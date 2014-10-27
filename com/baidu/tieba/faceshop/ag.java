package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FacePackageDetailActivity atk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FacePackageDetailActivity facePackageDetailActivity, int i) {
        super(i);
        this.atk = facePackageDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ak akVar;
        ak akVar2;
        am amVar;
        List<DownloadData> data;
        ak akVar3;
        ak akVar4;
        am amVar2;
        ak akVar5;
        DownloadData downloadData;
        ak akVar6;
        ap apVar;
        ap apVar2;
        akVar = this.atk.ata;
        if (akVar != null) {
            akVar2 = this.atk.ata;
            if (akVar2.CY() != null) {
                amVar = this.atk.atb;
                if (amVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                    akVar3 = this.atk.ata;
                    FacePackageData facePackageData = akVar3.CY().faces_list;
                    if (data.size() >= 1 && (downloadData = data.get(0)) != null) {
                        String id = downloadData.getId();
                        akVar6 = this.atk.ata;
                        if (id.equals(akVar6.getPid())) {
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                facePackageData.downloaded = 1;
                                facePackageData.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!com.baidu.tbadk.core.util.ay.aA(downloadData.getStatusMsg())) {
                                    this.atk.showToast(downloadData.getStatusMsg());
                                }
                                apVar = this.atk.atc;
                                if (apVar != null) {
                                    apVar2 = this.atk.atc;
                                    apVar2.cancelLoadData();
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
                    akVar4 = this.atk.ata;
                    akVar4.a(facePackageData);
                    amVar2 = this.atk.atb;
                    akVar5 = this.atk.ata;
                    amVar2.i(akVar5);
                }
            }
        }
    }
}
