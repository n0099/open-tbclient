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
public class bx9 {
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
        public final /* synthetic */ e55 a;
        public final /* synthetic */ bx9 b;

        public a(bx9 bx9Var, e55 e55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, e55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bx9Var;
            this.a = e55Var;
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
        public final /* synthetic */ e55 a;
        public final /* synthetic */ ax9 b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ bx9 d;

        public b(bx9 bx9Var, e55 e55Var, ax9 ax9Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, e55Var, ax9Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = bx9Var;
            this.a = e55Var;
            this.b = ax9Var;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                dx9 dx9Var = new dx9();
                ax9 ax9Var = this.b;
                if (ax9Var != null) {
                    dx9Var.g(ax9Var.a());
                    dx9Var.h(this.b.b());
                }
                new cx9(this.c, dx9Var).a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947660486, "Lcom/baidu/tieba/bx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947660486, "Lcom/baidu/tieba/bx9;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public bx9() {
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

    public /* synthetic */ void c(e55 e55Var, TbPageContext tbPageContext, View view2) {
        e55Var.a();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            h();
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public e55 d(IconPopData iconPopData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconPopData)) == null) {
            if (iconPopData != null && iconPopData.getPic160() != null && iconPopData.getTitle() != null) {
                ax9 ax9Var = new ax9();
                String pic160 = iconPopData.getPic160();
                ax9Var.d(iconPopData.getTitle());
                ax9Var.c(pic160);
                PollingModel.N0(iconPopData, true);
                return g(ax9Var);
            }
            return null;
        }
        return (e55) invokeL.objValue;
    }

    public final e55 g(ax9 ax9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ax9Var)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            final TbPageContext tbPageContext = null;
            if (currentActivity == null) {
                return null;
            }
            if (currentActivity instanceof TbPageContextSupport) {
                tbPageContext = ((TbPageContextSupport) currentActivity).getPageContext();
            }
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(currentActivity);
            newStyleStampDialogView.setStampData(ax9Var);
            final e55 e55Var = new e55(currentActivity);
            e55Var.c(newStyleStampDialogView);
            e55Var.d(this.a);
            try {
                e55Var.e();
            } catch (Exception e) {
                e55Var.a();
                BdLog.e(e);
            }
            i();
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new a(this, e55Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zw9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        bx9.this.c(e55Var, tbPageContext, view2);
                    }
                }
            });
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new b(this, e55Var, ax9Var, currentActivity));
            return e55Var;
        }
        return (e55) invokeL.objValue;
    }
}
