package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    public static f exy = new f();
    private com.baidu.adp.lib.e.b<e> exl;
    private com.baidu.adp.lib.e.b<d> exm;
    private com.baidu.adp.lib.e.b<k> exn;

    private void bF(final Context context) {
        this.exl = new com.baidu.adp.lib.e.b<e>(new com.baidu.adp.lib.e.c<e>() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGe */
            public e nl() {
                return new e(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void as(e eVar) {
                if (eVar instanceof e) {
                    eVar.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public e at(e eVar) {
                return eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public e au(e eVar) {
                if (eVar instanceof e) {
                    eVar.reset();
                }
                return eVar;
            }
        }, 1, 0) { // from class: com.baidu.tieba.im.chat.officialBar.f.2
        };
    }

    private void bG(final Context context) {
        this.exm = new com.baidu.adp.lib.e.b<d>(new com.baidu.adp.lib.e.c<d>() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGf */
            public d nl() {
                return new d(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public void as(d dVar) {
                if (dVar instanceof d) {
                    dVar.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: g */
            public d at(d dVar) {
                return dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: h */
            public d au(d dVar) {
                if (dVar instanceof d) {
                    dVar.reset();
                }
                return dVar;
            }
        }, 9, 0) { // from class: com.baidu.tieba.im.chat.officialBar.f.4
        };
    }

    private void bH(final Context context) {
        this.exn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<k>() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGg */
            public k nl() {
                return new k(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(k kVar) {
                if (kVar instanceof k) {
                    kVar.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public k at(k kVar) {
                return kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public k au(k kVar) {
                if (kVar instanceof k) {
                    kVar.reset();
                }
                return kVar;
            }
        }, 1, 0);
    }

    public com.baidu.adp.lib.e.b<e> bI(Context context) {
        if (this.exl == null) {
            bF(context);
        }
        return this.exl;
    }

    public com.baidu.adp.lib.e.b<d> bJ(Context context) {
        if (this.exm == null) {
            bG(context);
        }
        return this.exm;
    }

    public com.baidu.adp.lib.e.b<k> bK(Context context) {
        if (this.exn == null) {
            bH(context);
        }
        return this.exn;
    }
}
