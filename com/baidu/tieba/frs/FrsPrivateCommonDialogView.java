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
    private TextView aCS;
    private Context context;
    private TbImageView ddz;
    private TextView fTw;
    private TextView gri;
    private RelativeLayout grj;
    private TextView grk;
    private TextView grl;
    private TextView grm;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.aBr() == null) {
            return false;
        }
        String str = privateForumPopInfoData.aBr() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.aBu();
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(str, true);
        if (privateForumPopInfoData.aBr().equals("task_complete")) {
            this.grj.setVisibility(0);
            this.gri.setVisibility(8);
        } else {
            this.grj.setVisibility(8);
            this.gri.setVisibility(0);
        }
        if (privateForumPopInfoData.aBr().equals("create_success")) {
            this.aCS.setVisibility(0);
            this.aCS.setText(R.string.frs_private_create_title);
            this.gri.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddz, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.aBr().equals("left_time")) {
            this.aCS.setVisibility(8);
            this.gri.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddz, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.aBr().equals("clear_forum")) {
            this.aCS.setVisibility(8);
            this.gri.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddz, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.aBr().equals("task_complete")) {
            return false;
        } else {
            this.aCS.setVisibility(0);
            this.aCS.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.setImageResource(this.ddz, R.drawable.pic_frs_private_target_success);
        }
        this.fTw.setText(privateForumPopInfoData.aBs());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.gri.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.ddz = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.aCS = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.fTw = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.gri = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.grj = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.grk = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.grl = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.grm = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.ddz);
        setTextAttribute(Arrays.asList(this.grk, this.grl, this.grm));
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.aCS, (int) R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fTw, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.b(this.gri, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gri, (int) R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.ddz.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
