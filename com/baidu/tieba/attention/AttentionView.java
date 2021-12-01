package com.baidu.tieba.attention;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.j;
import c.a.q0.g0.h;
import c.a.r0.g;
import c.a.r0.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AttentionView extends FrameLayout implements g<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43053e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f43054f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f43055g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f43056h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.g0.g f43057i;

    /* renamed from: j  reason: collision with root package name */
    public h f43058j;

    /* renamed from: k  reason: collision with root package name */
    public List<SelectForumData> f43059k;
    public List<SelectForumData> l;
    public boolean m;
    public int n;
    public HttpMessageListener o;

    /* loaded from: classes10.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AttentionView a;

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
            this.a = attentionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (ListUtils.isEmpty(this.a.l)) {
                        this.a.showNetRefreshView(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (ListUtils.isEmpty(this.a.l)) {
                        this.a.showNetRefreshView(false, true);
                    }
                } else {
                    AttentionResMsg attentionResMsg = (AttentionResMsg) httpResponsedMessage;
                    List<SelectForumData> selectForumDataList = attentionResMsg.getSelectForumDataList();
                    if (ListUtils.isEmpty(selectForumDataList)) {
                        if (ListUtils.isEmpty(this.a.l)) {
                            this.a.showNetRefreshView(false, false);
                            return;
                        }
                        return;
                    }
                    this.a.m = attentionResMsg.getHasMore();
                    AttentionView.d(this.a);
                    List list = this.a.l;
                    this.a.j(selectForumDataList);
                    list.addAll(selectForumDataList);
                    this.a.f43055g.setDataList(this.a.l);
                    this.a.f43055g.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AttentionView a;

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
            this.a = attentionView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0 && this.a.m && this.a.f43056h.findLastVisibleItemPosition() == this.a.f43055g.getItemCount() - 1) {
                this.a.request((String) null);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AttentionView f43060e;

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
            this.f43060e = attentionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f43060e.request((String) null);
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
        int i2 = attentionView.n;
        attentionView.n = i2 + 1;
        return i2;
    }

    @Override // c.a.r0.g
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getContext().getString(R.string.activity_select_forum_tab_attention) : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
            this.f43054f = (RecyclerView) findViewById(R.id.select_forum_list);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f43055g = selectForumItemAdapter;
            selectForumItemAdapter.setType(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f43056h = linearLayoutManager;
            this.f43054f.setLayoutManager(linearLayoutManager);
            this.f43054f.setAdapter(this.f43055g);
            this.f43054f.addOnScrollListener(new b(this));
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    public void hideLoadingView() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f43057i) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f43057i = null;
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h hVar = this.f43058j;
            if (hVar != null) {
                hVar.dettachView(this);
                this.f43058j = null;
            }
            this.f43054f.setVisibility(0);
        }
    }

    public final boolean i(SelectForumData selectForumData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, selectForumData)) == null) {
            if (selectForumData != null && !ListUtils.isEmpty(this.f43059k)) {
                for (int i2 = 0; i2 < this.f43059k.size(); i2++) {
                    SelectForumData selectForumData2 = this.f43059k.get(i2);
                    if (selectForumData2 != null && (str = selectForumData.forumId) != null && str.equals(selectForumData2.forumId)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void initSelectedForums(ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f43059k = arrayList;
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.q0.g0.g gVar = this.f43057i;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h hVar = this.f43058j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<SelectForumData> j(List<SelectForumData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(this.f43059k)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    SelectForumData selectForumData = list.get(i2);
                    if (i(selectForumData)) {
                        selectForumData.isInterestForumSelected = true;
                    }
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public void notifyItemChanged(int i2) {
        SelectForumItemAdapter selectForumItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (selectForumItemAdapter = this.f43055g) == null) {
            return;
        }
        selectForumItemAdapter.notifyItemChanged(i2);
    }

    @Override // c.a.r0.g
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f43053e) {
            return;
        }
        this.f43053e = skinType;
        c.a.q0.g0.g gVar = this.f43057i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.f43058j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f43055g.notifyDataSetChanged();
    }

    @Override // c.a.r0.g
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SelectForumItemAdapter selectForumItemAdapter = this.f43055g;
            if (selectForumItemAdapter != null) {
                selectForumItemAdapter.setForumSelectStateChangedListener(null);
            }
            MessageManager.getInstance().unRegisterListener(this.o);
            hideLoadingView();
        }
    }

    public void setForumSelectStateChangedListener(q.c cVar) {
        SelectForumItemAdapter selectForumItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) || (selectForumItemAdapter = this.f43055g) == null) {
            return;
        }
        selectForumItemAdapter.setForumSelectStateChangedListener(cVar);
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f43057i == null) {
            c.a.q0.g0.g gVar = new c.a.q0.g0.g(getContext());
            this.f43057i = gVar;
            gVar.onChangeSkinType();
        }
        this.f43057i.attachView(this, z);
    }

    public void showNetRefreshView(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.f43058j == null) {
            this.f43058j = new h(getContext(), new c(this));
        }
        this.f43058j.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f43058j.attachView(this, z);
        if (z2) {
            this.f43058j.o();
        } else {
            this.f43058j.h(R.drawable.new_pic_emotion_01);
            this.f43058j.e();
        }
        this.f43058j.n(getContext().getString(R.string.activity_select_forum_empty));
        this.f43054f.setVisibility(8);
    }

    @Override // c.a.r0.g
    public void showTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
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
    @Override // c.a.r0.g
    public void request(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (ListUtils.isEmpty(this.l)) {
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
            httpMessage.addParam("page_no", this.n);
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
        this.f43053e = 3;
        this.f43059k = new ArrayList();
        this.l = new ArrayList();
        this.n = 1;
        this.o = new a(this, CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        h();
    }
}
