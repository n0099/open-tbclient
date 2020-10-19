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
    private TextView bwx;
    private Context context;
    private TbImageView eDb;
    private TextView hPB;
    private TextView isC;
    private RelativeLayout isD;
    private TextView isE;
    private TextView isF;
    private TextView isG;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bhg() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bhg() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bhj();
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(str, true);
        if (privateForumPopInfoData.bhg().equals("task_complete")) {
            this.isD.setVisibility(0);
            this.isC.setVisibility(8);
        } else {
            this.isD.setVisibility(8);
            this.isC.setVisibility(0);
        }
        if (privateForumPopInfoData.bhg().equals("create_success")) {
            this.bwx.setVisibility(0);
            this.bwx.setText(R.string.frs_private_create_title);
            this.isC.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eDb, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bhg().equals("left_time")) {
            this.bwx.setVisibility(8);
            this.isC.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eDb, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bhg().equals("clear_forum")) {
            this.bwx.setVisibility(8);
            this.isC.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eDb, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bhg().equals("task_complete")) {
            return false;
        } else {
            this.bwx.setVisibility(0);
            this.bwx.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eDb, R.drawable.pic_frs_private_target_success);
        }
        this.hPB.setText(privateForumPopInfoData.bhh());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.isC.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eDb = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bwx = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.hPB = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.isC = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.isD = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.isE = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.isF = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.isG = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eDb);
        setTextAttribute(Arrays.asList(this.isE, this.isF, this.isG));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bwx, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.hPB, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.ap.f(this.isC, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.isC, R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.eDb.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
