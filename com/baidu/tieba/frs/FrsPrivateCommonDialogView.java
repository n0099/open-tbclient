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
    private TextView axT;
    private TbImageView cZk;
    private Context context;
    private TextView fNS;
    private TextView glY;
    private RelativeLayout glZ;
    private TextView gma;
    private TextView gmb;
    private TextView gmc;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.ayH() == null) {
            return false;
        }
        String str = privateForumPopInfoData.ayH() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.ayK();
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(str, true);
        if (privateForumPopInfoData.ayH().equals("task_complete")) {
            this.glZ.setVisibility(0);
            this.glY.setVisibility(8);
        } else {
            this.glZ.setVisibility(8);
            this.glY.setVisibility(0);
        }
        if (privateForumPopInfoData.ayH().equals("create_success")) {
            this.axT.setVisibility(0);
            this.axT.setText(R.string.frs_private_create_title);
            this.glY.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZk, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.ayH().equals("left_time")) {
            this.axT.setVisibility(8);
            this.glY.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZk, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.ayH().equals("clear_forum")) {
            this.axT.setVisibility(8);
            this.glY.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZk, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.ayH().equals("task_complete")) {
            return false;
        } else {
            this.axT.setVisibility(0);
            this.axT.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.cZk, R.drawable.pic_frs_private_target_success);
        }
        this.fNS.setText(privateForumPopInfoData.ayI());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.glY.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.cZk = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.axT = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.fNS = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.glY = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.glZ = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.gma = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.gmb = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.gmc = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.cZk);
        setTextAttribute(Arrays.asList(this.gma, this.gmb, this.gmc));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.axT, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fNS, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.b(this.glY, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.glY, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.cZk.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
