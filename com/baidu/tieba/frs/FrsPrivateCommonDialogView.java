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
    private TextView bDl;
    private Context context;
    private TbImageView eQn;
    private TextView iLI;
    private RelativeLayout iLJ;
    private TextView iLK;
    private TextView iLL;
    private TextView iLM;
    private TextView iiN;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bkB() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bkB() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bkE();
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(str, true);
        if (privateForumPopInfoData.bkB().equals("task_complete")) {
            this.iLJ.setVisibility(0);
            this.iLI.setVisibility(8);
        } else {
            this.iLJ.setVisibility(8);
            this.iLI.setVisibility(0);
        }
        if (privateForumPopInfoData.bkB().equals("create_success")) {
            this.bDl.setVisibility(0);
            this.bDl.setText(R.string.frs_private_create_title);
            this.iLI.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eQn, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bkB().equals("left_time")) {
            this.bDl.setVisibility(8);
            this.iLI.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eQn, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bkB().equals("clear_forum")) {
            this.bDl.setVisibility(8);
            this.iLI.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eQn, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bkB().equals("task_complete")) {
            return false;
        } else {
            this.bDl.setVisibility(0);
            this.bDl.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.eQn, R.drawable.pic_frs_private_target_success);
        }
        this.iiN.setText(privateForumPopInfoData.bkC());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iLI.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.eQn = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bDl = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.iiN = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.iLI = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.iLJ = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.iLK = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.iLL = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.iLM = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.eQn);
        setTextAttribute(Arrays.asList(this.iLK, this.iLL, this.iLM));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bDl, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iiN, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.g(this.iLI, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iLI, R.color.CAM_X0101);
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
        ViewGroup.LayoutParams layoutParams = this.eQn.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
