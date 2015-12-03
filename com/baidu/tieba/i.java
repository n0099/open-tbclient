package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.n;
import java.io.File;
import java.io.FileFilter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements FileFilter {
    final /* synthetic */ LogoActivity aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.aFj = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.aFj.getPageContext().getString(n.i.app_name)) && name.endsWith(".apk");
    }
}
