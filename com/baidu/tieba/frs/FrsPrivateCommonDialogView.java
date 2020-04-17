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
    private TextView aWP;
    private Context context;
    private TbImageView dDz;
    private TextView gza;
    private TextView hbt;
    private RelativeLayout hbu;
    private TextView hbv;
    private TextView hbw;
    private TextView hbx;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aJJ() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aJJ() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aJM();
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(str, true);
        if (privateForumPopInfoData.aJJ().equals("task_complete")) {
            this.hbu.setVisibility(0);
            this.hbt.setVisibility(8);
        } else {
            this.hbu.setVisibility(8);
            this.hbt.setVisibility(0);
        }
        if (privateForumPopInfoData.aJJ().equals("create_success")) {
            this.aWP.setVisibility(0);
            this.aWP.setText(R.string.frs_private_create_title);
            this.hbt.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDz, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aJJ().equals("left_time")) {
            this.aWP.setVisibility(8);
            this.hbt.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDz, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aJJ().equals("clear_forum")) {
            this.aWP.setVisibility(8);
            this.hbt.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDz, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aJJ().equals("task_complete")) {
            return false;
        } else {
            this.aWP.setVisibility(0);
            this.aWP.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDz, R.drawable.pic_frs_private_target_success);
        }
        this.gza.setText(privateForumPopInfoData.aJK());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hbt.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.dDz = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.aWP = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.gza = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.hbt = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.hbu = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.hbv = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.hbw = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.hbx = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.dDz);
        setTextAttribute(Arrays.asList(this.hbv, this.hbw, this.hbx));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aWP, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gza, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.c(this.hbt, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hbt, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.dDz.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
