package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    private TextView aCT;
    private Context context;
    private TbImageView ddA;
    private TextView fTy;
    private TextView grk;
    private RelativeLayout grl;
    private TextView grm;
    private TextView grn;
    private TextView gro;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aBt() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aBt() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aBw();
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(str, true);
        if (privateForumPopInfoData.aBt().equals("task_complete")) {
            this.grl.setVisibility(0);
            this.grk.setVisibility(8);
        } else {
            this.grl.setVisibility(8);
            this.grk.setVisibility(0);
        }
        if (privateForumPopInfoData.aBt().equals("create_success")) {
            this.aCT.setVisibility(0);
            this.aCT.setText(R.string.frs_private_create_title);
            this.grk.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddA, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aBt().equals("left_time")) {
            this.aCT.setVisibility(8);
            this.grk.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddA, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aBt().equals("clear_forum")) {
            this.aCT.setVisibility(8);
            this.grk.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddA, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aBt().equals("task_complete")) {
            return false;
        } else {
            this.aCT.setVisibility(0);
            this.aCT.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddA, R.drawable.pic_frs_private_target_success);
        }
        this.fTy.setText(privateForumPopInfoData.aBu());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.grk.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.ddA = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.aCT = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.fTy = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.grk = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.grl = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.grm = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.grn = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.gro = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.ddA);
        setTextAttribute(Arrays.asList(this.grm, this.grn, this.gro));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aCT, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fTy, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.b(this.grk, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.grk, (int) R.color.cp_cont_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, (int) R.color.cp_cont_f);
        }
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int equipmentWidth;
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.context) - (dimens * 2);
        } else {
            equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.context) - (dimens * 2);
        }
        ViewGroup.LayoutParams layoutParams = this.ddA.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
