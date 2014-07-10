package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.download.DownloadData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class d extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<DownloadData>, List<DownloadData>> {
    ArrayList<com.baidu.tbadk.core.data.b> a;
    final /* synthetic */ b b;

    private d(b bVar) {
        this.b = bVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar, d dVar) {
        this(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.b>... arrayListArr) {
        ArrayList<com.baidu.tbadk.core.data.b> arrayList = arrayListArr[0];
        LinkedList linkedList = new LinkedList();
        if (arrayList == null) {
            return linkedList;
        }
        this.a = arrayList;
        Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.b next = it.next();
            String i = next.i();
            if (com.baidu.tbadk.core.util.z.d(this.b.a(next.j())) != null) {
                DownloadData downloadData = new DownloadData(i);
                downloadData.setStatus(3);
                linkedList.add(downloadData);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(List<DownloadData> list) {
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (DownloadData downloadData : com.baidu.tbadk.download.b.a().b()) {
            Iterator<com.baidu.tbadk.core.data.b> it = this.a.iterator();
            while (it.hasNext()) {
                if (downloadData.getId().equals(it.next().i())) {
                    list.add(downloadData);
                }
            }
        }
        this.b.a(list);
    }
}
