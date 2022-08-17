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
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ms4;
import com.repackage.qi;
import com.repackage.qm6;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes3.dex */
public class HeaderComponentMultiItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public GifView c;
    public TbImageView d;
    public ViewGroup e;
    public TbImageAutoSwitch f;
    public qm6 g;
    public List<String> h;
    public LiveFuseForumData i;
    public TbImageAutoSwitch.b j;

    /* loaded from: classes3.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeaderComponentMultiItemView a;

        /* renamed from: com.baidu.tieba.frs.headercomponent.HeaderComponentMultiItemView$a$a  reason: collision with other inner class name */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.a.g == null) {
                    return;
                }
                this.b.a.g.b(2, this.b.a.i, this.a);
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
                headImageView.K((String) this.a.h.get(i), 12, false);
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
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(HeaderComponentMultiItemView.k, HeaderComponentMultiItemView.k));
                headImageView.setBorderWidth(HeaderComponentMultiItemView.m);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.h.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.g == null) {
                return;
            }
            this.b.g.c(2, this.a);
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
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
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
        this.j = new a(this);
        g();
    }

    public void f(LiveFuseForumData liveFuseForumData, qm6 qm6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, liveFuseForumData, qm6Var) == null) || liveFuseForumData == null) {
            return;
        }
        this.i = liveFuseForumData;
        this.g = qm6Var;
        this.b.setText(liveFuseForumData.online_users);
        this.h.clear();
        if (!ListUtils.isEmpty(liveFuseForumData.head_img)) {
            this.h.addAll(liveFuseForumData.head_img);
            this.f.p();
        } else {
            this.f.setVisibility(8);
        }
        i();
        setOnClickListener(new b(this, liveFuseForumData));
        qm6 qm6Var2 = this.g;
        if (qm6Var2 != null) {
            qm6Var2.a(2, liveFuseForumData);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0311, (ViewGroup) null);
            this.a = inflate;
            addView(inflate);
            this.d = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090690);
            ViewGroup viewGroup = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09069a);
            this.e = viewGroup;
            viewGroup.getLayoutParams().width = (qi.k(getContext()) - (getResources().getDimensionPixelSize(R.dimen.M_W_X004) * 3)) / 2;
            TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090690);
            this.d = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setDrawCorner(true);
            this.d.setRadiusById(R.string.J_X06);
            this.d.setPlaceHolder(2);
            this.d.setConrers(15);
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090699);
            GifView gifView = (GifView) this.a.findViewById(R.id.obfuscated_res_0x7f090695);
            this.c = gifView;
            gifView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setShowStaticDrawable(false);
            this.c.setDrawerType(1);
            TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) this.a.findViewById(R.id.obfuscated_res_0x7f090694);
            this.f = tbImageAutoSwitch;
            int i = k;
            tbImageAutoSwitch.l(4, i, i, l);
            this.f.setAnimationDuration(500);
            this.f.setCarouselDelayPeriod(2000);
            this.f.setCarouselPeriod(2000);
            this.f.setAdapter(this.j);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.i == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 0) {
            this.d.K(this.i.bjimg_light_small, 10, false);
        } else {
            this.d.K(this.i.bjimg_dark_small, 10, false);
        }
        this.c.j0(this.i.icon_url, 38);
        if (skinType == 1) {
            this.c.setAlpha(0.7f);
        } else {
            this.c.setAlpha(1.0f);
        }
        ms4 d = ms4.d(this.e);
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0201);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ms4.d(this.b).v(R.color.CAM_X0105);
            if (!ListUtils.isEmpty(this.f.getChildViews())) {
                for (View view2 : this.f.getChildViews()) {
                    if (view2 instanceof HeadImageView) {
                        ((HeadImageView) view2).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                    }
                }
            }
            h();
        }
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
        this.j = new a(this);
        g();
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
        this.j = new a(this);
        g();
    }
}
