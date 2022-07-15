package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hq4;
import com.repackage.hx;
import com.repackage.jm4;
import com.repackage.jn;
import com.repackage.ln;
import com.repackage.pi;
/* loaded from: classes3.dex */
public class ConcernRecommendLayout extends LinearLayout implements hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public int b;
    public TextView c;
    public RecyclerView d;
    public ConcernRecommendListAdapter e;
    public ln f;
    public int g;
    public CustomMessageListener h;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernRecommendLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernRecommendLayout concernRecommendLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.f == null) {
                        this.a.f = new ln(new jn());
                    }
                    this.a.f.q(this.a.d, 1);
                } else if (this.a.f != null) {
                    this.a.f.w();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConcernRecommendLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01ec, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0920bc);
            this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f092029);
            ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.a);
            this.e = concernRecommendListAdapter;
            this.d.setAdapter(concernRecommendListAdapter);
            this.d.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                ln lnVar = new ln(new jn());
                this.f = lnVar;
                lnVar.q(this.d, 1);
            }
            int f = pi.f(this.a, R.dimen.tbds21);
            int f2 = pi.f(this.a, R.dimen.tbds44);
            this.d.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            this.d.setItemAnimator(new DefaultItemAnimator());
            this.d.addItemDecoration(new SpaceItemDecoration(f2, f, f2));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            if (UbsABTestHelper.showNewUI()) {
                layoutParams.bottomMargin = pi.f(this.a, R.dimen.tbds39);
            } else {
                layoutParams.bottomMargin = pi.f(this.a, R.dimen.tbds22);
            }
            this.d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            if (i != this.b) {
                SkinManager.setViewTextColor(this.c, this.g);
                this.e.h(i);
            }
            this.b = i;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public void setData(hq4 hq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hq4Var) == null) {
            if (hq4Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (!TextUtils.isEmpty(hq4Var.a) && hq4Var.b != 0) {
                this.c.setTextSize(0, pi.f(this.a, R.dimen.tbds37));
                this.c.setText(hq4Var.a);
                this.c.setTypeface(Typeface.DEFAULT_BOLD);
                this.g = hq4Var.b;
            } else {
                this.c.setTextSize(0, pi.f(this.a, R.dimen.tbds37));
                this.c.setText(R.string.obfuscated_res_0x7f0f0422);
                this.c.setTypeface(Typeface.DEFAULT_BOLD);
                this.g = R.color.CAM_X0105;
            }
            this.e.h(TbadkCoreApplication.getInst().getSkinType());
            this.e.setData(hq4Var.c());
            this.e.notifyDataSetChanged();
        }
    }

    public void setHasBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e.k(z);
        }
    }

    public void setOnItemCoverListener(jm4<MetaData> jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jm4Var) == null) {
            this.e.l(jm4Var);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.e.m(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.h.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.h);
            this.e.n(bdUniqueId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.g = R.color.CAM_X0108;
        this.h = new a(this, 2156674);
        this.a = context;
        d();
    }
}
