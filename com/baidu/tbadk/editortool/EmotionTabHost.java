package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements t {
    private CustomMessageListener CL;
    private EmotionTabContentView YC;
    private EmotionTabWidgetView YD;
    private ArrayList<ae> YE;
    private String YF;
    private boolean YG;
    private boolean YH;
    private int YI;
    private int Yk;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.YE = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.YF = null;
        this.Yk = -1;
        this.YH = true;
        this.YI = 0;
        this.CL = new r(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YE = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.YF = null;
        this.Yk = -1;
        this.YH = true;
        this.YI = 0;
        this.CL = new r(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.emotion_tab_host, this, true);
        this.YC = (EmotionTabContentView) findViewById(com.baidu.tieba.w.face_tab_content);
        this.YD = (EmotionTabWidgetView) findViewById(com.baidu.tieba.w.face_tab_widget);
        this.YD.setOnTabSelectedListener(this);
        setOrientation(1);
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        onChangeSkinType(this.Yk);
        setup();
    }

    public void setFrom(int i) {
        if (this.YD != null) {
            this.YD.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.YE = ab.vt().vv();
        if ((this.YE == null || this.YE.size() <= 0) && this.YI < 3) {
            this.YI++;
            ab.vt().vu();
            return;
        }
        this.YD.setDatas(this.YE);
        int size = this.YE.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ae aeVar = this.YE.get(i2);
            if (this.YF != null && this.YF.equals(aeVar.getGroupId())) {
                i = i2;
            }
            e(aeVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.CL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.CL);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.Yk) {
            this.Yk = skinType;
            onChangeSkinType(this.Yk);
        }
    }

    private void e(ae aeVar) {
        this.YD.d(aeVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.YE.size() && i != this.mCurrentIndex) {
            ae aeVar = this.YE.get(i);
            this.YC.b(aeVar);
            if (this.YG) {
                if (aeVar.vl() == EmotionGroupType.LOCAL) {
                    this.YD.setShowDelete(true);
                } else {
                    this.YD.setShowDelete(false);
                }
            }
            this.YD.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.YF = aeVar.getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.YE.clear();
        this.YC.reset();
        this.YD.reset();
    }

    public void setIsInChat(boolean z) {
        this.YG = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.YH = z;
        if (!this.YH) {
            int size = this.YE.size();
            for (int i = 0; i < size; i++) {
                this.YD.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.t
    public void dm(int i) {
        setCurrentEmotionGroup(i);
    }

    public void onChangeSkinType(int i) {
        this.YD.onChangeSkinType(i);
        this.YC.onChangeSkinType(i);
    }

    public void setOnDataSelected(w wVar) {
        this.YC.setOnDataSelected(wVar);
        this.YD.setOnDataSelected(wVar);
    }
}
