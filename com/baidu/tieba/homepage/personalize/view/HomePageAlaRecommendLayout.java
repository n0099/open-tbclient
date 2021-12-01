package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.q0.b.g.b;
import c.a.r0.n1.h.j.f;
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
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes10.dex */
public class HomePageAlaRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45362e;

    /* renamed from: f  reason: collision with root package name */
    public int f45363f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView f45364g;

    /* renamed from: h  reason: collision with root package name */
    public AlaRecommendListAdapter f45365h;

    /* renamed from: i  reason: collision with root package name */
    public List<AlaLiveInfo> f45366i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f45367j;

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageAlaRecommendLayout a;

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
            this.a = homePageAlaRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            AlaUserInfo alaUserInfo;
            Long l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) == null || data.f41557d || StringUtils.isNull(data.f41556c) || this.a.f45366i == null) {
                return;
            }
            for (AlaLiveInfo alaLiveInfo : this.a.f45366i) {
                if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && (l = alaUserInfo.user_id) != null && data.f41556c.equals(l.toString())) {
                    this.a.f45366i.remove(alaLiveInfo);
                    this.a.updateAdapter();
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
            this.f45364g = (BdRecyclerView) findViewById(R.id.ala_recommend_list);
            AlaRecommendListAdapter alaRecommendListAdapter = new AlaRecommendListAdapter(this.f45362e);
            this.f45365h = alaRecommendListAdapter;
            this.f45364g.setAdapter(alaRecommendListAdapter);
            this.f45364g.setLayoutManager(new LinearLayoutManager(this.f45362e, 0, false));
            this.f45364g.setItemAnimator(new DefaultItemAnimator());
            int f2 = l.f(this.f45362e, R.dimen.tbds20);
            this.f45364g.addItemDecoration(new CommonSpaceItemDecoration(f2, 0, f2));
            BdRecyclerView bdRecyclerView = this.f45364g;
            bdRecyclerView.setPadding(bdRecyclerView.getPaddingLeft(), this.f45364g.getPaddingTop(), this.f45364g.getPaddingRight(), l.f(this.f45364g.getContext(), b.e(R.dimen.tbds0, R.dimen.tbds51)));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().registerListener(this.f45367j);
            super.onAttachedToWindow();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f45363f == i2) {
            return;
        }
        this.f45363f = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f45367j);
            super.onDetachedFromWindow();
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            if (fVar != null && !ListUtils.isEmpty(fVar.g())) {
                this.f45366i = fVar.g();
                setVisibility(0);
                updateAdapter();
                return;
            }
            setVisibility(8);
        }
    }

    public void updateAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.isEmpty(this.f45366i)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f45365h.setData(this.f45366i);
            this.f45365h.notifyDataSetChanged();
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
        this.f45363f = 3;
        this.f45367j = new a(this, 2001115);
        this.f45362e = context;
        b();
    }
}
