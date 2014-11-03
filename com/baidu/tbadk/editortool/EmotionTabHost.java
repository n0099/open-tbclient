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
    private int RH;
    private int RO;
    private EmotionTabContentView Sa;
    private EmotionTabWidgetView Sb;
    private ArrayList<ad> Sc;
    private String Sd;
    private boolean Se;
    private boolean Sf;
    private CustomMessageListener Sg;

    public EmotionTabHost(Context context) {
        super(context);
        this.Sc = new ArrayList<>();
        this.RO = -1;
        this.Sd = null;
        this.RH = -1;
        this.Sf = true;
        this.Sg = new r(this, 2001120);
        init(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Sc = new ArrayList<>();
        this.RO = -1;
        this.Sd = null;
        this.RH = -1;
        this.Sf = true;
        this.Sg = new r(this, 2001120);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.emotion_tab_host, this, true);
        this.Sa = (EmotionTabContentView) findViewById(com.baidu.tieba.v.face_tab_content);
        this.Sb = (EmotionTabWidgetView) findViewById(com.baidu.tieba.v.face_tab_widget);
        this.Sb.setOnTabSelectedListener(this);
        setOrientation(1);
        this.RH = TbadkApplication.m251getInst().getSkinType();
        onChangeSkinType(this.RH);
        setup();
    }

    public void setFrom(int i) {
        if (this.Sb != null) {
            this.Sb.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.Sc = aa.rB().rD();
        this.Sb.setDatas(this.Sc);
        int size = this.Sc.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = this.Sc.get(i2);
            if (this.Sd != null && this.Sd.equals(adVar.getGroupId())) {
                i = i2;
            }
            e(adVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Sg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Sg);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType != this.RH) {
            this.RH = skinType;
            onChangeSkinType(this.RH);
        }
    }

    private void e(ad adVar) {
        this.Sb.d(adVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.Sc.size() && i != this.RO) {
            ad adVar = this.Sc.get(i);
            this.Sa.b(adVar);
            if (this.Se) {
                if (adVar.rt() == EmotionGroupType.LOCAL) {
                    this.Sb.setShowDelete(true);
                } else {
                    this.Sb.setShowDelete(false);
                }
            }
            this.Sb.setCurrentTab(i);
            this.RO = i;
            this.Sd = adVar.getGroupId();
        }
    }

    public void reset() {
        this.RO = -1;
        this.Sc.clear();
        this.Sa.reset();
        this.Sb.reset();
    }

    public void setIsInChat(boolean z) {
        this.Se = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.Sf = z;
        if (!this.Sf) {
            int size = this.Sc.size();
            for (int i = 0; i < size; i++) {
                this.Sb.f(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.t
    public void cH(int i) {
        setCurrentEmotionGroup(i);
    }

    public void onChangeSkinType(int i) {
        this.Sb.onChangeSkinType(i);
        this.Sa.onChangeSkinType(i);
    }

    public void setOnDataSelected(w wVar) {
        this.Sa.setOnDataSelected(wVar);
        this.Sb.setOnDataSelected(wVar);
    }
}
