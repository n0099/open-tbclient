package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static n f1621a;

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (f1621a == null) {
                f1621a = new n();
            }
            nVar = f1621a;
        }
        return nVar;
    }

    private n() {
    }

    public synchronized void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new o(this, imMessageCenterPojo), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean z;
        synchronized (this) {
            try {
                SQLiteDatabase a2 = m.a();
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
                z = false;
            }
        }
        return z;
    }

    private boolean a(String str) {
        try {
            SQLiteDatabase a2 = m.a();
            if (a2 != null) {
                a2.delete("tb_message_center", "gid=?", new String[]{str});
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public LinkedList<ImMessageCenterPojo> b() {
        Cursor cursor;
        Throwable th;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        SQLiteDatabase a2 = m.a();
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
                            com.baidu.tieba.util.o.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.tieba.util.o.a(cursor);
                        throw th;
                    }
                }
            }
            com.baidu.tieba.util.o.a(cursor);
            return linkedList;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.tieba.util.o.a(cursor);
            throw th;
        }
    }

    public synchronized void a(LinkedList<ImMessageCenterPojo> linkedList, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new p(this, linkedList), aVar);
    }

    public void a(String str, boolean z) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && (a2 = m.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_hidden", Integer.valueOf(z ? 1 : 0));
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.m.a(new q(this, str, str2), null);
        }
    }

    public void b(String str, String str2) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = m.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", str2);
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
                com.baidu.tieba.im.m.a(new r(this), new s(this, str, str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(String str, String str2) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = m.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_head", str2);
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
                com.baidu.tieba.im.m.a(new u(this), new v(this, str, str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str, boolean z) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str) && (a2 = m.a()) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
                a2.update("tb_message_center", contentValues, "gid=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(String str, String str2, boolean z) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Boolean.valueOf(false);
        }
        SQLiteDatabase a2 = m.a();
        if (a2 == null) {
            bool = false;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bool = false;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_hidden", (Integer) 0);
            contentValues.put("is_delete", String.valueOf(1));
            com.baidu.adp.lib.h.d.d(" delete recent group chat gid:" + str);
            a2.delete("tb_message_center", "gid=?", new String[]{str});
            contentValues.put(PushConstants.EXTRA_GID, str);
            a2.insert("tb_message_center", null, contentValues);
            bool = false;
        }
        return bool.booleanValue();
    }
}
