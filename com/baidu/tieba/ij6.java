package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.view.TbImageSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ij6 implements tx<mk6>, ux {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int[] q;
    public static final int[] r;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public View c;
    public TBLottieAnimationView d;
    public TextView e;
    public TextView f;
    public TbImageSwitch g;
    public TextView h;
    public TextView i;
    public TextView j;
    public int k;
    public List<String> l;
    public TbImageSwitch.b m;

    /* loaded from: classes6.dex */
    public class a implements TbImageSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij6 a;

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij6Var;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                ((HeadImageView) view2).J((String) this.a.l.get(i), 12, ij6.n, ij6.n, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.a.getPageActivity());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(ij6.n, ij6.n));
                headImageView.setBorderWidth(ij6.o);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.l.size();
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947855476, "Lcom/baidu/tieba/ij6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947855476, "Lcom/baidu/tieba/ij6;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        q = new int[]{-7433746, -10909978};
        r = new int[]{2005832174, 2002355942};
    }

    public ij6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 3;
        this.l = new ArrayList();
        this.m = new a(this);
        this.a = tbPageContext;
        g(f());
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.card_voice_room_layout, (ViewGroup) null, false);
            }
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.c = view2.findViewById(R.id.voice_room_talking_layout);
            this.d = (TBLottieAnimationView) view2.findViewById(R.id.voice_room_talking_lottie);
            this.e = (TextView) view2.findViewById(R.id.voice_room_talking_text);
            this.f = (TextView) view2.findViewById(R.id.card_voice_room_title);
            TbImageSwitch tbImageSwitch = (TbImageSwitch) view2.findViewById(R.id.card_voice_room_talking_user_portrait);
            this.g = tbImageSwitch;
            int i = n;
            tbImageSwitch.l(3, i, i, p);
            this.g.setAnimationDuration(1);
            this.g.setCarouselDelayPeriod(2);
            this.g.setCarouselPeriod(2);
            this.g.setAdapter(this.m);
            this.h = (TextView) view2.findViewById(R.id.card_voice_room_talking_num);
            this.i = (TextView) view2.findViewById(R.id.card_voice_room_online_num);
            this.j = (TextView) view2.findViewById(R.id.card_voice_room_join);
            onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tx
    /* renamed from: h */
    public void a(mk6 mk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, mk6Var) != null) || mk6Var == null) {
            return;
        }
        this.f.setText(mk6Var.c0());
        this.h.setText(String.format(this.a.getResources().getString(R.string.voice_room_talking_num), mk6Var.d0()));
        this.i.setText(String.format(this.a.getResources().getString(R.string.voice_room_online_num), mk6Var.Z()));
        if (!ListUtils.isEmpty(mk6Var.a0())) {
            if (mk6Var.a0().size() > 10) {
                this.l = mk6Var.a0().subList(0, 10);
            } else {
                this.l = mk6Var.a0();
            }
        }
        this.g.p();
        this.d.setRepeatCount(Integer.MAX_VALUE);
        this.d.setRepeatMode(1);
        this.d.playAnimation();
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.k != i) {
                if (i == 4) {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r);
                } else {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, q);
                }
                gradientDrawable.setCornerRadius(25.0f);
                f().setBackgroundDrawable(gradientDrawable);
                p45 d = p45.d(this.c);
                d.o(R.string.J_X01);
                d.f(R.color.CAM_X0605);
                SkinManager.setLottieAnimation(this.d, R.raw.lottie_voice_room_voicing_icon);
                p45.d(this.e).w(R.color.CAM_X0101);
                p45 d2 = p45.d(this.i);
                d2.w(R.color.CAM_X0620);
                d2.C(R.string.F_X02);
                p45 d3 = p45.d(this.f);
                d3.C(R.string.F_X02);
                d3.w(R.color.CAM_X0101);
                p45 d4 = p45.d(this.h);
                d4.w(R.color.CAM_X0620);
                d4.C(R.string.F_X02);
                p45 d5 = p45.d(this.j);
                d5.o(R.string.J_X07);
                d5.w(R.color.CAM_X0326);
                d5.f(R.color.CAM_X0621);
                if (!ListUtils.isEmpty(this.g.getChildViews())) {
                    for (View view2 : this.g.getChildViews()) {
                        if (view2 instanceof HeadImageView) {
                            ((HeadImageView) view2).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                        }
                    }
                }
            }
            this.k = i;
        }
    }
}
