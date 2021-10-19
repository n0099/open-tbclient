package com.baidu.tieba.attention;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.q0.u.i;
import c.a.r0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class AttentionView extends FrameLayout implements f<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49808e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f49809f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f49810g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f49811h;

    /* renamed from: i  reason: collision with root package name */
    public g f49812i;

    /* renamed from: j  reason: collision with root package name */
    public h f49813j;
    public List<i> k;
    public boolean l;
    public int m;
    public HttpMessageListener n;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttentionView f49814a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AttentionView attentionView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {attentionView, Integer.valueOf(i2)};
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
            this.f49814a = attentionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f49814a.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (ListUtils.isEmpty(this.f49814a.k)) {
                        this.f49814a.showNetRefreshView(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (ListUtils.isEmpty(this.f49814a.k)) {
                        this.f49814a.showNetRefreshView(false, true);
                    }
                } else {
                    AttentionResMsg attentionResMsg = (AttentionResMsg) httpResponsedMessage;
                    List<i> selectForumDataList = attentionResMsg.getSelectForumDataList();
                    if (ListUtils.isEmpty(selectForumDataList)) {
                        if (ListUtils.isEmpty(this.f49814a.k)) {
                            this.f49814a.showNetRefreshView(false, false);
                            return;
                        }
                        return;
                    }
                    this.f49814a.l = attentionResMsg.getHasMore();
                    AttentionView.d(this.f49814a);
                    this.f49814a.k.addAll(selectForumDataList);
                    this.f49814a.f49810g.setDataList(this.f49814a.k);
                    this.f49814a.f49810g.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttentionView f49815a;

        public b(AttentionView attentionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {attentionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49815a = attentionView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0 && this.f49815a.l && this.f49815a.f49811h.findLastVisibleItemPosition() == this.f49815a.f49810g.getItemCount() - 1) {
                this.f49815a.request((String) null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AttentionView f49816e;

        public c(AttentionView attentionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {attentionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49816e = attentionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f49816e.request((String) null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AttentionView(Context context) {
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

    public static /* synthetic */ int d(AttentionView attentionView) {
        int i2 = attentionView.m;
        attentionView.m = i2 + 1;
        return i2;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
            this.f49809f = (RecyclerView) findViewById(R.id.select_forum_list);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f49810g = selectForumItemAdapter;
            selectForumItemAdapter.setType(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f49811h = linearLayoutManager;
            this.f49809f.setLayoutManager(linearLayoutManager);
            this.f49809f.setAdapter(this.f49810g);
            this.f49809f.addOnScrollListener(new b(this));
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    @Override // c.a.r0.f
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getContext().getString(R.string.activity_select_forum_tab_attention) : (String) invokeV.objValue;
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f49812i) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f49812i = null;
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h hVar = this.f49813j;
            if (hVar != null) {
                hVar.dettachView(this);
                this.f49813j = null;
            }
            this.f49809f.setVisibility(0);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.f49812i;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h hVar = this.f49813j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.f
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f49808e) {
            return;
        }
        this.f49808e = skinType;
        g gVar = this.f49812i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.f49813j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f49810g.notifyDataSetChanged();
    }

    @Override // c.a.r0.f
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            hideLoadingView();
        }
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f49812i == null) {
            g gVar = new g(getContext());
            this.f49812i = gVar;
            gVar.onChangeSkinType();
        }
        this.f49812i.attachView(this, z);
    }

    public void showNetRefreshView(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.f49813j == null) {
            this.f49813j = new h(getContext(), new c(this));
        }
        this.f49813j.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f49813j.attachView(this, z);
        if (z2) {
            this.f49813j.o();
        } else {
            this.f49813j.h(R.drawable.new_pic_emotion_01);
            this.f49813j.e();
        }
        this.f49813j.n(getContext().getString(R.string.activity_select_forum_empty));
        this.f49809f.setVisibility(8);
    }

    @Override // c.a.r0.f
    public void showTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AttentionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f
    public void request(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (ListUtils.isEmpty(this.k)) {
                if (!j.A()) {
                    showNetRefreshView(false, true);
                    return;
                } else {
                    hideNetRefreshView();
                    showLoadingView(false);
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("from_index", 1);
            httpMessage.addParam("page_size", 50);
            httpMessage.addParam("page_no", this.m);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49808e = 3;
        this.k = new ArrayList();
        this.m = 1;
        this.n = new a(this, CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        g();
    }
}
