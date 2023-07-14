package com.baidu.tieba;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends kc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, nh nhVar, boolean z) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, nhVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nhVar;
            this.d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.F(getFileInfo().length());
                    if (this.d || this.c.l() > 20480) {
                        hi.b(this.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, nh nhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, nhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nhVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.F(0L);
                    xh.m().s(this.a);
                    return;
                }
                BdLog.e("Track Log rename fail!");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends kc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, nh nhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, nhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nhVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.F(getFileInfo().length());
                }
            }
        }
    }

    public static long a(nh nhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nhVar)) == null) {
            if (nhVar == null) {
                return -1L;
            }
            if (nhVar.v() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getTrackLogWriteDir(), nhVar.s(), DiskFileOperate.Action.INFO, nhVar);
                cVar.setSdCard(nhVar.C());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (fc.f().a(cVar)) {
                    return nhVar.v();
                }
            }
            return nhVar.v();
        }
        return invokeL.longValue;
    }

    public static void b(nh nhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, nhVar) != null) || nhVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), nhVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), nhVar.r(), DiskFileOperate.Action.RENAME, nhVar);
        bVar.setSdCard(nhVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        fc.f().a(bVar);
    }

    public static void c(nh nhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65538, null, nhVar, z) == null) && nhVar != null && nhVar.l() != 0) {
            a aVar = new a(BdStatisticsManager.getInstance().getTrackLogWriteDir(), nhVar.s(), DiskFileOperate.Action.APPEND, nhVar, z);
            aVar.setSdCard(nhVar.C());
            aVar.b(nhVar.z().toString());
            nhVar.f();
            if (!nhVar.A()) {
                aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.setTrySuccessWeight(3);
            }
            if (!fc.f().a(aVar)) {
                BdLog.e("Track Log write to disk fail!");
            }
        }
    }
}
