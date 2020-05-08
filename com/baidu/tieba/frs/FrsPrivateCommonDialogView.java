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
    private TextView aWU;
    private Context context;
    private TbImageView dDD;
    private TextView gzg;
    private RelativeLayout hbA;
    private TextView hbB;
    private TextView hbC;
    private TextView hbD;
    private TextView hbz;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aJH() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aJH() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aJK();
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(str, true);
        if (privateForumPopInfoData.aJH().equals("task_complete")) {
            this.hbA.setVisibility(0);
            this.hbz.setVisibility(8);
        } else {
            this.hbA.setVisibility(8);
            this.hbz.setVisibility(0);
        }
        if (privateForumPopInfoData.aJH().equals("create_success")) {
            this.aWU.setVisibility(0);
            this.aWU.setText(R.string.frs_private_create_title);
            this.hbz.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDD, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aJH().equals("left_time")) {
            this.aWU.setVisibility(8);
            this.hbz.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDD, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aJH().equals("clear_forum")) {
            this.aWU.setVisibility(8);
            this.hbz.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDD, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aJH().equals("task_complete")) {
            return false;
        } else {
            this.aWU.setVisibility(0);
            this.aWU.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.dDD, R.drawable.pic_frs_private_target_success);
        }
        this.gzg.setText(privateForumPopInfoData.aJI());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hbz.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.dDD = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.aWU = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.gzg = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.hbz = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.hbA = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.hbB = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.hbC = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.hbD = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.dDD);
        setTextAttribute(Arrays.asList(this.hbB, this.hbC, this.hbD));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aWU, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gzg, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.c(this.hbz, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hbz, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.dDD.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
