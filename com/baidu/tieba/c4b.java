package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.o1b;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.q1b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes5.dex */
public class c4b extends d4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final a4b C;
    @Nullable
    public f2b D;
    @Nullable
    public u1b E;
    @Nullable
    public e2b F;
    @Nullable
    public h2b G;
    @Nullable
    public i2b H;
    @Nullable
    public t1b I;
    @NonNull
    public w3b J;
    @NonNull
    public xha K;
    public final q3b L;
    public final q3b M;
    public final q3b N;
    public final q3b O;
    public final q3b P;
    public final q3b Q;
    public final q3b R;
    public final q3b S;

    /* renamed from: T  reason: collision with root package name */
    public final q3b f1096T;
    public final q3b U;

    @Override // com.baidu.tieba.d4b
    public void L(@NonNull List<p2b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements o1b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<c4b> a;

        /* loaded from: classes5.dex */
        public class a implements q1b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c4b a;

            public a(m mVar, c4b c4bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, c4bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c4bVar;
            }

            @Override // com.baidu.tieba.q1b.f
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a.u0(z);
                }
            }
        }

        public m(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(c4bVar);
        }

        @Override // com.baidu.tieba.o1b.b
        public void a(boolean z) {
            c4b c4bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (c4bVar = this.a.get()) == null) {
                return;
            }
            p1b.c(c4bVar.a.getPageActivity());
            if (p1b.f()) {
                return;
            }
            if (z) {
                new q1b(c4bVar.a.getPageActivity(), new a(this, c4bVar)).j();
            } else {
                c4bVar.u0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public a(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType() || 12 == this.a.p.getType() || 13 == this.a.p.getType()) {
                    return false;
                }
                f2b f2bVar = this.a.D;
                if (f2bVar != null && f2bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public b(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if (f2bVar != null && f2bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public c(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                c4b c4bVar = this.a;
                c4bVar.a.showToast(c4bVar.p.getDisableAudioMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public d(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            EditText editText;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                n1b.d(this.a.a.getPageActivity(), 1);
                n1b.e(this.a.p);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast((int) R.string.obfuscated_res_0x7f0f0e29);
                } else if (!jx5.a()) {
                    for (p2b<?> p2bVar : this.a.o) {
                        if (!p2bVar.o()) {
                            return;
                        }
                    }
                    f2b f2bVar = this.a.D;
                    EditText editText2 = null;
                    if (f2bVar != null) {
                        editText = f2bVar.p();
                    } else {
                        editText = null;
                    }
                    u1b u1bVar = this.a.E;
                    if (u1bVar != null) {
                        editText2 = u1bVar.p();
                    }
                    if (this.a.s.b(editText, editText2)) {
                        c4b c4bVar = this.a;
                        c4bVar.a.showToast(c4bVar.s.e());
                        return;
                    }
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public e(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if ((f2bVar != null && f2bVar.N()) || ListUtils.getCount(this.a.C.g().getChosedFiles()) >= this.a.C.g().getMaxImagesAllowed()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public f(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if (f2bVar != null && f2bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public g(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if (f2bVar != null && f2bVar.N()) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public h(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if ((f2bVar != null && f2bVar.N()) || 13 == this.a.p.getType() || 11 == this.a.p.getType()) {
                    return false;
                }
                h2b h2bVar = this.a.G;
                if ((h2bVar != null && h2bVar.x() != null && this.a.G.x().a != null) || ListUtils.getCount(this.a.C.g().getChosedFiles()) > 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public i(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if ((f2bVar != null && f2bVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                i2b i2bVar = this.a.H;
                if (i2bVar != null && i2bVar.t()) {
                    return false;
                }
                u1b u1bVar = this.a.E;
                if (u1bVar != null && u1bVar.W() != 0) {
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public j(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if ((f2bVar != null && f2bVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public k(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                f2b f2bVar = this.a.D;
                if ((f2bVar != null && f2bVar.N()) || 11 == this.a.p.getType()) {
                    return false;
                }
                return ListUtils.isEmpty(this.a.p.getItemDatas());
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements q3b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public l(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tieba.q3b
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (11 == this.a.p.getType()) {
                    return false;
                }
                f2b f2bVar = this.a.D;
                if (f2bVar != null && f2bVar.N()) {
                    return false;
                }
                return this.a.p.isVoiceEnable();
            }
            return invokeI.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull o2b o2bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, o2bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, o2bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (o2b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this);
        this.O = new h(this);
        this.P = new i(this);
        this.Q = new j(this);
        this.R = new k(this);
        this.S = new l(this);
        this.f1096T = new a(this);
        this.U = new b(this);
        this.C = new a4b(this.a);
        this.J = new w3b(this.a, this);
        this.K = xha.k();
    }

    public void q0(int i2, int i3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048597, this, i2, i3) != null) || (textView = this.i) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.rightMargin = i3;
        layoutParams.leftMargin = i2;
        this.i.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.d4b
    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.K(bundle);
            this.C.e(this, this.p);
            this.C.f(this, this.p);
        }
    }

    @Override // com.baidu.tieba.d4b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            p0();
            t0();
        }
    }

    @Override // com.baidu.tieba.d4b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.O(navigationBar);
            this.l.setOnClickListener(new d(this));
        }
    }

    public void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void onChangeSkinType(int i2) {
        EditText p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            e1b e1bVar = this.s;
            f2b f2bVar = this.D;
            EditText editText = null;
            if (f2bVar == null) {
                p = null;
            } else {
                p = f2bVar.p();
            }
            u1b u1bVar = this.E;
            if (u1bVar != null) {
                editText = u1bVar.p();
            }
            e1bVar.l(p, editText);
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            this.C.n(intent);
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null) {
                return;
            }
            bundle.putString(WriteActivityConfig.HOT_TOPIC_ID, this.p.getTopicId());
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.p.getStatisticFrom());
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iArr) == null) {
            super.x(iArr);
            if (iArr != null && iArr.length != 0) {
                this.g.b(iArr);
            }
        }
    }

    @Override // com.baidu.tieba.d4b
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof TbPageContextSupport) {
                this.K.m((TbPageContextSupport) tbPageContext);
            }
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            this.C.h(bundle, this.a.getPageActivity().getIntent(), this.p);
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.dfa.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeData) != null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
            return;
        }
        t1b t1bVar = this.I;
        if (t1bVar != null && t1bVar.t()) {
            return;
        }
        if (this.q && this.C.g().size() > 0) {
            return;
        }
        super.c(writeData);
    }

    @Override // com.baidu.tieba.d4b
    public p3b V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new n3b(this.a, this);
        }
        return (p3b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d4b
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                dfa.n(this.p.getForumId(), this);
            } else {
                dfa.u(this.p.getTopicId(), this);
            }
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void m() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            f2b f2bVar = this.D;
            if (f2bVar != null && f2bVar.N()) {
                str = "from_title";
            } else {
                str = "from_content";
            }
            this.J.f(str);
            this.J.g(true);
            super.m();
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (p2b<?> p2bVar : this.o) {
                if (p2bVar.t()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            this.K.o(this.a);
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            this.K.p(this.a);
        }
    }

    public final void t0() {
        hi5 o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (o = this.d.o(6)) != null && !TextUtils.isEmpty(this.p.getDisableAudioMessage())) {
            ((View) o).setOnClickListener(new c(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.K.e();
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.a();
            if (TextUtils.isEmpty(this.p.getTopicId())) {
                dfa.y(this.p.getForumId(), this.p, true);
            } else {
                dfa.F(this.p.getTopicId(), null);
            }
        }
    }

    @Override // com.baidu.tieba.d4b
    public boolean e0() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.p.isSaveDraft() && (textView = this.l) != null && (textView.isEnabled() || !ListUtils.isEmpty(this.p.getItemDatas()))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r2b
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.p.isShowCustomFigure()) {
            this.p.setShowCustomFigure(false);
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.K.z();
            lya.f(this.p);
            this.e.J();
            c0();
            if ("topic_detail".equals(this.p.getFrom())) {
                this.e.setResult(-1);
            } else {
                this.e.setResult(100);
            }
            this.e.x();
        }
    }

    @Override // com.baidu.tieba.d4b
    public void c0() {
        String forumId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            u1b u1bVar = this.E;
            if (u1bVar != null && u1bVar.x() != null) {
                this.p.onSaveDrafDataParse(this.E.x().a());
            }
            super.c0();
            if (13 != this.p.getType() && 14 != this.p.getType() && 12 != this.p.getType()) {
                if (TextUtils.isEmpty(this.p.getTopicId())) {
                    if (this.p.getForumId() == null) {
                        forumId = "0";
                    } else {
                        forumId = this.p.getForumId();
                    }
                    dfa.x(forumId, this.p);
                    return;
                }
                dfa.F(this.p.getTopicId(), this.p);
            }
        }
    }

    @Override // com.baidu.tieba.d4b, com.baidu.tieba.r2b
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (super.j()) {
                return true;
            }
            f2b f2bVar = this.D;
            if (f2bVar != null && f2bVar.t()) {
                d0(true);
                return true;
            }
            u1b u1bVar = this.E;
            if (u1bVar != null && u1bVar.t()) {
                d0(true);
                return true;
            }
            e2b e2bVar = this.F;
            if (e2bVar != null && e2bVar.t()) {
                d0(true);
                return true;
            } else if (this.C.g().getChosedFiles() != null && this.C.g().size() > 0) {
                d0(true);
                return true;
            } else {
                h2b h2bVar = this.G;
                if (h2bVar != null && h2bVar.t()) {
                    d0(true);
                    return true;
                }
                i2b i2bVar = this.H;
                if (i2bVar != null && i2bVar.t()) {
                    d0(true);
                    return true;
                }
                d0(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.g.c(10, this.L);
            this.g.c(5, this.M);
            this.g.c(9, this.N);
            this.g.c(34, this.O);
            this.g.c(35, this.P);
            this.g.c(33, this.Q);
            this.g.c(32, this.R);
            this.g.c(6, this.S);
            this.g.c(31, this.f1096T);
            this.g.c(2, this.U);
        }
    }

    public void r0(@DrawableRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048598, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = BdUtilHelper.getDimens(this.a.getPageActivity(), i3);
            layoutParams.height = BdUtilHelper.getDimens(this.a.getPageActivity(), i4);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), i5);
            this.k.setLayoutParams(layoutParams);
            this.k.setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.k.setVisibility(0);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            x0();
            boolean z = false;
            for (p2b<?> p2bVar : this.o) {
                p2bVar.a(this.p);
                if (((p2bVar instanceof h2b) || (p2bVar instanceof i2b) || (p2bVar instanceof w1b) || (p2bVar instanceof r1b) || (p2bVar instanceof t1b)) && p2bVar.t()) {
                    z = true;
                }
                if ((p2bVar instanceof u1b) && ((u1b) p2bVar).Y()) {
                    z = true;
                }
            }
            if (!this.p.isQuestionThread() && p1b.d() && !z && p1b.e()) {
                if (p1b.g()) {
                    p1b.h(this.a.getPageActivity());
                }
                o1b.c().g(this.p.getTitle(), this.p.getContent(), new m(this));
                if (p1b.f()) {
                    u0(false);
                    return;
                }
                return;
            }
            u0(false);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if ("1".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.p.getCallFrom())) {
                this.p.setCanNoForum(false);
            }
            this.d.D(new zh5(54, 15, null));
            this.d.D(new zh5(65, 15, null));
            if (this.p.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData writeData = this.p;
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            writeData.setShowCustomFigure(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            this.p.setBotConfig(BotEntranceManager.h().i());
            if (ck5.a()) {
                this.p.setShowBless(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_write_add_bless_enable"), true));
            }
            s0();
        }
    }

    public final void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            boolean z2 = true;
            p(true);
            B();
            this.p.setVcode(null);
            xha xhaVar = this.K;
            if (this.C.g().size() <= 0) {
                z2 = false;
            }
            xhaVar.v(z2);
            this.K.y(this.p);
            if (!this.K.f()) {
                this.a.showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0e29);
            } else if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 0 && this.p.isShowCustomFigure()) {
                this.e.P();
            } else {
                if (z) {
                    this.p.setQuestionThread(z);
                    this.p.setType(14);
                }
                u1b u1bVar = this.E;
                if (u1bVar != null && u1bVar.x() != null) {
                    this.p.onPostDataParse(this.E.x().a());
                }
                w0();
            }
        }
    }
}
