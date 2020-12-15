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
    private TextView bIt;
    private Context context;
    private TbImageView eXC;
    private TextView iWB;
    private RelativeLayout iWC;
    private TextView iWD;
    private TextView iWE;
    private TextView iWF;
    private TextView itI;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bnO() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bnO() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bnR();
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(str, true);
        if (privateForumPopInfoData.bnO().equals("task_complete")) {
            this.iWC.setVisibility(0);
            this.iWB.setVisibility(8);
        } else {
            this.iWC.setVisibility(8);
            this.iWB.setVisibility(0);
        }
        if (privateForumPopInfoData.bnO().equals("create_success")) {
            this.bIt.setVisibility(0);
            this.bIt.setText(R.string.frs_private_create_title);
            this.iWB.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eXC, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bnO().equals("left_time")) {
            this.bIt.setVisibility(8);
            this.iWB.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eXC, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bnO().equals("clear_forum")) {
            this.bIt.setVisibility(8);
            this.iWB.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eXC, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bnO().equals("task_complete")) {
            return false;
        } else {
            this.bIt.setVisibility(0);
            this.bIt.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eXC, R.drawable.pic_frs_private_target_success);
        }
        this.itI.setText(privateForumPopInfoData.bnP());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iWB.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eXC = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bIt = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.itI = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.iWB = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.iWC = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.iWD = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.iWE = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.iWF = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eXC);
        setTextAttribute(Arrays.asList(this.iWD, this.iWE, this.iWF));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bIt, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.itI, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.f(this.iWB, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWB, R.color.CAM_X0101);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0106);
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
        ViewGroup.LayoutParams layoutParams = this.eXC.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
