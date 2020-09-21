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
    private EditorTools aaS;
    private int aaT;
    private int aiX;
    private CustomMessageListener dWP;
    private EmotionTabContentView hzO;
    private EmotionTabWidgetView hzP;
    private View hzQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hzR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hzS;
    private String hzT;
    private boolean hzU;
    private boolean hzV;
    private int hzW;
    private CustomMessageListener hzX;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.hzR = new ArrayList<>();
        this.hzS = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hzT = null;
        this.aiX = -1;
        this.hzU = true;
        this.hzV = true;
        this.hzW = 0;
        this.aaT = 0;
        this.dWP = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hzX = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hzR.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hzR.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hzR.get(i2)).bsP() != EmotionGroupType.USER_COLLECT) {
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
        this.hzR = new ArrayList<>();
        this.hzS = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hzT = null;
        this.aiX = -1;
        this.hzU = true;
        this.hzV = true;
        this.hzW = 0;
        this.aaT = 0;
        this.dWP = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hzX = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hzR.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hzR.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hzR.get(i2)).bsP() != EmotionGroupType.USER_COLLECT) {
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
        this.hzO = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.hzP = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.hzQ = findViewById(R.id.emotion_tab_widget_div_line);
        this.hzP.setOnTabSelectedListener(this);
        this.hzO.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aiX = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aiX);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.hzP != null) {
            this.hzP.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.hzV = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> chu() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.chE().chG().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bsP() != EmotionGroupType.BIG_EMOTION || this.hzU) {
                if (next.bsP() != EmotionGroupType.USER_COLLECT || this.hzV) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.hzR = e.chE().chG();
        if (!this.hzU || !this.hzV) {
            this.hzS = chu();
            if (!this.hzV && this.hzR != null) {
                this.hzR = new ArrayList<>(e.chE().chG());
                int i = 0;
                while (true) {
                    if (i < this.hzR.size()) {
                        if (this.hzR.get(i).bsP() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.hzR.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.hzS = e.chE().chG();
        }
        if ((this.hzR == null || this.hzR.size() <= 0) && this.hzW < 3) {
            this.hzW++;
            e.chE().chF();
            return;
        }
        this.hzP.setDatas(this.hzR);
        int size = this.hzR.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hzR.get(i3);
            if (this.hzT != null && this.hzT.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dWP);
        MessageManager.getInstance().registerListener(this.hzX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dWP);
        MessageManager.getInstance().unRegisterListener(this.hzX);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiX) {
            this.aiX = skinType;
            onChangeSkinType(this.aiX);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hzP.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.hzS.size() && i != this.mCurrentIndex) {
            this.hzO.g(this.hzS, i);
            this.hzP.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.hzT = this.hzS.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hzR.clear();
        this.hzO.reset();
        this.hzP.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.hzU = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void qF(int i) {
        if (i >= 0 && i < this.hzR.size() && i != this.mCurrentIndex && this.hzO != null) {
            this.hzO.wj(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.hzP.onChangeSkinType(i);
        this.hzO.onChangeSkinType(i);
        ap.setBackgroundColor(this.hzQ, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void wk(int i) {
        if (this.hzP != null && i != this.mCurrentIndex) {
            this.hzP.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hzS.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bsO()) {
                                    arrayList.add(next);
                                }
                            }
                            this.hzO.g(arrayList, 0);
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
        this.aaS = editorTools;
        this.hzO.setOnDataSelected(editorTools);
        this.hzP.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.hzP != null) {
            int size = this.hzR.size();
            for (int i = 0; i < size; i++) {
                this.hzP.setTabWidgetVisibility(i, this.hzU);
            }
            this.hzP.setTabWidgetBigEmontionVisibility(this.hzU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
