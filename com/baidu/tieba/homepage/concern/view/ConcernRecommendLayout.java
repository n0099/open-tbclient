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
import c.a.d.m.e.j;
import c.a.d.m.e.l;
import c.a.k.q;
import c.a.q0.b.d;
import c.a.q0.n.f;
import c.a.q0.s.q.v1;
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
/* loaded from: classes10.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f45138e;

    /* renamed from: f  reason: collision with root package name */
    public int f45139f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45140g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f45141h;

    /* renamed from: i  reason: collision with root package name */
    public ConcernRecommendListAdapter f45142i;

    /* renamed from: j  reason: collision with root package name */
    public l f45143j;

    /* renamed from: k  reason: collision with root package name */
    public int f45144k;
    public CustomMessageListener l;

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernRecommendLayout a;

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
            this.a = concernRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.f45143j == null) {
                        this.a.f45143j = new l(new j());
                    }
                    this.a.f45143j.q(this.a.f45141h, 1);
                } else if (this.a.f45143j != null) {
                    this.a.f45143j.w();
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
            this.f45140g = (TextView) findViewById(R.id.title);
            this.f45141h = (RecyclerView) findViewById(R.id.thread_card_list);
            ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.f45138e);
            this.f45142i = concernRecommendListAdapter;
            this.f45141h.setAdapter(concernRecommendListAdapter);
            this.f45141h.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.f45143j = lVar;
                lVar.q(this.f45141h, 1);
            }
            int f2 = c.a.d.f.p.l.f(this.f45138e, R.dimen.tbds21);
            int f3 = c.a.d.f.p.l.f(this.f45138e, R.dimen.tbds44);
            this.f45141h.setLayoutManager(new LinearLayoutManager(this.f45138e, 0, false));
            this.f45141h.setItemAnimator(new DefaultItemAnimator());
            this.f45141h.addItemDecoration(new SpaceItemDecoration(f3, f2, f3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f45141h.getLayoutParams();
            if (d.u0()) {
                layoutParams.bottomMargin = c.a.d.f.p.l.f(this.f45138e, R.dimen.tbds39);
            } else {
                layoutParams.bottomMargin = c.a.d.f.p.l.f(this.f45138e, R.dimen.tbds22);
            }
            this.f45141h.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            if (i2 != this.f45139f) {
                SkinManager.setViewTextColor(this.f45140g, this.f45144k);
                this.f45142i.onChangeSkinType(i2);
            }
            this.f45139f = i2;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void setData(v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v1Var) == null) {
            if (v1Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (!TextUtils.isEmpty(v1Var.f13068e) && v1Var.f13069f != 0) {
                this.f45140g.setTextSize(0, c.a.d.f.p.l.f(this.f45138e, R.dimen.tbds37));
                this.f45140g.setText(v1Var.f13068e);
                this.f45140g.setTypeface(Typeface.DEFAULT_BOLD);
                this.f45144k = v1Var.f13069f;
            } else {
                this.f45140g.setTextSize(0, c.a.d.f.p.l.f(this.f45138e, R.dimen.tbds37));
                this.f45140g.setText(R.string.concern_recommend_title);
                this.f45140g.setTypeface(Typeface.DEFAULT_BOLD);
                this.f45144k = R.color.CAM_X0105;
            }
            this.f45142i.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f45142i.setData(v1Var.g());
            this.f45142i.notifyDataSetChanged();
        }
    }

    public void setHasBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f45142i.setHasBorder(z);
        }
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f45142i.setOnItemCoverListener(fVar);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f45142i.setPageContext(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.l.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.l);
            this.f45142i.setPageUniqueId(bdUniqueId);
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
        this.f45139f = 3;
        this.f45144k = R.color.CAM_X0108;
        this.l = new a(this, 2156674);
        this.f45138e = context;
        d();
    }
}
