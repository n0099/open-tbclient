package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.core.util.b {
    public ab(Context context) {
        super(context);
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.d dVar, boolean z2) {
        String b = ac.a().b(str2, z);
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(b);
        if (c == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("em_sharp_text", str2);
            hashMap.put("em_load_gif", Boolean.valueOf(z));
            if (str != null) {
                hashMap.put("em_group_id", str);
            }
            if (str3 != null) {
                hashMap.put("em_img_url", str3);
            }
            return a(b, dVar, 6, true, false, false, false, hashMap, z2);
        }
        return c;
    }

    @Deprecated
    public com.baidu.adp.widget.a.a a(String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, str2, str3, z, dVar, false);
    }

    @Deprecated
    public com.baidu.adp.widget.a.a a(String str, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        return a((String) null, str, (String) null, z, dVar);
    }
}
