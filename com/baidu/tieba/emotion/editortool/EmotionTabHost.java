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
    private CustomMessageListener cLH;
    private EmotionTabContentView fSR;
    private EmotionTabWidgetView fSS;
    private View fST;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSU;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSV;
    private String fSW;
    private boolean fSX;
    private boolean fSY;
    private int fSZ;
    private CustomMessageListener fTa;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.fSU = new ArrayList<>();
        this.fSV = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fSW = null;
        this.Ni = -1;
        this.fSX = true;
        this.fSY = true;
        this.fSZ = 0;
        this.FP = 0;
        this.cLH = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fTa = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fSU.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fSU.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fSU.get(i2)).aOJ() != EmotionGroupType.USER_COLLECT) {
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
        this.fSU = new ArrayList<>();
        this.fSV = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fSW = null;
        this.Ni = -1;
        this.fSX = true;
        this.fSY = true;
        this.fSZ = 0;
        this.FP = 0;
        this.cLH = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fTa = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fSU.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fSU.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fSU.get(i2)).aOJ() != EmotionGroupType.USER_COLLECT) {
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
        this.fSR = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.fSS = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.fST = findViewById(R.id.emotion_tab_widget_div_line);
        this.fSS.setOnTabSelectedListener(this);
        this.fSR.setOnEmotionSwitchedListener(this);
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
        if (this.fSS != null) {
            this.fSS.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.fSY = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bxq() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bxA().bxC().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aOJ() != EmotionGroupType.BIG_EMOTION || this.fSX) {
                if (next.aOJ() != EmotionGroupType.USER_COLLECT || this.fSY) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.fSU = e.bxA().bxC();
        if (!this.fSX || !this.fSY) {
            this.fSV = bxq();
            if (!this.fSY && this.fSU != null) {
                this.fSU = new ArrayList<>(e.bxA().bxC());
                int i = 0;
                while (true) {
                    if (i < this.fSU.size()) {
                        if (this.fSU.get(i).aOJ() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.fSU.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.fSV = e.bxA().bxC();
        }
        if ((this.fSU == null || this.fSU.size() <= 0) && this.fSZ < 3) {
            this.fSZ++;
            e.bxA().bxB();
            return;
        }
        this.fSS.setDatas(this.fSU);
        int size = this.fSU.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSU.get(i3);
            if (this.fSW != null && this.fSW.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLH);
        MessageManager.getInstance().registerListener(this.fTa);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cLH);
        MessageManager.getInstance().unRegisterListener(this.fTa);
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
        this.fSS.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.fSV.size() && i != this.mCurrentIndex) {
            this.fSR.f(this.fSV, i);
            this.fSS.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.fSW = this.fSV.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fSU.clear();
        this.fSR.reset();
        this.fSS.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.fSX = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mA(int i) {
        if (i >= 0 && i < this.fSU.size() && i != this.mCurrentIndex && this.fSR != null) {
            this.fSR.rC(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.fSS.onChangeSkinType(i);
        this.fSR.onChangeSkinType(i);
        am.setBackgroundColor(this.fST, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rD(int i) {
        if (this.fSS != null && i != this.mCurrentIndex) {
            this.fSS.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fSV.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aOI()) {
                                    arrayList.add(next);
                                }
                            }
                            this.fSR.f(arrayList, 0);
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
        this.fSR.setOnDataSelected(editorTools);
        this.fSS.setOnDataSelected(editorTools);
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
        if (this.fSS != null) {
            int size = this.fSU.size();
            for (int i = 0; i < size; i++) {
                this.fSS.setTabWidgetVisibility(i, this.fSX);
            }
            this.fSS.setTabWidgetBigEmontionVisibility(this.fSX);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
