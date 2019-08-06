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
    private LinearLayout bOg;
    private TbImageView bWR;
    private Context context;
    private TextView eVJ;
    private TextView ffR;
    private TextView fxr;
    private RelativeLayout fxs;
    private TextView fxt;
    private TextView fxu;
    private TextView fxv;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.adB() == null) {
            return false;
        }
        String str = privateForumPopInfoData.adB() + "_" + privateForumPopInfoData.adE();
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean(str, true);
        if (privateForumPopInfoData.adB().equals("task_complete")) {
            this.fxs.setVisibility(0);
            this.fxr.setVisibility(8);
        } else {
            this.fxs.setVisibility(8);
            this.fxr.setVisibility(0);
        }
        if (privateForumPopInfoData.adB().equals("create_success")) {
            this.ffR.setVisibility(0);
            this.ffR.setText(R.string.frs_private_create_title);
            this.fxr.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.c(this.bWR, (int) R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.adB().equals("left_time")) {
            this.ffR.setVisibility(8);
            this.fxr.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.c(this.bWR, (int) R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.adB().equals("clear_forum")) {
            this.ffR.setVisibility(8);
            this.fxr.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.c(this.bWR, (int) R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.adB().equals("task_complete")) {
            return false;
        } else {
            this.ffR.setVisibility(0);
            this.ffR.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.c(this.bWR, (int) R.drawable.pic_frs_private_target_success);
        }
        this.eVJ.setText(privateForumPopInfoData.adC());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.fxr.setOnClickListener(onClickListener);
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.bOg = (LinearLayout) findViewById(R.id.frs_private_common);
        this.bWR = (TbImageView) this.bOg.findViewById(R.id.frs_private_common_image);
        this.ffR = (TextView) this.bOg.findViewById(R.id.frs_private_common_title);
        this.eVJ = (TextView) this.bOg.findViewById(R.id.frs_private_common_hint);
        this.fxr = (TextView) this.bOg.findViewById(R.id.frs_private_common_button);
        this.fxs = (RelativeLayout) this.bOg.findViewById(R.id.frs_private_common_tips);
        this.fxt = (TextView) this.bOg.findViewById(R.id.frs_private_center_tip);
        this.fxu = (TextView) this.bOg.findViewById(R.id.frs_private_left_tip);
        this.fxv = (TextView) this.bOg.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.bWR);
        setTextAttribute(Arrays.asList(this.fxt, this.fxu, this.fxv));
        com.baidu.tbadk.core.util.am.k(this.bOg, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.j(this.ffR, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.j(this.eVJ, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.i(this.fxr, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.j(this.fxr, R.color.cp_btn_a);
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
        ViewGroup.LayoutParams layoutParams = this.bWR.getLayoutParams();
        layoutParams.width = af;
        layoutParams.height = (af * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
