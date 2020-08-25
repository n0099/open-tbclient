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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements n, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools aay;
    private int aaz;
    private int aiB;
    private CustomMessageListener dUB;
    private EmotionTabContentView hsD;
    private EmotionTabWidgetView hsE;
    private View hsF;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hsG;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hsH;
    private String hsI;
    private boolean hsJ;
    private boolean hsK;
    private int hsL;
    private CustomMessageListener hsM;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.hsG = new ArrayList<>();
        this.hsH = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hsI = null;
        this.aiB = -1;
        this.hsJ = true;
        this.hsK = true;
        this.hsL = 0;
        this.aaz = 0;
        this.dUB = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hsM = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hsG.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hsG.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hsG.get(i2)).brM() != EmotionGroupType.USER_COLLECT) {
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
        this.hsG = new ArrayList<>();
        this.hsH = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hsI = null;
        this.aiB = -1;
        this.hsJ = true;
        this.hsK = true;
        this.hsL = 0;
        this.aaz = 0;
        this.dUB = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hsM = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hsG.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hsG.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hsG.get(i2)).brM() != EmotionGroupType.USER_COLLECT) {
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
        this.hsD = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.hsE = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.hsF = findViewById(R.id.emotion_tab_widget_div_line);
        this.hsE.setOnTabSelectedListener(this);
        this.hsD.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aiB = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aiB);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.hsE != null) {
            this.hsE.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.hsK = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cee() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.ceo().ceq().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.brM() != EmotionGroupType.BIG_EMOTION || this.hsJ) {
                if (next.brM() != EmotionGroupType.USER_COLLECT || this.hsK) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.hsG = e.ceo().ceq();
        if (!this.hsJ || !this.hsK) {
            this.hsH = cee();
            if (!this.hsK && this.hsG != null) {
                this.hsG = new ArrayList<>(e.ceo().ceq());
                int i = 0;
                while (true) {
                    if (i < this.hsG.size()) {
                        if (this.hsG.get(i).brM() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.hsG.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.hsH = e.ceo().ceq();
        }
        if ((this.hsG == null || this.hsG.size() <= 0) && this.hsL < 3) {
            this.hsL++;
            e.ceo().cep();
            return;
        }
        this.hsE.setDatas(this.hsG);
        int size = this.hsG.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hsG.get(i3);
            if (this.hsI != null && this.hsI.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dUB);
        MessageManager.getInstance().registerListener(this.hsM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dUB);
        MessageManager.getInstance().unRegisterListener(this.hsM);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiB) {
            this.aiB = skinType;
            onChangeSkinType(this.aiB);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hsE.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.hsH.size() && i != this.mCurrentIndex) {
            this.hsD.g(this.hsH, i);
            this.hsE.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.hsI = this.hsH.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hsG.clear();
        this.hsD.reset();
        this.hsE.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.hsJ = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void qo(int i) {
        if (i >= 0 && i < this.hsG.size() && i != this.mCurrentIndex && this.hsD != null) {
            this.hsD.vK(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.hsE.onChangeSkinType(i);
        this.hsD.onChangeSkinType(i);
        ap.setBackgroundColor(this.hsF, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void vL(int i) {
        if (this.hsE != null && i != this.mCurrentIndex) {
            this.hsE.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new aq("c12612").ai("obj_locate", 7));
                    return;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hsH.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.brL()) {
                                    arrayList.add(next);
                                }
                            }
                            this.hsD.g(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
        this.hsD.setOnDataSelected(editorTools);
        this.hsE.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.hsE != null) {
            int size = this.hsG.size();
            for (int i = 0; i < size; i++) {
                this.hsE.setTabWidgetVisibility(i, this.hsJ);
            }
            this.hsE.setTabWidgetBigEmontionVisibility(this.hsJ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
