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
    private TextView bjy;
    private Context context;
    private TbImageView dYH;
    private TextView hDh;
    private RelativeLayout hDi;
    private TextView hDj;
    private TextView hDk;
    private TextView hDl;
    private TextView haX;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aRo() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aRo() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aRr();
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(str, true);
        if (privateForumPopInfoData.aRo().equals("task_complete")) {
            this.hDi.setVisibility(0);
            this.hDh.setVisibility(8);
        } else {
            this.hDi.setVisibility(8);
            this.hDh.setVisibility(0);
        }
        if (privateForumPopInfoData.aRo().equals("create_success")) {
            this.bjy.setVisibility(0);
            this.bjy.setText(R.string.frs_private_create_title);
            this.hDh.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.an.setImageResource(this.dYH, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aRo().equals("left_time")) {
            this.bjy.setVisibility(8);
            this.hDh.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.an.setImageResource(this.dYH, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aRo().equals("clear_forum")) {
            this.bjy.setVisibility(8);
            this.hDh.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.an.setImageResource(this.dYH, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aRo().equals("task_complete")) {
            return false;
        } else {
            this.bjy.setVisibility(0);
            this.bjy.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.an.setImageResource(this.dYH, R.drawable.pic_frs_private_target_success);
        }
        this.haX.setText(privateForumPopInfoData.aRp());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hDh.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.dYH = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bjy = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.haX = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.hDh = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.hDi = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.hDj = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.hDk = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.hDl = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.dYH);
        setTextAttribute(Arrays.asList(this.hDj, this.hDk, this.hDl));
        com.baidu.tbadk.core.util.an.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.bjy, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.haX, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.an.e(this.hDh, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.an.setViewTextColor(this.hDh, (int) R.color.cp_cont_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.an.setViewTextColor(textView, (int) R.color.cp_cont_f);
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
        ViewGroup.LayoutParams layoutParams = this.dYH.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
