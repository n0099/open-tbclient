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
    private TextView bNi;
    private Context context;
    private TbImageView fhd;
    private TextView iFV;
    private TextView jiO;
    private RelativeLayout jiP;
    private TextView jiQ;
    private TextView jiR;
    private TextView jiS;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bqo() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bqo() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bqr();
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(str, true);
        if (privateForumPopInfoData.bqo().equals("task_complete")) {
            this.jiP.setVisibility(0);
            this.jiO.setVisibility(8);
        } else {
            this.jiP.setVisibility(8);
            this.jiO.setVisibility(0);
        }
        if (privateForumPopInfoData.bqo().equals("create_success")) {
            this.bNi.setVisibility(0);
            this.bNi.setText(R.string.frs_private_create_title);
            this.jiO.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fhd, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bqo().equals("left_time")) {
            this.bNi.setVisibility(8);
            this.jiO.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fhd, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bqo().equals("clear_forum")) {
            this.bNi.setVisibility(8);
            this.jiO.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fhd, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bqo().equals("task_complete")) {
            return false;
        } else {
            this.bNi.setVisibility(0);
            this.bNi.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fhd, R.drawable.pic_frs_private_target_success);
        }
        this.iFV.setText(privateForumPopInfoData.bqp());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jiO.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.fhd = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bNi = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.iFV = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.jiO = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.jiP = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.jiQ = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.jiR = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.jiS = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.fhd);
        setTextAttribute(Arrays.asList(this.jiQ, this.jiR, this.jiS));
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.bNi, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.iFV, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ao.l(this.jiO, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.jiO, R.color.CAM_X0101);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ao.setViewTextColor(textView, R.color.CAM_X0106);
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
        ViewGroup.LayoutParams layoutParams = this.fhd.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
