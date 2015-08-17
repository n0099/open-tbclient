package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.i;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class g implements FileFilter {
    final /* synthetic */ LogoActivity aCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.aCy = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.aCy.getPageContext().getString(i.C0057i.app_name)) && name.endsWith(".apk");
    }
}
