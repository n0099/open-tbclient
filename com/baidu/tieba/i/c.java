package com.baidu.tieba.i;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class c implements FileFilter {
    private final /* synthetic */ String dUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.dUo = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().startsWith(this.dUo);
    }
}
