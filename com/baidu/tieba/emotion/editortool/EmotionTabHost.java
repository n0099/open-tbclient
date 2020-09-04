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
    private EditorTools aaA;
    private int aaB;
    private int aiD;
    private CustomMessageListener dUF;
    private EmotionTabContentView hsJ;
    private EmotionTabWidgetView hsK;
    private View hsL;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hsM;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hsN;
    private String hsO;
    private boolean hsP;
    private boolean hsQ;
    private int hsR;
    private CustomMessageListener hsS;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.hsM = new ArrayList<>();
        this.hsN = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hsO = null;
        this.aiD = -1;
        this.hsP = true;
        this.hsQ = true;
        this.hsR = 0;
        this.aaB = 0;
        this.dUF = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hsS = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hsM.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hsM.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hsM.get(i2)).brN() != EmotionGroupType.USER_COLLECT) {
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
        this.hsM = new ArrayList<>();
        this.hsN = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hsO = null;
        this.aiD = -1;
        this.hsP = true;
        this.hsQ = true;
        this.hsR = 0;
        this.aaB = 0;
        this.dUF = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hsS = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hsM.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hsM.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hsM.get(i2)).brN() != EmotionGroupType.USER_COLLECT) {
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
        this.hsJ = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.hsK = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.hsL = findViewById(R.id.emotion_tab_widget_div_line);
        this.hsK.setOnTabSelectedListener(this);
        this.hsJ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aiD = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aiD);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.hsK != null) {
            this.hsK.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.hsQ = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cef() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cep().cer().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.brN() != EmotionGroupType.BIG_EMOTION || this.hsP) {
                if (next.brN() != EmotionGroupType.USER_COLLECT || this.hsQ) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.hsM = e.cep().cer();
        if (!this.hsP || !this.hsQ) {
            this.hsN = cef();
            if (!this.hsQ && this.hsM != null) {
                this.hsM = new ArrayList<>(e.cep().cer());
                int i = 0;
                while (true) {
                    if (i < this.hsM.size()) {
                        if (this.hsM.get(i).brN() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.hsM.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.hsN = e.cep().cer();
        }
        if ((this.hsM == null || this.hsM.size() <= 0) && this.hsR < 3) {
            this.hsR++;
            e.cep().ceq();
            return;
        }
        this.hsK.setDatas(this.hsM);
        int size = this.hsM.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hsM.get(i3);
            if (this.hsO != null && this.hsO.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dUF);
        MessageManager.getInstance().registerListener(this.hsS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dUF);
        MessageManager.getInstance().unRegisterListener(this.hsS);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiD) {
            this.aiD = skinType;
            onChangeSkinType(this.aiD);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hsK.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.hsN.size() && i != this.mCurrentIndex) {
            this.hsJ.g(this.hsN, i);
            this.hsK.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.hsO = this.hsN.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hsM.clear();
        this.hsJ.reset();
        this.hsK.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.hsP = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void qo(int i) {
        if (i >= 0 && i < this.hsM.size() && i != this.mCurrentIndex && this.hsJ != null) {
            this.hsJ.vK(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.hsK.onChangeSkinType(i);
        this.hsJ.onChangeSkinType(i);
        ap.setBackgroundColor(this.hsL, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void vL(int i) {
        if (this.hsK != null && i != this.mCurrentIndex) {
            this.hsK.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hsN.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.brM()) {
                                    arrayList.add(next);
                                }
                            }
                            this.hsJ.g(arrayList, 0);
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
        this.aaA = editorTools;
        this.hsJ.setOnDataSelected(editorTools);
        this.hsK.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaB;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.hsK != null) {
            int size = this.hsM.size();
            for (int i = 0; i < size; i++) {
                this.hsK.setTabWidgetVisibility(i, this.hsP);
            }
            this.hsK.setTabWidgetBigEmontionVisibility(this.hsP);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
