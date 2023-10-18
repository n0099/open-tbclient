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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.rz4;
import com.baidu.tieba.sda;
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
public abstract class a3b implements o1b, i1b, dd5, sda.h {
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
    public l1b e;
    @Nullable
    public m2b f;
    @NonNull
    public l2b g;
    public View h;
    public TextView i;
    public View j;
    public ImageView k;
    public TextView l;
    public SaveDraftDialogView m;
    public pz4 n;
    @NonNull
    public final List<m1b<?>> o;
    @NonNull
    public WriteData p;
    public boolean q;
    public Handler r;
    public b0b s;
    public w2b t;
    public o2b u;
    public zza v;
    public f0b w;
    public final CustomMessageListener x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.o1b
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o1b
    public LinkedList<t55> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public abstract void K(@NonNull List<m1b<?>> list);

    public abstract void M(@NonNull EditorTools editorTools);

    public abstract m2b U();

    public abstract void X();

    public abstract boolean e0();

    @Override // com.baidu.tieba.o1b
    public void f(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.tieba.o1b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.o1b
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o1b
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, intent) == null) {
        }
    }

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o1b
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o1b
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, iArr) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a3b a;

        public a(a3b a3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3bVar;
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
        public final /* synthetic */ a3b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a3b a3bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar, Integer.valueOf(i)};
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
            this.a = a3bVar;
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
        public final /* synthetic */ a3b a;

        public c(a3b a3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz4 a;
        public final /* synthetic */ pz4 b;
        public final /* synthetic */ a3b c;

        public d(a3b a3bVar, nz4 nz4Var, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar, nz4Var, pz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a3bVar;
            this.a = nz4Var;
            this.b = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) && i == this.a.e()) {
                this.c.b();
                this.b.dismiss();
                this.c.e.setResult(100);
                this.c.e.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements rz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz4 a;

        public e(a3b a3bVar, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar, pz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.c
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
        public final /* synthetic */ a3b b;

        public f(a3b a3bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a3bVar;
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
                this.b.b();
                this.b.e.setResult(100);
                if (this.a) {
                    this.b.W();
                    this.b.e.s();
                } else {
                    this.b.e.finish();
                }
            } else if (id == R.id.save_draft_dialog_save) {
                this.b.b0();
                this.b.e.setResult(100);
                if (this.a) {
                    this.b.W();
                    this.b.e.s();
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
        public final /* synthetic */ a3b a;

        public g(a3b a3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.A) {
                    for (m1b<?> m1bVar : this.a.o) {
                        if (m1bVar instanceof n1b) {
                            n1b n1bVar = (n1b) m1bVar;
                            if (n1bVar.f() == 2) {
                                n1bVar.l();
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
        public final /* synthetic */ a3b a;

        public h(a3b a3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a3b a3bVar = this.a;
                if (a3bVar.d.a == null) {
                    return;
                }
                if (a3bVar.v == null) {
                    a3b a3bVar2 = this.a;
                    a3bVar2.v = new zza(a3bVar2.a);
                }
                this.a.v.b(this.a.d.a.s(2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a3b a;

        public i(a3b a3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3bVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    a3b a3bVar = this.a;
                    a3bVar.a(a3bVar.a.getString(R.string.obfuscated_res_0x7f0f17ba));
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
        public final /* synthetic */ a3b a;

        public j(a3b a3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                BdUtilHelper.showSoftKeyPad(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    public a3b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull l1b l1bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, l1bVar, Boolean.valueOf(z)};
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
        this.s = new b0b();
        this.x = new b(this, 2016554);
        this.a = tbPageContext;
        this.b = navigationBar;
        this.c = linearLayout;
        this.d = editorTools;
        this.e = l1bVar;
        this.z = z;
        this.p = new WriteData();
        this.f = U();
        this.g = new l2b(this.d);
        this.p.setNewWritePage(true);
    }

    @Override // com.baidu.tieba.o1b
    public void C(cd5 cd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cd5Var) != null) || cd5Var == null) {
            return;
        }
        this.d.D(cd5Var);
    }

    @Override // com.baidu.tieba.dd5
    public void O(cd5 cd5Var) {
        m2b m2bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, cd5Var) == null) && (m2bVar = this.f) != null) {
            m2bVar.O(cd5Var);
        }
    }

    @Override // com.baidu.tieba.o1b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.e.a(str);
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

    @Override // com.baidu.tieba.o1b
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.p.setPrivacy(z);
        }
    }

    @Override // com.baidu.tieba.o1b
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

    @Override // com.baidu.tieba.o1b
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

    @Override // com.baidu.tieba.o1b
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.p.setShowCustomFigure(z);
        }
    }

    @Override // com.baidu.tieba.i1b
    @CallSuper
    public void q(@NonNull n1b n1bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048636, this, n1bVar, z) == null) {
            if (z) {
                o(true);
                this.d.t();
            }
            w();
        }
    }

    @Override // com.baidu.tieba.o1b
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.o1b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.t();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.registerListener(this.x);
            if (this.y) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            a0();
            i0();
        }
    }

    public final void P() {
        zza zzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (zzaVar = this.v) != null) {
            zzaVar.a();
        }
    }

    public void Q() {
        f0b f0bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (f0bVar = this.w) != null) {
            f0bVar.b();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.r.postDelayed(new a(this), 150L);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            o2b o2bVar = new o2b(this.a, this.d);
            this.u = o2bVar;
            o2bVar.g();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = new w2b(this.a, this.s);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e.L0(onBackPressed());
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new i(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.B = true;
        }
    }

    @Override // com.baidu.tieba.o1b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.e.e();
        }
    }

    @Override // com.baidu.tieba.o1b
    public void g() {
        od5 p;
        pd5 pd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (p = this.d.p(6)) != null && (pd5Var = p.m) != null) {
            pd5Var.O(new cd5(52, 0, null));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.d.post(new h(this));
        }
    }

    @Override // com.baidu.tieba.o1b
    public void i() {
        o2b o2bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (o2bVar = this.u) != null) {
            o2bVar.f();
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.w == null) {
                this.w = new f0b(this.a);
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

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            B();
            for (m1b<?> m1bVar : this.o) {
                m1bVar.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            for (m1b<?> m1bVar : this.o) {
                m1bVar.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.o1b
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            B();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            u2b.d(this.a, this.p);
        }
    }

    @Override // com.baidu.tieba.o1b
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.g.a();
        }
    }

    @CallSuper
    public void J(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bundle) != null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent = this.a.getPageActivity().getIntent();
        for (m1b<?> m1bVar : this.o) {
            if (m1bVar != null) {
                m1bVar.m(bundle, intent, this.p);
                LinearLayout linearLayout = this.c;
                linearLayout.addView(m1bVar.s(linearLayout));
                m1bVar.j(this);
            }
        }
        this.c.setDrawingCacheEnabled(false);
        this.c.setOnClickListener(new g(this));
        j();
    }

    @Override // com.baidu.tieba.sda.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, writeData) != null) || writeData == null) {
            return;
        }
        if (this.q) {
            if (writeData.isRichTextEditorMode() && 11 != this.p.getType()) {
                this.e.M0(11, true);
                return;
            } else if (!writeData.isRichTextEditorMode() && 9 != this.p.getType()) {
                this.e.M0(9, true);
                return;
            }
        }
        for (m1b<?> m1bVar : this.o) {
            m1bVar.c(writeData);
        }
        j();
    }

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.b.onChangeSkinType(this.a, i2);
            WebPManager.setPureDrawable(this.b.getBackImageView(), R.drawable.icon_pure_topbar_close40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.l.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            this.d.z(i2);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            for (m1b<?> m1bVar : this.o) {
                m1bVar.onChangeSkinType(i2);
            }
            j();
            w();
        }
    }

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onCreate(Bundle bundle) {
        w2b w2bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            T(bundle);
            N(this.b);
            M(this.d);
            K(this.o);
            J(bundle);
            V();
            S();
            L();
            if (this.z) {
                X();
            }
            if (this.p.isFromErrorDialog() && (w2bVar = this.t) != null) {
                w2bVar.h();
            }
            Y();
        }
    }

    @Override // com.baidu.tieba.o1b
    public void z(cd5 cd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, cd5Var) == null) {
            for (m1b<?> m1bVar : this.o) {
                m1bVar.r(cd5Var);
            }
            if (cd5Var.a == 77) {
                HashMap<String, Serializable> hashMap = new HashMap<>();
                hashMap.put("postTitle", this.p.getTitle());
                hashMap.put("postContent", this.p.getToServerContent());
                tt4 j2 = tt4.j(this.a.getPageActivity(), hd5.c(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, this.p.getForumId()));
                j2.f(hashMap);
                j2.p();
            }
        }
    }

    public void N(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, navigationBar) == null) {
            this.i = navigationBar.getCenterText();
            this.k = (ImageView) navigationBar.getCenterImgBox();
            this.j = navigationBar.getCenterImgBoxLayout();
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.h = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new c(this));
            String string = this.a.getString(R.string.send_post);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f13b2);
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
                pz4 pz4Var = new pz4(this.a);
                this.n = pz4Var;
                pz4Var.setContentView(this.m);
            }
            this.m.setText(this.a.getString(R.string.write_save_draft_dialog_normal_title), this.a.getString(R.string.obfuscated_res_0x7f0f1303));
            this.n.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03ce  */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T(Bundle bundle) {
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
            if (this.p.isFromErrorDialog() && (writeData = pga.f) != null) {
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

    public void W() {
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

    public final void Y() {
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
            k0b.c(i2, i3);
            k0b.f(this.p);
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
            o2b o2bVar = this.u;
            if (o2bVar != null) {
                o2bVar.e();
            }
        }
    }

    @Override // com.baidu.tieba.o1b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            hotSelectActivityConfig.setForumExtra(JavaTypesHelper.toLong(this.p.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            this.a.sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    @Override // com.baidu.tieba.o1b
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            for (m1b<?> m1bVar : this.o) {
                if (m1bVar.g()) {
                    return true;
                }
            }
            if (this.d.x()) {
                B();
                return true;
            } else if (e0()) {
                b();
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

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (!this.B) {
                b0();
            }
            for (m1b<?> m1bVar : this.o) {
                m1bVar.b();
            }
            w2b w2bVar = this.t;
            if (w2bVar != null) {
                w2bVar.g();
            }
            EditorTools editorTools = this.d;
            if (editorTools != null) {
                editorTools.s(15);
            }
            this.r.removeCallbacksAndMessages(null);
            TiebaPrepareImageService.StopService();
            Q();
            P();
            hb.b(this.n, this.a);
            aea.d();
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.B = true;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                this.e.finish();
                return;
            }
            for (m1b<?> m1bVar : this.o) {
                m1bVar.e(this.p);
            }
        }
    }

    @Override // com.baidu.tieba.o1b
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            B();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            TbPageContext<?> tbPageContext = this.a;
            WriteData writeData = this.p;
            u2b.b(tbPageContext, writeData, writeData.getWriteImagesInfo(), this.p.getFrom(), this.p.getDisableAudioMessage(), this.p.isVoiceEnable(), this.p.getPrefixData());
        }
    }

    @Override // com.baidu.tieba.o1b
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

    @Override // com.baidu.tieba.o1b
    @CallSuper
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (this.v != null && !z) {
                P();
            }
            if (z) {
                B();
            }
            for (m1b<?> m1bVar : this.o) {
                if (m1bVar instanceof n1b) {
                    ((n1b) m1bVar).d(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i1b
    public void l(@NonNull n1b n1bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, n1bVar) != null) || this.t == null) {
            return;
        }
        if (n1bVar.f() == 1) {
            this.t.j(n1bVar.p());
        } else if (n1bVar.f() == 2) {
            this.t.i(n1bVar.p());
        }
    }

    @Override // com.baidu.tieba.o1b
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
            pz4 pz4Var = new pz4(this.a);
            rz4 rz4Var = new rz4(this.a.getPageActivity());
            rz4Var.u(this.a.getString(R.string.obfuscated_res_0x7f0f0ec5));
            ArrayList arrayList = new ArrayList();
            nz4 nz4Var = new nz4(this.a.getString(R.string.obfuscated_res_0x7f0f0ec4), rz4Var);
            nz4Var.r(R.color.CAM_X0107);
            arrayList.add(nz4Var);
            d dVar = new d(this, nz4Var, pz4Var);
            e eVar = new e(this, pz4Var);
            rz4Var.m(arrayList);
            rz4Var.r(dVar);
            rz4Var.p(eVar);
            pz4Var.setCanceledOnTouchOutside(true);
            pz4Var.h(rz4Var);
            hb.j(pz4Var, this.a);
        }
    }

    @Override // com.baidu.tieba.o1b
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
                    u2b.a(this.a, this.p);
                } else if (i2 == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                }
            } else if (i3 == 0 && i2 == 12006 && intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                this.a.showToast(postWriteCallBackData.getErrorString());
                this.s.n(postWriteCallBackData.getErrorString());
                this.s.m(postWriteCallBackData.getSensitiveWords());
                for (m1b<?> m1bVar : this.o) {
                    if (m1bVar instanceof n1b) {
                        ((n1b) m1bVar).n();
                    }
                }
            }
            for (m1b<?> m1bVar2 : this.o) {
                m1bVar2.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tieba.o1b
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
        for (m1b<?> m1bVar : this.o) {
            m1bVar.onSaveInstanceState(bundle);
        }
    }
}
