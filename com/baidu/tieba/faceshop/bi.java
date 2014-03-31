package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.download.DownloadMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
final class bi extends com.baidu.adp.framework.c.a {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(FaceShopActivity faceShopActivity, int i) {
        super(0);
        this.a = faceShopActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        bs bsVar;
        bu buVar;
        bs bsVar2;
        HashMap hashMap;
        bu buVar2;
        HashMap hashMap2;
        HashMap hashMap3;
        bu unused;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        bsVar = this.a.b;
        if (bsVar != null) {
            buVar = this.a.a;
            if (buVar == null) {
                return;
            }
            bsVar2 = this.a.b;
            FaceShopData a = bsVar2.a();
            if (a == null || a.packList == null) {
                return;
            }
            if (customResponsedMessage2.g() != 2001122) {
                if (customResponsedMessage2.g() == 2001120) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<FacePackageData> it = a.packList.iterator();
                    while (it.hasNext()) {
                        FacePackageData next = it.next();
                        if (next.downloaded == 1) {
                            next.downloaded = 0;
                        }
                        arrayList.add(String.valueOf(next.pid));
                    }
                    unused = this.a.a;
                    bu.a(arrayList);
                }
            } else if (customResponsedMessage2 instanceof DownloadMessage) {
                hashMap = this.a.d;
                hashMap.clear();
                List<com.baidu.tieba.download.a> a2 = ((DownloadMessage) customResponsedMessage2).a();
                if (a2 != null) {
                    buVar2 = this.a.a;
                    bm a3 = buVar2.a();
                    if (a3 != null) {
                        for (com.baidu.tieba.download.a aVar : a2) {
                            hashMap3 = this.a.d;
                            hashMap3.put(aVar.a(), aVar);
                        }
                        Iterator<FacePackageData> it2 = a.packList.iterator();
                        while (it2.hasNext()) {
                            FacePackageData next2 = it2.next();
                            hashMap2 = this.a.d;
                            com.baidu.tieba.download.a aVar2 = (com.baidu.tieba.download.a) hashMap2.get(String.valueOf(next2.pid));
                            if (aVar2 != null) {
                                int f = aVar2.f();
                                if (f == 3 || f == 0) {
                                    next2.downloaded = 1;
                                    next2.downloading = 0;
                                } else if (f == 2 || f == 4) {
                                    if (!com.baidu.tbadk.core.util.bc.c(aVar2.n())) {
                                        this.a.showToast(aVar2.n());
                                    }
                                    a3.c();
                                    next2.downloaded = 0;
                                    next2.downloading = 0;
                                } else if (f == 1) {
                                    next2.downloading = 1;
                                    next2.downloaded = 0;
                                    next2.downloadTotal = aVar2.i();
                                    next2.downloadNow = aVar2.h();
                                }
                            }
                        }
                        a3.a(a);
                    }
                }
            }
        }
    }
}
