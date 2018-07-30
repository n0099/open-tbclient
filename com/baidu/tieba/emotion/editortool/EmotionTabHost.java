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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Qg;
    private int Qh;
    private int aOY;
    private CustomMessageListener acq;
    private int azI;
    private EmotionTabContentView cRc;
    private EmotionTabWidgetView cRd;
    private View cRe;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRg;
    private String cRh;
    private boolean cRi;
    private boolean cRj;
    private int cRk;
    private CustomMessageListener cRl;

    public EmotionTabHost(Context context) {
        super(context);
        this.cRf = new ArrayList<>();
        this.cRg = new ArrayList<>();
        this.aOY = -1;
        this.cRh = null;
        this.azI = -1;
        this.cRi = true;
        this.cRj = true;
        this.cRk = 0;
        this.Qh = 0;
        this.acq = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cRl = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cRf.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cRf.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cRf.get(i2)).HI() != EmotionGroupType.USER_COLLECT) {
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
        this.cRf = new ArrayList<>();
        this.cRg = new ArrayList<>();
        this.aOY = -1;
        this.cRh = null;
        this.azI = -1;
        this.cRi = true;
        this.cRj = true;
        this.cRk = 0;
        this.Qh = 0;
        this.acq = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cRl = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cRf.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cRf.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cRf.get(i2)).HI() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_host, (ViewGroup) this, true);
        this.cRc = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cRd = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cRe = findViewById(d.g.emotion_tab_widget_div_line);
        this.cRd.setOnTabSelectedListener(this);
        this.cRc.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.azI = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.azI);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cRd != null) {
            this.cRd.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cRj = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aob() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aol().aon().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.HI() != EmotionGroupType.BIG_EMOTION || this.cRi) {
                if (next.HI() != EmotionGroupType.USER_COLLECT || this.cRj) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cRf = e.aol().aon();
        if (!this.cRi || !this.cRj) {
            this.cRg = aob();
            if (!this.cRj && this.cRf != null) {
                this.cRf = new ArrayList<>(e.aol().aon());
                int i = 0;
                while (true) {
                    if (i < this.cRf.size()) {
                        if (this.cRf.get(i).HI() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cRf.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cRg = e.aol().aon();
        }
        if ((this.cRf == null || this.cRf.size() <= 0) && this.cRk < 3) {
            this.cRk++;
            e.aol().aom();
            return;
        }
        this.cRd.setDatas(this.cRf);
        int size = this.cRf.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cRf.get(i3);
            if (this.cRh != null && this.cRh.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acq);
        MessageManager.getInstance().registerListener(this.cRl);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.acq);
        MessageManager.getInstance().unRegisterListener(this.cRl);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.azI) {
            this.azI = skinType;
            onChangeSkinType(this.azI);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cRd.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cRg.size() && i != this.aOY) {
            this.cRc.i(this.cRg, i);
            this.cRd.setCurrentTab(i);
            this.aOY = i;
            this.cRh = this.cRg.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aOY = -1;
        this.cRf.clear();
        this.cRc.reset();
        this.cRd.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cRi = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eZ(int i) {
        if (i >= 0 && i < this.cRf.size() && i != this.aOY && this.cRc != null) {
            this.cRc.jA(i);
            this.aOY = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cRd.onChangeSkinType(i);
        this.cRc.onChangeSkinType(i);
        am.e(this.cRe, d.C0140d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jB(int i) {
        if (this.cRd != null && i != this.aOY) {
            this.cRd.setCurrentTab(i);
            this.aOY = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cRg.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.HH()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cRc.i(arrayList, 0);
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
        this.Qg = editorTools;
        this.cRc.setOnDataSelected(editorTools);
        this.cRd.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oF() {
        if (this.cRd != null) {
            int size = this.cRf.size();
            for (int i = 0; i < size; i++) {
                this.cRd.setTabWidgetVisibility(i, this.cRi);
            }
            this.cRd.setTabWidgetBigEmontionVisibility(this.cRi);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
