package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class i extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            if (TbadkApplication.E() != null) {
                try {
                    new DatabaseManager().a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TbadkApplication.E()});
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("DatabaseManager", "delChunkUploadData", "error = " + e.getMessage());
                    TiebaStatic.a(e, "DatabaseManager.delOverdueChunkUploadData", new Object[0]);
                }
            }
            this.a.a(this.a.getCacheDir());
        } catch (Exception e2) {
        }
        handler = this.a.h;
        handler2 = this.a.h;
        handler.sendMessage(handler2.obtainMessage());
    }
}
