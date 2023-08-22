package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public class iha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        n9 mainDBDatabaseManager;
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
            n9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static jha c(String str) {
        InterceptResult invokeL;
        jha jhaVar;
        Exception e;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Cursor cursor2 = null;
            jha jhaVar2 = null;
            if (TbadkCoreApplication.getCurrentAccount() == null || StringUtils.isNull(str)) {
                return null;
            }
            n9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.i("select * from video_block_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            jhaVar = new jha();
                            try {
                                jhaVar.a = cursor.getString(cursor.getColumnIndex("last_upload_id"));
                                jhaVar.b = cursor.getInt(cursor.getColumnIndex("last_upload_success_index"));
                                jhaVar2 = jhaVar;
                            } catch (Exception e2) {
                                e = e2;
                                mainDBDatabaseManager.h(e, "getChunkUploadDataByMd5");
                                BdCloseHelper.close(cursor);
                                return jhaVar;
                            }
                        }
                        BdCloseHelper.close(cursor);
                        return jhaVar2;
                    } catch (Exception e3) {
                        jhaVar = null;
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    BdCloseHelper.close(cursor2);
                    throw th;
                }
            } catch (Exception e4) {
                jhaVar = null;
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                BdCloseHelper.close(cursor2);
                throw th;
            }
        } else {
            return (jha) invokeL.objValue;
        }
    }

    public static boolean d(String str, String str2, int i) {
        InterceptResult invokeLLI;
        n9 mainDBDatabaseManager;
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
