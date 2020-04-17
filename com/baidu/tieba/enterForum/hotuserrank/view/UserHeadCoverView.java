package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.b;
/* loaded from: classes9.dex */
public class UserHeadCoverView extends FrameLayout {
    private ImageView gDF;
    private View gDG;
    private ImageView gDH;

    public UserHeadCoverView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.gDF = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds78);
        addView(this.gDF, new FrameLayout.LayoutParams(dimens, dimens));
        this.gDG = new View(context);
        int dimens2 = l.getDimens(context, R.dimen.tbds158);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens2);
        int dimens3 = l.getDimens(context, R.dimen.tbds26);
        layoutParams.leftMargin = dimens3;
        layoutParams.topMargin = dimens3;
        addView(this.gDG, layoutParams);
        this.gDH = new ImageView(context);
        int dimens4 = l.getDimens(context, R.dimen.tbds36);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens4, dimens4);
        layoutParams2.gravity = 85;
        addView(this.gDH, layoutParams2);
    }

    public void setData(b bVar) {
        if (bVar != null) {
            if (bVar.rankNum != null) {
                if (bVar.rankNum.equals("1") || bVar.rankNum.equals("2") || bVar.rankNum.equals("3")) {
                    this.gDF.setVisibility(0);
                    this.gDG.setVisibility(0);
                    if (bVar.rankNum.equals("1")) {
                        SvgManager.aOU().a(this.gDF, R.drawable.svg_icon_mask_first30, (SvgManager.SvgResourceStateType) null);
                        this.gDG.setBackground(am.getDrawable(R.drawable.shape_hot_user_yellow_circle));
                    } else if (bVar.rankNum.equals("2")) {
                        SvgManager.aOU().a(this.gDF, R.drawable.svg_icon_mask_second30, (SvgManager.SvgResourceStateType) null);
                        this.gDG.setBackground(am.getDrawable(R.drawable.shape_hot_user_gray_circle));
                    } else if (bVar.rankNum.equals("3")) {
                        SvgManager.aOU().a(this.gDF, R.drawable.svg_icon_mask_third30, (SvgManager.SvgResourceStateType) null);
                        this.gDG.setBackground(am.getDrawable(R.drawable.shape_hot_user_brown_circle));
                    }
                } else {
                    this.gDF.setVisibility(8);
                    this.gDG.setVisibility(8);
                }
            } else {
                this.gDF.setVisibility(8);
                this.gDG.setVisibility(8);
            }
            if (bVar.gDy) {
                this.gDH.setVisibility(0);
                SvgManager.aOU().a(this.gDH, R.drawable.ic_icon_mask_v14_n_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            this.gDH.setVisibility(8);
        }
    }
}
