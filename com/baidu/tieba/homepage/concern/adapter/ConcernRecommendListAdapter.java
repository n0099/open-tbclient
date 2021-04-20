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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.m.f;
import d.b.h0.z0.l0;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f16678a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f16679b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f16680c;

    /* renamed from: d  reason: collision with root package name */
    public int f16681d = 3;

    /* renamed from: e  reason: collision with root package name */
    public List<MetaData> f16682e;

    /* renamed from: f  reason: collision with root package name */
    public f<MetaData> f16683f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16684a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16685b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16686c;

        /* renamed from: d  reason: collision with root package name */
        public HeadPendantClickableView f16687d;

        /* renamed from: e  reason: collision with root package name */
        public DynamicUserLikeButton f16688e;

        /* renamed from: f  reason: collision with root package name */
        public d.b.h0.r.f0.q.c f16689f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16690g;

        public ForumViewHolder(ConcernRecommendListAdapter concernRecommendListAdapter, View view) {
            super(view);
            this.f16690g = false;
            this.f16684a = (LinearLayout) view.findViewById(R.id.concern_container);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.f16687d = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.f16687d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16687d.getHeadView().setDefaultResource(17170445);
            this.f16687d.getHeadView().setPlaceHolder(1);
            this.f16687d.getHeadView().setBorderWidth(l.g(concernRecommendListAdapter.f16678a, R.dimen.tbds1));
            this.f16687d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f16685b = (TextView) view.findViewById(R.id.concern_user_name);
            this.f16686c = (TextView) view.findViewById(R.id.concern_user_desc);
            this.f16688e = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.f16689f = new d.b.h0.r.f0.q.c(concernRecommendListAdapter.f16679b, this.f16688e);
        }

        public void a(int i) {
            if (!this.f16690g) {
                SkinManager.setViewTextColor(this.f16685b, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f16685b, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f16686c, R.color.CAM_X0109);
            this.f16688e.r(i);
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f16684a);
            d2.k(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
        }

        public void b(boolean z) {
            this.f16690g = z;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f16691e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f16692f;

        public a(MetaData metaData, ForumViewHolder forumViewHolder) {
            this.f16691e = metaData;
            this.f16692f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            ConcernRecommendListAdapter.this.i(this.f16691e, this.f16692f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DynamicUserLikeButton.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MetaData f16694a;

        public b(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData) {
            this.f16694a = metaData;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            MetaData metaData = this.f16694a;
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
            statisticItem.param("obj_param1", this.f16694a.getUserId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f16695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f16696f;

        public c(MetaData metaData, ForumViewHolder forumViewHolder) {
            this.f16695e = metaData;
            this.f16696f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData = this.f16695e;
            if (metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ConcernRecommendListAdapter.this.f16678a, this.f16695e.getUserId(), this.f16695e.getName_show())));
            ConcernRecommendListAdapter.this.i(this.f16695e, this.f16696f);
        }
    }

    public ConcernRecommendListAdapter(Context context) {
        this.f16678a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        List<MetaData> list;
        MetaData metaData;
        if (forumViewHolder == null || (list = this.f16682e) == null || (metaData = list.get(i)) == null) {
            return;
        }
        forumViewHolder.b(metaData.isNewGod());
        n(metaData, forumViewHolder);
        q(metaData, forumViewHolder);
        o(metaData, forumViewHolder);
        p(metaData, forumViewHolder);
        f<MetaData> fVar = this.f16683f;
        if (fVar != null) {
            fVar.c(forumViewHolder.itemView, metaData, i, i);
        }
        forumViewHolder.a(this.f16681d);
    }

    public void g(int i) {
        this.f16681d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MetaData> list = this.f16682e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this, LayoutInflater.from(this.f16678a).inflate(R.layout.concern_recommend_item, (ViewGroup) null));
    }

    public final void i(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (this.f16683f != null) {
            this.f16683f.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    public void j(boolean z) {
    }

    public void k(f<MetaData> fVar) {
        this.f16683f = fVar;
    }

    public void l(TbPageContext tbPageContext) {
        this.f16679b = tbPageContext;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f16680c = bdUniqueId;
    }

    public final void n(MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.f16687d.setData(metaData, true);
        forumViewHolder.f16687d.setAfterClickListener(new a(metaData, forumViewHolder));
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
                str = fieldName + l0.c(metaData.isVideoGod());
            }
        }
        forumViewHolder.f16686c.setText(str);
    }

    public final void p(MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.f16688e.setOnClickEvent(new b(this, metaData));
        d.b.h0.r.f0.q.c cVar = forumViewHolder.f16689f;
        if (cVar != null) {
            cVar.l(this.f16680c);
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
        forumViewHolder.f16685b.setText(str);
        if (metaData.isNewGod()) {
            SkinManager.setViewTextColor(forumViewHolder.f16685b, R.color.CAM_X0301);
        }
        forumViewHolder.f16685b.setOnClickListener(new c(metaData, forumViewHolder));
    }

    public void setData(List<MetaData> list) {
        this.f16682e = list;
    }
}
