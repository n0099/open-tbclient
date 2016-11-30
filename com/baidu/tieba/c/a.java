package com.baidu.tieba.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        void OT();
    }

    public static boolean OR() {
        return UtilHelper.isInstallApk(TbadkCoreApplication.m9getInst(), "com.baidu.tiebabz");
    }

    public static void OS() {
        com.baidu.tbadk.download.b.CD().a("160802", "https://downpack.baidu.com/tbbazhu_AndroidPhone_1017265l.apk", "贴吧吧主版", null);
    }

    public static void a(h<?> hVar, int i, int i2) {
        if (!OR()) {
            String str = "";
            switch (i2) {
                case 1:
                    str = hVar.getString(r.j.delete_page);
                    break;
                case 2:
                    str = hVar.getString(r.j.commit_good);
                    break;
                case 3:
                    str = hVar.getString(r.j.cancel_good);
                    break;
                case 4:
                    str = hVar.getString(r.j.commit_top);
                    break;
                case 5:
                    str = hVar.getString(r.j.cancel_top);
                    break;
            }
            a(hVar, i, String.valueOf(str) + hVar.getString(r.j.bawu_operation_tips));
        }
    }

    public static void a(h<?> hVar, int i, String str) {
        if (!OR()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(hVar.getPageActivity());
            aVar.cF(str);
            aVar.a(r.j.download, new b(i));
            aVar.b(r.j.cancel, new c(i));
            aVar.b(hVar);
            aVar.tq();
        }
    }

    public static void a(h<?> hVar, String str, String str2, InterfaceC0056a interfaceC0056a) {
        if (!OR() || !e(hVar.getPageActivity(), str, str2)) {
            if (i.gm()) {
                if (i.gn()) {
                    a(hVar, 1, hVar.getString(r.j.bawu_center_wifi_tips));
                    return;
                } else {
                    a(hVar, interfaceC0056a);
                    return;
                }
            }
            UtilHelper.showToast(hVar.getPageActivity(), r.j.neterror);
        }
    }

    public static boolean e(Context context, String str, String str2) {
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
            Intent intent2 = null;
            if (0 == 0) {
                try {
                    intent2 = new Intent();
                    ComponentName componentName = new ComponentName("com.baidu.tiebabz", "com.baidu.tieba.frs.FrsActivity");
                    Bundle bundle = new Bundle();
                    bundle.putString("name", str2);
                    intent2.putExtras(bundle);
                    intent2.setComponent(componentName);
                } catch (Exception e2) {
                    if (e2 != null) {
                        BdLog.e(e2);
                        return false;
                    }
                    return false;
                }
            }
            intent2.setFlags(268435456);
            context.startActivity(intent2);
            return true;
        }
    }

    public static boolean f(Context context, String str, String str2) {
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
            Intent intent2 = null;
            if (0 == 0) {
                try {
                    intent2 = new Intent();
                    ComponentName componentName = new ComponentName("com.baidu.tiebabz", "com.baidu.tieba.pb.pb.main.PbActivity");
                    Bundle bundle = new Bundle();
                    bundle.putString("thread_id", str);
                    if (!TextUtils.isEmpty(str2)) {
                        bundle.putString("post_id", str2);
                    }
                    intent2.putExtras(bundle);
                    intent2.setComponent(componentName);
                } catch (Exception e2) {
                    if (e2 != null) {
                        BdLog.e(e2);
                        return false;
                    }
                    return false;
                }
            }
            intent2.setFlags(268435456);
            context.startActivity(intent2);
            return true;
        }
    }

    public static boolean a(Context context, String str, String str2, int i) {
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

    private static void a(h<?> hVar, InterfaceC0056a interfaceC0056a) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(hVar.getPageActivity());
        aVar.cF(hVar.getString(r.j.bawu_center_3g_tips));
        aVar.a(r.j.download, new d());
        aVar.b(r.j.continue_forward, new e(interfaceC0056a));
        aVar.b(hVar);
        aVar.tq();
    }
}
