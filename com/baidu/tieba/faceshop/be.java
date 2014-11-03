package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class be extends CustomMessageListener {
    final /* synthetic */ FaceShopActivity aux;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(FaceShopActivity faceShopActivity, int i) {
        super(i);
        this.aux = faceShopActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bo boVar;
        bq bqVar;
        bo boVar2;
        bq bqVar2;
        HashMap hashMap;
        bq bqVar3;
        HashMap hashMap2;
        HashMap hashMap3;
        boVar = this.aux.auv;
        if (boVar != null) {
            bqVar = this.aux.auu;
            if (bqVar != null) {
                boVar2 = this.aux.auv;
                FaceShopData DA = boVar2.DA();
                if (DA != null && DA.pack_list != null) {
                    if (customResponsedMessage.getCmd() == 2001122) {
                        if (customResponsedMessage instanceof DownloadMessage) {
                            hashMap = this.aux.auw;
                            hashMap.clear();
                            List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                            if (data != null) {
                                bqVar3 = this.aux.auu;
                                bi DB = bqVar3.DB();
                                if (DB != null) {
                                    for (DownloadData downloadData : data) {
                                        hashMap3 = this.aux.auw;
                                        hashMap3.put(downloadData.getId(), downloadData);
                                    }
                                    Iterator<FacePackageData> it = DA.pack_list.iterator();
                                    while (it.hasNext()) {
                                        FacePackageData next = it.next();
                                        hashMap2 = this.aux.auw;
                                        DownloadData downloadData2 = (DownloadData) hashMap2.get(String.valueOf(next.pid));
                                        if (downloadData2 != null) {
                                            int status = downloadData2.getStatus();
                                            if (status == 3 || status == 0) {
                                                next.downloaded = 1;
                                                next.downloading = 0;
                                            } else if (status == 2 || status == 4) {
                                                if (!com.baidu.tbadk.core.util.az.aA(downloadData2.getStatusMsg())) {
                                                    this.aux.showToast(downloadData2.getStatusMsg());
                                                }
                                                DB.onDestroy();
                                                next.downloaded = 0;
                                                next.downloading = 0;
                                            } else if (status == 1) {
                                                next.downloading = 1;
                                                next.downloaded = 0;
                                                next.downloadTotal = downloadData2.getSize();
                                                next.downloadNow = downloadData2.getLength();
                                            }
                                        }
                                    }
                                    DB.a(DA);
                                }
                            }
                        }
                    } else if (customResponsedMessage.getCmd() == 2001120) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        Iterator<FacePackageData> it2 = DA.pack_list.iterator();
                        while (it2.hasNext()) {
                            FacePackageData next2 = it2.next();
                            if (next2.downloaded == 1) {
                                next2.downloaded = 0;
                            }
                            arrayList.add(String.valueOf(next2.pid));
                        }
                        bqVar2 = this.aux.auu;
                        bqVar2.r(arrayList);
                    }
                }
            }
        }
    }
}
