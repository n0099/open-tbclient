package com.baidu.tbadk.plugins;

import android.content.Context;
/* loaded from: classes.dex */
public interface BaobaoSdkDelegate {
    public static final String KEY_BITMAP = "key_bitmap";
    public static final String KEY_BITMAPPATH = "key_bitmap_path";
    public static final String KEY_CONTENT = "key_content";

    boolean checkHasInstalled(Context context);

    void clearFont();

    void clearImage();

    String getJumpUrl();

    void init(boolean z, String str);

    void launchBaobao(Context context);

    void startMatchImage(Context context, String str, int i);
}
