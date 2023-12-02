package com.baidu.tieba;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class cg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentProvider a;
    public final int b;
    public final int c;

    public Bundle d(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public boolean e(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, bundle)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public abstract int f(int i, Uri uri, String str, String[] strArr);

    public abstract void h(UriMatcher uriMatcher, String str);

    public abstract String i(int i, Uri uri);

    public abstract Uri j(int i, Uri uri, ContentValues contentValues);

    public void m(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
        }
    }

    public abstract boolean n();

    public abstract Cursor r(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public abstract int t(int i, Uri uri, ContentValues contentValues, String str, String[] strArr);

    public cg1(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i;
        this.c = i2;
    }

    public ContentProviderResult[] a(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            int size = arrayList.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = arrayList.get(i).apply(this.a, contentProviderResultArr, i);
            }
            return contentProviderResultArr;
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    public void b(ContentProvider contentProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentProvider) == null) && this.a == null) {
            this.a = contentProvider;
        }
    }

    public int c(int i, Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, uri, contentValuesArr)) == null) {
            int length = contentValuesArr.length;
            for (ContentValues contentValues : contentValuesArr) {
                j(i, uri, contentValues);
            }
            return length;
        }
        return invokeILL.intValue;
    }

    public AssetFileDescriptor o(int i, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i, uri, str)) == null) {
            q(i, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeILL.objValue;
    }

    public ParcelFileDescriptor q(int i, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048592, this, i, uri, str)) == null) {
            throw new FileNotFoundException("No files supported by provider at " + uri);
        }
        return (ParcelFileDescriptor) invokeILL.objValue;
    }

    public void g(Uri uri, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, uri, i) != null) || Binder.getCallingUid() == Process.myUid()) {
            return;
        }
        throw new SecurityException();
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public AssetFileDescriptor p(int i, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), uri, str, cancellationSignal})) == null) {
            o(i, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeCommon.objValue;
    }

    public Cursor s(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            return r(i, uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeCommon.objValue;
    }
}
