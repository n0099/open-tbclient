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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.hq6;
import com.baidu.tieba.ii;
import com.baidu.tieba.jq6;
import com.baidu.tieba.jr5;
import com.baidu.tieba.kq6;
import com.baidu.tieba.q65;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;
    public List<kq6> b;
    public hq6 c;
    public PbListView d;
    public String e;
    public long f;
    public BdRecyclerView.i g;
    public RecyclerView.Adapter h;

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public HeadImageView b;
        public UserHeadCoverView c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public HotUserRankLikeButton h;
        public q65 i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes4.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kq6 a;
            public final /* synthetic */ RankListViewHolder b;

            public a(RankListViewHolder rankListViewHolder, kq6 kq6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rankListViewHolder, kq6Var};
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
                this.a = kq6Var;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int i = 2;
                    if (!TextUtils.isEmpty(this.b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("resource_id", this.b.l);
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
                    statisticItem2.param("resource_id", this.b.l);
                    statisticItem2.param("fid", this.b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    if (!this.a.f.getIsLike()) {
                        i = 1;
                    }
                    statisticItem2.param("obj_type", i);
                    TiebaStatic.log(statisticItem2);
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
            this.k = 3;
            this.l = "";
            this.n = 0;
            this.j = d(view2.getContext());
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ce4);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e7c);
            this.b = headImageView;
            headImageView.setIsRound(true);
            this.b.setPlaceHolder(1);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c = (UserHeadCoverView) view2.findViewById(R.id.obfuscated_res_0x7f090e7b);
            this.d = (TextView) view2.findViewById(R.id.user_name);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926a5);
            this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dfc);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09269e);
            this.h = (HotUserRankLikeButton) view2.findViewById(R.id.like_button);
        }

        public final TbPageContext d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
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

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.l = str;
            }
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.m = j;
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.n = i;
            }
        }

        public void c(kq6 kq6Var) {
            int i;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, kq6Var) != null) || kq6Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(kq6Var.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(kq6Var.a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.a.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.a.getText())) {
                i = R.color.CAM_X0315;
            } else if ("3".equals(this.a.getText())) {
                i = R.color.CAM_X0316;
            } else {
                i = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.a, i);
            this.b.N(kq6Var.b, 10, false);
            this.c.setData(kq6Var);
            String str = kq6Var.c;
            if (jr5.e(str) > 12) {
                str = jr5.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.d.setText(str);
            boolean z = kq6Var.h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(kq6Var.d)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(StringHelper.cutStringWithEllipsisStrict(kq6Var.d, 26));
            }
            if (kq6Var.f.getLevel_id() == 0) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                SkinManager.setImageResource(this.f, BitmapHelper.getGradeResourceIdInEnterForum(kq6Var.f.getLevel_id()));
            }
            if (TextUtils.isEmpty(kq6Var.e)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(kq6Var.e);
            }
            if (this.i == null && (tbPageContext = this.j) != null) {
                q65 q65Var = new q65(tbPageContext, this.h);
                this.i = q65Var;
                q65Var.l(this.j.getUniqueId());
            }
            this.i.n(kq6Var.f);
            this.h.setOnClickEvent(new a(this, kq6Var));
            MetaData metaData = kq6Var.f;
            if (metaData != null && metaData.getUserId() != null && kq6Var.f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.setVisibility(8);
                this.h.setVisibility(8);
            }
        }

        public void f(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.k == i) {
                return;
            }
            this.k = i;
            if (!this.o) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            this.h.onChangeSkinType(this.k);
        }
    }

    /* loaded from: classes4.dex */
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
            kq6 kq6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && (kq6Var = (kq6) this.a.b.get(i)) != null && kq6Var.f != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a.getContext(), kq6Var.f.getUserId(), kq6Var.f.getName_show())));
                if (!TextUtils.isEmpty(this.a.e)) {
                    StatisticItem statisticItem = new StatisticItem("c13660");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("resource_id", this.a.e);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, kq6Var.a);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13668");
                statisticItem2.param("uid", kq6Var.f.getUserId());
                statisticItem2.param("fid", this.a.f);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        /* renamed from: k */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rankListViewHolder, i) == null) {
                rankListViewHolder.c((kq6) this.a.b.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03e4, (ViewGroup) null));
                rankListViewHolder.i(0);
                rankListViewHolder.g(this.a.e);
                rankListViewHolder.h(this.a.f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }
    }

    public RankListViewController(View view2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
        View inflate = LayoutInflater.from(view2.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03e5, (ViewGroup) null);
        this.c = new hq6(inflate, this.e, this.f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view2.getContext());
        this.d = pbListView;
        pbListView.a();
        this.d.r(R.color.CAM_X0205);
        this.d.A();
        this.d.H(SkinManager.getColor(R.color.CAM_X0107));
        this.d.J(R.dimen.tbfontsize33);
        this.d.D(R.color.CAM_X0110);
        this.a.setNextPage(this.d);
        this.a.setOnItemClickListener(this.g);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.j(i);
            this.h.notifyDataSetChanged();
            PbListView pbListView = this.d;
            if (pbListView != null) {
                pbListView.H(SkinManager.getColor(R.color.CAM_X0109));
                this.d.e(i);
            }
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<kq6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null) {
            this.b.clear();
            this.b.addAll(list);
            this.h.notifyDataSetChanged();
        }
    }

    public void f(jq6 jq6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jq6Var, z) == null) {
            this.c.k(jq6Var, z);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.L();
            this.d.S();
            this.d.F(TbadkCoreApplication.getInst().getString(R.string.list_loading));
            this.d.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d.R(ii.g(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0951), str);
            } else {
                string = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f06dc);
            }
            this.d.G(string, ii.g(this.a.getContext(), R.dimen.tbds156));
            this.d.g();
            this.d.N(ii.g(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
