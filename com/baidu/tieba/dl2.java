package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class dl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                return Long.compare(file.lastModified(), file2.lastModified());
            }
            return invokeLL.intValue;
        }
    }

    public static void a() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            String y = gl2.y(AppRuntime.getAppContext());
            if (TextUtils.isEmpty(y)) {
                return;
            }
            File file = new File(y);
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String str = file2.getAbsolutePath() + File.separator + "aigames/sandbox";
                    File file3 = new File(str);
                    if (file3.exists() && file3.isDirectory()) {
                        String str2 = y + File.separator + "swangame/anonymous/sandbox";
                        if (!file3.renameTo(new File(str2))) {
                            gl2.e(str, str2);
                            gl2.j(str);
                        }
                    }
                }
            }
        }
    }

    public static void b() {
        File[] d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, null) != null) || (d = es2.m().d()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : d) {
            String name = file.getName();
            if (name.startsWith("aigame_storage_") && !name.endsWith("_anonymous.xml")) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new a());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file2 = (File) it.next();
            String absolutePath = file2.getAbsolutePath();
            int lastIndexOf = absolutePath.lastIndexOf("_");
            String str = absolutePath.substring(0, lastIndexOf) + "_anonymous.xml";
            if (!absolutePath.equals(str)) {
                File file3 = new File(str);
                if (file3.exists()) {
                    ap4.L(file3);
                }
                if (!file2.renameTo(file3)) {
                    ap4.f(file2, file3);
                    ap4.L(file2);
                }
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || !kh3.a().getBoolean("swan_game_data_migration", true)) {
            return;
        }
        kh3.a().putBoolean("swan_game_data_migration", false);
        if (zr2.a) {
            Log.d("DataMigrationUtils", "before migrate " + System.currentTimeMillis());
        }
        a();
        if (zr2.a) {
            Log.d("DataMigrationUtils", "in migrate " + System.currentTimeMillis());
        }
        b();
        if (zr2.a) {
            Log.d("DataMigrationUtils", "end migrate " + System.currentTimeMillis());
        }
    }
}
