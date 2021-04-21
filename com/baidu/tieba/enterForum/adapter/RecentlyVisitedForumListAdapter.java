package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f15026a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<VisitedForumData> f15027b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15028c;

    /* renamed from: d  reason: collision with root package name */
    public a f15029d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f15030e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f15031f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15032a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15033b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15034c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f15035d;

        /* renamed from: e  reason: collision with root package name */
        public MessageRedDotView f15036e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f15037f;

        /* renamed from: g  reason: collision with root package name */
        public LinearGradientView f15038g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15039h;
        public LinearLayout i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f15029d != null) {
                    RecentlyVisitedForumListAdapter.this.f15029d.a(ForumViewHolder.this);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnLongClickListener {
            public b(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f15030e != null) {
                    RecentlyVisitedForumListAdapter.this.f15030e.onLongClick(view);
                    return true;
                }
                return true;
            }
        }

        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            public c(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f15031f != null) {
                    RecentlyVisitedForumListAdapter.this.f15031f.onClick(view);
                }
            }
        }

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new a(RecentlyVisitedForumListAdapter.this));
            view.setOnLongClickListener(new b(RecentlyVisitedForumListAdapter.this));
            this.f15032a = view.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_image);
            this.f15035d = barImageView;
            barImageView.setPlaceHolderAutoChangeSkinType(1);
            this.f15033b = (TextView) view.findViewById(R.id.forum_name);
            this.f15036e = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.f15034c = (TextView) view.findViewById(R.id.forum_follow);
            LinearGradientView linearGradientView = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.f15038g = linearGradientView;
            linearGradientView.setCornerRadius(l.g(RecentlyVisitedForumListAdapter.this.f15026a.getPageActivity(), R.dimen.tbds10));
            this.f15038g.setRoundMode(3);
            this.f15038g.setVisibility(8);
            this.f15036e.setThreeDotMode(2);
            this.f15036e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.delete_image);
            this.f15037f = imageView;
            imageView.setOnClickListener(new c(RecentlyVisitedForumListAdapter.this));
            this.f15039h = (TextView) view.findViewById(R.id.live_label_view);
            this.i = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.f15026a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        LinkedList<VisitedForumData> linkedList;
        if (forumViewHolder == null || (linkedList = this.f15027b) == null || linkedList.get(i) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.f15027b.get(i);
        forumViewHolder.itemView.setTag(visitedForumData);
        o(visitedForumData, forumViewHolder);
        n(visitedForumData, forumViewHolder);
        p(visitedForumData, forumViewHolder);
        forumViewHolder.f15035d.W(visitedForumData.u(), 10, false);
        forumViewHolder.f15035d.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.f15035d.setStrokeWith(3);
        forumViewHolder.f15035d.setShowOval(true);
        q(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.f15037f, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.f15033b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.f15034c, R.color.CAM_X0109);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f15026a.getPageActivity(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(this.f15026a.getPageActivity(), R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f15026a.getPageActivity(), R.dimen.tbds5)).into(forumViewHolder.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        LinkedList<VisitedForumData> linkedList = this.f15027b;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.f15026a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    public void i(LinkedList<VisitedForumData> linkedList) {
        this.f15027b = linkedList;
    }

    public void j(View.OnClickListener onClickListener) {
        this.f15031f = onClickListener;
    }

    public void k(boolean z) {
        this.f15028c = z;
        notifyDataSetChanged();
    }

    public void l(a aVar) {
        this.f15029d = aVar;
    }

    public void m(View.OnLongClickListener onLongClickListener) {
        this.f15030e = onLongClickListener;
    }

    public final void n(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int t = visitedForumData.t();
        TextView textView = forumViewHolder.f15034c;
        textView.setText("关注 " + StringHelper.numFormatOverWanNa(t));
    }

    public final void o(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        String forumName = visitedForumData.getForumName();
        if (k.isEmpty(forumName)) {
            forumName = "";
        }
        forumViewHolder.f15033b.setText(forumName);
    }

    public final void p(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f15036e.setVisibility(8);
        forumViewHolder.f15037f.setVisibility(8);
        forumViewHolder.f15039h.setVisibility(8);
        if (this.f15028c) {
            forumViewHolder.f15037f.setVisibility(0);
            forumViewHolder.f15037f.setTag(visitedForumData);
        } else if (!visitedForumData.B()) {
            if (visitedForumData.x() <= 0) {
                forumViewHolder.f15036e.setVisibility(8);
                return;
            }
            forumViewHolder.f15036e.setVisibility(0);
            forumViewHolder.f15036e.f(visitedForumData.x());
        } else {
            forumViewHolder.f15039h.setVisibility(0);
        }
    }

    public final void q(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        ThemeColorInfo z = visitedForumData.z();
        if (z == null) {
            forumViewHolder.f15038g.setVisibility(0);
            forumViewHolder.f15038g.setDefaultGradientColor();
            return;
        }
        LinearGradientView linearGradientView = forumViewHolder.f15038g;
        if (linearGradientView != null) {
            linearGradientView.setGradientColor(z.day, z.night, z.dark);
            forumViewHolder.f15038g.setVisibility(0);
        }
    }
}
