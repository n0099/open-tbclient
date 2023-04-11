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
public class fg6 extends zf6<kh6> {
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
    public yv7 u;
    public CardExtendForumItemHolder v;
    public View w;
    public View.OnClickListener x;
    public LikeModel y;
    public List<zv7> z;

    /* loaded from: classes4.dex */
    public class a extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg6 a;

        public a(fg6 fg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg6Var;
        }

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!(obj instanceof sk9) || this.a.y.getErrorCode() != 0) {
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
        public final /* synthetic */ fg6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fg6 fg6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg6Var, Integer.valueOf(i)};
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
            this.a = fg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            this.a.J(((Long) customResponsedMessage.getData()).longValue(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fg6 fg6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg6Var, Integer.valueOf(i)};
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
            this.a = fg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            this.a.J(((Long) customResponsedMessage.getData()).longValue(), true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg6 a;

        public d(fg6 fg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null) {
                if (view2.getId() == R.id.forum_add_love) {
                    if (!ViewHelper.checkUpIsLogin(this.a.h().getContext())) {
                        return;
                    }
                    String str = (String) view2.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view2.getTag(R.id.tag_forum_id));
                    if (hi.isForumName(str)) {
                        this.a.y.i0(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.a.A).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, jg6.e()));
                    }
                } else if (view2.getTag(R.id.tag_forum_name) != null) {
                    String str2 = (String) view2.getTag(R.id.tag_forum_name);
                    String valueOf2 = String.valueOf(view2.getTag(R.id.tag_forum_id));
                    if (hi.isForumName(str2)) {
                        if (view2.getId() == R.id.m_forum_name_textview) {
                            TiebaStatic.log(new StatisticItem(this.a.C).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, jg6.e()));
                        } else {
                            TiebaStatic.log(new StatisticItem(this.a.B).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, jg6.e()));
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg6(TbPageContext<?> tbPageContext) {
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
            this.w = LayoutInflater.from(getContext()).inflate(R.layout.extend_forum_item, (ViewGroup) null);
        }
        this.v = new CardExtendForumItemHolder(this.w);
        this.q.addView(this.t);
        this.t.setSelector(R.drawable.list_selector_transparent);
        this.t.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0);
        E();
        if (this.u == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 10; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            yv7 yv7Var = new yv7(getContext(), R.layout.extend_forum_item, this.v);
            this.u = yv7Var;
            yv7Var.d(this.x);
            this.t.setAdapter((ListAdapter) this.u);
        }
        this.i.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.y = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.t.setOnItemClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zf6
    /* renamed from: G */
    public void t(kh6 kh6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kh6Var) == null) {
            super.l(kh6Var);
            if (kh6Var != null && ListUtils.getCount(kh6Var.getDataList()) > 0) {
                int count = ListUtils.getCount(kh6Var.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(kh6Var.getDataList());
                    kh6Var.getDataList().clear();
                    kh6Var.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.E = kh6Var.e();
                this.D = kh6Var.d();
                if (!F(kh6Var.getDataList(), this.z)) {
                    if (ListUtils.getCount(kh6Var.getDataList()) != ListUtils.getCount(this.z)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.z = kh6Var.getDataList();
                    if (count <= 0) {
                        h().setVisibility(8);
                        return;
                    }
                    h().setVisibility(0);
                    yv7 yv7Var = this.u;
                    if (yv7Var != null) {
                        if (z) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i = 0; i < this.z.size(); i++) {
                                arrayList2.add(String.valueOf(i));
                            }
                            yv7 yv7Var2 = new yv7(getContext(), R.layout.extend_forum_item, this.v);
                            this.u = yv7Var2;
                            yv7Var2.c(this.z);
                            this.u.d(this.x);
                            this.t.setAdapter((ListAdapter) this.u);
                            m(g(), TbadkCoreApplication.getInst().getSkinType());
                            return;
                        }
                        yv7Var.c(this.z);
                        this.u.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            h().setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.yf6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }

    public final jh6 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.z) > 0) {
                for (zv7 zv7Var : this.z) {
                    if (zv7Var != null && (zv7Var instanceof jh6)) {
                        jh6 jh6Var = (jh6) zv7Var;
                        if (String.valueOf(jh6Var.d).equals(str)) {
                            return jh6Var;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (jh6) invokeL.objValue;
    }

    public void H(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) && (customMessageListener = this.F) != null && this.G != null) {
            customMessageListener.setTag(bdUniqueId);
            this.G.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.G);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = new d(this);
        }
    }

    public final boolean F(List<zv7> list, List<zv7> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            for (int i = 0; i < ListUtils.getCount(list); i++) {
                zv7 zv7Var = (zv7) ListUtils.getItem(list, i);
                zv7 zv7Var2 = (zv7) ListUtils.getItem(list2, i);
                if (zv7Var != null && (zv7Var instanceof jh6) && zv7Var2 != null && (zv7Var2 instanceof jh6)) {
                    jh6 jh6Var = (jh6) zv7Var;
                    jh6 jh6Var2 = (jh6) zv7Var2;
                    if (jh6Var.d != jh6Var2.d) {
                        z = false;
                    }
                    if (!jh6Var.b.equals(jh6Var2.b)) {
                        z = false;
                    }
                    if (jh6Var.c.equals(jh6Var2.c)) {
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.A = str2;
            this.B = str3;
            this.C = str4;
        }
    }

    public final void J(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            jh6 D = D(String.valueOf(j));
            if (D != null) {
                D.e = z;
            }
            yv7 yv7Var = this.u;
            if (yv7Var != null) {
                yv7Var.c(this.z);
                this.u.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.zf6, com.baidu.tieba.yf6
    public void m(TbPageContext<?> tbPageContext, int i) {
        yv7 yv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.t != null && (yv7Var = this.u) != null) {
                yv7Var.b(i);
            }
        }
    }
}
