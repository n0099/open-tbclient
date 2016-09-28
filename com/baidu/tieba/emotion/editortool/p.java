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
import com.baidu.tbadk.core.util.av;
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
    private int EI;
    private com.baidu.tbadk.editortools.l EJ;
    private CustomMessageListener Oi;
    private int ahV;
    private int awO;
    private EmotionTabContentView bFn;
    private EmotionTabWidgetView bFo;
    private View bFp;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFq;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFr;
    private String bFs;
    private boolean bFt;
    private boolean bFu;
    private int bFv;

    public p(Context context) {
        super(context);
        this.bFq = new ArrayList<>();
        this.bFr = new ArrayList<>();
        this.awO = -1;
        this.bFs = null;
        this.ahV = -1;
        this.bFu = true;
        this.bFv = 0;
        this.EI = 0;
        this.Oi = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(r.h.emotion_tab_host, (ViewGroup) this, true);
        this.bFn = (EmotionTabContentView) findViewById(r.g.face_tab_content);
        this.bFo = (EmotionTabWidgetView) findViewById(r.g.face_tab_widget);
        this.bFp = findViewById(r.g.emotion_tab_widget_div_line);
        this.bFo.setOnTabSelectedListener(this);
        this.bFn.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ahV = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.ahV);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bFo != null) {
            this.bFo.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Xc() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Xm().Xo().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Da() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bFq = x.Xm().Xo();
        if (!this.bFu) {
            this.bFr = Xc();
        } else {
            this.bFr = x.Xm().Xo();
        }
        if ((this.bFq == null || this.bFq.size() <= 0) && this.bFv < 3) {
            this.bFv++;
            x.Xm().Xn();
            return;
        }
        this.bFo.setDatas(this.bFq);
        int size = this.bFq.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFq.get(i2);
            if (this.bFs != null && this.bFs.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Oi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Oi);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahV) {
            this.ahV = skinType;
            onChangeSkinType(this.ahV);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFo.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bFr.size() && i != this.awO) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFr.get(i);
            this.bFn.h(this.bFr, i);
            if (this.bFt) {
                if (cVar.Da() == EmotionGroupType.LOCAL) {
                    this.bFo.setShowDelete(true);
                } else {
                    this.bFo.setShowDelete(false);
                }
            }
            this.bFo.setCurrentTab(i);
            this.awO = i;
            this.bFs = cVar.getGroupId();
        }
    }

    public void reset() {
        this.awO = -1;
        this.bFq.clear();
        this.bFn.reset();
        this.bFo.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFt = z;
        this.bFo.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bFu = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eN(int i) {
        if (i >= 0 && i < this.bFq.size() && i != this.awO && this.bFn != null) {
            this.bFn.hg(i);
            this.awO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.bFo.onChangeSkinType(i);
        this.bFn.onChangeSkinType(i);
        av.e(this.bFp, r.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hh(int i) {
        if (this.bFo != null && i != this.awO) {
            this.bFo.setCurrentTab(i);
            this.awO = i;
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
        this.EJ = lVar;
        this.bFn.setOnDataSelected(lVar);
        this.bFo.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        if (this.bFo != null) {
            int size = this.bFq.size();
            for (int i = 0; i < size; i++) {
                this.bFo.z(i, this.bFu);
            }
            this.bFo.setTabWidgetBigEmontionVisibility(this.bFu);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
