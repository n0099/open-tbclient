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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f14364a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<VisitedForumData> f14365b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14366c;

    /* renamed from: d  reason: collision with root package name */
    public a f14367d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f14368e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14369f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14370a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14371b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14372c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f14373d;

        /* renamed from: e  reason: collision with root package name */
        public MessageRedDotView f14374e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14375f;

        /* renamed from: g  reason: collision with root package name */
        public LinearGradientView f14376g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14377h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f14378i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f14367d != null) {
                    RecentlyVisitedForumListAdapter.this.f14367d.a(ForumViewHolder.this);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnLongClickListener {
            public b(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f14368e != null) {
                    RecentlyVisitedForumListAdapter.this.f14368e.onLongClick(view);
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
                if (RecentlyVisitedForumListAdapter.this.f14369f != null) {
                    RecentlyVisitedForumListAdapter.this.f14369f.onClick(view);
                }
            }
        }

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new a(RecentlyVisitedForumListAdapter.this));
            view.setOnLongClickListener(new b(RecentlyVisitedForumListAdapter.this));
            this.f14370a = view.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_image);
            this.f14373d = barImageView;
            barImageView.setPlaceHolderAutoChangeSkinType(1);
            this.f14371b = (TextView) view.findViewById(R.id.forum_name);
            this.f14374e = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.f14372c = (TextView) view.findViewById(R.id.forum_follow);
            LinearGradientView linearGradientView = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.f14376g = linearGradientView;
            linearGradientView.setCornerRadius(l.g(RecentlyVisitedForumListAdapter.this.f14364a.getPageActivity(), R.dimen.tbds10));
            this.f14376g.setRoundMode(3);
            this.f14376g.setVisibility(8);
            this.f14374e.setThreeDotMode(2);
            this.f14374e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.delete_image);
            this.f14375f = imageView;
            imageView.setOnClickListener(new c(RecentlyVisitedForumListAdapter.this));
            this.f14377h = (TextView) view.findViewById(R.id.live_label_view);
            this.f14378i = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.f14364a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        LinkedList<VisitedForumData> linkedList;
        if (forumViewHolder == null || (linkedList = this.f14365b) == null || linkedList.get(i2) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.f14365b.get(i2);
        forumViewHolder.itemView.setTag(visitedForumData);
        o(visitedForumData, forumViewHolder);
        n(visitedForumData, forumViewHolder);
        p(visitedForumData, forumViewHolder);
        forumViewHolder.f14373d.V(visitedForumData.u(), 10, false);
        forumViewHolder.f14373d.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.f14373d.setStrokeWith(3);
        forumViewHolder.f14373d.setShowOval(true);
        q(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.f14375f, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.f14371b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.f14372c, R.color.CAM_X0109);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f14364a.getPageActivity(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(this.f14364a.getPageActivity(), R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f14364a.getPageActivity(), R.dimen.tbds5)).into(forumViewHolder.f14378i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        LinkedList<VisitedForumData> linkedList = this.f14365b;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ForumViewHolder(this.f14364a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    public void i(LinkedList<VisitedForumData> linkedList) {
        this.f14365b = linkedList;
    }

    public void j(View.OnClickListener onClickListener) {
        this.f14369f = onClickListener;
    }

    public void k(boolean z) {
        this.f14366c = z;
        notifyDataSetChanged();
    }

    public void l(a aVar) {
        this.f14367d = aVar;
    }

    public void m(View.OnLongClickListener onLongClickListener) {
        this.f14368e = onLongClickListener;
    }

    public final void n(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int t = visitedForumData.t();
        TextView textView = forumViewHolder.f14372c;
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
        forumViewHolder.f14371b.setText(forumName);
    }

    public final void p(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f14374e.setVisibility(8);
        forumViewHolder.f14375f.setVisibility(8);
        forumViewHolder.f14377h.setVisibility(8);
        if (this.f14366c) {
            forumViewHolder.f14375f.setVisibility(0);
            forumViewHolder.f14375f.setTag(visitedForumData);
        } else if (!visitedForumData.B()) {
            if (visitedForumData.x() <= 0) {
                forumViewHolder.f14374e.setVisibility(8);
                return;
            }
            forumViewHolder.f14374e.setVisibility(0);
            forumViewHolder.f14374e.f(visitedForumData.x());
        } else {
            forumViewHolder.f14377h.setVisibility(0);
        }
    }

    public final void q(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        ThemeColorInfo z = visitedForumData.z();
        if (z == null) {
            forumViewHolder.f14376g.setVisibility(0);
            forumViewHolder.f14376g.setDefaultGradientColor();
            return;
        }
        LinearGradientView linearGradientView = forumViewHolder.f14376g;
        if (linearGradientView != null) {
            linearGradientView.setGradientColor(z.day, z.night, z.dark);
            forumViewHolder.f14376g.setVisibility(0);
        }
    }
}
