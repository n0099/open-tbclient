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
class bd extends CustomMessageListener {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(FaceShopActivity faceShopActivity, int i) {
        super(i);
        this.a = faceShopActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bn bnVar;
        bp bpVar;
        bn bnVar2;
        bp bpVar2;
        HashMap hashMap;
        bp bpVar3;
        HashMap hashMap2;
        HashMap hashMap3;
        bnVar = this.a.b;
        if (bnVar != null) {
            bpVar = this.a.a;
            if (bpVar != null) {
                bnVar2 = this.a.b;
                FaceShopData a = bnVar2.a();
                if (a != null && a.packList != null) {
                    if (customResponsedMessage.getCmd() == 2001122) {
                        if (customResponsedMessage instanceof DownloadMessage) {
                            hashMap = this.a.d;
                            hashMap.clear();
                            List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                            if (data != null) {
                                bpVar3 = this.a.a;
                                bh a2 = bpVar3.a();
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
                                                if (!com.baidu.tbadk.core.util.ba.c(downloadData2.getStatusMsg())) {
                                                    this.a.showToast(downloadData2.getStatusMsg());
                                                }
                                                a2.b();
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
                    } else if (customResponsedMessage.getCmd() == 2001120) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        Iterator<FacePackageData> it2 = a.packList.iterator();
                        while (it2.hasNext()) {
                            FacePackageData next2 = it2.next();
                            if (next2.downloaded == 1) {
                                next2.downloaded = 0;
                            }
                            arrayList.add(String.valueOf(next2.pid));
                        }
                        bpVar2 = this.a.a;
                        bpVar2.a(arrayList);
                    }
                }
            }
        }
    }
}
