package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class fb6 extends BdAsyncTask<Void, Void, jb6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final eb6 b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public NetWork g;

    public fb6(String str, eb6 eb6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eb6Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = eb6Var;
        this.d = eb6Var.c();
        this.c = this.b.a();
        this.e = this.b.b();
        this.f = z;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(za6.f + "bdtbWCacheTemp/" + str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b9  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public jb6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        jb6 c;
        HashMap<String, db6> hashMap;
        InputStream inputStream;
        FileInputStream fileInputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            b(this.a);
            gb6.a(this.a);
            if (this.f) {
                if (!TextUtils.isEmpty(za6.h().i(this.a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", this.d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.g = netWork;
            netWork.setUrl(this.c);
            new File(za6.f + "bdtbWCacheTemp/" + this.a + "/").mkdirs();
            String str2 = za6.f + "bdtbWCacheTemp/" + this.a + "/bdtbNWCache.zip";
            if (this.g.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            String b = lj.b(fileInputStream);
                            if (StringUtils.isNull(b) || !b.toLowerCase().equals(this.e.toLowerCase())) {
                                e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "md5 error");
                                b(this.a);
                                fj.e(fileInputStream);
                                return null;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            fj.e(fileInputStream);
                            str = za6.f + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                            new File(str).mkdirs();
                            if (!x25.b(str2, str)) {
                            }
                            b(this.a);
                            c = gb6.c(this.a, this.d);
                            if (c == null) {
                            }
                            e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
                            gb6.a(this.a);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = "obj_type";
                        fj.e(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    fj.e(inputStream);
                    throw th;
                }
                fj.e(fileInputStream);
                str = za6.f + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                new File(str).mkdirs();
                if (!x25.b(str2, str)) {
                    String str3 = za6.f + "bdtbNWCache/" + this.a + "/" + this.d + "/";
                    new File(str3).mkdirs();
                    if (!FileHelper.CopyDir(str, str3, true)) {
                        e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "write error");
                    }
                } else {
                    e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "unzip error");
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "download error");
            }
            b(this.a);
            c = gb6.c(this.a, this.d);
            if (c == null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                gb6.b(c.c, this.a);
                return c;
            }
            e35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
            gb6.a(this.a);
            return null;
        }
        return (jb6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(jb6 jb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jb6Var) == null) {
            super.onPostExecute(jb6Var);
            if (jb6Var != null) {
                za6.h().r(this.a, jb6Var.c);
                za6.h().p();
                cb6.a().j(this.a, jb6Var.b);
                cb6.a().f(true, this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", jb6Var.c));
                return;
            }
            za6.h().e(this.a);
            za6.h().p();
            cb6.a().d(this.a);
        }
    }
}
