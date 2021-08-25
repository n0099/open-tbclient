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
import c.a.e.l.e.j;
import c.a.e.l.e.l;
import c.a.l.q;
import c.a.p0.b.d;
import c.a.p0.n.f;
import c.a.p0.s.q.u1;
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
/* loaded from: classes7.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f51943e;

    /* renamed from: f  reason: collision with root package name */
    public int f51944f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51945g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f51946h;

    /* renamed from: i  reason: collision with root package name */
    public ConcernRecommendListAdapter f51947i;

    /* renamed from: j  reason: collision with root package name */
    public l f51948j;
    public int k;
    public CustomMessageListener l;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernRecommendLayout f51949a;

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
            this.f51949a = concernRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f51949a.f51948j == null) {
                        this.f51949a.f51948j = new l(new j());
                    }
                    this.f51949a.f51948j.q(this.f51949a.f51946h, 1);
                } else if (this.f51949a.f51948j != null) {
                    this.f51949a.f51948j.w();
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
            this.f51945g = (TextView) findViewById(R.id.title);
            this.f51946h = (RecyclerView) findViewById(R.id.thread_card_list);
            ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.f51943e);
            this.f51947i = concernRecommendListAdapter;
            this.f51946h.setAdapter(concernRecommendListAdapter);
            this.f51946h.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.f51948j = lVar;
                lVar.q(this.f51946h, 1);
            }
            int g2 = c.a.e.e.p.l.g(this.f51943e, R.dimen.tbds21);
            int g3 = c.a.e.e.p.l.g(this.f51943e, R.dimen.tbds44);
            this.f51946h.setLayoutManager(new LinearLayoutManager(this.f51943e, 0, false));
            this.f51946h.setItemAnimator(new DefaultItemAnimator());
            this.f51946h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f51946h.getLayoutParams();
            if (d.w0()) {
                layoutParams.bottomMargin = c.a.e.e.p.l.g(this.f51943e, R.dimen.tbds39);
            } else {
                layoutParams.bottomMargin = c.a.e.e.p.l.g(this.f51943e, R.dimen.tbds22);
            }
            this.f51946h.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            if (i2 != this.f51944f) {
                SkinManager.setViewTextColor(this.f51945g, this.k);
                this.f51947i.onChangeSkinType(i2);
            }
            this.f51944f = i2;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void setData(u1 u1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, u1Var) == null) {
            if (u1Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (!TextUtils.isEmpty(u1Var.f14359e) && u1Var.f14360f != 0) {
                this.f51945g.setTextSize(0, c.a.e.e.p.l.g(this.f51943e, R.dimen.tbds37));
                this.f51945g.setText(u1Var.f14359e);
                this.f51945g.setTypeface(Typeface.DEFAULT_BOLD);
                this.k = u1Var.f14360f;
            } else {
                this.f51945g.setTextSize(0, c.a.e.e.p.l.g(this.f51943e, R.dimen.tbds37));
                this.f51945g.setText(R.string.concern_recommend_title);
                this.f51945g.setTypeface(Typeface.DEFAULT_BOLD);
                this.k = R.color.CAM_X0105;
            }
            this.f51947i.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f51947i.setData(u1Var.g());
            this.f51947i.notifyDataSetChanged();
        }
    }

    public void setHasBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f51947i.setHasBorder(z);
        }
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f51947i.setOnItemCoverListener(fVar);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f51947i.setPageContext(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.l.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.l);
            this.f51947i.setPageUniqueId(bdUniqueId);
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
        this.f51944f = 3;
        this.k = R.color.CAM_X0108;
        this.l = new a(this, 2156674);
        this.f51943e = context;
        d();
    }
}
