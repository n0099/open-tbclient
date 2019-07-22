package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    private LinearLayout bOb;
    private TbImageView bWL;
    private Context context;
    private TextView eVC;
    private TextView ffr;
    private TextView fwS;
    private RelativeLayout fwT;
    private TextView fwU;
    private TextView fwV;
    private TextView fwW;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.adA() == null) {
            return false;
        }
        String str = privateForumPopInfoData.adA() + "_" + privateForumPopInfoData.adD();
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean(str, true);
        if (privateForumPopInfoData.adA().equals("task_complete")) {
            this.fwT.setVisibility(0);
            this.fwS.setVisibility(8);
        } else {
            this.fwT.setVisibility(8);
            this.fwS.setVisibility(0);
        }
        if (privateForumPopInfoData.adA().equals("create_success")) {
            this.ffr.setVisibility(0);
            this.ffr.setText(R.string.frs_private_create_title);
            this.fwS.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.c(this.bWL, (int) R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.adA().equals("left_time")) {
            this.ffr.setVisibility(8);
            this.fwS.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.c(this.bWL, (int) R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.adA().equals("clear_forum")) {
            this.ffr.setVisibility(8);
            this.fwS.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.c(this.bWL, (int) R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.adA().equals("task_complete")) {
            return false;
        } else {
            this.ffr.setVisibility(0);
            this.ffr.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.c(this.bWL, (int) R.drawable.pic_frs_private_target_success);
        }
        this.eVC.setText(privateForumPopInfoData.adB());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.fwS.setOnClickListener(onClickListener);
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.bOb = (LinearLayout) findViewById(R.id.frs_private_common);
        this.bWL = (TbImageView) this.bOb.findViewById(R.id.frs_private_common_image);
        this.ffr = (TextView) this.bOb.findViewById(R.id.frs_private_common_title);
        this.eVC = (TextView) this.bOb.findViewById(R.id.frs_private_common_hint);
        this.fwS = (TextView) this.bOb.findViewById(R.id.frs_private_common_button);
        this.fwT = (RelativeLayout) this.bOb.findViewById(R.id.frs_private_common_tips);
        this.fwU = (TextView) this.bOb.findViewById(R.id.frs_private_center_tip);
        this.fwV = (TextView) this.bOb.findViewById(R.id.frs_private_left_tip);
        this.fwW = (TextView) this.bOb.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.bWL);
        setTextAttribute(Arrays.asList(this.fwU, this.fwV, this.fwW));
        com.baidu.tbadk.core.util.am.k(this.bOb, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.j(this.ffr, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.j(this.eVC, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.j(this.fwS, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.j(this.fwS, R.color.cp_btn_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int g = com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, g, g);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.am.j(textView, R.color.cp_cont_f);
        }
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int af;
        int g = com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            af = com.baidu.adp.lib.util.l.ah(this.context) - (g * 2);
        } else {
            af = com.baidu.adp.lib.util.l.af(this.context) - (g * 2);
        }
        ViewGroup.LayoutParams layoutParams = this.bWL.getLayoutParams();
        layoutParams.width = af;
        layoutParams.height = (af * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
