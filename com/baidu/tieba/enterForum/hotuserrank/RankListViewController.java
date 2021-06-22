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
import d.a.n0.r.f0.q.c;
import d.a.n0.z0.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f14599a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.j0.i.a f14601c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f14602d;

    /* renamed from: e  reason: collision with root package name */
    public String f14603e;

    /* renamed from: f  reason: collision with root package name */
    public long f14604f;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.o0.j0.i.c.b> f14600b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f14605g = new a();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f14606h = new b();

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f14607a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f14608b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f14609c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14610d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14611e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14612f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14613g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f14614h;

        /* renamed from: i  reason: collision with root package name */
        public c f14615i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes4.dex */
        public class a implements DynamicUserLikeButton.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.j0.i.c.b f14616a;

            public a(d.a.o0.j0.i.c.b bVar) {
                this.f14616a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                if (!TextUtils.isEmpty(RankListViewHolder.this.l)) {
                    StatisticItem statisticItem = new StatisticItem("c13661");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f14616a.f59779a);
                    statisticItem.param("obj_type", this.f14616a.f59784f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13672");
                statisticItem2.param("obj_id", this.f14616a.f59784f.getUserId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                statisticItem2.param("fid", RankListViewHolder.this.m);
                statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f14616a.f59779a);
                statisticItem2.param("obj_type", this.f14616a.f59784f.getIsLike() ? 2 : 1);
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
            this.f14607a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f14608b = headImageView;
            headImageView.setIsRound(true);
            this.f14608b.setPlaceHolder(1);
            this.f14608b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14609c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f14610d = (TextView) view.findViewById(R.id.user_name);
            this.f14611e = (TextView) view.findViewById(R.id.user_intro);
            this.f14612f = (ImageView) view.findViewById(R.id.grade);
            this.f14613g = (TextView) view.findViewById(R.id.user_influence);
            this.f14614h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.a.o0.j0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            if (bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f59779a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14607a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f14607a.setText(bVar.f59779a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f14607a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f14607a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f14607a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f14607a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f14607a, i2);
            this.f14608b.U(bVar.f59780b, 10, false);
            this.f14609c.setData(bVar);
            String str = bVar.f59781c;
            if (i0.d(str) > 12) {
                str = i0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f14610d.setText(str);
            boolean z = bVar.f59786h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f14610d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f59782d)) {
                this.f14611e.setVisibility(8);
            } else {
                this.f14611e.setVisibility(0);
                this.f14611e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f59782d, 26));
            }
            if (bVar.f59784f.getLevel_id() == 0) {
                this.f14612f.setVisibility(8);
            } else {
                this.f14612f.setVisibility(0);
                SkinManager.setImageResource(this.f14612f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f59784f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f59783e)) {
                this.f14613g.setVisibility(8);
            } else {
                this.f14613g.setVisibility(0);
                this.f14613g.setText(bVar.f59783e);
            }
            if (this.f14615i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f14614h);
                this.f14615i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f14615i.n(bVar.f59784f);
            this.f14614h.setOnClickEvent(new a(bVar));
            MetaData metaData = bVar.f59784f;
            if (metaData != null && metaData.getUserId() != null && bVar.f59784f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f14614h.setVisibility(8);
            } else {
                this.f14614h.setVisibility(0);
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
            this.f14611e.setVisibility(8);
            this.f14614h.setVisibility(8);
        }

        public void f(int i2) {
            if (this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f14610d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f14610d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f14611e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14613g, R.color.CAM_X0109);
            this.f14614h.r(this.k);
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
            d.a.o0.j0.i.c.b bVar = (d.a.o0.j0.i.c.b) RankListViewController.this.f14600b.get(i2);
            if (bVar == null || bVar.f59784f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(RankListViewController.this.f14599a.getContext(), bVar.f59784f.getUserId(), bVar.f59784f.getName_show())));
            if (!TextUtils.isEmpty(RankListViewController.this.f14603e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewController.this.f14603e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f59779a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f59784f.getUserId());
            statisticItem2.param("fid", RankListViewController.this.f14604f);
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
            rankListViewHolder.c((d.a.o0.j0.i.c.b) RankListViewController.this.f14600b.get(i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.i(0);
            rankListViewHolder.g(RankListViewController.this.f14603e);
            rankListViewHolder.h(RankListViewController.this.f14604f);
            return rankListViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.f14600b.size();
        }
    }

    public RankListViewController(View view, String str, long j) {
        this.f14603e = str;
        this.f14604f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f14599a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f14599a.setAdapter(this.f14606h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f14601c = new d.a.o0.j0.i.a(inflate, this.f14603e, this.f14604f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f14599a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f14602d = pbListView;
        pbListView.a();
        this.f14602d.o(R.color.CAM_X0205);
        this.f14602d.v();
        this.f14602d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f14602d.E(R.dimen.tbfontsize33);
        this.f14602d.y(R.color.CAM_X0110);
        this.f14599a.setNextPage(this.f14602d);
        this.f14599a.setOnItemClickListener(this.f14605g);
    }

    public void e(int i2) {
        this.f14601c.j(i2);
        this.f14606h.notifyDataSetChanged();
        PbListView pbListView = this.f14602d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f14602d.d(i2);
        }
    }

    public void f(d.a.o0.j0.i.c.a aVar, boolean z) {
        this.f14601c.k(aVar, z);
    }

    public void g(BdListView.p pVar) {
        this.f14599a.setOnSrollToBottomListener(pVar);
    }

    public void h(List<d.a.o0.j0.i.c.b> list) {
        if (list != null) {
            this.f14600b.clear();
            this.f14600b.addAll(list);
            this.f14606h.notifyDataSetChanged();
        }
    }

    public void i() {
        this.f14602d.H();
        this.f14602d.O();
        this.f14602d.A(this.f14599a.getContext().getString(R.string.list_loading));
        this.f14602d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void j(String str) {
        String string;
        this.f14602d.N(l.g(this.f14599a.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.f14599a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.f14599a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.f14602d.B(string, l.g(this.f14599a.getContext(), R.dimen.tbds156));
        this.f14602d.f();
        this.f14602d.J(l.g(this.f14599a.getContext(), R.dimen.tbds44));
    }
}
