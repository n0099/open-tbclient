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
    private TextView bjS;
    private Context context;
    private TbImageView eeU;
    private TextView hJf;
    private RelativeLayout hJg;
    private TextView hJh;
    private TextView hJi;
    private TextView hJj;
    private TextView hgC;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aVk() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aVk() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aVn();
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(str, true);
        if (privateForumPopInfoData.aVk().equals("task_complete")) {
            this.hJg.setVisibility(0);
            this.hJf.setVisibility(8);
        } else {
            this.hJg.setVisibility(8);
            this.hJf.setVisibility(0);
        }
        if (privateForumPopInfoData.aVk().equals("create_success")) {
            this.bjS.setVisibility(0);
            this.bjS.setText(R.string.frs_private_create_title);
            this.hJf.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.eeU, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aVk().equals("left_time")) {
            this.bjS.setVisibility(8);
            this.hJf.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.eeU, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aVk().equals("clear_forum")) {
            this.bjS.setVisibility(8);
            this.hJf.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.eeU, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aVk().equals("task_complete")) {
            return false;
        } else {
            this.bjS.setVisibility(0);
            this.bjS.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ao.setImageResource(this.eeU, R.drawable.pic_frs_private_target_success);
        }
        this.hgC.setText(privateForumPopInfoData.aVl());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hJf.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eeU = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bjS = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.hgC = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.hJf = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.hJg = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.hJh = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.hJi = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.hJj = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eeU);
        setTextAttribute(Arrays.asList(this.hJh, this.hJi, this.hJj));
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.bjS, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.hgC, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.ao.g(this.hJf, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.hJf, R.color.cp_cont_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ao.setViewTextColor(textView, R.color.cp_cont_f);
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
        ViewGroup.LayoutParams layoutParams = this.eeU.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
