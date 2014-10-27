package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<List<String>, List<DownloadData>, List<DownloadData>> {
    final /* synthetic */ g ask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.ask = gVar;
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
            MyEmotionGroupData ac = d.CG().ac(TbadkApplication.getCurrentAccount(), listArr[0].get(i));
            if (ac != null && e.eK(ac.getGroupId())) {
                DownloadData downloadData = new DownloadData(ac.getGroupId());
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
        List<String> list2;
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (DownloadData downloadData : com.baidu.tbadk.download.g.rk().rm()) {
            list2 = this.ask.asi;
            for (String str : list2) {
                if (downloadData.getType() == 11 && downloadData.getId().equals(str)) {
                    list.add(downloadData);
                }
            }
        }
        this.ask.h(list);
    }
}
