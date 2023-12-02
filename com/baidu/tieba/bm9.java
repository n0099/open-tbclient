package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.am9;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.tieba.memberCenter.bubble.SetBubbleResultData;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.ph5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class bm9 extends ph5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListModel m;
    public BubbleListData n;
    public Context o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public BubbleListModel.c u;
    public BubbleListModel.d v;
    public CustomMessageListener w;
    public View.OnClickListener x;
    public am9.e y;
    public am9.e z;

    /* loaded from: classes5.dex */
    public class a implements ph5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ bm9 b;

        public a(bm9 bm9Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bm9Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.ph5.a
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
                BubbleListData.BubbleData S = this.b.S(i);
                if (S != null) {
                    bubbleView2.setData(S, BubbleListModel.Q(this.b.n.getB_info()));
                    bubbleView2.setGravity(17);
                    bubbleView2.setTag(Integer.valueOf(i));
                    bubbleView2.setOnClickListener(this.b.x);
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                TbPageContext tbPageContext = (TbPageContext) a5.a(this.b.o);
                BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
                if (skinType == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.setNightMode(z);
                tbPageContext.getLayoutMode().onModeChanged(bubbleView);
                return bubbleView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm9 a;

        public b(bm9 bm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm9Var;
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
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0e70);
                    }
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0e70);
                }
            } else {
                UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0e70);
            }
            if (this.a.h() != null) {
                this.a.h().d();
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                if (bubbleListData == null) {
                    this.a.h().d();
                    return;
                }
                this.a.n = bubbleListData.m144clone();
                if (this.a.m.S() > 0) {
                    List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
                    if (b_info != null && b_info.size() != 0) {
                        for (BubbleListData.BubbleData bubbleData : b_info) {
                            if (bubbleData != null && bubbleData.getBcode() == this.a.m.S()) {
                                if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                    break;
                                }
                                this.a.m.Y(this.a.m.S());
                                this.a.m.X(this.a.m.S(), BdUtilHelper.getEquipmentWidth(this.a.o), BdUtilHelper.getEquipmentHeight(this.a.o));
                            }
                        }
                        this.a.m.Z(-1);
                    } else {
                        return;
                    }
                }
                this.a.T("getList");
                this.a.h().b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm9 a;

        public c(bm9 bm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm9Var;
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
                    this.a.s = setBubbleResultData.getB_info().getIosBImgFormat();
                    this.a.t = setBubbleResultData.getB_info().getIosBUrl();
                    TbadkCoreApplication.getInst().setDefaultIosBImgFormat(this.a.s);
                    TbadkCoreApplication.getInst().setDefaultIosBUrl(this.a.t);
                    int R = this.a.m.R();
                    if (R == 0) {
                        TbadkCoreApplication.getInst().setDefaultBubble("");
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes("");
                        TbadkCoreApplication.getInst().setDefaultIosBImgFormat("");
                        TbadkCoreApplication.getInst().setDefaultIosBUrl("");
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
                            if (bubbleData2.getBcode() == R) {
                                bubbleData2.setIs_def(1);
                            } else if (bubbleData2.isDef()) {
                                bubbleData2.setIs_def(0);
                            }
                            if (bubbleData2.getBcode() == R) {
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
                    this.a.T("set");
                    this.a.h().b(this.a);
                    return;
                }
                this.a.h().d();
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
                            UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0e70);
                        }
                    } else {
                        UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0e70);
                    }
                } else {
                    UtilHelper.showToast(this.a.o, (int) R.string.obfuscated_res_0x7f0f0e70);
                }
                if (this.a.h() != null) {
                    this.a.h().d();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bm9 bm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var, Integer.valueOf(i)};
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
            this.a = bm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m.W(0, 50, 0, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm9 a;

        public e(bm9 bm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm9Var;
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
                        am9.a(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.y);
                        return;
                    } else if (!(this.a.o instanceof TbPageContextSupport)) {
                        return;
                    } else {
                        am9.b(((TbPageContextSupport) this.a.o).getPageContext(), bubbleData, this.a.z);
                        return;
                    }
                }
                this.a.V(bubbleData.getBcode());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements am9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm9 a;

        @Override // com.baidu.tieba.am9.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public f(bm9 bm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm9Var;
        }

        @Override // com.baidu.tieba.am9.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.V(i);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements am9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm9 a;

        @Override // com.baidu.tieba.am9.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public g(bm9 bm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm9Var;
        }

        @Override // com.baidu.tieba.am9.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.m.Z(i);
                PayPanelUtils.launchPayPanel(TbadkCoreApplication.getInst().getCurrentPageContext(this.a.o), IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            }
        }
    }

    public bm9() {
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
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this, 2010040);
        this.x = new e(this);
        this.y = new f(this);
        this.z = new g(this);
    }

    public final BubbleListData.BubbleData S(int i) {
        InterceptResult invokeI;
        BubbleListData bubbleListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0 && i < c() && (bubbleListData = this.n) != null) {
                return bubbleListData.getB_info().get(i);
            }
            return null;
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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
                        String bg_url = this.n.getB_info().get(i).getBg_url();
                        if (bg_url != null && !bg_url.equals(this.q)) {
                            this.s = null;
                            this.t = null;
                            TbadkCoreApplication.getInst().setDefaultIosBImgFormat(null);
                            TbadkCoreApplication.getInst().setDefaultIosBUrl(null);
                            DefaultLog.getInstance().e(FileHelper.FILE_CACHE_BUBBLE, "根据列表更新显示的气泡，显示了一个新的气泡，get接口没有IosBUrl！！！");
                        }
                        this.q = bg_url;
                        TbadkCoreApplication.getInst().setDefaultBubble(this.q);
                        this.r = this.n.getB_info().get(i).getDynamicUrl();
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.r);
                    } else {
                        i++;
                    }
                }
            }
            if (this.p != 0 && !TextUtils.isEmpty(this.q)) {
                j0(new he5(2, 12, " "));
                z = true;
            } else {
                j0(new he5(2, 12, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.valueOf(z)));
            HashMap hashMap = new HashMap();
            hashMap.put("b_url", this.q);
            hashMap.put("dynamic_url", this.r);
            hashMap.put("ios_bimg_format", this.s);
            hashMap.put("ios_b_url", this.t);
            hashMap.put("from", str);
            j0(new he5(25, -1, hashMap));
        }
    }

    @Override // com.baidu.tieba.ie5
    public void U(he5 he5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, he5Var) == null) {
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
            this.m.W(0, 50, BdUtilHelper.getEquipmentWidth(this.o), BdUtilHelper.getEquipmentHeight(this.o));
        }
    }

    public final void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.m.X(i, BdUtilHelper.getEquipmentWidth(this.o), BdUtilHelper.getEquipmentHeight(this.o));
            this.m.Y(i);
            if (h() != null) {
                h().a();
            }
        }
    }

    @Override // com.baidu.tieba.ph5
    public void a() {
        BubbleListModel bubbleListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bubbleListModel = this.m) != null) {
            bubbleListModel.unRegisterListener();
            this.m.c0(this.w);
            this.m = null;
        }
    }

    @Override // com.baidu.tieba.ph5
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

    @Override // com.baidu.tieba.ph5
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.o = context;
            ph5.b bVar = new ph5.b();
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
            this.s = TbadkCoreApplication.getInst().getDefaultIosBImgFormat();
            this.t = TbadkCoreApplication.getInst().getDefaultIosBUrl();
            if (this.m == null) {
                Context context2 = this.o;
                if (context2 instanceof TbPageContext) {
                    this.m = new BubbleListModel((TbPageContext) context2);
                } else {
                    this.m = new BubbleListModel(null);
                }
            }
            this.m.a0(this.u);
            this.m.b0(this.v);
            this.m.V(this.w);
            this.m.T();
            this.m.U();
            if (h() != null) {
                h().a();
            }
            this.m.W(0, 50, BdUtilHelper.getEquipmentWidth(this.o), BdUtilHelper.getEquipmentHeight(this.o));
        }
    }
}
