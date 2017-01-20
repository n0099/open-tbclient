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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.y, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int DW;
    private com.baidu.tbadk.editortools.j DX;
    private CustomMessageListener Ns;
    private int ahp;
    private int awg;
    private EmotionTabContentView bvX;
    private EmotionTabWidgetView bvY;
    private View bvZ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bwa;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bwb;
    private String bwc;
    private boolean bwd;
    private boolean bwe;
    private int bwf;

    public p(Context context) {
        super(context);
        this.bwa = new ArrayList<>();
        this.bwb = new ArrayList<>();
        this.awg = -1;
        this.bwc = null;
        this.ahp = -1;
        this.bwe = true;
        this.bwf = 0;
        this.DW = 0;
        this.Ns = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(r.j.emotion_tab_host, (ViewGroup) this, true);
        this.bvX = (EmotionTabContentView) findViewById(r.h.face_tab_content);
        this.bvY = (EmotionTabWidgetView) findViewById(r.h.face_tab_widget);
        this.bvZ = findViewById(r.h.emotion_tab_widget_div_line);
        this.bvY.setOnTabSelectedListener(this);
        this.bvX.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ahp = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.ahp);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bvY != null) {
            this.bvY.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> TL() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.TV().TX().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CM() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bwa = x.TV().TX();
        if (!this.bwe) {
            this.bwb = TL();
        } else {
            this.bwb = x.TV().TX();
        }
        if ((this.bwa == null || this.bwa.size() <= 0) && this.bwf < 3) {
            this.bwf++;
            x.TV().TW();
            return;
        }
        this.bvY.setDatas(this.bwa);
        int size = this.bwa.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bwa.get(i2);
            if (this.bwc != null && this.bwc.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Ns);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Ns);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahp) {
            this.ahp = skinType;
            onChangeSkinType(this.ahp);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bvY.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bwb.size() && i != this.awg) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bwb.get(i);
            this.bvX.g(this.bwb, i);
            if (this.bwd) {
                if (cVar.CM() == EmotionGroupType.LOCAL) {
                    this.bvY.setShowDelete(true);
                } else {
                    this.bvY.setShowDelete(false);
                }
            }
            this.bvY.setCurrentTab(i);
            this.awg = i;
            this.bwc = cVar.getGroupId();
        }
    }

    public void reset() {
        this.awg = -1;
        this.bwa.clear();
        this.bvX.reset();
        this.bvY.reset();
    }

    public void setIsInChat(boolean z) {
        this.bwd = z;
        this.bvY.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bwe = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eS(int i) {
        if (i >= 0 && i < this.bwa.size() && i != this.awg && this.bvX != null) {
            this.bvX.hd(i);
            this.awg = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bvY.onChangeSkinType(i);
        this.bvX.onChangeSkinType(i);
        ap.e(this.bvZ, r.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void he(int i) {
        if (this.bvY != null && i != this.awg) {
            this.bvY.setCurrentTab(i);
            this.awg = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bwb.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CL()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bvX.g(arrayList, 0);
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
        this.DX = jVar;
        this.bvX.setOnDataSelected(jVar);
        this.bvY.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lr() {
        if (this.bvY != null) {
            int size = this.bwa.size();
            for (int i = 0; i < size; i++) {
                this.bvY.l(i, this.bwe);
            }
            this.bvY.setTabWidgetBigEmontionVisibility(this.bwe);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
