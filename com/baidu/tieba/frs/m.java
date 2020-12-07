package com.baidu.tieba.frs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.WindowToast;
/* loaded from: classes.dex */
public class m {
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
            aVar.bi(inflate);
            aVar.oT(2);
            aVar.jm(true);
            aVar.setAutoNight(true);
            aVar.jl(true);
            int dimens = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds31);
            com.baidu.tbadk.core.util.ap.d(inflate, dimens, R.color.CAM_X0201, R.color.CAM_X0101);
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
            com.baidu.tbadk.core.util.ap.setImageResource(tbImageView, R.drawable.frs_general_tab_notify_pic);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView2, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView3, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView4, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView5, R.color.CAM_X0302);
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.m.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            });
            aVar.b(tbPageContext).brv();
        }
    }

    public static void a(final TbPageContext<?> tbPageContext, WindowToast windowToast, final String str, final String str2) {
        int equipmentWidth;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            final int intValue = windowToast.toast_type.intValue();
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_bazhu_exam_fail, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bazhu_exam_top_image);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bazhu_exam_close_button);
            TextView textView = (TextView) inflate.findViewById(R.id.bazhu_exam_content);
            TextView textView2 = (TextView) inflate.findViewById(R.id.bazhu_exam_btn);
            textView.setText(windowToast.toast_content);
            if (windowToast.toast_type.intValue() == 0) {
                textView2.setText(TbadkCoreApplication.getInst().getString(R.string.know));
            } else if (windowToast.toast_type.intValue() == 1) {
                textView2.setText(TbadkCoreApplication.getInst().getString(R.string.bazhu_exam_fail_btn_text));
            } else {
                return;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.bi(inflate);
            aVar.oT(2);
            aVar.jm(false);
            aVar.setAutoNight(true);
            aVar.jl(true);
            int dimens = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
            com.baidu.tbadk.core.util.ap.d(inflate, dimens, R.color.CAM_X0201, R.color.CAM_X0201);
            tbImageView.setRadius(dimens);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(tbPageContext.getPageActivity()) - (dimens2 * 2);
            } else {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - (dimens2 * 2);
            }
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (equipmentWidth * 560) / 992;
            tbImageView.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.ap.setImageResource(tbImageView, R.drawable.backguard_mask_apity);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.setViewTextColor(textView2, R.color.CAM_X0304);
            SvgManager.btW().a(imageView, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                    if (intValue == 1) {
                        com.baidu.tbadk.core.util.bf.bua().b(tbPageContext, new String[]{String.format("https://tieba.baidu.com/mo/q/bawu/taskinfoview?fn=%1$s&fid=%2$s&noshare=1", str2, str)});
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.m.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            });
            aVar.b(tbPageContext).brv();
        }
    }
}
