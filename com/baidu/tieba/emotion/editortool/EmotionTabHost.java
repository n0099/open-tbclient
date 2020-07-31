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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements m, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools ZS;
    private int ZT;
    private int aho;
    private CustomMessageListener dLt;
    private EmotionTabContentView hfK;
    private EmotionTabWidgetView hfL;
    private View hfM;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hfN;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hfO;
    private String hfP;
    private boolean hfQ;
    private boolean hfR;
    private int hfS;
    private CustomMessageListener hfT;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.hfN = new ArrayList<>();
        this.hfO = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hfP = null;
        this.aho = -1;
        this.hfQ = true;
        this.hfR = true;
        this.hfS = 0;
        this.ZT = 0;
        this.dLt = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hfT = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hfN.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hfN.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hfN.get(i2)).bja() != EmotionGroupType.USER_COLLECT) {
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
        this.hfN = new ArrayList<>();
        this.hfO = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hfP = null;
        this.aho = -1;
        this.hfQ = true;
        this.hfR = true;
        this.hfS = 0;
        this.ZT = 0;
        this.dLt = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hfT = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hfN.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hfN.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hfN.get(i2)).bja() != EmotionGroupType.USER_COLLECT) {
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
        this.hfK = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.hfL = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.hfM = findViewById(R.id.emotion_tab_widget_div_line);
        this.hfL.setOnTabSelectedListener(this);
        this.hfK.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aho = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aho);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.hfL != null) {
            this.hfL.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.hfR = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bTS() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bUc().bUe().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bja() != EmotionGroupType.BIG_EMOTION || this.hfQ) {
                if (next.bja() != EmotionGroupType.USER_COLLECT || this.hfR) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.hfN = e.bUc().bUe();
        if (!this.hfQ || !this.hfR) {
            this.hfO = bTS();
            if (!this.hfR && this.hfN != null) {
                this.hfN = new ArrayList<>(e.bUc().bUe());
                int i = 0;
                while (true) {
                    if (i < this.hfN.size()) {
                        if (this.hfN.get(i).bja() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.hfN.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.hfO = e.bUc().bUe();
        }
        if ((this.hfN == null || this.hfN.size() <= 0) && this.hfS < 3) {
            this.hfS++;
            e.bUc().bUd();
            return;
        }
        this.hfL.setDatas(this.hfN);
        int size = this.hfN.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hfN.get(i3);
            if (this.hfP != null && this.hfP.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dLt);
        MessageManager.getInstance().registerListener(this.hfT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dLt);
        MessageManager.getInstance().unRegisterListener(this.hfT);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aho) {
            this.aho = skinType;
            onChangeSkinType(this.aho);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hfL.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.hfO.size() && i != this.mCurrentIndex) {
            this.hfK.g(this.hfO, i);
            this.hfL.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.hfP = this.hfO.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hfN.clear();
        this.hfK.reset();
        this.hfL.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.hfQ = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void od(int i) {
        if (i >= 0 && i < this.hfN.size() && i != this.mCurrentIndex && this.hfK != null) {
            this.hfK.tv(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.hfL.onChangeSkinType(i);
        this.hfK.onChangeSkinType(i);
        ao.setBackgroundColor(this.hfM, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void tw(int i) {
        if (this.hfL != null && i != this.mCurrentIndex) {
            this.hfL.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ap("c12612").ah("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hfO.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.biZ()) {
                                    arrayList.add(next);
                                }
                            }
                            this.hfK.g(arrayList, 0);
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
        this.ZS = editorTools;
        this.hfK.setOnDataSelected(editorTools);
        this.hfL.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.hfL != null) {
            int size = this.hfN.size();
            for (int i = 0; i < size; i++) {
                this.hfL.setTabWidgetVisibility(i, this.hfQ);
            }
            this.hfL.setTabWidgetBigEmontionVisibility(this.hfQ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
