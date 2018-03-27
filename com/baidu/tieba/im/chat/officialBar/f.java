package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    public static f exO = new f();
    private com.baidu.adp.lib.e.b<e> exC;
    private com.baidu.adp.lib.e.b<d> exD;
    private com.baidu.adp.lib.e.b<k> exE;

    private void bF(final Context context) {
        this.exC = new com.baidu.adp.lib.e.b<e>(new com.baidu.adp.lib.e.c<e>() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGf */
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
        this.exD = new com.baidu.adp.lib.e.b<d>(new com.baidu.adp.lib.e.c<d>() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGg */
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
        this.exE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<k>() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGh */
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
        if (this.exC == null) {
            bF(context);
        }
        return this.exC;
    }

    public com.baidu.adp.lib.e.b<d> bJ(Context context) {
        if (this.exD == null) {
            bG(context);
        }
        return this.exD;
    }

    public com.baidu.adp.lib.e.b<k> bK(Context context) {
        if (this.exE == null) {
            bH(context);
        }
        return this.exE;
    }
}
