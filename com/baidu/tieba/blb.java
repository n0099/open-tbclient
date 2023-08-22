package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xkb;
import com.baidu.tieba.zkb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class blb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Deque<c>> a;

    /* loaded from: classes5.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zkb a;
        public final HashSet<Ssp.Pid> b;

        public a(zkb zkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zkbVar;
            this.b = new HashSet<>();
            for (zkb.c cVar : zkbVar.e) {
                for (zkb.b bVar : cVar.b) {
                    this.b.add(bVar.c);
                }
            }
        }

        @Override // com.baidu.tieba.blb.c
        public Set<Ssp.Pid> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Set) invokeV.objValue;
        }

        @Override // com.baidu.tieba.blb.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.d : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xkb a;
        public final HashSet<Ssp.Pid> b;

        public b(xkb xkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xkbVar;
            this.b = new HashSet<>();
            for (xkb.b bVar : xkbVar.b) {
                for (xkb.a aVar : bVar.b) {
                    this.b.add(aVar.c);
                }
            }
        }

        @Override // com.baidu.tieba.blb.c
        public Set<Ssp.Pid> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Set) invokeV.objValue;
        }

        @Override // com.baidu.tieba.blb.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.c : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        Set<Ssp.Pid> a();

        int b();
    }

    public blb() {
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
        this.a = new HashMap<>();
    }

    public final Deque<c> a(String str) {
        InterceptResult invokeL;
        Deque<c> deque;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.a) {
                deque = this.a.get(str);
                if (deque == null) {
                    deque = new ArrayDeque<>();
                    this.a.put(str, deque);
                }
            }
            return deque;
        }
        return (Deque) invokeL.objValue;
    }
}
