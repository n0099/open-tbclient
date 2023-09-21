package com.baidu.tieba;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BundleInfo a;
    public df1 b;
    public ef1 c;

    public cf1(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundleInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        if (a(bundleInfo)) {
            this.a = bundleInfo;
            return;
        }
        xe1.j().s(bundleInfo);
        throw new InitException(22, "bad param bundleInfo:" + bundleInfo.toString());
    }

    public static cf1 b(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundleInfo)) == null) {
            cf1 cf1Var = new cf1(bundleInfo);
            cf1Var.d();
            return cf1Var;
        }
        return (cf1) invokeL.objValue;
    }

    public final boolean a(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundleInfo)) == null) {
            if (bundleInfo == null || TextUtils.isEmpty(bundleInfo.getPackageName())) {
                return false;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            if (!lf1.d(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ClassLoader c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (ClassLoader) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.b = bf1.d().b(this.a, ContextHolder.getApplicationContext());
            return true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (e()) {
                if (Build.VERSION.SDK_INT < 21) {
                    if (!g()) {
                        throw new InitException(20, "resources init error");
                    }
                    return;
                } else if (f()) {
                    return;
                } else {
                    throw new InitException(20, "resources init error");
                }
            }
            throw new InitException(16, "class loader init error");
        }
    }

    public final synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                try {
                    Application applicationContext = ContextHolder.getApplicationContext();
                    Resources a = me1.c().a();
                    Resources b = me1.c().b();
                    Resources[] d = me1.c().d();
                    gf1.a().b(applicationContext);
                    String absolutePath = lf1.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                    ResourcesHookUtil.hookResources(a, absolutePath, this.a.getGroupName());
                    ResourcesHookUtil.hookResources(b, absolutePath, this.a.getGroupName());
                    if (d != null) {
                        for (Resources resources : d) {
                            ResourcesHookUtil.hookResources(resources, absolutePath, this.a.getGroupName());
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Application applicationContext = ContextHolder.getApplicationContext();
                String absolutePath = lf1.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                String str = applicationContext.getApplicationInfo().sourceDir;
                try {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    ResourcesHookUtil.hookAssets(assetManager, absolutePath, this.a.getGroupName());
                    ResourcesHookUtil.hookAssets(assetManager, str, this.a.getGroupName());
                    Resources a = me1.c().a();
                    this.c = new ef1(assetManager, a.getDisplayMetrics(), a.getConfiguration(), a);
                } catch (Exception e) {
                    if (kf1.a()) {
                        Log.e("Runtime", LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE, e);
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized Resources getResources(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resources)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT < 21) {
                    return this.c;
                }
                Application applicationContext = ContextHolder.getApplicationContext();
                String absolutePath = lf1.d(applicationContext, this.a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
                AssetManager assets = resources.getAssets();
                if (ResourcesHookUtil.hookAssets(assets, absolutePath, this.a.getGroupName())) {
                    if (this.c == null || this.c.getAssets().hashCode() != assets.hashCode()) {
                        if (this.c != null) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                ResourcesHookUtil.recoveryAssetsByGroup(assets, this.c.getAssets().hashCode(), this.a.getGroupName());
                                this.c = new ef1(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
                            }
                        } else {
                            this.c = new ef1(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
                        }
                    }
                    return this.c;
                }
                throw new InitException(21, "resources hook error");
            }
        }
        return (Resources) invokeL.objValue;
    }
}
