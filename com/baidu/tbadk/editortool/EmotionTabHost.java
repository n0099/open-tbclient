package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements j, s {
    private CustomMessageListener OQ;
    private EmotionTabContentView ajT;
    private EmotionTabWidgetView ajU;
    private View ajV;
    private ArrayList<ad> ajW;
    private String ajX;
    private boolean ajY;
    private boolean ajZ;
    private int ajy;
    private int aka;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.ajW = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ajX = null;
        this.ajy = -1;
        this.ajZ = true;
        this.aka = 0;
        this.OQ = new q(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajW = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.ajX = null;
        this.ajy = -1;
        this.ajZ = true;
        this.aka = 0;
        this.OQ = new q(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.emotion_tab_host, this, true);
        this.ajT = (EmotionTabContentView) findViewById(com.baidu.tieba.q.face_tab_content);
        this.ajU = (EmotionTabWidgetView) findViewById(com.baidu.tieba.q.face_tab_widget);
        this.ajV = findViewById(com.baidu.tieba.q.emotion_tab_widget_div_line);
        this.ajU.setOnTabSelectedListener(this);
        this.ajT.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.ajy);
        setup();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.ajU != null) {
            this.ajU.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ajW = aa.zF().zH();
        if ((this.ajW == null || this.ajW.size() <= 0) && this.aka < 3) {
            this.aka++;
            aa.zF().zG();
            return;
        }
        this.ajU.setDatas(this.ajW);
        int size = this.ajW.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = this.ajW.get(i2);
            if (this.ajX != null && this.ajX.equals(adVar.getGroupId())) {
                i = i2;
            }
            d(adVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.OQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.OQ);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ajy) {
            this.ajy = skinType;
            onChangeSkinType(this.ajy);
        }
    }

    private void d(ad adVar) {
        this.ajU.c(adVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.ajW.size() && i != this.mCurrentIndex) {
            ad adVar = this.ajW.get(i);
            this.ajT.b(this.ajW, i);
            if (this.ajY) {
                if (adVar.zC() == EmotionGroupType.LOCAL) {
                    this.ajU.setShowDelete(true);
                } else {
                    this.ajU.setShowDelete(false);
                }
            }
            this.ajU.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.ajX = adVar.getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ajW.clear();
        this.ajT.reset();
        this.ajU.reset();
    }

    public void setIsInChat(boolean z) {
        this.ajY = z;
        this.ajU.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.ajZ = z;
        if (!this.ajZ) {
            int size = this.ajW.size();
            for (int i = 0; i < size; i++) {
                this.ajU.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.s
    public void dA(int i) {
        if (i >= 0 && i < this.ajW.size() && i != this.mCurrentIndex && this.ajT != null) {
            this.ajT.dy(i);
            this.mCurrentIndex = i;
        }
    }

    public void onChangeSkinType(int i) {
        this.ajU.onChangeSkinType(i);
        this.ajT.onChangeSkinType(i);
        ay.d(this.ajV, com.baidu.tieba.n.emotion_tab_div_line_color, i);
    }

    public void setOnDataSelected(v vVar) {
        this.ajT.setOnDataSelected(vVar);
        this.ajU.setOnDataSelected(vVar);
    }

    @Override // com.baidu.tbadk.editortool.j
    public void dz(int i) {
        if (this.ajU != null && i != this.mCurrentIndex) {
            this.ajU.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }
}
