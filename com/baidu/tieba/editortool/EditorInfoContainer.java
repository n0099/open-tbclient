package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class EditorInfoContainer extends LinearLayout {
    protected y aqd;
    private k aqe;
    private k aqf;
    private k aqg;
    private k aqh;
    private final CustomMessageListener aqi;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqi = new i(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(com.baidu.tieba.t.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.aqd = new y(context);
        this.aqe = new k(context);
        this.aqf = new k(context);
        this.aqg = new k(context);
        this.aqg.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aqh = new k(context);
        this.aqh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16);
        addView(this.aqd, layoutParams);
        addView(this.aqe, layoutParams);
        addView(this.aqf, layoutParams);
        addView(this.aqg, layoutParams);
        addView(this.aqh, layoutParams);
        this.aqe.setVisibility(8);
        this.aqf.setVisibility(8);
        this.aqg.setVisibility(8);
        this.aqh.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof BaseActivity) {
            this.aqi.setTag(((BaseActivity) getContext()).getUniqueId());
        } else if (getContext() instanceof BaseFragmentActivity) {
            this.aqi.setTag(((BaseFragmentActivity) getContext()).getUniqueId());
        }
        this.aqi.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aqi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aqi);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.t.ds62));
    }

    public y getLocationInfoView() {
        return this.aqd;
    }

    public void a(ba baVar) {
        if (baVar != null) {
            if (baVar.arY > 0) {
                this.aqe.setVisibility(0);
                this.aqe.setText(String.valueOf(baVar.arY));
            } else {
                this.aqe.setVisibility(8);
            }
            if (baVar.arZ > 0) {
                this.aqf.setVisibility(0);
                this.aqf.setText(String.valueOf(baVar.arY));
            } else {
                this.aqf.setVisibility(8);
            }
            if (baVar.asa > 0) {
                this.aqg.setVisibility(0);
                this.aqg.setText(String.valueOf(baVar.asa + baVar.asc));
            } else {
                this.aqg.setVisibility(8);
            }
            if (baVar.asb > 0) {
                this.aqh.setVisibility(0);
                this.aqh.setText(String.valueOf(baVar.asb));
                return;
            }
            this.aqh.setVisibility(8);
        }
    }

    public void sB() {
        TbadkApplication.m251getInst().getSkinType();
        if (this.aqd != null) {
            this.aqd.nz();
        }
        if (this.aqe != null) {
            this.aqe.nz();
        }
        if (this.aqf != null) {
            this.aqf.nz();
        }
        if (this.aqg != null) {
            this.aqg.nz();
            this.aqg.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.aqh != null) {
            this.aqh.nz();
            this.aqh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
