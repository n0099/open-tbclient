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
/* loaded from: classes6.dex */
public class ig4 extends n62<TextureMapView, kx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<hg4> n;
    public List<gg4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig4(@NonNull Context context, @NonNull kx2 kx2Var) {
        super(context, kx2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kx2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (o62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = kx2Var.c;
        this.j = kx2Var.b;
        String str = kx2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = kx2Var.r;
    }

    public static ig4 K(Context context, kx2 kx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, kx2Var)) == null) {
            if (context != null && kx2Var != null && kx2Var.isValid()) {
                return new ig4(context, kx2Var);
            }
            return null;
        }
        return (ig4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (hg4 hg4Var : this.n) {
                this.l.removeView(hg4Var.e);
            }
            this.n.clear();
            for (gg4 gg4Var : this.o) {
                this.l.removeView(gg4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public gg4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (gg4 gg4Var : this.o) {
                if (gg4Var.b == view2) {
                    return gg4Var;
                }
            }
            return null;
        }
        return (gg4) invokeL.objValue;
    }

    @Nullable
    public hg4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (hg4 hg4Var : this.n) {
                if (marker == hg4Var.b) {
                    return hg4Var;
                }
            }
            return null;
        }
        return (hg4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n62
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

    public List<hg4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (hg4 hg4Var : this.n) {
                sx2 sx2Var = hg4Var.a;
                if (sx2Var != null && TextUtils.equals(str, sx2Var.a)) {
                    arrayList.add(hg4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
