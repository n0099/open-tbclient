package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.cf5;
import com.baidu.tieba.gk8;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.tieba.memberCenter.bubble.SetBubbleResultData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class hk8 extends cf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListModel m;
    public BubbleListData n;
    public Context o;
    public int p;
    public String q;
    public String r;
    public BubbleListModel.c s;
    public BubbleListModel.d t;
    public CustomMessageListener u;
    public View.OnClickListener v;
    public gk8.e w;
    public gk8.e x;

    /* loaded from: classes4.dex */
    public class a implements cf5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ hk8 b;

        public a(hk8 hk8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk8Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.cf5.a
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            BubbleView bubbleView;
            BubbleView bubbleView2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    bubbleView2 = new BubbleView(this.a);
                    bubbleView = bubbleView2;
                } else {
                    bubbleView = view2;
                    bubbleView2 = (BubbleView) view2;
                }
                BubbleListData.BubbleData Q = this.b.Q(i);
                if (Q != null) {
                    bubbleView2.setData(Q, BubbleListModel.S(this.b.n.getB_info()));
                    bubbleView2.setGravity(17);
                    bubbleView2.setTag(Integer.valueOf(i));
                    bubbleView2.setOnClickListener(this.b.v);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) g9.a(this.b.o);
                hv4 layoutMode = tbPageContext.getLayoutMode();
                if (skinType == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.l(z);
                tbPageContext.getLayoutMode().k(bubbleView);
                return bubbleView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk8 a;

        public b(hk8 hk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk8Var;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bubbleListData) != null) {
                return;
            }
            this.a.n = null;
            if (bubbleListData != null) {
                if (!bubbleListData.getError_code().equals("0")) {
                    if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                        UtilHelper.showToast(this.a.o, bubbleListData.getError_msg());
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0d1b);
                    }
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0d1b);
                }
            } else {
                UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0d1b);
            }
            if (this.a.h() != null) {
                this.a.h().onLoadFail();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                if (bubbleListData == null) {
                    this.a.h().onLoadFail();
                    return;
                }
                this.a.n = bubbleListData.m61clone();
                if (this.a.m.U() > 0) {
                    List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                    if (b_info != null && b_info.size() != 0) {
                        for (BubbleListData.BubbleData bubbleData : b_info) {
                            if (bubbleData != null && bubbleData.getBcode() == this.a.m.U()) {
                                if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                    break;
                                }
                                this.a.m.a0(this.a.m.U());
                                this.a.m.Z(this.a.m.U(), ii.l(this.a.o), ii.j(this.a.o));
                            }
                        }
                        this.a.m.b0(-1);
                    } else {
                        return;
                    }
                }
                this.a.R();
                this.a.h().b(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk8 a;

        public c(hk8 hk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk8Var;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null && setBubbleResultData.getB_info() != null) {
                    this.a.q = setBubbleResultData.getB_info().getB_url();
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.q);
                    this.a.r = setBubbleResultData.getB_info().getDynamicUrl();
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.a.r);
                    int T = this.a.m.T();
                    if (T == 0) {
                        TbadkCoreApplication.getInst().setDefaultBubble("");
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes("");
                        for (BubbleListData.BubbleData bubbleData : this.a.n.getB_info()) {
                            if (bubbleData.getBcode() != 0) {
                                if (bubbleData.isDef()) {
                                    bubbleData.setIs_def(0);
                                }
                            } else {
                                bubbleData.setIs_def(1);
                            }
                        }
                    } else if (setBubbleResultData.getB_info().canUser()) {
                        for (BubbleListData.BubbleData bubbleData2 : this.a.n.getB_info()) {
                            if (bubbleData2.getBcode() == T) {
                                bubbleData2.setIs_def(1);
                            } else if (bubbleData2.isDef()) {
                                bubbleData2.setIs_def(0);
                            }
                            if (bubbleData2.getBcode() == T) {
                                bubbleData2.setCan_use(1);
                            }
                        }
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.setdefualt_error);
                        if (this.a.n != null && this.a.n.getB_info() != null && this.a.n.getB_info().size() > 0) {
                            if (this.a.n.getB_info().get(0).getBcode() != 0) {
                                BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                                bubbleData3.setBcode(0);
                                this.a.n.getB_info().add(0, bubbleData3);
                            } else {
                                this.a.p = 0;
                                int i = 0;
                                while (true) {
                                    if (i < this.a.n.getB_info().size()) {
                                        if (!this.a.n.getB_info().get(i).isDef()) {
                                            i++;
                                        } else {
                                            this.a.p = i;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                this.a.n.getB_info().get(this.a.p).setIs_def(0);
                                this.a.n.getB_info().get(0).setIs_def(1);
                            }
                        }
                    }
                    this.a.R();
                    this.a.h().b(this.a);
                    return;
                }
                this.a.h().onLoadFail();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                if (setBubbleResultData != null) {
                    if (!setBubbleResultData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                            UtilHelper.showToast(this.a.o, setBubbleResultData.getError_msg());
                        } else {
                            UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0d1b);
                        }
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0d1b);
                    }
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0d1b);
                }
                if (this.a.h() != null) {
                    this.a.h().onLoadFail();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hk8 hk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var, Integer.valueOf(i)};
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
            this.a = hk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m.Y(0, 50, 0, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk8 a;

        public e(hk8 hk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.n == null || !(view2 instanceof BubbleView)) {
                return;
            }
            BubbleListData.BubbleData bubbleData = (BubbleListData.BubbleData) ListUtils.getItem(this.a.n.getB_info(), ((Integer) view2.getTag()).intValue());
            TbadkSettings inst = TbadkSettings.getInst();
            boolean loadBoolean = inst.loadBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
            if (bubbleData != null && !bubbleData.isDef()) {
                if (bubbleData.getBcode() != 0 && !bubbleData.canUse() && !loadBoolean) {
                    if (bubbleData.isFree()) {
                        if (!(this.a.o instanceof TbPageContextSupport)) {
                            return;
                        }
                        gk8.a(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.w);
                        return;
                    } else if (!(this.a.o instanceof TbPageContextSupport)) {
                        return;
                    } else {
                        gk8.b(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.x);
                        return;
                    }
                }
                this.a.S(bubbleData.getBcode());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements gk8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk8 a;

        @Override // com.baidu.tieba.gk8.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public f(hk8 hk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk8Var;
        }

        @Override // com.baidu.tieba.gk8.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.S(i);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements gk8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk8 a;

        @Override // com.baidu.tieba.gk8.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public g(hk8 hk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk8Var;
        }

        @Override // com.baidu.tieba.gk8.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.m.b0(i);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.o, true, 23004, "pop_unable");
                memberPayActivityConfig.setSceneId("4002001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    public hk8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 0;
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this, 2010040);
        this.v = new e(this);
        this.w = new f(this);
        this.x = new g(this);
    }

    public final BubbleListData.BubbleData Q(int i) {
        InterceptResult invokeI;
        BubbleListData bubbleListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && i < c() && (bubbleListData = this.n) != null) {
                return bubbleListData.getB_info().get(i);
            }
            return null;
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    @Override // com.baidu.tieba.qc5
    public void C(pc5 pc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pc5Var) == null) {
            if (this.m == null) {
                Context context = this.o;
                if (context instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            if (h() != null) {
                h().a();
            }
            this.m.Y(0, 50, ii.l(this.o), ii.j(this.o));
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BubbleListData bubbleListData = this.n;
            boolean z = false;
            if (bubbleListData != null && bubbleListData.getB_info() != null && this.n.getB_info().size() > 0) {
                BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
                bubbleData.setBcode(0);
                if (this.n.getB_info().get(0).getBcode() != 0) {
                    this.n.getB_info().add(0, bubbleData);
                }
                this.p = 0;
                int i = 0;
                while (true) {
                    if (i >= this.n.getB_info().size()) {
                        break;
                    } else if (this.n.getB_info().get(i).isDef()) {
                        this.p = i;
                        this.q = this.n.getB_info().get(i).getBg_url();
                        TbadkCoreApplication.getInst().setDefaultBubble(this.q);
                        this.r = this.n.getB_info().get(i).getDynamicUrl();
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.r);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (this.p != 0 && !TextUtils.isEmpty(this.q)) {
                H(new pc5(2, 12, " "));
                z = true;
            } else {
                H(new pc5(2, 12, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.valueOf(z)));
            HashMap hashMap = new HashMap();
            hashMap.put("b_url", this.q);
            hashMap.put("dynamic_url", this.r);
            H(new pc5(25, -1, hashMap));
        }
    }

    public final void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.m.Z(i, ii.l(this.o), ii.j(this.o));
            this.m.a0(i);
            if (h() != null) {
                h().a();
            }
        }
    }

    @Override // com.baidu.tieba.cf5
    public void a() {
        BubbleListModel bubbleListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bubbleListModel = this.m) != null) {
            bubbleListModel.unRegisterListener();
            this.m.e0(this.u);
            this.m = null;
        }
    }

    @Override // com.baidu.tieba.cf5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BubbleListData bubbleListData = this.n;
            if (bubbleListData != null && bubbleListData.getB_info() != null) {
                return this.n.getB_info().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cf5
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.o = context;
            cf5.b bVar = new cf5.b();
            bVar.a = R.drawable.icon_bubble;
            bVar.b = 0;
            w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0));
            q(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201));
            r(bVar);
            o(2);
            v(2);
            x(new a(this, context));
            this.q = TbadkCoreApplication.getInst().getDefaultBubble();
            this.r = TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes();
            if (this.m == null) {
                Context context2 = this.o;
                if (context2 instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context2);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            this.m.c0(this.s);
            this.m.d0(this.t);
            this.m.X(this.u);
            this.m.V();
            this.m.W();
            if (h() != null) {
                h().a();
            }
            this.m.Y(0, 50, ii.l(this.o), ii.j(this.o));
        }
    }
}
