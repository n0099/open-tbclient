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
import d.b.b.a.e;
import d.b.b.e.p.k;
import d.b.i0.c3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14132e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f14133f;

    /* renamed from: g  reason: collision with root package name */
    public int f14134g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f14135h;
    public View.OnClickListener i;
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
        public BarImageView f14136a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14137b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f14138c;

        /* renamed from: d  reason: collision with root package name */
        public EntelechyUserLikeButton f14139d;

        public ItemViewHolder(View view) {
            super(view);
            this.f14136a = null;
            this.f14137b = null;
            this.f14138c = null;
            this.f14139d = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f14136a = barImageView;
            barImageView.setGifIconSupport(false);
            this.f14137b = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f14138c = (TbImageView) view.findViewById(R.id.hot_rank);
            this.f14139d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
        public b(int i) {
            super(i);
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
            public final /* synthetic */ LikeModel f14143a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EntelechyUserLikeButton f14144b;

            public a(LikeModel likeModel, EntelechyUserLikeButton entelechyUserLikeButton) {
                this.f14143a = likeModel;
                this.f14144b = entelechyUserLikeButton;
            }

            @Override // d.b.b.a.e
            public void c(Object obj) {
                if ((obj instanceof w) && this.f14143a.getErrorCode() == 0) {
                    w wVar = (w) obj;
                    wVar.v(1);
                    HorizonalScrollListView.this.o(this.f14144b, wVar.l() == 1);
                } else if (AntiHelper.m(this.f14143a.getErrorCode(), this.f14143a.getErrorString())) {
                    AntiHelper.u(HorizonalScrollListView.this.f14135h.getPageActivity(), this.f14143a.getErrorString());
                } else {
                    HorizonalScrollListView.this.f14135h.showToast(this.f14143a.getErrorString());
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
                    LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.f14135h);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.f14135h.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
            }
        }
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.f14133f = new ArrayList<>();
        this.f14134g = 3;
        this.i = null;
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
        return View.inflate(this.f14135h.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    public final void i(ItemViewHolder itemViewHolder) {
        if (itemViewHolder == null) {
            return;
        }
        this.j = itemViewHolder.a();
        itemViewHolder.f14139d.setVisibility(8);
        itemViewHolder.f14137b.setText(this.f14135h.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
        itemViewHolder.f14138c.setVisibility(8);
        itemViewHolder.f14136a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.f14136a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.f14137b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.f14136a, R.drawable.selector_load_more_bg);
        this.j.setClickable(true);
        this.j.setOnClickListener(this.i);
    }

    public final void j(View view, d.b.h0.b1.g.a aVar) {
        if (aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f14136a.setTag(aVar.f49880b);
        itemViewHolder.f14136a.W(aVar.f49880b, 10, false);
        itemViewHolder.f14137b.setText(aVar.f49881c);
        itemViewHolder.f14137b.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f49882d));
        itemViewHolder.f14138c.setDefaultBgResource(0);
        itemViewHolder.f14138c.setDefaultResource(0);
        itemViewHolder.f14139d.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f49882d));
        itemViewHolder.f14139d.setTag(R.id.tag_forum_name, aVar.f49881c);
        itemViewHolder.a().setTag(R.id.tag_forum_id, Long.valueOf(aVar.f49882d));
        itemViewHolder.a().setTag(R.id.tag_forum_name, aVar.f49881c);
        o(itemViewHolder.f14139d, aVar.f49883e);
        int i = aVar.f49879a;
        if (i == 1) {
            itemViewHolder.f14138c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f14138c, R.drawable.icon_grade_shaitu1);
        } else if (i == 2) {
            itemViewHolder.f14138c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f14138c, R.drawable.icon_grade_shaitu2);
        } else if (i != 3) {
            itemViewHolder.f14138c.setVisibility(8);
        } else {
            itemViewHolder.f14138c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f14138c, R.drawable.icon_grade_shaitu3);
        }
        n(view, aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k(ItemViewHolder itemViewHolder, int i) {
        if (itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        if (itemViewHolder.f14139d.getTag(R.id.forum_follow) != null && (itemViewHolder.f14139d.getTag(R.id.forum_follow) instanceof Boolean)) {
            o(itemViewHolder.f14139d, ((Boolean) itemViewHolder.f14139d.getTag(R.id.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.f14137b, R.color.CAM_X0105, 1);
    }

    public final void l(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f14132e = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f14132e.setOrientation(0);
        addView(this.f14132e);
    }

    public void m(int i) {
        if (this.f14134g != i) {
            Iterator<ItemViewHolder> it = this.f14133f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    k(next, i);
                }
            }
            View view = this.j;
            if (view != null) {
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
                SkinManager.setViewTextColor((TextView) this.j.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            int count = ListUtils.getCount(this.f14133f);
            for (int i2 = 0; i2 < 3 && i2 < count; i2++) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f14133f, i2);
                if (itemViewHolder != null) {
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        SkinManager.setImageResource(itemViewHolder.f14138c, R.drawable.icon_grade_shaitu1);
                    } else if (i3 == 2) {
                        SkinManager.setImageResource(itemViewHolder.f14138c, R.drawable.icon_grade_shaitu2);
                    } else if (i3 == 3) {
                        SkinManager.setImageResource(itemViewHolder.f14138c, R.drawable.icon_grade_shaitu3);
                    }
                }
            }
            this.f14134g = i;
        }
    }

    public final void n(View view, d.b.h0.b1.g.a aVar) {
        if (view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f14139d.setClickable(true);
        itemViewHolder.f14139d.setOnClickListener(this.q);
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
        Iterator<ItemViewHolder> it = this.f14133f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.a() != null && next.f14137b.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.f14139d;
                if (((Long) next.f14137b.getTag(R.id.tag_forum_id)).longValue() == j) {
                    o(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    public void setData(List<d.b.h0.b1.g.a> list, TbPageContext<?> tbPageContext) {
        if (ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f14135h = tbPageContext;
        list.add(new d.b.h0.b1.g.a());
        int count = ListUtils.getCount(this.f14133f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i = 0; i < count - count2; i++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f14133f, i);
                if (viewHolder != null) {
                    this.f14132e.removeView(viewHolder.a());
                }
                this.f14133f.remove(viewHolder);
            }
        }
        for (int i2 = 0; i2 < count2; i2++) {
            d.b.h0.b1.g.a aVar = (d.b.h0.b1.g.a) ListUtils.getItem(list, i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f14133f, i2);
            if (itemViewHolder != null) {
                j(itemViewHolder.a(), aVar);
            } else {
                View h2 = h();
                if (h2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(h2);
                    this.f14133f.add(itemViewHolder2);
                    j(itemViewHolder2.a(), aVar);
                    this.f14132e.addView(h2);
                }
            }
            int i3 = count2 - 1;
            if (i2 == i3) {
                i(this.f14133f.get(i3));
            }
        }
        this.f14135h.registerListener(this.o);
        this.f14135h.registerListener(this.p);
        if (getTag() != null) {
            this.o.setTag(getTag());
            this.p.setTag(getTag());
        }
        m(this.f14134g);
    }

    public void setFrom(String str) {
        this.n = str;
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
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
        this.f14133f = new ArrayList<>();
        this.f14134g = 3;
        this.i = null;
        this.m = null;
        this.o = new a(2001336);
        this.p = new b(2001335);
        this.q = new c();
        this.r = new d();
        l(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14133f = new ArrayList<>();
        this.f14134g = 3;
        this.i = null;
        this.m = null;
        this.o = new a(2001336);
        this.p = new b(2001335);
        this.q = new c();
        this.r = new d();
        l(context);
    }
}
