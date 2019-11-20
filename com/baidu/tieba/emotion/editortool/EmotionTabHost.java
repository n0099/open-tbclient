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
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools CJ;
    private int CK;
    private int apz;
    private CustomMessageListener bVa;
    private int csg;
    private EmotionTabContentView eYq;
    private EmotionTabWidgetView eYr;
    private View eYs;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eYt;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eYu;
    private String eYv;
    private boolean eYw;
    private boolean eYx;
    private int eYy;
    private CustomMessageListener eYz;

    public EmotionTabHost(Context context) {
        super(context);
        this.eYt = new ArrayList<>();
        this.eYu = new ArrayList<>();
        this.apz = -1;
        this.eYv = null;
        this.csg = -1;
        this.eYw = true;
        this.eYx = true;
        this.eYy = 0;
        this.CK = 0;
        this.bVa = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eYz = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eYt.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eYt.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eYt.get(i2)).aum() != EmotionGroupType.USER_COLLECT) {
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
        this.eYt = new ArrayList<>();
        this.eYu = new ArrayList<>();
        this.apz = -1;
        this.eYv = null;
        this.csg = -1;
        this.eYw = true;
        this.eYx = true;
        this.eYy = 0;
        this.CK = 0;
        this.bVa = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eYz = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eYt.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eYt.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eYt.get(i2)).aum() != EmotionGroupType.USER_COLLECT) {
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
        this.eYq = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.eYr = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.eYs = findViewById(R.id.emotion_tab_widget_div_line);
        this.eYr.setOnTabSelectedListener(this);
        this.eYq.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.csg = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.csg);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eYr != null) {
            this.eYr.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eYx = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bdl() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bdv().bdx().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aum() != EmotionGroupType.BIG_EMOTION || this.eYw) {
                if (next.aum() != EmotionGroupType.USER_COLLECT || this.eYx) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eYt = e.bdv().bdx();
        if (!this.eYw || !this.eYx) {
            this.eYu = bdl();
            if (!this.eYx && this.eYt != null) {
                this.eYt = new ArrayList<>(e.bdv().bdx());
                int i = 0;
                while (true) {
                    if (i < this.eYt.size()) {
                        if (this.eYt.get(i).aum() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eYt.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eYu = e.bdv().bdx();
        }
        if ((this.eYt == null || this.eYt.size() <= 0) && this.eYy < 3) {
            this.eYy++;
            e.bdv().bdw();
            return;
        }
        this.eYr.setDatas(this.eYt);
        int size = this.eYt.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eYt.get(i3);
            if (this.eYv != null && this.eYv.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bVa);
        MessageManager.getInstance().registerListener(this.eYz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bVa);
        MessageManager.getInstance().unRegisterListener(this.eYz);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.csg) {
            this.csg = skinType;
            onChangeSkinType(this.csg);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eYr.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eYu.size() && i != this.apz) {
            this.eYq.f(this.eYu, i);
            this.eYr.setCurrentTab(i);
            this.apz = i;
            this.eYv = this.eYu.get(i).getGroupId();
        }
    }

    public void reset() {
        this.apz = -1;
        this.eYt.clear();
        this.eYq.reset();
        this.eYr.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eYw = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void jV(int i) {
        if (i >= 0 && i < this.eYt.size() && i != this.apz && this.eYq != null) {
            this.eYq.pj(i);
            this.apz = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eYr.onChangeSkinType(i);
        this.eYq.onChangeSkinType(i);
        am.setBackgroundColor(this.eYs, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void pk(int i) {
        if (this.eYr != null && i != this.apz) {
            this.eYr.setCurrentTab(i);
            this.apz = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eYu.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aul()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eYq.f(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
        this.eYq.setOnDataSelected(editorTools);
        this.eYr.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.eYr != null) {
            int size = this.eYt.size();
            for (int i = 0; i < size; i++) {
                this.eYr.setTabWidgetVisibility(i, this.eYw);
            }
            this.eYr.setTabWidgetBigEmontionVisibility(this.eYw);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
