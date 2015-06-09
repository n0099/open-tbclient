package com.baidu.tbadk.download;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class d extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
    final /* synthetic */ b aiT;
    ArrayList<com.baidu.tbadk.core.data.c> aiU;

    private d(b bVar) {
        this.aiT = bVar;
        this.aiU = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar, d dVar) {
        this(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.c>... arrayListArr) {
        ArrayList<com.baidu.tbadk.core.data.c> arrayList = arrayListArr[0];
        LinkedList linkedList = new LinkedList();
        if (arrayList == null) {
            return linkedList;
        }
        this.aiU = arrayList;
        Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.c next = it.next();
            String str = next.Px;
            if (o.cB(this.aiT.getFileOfUrl(next.Pw)) != null) {
                DownloadData downloadData = new DownloadData(str);
                downloadData.setStatus(3);
                linkedList.add(downloadData);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<DownloadData> list) {
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (DownloadData downloadData : g.zj().lZ()) {
            Iterator<com.baidu.tbadk.core.data.c> it = this.aiU.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().Px, downloadData.getId())) {
                    list.add(downloadData);
                }
            }
        }
        this.aiT.n(list);
    }
}
