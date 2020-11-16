package com.baidu.tbadk.coreExtra.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
public class a {
    public static void a(ShareItem shareItem, final Context context, final int i, final DialogInterface.OnCancelListener onCancelListener) {
        if (shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title) && (context instanceof Activity)) {
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.fgA);
            Activity activity = (Activity) context;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.AI(context.getString(R.string.command_share_tips));
            aVar.AJ(shareItem.fgA);
            aVar.setAutoNight(false);
            aVar.iW(true);
            aVar.setTitleShowCenter(true);
            aVar.a(j(i, context), new a.b() { // from class: com.baidu.tbadk.coreExtra.share.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.i(i, context);
                    aVar2.dismiss();
                    onCancelListener.onCancel(aVar2.getDialog());
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.share.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    onCancelListener.onCancel(aVar2.getDialog());
                }
            }).b(i.I(activity));
            if (onCancelListener != null) {
                aVar.c(onCancelListener);
            }
            aVar.bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(int i, Context context) {
        Intent intent = null;
        if (i == 3 || i == 2) {
            if (!v(context, i)) {
                BdToast.b(context.getApplicationContext(), context.getText(R.string.share_wechat_not_install)).bom();
                return;
            }
            intent = new Intent("android.intent.action.MAIN");
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            context.startActivity(intent);
        } else if (i == 8 || i == 4) {
            if (!v(context, i)) {
                BdToast.b(context.getApplicationContext(), context.getText(R.string.share_qq_not_install)).bom();
                return;
            }
            intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else if (i == 6) {
            if (!v(context, i)) {
                BdToast.b(context.getApplicationContext(), context.getText(R.string.share_sina_weibo_not_install)).bom();
                return;
            }
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("sinaweibo://splash"));
            intent.addFlags(268435456);
        }
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    public static boolean v(Context context, int i) {
        if (i == 3 || i == 2) {
            return y.isInstalledPackage(context, "com.tencent.mm");
        }
        if (i == 8 || i == 4) {
            return y.isInstalledPackage(context, "com.tencent.mobileqq");
        }
        if (i == 6) {
            return y.isInstalledPackage(context, "com.sina.weibo");
        }
        return true;
    }

    private static String j(int i, Context context) {
        if (i == 3 || i == 2) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.wechat));
        }
        if (i == 8 || i == 4) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.qq));
        }
        if (i == 6) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.sinaweibo));
        }
        return null;
    }
}
