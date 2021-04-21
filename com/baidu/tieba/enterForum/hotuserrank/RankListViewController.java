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
import d.b.c.e.p.l;
import d.b.i0.r.f0.q.c;
import d.b.i0.z0.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f15116a;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.i0.i.a f15118c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f15119d;

    /* renamed from: e  reason: collision with root package name */
    public String f15120e;

    /* renamed from: f  reason: collision with root package name */
    public long f15121f;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.j0.i0.i.c.b> f15117b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f15122g = new a();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f15123h = new b();

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f15124a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f15125b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f15126c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15127d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15128e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f15129f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15130g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f15131h;
        public c i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes4.dex */
        public class a implements DynamicUserLikeButton.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.j0.i0.i.c.b f15132a;

            public a(d.b.j0.i0.i.c.b bVar) {
                this.f15132a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                if (!TextUtils.isEmpty(RankListViewHolder.this.l)) {
                    StatisticItem statisticItem = new StatisticItem("c13661");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f15132a.f57144a);
                    statisticItem.param("obj_type", this.f15132a.f57149f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13672");
                statisticItem2.param("obj_id", this.f15132a.f57149f.getUserId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                statisticItem2.param("fid", RankListViewHolder.this.m);
                statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f15132a.f57144a);
                statisticItem2.param("obj_type", this.f15132a.f57149f.getIsLike() ? 2 : 1);
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
            this.f15124a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f15125b = headImageView;
            headImageView.setIsRound(true);
            this.f15125b.setPlaceHolder(1);
            this.f15125b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15126c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f15127d = (TextView) view.findViewById(R.id.user_name);
            this.f15128e = (TextView) view.findViewById(R.id.user_intro);
            this.f15129f = (ImageView) view.findViewById(R.id.grade);
            this.f15130g = (TextView) view.findViewById(R.id.user_influence);
            this.f15131h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.b.j0.i0.i.c.b bVar) {
            int i;
            TbPageContext tbPageContext;
            if (bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f57144a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15124a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f15124a.setText(bVar.f57144a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f15124a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f15124a.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.f15124a.getText())) {
                i = R.color.CAM_X0315;
            } else if ("3".equals(this.f15124a.getText())) {
                i = R.color.CAM_X0316;
            } else {
                i = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f15124a, i);
            this.f15125b.W(bVar.f57145b, 10, false);
            this.f15126c.setData(bVar);
            String str = bVar.f57146c;
            if (i0.d(str) > 12) {
                str = i0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f15127d.setText(str);
            boolean z = bVar.f57151h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f15127d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f57147d)) {
                this.f15128e.setVisibility(8);
            } else {
                this.f15128e.setVisibility(0);
                this.f15128e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f57147d, 26));
            }
            if (bVar.f57149f.getLevel_id() == 0) {
                this.f15129f.setVisibility(8);
            } else {
                this.f15129f.setVisibility(0);
                SkinManager.setImageResource(this.f15129f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f57149f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f57148e)) {
                this.f15130g.setVisibility(8);
            } else {
                this.f15130g.setVisibility(0);
                this.f15130g.setText(bVar.f57148e);
            }
            if (this.i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f15131h);
                this.i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.i.n(bVar.f57149f);
            this.f15131h.setOnClickEvent(new a(bVar));
            MetaData metaData = bVar.f57149f;
            if (metaData != null && metaData.getUserId() != null && bVar.f57149f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f15131h.setVisibility(8);
            } else {
                this.f15131h.setVisibility(0);
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
            this.f15128e.setVisibility(8);
            this.f15131h.setVisibility(8);
        }

        public void f(int i) {
            if (this.k == i) {
                return;
            }
            this.k = i;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f15127d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f15127d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f15128e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15130g, R.color.CAM_X0109);
            this.f15131h.r(this.k);
        }

        public void g(String str) {
            this.l = str;
        }

        public void h(long j) {
            this.m = j;
        }

        public void i(int i) {
            this.n = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void c(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            d.b.j0.i0.i.c.b bVar = (d.b.j0.i0.i.c.b) RankListViewController.this.f15117b.get(i);
            if (bVar == null || bVar.f57149f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(RankListViewController.this.f15116a.getContext(), bVar.f57149f.getUserId(), bVar.f57149f.getName_show())));
            if (!TextUtils.isEmpty(RankListViewController.this.f15120e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewController.this.f15120e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f57144a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f57149f.getUserId());
            statisticItem2.param("fid", RankListViewController.this.f15121f);
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
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i) {
            rankListViewHolder.c((d.b.j0.i0.i.c.b) RankListViewController.this.f15117b.get(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.i(0);
            rankListViewHolder.g(RankListViewController.this.f15120e);
            rankListViewHolder.h(RankListViewController.this.f15121f);
            return rankListViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.f15117b.size();
        }
    }

    public RankListViewController(View view, String str, long j) {
        this.f15120e = str;
        this.f15121f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f15116a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f15116a.setAdapter(this.f15123h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f15118c = new d.b.j0.i0.i.a(inflate, this.f15120e, this.f15121f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f15116a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f15119d = pbListView;
        pbListView.a();
        this.f15119d.o(R.color.CAM_X0205);
        this.f15119d.v();
        this.f15119d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f15119d.E(R.dimen.tbfontsize33);
        this.f15119d.y(R.color.CAM_X0110);
        this.f15116a.setNextPage(this.f15119d);
        this.f15116a.setOnItemClickListener(this.f15122g);
    }

    public void e(int i) {
        this.f15118c.j(i);
        this.f15123h.notifyDataSetChanged();
        PbListView pbListView = this.f15119d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f15119d.d(i);
        }
    }

    public void f(d.b.j0.i0.i.c.a aVar, boolean z) {
        this.f15118c.k(aVar, z);
    }

    public void g(BdListView.p pVar) {
        this.f15116a.setOnSrollToBottomListener(pVar);
    }

    public void h(List<d.b.j0.i0.i.c.b> list) {
        if (list != null) {
            this.f15117b.clear();
            this.f15117b.addAll(list);
            this.f15123h.notifyDataSetChanged();
        }
    }

    public void i() {
        this.f15119d.H();
        this.f15119d.O();
        this.f15119d.A(this.f15116a.getContext().getString(R.string.list_loading));
        this.f15119d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void j(String str) {
        String string;
        this.f15119d.N(l.g(this.f15116a.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.f15116a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.f15116a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.f15119d.B(string, l.g(this.f15116a.getContext(), R.dimen.tbds156));
        this.f15119d.f();
        this.f15119d.J(l.g(this.f15116a.getContext(), R.dimen.tbds44));
    }
}
