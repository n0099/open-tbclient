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
import c.a.d.f.p.n;
import c.a.s0.e1.o0;
import c.a.s0.s.j0.t.c;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.t0.u0.i.c.b> f42593b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.u0.i.a f42594c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f42595d;

    /* renamed from: e  reason: collision with root package name */
    public String f42596e;

    /* renamed from: f  reason: collision with root package name */
    public long f42597f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f42598g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f42599h;

    /* loaded from: classes12.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f42600b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f42601c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f42602d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f42603e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f42604f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f42605g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f42606h;

        /* renamed from: i  reason: collision with root package name */
        public c f42607i;

        /* renamed from: j  reason: collision with root package name */
        public TbPageContext f42608j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes12.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.t0.u0.i.c.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f42609b;

            public a(RankListViewHolder rankListViewHolder, c.a.t0.u0.i.c.b bVar) {
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
                this.f42609b = rankListViewHolder;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f42609b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f42609b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        statisticItem.param("obj_type", this.a.f24062f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f24062f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f42609b.l);
                    statisticItem2.param("fid", this.f42609b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    statisticItem2.param("obj_type", this.a.f24062f.getIsLike() ? 2 : 1);
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
            this.f42608j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f42600b = headImageView;
            headImageView.setIsRound(true);
            this.f42600b.setPlaceHolder(1);
            this.f42600b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f42601c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f42602d = (TextView) view.findViewById(R.id.user_name);
            this.f42603e = (TextView) view.findViewById(R.id.user_intro);
            this.f42604f = (ImageView) view.findViewById(R.id.grade);
            this.f42605g = (TextView) view.findViewById(R.id.user_influence);
            this.f42606h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(c.a.t0.u0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.f42608j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(bVar.a);
                if (this.n == 1) {
                    dimension = (int) this.f42608j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.f42608j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.a, i2);
            this.f42600b.startLoad(bVar.f24058b, 10, false);
            this.f42601c.setData(bVar);
            String str = bVar.f24059c;
            if (o0.d(str) > 12) {
                str = o0.m(str, 10) + "...";
            }
            this.f42602d.setText(str);
            boolean z = bVar.f24064h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f42602d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f24060d)) {
                this.f42603e.setVisibility(8);
            } else {
                this.f42603e.setVisibility(0);
                this.f42603e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f24060d, 26));
            }
            if (bVar.f24062f.getLevel_id() == 0) {
                this.f42604f.setVisibility(8);
            } else {
                this.f42604f.setVisibility(0);
                SkinManager.setImageResource(this.f42604f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f24062f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f24061e)) {
                this.f42605g.setVisibility(8);
            } else {
                this.f42605g.setVisibility(0);
                this.f42605g.setText(bVar.f24061e);
            }
            if (this.f42607i == null && (tbPageContext = this.f42608j) != null) {
                c cVar = new c(tbPageContext, this.f42606h);
                this.f42607i = cVar;
                cVar.l(this.f42608j.getUniqueId());
            }
            this.f42607i.n(bVar.f24062f);
            this.f42606h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f24062f;
            if (metaData != null && metaData.getUserId() != null && bVar.f24062f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f42606h.setVisibility(8);
            } else {
                this.f42606h.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public final TbPageContext c(Context context) {
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

        public void hideIntroAndLikeButton() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f42603e.setVisibility(8);
                this.f42606h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f42602d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f42602d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f42603e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f42605g, R.color.CAM_X0109);
            this.f42606h.onChangeSkinType(this.k);
        }

        public void setCategory(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.l = str;
            }
        }

        public void setForumId(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.m = j2;
            }
        }

        public void setViewHolderType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.n = i2;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f42610e;

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
            this.f42610e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            c.a.t0.u0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = (c.a.t0.u0.i.c.b) this.f42610e.f42593b.get(i2)) == null || bVar.f24062f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f42610e.a.getContext(), bVar.f24062f.getUserId(), bVar.f24062f.getName_show())));
            if (!TextUtils.isEmpty(this.f42610e.f42596e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f42610e.f42596e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f24062f.getUserId());
            statisticItem2.param("fid", this.f42610e.f42597f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.bindData((c.a.t0.u0.i.c.b) this.a.f42593b.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
                rankListViewHolder.setViewHolderType(0);
                rankListViewHolder.setCategory(this.a.f42596e);
                rankListViewHolder.setForumId(this.a.f42597f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f42593b.size() : invokeV.intValue;
        }
    }

    public RankListViewController(View view, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42593b = new ArrayList();
        this.f42598g = new a(this);
        this.f42599h = new b(this);
        this.f42596e = str;
        this.f42597f = j2;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.a.setAdapter(this.f42599h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f42594c = new c.a.t0.u0.i.a(inflate, this.f42596e, this.f42597f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f42595d = pbListView;
        pbListView.a();
        this.f42595d.p(R.color.CAM_X0205);
        this.f42595d.y();
        this.f42595d.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f42595d.H(R.dimen.tbfontsize33);
        this.f42595d.B(R.color.CAM_X0110);
        this.a.setNextPage(this.f42595d);
        this.a.setOnItemClickListener(this.f42598g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f42594c.j(i2);
            this.f42599h.notifyDataSetChanged();
            PbListView pbListView = this.f42595d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f42595d.d(i2);
            }
        }
    }

    public void f(c.a.t0.u0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f42594c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.t0.u0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f42593b.clear();
        this.f42593b.addAll(list);
        this.f42599h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42595d.K();
            this.f42595d.R();
            this.f42595d.D(this.a.getContext().getString(R.string.list_loading));
            this.f42595d.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f42595d.Q(n.f(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f42595d.E(string, n.f(this.a.getContext(), R.dimen.tbds156));
            this.f42595d.f();
            this.f42595d.M(n.f(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
