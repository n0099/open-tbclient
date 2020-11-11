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
    private CustomMessageListener exi;
    private EmotionTabContentView ihh;
    private EmotionTabWidgetView ihi;
    private View ihj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ihk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ihl;
    private String ihm;
    private boolean ihn;
    private boolean iho;
    private int ihp;
    private CustomMessageListener ihq;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.ihk = new ArrayList<>();
        this.ihl = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ihm = null;
        this.ajq = -1;
        this.ihn = true;
        this.iho = true;
        this.ihp = 0;
        this.abl = 0;
        this.exi = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.ihq = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ihk.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ihk.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ihk.get(i2)).bzR() != EmotionGroupType.USER_COLLECT) {
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
        this.ihk = new ArrayList<>();
        this.ihl = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ihm = null;
        this.ajq = -1;
        this.ihn = true;
        this.iho = true;
        this.ihp = 0;
        this.abl = 0;
        this.exi = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.ihq = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ihk.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ihk.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ihk.get(i2)).bzR() != EmotionGroupType.USER_COLLECT) {
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
        this.ihh = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.ihi = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.ihj = findViewById(R.id.emotion_tab_widget_div_line);
        this.ihi.setOnTabSelectedListener(this);
        this.ihh.setOnEmotionSwitchedListener(this);
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
        if (this.ihi != null) {
            this.ihi.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iho = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cqy() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cqI().cqK().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bzR() != EmotionGroupType.BIG_EMOTION || this.ihn) {
                if (next.bzR() != EmotionGroupType.USER_COLLECT || this.iho) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ihk = e.cqI().cqK();
        if (!this.ihn || !this.iho) {
            this.ihl = cqy();
            if (!this.iho && this.ihk != null) {
                this.ihk = new ArrayList<>(e.cqI().cqK());
                int i = 0;
                while (true) {
                    if (i < this.ihk.size()) {
                        if (this.ihk.get(i).bzR() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.ihk.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.ihl = e.cqI().cqK();
        }
        if ((this.ihk == null || this.ihk.size() <= 0) && this.ihp < 3) {
            this.ihp++;
            e.cqI().cqJ();
            return;
        }
        this.ihi.setDatas(this.ihk);
        int size = this.ihk.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ihk.get(i3);
            if (this.ihm != null && this.ihm.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.exi);
        MessageManager.getInstance().registerListener(this.ihq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.exi);
        MessageManager.getInstance().unRegisterListener(this.ihq);
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
        this.ihi.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.ihl.size() && i != this.mCurrentIndex) {
            this.ihh.g(this.ihl, i);
            this.ihi.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.ihm = this.ihl.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ihk.clear();
        this.ihh.reset();
        this.ihi.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.ihn = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ry(int i) {
        if (i >= 0 && i < this.ihk.size() && i != this.mCurrentIndex && this.ihh != null) {
            this.ihh.xv(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ihi.onChangeSkinType(i);
        this.ihh.onChangeSkinType(i);
        ap.setBackgroundColor(this.ihj, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xw(int i) {
        if (this.ihi != null && i != this.mCurrentIndex) {
            this.ihi.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new aq("c12612").al("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ihl.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bzQ()) {
                                    arrayList.add(next);
                                }
                            }
                            this.ihh.g(arrayList, 0);
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
        this.ihh.setOnDataSelected(editorTools);
        this.ihi.setOnDataSelected(editorTools);
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
        if (this.ihi != null) {
            int size = this.ihk.size();
            for (int i = 0; i < size; i++) {
                this.ihi.setTabWidgetVisibility(i, this.ihn);
            }
            this.ihi.setTabWidgetBigEmontionVisibility(this.ihn);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
