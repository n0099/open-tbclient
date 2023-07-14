package com.baidu.tieba;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.RelativeMemeDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class en8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final GroupChatFragment a;
    @NonNull
    public final d b;
    @NonNull
    public final FastRequest c;
    @NonNull
    public final l2c<CharSequence> d;
    @NonNull
    public final m2c<CharSequence, Boolean> e;
    public on8 f;
    public ml8 g;
    public mn8 h;
    @NonNull
    public final c<RelativeMemeDetail> i;

    /* loaded from: classes5.dex */
    public interface c<Result> {
        void a();

        void b(@NonNull Result result);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(AbilityItem abilityItem);

        void onFail();

        void onFinish();

        void onStart();
    }

    /* loaded from: classes5.dex */
    public class a implements c<RelativeMemeDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ en8 a;

        /* renamed from: com.baidu.tieba.en8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0284a implements pn8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.en8$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0285a implements e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbilityItem a;
                public final /* synthetic */ String b;
                public final /* synthetic */ C0284a c;

                public C0285a(C0284a c0284a, AbilityItem abilityItem, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0284a, abilityItem, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = c0284a;
                    this.a = abilityItem;
                    this.b = str;
                }

                @Override // com.baidu.tieba.en8.e
                public void a(AbilityItem abilityItem) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) {
                        if (this.c.a.a.h != null) {
                            List<lp8> f = this.c.a.a.h.f();
                            ArrayList arrayList = new ArrayList();
                            for (lp8 lp8Var : f) {
                                arrayList.add(new b(lp8Var));
                            }
                            arrayList.add(1, new b(abilityItem));
                            this.c.a.a.h.h(arrayList);
                        }
                        this.c.a.a.f.n(Boolean.TRUE);
                    }
                }

                @Override // com.baidu.tieba.en8.e
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.c.a.a.q(this.a, this.b);
                    this.c.a.a.f.n(Boolean.TRUE);
                }

                @Override // com.baidu.tieba.en8.e
                public void onFinish() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                        return;
                    }
                    this.c.a.a.q(this.a, this.b);
                    this.c.a.a.f.n(Boolean.TRUE);
                }

                @Override // com.baidu.tieba.en8.e
                public void onStart() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                        if (this.c.a.a.h != null) {
                            this.c.a.a.r(this.a);
                        }
                        this.c.a.a.f.n(Boolean.FALSE);
                    }
                }
            }

            public C0284a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.pn8
            public void a(AbilityItem abilityItem) {
                String str;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) && this.a.a.g != null) {
                    if (abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getDay() != null) {
                        str = abilityItem.getStyleConf().getDay().getIcon();
                    } else {
                        str = "";
                    }
                    this.a.a.g.d(abilityItem, null, new C0285a(this, abilityItem, str));
                    if (this.a.a.a.p2() != null && !"pic_gen_commit".equals(abilityItem.getType())) {
                        this.a.a.a.p2().y0();
                    }
                }
            }
        }

        public a(en8 en8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = en8Var;
        }

        @Override // com.baidu.tieba.en8.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.j();
                }
                this.a.l(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.en8.c
        /* renamed from: c */
        public void b(@NonNull RelativeMemeDetail relativeMemeDetail) {
            RelativeLayout relativeLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relativeMemeDetail) == null) {
                if (this.a.f == null) {
                    if (this.a.a.p2() != null && this.a.a.p2().K0() != null) {
                        relativeLayout = this.a.a.p2().K0().J();
                    } else {
                        relativeLayout = null;
                    }
                    if (relativeLayout != null) {
                        long i2 = this.a.a.i2();
                        long k2 = this.a.a.k2();
                        this.a.f = new on8(relativeLayout.findViewById(R.id.obfuscated_res_0x7f090434), new C0284a(this));
                        this.a.f.p(k2);
                        this.a.f.o(i2);
                        en8 en8Var = this.a;
                        en8Var.h = en8Var.f.i();
                    }
                }
                if (this.a.f != null) {
                    this.a.l(true);
                    this.a.f.q(relativeMemeDetail);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final l2c<CharSequence> a;
        public final m2c<CharSequence, Boolean> b;
        public final FastRequest c;
        public final c<RelativeMemeDetail> d;
        public final GroupChatFragment e;

        /* loaded from: classes5.dex */
        public class a extends FastRequest.b<RelativeMemeDetail> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CharSequence b;
            public final /* synthetic */ d c;

            public a(d dVar, CharSequence charSequence) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, charSequence};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
                this.b = charSequence;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: f */
            public void b(int i, @NonNull String str, @Nullable RelativeMemeDetail relativeMemeDetail) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, relativeMemeDetail) == null) {
                    super.b(i, str, relativeMemeDetail);
                    this.c.d.a();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: g */
            public void e(@NonNull RelativeMemeDetail relativeMemeDetail) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, relativeMemeDetail) == null) {
                    super.e(relativeMemeDetail);
                    if (((Boolean) this.c.b.call(this.b)).booleanValue() && relativeMemeDetail.getAbilityItems() != null && !relativeMemeDetail.getAbilityItems().isEmpty()) {
                        this.c.d.b(relativeMemeDetail);
                    } else {
                        this.c.d.a();
                    }
                }
            }
        }

        public d(l2c<CharSequence> l2cVar, m2c<CharSequence, Boolean> m2cVar, FastRequest fastRequest, @NonNull c<RelativeMemeDetail> cVar, GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l2cVar, m2cVar, fastRequest, cVar, groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l2cVar;
            this.c = fastRequest;
            this.d = cVar;
            this.b = m2cVar;
            this.e = groupChatFragment;
        }

        public void c(CharSequence charSequence, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                FastRequest fastRequest = this.c;
                fastRequest.W("chatroom_id", String.valueOf(j));
                fastRequest.W("forum_id", String.valueOf(j2));
                fastRequest.W("keyword", charSequence);
                fastRequest.Y(new a(this, charSequence));
                fastRequest.X();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                CharSequence call = this.a.call();
                if (this.b.call(call).booleanValue()) {
                    c(call, this.e.k2(), this.e.i2());
                } else {
                    this.d.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        public b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }
    }

    public en8(@NonNull GroupChatFragment groupChatFragment, @NonNull l2c<CharSequence> l2cVar, ml8 ml8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, l2cVar, ml8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new m2c() { // from class: com.baidu.tieba.dn8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.m2c
            public final Object call(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(en8.this.j((CharSequence) obj)) : invokeL.objValue;
            }
        };
        this.i = new a(this);
        this.a = groupChatFragment;
        this.d = l2cVar;
        this.g = ml8Var;
        FastRequest fastRequest = new FastRequest(groupChatFragment.getPageContext(), CmdConfigHttp.CMD_HTTP_RELATIVE_MEME_LIST, TbConfig.GET_RELATIVE_MEME_LIST);
        this.c = fastRequest;
        this.b = new d(l2cVar, this.e, fastRequest, this.i, this.a);
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.a.p2() != null && this.a.p2().K0() != null) {
            this.a.p2().K0().D(z);
        }
    }

    public void m(final long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            dh.g(new Runnable() { // from class: com.baidu.tieba.cn8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        en8.this.n(j);
                    }
                }
            });
        }
    }

    public /* synthetic */ void n(long j) {
        p();
        if (this.e.call(this.d.call()).booleanValue()) {
            zg.a().postDelayed(this.b, j);
        } else {
            this.i.a();
        }
    }

    public final boolean j(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
            GroupInputTool g2 = this.a.g2();
            if (g2 != null && g2.S() != null && !g2.Z() && this.a.p2() != null && this.a.p2().M0() != null && !this.a.p2().M0().k() && this.a.p2() != null && this.a.p2().T0() != null && !this.a.p2().T0().e() && this.a.p2() != null && this.a.p2().S0() != null && !this.a.p2().S0().e() && !g2.N() && g2.S().hasFocus() && !TextUtils.isEmpty(charSequence) && charSequence.length() <= 5) {
                try {
                    Pattern compile = Pattern.compile("[a-zA-Z一-龥]");
                    for (int i = 0; i < charSequence.length(); i++) {
                        if (!compile.matcher(String.valueOf(charSequence.charAt(i))).find()) {
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p();
            this.i.a();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            on8 on8Var = this.f;
            if (on8Var != null) {
                on8Var.l();
            }
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            zg.a().removeCallbacks(this.b);
            this.c.cancelLoadData();
        }
    }

    public final void q(AbilityItem abilityItem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, abilityItem, str) == null) {
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDay())).setIcon(str);
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDark())).setIcon(str);
            this.h.a(0, false, abilityItem);
        }
    }

    public final void r(AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, abilityItem) == null) && abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getAndroidExtra() != null) {
            String waitingIcon = abilityItem.getStyleConf().getAndroidExtra().getWaitingIcon();
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDay())).setIcon(waitingIcon);
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDark())).setIcon(waitingIcon);
            this.h.a(0, false, abilityItem);
        }
    }
}
