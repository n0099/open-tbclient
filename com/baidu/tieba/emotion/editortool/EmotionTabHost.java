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
    private int Nj;
    private CustomMessageListener cLS;
    private EmotionTabContentView fTA;
    private EmotionTabWidgetView fTB;
    private View fTC;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fTD;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fTE;
    private String fTF;
    private boolean fTG;
    private boolean fTH;
    private int fTI;
    private CustomMessageListener fTJ;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.fTD = new ArrayList<>();
        this.fTE = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fTF = null;
        this.Nj = -1;
        this.fTG = true;
        this.fTH = true;
        this.fTI = 0;
        this.FP = 0;
        this.cLS = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fTJ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fTD.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fTD.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fTD.get(i2)).aON() != EmotionGroupType.USER_COLLECT) {
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
        this.fTD = new ArrayList<>();
        this.fTE = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fTF = null;
        this.Nj = -1;
        this.fTG = true;
        this.fTH = true;
        this.fTI = 0;
        this.FP = 0;
        this.cLS = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fTJ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fTD.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fTD.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fTD.get(i2)).aON() != EmotionGroupType.USER_COLLECT) {
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
        this.fTA = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.fTB = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.fTC = findViewById(R.id.emotion_tab_widget_div_line);
        this.fTB.setOnTabSelectedListener(this);
        this.fTA.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.Nj = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.Nj);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.fTB != null) {
            this.fTB.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.fTH = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bxv() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bxF().bxH().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aON() != EmotionGroupType.BIG_EMOTION || this.fTG) {
                if (next.aON() != EmotionGroupType.USER_COLLECT || this.fTH) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.fTD = e.bxF().bxH();
        if (!this.fTG || !this.fTH) {
            this.fTE = bxv();
            if (!this.fTH && this.fTD != null) {
                this.fTD = new ArrayList<>(e.bxF().bxH());
                int i = 0;
                while (true) {
                    if (i < this.fTD.size()) {
                        if (this.fTD.get(i).aON() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.fTD.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.fTE = e.bxF().bxH();
        }
        if ((this.fTD == null || this.fTD.size() <= 0) && this.fTI < 3) {
            this.fTI++;
            e.bxF().bxG();
            return;
        }
        this.fTB.setDatas(this.fTD);
        int size = this.fTD.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fTD.get(i3);
            if (this.fTF != null && this.fTF.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLS);
        MessageManager.getInstance().registerListener(this.fTJ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cLS);
        MessageManager.getInstance().unRegisterListener(this.fTJ);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.Nj) {
            this.Nj = skinType;
            onChangeSkinType(this.Nj);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fTB.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.fTE.size() && i != this.mCurrentIndex) {
            this.fTA.f(this.fTE, i);
            this.fTB.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.fTF = this.fTE.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fTD.clear();
        this.fTA.reset();
        this.fTB.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.fTG = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mC(int i) {
        if (i >= 0 && i < this.fTD.size() && i != this.mCurrentIndex && this.fTA != null) {
            this.fTA.rE(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.fTB.onChangeSkinType(i);
        this.fTA.onChangeSkinType(i);
        am.setBackgroundColor(this.fTC, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rF(int i) {
        if (this.fTB != null && i != this.mCurrentIndex) {
            this.fTB.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fTE.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aOM()) {
                                    arrayList.add(next);
                                }
                            }
                            this.fTA.f(arrayList, 0);
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
        this.fTA.setOnDataSelected(editorTools);
        this.fTB.setOnDataSelected(editorTools);
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
        if (this.fTB != null) {
            int size = this.fTD.size();
            for (int i = 0; i < size; i++) {
                this.fTB.setTabWidgetVisibility(i, this.fTG);
            }
            this.fTB.setTabWidgetBigEmontionVisibility(this.fTG);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
