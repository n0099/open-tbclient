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
class bl extends CustomMessageListener {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(FaceShopActivity faceShopActivity, int i) {
        super(i);
        this.a = faceShopActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bv bvVar;
        bx bxVar;
        bv bvVar2;
        bx bxVar2;
        HashMap hashMap;
        bx bxVar3;
        HashMap hashMap2;
        HashMap hashMap3;
        bvVar = this.a.b;
        if (bvVar != null) {
            bxVar = this.a.a;
            if (bxVar != null) {
                bvVar2 = this.a.b;
                FaceShopData a = bvVar2.a();
                if (a != null && a.packList != null) {
                    if (customResponsedMessage.getCmd() == 2003122) {
                        if (customResponsedMessage instanceof DownloadMessage) {
                            hashMap = this.a.d;
                            hashMap.clear();
                            List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                            if (data != null) {
                                bxVar3 = this.a.a;
                                bp a2 = bxVar3.a();
                                if (a2 != null) {
                                    for (DownloadData downloadData : data) {
                                        hashMap3 = this.a.d;
                                        hashMap3.put(downloadData.getId(), downloadData);
                                    }
                                    Iterator<FacePackageData> it = a.packList.iterator();
                                    while (it.hasNext()) {
                                        FacePackageData next = it.next();
                                        hashMap2 = this.a.d;
                                        DownloadData downloadData2 = (DownloadData) hashMap2.get(String.valueOf(next.pid));
                                        if (downloadData2 != null) {
                                            int status = downloadData2.getStatus();
                                            if (status == 3 || status == 0) {
                                                next.downloaded = 1;
                                                next.downloading = 0;
                                            } else if (status == 2 || status == 4) {
                                                if (!com.baidu.tbadk.core.util.be.c(downloadData2.getStatusMsg())) {
                                                    this.a.showToast(downloadData2.getStatusMsg());
                                                }
                                                a2.c();
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
                                    a2.a(a);
                                }
                            }
                        }
                    } else if (customResponsedMessage.getCmd() == 2003120) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        Iterator<FacePackageData> it2 = a.packList.iterator();
                        while (it2.hasNext()) {
                            FacePackageData next2 = it2.next();
                            if (next2.downloaded == 1) {
                                next2.downloaded = 0;
                            }
                            arrayList.add(String.valueOf(next2.pid));
                        }
                        bxVar2 = this.a.a;
                        bxVar2.a(arrayList);
                    }
                }
            }
        }
    }
}
