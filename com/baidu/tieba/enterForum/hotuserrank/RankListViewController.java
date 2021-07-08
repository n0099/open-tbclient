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
import d.a.c.e.p.l;
import d.a.o0.r.f0.t.c;
import d.a.o0.z0.j0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f14725a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.p0.l0.i.c.b> f14726b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.l0.i.a f14727c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f14728d;

    /* renamed from: e  reason: collision with root package name */
    public String f14729e;

    /* renamed from: f  reason: collision with root package name */
    public long f14730f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f14731g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f14732h;

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f14733a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f14734b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f14735c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14736d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14737e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14738f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14739g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f14740h;

        /* renamed from: i  reason: collision with root package name */
        public c f14741i;
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
            public final /* synthetic */ d.a.p0.l0.i.c.b f14742a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f14743b;

            public a(RankListViewHolder rankListViewHolder, d.a.p0.l0.i.c.b bVar) {
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
                this.f14743b = rankListViewHolder;
                this.f14742a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f14743b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f14743b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f14742a.f59673a);
                        statisticItem.param("obj_type", this.f14742a.f59678f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.f14742a.f59678f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f14743b.l);
                    statisticItem2.param("fid", this.f14743b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f14742a.f59673a);
                    statisticItem2.param("obj_type", this.f14742a.f59678f.getIsLike() ? 2 : 1);
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
            this.f14733a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f14734b = headImageView;
            headImageView.setIsRound(true);
            this.f14734b.setPlaceHolder(1);
            this.f14734b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14735c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f14736d = (TextView) view.findViewById(R.id.user_name);
            this.f14737e = (TextView) view.findViewById(R.id.user_intro);
            this.f14738f = (ImageView) view.findViewById(R.id.grade);
            this.f14739g = (TextView) view.findViewById(R.id.user_influence);
            this.f14740h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.a.p0.l0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f59673a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14733a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f14733a.setText(bVar.f59673a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f14733a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f14733a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f14733a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f14733a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f14733a, i2);
            this.f14734b.M(bVar.f59674b, 10, false);
            this.f14735c.setData(bVar);
            String str = bVar.f59675c;
            if (j0.d(str) > 12) {
                str = j0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f14736d.setText(str);
            boolean z = bVar.f59680h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f14736d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f59676d)) {
                this.f14737e.setVisibility(8);
            } else {
                this.f14737e.setVisibility(0);
                this.f14737e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f59676d, 26));
            }
            if (bVar.f59678f.getLevel_id() == 0) {
                this.f14738f.setVisibility(8);
            } else {
                this.f14738f.setVisibility(0);
                SkinManager.setImageResource(this.f14738f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f59678f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f59677e)) {
                this.f14739g.setVisibility(8);
            } else {
                this.f14739g.setVisibility(0);
                this.f14739g.setText(bVar.f59677e);
            }
            if (this.f14741i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f14740h);
                this.f14741i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f14741i.n(bVar.f59678f);
            this.f14740h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f59678f;
            if (metaData != null && metaData.getUserId() != null && bVar.f59678f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f14740h.setVisibility(8);
            } else {
                this.f14740h.setVisibility(0);
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
                this.f14737e.setVisibility(8);
                this.f14740h.setVisibility(8);
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f14736d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f14736d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f14737e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14739g, R.color.CAM_X0109);
            this.f14740h.r(this.k);
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
        public final /* synthetic */ RankListViewController f14744e;

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
            this.f14744e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            d.a.p0.l0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (bVar = (d.a.p0.l0.i.c.b) this.f14744e.f14726b.get(i2)) == null || bVar.f59678f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f14744e.f14725a.getContext(), bVar.f59678f.getUserId(), bVar.f59678f.getName_show())));
            if (!TextUtils.isEmpty(this.f14744e.f14729e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f14744e.f14729e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f59673a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f59678f.getUserId());
            statisticItem2.param("fid", this.f14744e.f14730f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f14745a;

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
            this.f14745a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.c((d.a.p0.l0.i.c.b) this.f14745a.f14726b.get(i2));
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
                rankListViewHolder.g(this.f14745a.f14729e);
                rankListViewHolder.h(this.f14745a.f14730f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14745a.f14726b.size() : invokeV.intValue;
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
        this.f14726b = new ArrayList();
        this.f14731g = new a(this);
        this.f14732h = new b(this);
        this.f14729e = str;
        this.f14730f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f14725a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f14725a.setAdapter(this.f14732h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f14727c = new d.a.p0.l0.i.a(inflate, this.f14729e, this.f14730f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f14725a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f14728d = pbListView;
        pbListView.a();
        this.f14728d.o(R.color.CAM_X0205);
        this.f14728d.v();
        this.f14728d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f14728d.E(R.dimen.tbfontsize33);
        this.f14728d.y(R.color.CAM_X0110);
        this.f14725a.setNextPage(this.f14728d);
        this.f14725a.setOnItemClickListener(this.f14731g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f14727c.j(i2);
            this.f14732h.notifyDataSetChanged();
            PbListView pbListView = this.f14728d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f14728d.d(i2);
            }
        }
    }

    public void f(d.a.p0.l0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f14727c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f14725a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<d.a.p0.l0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f14726b.clear();
        this.f14726b.addAll(list);
        this.f14732h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14728d.H();
            this.f14728d.O();
            this.f14728d.A(this.f14725a.getContext().getString(R.string.list_loading));
            this.f14728d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f14728d.N(l.g(this.f14725a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.f14725a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.f14725a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f14728d.B(string, l.g(this.f14725a.getContext(), R.dimen.tbds156));
            this.f14728d.f();
            this.f14728d.J(l.g(this.f14725a.getContext(), R.dimen.tbds44));
        }
    }
}
