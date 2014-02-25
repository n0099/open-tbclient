package com.baidu.tieba.data.emotions;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private static l a = new l();
    private ArrayList<WritableEmotionGroup> b = new ArrayList<>();
    private k c;
    private List<a> d;

    public static l a() {
        return a;
    }

    public void b() {
        com.baidu.adp.lib.f.d.a().a(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c() {
        ArrayList arrayList = new ArrayList();
        if (this.c == null) {
            this.c = new k();
        }
        arrayList.add(this.c);
        if (af.a()) {
            for (MyEmotionGroupData myEmotionGroupData : j.a().c(TiebaApplication.A())) {
                EmotionGroupData a2 = j.a().a(myEmotionGroupData.groupId);
                if (a2 != null) {
                    e eVar = new e(a2);
                    if (eVar.i() != null) {
                        arrayList.add(eVar);
                    }
                }
            }
            if (this.d != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.d.size()) {
                        break;
                    }
                    a aVar = this.d.get(i2);
                    if (aVar.b() && j.a().a(aVar.e()) == null) {
                        arrayList.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
        }
        new Handler(Looper.getMainLooper()).post(new n(this, arrayList));
    }

    private l() {
    }

    public boolean a(String str) {
        Iterator<WritableEmotionGroup> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().a(str)) {
                return true;
            }
        }
        return false;
    }

    public String a(String str, boolean z) {
        if (this.c == null || !z || this.c.a(str)) {
            return str;
        }
        return "#@" + str;
    }

    public com.baidu.adp.widget.ImageView.b b(String str) {
        return com.baidu.tbadk.imageManager.e.a().c(str);
    }

    public com.baidu.adp.widget.ImageView.b c(String str) {
        return com.baidu.tbadk.imageManager.e.a().c(a(str, true));
    }

    public com.baidu.adp.widget.ImageView.b a(String str, String str2) {
        com.baidu.adp.widget.ImageView.b bVar;
        Bitmap a2;
        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(str2);
        if (c != null) {
            return c;
        }
        Iterator<WritableEmotionGroup> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = c;
                break;
            }
            WritableEmotionGroup next = it.next();
            if (next.a(str2)) {
                bVar = next.b(str2);
                break;
            }
        }
        if (bVar == null && str != null && (a2 = d.a(str, d.a(str2, false))) != null) {
            bVar = new com.baidu.adp.widget.ImageView.b(a2, false, str2);
        }
        a(str2, bVar, false);
        return bVar;
    }

    public com.baidu.adp.widget.ImageView.b b(String str, String str2) {
        com.baidu.adp.widget.ImageView.b bVar;
        if (this.c == null) {
            return null;
        }
        com.baidu.adp.widget.ImageView.b c = c(str2);
        if (c != null) {
            return c;
        }
        Iterator<WritableEmotionGroup> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = c;
                break;
            }
            WritableEmotionGroup next = it.next();
            if (next.a(str2)) {
                bVar = next.c(str2);
                break;
            }
        }
        if (bVar == null && str != null) {
            bVar = d.b(str, d.a(str2, true));
        }
        a(str2, bVar, true);
        return bVar;
    }

    public void a(String str, com.baidu.adp.widget.ImageView.b bVar, boolean z) {
        if (bVar != null) {
            if (z) {
                if (!this.c.a(str)) {
                    str = "#@" + str;
                }
                com.baidu.tbadk.imageManager.e.a().b(str, bVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.a().b(str, bVar, false);
        }
    }

    public ArrayList<WritableEmotionGroup> d() {
        return this.b;
    }

    public WritableEmotionGroup d(String str) {
        Iterator<WritableEmotionGroup> it = this.b.iterator();
        while (it.hasNext()) {
            WritableEmotionGroup next = it.next();
            if (next.e().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public synchronized void a(List<AdsEmotionGroupData> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                boolean z = false;
                for (AdsEmotionGroupData adsEmotionGroupData : list) {
                    if (!TextUtils.isEmpty(adsEmotionGroupData.getGroupId()) && !TextUtils.isEmpty(adsEmotionGroupData.getColorCoverUrl())) {
                        a aVar = new a(adsEmotionGroupData);
                        linkedList.add(aVar);
                        z = z || aVar.a(adsEmotionGroupData, new o(this));
                    }
                }
                this.d = linkedList;
                if (z) {
                    b();
                }
            }
        }
        if (this.d != null) {
            this.d = null;
            b();
        }
    }
}
