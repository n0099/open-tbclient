package com.baidu.tbadk.download;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class d extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.a>, List<DownloadData>, List<DownloadData>> {
    final /* synthetic */ b Rg;
    ArrayList<com.baidu.tbadk.core.data.a> Rh;

    private d(b bVar) {
        this.Rg = bVar;
        this.Rh = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar, d dVar) {
        this(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.a>... arrayListArr) {
        ArrayList<com.baidu.tbadk.core.data.a> arrayList = arrayListArr[0];
        LinkedList linkedList = new LinkedList();
        if (arrayList == null) {
            return linkedList;
        }
        this.Rh = arrayList;
        Iterator<com.baidu.tbadk.core.data.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.a next = it.next();
            String str = next.zl;
            if (s.br(this.Rg.getFileOfUrl(next.zk)) != null) {
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
    /* renamed from: i */
    public void onPostExecute(List<DownloadData> list) {
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (DownloadData downloadData : g.rm().ro()) {
            Iterator<com.baidu.tbadk.core.data.a> it = this.Rh.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().zl, downloadData.getId())) {
                    list.add(downloadData);
                }
            }
        }
        this.Rg.h(list);
    }
}
