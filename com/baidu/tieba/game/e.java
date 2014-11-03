package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.download.DownloadData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class e extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.a>, List<DownloadData>, List<DownloadData>> {
    ArrayList<com.baidu.tbadk.core.data.a> Rh;
    final /* synthetic */ c aGR;

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
            if (com.baidu.tbadk.core.util.s.br(this.aGR.getFileOfUrl(next.zk)) != null) {
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
        for (DownloadData downloadData : com.baidu.tbadk.download.g.rm().ro()) {
            Iterator<com.baidu.tbadk.core.data.a> it = this.Rh.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().zl, downloadData.getId())) {
                    list.add(downloadData);
                }
            }
        }
        this.aGR.h(list);
    }
}
