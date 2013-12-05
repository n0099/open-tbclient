package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1679a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, List list) {
        this.b = lVar;
        this.f1679a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (this.f1679a == null || this.f1679a.isEmpty()) {
            return false;
        }
        try {
            SQLiteDatabase a2 = s.a();
            if (a2 == null) {
                return false;
            }
            int size = this.f1679a.size();
            com.baidu.adp.lib.h.e.d("size:" + size);
            for (int i = 0; i < size; i++) {
                UpdatesItemData updatesItemData = (UpdatesItemData) this.f1679a.get(i);
                if (updatesItemData != null) {
                    a2.delete("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
