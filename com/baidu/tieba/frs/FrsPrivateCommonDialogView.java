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
    private TextView bEW;
    private Context context;
    private TbImageView eRm;
    private TextView iKV;
    private RelativeLayout iKW;
    private TextView iKX;
    private TextView iKY;
    private TextView iKZ;
    private TextView ihZ;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.blz() == null) {
            return false;
        }
        String str = privateForumPopInfoData.blz() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.blC();
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(str, true);
        if (privateForumPopInfoData.blz().equals("task_complete")) {
            this.iKW.setVisibility(0);
            this.iKV.setVisibility(8);
        } else {
            this.iKW.setVisibility(8);
            this.iKV.setVisibility(0);
        }
        if (privateForumPopInfoData.blz().equals("create_success")) {
            this.bEW.setVisibility(0);
            this.bEW.setText(R.string.frs_private_create_title);
            this.iKV.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eRm, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.blz().equals("left_time")) {
            this.bEW.setVisibility(8);
            this.iKV.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eRm, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.blz().equals("clear_forum")) {
            this.bEW.setVisibility(8);
            this.iKV.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eRm, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.blz().equals("task_complete")) {
            return false;
        } else {
            this.bEW.setVisibility(0);
            this.bEW.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eRm, R.drawable.pic_frs_private_target_success);
        }
        this.ihZ.setText(privateForumPopInfoData.blA());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iKV.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eRm = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bEW = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.ihZ = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.iKV = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.iKW = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.iKX = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.iKY = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.iKZ = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eRm);
        setTextAttribute(Arrays.asList(this.iKX, this.iKY, this.iKZ));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bEW, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ihZ, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.ap.f(this.iKV, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iKV, R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.eRm.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
