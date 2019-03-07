package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    public static boolean ay(Context context, String str) {
        return b(dj(context), str);
    }

    private static TbPageContext dj(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public static boolean py(String str) {
        return pz(str) && !ck(str);
    }

    public static boolean b(TbPageContext<?> tbPageContext, String str) {
        if (!pz(str)) {
            a(tbPageContext, tbPageContext.getResources().getString(d.j.current_plugin_not_install), tbPageContext.getResources().getString(d.j.plugin_go_install), str);
            return false;
        } else if (ck(str)) {
            a(tbPageContext, tbPageContext.getResources().getString(d.j.current_plugin_not_active), tbPageContext.getResources().getString(d.j.setup), str);
            return false;
        } else {
            return true;
        }
    }

    private static boolean pz(String str) {
        return PluginPackageManager.ni().bT(str);
    }

    private static boolean ck(String str) {
        return PluginPackageManager.ni().bZ(str);
    }

    private static void a(final TbPageContext<?> tbPageContext, String str, String str2, final String str3) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.ly(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.plugins.c.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            } else {
                aVar.a(str2, new a.b() { // from class: com.baidu.tbadk.plugins.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PluginPackageManager.ni().getPluginConfig(str3) != null) {
                            tbPageContext.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(pageActivity, str3)));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(pageActivity)));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            aVar.b(tbPageContext).aaZ();
        }
    }
}
