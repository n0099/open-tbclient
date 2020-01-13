package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static final String eQh = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.ala_challenge/";

    public static void bil() {
        String str = com.baidu.live.s.a.wR().asq.Yu;
        String str2 = com.baidu.live.s.a.wR().asq.Yt;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            g("ala_live_challenge_res_id_android", str, "challenge_res", str2, true);
        }
    }

    private static void g(final String str, final String str2, final String str3, final String str4, final boolean z) {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.ala.liveroom.challenge.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                d.c(str, str2, str3, str4, z);
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str, String str2, String str3, String str4, boolean z) {
        if (StringUtils.isNull(str3) || StringUtils.isNull(str2) || StringUtils.isNull(str4)) {
            return false;
        }
        String str5 = eQh + str3;
        String str6 = "ala_live_challenge_res_md5_" + str3;
        if (!com.baidu.live.f.b.e(str5, com.baidu.live.f.b.cQ(str6)) || yv(str)) {
            return false;
        }
        com.baidu.live.f.b.a(str, str2, str5, str6, str3, str4, 19, z);
        return true;
    }

    private static boolean yv(String str) {
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || StringUtils.isNull(str)) {
            return false;
        }
        for (DownloadData downloadData : new LinkedList(downloadList)) {
            if (19 == downloadData.getType() && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
