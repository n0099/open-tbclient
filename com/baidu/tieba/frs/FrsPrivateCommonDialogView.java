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
    private LinearLayout bOF;
    private TbImageView bXK;
    private Context context;
    private TextView eXp;
    private TextView fhE;
    private TextView fze;
    private RelativeLayout fzf;
    private TextView fzg;
    private TextView fzh;
    private TextView fzi;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public boolean b(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData == null || privateForumPopInfoData.adF() == null) {
            return false;
        }
        String str = privateForumPopInfoData.adF() + "_" + privateForumPopInfoData.adI();
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean(str, false)) {
            return false;
        }
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean(str, true);
        if (privateForumPopInfoData.adF().equals("task_complete")) {
            this.fzf.setVisibility(0);
            this.fze.setVisibility(8);
        } else {
            this.fzf.setVisibility(8);
            this.fze.setVisibility(0);
        }
        if (privateForumPopInfoData.adF().equals("create_success")) {
            this.fhE.setVisibility(0);
            this.fhE.setText(R.string.frs_private_create_title);
            this.fze.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.c(this.bXK, (int) R.drawable.pic_frs_private_create_success);
        } else if (privateForumPopInfoData.adF().equals("left_time")) {
            this.fhE.setVisibility(8);
            this.fze.setText(R.string.frs_private_create_button);
            com.baidu.tbadk.core.util.am.c(this.bXK, (int) R.drawable.pic_frs_private_target_remind);
        } else if (privateForumPopInfoData.adF().equals("clear_forum")) {
            this.fhE.setVisibility(8);
            this.fze.setText(R.string.frs_private_fail_button);
            com.baidu.tbadk.core.util.am.c(this.bXK, (int) R.drawable.pic_frs_private_target_fail);
        } else if (!privateForumPopInfoData.adF().equals("task_complete")) {
            return false;
        } else {
            this.fhE.setVisibility(0);
            this.fhE.setText(R.string.frs_private_success_title);
            com.baidu.tbadk.core.util.am.c(this.bXK, (int) R.drawable.pic_frs_private_target_success);
        }
        this.eXp.setText(privateForumPopInfoData.adG());
        return true;
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.fze.setOnClickListener(onClickListener);
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        this.bOF = (LinearLayout) findViewById(R.id.frs_private_common);
        this.bXK = (TbImageView) this.bOF.findViewById(R.id.frs_private_common_image);
        this.fhE = (TextView) this.bOF.findViewById(R.id.frs_private_common_title);
        this.eXp = (TextView) this.bOF.findViewById(R.id.frs_private_common_hint);
        this.fze = (TextView) this.bOF.findViewById(R.id.frs_private_common_button);
        this.fzf = (RelativeLayout) this.bOF.findViewById(R.id.frs_private_common_tips);
        this.fzg = (TextView) this.bOF.findViewById(R.id.frs_private_center_tip);
        this.fzh = (TextView) this.bOF.findViewById(R.id.frs_private_left_tip);
        this.fzi = (TextView) this.bOF.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.bXK);
        setTextAttribute(Arrays.asList(this.fzg, this.fzh, this.fzi));
        com.baidu.tbadk.core.util.am.k(this.bOF, R.drawable.bg_frs_private_dialog);
        com.baidu.tbadk.core.util.am.j(this.fhE, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.am.j(this.eXp, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.am.i(this.fze, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        com.baidu.tbadk.core.util.am.j(this.fze, R.color.cp_cont_a);
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
        ViewGroup.LayoutParams layoutParams = this.bXK.getLayoutParams();
        layoutParams.width = af;
        layoutParams.height = (af * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.g(this.context, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }
}
