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
import com.baidu.tbadk.core.util.ar;
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
    private EditorTools acn;
    private int aco;
    private int aku;
    private CustomMessageListener eCA;
    private EmotionTabContentView isO;
    private EmotionTabWidgetView isP;
    private View isQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> isR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> isS;
    private String isT;
    private boolean isU;
    private boolean isV;
    private int isW;
    private CustomMessageListener isX;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.isR = new ArrayList<>();
        this.isS = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.isT = null;
        this.aku = -1;
        this.isU = true;
        this.isV = true;
        this.isW = 0;
        this.aco = 0;
        this.eCA = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.isX = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.isR.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.isR.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.isR.get(i2)).bCH() != EmotionGroupType.USER_COLLECT) {
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
        this.isR = new ArrayList<>();
        this.isS = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.isT = null;
        this.aku = -1;
        this.isU = true;
        this.isV = true;
        this.isW = 0;
        this.aco = 0;
        this.eCA = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.isX = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.isR.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.isR.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.isR.get(i2)).bCH() != EmotionGroupType.USER_COLLECT) {
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
        this.isO = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.isP = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.isQ = findViewById(R.id.emotion_tab_widget_div_line);
        this.isP.setOnTabSelectedListener(this);
        this.isO.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aku = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aku);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.isP != null) {
            this.isP.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.isV = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cup() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cuz().cuB().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bCH() != EmotionGroupType.BIG_EMOTION || this.isU) {
                if (next.bCH() != EmotionGroupType.USER_COLLECT || this.isV) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.isR = e.cuz().cuB();
        if (!this.isU || !this.isV) {
            this.isS = cup();
            if (!this.isV && this.isR != null) {
                this.isR = new ArrayList<>(e.cuz().cuB());
                int i = 0;
                while (true) {
                    if (i < this.isR.size()) {
                        if (this.isR.get(i).bCH() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.isR.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.isS = e.cuz().cuB();
        }
        if ((this.isR == null || this.isR.size() <= 0) && this.isW < 3) {
            this.isW++;
            e.cuz().cuA();
            return;
        }
        this.isP.setDatas(this.isR);
        int size = this.isR.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.isR.get(i3);
            if (this.isT != null && this.isT.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eCA);
        MessageManager.getInstance().registerListener(this.isX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eCA);
        MessageManager.getInstance().unRegisterListener(this.isX);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aku) {
            this.aku = skinType;
            onChangeSkinType(this.aku);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.isP.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.isS.size() && i != this.mCurrentIndex) {
            this.isO.g(this.isS, i);
            this.isP.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.isT = this.isS.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.isR.clear();
        this.isO.reset();
        this.isP.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.isU = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void sx(int i) {
        if (i >= 0 && i < this.isR.size() && i != this.mCurrentIndex && this.isO != null) {
            this.isO.yy(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.isP.onChangeSkinType(i);
        this.isO.onChangeSkinType(i);
        ap.setBackgroundColor(this.isQ, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void yz(int i) {
        if (this.isP != null && i != this.mCurrentIndex) {
            this.isP.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ar("c12612").al("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.isS.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bCG()) {
                                    arrayList.add(next);
                                }
                            }
                            this.isO.g(arrayList, 0);
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
        this.acn = editorTools;
        this.isO.setOnDataSelected(editorTools);
        this.isP.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        if (this.isP != null) {
            int size = this.isR.size();
            for (int i = 0; i < size; i++) {
                this.isP.setTabWidgetVisibility(i, this.isU);
            }
            this.isP.setTabWidgetBigEmontionVisibility(this.isU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
