package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.m.f;
import d.a.n0.z0.l0;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f16306a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f16307b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f16308c;

    /* renamed from: d  reason: collision with root package name */
    public int f16309d = 3;

    /* renamed from: e  reason: collision with root package name */
    public List<MetaData> f16310e;

    /* renamed from: f  reason: collision with root package name */
    public f<MetaData> f16311f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16312a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16313b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16314c;

        /* renamed from: d  reason: collision with root package name */
        public HeadPendantClickableView f16315d;

        /* renamed from: e  reason: collision with root package name */
        public DynamicUserLikeButton f16316e;

        /* renamed from: f  reason: collision with root package name */
        public d.a.n0.r.f0.q.c f16317f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16318g;

        public ForumViewHolder(ConcernRecommendListAdapter concernRecommendListAdapter, View view) {
            super(view);
            this.f16318g = false;
            this.f16312a = (LinearLayout) view.findViewById(R.id.concern_container);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.f16315d = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.f16315d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16315d.getHeadView().setDefaultResource(17170445);
            this.f16315d.getHeadView().setPlaceHolder(1);
            this.f16315d.getHeadView().setBorderWidth(l.g(concernRecommendListAdapter.f16306a, R.dimen.tbds1));
            this.f16315d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f16313b = (TextView) view.findViewById(R.id.concern_user_name);
            this.f16314c = (TextView) view.findViewById(R.id.concern_user_desc);
            this.f16316e = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.f16317f = new d.a.n0.r.f0.q.c(concernRecommendListAdapter.f16307b, this.f16316e);
        }

        public void a(int i2) {
            if (!this.f16318g) {
                SkinManager.setViewTextColor(this.f16313b, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f16313b, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f16314c, R.color.CAM_X0109);
            this.f16316e.r(i2);
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f16312a);
            d2.m(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
        }

        public void b(boolean z) {
            this.f16318g = z;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f16319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f16320f;

        public a(MetaData metaData, ForumViewHolder forumViewHolder) {
            this.f16319e = metaData;
            this.f16320f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            ConcernRecommendListAdapter.this.i(this.f16319e, this.f16320f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DynamicUserLikeButton.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MetaData f16322a;

        public b(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData) {
            this.f16322a = metaData;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            MetaData metaData = this.f16322a;
            if (metaData == null) {
                return;
            }
            if (metaData.getIsLike()) {
                TiebaStatic.log(new StatisticItem("c13571"));
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_id", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_param1", this.f16322a.getUserId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f16323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f16324f;

        public c(MetaData metaData, ForumViewHolder forumViewHolder) {
            this.f16323e = metaData;
            this.f16324f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData = this.f16323e;
            if (metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ConcernRecommendListAdapter.this.f16306a, this.f16323e.getUserId(), this.f16323e.getName_show())));
            ConcernRecommendListAdapter.this.i(this.f16323e, this.f16324f);
        }
    }

    public ConcernRecommendListAdapter(Context context) {
        this.f16306a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        List<MetaData> list;
        MetaData metaData;
        if (forumViewHolder == null || (list = this.f16310e) == null || (metaData = list.get(i2)) == null) {
            return;
        }
        forumViewHolder.b(metaData.isNewGod());
        n(metaData, forumViewHolder);
        q(metaData, forumViewHolder);
        o(metaData, forumViewHolder);
        p(metaData, forumViewHolder);
        f<MetaData> fVar = this.f16311f;
        if (fVar != null) {
            fVar.c(forumViewHolder.itemView, metaData, i2, i2);
        }
        forumViewHolder.a(this.f16309d);
    }

    public void g(int i2) {
        this.f16309d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MetaData> list = this.f16310e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ForumViewHolder(this, LayoutInflater.from(this.f16306a).inflate(R.layout.concern_recommend_item, (ViewGroup) null));
    }

    public final void i(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (this.f16311f != null) {
            this.f16311f.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    public void j(boolean z) {
    }

    public void k(f<MetaData> fVar) {
        this.f16311f = fVar;
    }

    public void l(TbPageContext tbPageContext) {
        this.f16307b = tbPageContext;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f16308c = bdUniqueId;
    }

    public final void n(MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.f16315d.setData(metaData, true);
        forumViewHolder.f16315d.setAfterClickListener(new a(metaData, forumViewHolder));
    }

    public final void o(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (metaData == null || forumViewHolder == null) {
            return;
        }
        String str = "";
        if (metaData.isBaijiahaoUser()) {
            String str2 = metaData.getBaijiahaoInfo().auth_desc;
            if (!k.isEmpty(str2)) {
                str = str2;
            }
        } else if (metaData.isNewGod()) {
            String fieldName = metaData.getNewGodData().getFieldName();
            if (!k.isEmpty(fieldName)) {
                str = fieldName + l0.d(metaData.isVideoGod());
            }
        }
        forumViewHolder.f16314c.setText(str);
    }

    public final void p(MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.f16316e.setOnClickEvent(new b(this, metaData));
        d.a.n0.r.f0.q.c cVar = forumViewHolder.f16317f;
        if (cVar != null) {
            cVar.l(this.f16308c);
            cVar.n(metaData);
        }
    }

    public final void q(MetaData metaData, ForumViewHolder forumViewHolder) {
        String str;
        if (metaData == null || forumViewHolder == null) {
            return;
        }
        if (!StringUtils.isNull(metaData.getName_show())) {
            str = metaData.getName_show();
        } else {
            str = (metaData.getBaijiahaoInfo() == null || StringUtils.isNull(metaData.getBaijiahaoInfo().name)) ? "" : metaData.getBaijiahaoInfo().name;
        }
        forumViewHolder.f16313b.setText(str);
        if (metaData.isNewGod()) {
            SkinManager.setViewTextColor(forumViewHolder.f16313b, R.color.CAM_X0301);
        }
        forumViewHolder.f16313b.setOnClickListener(new c(metaData, forumViewHolder));
    }

    public void setData(List<MetaData> list) {
        this.f16310e = list;
    }
}
