package com.baidu.tieba.frs.headercomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.ke7;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes4.dex */
public class HeaderComponentMultiItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public GifView c;
    public TbImageView d;
    public ViewGroup e;
    public TbImageAutoSwitch f;
    public ke7 g;
    public List<String> h;
    public LiveFuseForumData i;
    public boolean j;
    public TbImageAutoSwitch.b k;

    /* loaded from: classes4.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeaderComponentMultiItemView a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.frs.headercomponent.HeaderComponentMultiItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0272a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0272a(a aVar, int i) {
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.a.g != null) {
                    this.b.a.g.b(2, this.b.a.i, this.a);
                }
            }
        }

        public a(HeaderComponentMultiItemView headerComponentMultiItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerComponentMultiItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headerComponentMultiItemView;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                HeadImageView headImageView = (HeadImageView) view2;
                headImageView.N((String) this.a.h.get(i), 12, false);
                headImageView.setOnClickListener(new View$OnClickListenerC0272a(this, i));
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(HeaderComponentMultiItemView.l, HeaderComponentMultiItemView.l));
                headImageView.setBorderWidth(HeaderComponentMultiItemView.n);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                if (this.a.j) {
                    headImageView.setIsRound(true);
                } else {
                    headImageView.setIsRound(false);
                    headImageView.setRadiusById(R.string.J_X05);
                    headImageView.setConrers(15);
                }
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
                return this.a.h.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFuseForumData a;
        public final /* synthetic */ HeaderComponentMultiItemView b;

        public b(HeaderComponentMultiItemView headerComponentMultiItemView, LiveFuseForumData liveFuseForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerComponentMultiItemView, liveFuseForumData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = headerComponentMultiItemView;
            this.a = liveFuseForumData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.g != null) {
                this.b.g.c(2, this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1489188123, "Lcom/baidu/tieba/frs/headercomponent/HeaderComponentMultiItemView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1489188123, "Lcom/baidu/tieba/frs/headercomponent/HeaderComponentMultiItemView;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.i == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.d.N(this.i.bjimg_light_small, 10, false);
        } else {
            this.d.N(this.i.bjimg_dark_small, 10, false);
        }
        this.c.m0(this.i.icon_url, 38);
        this.c.setAlpha(1.0f);
        g35 d = g35.d(this.e);
        d.o(R.string.J_X06);
        d.f(R.color.CAM_X0201);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g35.d(this.b).w(R.color.CAM_X0105);
            if (!ListUtils.isEmpty(this.f.getChildViews())) {
                for (View view2 : this.f.getChildViews()) {
                    if (view2 instanceof HeadImageView) {
                        ((HeadImageView) view2).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                    }
                }
            }
            i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderComponentMultiItemView(@NonNull Context context) {
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
        this.h = new ArrayList();
        this.j = true;
        this.k = new a(this);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderComponentMultiItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.h = new ArrayList();
        this.j = true;
        this.k = new a(this);
        h();
    }

    public void g(LiveFuseForumData liveFuseForumData, ke7 ke7Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, liveFuseForumData, ke7Var) != null) || liveFuseForumData == null) {
            return;
        }
        this.i = liveFuseForumData;
        this.g = ke7Var;
        Integer num = liveFuseForumData.head_img_style;
        if (num != null && num.intValue() != 0) {
            z = false;
        } else {
            z = true;
        }
        this.j = z;
        this.b.setText(liveFuseForumData.online_users);
        this.h.clear();
        if (!ListUtils.isEmpty(liveFuseForumData.head_img)) {
            this.h.addAll(liveFuseForumData.head_img);
            this.f.p();
        } else {
            this.f.setVisibility(8);
        }
        j();
        setOnClickListener(new b(this, liveFuseForumData));
        ke7 ke7Var2 = this.g;
        if (ke7Var2 != null) {
            ke7Var2.a(2, liveFuseForumData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderComponentMultiItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.h = new ArrayList();
        this.j = true;
        this.k = new a(this);
        h();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d033a, (ViewGroup) null);
            this.a = inflate;
            addView(inflate);
            this.d = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09074c);
            ViewGroup viewGroup = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f090756);
            this.e = viewGroup;
            viewGroup.getLayoutParams().width = (ii.l(getContext()) - (getResources().getDimensionPixelSize(R.dimen.M_W_X004) * 3)) / 2;
            TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09074c);
            this.d = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setDrawCorner(true);
            this.d.setRadiusById(R.string.J_X06);
            this.d.setPlaceHolder(2);
            this.d.setConrers(15);
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090755);
            GifView gifView = (GifView) this.a.findViewById(R.id.obfuscated_res_0x7f090751);
            this.c = gifView;
            gifView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setShowStaticDrawable(false);
            this.c.setDrawerType(1);
            TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) this.a.findViewById(R.id.obfuscated_res_0x7f090750);
            this.f = tbImageAutoSwitch;
            int i = l;
            tbImageAutoSwitch.l(4, i, i, m);
            this.f.setAnimationDuration(500);
            this.f.setCarouselDelayPeriod(2000);
            this.f.setCarouselPeriod(2000);
            this.f.setAdapter(this.k);
        }
    }
}
