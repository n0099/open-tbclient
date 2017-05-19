package com.baidu.tieba.g;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class c implements FileFilter {
    private final /* synthetic */ String dOR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.dOR = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().startsWith(this.dOR);
    }
}
