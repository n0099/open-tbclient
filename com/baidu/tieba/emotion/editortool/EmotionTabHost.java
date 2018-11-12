package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Ta;
    private int Tb;
    private int aIf;
    private CustomMessageListener akD;
    private EmotionTabContentView dgn;
    private EmotionTabWidgetView dgo;
    private View dgp;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dgq;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dgr;
    private String dgs;
    private boolean dgt;
    private boolean dgu;
    private int dgv;
    private CustomMessageListener dgw;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.dgq = new ArrayList<>();
        this.dgr = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dgs = null;
        this.aIf = -1;
        this.dgt = true;
        this.dgu = true;
        this.dgv = 0;
        this.Tb = 0;
        this.akD = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dgw = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dgq.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dgq.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dgq.get(i2)).Li() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                EmotionTabHost.this.setCurrentEmotionGroup(i2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgq = new ArrayList<>();
        this.dgr = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dgs = null;
        this.aIf = -1;
        this.dgt = true;
        this.dgu = true;
        this.dgv = 0;
        this.Tb = 0;
        this.akD = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dgw = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dgq.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dgq.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dgq.get(i2)).Li() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                EmotionTabHost.this.setCurrentEmotionGroup(i2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(e.h.emotion_tab_host, (ViewGroup) this, true);
        this.dgn = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.dgo = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.dgp = findViewById(e.g.emotion_tab_widget_div_line);
        this.dgo.setOnTabSelectedListener(this);
        this.dgn.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aIf = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aIf);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dgo != null) {
            this.dgo.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dgu = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> asM() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.asW().asY().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Li() != EmotionGroupType.BIG_EMOTION || this.dgt) {
                if (next.Li() != EmotionGroupType.USER_COLLECT || this.dgu) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dgq = e.asW().asY();
        if (!this.dgt || !this.dgu) {
            this.dgr = asM();
            if (!this.dgu && this.dgq != null) {
                this.dgq = new ArrayList<>(e.asW().asY());
                int i = 0;
                while (true) {
                    if (i < this.dgq.size()) {
                        if (this.dgq.get(i).Li() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dgq.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dgr = e.asW().asY();
        }
        if ((this.dgq == null || this.dgq.size() <= 0) && this.dgv < 3) {
            this.dgv++;
            e.asW().asX();
            return;
        }
        this.dgo.setDatas(this.dgq);
        int size = this.dgq.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dgq.get(i3);
            if (this.dgs != null && this.dgs.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.akD);
        MessageManager.getInstance().registerListener(this.dgw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.akD);
        MessageManager.getInstance().unRegisterListener(this.dgw);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aIf) {
            this.aIf = skinType;
            onChangeSkinType(this.aIf);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dgo.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dgr.size() && i != this.mCurrentIndex) {
            this.dgn.j(this.dgr, i);
            this.dgo.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.dgs = this.dgr.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dgq.clear();
        this.dgn.reset();
        this.dgo.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dgt = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fH(int i) {
        if (i >= 0 && i < this.dgq.size() && i != this.mCurrentIndex && this.dgn != null) {
            this.dgn.kO(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.dgo.onChangeSkinType(i);
        this.dgn.onChangeSkinType(i);
        al.e(this.dgp, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void kP(int i) {
        if (this.dgo != null && i != this.mCurrentIndex) {
            this.dgo.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 34:
                    if (aVar.data instanceof Integer) {
                        setFrom(((Integer) aVar.data).intValue());
                        return;
                    }
                    return;
                case 35:
                    if (aVar.data instanceof Boolean) {
                        boolean booleanValue = ((Boolean) aVar.data).booleanValue();
                        setShowBigEmotion(booleanValue);
                        if (!booleanValue) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dgr.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Lh()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dgn.j(arrayList, 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
        this.dgn.setOnDataSelected(editorTools);
        this.dgo.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.dgo != null) {
            int size = this.dgq.size();
            for (int i = 0; i < size; i++) {
                this.dgo.setTabWidgetVisibility(i, this.dgt);
            }
            this.dgo.setTabWidgetBigEmontionVisibility(this.dgt);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
