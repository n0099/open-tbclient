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
import c.a.s0.d1.o0;
import c.a.s0.s.k0.t.c;
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
    public List<c.a.t0.v0.i.c.b> f42614b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.v0.i.a f42615c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f42616d;

    /* renamed from: e  reason: collision with root package name */
    public String f42617e;

    /* renamed from: f  reason: collision with root package name */
    public long f42618f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f42619g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f42620h;

    /* loaded from: classes12.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f42621b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f42622c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f42623d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f42624e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f42625f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f42626g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f42627h;

        /* renamed from: i  reason: collision with root package name */
        public c f42628i;

        /* renamed from: j  reason: collision with root package name */
        public TbPageContext f42629j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes12.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.t0.v0.i.c.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f42630b;

            public a(RankListViewHolder rankListViewHolder, c.a.t0.v0.i.c.b bVar) {
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
                this.f42630b = rankListViewHolder;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f42630b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f42630b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        statisticItem.param("obj_type", this.a.f24351f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f24351f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f42630b.l);
                    statisticItem2.param("fid", this.f42630b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    statisticItem2.param("obj_type", this.a.f24351f.getIsLike() ? 2 : 1);
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
            this.f42629j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f42621b = headImageView;
            headImageView.setIsRound(true);
            this.f42621b.setPlaceHolder(1);
            this.f42621b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f42622c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f42623d = (TextView) view.findViewById(R.id.user_name);
            this.f42624e = (TextView) view.findViewById(R.id.user_intro);
            this.f42625f = (ImageView) view.findViewById(R.id.grade);
            this.f42626g = (TextView) view.findViewById(R.id.user_influence);
            this.f42627h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(c.a.t0.v0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.f42629j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(bVar.a);
                if (this.n == 1) {
                    dimension = (int) this.f42629j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.f42629j.getResources().getDimension(R.dimen.tbds129);
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
            this.f42621b.startLoad(bVar.f24347b, 10, false);
            this.f42622c.setData(bVar);
            String str = bVar.f24348c;
            if (o0.d(str) > 12) {
                str = o0.n(str, 10) + "...";
            }
            this.f42623d.setText(str);
            boolean z = bVar.f24353h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f42623d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f24349d)) {
                this.f42624e.setVisibility(8);
            } else {
                this.f42624e.setVisibility(0);
                this.f42624e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f24349d, 26));
            }
            if (bVar.f24351f.getLevel_id() == 0) {
                this.f42625f.setVisibility(8);
            } else {
                this.f42625f.setVisibility(0);
                SkinManager.setImageResource(this.f42625f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f24351f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f24350e)) {
                this.f42626g.setVisibility(8);
            } else {
                this.f42626g.setVisibility(0);
                this.f42626g.setText(bVar.f24350e);
            }
            if (this.f42628i == null && (tbPageContext = this.f42629j) != null) {
                c cVar = new c(tbPageContext, this.f42627h);
                this.f42628i = cVar;
                cVar.l(this.f42629j.getUniqueId());
            }
            this.f42628i.n(bVar.f24351f);
            this.f42627h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f24351f;
            if (metaData != null && metaData.getUserId() != null && bVar.f24351f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f42627h.setVisibility(8);
            } else {
                this.f42627h.setVisibility(0);
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
                this.f42624e.setVisibility(8);
                this.f42627h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f42623d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f42623d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f42624e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f42626g, R.color.CAM_X0109);
            this.f42627h.onChangeSkinType(this.k);
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
        public final /* synthetic */ RankListViewController f42631e;

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
            this.f42631e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            c.a.t0.v0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = (c.a.t0.v0.i.c.b) this.f42631e.f42614b.get(i2)) == null || bVar.f24351f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f42631e.a.getContext(), bVar.f24351f.getUserId(), bVar.f24351f.getName_show())));
            if (!TextUtils.isEmpty(this.f42631e.f42617e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f42631e.f42617e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f24351f.getUserId());
            statisticItem2.param("fid", this.f42631e.f42618f);
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
                rankListViewHolder.bindData((c.a.t0.v0.i.c.b) this.a.f42614b.get(i2));
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
                rankListViewHolder.setCategory(this.a.f42617e);
                rankListViewHolder.setForumId(this.a.f42618f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f42614b.size() : invokeV.intValue;
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
        this.f42614b = new ArrayList();
        this.f42619g = new a(this);
        this.f42620h = new b(this);
        this.f42617e = str;
        this.f42618f = j2;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.a.setAdapter(this.f42620h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f42615c = new c.a.t0.v0.i.a(inflate, this.f42617e, this.f42618f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f42616d = pbListView;
        pbListView.a();
        this.f42616d.p(R.color.CAM_X0205);
        this.f42616d.y();
        this.f42616d.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f42616d.H(R.dimen.tbfontsize33);
        this.f42616d.B(R.color.CAM_X0110);
        this.a.setNextPage(this.f42616d);
        this.a.setOnItemClickListener(this.f42619g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f42615c.j(i2);
            this.f42620h.notifyDataSetChanged();
            PbListView pbListView = this.f42616d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f42616d.d(i2);
            }
        }
    }

    public void f(c.a.t0.v0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f42615c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.t0.v0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f42614b.clear();
        this.f42614b.addAll(list);
        this.f42620h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42616d.K();
            this.f42616d.R();
            this.f42616d.D(this.a.getContext().getString(R.string.list_loading));
            this.f42616d.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f42616d.Q(n.f(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f42616d.E(string, n.f(this.a.getContext(), R.dimen.tbds156));
            this.f42616d.f();
            this.f42616d.M(n.f(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
