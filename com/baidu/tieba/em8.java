package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
/* loaded from: classes5.dex */
public class em8 {
    public static /* synthetic */ Interceptable $ic;
    public static String u;
    public static String v;
    public static String w;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    @Nullable
    public ql8 b;
    @NonNull
    public TbPageContext c;
    public GroupChatDialogFragment d;
    public km8 e;
    public fm8 f;
    public gm8 g;
    public tl8 h;
    public String i;
    public LinearLayoutManager j;
    public ChatRoomRecycleAdapter k;
    public ul8 l;
    public String m;
    public long n;
    public boolean o;
    public long p;
    public String q;
    public final View.OnClickListener r;
    public final View.OnClickListener s;
    public TbImageAutoSwitch.b t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947739257, "Lcom/baidu/tieba/em8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947739257, "Lcom/baidu/tieba/em8;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em8 a;

        public a(em8 em8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && em8.v != null) {
                UrlManager.getInstance().dealOneLink(this.a.c, new String[]{em8.v});
                em8 em8Var = this.a;
                dm8.b(em8Var.n, em8Var.q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em8 a;

        public b(em8 em8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && em8.u != null) {
                UrlManager.getInstance().dealOneLink(this.a.c, new String[]{em8.u});
                em8 em8Var = this.a;
                dm8.c(em8Var.n, em8Var.q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em8 a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public c(em8 em8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em8Var;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                ((HeadImageView) view2).startLoad(this.a.a.get(i), 10, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(im6.getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.a.e.j(), this.a.e.j()));
                headImageView.setBorderWidth(this.a.e.i());
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0101));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.a.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(em8 em8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements am8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em8 a;

        public e(em8 em8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em8Var;
        }

        @Override // com.baidu.tieba.am8
        public void a(long j, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && this.a.b != null) {
                this.a.b.w(j, i);
                this.a.b.u(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends SimpleTarget<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em8 a;

        public f(em8 em8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, drawable, transition) == null) {
                this.a.e.b().setBackground(drawable);
            }
        }
    }

    public em8(@NonNull GroupChatDialogFragment groupChatDialogFragment, @NonNull TbPageContext tbPageContext, @NonNull ql8 ql8Var, km8 km8Var, String str, long j, boolean z, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatDialogFragment, tbPageContext, ql8Var, km8Var, str, Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(j2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.d = groupChatDialogFragment;
        this.c = tbPageContext;
        this.b = ql8Var;
        this.e = km8Var;
        this.f = new fm8(groupChatDialogFragment, tbPageContext, ql8Var, km8Var, str2);
        this.m = str;
        this.n = j;
        this.o = z;
        this.p = j2;
        this.i = str2;
        u();
    }

    @NonNull
    public fm8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (fm8) invokeV.objValue;
    }

    @NonNull
    public gm8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (gm8) invokeV.objValue;
    }

    @NonNull
    public km8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (km8) invokeV.objValue;
    }

    public tl8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (tl8) invokeV.objValue;
    }

    public RecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.n();
        }
        return (RecyclerView) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.j();
            this.f.g();
            this.e.c().setVisibility(8);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e.l().setOnClickListener(this.r);
            this.e.k().setOnClickListener(this.s);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f.f();
            this.f.e();
            this.e.c().setVisibility(0);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.i.equals("frs")) {
                this.q = dm8.d;
            } else if (this.i.equals("message_tab")) {
                this.q = dm8.e;
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.i.equals("frs")) {
            Glide.with(this.e.b()).load(qu6.b("group_list_head_bcg_pic.webp", "group_list_head_bcg_pic")).into((RequestBuilder<Drawable>) new f(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e.e().setText(MeasureTextLength.fitTextLabel(this.m, "...吧", MeasureTextLength.spaceLength(this.e.o()), this.e.e().getPaint(), "吧"));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090eb0);
            layoutParams.leftMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
            layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            this.e.c().setLayoutParams(layoutParams);
        }
    }

    public void k(@NonNull fn8 fn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fn8Var) == null) {
            List<String> c2 = fn8Var.c();
            this.a = c2;
            if (c2 != null && c2.size() > 0) {
                if (this.a.size() == 1) {
                    this.e.h().setVisibility(0);
                    this.e.s().setVisibility(8);
                    this.e.h().startLoad(this.a.get(0), 10, false);
                    return;
                }
                this.e.s().setVisibility(0);
                this.e.h().setVisibility(8);
                this.e.s().q();
                return;
            }
            this.e.s().setVisibility(8);
            this.e.h().setVisibility(8);
            v();
        }
    }

    public void m(@NonNull fn8 fn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fn8Var) == null) {
            if (fn8Var.a() != null) {
                v = fn8Var.a();
            }
            if (fn8Var.g() != null) {
                u = fn8Var.g();
            }
            if (!StringUtils.isNull(fn8Var.f())) {
                String f2 = fn8Var.f();
                w = f2;
                if ("1".equals(f2)) {
                    this.e.l().setVisibility(0);
                    this.e.k().setVisibility(0);
                    return;
                }
                this.e.l().setVisibility(8);
                this.e.k().setVisibility(8);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.h().setPlaceHolder(1);
            this.e.h().setIsRound(true);
            this.e.h().setBorderWidth(this.e.i());
            this.e.h().setBorderColor(R.color.CAM_X0101);
            this.e.h().setDrawBorder(true);
            this.e.h().setScaleType(ImageView.ScaleType.FIT_XY);
            this.e.s().l(4, this.e.j(), this.e.j(), this.e.g());
            this.e.s().setAnimationDuration(500);
            this.e.s().setCarouselDelayPeriod(2000);
            this.e.s().setCarouselPeriod(2000);
            this.e.s().setAdapter(this.t);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j = new d(this, this.c.getContext());
            if (this.e.n() != null) {
                this.e.n().setLayoutManager(this.j);
                tl8 tl8Var = new tl8(this.c, this.n, this.o);
                this.h = tl8Var;
                tl8Var.p(new e(this));
                ul8 ul8Var = new ul8(null, this.i);
                this.l = ul8Var;
                this.k = new ChatRoomRecycleAdapter(ul8Var, this.h, this.c, this.i);
                this.e.n().setAdapter(this.k);
                if (this.i.equals("frs")) {
                    this.g = new gm8(this.j, this.e, this.p, this.h);
                    this.e.n().removeOnScrollListener(this.g.l);
                    this.e.n().addOnScrollListener(this.g.l);
                }
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (this.i.equals("message_tab") && !StringUtils.isNull(str)) {
                this.e.u().setVisibility(0);
                this.e.q().setText(R.string.obfuscated_res_0x7f0f0ccf);
                this.e.d(str, this.n);
            } else if (this.e.u() != null) {
                this.e.u().setVisibility(8);
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            int dimenPixelSize = i - UtilHelper.getDimenPixelSize(R.dimen.tbds318);
            this.e.p().getLayoutParams().height = dimenPixelSize;
            this.e.t(dimenPixelSize);
            if (this.i.equals("frs")) {
                this.e.a(dimenPixelSize);
            }
            this.e.m().getLayoutParams().height = dimenPixelSize;
            this.e.r().getLayoutParams().height = dimenPixelSize;
        }
    }
}
