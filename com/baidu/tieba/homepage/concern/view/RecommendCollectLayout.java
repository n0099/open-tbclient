package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.b35;
import com.baidu.tieba.ej;
import com.baidu.tieba.ey;
import com.baidu.tieba.fc7;
import com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter;
import com.baidu.tieba.on;
import com.baidu.tieba.td9;
import com.baidu.tieba.yg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class RecommendCollectLayout extends RelativeLayout implements ey {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer k;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public ContentCollectListAdapter b;
    public BdRecyclerView c;
    public ImageView d;
    public EMTextView e;
    public int f;
    public fc7 g;
    public int h;
    public BdUniqueId i;
    public final yg<on> j;

    /* loaded from: classes4.dex */
    public class a extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendCollectLayout a;

        public a(RecommendCollectLayout recommendCollectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendCollectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendCollectLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                if (onVar != null && onVar.j() != null) {
                    this.a.setBackground(onVar.j());
                } else {
                    this.a.d(true);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1980034149, "Lcom/baidu/tieba/homepage/concern/view/RecommendCollectLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1980034149, "Lcom/baidu/tieba/homepage/concern/view/RecommendCollectLayout;");
                return;
            }
        }
        k = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendCollectLayout(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 3;
        this.j = new a(this);
        this.a = tbPageContext;
        c();
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i > k.intValue()) {
                return R.drawable.bg_home_card_heji;
            }
            return R.drawable.bg_home_card_heji_two;
        }
        return invokeI.intValue;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
        }
    }

    public void setSourceForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07c0, (ViewGroup) this, true);
            int g = ej.g(getContext(), R.dimen.M_W_X004);
            setPadding(g, 0, g, 0);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f0906f0);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0906f6);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091da0);
            this.b = new ContentCollectListAdapter(this.a);
            this.c.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.c.setAdapter(this.b);
        }
    }

    public final void d(boolean z) {
        fc7 fc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || (fc7Var = this.g) == null) {
            return;
        }
        if (!z && fc7Var.f() != null && !TextUtils.isEmpty(td9.d(this.g.f()))) {
            on onVar = (on) zg.h().m(td9.d(this.g.f()), 45, this.j, this.i);
            if (onVar != null) {
                setBackground(onVar.j());
                return;
            }
            return;
        }
        setBackground(WebPManager.getMaskDrawable(b(ListUtils.getCount(this.g.getDataList())), WebPManager.ResourceStateType.NORMAL));
    }

    @Override // com.baidu.tieba.ey
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.h != i) {
            b35 d = b35.d(this.e);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X07);
            d.v(R.color.CAM_X0105);
            d(false);
            ContentCollectListAdapter contentCollectListAdapter = this.b;
            if (contentCollectListAdapter != null) {
                contentCollectListAdapter.notifyDataSetChanged();
            }
            this.h = i;
        }
    }

    public void setData(fc7 fc7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, fc7Var) != null) || fc7Var == null) {
            return;
        }
        this.g = fc7Var;
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (fc7Var.c() > 0) {
                marginLayoutParams.topMargin = ej.g(getContext(), R.dimen.M_H_X001);
            } else {
                marginLayoutParams.topMargin = 0;
            }
            setLayoutParams(marginLayoutParams);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b9, SkinManager.getColor(R.color.CAM_X0306), null);
        pureDrawable.setBounds(0, 0, ej.g(getContext(), R.dimen.tbds96), ej.g(getContext(), R.dimen.T_X07));
        this.e.setCompoundDrawables(pureDrawable, null, null, null);
        this.e.setCompoundDrawablePadding(ej.g(getContext(), R.dimen.M_W_X001));
        this.e.setText(fc7Var.getTitle());
        this.d.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08083a, true));
        this.b.i(fc7Var.getDataList());
        this.b.j(this.f);
        this.b.notifyDataSetChanged();
        d(false);
    }
}
