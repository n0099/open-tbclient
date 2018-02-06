package com.baidu.tieba.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0135a {
        void akN();
    }

    public static boolean akM() {
        return UtilHelper.isInstallApk(TbadkCoreApplication.getInst(), "com.baidu.tiebabz");
    }

    public static void a(e<?> eVar, String str, String str2, InterfaceC0135a interfaceC0135a) {
        if (!akM() || !i(eVar.getPageActivity(), str, str2)) {
            if (j.oJ()) {
                if (!j.oK()) {
                    a(eVar, interfaceC0135a);
                    return;
                }
                return;
            }
            UtilHelper.showToast(eVar.getPageActivity(), d.j.neterror);
        }
    }

    public static boolean i(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            BdLog.e("fname is null");
            return false;
        }
        try {
            Intent intent = new Intent();
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("tbbzfrs");
            builder.authority("tieba.baidu.com");
            StringBuilder sb = new StringBuilder(50);
            sb.append("?kw=");
            sb.append(str2);
            sb.append("&from=tieba");
            builder.path(sb.toString());
            Uri build = builder.build();
            BdLog.i(build.toString());
            intent.setData(build);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            try {
                Intent intent2 = new Intent();
                ComponentName componentName = new ComponentName("com.baidu.tiebabz", "com.baidu.tieba.frs.FrsActivity");
                Bundle bundle = new Bundle();
                bundle.putString("name", str2);
                intent2.putExtras(bundle);
                intent2.setComponent(componentName);
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return true;
            } catch (Exception e2) {
                if (e2 != null) {
                    BdLog.e(e2);
                    return false;
                }
                return false;
            }
        }
    }

    public static boolean j(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("tid is null");
            return false;
        }
        try {
            Intent intent = new Intent();
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("tbbzpb");
            builder.authority("tieba.baidu.com");
            StringBuilder sb = new StringBuilder(50);
            sb.append("?from=tieba");
            sb.append("&pid=");
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            sb.append(str2);
            sb.append("&tid=");
            sb.append(str);
            builder.path(sb.toString());
            Uri build = builder.build();
            BdLog.i(build.toString());
            intent.setData(build);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            try {
                Intent intent2 = new Intent();
                ComponentName componentName = new ComponentName("com.baidu.tiebabz", "com.baidu.tieba.pb.pb.main.PbActivity");
                Bundle bundle = new Bundle();
                bundle.putString("thread_id", str);
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("post_id", str2);
                }
                intent2.putExtras(bundle);
                intent2.setComponent(componentName);
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return true;
            } catch (Exception e2) {
                if (e2 != null) {
                    BdLog.e(e2);
                    return false;
                }
                return false;
            }
        }
    }

    public static boolean b(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            BdLog.e("tid or pid null");
            return false;
        }
        try {
            Intent intent = new Intent();
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("tbbzsubpb");
            builder.authority("tieba.baidu.com");
            StringBuilder sb = new StringBuilder(50);
            sb.append("?tid=");
            sb.append(str);
            sb.append("&pid=");
            sb.append(str2);
            sb.append("&userIdentity=");
            sb.append(i);
            sb.append("&from=tieba");
            builder.path(sb.toString());
            Uri build = builder.build();
            BdLog.i(build.toString());
            intent.setData(build);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void a(e<?> eVar, final InterfaceC0135a interfaceC0135a) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(eVar.getPageActivity());
        aVar.dk(eVar.getString(d.j.bawu_center_3g_tips));
        aVar.a(d.j.download, new a.b() { // from class: com.baidu.tieba.c.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                TiebaStatic.log("c11577");
            }
        });
        aVar.b(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.c.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (InterfaceC0135a.this != null) {
                    InterfaceC0135a.this.akN();
                }
                TiebaStatic.log("c11574");
            }
        });
        aVar.b(eVar);
        aVar.AU();
    }
}
