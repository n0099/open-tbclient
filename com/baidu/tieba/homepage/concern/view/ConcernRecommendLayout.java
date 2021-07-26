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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.j;
import d.a.d.k.e.l;
import d.a.k.q;
import d.a.p0.b.d;
import d.a.p0.n.f;
import d.a.p0.s.q.t1;
/* loaded from: classes4.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f16582e;

    /* renamed from: f  reason: collision with root package name */
    public int f16583f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16584g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f16585h;

    /* renamed from: i  reason: collision with root package name */
    public ConcernRecommendListAdapter f16586i;
    public l j;
    public int k;
    public CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernRecommendLayout f16587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernRecommendLayout concernRecommendLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16587a = concernRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f16587a.j == null) {
                        this.f16587a.j = new l(new j());
                    }
                    this.f16587a.j.q(this.f16587a.f16585h, 1);
                } else if (this.f16587a.j != null) {
                    this.f16587a.j.w();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            LayoutInflater.from(getContext()).inflate(R.layout.concern_recommend_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f16584g = (TextView) findViewById(R.id.title);
            this.f16585h = (RecyclerView) findViewById(R.id.thread_card_list);
            ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.f16582e);
            this.f16586i = concernRecommendListAdapter;
            this.f16585h.setAdapter(concernRecommendListAdapter);
            this.f16585h.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.j = lVar;
                lVar.q(this.f16585h, 1);
            }
            int g2 = d.a.d.e.p.l.g(this.f16582e, R.dimen.tbds21);
            int g3 = d.a.d.e.p.l.g(this.f16582e, R.dimen.tbds44);
            this.f16585h.setLayoutManager(new LinearLayoutManager(this.f16582e, 0, false));
            this.f16585h.setItemAnimator(new DefaultItemAnimator());
            this.f16585h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16585h.getLayoutParams();
            if (d.o0()) {
                layoutParams.bottomMargin = d.a.d.e.p.l.g(this.f16582e, R.dimen.tbds39);
            } else {
                layoutParams.bottomMargin = d.a.d.e.p.l.g(this.f16582e, R.dimen.tbds22);
            }
            this.f16585h.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            if (i2 != this.f16583f) {
                SkinManager.setViewTextColor(this.f16584g, this.k);
                this.f16586i.h(i2);
            }
            this.f16583f = i2;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void setData(t1 t1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t1Var) == null) {
            if (t1Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (!TextUtils.isEmpty(t1Var.f53442e) && t1Var.f53443f != 0) {
                this.f16584g.setTextSize(0, d.a.d.e.p.l.g(this.f16582e, R.dimen.tbds37));
                this.f16584g.setText(t1Var.f53442e);
                this.f16584g.setTypeface(Typeface.DEFAULT_BOLD);
                this.k = t1Var.f53443f;
            } else {
                this.f16584g.setTextSize(0, d.a.d.e.p.l.g(this.f16582e, R.dimen.tbds37));
                this.f16584g.setText(R.string.concern_recommend_title);
                this.f16584g.setTypeface(Typeface.DEFAULT_BOLD);
                this.k = R.color.CAM_X0105;
            }
            this.f16586i.h(TbadkCoreApplication.getInst().getSkinType());
            this.f16586i.setData(t1Var.c());
            this.f16586i.notifyDataSetChanged();
        }
    }

    public void setHasBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f16586i.k(z);
        }
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f16586i.l(fVar);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f16586i.m(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.l.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.l);
            this.f16586i.n(bdUniqueId);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16583f = 3;
        this.k = R.color.CAM_X0108;
        this.l = new a(this, 2156674);
        this.f16582e = context;
        d();
    }
}
