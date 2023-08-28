package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.c55;
import com.baidu.tieba.dfa;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class f4b implements t2b, n2b, ai5, dfa.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    @NonNull
    public TbPageContext<?> a;
    @NonNull
    public NavigationBar b;
    @NonNull
    public LinearLayout c;
    @NonNull
    public EditorTools d;
    @NonNull
    public q2b e;
    @Nullable
    public r3b f;
    @NonNull
    public q3b g;
    public View h;
    public TextView i;
    public View j;
    public ImageView k;
    public TextView l;
    public SaveDraftDialogView m;
    public a55 n;
    @NonNull
    public final List<r2b<?>> o;
    @NonNull
    public WriteData p;
    public boolean q;
    public Handler r;
    public g1b s;
    public b4b t;
    public t3b u;
    public e1b v;
    public k1b w;
    public final CustomMessageListener x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.t2b
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.t2b
    public LinkedList<xa5> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public abstract void L(@NonNull List<r2b<?>> list);

    public abstract void N(@NonNull EditorTools editorTools);

    public abstract r3b V();

    public abstract void Y();

    public abstract boolean e0();

    @Override // com.baidu.tieba.t2b
    public void f(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.tieba.t2b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.t2b
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t2b
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, intent) == null) {
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
        }
    }

    @Override // com.baidu.tieba.t2b
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
        }
    }

    @Override // com.baidu.tieba.t2b
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, iArr) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        public a(f4b f4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                BdUtilHelper.hideSoftKeyPad(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f4b f4bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        public c(f4b f4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y45 a;
        public final /* synthetic */ a55 b;
        public final /* synthetic */ f4b c;

        public d(f4b f4bVar, y45 y45Var, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar, y45Var, a55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f4bVar;
            this.a = y45Var;
            this.b = a55Var;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) && i == this.a.f()) {
                this.c.a();
                this.b.dismiss();
                this.c.e.setResult(100);
                this.c.e.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a55 a;

        public e(f4b f4bVar, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar, a55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a55Var;
        }

        @Override // com.baidu.tieba.c55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ f4b b;

        public f(f4b f4bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f4bVar;
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                this.b.a();
                this.b.e.setResult(100);
                if (this.a) {
                    this.b.X();
                    this.b.e.x();
                } else {
                    this.b.e.finish();
                }
            } else if (id == R.id.save_draft_dialog_save) {
                this.b.c0();
                this.b.e.setResult(100);
                if (this.a) {
                    this.b.X();
                    this.b.e.x();
                } else {
                    this.b.e.finish();
                }
            }
            this.b.n.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        public g(f4b f4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.A) {
                    for (r2b<?> r2bVar : this.a.o) {
                        if (r2bVar instanceof s2b) {
                            s2b s2bVar = (s2b) r2bVar;
                            if (s2bVar.f() == 2) {
                                s2bVar.l();
                            }
                        }
                    }
                    return;
                }
                this.a.A = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        public h(f4b f4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f4b f4bVar = this.a;
                if (f4bVar.d.a == null) {
                    return;
                }
                if (f4bVar.v == null) {
                    f4b f4bVar2 = this.a;
                    f4bVar2.v = new e1b(f4bVar2.a);
                }
                this.a.v.b(this.a.d.a.s(2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        public i(f4b f4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    f4b f4bVar = this.a;
                    f4bVar.b(f4bVar.a.getString(R.string.obfuscated_res_0x7f0f17bc));
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4b a;

        public j(f4b f4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                BdUtilHelper.showSoftKeyPad(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    public f4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull q2b q2bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, q2bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.r = new Handler(Looper.getMainLooper());
        this.s = new g1b();
        this.x = new b(this, 2016554);
        this.a = tbPageContext;
        this.b = navigationBar;
        this.c = linearLayout;
        this.d = editorTools;
        this.e = q2bVar;
        this.z = z;
        this.p = new WriteData();
        this.f = V();
        this.g = new q3b(this.d);
        this.p.setNewWritePage(true);
    }

    @Override // com.baidu.tieba.t2b
    public void C(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zh5Var) != null) || zh5Var == null) {
            return;
        }
        this.d.D(zh5Var);
    }

    @Override // com.baidu.tieba.ai5
    public void E(zh5 zh5Var) {
        r3b r3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, zh5Var) == null) && (r3bVar = this.f) != null) {
            r3bVar.E(zh5Var);
        }
    }

    @Override // com.baidu.tieba.t2b
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.e.b(str);
        }
    }

    public void d0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || (textView = this.l) == null) {
            return;
        }
        textView.setEnabled(z);
    }

    @Override // com.baidu.tieba.t2b
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.p.setPrivacy(z);
        }
    }

    @Override // com.baidu.tieba.t2b
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            if (z) {
                l0();
            } else {
                BdUtilHelper.showSoftKeyPad(this.a.getPageActivity(), this.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z) {
                R();
            } else {
                BdUtilHelper.hideSoftKeyPad(this.a.getPageActivity(), this.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.p.setShowCustomFigure(z);
        }
    }

    @Override // com.baidu.tieba.n2b
    @CallSuper
    public void q(@NonNull s2b s2bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048636, this, s2bVar, z) == null) {
            if (z) {
                o(true);
                this.d.t();
            }
            w();
        }
    }

    @Override // com.baidu.tieba.t2b
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.t2b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.t();
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.registerListener(this.x);
            if (this.y) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            b0();
            i0();
        }
    }

    public final void P() {
        e1b e1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (e1bVar = this.v) != null) {
            e1bVar.a();
        }
    }

    public void Q() {
        k1b k1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (k1bVar = this.w) != null) {
            k1bVar.b();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.r.postDelayed(new a(this), 150L);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            t3b t3bVar = new t3b(this.a, this.d);
            this.u = t3bVar;
            t3bVar.g();
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = new b4b(this.a, this.s);
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.B = true;
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.e.P0(onBackPressed());
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new i(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.t2b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.e.d();
        }
    }

    @Override // com.baidu.tieba.t2b
    public void g() {
        li5 p;
        mi5 mi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (p = this.d.p(6)) != null && (mi5Var = p.m) != null) {
            mi5Var.E(new zh5(52, 0, null));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.d.post(new h(this));
        }
    }

    @Override // com.baidu.tieba.t2b
    public void i() {
        t3b t3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (t3bVar = this.u) != null) {
            t3bVar.f();
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.w == null) {
                this.w = new k1b(this.a);
            }
            this.w.c(this.d);
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.r.postDelayed(new j(this), 150L);
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            B();
            for (r2b<?> r2bVar : this.o) {
                r2bVar.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            for (r2b<?> r2bVar : this.o) {
                r2bVar.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            B();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            z3b.d(this.a, this.p);
        }
    }

    @Override // com.baidu.tieba.t2b
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.g.a();
        }
    }

    @CallSuper
    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, bundle) != null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent = this.a.getPageActivity().getIntent();
        for (r2b<?> r2bVar : this.o) {
            if (r2bVar != null) {
                r2bVar.m(bundle, intent, this.p);
                LinearLayout linearLayout = this.c;
                linearLayout.addView(r2bVar.s(linearLayout));
                r2bVar.j(this);
            }
        }
        this.c.setDrawingCacheEnabled(false);
        this.c.setOnClickListener(new g(this));
        j();
    }

    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, writeData) != null) || writeData == null) {
            return;
        }
        if (this.q) {
            if (writeData.isRichTextEditorMode() && 11 != this.p.getType()) {
                this.e.Q0(11, true);
                return;
            } else if (!writeData.isRichTextEditorMode() && 9 != this.p.getType()) {
                this.e.Q0(9, true);
                return;
            }
        }
        for (r2b<?> r2bVar : this.o) {
            r2bVar.c(writeData);
        }
        j();
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.b.onChangeSkinType(this.a, i2);
            WebPManager.setPureDrawable(this.b.getBackImageView(), R.drawable.icon_pure_topbar_close40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.l.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            this.d.z(i2);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            for (r2b<?> r2bVar : this.o) {
                r2bVar.onChangeSkinType(i2);
            }
            j();
            w();
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onCreate(Bundle bundle) {
        b4b b4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            U(bundle);
            O(this.b);
            N(this.d);
            L(this.o);
            K(bundle);
            W();
            T();
            M();
            if (this.z) {
                Y();
            }
            if (this.p.isFromErrorDialog() && (b4bVar = this.t) != null) {
                b4bVar.h();
            }
            Z();
        }
    }

    @Override // com.baidu.tieba.t2b
    public void z(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, zh5Var) == null) {
            for (r2b<?> r2bVar : this.o) {
                r2bVar.r(zh5Var);
            }
            if (zh5Var.a == 77) {
                HashMap<String, Serializable> hashMap = new HashMap<>();
                hashMap.put("postTitle", this.p.getTitle());
                hashMap.put("postContent", this.p.getToServerContent());
                hz4 j2 = hz4.j(this.a.getPageActivity(), ei5.c(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, this.p.getForumId()));
                j2.f(hashMap);
                j2.p();
            }
        }
    }

    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, navigationBar) == null) {
            this.i = navigationBar.getCenterText();
            this.k = (ImageView) navigationBar.getCenterImgBox();
            this.j = navigationBar.getCenterImgBoxLayout();
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.h = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new c(this));
            String string = this.a.getString(R.string.send_post);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f1387);
            }
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
            this.l = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.l.setLayoutParams(layoutParams);
            j();
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && this.a.getPageActivity() != null && !this.a.getPageActivity().isFinishing()) {
            if (this.m == null) {
                this.m = new SaveDraftDialogView(this.a.getPageActivity());
                this.m.setOnClickListener(new f(this, z));
            }
            if (this.n == null) {
                a55 a55Var = new a55(this.a);
                this.n = a55Var;
                a55Var.setContentView(this.m);
            }
            this.m.setText(this.a.getString(R.string.write_save_draft_dialog_normal_title), this.a.getString(R.string.obfuscated_res_0x7f0f12d8));
            this.n.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03ce  */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U(Bundle bundle) {
        Intent intent;
        boolean z;
        WriteData writeData;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, bundle) != null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent2 = this.a.getPageActivity().getIntent();
        if (bundle != null) {
            this.p.setType(bundle.getInt("type", 9));
            this.p.setForumId(bundle.getString("forum_id"));
            this.p.setForumName(bundle.getString("forum_name"));
            this.p.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.p.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.p.setThreadId(bundle.getString("thread_id"));
            this.p.setTitle(bundle.getString(BaseWriteConfig.TITLE));
            this.p.setContent(bundle.getString(BaseWriteConfig.CONTENT));
            this.p.setCallFrom(bundle.getString(BaseWriteConfig.KEY_CALL_FROM));
            String string = bundle.getString(BaseWriteConfig.PREFIX_DATA);
            PostPrefixData postPrefixData = null;
            if (!StringUtils.isNull(string)) {
                postPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string, PostPrefixData.class);
            }
            if ("1".equals(bundle.getString(WriteActivityConfig.NO_SUCCESS_TOAST))) {
                z2 = true;
                this.p.setInterceptWriteResultDialog(true);
            } else {
                z2 = true;
            }
            if (bundle.getBoolean(WriteActivityConfig.KEY_PUT_STORAGE_TID, false)) {
                this.p.setPutStorageTid(z2);
            }
            this.p.setPrefixData(postPrefixData);
            this.p.setFrom(bundle.getString("from"));
            this.p.setTopicId(bundle.getString(WriteActivityConfig.HOT_TOPIC_ID));
            this.p.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.p.setPrivateThread(bundle.getInt(BaseWriteConfig.PRIVATE_THREAD));
            this.p.setFrsTabInfoData((FrsTabInfoData) bundle.getSerializable("tab_list"));
            this.p.setCanGoods(bundle.getBoolean(WriteActivityConfig.CAN_GOODS));
            this.y = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
            this.q = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            this.p.setNotificationH5(bundle.getBoolean(WriteActivityConfig.KEY_NOTIFICATION_H5, false));
            this.p.setNotFakePost(bundle.getBoolean(WriteActivityConfig.KEY_NOT_FAKE_POST, false));
            this.p.setActiveName(bundle.getString(WriteActivityConfig.KEY_ACTIVE_NAME));
            this.p.setActiveTaskName(bundle.getString(WriteActivityConfig.KEY_ACTIVE_TASK_NAME));
            this.p.setHintText(bundle.getString(WriteActivityConfig.KEY_WRITE_HINT_TEXT));
            this.p.setInputInsertAtList(bundle.getParcelableArrayList(WriteActivityConfig.KEY_WRITE_AT_LIST));
        } else if (intent2 != null) {
            intent = intent2;
            this.p.setType(intent.getIntExtra("type", 9));
            this.p.setForumId(intent.getStringExtra("forum_id"));
            this.p.setForumName(intent.getStringExtra("forum_name"));
            this.p.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.p.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.p.setThreadId(intent.getStringExtra("thread_id"));
            this.p.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
            this.p.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
            this.p.setCallFrom(intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM));
            this.p.setFrom(intent.getStringExtra("from"));
            this.p.setTopicId(intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID));
            this.p.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.p.setPrivateThread(intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0));
            this.p.setFrsTabInfoData((FrsTabInfoData) intent.getSerializableExtra("tab_list"));
            this.p.setVoiceEnable(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            this.p.setDisableAudioMessage(intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE));
            this.p.setCanGoods(intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false));
            this.y = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
            PostPrefixData postPrefixData2 = (PostPrefixData) intent.getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
            if (postPrefixData2 != null && postPrefixData2.getPrefixs().size() > 0) {
                postPrefixData2.getPrefixs().add(this.a.getString(R.string.write_no_prefix));
            }
            if ("1".equals(intent.getStringExtra(WriteActivityConfig.NO_SUCCESS_TOAST))) {
                z = true;
                this.p.setInterceptWriteResultDialog(true);
            } else {
                z = true;
            }
            if (intent.getBooleanExtra(WriteActivityConfig.KEY_PUT_STORAGE_TID, false)) {
                this.p.setPutStorageTid(z);
            }
            this.p.setPrefixData(postPrefixData2);
            this.p.setWriteVoteData((WriteVoteData) intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA));
            this.p.setFromItemDetail(intent.getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false));
            this.p.setIntentStarCount(intent.getIntExtra(WriteActivityConfig.STAR_COUNT, 0));
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.ITEM_INFO);
            if (serializableExtra instanceof SerializableItemInfo) {
                SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                this.p.setIntentItemInfo(serializableItemInfo);
                this.p.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.p.setSaveDraft(intent.getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true));
            this.p.setMoreForumImg(intent.getStringExtra("more_forum_img"));
            this.p.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
            this.p.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
            this.p.setIsArticle(intent.getStringExtra(WriteActivityConfig.IS_ARTICLE));
            this.p.setNetImgUrl(intent.getStringExtra(WriteActivityConfig.KEY_GAME_RANK_IMG_URL));
            this.p.setFromGameRank(intent.getBooleanExtra(WriteActivityConfig.KEY_IS_FROM_GAME_RANK, false));
            this.p.setGameId(intent.getStringExtra(WriteActivityConfig.KEY_GAME_ID));
            this.p.setGameName(intent.getStringExtra(WriteActivityConfig.KEY_GAME_NAME));
            this.p.setRewardsType(intent.getStringExtra(WriteActivityConfig.KEY_REWARDS_TYPE));
            this.p.setXiuxiuOriginalContent(intent.getStringExtra(WriteActivityConfig.KEY_XIUXIU_ORIGINAL_CONTENT));
            this.p.setXiuxiuOriginalFname(intent.getStringExtra(WriteActivityConfig.KEY_XIUXIU_ORIGINAL_FNAME));
            this.p.setIsArticle(intent.getStringExtra(WriteActivityConfig.IS_ARTICLE));
            this.p.setNotificationH5(intent.getBooleanExtra(WriteActivityConfig.KEY_NOTIFICATION_H5, false));
            this.p.setNotFakePost(intent.getBooleanExtra(WriteActivityConfig.KEY_NOT_FAKE_POST, false));
            this.p.setHintText(intent.getStringExtra(WriteActivityConfig.KEY_WRITE_HINT_TEXT));
            this.p.setInputInsertAtList(intent.getParcelableArrayListExtra(WriteActivityConfig.KEY_WRITE_AT_LIST));
            this.q = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            this.p.setActiveName(intent.getStringExtra(WriteActivityConfig.KEY_ACTIVE_NAME));
            this.p.setActiveTaskName(intent.getStringExtra(WriteActivityConfig.KEY_ACTIVE_TASK_NAME));
            if (this.p.getType() != 10) {
                this.p.setEntranceType(2);
                this.p.setType(9);
            } else {
                this.p.setEntranceType(1);
            }
            if (bundle == null && intent != null) {
                this.p.setFromErrorDialog(intent.getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false));
            }
            if (this.p.isFromErrorDialog() && (writeData = zha.f) != null) {
                this.p = writeData;
                writeData.setFromErrorDialog(true);
                WriteData writeData2 = this.p;
                writeData2.setContent(writeData2.getPlainTextContent());
            }
            w();
        }
        intent = intent2;
        if (this.p.getType() != 10) {
        }
        if (bundle == null) {
            this.p.setFromErrorDialog(intent.getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false));
        }
        if (this.p.isFromErrorDialog()) {
            this.p = writeData;
            writeData.setFromErrorDialog(true);
            WriteData writeData22 = this.p;
            writeData22.setContent(writeData22.getPlainTextContent());
        }
        w();
    }

    public void X() {
        String forumId;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig type = WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9);
        if (TextUtils.isEmpty(this.p.getForumId())) {
            forumId = "0";
        } else {
            forumId = this.p.getForumId();
        }
        type.setForumId(forumId).setForumName(this.p.getForumName()).setEnableAudio(this.p.isVoiceEnable()).setAudioMsg(this.p.getDisableAudioMessage()).setCanGoods(false).setPrefixData(this.p.getPrefixData()).setPrivateThread(this.p.getPrivateThread()).setForumDir(this.p.getFirstDir(), this.p.getSecondDir()).setFrsTabInfo(this.p.getFrsTabInfoData()).setCallFrom(this.p.getCallFrom()).setStatisticFrom(this.p.getStatisticFrom()).setIsEvaluate(true).setScoreItemInfo(this.p.getIntentItemInfo()).setStarCount(this.p.getIntentStarCount()).setFrom(this.p.getFrom()).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        if ("main_tab".equals(this.p.getFrom())) {
            i2 = 8;
        } else {
            i2 = 2;
        }
        statisticItem.param("obj_locate", i2);
        statisticItem.param("obj_type", 6);
        TiebaStatic.log(statisticItem);
    }

    public final void Z() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int i3 = 1;
            switch (this.p.getType()) {
                case 9:
                case 13:
                    i2 = 1;
                    break;
                case 10:
                default:
                    i2 = -1;
                    break;
                case 11:
                    i2 = 2;
                    break;
                case 12:
                    i2 = 4;
                    break;
                case 14:
                    i2 = 5;
                    break;
            }
            if ("main_tab".equals(this.p.getFrom())) {
                i3 = 0;
            } else if (!"frs".equals(this.p.getFrom())) {
                i3 = -1;
            }
            p1b.c(i2, i3);
            p1b.f(this.p);
        }
    }

    public final boolean f0() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null && (textView = this.l) != null) {
                if (textView.isEnabled() || !ListUtils.isEmpty(this.p.getItemDatas())) {
                    return "1".equals(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.SHOW_NOT_SAVE_POPUP));
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            int i2 = SharedPrefHelper.getInstance().getInt("write_associate_item_hint_tip_key", 0);
            if (SharedPrefHelper.getInstance().getInt("commodity_tip_show_controller", 0) == 0 && this.p.isCanGoods()) {
                if (i2 > 0) {
                    g0();
                    return;
                } else {
                    SharedPrefHelper.getInstance().putInt("commodity_tip_show_controller", SharedPrefHelper.getInstance().getInt("commodity_tip_show_controller", 0) + 1);
                    return;
                }
            }
            j0();
            t3b t3bVar = this.u;
            if (t3bVar != null) {
                t3bVar.e();
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            hotSelectActivityConfig.setForumExtra(JavaTypesHelper.toLong(this.p.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            this.a.sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    @Override // com.baidu.tieba.t2b
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            for (r2b<?> r2bVar : this.o) {
                if (r2bVar.g()) {
                    return true;
                }
            }
            if (this.d.x()) {
                B();
                return true;
            } else if (e0()) {
                a();
                return false;
            } else {
                if (f0()) {
                    k0();
                } else {
                    h0(false);
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (!this.B) {
                c0();
            }
            for (r2b<?> r2bVar : this.o) {
                r2bVar.b();
            }
            b4b b4bVar = this.t;
            if (b4bVar != null) {
                b4bVar.g();
            }
            EditorTools editorTools = this.d;
            if (editorTools != null) {
                editorTools.s(15);
            }
            this.r.removeCallbacksAndMessages(null);
            TiebaPrepareImageService.StopService();
            Q();
            P();
            jg.b(this.n, this.a);
            lfa.d();
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B = true;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                this.e.finish();
                return;
            }
            for (r2b<?> r2bVar : this.o) {
                r2bVar.d(this.p);
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            B();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            TbPageContext<?> tbPageContext = this.a;
            WriteData writeData = this.p;
            z3b.b(tbPageContext, writeData, writeData.getWriteImagesInfo(), this.p.getFrom(), this.p.getDisableAudioMessage(), this.p.isVoiceEnable(), this.p.getPrefixData());
        }
    }

    @Override // com.baidu.tieba.t2b
    @NonNull
    public PermissionJudgePolicy t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            Activity pageActivity = this.a.getPageActivity();
            if (pageActivity instanceof BaseActivity) {
                return ((BaseActivity) pageActivity).getCurrentPermissionJudgePolicy();
            }
            if (pageActivity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) pageActivity).getCurrentPermissionJudgePolicy();
            }
            return new PermissionJudgePolicy();
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (this.v != null && !z) {
                P();
            }
            if (z) {
                B();
            }
            for (r2b<?> r2bVar : this.o) {
                if (r2bVar instanceof s2b) {
                    ((s2b) r2bVar).e(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.n2b
    public void l(@NonNull s2b s2bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, s2bVar) != null) || this.t == null) {
            return;
        }
        if (s2bVar.f() == 1) {
            this.t.j(s2bVar.p());
        } else if (s2bVar.f() == 2) {
            this.t.i(s2bVar.p());
        }
    }

    @Override // com.baidu.tieba.t2b
    public void n(@Nullable ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, arrayList) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageActivity(), 12004, true);
            atListActivityConfig.setSelectedAtList(arrayList);
            this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            a55 a55Var = new a55(this.a);
            c55 c55Var = new c55(this.a.getPageActivity());
            c55Var.t(this.a.getString(R.string.obfuscated_res_0x7f0f0e9f));
            ArrayList arrayList = new ArrayList();
            y45 y45Var = new y45(this.a.getString(R.string.obfuscated_res_0x7f0f0e9e), c55Var);
            y45Var.q(R.color.CAM_X0107);
            arrayList.add(y45Var);
            d dVar = new d(this, y45Var, a55Var);
            e eVar = new e(this, a55Var);
            c55Var.l(arrayList);
            c55Var.q(dVar);
            c55Var.o(eVar);
            a55Var.setCanceledOnTouchOutside(true);
            a55Var.h(c55Var);
            jg.j(a55Var, this.a);
        }
    }

    @Override // com.baidu.tieba.t2b
    @CallSuper
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048624, this, i2, i3, intent) == null) {
            if (i3 == -1) {
                if (i2 == 12002) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                        this.a.getPageActivity().setResult(-1, intent);
                        this.a.getPageActivity().finish();
                        return;
                    }
                } else if (i2 == 25064) {
                    z3b.a(this.a, this.p);
                } else if (i2 == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                }
            } else if (i3 == 0 && i2 == 12006 && intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                this.a.showToast(postWriteCallBackData.getErrorString());
                this.s.n(postWriteCallBackData.getErrorString());
                this.s.m(postWriteCallBackData.getSensitiveWords());
                for (r2b<?> r2bVar : this.o) {
                    if (r2bVar instanceof s2b) {
                        ((s2b) r2bVar).n();
                    }
                }
            }
            for (r2b<?> r2bVar2 : this.o) {
                r2bVar2.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tieba.t2b
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048632, this, bundle) != null) || bundle == null) {
            return;
        }
        bundle.putInt("type", this.p.getType());
        bundle.putString("forum_id", this.p.getForumId());
        bundle.putString("forum_name", this.p.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.p.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.p.getSecondDir());
        bundle.putString("thread_id", this.p.getThreadId());
        bundle.putString(BaseWriteConfig.KEY_CALL_FROM, this.p.getCallFrom());
        bundle.putInt(BaseWriteConfig.PRIVATE_THREAD, this.p.getPrivateThread());
        bundle.putString("from", this.p.getFrom());
        bundle.putSerializable("tab_list", this.p.getFrsTabInfoData());
        bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.y);
        PostPrefixData prefixData = this.p.getPrefixData();
        if (prefixData != null) {
            bundle.putString(BaseWriteConfig.PREFIX_DATA, OrmObject.jsonStrWithObject(prefixData));
        }
        for (r2b<?> r2bVar : this.o) {
            r2bVar.onSaveInstanceState(bundle);
        }
    }
}
