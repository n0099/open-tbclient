package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.card.CardExtendForumItemHolder;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g36 extends a36<m46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public HListView t;
    public e87 u;
    public CardExtendForumItemHolder v;
    public View w;
    public View.OnClickListener x;
    public LikeModel y;
    public List<f87> z;

    /* loaded from: classes4.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g36 a;

        public a(g36 g36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g36Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof ao8) || this.a.y.getErrorCode() != 0) {
                    if (AntiHelper.m(this.a.y.getErrorCode(), this.a.y.getErrorString())) {
                        AntiHelper.u(this.a.getContext(), this.a.y.getErrorString());
                    } else {
                        this.a.g().showToast(this.a.y.getErrorString());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g36 g36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g36Var, Integer.valueOf(i)};
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
            this.a = g36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            this.a.H(((Long) customResponsedMessage.getData()).longValue(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g36 g36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g36Var, Integer.valueOf(i)};
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
            this.a = g36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            this.a.H(((Long) customResponsedMessage.getData()).longValue(), true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g36 a;

        public d(g36 g36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090a63) {
                    if (!ViewHelper.checkUpIsLogin(this.a.k().getContext())) {
                        return;
                    }
                    String str = (String) view2.getTag(R.id.obfuscated_res_0x7f092099);
                    String valueOf = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f092098));
                    if (wi.isForumName(str)) {
                        this.a.y.Q(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.a.A).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, k36.e()));
                    }
                } else if (view2.getTag(R.id.obfuscated_res_0x7f092099) != null) {
                    String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f092099);
                    String valueOf2 = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f092098));
                    if (wi.isForumName(str2)) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f0914a8) {
                            TiebaStatic.log(new StatisticItem(this.a.C).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, k36.e()));
                        } else {
                            TiebaStatic.log(new StatisticItem(this.a.B).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, k36.e()));
                        }
                        if (!StringUtils.isNull(this.a.D) && !StringUtils.isNull(this.a.E)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.k().getContext()).createCfgForpersonalized(str2, this.a.D, this.a.E)));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.k().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g36(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = new b(this, 2001336);
        this.G = new c(this, 2001335);
        HListView hListView = new HListView(getContext());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().a != null && TbadkCoreApplication.getInst().getPersonalizeViewData().a.getParent() == null) {
            this.w = TbadkCoreApplication.getInst().getPersonalizeViewData().a;
        } else {
            this.w = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d027e, (ViewGroup) null);
        }
        this.v = new CardExtendForumItemHolder(this.w);
        this.q.addView(this.t);
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080d0f);
        this.t.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0);
        C();
        if (this.u == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 10; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            e87 e87Var = new e87(getContext(), R.layout.obfuscated_res_0x7f0d027e, this.v);
            this.u = e87Var;
            e87Var.d(this.x);
            this.t.setAdapter((ListAdapter) this.u);
        }
        this.i.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.y = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.t.setOnItemClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a36
    /* renamed from: E */
    public void t(m46 m46Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, m46Var) == null) {
            super.l(m46Var);
            if (m46Var != null && ListUtils.getCount(m46Var.getDataList()) > 0) {
                int count = ListUtils.getCount(m46Var.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(m46Var.getDataList());
                    m46Var.getDataList().clear();
                    m46Var.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.E = m46Var.h();
                this.D = m46Var.f();
                if (!D(m46Var.getDataList(), this.z)) {
                    if (ListUtils.getCount(m46Var.getDataList()) != ListUtils.getCount(this.z)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.z = m46Var.getDataList();
                    if (count <= 0) {
                        k().setVisibility(8);
                        return;
                    }
                    k().setVisibility(0);
                    e87 e87Var = this.u;
                    if (e87Var != null) {
                        if (z) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i = 0; i < this.z.size(); i++) {
                                arrayList2.add(String.valueOf(i));
                            }
                            e87 e87Var2 = new e87(getContext(), R.layout.obfuscated_res_0x7f0d027e, this.v);
                            this.u = e87Var2;
                            e87Var2.c(this.z);
                            this.u.d(this.x);
                            this.t.setAdapter((ListAdapter) this.u);
                            m(g(), TbadkCoreApplication.getInst().getSkinType());
                            return;
                        }
                        e87Var.c(this.z);
                        this.u.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            k().setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.z26
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }

    public final l46 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.z) > 0) {
                for (f87 f87Var : this.z) {
                    if (f87Var != null && (f87Var instanceof l46)) {
                        l46 l46Var = (l46) f87Var;
                        if (String.valueOf(l46Var.d).equals(str)) {
                            return l46Var;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (l46) invokeL.objValue;
    }

    public void F(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) && (customMessageListener = this.F) != null && this.G != null) {
            customMessageListener.setTag(bdUniqueId);
            this.G.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.G);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = new d(this);
        }
    }

    public final boolean D(List<f87> list, List<f87> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            for (int i = 0; i < ListUtils.getCount(list); i++) {
                f87 f87Var = (f87) ListUtils.getItem(list, i);
                f87 f87Var2 = (f87) ListUtils.getItem(list2, i);
                if (f87Var != null && (f87Var instanceof l46) && f87Var2 != null && (f87Var2 instanceof l46)) {
                    l46 l46Var = (l46) f87Var;
                    l46 l46Var2 = (l46) f87Var2;
                    if (l46Var.d != l46Var2.d) {
                        z = false;
                    }
                    if (!l46Var.b.equals(l46Var2.b)) {
                        z = false;
                    }
                    if (l46Var.c.equals(l46Var2.c)) {
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void G(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.A = str2;
            this.B = str3;
            this.C = str4;
        }
    }

    public final void H(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            l46 B = B(String.valueOf(j));
            if (B != null) {
                B.e = z;
            }
            e87 e87Var = this.u;
            if (e87Var != null) {
                e87Var.c(this.z);
                this.u.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.a36, com.baidu.tieba.z26
    public void m(TbPageContext<?> tbPageContext, int i) {
        e87 e87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.t != null && (e87Var = this.u) != null) {
                e87Var.b(i);
            }
        }
    }
}
