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
    private TextView bem;
    private Context context;
    private TbImageView dRP;
    private TextView gOb;
    private TextView hqA;
    private TextView hqB;
    private TextView hqC;
    private TextView hqy;
    private RelativeLayout hqz;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aPC() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aPC() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aPF();
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(str, true);
        if (privateForumPopInfoData.aPC().equals("task_complete")) {
            this.hqz.setVisibility(0);
            this.hqy.setVisibility(8);
        } else {
            this.hqz.setVisibility(8);
            this.hqy.setVisibility(0);
        }
        if (privateForumPopInfoData.aPC().equals("create_success")) {
            this.bem.setVisibility(0);
            this.bem.setText(R.string.frs_private_create_title);
            this.hqy.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dRP, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aPC().equals("left_time")) {
            this.bem.setVisibility(8);
            this.hqy.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dRP, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aPC().equals("clear_forum")) {
            this.bem.setVisibility(8);
            this.hqy.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dRP, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aPC().equals("task_complete")) {
            return false;
        } else {
            this.bem.setVisibility(0);
            this.bem.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.dRP, R.drawable.pic_frs_private_target_success);
        }
        this.gOb.setText(privateForumPopInfoData.aPD());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hqy.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.dRP = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bem = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.gOb = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.hqy = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.hqz = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.hqA = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.hqB = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.hqC = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.dRP);
        setTextAttribute(Arrays.asList(this.hqA, this.hqB, this.hqC));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.bem, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gOb, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.e(this.hqy, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hqy, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.dRP.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
