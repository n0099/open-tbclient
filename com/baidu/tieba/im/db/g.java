package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class g {
    private static g a;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    private g() {
    }

    public final synchronized boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean z = false;
        synchronized (this) {
            try {
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                if (imDataBase != null && imMessageCenterPojo != null) {
                    a(imMessageCenterPojo.getGid());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ext", imMessageCenterPojo.getExt());
                    contentValues.put("gid", imMessageCenterPojo.getGid());
                    contentValues.put("group_ext", imMessageCenterPojo.getGroup_ext());
                    contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
                    contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
                    contentValues.put("group_type", Integer.valueOf(imMessageCenterPojo.getGroup_type()));
                    contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                    contentValues.put("type", Integer.valueOf(imMessageCenterPojo.getType()));
                    contentValues.put("orderCol", Long.valueOf(imMessageCenterPojo.getOrderCol()));
                    contentValues.put("is_delete", Integer.valueOf(imMessageCenterPojo.getIs_delete()));
                    if (imDataBase.insert("tb_message_center", null, contentValues) > 0) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.a(e, "ImMessageCenterDao.CreatGroupSync", new Object[0]);
            }
        }
        return z;
    }

    public static boolean a(String str) {
        try {
            SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
            if (imDataBase != null) {
                imDataBase.delete("tb_message_center", "gid=?", new String[]{str});
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.a(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
            return false;
        }
    }

    public static LinkedList<ImMessageCenterPojo> b() {
        Cursor cursor;
        Throwable th;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
        if (imDataBase == null) {
            return null;
        }
        try {
            cursor = imDataBase.rawQuery("select * from tb_message_center ORDER BY gid", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            imMessageCenterPojo.setGroup_ext(cursor.getString(cursor.getColumnIndex("group_ext")));
                            imMessageCenterPojo.setGroup_head(cursor.getString(cursor.getColumnIndex("group_head")));
                            imMessageCenterPojo.setGroup_name(cursor.getString(cursor.getColumnIndex("group_name")));
                            imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                            imMessageCenterPojo.setIs_hidden(cursor.getInt(cursor.getColumnIndex("is_hidden")));
                            imMessageCenterPojo.setType(cursor.getInt(cursor.getColumnIndex("type")));
                            imMessageCenterPojo.setOrderCol(cursor.getLong(cursor.getColumnIndex("orderCol")));
                            imMessageCenterPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            linkedList.add(imMessageCenterPojo);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            TiebaStatic.a(e, "ImMessageCenterDao.getAllRecentMsg", new Object[0]);
                            com.baidu.tbadk.core.util.l.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.tbadk.core.util.l.a(cursor);
                        throw th;
                    }
                }
            }
            com.baidu.tbadk.core.util.l.a(cursor);
            return linkedList;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.tbadk.core.util.l.a(cursor);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00d2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static ImMessageCenterPojo b(String str) {
        Cursor cursor;
        Exception e;
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        ?? imDataBase = ImDatabaseManager.getImDataBase();
        try {
            if (imDataBase == 0) {
                return null;
            }
            try {
                cursor = imDataBase.rawQuery("select * from tb_message_center WHERE gid=?", new String[]{str});
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            imMessageCenterPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            imMessageCenterPojo.setGroup_ext(cursor.getString(cursor.getColumnIndex("group_ext")));
                            imMessageCenterPojo.setGroup_head(cursor.getString(cursor.getColumnIndex("group_head")));
                            imMessageCenterPojo.setGroup_name(cursor.getString(cursor.getColumnIndex("group_name")));
                            imMessageCenterPojo.setGroup_type(cursor.getInt(cursor.getColumnIndex("group_type")));
                            imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                            imMessageCenterPojo.setIs_hidden(cursor.getInt(cursor.getColumnIndex("is_hidden")));
                            imMessageCenterPojo.setType(cursor.getInt(cursor.getColumnIndex("type")));
                            imMessageCenterPojo.setOrderCol(cursor.getLong(cursor.getColumnIndex("orderCol")));
                            imMessageCenterPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        TiebaStatic.a(e, "ImMessageCenterDao.getGroupInfo", new Object[0]);
                        com.baidu.tbadk.core.util.l.a(cursor);
                        return imMessageCenterPojo;
                    }
                }
                com.baidu.tbadk.core.util.l.a(cursor);
                return imMessageCenterPojo;
            } catch (Exception e3) {
                cursor = null;
                e = e3;
            } catch (Throwable th) {
                imDataBase = 0;
                th = th;
                com.baidu.tbadk.core.util.l.a((Cursor) imDataBase);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized void a(LinkedList<ImMessageCenterPojo> linkedList) {
        SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
        if (imDataBase != null && linkedList != null && linkedList.size() > 0) {
            try {
                imDataBase.beginTransaction();
                Iterator<ImMessageCenterPojo> it = linkedList.iterator();
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ext", next.getExt());
                    contentValues.put("gid", next.getGid());
                    contentValues.put("group_ext", next.getGroup_ext());
                    contentValues.put("group_head", next.getGroup_head());
                    contentValues.put("group_name", next.getGroup_name());
                    contentValues.put("group_type", Integer.valueOf(next.getGroup_type()));
                    contentValues.put("custom_group_type", Integer.valueOf(next.getCustomGroupType()));
                    contentValues.put("is_delete", Integer.valueOf(next.getIs_delete()));
                    contentValues.put("type", Integer.valueOf(next.getType()));
                    contentValues.put("orderCol", Long.valueOf(next.getOrderCol()));
                    com.baidu.adp.lib.util.f.e(" update recent group chat gid:" + next.getGid());
                    if (imDataBase.update("tb_message_center", contentValues, "gid=?", new String[]{next.getGid()}) == 0) {
                        if (imDataBase.insert("tb_message_center", null, contentValues) == 0) {
                            com.baidu.adp.lib.util.f.e("表：tb_message_center[insert error] " + next);
                        } else {
                            com.baidu.adp.lib.util.f.e("表：tb_message_center[insert] " + next);
                        }
                    } else {
                        com.baidu.adp.lib.util.f.e("表：tb_message_center[update] " + next);
                    }
                }
                imDataBase.setTransactionSuccessful();
                imDataBase.endTransaction();
            } catch (Exception e) {
                TiebaStatic.a(e, "ImMessageCenterDao.syncOnline", new Object[0]);
                e.printStackTrace();
                imDataBase.endTransaction();
            }
        }
    }

    public static void a(String str, boolean z) {
        SQLiteDatabase imDataBase;
        try {
            if (!TextUtils.isEmpty(str) && (imDataBase = ImDatabaseManager.getImDataBase()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_hidden", Integer.valueOf(z ? 1 : 0));
                if (imDataBase.update("tb_message_center", contentValues, "gid=?", new String[]{str}) == 0) {
                    contentValues.put("gid", str);
                    imDataBase.insert("tb_message_center", null, contentValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.a(e, "ImMessageCenterDao.updateGroupMsgVisiblity", new Object[0]);
        }
    }

    public static void a(String str, String str2) {
        SQLiteDatabase imDataBase;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (imDataBase = ImDatabaseManager.getImDataBase()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", str2);
                imDataBase.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.a(e, "ImMessageCenterDao.updateGroupMsgNameSync", new Object[0]);
        }
    }

    public static void b(String str, String str2) {
        SQLiteDatabase imDataBase;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (imDataBase = ImDatabaseManager.getImDataBase()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_head", str2);
                imDataBase.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.a(e, "ImMessageCenterDao.updateGroupHeadSync", new Object[0]);
        }
    }

    public static void b(String str, boolean z) {
        SQLiteDatabase imDataBase;
        try {
            if (!TextUtils.isEmpty(str) && (imDataBase = ImDatabaseManager.getImDataBase()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", (Integer) 1);
                imDataBase.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.a(e, "ImMessageCenterDao.updateIsDelete", new Object[0]);
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }
}
