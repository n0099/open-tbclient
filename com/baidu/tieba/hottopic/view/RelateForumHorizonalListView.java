package com.baidu.tieba.hottopic.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.n0.e3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16947e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f16948f;

    /* renamed from: g  reason: collision with root package name */
    public int f16949g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f16950h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f16951i;
    public View j;
    public BdUniqueId k;
    public String l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f16952a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16953b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16954c;

        public ItemViewHolder(View view) {
            super(view);
            this.f16952a = null;
            this.f16953b = null;
            this.f16954c = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f16952a = barImageView;
            barImageView.setGifIconSupport(false);
            this.f16953b = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f16954c = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }

    /* loaded from: classes4.dex */
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
            RelateForumHorizonalListView.this.o(((Long) customResponsedMessage.getData()).longValue(), false);
        }
    }

    /* loaded from: classes4.dex */
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
            RelateForumHorizonalListView.this.o(((Long) customResponsedMessage.getData()).longValue(), true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a extends e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LikeModel f16958a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TextView f16959b;

            public a(LikeModel likeModel, TextView textView) {
                this.f16958a = likeModel;
                this.f16959b = textView;
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                if ((obj instanceof w) && this.f16958a.getErrorCode() == 0) {
                    w wVar = (w) obj;
                    wVar.v(1);
                    RelateForumHorizonalListView.this.n(this.f16959b, wVar.l() == 1);
                } else if (AntiHelper.m(this.f16958a.getErrorCode(), this.f16958a.getErrorString())) {
                    AntiHelper.u(RelateForumHorizonalListView.this.f16950h.getPageActivity(), this.f16958a.getErrorString());
                } else {
                    RelateForumHorizonalListView.this.f16950h.showToast(this.f16958a.getErrorString());
                }
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (!ViewHelper.checkUpIsLogin(RelateForumHorizonalListView.this.getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            String str2 = (String) view.getTag(R.id.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
            TextView textView = (TextView) view;
            if (k.isForumName(str2)) {
                Object orignalPage = RelateForumHorizonalListView.this.f16950h.getOrignalPage();
                String str3 = "";
                if (orignalPage instanceof HotTopicActivity) {
                    HotTopicActivity hotTopicActivity = (HotTopicActivity) orignalPage;
                    str3 = hotTopicActivity.getTopicName();
                    str = hotTopicActivity.getHotTopicId();
                } else {
                    str = "";
                }
                TiebaStatic.log(new StatisticItem("c10815").param("obj_locate", 2).param("obj_name", str3).param("topic_id", str));
                LikeModel likeModel = new LikeModel(RelateForumHorizonalListView.this.f16950h);
                likeModel.setLoadDataCallBack(new a(likeModel, textView));
                likeModel.L(str2, valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = (String) view.getTag(R.id.tag_forum_name);
            if (k.isForumName(str2)) {
                Object orignalPage = RelateForumHorizonalListView.this.f16950h.getOrignalPage();
                String str3 = "";
                if (orignalPage instanceof HotTopicActivity) {
                    HotTopicActivity hotTopicActivity = (HotTopicActivity) orignalPage;
                    str3 = hotTopicActivity.getTopicName();
                    str = hotTopicActivity.getHotTopicId();
                } else {
                    str = "";
                }
                TiebaStatic.log(new StatisticItem("c10815").param("obj_locate", 1).param("obj_name", str3).param("topic_id", str));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(RelateForumHorizonalListView.this.f16950h.getPageActivity()).createNormalCfg(str2, RelateForumHorizonalListView.this.getFrom())));
            }
        }
    }

    public RelateForumHorizonalListView(Context context) {
        super(context);
        this.f16948f = new ArrayList<>();
        this.f16949g = 3;
        this.f16951i = null;
        this.k = null;
        this.m = new a(2001336);
        this.n = new b(2001335);
        this.o = new c();
        this.p = new d();
        k(context);
    }

    public final View f() {
        return View.inflate(this.f16950h.getPageActivity(), R.layout.extend_forum_item, null);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder) {
        if (itemViewHolder == null) {
            return;
        }
        this.j = itemViewHolder.a();
        itemViewHolder.f16954c.setVisibility(8);
        itemViewHolder.f16953b.setText(this.f16950h.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
        itemViewHolder.f16952a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.f16952a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.f16953b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.f16952a, R.drawable.selector_load_more_bg);
        this.j.setClickable(true);
        this.j.setOnClickListener(this.f16951i);
    }

    public String getFrom() {
        return this.l;
    }

    public View getLastItemView() {
        return this.j;
    }

    public final void h(View view, d.a.m0.b1.g.a aVar) {
        if (aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f16952a.setTag(aVar.f52697b);
        itemViewHolder.f16952a.U(aVar.f52697b, 10, false);
        itemViewHolder.f16953b.setText(i(aVar.f52698c, 8));
        itemViewHolder.f16953b.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f52699d));
        itemViewHolder.f16954c.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f52699d));
        itemViewHolder.f16954c.setTag(R.id.tag_forum_name, aVar.f52698c);
        itemViewHolder.a().setTag(R.id.tag_forum_id, Long.valueOf(aVar.f52699d));
        itemViewHolder.a().setTag(R.id.tag_forum_name, aVar.f52698c);
        n(itemViewHolder.f16954c, aVar.f52700e);
        m(view, aVar);
    }

    public final String i(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() <= i2) {
            return str;
        }
        String substring = str.substring(0, i2 - 1);
        if (this.f16950h != null) {
            return substring + this.f16950h.getString(R.string.ellipsis);
        }
        return substring;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void j(ItemViewHolder itemViewHolder, int i2) {
        if (itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        if (itemViewHolder.f16954c.getTag(R.id.forum_follow) != null && (itemViewHolder.f16954c.getTag(R.id.forum_follow) instanceof Boolean)) {
            n(itemViewHolder.f16954c, ((Boolean) itemViewHolder.f16954c.getTag(R.id.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.f16953b, R.color.CAM_X0105, 1);
    }

    public final void k(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f16947e = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f16947e.setOrientation(0);
        addView(this.f16947e);
    }

    @SuppressLint({"ResourceAsColor"})
    public void l(int i2) {
        if (this.f16949g != i2) {
            Iterator<ItemViewHolder> it = this.f16948f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    j(next, i2);
                }
            }
            View view = this.j;
            if (view != null) {
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
                SkinManager.setViewTextColor((TextView) this.j.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            this.f16949g = i2;
        }
    }

    public final void m(View view, d.a.m0.b1.g.a aVar) {
        if (view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f16954c.setClickable(true);
        itemViewHolder.f16954c.setOnClickListener(this.o);
        view.setClickable(true);
        view.setOnClickListener(this.p);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void n(TextView textView, boolean z) {
        textView.setTag(R.id.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    public final void o(long j, boolean z) {
        Iterator<ItemViewHolder> it = this.f16948f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null && next.a() != null && next.f16953b.getTag(R.id.tag_forum_id) != null) {
                TextView textView = next.f16954c;
                if (((Long) next.f16953b.getTag(R.id.tag_forum_id)).longValue() == j) {
                    n(textView, z);
                    return;
                }
            }
        }
    }

    public void setData(List<d.a.m0.b1.g.a> list, TbPageContext<?> tbPageContext, boolean z) {
        if (ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f16950h = tbPageContext;
        if (z) {
            list.add(new d.a.m0.b1.g.a());
        }
        int count = ListUtils.getCount(this.f16948f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f16948f, i2);
                if (viewHolder != null) {
                    this.f16947e.removeView(viewHolder.a());
                }
                this.f16948f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            d.a.m0.b1.g.a aVar = (d.a.m0.b1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f16948f, i3);
            if (itemViewHolder != null) {
                h(itemViewHolder.a(), aVar);
            } else {
                View f2 = f();
                if (f2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(f2);
                    this.f16948f.add(itemViewHolder2);
                    h(itemViewHolder2.a(), aVar);
                    this.f16947e.addView(f2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4 && z) {
                g(this.f16948f.get(i4));
            }
        }
        this.f16950h.registerListener(this.m);
        this.f16950h.registerListener(this.n);
        if (getTag() != null) {
            this.m.setTag(getTag());
            this.n.setTag(getTag());
        }
        l(this.f16949g);
    }

    public void setFrom(String str) {
        this.l = str;
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.f16951i = onClickListener;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.k = bdUniqueId;
        if (bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.n;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.m;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(this.k);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        return this.k;
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16948f = new ArrayList<>();
        this.f16949g = 3;
        this.f16951i = null;
        this.k = null;
        this.m = new a(2001336);
        this.n = new b(2001335);
        this.o = new c();
        this.p = new d();
        k(context);
    }

    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16948f = new ArrayList<>();
        this.f16949g = 3;
        this.f16951i = null;
        this.k = null;
        this.m = new a(2001336);
        this.n = new b(2001335);
        this.o = new c();
        this.p = new d();
        k(context);
    }
}
