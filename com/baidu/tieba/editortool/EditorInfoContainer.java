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
    protected y aqm;
    private k aqn;
    private k aqo;
    private k aqp;
    private k aqq;
    private final CustomMessageListener aqr;

    public EditorInfoContainer(Context context) {
        this(context, null);
    }

    public EditorInfoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqr = new i(this, 2010041);
        setOrientation(0);
        int dimension = (int) context.getResources().getDimension(com.baidu.tieba.t.ds20);
        setPadding(dimension, 0, dimension, 0);
        setGravity(48);
        this.aqm = new y(context);
        this.aqn = new k(context);
        this.aqo = new k(context);
        this.aqp = new k(context);
        this.aqp.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aqq = new k(context);
        this.aqq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16);
        addView(this.aqm, layoutParams);
        addView(this.aqn, layoutParams);
        addView(this.aqo, layoutParams);
        addView(this.aqp, layoutParams);
        addView(this.aqq, layoutParams);
        this.aqn.setVisibility(8);
        this.aqo.setVisibility(8);
        this.aqp.setVisibility(8);
        this.aqq.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof BaseActivity) {
            this.aqr.setTag(((BaseActivity) getContext()).getUniqueId());
        } else if (getContext() instanceof BaseFragmentActivity) {
            this.aqr.setTag(((BaseFragmentActivity) getContext()).getUniqueId());
        }
        this.aqr.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aqr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aqr);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.t.ds62));
    }

    public y getLocationInfoView() {
        return this.aqm;
    }

    public void a(ba baVar) {
        if (baVar != null) {
            if (baVar.ash > 0) {
                this.aqn.setVisibility(0);
                this.aqn.setText(String.valueOf(baVar.ash));
            } else {
                this.aqn.setVisibility(8);
            }
            if (baVar.asi > 0) {
                this.aqo.setVisibility(0);
                this.aqo.setText(String.valueOf(baVar.ash));
            } else {
                this.aqo.setVisibility(8);
            }
            if (baVar.asj > 0) {
                this.aqp.setVisibility(0);
                this.aqp.setText(String.valueOf(baVar.asj + baVar.asl));
            } else {
                this.aqp.setVisibility(8);
            }
            if (baVar.ask > 0) {
                this.aqq.setVisibility(0);
                this.aqq.setText(String.valueOf(baVar.ask));
                return;
            }
            this.aqq.setVisibility(8);
        }
    }

    public void sD() {
        TbadkApplication.m251getInst().getSkinType();
        if (this.aqm != null) {
            this.aqm.nz();
        }
        if (this.aqn != null) {
            this.aqn.nz();
        }
        if (this.aqo != null) {
            this.aqo.nz();
        }
        if (this.aqp != null) {
            this.aqp.nz();
            this.aqp.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_camers_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.aqq != null) {
            this.aqq.nz();
            this.aqq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_microphone_gray), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
