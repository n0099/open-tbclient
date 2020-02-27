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
    private CustomMessageListener cLF;
    private EmotionTabContentView fSC;
    private EmotionTabWidgetView fSD;
    private View fSE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSF;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSG;
    private String fSH;
    private boolean fSI;
    private boolean fSJ;
    private int fSK;
    private CustomMessageListener fSL;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.fSF = new ArrayList<>();
        this.fSG = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fSH = null;
        this.Ni = -1;
        this.fSI = true;
        this.fSJ = true;
        this.fSK = 0;
        this.FP = 0;
        this.cLF = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fSL = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fSF.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fSF.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fSF.get(i2)).aOG() != EmotionGroupType.USER_COLLECT) {
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
        this.fSF = new ArrayList<>();
        this.fSG = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fSH = null;
        this.Ni = -1;
        this.fSI = true;
        this.fSJ = true;
        this.fSK = 0;
        this.FP = 0;
        this.cLF = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fSL = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fSF.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fSF.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fSF.get(i2)).aOG() != EmotionGroupType.USER_COLLECT) {
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
        this.fSC = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.fSD = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.fSE = findViewById(R.id.emotion_tab_widget_div_line);
        this.fSD.setOnTabSelectedListener(this);
        this.fSC.setOnEmotionSwitchedListener(this);
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
        if (this.fSD != null) {
            this.fSD.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.fSJ = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bxn() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bxx().bxz().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aOG() != EmotionGroupType.BIG_EMOTION || this.fSI) {
                if (next.aOG() != EmotionGroupType.USER_COLLECT || this.fSJ) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.fSF = e.bxx().bxz();
        if (!this.fSI || !this.fSJ) {
            this.fSG = bxn();
            if (!this.fSJ && this.fSF != null) {
                this.fSF = new ArrayList<>(e.bxx().bxz());
                int i = 0;
                while (true) {
                    if (i < this.fSF.size()) {
                        if (this.fSF.get(i).aOG() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.fSF.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.fSG = e.bxx().bxz();
        }
        if ((this.fSF == null || this.fSF.size() <= 0) && this.fSK < 3) {
            this.fSK++;
            e.bxx().bxy();
            return;
        }
        this.fSD.setDatas(this.fSF);
        int size = this.fSF.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSF.get(i3);
            if (this.fSH != null && this.fSH.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLF);
        MessageManager.getInstance().registerListener(this.fSL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cLF);
        MessageManager.getInstance().unRegisterListener(this.fSL);
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
        this.fSD.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.fSG.size() && i != this.mCurrentIndex) {
            this.fSC.f(this.fSG, i);
            this.fSD.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.fSH = this.fSG.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fSF.clear();
        this.fSC.reset();
        this.fSD.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.fSI = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mA(int i) {
        if (i >= 0 && i < this.fSF.size() && i != this.mCurrentIndex && this.fSC != null) {
            this.fSC.rC(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.fSD.onChangeSkinType(i);
        this.fSC.onChangeSkinType(i);
        am.setBackgroundColor(this.fSE, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rD(int i) {
        if (this.fSD != null && i != this.mCurrentIndex) {
            this.fSD.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fSG.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aOF()) {
                                    arrayList.add(next);
                                }
                            }
                            this.fSC.f(arrayList, 0);
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
        this.fSC.setOnDataSelected(editorTools);
        this.fSD.setOnDataSelected(editorTools);
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
        if (this.fSD != null) {
            int size = this.fSF.size();
            for (int i = 0; i < size; i++) {
                this.fSD.setTabWidgetVisibility(i, this.fSI);
            }
            this.fSD.setTabWidgetBigEmontionVisibility(this.fSI);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
