package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public TbPageContext b;
    public FastRequest c;
    public boolean d;
    public d e;

    /* loaded from: classes5.dex */
    public interface c {
        void a(v08 v08Var);

        void onFail();
    }

    /* loaded from: classes5.dex */
    public class a implements FastRequest.e<v08> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c18 a;

        public a(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.e
        @Nullable
        /* renamed from: b */
        public v08 a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
                return (v08) invokeL.objValue;
            }
            return this.a.l(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends FastRequest.b<v08> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ThreadData d;
        public final /* synthetic */ c18 e;

        public b(c18 c18Var, String str, long j, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var, str, Long.valueOf(j), threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c18Var;
            this.b = str;
            this.c = j;
            this.d = threadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, v08Var) == null) {
                super.b(i, str, v08Var);
                this.e.d = true;
                this.e.a.onFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, v08Var) == null) {
                super.e(v08Var);
                this.e.d = true;
                v08Var.g(this.b);
                v08Var.f(String.valueOf(this.c));
                this.e.j(this.d.getFid());
                c18 c18Var = this.e;
                if (c18Var.i(c18Var.e)) {
                    this.e.a.a(v08Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public d(c18 c18Var, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = j2;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.longValue;
        }
    }

    public c18(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.b = tbPageContext;
    }

    @NonNull
    public final List<d> g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return DataExt.toEntityList(str, d.class);
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public final String h(@NonNull List<d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            return DataExt.toJson(list);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public final d j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            d dVar = new d(this, j, System.currentTimeMillis());
            this.e = dVar;
            return dVar;
        }
        return (d) invokeJ.objValue;
    }

    public final v08 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return v08.e(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (v08) invokeL.objValue;
    }

    public final void o(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this) {
                l95.m().B("key_homepage_rec_forum_record_info", str);
            }
        }
    }

    public void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public final boolean i(@Nullable d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            List<d> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(m())) {
                arrayList = g(m());
            }
            long j = dVar.a;
            long j2 = dVar.b;
            d dVar2 = (d) ListUtils.getItem(arrayList, 1);
            d dVar3 = (d) ListUtils.getItem(arrayList, 0);
            if (dVar2 != null) {
                if (dVar3 == null || j2 - dVar2.c() < 86400000) {
                    return false;
                }
                if (j2 - dVar3.c() < 86400000 && j == dVar3.a) {
                    return false;
                }
                return true;
            } else if (dVar3 != null && j2 - dVar3.c() < 86400000 && j == dVar3.a) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void n(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, threadData) != null) || !this.d) {
            return;
        }
        if (this.c == null) {
            this.c = new FastRequest(this.b, CmdConfigHttp.CMD_GET_HOMEPAGE_REC_FORUM_INFO, TbConfig.GET_HOMEPAGE_REC_FORUM_INFO);
        }
        String forum_name = threadData.getForum_name();
        String tid = threadData.getTid();
        long fid = threadData.getFid();
        if (this.a != null && !TextUtils.isEmpty(tid) && !TextUtils.isEmpty(forum_name) && fid > 0) {
            this.d = false;
            FastRequest fastRequest = this.c;
            fastRequest.V("forum_id", Long.valueOf(fid));
            fastRequest.V("forum_name", forum_name);
            fastRequest.Z(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.X(new b(this, tid, fid, threadData));
            fastRequest.b0(new a(this));
            fastRequest.W();
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.e == null) {
                return false;
            }
            List<d> list = null;
            if (!TextUtils.isEmpty(m())) {
                list = g(m());
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ListUtils.add(list, 0, this.e);
            if (ListUtils.getCount(list) > 2) {
                list = list.subList(0, 2);
            }
            String h = h(list);
            if (TextUtils.isEmpty(h)) {
                return false;
            }
            o(h);
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final String m() {
        InterceptResult invokeV;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                s = l95.m().s("key_homepage_rec_forum_record_info", "");
            }
            return s;
        }
        return (String) invokeV.objValue;
    }
}
