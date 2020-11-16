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
    private EditorTools abp;
    private int abq;
    private int ajv;
    private CustomMessageListener evz;
    private EmotionTabContentView ihV;
    private EmotionTabWidgetView ihW;
    private View ihX;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ihY;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ihZ;
    private String iia;
    private boolean iib;
    private boolean iic;
    private int iid;
    private CustomMessageListener iie;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.ihY = new ArrayList<>();
        this.ihZ = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.iia = null;
        this.ajv = -1;
        this.iib = true;
        this.iic = true;
        this.iid = 0;
        this.abq = 0;
        this.evz = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iie = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ihY.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ihY.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ihY.get(i2)).bzh() != EmotionGroupType.USER_COLLECT) {
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
        this.ihY = new ArrayList<>();
        this.ihZ = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.iia = null;
        this.ajv = -1;
        this.iib = true;
        this.iic = true;
        this.iid = 0;
        this.abq = 0;
        this.evz = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iie = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ihY.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ihY.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ihY.get(i2)).bzh() != EmotionGroupType.USER_COLLECT) {
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
        this.ihV = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.ihW = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.ihX = findViewById(R.id.emotion_tab_widget_div_line);
        this.ihW.setOnTabSelectedListener(this);
        this.ihV.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ajv = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ajv);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.ihW != null) {
            this.ihW.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iic = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cqb() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cql().cqn().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bzh() != EmotionGroupType.BIG_EMOTION || this.iib) {
                if (next.bzh() != EmotionGroupType.USER_COLLECT || this.iic) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ihY = e.cql().cqn();
        if (!this.iib || !this.iic) {
            this.ihZ = cqb();
            if (!this.iic && this.ihY != null) {
                this.ihY = new ArrayList<>(e.cql().cqn());
                int i = 0;
                while (true) {
                    if (i < this.ihY.size()) {
                        if (this.ihY.get(i).bzh() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.ihY.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.ihZ = e.cql().cqn();
        }
        if ((this.ihY == null || this.ihY.size() <= 0) && this.iid < 3) {
            this.iid++;
            e.cql().cqm();
            return;
        }
        this.ihW.setDatas(this.ihY);
        int size = this.ihY.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ihY.get(i3);
            if (this.iia != null && this.iia.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.evz);
        MessageManager.getInstance().registerListener(this.iie);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.evz);
        MessageManager.getInstance().unRegisterListener(this.iie);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajv) {
            this.ajv = skinType;
            onChangeSkinType(this.ajv);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ihW.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.ihZ.size() && i != this.mCurrentIndex) {
            this.ihV.g(this.ihZ, i);
            this.ihW.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.iia = this.ihZ.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ihY.clear();
        this.ihV.reset();
        this.ihW.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.iib = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void rW(int i) {
        if (i >= 0 && i < this.ihY.size() && i != this.mCurrentIndex && this.ihV != null) {
            this.ihV.xT(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ihW.onChangeSkinType(i);
        this.ihV.onChangeSkinType(i);
        ap.setBackgroundColor(this.ihX, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xU(int i) {
        if (this.ihW != null && i != this.mCurrentIndex) {
            this.ihW.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ar("c12612").ak("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ihZ.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bzg()) {
                                    arrayList.add(next);
                                }
                            }
                            this.ihV.g(arrayList, 0);
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
        this.abp = editorTools;
        this.ihV.setOnDataSelected(editorTools);
        this.ihW.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abq;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.ihW != null) {
            int size = this.ihY.size();
            for (int i = 0; i < size; i++) {
                this.ihW.setTabWidgetVisibility(i, this.iib);
            }
            this.ihW.setTabWidgetBigEmontionVisibility(this.iib);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
