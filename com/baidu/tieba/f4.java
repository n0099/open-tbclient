package com.baidu.tieba;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final short[] a;
    public final k6<g4> b;
    public final k6<ModelMaterial> c;
    public final k6<i4> d;
    public final k6<e4> e;

    public f4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new short[2];
        this.b = new k6<>();
        this.c = new k6<>();
        this.d = new k6<>();
        this.e = new k6<>();
    }
}
