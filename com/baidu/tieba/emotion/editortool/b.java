package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends NoPressedLinearLayout implements s, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private i IT;
    private int IU;
    private CustomMessageListener TJ;
    private int aEN;
    private int apA;
    private EmotionTabContentView crQ;
    private EmotionTabWidgetView crR;
    private View crS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> crT;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> crU;
    private String crV;
    private boolean crW;
    private boolean crX;
    private int crY;
    private CustomMessageListener crZ;

    public b(Context context) {
        super(context);
        this.crT = new ArrayList<>();
        this.crU = new ArrayList<>();
        this.aEN = -1;
        this.crV = null;
        this.apA = -1;
        this.crW = true;
        this.crX = true;
        this.crY = 0;
        this.IU = 0;
        this.TJ = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        b.this.reset();
                        b.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.crZ = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.crT.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.crT.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.crT.get(i2)).Ds() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                b.this.setCurrentEmotionGroup(i2);
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_host, (ViewGroup) this, true);
        this.crQ = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.crR = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.crS = findViewById(d.g.emotion_tab_widget_div_line);
        this.crR.setOnTabSelectedListener(this);
        this.crQ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apA = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.apA);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.crR != null) {
            this.crR.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.crX = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> agp() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.agz().agB().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Ds() != EmotionGroupType.BIG_EMOTION || this.crW) {
                if (next.Ds() != EmotionGroupType.USER_COLLECT || this.crX) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.crT = g.agz().agB();
        if (!this.crW || !this.crX) {
            this.crU = agp();
            if (!this.crX && this.crT != null) {
                this.crT = new ArrayList<>(g.agz().agB());
                int i = 0;
                while (true) {
                    if (i < this.crT.size()) {
                        if (this.crT.get(i).Ds() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.crT.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.crU = g.agz().agB();
        }
        if ((this.crT == null || this.crT.size() <= 0) && this.crY < 3) {
            this.crY++;
            g.agz().agA();
            return;
        }
        this.crR.setDatas(this.crT);
        int size = this.crT.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.crT.get(i3);
            if (this.crV != null && this.crV.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TJ);
        MessageManager.getInstance().registerListener(this.crZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TJ);
        MessageManager.getInstance().unRegisterListener(this.crZ);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apA) {
            this.apA = skinType;
            onChangeSkinType(this.apA);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.crR.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.crU.size() && i != this.aEN) {
            this.crQ.i(this.crU, i);
            this.crR.setCurrentTab(i);
            this.aEN = i;
            this.crV = this.crU.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aEN = -1;
        this.crT.clear();
        this.crQ.reset();
        this.crR.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.crW = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fb(int i) {
        if (i >= 0 && i < this.crT.size() && i != this.aEN && this.crQ != null) {
            this.crQ.jd(i);
            this.aEN = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.crR.onChangeSkinType(i);
        this.crQ.onChangeSkinType(i);
        aj.e(this.crS, d.C0082d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void je(int i) {
        if (this.crR != null && i != this.aEN) {
            this.crR.setCurrentTab(i);
            this.aEN = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.crU.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dr()) {
                                    arrayList.add(next);
                                }
                            }
                            this.crQ.i(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
        this.crQ.setOnDataSelected(iVar);
        this.crR.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.crR != null) {
            int size = this.crT.size();
            for (int i = 0; i < size; i++) {
                this.crR.m(i, this.crW);
            }
            this.crR.setTabWidgetBigEmontionVisibility(this.crW);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
