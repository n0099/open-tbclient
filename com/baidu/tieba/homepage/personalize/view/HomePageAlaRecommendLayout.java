package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.b.g.b;
import d.a.q0.e1.h.j.f;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes4.dex */
public class HomePageAlaRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f16851e;

    /* renamed from: f  reason: collision with root package name */
    public int f16852f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView f16853g;

    /* renamed from: h  reason: collision with root package name */
    public AlaRecommendListAdapter f16854h;

    /* renamed from: i  reason: collision with root package name */
    public List<AlaLiveInfo> f16855i;
    public CustomMessageListener j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageAlaRecommendLayout f16856a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomePageAlaRecommendLayout homePageAlaRecommendLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageAlaRecommendLayout, Integer.valueOf(i2)};
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
            this.f16856a = homePageAlaRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            AlaUserInfo alaUserInfo;
            Long l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) == null || data.f12869d || StringUtils.isNull(data.f12868c) || this.f16856a.f16855i == null) {
                return;
            }
            for (AlaLiveInfo alaLiveInfo : this.f16856a.f16855i) {
                if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && (l = alaUserInfo.user_id) != null && data.f12868c.equals(l.toString())) {
                    this.f16856a.f16855i.remove(alaLiveInfo);
                    this.f16856a.d();
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomePageAlaRecommendLayout(Context context) {
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.home_page_ala_recommend_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f16853g = (BdRecyclerView) findViewById(R.id.ala_recommend_list);
            AlaRecommendListAdapter alaRecommendListAdapter = new AlaRecommendListAdapter(this.f16851e);
            this.f16854h = alaRecommendListAdapter;
            this.f16853g.setAdapter(alaRecommendListAdapter);
            this.f16853g.setLayoutManager(new LinearLayoutManager(this.f16851e, 0, false));
            this.f16853g.setItemAnimator(new DefaultItemAnimator());
            int g2 = l.g(this.f16851e, R.dimen.tbds20);
            this.f16853g.addItemDecoration(new CommonSpaceItemDecoration(g2, 0, g2));
            BdRecyclerView bdRecyclerView = this.f16853g;
            bdRecyclerView.setPadding(bdRecyclerView.getPaddingLeft(), this.f16853g.getPaddingTop(), this.f16853g.getPaddingRight(), l.g(this.f16853g.getContext(), b.e(R.dimen.tbds0, R.dimen.tbds51)));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f16852f == i2) {
            return;
        }
        this.f16852f = i2;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (ListUtils.isEmpty(this.f16855i)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f16854h.setData(this.f16855i);
            this.f16854h.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.j);
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            super.onDetachedFromWindow();
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            if (fVar != null && !ListUtils.isEmpty(fVar.c())) {
                this.f16855i = fVar.c();
                setVisibility(0);
                d();
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageAlaRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f16852f = 3;
        this.j = new a(this, 2001115);
        this.f16851e = context;
        b();
    }
}
