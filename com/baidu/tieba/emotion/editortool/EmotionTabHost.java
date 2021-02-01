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
/* loaded from: classes8.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements n, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools acR;
    private int acS;
    private int ajU;
    private int bLv;
    private CustomMessageListener eJz;
    private EmotionTabContentView iGg;
    private EmotionTabWidgetView iGh;
    private View iGi;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iGj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iGk;
    private String iGl;
    private boolean iGm;
    private boolean iGn;
    private int iGo;
    private CustomMessageListener iGp;

    public EmotionTabHost(Context context) {
        super(context);
        this.iGj = new ArrayList<>();
        this.iGk = new ArrayList<>();
        this.bLv = -1;
        this.iGl = null;
        this.ajU = -1;
        this.iGm = true;
        this.iGn = true;
        this.iGo = 0;
        this.acS = 0;
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iGp = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iGj.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iGj.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iGj.get(i2)).bBB() != EmotionGroupType.USER_COLLECT) {
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
        this.iGj = new ArrayList<>();
        this.iGk = new ArrayList<>();
        this.bLv = -1;
        this.iGl = null;
        this.ajU = -1;
        this.iGm = true;
        this.iGn = true;
        this.iGo = 0;
        this.acS = 0;
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iGp = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iGj.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iGj.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iGj.get(i2)).bBB() != EmotionGroupType.USER_COLLECT) {
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
        this.iGg = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.iGh = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.iGi = findViewById(R.id.emotion_tab_widget_div_line);
        this.iGh.setOnTabSelectedListener(this);
        this.iGg.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ajU = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ajU);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.iGh != null) {
            this.iGh.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iGn = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cuE() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cuO().cuQ().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bBB() != EmotionGroupType.BIG_EMOTION || this.iGm) {
                if (next.bBB() != EmotionGroupType.USER_COLLECT || this.iGn) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.iGj = e.cuO().cuQ();
        if (!this.iGm || !this.iGn) {
            this.iGk = cuE();
            if (!this.iGn && this.iGj != null) {
                this.iGj = new ArrayList<>(e.cuO().cuQ());
                int i = 0;
                while (true) {
                    if (i < this.iGj.size()) {
                        if (this.iGj.get(i).bBB() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.iGj.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.iGk = e.cuO().cuQ();
        }
        if ((this.iGj == null || this.iGj.size() <= 0) && this.iGo < 3) {
            this.iGo++;
            e.cuO().cuP();
            return;
        }
        this.iGh.setDatas(this.iGj);
        int size = this.iGj.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iGj.get(i3);
            if (this.iGl != null && this.iGl.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eJz);
        MessageManager.getInstance().registerListener(this.iGp);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eJz);
        MessageManager.getInstance().unRegisterListener(this.iGp);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajU) {
            this.ajU = skinType;
            onChangeSkinType(this.ajU);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iGh.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.iGk.size() && i != this.bLv) {
            this.iGg.g(this.iGk, i);
            this.iGh.setCurrentTab(i);
            this.bLv = i;
            this.iGl = this.iGk.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bLv = -1;
        this.iGj.clear();
        this.iGg.reset();
        this.iGh.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.iGm = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ri(int i) {
        if (i >= 0 && i < this.iGj.size() && i != this.bLv && this.iGg != null) {
            this.iGg.xp(i);
            this.bLv = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.iGh.onChangeSkinType(i);
        this.iGg.onChangeSkinType(i);
        ap.setBackgroundColor(this.iGi, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xq(int i) {
        if (this.iGh != null && i != this.bLv) {
            this.iGh.setCurrentTab(i);
            this.bLv = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ar("c12612").ap("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGk.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bBA()) {
                                    arrayList.add(next);
                                }
                            }
                            this.iGg.g(arrayList, 0);
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
        this.acR = editorTools;
        this.iGg.setOnDataSelected(editorTools);
        this.iGh.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.iGh != null) {
            int size = this.iGj.size();
            for (int i = 0; i < size; i++) {
                this.iGh.setTabWidgetVisibility(i, this.iGm);
            }
            this.iGh.setTabWidgetBigEmontionVisibility(this.iGm);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
