package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.util.by;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends SingleRunnable<Boolean> {
    final /* synthetic */ List a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, List list) {
        this.b = lVar;
        this.a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (this.a == null || this.a.isEmpty()) {
            return false;
        }
        try {
            SQLiteDatabase a = s.a();
            if (a == null) {
                return false;
            }
            int size = this.a.size();
            com.baidu.adp.lib.g.e.d("size:" + size);
            for (int i = 0; i < size; i++) {
                UpdatesItemData updatesItemData = (UpdatesItemData) this.a.get(i);
                if (updatesItemData != null) {
                    a.delete("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                }
            }
            return false;
        } catch (Exception e) {
            by.a(e, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
            e.printStackTrace();
            return false;
        }
    }
}
