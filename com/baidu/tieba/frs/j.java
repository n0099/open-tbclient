package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j {
    public static void a(Activity activity, TbPageContext<?> tbPageContext) {
        int equipmentWidth;
        if (activity != null && tbPageContext != null) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_general_tab_notify_dialog_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.general_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.general_content_1);
            TextView textView3 = (TextView) inflate.findViewById(R.id.general_content_2);
            TextView textView4 = (TextView) inflate.findViewById(R.id.general_content_3);
            TextView textView5 = (TextView) inflate.findViewById(R.id.general_btn);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.top_general_image);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.aO(inflate);
            aVar.jZ(2);
            aVar.fI(true);
            aVar.setAutoNight(true);
            aVar.fH(true);
            int dimens = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds31);
            com.baidu.tbadk.core.util.am.c(inflate, dimens, R.color.cp_bg_line_d, R.color.cp_cont_a);
            tbImageView.setRadius(dimens);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(activity) == 2) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(activity) - (dimens2 * 2);
            } else {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(activity) - (dimens2 * 2);
            }
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (equipmentWidth * 556) / 988;
            tbImageView.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.am.setImageResource(tbImageView, R.drawable.frs_general_tab_notify_pic);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView2, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView3, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView4, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView5, (int) R.color.cp_link_tip_a);
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            });
            aVar.b(tbPageContext).aEG();
        }
    }
}
