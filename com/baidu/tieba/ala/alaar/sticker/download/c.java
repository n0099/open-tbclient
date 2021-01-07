package com.baidu.tieba.ala.alaar.sticker.download;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class c {
    private CharSequence mDescription;
    private File mFolder;
    private CharSequence mName;
    private String mUri;

    private c() {
    }

    private c(String str, File file, CharSequence charSequence, CharSequence charSequence2) {
        this.mUri = str;
        this.mFolder = file;
        this.mName = charSequence;
        this.mDescription = charSequence2;
    }

    public String getUri() {
        return this.mUri;
    }

    public File getFolder() {
        return this.mFolder;
    }

    public CharSequence getName() {
        if (TextUtils.isEmpty(this.mName)) {
            this.mName = com.baidu.tieba.ala.alaar.sticker.b.c.getFileFullName(getUri());
        }
        return this.mName;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private CharSequence mDescription;
        private File mFolder;
        private CharSequence mName;
        private String mUri;

        public a Gl(String str) {
            this.mUri = str;
            return this;
        }

        public a aa(File file) {
            this.mFolder = file;
            return this;
        }

        public a s(CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        public c bSY() {
            return new c(this.mUri, this.mFolder, this.mName, this.mDescription);
        }
    }
}
