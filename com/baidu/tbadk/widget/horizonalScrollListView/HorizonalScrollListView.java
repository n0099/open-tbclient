package com.baidu.tbadk.widget.horizonalScrollListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.j0.d3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13833e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f13834f;

    /* renamed from: g  reason: collision with root package name */
    public int f13835g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13836h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13837i;
    public View j;
    public String k;
    public String l;
    public BdUniqueId m;
    public String n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f13838a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13839b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f13840c;

        /* renamed from: d  reason: collision with root package name */
        public EntelechyUserLikeButton f13841d;

        public ItemViewHolder(View view) {
            super(view);
            this.f13838a = null;
            this.f13839b = null;
            this.f13840c = null;
            this.f13841d = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f13838a = barImageView;
            barImageView.setGifIconSupport(false);
            this.f13839b = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f13840c = (TbImageView) view.findViewById(R.id.hot_rank);
            this.f13841d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            HorizonalScrollListView.this.p(((Long) customResponsedMessage.getData()).longValue(), false);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            HorizonalScrollListView.this.p(((Long) customResponsedMessage.getData()).longValue(), true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* loaded from: classes3.dex */
        public class a extends e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LikeModel f13845a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EntelechyUserLikeButton f13846b;

            public a(LikeModel likeModel, EntelechyUserLikeButton entelechyUserLikeButton) {
                this.f13845a = likeModel;
                this.f13846b = entelechyUserLikeButton;
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                if ((obj instanceof w) && this.f13845a.getErrorCode() == 0) {
                    w wVar = (w) obj;
                    wVar.v(1);
                    HorizonalScrollListView.this.o(this.f13846b, wVar.l() == 1);
                } else if (AntiHelper.m(this.f13845a.getErrorCode(), this.f13845a.getErrorString())) {
                    AntiHelper.u(HorizonalScrollListView.this.f13836h.getPageActivity(), this.f13845a.getErrorString());
                } else {
                    HorizonalScrollListView.this.f13836h.showToast(this.f13845a.getErrorString());
                }
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                if (k.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.k)) {
                        TiebaStatic.log(new StatisticItem(HorizonalScrollListView.this.k).param("obj_type", 1).param("fid", valueOf));
                    }
                    LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.f13836h);
                    likeModel.setLoadDataCallBack(new a(likeModel, entelechyUserLikeButton));
                    likeModel.H(str, valueOf);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag(R.id.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
            if (k.isForumName(str)) {
                if (!TextUtils.isEmpty(HorizonalScrollListView.this.l)) {
                    TiebaStatic.log(new StatisticItem(HorizonalScrollListView.this.l).param("fid", valueOf));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.f13836h.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
            }
        }
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.f13834f = new ArrayList<>();
        this.f13835g = 3;
        this.f13837i = null;
        this.m = null;
        this.o = new a(2001336);
        this.p = new b(2001335);
        this.q = new c();
        this.r = new d();
        l(context);
    }

    public String getFrom() {
        return this.n;
    }

    public View getLastItemView() {
        return this.j;
    }

    public final View h() {
        return View.inflate(this.f13836h.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    public final void i(ItemViewHolder itemViewHolder) {
        if (itemViewHolder == null) {
            return;
        }
        this.j = itemViewHolder.a();
        itemViewHolder.f13841d.setVisibility(8);
        itemViewHolder.f13839b.setText(this.f13836h.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
        itemViewHolder.f13840c.setVisibility(8);
        itemViewHolder.f13838a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.f13838a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.f13839b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.f13838a, R.drawable.selector_load_more_bg);
        this.j.setClickable(true);
        this.j.setOnClickListener(this.f13837i);
    }

    public final void j(View view, d.a.i0.b1.g.a aVar) {
        if (aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f13838a.setTag(aVar.f48170b);
        itemViewHolder.f13838a.V(aVar.f48170b, 10, false);
        itemViewHolder.f13839b.setText(aVar.f48171c);
        itemViewHolder.f13839b.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f48172d));
        itemViewHolder.f13840c.setDefaultBgResource(0);
        itemViewHolder.f13840c.setDefaultResource(0);
        itemViewHolder.f13841d.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f48172d));
        itemViewHolder.f13841d.setTag(R.id.tag_forum_name, aVar.f48171c);
        itemViewHolder.a().setTag(R.id.tag_forum_id, Long.valueOf(aVar.f48172d));
        itemViewHolder.a().setTag(R.id.tag_forum_name, aVar.f48171c);
        o(itemViewHolder.f13841d, aVar.f48173e);
        int i2 = aVar.f48169a;
        if (i2 == 1) {
            itemViewHolder.f13840c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f13840c, R.drawable.icon_grade_shaitu1);
        } else if (i2 == 2) {
            itemViewHolder.f13840c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f13840c, R.drawable.icon_grade_shaitu2);
        } else if (i2 != 3) {
            itemViewHolder.f13840c.setVisibility(8);
        } else {
            itemViewHolder.f13840c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f13840c, R.drawable.icon_grade_shaitu3);
        }
        n(view, aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k(ItemViewHolder itemViewHolder, int i2) {
        if (itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        if (itemViewHolder.f13841d.getTag(R.id.forum_follow) != null && (itemViewHolder.f13841d.getTag(R.id.forum_follow) instanceof Boolean)) {
            o(itemViewHolder.f13841d, ((Boolean) itemViewHolder.f13841d.getTag(R.id.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.f13839b, R.color.CAM_X0105, 1);
    }

    public final void l(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f13833e = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f13833e.setOrientation(0);
        addView(this.f13833e);
    }

    public void m(int i2) {
        if (this.f13835g != i2) {
            Iterator<ItemViewHolder> it = this.f13834f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    k(next, i2);
                }
            }
            View view = this.j;
            if (view != null) {
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
                SkinManager.setViewTextColor((TextView) this.j.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            int count = ListUtils.getCount(this.f13834f);
            for (int i3 = 0; i3 < 3 && i3 < count; i3++) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f13834f, i3);
                if (itemViewHolder != null) {
                    int i4 = i3 + 1;
                    if (i4 == 1) {
                        SkinManager.setImageResource(itemViewHolder.f13840c, R.drawable.icon_grade_shaitu1);
                    } else if (i4 == 2) {
                        SkinManager.setImageResource(itemViewHolder.f13840c, R.drawable.icon_grade_shaitu2);
                    } else if (i4 == 3) {
                        SkinManager.setImageResource(itemViewHolder.f13840c, R.drawable.icon_grade_shaitu3);
                    }
                }
            }
            this.f13835g = i2;
        }
    }

    public final void n(View view, d.a.i0.b1.g.a aVar) {
        if (view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f13841d.setClickable(true);
        itemViewHolder.f13841d.setOnClickListener(this.q);
        view.setClickable(true);
        view.setOnClickListener(this.r);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }

    public final void p(long j, boolean z) {
        Iterator<ItemViewHolder> it = this.f13834f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.a() != null && next.f13839b.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.f13841d;
                if (((Long) next.f13839b.getTag(R.id.tag_forum_id)).longValue() == j) {
                    o(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    public void setData(List<d.a.i0.b1.g.a> list, TbPageContext<?> tbPageContext) {
        if (ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f13836h = tbPageContext;
        list.add(new d.a.i0.b1.g.a());
        int count = ListUtils.getCount(this.f13834f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f13834f, i2);
                if (viewHolder != null) {
                    this.f13833e.removeView(viewHolder.a());
                }
                this.f13834f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            d.a.i0.b1.g.a aVar = (d.a.i0.b1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f13834f, i3);
            if (itemViewHolder != null) {
                j(itemViewHolder.a(), aVar);
            } else {
                View h2 = h();
                if (h2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(h2);
                    this.f13834f.add(itemViewHolder2);
                    j(itemViewHolder2.a(), aVar);
                    this.f13833e.addView(h2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4) {
                i(this.f13834f.get(i4));
            }
        }
        this.f13836h.registerListener(this.o);
        this.f13836h.registerListener(this.p);
        if (getTag() != null) {
            this.o.setTag(getTag());
            this.p.setTag(getTag());
        }
        m(this.f13835g);
    }

    public void setFrom(String str) {
        this.n = str;
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.f13837i = onClickListener;
    }

    public void setStatKey(String str, String str2) {
        this.k = str;
        this.l = str2;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
        if (bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.p;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.o;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        return this.m;
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13834f = new ArrayList<>();
        this.f13835g = 3;
        this.f13837i = null;
        this.m = null;
        this.o = new a(2001336);
        this.p = new b(2001335);
        this.q = new c();
        this.r = new d();
        l(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13834f = new ArrayList<>();
        this.f13835g = 3;
        this.f13837i = null;
        this.m = null;
        this.o = new a(2001336);
        this.p = new b(2001335);
        this.q = new c();
        this.r = new d();
        l(context);
    }
}
