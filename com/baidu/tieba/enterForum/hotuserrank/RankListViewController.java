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
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.f0.t.c;
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
/* loaded from: classes7.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f50267a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.r0.o0.i.c.b> f50268b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.o0.i.a f50269c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f50270d;

    /* renamed from: e  reason: collision with root package name */
    public String f50271e;

    /* renamed from: f  reason: collision with root package name */
    public long f50272f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f50273g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f50274h;

    /* loaded from: classes7.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50275a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f50276b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f50277c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f50278d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f50279e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f50280f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f50281g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f50282h;

        /* renamed from: i  reason: collision with root package name */
        public c f50283i;

        /* renamed from: j  reason: collision with root package name */
        public TbPageContext f50284j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes7.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.o0.i.c.b f50285a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f50286b;

            public a(RankListViewHolder rankListViewHolder, c.a.r0.o0.i.c.b bVar) {
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
                this.f50286b = rankListViewHolder;
                this.f50285a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f50286b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f50286b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f50285a.f22820a);
                        statisticItem.param("obj_type", this.f50285a.f22825f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.f50285a.f22825f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f50286b.l);
                    statisticItem2.param("fid", this.f50286b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f50285a.f22820a);
                    statisticItem2.param("obj_type", this.f50285a.f22825f.getIsLike() ? 2 : 1);
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
            this.f50284j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.f50275a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f50276b = headImageView;
            headImageView.setIsRound(true);
            this.f50276b.setPlaceHolder(1);
            this.f50276b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f50277c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f50278d = (TextView) view.findViewById(R.id.user_name);
            this.f50279e = (TextView) view.findViewById(R.id.user_intro);
            this.f50280f = (ImageView) view.findViewById(R.id.grade);
            this.f50281g = (TextView) view.findViewById(R.id.user_influence);
            this.f50282h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(c.a.r0.o0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f22820a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50275a.getLayoutParams();
                int dimension = (int) this.f50284j.getResources().getDimension(R.dimen.tbds44);
                this.f50275a.setText(bVar.f22820a);
                if (this.n == 1) {
                    dimension = (int) this.f50284j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.f50284j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f50275a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f50275a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f50275a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f50275a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f50275a, i2);
            this.f50276b.startLoad(bVar.f22821b, 10, false);
            this.f50277c.setData(bVar);
            String str = bVar.f22822c;
            if (m0.d(str) > 12) {
                str = m0.m(str, 10) + "...";
            }
            this.f50278d.setText(str);
            boolean z = bVar.f22827h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f50278d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f22823d)) {
                this.f50279e.setVisibility(8);
            } else {
                this.f50279e.setVisibility(0);
                this.f50279e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f22823d, 26));
            }
            if (bVar.f22825f.getLevel_id() == 0) {
                this.f50280f.setVisibility(8);
            } else {
                this.f50280f.setVisibility(0);
                SkinManager.setImageResource(this.f50280f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f22825f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f22824e)) {
                this.f50281g.setVisibility(8);
            } else {
                this.f50281g.setVisibility(0);
                this.f50281g.setText(bVar.f22824e);
            }
            if (this.f50283i == null && (tbPageContext = this.f50284j) != null) {
                c cVar = new c(tbPageContext, this.f50282h);
                this.f50283i = cVar;
                cVar.l(this.f50284j.getUniqueId());
            }
            this.f50283i.n(bVar.f22825f);
            this.f50282h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f22825f;
            if (metaData != null && metaData.getUserId() != null && bVar.f22825f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f50282h.setVisibility(8);
            } else {
                this.f50282h.setVisibility(0);
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
                this.f50279e.setVisibility(8);
                this.f50282h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f50278d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f50278d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f50279e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50281g, R.color.CAM_X0109);
            this.f50282h.onChangeSkinType(this.k);
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

    /* loaded from: classes7.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f50287e;

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
            this.f50287e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            c.a.r0.o0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = (c.a.r0.o0.i.c.b) this.f50287e.f50268b.get(i2)) == null || bVar.f22825f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f50287e.f50267a.getContext(), bVar.f22825f.getUserId(), bVar.f22825f.getName_show())));
            if (!TextUtils.isEmpty(this.f50287e.f50271e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f50287e.f50271e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f22820a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f22825f.getUserId());
            statisticItem2.param("fid", this.f50287e.f50272f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f50288a;

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
            this.f50288a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.bindData((c.a.r0.o0.i.c.b) this.f50288a.f50268b.get(i2));
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
                rankListViewHolder.setCategory(this.f50288a.f50271e);
                rankListViewHolder.setForumId(this.f50288a.f50272f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50288a.f50268b.size() : invokeV.intValue;
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
        this.f50268b = new ArrayList();
        this.f50273g = new a(this);
        this.f50274h = new b(this);
        this.f50271e = str;
        this.f50272f = j2;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f50267a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f50267a.setAdapter(this.f50274h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f50269c = new c.a.r0.o0.i.a(inflate, this.f50271e, this.f50272f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f50267a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f50270d = pbListView;
        pbListView.a();
        this.f50270d.o(R.color.CAM_X0205);
        this.f50270d.v();
        this.f50270d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f50270d.E(R.dimen.tbfontsize33);
        this.f50270d.y(R.color.CAM_X0110);
        this.f50267a.setNextPage(this.f50270d);
        this.f50267a.setOnItemClickListener(this.f50273g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f50269c.j(i2);
            this.f50274h.notifyDataSetChanged();
            PbListView pbListView = this.f50270d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f50270d.d(i2);
            }
        }
    }

    public void f(c.a.r0.o0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f50269c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f50267a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.r0.o0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f50268b.clear();
        this.f50268b.addAll(list);
        this.f50274h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f50270d.H();
            this.f50270d.O();
            this.f50270d.A(this.f50267a.getContext().getString(R.string.list_loading));
            this.f50270d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f50270d.N(l.g(this.f50267a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.f50267a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.f50267a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f50270d.B(string, l.g(this.f50267a.getContext(), R.dimen.tbds156));
            this.f50270d.f();
            this.f50270d.J(l.g(this.f50267a.getContext(), R.dimen.tbds44));
        }
    }
}
