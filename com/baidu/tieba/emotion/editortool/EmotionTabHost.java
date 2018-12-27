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
    private int aLH;
    private CustomMessageListener aof;
    private EmotionTabContentView dpM;
    private EmotionTabWidgetView dpN;
    private View dpO;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dpP;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dpQ;
    private String dpR;
    private boolean dpS;
    private boolean dpT;
    private int dpU;
    private CustomMessageListener dpV;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.dpP = new ArrayList<>();
        this.dpQ = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dpR = null;
        this.aLH = -1;
        this.dpS = true;
        this.dpT = true;
        this.dpU = 0;
        this.Tb = 0;
        this.aof = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.dpV = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dpP.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dpP.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dpP.get(i2)).Mn() != EmotionGroupType.USER_COLLECT) {
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
        this.dpP = new ArrayList<>();
        this.dpQ = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dpR = null;
        this.aLH = -1;
        this.dpS = true;
        this.dpT = true;
        this.dpU = 0;
        this.Tb = 0;
        this.aof = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.dpV = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dpP.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dpP.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dpP.get(i2)).Mn() != EmotionGroupType.USER_COLLECT) {
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
        this.dpM = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.dpN = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.dpO = findViewById(e.g.emotion_tab_widget_div_line);
        this.dpN.setOnTabSelectedListener(this);
        this.dpM.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aLH = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aLH);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dpN != null) {
            this.dpN.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dpT = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> avn() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.avx().avz().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Mn() != EmotionGroupType.BIG_EMOTION || this.dpS) {
                if (next.Mn() != EmotionGroupType.USER_COLLECT || this.dpT) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dpP = e.avx().avz();
        if (!this.dpS || !this.dpT) {
            this.dpQ = avn();
            if (!this.dpT && this.dpP != null) {
                this.dpP = new ArrayList<>(e.avx().avz());
                int i = 0;
                while (true) {
                    if (i < this.dpP.size()) {
                        if (this.dpP.get(i).Mn() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dpP.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dpQ = e.avx().avz();
        }
        if ((this.dpP == null || this.dpP.size() <= 0) && this.dpU < 3) {
            this.dpU++;
            e.avx().avy();
            return;
        }
        this.dpN.setDatas(this.dpP);
        int size = this.dpP.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dpP.get(i3);
            if (this.dpR != null && this.dpR.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aof);
        MessageManager.getInstance().registerListener(this.dpV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aof);
        MessageManager.getInstance().unRegisterListener(this.dpV);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aLH) {
            this.aLH = skinType;
            onChangeSkinType(this.aLH);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dpN.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dpQ.size() && i != this.mCurrentIndex) {
            this.dpM.j(this.dpQ, i);
            this.dpN.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.dpR = this.dpQ.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dpP.clear();
        this.dpM.reset();
        this.dpN.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dpS = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fW(int i) {
        if (i >= 0 && i < this.dpP.size() && i != this.mCurrentIndex && this.dpM != null) {
            this.dpM.lr(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.dpN.onChangeSkinType(i);
        this.dpM.onChangeSkinType(i);
        al.e(this.dpO, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void ls(int i) {
        if (this.dpN != null && i != this.mCurrentIndex) {
            this.dpN.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dpQ.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Mm()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dpM.j(arrayList, 0);
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
        this.dpM.setOnDataSelected(editorTools);
        this.dpN.setOnDataSelected(editorTools);
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
    public void pN() {
        if (this.dpN != null) {
            int size = this.dpP.size();
            for (int i = 0; i < size; i++) {
                this.dpN.setTabWidgetVisibility(i, this.dpS);
            }
            this.dpN.setTabWidgetBigEmontionVisibility(this.dpS);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
