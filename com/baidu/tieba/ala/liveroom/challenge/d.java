package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static final String dYJ = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.ala_challenge/";

    public static String aPV() {
        return dYJ + "challenge_res";
    }

    public static void aPW() {
        String str = com.baidu.live.l.a.uB().ajF.Ru;
        String str2 = com.baidu.live.l.a.uB().ajF.Rt;
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
        String str5 = dYJ + str3;
        String str6 = "ala_live_challenge_res_md5_" + str3;
        if (!com.baidu.live.d.b.d(str5, com.baidu.live.d.b.bX(str6)) || tz(str)) {
            return false;
        }
        if (BdNetTypeUtil.isWifiNet() || z) {
            com.baidu.live.d.b.a(str, str2, str5, str6, str3, str4, 19, z);
        }
        return true;
    }

    private static boolean tz(String str) {
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || StringUtils.isNull(str)) {
            return false;
        }
        for (DownloadData downloadData : downloadList) {
            if (19 == downloadData.getType() && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String[] a(String str, String str2, int i, int i2, int i3) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || i3 <= 0 || i2 <= 0) {
            return null;
        }
        String[] strArr = new String[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            StringBuilder append = new StringBuilder(str).append("/").append(str2);
            append.append(aS(i, i3));
            strArr[i4] = append.append(".png").toString();
            i++;
        }
        return strArr;
    }

    private static String aS(int i, int i2) {
        if (i < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        if (sb.length() == i2) {
            return sb.toString();
        }
        int length = sb.length() < i2 ? i2 - sb.length() : 0;
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }
}
