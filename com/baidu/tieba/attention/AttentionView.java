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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.cq5;
import com.baidu.tieba.ja5;
import com.baidu.tieba.ka5;
import com.baidu.tieba.to5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AttentionView extends FrameLayout implements to5<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RecyclerView b;
    public SelectForumItemAdapter c;
    public LinearLayoutManager d;
    public ja5 e;
    public ka5 f;
    public List<SelectForumData> g;
    public List<SelectForumData> h;
    public boolean i;
    public int j;
    public d k;
    public HttpMessageListener l;

    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    @Override // com.baidu.tieba.to5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
                    if (ListUtils.isEmpty(this.a.h)) {
                        this.a.w(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (ListUtils.isEmpty(this.a.h)) {
                        this.a.w(false, true);
                    }
                } else {
                    AttentionResMsg attentionResMsg = (AttentionResMsg) httpResponsedMessage;
                    List<SelectForumData> selectForumDataList = attentionResMsg.getSelectForumDataList();
                    if (ListUtils.isEmpty(selectForumDataList)) {
                        if (ListUtils.isEmpty(this.a.h)) {
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
                    List list = this.a.h;
                    this.a.s(selectForumDataList);
                    list.addAll(selectForumDataList);
                    this.a.c.i(this.a.h);
                    this.a.c.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0 && this.a.i && this.a.d.findLastVisibleItemPosition() == this.a.c.getItemCount() - 1) {
                this.a.c(null);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.c(null);
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

    public final boolean p(SelectForumData selectForumData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, selectForumData)) == null) {
            if (selectForumData != null && !ListUtils.isEmpty(this.g)) {
                for (int i = 0; i < this.g.size(); i++) {
                    SelectForumData selectForumData2 = this.g.get(i);
                    if (selectForumData2 != null && (str = selectForumData.forumId) != null && str.equals(selectForumData2.forumId)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final List<SelectForumData> s(List<SelectForumData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(this.g)) {
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
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.j = 1;
        this.l = new a(this, CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        n();
    }

    public static /* synthetic */ int h(AttentionView attentionView) {
        int i = attentionView.j;
        attentionView.j = i + 1;
        return i;
    }

    public void o(ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            this.g = arrayList;
        }
    }

    public void setForumSelectStateChangedListener(cq5.e eVar) {
        SelectForumItemAdapter selectForumItemAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) && (selectForumItemAdapter = this.c) != null) {
            selectForumItemAdapter.j(eVar);
        }
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
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (selectForumItemAdapter = this.c) != null) {
            selectForumItemAdapter.notifyItemChanged(i);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || q()) {
            return;
        }
        if (this.e == null) {
            ja5 ja5Var = new ja5(getContext());
            this.e = ja5Var;
            ja5Var.onChangeSkinType();
        }
        this.e.attachView(this, z);
    }

    @Override // com.baidu.tieba.to5
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        ja5 ja5Var = this.e;
        if (ja5Var != null) {
            ja5Var.onChangeSkinType();
        }
        ka5 ka5Var = this.f;
        if (ka5Var != null) {
            ka5Var.onChangeSkinType();
        }
        this.c.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.to5
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getContext().getString(R.string.obfuscated_res_0x7f0f0091);
        }
        return (String) invokeV.objValue;
    }

    public void l() {
        ja5 ja5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ja5Var = this.e) != null) {
            ja5Var.dettachView(this);
            this.e = null;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ka5 ka5Var = this.f;
            if (ka5Var != null) {
                ka5Var.dettachView(this);
                this.f = null;
            }
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.to5
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SelectForumItemAdapter selectForumItemAdapter = this.c;
            if (selectForumItemAdapter != null) {
                selectForumItemAdapter.j(null);
            }
            MessageManager.getInstance().unRegisterListener(this.l);
            l();
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ja5 ja5Var = this.e;
            if (ja5Var != null) {
                return ja5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ka5 ka5Var = this.f;
            if (ka5Var != null) {
                return ka5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07c6, (ViewGroup) this, true);
            this.b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091e92);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.c = selectForumItemAdapter;
            selectForumItemAdapter.k(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.d = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setAdapter(this.c);
            this.b.addOnScrollListener(new b(this));
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.to5
    /* renamed from: u */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (ListUtils.isEmpty(this.h)) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
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
            httpMessage.addParam(SuggestAddrField.KEY_PAGE_SIZE, 50);
            httpMessage.addParam("page_no", this.j);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void w(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || r()) {
            return;
        }
        if (this.f == null) {
            this.f = new ka5(getContext(), new c(this));
        }
        this.f.k(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f.attachView(this, z);
        if (z2) {
            this.f.p();
        } else {
            this.f.h(R.drawable.new_pic_emotion_01);
            this.f.e();
        }
        this.f.o(getContext().getString(R.string.obfuscated_res_0x7f0f008e));
        this.b.setVisibility(8);
    }
}
