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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements z, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int Lw;
    private com.baidu.tbadk.editortools.k Lx;
    private CustomMessageListener TI;
    private EmotionTabContentView aVh;
    private EmotionTabWidgetView aVi;
    private View aVj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVl;
    private String aVm;
    private boolean aVn;
    private boolean aVo;
    private int aVp;
    private int ahU;
    private int avR;

    public p(Context context) {
        super(context);
        this.aVk = new ArrayList<>();
        this.aVl = new ArrayList<>();
        this.avR = -1;
        this.aVm = null;
        this.ahU = -1;
        this.aVo = true;
        this.aVp = 0;
        this.Lw = 0;
        this.TI = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.emotion_tab_host, (ViewGroup) this, true);
        this.aVh = (EmotionTabContentView) findViewById(t.g.face_tab_content);
        this.aVi = (EmotionTabWidgetView) findViewById(t.g.face_tab_widget);
        this.aVj = findViewById(t.g.emotion_tab_widget_div_line);
        this.aVi.setOnTabSelectedListener(this);
        this.aVh.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ahU = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.ahU);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aVi != null) {
            this.aVi.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Lp() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Lz().LB().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CT() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aVk = x.Lz().LB();
        if (!this.aVo) {
            this.aVl = Lp();
        } else {
            this.aVl = x.Lz().LB();
        }
        if ((this.aVk == null || this.aVk.size() <= 0) && this.aVp < 3) {
            this.aVp++;
            x.Lz().LA();
            return;
        }
        this.aVi.setDatas(this.aVk);
        int size = this.aVk.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aVk.get(i2);
            if (this.aVm != null && this.aVm.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TI);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahU) {
            this.ahU = skinType;
            onChangeSkinType(this.ahU);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aVi.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aVl.size() && i != this.avR) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aVl.get(i);
            this.aVh.c(this.aVl, i);
            if (this.aVn) {
                if (cVar.CT() == EmotionGroupType.LOCAL) {
                    this.aVi.setShowDelete(true);
                } else {
                    this.aVi.setShowDelete(false);
                }
            }
            this.aVi.setCurrentTab(i);
            this.avR = i;
            this.aVm = cVar.getGroupId();
        }
    }

    public void reset() {
        this.avR = -1;
        this.aVk.clear();
        this.aVh.reset();
        this.aVi.reset();
    }

    public void setIsInChat(boolean z) {
        this.aVn = z;
        this.aVi.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aVo = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eK(int i) {
        if (i >= 0 && i < this.aVk.size() && i != this.avR && this.aVh != null) {
            this.aVh.fE(i);
            this.avR = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        this.aVi.onChangeSkinType(i);
        this.aVh.onChangeSkinType(i);
        ar.d(this.aVj, t.d.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void fF(int i) {
        if (this.aVi != null && i != this.avR) {
            this.aVi.setCurrentTab(i);
            this.avR = i;
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

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
        this.aVh.setOnDataSelected(kVar);
        this.aVi.setOnDataSelected(kVar);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        if (!this.aVo) {
            int size = this.aVk.size();
            for (int i = 0; i < size; i++) {
                this.aVi.h(i, this.aVo);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }
}
