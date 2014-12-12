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
    private int XE;
    private EmotionTabContentView XW;
    private EmotionTabWidgetView XX;
    private ArrayList<ae> XY;
    private String XZ;
    private boolean Ya;
    private boolean Yb;
    private int Yc;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.XY = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.XZ = null;
        this.XE = -1;
        this.Yb = true;
        this.Yc = 0;
        this.CL = new r(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XY = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.XZ = null;
        this.XE = -1;
        this.Yb = true;
        this.Yc = 0;
        this.CL = new r(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.emotion_tab_host, this, true);
        this.XW = (EmotionTabContentView) findViewById(com.baidu.tieba.w.face_tab_content);
        this.XX = (EmotionTabWidgetView) findViewById(com.baidu.tieba.w.face_tab_widget);
        this.XX.setOnTabSelectedListener(this);
        setOrientation(1);
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        onChangeSkinType(this.XE);
        setup();
    }

    public void setFrom(int i) {
        if (this.XX != null) {
            this.XX.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.XY = ab.vc().ve();
        if ((this.XY == null || this.XY.size() <= 0) && this.Yc < 3) {
            this.Yc++;
            ab.vc().vd();
            return;
        }
        this.XX.setDatas(this.XY);
        int size = this.XY.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ae aeVar = this.XY.get(i2);
            if (this.XZ != null && this.XZ.equals(aeVar.getGroupId())) {
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
        if (skinType != this.XE) {
            this.XE = skinType;
            onChangeSkinType(this.XE);
        }
    }

    private void e(ae aeVar) {
        this.XX.d(aeVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.XY.size() && i != this.mCurrentIndex) {
            ae aeVar = this.XY.get(i);
            this.XW.b(aeVar);
            if (this.Ya) {
                if (aeVar.uU() == EmotionGroupType.LOCAL) {
                    this.XX.setShowDelete(true);
                } else {
                    this.XX.setShowDelete(false);
                }
            }
            this.XX.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.XZ = aeVar.getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.XY.clear();
        this.XW.reset();
        this.XX.reset();
    }

    public void setIsInChat(boolean z) {
        this.Ya = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.Yb = z;
        if (!this.Yb) {
            int size = this.XY.size();
            for (int i = 0; i < size; i++) {
                this.XX.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.t
    public void df(int i) {
        setCurrentEmotionGroup(i);
    }

    public void onChangeSkinType(int i) {
        this.XX.onChangeSkinType(i);
        this.XW.onChangeSkinType(i);
    }

    public void setOnDataSelected(w wVar) {
        this.XW.setOnDataSelected(wVar);
        this.XX.setOnDataSelected(wVar);
    }
}
