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
    private int aEn;
    private int apQ;
    private EmotionTabContentView cbC;
    private EmotionTabWidgetView cbD;
    private View cbE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbF;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbG;
    private String cbH;
    private boolean cbI;
    private boolean cbJ;
    private boolean cbK;
    private int cbL;

    public b(Context context) {
        super(context);
        this.cbF = new ArrayList<>();
        this.cbG = new ArrayList<>();
        this.aEn = -1;
        this.cbH = null;
        this.apQ = -1;
        this.cbJ = true;
        this.cbK = true;
        this.cbL = 0;
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
        this.cbC = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.cbD = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.cbE = findViewById(d.h.emotion_tab_widget_div_line);
        this.cbD.setOnTabSelectedListener(this);
        this.cbC.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apQ = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.apQ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cbD != null) {
            this.cbD.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cbK = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> acz() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.acJ().acL().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dk() != EmotionGroupType.BIG_EMOTION || this.cbJ) {
                if (next.Dk() != EmotionGroupType.USER_COLLECT || this.cbK) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cbF = g.acJ().acL();
        if (!this.cbJ || !this.cbK) {
            this.cbG = acz();
            if (!this.cbK && this.cbF != null) {
                this.cbF = new ArrayList<>(g.acJ().acL());
                int i = 0;
                while (true) {
                    if (i < this.cbF.size()) {
                        if (this.cbF.get(i).Dk() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cbF.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cbG = g.acJ().acL();
        }
        if ((this.cbF == null || this.cbF.size() <= 0) && this.cbL < 3) {
            this.cbL++;
            g.acJ().acK();
            return;
        }
        this.cbD.setDatas(this.cbF);
        int size = this.cbF.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbF.get(i3);
            if (this.cbH != null && this.cbH.equals(cVar.getGroupId())) {
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
        if (skinType != this.apQ) {
            this.apQ = skinType;
            onChangeSkinType(this.apQ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbD.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cbG.size() && i != this.aEn) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbG.get(i);
            this.cbC.h(this.cbG, i);
            if (this.cbI) {
                if (cVar.Dk() == EmotionGroupType.LOCAL) {
                    this.cbD.setShowDelete(true);
                } else {
                    this.cbD.setShowDelete(false);
                }
            }
            this.cbD.setCurrentTab(i);
            this.aEn = i;
            this.cbH = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aEn = -1;
        this.cbF.clear();
        this.cbC.reset();
        this.cbD.reset();
    }

    public void setIsInChat(boolean z) {
        this.cbI = z;
        this.cbD.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.cbJ = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eT(int i) {
        if (i >= 0 && i < this.cbF.size() && i != this.aEn && this.cbC != null) {
            this.cbC.ih(i);
            this.aEn = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.cbD.onChangeSkinType(i);
        this.cbC.onChangeSkinType(i);
        aj.e(this.cbE, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void ii(int i) {
        if (this.cbD != null && i != this.aEn) {
            this.cbD.setCurrentTab(i);
            this.aEn = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbG.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dj()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cbC.h(arrayList, 0);
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
        this.cbC.setOnDataSelected(iVar);
        this.cbD.setOnDataSelected(iVar);
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
        if (this.cbD != null) {
            int size = this.cbF.size();
            for (int i = 0; i < size; i++) {
                this.cbD.m(i, this.cbJ);
            }
            this.cbD.setTabWidgetBigEmontionVisibility(this.cbJ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
