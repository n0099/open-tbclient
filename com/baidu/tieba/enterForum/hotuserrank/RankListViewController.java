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
import b.a.e.f.p.l;
import b.a.q0.c1.m0;
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
/* loaded from: classes8.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f48527a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.r0.o0.i.c.b> f48528b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.o0.i.a f48529c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f48530d;

    /* renamed from: e  reason: collision with root package name */
    public String f48531e;

    /* renamed from: f  reason: collision with root package name */
    public long f48532f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f48533g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f48534h;

    /* loaded from: classes8.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RANK_TYPE_BOTTOM = 1;
        public static final int RANK_TYPE_LIST = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f48535a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f48536b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f48537c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f48538d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f48539e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f48540f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f48541g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f48542h;

        /* renamed from: i  reason: collision with root package name */
        public c f48543i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes8.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.o0.i.c.b f48544a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f48545b;

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
                this.f48545b = rankListViewHolder;
                this.f48544a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f48545b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f48545b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f48544a.f23190a);
                        statisticItem.param("obj_type", this.f48544a.f23195f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.f48544a.f23195f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f48545b.l);
                    statisticItem2.param("fid", this.f48545b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f48544a.f23190a);
                    statisticItem2.param("obj_type", this.f48544a.f23195f.getIsLike() ? 2 : 1);
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
            this.f48535a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f48536b = headImageView;
            headImageView.setIsRound(true);
            this.f48536b.setPlaceHolder(1);
            this.f48536b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f48537c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f48538d = (TextView) view.findViewById(R.id.user_name);
            this.f48539e = (TextView) view.findViewById(R.id.user_intro);
            this.f48540f = (ImageView) view.findViewById(R.id.grade);
            this.f48541g = (TextView) view.findViewById(R.id.user_influence);
            this.f48542h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void bindData(b.a.r0.o0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f23190a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f48535a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f48535a.setText(bVar.f23190a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f48535a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f48535a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f48535a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f48535a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f48535a, i2);
            this.f48536b.startLoad(bVar.f23191b, 10, false);
            this.f48537c.setData(bVar);
            String str = bVar.f23192c;
            if (m0.d(str) > 12) {
                str = m0.m(str, 10) + "...";
            }
            this.f48538d.setText(str);
            boolean z = bVar.f23197h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f48538d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f23193d)) {
                this.f48539e.setVisibility(8);
            } else {
                this.f48539e.setVisibility(0);
                this.f48539e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f23193d, 26));
            }
            if (bVar.f23195f.getLevel_id() == 0) {
                this.f48540f.setVisibility(8);
            } else {
                this.f48540f.setVisibility(0);
                SkinManager.setImageResource(this.f48540f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f23195f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f23194e)) {
                this.f48541g.setVisibility(8);
            } else {
                this.f48541g.setVisibility(0);
                this.f48541g.setText(bVar.f23194e);
            }
            if (this.f48543i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f48542h);
                this.f48543i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f48543i.n(bVar.f23195f);
            this.f48542h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f23195f;
            if (metaData != null && metaData.getUserId() != null && bVar.f23195f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f48542h.setVisibility(8);
            } else {
                this.f48542h.setVisibility(0);
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
                this.f48539e.setVisibility(8);
                this.f48542h.setVisibility(8);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f48538d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f48538d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f48539e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f48541g, R.color.CAM_X0109);
            this.f48542h.onChangeSkinType(this.k);
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

    /* loaded from: classes8.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f48546e;

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
            this.f48546e = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            b.a.r0.o0.i.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (bVar = (b.a.r0.o0.i.c.b) this.f48546e.f48528b.get(i2)) == null || bVar.f23195f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f48546e.f48527a.getContext(), bVar.f23195f.getUserId(), bVar.f23195f.getName_show())));
            if (!TextUtils.isEmpty(this.f48546e.f48531e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f48546e.f48531e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f23190a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f23195f.getUserId());
            statisticItem2.param("fid", this.f48546e.f48532f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RankListViewController f48547a;

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
            this.f48547a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i2) == null) {
                rankListViewHolder.bindData((b.a.r0.o0.i.c.b) this.f48547a.f48528b.get(i2));
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
                rankListViewHolder.setCategory(this.f48547a.f48531e);
                rankListViewHolder.setForumId(this.f48547a.f48532f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48547a.f48528b.size() : invokeV.intValue;
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
        this.f48528b = new ArrayList();
        this.f48533g = new a(this);
        this.f48534h = new b(this);
        this.f48531e = str;
        this.f48532f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f48527a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f48527a.setAdapter(this.f48534h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f48529c = new b.a.r0.o0.i.a(inflate, this.f48531e, this.f48532f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f48527a.addHeaderView(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f48530d = pbListView;
        pbListView.a();
        this.f48530d.p(R.color.CAM_X0205);
        this.f48530d.x();
        this.f48530d.E(SkinManager.getColor(R.color.CAM_X0107));
        this.f48530d.G(R.dimen.tbfontsize33);
        this.f48530d.A(R.color.CAM_X0110);
        this.f48527a.setNextPage(this.f48530d);
        this.f48527a.setOnItemClickListener(this.f48533g);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f48529c.j(i2);
            this.f48534h.notifyDataSetChanged();
            PbListView pbListView = this.f48530d;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f48530d.d(i2);
            }
        }
    }

    public void f(b.a.r0.o0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f48529c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f48527a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<b.a.r0.o0.i.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f48528b.clear();
        this.f48528b.addAll(list);
        this.f48534h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48530d.J();
            this.f48530d.Q();
            this.f48530d.C(this.f48527a.getContext().getString(R.string.list_loading));
            this.f48530d.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f48530d.P(l.g(this.f48527a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.f48527a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
            } else {
                string = this.f48527a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
            }
            this.f48530d.D(string, l.g(this.f48527a.getContext(), R.dimen.tbds156));
            this.f48530d.f();
            this.f48530d.L(l.g(this.f48527a.getContext(), R.dimen.tbds44));
        }
    }
}
