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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements ab, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int EK;
    private com.baidu.tbadk.editortools.l EL;
    private CustomMessageListener Ol;
    private int aiA;
    private int axF;
    private EmotionTabContentView bIh;
    private EmotionTabWidgetView bIi;
    private View bIj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bIk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bIl;
    private String bIm;
    private boolean bIn;
    private boolean bIo;
    private int bIp;

    public p(Context context) {
        super(context);
        this.bIk = new ArrayList<>();
        this.bIl = new ArrayList<>();
        this.axF = -1;
        this.bIm = null;
        this.aiA = -1;
        this.bIo = true;
        this.bIp = 0;
        this.EK = 0;
        this.Ol = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.emotion_tab_host, (ViewGroup) this, true);
        this.bIh = (EmotionTabContentView) findViewById(r.g.face_tab_content);
        this.bIi = (EmotionTabWidgetView) findViewById(r.g.face_tab_widget);
        this.bIj = findViewById(r.g.emotion_tab_widget_div_line);
        this.bIi.setOnTabSelectedListener(this);
        this.bIh.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aiA = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.aiA);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bIi != null) {
            this.bIi.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Ye() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Yo().Yq().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Di() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bIk = x.Yo().Yq();
        if (!this.bIo) {
            this.bIl = Ye();
        } else {
            this.bIl = x.Yo().Yq();
        }
        if ((this.bIk == null || this.bIk.size() <= 0) && this.bIp < 3) {
            this.bIp++;
            x.Yo().Yp();
            return;
        }
        this.bIi.setDatas(this.bIk);
        int size = this.bIk.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bIk.get(i2);
            if (this.bIm != null && this.bIm.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Ol);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Ol);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aiA) {
            this.aiA = skinType;
            onChangeSkinType(this.aiA);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bIi.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bIl.size() && i != this.axF) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bIl.get(i);
            this.bIh.h(this.bIl, i);
            if (this.bIn) {
                if (cVar.Di() == EmotionGroupType.LOCAL) {
                    this.bIi.setShowDelete(true);
                } else {
                    this.bIi.setShowDelete(false);
                }
            }
            this.bIi.setCurrentTab(i);
            this.axF = i;
            this.bIm = cVar.getGroupId();
        }
    }

    public void reset() {
        this.axF = -1;
        this.bIk.clear();
        this.bIh.reset();
        this.bIi.reset();
    }

    public void setIsInChat(boolean z) {
        this.bIn = z;
        this.bIi.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bIo = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eQ(int i) {
        if (i >= 0 && i < this.bIk.size() && i != this.axF && this.bIh != null) {
            this.bIh.hh(i);
            this.axF = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.bIi.onChangeSkinType(i);
        this.bIh.onChangeSkinType(i);
        at.e(this.bIj, r.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hi(int i) {
        if (this.bIi != null && i != this.axF) {
            this.bIi.setCurrentTab(i);
            this.axF = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bIl.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dh()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bIh.h(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
        this.bIh.setOnDataSelected(lVar);
        this.bIi.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lz() {
        if (this.bIi != null) {
            int size = this.bIk.size();
            for (int i = 0; i < size; i++) {
                this.bIi.z(i, this.bIo);
            }
            this.bIi.setTabWidgetBigEmontionVisibility(this.bIo);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
