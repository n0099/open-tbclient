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
    private EditorTools abk;
    private int abl;
    private int ajq;
    private CustomMessageListener erp;
    private EmotionTabContentView ibg;
    private EmotionTabWidgetView ibh;
    private View ibi;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ibj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ibk;
    private String ibl;
    private boolean ibm;
    private boolean ibn;
    private int ibo;
    private CustomMessageListener ibp;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.ibj = new ArrayList<>();
        this.ibk = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ibl = null;
        this.ajq = -1;
        this.ibm = true;
        this.ibn = true;
        this.ibo = 0;
        this.abl = 0;
        this.erp = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.ibp = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ibj.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ibj.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ibj.get(i2)).bxs() != EmotionGroupType.USER_COLLECT) {
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
        this.ibj = new ArrayList<>();
        this.ibk = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ibl = null;
        this.ajq = -1;
        this.ibm = true;
        this.ibn = true;
        this.ibo = 0;
        this.abl = 0;
        this.erp = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.ibp = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ibj.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ibj.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ibj.get(i2)).bxs() != EmotionGroupType.USER_COLLECT) {
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
        this.ibg = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.ibh = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.ibi = findViewById(R.id.emotion_tab_widget_div_line);
        this.ibh.setOnTabSelectedListener(this);
        this.ibg.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ajq = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ajq);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.ibh != null) {
            this.ibh.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.ibn = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cnX() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.coh().coj().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bxs() != EmotionGroupType.BIG_EMOTION || this.ibm) {
                if (next.bxs() != EmotionGroupType.USER_COLLECT || this.ibn) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ibj = e.coh().coj();
        if (!this.ibm || !this.ibn) {
            this.ibk = cnX();
            if (!this.ibn && this.ibj != null) {
                this.ibj = new ArrayList<>(e.coh().coj());
                int i = 0;
                while (true) {
                    if (i < this.ibj.size()) {
                        if (this.ibj.get(i).bxs() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.ibj.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.ibk = e.coh().coj();
        }
        if ((this.ibj == null || this.ibj.size() <= 0) && this.ibo < 3) {
            this.ibo++;
            e.coh().coi();
            return;
        }
        this.ibh.setDatas(this.ibj);
        int size = this.ibj.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ibj.get(i3);
            if (this.ibl != null && this.ibl.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.erp);
        MessageManager.getInstance().registerListener(this.ibp);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.erp);
        MessageManager.getInstance().unRegisterListener(this.ibp);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajq) {
            this.ajq = skinType;
            onChangeSkinType(this.ajq);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ibh.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.ibk.size() && i != this.mCurrentIndex) {
            this.ibg.g(this.ibk, i);
            this.ibh.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.ibl = this.ibk.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ibj.clear();
        this.ibg.reset();
        this.ibh.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.ibm = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ro(int i) {
        if (i >= 0 && i < this.ibj.size() && i != this.mCurrentIndex && this.ibg != null) {
            this.ibg.xi(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ibh.onChangeSkinType(i);
        this.ibg.onChangeSkinType(i);
        ap.setBackgroundColor(this.ibi, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xj(int i) {
        if (this.ibh != null && i != this.mCurrentIndex) {
            this.ibh.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new aq("c12612").aj("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ibk.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bxr()) {
                                    arrayList.add(next);
                                }
                            }
                            this.ibg.g(arrayList, 0);
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
        this.abk = editorTools;
        this.ibg.setOnDataSelected(editorTools);
        this.ibh.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.ibh != null) {
            int size = this.ibj.size();
            for (int i = 0; i < size; i++) {
                this.ibh.setTabWidgetVisibility(i, this.ibm);
            }
            this.ibh.setTabWidgetBigEmontionVisibility(this.ibm);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
