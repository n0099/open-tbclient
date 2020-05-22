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
    private EditorTools Zt;
    private int Zu;
    private int agt;
    private CustomMessageListener dzd;
    private EmotionTabContentView gMY;
    private EmotionTabWidgetView gMZ;
    private View gNa;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gNb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gNc;
    private String gNd;
    private boolean gNe;
    private boolean gNf;
    private int gNg;
    private CustomMessageListener gNh;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.gNb = new ArrayList<>();
        this.gNc = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gNd = null;
        this.agt = -1;
        this.gNe = true;
        this.gNf = true;
        this.gNg = 0;
        this.Zu = 0;
        this.dzd = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.gNh = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gNb.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gNb.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gNb.get(i2)).bdl() != EmotionGroupType.USER_COLLECT) {
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
        this.gNb = new ArrayList<>();
        this.gNc = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gNd = null;
        this.agt = -1;
        this.gNe = true;
        this.gNf = true;
        this.gNg = 0;
        this.Zu = 0;
        this.dzd = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.gNh = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gNb.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gNb.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gNb.get(i2)).bdl() != EmotionGroupType.USER_COLLECT) {
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
        this.gMY = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.gMZ = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.gNa = findViewById(R.id.emotion_tab_widget_div_line);
        this.gMZ.setOnTabSelectedListener(this);
        this.gMY.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.agt = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.agt);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.gMZ != null) {
            this.gMZ.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.gNf = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bNz() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bNJ().bNL().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bdl() != EmotionGroupType.BIG_EMOTION || this.gNe) {
                if (next.bdl() != EmotionGroupType.USER_COLLECT || this.gNf) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.gNb = e.bNJ().bNL();
        if (!this.gNe || !this.gNf) {
            this.gNc = bNz();
            if (!this.gNf && this.gNb != null) {
                this.gNb = new ArrayList<>(e.bNJ().bNL());
                int i = 0;
                while (true) {
                    if (i < this.gNb.size()) {
                        if (this.gNb.get(i).bdl() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.gNb.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.gNc = e.bNJ().bNL();
        }
        if ((this.gNb == null || this.gNb.size() <= 0) && this.gNg < 3) {
            this.gNg++;
            e.bNJ().bNK();
            return;
        }
        this.gMZ.setDatas(this.gNb);
        int size = this.gNb.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gNb.get(i3);
            if (this.gNd != null && this.gNd.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dzd);
        MessageManager.getInstance().registerListener(this.gNh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dzd);
        MessageManager.getInstance().unRegisterListener(this.gNh);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.agt) {
            this.agt = skinType;
            onChangeSkinType(this.agt);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gMZ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.gNc.size() && i != this.mCurrentIndex) {
            this.gMY.h(this.gNc, i);
            this.gMZ.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.gNd = this.gNc.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gNb.clear();
        this.gMY.reset();
        this.gMZ.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.gNe = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void np(int i) {
        if (i >= 0 && i < this.gNb.size() && i != this.mCurrentIndex && this.gMY != null) {
            this.gMY.sA(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.gMZ.onChangeSkinType(i);
        this.gMY.onChangeSkinType(i);
        am.setBackgroundColor(this.gNa, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void sB(int i) {
        if (this.gMZ != null && i != this.mCurrentIndex) {
            this.gMZ.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gNc.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bdk()) {
                                    arrayList.add(next);
                                }
                            }
                            this.gMY.h(arrayList, 0);
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
        this.Zt = editorTools;
        this.gMY.setOnDataSelected(editorTools);
        this.gMZ.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.gMZ != null) {
            int size = this.gNb.size();
            for (int i = 0; i < size; i++) {
                this.gMZ.setTabWidgetVisibility(i, this.gNe);
            }
            this.gMZ.setTabWidgetBigEmontionVisibility(this.gNe);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
