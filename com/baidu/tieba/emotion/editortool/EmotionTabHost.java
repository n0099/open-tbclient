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
    private EmotionTabContentView isQ;
    private EmotionTabWidgetView isR;
    private View isS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> isT;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> isU;
    private String isV;
    private boolean isW;
    private boolean isX;
    private int isY;
    private CustomMessageListener isZ;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.isT = new ArrayList<>();
        this.isU = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.isV = null;
        this.aku = -1;
        this.isW = true;
        this.isX = true;
        this.isY = 0;
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
        this.isZ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.isT.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.isT.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.isT.get(i2)).bCH() != EmotionGroupType.USER_COLLECT) {
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
        this.isT = new ArrayList<>();
        this.isU = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.isV = null;
        this.aku = -1;
        this.isW = true;
        this.isX = true;
        this.isY = 0;
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
        this.isZ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.isT.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.isT.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.isT.get(i2)).bCH() != EmotionGroupType.USER_COLLECT) {
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
        this.isQ = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.isR = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.isS = findViewById(R.id.emotion_tab_widget_div_line);
        this.isR.setOnTabSelectedListener(this);
        this.isQ.setOnEmotionSwitchedListener(this);
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
        if (this.isR != null) {
            this.isR.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.isX = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cuq() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cuA().cuC().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bCH() != EmotionGroupType.BIG_EMOTION || this.isW) {
                if (next.bCH() != EmotionGroupType.USER_COLLECT || this.isX) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.isT = e.cuA().cuC();
        if (!this.isW || !this.isX) {
            this.isU = cuq();
            if (!this.isX && this.isT != null) {
                this.isT = new ArrayList<>(e.cuA().cuC());
                int i = 0;
                while (true) {
                    if (i < this.isT.size()) {
                        if (this.isT.get(i).bCH() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.isT.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.isU = e.cuA().cuC();
        }
        if ((this.isT == null || this.isT.size() <= 0) && this.isY < 3) {
            this.isY++;
            e.cuA().cuB();
            return;
        }
        this.isR.setDatas(this.isT);
        int size = this.isT.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.isT.get(i3);
            if (this.isV != null && this.isV.equals(cVar.getGroupId())) {
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
        MessageManager.getInstance().registerListener(this.isZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eCA);
        MessageManager.getInstance().unRegisterListener(this.isZ);
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
        this.isR.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.isU.size() && i != this.mCurrentIndex) {
            this.isQ.g(this.isU, i);
            this.isR.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.isV = this.isU.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.isT.clear();
        this.isQ.reset();
        this.isR.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.isW = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void sx(int i) {
        if (i >= 0 && i < this.isT.size() && i != this.mCurrentIndex && this.isQ != null) {
            this.isQ.yy(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.isR.onChangeSkinType(i);
        this.isQ.onChangeSkinType(i);
        ap.setBackgroundColor(this.isS, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void yz(int i) {
        if (this.isR != null && i != this.mCurrentIndex) {
            this.isR.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.isU.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bCG()) {
                                    arrayList.add(next);
                                }
                            }
                            this.isQ.g(arrayList, 0);
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
        this.isQ.setOnDataSelected(editorTools);
        this.isR.setOnDataSelected(editorTools);
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
        if (this.isR != null) {
            int size = this.isT.size();
            for (int i = 0; i < size; i++) {
                this.isR.setTabWidgetVisibility(i, this.isW);
            }
            this.isR.setTabWidgetBigEmontionVisibility(this.isW);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
