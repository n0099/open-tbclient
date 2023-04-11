package com.baidu.tieba;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i32 extends k32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public JSONObject j;
    public int k;
    public int l;
    public int m;
    public int n;
    public JSONArray o;
    public float p;
    @Nullable
    public JSONObject q;
    public long r;
    public String s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i32(String str, @NonNull String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.m = 0;
        this.p = -1.0f;
        this.s = "";
    }

    @Override // com.baidu.tieba.k32, com.baidu.tieba.tx2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.j = jSONObject.optJSONObject("style");
        this.q = jSONObject.optJSONObject(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        i();
        h();
    }

    @Override // com.baidu.tieba.k32
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            super.g(jSONObject);
            i();
            h();
        }
    }

    @Override // com.baidu.tieba.k32
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i32 i32Var = (i32) super.clone();
            if (this.j != null) {
                try {
                    i32Var.j = new JSONObject(this.j.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (this.o != null) {
                try {
                    i32Var.o = new JSONArray(this.o.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.q != null) {
                try {
                    i32Var.q = new JSONObject(this.q.toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return i32Var;
        }
        return invokeV.objValue;
    }

    public final void h() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jSONObject = this.q) != null) {
            try {
                this.r = Long.parseLong(jSONObject.optString("duration"));
            } catch (Exception unused) {
                u42.b("Component-Model-View", "duration occurs exception");
                this.r = 0L;
            }
            this.s = this.q.optString("easing");
        }
    }

    public final void i() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (jSONObject = this.j) != null) {
            try {
                this.k = Color.parseColor(jSONObject.optString("bgColor"));
            } catch (Exception unused) {
                u42.b("Component-Model-View", "backgroundColor occurs exception");
                this.k = 0;
            }
            this.l = this.j.optInt("borderWidth");
            try {
                this.m = Color.parseColor(this.j.optString("borderColor"));
            } catch (Exception unused2) {
                u42.b("Component-Model-View", "borderColor occurs exception");
                this.m = 0;
            }
            this.n = ll3.g(this.j.optInt("borderRadius"));
            this.p = uk3.b(this.j, NativeConstants.OPACITY, -1.0f);
            this.o = this.j.optJSONArray(CriusAttrConstants.PADDING);
        }
    }
}
