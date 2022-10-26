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
/* loaded from: classes3.dex */
public class b26 implements xx, yx {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int[] q;
    public static final int[] r;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
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
    public List l;
    public TbImageSwitch.b m;

    /* loaded from: classes3.dex */
    public class a implements TbImageSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b26 a;

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(b26 b26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b26Var;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                ((HeadImageView) view2).H((String) this.a.l.get(i), 12, b26.n, b26.n, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.a.getPageActivity());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(b26.n, b26.n));
                headImageView.setBorderWidth(b26.o);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947593123, "Lcom/baidu/tieba/b26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947593123, "Lcom/baidu/tieba/b26;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        q = new int[]{-7433746, -10909978};
        r = new int[]{2005832174, 2002355942};
    }

    public b26(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
                this.b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01c4, (ViewGroup) null, false);
            }
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f0925fd);
            this.d = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0925fe);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092601);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905a9);
            TbImageSwitch tbImageSwitch = (TbImageSwitch) view2.findViewById(R.id.obfuscated_res_0x7f0905a8);
            this.g = tbImageSwitch;
            int i = n;
            tbImageSwitch.l(3, i, i, p);
            this.g.setAnimationDuration(1);
            this.g.setCarouselDelayPeriod(2);
            this.g.setCarouselPeriod(2);
            this.g.setAdapter(this.m);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905a7);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905a6);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905a5);
            onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx
    /* renamed from: h */
    public void a(g36 g36Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, g36Var) != null) || g36Var == null) {
            return;
        }
        this.f.setText(g36Var.c0());
        this.h.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f15b6), g36Var.d0()));
        this.i.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f15b4), g36Var.Z()));
        if (!ListUtils.isEmpty(g36Var.a0())) {
            if (g36Var.a0().size() > 10) {
                this.l = g36Var.a0().subList(0, 10);
            } else {
                this.l = g36Var.a0();
            }
        }
        this.g.p();
        this.d.setRepeatCount(Integer.MAX_VALUE);
        this.d.setRepeatMode(1);
        this.d.playAnimation();
    }

    @Override // com.baidu.tieba.yx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.k != i) {
                if (i != 1 && i != 4) {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, q);
                } else {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r);
                }
                gradientDrawable.setCornerRadius(25.0f);
                f().setBackgroundDrawable(gradientDrawable);
                nv4 d = nv4.d(this.c);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0605);
                SkinManager.setLottieAnimation(this.d, R.raw.lottie_voice_room_voicing_icon);
                nv4.d(this.e).v(R.color.CAM_X0101);
                nv4 d2 = nv4.d(this.i);
                d2.v(R.color.CAM_X0620);
                d2.A(R.string.F_X02);
                nv4 d3 = nv4.d(this.f);
                d3.A(R.string.F_X02);
                d3.v(R.color.CAM_X0101);
                nv4 d4 = nv4.d(this.h);
                d4.v(R.color.CAM_X0620);
                d4.A(R.string.F_X02);
                nv4 d5 = nv4.d(this.j);
                d5.n(R.string.J_X07);
                d5.v(R.color.CAM_X0326);
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
