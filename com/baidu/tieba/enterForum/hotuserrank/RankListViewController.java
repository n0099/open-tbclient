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
import c.a.d.f.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.g0.t.c;
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
/* loaded from: classes10.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.r0.u0.i.c.b> f43533b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.u0.i.a f43534c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f43535d;

    /* renamed from: e  reason: collision with root package name */
    public String f43536e;

    /* renamed from: f  reason: collision with root package name */
    public long f43537f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f43538g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f43539h;

    /* loaded from: classes10.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f43540b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f43541c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f43542d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f43543e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f43544f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f43545g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f43546h;

        /* renamed from: i  reason: collision with root package name */
        public c f43547i;

        /* renamed from: j  reason: collision with root package name */
        public TbPageContext f43548j;

        /* renamed from: k  reason: collision with root package name */
        public int f43549k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes10.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.r0.u0.i.c.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f43550b;

            public a(RankListViewHolder rankListViewHolder, c.a.r0.u0.i.c.b bVar) {
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
                this.f43550b = rankListViewHolder;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f43550b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f43550b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        statisticItem.param("obj_type", this.a.f24216f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f24216f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f43550b.l);
                    statisticItem2.param("fid", this.f43550b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    statisticItem2.param("obj_type", this.a.f24216f.getIsLike() ? 2 : 1);
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
            this.f43549k = 3;
            this.l = "";
            this.n = 0;
            this.f43548j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f43540b = headImageView;
            headImageView.setIsRound(true);
            this.f43540b.setPlaceHolder(1);
            this.f43540b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f43541c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f43542d = (TextView) view.findViewById(R.id.user_name);
            this.f43543e = (TextView) view.findViewById(R.id.user_intro);
            this.f43544f = (ImageView) view.findViewById(R.id.grade);
            this.f43545g = (TextView) view.findViewById(R.id.user_influence);
            this.f43546h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(c.a.r0.u0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.f43548j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(bVar.a);
                if (this.n == 1) {
                    dimension = (int) this.f43548j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.f43548j.getResources().getDimension(R.dimen.tbds129);
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
            this.f43540b.startLoad(bVar.f24212b, 10, false);
            this.f43541c.setData(bVar);
            String str = bVar.f24213c;
            if (m0.d(str) > 12) {
                str = m0.m(str, 10) + "...";
            }
            this.f43542d.setText(str);
            boolean z = bVar.f24218h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f43542d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f24214d)) {
                this.f43543e.setVisibility(8);
            } else {
                this.f43543e.setVisibility(0);
                this.f43543e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f24214d, 26));
            }
            if (bVar.f24216f.getLevel_id() == 0) {
                this.f43544f.setVisibility(8);
            } else {
                this.f43544f.setVisibility(0);
                SkinManager.setImageResource(this.f43544f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f24216f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f24215e)) {
                this.f43545g.setVisibility(8);
            } else {
                this.f43545g.setVisibility(0);
                this.f43545g.setText(bVar.f24215e);
            }
            if (this.f43547i == null && (tbPageContext = this.f43548j) != null) {
                c cVar = new c(tbPageContext, this.f43546h);
                this.f43547i = cVar;
                cVar.l(this.f43548j.getUniqueId());
            }
            this.f43547i.n(bVar.f24216f);
            this.f43546h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f24216f;
            if (metaData != null && metaData.getUserId() != null && bVar.f24216f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f43546h.setVisibility(8);
            } else {
                this.f43546h.setVisibility(0);
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
                this.f43543e.setVisibility(8);
                this.f43546h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f43549k == i2) {
                return;
            }
            this.f43549k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f43542d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f43542d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f43543e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f43545g, R.color.CAM_X0109);
            this.f43546h.onChangeSkinType(this.f43549k);
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

    /* loaded from: classes10.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f43551e;

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
            this.f43551e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            c.a.r0.u0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = (c.a.r0.u0.i.c.b) this.f43551e.f43533b.get(i2)) == null || bVar.f24216f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f43551e.a.getContext(), bVar.f24216f.getUserId(), bVar.f24216f.getName_show())));
            if (!TextUtils.isEmpty(this.f43551e.f43536e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f43551e.f43536e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f24216f.getUserId());
            statisticItem2.param("fid", this.f43551e.f43537f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes10.dex */
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
                rankListViewHolder.bindData((c.a.r0.u0.i.c.b) this.a.f43533b.get(i2));
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
                rankListViewHolder.setCategory(this.a.f43536e);
                rankListViewHolder.setForumId(this.a.f43537f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f43533b.size() : invokeV.intValue;
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
        this.f43533b = new ArrayList();
        this.f43538g = new a(this);
        this.f43539h = new b(this);
        this.f43536e = str;
        this.f43537f = j2;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.a.setAdapter(this.f43539h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f43534c = new c.a.r0.u0.i.a(inflate, this.f43536e, this.f43537f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f43535d = pbListView;
        pbListView.a();
        this.f43535d.p(R.color.CAM_X0205);
        this.f43535d.x();
        this.f43535d.E(SkinManager.getColor(R.color.CAM_X0107));
        this.f43535d.G(R.dimen.tbfontsize33);
        this.f43535d.A(R.color.CAM_X0110);
        this.a.setNextPage(this.f43535d);
        this.a.setOnItemClickListener(this.f43538g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f43534c.j(i2);
            this.f43539h.notifyDataSetChanged();
            PbListView pbListView = this.f43535d;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f43535d.d(i2);
            }
        }
    }

    public void f(c.a.r0.u0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f43534c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.r0.u0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f43533b.clear();
        this.f43533b.addAll(list);
        this.f43539h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f43535d.J();
            this.f43535d.Q();
            this.f43535d.C(this.a.getContext().getString(R.string.list_loading));
            this.f43535d.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f43535d.P(l.f(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f43535d.D(string, l.f(this.a.getContext(), R.dimen.tbds156));
            this.f43535d.f();
            this.f43535d.L(l.f(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
