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
    private TextView bMg;
    private Context context;
    private TbImageView feK;
    private TextView iGY;
    private TextView jjN;
    private RelativeLayout jjO;
    private TextView jjP;
    private TextView jjQ;
    private TextView jjR;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bmO() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bmO() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bmR();
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(str, true);
        if (privateForumPopInfoData.bmO().equals("task_complete")) {
            this.jjO.setVisibility(0);
            this.jjN.setVisibility(8);
        } else {
            this.jjO.setVisibility(8);
            this.jjN.setVisibility(0);
        }
        if (privateForumPopInfoData.bmO().equals("create_success")) {
            this.bMg.setVisibility(0);
            this.bMg.setText(R.string.frs_private_create_title);
            this.jjN.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.feK, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bmO().equals("left_time")) {
            this.bMg.setVisibility(8);
            this.jjN.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.feK, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bmO().equals("clear_forum")) {
            this.bMg.setVisibility(8);
            this.jjN.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.feK, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bmO().equals("task_complete")) {
            return false;
        } else {
            this.bMg.setVisibility(0);
            this.bMg.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.feK, R.drawable.pic_frs_private_target_success);
        }
        this.iGY.setText(privateForumPopInfoData.bmP());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jjN.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.feK = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bMg = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.iGY = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.jjN = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.jjO = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.jjP = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.jjQ = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.jjR = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.feK);
        setTextAttribute(Arrays.asList(this.jjP, this.jjQ, this.jjR));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bMg, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iGY, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.l(this.jjN, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.jjN, R.color.CAM_X0101);
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
        ViewGroup.LayoutParams layoutParams = this.feK.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
