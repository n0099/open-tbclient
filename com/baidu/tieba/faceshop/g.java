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
    private static g asg = new g();
    private j ash;
    private List<String> asi;
    private int max = 5;
    private CustomMessageListener asj = new h(this, 2001144);
    private CustomMessageListener Sc = new i(this, 2001123);

    private g() {
        MessageManager.getInstance().registerListener(this.Sc);
        MessageManager.getInstance().registerListener(this.asj);
    }

    public static g CH() {
        return asg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(List<String> list) {
        this.ash = new j(this);
        this.ash.execute(list);
    }

    public void l(String str, String str2, String str3) {
        if (!com.baidu.tbadk.core.util.ay.aA(str) && !com.baidu.tbadk.core.util.ay.aA(str3)) {
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
                        downloadData.setWidth(com.baidu.adp.lib.g.c.f(split2[3], Constants.MEDIA_INFO));
                        downloadData.setHeight(com.baidu.adp.lib.g.c.f(split2[4].split(".png")[0], Constants.MEDIA_INFO));
                    } else if (split2.length == 3) {
                        downloadData.setDescription(split2[1]);
                        downloadData.setCheck(split2[2].split(".png")[0]);
                        downloadData.setWidth(Constants.MEDIA_INFO);
                        downloadData.setHeight(Constants.MEDIA_INFO);
                    } else {
                        downloadData.setStatusMsg(TbadkApplication.m251getInst().getApp().getString(cb.download_fail));
                        downloadData.setStatus(2);
                    }
                } else {
                    downloadData.setStatusMsg(TbadkApplication.m251getInst().getApp().getString(cb.download_fail));
                    downloadData.setStatus(2);
                }
            } else {
                downloadData.setStatusMsg(TbadkApplication.m251getInst().getApp().getString(cb.download_fail));
                downloadData.setStatus(2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.tbadk.core.util.s.lw());
            sb.append(com.baidu.tbadk.core.util.s.bp(2));
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            downloadData.setPath(sb.toString());
            BdLog.d("download:path:" + downloadData.getPath());
            com.baidu.tbadk.download.g.rk().a(downloadData, this.max);
        }
    }

    public void eL(String str) {
        com.baidu.tbadk.download.g.rk().p(str, 11);
    }

    public void CI() {
        com.baidu.tbadk.download.g.rk().cF(11);
    }

    public void a(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void h(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }
}
