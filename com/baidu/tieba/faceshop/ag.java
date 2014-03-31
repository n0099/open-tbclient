package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
final class ag extends com.baidu.adp.framework.c.a {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FacePackageDetailActivity facePackageDetailActivity, int i) {
        super(2001122);
        this.a = facePackageDetailActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        ak akVar;
        ak akVar2;
        am amVar;
        List<com.baidu.tieba.download.a> a;
        ak akVar3;
        ak akVar4;
        am amVar2;
        ak akVar5;
        com.baidu.tieba.download.a aVar;
        ak akVar6;
        ar arVar;
        ar arVar2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        akVar = this.a.a;
        if (akVar != null) {
            akVar2 = this.a.a;
            if (akVar2.a() != null) {
                amVar = this.a.b;
                if (amVar != null && customResponsedMessage2.g() == 2001122 && (customResponsedMessage2 instanceof DownloadMessage) && (a = ((DownloadMessage) customResponsedMessage2).a()) != null) {
                    akVar3 = this.a.a;
                    FacePackageData facePackageData = akVar3.a().facePackage;
                    if (a.size() > 0 && (aVar = a.get(0)) != null) {
                        String a2 = aVar.a();
                        akVar6 = this.a.a;
                        if (a2.equals(akVar6.e())) {
                            int f = aVar.f();
                            if (f == 3 || f == 0) {
                                facePackageData.downloaded = 1;
                                facePackageData.downloading = 0;
                            } else if (f == 2 || f == 4) {
                                if (!com.baidu.tbadk.core.util.bc.c(aVar.n())) {
                                    this.a.showToast(aVar.n());
                                }
                                arVar = this.a.c;
                                if (arVar != null) {
                                    arVar2 = this.a.c;
                                    arVar2.cancelLoadData();
                                }
                                facePackageData.downloaded = 0;
                                facePackageData.downloading = 0;
                            } else if (f == 1) {
                                facePackageData.downloading = 1;
                                facePackageData.downloaded = 0;
                                facePackageData.downloadTotal = aVar.i();
                                facePackageData.downloadNow = aVar.h();
                            }
                        }
                    }
                    akVar4 = this.a.a;
                    akVar4.a(facePackageData);
                    amVar2 = this.a.b;
                    akVar5 = this.a.a;
                    amVar2.b(akVar5);
                }
            }
        }
    }
}
