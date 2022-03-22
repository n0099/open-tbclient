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
import c.a.d.f.p.n;
import c.a.d.o.e.j;
import c.a.d.o.e.l;
import c.a.l.q;
import c.a.o0.m.f;
import c.a.o0.r.r.s1;
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
/* loaded from: classes5.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f33227b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33228c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f33229d;

    /* renamed from: e  reason: collision with root package name */
    public ConcernRecommendListAdapter f33230e;

    /* renamed from: f  reason: collision with root package name */
    public l f33231f;

    /* renamed from: g  reason: collision with root package name */
    public int f33232g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f33233h;

    /* loaded from: classes5.dex */
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
                    if (this.a.f33231f == null) {
                        this.a.f33231f = new l(new j());
                    }
                    this.a.f33231f.q(this.a.f33229d, 1);
                } else if (this.a.f33231f != null) {
                    this.a.f33231f.w();
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01fb, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f33228c = (TextView) findViewById(R.id.obfuscated_res_0x7f09202b);
            this.f33229d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091f99);
            ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.a);
            this.f33230e = concernRecommendListAdapter;
            this.f33229d.setAdapter(concernRecommendListAdapter);
            this.f33229d.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.f33231f = lVar;
                lVar.q(this.f33229d, 1);
            }
            int f2 = n.f(this.a, R.dimen.tbds21);
            int f3 = n.f(this.a, R.dimen.tbds44);
            this.f33229d.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            this.f33229d.setItemAnimator(new DefaultItemAnimator());
            this.f33229d.addItemDecoration(new SpaceItemDecoration(f3, f2, f3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f33229d.getLayoutParams();
            if (UbsABTestHelper.showNewUI()) {
                layoutParams.bottomMargin = n.f(this.a, R.dimen.tbds39);
            } else {
                layoutParams.bottomMargin = n.f(this.a, R.dimen.tbds22);
            }
            this.f33229d.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            if (i != this.f33227b) {
                SkinManager.setViewTextColor(this.f33228c, this.f33232g);
                this.f33230e.h(i);
            }
            this.f33227b = i;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public void setData(s1 s1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s1Var) == null) {
            if (s1Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (!TextUtils.isEmpty(s1Var.a) && s1Var.f10952b != 0) {
                this.f33228c.setTextSize(0, n.f(this.a, R.dimen.tbds37));
                this.f33228c.setText(s1Var.a);
                this.f33228c.setTypeface(Typeface.DEFAULT_BOLD);
                this.f33232g = s1Var.f10952b;
            } else {
                this.f33228c.setTextSize(0, n.f(this.a, R.dimen.tbds37));
                this.f33228c.setText(R.string.obfuscated_res_0x7f0f0415);
                this.f33228c.setTypeface(Typeface.DEFAULT_BOLD);
                this.f33232g = R.color.CAM_X0105;
            }
            this.f33230e.h(TbadkCoreApplication.getInst().getSkinType());
            this.f33230e.setData(s1Var.e());
            this.f33230e.notifyDataSetChanged();
        }
    }

    public void setHasBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f33230e.k(z);
        }
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f33230e.l(fVar);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f33230e.m(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.f33233h.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f33233h);
            this.f33230e.n(bdUniqueId);
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
        this.f33227b = 3;
        this.f33232g = R.color.CAM_X0108;
        this.f33233h = new a(this, 2156674);
        this.a = context;
        d();
    }
}
