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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.m.f;
import d.b.h0.z0.l0;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f17004a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f17005b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f17006c;

    /* renamed from: d  reason: collision with root package name */
    public int f17007d = 3;

    /* renamed from: e  reason: collision with root package name */
    public List<MetaData> f17008e;

    /* renamed from: f  reason: collision with root package name */
    public f<MetaData> f17009f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17010a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17011b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17012c;

        /* renamed from: d  reason: collision with root package name */
        public HeadPendantClickableView f17013d;

        /* renamed from: e  reason: collision with root package name */
        public DynamicUserLikeButton f17014e;

        /* renamed from: f  reason: collision with root package name */
        public d.b.h0.r.f0.q.c f17015f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17016g;

        public ForumViewHolder(ConcernRecommendListAdapter concernRecommendListAdapter, View view) {
            super(view);
            this.f17016g = false;
            this.f17010a = (LinearLayout) view.findViewById(R.id.concern_container);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.f17013d = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.f17013d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f17013d.getHeadView().setDefaultResource(17170445);
            this.f17013d.getHeadView().setPlaceHolder(1);
            this.f17013d.getHeadView().setBorderWidth(l.g(concernRecommendListAdapter.f17004a, R.dimen.tbds1));
            this.f17013d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f17011b = (TextView) view.findViewById(R.id.concern_user_name);
            this.f17012c = (TextView) view.findViewById(R.id.concern_user_desc);
            this.f17014e = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.f17015f = new d.b.h0.r.f0.q.c(concernRecommendListAdapter.f17005b, this.f17014e);
        }

        public void a(int i) {
            if (!this.f17016g) {
                SkinManager.setViewTextColor(this.f17011b, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f17011b, R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.f17012c, R.color.CAM_X0109);
            this.f17014e.r(i);
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f17010a);
            a2.h(R.string.J_X05);
            a2.c(R.color.CAM_X0206);
        }

        public void b(boolean z) {
            this.f17016g = z;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f17017e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f17018f;

        public a(MetaData metaData, ForumViewHolder forumViewHolder) {
            this.f17017e = metaData;
            this.f17018f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            ConcernRecommendListAdapter.this.i(this.f17017e, this.f17018f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DynamicUserLikeButton.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MetaData f17020a;

        public b(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData) {
            this.f17020a = metaData;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            MetaData metaData = this.f17020a;
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
            statisticItem.param("obj_param1", this.f17020a.getUserId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f17021e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f17022f;

        public c(MetaData metaData, ForumViewHolder forumViewHolder) {
            this.f17021e = metaData;
            this.f17022f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData = this.f17021e;
            if (metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ConcernRecommendListAdapter.this.f17004a, this.f17021e.getUserId(), this.f17021e.getName_show())));
            ConcernRecommendListAdapter.this.i(this.f17021e, this.f17022f);
        }
    }

    public ConcernRecommendListAdapter(Context context) {
        this.f17004a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        List<MetaData> list;
        MetaData metaData;
        if (forumViewHolder == null || (list = this.f17008e) == null || (metaData = list.get(i)) == null) {
            return;
        }
        forumViewHolder.b(metaData.isNewGod());
        n(metaData, forumViewHolder);
        q(metaData, forumViewHolder);
        o(metaData, forumViewHolder);
        p(metaData, forumViewHolder);
        f<MetaData> fVar = this.f17009f;
        if (fVar != null) {
            fVar.c(forumViewHolder.itemView, metaData, i, i);
        }
        forumViewHolder.a(this.f17007d);
    }

    public void g(int i) {
        this.f17007d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MetaData> list = this.f17008e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this, LayoutInflater.from(this.f17004a).inflate(R.layout.concern_recommend_item, (ViewGroup) null));
    }

    public final void i(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (this.f17009f != null) {
            this.f17009f.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    public void j(boolean z) {
    }

    public void k(f<MetaData> fVar) {
        this.f17009f = fVar;
    }

    public void l(TbPageContext tbPageContext) {
        this.f17005b = tbPageContext;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f17006c = bdUniqueId;
    }

    public final void n(MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.f17013d.setData(metaData, true);
        forumViewHolder.f17013d.setAfterClickListener(new a(metaData, forumViewHolder));
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
        forumViewHolder.f17012c.setText(str);
    }

    public final void p(MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.f17014e.setOnClickEvent(new b(this, metaData));
        d.b.h0.r.f0.q.c cVar = forumViewHolder.f17015f;
        if (cVar != null) {
            cVar.l(this.f17006c);
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
        forumViewHolder.f17011b.setText(str);
        if (metaData.isNewGod()) {
            SkinManager.setViewTextColor(forumViewHolder.f17011b, R.color.CAM_X0301);
        }
        forumViewHolder.f17011b.setOnClickListener(new c(metaData, forumViewHolder));
    }

    public void setData(List<MetaData> list) {
        this.f17008e = list;
    }
}
