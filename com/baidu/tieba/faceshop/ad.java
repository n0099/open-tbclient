package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.faceshop.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class ad {
    private ab iWu = ab.cCn();
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    public void dh(List<CollectEmotionData> list) {
        ab.cCn().qe(true);
        List<CollectEmotionData> Kf = i.cBl().Kf(TbadkCoreApplication.getCurrentAccount());
        for (CollectEmotionData collectEmotionData : Kf) {
            String aO = ab.aO(collectEmotionData.pid, false);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(aO);
            collectEmotionData.imageFileInfo = imageFileInfo;
        }
        BdLog.e("NewFaceSyncUtil MergeCollectFace Called CloudList:");
        Iterator<CollectEmotionData> it = list.iterator();
        while (it.hasNext()) {
            BdLog.e("NewFaceSyncUtil Cloud data:" + it.next().pkgId);
        }
        BdLog.e("NewFaceSyncUtil MergeCollectFace Called localList:");
        Iterator<CollectEmotionData> it2 = Kf.iterator();
        while (it2.hasNext()) {
            BdLog.e("NewFaceSyncUtil Local data:" + it2.next().pkgId);
        }
        v(list, Kf);
    }

    private void v(final List<CollectEmotionData> list, List<CollectEmotionData> list2) {
        ArrayList arrayList = new ArrayList();
        final Map<String, CollectEmotionData> dj = dj(list2);
        Map<String, CollectEmotionData> dj2 = dj(list);
        for (Map.Entry<String, CollectEmotionData> entry : dj.entrySet()) {
            if (!dj2.containsKey(entry.getKey())) {
                arrayList.add(entry.getValue());
            }
        }
        if (!arrayList.isEmpty()) {
            this.iWu.d(arrayList, false, new ab.c() { // from class: com.baidu.tieba.faceshop.ad.1
                @Override // com.baidu.tieba.faceshop.ab.c
                public void S(int i, int i2, int i3) {
                    ad.this.a(list, dj);
                }
            });
        } else {
            a(list, dj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<CollectEmotionData> list, Map<String, CollectEmotionData> map) {
        ArrayList<CollectEmotionData> arrayList = new ArrayList();
        for (CollectEmotionData collectEmotionData : list) {
            if (collectEmotionData != null && !map.containsKey(collectEmotionData.pid) && !TextUtils.isEmpty(collectEmotionData.picUrl)) {
                arrayList.add(collectEmotionData);
            }
        }
        if (!arrayList.isEmpty()) {
            final ArrayList arrayList2 = new ArrayList();
            for (CollectEmotionData collectEmotionData2 : arrayList) {
                com.baidu.tbadk.img.c cVar = new com.baidu.tbadk.img.c();
                cVar.pkgId = collectEmotionData2.pkgId;
                cVar.picId = collectEmotionData2.pid;
                cVar.picUrl = collectEmotionData2.picUrl;
                cVar.width = collectEmotionData2.width;
                cVar.height = collectEmotionData2.height;
                cVar.thumbnail = collectEmotionData2.thumbnail;
                arrayList2.add(cVar);
            }
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.faceshop.ad.2
                @Override // java.lang.Runnable
                public void run() {
                    ad.this.iWu.a(arrayList2, false, new ab.c() { // from class: com.baidu.tieba.faceshop.ad.2.1
                        @Override // com.baidu.tieba.faceshop.ab.c
                        public void S(int i, int i2, int i3) {
                            ad.this.di(list);
                        }
                    });
                }
            });
            return;
        }
        di(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(List<CollectEmotionData> list) {
        this.iWu.c(list, false, new ab.c() { // from class: com.baidu.tieba.faceshop.ad.3
            @Override // com.baidu.tieba.faceshop.ab.c
            public void S(int i, int i2, int i3) {
                if (i2 > 0) {
                    BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                    com.baidu.tieba.newfaceshop.d.hi(System.currentTimeMillis());
                }
                com.baidu.tieba.newfaceshop.d.dkg().uj(false);
            }
        });
    }

    private Map<String, CollectEmotionData> dj(List<CollectEmotionData> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && !TextUtils.isEmpty(collectEmotionData.pid)) {
                    hashMap.put(collectEmotionData.pid, collectEmotionData);
                }
            }
        }
        return hashMap;
    }
}
