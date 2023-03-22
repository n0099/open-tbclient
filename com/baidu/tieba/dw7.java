package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class dw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final GroupChatFragment a;
    @NonNull
    public final c b;
    @NonNull
    public final FastRequest c;
    @NonNull
    public final fsa<CharSequence> d;
    @NonNull
    public final gsa<CharSequence, Boolean> e;
    public lw7 f;
    public fv7 g;
    @NonNull
    public final b<RelativeMemeDetail> h;

    /* loaded from: classes4.dex */
    public interface b<Result> {
        void a();

        void b(@NonNull Result result);
    }

    /* loaded from: classes4.dex */
    public class a implements b<RelativeMemeDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw7 a;

        /* renamed from: com.baidu.tieba.dw7$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0243a implements mw7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0243a(a aVar) {
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

            @Override // com.baidu.tieba.mw7
            public void a(AbilityItem abilityItem) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) && this.a.a.g != null) {
                    this.a.a.g.c(abilityItem, null);
                    if (this.a.a.a.k2() != null) {
                        this.a.a.a.k2().i0();
                    }
                }
            }
        }

        public a(dw7 dw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw7Var;
        }

        @Override // com.baidu.tieba.dw7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.f();
                }
                this.a.h(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dw7.b
        /* renamed from: c */
        public void b(@NonNull RelativeMemeDetail relativeMemeDetail) {
            RelativeLayout relativeLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relativeMemeDetail) == null) {
                if (this.a.f == null) {
                    if (this.a.a.k2() != null && this.a.a.k2().m0() != null) {
                        relativeLayout = this.a.a.k2().m0().D();
                    } else {
                        relativeLayout = null;
                    }
                    if (relativeLayout != null) {
                        this.a.f = new lw7(relativeLayout.findViewById(R.id.obfuscated_res_0x7f090428), new C0243a(this));
                    }
                }
                if (this.a.f != null) {
                    this.a.h(true);
                    this.a.f.j(relativeMemeDetail);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final fsa<CharSequence> a;
        public final gsa<CharSequence, Boolean> b;
        public final FastRequest c;
        public final b<RelativeMemeDetail> d;
        public final GroupChatFragment e;

        /* loaded from: classes4.dex */
        public class a extends FastRequest.b<RelativeMemeDetail> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CharSequence b;
            public final /* synthetic */ c c;

            public a(c cVar, CharSequence charSequence) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, charSequence};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
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

        public c(fsa<CharSequence> fsaVar, gsa<CharSequence, Boolean> gsaVar, FastRequest fastRequest, @NonNull b<RelativeMemeDetail> bVar, GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fsaVar, gsaVar, fastRequest, bVar, groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fsaVar;
            this.c = fastRequest;
            this.d = bVar;
            this.b = gsaVar;
            this.e = groupChatFragment;
        }

        public void c(CharSequence charSequence, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                FastRequest fastRequest = this.c;
                fastRequest.S("chatroom_id", String.valueOf(j));
                fastRequest.S("forum_id", String.valueOf(j2));
                fastRequest.S("keyword", charSequence);
                fastRequest.U(new a(this, charSequence));
                fastRequest.T();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Log.e("lt-log", "start：" + ((Object) this.a.call()));
                CharSequence call = this.a.call();
                if (this.b.call(call).booleanValue()) {
                    c(call, this.e.h2(), this.e.f2());
                } else {
                    this.d.a();
                }
            }
        }
    }

    public dw7(@NonNull GroupChatFragment groupChatFragment, @NonNull fsa<CharSequence> fsaVar, fv7 fv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, fsaVar, fv7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new gsa() { // from class: com.baidu.tieba.cw7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gsa
            public final Object call(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(dw7.this.f((CharSequence) obj)) : invokeL.objValue;
            }
        };
        this.h = new a(this);
        this.a = groupChatFragment;
        this.d = fsaVar;
        this.g = fv7Var;
        FastRequest fastRequest = new FastRequest(groupChatFragment.getPageContext(), CmdConfigHttp.CMD_HTTP_RELATIVE_MEME_LIST, TbConfig.GET_RELATIVE_MEME_LIST);
        this.c = fastRequest;
        this.b = new c(fsaVar, this.e, fastRequest, this.h, this.a);
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.a.k2() != null && this.a.k2().m0() != null) {
            this.a.k2().m0().u(z);
        }
    }

    public void i(final long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            ng.e(new Runnable() { // from class: com.baidu.tieba.bw7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        dw7.this.j(j);
                    }
                }
            });
        }
    }

    public /* synthetic */ void j(long j) {
        l();
        if (this.e.call(this.d.call()).booleanValue()) {
            jg.a().postDelayed(this.b, j);
        } else {
            this.h.a();
        }
    }

    public final boolean f(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
            GroupInputTool e2 = this.a.e2();
            if (e2 != null && e2.O() != null && !e2.U() && this.a.k2() != null && this.a.k2().o0() != null && !this.a.k2().o0().h() && this.a.k2() != null && this.a.k2().p0() != null && !this.a.k2().p0().e() && !e2.G() && e2.O().hasFocus() && !TextUtils.isEmpty(charSequence) && charSequence.length() <= 5) {
                try {
                    Pattern compile = Pattern.compile("[a-zA-Z一-龥]");
                    for (int i = 0; i < charSequence.length(); i++) {
                        if (!compile.matcher(String.valueOf(charSequence.charAt(i))).find()) {
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            this.h.a();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            lw7 lw7Var = this.f;
            if (lw7Var != null) {
                lw7Var.h();
            }
            l();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            jg.a().removeCallbacks(this.b);
            this.c.cancelLoadData();
        }
    }
}
