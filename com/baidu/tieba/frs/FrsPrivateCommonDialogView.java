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
    private TextView bIw;
    private Context context;
    private TbImageView fcv;
    private TextView iBo;
    private TextView jeg;
    private RelativeLayout jeh;
    private TextView jei;
    private TextView jej;
    private TextView jek;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bmv() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bmv() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bmy();
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(str, true);
        if (privateForumPopInfoData.bmv().equals("task_complete")) {
            this.jeh.setVisibility(0);
            this.jeg.setVisibility(8);
        } else {
            this.jeh.setVisibility(8);
            this.jeg.setVisibility(0);
        }
        if (privateForumPopInfoData.bmv().equals("create_success")) {
            this.bIw.setVisibility(0);
            this.bIw.setText(R.string.frs_private_create_title);
            this.jeg.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fcv, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bmv().equals("left_time")) {
            this.bIw.setVisibility(8);
            this.jeg.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fcv, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bmv().equals("clear_forum")) {
            this.bIw.setVisibility(8);
            this.jeg.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fcv, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bmv().equals("task_complete")) {
            return false;
        } else {
            this.bIw.setVisibility(0);
            this.bIw.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ao.setImageResource(this.fcv, R.drawable.pic_frs_private_target_success);
        }
        this.iBo.setText(privateForumPopInfoData.bmw());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jeg.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.fcv = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bIw = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.iBo = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.jeg = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.jeh = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.jei = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.jej = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.jek = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.fcv);
        setTextAttribute(Arrays.asList(this.jei, this.jej, this.jek));
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.bIw, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.iBo, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ao.l(this.jeg, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.jeg, R.color.CAM_X0101);
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
        ViewGroup.LayoutParams layoutParams = this.fcv.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
