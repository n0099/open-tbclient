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
    private TextView bNG;
    private Context context;
    private TbImageView fgj;
    private TextView iIV;
    private TextView jlK;
    private RelativeLayout jlL;
    private TextView jlM;
    private TextView jlN;
    private TextView jlO;
    private LinearLayout mRootView;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.bmQ() == null) {
            return false;
        }
        String str = privateForumPopInfoData.bmQ() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + privateForumPopInfoData.bmT();
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(str, true);
        if (privateForumPopInfoData.bmQ().equals("task_complete")) {
            this.jlL.setVisibility(0);
            this.jlK.setVisibility(8);
        } else {
            this.jlL.setVisibility(8);
            this.jlK.setVisibility(0);
        }
        if (privateForumPopInfoData.bmQ().equals("create_success")) {
            this.bNG.setVisibility(0);
            this.bNG.setText(R.string.frs_private_create_title);
            this.jlK.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.fgj, R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.bmQ().equals("left_time")) {
            this.bNG.setVisibility(8);
            this.jlK.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.fgj, R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.bmQ().equals("clear_forum")) {
            this.bNG.setVisibility(8);
            this.jlK.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.ap.setImageResource(this.fgj, R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.bmQ().equals("task_complete")) {
            return false;
        } else {
            this.bNG.setVisibility(0);
            this.bNG.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.ap.setImageResource(this.fgj, R.drawable.pic_frs_private_target_success);
        }
        this.iIV.setText(privateForumPopInfoData.bmR());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jlK.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_common);
        this.fgj = (TbImageView) this.mRootView.findViewById(R.id.frs_private_common_image);
        this.bNG = (TextView) this.mRootView.findViewById(R.id.frs_private_common_title);
        this.iIV = (TextView) this.mRootView.findViewById(R.id.frs_private_common_hint);
        this.jlK = (TextView) this.mRootView.findViewById(R.id.frs_private_common_button);
        this.jlL = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_common_tips);
        this.jlM = (TextView) this.mRootView.findViewById(R.id.frs_private_center_tip);
        this.jlN = (TextView) this.mRootView.findViewById(R.id.frs_private_left_tip);
        this.jlO = (TextView) this.mRootView.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.fgj);
        setTextAttribute(Arrays.asList(this.jlM, this.jlN, this.jlO));
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bNG, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iIV, R.color.CAM_X0107);
        com.baidu.tbadk.core.util.ap.l(this.jlK, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.jlK, R.color.CAM_X0101);
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
        ViewGroup.LayoutParams layoutParams = this.fgj.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
