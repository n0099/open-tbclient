package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(FacePackageDetailActivity facePackageDetailActivity, int i) {
        super(i);
        this.a = facePackageDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        an anVar;
        an anVar2;
        ap apVar;
        List<DownloadData> data;
        an anVar3;
        an anVar4;
        ap apVar2;
        an anVar5;
        DownloadData downloadData;
        an anVar6;
        au auVar;
        au auVar2;
        anVar = this.a.a;
        if (anVar != null) {
            anVar2 = this.a.a;
            if (anVar2.a() != null) {
                apVar = this.a.b;
                if (apVar != null && customResponsedMessage.getCmd() == 2003122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                    anVar3 = this.a.a;
                    FacePackageData facePackageData = anVar3.a().facePackage;
                    if (data.size() >= 1 && (downloadData = data.get(0)) != null) {
                        String id = downloadData.getId();
                        anVar6 = this.a.a;
                        if (id.equals(anVar6.e())) {
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                facePackageData.downloaded = 1;
                                facePackageData.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!com.baidu.tbadk.core.util.bg.c(downloadData.getStatusMsg())) {
                                    this.a.showToast(downloadData.getStatusMsg());
                                }
                                auVar = this.a.c;
                                if (auVar != null) {
                                    auVar2 = this.a.c;
                                    auVar2.cancelLoadData();
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
                    anVar4 = this.a.a;
                    anVar4.a(facePackageData);
                    apVar2 = this.a.b;
                    anVar5 = this.a.a;
                    apVar2.c(anVar5);
                }
            }
        }
    }
}
