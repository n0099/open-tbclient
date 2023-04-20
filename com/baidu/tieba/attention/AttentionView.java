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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.gy5;
import com.baidu.tieba.pg5;
import com.baidu.tieba.qg5;
import com.baidu.tieba.xw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AttentionView extends FrameLayout implements xw5<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RecyclerView b;
    public SelectForumItemAdapter c;
    public LinearLayoutManager d;
    public pg5 e;
    public qg5 f;
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

    @Override // com.baidu.tieba.xw5
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

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.attention.AttentionView.i(com.baidu.tieba.attention.AttentionView, java.util.List):java.util.List
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(com.baidu.adp.framework.message.HttpResponsedMessage r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.attention.AttentionView.a.$ic
                if (r0 != 0) goto L9d
            L4:
                com.baidu.tieba.attention.AttentionView r0 = r4.a
                r0.l()
                int r0 = r5.getError()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L23
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                java.util.List r5 = com.baidu.tieba.attention.AttentionView.d(r5)
                boolean r5 = com.baidu.tbadk.core.util.ListUtils.isEmpty(r5)
                if (r5 == 0) goto L22
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                r5.w(r2, r1)
            L22:
                return
            L23:
                boolean r0 = r5 instanceof com.baidu.tieba.attention.AttentionResMsg
                if (r0 != 0) goto L39
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                java.util.List r5 = com.baidu.tieba.attention.AttentionView.d(r5)
                boolean r5 = com.baidu.tbadk.core.util.ListUtils.isEmpty(r5)
                if (r5 == 0) goto L38
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                r5.w(r2, r1)
            L38:
                return
            L39:
                com.baidu.tieba.attention.AttentionResMsg r5 = (com.baidu.tieba.attention.AttentionResMsg) r5
                java.util.List r0 = r5.getSelectForumDataList()
                boolean r1 = com.baidu.tbadk.core.util.ListUtils.isEmpty(r0)
                if (r1 == 0) goto L68
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                java.util.List r5 = com.baidu.tieba.attention.AttentionView.d(r5)
                boolean r5 = com.baidu.tbadk.core.util.ListUtils.isEmpty(r5)
                if (r5 == 0) goto L67
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                r5.w(r2, r2)
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                com.baidu.tieba.attention.AttentionView$d r5 = com.baidu.tieba.attention.AttentionView.e(r5)
                if (r5 == 0) goto L67
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                com.baidu.tieba.attention.AttentionView$d r5 = com.baidu.tieba.attention.AttentionView.e(r5)
                r5.a()
            L67:
                return
            L68:
                com.baidu.tieba.attention.AttentionView r1 = r4.a
                boolean r5 = r5.getHasMore()
                com.baidu.tieba.attention.AttentionView.g(r1, r5)
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                com.baidu.tieba.attention.AttentionView.h(r5)
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                java.util.List r5 = com.baidu.tieba.attention.AttentionView.d(r5)
                com.baidu.tieba.attention.AttentionView r1 = r4.a
                com.baidu.tieba.attention.AttentionView.i(r1, r0)
                r5.addAll(r0)
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                com.baidu.tieba.adapter.SelectForumItemAdapter r5 = com.baidu.tieba.attention.AttentionView.j(r5)
                com.baidu.tieba.attention.AttentionView r0 = r4.a
                java.util.List r0 = com.baidu.tieba.attention.AttentionView.d(r0)
                r5.p(r0)
                com.baidu.tieba.attention.AttentionView r5 = r4.a
                com.baidu.tieba.adapter.SelectForumItemAdapter r5 = com.baidu.tieba.attention.AttentionView.j(r5)
                r5.notifyDataSetChanged()
                return
            L9d:
                r2 = r0
                r3 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.attention.AttentionView.a.onMessage(com.baidu.adp.framework.message.HttpResponsedMessage):void");
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

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.attention.AttentionView.a.onMessage(com.baidu.adp.framework.message.HttpResponsedMessage):void] */
    public static /* synthetic */ SelectForumItemAdapter j(AttentionView attentionView) {
        return attentionView.c;
    }

    public void o(ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            this.g = arrayList;
        }
    }

    public void setForumSelectStateChangedListener(gy5.e eVar) {
        SelectForumItemAdapter selectForumItemAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) && (selectForumItemAdapter = this.c) != null) {
            selectForumItemAdapter.q(eVar);
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
            pg5 pg5Var = new pg5(getContext());
            this.e = pg5Var;
            pg5Var.onChangeSkinType();
        }
        this.e.attachView(this, z);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ java.util.List i(com.baidu.tieba.attention.AttentionView r0, java.util.List r1) {
        /*
            r0.s(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.attention.AttentionView.i(com.baidu.tieba.attention.AttentionView, java.util.List):java.util.List");
    }

    @Override // com.baidu.tieba.xw5
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        pg5 pg5Var = this.e;
        if (pg5Var != null) {
            pg5Var.onChangeSkinType();
        }
        qg5 qg5Var = this.f;
        if (qg5Var != null) {
            qg5Var.onChangeSkinType();
        }
        this.c.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.xw5
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getContext().getString(R.string.obfuscated_res_0x7f0f0094);
        }
        return (String) invokeV.objValue;
    }

    public void l() {
        pg5 pg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pg5Var = this.e) != null) {
            pg5Var.dettachView(this);
            this.e = null;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            qg5 qg5Var = this.f;
            if (qg5Var != null) {
                qg5Var.dettachView(this);
                this.f = null;
            }
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.xw5
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SelectForumItemAdapter selectForumItemAdapter = this.c;
            if (selectForumItemAdapter != null) {
                selectForumItemAdapter.q(null);
            }
            MessageManager.getInstance().unRegisterListener(this.l);
            l();
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            pg5 pg5Var = this.e;
            if (pg5Var != null) {
                return pg5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            qg5 qg5Var = this.f;
            if (qg5Var != null) {
                return qg5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d080c, (ViewGroup) this, true);
            this.b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091ff1);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.c = selectForumItemAdapter;
            selectForumItemAdapter.r(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.d = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setAdapter(this.c);
            this.b.addOnScrollListener(new b(this));
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xw5
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
            this.f = new qg5(getContext(), new c(this));
        }
        this.f.k(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f.attachView(this, z);
        if (z2) {
            this.f.p();
        } else {
            this.f.h(R.drawable.new_pic_emotion_01);
            this.f.e();
        }
        this.f.o(getContext().getString(R.string.obfuscated_res_0x7f0f0091));
        this.b.setVisibility(8);
    }
}
