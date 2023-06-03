package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ev9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DialogInterface.OnDismissListener a;
    public c b;

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b55 a;
        public final /* synthetic */ ev9 b;

        public a(ev9 ev9Var, b55 b55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var, b55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ev9Var;
            this.a = b55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.b != null) {
                    this.b.b.a();
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b55 a;
        public final /* synthetic */ dv9 b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ ev9 d;

        public b(ev9 ev9Var, b55 b55Var, dv9 dv9Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var, b55Var, dv9Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ev9Var;
            this.a = b55Var;
            this.b = dv9Var;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                gv9 gv9Var = new gv9();
                dv9 dv9Var = this.b;
                if (dv9Var != null) {
                    gv9Var.g(dv9Var.a());
                    gv9Var.h(this.b.b());
                }
                new fv9(this.c, gv9Var).a();
                this.d.j();
                if (this.d.b != null) {
                    this.d.b.c();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947747937, "Lcom/baidu/tieba/ev9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947747937, "Lcom/baidu/tieba/ev9;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public ev9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new NewStyleStampDialogView(TbadkCoreApplication.getInst().getContext());
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDismissListener) == null) {
            this.a = onDismissListener;
        }
    }

    public /* synthetic */ void c(b55 b55Var, TbPageContext tbPageContext, View view2) {
        b55Var.a();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            h();
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public b55 d(IconPopData iconPopData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconPopData)) == null) {
            if (iconPopData != null && iconPopData.getPic160() != null && iconPopData.getTitle() != null) {
                dv9 dv9Var = new dv9();
                String pic160 = iconPopData.getPic160();
                dv9Var.d(iconPopData.getTitle());
                dv9Var.c(pic160);
                PollingModel.N0(iconPopData, true);
                return g(dv9Var);
            }
            return null;
        }
        return (b55) invokeL.objValue;
    }

    public final b55 g(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dv9Var)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            final TbPageContext tbPageContext = null;
            if (currentActivity == null) {
                return null;
            }
            if (currentActivity instanceof TbPageContextSupport) {
                tbPageContext = ((TbPageContextSupport) currentActivity).getPageContext();
            }
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(currentActivity);
            newStyleStampDialogView.setStampData(dv9Var);
            final b55 b55Var = new b55(currentActivity);
            b55Var.c(newStyleStampDialogView);
            b55Var.d(this.a);
            try {
                b55Var.e();
            } catch (Exception e) {
                b55Var.a();
                BdLog.e(e);
            }
            i();
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new a(this, b55Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.cv9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ev9.this.c(b55Var, tbPageContext, view2);
                    }
                }
            });
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new b(this, b55Var, dv9Var, currentActivity));
            return b55Var;
        }
        return (b55) invokeL.objValue;
    }
}
