package com.baidu.tieba;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ht6 {
    public static /* synthetic */ Interceptable $ic;
    public static final ht6 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835295, "Lcom/baidu/tieba/ht6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835295, "Lcom/baidu/tieba/ht6;");
                return;
            }
        }
        a = new ht6();
    }

    public ht6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ht6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (ht6) invokeV.objValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (new File(TbadkCoreApplication.getInst().getFilesDir(), str).exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(MyEmotionGroupData myEmotionGroupData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, myEmotionGroupData)) == null) {
            if (myEmotionGroupData == null) {
                return false;
            }
            i9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                mainDBDatabaseManager.f().delete(EmotionUtil.TABLE_NAME_USER_EMOTIONS, "uid = ? and groupId = ?", new String[]{myEmotionGroupData.uid, myEmotionGroupData.groupId});
                return true;
            } catch (Throwable th) {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.deleteMyEmotion");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public MyEmotionGroupData d(String str, String str2) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            i9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{str, str2});
                try {
                    if (cursor.moveToNext()) {
                        return i(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        mainDBDatabaseManager.i(th, "EmotionsDBManager.getMyEmotion");
                        return null;
                    } finally {
                        ji.a(cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return null;
        }
        return (MyEmotionGroupData) invokeLL.objValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            i9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor = null;
            try {
                cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{TbadkCoreApplication.getCurrentAccount(), str});
                if (!cursor.moveToNext()) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.hasEmotionByPckID");
                    return false;
                } finally {
                    ji.a(cursor);
                }
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<MyEmotionGroupData> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            LinkedList linkedList = new LinkedList();
            if (TextUtils.isEmpty(str)) {
                return linkedList;
            }
            Cursor cursor = null;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    linkedList.add(i(cursor));
                }
            } finally {
                try {
                    return linkedList;
                } finally {
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public MyEmotionGroupData i(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cursor)) == null) {
            MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
            myEmotionGroupData.id = cursor.getInt(cursor.getColumnIndex("id"));
            myEmotionGroupData.uid = cursor.getString(cursor.getColumnIndex("uid"));
            myEmotionGroupData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
            myEmotionGroupData.updateTime = cursor.getLong(cursor.getColumnIndex("updateTime"));
            return myEmotionGroupData;
        }
        return (MyEmotionGroupData) invokeL.objValue;
    }

    public int f(lp8 lp8Var) {
        InterceptResult invokeL;
        List<mp8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lp8Var)) == null) {
            if (lp8Var == null || (list = lp8Var.e) == null || list.size() == 0) {
                return 0;
            }
            String str = ".emotions/" + lp8Var.a;
            pt6 o = pt6.o();
            List<mp8> list2 = lp8Var.e;
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                mp8 mp8Var = list2.get(i2);
                if (a(str + "/" + mp8Var.c)) {
                    if (a(str + "/" + mp8Var.d)) {
                        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
                        sb.append(lp8Var.a + "_" + mp8Var.b);
                        sb.append(",");
                        sb.append(mp8Var.f);
                        sb.append(",");
                        sb.append(mp8Var.e);
                        sb.append(",");
                        String str2 = SmallTailInfo.EMOTION_PREFIX + sb.toString() + pi.c(sb.toString() + UploadedImageInfo.MD5_KEY).toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
                        boolean isGifImage = FileHelper.isGifImage(xh5.b.e(lp8Var.a, mp8Var.c));
                        it6.g(lp8Var.a, mp8Var.d, it6.c(str2, true, false));
                        it6.g(lp8Var.a, mp8Var.c, it6.c(str2, false, isGifImage));
                        if (o.f(str2, lp8Var.a, i2 + 1)) {
                            i++;
                        }
                    }
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public int g(String str, InputStream inputStream) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, inputStream)) == null) {
            pt6 o = pt6.o();
            List<String> a2 = it6.a(str, inputStream);
            int i = 0;
            int i2 = 0;
            while (i < a2.size()) {
                i++;
                if (o.f(a2.get(i), str, i)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }
}
