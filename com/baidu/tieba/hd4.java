package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class hd4 extends m32<TextureMapView, ju2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<gd4> n;
    public List<fd4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd4(@NonNull Context context, @NonNull ju2 ju2Var) {
        super(context, ju2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ju2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (n32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = ju2Var.c;
        this.j = ju2Var.b;
        String str = ju2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = ju2Var.r;
    }

    public static hd4 K(Context context, ju2 ju2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ju2Var)) == null) {
            if (context != null && ju2Var != null && ju2Var.isValid()) {
                return new hd4(context, ju2Var);
            }
            return null;
        }
        return (hd4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (gd4 gd4Var : this.n) {
                this.l.removeView(gd4Var.e);
            }
            this.n.clear();
            for (fd4 fd4Var : this.o) {
                this.l.removeView(fd4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public fd4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (fd4 fd4Var : this.o) {
                if (fd4Var.b == view2) {
                    return fd4Var;
                }
            }
            return null;
        }
        return (fd4) invokeL.objValue;
    }

    @Nullable
    public gd4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (gd4 gd4Var : this.n) {
                if (marker == gd4Var.b) {
                    return gd4Var;
                }
            }
            return null;
        }
        return (gd4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m32
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return this.l;
        }
        return (TextureMapView) invokeL.objValue;
    }

    public List<gd4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (gd4 gd4Var : this.n) {
                ru2 ru2Var = gd4Var.a;
                if (ru2Var != null && TextUtils.equals(str, ru2Var.a)) {
                    arrayList.add(gd4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
