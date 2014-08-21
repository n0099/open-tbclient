package com.baidu.tieba.game;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.download.a {
    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 1) {
                b.a().b(downloadData);
            }
            b.a().a(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.a
    public boolean b(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public boolean c(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        TiebaStatic.eventStat(com.baidu.tieba.ai.c().d(), "dl_game_success", downloadData.getId());
        ap.a(com.baidu.tieba.ai.c().d(), downloadData.getNotifyId());
        b.a().a(downloadData);
        ae.a().b(downloadData.getId());
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public void d(DownloadData downloadData) {
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData, int i, String str) {
        b.a().c(downloadData);
        b.a().a(downloadData);
    }
}
