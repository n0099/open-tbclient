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
    final /* synthetic */ b ahT;
    ArrayList<com.baidu.tbadk.core.data.c> ahU;

    private d(b bVar) {
        this.ahT = bVar;
        this.ahU = null;
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
        this.ahU = arrayList;
        Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.c next = it.next();
            String str = next.Pd;
            if (o.cm(this.ahT.getFileOfUrl(next.Pc)) != null) {
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
    /* renamed from: n */
    public void onPostExecute(List<DownloadData> list) {
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (DownloadData downloadData : g.yv().lG()) {
            Iterator<com.baidu.tbadk.core.data.c> it = this.ahU.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().Pd, downloadData.getId())) {
                    list.add(downloadData);
                }
            }
        }
        this.ahT.m(list);
    }
}
