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
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.b1.j0;
import d.a.p0.s.f0.t.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f14773a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.q0.l0.i.c.b> f14774b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.l0.i.a f14775c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f14776d;

    /* renamed from: e  reason: collision with root package name */
    public String f14777e;

    /* renamed from: f  reason: collision with root package name */
    public long f14778f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f14779g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f14780h;

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f14781a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f14782b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f14783c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14784d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14785e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14786f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14787g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f14788h;

        /* renamed from: i  reason: collision with root package name */
        public c f14789i;
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

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.l0.i.c.b f14790a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f14791b;

            public a(RankListViewHolder rankListViewHolder, d.a.q0.l0.i.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rankListViewHolder, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14791b = rankListViewHolder;
                this.f14790a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f14791b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f14791b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f14790a.f60287a);
                        statisticItem.param("obj_type", this.f14790a.f60292f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.f14790a.f60292f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f14791b.l);
                    statisticItem2.param("fid", this.f14791b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f14790a.f60287a);
                    statisticItem2.param("obj_type", this.f14790a.f60292f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankListViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = 3;
            this.l = "";
            this.n = 0;
            this.j = d(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.f14781a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f14782b = headImageView;
            headImageView.setIsRound(true);
            this.f14782b.setPlaceHolder(1);
            this.f14782b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14783c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f14784d = (TextView) view.findViewById(R.id.user_name);
            this.f14785e = (TextView) view.findViewById(R.id.user_intro);
            this.f14786f = (ImageView) view.findViewById(R.id.grade);
            this.f14787g = (TextView) view.findViewById(R.id.user_influence);
            this.f14788h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.a.q0.l0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f60287a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14781a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f14781a.setText(bVar.f60287a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f14781a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f14781a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f14781a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f14781a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f14781a, i2);
            this.f14782b.M(bVar.f60288b, 10, false);
            this.f14783c.setData(bVar);
            String str = bVar.f60289c;
            if (j0.d(str) > 12) {
                str = j0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f14784d.setText(str);
            boolean z = bVar.f60294h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f14784d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f60290d)) {
                this.f14785e.setVisibility(8);
            } else {
                this.f14785e.setVisibility(0);
                this.f14785e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f60290d, 26));
            }
            if (bVar.f60292f.getLevel_id() == 0) {
                this.f14786f.setVisibility(8);
            } else {
                this.f14786f.setVisibility(0);
                SkinManager.setImageResource(this.f14786f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f60292f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f60291e)) {
                this.f14787g.setVisibility(8);
            } else {
                this.f14787g.setVisibility(0);
                this.f14787g.setText(bVar.f60291e);
            }
            if (this.f14789i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f14788h);
                this.f14789i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f14789i.n(bVar.f60292f);
            this.f14788h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f60292f;
            if (metaData != null && metaData.getUserId() != null && bVar.f60292f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f14788h.setVisibility(8);
            } else {
                this.f14788h.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
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

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f14785e.setVisibility(8);
                this.f14788h.setVisibility(8);
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f14784d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f14784d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f14785e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14787g, R.color.CAM_X0109);
            this.f14788h.r(this.k);
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

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.n = i2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f14792e;

        public a(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14792e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            d.a.q0.l0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (bVar = (d.a.q0.l0.i.c.b) this.f14792e.f14774b.get(i2)) == null || bVar.f60292f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f14792e.f14773a.getContext(), bVar.f60292f.getUserId(), bVar.f60292f.getName_show())));
            if (!TextUtils.isEmpty(this.f14792e.f14777e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f14792e.f14777e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f60287a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f60292f.getUserId());
            statisticItem2.param("fid", this.f14792e.f14778f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f14793a;

        public b(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14793a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.c((d.a.q0.l0.i.c.b) this.f14793a.f14774b.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
                rankListViewHolder.i(0);
                rankListViewHolder.g(this.f14793a.f14777e);
                rankListViewHolder.h(this.f14793a.f14778f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14793a.f14774b.size() : invokeV.intValue;
        }
    }

    public RankListViewController(View view, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14774b = new ArrayList();
        this.f14779g = new a(this);
        this.f14780h = new b(this);
        this.f14777e = str;
        this.f14778f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f14773a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f14773a.setAdapter(this.f14780h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f14775c = new d.a.q0.l0.i.a(inflate, this.f14777e, this.f14778f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f14773a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f14776d = pbListView;
        pbListView.a();
        this.f14776d.o(R.color.CAM_X0205);
        this.f14776d.v();
        this.f14776d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f14776d.E(R.dimen.tbfontsize33);
        this.f14776d.y(R.color.CAM_X0110);
        this.f14773a.setNextPage(this.f14776d);
        this.f14773a.setOnItemClickListener(this.f14779g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f14775c.j(i2);
            this.f14780h.notifyDataSetChanged();
            PbListView pbListView = this.f14776d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f14776d.d(i2);
            }
        }
    }

    public void f(d.a.q0.l0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f14775c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f14773a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<d.a.q0.l0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f14774b.clear();
        this.f14774b.addAll(list);
        this.f14780h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14776d.H();
            this.f14776d.O();
            this.f14776d.A(this.f14773a.getContext().getString(R.string.list_loading));
            this.f14776d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f14776d.N(l.g(this.f14773a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.f14773a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.f14773a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f14776d.B(string, l.g(this.f14773a.getContext(), R.dimen.tbds156));
            this.f14776d.f();
            this.f14776d.J(l.g(this.f14773a.getContext(), R.dimen.tbds44));
        }
    }
}
