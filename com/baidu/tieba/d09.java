package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class d09 implements b09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LegoPageModel a;
    public c09 b;
    public LegoPageModel.b c;

    /* loaded from: classes5.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d09 a;

        public a(d09 d09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d09Var;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) && this.a.b != null) {
                this.a.b.c(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i), str2}) == null) && this.a.b != null) {
                this.a.b.b(j, str, str2, i);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && this.a.b != null) {
                this.a.b.a(true, dataRes, !z, j, str, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends gs5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m9 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public b(d09 d09Var, m9 m9Var, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d09Var, m9Var, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m9Var;
            this.b = j;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gs5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                m9 m9Var = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                sb.append("_");
                if (TextUtils.isEmpty(this.c)) {
                    str = "";
                } else {
                    str = this.c;
                }
                sb.append(str);
                byte[] bArr = (byte[]) m9Var.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException unused) {
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements lr5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d09 c;

        public c(d09 d09Var, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d09Var, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d09Var;
            this.a = j;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lr5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) {
                return;
            }
            this.c.f(this.a, this.b, dataRes);
        }
    }

    public d09(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.a = legoPageModel;
        legoPageModel.P(this.c);
    }

    @Override // com.baidu.tieba.b09
    public void b(c09 c09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c09Var) == null) {
            this.b = c09Var;
        }
    }

    @Override // com.baidu.tieba.b09
    public void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) {
            gz4.k();
            ks5.b(new b(this, gz4.i("tb.lego_update"), j, str), new c(this, j, str));
        }
    }

    @Override // com.baidu.tieba.b09
    public void c(int i, long j, String str, int i2, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) && (legoPageModel = this.a) != null) {
            legoPageModel.O(i, j, str, i2, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, dataRes}) != null) || j < 0) {
            return;
        }
        c09 c09Var = this.b;
        if (c09Var != null) {
            c09Var.a(false, dataRes, false, j, str, 1);
        }
        this.a.O(2, j, str, 1, "");
    }
}
