package com.baidu.tbadk.coreExtra.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import com.baidu.adp.base.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.CustomPushPremissionDialogView;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).AZ(string).Ba(format).a(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), bVar).b(TbadkCoreApplication.getInst().getContext().getString(R.string.cancel), bVar2).b(tbPageContext);
        b.bmC();
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
        aVar.AZ(str);
        aVar.Ba(str2);
        aVar.a(str3, bVar);
        aVar.b(str4, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static void a(TbPageContext<?> tbPageContext, boolean[] zArr, int i) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && zArr != null && zArr.length == 2) {
            a(tbPageContext, i, 0L);
        }
    }

    public static void f(e eVar) {
        try {
            if (g.isHuaWei()) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", eVar.getPageActivity().getPackageName(), null));
                eVar.getPageActivity().startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("android.provider.extra.APP_PACKAGE", eVar.getPageActivity().getPackageName());
                intent2.putExtra("android.provider.extra.CHANNEL_ID", eVar.getPageActivity().getApplicationInfo().uid);
                intent2.putExtra("app_package", eVar.getPageActivity().getPackageName());
                intent2.putExtra("app_uid", eVar.getPageActivity().getApplicationInfo().uid);
                eVar.getPageActivity().startActivity(intent2);
            }
        } catch (Exception e) {
            Intent intent3 = new Intent();
            intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.fromParts("package", eVar.getPageActivity().getPackageName(), null));
            eVar.getPageActivity().startActivity(intent3);
        }
    }

    public static boolean w(Context context, int i) {
        boolean z = false;
        if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bnH().getLong("push_permission_dialog_scene_cold_start_key", 0L));
            Date date2 = new Date(com.baidu.tbadk.core.sharedPref.b.bnH().getLong("push_permission_dialog_scene_interaction_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i == 0 && bd.b(date3, date2) >= 7 && !bd.c(date3, date)) {
                z = true;
            }
            if (i == 1 && bd.b(date3, date) >= 7 && !bd.c(date3, date2)) {
                z = true;
            }
            if (z) {
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.sharedPref.b.bnH().putLong("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                        break;
                    case 1:
                        com.baidu.tbadk.core.sharedPref.b.bnH().putLong("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                        break;
                }
            }
        }
        return z;
    }

    public static void a(final TbPageContext<?> tbPageContext, final int i, long j) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.iM(false);
        aVar.a((String) null, (a.b) null);
        aVar.b((String) null, (a.b) null);
        aVar.op(4);
        CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
        aVar.bb(customPushPremissionDialogView);
        final int[] iArr = {-1};
        customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.f(TbPageContext.this);
                iArr[0] = 1;
                aVar.dismiss();
            }
        });
        customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.c.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                iArr[0] = 2;
                aVar.dismiss();
            }
        });
        aVar.d(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.coreExtra.c.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aq aqVar = new aq("c13673");
                aqVar.aj("obj_source", i);
                aqVar.aj("obj_type", iArr[0]);
                TiebaStatic.log(aqVar);
            }
        });
        if (j > 0) {
            aVar.b(tbPageContext).cP(j);
        } else {
            aVar.b(tbPageContext).bmC();
        }
        aq aqVar = new aq("c13674");
        aqVar.aj("obj_source", i);
        TiebaStatic.log(aqVar);
    }
}
