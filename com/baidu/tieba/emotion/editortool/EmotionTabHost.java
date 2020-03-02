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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements m, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools FO;
    private int FP;
    private int Ni;
    private CustomMessageListener cLG;
    private EmotionTabContentView fSE;
    private EmotionTabWidgetView fSF;
    private View fSG;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSH;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSI;
    private String fSJ;
    private boolean fSK;
    private boolean fSL;
    private int fSM;
    private CustomMessageListener fSN;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.fSH = new ArrayList<>();
        this.fSI = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fSJ = null;
        this.Ni = -1;
        this.fSK = true;
        this.fSL = true;
        this.fSM = 0;
        this.FP = 0;
        this.cLG = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSN = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fSH.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fSH.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fSH.get(i2)).aOI() != EmotionGroupType.USER_COLLECT) {
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
        this.fSH = new ArrayList<>();
        this.fSI = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fSJ = null;
        this.Ni = -1;
        this.fSK = true;
        this.fSL = true;
        this.fSM = 0;
        this.FP = 0;
        this.cLG = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.fSN = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fSH.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fSH.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fSH.get(i2)).aOI() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.fSE = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.fSF = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.fSG = findViewById(R.id.emotion_tab_widget_div_line);
        this.fSF.setOnTabSelectedListener(this);
        this.fSE.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.Ni = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.Ni);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.fSF != null) {
            this.fSF.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.fSL = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bxp() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bxz().bxB().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aOI() != EmotionGroupType.BIG_EMOTION || this.fSK) {
                if (next.aOI() != EmotionGroupType.USER_COLLECT || this.fSL) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.fSH = e.bxz().bxB();
        if (!this.fSK || !this.fSL) {
            this.fSI = bxp();
            if (!this.fSL && this.fSH != null) {
                this.fSH = new ArrayList<>(e.bxz().bxB());
                int i = 0;
                while (true) {
                    if (i < this.fSH.size()) {
                        if (this.fSH.get(i).aOI() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.fSH.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.fSI = e.bxz().bxB();
        }
        if ((this.fSH == null || this.fSH.size() <= 0) && this.fSM < 3) {
            this.fSM++;
            e.bxz().bxA();
            return;
        }
        this.fSF.setDatas(this.fSH);
        int size = this.fSH.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSH.get(i3);
            if (this.fSJ != null && this.fSJ.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLG);
        MessageManager.getInstance().registerListener(this.fSN);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cLG);
        MessageManager.getInstance().unRegisterListener(this.fSN);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.Ni) {
            this.Ni = skinType;
            onChangeSkinType(this.Ni);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fSF.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.fSI.size() && i != this.mCurrentIndex) {
            this.fSE.f(this.fSI, i);
            this.fSF.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.fSJ = this.fSI.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fSH.clear();
        this.fSE.reset();
        this.fSF.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.fSK = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mA(int i) {
        if (i >= 0 && i < this.fSH.size() && i != this.mCurrentIndex && this.fSE != null) {
            this.fSE.rC(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.fSF.onChangeSkinType(i);
        this.fSE.onChangeSkinType(i);
        am.setBackgroundColor(this.fSG, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rD(int i) {
        if (this.fSF != null && i != this.mCurrentIndex) {
            this.fSF.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fSI.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aOH()) {
                                    arrayList.add(next);
                                }
                            }
                            this.fSE.f(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.fSE.setOnDataSelected(editorTools);
        this.fSF.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.fSF != null) {
            int size = this.fSH.size();
            for (int i = 0; i < size; i++) {
                this.fSF.setTabWidgetVisibility(i, this.fSK);
            }
            this.fSF.setTabWidgetBigEmontionVisibility(this.fSK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
