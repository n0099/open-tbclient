package com.baidu.tieba.frs.utils;

import android.content.DialogInterface;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnCancelListener {
    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        u.cbN = null;
        PluginPackageManager.jt().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
