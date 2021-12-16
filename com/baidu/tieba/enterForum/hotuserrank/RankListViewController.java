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
import c.a.d.f.p.m;
import c.a.r0.d1.o0;
import c.a.r0.s.i0.t.c;
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
    public List<c.a.s0.u0.i.c.b> f44024b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.u0.i.a f44025c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f44026d;

    /* renamed from: e  reason: collision with root package name */
    public String f44027e;

    /* renamed from: f  reason: collision with root package name */
    public long f44028f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f44029g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f44030h;

    /* loaded from: classes12.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f44031b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f44032c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f44033d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f44034e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f44035f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f44036g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f44037h;

        /* renamed from: i  reason: collision with root package name */
        public c f44038i;

        /* renamed from: j  reason: collision with root package name */
        public TbPageContext f44039j;

        /* renamed from: k  reason: collision with root package name */
        public int f44040k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes12.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.s0.u0.i.c.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f44041b;

            public a(RankListViewHolder rankListViewHolder, c.a.s0.u0.i.c.b bVar) {
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
                this.f44041b = rankListViewHolder;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f44041b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f44041b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        statisticItem.param("obj_type", this.a.f24229f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f24229f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f44041b.l);
                    statisticItem2.param("fid", this.f44041b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    statisticItem2.param("obj_type", this.a.f24229f.getIsLike() ? 2 : 1);
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
            this.f44040k = 3;
            this.l = "";
            this.n = 0;
            this.f44039j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f44031b = headImageView;
            headImageView.setIsRound(true);
            this.f44031b.setPlaceHolder(1);
            this.f44031b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f44032c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f44033d = (TextView) view.findViewById(R.id.user_name);
            this.f44034e = (TextView) view.findViewById(R.id.user_intro);
            this.f44035f = (ImageView) view.findViewById(R.id.grade);
            this.f44036g = (TextView) view.findViewById(R.id.user_influence);
            this.f44037h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(c.a.s0.u0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.f44039j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(bVar.a);
                if (this.n == 1) {
                    dimension = (int) this.f44039j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.f44039j.getResources().getDimension(R.dimen.tbds129);
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
            this.f44031b.startLoad(bVar.f24225b, 10, false);
            this.f44032c.setData(bVar);
            String str = bVar.f24226c;
            if (o0.d(str) > 12) {
                str = o0.m(str, 10) + "...";
            }
            this.f44033d.setText(str);
            boolean z = bVar.f24231h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f44033d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f24227d)) {
                this.f44034e.setVisibility(8);
            } else {
                this.f44034e.setVisibility(0);
                this.f44034e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f24227d, 26));
            }
            if (bVar.f24229f.getLevel_id() == 0) {
                this.f44035f.setVisibility(8);
            } else {
                this.f44035f.setVisibility(0);
                SkinManager.setImageResource(this.f44035f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f24229f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f24228e)) {
                this.f44036g.setVisibility(8);
            } else {
                this.f44036g.setVisibility(0);
                this.f44036g.setText(bVar.f24228e);
            }
            if (this.f44038i == null && (tbPageContext = this.f44039j) != null) {
                c cVar = new c(tbPageContext, this.f44037h);
                this.f44038i = cVar;
                cVar.l(this.f44039j.getUniqueId());
            }
            this.f44038i.n(bVar.f24229f);
            this.f44037h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f24229f;
            if (metaData != null && metaData.getUserId() != null && bVar.f24229f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f44037h.setVisibility(8);
            } else {
                this.f44037h.setVisibility(0);
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
                this.f44034e.setVisibility(8);
                this.f44037h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f44040k == i2) {
                return;
            }
            this.f44040k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f44033d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f44033d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f44034e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f44036g, R.color.CAM_X0109);
            this.f44037h.onChangeSkinType(this.f44040k);
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
        public final /* synthetic */ RankListViewController f44042e;

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
            this.f44042e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            c.a.s0.u0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = (c.a.s0.u0.i.c.b) this.f44042e.f44024b.get(i2)) == null || bVar.f24229f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f44042e.a.getContext(), bVar.f24229f.getUserId(), bVar.f24229f.getName_show())));
            if (!TextUtils.isEmpty(this.f44042e.f44027e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f44042e.f44027e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f24229f.getUserId());
            statisticItem2.param("fid", this.f44042e.f44028f);
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
                rankListViewHolder.bindData((c.a.s0.u0.i.c.b) this.a.f44024b.get(i2));
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
                rankListViewHolder.setCategory(this.a.f44027e);
                rankListViewHolder.setForumId(this.a.f44028f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f44024b.size() : invokeV.intValue;
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
        this.f44024b = new ArrayList();
        this.f44029g = new a(this);
        this.f44030h = new b(this);
        this.f44027e = str;
        this.f44028f = j2;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.a.setAdapter(this.f44030h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f44025c = new c.a.s0.u0.i.a(inflate, this.f44027e, this.f44028f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f44026d = pbListView;
        pbListView.a();
        this.f44026d.p(R.color.CAM_X0205);
        this.f44026d.y();
        this.f44026d.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f44026d.H(R.dimen.tbfontsize33);
        this.f44026d.B(R.color.CAM_X0110);
        this.a.setNextPage(this.f44026d);
        this.a.setOnItemClickListener(this.f44029g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f44025c.j(i2);
            this.f44030h.notifyDataSetChanged();
            PbListView pbListView = this.f44026d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f44026d.d(i2);
            }
        }
    }

    public void f(c.a.s0.u0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f44025c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.s0.u0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f44024b.clear();
        this.f44024b.addAll(list);
        this.f44030h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f44026d.K();
            this.f44026d.R();
            this.f44026d.D(this.a.getContext().getString(R.string.list_loading));
            this.f44026d.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f44026d.Q(m.f(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f44026d.E(string, m.f(this.a.getContext(), R.dimen.tbds156));
            this.f44026d.f();
            this.f44026d.M(m.f(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
