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
/* loaded from: classes8.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements n, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools acZ;
    private int ada;
    private int akW;
    private int bMx;
    private CustomMessageListener eMe;
    private EmotionTabContentView iFd;
    private EmotionTabWidgetView iFe;
    private View iFf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iFg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iFh;
    private String iFi;
    private boolean iFj;
    private boolean iFk;
    private int iFl;
    private CustomMessageListener iFm;

    public EmotionTabHost(Context context) {
        super(context);
        this.iFg = new ArrayList<>();
        this.iFh = new ArrayList<>();
        this.bMx = -1;
        this.iFi = null;
        this.akW = -1;
        this.iFj = true;
        this.iFk = true;
        this.iFl = 0;
        this.ada = 0;
        this.eMe = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iFm = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iFg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iFg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iFg.get(i2)).bFc() != EmotionGroupType.USER_COLLECT) {
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
        this.iFg = new ArrayList<>();
        this.iFh = new ArrayList<>();
        this.bMx = -1;
        this.iFi = null;
        this.akW = -1;
        this.iFj = true;
        this.iFk = true;
        this.iFl = 0;
        this.ada = 0;
        this.eMe = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iFm = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iFg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iFg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iFg.get(i2)).bFc() != EmotionGroupType.USER_COLLECT) {
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
        this.iFd = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.iFe = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.iFf = findViewById(R.id.emotion_tab_widget_div_line);
        this.iFe.setOnTabSelectedListener(this);
        this.iFd.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.akW = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.akW);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.iFe != null) {
            this.iFe.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iFk = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cxj() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cxt().cxv().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bFc() != EmotionGroupType.BIG_EMOTION || this.iFj) {
                if (next.bFc() != EmotionGroupType.USER_COLLECT || this.iFk) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.iFg = e.cxt().cxv();
        if (!this.iFj || !this.iFk) {
            this.iFh = cxj();
            if (!this.iFk && this.iFg != null) {
                this.iFg = new ArrayList<>(e.cxt().cxv());
                int i = 0;
                while (true) {
                    if (i < this.iFg.size()) {
                        if (this.iFg.get(i).bFc() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.iFg.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.iFh = e.cxt().cxv();
        }
        if ((this.iFg == null || this.iFg.size() <= 0) && this.iFl < 3) {
            this.iFl++;
            e.cxt().cxu();
            return;
        }
        this.iFe.setDatas(this.iFg);
        int size = this.iFg.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iFg.get(i3);
            if (this.iFi != null && this.iFi.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eMe);
        MessageManager.getInstance().registerListener(this.iFm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eMe);
        MessageManager.getInstance().unRegisterListener(this.iFm);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.akW) {
            this.akW = skinType;
            onChangeSkinType(this.akW);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iFe.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.iFh.size() && i != this.bMx) {
            this.iFd.g(this.iFh, i);
            this.iFe.setCurrentTab(i);
            this.bMx = i;
            this.iFi = this.iFh.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bMx = -1;
        this.iFg.clear();
        this.iFd.reset();
        this.iFe.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.iFj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void sJ(int i) {
        if (i >= 0 && i < this.iFg.size() && i != this.bMx && this.iFd != null) {
            this.iFd.yL(i);
            this.bMx = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.iFe.onChangeSkinType(i);
        this.iFd.onChangeSkinType(i);
        ao.setBackgroundColor(this.iFf, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void yM(int i) {
        if (this.iFe != null && i != this.bMx) {
            this.iFe.setCurrentTab(i);
            this.bMx = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new aq("c12612").an("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iFh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bFb()) {
                                    arrayList.add(next);
                                }
                            }
                            this.iFd.g(arrayList, 0);
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
        this.acZ = editorTools;
        this.iFd.setOnDataSelected(editorTools);
        this.iFe.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.iFe != null) {
            int size = this.iFg.size();
            for (int i = 0; i < size; i++) {
                this.iFe.setTabWidgetVisibility(i, this.iFj);
            }
            this.iFe.setTabWidgetBigEmontionVisibility(this.iFj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
