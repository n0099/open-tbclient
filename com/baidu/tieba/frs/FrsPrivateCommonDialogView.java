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
    private TextView ayC;
    private TbImageView cZu;
    private Context context;
    private TextView fRb;
    private TextView gph;
    private RelativeLayout gpi;
    private TextView gpj;
    private TextView gpk;
    private TextView gpl;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aza() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aza() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.azd();
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(str, true);
        if (privateForumPopInfoData.aza().equals("task_complete")) {
            this.gpi.setVisibility(0);
            this.gph.setVisibility(8);
        } else {
            this.gpi.setVisibility(8);
            this.gph.setVisibility(0);
        }
        if (privateForumPopInfoData.aza().equals("create_success")) {
            this.ayC.setVisibility(0);
            this.ayC.setText(R.string.frs_private_create_title);
            this.gph.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZu, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aza().equals("left_time")) {
            this.ayC.setVisibility(8);
            this.gph.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZu, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aza().equals("clear_forum")) {
            this.ayC.setVisibility(8);
            this.gph.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZu, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aza().equals("task_complete")) {
            return false;
        } else {
            this.ayC.setVisibility(0);
            this.ayC.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZu, R.drawable.pic_frs_private_target_success);
        }
        this.fRb.setText(privateForumPopInfoData.azb());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.gph.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.cZu = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.ayC = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.fRb = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.gph = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.gpi = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.gpj = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.gpk = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.gpl = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.cZu);
        setTextAttribute(Arrays.asList(this.gpj, this.gpk, this.gpl));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.ayC, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fRb, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.b(this.gph, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gph, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.cZu.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
