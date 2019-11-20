package com.baidu.tieba.ad;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.tieba.recapp.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class a implements h {
    private static final Pattern pattern = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private static a dgy = new a();
    private final List<h.a> mListeners = new LinkedList();
    private final ConcurrentHashMap<String, h.b> mHandlers = new ConcurrentHashMap<>();
    private h.c dgz = null;

    private a() {
    }

    public static a aDw() {
        return dgy;
    }

    public void a(final h.a aVar) {
        if (l.isMainThread()) {
            b(aVar);
        } else {
            e.fZ().post(new Runnable() { // from class: com.baidu.tieba.ad.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h.a aVar) {
        if (!this.mListeners.contains(aVar)) {
            this.mListeners.add(aVar);
        }
    }

    public void a(h.c cVar) {
        this.dgz = cVar;
    }

    public boolean a(Context context, String[] strArr, boolean z, h.d dVar, boolean z2) {
        return a(context, "", strArr, z, dVar, z2);
    }

    public int b(Context context, String[] strArr) {
        int d;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        for (h.a aVar : this.mListeners) {
            if (aVar != null && (d = aVar.d(context, strArr)) != 3) {
                return d;
            }
        }
        return 3;
    }

    public boolean a(Context context, String str, String[] strArr, boolean z, h.d dVar, boolean z2) {
        boolean z3;
        boolean z4;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        String str2 = strArr[0];
        h.b bVar = this.mHandlers.get(getSchemaKey(str2));
        if (bVar != null) {
            bVar.k(context, getInnerParamPair(rk(str2)));
            return true;
        }
        Iterator<h.a> it = this.mListeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            }
            h.a next = it.next();
            if (next != null && next.d(context, strArr) != 3) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.dgz != null) {
            if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                z4 = true;
                return z4;
            }
            a(context, str, strArr[0], z, dVar, z2);
        }
        z4 = z3;
        return z4;
    }

    private String rk(String str) {
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

    @Override // com.baidu.tieba.recapp.h
    public boolean c(Context context, String[] strArr) {
        return a(context, strArr, false, null, false);
    }

    @Override // com.baidu.tieba.recapp.h
    public void a(Context context, String[] strArr, boolean z) {
        a(context, strArr, false, null, z);
    }

    private void a(Context context, String str, String str2, boolean z, h.d dVar, boolean z2) {
        if (pattern.matcher(str2).find()) {
            this.dgz.b(context, str, str2, z, dVar, z2);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean rl(String str) {
        return pattern.matcher(str).find();
    }
}
