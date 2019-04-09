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
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {
    private LinearLayout bFz;
    private TbImageView bNX;
    private Context context;
    private TextView eAW;
    private TextView eKg;
    private TextView fbG;
    private RelativeLayout fbH;
    private TextView fbI;
    private TextView fbJ;
    private TextView fbK;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        aX(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.XR() == null) {
            return false;
        }
        String str = privateForumPopInfoData.XR() + "_" + privateForumPopInfoData.XU();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, true);
        if (privateForumPopInfoData.XR().equals("task_complete")) {
            this.fbH.setVisibility(0);
            this.fbG.setVisibility(8);
        } else {
            this.fbH.setVisibility(8);
            this.fbG.setVisibility(0);
        }
        if (privateForumPopInfoData.XR().equals("create_success")) {
            this.eKg.setVisibility(0);
            this.eKg.setText(d.j.frs_private_create_title);
            this.fbG.setText(d.j.frs_private_create_button);
            com.baidu.tbadk.core.util.al.c(this.bNX, d.f.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.XR().equals("left_time")) {
            this.eKg.setVisibility(8);
            this.fbG.setText(d.j.frs_private_create_button);
            com.baidu.tbadk.core.util.al.c(this.bNX, d.f.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.XR().equals("clear_forum")) {
            this.eKg.setVisibility(8);
            this.fbG.setText(d.j.frs_private_fail_button);
            com.baidu.tbadk.core.util.al.c(this.bNX, d.f.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.XR().equals("task_complete")) {
            return false;
        } else {
            this.eKg.setVisibility(0);
            this.eKg.setText(d.j.frs_private_success_title);
            com.baidu.tbadk.core.util.al.c(this.bNX, d.f.pic_frs_private_target_success);
        }
        this.eAW.setText(privateForumPopInfoData.XS());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.fbG.setOnClickListener(onClickListener);
        }
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_private_common_dialog, this);
        this.bFz = (LinearLayout) findViewById(d.g.frs_private_common);
        this.bNX = (TbImageView) this.bFz.findViewById(d.g.frs_private_common_image);
        this.eKg = (TextView) this.bFz.findViewById(d.g.frs_private_common_title);
        this.eAW = (TextView) this.bFz.findViewById(d.g.frs_private_common_hint);
        this.fbG = (TextView) this.bFz.findViewById(d.g.frs_private_common_button);
        this.fbH = (RelativeLayout) this.bFz.findViewById(d.g.frs_private_common_tips);
        this.fbI = (TextView) this.bFz.findViewById(d.g.frs_private_center_tip);
        this.fbJ = (TextView) this.bFz.findViewById(d.g.frs_private_left_tip);
        this.fbK = (TextView) this.bFz.findViewById(d.g.frs_private_right_tip);
        setImageAttribute(this.bNX);
        setTextAttribute(Arrays.asList(this.fbI, this.fbJ, this.fbK));
        com.baidu.tbadk.core.util.al.k(this.bFz, d.f.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.al.j(this.eKg, d.C0277d.cp_cont_b);
        com.baidu.tbadk.core.util.al.j(this.eAW, d.C0277d.cp_cont_j);
        com.baidu.tbadk.core.util.al.g(this.fbG, d.f.btn_frs_private_n, d.f.btn_frs_private_s);
        com.baidu.tbadk.core.util.al.j(this.fbG, d.C0277d.cp_btn_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int h = com.baidu.adp.lib.util.l.h(this.context, d.e.tbds78);
            drawable.setBounds(0, 0, h, h);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.al.j(textView, d.C0277d.cp_cont_f);
        }
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int aO;
        int h = com.baidu.adp.lib.util.l.h(this.context, d.e.tbds44);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            aO = com.baidu.adp.lib.util.l.aQ(this.context) - (h * 2);
        } else {
            aO = com.baidu.adp.lib.util.l.aO(this.context) - (h * 2);
        }
        ViewGroup.LayoutParams layoutParams = this.bNX.getLayoutParams();
        layoutParams.width = aO;
        layoutParams.height = (aO * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.h(this.context, d.e.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
