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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements ab, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int LD;
    private com.baidu.tbadk.editortools.l LE;
    private CustomMessageListener Rf;
    private EmotionTabContentView aZP;
    private EmotionTabWidgetView aZQ;
    private View aZR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aZS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aZT;
    private String aZU;
    private boolean aZV;
    private boolean aZW;
    private int aZX;
    private int aik;
    private int awy;

    public p(Context context) {
        super(context);
        this.aZS = new ArrayList<>();
        this.aZT = new ArrayList<>();
        this.awy = -1;
        this.aZU = null;
        this.aik = -1;
        this.aZW = true;
        this.aZX = 0;
        this.LD = 0;
        this.Rf = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.emotion_tab_host, (ViewGroup) this, true);
        this.aZP = (EmotionTabContentView) findViewById(t.g.face_tab_content);
        this.aZQ = (EmotionTabWidgetView) findViewById(t.g.face_tab_widget);
        this.aZR = findViewById(t.g.emotion_tab_widget_div_line);
        this.aZQ.setOnTabSelectedListener(this);
        this.aZP.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aik = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.aik);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aZQ != null) {
            this.aZQ.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Nd() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Nn().Np().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DB() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aZS = x.Nn().Np();
        if (!this.aZW) {
            this.aZT = Nd();
        } else {
            this.aZT = x.Nn().Np();
        }
        if ((this.aZS == null || this.aZS.size() <= 0) && this.aZX < 3) {
            this.aZX++;
            x.Nn().No();
            return;
        }
        this.aZQ.setDatas(this.aZS);
        int size = this.aZS.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aZS.get(i2);
            if (this.aZU != null && this.aZU.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Rf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Rf);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aik) {
            this.aik = skinType;
            onChangeSkinType(this.aik);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aZQ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aZT.size() && i != this.awy) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aZT.get(i);
            this.aZP.f(this.aZT, i);
            if (this.aZV) {
                if (cVar.DB() == EmotionGroupType.LOCAL) {
                    this.aZQ.setShowDelete(true);
                } else {
                    this.aZQ.setShowDelete(false);
                }
            }
            this.aZQ.setCurrentTab(i);
            this.awy = i;
            this.aZU = cVar.getGroupId();
        }
    }

    public void reset() {
        this.awy = -1;
        this.aZS.clear();
        this.aZP.reset();
        this.aZQ.reset();
    }

    public void setIsInChat(boolean z) {
        this.aZV = z;
        this.aZQ.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aZW = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eQ(int i) {
        if (i >= 0 && i < this.aZS.size() && i != this.awy && this.aZP != null) {
            this.aZP.fU(i);
            this.awy = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.aZQ.onChangeSkinType(i);
        this.aZP.onChangeSkinType(i);
        at.d(this.aZR, t.d.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void fV(int i) {
        if (this.aZQ != null && i != this.awy) {
            this.aZQ.setCurrentTab(i);
            this.awy = i;
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

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
        this.aZP.setOnDataSelected(lVar);
        this.aZQ.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void op() {
        if (!this.aZW) {
            int size = this.aZS.size();
            for (int i = 0; i < size; i++) {
                this.aZQ.h(i, this.aZW);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
