package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FacePackageDetailActivity att;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FacePackageDetailActivity facePackageDetailActivity, int i) {
        super(i);
        this.att = facePackageDetailActivity;
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
        akVar = this.att.atj;
        if (akVar != null) {
            akVar2 = this.att.atj;
            if (akVar2.Da() != null) {
                amVar = this.att.atk;
                if (amVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                    akVar3 = this.att.atj;
                    FacePackageData facePackageData = akVar3.Da().faces_list;
                    if (data.size() >= 1 && (downloadData = data.get(0)) != null) {
                        String id = downloadData.getId();
                        akVar6 = this.att.atj;
                        if (id.equals(akVar6.getPid())) {
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                facePackageData.downloaded = 1;
                                facePackageData.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!com.baidu.tbadk.core.util.az.aA(downloadData.getStatusMsg())) {
                                    this.att.showToast(downloadData.getStatusMsg());
                                }
                                apVar = this.att.atl;
                                if (apVar != null) {
                                    apVar2 = this.att.atl;
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
                    akVar4 = this.att.atj;
                    akVar4.a(facePackageData);
                    amVar2 = this.att.atk;
                    akVar5 = this.att.atj;
                    amVar2.i(akVar5);
                }
            }
        }
    }
}
