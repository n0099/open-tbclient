package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/* loaded from: classes5.dex */
public class ef1 extends BaseDexClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClassLoader a;
    public ClassLoader b;
    public Context c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ef1(String str, String str2, String str3, Context context) {
        super(str, new File(str2), str3, ClassLoader.getSystemClassLoader());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (File) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context;
        this.a = context.getClass().getClassLoader();
        this.b = ClassLoader.getSystemClassLoader();
    }

    public final Class<?> a(String str) throws ClassNotFoundException {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                cls = this.b.loadClass(str);
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                return cls;
            }
            try {
                cls = super.findClass(str);
            } catch (ClassNotFoundException unused2) {
            }
            if (cls != null) {
                return cls;
            }
            throw new ClassNotFoundException("Didn't find class: " + str + " in own classloader.");
        }
        return (Class) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String findLibrary = super.findLibrary(str);
            if (findLibrary != null) {
                return findLibrary;
            }
            return ((PathClassLoader) this.a).findLibrary(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            URL findResource = super.findResource(str);
            if (findResource != null) {
                return findResource;
            }
            return this.a.getResource(str);
        }
        return (URL) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Enumeration<URL> findResources = super.findResources(str);
            if (findResources != null) {
                return findResources;
            }
            try {
                return this.a.getResources(str);
            } catch (IOException unused) {
                return findResources;
            }
        }
        return (Enumeration) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = a(str);
            } catch (ClassNotFoundException unused) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = this.a.loadClass(str);
            } catch (ClassNotFoundException unused2) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            throw new ClassNotFoundException("Didn't find class \"" + str + "\"");
        }
        return (Class) invokeLZ.objValue;
    }
}
