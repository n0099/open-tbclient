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
    private TextView bsJ;
    private Context context;
    private TbImageView eqP;
    private TextView hAG;
    private TextView idF;
    private RelativeLayout idG;
    private TextView idH;
    private TextView idI;
    private TextView idJ;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bex() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bex() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.beA();
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(str, true);
        if (privateForumPopInfoData.bex().equals("task_complete")) {
            this.idG.setVisibility(0);
            this.idF.setVisibility(8);
        } else {
            this.idG.setVisibility(8);
            this.idF.setVisibility(0);
        }
        if (privateForumPopInfoData.bex().equals("create_success")) {
            this.bsJ.setVisibility(0);
            this.bsJ.setText(R.string.frs_private_create_title);
            this.idF.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eqP, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bex().equals("left_time")) {
            this.bsJ.setVisibility(8);
            this.idF.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eqP, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bex().equals("clear_forum")) {
            this.bsJ.setVisibility(8);
            this.idF.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eqP, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bex().equals("task_complete")) {
            return false;
        } else {
            this.bsJ.setVisibility(0);
            this.bsJ.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eqP, R.drawable.pic_frs_private_target_success);
        }
        this.hAG.setText(privateForumPopInfoData.bey());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.idF.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eqP = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bsJ = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.hAG = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.idF = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.idG = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.idH = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.idI = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.idJ = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eqP);
        setTextAttribute(Arrays.asList(this.idH, this.idI, this.idJ));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bsJ, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.hAG, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.ap.f(this.idF, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.idF, R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.eqP.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
