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
    private EmotionTabContentView gNj;
    private EmotionTabWidgetView gNk;
    private View gNl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gNm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gNn;
    private String gNo;
    private boolean gNp;
    private boolean gNq;
    private int gNr;
    private CustomMessageListener gNs;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.gNm = new ArrayList<>();
        this.gNn = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gNo = null;
        this.agt = -1;
        this.gNp = true;
        this.gNq = true;
        this.gNr = 0;
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
        this.gNs = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gNm.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gNm.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gNm.get(i2)).bdm() != EmotionGroupType.USER_COLLECT) {
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
        this.gNm = new ArrayList<>();
        this.gNn = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gNo = null;
        this.agt = -1;
        this.gNp = true;
        this.gNq = true;
        this.gNr = 0;
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
        this.gNs = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gNm.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gNm.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gNm.get(i2)).bdm() != EmotionGroupType.USER_COLLECT) {
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
        this.gNj = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.gNk = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.gNl = findViewById(R.id.emotion_tab_widget_div_line);
        this.gNk.setOnTabSelectedListener(this);
        this.gNj.setOnEmotionSwitchedListener(this);
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
        if (this.gNk != null) {
            this.gNk.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.gNq = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bNB() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bNL().bNN().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bdm() != EmotionGroupType.BIG_EMOTION || this.gNp) {
                if (next.bdm() != EmotionGroupType.USER_COLLECT || this.gNq) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.gNm = e.bNL().bNN();
        if (!this.gNp || !this.gNq) {
            this.gNn = bNB();
            if (!this.gNq && this.gNm != null) {
                this.gNm = new ArrayList<>(e.bNL().bNN());
                int i = 0;
                while (true) {
                    if (i < this.gNm.size()) {
                        if (this.gNm.get(i).bdm() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.gNm.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.gNn = e.bNL().bNN();
        }
        if ((this.gNm == null || this.gNm.size() <= 0) && this.gNr < 3) {
            this.gNr++;
            e.bNL().bNM();
            return;
        }
        this.gNk.setDatas(this.gNm);
        int size = this.gNm.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gNm.get(i3);
            if (this.gNo != null && this.gNo.equals(cVar.getGroupId())) {
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
        MessageManager.getInstance().registerListener(this.gNs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dzd);
        MessageManager.getInstance().unRegisterListener(this.gNs);
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
        this.gNk.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.gNn.size() && i != this.mCurrentIndex) {
            this.gNj.h(this.gNn, i);
            this.gNk.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.gNo = this.gNn.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gNm.clear();
        this.gNj.reset();
        this.gNk.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.gNp = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void nr(int i) {
        if (i >= 0 && i < this.gNm.size() && i != this.mCurrentIndex && this.gNj != null) {
            this.gNj.sC(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.gNk.onChangeSkinType(i);
        this.gNj.onChangeSkinType(i);
        am.setBackgroundColor(this.gNl, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void sD(int i) {
        if (this.gNk != null && i != this.mCurrentIndex) {
            this.gNk.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gNn.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bdl()) {
                                    arrayList.add(next);
                                }
                            }
                            this.gNj.h(arrayList, 0);
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
        this.gNj.setOnDataSelected(editorTools);
        this.gNk.setOnDataSelected(editorTools);
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
        if (this.gNk != null) {
            int size = this.gNm.size();
            for (int i = 0; i < size; i++) {
                this.gNk.setTabWidgetVisibility(i, this.gNp);
            }
            this.gNk.setTabWidgetBigEmontionVisibility(this.gNp);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
