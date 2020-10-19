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
    private EditorTools abj;
    private int abk;
    private int ajp;
    private CustomMessageListener eiR;
    private EmotionTabContentView hOJ;
    private EmotionTabWidgetView hOK;
    private View hOL;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hOM;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hON;
    private String hOO;
    private boolean hOP;
    private boolean hOQ;
    private int hOR;
    private CustomMessageListener hOS;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.hOM = new ArrayList<>();
        this.hON = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hOO = null;
        this.ajp = -1;
        this.hOP = true;
        this.hOQ = true;
        this.hOR = 0;
        this.abk = 0;
        this.eiR = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hOS = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hOM.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hOM.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hOM.get(i2)).bvz() != EmotionGroupType.USER_COLLECT) {
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
        this.hOM = new ArrayList<>();
        this.hON = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hOO = null;
        this.ajp = -1;
        this.hOP = true;
        this.hOQ = true;
        this.hOR = 0;
        this.abk = 0;
        this.eiR = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hOS = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hOM.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hOM.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hOM.get(i2)).bvz() != EmotionGroupType.USER_COLLECT) {
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
        this.hOJ = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.hOK = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.hOL = findViewById(R.id.emotion_tab_widget_div_line);
        this.hOK.setOnTabSelectedListener(this);
        this.hOJ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ajp = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ajp);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.hOK != null) {
            this.hOK.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.hOQ = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ckQ() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cla().clc().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bvz() != EmotionGroupType.BIG_EMOTION || this.hOP) {
                if (next.bvz() != EmotionGroupType.USER_COLLECT || this.hOQ) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.hOM = e.cla().clc();
        if (!this.hOP || !this.hOQ) {
            this.hON = ckQ();
            if (!this.hOQ && this.hOM != null) {
                this.hOM = new ArrayList<>(e.cla().clc());
                int i = 0;
                while (true) {
                    if (i < this.hOM.size()) {
                        if (this.hOM.get(i).bvz() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.hOM.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.hON = e.cla().clc();
        }
        if ((this.hOM == null || this.hOM.size() <= 0) && this.hOR < 3) {
            this.hOR++;
            e.cla().clb();
            return;
        }
        this.hOK.setDatas(this.hOM);
        int size = this.hOM.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hOM.get(i3);
            if (this.hOO != null && this.hOO.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eiR);
        MessageManager.getInstance().registerListener(this.hOS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eiR);
        MessageManager.getInstance().unRegisterListener(this.hOS);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajp) {
            this.ajp = skinType;
            onChangeSkinType(this.ajp);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hOK.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.hON.size() && i != this.mCurrentIndex) {
            this.hOJ.g(this.hON, i);
            this.hOK.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.hOO = this.hON.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hOM.clear();
        this.hOJ.reset();
        this.hOK.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.hOP = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void rd(int i) {
        if (i >= 0 && i < this.hOM.size() && i != this.mCurrentIndex && this.hOJ != null) {
            this.hOJ.wP(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.hOK.onChangeSkinType(i);
        this.hOJ.onChangeSkinType(i);
        ap.setBackgroundColor(this.hOL, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void wQ(int i) {
        if (this.hOK != null && i != this.mCurrentIndex) {
            this.hOK.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hON.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bvy()) {
                                    arrayList.add(next);
                                }
                            }
                            this.hOJ.g(arrayList, 0);
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
        this.abj = editorTools;
        this.hOJ.setOnDataSelected(editorTools);
        this.hOK.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abk;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.hOK != null) {
            int size = this.hOM.size();
            for (int i = 0; i < size; i++) {
                this.hOK.setTabWidgetVisibility(i, this.hOP);
            }
            this.hOK.setTabWidgetBigEmontionVisibility(this.hOP);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
