package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<List<String>, List<DownloadData>, List<DownloadData>> {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<DownloadData> doInBackground(List<String>... listArr) {
        LinkedList linkedList = new LinkedList();
        if (listArr[0] == null) {
            return linkedList;
        }
        for (int i = 0; i < listArr[0].size(); i++) {
            MyEmotionGroupData a = d.a().a(TbadkApplication.getCurrentAccount(), listArr[0].get(i));
            if (a != null && e.a(a.getGroupId())) {
                DownloadData downloadData = new DownloadData(a.getGroupId());
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
        List<String> list2;
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (DownloadData downloadData : com.baidu.tbadk.download.b.a().b()) {
            list2 = this.a.c;
            for (String str : list2) {
                if (downloadData.getType() == 11 && downloadData.getId().equals(str)) {
                    list.add(downloadData);
                }
            }
        }
        this.a.a(list);
    }
}
