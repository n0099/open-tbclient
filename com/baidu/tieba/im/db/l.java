package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
public class l extends a {
    public static String exh = "tb_private_msg_";
    private static a exx;

    private l() {
        super("tb_private_msg_", PersonalChatMessage.class);
    }

    public static synchronized l aGR() {
        l lVar;
        synchronized (l.class) {
            if (exx == null) {
                exx = new l();
            }
            lVar = (l) exx;
        }
        return lVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x017b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x017d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x017f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public CommonMsgPojo ak(String str, int i) {
        Throwable th;
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        if (!TextUtils.isEmpty(str)) {
            ?? sb = new StringBuilder();
            ?? r2 = exh;
            try {
                try {
                    cursor = g.aGG().rawQuery("select * from " + sb.append(r2).append(str).toString() + " WHERE is_delete=? AND msg_type= ?", new String[]{String.valueOf(0), String.valueOf(i)});
                    try {
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                        if (cursor == null || !cursor.moveToNext()) {
                            n.i(cursor);
                            r2 = cursor;
                        } else {
                            commonMsgPojo2.setGid(str);
                            commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo2.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                            commonMsgPojo2.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                            commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo2.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            n.i(cursor);
                            commonMsgPojo = commonMsgPojo2;
                            r2 = cursor;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                        e.printStackTrace();
                        mY(str);
                        n.i(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                        e.printStackTrace();
                        n.i(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    n.i((Cursor) r2);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                n.i((Cursor) r2);
                throw th;
            }
        }
        return commonMsgPojo;
    }
}
