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
import d.b.b.e.p.l;
import d.b.h0.r.f0.q.c;
import d.b.h0.z0.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RankListViewController {

    /* renamed from: a  reason: collision with root package name */
    public BdRecyclerView f15445a;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.i0.i.a f15447c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f15448d;

    /* renamed from: e  reason: collision with root package name */
    public String f15449e;

    /* renamed from: f  reason: collision with root package name */
    public long f15450f;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.i0.i0.i.c.b> f15446b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView.i f15451g = new a();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f15452h = new b();

    /* loaded from: classes4.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f15453a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f15454b;

        /* renamed from: c  reason: collision with root package name */
        public UserHeadCoverView f15455c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15456d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15457e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f15458f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15459g;

        /* renamed from: h  reason: collision with root package name */
        public HotUserRankLikeButton f15460h;
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
            public final /* synthetic */ d.b.i0.i0.i.c.b f15461a;

            public a(d.b.i0.i0.i.c.b bVar) {
                this.f15461a = bVar;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view) {
                if (!TextUtils.isEmpty(RankListViewHolder.this.l)) {
                    StatisticItem statisticItem = new StatisticItem("c13661");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f15461a.f55600a);
                    statisticItem.param("obj_type", this.f15461a.f55605f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13672");
                statisticItem2.param("obj_id", this.f15461a.f55605f.getUserId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, RankListViewHolder.this.l);
                statisticItem2.param("fid", RankListViewHolder.this.m);
                statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.f15461a.f55600a);
                statisticItem2.param("obj_type", this.f15461a.f55605f.getIsLike() ? 2 : 1);
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
            this.f15453a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head_icon);
            this.f15454b = headImageView;
            headImageView.setIsRound(true);
            this.f15454b.setPlaceHolder(1);
            this.f15454b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15455c = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.f15456d = (TextView) view.findViewById(R.id.user_name);
            this.f15457e = (TextView) view.findViewById(R.id.user_intro);
            this.f15458f = (ImageView) view.findViewById(R.id.grade);
            this.f15459g = (TextView) view.findViewById(R.id.user_influence);
            this.f15460h = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void c(d.b.i0.i0.i.c.b bVar) {
            int i;
            TbPageContext tbPageContext;
            if (bVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(bVar.f55600a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15453a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.f15453a.setText(bVar.f55600a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.f15453a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.f15453a.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.f15453a.getText())) {
                i = R.color.CAM_X0315;
            } else if ("3".equals(this.f15453a.getText())) {
                i = R.color.CAM_X0316;
            } else {
                i = R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.f15453a, i);
            this.f15454b.W(bVar.f55601b, 10, false);
            this.f15455c.setData(bVar);
            String str = bVar.f55602c;
            if (i0.d(str) > 12) {
                str = i0.m(str, 10) + StringHelper.STRING_MORE;
            }
            this.f15456d.setText(str);
            boolean z = bVar.f55607h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.f15456d, R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(bVar.f55603d)) {
                this.f15457e.setVisibility(8);
            } else {
                this.f15457e.setVisibility(0);
                this.f15457e.setText(StringHelper.cutStringWithEllipsisStrict(bVar.f55603d, 26));
            }
            if (bVar.f55605f.getLevel_id() == 0) {
                this.f15458f.setVisibility(8);
            } else {
                this.f15458f.setVisibility(0);
                SkinManager.setImageResource(this.f15458f, BitmapHelper.getGradeResourceIdInEnterForum(bVar.f55605f.getLevel_id()));
            }
            if (TextUtils.isEmpty(bVar.f55604e)) {
                this.f15459g.setVisibility(8);
            } else {
                this.f15459g.setVisibility(0);
                this.f15459g.setText(bVar.f55604e);
            }
            if (this.i == null && (tbPageContext = this.j) != null) {
                c cVar = new c(tbPageContext, this.f15460h);
                this.i = cVar;
                cVar.l(this.j.getUniqueId());
            }
            this.i.n(bVar.f55605f);
            this.f15460h.setOnClickEvent(new a(bVar));
            MetaData metaData = bVar.f55605f;
            if (metaData != null && metaData.getUserId() != null && bVar.f55605f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.f15460h.setVisibility(8);
            } else {
                this.f15460h.setVisibility(0);
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
            this.f15457e.setVisibility(8);
            this.f15460h.setVisibility(8);
        }

        public void f(int i) {
            if (this.k == i) {
                return;
            }
            this.k = i;
            if (!this.o) {
                SkinManager.setViewTextColor(this.f15456d, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f15456d, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f15457e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15459g, R.color.CAM_X0109);
            this.f15460h.r(this.k);
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
            d.b.i0.i0.i.c.b bVar = (d.b.i0.i0.i.c.b) RankListViewController.this.f15446b.get(i);
            if (bVar == null || bVar.f55605f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(RankListViewController.this.f15445a.getContext(), bVar.f55605f.getUserId(), bVar.f55605f.getName_show())));
            if (!TextUtils.isEmpty(RankListViewController.this.f15449e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, RankListViewController.this.f15449e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, bVar.f55600a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", bVar.f55605f.getUserId());
            statisticItem2.param("fid", RankListViewController.this.f15450f);
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
            rankListViewHolder.c((d.b.i0.i0.i.c.b) RankListViewController.this.f15446b.get(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.i(0);
            rankListViewHolder.g(RankListViewController.this.f15449e);
            rankListViewHolder.h(RankListViewController.this.f15450f);
            return rankListViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.f15446b.size();
        }
    }

    public RankListViewController(View view, String str, long j) {
        this.f15449e = str;
        this.f15450f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view;
        this.f15445a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f15445a.setAdapter(this.f15452h);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.f15447c = new d.b.i0.i0.i.a(inflate, this.f15449e, this.f15450f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f15445a.s(inflate);
        PbListView pbListView = new PbListView(view.getContext());
        this.f15448d = pbListView;
        pbListView.a();
        this.f15448d.o(R.color.CAM_X0205);
        this.f15448d.v();
        this.f15448d.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f15448d.E(R.dimen.tbfontsize33);
        this.f15448d.y(R.color.CAM_X0110);
        this.f15445a.setNextPage(this.f15448d);
        this.f15445a.setOnItemClickListener(this.f15451g);
    }

    public void e(int i) {
        this.f15447c.j(i);
        this.f15452h.notifyDataSetChanged();
        PbListView pbListView = this.f15448d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f15448d.d(i);
        }
    }

    public void f(d.b.i0.i0.i.c.a aVar, boolean z) {
        this.f15447c.k(aVar, z);
    }

    public void g(BdListView.p pVar) {
        this.f15445a.setOnSrollToBottomListener(pVar);
    }

    public void h(List<d.b.i0.i0.i.c.b> list) {
        if (list != null) {
            this.f15446b.clear();
            this.f15446b.addAll(list);
            this.f15452h.notifyDataSetChanged();
        }
    }

    public void i() {
        this.f15448d.H();
        this.f15448d.O();
        this.f15448d.A(this.f15445a.getContext().getString(R.string.list_loading));
        this.f15448d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void j(String str) {
        String string;
        this.f15448d.N(l.g(this.f15445a.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.f15445a.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.f15445a.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.f15448d.B(string, l.g(this.f15445a.getContext(), R.dimen.tbds156));
        this.f15448d.f();
        this.f15448d.J(l.g(this.f15445a.getContext(), R.dimen.tbds44));
    }
}
