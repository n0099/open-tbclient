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
import d.a.i0.r.f0.q.c;
import d.a.i0.z0.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f15242a;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.i0.i.a f15244c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f15245d;

    /* renamed from: e  reason: collision with root package name */
    public String f15246e;

    /* renamed from: f  reason: collision with root package name */
    public long f15247f;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.j0.i0.i.c.b> f15243b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f15248g = new a();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f15249h = new b();

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f15250a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f15251b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f15252c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15253d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15254e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f15255f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15256g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f15257h;

        /* renamed from: i  reason: collision with root package name */
        public c f15258i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes4.dex */
        public class a implements DynamicUserLikeButton.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.j0.i0.i.c.b f15259a;

            public a(d.a.j0.i0.i.c.b bVar) {
                this.f15259a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                if (!TextUtils.isEmpty(RankListViewHolder.this.l)) {
                    StatisticItem statisticItem = new StatisticItem("c13661");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f15259a.f55074a);
                    statisticItem.param("obj_type", this.f15259a.f55079f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13672");
                statisticItem2.param("obj_id", this.f15259a.f55079f.getUserId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                statisticItem2.param("fid", RankListViewHolder.this.m);
                statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f15259a.f55074a);
                statisticItem2.param("obj_type", this.f15259a.f55079f.getIsLike() ? 2 : 1);
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
            this.f15250a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f15251b = headImageView;
            headImageView.setIsRound(true);
            this.f15251b.setPlaceHolder(1);
            this.f15251b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15252c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f15253d = (TextView) view.findViewById(R.id.user_name);
            this.f15254e = (TextView) view.findViewById(R.id.user_intro);
            this.f15255f = (ImageView) view.findViewById(R.id.grade);
            this.f15256g = (TextView) view.findViewById(R.id.user_influence);
            this.f15257h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.a.j0.i0.i.c.b bVar) {
            int i2;
            TbPageContext tbPageContext;
            if (bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f55074a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15250a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f15250a.setText(bVar.f55074a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f15250a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f15250a.getText())) {
                i2 = R.color.CAM_X0314;
            } else if ("2".equals(this.f15250a.getText())) {
                i2 = R.color.CAM_X0315;
            } else if ("3".equals(this.f15250a.getText())) {
                i2 = R.color.CAM_X0316;
            } else {
                i2 = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f15250a, i2);
            this.f15251b.V(bVar.f55075b, 10, false);
            this.f15252c.setData(bVar);
            String str = bVar.f55076c;
            if (i0.d(str) > 12) {
                str = i0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f15253d.setText(str);
            boolean z = bVar.f55081h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f15253d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f55077d)) {
                this.f15254e.setVisibility(8);
            } else {
                this.f15254e.setVisibility(0);
                this.f15254e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f55077d, 26));
            }
            if (bVar.f55079f.getLevel_id() == 0) {
                this.f15255f.setVisibility(8);
            } else {
                this.f15255f.setVisibility(0);
                SkinManager.setImageResource(this.f15255f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f55079f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f55078e)) {
                this.f15256g.setVisibility(8);
            } else {
                this.f15256g.setVisibility(0);
                this.f15256g.setText(bVar.f55078e);
            }
            if (this.f15258i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f15257h);
                this.f15258i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.f15258i.n(bVar.f55079f);
            this.f15257h.setOnClickEvent(new a(bVar));
            MetaData metaData = bVar.f55079f;
            if (metaData != null && metaData.getUserId() != null && bVar.f55079f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f15257h.setVisibility(8);
            } else {
                this.f15257h.setVisibility(0);
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
            this.f15254e.setVisibility(8);
            this.f15257h.setVisibility(8);
        }

        public void f(int i2) {
            if (this.k == i2) {
                return;
            }
            this.k = i2;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f15253d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f15253d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f15254e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15256g, R.color.CAM_X0109);
            this.f15257h.r(this.k);
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
            d.a.j0.i0.i.c.b bVar = (d.a.j0.i0.i.c.b) RankListViewController.this.f15243b.get(i2);
            if (bVar == null || bVar.f55079f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(RankListViewController.this.f15242a.getContext(), bVar.f55079f.getUserId(), bVar.f55079f.getName_show())));
            if (!TextUtils.isEmpty(RankListViewController.this.f15246e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewController.this.f15246e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f55074a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f55079f.getUserId());
            statisticItem2.param("fid", RankListViewController.this.f15247f);
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
            rankListViewHolder.c((d.a.j0.i0.i.c.b) RankListViewController.this.f15243b.get(i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.i(0);
            rankListViewHolder.g(RankListViewController.this.f15246e);
            rankListViewHolder.h(RankListViewController.this.f15247f);
            return rankListViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.f15243b.size();
        }
    }

    public RankListViewController(View view, String str, long j) {
        this.f15246e = str;
        this.f15247f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f15242a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f15242a.setAdapter(this.f15249h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f15244c = new d.a.j0.i0.i.a(inflate, this.f15246e, this.f15247f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f15242a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f15245d = pbListView;
        pbListView.a();
        this.f15245d.o(R.color.CAM_X0205);
        this.f15245d.v();
        this.f15245d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f15245d.E(R.dimen.tbfontsize33);
        this.f15245d.y(R.color.CAM_X0110);
        this.f15242a.setNextPage(this.f15245d);
        this.f15242a.setOnItemClickListener(this.f15248g);
    }

    public void e(int i2) {
        this.f15244c.j(i2);
        this.f15249h.notifyDataSetChanged();
        PbListView pbListView = this.f15245d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f15245d.d(i2);
        }
    }

    public void f(d.a.j0.i0.i.c.a aVar, boolean z) {
        this.f15244c.k(aVar, z);
    }

    public void g(BdListView.p pVar) {
        this.f15242a.setOnSrollToBottomListener(pVar);
    }

    public void h(List<d.a.j0.i0.i.c.b> list) {
        if (list != null) {
            this.f15243b.clear();
            this.f15243b.addAll(list);
            this.f15249h.notifyDataSetChanged();
        }
    }

    public void i() {
        this.f15245d.H();
        this.f15245d.O();
        this.f15245d.A(this.f15242a.getContext().getString(R.string.list_loading));
        this.f15245d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void j(String str) {
        String string;
        this.f15245d.N(l.g(this.f15242a.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.f15242a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.f15242a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.f15245d.B(string, l.g(this.f15242a.getContext(), R.dimen.tbds156));
        this.f15245d.f();
        this.f15245d.J(l.g(this.f15242a.getContext(), R.dimen.tbds44));
    }
}
