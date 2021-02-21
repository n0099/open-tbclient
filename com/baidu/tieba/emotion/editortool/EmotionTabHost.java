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
    private boolean iGA;
    private boolean iGB;
    private int iGC;
    private CustomMessageListener iGD;
    private EmotionTabContentView iGu;
    private EmotionTabWidgetView iGv;
    private View iGw;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iGx;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iGy;
    private String iGz;

    public EmotionTabHost(Context context) {
        super(context);
        this.iGx = new ArrayList<>();
        this.iGy = new ArrayList<>();
        this.bLv = -1;
        this.iGz = null;
        this.ajU = -1;
        this.iGA = true;
        this.iGB = true;
        this.iGC = 0;
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
        this.iGD = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iGx.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iGx.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iGx.get(i2)).bBB() != EmotionGroupType.USER_COLLECT) {
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
        this.iGx = new ArrayList<>();
        this.iGy = new ArrayList<>();
        this.bLv = -1;
        this.iGz = null;
        this.ajU = -1;
        this.iGA = true;
        this.iGB = true;
        this.iGC = 0;
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
        this.iGD = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iGx.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iGx.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iGx.get(i2)).bBB() != EmotionGroupType.USER_COLLECT) {
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
        this.iGu = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.iGv = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.iGw = findViewById(R.id.emotion_tab_widget_div_line);
        this.iGv.setOnTabSelectedListener(this);
        this.iGu.setOnEmotionSwitchedListener(this);
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
        if (this.iGv != null) {
            this.iGv.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iGB = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cuL() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cuV().cuX().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bBB() != EmotionGroupType.BIG_EMOTION || this.iGA) {
                if (next.bBB() != EmotionGroupType.USER_COLLECT || this.iGB) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.iGx = e.cuV().cuX();
        if (!this.iGA || !this.iGB) {
            this.iGy = cuL();
            if (!this.iGB && this.iGx != null) {
                this.iGx = new ArrayList<>(e.cuV().cuX());
                int i = 0;
                while (true) {
                    if (i < this.iGx.size()) {
                        if (this.iGx.get(i).bBB() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.iGx.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.iGy = e.cuV().cuX();
        }
        if ((this.iGx == null || this.iGx.size() <= 0) && this.iGC < 3) {
            this.iGC++;
            e.cuV().cuW();
            return;
        }
        this.iGv.setDatas(this.iGx);
        int size = this.iGx.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iGx.get(i3);
            if (this.iGz != null && this.iGz.equals(cVar.getGroupId())) {
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
        MessageManager.getInstance().registerListener(this.iGD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eJz);
        MessageManager.getInstance().unRegisterListener(this.iGD);
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
        this.iGv.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.iGy.size() && i != this.bLv) {
            this.iGu.g(this.iGy, i);
            this.iGv.setCurrentTab(i);
            this.bLv = i;
            this.iGz = this.iGy.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bLv = -1;
        this.iGx.clear();
        this.iGu.reset();
        this.iGv.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.iGA = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ri(int i) {
        if (i >= 0 && i < this.iGx.size() && i != this.bLv && this.iGu != null) {
            this.iGu.xp(i);
            this.bLv = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.iGv.onChangeSkinType(i);
        this.iGu.onChangeSkinType(i);
        ap.setBackgroundColor(this.iGw, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xq(int i) {
        if (this.iGv != null && i != this.bLv) {
            this.iGv.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGy.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bBA()) {
                                    arrayList.add(next);
                                }
                            }
                            this.iGu.g(arrayList, 0);
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
        this.iGu.setOnDataSelected(editorTools);
        this.iGv.setOnDataSelected(editorTools);
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
        if (this.iGv != null) {
            int size = this.iGx.size();
            for (int i = 0; i < size; i++) {
                this.iGv.setTabWidgetVisibility(i, this.iGA);
            }
            this.iGv.setTabWidgetBigEmontionVisibility(this.iGA);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
