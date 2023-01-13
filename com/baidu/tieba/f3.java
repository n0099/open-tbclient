package com.baidu.tieba;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import com.badlogic.gdx.Files;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class f3 implements p2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final AssetManager c;
    public h3 d;

    public f3(AssetManager assetManager, ContextWrapper contextWrapper, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, contextWrapper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.c = assetManager;
        String absolutePath = contextWrapper.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        this.b = absolutePath;
        if (z) {
            this.a = h(contextWrapper);
        } else {
            this.a = null;
        }
    }

    @Override // com.badlogic.gdx.Files
    public l3 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            o2 o2Var = new o2(this.c, str, Files.FileType.Internal);
            if (this.d != null) {
                return g(o2Var, str);
            }
            return o2Var;
        }
        return (l3) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public l3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return new o2((AssetManager) null, str, Files.FileType.Classpath);
        }
        return (l3) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p2
    public h3 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (h3) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public l3 d(String str, Files.FileType fileType) {
        InterceptResult invokeLL;
        AssetManager assetManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, fileType)) == null) {
            if (fileType == Files.FileType.Internal) {
                assetManager = this.c;
            } else {
                assetManager = null;
            }
            o2 o2Var = new o2(assetManager, str, fileType);
            if (this.d != null && fileType == Files.FileType.Internal) {
                return g(o2Var, str);
            }
            return o2Var;
        }
        return (l3) invokeLL.objValue;
    }

    public final l3 g(l3 l3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, l3Var, str)) == null) {
            try {
                this.c.open(str).close();
                return l3Var;
            } catch (Exception unused) {
                d3 d3Var = new d3(str);
                if (!d3Var.x()) {
                    return d3Var;
                }
                if (d3Var.c()) {
                    return d3Var;
                }
                return l3Var;
            }
        }
        return (l3) invokeLL.objValue;
    }

    public String h(ContextWrapper contextWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, contextWrapper)) == null) {
            File externalFilesDir = contextWrapper.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return null;
            }
            String absolutePath = externalFilesDir.getAbsolutePath();
            if (!absolutePath.endsWith("/")) {
                return absolutePath + "/";
            }
            return absolutePath;
        }
        return (String) invokeL.objValue;
    }
}
