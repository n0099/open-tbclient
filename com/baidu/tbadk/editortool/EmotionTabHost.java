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
    private CustomMessageListener Os;
    private EmotionTabContentView aiM;
    private EmotionTabWidgetView aiN;
    private View aiO;
    private ArrayList<ad> aiP;
    private String aiQ;
    private boolean aiR;
    private boolean aiS;
    private int aiT;
    private int aiq;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.aiP = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aiQ = null;
        this.aiq = -1;
        this.aiS = true;
        this.aiT = 0;
        this.Os = new q(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiP = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.aiQ = null;
        this.aiq = -1;
        this.aiS = true;
        this.aiT = 0;
        this.Os = new q(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.emotion_tab_host, this, true);
        this.aiM = (EmotionTabContentView) findViewById(com.baidu.tieba.v.face_tab_content);
        this.aiN = (EmotionTabWidgetView) findViewById(com.baidu.tieba.v.face_tab_widget);
        this.aiO = findViewById(com.baidu.tieba.v.emotion_tab_widget_div_line);
        this.aiN.setOnTabSelectedListener(this);
        this.aiM.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.aiq);
        setup();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aiN != null) {
            this.aiN.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aiP = aa.yL().yN();
        if ((this.aiP == null || this.aiP.size() <= 0) && this.aiT < 3) {
            this.aiT++;
            aa.yL().yM();
            return;
        }
        this.aiN.setDatas(this.aiP);
        int size = this.aiP.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = this.aiP.get(i2);
            if (this.aiQ != null && this.aiQ.equals(adVar.getGroupId())) {
                i = i2;
            }
            d(adVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Os);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Os);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aiq) {
            this.aiq = skinType;
            onChangeSkinType(this.aiq);
        }
    }

    private void d(ad adVar) {
        this.aiN.c(adVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aiP.size() && i != this.mCurrentIndex) {
            ad adVar = this.aiP.get(i);
            this.aiM.b(this.aiP, i);
            if (this.aiR) {
                if (adVar.yI() == EmotionGroupType.LOCAL) {
                    this.aiN.setShowDelete(true);
                } else {
                    this.aiN.setShowDelete(false);
                }
            }
            this.aiN.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.aiQ = adVar.getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.aiP.clear();
        this.aiM.reset();
        this.aiN.reset();
    }

    public void setIsInChat(boolean z) {
        this.aiR = z;
        this.aiN.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aiS = z;
        if (!this.aiS) {
            int size = this.aiP.size();
            for (int i = 0; i < size; i++) {
                this.aiN.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.s
    public void dr(int i) {
        if (i >= 0 && i < this.aiP.size() && i != this.mCurrentIndex && this.aiM != null) {
            this.aiM.dp(i);
            this.mCurrentIndex = i;
        }
    }

    public void onChangeSkinType(int i) {
        this.aiN.onChangeSkinType(i);
        this.aiM.onChangeSkinType(i);
        ba.d(this.aiO, com.baidu.tieba.s.emotion_tab_div_line_color, i);
    }

    public void setOnDataSelected(v vVar) {
        this.aiM.setOnDataSelected(vVar);
        this.aiN.setOnDataSelected(vVar);
    }

    @Override // com.baidu.tbadk.editortool.j
    public void dq(int i) {
        if (this.aiN != null && i != this.mCurrentIndex) {
            this.aiN.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }
}
