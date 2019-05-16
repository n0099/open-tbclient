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
    private LinearLayout bMZ;
    private TbImageView bVI;
    private Context context;
    private TextView eQB;
    private TextView fap;
    private TextView frV;
    private RelativeLayout frW;
    private TextView frX;
    private TextView frY;
    private TextView frZ;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.acy() == null) {
            return false;
        }
        String str = privateForumPopInfoData.acy() + "_" + privateForumPopInfoData.acB();
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(str, true);
        if (privateForumPopInfoData.acy().equals("task_complete")) {
            this.frW.setVisibility(0);
            this.frV.setVisibility(8);
        } else {
            this.frW.setVisibility(8);
            this.frV.setVisibility(0);
        }
        if (privateForumPopInfoData.acy().equals("create_success")) {
            this.fap.setVisibility(0);
            this.fap.setText(R.string.frs_private_create_title);
            this.frV.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.al.c(this.bVI, (int) R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.acy().equals("left_time")) {
            this.fap.setVisibility(8);
            this.frV.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.al.c(this.bVI, (int) R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.acy().equals("clear_forum")) {
            this.fap.setVisibility(8);
            this.frV.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.al.c(this.bVI, (int) R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.acy().equals("task_complete")) {
            return false;
        } else {
            this.fap.setVisibility(0);
            this.fap.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.al.c(this.bVI, (int) R.drawable.pic_frs_private_target_success);
        }
        this.eQB.setText(privateForumPopInfoData.acz());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.frV.setOnClickListener(onClickListener);
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.bMZ = (LinearLayout) findViewById(R.id.frs_private_common);
        this.bVI = (TbImageView) this.bMZ.findViewById(R.id.frs_private_common_image);
        this.fap = (TextView) this.bMZ.findViewById(R.id.frs_private_common_title);
        this.eQB = (TextView) this.bMZ.findViewById(R.id.frs_private_common_hint);
        this.frV = (TextView) this.bMZ.findViewById(R.id.frs_private_common_button);
        this.frW = (RelativeLayout) this.bMZ.findViewById(R.id.frs_private_common_tips);
        this.frX = (TextView) this.bMZ.findViewById(R.id.frs_private_center_tip);
        this.frY = (TextView) this.bMZ.findViewById(R.id.frs_private_left_tip);
        this.frZ = (TextView) this.bMZ.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.bVI);
        setTextAttribute(Arrays.asList(this.frX, this.frY, this.frZ));
        com.baidu.tbadk.core.util.al.k(this.bMZ, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.al.j(this.fap, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.al.j(this.eQB, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.al.j(this.frV, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.al.j(this.frV, R.color.cp_btn_a);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int g = com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds78);
            drawable.setBounds(0, 0, g, g);
            textView.setCompoundDrawables(null, drawable, null, null);
            com.baidu.tbadk.core.util.al.j(textView, R.color.cp_cont_f);
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
        ViewGroup.LayoutParams layoutParams = this.bVI.getLayoutParams();
        layoutParams.width = af;
        layoutParams.height = (af * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
