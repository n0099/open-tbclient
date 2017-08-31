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
    private int Jo;
    private i Jp;
    private CustomMessageListener SH;
    private int aEq;
    private int apS;
    private EmotionTabContentView caK;
    private EmotionTabWidgetView caL;
    private View caM;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> caN;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> caO;
    private String caP;
    private boolean caQ;
    private boolean caR;
    private boolean caS;
    private int caT;

    public b(Context context) {
        super(context);
        this.caN = new ArrayList<>();
        this.caO = new ArrayList<>();
        this.aEq = -1;
        this.caP = null;
        this.apS = -1;
        this.caR = true;
        this.caS = true;
        this.caT = 0;
        this.Jo = 0;
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.emotion_tab_host, (ViewGroup) this, true);
        this.caK = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.caL = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.caM = findViewById(d.h.emotion_tab_widget_div_line);
        this.caL.setOnTabSelectedListener(this);
        this.caK.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apS = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.apS);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.caL != null) {
            this.caL.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.caS = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aco() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.acy().acA().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dk() != EmotionGroupType.BIG_EMOTION || this.caR) {
                if (next.Dk() != EmotionGroupType.USER_COLLECT || this.caS) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.caN = g.acy().acA();
        if (!this.caR || !this.caS) {
            this.caO = aco();
            if (!this.caS && this.caN != null) {
                this.caN = new ArrayList<>(g.acy().acA());
                int i = 0;
                while (true) {
                    if (i < this.caN.size()) {
                        if (this.caN.get(i).Dk() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.caN.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.caO = g.acy().acA();
        }
        if ((this.caN == null || this.caN.size() <= 0) && this.caT < 3) {
            this.caT++;
            g.acy().acz();
            return;
        }
        this.caL.setDatas(this.caN);
        int size = this.caN.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.caN.get(i3);
            if (this.caP != null && this.caP.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.SH);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apS) {
            this.apS = skinType;
            onChangeSkinType(this.apS);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.caL.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.caO.size() && i != this.aEq) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.caO.get(i);
            this.caK.h(this.caO, i);
            if (this.caQ) {
                if (cVar.Dk() == EmotionGroupType.LOCAL) {
                    this.caL.setShowDelete(true);
                } else {
                    this.caL.setShowDelete(false);
                }
            }
            this.caL.setCurrentTab(i);
            this.aEq = i;
            this.caP = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aEq = -1;
        this.caN.clear();
        this.caK.reset();
        this.caL.reset();
    }

    public void setIsInChat(boolean z) {
        this.caQ = z;
        this.caL.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.caR = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eT(int i) {
        if (i >= 0 && i < this.caN.size() && i != this.aEq && this.caK != null) {
            this.caK.m11if(i);
            this.aEq = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.caL.onChangeSkinType(i);
        this.caK.onChangeSkinType(i);
        aj.e(this.caM, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void ig(int i) {
        if (this.caL != null && i != this.aEq) {
            this.caL.setCurrentTab(i);
            this.aEq = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.caO.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dj()) {
                                    arrayList.add(next);
                                }
                            }
                            this.caK.h(arrayList, 0);
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
        this.Jp = iVar;
        this.caK.setOnDataSelected(iVar);
        this.caL.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        if (this.caL != null) {
            int size = this.caN.size();
            for (int i = 0; i < size; i++) {
                this.caL.m(i, this.caR);
            }
            this.caL.setTabWidgetBigEmontionVisibility(this.caR);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
