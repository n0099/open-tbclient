package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final View b;
    public final x78 c;
    public final RecyclerView d;
    public final x78 e;
    public final RecyclerView f;
    public final View g;
    public final TextView h;
    public final l i;
    public j j;
    public k k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    @Nullable
    public v68 r;
    public final CustomMessageListener s;
    public Runnable t;

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;
        public final /* synthetic */ k b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ a68 d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d.j != null) {
                    this.a.d.j.a();
                }
            }
        }

        public g(a68 a68Var, j jVar, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var, jVar, kVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a68Var;
            this.a = jVar;
            this.b = kVar;
            this.c = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.d.j = this.a;
                this.d.k = this.b;
                this.d.a.setVisibility(0);
                this.d.g.setVisibility(0);
                this.d.F(this.c);
                this.d.h.setVisibility(0);
                this.d.h.setOnClickListener(new a(this));
                this.d.N();
                jg.a().postDelayed(this.d.t, 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a68 a68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var, Integer.valueOf(i)};
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
            this.a = a68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.N();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements z78 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        public b(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a68Var;
        }

        @Override // com.baidu.tieba.z78
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (this.a.l != i || !this.a.m) {
                    if (obj instanceof List) {
                        if (this.a.l != i && this.a.l >= 0) {
                            y78 a = this.a.e.a(this.a.l);
                            if (a instanceof f78) {
                                ((f78) a).m(false);
                                this.a.e.e(this.a.l);
                            }
                        }
                        this.a.l = i;
                        List list = (List) obj;
                        if (list.size() <= 1) {
                            if (list.size() <= 1 && this.a.m) {
                                this.a.A();
                                this.a.m = false;
                            }
                        } else {
                            this.a.E(list);
                            this.a.c.d(list);
                            if (!this.a.m) {
                                this.a.T();
                                this.a.m = true;
                            }
                        }
                        if (!this.a.w() && list.size() <= 1) {
                            return false;
                        }
                        return true;
                    }
                } else {
                    this.a.m = false;
                    if ((obj instanceof List) && ((List) obj).size() <= 1) {
                        return false;
                    }
                    this.a.e.e(this.a.l);
                    this.a.A();
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements z78 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        public c(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a68Var;
        }

        @Override // com.baidu.tieba.z78
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (!(obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO)) {
                    return true;
                }
                this.a.m = false;
                f78 f78Var = (f78) this.a.e.a(this.a.l);
                if (f78Var != null) {
                    f78Var.l((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                    f78Var.m(false);
                    this.a.e.e(this.a.l);
                }
                this.a.A();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        public d(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a68Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m78.c(this.a.d, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        public e(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a68Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.O(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.O(true);
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ a68 c;

        public f(a68 a68Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a68Var;
            this.a = z;
            this.b = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                View view2 = this.c.g;
                if (this.a) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
                this.c.F(this.b);
                this.c.N();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        public h(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a68Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null) {
                this.a.k.a(this.a.q);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnimatorListenerAdapter a;
        public final /* synthetic */ a68 b;

        public i(a68 a68Var, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a68Var;
            this.a = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.b.d.setVisibility(0);
                AnimatorListenerAdapter animatorListenerAdapter = this.a;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.b.d.setVisibility(0);
                AnimatorListenerAdapter animatorListenerAdapter = this.a;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }
    }

    public a68(@NonNull View view2, @Nullable l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = new a(this, 2001304);
        this.t = new h(this);
        this.b = view2;
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f090e1e);
        this.i = lVar;
        this.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0910a0);
        this.f = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09109e);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09109f);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f09109d);
        this.c = b78.a(view2.getContext(), this.d, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        this.e = b78.b(view2.getContext(), this.f, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        D();
        G();
        MessageManager.getInstance().registerListener(this.s);
    }

    public void B(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListenerAdapter) == null) {
            this.q = false;
            m78.a(this.a, new i(this, animatorListenerAdapter));
        }
    }

    public final void O(boolean z) {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (lVar = this.i) != null) {
            lVar.a(z);
        }
    }

    public void R(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kVar) == null) {
            this.k = kVar;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p = true;
            m78.a(this.d, new e(this));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.g(new b(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.g(new c(this));
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            O(false);
            jg.a().postDelayed(new d(this), 300L);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || !this.m) {
            return;
        }
        this.m = false;
        this.e.e(this.l);
        f78 f78Var = (f78) this.e.a(this.l);
        if (f78Var != null) {
            f78Var.m(false);
        }
        A();
    }

    public void C(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, v68 v68Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, list, v68Var, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            this.r = v68Var;
            if (ListUtils.isEmpty(list)) {
                A();
                return;
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = list.get(0).getOpts();
            E(opts);
            Q(list, z, (opts == null || opts.size() <= 1) ? false : false);
            this.e.c(list);
            this.c.c(opts);
        }
    }

    public final void Q(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        boolean z3 = false;
        if (z) {
            this.e.h(0);
            this.l = 0;
        } else {
            this.e.h(-1);
            this.l = -1;
        }
        this.n = z2;
        if (z && z2) {
            z3 = true;
        }
        this.m = z3;
    }

    public final void E(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO : list) {
            if (optsDTO.getDefaultX() == 1) {
                return;
            }
        }
        list.get(0).setDefaultX(1);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (this.n && z) {
                if (this.p) {
                    m78.d(this.d, null, 0L);
                } else {
                    this.d.setVisibility(0);
                }
                O(false);
                return;
            }
            this.d.setVisibility(8);
            O(true);
        }
    }

    public void J(List<AtSelectData> list) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && (this.e.a(this.l) instanceof f78) && (f78Var = (f78) this.e.a(this.l)) != null && f78Var.d() != null && f78Var.d().getItemType() == 2) {
            f78Var.n(list);
            this.e.e(this.l);
        }
    }

    public void K(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            if (ListUtils.isEmpty(list)) {
                A();
                return;
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = list.get(0).getOpts();
            Q(list, z, (opts == null || opts.size() <= 1) ? false : false);
            E(opts);
            this.e.d(list);
            this.c.d(opts);
        }
    }

    public void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) && (this.e.a(this.l) instanceof g78)) {
            g78 g78Var = (g78) this.e.a(this.l);
            g78Var.r(str, str2);
            g78Var.q(true);
            this.e.e(this.l);
        }
    }

    public void S(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.h.setVisibility(8);
            m78.c(this.a, new f(this, z2, z));
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            r25 d2 = r25.d(this.d);
            d2.o(R.string.J_X13);
            d2.f(R.color.CAM_X0207);
            r25.d(this.g).f(R.color.CAM_X0207);
            r25.d(this.f).f(R.color.CAM_X0207);
            if (this.h.getVisibility() == 0) {
                r25 d3 = r25.d(this.h);
                d3.w(R.color.CAM_X0101);
                d3.B(R.dimen.T_X08);
                d3.o(R.string.J_X01);
                d3.C(R.string.F_X01);
                d3.f(R.color.CAM_X0302);
            }
        }
    }

    @Nullable
    public List<String> x() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if ((this.e.a(this.l) instanceof f78) && (f78Var = (f78) this.e.a(this.l)) != null && f78Var.d() != null && f78Var.d().getItemType() == 2) {
                return t78.b(f78Var.c());
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void P(Context context, v68 v68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, v68Var) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(context, 12004, true);
            atListActivityConfig.setIsForGroupChat(true);
            atListActivityConfig.setCallAtListSource(AtListActivityConfig.GROUP_BOT_SKILL);
            if (!ListUtils.isEmpty(x()) && ListUtils.getCount(x()) > 0) {
                atListActivityConfig.setSelectedAtUid(TextUtils.join(",", x()));
            }
            if (v68Var.a() > 0) {
                atListActivityConfig.setFromFid(String.valueOf(v68Var.a()));
            }
            atListActivityConfig.setChatroomId(v68Var.c());
            atListActivityConfig.setUserRole(v68Var.d());
            atListActivityConfig.setForumName(v68Var.b());
            atListActivityConfig.setIsShowBotInfo(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
        }
    }

    public void U(j jVar, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048596, this, jVar, kVar, z) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            m78.c(this.a, new g(this, jVar, kVar, z));
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i2 = this.l;
            if (i2 >= 0) {
                y78 a2 = this.e.a(i2);
                if ((a2 instanceof f78) && ((f78) a2).i() == 2 && this.r != null) {
                    P(this.b.getContext(), this.r);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> y() {
        InterceptResult invokeV;
        f78 f78Var;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<y78> b2 = this.e.b();
            if (b2 != null && this.o) {
                ArrayList arrayList = new ArrayList();
                for (y78 y78Var : b2) {
                    if ((y78Var instanceof f78) && (d2 = (f78Var = (f78) y78Var).d()) != null) {
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = new BotsDTO.BotListDTO.SkillDTO.ItemsDTO();
                        itemsDTO.setName(d2.getName());
                        itemsDTO.setValue(d2.getValue());
                        itemsDTO.setItemType(d2.getItemType());
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO g2 = f78Var.g();
                        if (g2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(g2);
                            itemsDTO.setOpts(arrayList2);
                        }
                        arrayList.add(itemsDTO);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
