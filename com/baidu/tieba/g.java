package com.baidu.tieba;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements FileFilter {
    final /* synthetic */ LogoActivity avg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.avg = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.avg.getPageContext().getString(t.app_name)) && name.endsWith(".apk");
    }
}
