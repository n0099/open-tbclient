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
/* loaded from: classes3.dex */
public class d {
    public static void btB() {
        String str = com.baidu.live.v.a.En().aQu.asR;
        String str2 = com.baidu.live.v.a.En().aQu.asQ;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            d("ala_live_challenge_res_id_android", str, "challenge_res", str2, true);
        }
    }

    private static void d(final String str, final String str2, final String str3, final String str4, final boolean z) {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.ala.liveroom.challenge.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                d.e(str, str2, str3, str4, z);
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(String str, String str2, String str3, String str4, boolean z) {
        if (StringUtils.isNull(str3) || StringUtils.isNull(str2) || StringUtils.isNull(str4)) {
            return false;
        }
        String str5 = (TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.ala_challenge/") + str3;
        String str6 = "ala_live_challenge_res_md5_" + str3;
        if (!com.baidu.live.f.b.b(str5, com.baidu.live.f.b.dQ(str6)) || AD(str)) {
            return false;
        }
        com.baidu.live.f.b.a(str, str2, str5, str6, str3, str4, 19, z);
        return true;
    }

    private static boolean AD(String str) {
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
