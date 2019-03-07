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
    private LinearLayout bFu;
    private TbImageView bNT;
    private Context context;
    private TextView eBo;
    private TextView eKx;
    private TextView fbU;
    private RelativeLayout fbV;
    private TextView fbW;
    private TextView fbX;
    private TextView fbY;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        aX(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.XU() == null) {
            return false;
        }
        String str = privateForumPopInfoData.XU() + "_" + privateForumPopInfoData.XX();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, true);
        if (privateForumPopInfoData.XU().equals("task_complete")) {
            this.fbV.setVisibility(0);
            this.fbU.setVisibility(8);
        } else {
            this.fbV.setVisibility(8);
            this.fbU.setVisibility(0);
        }
        if (privateForumPopInfoData.XU().equals("create_success")) {
            this.eKx.setVisibility(0);
            this.eKx.setText(d.j.frs_private_create_title);
            this.fbU.setText(d.j.frs_private_create_button);
            com.baidu.tbadk.core.util.al.c(this.bNT, d.f.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.XU().equals("left_time")) {
            this.eKx.setVisibility(8);
            this.fbU.setText(d.j.frs_private_create_button);
            com.baidu.tbadk.core.util.al.c(this.bNT, d.f.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.XU().equals("clear_forum")) {
            this.eKx.setVisibility(8);
            this.fbU.setText(d.j.frs_private_fail_button);
            com.baidu.tbadk.core.util.al.c(this.bNT, d.f.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.XU().equals("task_complete")) {
            return false;
        } else {
            this.eKx.setVisibility(0);
            this.eKx.setText(d.j.frs_private_success_title);
            com.baidu.tbadk.core.util.al.c(this.bNT, d.f.pic_frs_private_target_success);
        }
        this.eBo.setText(privateForumPopInfoData.XV());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.fbU.setOnClickListener(onClickListener);
        }
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_private_common_dialog, this);
        this.bFu = (LinearLayout) findViewById(d.g.frs_private_common);
        this.bNT = (TbImageView) this.bFu.findViewById(d.g.frs_private_common_image);
        this.eKx = (TextView) this.bFu.findViewById(d.g.frs_private_common_title);
        this.eBo = (TextView) this.bFu.findViewById(d.g.frs_private_common_hint);
        this.fbU = (TextView) this.bFu.findViewById(d.g.frs_private_common_button);
        this.fbV = (RelativeLayout) this.bFu.findViewById(d.g.frs_private_common_tips);
        this.fbW = (TextView) this.bFu.findViewById(d.g.frs_private_center_tip);
        this.fbX = (TextView) this.bFu.findViewById(d.g.frs_private_left_tip);
        this.fbY = (TextView) this.bFu.findViewById(d.g.frs_private_right_tip);
        setImageAttribute(this.bNT);
        setTextAttribute(Arrays.asList(this.fbW, this.fbX, this.fbY));
        com.baidu.tbadk.core.util.al.k(this.bFu, d.f.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.al.j(this.eKx, d.C0236d.cp_cont_b);
        com.baidu.tbadk.core.util.al.j(this.eBo, d.C0236d.cp_cont_j);
        com.baidu.tbadk.core.util.al.g(this.fbU, d.f.btn_frs_private_n, d.f.btn_frs_private_s);
        com.baidu.tbadk.core.util.al.j(this.fbU, d.C0236d.cp_btn_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int h = com.baidu.adp.lib.util.l.h(this.context, d.e.tbds78);
            drawable.setBounds(0, 0, h, h);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.al.j(textView, d.C0236d.cp_cont_f);
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
        ViewGroup.LayoutParams layoutParams = this.bNT.getLayoutParams();
        layoutParams.width = aO;
        layoutParams.height = (aO * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.h(this.context, d.e.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
