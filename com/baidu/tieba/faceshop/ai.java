package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
final class ai extends com.baidu.adp.framework.c.a {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(FacePackageDetailActivity facePackageDetailActivity, int i) {
        super(2001122);
        this.a = facePackageDetailActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        am amVar;
        am amVar2;
        ao aoVar;
        List<com.baidu.tieba.download.a> a;
        am amVar3;
        am amVar4;
        ao aoVar2;
        am amVar5;
        com.baidu.tieba.download.a aVar;
        am amVar6;
        at atVar;
        at atVar2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        amVar = this.a.a;
        if (amVar != null) {
            amVar2 = this.a.a;
            if (amVar2.a() != null) {
                aoVar = this.a.b;
                if (aoVar != null && customResponsedMessage2.g() == 2001122 && (customResponsedMessage2 instanceof DownloadMessage) && (a = ((DownloadMessage) customResponsedMessage2).a()) != null) {
                    amVar3 = this.a.a;
                    FacePackageData facePackageData = amVar3.a().facePackage;
                    if (a.size() > 0 && (aVar = a.get(0)) != null) {
                        String a2 = aVar.a();
                        amVar6 = this.a.a;
                        if (a2.equals(amVar6.e())) {
                            int f = aVar.f();
                            if (f == 3 || f == 0) {
                                facePackageData.downloaded = 1;
                                facePackageData.downloading = 0;
                            } else if (f == 2 || f == 4) {
                                if (!com.baidu.tbadk.core.util.bc.c(aVar.n())) {
                                    this.a.showToast(aVar.n());
                                }
                                atVar = this.a.c;
                                if (atVar != null) {
                                    atVar2 = this.a.c;
                                    atVar2.cancelLoadData();
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
                    amVar4 = this.a.a;
                    amVar4.a(facePackageData);
                    aoVar2 = this.a.b;
                    amVar5 = this.a.a;
                    aoVar2.b(amVar5);
                }
            }
        }
    }
}
