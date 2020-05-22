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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.b;
/* loaded from: classes9.dex */
public class UserHeadCoverView extends FrameLayout {
    private ImageView gSu;
    private View gSv;
    private ImageView gSw;

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
        this.gSu = new ImageView(context);
        int dimens = l.getDimens(context, R.dimen.tbds78);
        addView(this.gSu, new FrameLayout.LayoutParams(dimens, dimens));
        this.gSv = new View(context);
        int dimens2 = l.getDimens(context, R.dimen.tbds158);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens2);
        int dimens3 = l.getDimens(context, R.dimen.tbds26);
        layoutParams.leftMargin = dimens3;
        layoutParams.topMargin = dimens3;
        addView(this.gSv, layoutParams);
        this.gSw = new ImageView(context);
        int dimens4 = l.getDimens(context, R.dimen.tbds36);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens4, dimens4);
        layoutParams2.gravity = 85;
        addView(this.gSw, layoutParams2);
    }

    public void setData(b bVar) {
        if (bVar != null) {
            if (bVar.rankNum != null) {
                if (bVar.rankNum.equals("1") || bVar.rankNum.equals("2") || bVar.rankNum.equals("3")) {
                    this.gSu.setVisibility(0);
                    this.gSv.setVisibility(0);
                    if (bVar.rankNum.equals("1")) {
                        SvgManager.aUV().a(this.gSu, R.drawable.svg_icon_mask_first30, (SvgManager.SvgResourceStateType) null);
                        this.gSv.setBackground(am.getDrawable(R.drawable.shape_hot_user_yellow_circle));
                    } else if (bVar.rankNum.equals("2")) {
                        SvgManager.aUV().a(this.gSu, R.drawable.svg_icon_mask_second30, (SvgManager.SvgResourceStateType) null);
                        this.gSv.setBackground(am.getDrawable(R.drawable.shape_hot_user_gray_circle));
                    } else if (bVar.rankNum.equals("3")) {
                        SvgManager.aUV().a(this.gSu, R.drawable.svg_icon_mask_third30, (SvgManager.SvgResourceStateType) null);
                        this.gSv.setBackground(am.getDrawable(R.drawable.shape_hot_user_brown_circle));
                    }
                } else {
                    this.gSu.setVisibility(8);
                    this.gSv.setVisibility(8);
                }
            } else {
                this.gSu.setVisibility(8);
                this.gSv.setVisibility(8);
            }
            if (bVar.gSn) {
                int dimens = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds36);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.gravity = 85;
                this.gSw.setLayoutParams(layoutParams);
                this.gSw.setVisibility(0);
                SvgManager.aUV().a(this.gSw, R.drawable.ic_icon_mask_v14_n_svg, (SvgManager.SvgResourceStateType) null);
            } else if (bVar.gSa) {
                int dimens2 = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds40);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens2, dimens2);
                layoutParams2.gravity = 85;
                this.gSw.setLayoutParams(layoutParams2);
                this.gSw.setVisibility(0);
                SvgManager.aUV().a(this.gSw, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                this.gSw.setVisibility(8);
            }
        }
    }
}
