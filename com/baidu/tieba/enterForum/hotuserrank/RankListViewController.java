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
import c.a.o0.c1.o0;
import c.a.o0.r.l0.t.c;
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
/* loaded from: classes5.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.w0.j.c.b> f31879b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.w0.j.a f31880c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f31881d;

    /* renamed from: e  reason: collision with root package name */
    public String f31882e;

    /* renamed from: f  reason: collision with root package name */
    public long f31883f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f31884g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f31885h;

    /* loaded from: classes5.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f31886b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f31887c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f31888d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f31889e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f31890f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f31891g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f31892h;
        public c i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes5.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.w0.j.c.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RankListViewHolder f31893b;

            public a(RankListViewHolder rankListViewHolder, c.a.p0.w0.j.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rankListViewHolder, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31893b = rankListViewHolder;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (!TextUtils.isEmpty(this.f31893b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f31893b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        statisticItem.param("obj_type", this.a.f19450f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f19450f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f31893b.l);
                    statisticItem2.param("fid", this.f31893b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    statisticItem2.param("obj_type", this.a.f19450f.getIsLike() ? 2 : 1);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919b7);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090d20);
            this.f31886b = headImageView;
            headImageView.setIsRound(true);
            this.f31886b.setPlaceHolder(1);
            this.f31886b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f31887c = (UserHeadCoverView) view.findViewById(R.id.obfuscated_res_0x7f090d1f);
            this.f31888d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.f31889e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922b5);
            this.f31890f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ce0);
            this.f31891g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922ac);
            this.f31892h = (HotUserRankLikeButton) view.findViewById(R.id.obfuscated_res_0x7f09124e);
        }

        public void c(c.a.p0.w0.j.c.b bVar) {
            int i;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(bVar.a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.a.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.a.getText())) {
                i = R.color.CAM_X0315;
            } else {
                i = "3".equals(this.a.getText()) ? R.color.CAM_X0316 : R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.a, i);
            this.f31886b.J(bVar.f19446b, 10, false);
            this.f31887c.setData(bVar);
            String str = bVar.f19447c;
            if (o0.d(str) > 12) {
                str = o0.n(str, 10) + StringHelper.STRING_MORE;
            }
            this.f31888d.setText(str);
            boolean z = bVar.f19452h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f31888d, (int) R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f19448d)) {
                this.f31889e.setVisibility(8);
            } else {
                this.f31889e.setVisibility(0);
                this.f31889e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f19448d, 26));
            }
            if (bVar.f19450f.getLevel_id() == 0) {
                this.f31890f.setVisibility(8);
            } else {
                this.f31890f.setVisibility(0);
                SkinManager.setImageResource(this.f31890f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f19450f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f19449e)) {
                this.f31891g.setVisibility(8);
            } else {
                this.f31891g.setVisibility(0);
                this.f31891g.setText(bVar.f19449e);
            }
            if (this.i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f31892h);
                this.i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.i.n(bVar.f19450f);
            this.f31892h.setOnClickEvent(new a(this, bVar));
            MetaData metaData = bVar.f19450f;
            if (metaData != null && metaData.getUserId() != null && bVar.f19450f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f31892h.setVisibility(8);
            } else {
                this.f31892h.setVisibility(0);
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
                this.f31889e.setVisibility(8);
                this.f31892h.setVisibility(8);
            }
        }

        public void f(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.k == i) {
                return;
            }
            this.k = i;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f31888d, (int) R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f31888d, (int) R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f31889e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f31891g, (int) R.color.CAM_X0109);
            this.f31892h.r(this.k);
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

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.n = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankListViewController a;

        public a(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            c.a.p0.w0.j.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || (bVar = (c.a.p0.w0.j.c.b) this.a.f31879b.get(i)) == null || bVar.f19450f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a.getContext(), bVar.f19450f.getUserId(), bVar.f19450f.getName_show())));
            if (!TextUtils.isEmpty(this.a.f31882e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.f31882e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f19450f.getUserId());
            statisticItem2.param("fid", this.a.f31883f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i) == null) {
                rankListViewHolder.c((c.a.p0.w0.j.c.b) this.a.f31879b.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03c3, (ViewGroup) null));
                rankListViewHolder.i(0);
                rankListViewHolder.g(this.a.f31882e);
                rankListViewHolder.h(this.a.f31883f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f31879b.size() : invokeV.intValue;
        }
    }

    public RankListViewController(View view, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31879b = new ArrayList();
        this.f31884g = new a(this);
        this.f31885h = new b(this);
        this.f31882e = str;
        this.f31883f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.a.setAdapter(this.f31885h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03c4, (ViewGroup) null);
        this.f31880c = new c.a.p0.w0.j.a(inflate, this.f31882e, this.f31883f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f31881d = pbListView;
        pbListView.a();
        this.f31881d.p(R.color.CAM_X0205);
        this.f31881d.y();
        this.f31881d.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f31881d.H(R.dimen.tbfontsize33);
        this.f31881d.B(R.color.CAM_X0110);
        this.a.setNextPage(this.f31881d);
        this.a.setOnItemClickListener(this.f31884g);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f31880c.j(i);
            this.f31885h.notifyDataSetChanged();
            PbListView pbListView = this.f31881d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f31881d.d(i);
            }
        }
    }

    public void f(c.a.p0.w0.j.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f31880c.k(aVar, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<c.a.p0.w0.j.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f31879b.clear();
        this.f31879b.addAll(list);
        this.f31885h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31881d.K();
            this.f31881d.R();
            this.f31881d.D(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f09e7));
            this.f31881d.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f31881d.Q(n.f(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f088a), str);
            } else {
                string = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0662);
            }
            this.f31881d.E(string, n.f(this.a.getContext(), R.dimen.tbds156));
            this.f31881d.f();
            this.f31881d.M(n.f(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
