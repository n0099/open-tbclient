package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements j, s {
    private CustomMessageListener Ou;
    private EmotionTabContentView aiU;
    private EmotionTabWidgetView aiV;
    private View aiW;
    private ArrayList<ad> aiX;
    private String aiY;
    private boolean aiZ;
    private int aiy;
    private boolean aja;
    private int ajb;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.aiX = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aiY = null;
        this.aiy = -1;
        this.aja = true;
        this.ajb = 0;
        this.Ou = new q(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiX = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aiY = null;
        this.aiy = -1;
        this.aja = true;
        this.ajb = 0;
        this.Ou = new q(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.emotion_tab_host, this, true);
        this.aiU = (EmotionTabContentView) findViewById(com.baidu.tieba.v.face_tab_content);
        this.aiV = (EmotionTabWidgetView) findViewById(com.baidu.tieba.v.face_tab_widget);
        this.aiW = findViewById(com.baidu.tieba.v.emotion_tab_widget_div_line);
        this.aiV.setOnTabSelectedListener(this);
        this.aiU.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aiy = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.aiy);
        setup();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aiV != null) {
            this.aiV.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aiX = aa.yR().yT();
        if ((this.aiX == null || this.aiX.size() <= 0) && this.ajb < 3) {
            this.ajb++;
            aa.yR().yS();
            return;
        }
        this.aiV.setDatas(this.aiX);
        int size = this.aiX.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = this.aiX.get(i2);
            if (this.aiY != null && this.aiY.equals(adVar.getGroupId())) {
                i = i2;
            }
            d(adVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Ou);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Ou);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aiy) {
            this.aiy = skinType;
            onChangeSkinType(this.aiy);
        }
    }

    private void d(ad adVar) {
        this.aiV.c(adVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aiX.size() && i != this.mCurrentIndex) {
            ad adVar = this.aiX.get(i);
            this.aiU.b(this.aiX, i);
            if (this.aiZ) {
                if (adVar.yO() == EmotionGroupType.LOCAL) {
                    this.aiV.setShowDelete(true);
                } else {
                    this.aiV.setShowDelete(false);
                }
            }
            this.aiV.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.aiY = adVar.getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.aiX.clear();
        this.aiU.reset();
        this.aiV.reset();
    }

    public void setIsInChat(boolean z) {
        this.aiZ = z;
        this.aiV.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aja = z;
        if (!this.aja) {
            int size = this.aiX.size();
            for (int i = 0; i < size; i++) {
                this.aiV.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.s
    public void dr(int i) {
        if (i >= 0 && i < this.aiX.size() && i != this.mCurrentIndex && this.aiU != null) {
            this.aiU.dp(i);
            this.mCurrentIndex = i;
        }
    }

    public void onChangeSkinType(int i) {
        this.aiV.onChangeSkinType(i);
        this.aiU.onChangeSkinType(i);
        ba.d(this.aiW, com.baidu.tieba.s.emotion_tab_div_line_color, i);
    }

    public void setOnDataSelected(v vVar) {
        this.aiU.setOnDataSelected(vVar);
        this.aiV.setOnDataSelected(vVar);
    }

    @Override // com.baidu.tbadk.editortool.j
    public void dq(int i) {
        if (this.aiV != null && i != this.mCurrentIndex) {
            this.aiV.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }
}
