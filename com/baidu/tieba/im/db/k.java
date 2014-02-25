package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.r;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k {
    private static k a;

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k();
            }
            kVar = a;
        }
        return kVar;
    }

    private k() {
    }

    public synchronized boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean z = false;
        synchronized (this) {
            try {
                SQLiteDatabase a2 = g.a();
                if (a2 != null && imMessageCenterPojo != null) {
                    a(imMessageCenterPojo.getGid());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ext", imMessageCenterPojo.getExt());
                    contentValues.put(PushConstants.EXTRA_GID, imMessageCenterPojo.getGid());
                    contentValues.put("group_ext", imMessageCenterPojo.getGroup_ext());
                    contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
                    contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
                    contentValues.put("group_type", Integer.valueOf(imMessageCenterPojo.getGroup_type()));
                    contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                    contentValues.put("type", Integer.valueOf(imMessageCenterPojo.getType()));
                    contentValues.put("orderCol", Long.valueOf(imMessageCenterPojo.getOrderCol()));
                    contentValues.put("is_delete", Integer.valueOf(imMessageCenterPojo.getIs_delete()));
                    if (a2.insert("tb_message_center", null, contentValues) > 0) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                cb.a(e, "ImMessageCenterDao.CreatGroupSync", new Object[0]);
            }
        }
        return z;
    }

    public boolean a(String str) {
        try {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                a2.delete("tb_message_center", "gid=?", new String[]{str});
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            cb.a(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
            return false;
        }
    }

    public LinkedList<ImMessageCenterPojo> b() {
        Cursor cursor;
        Throwable th;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        SQLiteDatabase a2 = g.a();
        if (a2 == null) {
            return null;
        }
        try {
            cursor = a2.rawQuery("select * from tb_message_center ORDER BY gid", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_GID)));
                            imMessageCenterPojo.setGroup_ext(cursor.getString(cursor.getColumnIndex("group_ext")));
                            imMessageCenterPojo.setGroup_head(cursor.getString(cursor.getColumnIndex("group_head")));
                            imMessageCenterPojo.setGroup_name(cursor.getString(cursor.getColumnIndex("group_name")));
                            imMessageCenterPojo.setGroup_type(cursor.getInt(cursor.getColumnIndex("group_type")));
                            imMessageCenterPojo.setIs_hidden(cursor.getInt(cursor.getColumnIndex("is_hidden")));
                            imMessageCenterPojo.setType(cursor.getInt(cursor.getColumnIndex("type")));
                            imMessageCenterPojo.setOrderCol(cursor.getLong(cursor.getColumnIndex("orderCol")));
                            imMessageCenterPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            linkedList.add(imMessageCenterPojo);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            cb.a(e, "ImMessageCenterDao.getAllRecentMsg", new Object[0]);
                            r.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r.a(cursor);
                        throw th;
                    }
                }
            }
            r.a(cursor);
            return linkedList;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            r.a(cursor);
            throw th;
        }
    }

    public synchronized void a(LinkedList<ImMessageCenterPojo> linkedList) {
        SQLiteDatabase a2 = g.a();
        if (a2 != null && linkedList != null && linkedList.size() > 0) {
            try {
                a2.beginTransaction();
                Iterator<ImMessageCenterPojo> it = linkedList.iterator();
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ext", next.getExt());
                    contentValues.put(PushConstants.EXTRA_GID, next.getGid());
                    contentValues.put("group_ext", next.getGroup_ext());
                    contentValues.put("group_head", next.getGroup_head());
                    contentValues.put("group_name", next.getGroup_name());
                    contentValues.put("group_type", Integer.valueOf(next.getGroup_type()));
                    contentValues.put("is_delete", Integer.valueOf(next.getIs_delete()));
                    contentValues.put("type", Integer.valueOf(next.getType()));
                    contentValues.put("orderCol", Long.valueOf(next.getOrderCol()));
                    com.baidu.adp.lib.util.f.e(" update recent group chat gid:" + next.getGid());
                    if (a2.update("tb_message_center", contentValues, "gid=?", new String[]{next.getGid()}) == 0) {
                        if (a2.insert("tb_message_center", null, contentValues) == 0) {
                            com.baidu.adp.lib.util.f.e("表：tb_message_center[insert error] " + next);
                        } else {
                            com.baidu.adp.lib.util.f.e("表：tb_message_center[insert] " + next);
                        }
                    } else {
                        com.baidu.adp.lib.util.f.e("表：tb_message_center[update] " + next);
                    }
                }
                a2.setTransactionSuccessful();
                a2.endTransaction();
            } catch (Exception e) {
                cb.a(e, "ImMessageCenterDao.syncOnline", new Object[0]);
                e.printStackTrace();
                a2.endTransaction();
            }
        }
    }

    public void a(String str, boolean z) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && (a2 = g.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_hidden", Integer.valueOf(z ? 1 : 0));
                if (a2.update("tb_message_center", contentValues, "gid=?", new String[]{str}) == 0) {
                    contentValues.put(PushConstants.EXTRA_GID, str);
                    a2.insert("tb_message_center", null, contentValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            cb.a(e, "ImMessageCenterDao.updateGroupMsgVisiblity", new Object[0]);
        }
    }

    public void a(String str, String str2) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = g.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", str2);
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            cb.a(e, "ImMessageCenterDao.updateGroupMsgNameSync", new Object[0]);
        }
    }

    public void b(String str, String str2) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = g.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_head", str2);
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            cb.a(e, "ImMessageCenterDao.updateGroupHeadSync", new Object[0]);
        }
    }

    public void b(String str, boolean z) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && (a2 = g.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            cb.a(e, "ImMessageCenterDao.updateIsDelete", new Object[0]);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }
}
