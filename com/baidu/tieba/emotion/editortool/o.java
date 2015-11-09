package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class o extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.x, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int KA;
    private com.baidu.tbadk.editortools.j KB;
    private CustomMessageListener Tt;
    private EmotionTabContentView aKJ;
    private EmotionTabWidgetView aKK;
    private View aKL;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aKM;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aKN;
    private String aKO;
    private boolean aKP;
    private boolean aKQ;
    private int aKR;
    private int arf;
    private int aru;

    public o(Context context) {
        super(context);
        this.aKM = new ArrayList<>();
        this.aKN = new ArrayList<>();
        this.aru = -1;
        this.aKO = null;
        this.arf = -1;
        this.aKQ = true;
        this.aKR = 0;
        this.KA = 0;
        this.Tt = new p(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.emotion_tab_host, (ViewGroup) this, true);
        this.aKJ = (EmotionTabContentView) findViewById(i.f.face_tab_content);
        this.aKK = (EmotionTabWidgetView) findViewById(i.f.face_tab_widget);
        this.aKL = findViewById(i.f.emotion_tab_widget_div_line);
        this.aKK.setOnTabSelectedListener(this);
        this.aKJ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.arf = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.arf);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aKK != null) {
            this.aKK.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> HR() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = w.Ib().Id().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.AP() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aKM = w.Ib().Id();
        if (!this.aKQ) {
            this.aKN = HR();
        } else {
            this.aKN = w.Ib().Id();
        }
        if ((this.aKM == null || this.aKM.size() <= 0) && this.aKR < 3) {
            this.aKR++;
            w.Ib().Ic();
            return;
        }
        this.aKK.setDatas(this.aKM);
        int size = this.aKM.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aKM.get(i2);
            if (this.aKO != null && this.aKO.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Tt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Tt);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.arf) {
            this.arf = skinType;
            onChangeSkinType(this.arf);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aKK.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aKN.size() && i != this.aru) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aKN.get(i);
            this.aKJ.c(this.aKN, i);
            if (this.aKP) {
                if (cVar.AP() == EmotionGroupType.LOCAL) {
                    this.aKK.setShowDelete(true);
                } else {
                    this.aKK.setShowDelete(false);
                }
            }
            this.aKK.setCurrentTab(i);
            this.aru = i;
            this.aKO = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aru = -1;
        this.aKM.clear();
        this.aKJ.reset();
        this.aKK.reset();
    }

    public void setIsInChat(boolean z) {
        this.aKP = z;
        this.aKK.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aKQ = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ei(int i) {
        if (i >= 0 && i < this.aKM.size() && i != this.aru && this.aKJ != null) {
            this.aKJ.eV(i);
            this.aru = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        this.aKK.onChangeSkinType(i);
        this.aKJ.onChangeSkinType(i);
        an.d(this.aKL, i.c.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void eW(int i) {
        if (this.aKK != null && i != this.aru) {
            this.aKK.setCurrentTab(i);
            this.aru = i;
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
                case TbConfig.FRS_NOABSTRACT_ITEM_NUMBER /* 35 */:
                    if (aVar.data instanceof Boolean) {
                        setShowBigEmotion(((Boolean) aVar.data).booleanValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KB = jVar;
        this.aKJ.setOnDataSelected(jVar);
        this.aKK.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.KA = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.KA;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        if (!this.aKQ) {
            int size = this.aKM.size();
            for (int i = 0; i < size; i++) {
                this.aKK.h(i, this.aKQ);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }
}
