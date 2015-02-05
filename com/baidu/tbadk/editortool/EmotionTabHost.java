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
    private CustomMessageListener CI;
    private EmotionTabWidgetView YA;
    private ArrayList<ae> YB;
    private String YC;
    private boolean YD;
    private boolean YE;
    private int YF;
    private int Yh;
    private EmotionTabContentView Yz;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.YB = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.YC = null;
        this.Yh = -1;
        this.YE = true;
        this.YF = 0;
        this.CI = new r(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YB = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.YC = null;
        this.Yh = -1;
        this.YE = true;
        this.YF = 0;
        this.CI = new r(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.emotion_tab_host, this, true);
        this.Yz = (EmotionTabContentView) findViewById(com.baidu.tieba.w.face_tab_content);
        this.YA = (EmotionTabWidgetView) findViewById(com.baidu.tieba.w.face_tab_widget);
        this.YA.setOnTabSelectedListener(this);
        setOrientation(1);
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        onChangeSkinType(this.Yh);
        setup();
    }

    public void setFrom(int i) {
        if (this.YA != null) {
            this.YA.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.YB = ab.vn().vp();
        if ((this.YB == null || this.YB.size() <= 0) && this.YF < 3) {
            this.YF++;
            ab.vn().vo();
            return;
        }
        this.YA.setDatas(this.YB);
        int size = this.YB.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ae aeVar = this.YB.get(i2);
            if (this.YC != null && this.YC.equals(aeVar.getGroupId())) {
                i = i2;
            }
            e(aeVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.CI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.CI);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (skinType != this.Yh) {
            this.Yh = skinType;
            onChangeSkinType(this.Yh);
        }
    }

    private void e(ae aeVar) {
        this.YA.d(aeVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.YB.size() && i != this.mCurrentIndex) {
            ae aeVar = this.YB.get(i);
            this.Yz.b(aeVar);
            if (this.YD) {
                if (aeVar.vf() == EmotionGroupType.LOCAL) {
                    this.YA.setShowDelete(true);
                } else {
                    this.YA.setShowDelete(false);
                }
            }
            this.YA.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.YC = aeVar.getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.YB.clear();
        this.Yz.reset();
        this.YA.reset();
    }

    public void setIsInChat(boolean z) {
        this.YD = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.YE = z;
        if (!this.YE) {
            int size = this.YB.size();
            for (int i = 0; i < size; i++) {
                this.YA.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.t
    public void dm(int i) {
        setCurrentEmotionGroup(i);
    }

    public void onChangeSkinType(int i) {
        this.YA.onChangeSkinType(i);
        this.Yz.onChangeSkinType(i);
    }

    public void setOnDataSelected(w wVar) {
        this.Yz.setOnDataSelected(wVar);
        this.YA.setOnDataSelected(wVar);
    }
}
