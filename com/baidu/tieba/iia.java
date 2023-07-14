package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tieba.f65;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.x9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iia extends f65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final pfa d;
    public IconPopData e;
    public q55 f;

    /* loaded from: classes6.dex */
    public class a implements x9a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iia a;

        public a(iia iiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iiaVar;
        }

        @Override // com.baidu.tieba.x9a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }

        @Override // com.baidu.tieba.x9a.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c();
            }
        }

        @Override // com.baidu.tieba.x9a.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iia a;

        public b(iia iiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iiaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                m65.u("userIcon");
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iia(MainTabActivity mainTabActivity, pfa pfaVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
        this.d = pfaVar;
    }

    @Override // com.baidu.tieba.f65
    public void b() {
        q55 q55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (q55Var = this.f) != null) {
            q55Var.a();
        }
    }

    @Override // com.baidu.tieba.f65
    public void d(f65.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (m65.k() && aVar != null) {
                aVar.callback(false);
                return;
            }
            pfa pfaVar = this.d;
            if ((pfaVar == null || pfaVar.y() == null || (this.d.y().getCurrentTabType() != 2 && this.d.y().getCurrentTabType() != 1 && this.d.y().getCurrentTabType() != 3)) && aVar != null) {
                aVar.callback(false);
                return;
            }
            IconPopData iconPopData = TbSingleton.getInstance().getIconPopData();
            this.e = iconPopData;
            if (iconPopData != null && PollingModel.z0() && this.e.getPic160() != null && this.e.getTitle() != null && this.c.L1() && this.c.B && this.e.getUid().longValue() == TbadkCoreApplication.getCurrentAccountId() && aVar != null) {
                aVar.callback(true);
            } else if (aVar != null) {
                aVar.callback(false);
            }
        }
    }

    @Override // com.baidu.tieba.f65
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.e == null) {
                this.e = TbSingleton.getInstance().getIconPopData();
            }
            if (!PollingModel.z0()) {
                c();
                return;
            }
            x9a x9aVar = new x9a();
            x9aVar.e(new a(this));
            x9aVar.f(new b(this));
            this.f = x9aVar.d(this.e);
            m65.n("userIcon");
        }
    }
}
