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
    private CustomMessageListener aIi;
    private i axQ;
    private int axR;
    private int bdS;
    private int btf;
    private View dlA;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dlB;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dlC;
    private String dlD;
    private boolean dlE;
    private boolean dlF;
    private int dlG;
    private CustomMessageListener dlH;
    private EmotionTabContentView dly;
    private EmotionTabWidgetView dlz;

    public b(Context context) {
        super(context);
        this.dlB = new ArrayList<>();
        this.dlC = new ArrayList<>();
        this.btf = -1;
        this.dlD = null;
        this.bdS = -1;
        this.dlE = true;
        this.dlF = true;
        this.dlG = 0;
        this.axR = 0;
        this.aIi = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.dlH = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.dlB.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.dlB.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.dlB.get(i2)).KL() != EmotionGroupType.USER_COLLECT) {
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
        this.dly = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.dlz = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.dlA = findViewById(d.g.emotion_tab_widget_div_line);
        this.dlz.setOnTabSelectedListener(this);
        this.dly.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bdS = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bdS);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dlz != null) {
            this.dlz.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dlF = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apf() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.app().apr().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.KL() != EmotionGroupType.BIG_EMOTION || this.dlE) {
                if (next.KL() != EmotionGroupType.USER_COLLECT || this.dlF) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dlB = g.app().apr();
        if (!this.dlE || !this.dlF) {
            this.dlC = apf();
            if (!this.dlF && this.dlB != null) {
                this.dlB = new ArrayList<>(g.app().apr());
                int i = 0;
                while (true) {
                    if (i < this.dlB.size()) {
                        if (this.dlB.get(i).KL() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dlB.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dlC = g.app().apr();
        }
        if ((this.dlB == null || this.dlB.size() <= 0) && this.dlG < 3) {
            this.dlG++;
            g.app().apq();
            return;
        }
        this.dlz.setDatas(this.dlB);
        int size = this.dlB.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dlB.get(i3);
            if (this.dlD != null && this.dlD.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aIi);
        MessageManager.getInstance().registerListener(this.dlH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aIi);
        MessageManager.getInstance().unRegisterListener(this.dlH);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bdS) {
            this.bdS = skinType;
            onChangeSkinType(this.bdS);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dlz.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dlC.size() && i != this.btf) {
            this.dly.l(this.dlC, i);
            this.dlz.setCurrentTab(i);
            this.btf = i;
            this.dlD = this.dlC.get(i).getGroupId();
        }
    }

    public void reset() {
        this.btf = -1;
        this.dlB.clear();
        this.dly.reset();
        this.dlz.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dlE = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void hV(int i) {
        if (i >= 0 && i < this.dlB.size() && i != this.btf && this.dly != null) {
            this.dly.mg(i);
            this.btf = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.dlz.onChangeSkinType(i);
        this.dly.onChangeSkinType(i);
        aj.g(this.dlA, d.C0108d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void mh(int i) {
        if (this.dlz != null && i != this.btf) {
            this.dlz.setCurrentTab(i);
            this.btf = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlC.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.KK()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dly.l(arrayList, 0);
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
        this.axQ = iVar;
        this.dly.setOnDataSelected(iVar);
        this.dlz.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void ti() {
        if (this.dlz != null) {
            int size = this.dlB.size();
            for (int i = 0; i < size; i++) {
                this.dlz.y(i, this.dlE);
            }
            this.dlz.setTabWidgetBigEmontionVisibility(this.dlE);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
