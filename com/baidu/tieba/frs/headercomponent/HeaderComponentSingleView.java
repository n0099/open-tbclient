package com.baidu.tieba.frs.headercomponent;

import android.content.Context;
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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.titletags.TitleTagsView;
import com.baidu.tieba.i08;
import com.baidu.tieba.j08;
import com.baidu.tieba.tr6;
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
import tbclient.TagLabelInfo;
/* loaded from: classes6.dex */
public class HeaderComponentSingleView extends FrameLayout implements j08 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
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
    public i08 j;
    public LiveFuseForumData k;
    public boolean l;
    public TbImageAutoSwitch.b m;

    @Override // com.baidu.tieba.j08
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeaderComponentSingleView a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.frs.headercomponent.HeaderComponentSingleView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0308a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0308a(a aVar, int i) {
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.a.j != null) {
                    this.b.a.j.b(1, this.b.a.k, this.a);
                }
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
                headImageView.startLoad((String) this.a.i.get(i), 12, false);
                headImageView.setOnClickListener(new View$OnClickListenerC0308a(this, i));
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(HeaderComponentSingleView.n, HeaderComponentSingleView.n));
                headImageView.setBorderWidth(HeaderComponentSingleView.p);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                if (this.a.l) {
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
                return this.a.i.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.c(1, this.a.k);
            }
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
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.k == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.e.startLoad(this.k.bjimg_light_big, 10, false);
        } else {
            this.e.startLoad(this.k.bjimg_dark_big, 10, false);
        }
        this.c.q(this.k.icon_url, 38);
        this.c.setAlpha(1.0f);
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
        this.l = true;
        this.m = new a(this);
        j();
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
        this.l = true;
        this.m = new a(this);
        j();
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
        this.l = true;
        this.m = new a(this);
        j();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt instanceof TitleTagsView) {
                    ((TitleTagsView) childAt).g();
                }
            }
        }
    }

    @Override // com.baidu.tieba.j08
    public void a(List<LiveFuseForumData> list, i08 i08Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, list, i08Var) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        LiveFuseForumData liveFuseForumData = list.get(0);
        this.k = liveFuseForumData;
        this.j = i08Var;
        Integer num = liveFuseForumData.head_img_style;
        if (num != null && num.intValue() != 0) {
            z = false;
        } else {
            z = true;
        }
        this.l = z;
        if (z) {
            this.g.setIsRound(true);
        } else {
            this.g.setIsRound(false);
            this.g.setRadiusById(R.string.J_X05);
            this.g.setConrers(15);
        }
        i();
        this.b.setText(this.k.online_users);
        this.i.clear();
        if (!ListUtils.isEmpty(this.k.head_img)) {
            this.i.addAll(this.k.head_img);
            if (this.i.size() == 1) {
                this.g.setVisibility(0);
                this.h.setVisibility(8);
                this.g.startLoad(this.i.get(0), 12, false);
            } else {
                this.h.setVisibility(0);
                this.g.setVisibility(8);
                this.h.q();
            }
        } else {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
        }
        f();
        setOnClickListener(new b(this));
        i08 i08Var2 = this.j;
        if (i08Var2 != null) {
            i08Var2.a(1, this.k);
        }
    }

    @Override // com.baidu.tieba.j08
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            EMManager.from(this.b).setTextColor(R.color.CAM_X0108);
            k();
            if (!ListUtils.isEmpty(this.h.getChildViews())) {
                for (View view2 : this.h.getChildViews()) {
                    if (view2 instanceof HeadImageView) {
                        ((HeadImageView) view2).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                    }
                }
            }
            this.g.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
            EMManager.from(this.f).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<String> list = this.k.title;
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TitleTagsView titleTagsView = new TitleTagsView(getContext());
                    String str = list.get(i);
                    List arrayList = new ArrayList();
                    TagLabelInfo tagLabelInfo = (TagLabelInfo) ListUtils.getItem(this.k.label_infos, i);
                    if (tagLabelInfo != null && !ListUtils.isEmpty(tagLabelInfo.labels)) {
                        arrayList = tagLabelInfo.labels;
                    }
                    titleTagsView.c(new tr6(str, arrayList, true));
                    this.d.addView(titleTagsView, new ViewGroup.LayoutParams(-2, -1));
                }
                if (size > 1) {
                    this.d.startFlipping();
                } else {
                    this.d.stopFlipping();
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d038b, this);
            this.a = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0907cf);
            this.e = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.e.setDrawCorner(true);
            this.e.setRadiusById(R.string.J_X06);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.f = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0907d9);
            this.d = (ViewFlipper) this.a.findViewById(R.id.obfuscated_res_0x7f0907d1);
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0907d0);
            GifView gifView = (GifView) this.a.findViewById(R.id.obfuscated_res_0x7f0907d4);
            this.c = gifView;
            gifView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setShowStaticDrawable(false);
            this.c.setDrawerType(1);
            HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0907d7);
            this.g = headImageView;
            headImageView.setPlaceHolder(1);
            this.g.setIsRound(true);
            this.g.setBorderWidth(getResources().getDimensionPixelSize(R.dimen.L_X02));
            this.g.setBorderColor(R.color.CAM_X0402);
            this.g.setDrawBorder(true);
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) this.a.findViewById(R.id.obfuscated_res_0x7f0907d3);
            this.h = tbImageAutoSwitch;
            int i = n;
            tbImageAutoSwitch.l(4, i, i, o);
            this.h.setAnimationDuration(500);
            this.h.setCarouselDelayPeriod(2000);
            this.h.setCarouselPeriod(2000);
            this.h.setAdapter(this.m);
        }
    }
}
