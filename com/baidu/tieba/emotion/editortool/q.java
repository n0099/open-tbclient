package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.y, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int KL;
    private com.baidu.tbadk.editortools.j KM;
    private CustomMessageListener SO;
    private int aBR;
    private int amZ;
    private EmotionTabContentView bCW;
    private EmotionTabWidgetView bCX;
    private View bCY;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bCZ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDa;
    private String bDb;
    private boolean bDc;
    private boolean bDd;
    private int bDe;

    public q(Context context) {
        super(context);
        this.bCZ = new ArrayList<>();
        this.bDa = new ArrayList<>();
        this.aBR = -1;
        this.bDb = null;
        this.amZ = -1;
        this.bDd = true;
        this.bDe = 0;
        this.KL = 0;
        this.SO = new r(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_host, (ViewGroup) this, true);
        this.bCW = (EmotionTabContentView) findViewById(w.h.face_tab_content);
        this.bCX = (EmotionTabWidgetView) findViewById(w.h.face_tab_widget);
        this.bCY = findViewById(w.h.emotion_tab_widget_div_line);
        this.bCX.setOnTabSelectedListener(this);
        this.bCW.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.amZ = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.amZ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bCX != null) {
            this.bCX.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Vh() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Vr().Vt().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DC() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bCZ = x.Vr().Vt();
        if (!this.bDd) {
            this.bDa = Vh();
        } else {
            this.bDa = x.Vr().Vt();
        }
        if ((this.bCZ == null || this.bCZ.size() <= 0) && this.bDe < 3) {
            this.bDe++;
            x.Vr().Vs();
            return;
        }
        this.bCX.setDatas(this.bCZ);
        int size = this.bCZ.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bCZ.get(i2);
            if (this.bDb != null && this.bDb.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.SO);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amZ) {
            this.amZ = skinType;
            onChangeSkinType(this.amZ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bCX.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bDa.size() && i != this.aBR) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bDa.get(i);
            this.bCW.h(this.bDa, i);
            if (this.bDc) {
                if (cVar.DC() == EmotionGroupType.LOCAL) {
                    this.bCX.setShowDelete(true);
                } else {
                    this.bCX.setShowDelete(false);
                }
            }
            this.bCX.setCurrentTab(i);
            this.aBR = i;
            this.bDb = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aBR = -1;
        this.bCZ.clear();
        this.bCW.reset();
        this.bCX.reset();
    }

    public void setIsInChat(boolean z) {
        this.bDc = z;
        this.bCX.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bDd = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eQ(int i) {
        if (i >= 0 && i < this.bCZ.size() && i != this.aBR && this.bCW != null) {
            this.bCW.hc(i);
            this.aBR = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bCX.onChangeSkinType(i);
        this.bCW.onChangeSkinType(i);
        aq.e(this.bCY, w.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hd(int i) {
        if (this.bCX != null && i != this.aBR) {
            this.bCX.setCurrentTab(i);
            this.aBR = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDa.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.DB()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bCW.h(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
        this.bCW.setOnDataSelected(jVar);
        this.bCX.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KM != null) {
            this.KM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KL;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        if (this.bCX != null) {
            int size = this.bCZ.size();
            for (int i = 0; i < size; i++) {
                this.bCX.l(i, this.bDd);
            }
            this.bCX.setTabWidgetBigEmontionVisibility(this.bDd);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
