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
    private int Kf;
    private com.baidu.tbadk.editortools.j Kg;
    private CustomMessageListener Sj;
    private int aBS;
    private int ane;
    private boolean bFA;
    private boolean bFB;
    private int bFC;
    private EmotionTabContentView bFu;
    private EmotionTabWidgetView bFv;
    private View bFw;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFx;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFy;
    private String bFz;

    public q(Context context) {
        super(context);
        this.bFx = new ArrayList<>();
        this.bFy = new ArrayList<>();
        this.aBS = -1;
        this.bFz = null;
        this.ane = -1;
        this.bFB = true;
        this.bFC = 0;
        this.Kf = 0;
        this.Sj = new r(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_host, (ViewGroup) this, true);
        this.bFu = (EmotionTabContentView) findViewById(w.h.face_tab_content);
        this.bFv = (EmotionTabWidgetView) findViewById(w.h.face_tab_widget);
        this.bFw = findViewById(w.h.emotion_tab_widget_div_line);
        this.bFv.setOnTabSelectedListener(this);
        this.bFu.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ane = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.ane);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bFv != null) {
            this.bFv.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> VD() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.VN().VP().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CG() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bFx = x.VN().VP();
        if (!this.bFB) {
            this.bFy = VD();
        } else {
            this.bFy = x.VN().VP();
        }
        if ((this.bFx == null || this.bFx.size() <= 0) && this.bFC < 3) {
            this.bFC++;
            x.VN().VO();
            return;
        }
        this.bFv.setDatas(this.bFx);
        int size = this.bFx.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFx.get(i2);
            if (this.bFz != null && this.bFz.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Sj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Sj);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ane) {
            this.ane = skinType;
            onChangeSkinType(this.ane);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFv.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bFy.size() && i != this.aBS) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFy.get(i);
            this.bFu.h(this.bFy, i);
            if (this.bFA) {
                if (cVar.CG() == EmotionGroupType.LOCAL) {
                    this.bFv.setShowDelete(true);
                } else {
                    this.bFv.setShowDelete(false);
                }
            }
            this.bFv.setCurrentTab(i);
            this.aBS = i;
            this.bFz = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aBS = -1;
        this.bFx.clear();
        this.bFu.reset();
        this.bFv.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFA = z;
        this.bFv.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bFB = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eM(int i) {
        if (i >= 0 && i < this.bFx.size() && i != this.aBS && this.bFu != null) {
            this.bFu.hf(i);
            this.aBS = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bFv.onChangeSkinType(i);
        this.bFu.onChangeSkinType(i);
        aq.e(this.bFw, w.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hg(int i) {
        if (this.bFv != null && i != this.aBS) {
            this.bFv.setCurrentTab(i);
            this.aBS = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFy.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CF()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bFu.h(arrayList, 0);
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
        this.Kg = jVar;
        this.bFu.setOnDataSelected(jVar);
        this.bFv.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        if (this.bFv != null) {
            int size = this.bFx.size();
            for (int i = 0; i < size; i++) {
                this.bFv.l(i, this.bFB);
            }
            this.bFv.setTabWidgetBigEmontionVisibility(this.bFB);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
