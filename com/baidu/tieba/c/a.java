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
import com.baidu.tbadk.download.b;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078a {
        void Zv();
    }

    public static boolean Zt() {
        return UtilHelper.isInstallApk(TbadkCoreApplication.getInst(), "com.baidu.tiebabz");
    }

    public static void Zu() {
        b.Cx().a("160802", "https://downpack.baidu.com/tbbazhu_AndroidPhone_1017265l.apk", "贴吧吧主版", null);
    }

    public static void a(e<?> eVar, int i, int i2) {
        if (!Zt()) {
            String str = "";
            switch (i2) {
                case 1:
                    str = eVar.getString(d.j.delete_page);
                    break;
                case 2:
                    str = eVar.getString(d.j.commit_good);
                    break;
                case 3:
                    str = eVar.getString(d.j.cancel_good);
                    break;
                case 4:
                    str = eVar.getString(d.j.top);
                    break;
                case 5:
                    str = eVar.getString(d.j.cancel_top);
                    break;
            }
            a(eVar, i, str + eVar.getString(d.j.bawu_operation_tips));
        }
    }

    public static void a(e<?> eVar, final int i, String str) {
        if (!Zt()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(eVar.getPageActivity());
            aVar.cS(str);
            aVar.a(d.j.download, new a.b() { // from class: com.baidu.tieba.c.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    a.Zu();
                    String str2 = "";
                    if (i == 1) {
                        str2 = "c11568";
                    } else if (i == 2) {
                        str2 = "c11572";
                    } else if (i == 3) {
                        str2 = "c11576";
                    }
                    TiebaStatic.log(str2);
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.c.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    String str2 = "";
                    if (i == 1) {
                        str2 = "c11569";
                    } else if (i == 2) {
                        str2 = "c11573";
                    } else if (i == 3) {
                        str2 = "c11575";
                    }
                    TiebaStatic.log(str2);
                }
            });
            aVar.b(eVar);
            aVar.th();
        }
    }

    public static void a(e<?> eVar, String str, String str2, InterfaceC0078a interfaceC0078a) {
        if (!Zt() || !h(eVar.getPageActivity(), str, str2)) {
            if (j.hh()) {
                if (j.hi()) {
                    a(eVar, 1, eVar.getString(d.j.bawu_center_wifi_tips));
                    return;
                } else {
                    a(eVar, interfaceC0078a);
                    return;
                }
            }
            UtilHelper.showToast(eVar.getPageActivity(), d.j.neterror);
        }
    }

    public static boolean h(Context context, String str, String str2) {
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

    public static boolean i(Context context, String str, String str2) {
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

    private static void a(e<?> eVar, final InterfaceC0078a interfaceC0078a) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(eVar.getPageActivity());
        aVar.cS(eVar.getString(d.j.bawu_center_3g_tips));
        aVar.a(d.j.download, new a.b() { // from class: com.baidu.tieba.c.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.Zu();
                TiebaStatic.log("c11577");
            }
        });
        aVar.b(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.c.a.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (InterfaceC0078a.this != null) {
                    InterfaceC0078a.this.Zv();
                }
                TiebaStatic.log("c11574");
            }
        });
        aVar.b(eVar);
        aVar.th();
    }
}
