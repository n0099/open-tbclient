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
    private TextView bpA;
    private Context context;
    private TbImageView eoz;
    private TextView hWB;
    private RelativeLayout hWC;
    private TextView hWD;
    private TextView hWE;
    private TextView hWF;
    private TextView htB;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bdD() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bdD() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bdG();
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(str, true);
        if (privateForumPopInfoData.bdD().equals("task_complete")) {
            this.hWC.setVisibility(0);
            this.hWB.setVisibility(8);
        } else {
            this.hWC.setVisibility(8);
            this.hWB.setVisibility(0);
        }
        if (privateForumPopInfoData.bdD().equals("create_success")) {
            this.bpA.setVisibility(0);
            this.bpA.setText(R.string.frs_private_create_title);
            this.hWB.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eoz, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bdD().equals("left_time")) {
            this.bpA.setVisibility(8);
            this.hWB.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eoz, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bdD().equals("clear_forum")) {
            this.bpA.setVisibility(8);
            this.hWB.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eoz, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bdD().equals("task_complete")) {
            return false;
        } else {
            this.bpA.setVisibility(0);
            this.bpA.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eoz, R.drawable.pic_frs_private_target_success);
        }
        this.htB.setText(privateForumPopInfoData.bdE());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hWB.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eoz = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bpA = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.htB = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.hWB = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.hWC = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.hWD = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.hWE = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.hWF = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eoz);
        setTextAttribute(Arrays.asList(this.hWD, this.hWE, this.hWF));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bpA, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.htB, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.ap.f(this.hWB, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.hWB, R.color.cp_cont_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.cp_cont_f);
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
        ViewGroup.LayoutParams layoutParams = this.eoz.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
