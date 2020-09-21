package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.media.annotations.MediaQueryParam;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends a {
    public static String HEAD = "tb_oficial_msg_";
    private static a jvb;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l cHU() {
        l lVar;
        synchronized (l.class) {
            if (jvb == null) {
                jvb = new l();
            }
            lVar = (l) jvb;
        }
        return lVar;
    }

    public static List<String> cHV() {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = h.cHK().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time" + MediaQueryParam.SORT_ASC, new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
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

    public static List<com.baidu.tieba.im.db.pojo.a> cHW() {
        Cursor cursor;
        Exception e;
        ArrayList arrayList;
        try {
            try {
                cursor = h.cHK().rawQuery("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                if (cursor != null) {
                    try {
                        arrayList = new ArrayList(cursor.getCount());
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.tieba.im.db.pojo.a aVar = new com.baidu.tieba.im.db.pojo.a();
                                aVar.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                                aVar.setUnReadCount(cursor.getInt(cursor.getColumnIndex("unread_count")));
                                aVar.Lg(cursor.getString(cursor.getColumnIndex("group_head")));
                                aVar.setForumName(cursor.getString(cursor.getColumnIndex("group_name")));
                                aVar.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                                int columnIndex = cursor.getColumnIndex("visit_time");
                                if (columnIndex >= 0) {
                                    aVar.fp(cursor.getLong(columnIndex));
                                }
                                arrayList.add(aVar);
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                                com.baidu.adp.lib.util.n.close(cursor);
                                return arrayList;
                            }
                        }
                    } catch (Exception e3) {
                        arrayList = null;
                        e = e3;
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
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            arrayList = null;
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
            BdLog.d("updateReadCount result = " + h.cHK().a(HEAD + j, contentValues, "mid = ?", new String[]{String.valueOf(j2)}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void z(long j, long j2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("visit_time", Long.valueOf(j2));
            contentValues.put("unread_count", (Integer) 0);
            BdLog.d("updateReadCount result = " + h.cHK().a("tb_message_center", contentValues, "gid = ?", new String[]{String.valueOf(j)}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
