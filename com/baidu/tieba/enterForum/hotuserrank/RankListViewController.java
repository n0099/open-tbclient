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
import d.b.h0.r.f0.q.c;
import d.b.h0.z0.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f15108a;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.i0.i.a f15110c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f15111d;

    /* renamed from: e  reason: collision with root package name */
    public String f15112e;

    /* renamed from: f  reason: collision with root package name */
    public long f15113f;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.i0.i0.i.c.b> f15109b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f15114g = new a();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f15115h = new b();

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f15116a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f15117b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f15118c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15119d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15120e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f15121f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15122g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f15123h;
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
            public final /* synthetic */ d.b.i0.i0.i.c.b f15124a;

            public a(d.b.i0.i0.i.c.b bVar) {
                this.f15124a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                if (!TextUtils.isEmpty(RankListViewHolder.this.l)) {
                    StatisticItem statisticItem = new StatisticItem("c13661");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f15124a.f56723a);
                    statisticItem.param("obj_type", this.f15124a.f56728f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13672");
                statisticItem2.param("obj_id", this.f15124a.f56728f.getUserId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                statisticItem2.param("fid", RankListViewHolder.this.m);
                statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f15124a.f56723a);
                statisticItem2.param("obj_type", this.f15124a.f56728f.getIsLike() ? 2 : 1);
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
            this.f15116a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f15117b = headImageView;
            headImageView.setIsRound(true);
            this.f15117b.setPlaceHolder(1);
            this.f15117b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15118c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f15119d = (TextView) view.findViewById(R.id.user_name);
            this.f15120e = (TextView) view.findViewById(R.id.user_intro);
            this.f15121f = (ImageView) view.findViewById(R.id.grade);
            this.f15122g = (TextView) view.findViewById(R.id.user_influence);
            this.f15123h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.b.i0.i0.i.c.b bVar) {
            int i;
            TbPageContext tbPageContext;
            if (bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f56723a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15116a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f15116a.setText(bVar.f56723a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f15116a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f15116a.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.f15116a.getText())) {
                i = R.color.CAM_X0315;
            } else if ("3".equals(this.f15116a.getText())) {
                i = R.color.CAM_X0316;
            } else {
                i = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f15116a, i);
            this.f15117b.W(bVar.f56724b, 10, false);
            this.f15118c.setData(bVar);
            String str = bVar.f56725c;
            if (i0.d(str) > 12) {
                str = i0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f15119d.setText(str);
            boolean z = bVar.f56730h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f15119d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f56726d)) {
                this.f15120e.setVisibility(8);
            } else {
                this.f15120e.setVisibility(0);
                this.f15120e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f56726d, 26));
            }
            if (bVar.f56728f.getLevel_id() == 0) {
                this.f15121f.setVisibility(8);
            } else {
                this.f15121f.setVisibility(0);
                SkinManager.setImageResource(this.f15121f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f56728f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f56727e)) {
                this.f15122g.setVisibility(8);
            } else {
                this.f15122g.setVisibility(0);
                this.f15122g.setText(bVar.f56727e);
            }
            if (this.i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f15123h);
                this.i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.i.n(bVar.f56728f);
            this.f15123h.setOnClickEvent(new a(bVar));
            MetaData metaData = bVar.f56728f;
            if (metaData != null && metaData.getUserId() != null && bVar.f56728f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f15123h.setVisibility(8);
            } else {
                this.f15123h.setVisibility(0);
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
            this.f15120e.setVisibility(8);
            this.f15123h.setVisibility(8);
        }

        public void f(int i) {
            if (this.k == i) {
                return;
            }
            this.k = i;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f15119d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f15119d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f15120e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15122g, R.color.CAM_X0109);
            this.f15123h.r(this.k);
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
            d.b.i0.i0.i.c.b bVar = (d.b.i0.i0.i.c.b) RankListViewController.this.f15109b.get(i);
            if (bVar == null || bVar.f56728f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(RankListViewController.this.f15108a.getContext(), bVar.f56728f.getUserId(), bVar.f56728f.getName_show())));
            if (!TextUtils.isEmpty(RankListViewController.this.f15112e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewController.this.f15112e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f56723a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f56728f.getUserId());
            statisticItem2.param("fid", RankListViewController.this.f15113f);
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
            rankListViewHolder.c((d.b.i0.i0.i.c.b) RankListViewController.this.f15109b.get(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.i(0);
            rankListViewHolder.g(RankListViewController.this.f15112e);
            rankListViewHolder.h(RankListViewController.this.f15113f);
            return rankListViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.f15109b.size();
        }
    }

    public RankListViewController(View view, String str, long j) {
        this.f15112e = str;
        this.f15113f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f15108a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f15108a.setAdapter(this.f15115h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f15110c = new d.b.i0.i0.i.a(inflate, this.f15112e, this.f15113f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f15108a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f15111d = pbListView;
        pbListView.a();
        this.f15111d.o(R.color.CAM_X0205);
        this.f15111d.v();
        this.f15111d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f15111d.E(R.dimen.tbfontsize33);
        this.f15111d.y(R.color.CAM_X0110);
        this.f15108a.setNextPage(this.f15111d);
        this.f15108a.setOnItemClickListener(this.f15114g);
    }

    public void e(int i) {
        this.f15110c.j(i);
        this.f15115h.notifyDataSetChanged();
        PbListView pbListView = this.f15111d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f15111d.d(i);
        }
    }

    public void f(d.b.i0.i0.i.c.a aVar, boolean z) {
        this.f15110c.k(aVar, z);
    }

    public void g(BdListView.p pVar) {
        this.f15108a.setOnSrollToBottomListener(pVar);
    }

    public void h(List<d.b.i0.i0.i.c.b> list) {
        if (list != null) {
            this.f15109b.clear();
            this.f15109b.addAll(list);
            this.f15115h.notifyDataSetChanged();
        }
    }

    public void i() {
        this.f15111d.H();
        this.f15111d.O();
        this.f15111d.A(this.f15108a.getContext().getString(R.string.list_loading));
        this.f15111d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void j(String str) {
        String string;
        this.f15111d.N(l.g(this.f15108a.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.f15108a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.f15108a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.f15111d.B(string, l.g(this.f15108a.getContext(), R.dimen.tbds156));
        this.f15111d.f();
        this.f15111d.J(l.g(this.f15108a.getContext(), R.dimen.tbds44));
    }
}
