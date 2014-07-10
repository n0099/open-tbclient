package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(FacePackageDetailActivity facePackageDetailActivity, int i) {
        super(i);
        this.a = facePackageDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        am amVar;
        am amVar2;
        ao aoVar;
        List<DownloadData> data;
        am amVar3;
        am amVar4;
        ao aoVar2;
        am amVar5;
        DownloadData downloadData;
        am amVar6;
        ar arVar;
        ar arVar2;
        amVar = this.a.a;
        if (amVar != null) {
            amVar2 = this.a.a;
            if (amVar2.a() != null) {
                aoVar = this.a.b;
                if (aoVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                    amVar3 = this.a.a;
                    FacePackageData facePackageData = amVar3.a().facePackage;
                    if (data.size() >= 1 && (downloadData = data.get(0)) != null) {
                        String id = downloadData.getId();
                        amVar6 = this.a.a;
                        if (id.equals(amVar6.e())) {
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                facePackageData.downloaded = 1;
                                facePackageData.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!com.baidu.tbadk.core.util.bm.c(downloadData.getStatusMsg())) {
                                    this.a.showToast(downloadData.getStatusMsg());
                                }
                                arVar = this.a.c;
                                if (arVar != null) {
                                    arVar2 = this.a.c;
                                    arVar2.cancelLoadData();
                                }
                                facePackageData.downloaded = 0;
                                facePackageData.downloading = 0;
                            } else if (status == 1) {
                                facePackageData.downloading = 1;
                                facePackageData.downloaded = 0;
                                facePackageData.downloadTotal = downloadData.getSize();
                                facePackageData.downloadNow = downloadData.getLength();
                            }
                        }
                    }
                    amVar4 = this.a.a;
                    amVar4.a(facePackageData);
                    aoVar2 = this.a.b;
                    amVar5 = this.a.a;
                    aoVar2.c(amVar5);
                }
            }
        }
    }
}
