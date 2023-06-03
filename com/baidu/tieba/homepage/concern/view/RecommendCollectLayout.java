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
import com.baidu.tieba.cw7;
import com.baidu.tieba.gn;
import com.baidu.tieba.homepage.concern.adapter.ContentCollectListAdapter;
import com.baidu.tieba.m75;
import com.baidu.tieba.og;
import com.baidu.tieba.pg;
import com.baidu.tieba.py;
import com.baidu.tieba.r6a;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class RecommendCollectLayout extends RelativeLayout implements py {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer k;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public ContentCollectListAdapter b;
    public BdRecyclerView c;
    public EMTextView d;
    public int e;
    public cw7 f;
    public int g;
    public BdUniqueId h;
    public Boolean i;
    public final og<gn> j;

    /* loaded from: classes6.dex */
    public class a extends og<gn> {
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
        @Override // com.baidu.tieba.og
        public void onLoaded(gn gnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, gnVar, str, i) == null) {
                if (gnVar != null && gnVar.j() != null) {
                    this.a.setBackground(gnVar.j());
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
        cw7 cw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || (cw7Var = this.f) == null) {
            return;
        }
        if (!z && cw7Var.d() != null && !TextUtils.isEmpty(r6a.g(this.f.d()))) {
            gn gnVar = (gn) pg.h().m(r6a.g(this.f.d()), 45, this.j, this.h);
            if (gnVar != null) {
                setBackground(gnVar.j());
                return;
            }
            return;
        }
        setBackground(WebPManager.getMaskDrawable(getDefaultIdByNumber(), WebPManager.ResourceStateType.NORMAL));
    }

    private int getDefaultIdByNumber() {
        InterceptResult invokeV;
        cw7 cw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            cw7 cw7Var2 = this.f;
            if ((cw7Var2 != null && cw7Var2.e()) || (cw7Var = this.f) == null || ListUtils.getCount(cw7Var.getDataList()) <= k.intValue()) {
                return R.drawable.bg_home_card_heji_two;
            }
            return R.drawable.bg_home_card_heji;
        }
        return invokeV.intValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0818, (ViewGroup) this, true);
            int g = vi.g(getContext(), R.dimen.M_W_X004);
            setPadding(g, 0, g, 0);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f090739);
            this.d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f09073f);
            this.b = new ContentCollectListAdapter(this.a);
            this.c.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.c.setAdapter(this.b);
        }
    }

    @Override // com.baidu.tieba.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.g != i) {
            m75 d = m75.d(this.d);
            d.C(R.string.F_X02);
            d.B(R.dimen.T_X07);
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
                    i3 = vi.g(getContext(), R.dimen.tbds31);
                } else {
                    i3 = 0;
                }
                ShadowDrawable shadowSide = shadowColor.setShapeRadius(i3).setShadowSide(ShadowDrawable.ALL);
                if (this.i.booleanValue()) {
                    i4 = vi.g(getContext(), R.dimen.tbds10);
                } else {
                    i4 = 0;
                }
                ShadowDrawable offsetX = shadowSide.setShadowRadius(i4).setOffsetX(0);
                if (this.i.booleanValue()) {
                    i5 = vi.g(getContext(), R.dimen.tbds5);
                }
                offsetX.setOffsetY(i5).into(this.c);
            }
            this.g = i;
        }
    }

    public void setData(cw7 cw7Var) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, cw7Var) != null) || cw7Var == null) {
            return;
        }
        this.f = cw7Var;
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (cw7Var.c() > 0) {
                marginLayoutParams.topMargin = vi.g(getContext(), R.dimen.M_H_X001);
            } else {
                marginLayoutParams.topMargin = 0;
            }
            setLayoutParams(marginLayoutParams);
        }
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b32, SkinManager.getColor(R.color.CAM_X0306), null);
        pureDrawable.setBounds(0, 0, vi.g(getContext(), R.dimen.tbds96), vi.g(getContext(), R.dimen.T_X07));
        this.d.setCompoundDrawables(pureDrawable, null, null, null);
        this.d.setCompoundDrawablePadding(vi.g(getContext(), R.dimen.M_W_X001));
        this.d.setText(cw7Var.getTitle());
        this.b.q(cw7Var.getDataList());
        this.b.r(this.e);
        Boolean bool = this.i;
        if (bool == null || bool.booleanValue() != cw7Var.e()) {
            boolean e = cw7Var.e();
            if (e) {
                this.b.p(ContentCollectListAdapter.CornerType.FULL);
            } else {
                this.b.p(ContentCollectListAdapter.CornerType.ITEM);
            }
            ShadowDrawable makeShadowDrawable = TBSelector.makeShadowDrawable();
            if (e) {
                i = R.color.CAM_X0205;
            } else {
                i = R.color.transparent;
            }
            ShadowDrawable shadowColor = makeShadowDrawable.setBgColor(i).setShadowColor(R.color.CAM_X0802);
            if (e) {
                i2 = vi.g(getContext(), R.dimen.tbds31);
            } else {
                i2 = 0;
            }
            ShadowDrawable shadowSide = shadowColor.setShapeRadius(i2).setShadowSide(ShadowDrawable.ALL);
            if (e) {
                i3 = vi.g(getContext(), R.dimen.tbds10);
            } else {
                i3 = 0;
            }
            ShadowDrawable offsetX = shadowSide.setShadowRadius(i3).setOffsetX(0);
            if (e) {
                i4 = vi.g(getContext(), R.dimen.tbds5);
            } else {
                i4 = 0;
            }
            offsetX.setOffsetY(i4).into(this.c);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.i = Boolean.valueOf(e);
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
