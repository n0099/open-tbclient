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
import d.a.r0.d0.g;
import d.a.r0.d0.h;
import d.a.r0.t.j;
import d.a.s0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AttentionView extends FrameLayout implements d<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14300e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f14301f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f14302g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f14303h;

    /* renamed from: i  reason: collision with root package name */
    public g f14304i;
    public h j;
    public List<j> k;
    public boolean l;
    public int m;
    public HttpMessageListener n;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttentionView f14305a;

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
            this.f14305a = attentionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f14305a.j();
                if (httpResponsedMessage.getError() != 0) {
                    if (ListUtils.isEmpty(this.f14305a.k)) {
                        this.f14305a.q(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (ListUtils.isEmpty(this.f14305a.k)) {
                        this.f14305a.q(false, true);
                    }
                } else {
                    AttentionResMsg attentionResMsg = (AttentionResMsg) httpResponsedMessage;
                    List<j> selectForumDataList = attentionResMsg.getSelectForumDataList();
                    if (ListUtils.isEmpty(selectForumDataList)) {
                        if (ListUtils.isEmpty(this.f14305a.k)) {
                            this.f14305a.q(false, false);
                            return;
                        }
                        return;
                    }
                    this.f14305a.l = attentionResMsg.getHasMore();
                    AttentionView.g(this.f14305a);
                    this.f14305a.k.addAll(selectForumDataList);
                    this.f14305a.f14302g.h(this.f14305a.k);
                    this.f14305a.f14302g.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttentionView f14306a;

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
            this.f14306a = attentionView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0 && this.f14306a.l && this.f14306a.f14303h.findLastVisibleItemPosition() == this.f14306a.f14302g.getItemCount() - 1) {
                this.f14306a.c(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AttentionView f14307e;

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
            this.f14307e = attentionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && d.a.c.e.p.j.A()) {
                this.f14307e.c(null);
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

    public static /* synthetic */ int g(AttentionView attentionView) {
        int i2 = attentionView.m;
        attentionView.m = i2 + 1;
        return i2;
    }

    @Override // d.a.s0.d
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f14300e) {
            return;
        }
        this.f14300e = skinType;
        g gVar = this.f14304i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f14302g.notifyDataSetChanged();
    }

    @Override // d.a.s0.d
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // d.a.s0.d
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getContext().getString(R.string.activity_select_forum_tab_attention) : (String) invokeV.objValue;
    }

    public void j() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.f14304i) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f14304i = null;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h hVar = this.j;
            if (hVar != null) {
                hVar.dettachView(this);
                this.j = null;
            }
            this.f14301f.setVisibility(0);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
            this.f14301f = (RecyclerView) findViewById(R.id.select_forum_list);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f14302g = selectForumItemAdapter;
            selectForumItemAdapter.i(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f14303h = linearLayoutManager;
            this.f14301f.setLayoutManager(linearLayoutManager);
            this.f14301f.setAdapter(this.f14302g);
            this.f14301f.addOnScrollListener(new b(this));
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g gVar = this.f14304i;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h hVar = this.j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.d
    /* renamed from: o */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (ListUtils.isEmpty(this.k)) {
                if (!d.a.c.e.p.j.A()) {
                    q(false, true);
                    return;
                } else {
                    k();
                    p(false);
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

    @Override // d.a.s0.d
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || m()) {
            return;
        }
        if (this.f14304i == null) {
            g gVar = new g(getContext());
            this.f14304i = gVar;
            gVar.onChangeSkinType();
        }
        this.f14304i.attachView(this, z);
    }

    public void q(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || n()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new c(this));
        }
        this.j.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.j.attachView(this, z);
        if (z2) {
            this.j.o();
        } else {
            this.j.h(R.drawable.new_pic_emotion_01);
            this.j.e();
        }
        this.j.n(getContext().getString(R.string.activity_select_forum_empty));
        this.f14301f.setVisibility(8);
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
        this.f14300e = 3;
        this.k = new ArrayList();
        this.m = 1;
        this.n = new a(this, CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        l();
    }
}
