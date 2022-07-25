package com.baidu.tieba.frs.headercomponent;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vr4;
import com.repackage.xk6;
import com.repackage.yk6;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes3.dex */
public class HeaderComponentSingleView extends FrameLayout implements yk6 {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public static final int n;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public GifView c;
    public ViewFlipper d;
    public TbImageView e;
    public ViewGroup f;
    public HeadImageView g;
    public TbImageAutoSwitch h;
    public List<String> i;
    public xk6 j;
    public LiveFuseForumData k;
    public TbImageAutoSwitch.b l;

    /* loaded from: classes3.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeaderComponentSingleView a;

        /* renamed from: com.baidu.tieba.frs.headercomponent.HeaderComponentSingleView$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0210a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0210a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.a.j == null) {
                    return;
                }
                this.b.a.j.b(1, this.b.a.k, this.a);
            }
        }

        public a(HeaderComponentSingleView headerComponentSingleView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerComponentSingleView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headerComponentSingleView;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                HeadImageView headImageView = (HeadImageView) view2;
                headImageView.J((String) this.a.i.get(i), 12, false);
                headImageView.setOnClickListener(new View$OnClickListenerC0210a(this, i));
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(HeaderComponentSingleView.m, HeaderComponentSingleView.m));
                headImageView.setBorderWidth(HeaderComponentSingleView.o);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.i.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeaderComponentSingleView a;

        public b(HeaderComponentSingleView headerComponentSingleView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerComponentSingleView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headerComponentSingleView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.j == null) {
                return;
            }
            this.a.j.c(1, this.a.k);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-444627085, "Lcom/baidu/tieba/frs/headercomponent/HeaderComponentSingleView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-444627085, "Lcom/baidu/tieba/frs/headercomponent/HeaderComponentSingleView;");
                return;
            }
        }
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderComponentSingleView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new a(this);
        h();
    }

    @Override // com.repackage.yk6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int childCount = this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                vr4 d = vr4.d((TextView) this.d.getChildAt(i));
                d.v(R.color.CAM_X0105);
                d.A(R.string.F_X02);
            }
            vr4.d(this.b).v(R.color.CAM_X0108);
            i();
            if (!ListUtils.isEmpty(this.h.getChildViews())) {
                for (View view2 : this.h.getChildViews()) {
                    if (view2 instanceof HeadImageView) {
                        ((HeadImageView) view2).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                    }
                }
            }
            this.g.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
            vr4 d2 = vr4.d(this.f);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
        }
    }

    @Override // com.repackage.yk6
    public void b(List<LiveFuseForumData> list, xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, xk6Var) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        LiveFuseForumData liveFuseForumData = list.get(0);
        this.k = liveFuseForumData;
        this.j = xk6Var;
        List<String> list2 = liveFuseForumData.title;
        if (!ListUtils.isEmpty(list2)) {
            int size = list2.size();
            for (int i = 0; i < list2.size(); i++) {
                TextView textView = new TextView(getContext());
                textView.setIncludeFontPadding(false);
                textView.setLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(list2.get(i));
                vr4 d = vr4.d(textView);
                d.v(R.color.CAM_X0105);
                d.A(R.string.F_X02);
                d.z(R.dimen.T_X06);
                this.d.addView(textView);
            }
            if (size > 1) {
                this.d.startFlipping();
            } else {
                this.d.stopFlipping();
            }
        }
        this.b.setText(this.k.online_users);
        this.i.clear();
        if (!ListUtils.isEmpty(this.k.head_img)) {
            this.i.addAll(this.k.head_img);
            if (this.i.size() == 1) {
                this.g.setVisibility(0);
                this.h.setVisibility(8);
                this.g.J(this.i.get(0), 12, false);
            } else {
                this.h.setVisibility(0);
                this.g.setVisibility(8);
                this.h.p();
            }
        } else {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
        }
        a();
        setOnClickListener(new b(this));
        xk6 xk6Var2 = this.j;
        if (xk6Var2 != null) {
            xk6Var2.a(1, this.k);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0311, this);
            this.a = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090673);
            this.e = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.e.setDrawCorner(true);
            this.e.setRadiusById(R.string.J_X06);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.f = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09067d);
            this.d = (ViewFlipper) this.a.findViewById(R.id.obfuscated_res_0x7f090675);
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090674);
            GifView gifView = (GifView) this.a.findViewById(R.id.obfuscated_res_0x7f090678);
            this.c = gifView;
            gifView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setShowStaticDrawable(false);
            this.c.setDrawerType(1);
            HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09067b);
            this.g = headImageView;
            headImageView.setPlaceHolder(1);
            this.g.setIsRound(true);
            this.g.setBorderWidth(getResources().getDimensionPixelSize(R.dimen.L_X02));
            this.g.setBorderColor(R.color.CAM_X0402);
            this.g.setDrawBorder(true);
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) this.a.findViewById(R.id.obfuscated_res_0x7f090677);
            this.h = tbImageAutoSwitch;
            int i = m;
            tbImageAutoSwitch.l(4, i, i, n);
            this.h.setAnimationDuration(500);
            this.h.setCarouselDelayPeriod(2000);
            this.h.setCarouselPeriod(2000);
            this.h.setAdapter(this.l);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 0) {
            this.e.J(this.k.bjimg_light_big, 10, false);
        } else {
            this.e.J(this.k.bjimg_dark_big, 10, false);
        }
        this.c.j0(this.k.icon_url, 38);
        if (skinType == 1) {
            this.c.setAlpha(0.7f);
        } else {
            this.c.setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderComponentSingleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new a(this);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderComponentSingleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new a(this);
        h();
    }
}
