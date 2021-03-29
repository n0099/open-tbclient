package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.i0.i.c.b;
/* loaded from: classes4.dex */
public class UserHeadCoverView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15465e;

    /* renamed from: f  reason: collision with root package name */
    public View f15466f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15467g;

    public UserHeadCoverView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f15465e = new ImageView(context);
        int g2 = l.g(context, R.dimen.tbds78);
        addView(this.f15465e, new FrameLayout.LayoutParams(g2, g2));
        this.f15466f = new View(context);
        int g3 = l.g(context, R.dimen.tbds158);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g3);
        int g4 = l.g(context, R.dimen.tbds26);
        layoutParams.leftMargin = g4;
        layoutParams.topMargin = g4;
        addView(this.f15466f, layoutParams);
        this.f15467g = new ImageView(context);
        int g5 = l.g(context, R.dimen.tbds36);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(g5, g5);
        layoutParams2.gravity = 85;
        addView(this.f15467g, layoutParams2);
    }

    public void setData(b bVar) {
        if (bVar == null) {
            return;
        }
        String str = bVar.f55600a;
        if (str != null) {
            if (!str.equals("1") && !bVar.f55600a.equals("2") && !bVar.f55600a.equals("3")) {
                this.f15465e.setVisibility(8);
                this.f15466f.setVisibility(8);
            } else {
                this.f15465e.setVisibility(0);
                this.f15466f.setVisibility(0);
                if (bVar.f55600a.equals("1")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f15465e, R.drawable.svg_icon_mask_first30, null);
                    this.f15466f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_yellow_circle));
                } else if (bVar.f55600a.equals("2")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f15465e, R.drawable.svg_icon_mask_second30, null);
                    this.f15466f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_gray_circle));
                } else if (bVar.f55600a.equals("3")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f15465e, R.drawable.svg_icon_mask_third30, null);
                    this.f15466f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_brown_circle));
                }
            }
        } else {
            this.f15465e.setVisibility(8);
            this.f15466f.setVisibility(8);
        }
        if (bVar.f55606g) {
            int g2 = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 85;
            this.f15467g.setLayoutParams(layoutParams);
            this.f15467g.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f15467g, R.drawable.ic_icon_mask_v14_n_svg, null);
        } else if (bVar.f55607h) {
            int g3 = l.g(TbadkApplication.getInst(), R.dimen.tbds40);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(g3, g3);
            layoutParams2.gravity = 85;
            this.f15467g.setLayoutParams(layoutParams2);
            this.f15467g.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f15467g, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            this.f15467g.setVisibility(8);
        }
    }

    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
