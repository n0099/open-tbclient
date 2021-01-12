package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private static f iNt = new f();
    private a iNu;
    private List<String> iNv;
    private int max = 5;
    private CustomMessageListener iNw = new CustomMessageListener(CmdConfigCustom.CMD_CANCEL_FILE_DOWNLOAD) { // from class: com.baidu.tieba.faceshop.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001140 && (customResponsedMessage instanceof CancelDownloadMessage)) {
                f.this.cxh();
            }
        }
    };
    private CustomMessageListener eHt = new CustomMessageListener(CmdConfigCustom.CMD_QEURY_FILE_DOWNLOAD) { // from class: com.baidu.tieba.faceshop.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001119 && (customResponsedMessage instanceof QueryDownloadMessage)) {
                f.this.iNv = ((QueryDownloadMessage) customResponsedMessage).getData();
                f.this.dd(f.this.iNv);
            }
        }
    };

    private f() {
        MessageManager.getInstance().registerListener(this.eHt);
        MessageManager.getInstance().registerListener(this.iNw);
    }

    public static f cxg() {
        return iNt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(List<String> list) {
        this.iNu = new a();
        this.iNu.execute(list);
    }

    public void aF(String str, String str2, String str3) {
        if (!at.isEmpty(str) && !at.isEmpty(str3)) {
            DownloadData downloadData = new DownloadData(str, str2, str3, new e());
            downloadData.setStatusMsg(TbadkApplication.getCurrentAccount());
            downloadData.setType(11);
            String[] split = str3.split("/");
            if (split.length > 1) {
                String[] split2 = split[split.length - 1].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split2 != null) {
                    if (split2.length == 5) {
                        downloadData.setDescription(split2[1]);
                        downloadData.setCheck(split2[2]);
                        downloadData.setWidth(com.baidu.adp.lib.f.b.toInt(split2[3], 200));
                        downloadData.setHeight(com.baidu.adp.lib.f.b.toInt(split2[4].split(".png")[0], 200));
                    } else if (split2.length == 3) {
                        downloadData.setDescription(split2[1]);
                        downloadData.setCheck(split2[2].split(".png")[0]);
                        downloadData.setWidth(200);
                        downloadData.setHeight(200);
                    } else {
                        downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                        downloadData.setStatus(2);
                    }
                } else {
                    downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                    downloadData.setStatus(2);
                }
            } else {
                downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                downloadData.setStatus(2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath());
            sb.append(com.baidu.tbadk.core.util.n.getPrefixByType(2));
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            downloadData.setPath(sb.toString());
            BdLog.d("download:path:" + downloadData.getPath());
            com.baidu.tbadk.download.d.bAL().a(downloadData, this.max);
        }
    }

    public void IN(String str) {
        com.baidu.tbadk.download.d.bAL().cancelDownLoadById(str, 11);
    }

    public void cxh() {
        com.baidu.tbadk.download.d.bAL().cancelDownloadByType(11);
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void bK(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<List<String>, List<DownloadData>, List<DownloadData>> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public List<DownloadData> doInBackground(List<String>... listArr) {
            LinkedList linkedList = new LinkedList();
            if (listArr[0] == null) {
                return linkedList;
            }
            for (int i = 0; i < listArr[0].size(); i++) {
                MyEmotionGroupData eS = com.baidu.tieba.faceshop.a.cxd().eS(TbadkApplication.getCurrentAccount(), listArr[0].get(i));
                if (eS != null && b.IM(eS.getGroupId())) {
                    DownloadData downloadData = new DownloadData(eS.getGroupId());
                    downloadData.setStatus(3);
                    linkedList.add(downloadData);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : com.baidu.tbadk.download.d.bAL().getDownloadList()) {
                for (String str : f.this.iNv) {
                    if (downloadData.getType() == 11 && downloadData.getId().equals(str)) {
                        list.add(downloadData);
                    }
                }
            }
            f.this.bK(list);
        }
    }
}
