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
import b.a.e.e.p.l;
import b.a.q0.d1.m0;
import b.a.q0.s.g0.t.c;
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
/* loaded from: classes9.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f47663a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.r0.o0.i.c.b> f47664b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.o0.i.a f47665c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f47666d;

    /* renamed from: e  reason: collision with root package name */
    public String f47667e;

    /* renamed from: f  reason: collision with root package name */
    public long f47668f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f47669g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f47670h;

    /* loaded from: classes9.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f47671a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f47672b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f47673c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f47674d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f47675e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f47676f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f47677g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f47678h;

        /* renamed from: i  reason: collision with root package name */
        public c f47679i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes9.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.o0.i.c.b f47680a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f47681b;

            public a(RankListViewHolder rankListViewHolder, b.a.r0.o0.i.c.b bVar) {
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
                this.f47681b = rankListViewHolder;
                this.f47680a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f47681b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f47681b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f47680a.f21691a);
                        statisticItem.param("obj_type", this.f47680a.f21696f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.f47680a.f21696f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f47681b.l);
                    statisticItem2.param("fid", this.f47681b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f47680a.f21691a);
                    statisticItem2.param("obj_type", this.f47680a.f21696f.getIsLike() ? 2 : 1);
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
            this.j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.f47671a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f47672b = headImageView;
            headImageView.setIsRound(true);
            this.f47672b.setPlaceHolder(1);
            this.f47672b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f47673c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f47674d = (TextView) view.findViewById(R.id.user_name);
            this.f47675e = (TextView) view.findViewById(R.id.user_intro);
            this.f47676f = (ImageView) view.findViewById(R.id.grade);
            this.f47677g = (TextView) view.findViewById(R.id.user_influence);
            this.f47678h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(b.a.r0.o0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f21691a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f47671a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f47671a.setText(bVar.f21691a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f47671a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f47671a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f47671a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f47671a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f47671a, i2);
            this.f47672b.startLoad(bVar.f21692b, 10, false);
            this.f47673c.setData(bVar);
            String str = bVar.f21693c;
            if (m0.d(str) > 12) {
                str = m0.m(str, 10) + "...";
            }
            this.f47674d.setText(str);
            boolean z = bVar.f21698h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f47674d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f21694d)) {
                this.f47675e.setVisibility(8);
            } else {
                this.f47675e.setVisibility(0);
                this.f47675e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f21694d, 26));
            }
            if (bVar.f21696f.getLevel_id() == 0) {
                this.f47676f.setVisibility(8);
            } else {
                this.f47676f.setVisibility(0);
                SkinManager.setImageResource(this.f47676f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f21696f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f21695e)) {
                this.f47677g.setVisibility(8);
            } else {
                this.f47677g.setVisibility(0);
                this.f47677g.setText(bVar.f21695e);
            }
            if (this.f47679i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f47678h);
                this.f47679i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f47679i.n(bVar.f21696f);
            this.f47678h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f21696f;
            if (metaData != null && metaData.getUserId() != null && bVar.f21696f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f47678h.setVisibility(8);
            } else {
                this.f47678h.setVisibility(0);
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
                this.f47675e.setVisibility(8);
                this.f47678h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f47674d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f47674d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f47675e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f47677g, R.color.CAM_X0109);
            this.f47678h.onChangeSkinType(this.k);
        }

        public void setCategory(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.l = str;
            }
        }

        public void setForumId(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.m = j;
            }
        }

        public void setViewHolderType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.n = i2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f47682e;

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
            this.f47682e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            b.a.r0.o0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (bVar = (b.a.r0.o0.i.c.b) this.f47682e.f47664b.get(i2)) == null || bVar.f21696f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f47682e.f47663a.getContext(), bVar.f21696f.getUserId(), bVar.f21696f.getName_show())));
            if (!TextUtils.isEmpty(this.f47682e.f47667e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f47682e.f47667e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f21691a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f21696f.getUserId());
            statisticItem2.param("fid", this.f47682e.f47668f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f47683a;

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
            this.f47683a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.bindData((b.a.r0.o0.i.c.b) this.f47683a.f47664b.get(i2));
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
                rankListViewHolder.setCategory(this.f47683a.f47667e);
                rankListViewHolder.setForumId(this.f47683a.f47668f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47683a.f47664b.size() : invokeV.intValue;
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
        this.f47664b = new ArrayList();
        this.f47669g = new a(this);
        this.f47670h = new b(this);
        this.f47667e = str;
        this.f47668f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f47663a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f47663a.setAdapter(this.f47670h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f47665c = new b.a.r0.o0.i.a(inflate, this.f47667e, this.f47668f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f47663a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f47666d = pbListView;
        pbListView.a();
        this.f47666d.p(R.color.CAM_X0205);
        this.f47666d.x();
        this.f47666d.E(SkinManager.getColor(R.color.CAM_X0107));
        this.f47666d.G(R.dimen.tbfontsize33);
        this.f47666d.A(R.color.CAM_X0110);
        this.f47663a.setNextPage(this.f47666d);
        this.f47663a.setOnItemClickListener(this.f47669g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f47665c.j(i2);
            this.f47670h.notifyDataSetChanged();
            PbListView pbListView = this.f47666d;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f47666d.d(i2);
            }
        }
    }

    public void f(b.a.r0.o0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f47665c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f47663a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<b.a.r0.o0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f47664b.clear();
        this.f47664b.addAll(list);
        this.f47670h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47666d.J();
            this.f47666d.Q();
            this.f47666d.C(this.f47663a.getContext().getString(R.string.list_loading));
            this.f47666d.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f47666d.P(l.g(this.f47663a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.f47663a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.f47663a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f47666d.D(string, l.g(this.f47663a.getContext(), R.dimen.tbds156));
            this.f47666d.f();
            this.f47666d.L(l.g(this.f47663a.getContext(), R.dimen.tbds44));
        }
    }
}
