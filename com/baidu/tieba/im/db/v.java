package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends SingleRunnable<Void> {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, LinkedList linkedList) {
        this.b = tVar;
        this.a = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        SQLiteDatabase a = s.a();
        if (a != null && this.a != null) {
            try {
                if (this.a.size() > 0) {
                    a.beginTransaction();
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ext", imMessageCenterPojo.getExt());
                        contentValues.put(PushConstants.EXTRA_GID, imMessageCenterPojo.getGid());
                        contentValues.put("group_ext", imMessageCenterPojo.getGroup_ext());
                        contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
                        contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
                        contentValues.put("group_type", Integer.valueOf(imMessageCenterPojo.getGroup_type()));
                        contentValues.put("is_delete", Integer.valueOf(imMessageCenterPojo.getIs_delete()));
                        contentValues.put("type", Integer.valueOf(imMessageCenterPojo.getType()));
                        contentValues.put("orderCol", Long.valueOf(imMessageCenterPojo.getOrderCol()));
                        com.baidu.adp.lib.h.e.d(" update recent group chat gid:" + imMessageCenterPojo.getGid());
                        if (a.update("tb_message_center", contentValues, "gid=?", new String[]{imMessageCenterPojo.getGid()}) == 0) {
                            if (a.insert("tb_message_center", null, contentValues) == 0) {
                                com.baidu.adp.lib.h.e.d("表：tb_message_center[insert error] " + imMessageCenterPojo);
                            } else {
                                com.baidu.adp.lib.h.e.d("表：tb_message_center[insert] " + imMessageCenterPojo);
                            }
                        } else {
                            com.baidu.adp.lib.h.e.d("表：tb_message_center[update] " + imMessageCenterPojo);
                        }
                    }
                    a.setTransactionSuccessful();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                a.endTransaction();
            }
        }
        return null;
    }
}
