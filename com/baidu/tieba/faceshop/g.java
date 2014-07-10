package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g a = new g();
    private j b;
    private List<String> c;
    private int d = 5;
    private CustomMessageListener e = new h(this, 2001144);
    private CustomMessageListener f = new i(this, 2001123);

    private g() {
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.e);
    }

    public static g a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<String> list) {
        this.b = new j(this);
        this.b.execute(list);
    }

    public void a(String str, String str2, String str3) {
        if (!com.baidu.tbadk.core.util.bm.c(str) && !com.baidu.tbadk.core.util.bm.c(str3)) {
            DownloadData downloadData = new DownloadData(str, str2, str3, new f());
            downloadData.setStatusMsg(TbadkApplication.getCurrentAccount());
            downloadData.setType(11);
            String[] split = str3.split("/");
            if (split.length > 1) {
                String[] split2 = split[split.length - 1].split("_");
                if (split2 != null) {
                    if (split2.length == 5) {
                        downloadData.setDescription(split2[1]);
                        downloadData.setCheck(split2[2]);
                        downloadData.setWidth(com.baidu.adp.lib.f.b.a(split2[3], (int) Constants.MEDIA_INFO));
                        downloadData.setHeight(com.baidu.adp.lib.f.b.a(split2[4].split(".png")[0], (int) Constants.MEDIA_INFO));
                    } else if (split2.length == 3) {
                        downloadData.setDescription(split2[1]);
                        downloadData.setCheck(split2[2].split(".png")[0]);
                        downloadData.setWidth(Constants.MEDIA_INFO);
                        downloadData.setHeight(Constants.MEDIA_INFO);
                    } else {
                        downloadData.setStatusMsg(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.download_fail));
                        downloadData.setStatus(2);
                    }
                } else {
                    downloadData.setStatusMsg(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.download_fail));
                    downloadData.setStatus(2);
                }
            } else {
                downloadData.setStatusMsg(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.download_fail));
                downloadData.setStatus(2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.tbadk.core.util.z.d());
            sb.append(com.baidu.tbadk.core.util.z.a(2));
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            downloadData.setPath(sb.toString());
            BdLog.d("download:path:" + downloadData.getPath());
            com.baidu.tbadk.download.b.a().a(downloadData, this.d);
        }
    }

    public void a(String str) {
        com.baidu.tbadk.download.b.a().a(str, 11);
    }

    public void b() {
        com.baidu.tbadk.download.b.a().a(11);
    }

    public void a(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void a(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }
}
