package com.baidu.tbadk.motu_gallery;

import android.net.Uri;
import android.provider.MediaStore;
/* loaded from: classes.dex */
public class c {
    public int Wf;
    public String path;
    public int type;
    public Uri uri;

    public c(int i, String str, int i2) {
        this.type = i;
        this.path = str;
        this.Wf = i2;
        this.uri = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.Wf));
    }
}
