package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.util.by;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class t {
    private static t a;

    public static synchronized t a() {
        t tVar;
        synchronized (t.class) {
            if (a == null) {
                a = new t();
            }
            tVar = a;
        }
        return tVar;
    }

    private t() {
    }

    public synchronized void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new u(this, imMessageCenterPojo), aVar);
    }

    public synchronized void a(String str, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new v(this, str), aVar);
    }

    public synchronized Boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean z;
        synchronized (this) {
            try {
                SQLiteDatabase a2 = s.a();
                if (a2 == null) {
                    z = false;
                } else if (imMessageCenterPojo == null) {
                    z = false;
                } else {
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
                    z = Boolean.valueOf(a2.insert("tb_message_center", null, contentValues) > 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                by.a(e, "ImMessageCenterDao.CreatGroupSync", new Object[0]);
                z = false;
            }
        }
        return z;
    }

    public boolean a(String str) {
        try {
            SQLiteDatabase a2 = s.a();
            if (a2 != null) {
                a2.delete("tb_message_center", "gid=?", new String[]{str});
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            by.a(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00c6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public LinkedList<ImMessageCenterPojo> b() {
        Cursor cursor;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        ?? a2 = s.a();
        try {
            if (a2 == 0) {
                return null;
            }
            try {
                cursor = a2.rawQuery("select * from tb_message_center ORDER BY gid", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
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
                            by.a(e, "ImMessageCenterDao.getAllRecentMsg", new Object[0]);
                            com.baidu.tieba.util.p.a(cursor);
                            return null;
                        }
                    }
                }
                com.baidu.tieba.util.p.a(cursor);
                return linkedList;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                a2 = 0;
                th = th;
                com.baidu.tieba.util.p.a((Cursor) a2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void a(LinkedList<ImMessageCenterPojo> linkedList, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new w(this, linkedList), aVar);
    }

    public void a(String str, boolean z) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && (a2 = s.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_hidden", Integer.valueOf(z ? 1 : 0));
                if (a2.update("tb_message_center", contentValues, "gid=?", new String[]{str}) == 0) {
                    contentValues.put(PushConstants.EXTRA_GID, str);
                    a2.insert("tb_message_center", null, contentValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            by.a(e, "ImMessageCenterDao.updateGroupMsgVisiblity", new Object[0]);
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.m.a(new x(this, str, str2), null);
        }
    }

    public void b(String str, String str2) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = s.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", str2);
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
                com.baidu.tieba.im.m.a(new y(this), new z(this, str, str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            by.a(e, "ImMessageCenterDao.updateGroupMsgNameSync", new Object[0]);
        }
    }

    public void c(String str, String str2) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = s.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_head", str2);
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
                com.baidu.tieba.im.m.a(new ab(this), new ac(this, str, str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            by.a(e, "ImMessageCenterDao.updateGroupHeadSync", new Object[0]);
        }
    }

    public void b(String str, boolean z) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && (a2 = s.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
            by.a(e, "ImMessageCenterDao.updateIsDelete", new Object[0]);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "" + str;
    }
}
