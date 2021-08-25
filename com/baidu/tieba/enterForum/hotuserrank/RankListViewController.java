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
import c.a.p0.b1.l0;
import c.a.p0.s.f0.t.c;
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
    public BdRecyclerView f50062a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.q0.m0.i.c.b> f50063b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.m0.i.a f50064c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f50065d;

    /* renamed from: e  reason: collision with root package name */
    public String f50066e;

    /* renamed from: f  reason: collision with root package name */
    public long f50067f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f50068g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f50069h;

    /* loaded from: classes7.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50070a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f50071b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f50072c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f50073d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f50074e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f50075f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f50076g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f50077h;

        /* renamed from: i  reason: collision with root package name */
        public c f50078i;

        /* renamed from: j  reason: collision with root package name */
        public TbPageContext f50079j;
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
            public final /* synthetic */ c.a.q0.m0.i.c.b f50080a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f50081b;

            public a(RankListViewHolder rankListViewHolder, c.a.q0.m0.i.c.b bVar) {
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
                this.f50081b = rankListViewHolder;
                this.f50080a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f50081b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f50081b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f50080a.f22052a);
                        statisticItem.param("obj_type", this.f50080a.f22057f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.f50080a.f22057f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f50081b.l);
                    statisticItem2.param("fid", this.f50081b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f50080a.f22052a);
                    statisticItem2.param("obj_type", this.f50080a.f22057f.getIsLike() ? 2 : 1);
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
            this.f50079j = c(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.f50070a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f50071b = headImageView;
            headImageView.setIsRound(true);
            this.f50071b.setPlaceHolder(1);
            this.f50071b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f50072c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f50073d = (TextView) view.findViewById(R.id.user_name);
            this.f50074e = (TextView) view.findViewById(R.id.user_intro);
            this.f50075f = (ImageView) view.findViewById(R.id.grade);
            this.f50076g = (TextView) view.findViewById(R.id.user_influence);
            this.f50077h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(c.a.q0.m0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f22052a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50070a.getLayoutParams();
                int dimension = (int) this.f50079j.getResources().getDimension(R.dimen.tbds44);
                this.f50070a.setText(bVar.f22052a);
                if (this.n == 1) {
                    dimension = (int) this.f50079j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.f50079j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f50070a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f50070a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f50070a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f50070a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f50070a, i2);
            this.f50071b.startLoad(bVar.f22053b, 10, false);
            this.f50072c.setData(bVar);
            String str = bVar.f22054c;
            if (l0.d(str) > 12) {
                str = l0.m(str, 10) + "...";
            }
            this.f50073d.setText(str);
            boolean z = bVar.f22059h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f50073d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f22055d)) {
                this.f50074e.setVisibility(8);
            } else {
                this.f50074e.setVisibility(0);
                this.f50074e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f22055d, 26));
            }
            if (bVar.f22057f.getLevel_id() == 0) {
                this.f50075f.setVisibility(8);
            } else {
                this.f50075f.setVisibility(0);
                SkinManager.setImageResource(this.f50075f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f22057f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f22056e)) {
                this.f50076g.setVisibility(8);
            } else {
                this.f50076g.setVisibility(0);
                this.f50076g.setText(bVar.f22056e);
            }
            if (this.f50078i == null && (tbPageContext = this.f50079j) != null) {
                c cVar = new c(tbPageContext, this.f50077h);
                this.f50078i = cVar;
                cVar.l(this.f50079j.getUniqueId());
            }
            this.f50078i.n(bVar.f22057f);
            this.f50077h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f22057f;
            if (metaData != null && metaData.getUserId() != null && bVar.f22057f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f50077h.setVisibility(8);
            } else {
                this.f50077h.setVisibility(0);
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
                this.f50074e.setVisibility(8);
                this.f50077h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f50073d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f50073d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f50074e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50076g, R.color.CAM_X0109);
            this.f50077h.onChangeSkinType(this.k);
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
        public final /* synthetic */ RankListViewController f50082e;

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
            this.f50082e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            c.a.q0.m0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = (c.a.q0.m0.i.c.b) this.f50082e.f50063b.get(i2)) == null || bVar.f22057f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f50082e.f50062a.getContext(), bVar.f22057f.getUserId(), bVar.f22057f.getName_show())));
            if (!TextUtils.isEmpty(this.f50082e.f50066e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f50082e.f50066e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f22052a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f22057f.getUserId());
            statisticItem2.param("fid", this.f50082e.f50067f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f50083a;

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
            this.f50083a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.bindData((c.a.q0.m0.i.c.b) this.f50083a.f50063b.get(i2));
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
                rankListViewHolder.setCategory(this.f50083a.f50066e);
                rankListViewHolder.setForumId(this.f50083a.f50067f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50083a.f50063b.size() : invokeV.intValue;
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
        this.f50063b = new ArrayList();
        this.f50068g = new a(this);
        this.f50069h = new b(this);
        this.f50066e = str;
        this.f50067f = j2;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f50062a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f50062a.setAdapter(this.f50069h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f50064c = new c.a.q0.m0.i.a(inflate, this.f50066e, this.f50067f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f50062a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f50065d = pbListView;
        pbListView.a();
        this.f50065d.o(R.color.CAM_X0205);
        this.f50065d.v();
        this.f50065d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f50065d.E(R.dimen.tbfontsize33);
        this.f50065d.y(R.color.CAM_X0110);
        this.f50062a.setNextPage(this.f50065d);
        this.f50062a.setOnItemClickListener(this.f50068g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f50064c.j(i2);
            this.f50069h.notifyDataSetChanged();
            PbListView pbListView = this.f50065d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f50065d.d(i2);
            }
        }
    }

    public void f(c.a.q0.m0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f50064c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f50062a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.q0.m0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f50063b.clear();
        this.f50063b.addAll(list);
        this.f50069h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f50065d.H();
            this.f50065d.O();
            this.f50065d.A(this.f50062a.getContext().getString(R.string.list_loading));
            this.f50065d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f50065d.N(l.g(this.f50062a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.f50062a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.f50062a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f50065d.B(string, l.g(this.f50062a.getContext(), R.dimen.tbds156));
            this.f50065d.f();
            this.f50065d.J(l.g(this.f50062a.getContext(), R.dimen.tbds44));
        }
    }
}
