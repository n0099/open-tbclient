package com.baidu.tbadk.coreExtra.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MsgRemindActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).vN(string).vO(format).a(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), bVar).b(TbadkCoreApplication.getInst().getContext().getString(R.string.cancel), bVar2).b(tbPageContext);
        b.aST();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, a.b bVar, a.b bVar2) {
        String str = null;
        if (i >= 0) {
            str = TbadkCoreApplication.getInst().getContext().getString(i);
        }
        return a(tbPageContext, str, TbadkCoreApplication.getInst().getContext().getString(i2), TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), bVar, bVar2);
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.b bVar, a.b bVar2) {
        if (tbPageContext == null) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.vN(str);
        aVar.vO(str2);
        aVar.a(str3, bVar);
        aVar.b(str4, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static void a(final TbPageContext<?> tbPageContext, final boolean[] zArr, String str, String str2, final int i) {
        int equipmentWidth;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && zArr != null && zArr.length == 2 && str2 != null) {
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.notification_permission_dialog, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.notification_permission_image);
            TextView textView = (TextView) inflate.findViewById(R.id.permission_btn);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.close_btn);
            TextView textView2 = (TextView) inflate.findViewById(R.id.permission_des);
            TextView textView3 = (TextView) inflate.findViewById(R.id.permission_title);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.aP(inflate);
            aVar.kG(2);
            aVar.gX(true);
            aVar.gW(true);
            aVar.setAutoNight(true);
            int dimens = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
            am.c(inflate, dimens, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            tbImageView.setRadius(dimens);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int dimens2 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
                equipmentWidth = l.getEquipmentHeight(tbPageContext.getPageActivity()) - (dimens2 * 2);
            } else {
                equipmentWidth = l.getEquipmentWidth(tbPageContext.getPageActivity()) - (dimens2 * 2);
            }
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (equipmentWidth * 556) / 988;
            tbImageView.setLayoutParams(layoutParams);
            am.setImageResource(tbImageView, R.drawable.pic_notification_permission);
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable mutate = tbPageContext.getResources().getDrawable(R.drawable.icon_prefession_popup_close_n).getConstantState().newDrawable().mutate();
            Drawable mutate2 = tbPageContext.getResources().getDrawable(R.drawable.icon_prefession_popup_close_n).getConstantState().newDrawable().mutate();
            mutate2.setAlpha(128);
            stateListDrawable.addState(new int[]{16842919}, mutate2);
            stateListDrawable.addState(new int[0], mutate);
            imageView.setBackgroundDrawable(stateListDrawable);
            com.baidu.tbadk.core.util.e.a.aF(R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50).a(textView);
            textView2.setText(str2);
            am.setViewTextColor(textView2, (int) R.color.cp_cont_j);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView3.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            if (StringUtils.isNull(str)) {
                textView3.setVisibility(8);
                layoutParams3.addRule(3, R.id.notification_permission_image);
                layoutParams3.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds68);
                textView2.setLayoutParams(layoutParams3);
                layoutParams4.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds83);
                layoutParams4.bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds81);
                textView.setLayoutParams(layoutParams4);
            } else {
                textView3.setVisibility(0);
                textView3.setText(str);
                am.setViewTextColor(textView3, (int) R.color.cp_cont_b);
                layoutParams2.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds70);
                textView3.setLayoutParams(layoutParams2);
                layoutParams3.addRule(3, R.id.permission_title);
                layoutParams3.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds10);
                textView2.setLayoutParams(layoutParams3);
                layoutParams4.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds80);
                layoutParams4.bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds81);
                textView.setLayoutParams(layoutParams4);
            }
            final int[] iArr = {2};
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (zArr[0]) {
                        a.g(tbPageContext);
                    } else if (zArr[1]) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MsgRemindActivityConfig(tbPageContext.getPageActivity())));
                    }
                    iArr[0] = 1;
                    aVar.dismiss();
                }
            });
            an anVar = new an("c13674");
            anVar.ag("obj_source", i);
            TiebaStatic.log(anVar);
            aVar.c(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.coreExtra.c.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    an anVar2 = new an("c13673");
                    anVar2.ag("obj_source", i);
                    anVar2.ag("obj_type", iArr[0]);
                    TiebaStatic.log(anVar2);
                }
            });
            aVar.b(tbPageContext).aST();
        }
    }

    public static void g(TbPageContext tbPageContext) {
        try {
            if (g.isHuaWei()) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", tbPageContext.getPageActivity().getPackageName(), null));
                tbPageContext.getPageActivity().startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("android.provider.extra.APP_PACKAGE", tbPageContext.getPageActivity().getPackageName());
                intent2.putExtra("android.provider.extra.CHANNEL_ID", tbPageContext.getPageActivity().getApplicationInfo().uid);
                intent2.putExtra("app_package", tbPageContext.getPageActivity().getPackageName());
                intent2.putExtra("app_uid", tbPageContext.getPageActivity().getApplicationInfo().uid);
                tbPageContext.getPageActivity().startActivity(intent2);
            }
        } catch (Exception e) {
            Intent intent3 = new Intent();
            intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.fromParts("package", tbPageContext.getPageActivity().getPackageName(), null));
            tbPageContext.getPageActivity().startActivity(intent3);
        }
    }
}
