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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.y, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int EL;
    private com.baidu.tbadk.editortools.j EM;
    private CustomMessageListener Oh;
    private int aib;
    private int axc;
    private EmotionTabContentView bok;
    private EmotionTabWidgetView bol;
    private View bom;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bon;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> boo;
    private String bop;
    private boolean boq;
    private boolean bor;
    private int bos;

    public p(Context context) {
        super(context);
        this.bon = new ArrayList<>();
        this.boo = new ArrayList<>();
        this.axc = -1;
        this.bop = null;
        this.aib = -1;
        this.bor = true;
        this.bos = 0;
        this.EL = 0;
        this.Oh = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.emotion_tab_host, (ViewGroup) this, true);
        this.bok = (EmotionTabContentView) findViewById(r.g.face_tab_content);
        this.bol = (EmotionTabWidgetView) findViewById(r.g.face_tab_widget);
        this.bom = findViewById(r.g.emotion_tab_widget_div_line);
        this.bol.setOnTabSelectedListener(this);
        this.bok.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aib = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.aib);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bol != null) {
            this.bol.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Sp() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Sz().SB().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CR() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bon = x.Sz().SB();
        if (!this.bor) {
            this.boo = Sp();
        } else {
            this.boo = x.Sz().SB();
        }
        if ((this.bon == null || this.bon.size() <= 0) && this.bos < 3) {
            this.bos++;
            x.Sz().SA();
            return;
        }
        this.bol.setDatas(this.bon);
        int size = this.bon.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bon.get(i2);
            if (this.bop != null && this.bop.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Oh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Oh);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aib) {
            this.aib = skinType;
            onChangeSkinType(this.aib);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bol.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.boo.size() && i != this.axc) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.boo.get(i);
            this.bok.g(this.boo, i);
            if (this.boq) {
                if (cVar.CR() == EmotionGroupType.LOCAL) {
                    this.bol.setShowDelete(true);
                } else {
                    this.bol.setShowDelete(false);
                }
            }
            this.bol.setCurrentTab(i);
            this.axc = i;
            this.bop = cVar.getGroupId();
        }
    }

    public void reset() {
        this.axc = -1;
        this.bon.clear();
        this.bok.reset();
        this.bol.reset();
    }

    public void setIsInChat(boolean z) {
        this.boq = z;
        this.bol.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bor = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eR(int i) {
        if (i >= 0 && i < this.bon.size() && i != this.axc && this.bok != null) {
            this.bok.gr(i);
            this.axc = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bol.onChangeSkinType(i);
        this.bok.onChangeSkinType(i);
        ar.e(this.bom, r.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void gs(int i) {
        if (this.bol != null && i != this.axc) {
            this.bol.setCurrentTab(i);
            this.axc = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.boo.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CQ()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bok.g(arrayList, 0);
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
        this.EM = jVar;
        this.bok.setOnDataSelected(jVar);
        this.bol.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lz() {
        if (this.bol != null) {
            int size = this.bon.size();
            for (int i = 0; i < size; i++) {
                this.bol.m(i, this.bor);
            }
            this.bol.setTabWidgetBigEmontionVisibility(this.bor);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
