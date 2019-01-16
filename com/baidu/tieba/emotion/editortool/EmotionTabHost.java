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
    private EditorTools Tj;
    private int Tk;
    private int aMj;
    private CustomMessageListener aoH;
    private View dqA;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dqB;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dqC;
    private String dqD;
    private boolean dqE;
    private boolean dqF;
    private int dqG;
    private CustomMessageListener dqH;
    private EmotionTabContentView dqy;
    private EmotionTabWidgetView dqz;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.dqB = new ArrayList<>();
        this.dqC = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dqD = null;
        this.aMj = -1;
        this.dqE = true;
        this.dqF = true;
        this.dqG = 0;
        this.Tk = 0;
        this.aoH = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.dqH = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dqB.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dqB.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dqB.get(i2)).ME() != EmotionGroupType.USER_COLLECT) {
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
        this.dqB = new ArrayList<>();
        this.dqC = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dqD = null;
        this.aMj = -1;
        this.dqE = true;
        this.dqF = true;
        this.dqG = 0;
        this.Tk = 0;
        this.aoH = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.dqH = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dqB.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dqB.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dqB.get(i2)).ME() != EmotionGroupType.USER_COLLECT) {
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
        this.dqy = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.dqz = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.dqA = findViewById(e.g.emotion_tab_widget_div_line);
        this.dqz.setOnTabSelectedListener(this);
        this.dqy.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aMj = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aMj);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dqz != null) {
            this.dqz.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dqF = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> avL() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.avV().avX().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ME() != EmotionGroupType.BIG_EMOTION || this.dqE) {
                if (next.ME() != EmotionGroupType.USER_COLLECT || this.dqF) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dqB = e.avV().avX();
        if (!this.dqE || !this.dqF) {
            this.dqC = avL();
            if (!this.dqF && this.dqB != null) {
                this.dqB = new ArrayList<>(e.avV().avX());
                int i = 0;
                while (true) {
                    if (i < this.dqB.size()) {
                        if (this.dqB.get(i).ME() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dqB.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dqC = e.avV().avX();
        }
        if ((this.dqB == null || this.dqB.size() <= 0) && this.dqG < 3) {
            this.dqG++;
            e.avV().avW();
            return;
        }
        this.dqz.setDatas(this.dqB);
        int size = this.dqB.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dqB.get(i3);
            if (this.dqD != null && this.dqD.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aoH);
        MessageManager.getInstance().registerListener(this.dqH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aoH);
        MessageManager.getInstance().unRegisterListener(this.dqH);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aMj) {
            this.aMj = skinType;
            onChangeSkinType(this.aMj);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dqz.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dqC.size() && i != this.mCurrentIndex) {
            this.dqy.j(this.dqC, i);
            this.dqz.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.dqD = this.dqC.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dqB.clear();
        this.dqy.reset();
        this.dqz.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dqE = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fW(int i) {
        if (i >= 0 && i < this.dqB.size() && i != this.mCurrentIndex && this.dqy != null) {
            this.dqy.ls(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.dqz.onChangeSkinType(i);
        this.dqy.onChangeSkinType(i);
        al.e(this.dqA, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void lt(int i) {
        if (this.dqz != null && i != this.mCurrentIndex) {
            this.dqz.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqC.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.MD()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dqy.j(arrayList, 0);
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
        this.Tj = editorTools;
        this.dqy.setOnDataSelected(editorTools);
        this.dqz.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        if (this.dqz != null) {
            int size = this.dqB.size();
            for (int i = 0; i < size; i++) {
                this.dqz.setTabWidgetVisibility(i, this.dqE);
            }
            this.dqz.setTabWidgetBigEmontionVisibility(this.dqE);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
