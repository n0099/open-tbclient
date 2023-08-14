package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.rw5;
import com.baidu.tieba.sy6;
import com.baidu.tieba.uy6;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.tieba.vy6;
import com.baidu.tieba.ww5;
import com.baidu.tieba.yw5;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;
    public List<vy6> b;
    public sy6 c;
    public PbListView d;
    public String e;
    public long f;
    public BdRecyclerView.i g;
    public RecyclerView.Adapter h;

    /* loaded from: classes5.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public HeadImageView c;
        public UserHeadCoverView d;
        public TextView e;
        public TextView f;
        public TbLevelView g;
        public TextView h;
        public HotUserRankLikeButton i;
        public za5 j;
        public TbPageContext k;
        public int l;
        public String m;
        public long n;
        public int o;
        public boolean p;

        /* loaded from: classes5.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vy6 a;
            public final /* synthetic */ RankListViewHolder b;

            public a(RankListViewHolder rankListViewHolder, vy6 vy6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rankListViewHolder, vy6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = rankListViewHolder;
                this.a = vy6Var;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int i = 2;
                    if (!TextUtils.isEmpty(this.b.m)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("resource_id", this.b.m);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        if (!this.a.f.getIsLike()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("resource_id", this.b.m);
                    statisticItem2.param("fid", this.b.n);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    if (!this.a.f.getIsLike()) {
                        i = 1;
                    }
                    statisticItem2.param("obj_type", i);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ vy6 b;
            public final /* synthetic */ List c;
            public final /* synthetic */ RankListViewHolder d;

            public b(RankListViewHolder rankListViewHolder, int i, vy6 vy6Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rankListViewHolder, Integer.valueOf(i), vy6Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = rankListViewHolder;
                this.a = i;
                this.b = vy6Var;
                this.c = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ww5 ww5Var = ww5.a;
                    ww5.c(this.a, this.b.c, this.d.e, this.d.g, this.c, null);
                    yw5.a(this.d.e, null, null, this.d.g, null, 4);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankListViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = 3;
            this.m = "";
            this.o = 0;
            this.a = view2;
            this.k = h(view2.getContext());
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e11);
            this.b = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ef4);
            this.c = headImageView;
            headImageView.setIsRound(true);
            this.c.setPlaceHolder(1);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d = (UserHeadCoverView) view2.findViewById(R.id.obfuscated_res_0x7f090ef3);
            this.e = (TextView) view2.findViewById(R.id.user_name);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09282a);
            this.g = (TbLevelView) view2.findViewById(R.id.obfuscated_res_0x7f090e6c);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092822);
            this.i = (HotUserRankLikeButton) view2.findViewById(R.id.like_button);
        }

        public final TbPageContext h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                if (context instanceof BaseActivity) {
                    return ((BaseActivity) context).getPageContext();
                }
                if (context instanceof BaseFragmentActivity) {
                    return ((BaseFragmentActivity) context).getPageContext();
                }
                return null;
            }
            return (TbPageContext) invokeL.objValue;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.m = str;
            }
        }

        public void l(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                this.n = j;
            }
        }

        public void m(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.o = i;
            }
        }

        public void f(vy6 vy6Var) {
            int i;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, vy6Var) != null) || vy6Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(vy6Var.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                int dimension = (int) this.k.getResources().getDimension(R.dimen.tbds44);
                this.b.setText(vy6Var.a);
                if (this.o == 1) {
                    dimension = (int) this.k.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.k.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.b.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.b.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.b.getText())) {
                i = R.color.CAM_X0315;
            } else if ("3".equals(this.b.getText())) {
                i = R.color.CAM_X0316;
            } else {
                i = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.b, i);
            this.c.startLoad(vy6Var.b, 10, false);
            this.d.setData(vy6Var);
            String str = vy6Var.c;
            if (rw5.e(str) > 12) {
                str = rw5.m(str, 10) + "...";
            }
            this.e.setText(str);
            boolean z = vy6Var.h;
            this.p = z;
            if (z) {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0301);
            } else {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            }
            if (TextUtils.isEmpty(vy6Var.d)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(StringHelper.cutStringWithEllipsisStrict(vy6Var.d, 26));
            }
            if (vy6Var.f.getLevel_id() == 0) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                g(vy6Var);
            }
            if (TextUtils.isEmpty(vy6Var.e)) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
                this.h.setText(vy6Var.e);
            }
            if (this.j == null && (tbPageContext = this.k) != null) {
                za5 za5Var = new za5(tbPageContext, this.i);
                this.j = za5Var;
                za5Var.j(this.k.getUniqueId());
            }
            this.j.l(vy6Var.f);
            this.i.setOnClickEvent(new a(this, vy6Var));
            MetaData metaData = vy6Var.f;
            if (metaData != null && metaData.getUserId() != null && vy6Var.f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
            j(TbadkCoreApplication.getInst().getSkinType());
        }

        public final void g(vy6 vy6Var) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vy6Var) == null) && vy6Var != null && (metaData = vy6Var.f) != null) {
                this.g.setLevel(metaData.getLevel_id(), vy6Var.f.getLevelName());
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.k.getContext()) - RankListViewController.i;
                if (equipmentWidth <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.g);
                this.a.post(new b(this, equipmentWidth, vy6Var, arrayList));
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f.setVisibility(8);
                this.i.setVisibility(8);
            }
        }

        public void j(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || this.l == i) {
                return;
            }
            this.l = i;
            if (!this.p) {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            this.i.onChangeSkinType(this.l);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankListViewController a;

        public a(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            vy6 vy6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vy6Var = (vy6) this.a.b.get(i)) != null && vy6Var.f != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a.getContext(), vy6Var.f.getUserId(), vy6Var.f.getName_show())));
                if (!TextUtils.isEmpty(this.a.e)) {
                    StatisticItem statisticItem = new StatisticItem("c13660");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("resource_id", this.a.e);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, vy6Var.a);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13668");
                statisticItem2.param("uid", vy6Var.f.getUserId());
                statisticItem2.param("fid", this.a.f);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankListViewController a;

        public b(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.b.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rankListViewHolder, i) == null) {
                rankListViewHolder.f((vy6) this.a.b.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d041c, (ViewGroup) null));
                rankListViewHolder.m(0);
                rankListViewHolder.k(this.a.e);
                rankListViewHolder.l(this.a.f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-101709843, "Lcom/baidu/tieba/enterForum/hotuserrank/RankListViewController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-101709843, "Lcom/baidu/tieba/enterForum/hotuserrank/RankListViewController;");
                return;
            }
        }
        i = UtilHelper.getDimenPixelSize(R.dimen.tbds608);
    }

    public RankListViewController(View view2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.g = new a(this);
        this.h = new b(this);
        this.e = str;
        this.f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view2;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
        this.a.setAdapter(this.h);
        View inflate = LayoutInflater.from(view2.getContext()).inflate(R.layout.obfuscated_res_0x7f0d041d, (ViewGroup) null);
        this.c = new sy6(inflate, this.e, this.f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view2.getContext());
        this.d = pbListView;
        pbListView.a();
        this.d.s(R.color.CAM_X0205);
        this.d.B();
        this.d.J(SkinManager.getColor(R.color.CAM_X0107));
        this.d.L(R.dimen.tbfontsize33);
        this.d.F(R.color.CAM_X0110);
        this.a.setNextPage(this.d);
        this.a.setOnItemClickListener(this.g);
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.c.j(i2);
            this.h.notifyDataSetChanged();
            PbListView pbListView = this.d;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.d.e(i2);
            }
        }
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void i(List<vy6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null) {
            this.b.clear();
            this.b.addAll(list);
            this.h.notifyDataSetChanged();
        }
    }

    public void g(uy6 uy6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uy6Var, z) == null) {
            this.c.k(uy6Var, z);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.N();
            this.d.U();
            this.d.H(TbadkCoreApplication.getInst().getString(R.string.list_loading));
            this.d.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void k(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d.T(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0a27), str);
            } else {
                string = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f079b);
            }
            this.d.I(string, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds156));
            this.d.g();
            this.d.P(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
