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
    private TextView byL;
    private Context context;
    private TbImageView eLx;
    private TextView iEY;
    private RelativeLayout iEZ;
    private TextView iFa;
    private TextView iFb;
    private TextView iFc;
    private TextView ibY;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.biZ() == null) {
            return false;
        }
        String str = privateForumPopInfoData.biZ() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bjc();
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(str, true);
        if (privateForumPopInfoData.biZ().equals("task_complete")) {
            this.iEZ.setVisibility(0);
            this.iEY.setVisibility(8);
        } else {
            this.iEZ.setVisibility(8);
            this.iEY.setVisibility(0);
        }
        if (privateForumPopInfoData.biZ().equals("create_success")) {
            this.byL.setVisibility(0);
            this.byL.setText(R.string.frs_private_create_title);
            this.iEY.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eLx, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.biZ().equals("left_time")) {
            this.byL.setVisibility(8);
            this.iEY.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eLx, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.biZ().equals("clear_forum")) {
            this.byL.setVisibility(8);
            this.iEY.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eLx, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.biZ().equals("task_complete")) {
            return false;
        } else {
            this.byL.setVisibility(0);
            this.byL.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eLx, R.drawable.pic_frs_private_target_success);
        }
        this.ibY.setText(privateForumPopInfoData.bja());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iEY.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eLx = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.byL = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.ibY = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.iEY = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.iEZ = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.iFa = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.iFb = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.iFc = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eLx);
        setTextAttribute(Arrays.asList(this.iFa, this.iFb, this.iFc));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.byL, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ibY, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.ap.f(this.iEY, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iEY, R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.eLx.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
