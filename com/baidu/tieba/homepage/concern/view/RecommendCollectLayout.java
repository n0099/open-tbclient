package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tieba.R;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.hi;
import com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter;
import com.baidu.tieba.hx;
import com.baidu.tieba.ik9;
import com.baidu.tieba.ld7;
import com.baidu.tieba.n15;
import com.baidu.tieba.rm;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class RecommendCollectLayout extends RelativeLayout implements hx {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer k;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public ContentCollectListAdapter b;
    public BdRecyclerView c;
    public EMTextView d;
    public int e;
    public ld7 f;
    public int g;
    public BdUniqueId h;
    public Boolean i;
    public final bg<rm> j;

    /* loaded from: classes4.dex */
    public class a extends bg<rm> {
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
        @Override // com.baidu.tieba.bg
        public void onLoaded(rm rmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, rmVar, str, i) == null) {
                if (rmVar != null && rmVar.j() != null) {
                    this.a.setBackground(rmVar.j());
                } else {
                    this.a.c(true);
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
        this.g = 3;
        this.i = null;
        this.j = new a(this);
        this.a = tbPageContext;
        b();
    }

    public final void c(boolean z) {
        ld7 ld7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || (ld7Var = this.f) == null) {
            return;
        }
        if (!z && ld7Var.f() != null && !TextUtils.isEmpty(ik9.f(this.f.f()))) {
            rm rmVar = (rm) cg.h().m(ik9.f(this.f.f()), 45, this.j, this.h);
            if (rmVar != null) {
                setBackground(rmVar.j());
                return;
            }
            return;
        }
        setBackground(WebPManager.getMaskDrawable(getDefaultIdByNumber(), WebPManager.ResourceStateType.NORMAL));
    }

    private int getDefaultIdByNumber() {
        InterceptResult invokeV;
        ld7 ld7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ld7 ld7Var2 = this.f;
            if ((ld7Var2 != null && ld7Var2.g()) || (ld7Var = this.f) == null || ListUtils.getCount(ld7Var.getDataList()) <= k.intValue()) {
                return R.drawable.bg_home_card_heji_two;
            }
            return R.drawable.bg_home_card_heji;
        }
        return invokeV.intValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07d1, (ViewGroup) this, true);
            int g = hi.g(getContext(), R.dimen.M_W_X004);
            setPadding(g, 0, g, 0);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f09070f);
            this.d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090715);
            this.b = new ContentCollectListAdapter(this.a);
            this.c.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.c.setAdapter(this.b);
        }
    }

    @Override // com.baidu.tieba.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.g != i) {
            n15 d = n15.d(this.d);
            d.B(R.string.F_X02);
            d.A(R.dimen.T_X07);
            d.w(R.color.CAM_X0105);
            int i5 = 0;
            c(false);
            ContentCollectListAdapter contentCollectListAdapter = this.b;
            if (contentCollectListAdapter != null) {
                contentCollectListAdapter.notifyDataSetChanged();
            }
            if (this.i != null) {
                ShadowDrawable makeShadowDrawable = TBSelector.makeShadowDrawable();
                if (this.i.booleanValue()) {
                    i2 = R.color.CAM_X0205;
                } else {
                    i2 = R.color.transparent;
                }
                ShadowDrawable shadowColor = makeShadowDrawable.setBgColor(i2).setShadowColor(R.color.CAM_X0802);
                if (this.i.booleanValue()) {
                    i3 = hi.g(getContext(), R.dimen.tbds31);
                } else {
                    i3 = 0;
                }
                ShadowDrawable shadowSide = shadowColor.setShapeRadius(i3).setShadowSide(ShadowDrawable.ALL);
                if (this.i.booleanValue()) {
                    i4 = hi.g(getContext(), R.dimen.tbds10);
                } else {
                    i4 = 0;
                }
                ShadowDrawable offsetX = shadowSide.setShadowRadius(i4).setOffsetX(0);
                if (this.i.booleanValue()) {
                    i5 = hi.g(getContext(), R.dimen.tbds5);
                }
                offsetX.setOffsetY(i5).into(this.c);
            }
            this.g = i;
        }
    }

    public void setData(ld7 ld7Var) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ld7Var) != null) || ld7Var == null) {
            return;
        }
        this.f = ld7Var;
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (ld7Var.c() > 0) {
                marginLayoutParams.topMargin = hi.g(getContext(), R.dimen.M_H_X001);
            } else {
                marginLayoutParams.topMargin = 0;
            }
            setLayoutParams(marginLayoutParams);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809cb, SkinManager.getColor(R.color.CAM_X0306), null);
        pureDrawable.setBounds(0, 0, hi.g(getContext(), R.dimen.tbds96), hi.g(getContext(), R.dimen.T_X07));
        this.d.setCompoundDrawables(pureDrawable, null, null, null);
        this.d.setCompoundDrawablePadding(hi.g(getContext(), R.dimen.M_W_X001));
        this.d.setText(ld7Var.getTitle());
        this.b.j(ld7Var.getDataList());
        this.b.k(this.e);
        Boolean bool = this.i;
        if (bool == null || bool.booleanValue() != ld7Var.g()) {
            boolean g = ld7Var.g();
            if (g) {
                this.b.i(ContentCollectListAdapter.CornerType.FULL);
            } else {
                this.b.i(ContentCollectListAdapter.CornerType.ITEM);
            }
            ShadowDrawable makeShadowDrawable = TBSelector.makeShadowDrawable();
            if (g) {
                i = R.color.CAM_X0205;
            } else {
                i = R.color.transparent;
            }
            ShadowDrawable shadowColor = makeShadowDrawable.setBgColor(i).setShadowColor(R.color.CAM_X0802);
            if (g) {
                i2 = hi.g(getContext(), R.dimen.tbds31);
            } else {
                i2 = 0;
            }
            ShadowDrawable shadowSide = shadowColor.setShapeRadius(i2).setShadowSide(ShadowDrawable.ALL);
            if (g) {
                i3 = hi.g(getContext(), R.dimen.tbds10);
            } else {
                i3 = 0;
            }
            ShadowDrawable offsetX = shadowSide.setShadowRadius(i3).setOffsetX(0);
            if (g) {
                i4 = hi.g(getContext(), R.dimen.tbds5);
            } else {
                i4 = 0;
            }
            offsetX.setOffsetY(i4).into(this.c);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.i = Boolean.valueOf(g);
        }
        this.b.notifyDataSetChanged();
        c(false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.h = bdUniqueId;
        }
    }

    public void setSourceForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
        }
    }
}
