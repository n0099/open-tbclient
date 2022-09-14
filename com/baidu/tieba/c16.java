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
/* loaded from: classes3.dex */
public class c16 extends w06<i26> {
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
    public y57 u;
    public CardExtendForumItemHolder v;
    public View w;
    public View.OnClickListener x;
    public LikeModel y;
    public List<z57> z;

    /* loaded from: classes3.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c16 a;

        public a(c16 c16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c16Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof vl8) && this.a.y.getErrorCode() == 0) {
                    return;
                }
                if (AntiHelper.m(this.a.y.getErrorCode(), this.a.y.getErrorString())) {
                    AntiHelper.u(this.a.getContext(), this.a.y.getErrorString());
                } else {
                    this.a.g().showToast(this.a.y.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c16 c16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c16Var, Integer.valueOf(i)};
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
            this.a = c16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.H(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c16 c16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c16Var, Integer.valueOf(i)};
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
            this.a = c16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.H(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c16 a;

        public d(c16 c16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090a46) {
                if (ViewHelper.checkUpIsLogin(this.a.h().getContext())) {
                    String str = (String) view2.getTag(R.id.obfuscated_res_0x7f09204c);
                    String valueOf = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f09204b));
                    if (dj.isForumName(str)) {
                        this.a.y.Q(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.a.A).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, g16.e()));
                    }
                }
            } else if (view2.getTag(R.id.obfuscated_res_0x7f09204c) != null) {
                String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f09204c);
                String valueOf2 = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f09204b));
                if (dj.isForumName(str2)) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091477) {
                        TiebaStatic.log(new StatisticItem(this.a.C).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, g16.e()));
                    } else {
                        TiebaStatic.log(new StatisticItem(this.a.B).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, g16.e()));
                    }
                    if (!StringUtils.isNull(this.a.D) && !StringUtils.isNull(this.a.E)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.h().getContext()).createCfgForpersonalized(str2, this.a.D, this.a.E)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.h().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c16(TbPageContext<?> tbPageContext) {
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
            this.w = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d027d, (ViewGroup) null);
        }
        this.v = new CardExtendForumItemHolder(this.w);
        this.q.addView(this.t);
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080ce2);
        this.t.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0);
        C();
        if (this.u == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 10; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            y57 y57Var = new y57(getContext(), R.layout.obfuscated_res_0x7f0d027d, this.v);
            this.u = y57Var;
            y57Var.d(this.x);
            this.t.setAdapter((ListAdapter) this.u);
        }
        this.i.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.y = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.t.setOnItemClickListener(null);
    }

    public final h26 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.z) > 0) {
                for (z57 z57Var : this.z) {
                    if (z57Var != null && (z57Var instanceof h26)) {
                        h26 h26Var = (h26) z57Var;
                        if (String.valueOf(h26Var.d).equals(str)) {
                            return h26Var;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (h26) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = new d(this);
        }
    }

    public final boolean D(List<z57> list, List<z57> list2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            while (i < ListUtils.getCount(list)) {
                z57 z57Var = (z57) ListUtils.getItem(list, i);
                z57 z57Var2 = (z57) ListUtils.getItem(list2, i);
                if (z57Var != null && (z57Var instanceof h26) && z57Var2 != null && (z57Var2 instanceof h26)) {
                    h26 h26Var = (h26) z57Var;
                    h26 h26Var2 = (h26) z57Var2;
                    if (h26Var.d != h26Var2.d) {
                        z = false;
                    }
                    if (!h26Var.b.equals(h26Var2.b)) {
                        z = false;
                    }
                    i = h26Var.c.equals(h26Var2.c) ? i + 1 : 0;
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w06
    /* renamed from: E */
    public void t(i26 i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, i26Var) == null) {
            super.i(i26Var);
            if (i26Var != null && ListUtils.getCount(i26Var.getDataList()) > 0) {
                int count = ListUtils.getCount(i26Var.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(i26Var.getDataList());
                    i26Var.getDataList().clear();
                    i26Var.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.E = i26Var.h();
                this.D = i26Var.f();
                if (D(i26Var.getDataList(), this.z)) {
                    return;
                }
                boolean z = ListUtils.getCount(i26Var.getDataList()) != ListUtils.getCount(this.z);
                this.z = i26Var.getDataList();
                if (count <= 0) {
                    h().setVisibility(8);
                    return;
                }
                h().setVisibility(0);
                y57 y57Var = this.u;
                if (y57Var != null) {
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < this.z.size(); i++) {
                            arrayList2.add(String.valueOf(i));
                        }
                        y57 y57Var2 = new y57(getContext(), R.layout.obfuscated_res_0x7f0d027d, this.v);
                        this.u = y57Var2;
                        y57Var2.c(this.z);
                        this.u.d(this.x);
                        this.t.setAdapter((ListAdapter) this.u);
                        j(g(), TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    y57Var.c(this.z);
                    this.u.notifyDataSetChanged();
                    return;
                }
                return;
            }
            h().setVisibility(8);
        }
    }

    public void F(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || (customMessageListener = this.F) == null || this.G == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.G.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.F);
        MessageManager.getInstance().registerListener(this.G);
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
            h26 B = B(String.valueOf(j));
            if (B != null) {
                B.e = z;
            }
            y57 y57Var = this.u;
            if (y57Var != null) {
                y57Var.c(this.z);
                this.u.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.w06, com.baidu.tieba.v06
    public void j(TbPageContext<?> tbPageContext, int i) {
        y57 y57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            super.j(tbPageContext, i);
            if (this.t == null || (y57Var = this.u) == null) {
                return;
            }
            y57Var.b(i);
        }
    }

    @Override // com.baidu.tieba.v06
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }
}
