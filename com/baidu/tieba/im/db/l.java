package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static String HEAD = "tb_oficial_msg_";
    private static a kHq;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l cVX() {
        l lVar;
        synchronized (l.class) {
            if (kHq == null) {
                kHq = new l();
            }
            lVar = (l) kHq;
        }
        return lVar;
    }

    public static List<String> cVY() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cVN().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time ASC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
        } finally {
            com.baidu.adp.lib.util.n.close(cursor);
        }
        return arrayList;
    }

    public static List<com.baidu.tieba.im.db.pojo.a> cVZ() {
        ArrayList arrayList;
        Cursor cursor;
        try {
            try {
                cursor = h.cVN().rawQuery("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                if (cursor != null) {
                    try {
                        arrayList = new ArrayList(cursor.getCount());
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.tieba.im.db.pojo.a aVar = new com.baidu.tieba.im.db.pojo.a();
                                aVar.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                                aVar.setUnReadCount(cursor.getInt(cursor.getColumnIndex("unread_count")));
                                aVar.Na(cursor.getString(cursor.getColumnIndex("group_head")));
                                aVar.setForumName(cursor.getString(cursor.getColumnIndex("group_name")));
                                aVar.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                                int columnIndex = cursor.getColumnIndex("visit_time");
                                if (columnIndex >= 0) {
                                    aVar.gP(cursor.getLong(columnIndex));
                                }
                                arrayList.add(aVar);
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                                com.baidu.adp.lib.util.n.close(cursor);
                                return arrayList;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                    }
                } else {
                    arrayList = null;
                }
                com.baidu.adp.lib.util.n.close(cursor);
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.util.n.close((Cursor) null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.n.close((Cursor) null);
            throw th;
        }
        return arrayList;
    }

    public void b(long j, long j2, int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("read_count", Integer.valueOf(i));
            BdLog.d("updateReadCount result = " + h.cVN().b(HEAD + j, contentValues, "mid = ?", new String[]{String.valueOf(j2)}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void H(long j, long j2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("visit_time", Long.valueOf(j2));
            contentValues.put("unread_count", (Integer) 0);
            BdLog.d("updateReadCount result = " + h.cVN().b("tb_message_center", contentValues, "gid = ?", new String[]{String.valueOf(j)}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
