package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes4.dex */
public class id9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        i9 mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.d("CREATE TABLE IF NOT EXISTS video_block_upload_data('md5' text,'last_upload_id' text ,'last_upload_success_index' integer,'account' text,'time' long)");
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            BdLog.e("deleteVieoChunkUploadData Called");
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return;
            }
            i9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static jd9 c(String str) {
        InterceptResult invokeL;
        jd9 jd9Var;
        Exception e;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Cursor cursor2 = null;
            jd9 jd9Var2 = null;
            if (TbadkCoreApplication.getCurrentAccount() == null || StringUtils.isNull(str)) {
                return null;
            }
            i9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.j("select * from video_block_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            jd9Var = new jd9();
                            try {
                                jd9Var.a = cursor.getString(cursor.getColumnIndex("last_upload_id"));
                                jd9Var.b = cursor.getInt(cursor.getColumnIndex("last_upload_success_index"));
                                jd9Var2 = jd9Var;
                            } catch (Exception e2) {
                                e = e2;
                                mainDBDatabaseManager.i(e, "getChunkUploadDataByMd5");
                                fg.a(cursor);
                                return jd9Var;
                            }
                        }
                        fg.a(cursor);
                        return jd9Var2;
                    } catch (Exception e3) {
                        jd9Var = null;
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    fg.a(cursor2);
                    throw th;
                }
            } catch (Exception e4) {
                jd9Var = null;
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                fg.a(cursor2);
                throw th;
            }
        } else {
            return (jd9) invokeL.objValue;
        }
    }

    public static boolean d(String str, String str2, int i) {
        InterceptResult invokeLLI;
        i9 mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
                return false;
            }
            Date date = new Date();
            mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into video_block_upload_data(md5,last_upload_id,last_upload_success_index,account,time) values(?,?,?,?,?)", new Object[]{str, str2, Integer.valueOf(i), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeLLI.booleanValue;
    }
}
