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
import c.a.d.f.p.l;
import c.a.o0.f0.h;
import c.a.p0.g;
import c.a.p0.q;
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
/* loaded from: classes5.dex */
public class AttentionView extends FrameLayout implements g<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f31501b;

    /* renamed from: c  reason: collision with root package name */
    public SelectForumItemAdapter f31502c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutManager f31503d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.f0.g f31504e;

    /* renamed from: f  reason: collision with root package name */
    public h f31505f;

    /* renamed from: g  reason: collision with root package name */
    public List<SelectForumData> f31506g;

    /* renamed from: h  reason: collision with root package name */
    public List<SelectForumData> f31507h;
    public boolean i;
    public int j;
    public d k;
    public HttpMessageListener l;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AttentionView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AttentionView attentionView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {attentionView, Integer.valueOf(i)};
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
            this.a = attentionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.l();
                if (httpResponsedMessage.getError() != 0) {
                    if (ListUtils.isEmpty(this.a.f31507h)) {
                        this.a.w(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (ListUtils.isEmpty(this.a.f31507h)) {
                        this.a.w(false, true);
                    }
                } else {
                    AttentionResMsg attentionResMsg = (AttentionResMsg) httpResponsedMessage;
                    List<SelectForumData> selectForumDataList = attentionResMsg.getSelectForumDataList();
                    if (ListUtils.isEmpty(selectForumDataList)) {
                        if (ListUtils.isEmpty(this.a.f31507h)) {
                            this.a.w(false, false);
                            if (this.a.k != null) {
                                this.a.k.a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.i = attentionResMsg.getHasMore();
                    AttentionView.h(this.a);
                    List list = this.a.f31507h;
                    this.a.s(selectForumDataList);
                    list.addAll(selectForumDataList);
                    this.a.f31502c.i(this.a.f31507h);
                    this.a.f31502c.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = attentionView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0 && this.a.i && this.a.f31503d.findLastVisibleItemPosition() == this.a.f31502c.getItemCount() - 1) {
                this.a.c(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AttentionView a;

        public c(AttentionView attentionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {attentionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = attentionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.a.c(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();
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

    public static /* synthetic */ int h(AttentionView attentionView) {
        int i = attentionView.j;
        attentionView.j = i + 1;
        return i;
    }

    @Override // c.a.p0.g
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        c.a.o0.f0.g gVar = this.f31504e;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.f31505f;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f31502c.notifyDataSetChanged();
    }

    @Override // c.a.p0.g
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // c.a.p0.g
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getContext().getString(R.string.obfuscated_res_0x7f0f008f) : (String) invokeV.objValue;
    }

    public void l() {
        c.a.o0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.f31504e) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f31504e = null;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h hVar = this.f31505f;
            if (hVar != null) {
                hVar.dettachView(this);
                this.f31505f = null;
            }
            this.f31501b.setVisibility(0);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0761, (ViewGroup) this, true);
            this.f31501b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091c72);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f31502c = selectForumItemAdapter;
            selectForumItemAdapter.k(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f31503d = linearLayoutManager;
            this.f31501b.setLayoutManager(linearLayoutManager);
            this.f31501b.setAdapter(this.f31502c);
            this.f31501b.addOnScrollListener(new b(this));
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void o(ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            this.f31506g = arrayList;
        }
    }

    @Override // c.a.p0.g
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SelectForumItemAdapter selectForumItemAdapter = this.f31502c;
            if (selectForumItemAdapter != null) {
                selectForumItemAdapter.j(null);
            }
            MessageManager.getInstance().unRegisterListener(this.l);
            l();
        }
    }

    public final boolean p(SelectForumData selectForumData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, selectForumData)) == null) {
            if (selectForumData != null && !ListUtils.isEmpty(this.f31506g)) {
                for (int i = 0; i < this.f31506g.size(); i++) {
                    SelectForumData selectForumData2 = this.f31506g.get(i);
                    if (selectForumData2 != null && (str = selectForumData.forumId) != null && str.equals(selectForumData2.forumId)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.o0.f0.g gVar = this.f31504e;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            h hVar = this.f31505f;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<SelectForumData> s(List<SelectForumData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(this.f31506g)) {
                for (int i = 0; i < list.size(); i++) {
                    SelectForumData selectForumData = list.get(i);
                    if (p(selectForumData)) {
                        selectForumData.isInterestForumSelected = true;
                    }
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public void setForumSelectStateChangedListener(q.e eVar) {
        SelectForumItemAdapter selectForumItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || (selectForumItemAdapter = this.f31502c) == null) {
            return;
        }
        selectForumItemAdapter.j(eVar);
    }

    public void setResultEmptyListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void t(int i) {
        SelectForumItemAdapter selectForumItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (selectForumItemAdapter = this.f31502c) == null) {
            return;
        }
        selectForumItemAdapter.notifyItemChanged(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.g
    /* renamed from: u */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (ListUtils.isEmpty(this.f31507h)) {
                if (!l.A()) {
                    w(false, true);
                    return;
                } else {
                    m();
                    v(false);
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("from_index", 1);
            httpMessage.addParam("page_size", 50);
            httpMessage.addParam("page_no", this.j);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || q()) {
            return;
        }
        if (this.f31504e == null) {
            c.a.o0.f0.g gVar = new c.a.o0.f0.g(getContext());
            this.f31504e = gVar;
            gVar.onChangeSkinType();
        }
        this.f31504e.attachView(this, z);
    }

    public void w(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || r()) {
            return;
        }
        if (this.f31505f == null) {
            this.f31505f = new h(getContext(), new c(this));
        }
        this.f31505f.k(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f31505f.attachView(this, z);
        if (z2) {
            this.f31505f.p();
        } else {
            this.f31505f.h(R.drawable.new_pic_emotion_01);
            this.f31505f.e();
        }
        this.f31505f.o(getContext().getString(R.string.obfuscated_res_0x7f0f008c));
        this.f31501b.setVisibility(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f31506g = new ArrayList();
        this.f31507h = new ArrayList();
        this.j = 1;
        this.l = new a(this, CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        n();
    }
}
