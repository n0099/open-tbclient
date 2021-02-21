package com.baidu.tieba.ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.tieba.recapp.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class a implements j {
    private static final Pattern pattern = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private static a ggM = new a();
    private final List<j.a> mListeners = new LinkedList();
    private final ConcurrentHashMap<String, j.b> mHandlers = new ConcurrentHashMap<>();
    private j.c ggN = null;

    private a() {
    }

    public static a bLn() {
        return ggM;
    }

    public void a(final j.a aVar) {
        if (l.isMainThread()) {
            b(aVar);
        } else {
            e.mA().post(new Runnable() { // from class: com.baidu.tieba.ad.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j.a aVar) {
        if (!this.mListeners.contains(aVar)) {
            this.mListeners.add(aVar);
        }
    }

    public void a(j.c cVar) {
        this.ggN = cVar;
    }

    public boolean a(Context context, String[] strArr, boolean z, j.d dVar, boolean z2, Bundle bundle) {
        return a(context, "", strArr, z, dVar, z2, bundle);
    }

    public int b(Context context, String[] strArr) {
        int c;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        for (j.a aVar : this.mListeners) {
            if (aVar != null && (c = aVar.c(context, strArr)) != 3) {
                return c;
            }
        }
        return 3;
    }

    public boolean a(Context context, String str, String[] strArr, boolean z, j.d dVar, boolean z2, Bundle bundle) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        boolean z3 = false;
        String str2 = strArr[0];
        j.b bVar = this.mHandlers.get(getSchemaKey(str2));
        if (bVar != null) {
            bVar.l(context, getInnerParamPair(Ez(str2)));
            return true;
        }
        Iterator<j.a> it = this.mListeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j.a next = it.next();
            if (next != null && next.c(context, strArr) != 3) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.ggN != null) {
            if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                return true;
            }
            a(context, str, strArr[0], z, dVar, z2, bundle);
        }
        return z3;
    }

    private String Ez(String str) {
        int lastIndexOf;
        if (!StringUtils.isNull(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    private Map<String, String> getInnerParamPair(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("[&]");
        if (split == null) {
            hashMap.put(UrlManager.DEFAULT_PARAM, str);
            return hashMap;
        }
        for (String str2 : split) {
            String[] split2 = str2.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    private String getSchemaKey(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.contains(":")) {
            return str.substring(0, str.lastIndexOf(":"));
        }
        return str;
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean a(Context context, String[] strArr, Bundle bundle) {
        return a(context, strArr, false, null, false, bundle);
    }

    @Override // com.baidu.tieba.recapp.j
    public void a(Context context, String[] strArr, boolean z, Bundle bundle) {
        a(context, strArr, false, null, z, bundle);
    }

    private void a(Context context, String str, String str2, boolean z, j.d dVar, boolean z2, Bundle bundle) {
        if (pattern.matcher(str2).find()) {
            this.ggN.b(context, str, str2, z, dVar, z2, bundle);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean EA(String str) {
        return pattern.matcher(str).find();
    }
}
