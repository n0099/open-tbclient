package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.b;
/* loaded from: classes16.dex */
public class UserHeadCoverView extends FrameLayout {
    private ImageView hkY;
    private View hkZ;
    private ImageView hla;

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
        this.hkY = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds78);
        addView(this.hkY, new FrameLayout.LayoutParams(dimens, dimens));
        this.hkZ = new View(context);
        int dimens2 = l.getDimens(context, R.dimen.tbds158);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens2);
        int dimens3 = l.getDimens(context, R.dimen.tbds26);
        layoutParams.leftMargin = dimens3;
        layoutParams.topMargin = dimens3;
        addView(this.hkZ, layoutParams);
        this.hla = new ImageView(context);
        int dimens4 = l.getDimens(context, R.dimen.tbds36);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens4, dimens4);
        layoutParams2.gravity = 85;
        addView(this.hla, layoutParams2);
    }

    public void setData(b bVar) {
        if (bVar != null) {
            if (bVar.rankNum != null) {
                if (bVar.rankNum.equals("1") || bVar.rankNum.equals("2") || bVar.rankNum.equals("3")) {
                    this.hkY.setVisibility(0);
                    this.hkZ.setVisibility(0);
                    if (bVar.rankNum.equals("1")) {
                        SvgManager.baR().a(this.hkY, R.drawable.svg_icon_mask_first30, (SvgManager.SvgResourceStateType) null);
                        this.hkZ.setBackground(ao.getDrawable(R.drawable.shape_hot_user_yellow_circle));
                    } else if (bVar.rankNum.equals("2")) {
                        SvgManager.baR().a(this.hkY, R.drawable.svg_icon_mask_second30, (SvgManager.SvgResourceStateType) null);
                        this.hkZ.setBackground(ao.getDrawable(R.drawable.shape_hot_user_gray_circle));
                    } else if (bVar.rankNum.equals("3")) {
                        SvgManager.baR().a(this.hkY, R.drawable.svg_icon_mask_third30, (SvgManager.SvgResourceStateType) null);
                        this.hkZ.setBackground(ao.getDrawable(R.drawable.shape_hot_user_brown_circle));
                    }
                } else {
                    this.hkY.setVisibility(8);
                    this.hkZ.setVisibility(8);
                }
            } else {
                this.hkY.setVisibility(8);
                this.hkZ.setVisibility(8);
            }
            if (bVar.hkR) {
                int dimens = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.gravity = 85;
                this.hla.setLayoutParams(layoutParams);
                this.hla.setVisibility(0);
                SvgManager.baR().a(this.hla, R.drawable.ic_icon_mask_v14_n_svg, (SvgManager.SvgResourceStateType) null);
            } else if (bVar.hkE) {
                int dimens2 = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds40);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens2, dimens2);
                layoutParams2.gravity = 85;
                this.hla.setLayoutParams(layoutParams2);
                this.hla.setVisibility(0);
                SvgManager.baR().a(this.hla, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                this.hla.setVisibility(8);
            }
        }
    }
}
