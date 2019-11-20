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
    private TextView aqd;
    private TbImageView clX;
    private Context context;
    private TextView eZk;
    private TextView fxB;
    private RelativeLayout fxC;
    private TextView fxD;
    private TextView fxE;
    private TextView fxF;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.ahH() == null) {
            return false;
        }
        String str = privateForumPopInfoData.ahH() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.ahK();
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(str, true);
        if (privateForumPopInfoData.ahH().equals("task_complete")) {
            this.fxC.setVisibility(0);
            this.fxB.setVisibility(8);
        } else {
            this.fxC.setVisibility(8);
            this.fxB.setVisibility(0);
        }
        if (privateForumPopInfoData.ahH().equals("create_success")) {
            this.aqd.setVisibility(0);
            this.aqd.setText(R.string.frs_private_create_title);
            this.fxB.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.clX, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.ahH().equals("left_time")) {
            this.aqd.setVisibility(8);
            this.fxB.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.clX, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.ahH().equals("clear_forum")) {
            this.aqd.setVisibility(8);
            this.fxB.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.clX, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.ahH().equals("task_complete")) {
            return false;
        } else {
            this.aqd.setVisibility(0);
            this.aqd.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.clX, R.drawable.pic_frs_private_target_success);
        }
        this.eZk.setText(privateForumPopInfoData.ahI());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.fxB.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.clX = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.aqd = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.eZk = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.fxB = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.fxC = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.fxD = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.fxE = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.fxF = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.clX);
        setTextAttribute(Arrays.asList(this.fxD, this.fxE, this.fxF));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aqd, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.eZk, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.d(this.fxB, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fxB, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.clX.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
