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
import d.a.c.e.p.l;
import d.a.m0.r.f0.q.c;
import d.a.m0.z0.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f14460a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.j0.i.a f14462c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f14463d;

    /* renamed from: e  reason: collision with root package name */
    public String f14464e;

    /* renamed from: f  reason: collision with root package name */
    public long f14465f;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.n0.j0.i.c.b> f14461b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f14466g = new a();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f14467h = new b();

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f14468a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f14469b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f14470c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14471d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14472e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14473f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14474g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f14475h;

        /* renamed from: i  reason: collision with root package name */
        public c f14476i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes4.dex */
        public class a implements DynamicUserLikeButton.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.j0.i.c.b f14477a;

            public a(d.a.n0.j0.i.c.b bVar) {
                this.f14477a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                if (!TextUtils.isEmpty(RankListViewHolder.this.l)) {
                    StatisticItem statisticItem = new StatisticItem("c13661");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f14477a.f55965a);
                    statisticItem.param("obj_type", this.f14477a.f55970f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13672");
                statisticItem2.param("obj_id", this.f14477a.f55970f.getUserId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                statisticItem2.param("fid", RankListViewHolder.this.m);
                statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f14477a.f55965a);
                statisticItem2.param("obj_type", this.f14477a.f55970f.getIsLike() ? 2 : 1);
                TiebaStatic.log(statisticItem2);
            }
        }

        public RankListViewHolder(View view) {
            super(view);
            this.k = 3;
            this.l = "";
            this.n = 0;
            this.j = d(view.getContext());
            TextView textView = (TextView) view.findViewById(R.id.rank_num);
            this.f14468a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f14469b = headImageView;
            headImageView.setIsRound(true);
            this.f14469b.setPlaceHolder(1);
            this.f14469b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14470c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f14471d = (TextView) view.findViewById(R.id.user_name);
            this.f14472e = (TextView) view.findViewById(R.id.user_intro);
            this.f14473f = (ImageView) view.findViewById(R.id.grade);
            this.f14474g = (TextView) view.findViewById(R.id.user_influence);
            this.f14475h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.a.n0.j0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            if (bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f55965a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14468a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f14468a.setText(bVar.f55965a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f14468a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f14468a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f14468a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f14468a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f14468a, i2);
            this.f14469b.V(bVar.f55966b, 10, false);
            this.f14470c.setData(bVar);
            String str = bVar.f55967c;
            if (i0.d(str) > 12) {
                str = i0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f14471d.setText(str);
            boolean z = bVar.f55972h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f14471d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f55968d)) {
                this.f14472e.setVisibility(8);
            } else {
                this.f14472e.setVisibility(0);
                this.f14472e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f55968d, 26));
            }
            if (bVar.f55970f.getLevel_id() == 0) {
                this.f14473f.setVisibility(8);
            } else {
                this.f14473f.setVisibility(0);
                SkinManager.setImageResource(this.f14473f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f55970f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f55969e)) {
                this.f14474g.setVisibility(8);
            } else {
                this.f14474g.setVisibility(0);
                this.f14474g.setText(bVar.f55969e);
            }
            if (this.f14476i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f14475h);
                this.f14476i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f14476i.n(bVar.f55970f);
            this.f14475h.setOnClickEvent(new a(bVar));
            MetaData metaData = bVar.f55970f;
            if (metaData != null && metaData.getUserId() != null && bVar.f55970f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f14475h.setVisibility(8);
            } else {
                this.f14475h.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }

        public final TbPageContext d(Context context) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }

        public void e() {
            this.f14472e.setVisibility(8);
            this.f14475h.setVisibility(8);
        }

        public void f(int i2) {
            if (this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f14471d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f14471d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f14472e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14474g, R.color.CAM_X0109);
            this.f14475h.r(this.k);
        }

        public void g(String str) {
            this.l = str;
        }

        public void h(long j) {
            this.m = j;
        }

        public void i(int i2) {
            this.n = i2;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            d.a.n0.j0.i.c.b bVar = (d.a.n0.j0.i.c.b) RankListViewController.this.f14461b.get(i2);
            if (bVar == null || bVar.f55970f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(RankListViewController.this.f14460a.getContext(), bVar.f55970f.getUserId(), bVar.f55970f.getName_show())));
            if (!TextUtils.isEmpty(RankListViewController.this.f14464e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewController.this.f14464e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f55965a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f55970f.getUserId());
            statisticItem2.param("fid", RankListViewController.this.f14465f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i2) {
            rankListViewHolder.c((d.a.n0.j0.i.c.b) RankListViewController.this.f14461b.get(i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.i(0);
            rankListViewHolder.g(RankListViewController.this.f14464e);
            rankListViewHolder.h(RankListViewController.this.f14465f);
            return rankListViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.f14461b.size();
        }
    }

    public RankListViewController(View view, String str, long j) {
        this.f14464e = str;
        this.f14465f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f14460a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f14460a.setAdapter(this.f14467h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f14462c = new d.a.n0.j0.i.a(inflate, this.f14464e, this.f14465f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f14460a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f14463d = pbListView;
        pbListView.a();
        this.f14463d.o(R.color.CAM_X0205);
        this.f14463d.v();
        this.f14463d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f14463d.E(R.dimen.tbfontsize33);
        this.f14463d.y(R.color.CAM_X0110);
        this.f14460a.setNextPage(this.f14463d);
        this.f14460a.setOnItemClickListener(this.f14466g);
    }

    public void e(int i2) {
        this.f14462c.j(i2);
        this.f14467h.notifyDataSetChanged();
        PbListView pbListView = this.f14463d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f14463d.d(i2);
        }
    }

    public void f(d.a.n0.j0.i.c.a aVar, boolean z) {
        this.f14462c.k(aVar, z);
    }

    public void g(BdListView.p pVar) {
        this.f14460a.setOnSrollToBottomListener(pVar);
    }

    public void h(List<d.a.n0.j0.i.c.b> list) {
        if (list != null) {
            this.f14461b.clear();
            this.f14461b.addAll(list);
            this.f14467h.notifyDataSetChanged();
        }
    }

    public void i() {
        this.f14463d.H();
        this.f14463d.O();
        this.f14463d.A(this.f14460a.getContext().getString(R.string.list_loading));
        this.f14463d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void j(String str) {
        String string;
        this.f14463d.N(l.g(this.f14460a.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.f14460a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.f14460a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.f14463d.B(string, l.g(this.f14460a.getContext(), R.dimen.tbds156));
        this.f14463d.f();
        this.f14463d.J(l.g(this.f14460a.getContext(), R.dimen.tbds44));
    }
}
