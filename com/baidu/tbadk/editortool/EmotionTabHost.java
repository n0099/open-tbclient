package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements t {
    private int RD;
    private int RK;
    private EmotionTabContentView RW;
    private EmotionTabWidgetView RX;
    private ArrayList<ad> RY;
    private String RZ;
    private boolean Sa;
    private boolean Sb;
    private CustomMessageListener Sc;

    public EmotionTabHost(Context context) {
        super(context);
        this.RY = new ArrayList<>();
        this.RK = -1;
        this.RZ = null;
        this.RD = -1;
        this.Sb = true;
        this.Sc = new r(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RY = new ArrayList<>();
        this.RK = -1;
        this.RZ = null;
        this.RD = -1;
        this.Sb = true;
        this.Sc = new r(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.emotion_tab_host, this, true);
        this.RW = (EmotionTabContentView) findViewById(com.baidu.tieba.v.face_tab_content);
        this.RX = (EmotionTabWidgetView) findViewById(com.baidu.tieba.v.face_tab_widget);
        this.RX.setOnTabSelectedListener(this);
        setOrientation(1);
        this.RD = TbadkApplication.m251getInst().getSkinType();
        onChangeSkinType(this.RD);
        setup();
    }

    public void setFrom(int i) {
        if (this.RX != null) {
            this.RX.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.RY = aa.rz().rB();
        this.RX.setDatas(this.RY);
        int size = this.RY.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = this.RY.get(i2);
            if (this.RZ != null && this.RZ.equals(adVar.getGroupId())) {
                i = i2;
            }
            e(adVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Sc);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Sc);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType != this.RD) {
            this.RD = skinType;
            onChangeSkinType(this.RD);
        }
    }

    private void e(ad adVar) {
        this.RX.d(adVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.RY.size() && i != this.RK) {
            ad adVar = this.RY.get(i);
            this.RW.b(adVar);
            if (this.Sa) {
                if (adVar.rr() == EmotionGroupType.LOCAL) {
                    this.RX.setShowDelete(true);
                } else {
                    this.RX.setShowDelete(false);
                }
            }
            this.RX.setCurrentTab(i);
            this.RK = i;
            this.RZ = adVar.getGroupId();
        }
    }

    public void reset() {
        this.RK = -1;
        this.RY.clear();
        this.RW.reset();
        this.RX.reset();
    }

    public void setIsInChat(boolean z) {
        this.Sa = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.Sb = z;
        if (!this.Sb) {
            int size = this.RY.size();
            for (int i = 0; i < size; i++) {
                this.RX.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.t
    public void cH(int i) {
        setCurrentEmotionGroup(i);
    }

    public void onChangeSkinType(int i) {
        this.RX.onChangeSkinType(i);
        this.RW.onChangeSkinType(i);
    }

    public void setOnDataSelected(w wVar) {
        this.RW.setOnDataSelected(wVar);
        this.RX.setOnDataSelected(wVar);
    }
}
