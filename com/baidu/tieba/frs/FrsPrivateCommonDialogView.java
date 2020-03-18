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
    private TextView aDi;
    private Context context;
    private TbImageView dea;
    private TextView fUu;
    private TextView gsh;
    private RelativeLayout gsi;
    private TextView gsj;
    private TextView gsk;
    private TextView gsl;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aBw() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aBw() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aBz();
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(str, true);
        if (privateForumPopInfoData.aBw().equals("task_complete")) {
            this.gsi.setVisibility(0);
            this.gsh.setVisibility(8);
        } else {
            this.gsi.setVisibility(8);
            this.gsh.setVisibility(0);
        }
        if (privateForumPopInfoData.aBw().equals("create_success")) {
            this.aDi.setVisibility(0);
            this.aDi.setText(R.string.frs_private_create_title);
            this.gsh.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dea, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aBw().equals("left_time")) {
            this.aDi.setVisibility(8);
            this.gsh.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dea, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aBw().equals("clear_forum")) {
            this.aDi.setVisibility(8);
            this.gsh.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.dea, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aBw().equals("task_complete")) {
            return false;
        } else {
            this.aDi.setVisibility(0);
            this.aDi.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.dea, R.drawable.pic_frs_private_target_success);
        }
        this.fUu.setText(privateForumPopInfoData.aBx());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.gsh.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.dea = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.aDi = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.fUu = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.gsh = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.gsi = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.gsj = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.gsk = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.gsl = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.dea);
        setTextAttribute(Arrays.asList(this.gsj, this.gsk, this.gsl));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aDi, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fUu, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.c(this.gsh, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gsh, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.dea.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
