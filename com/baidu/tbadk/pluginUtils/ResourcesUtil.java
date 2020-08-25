package com.baidu.tbadk.pluginUtils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ResourcesUtil {
    private static HashMap<String, Resources> sResources = new HashMap<>();

    public static Resources getResources(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null.");
        }
        if (TextUtils.isEmpty(str)) {
            return context.getResources();
        }
        Resources resources = sResources.get(str);
        if (resources == null) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
                resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
            } catch (Exception e) {
                resources = context.getResources();
            }
        }
        sResources.put(str, resources);
        return resources;
    }
}
