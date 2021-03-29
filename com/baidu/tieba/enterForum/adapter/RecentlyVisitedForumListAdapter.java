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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f15355a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<VisitedForumData> f15356b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15357c;

    /* renamed from: d  reason: collision with root package name */
    public a f15358d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f15359e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f15360f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f15361a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15362b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15363c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f15364d;

        /* renamed from: e  reason: collision with root package name */
        public MessageRedDotView f15365e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f15366f;

        /* renamed from: g  reason: collision with root package name */
        public LinearGradientView f15367g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15368h;
        public LinearLayout i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f15358d != null) {
                    RecentlyVisitedForumListAdapter.this.f15358d.a(ForumViewHolder.this);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnLongClickListener {
            public b(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f15359e != null) {
                    RecentlyVisitedForumListAdapter.this.f15359e.onLongClick(view);
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
                if (RecentlyVisitedForumListAdapter.this.f15360f != null) {
                    RecentlyVisitedForumListAdapter.this.f15360f.onClick(view);
                }
            }
        }

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new a(RecentlyVisitedForumListAdapter.this));
            view.setOnLongClickListener(new b(RecentlyVisitedForumListAdapter.this));
            this.f15361a = view.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_image);
            this.f15364d = barImageView;
            barImageView.setPlaceHolderAutoChangeSkinType(1);
            this.f15362b = (TextView) view.findViewById(R.id.forum_name);
            this.f15365e = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.f15363c = (TextView) view.findViewById(R.id.forum_follow);
            LinearGradientView linearGradientView = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.f15367g = linearGradientView;
            linearGradientView.setCornerRadius(l.g(RecentlyVisitedForumListAdapter.this.f15355a.getPageActivity(), R.dimen.tbds10));
            this.f15367g.setRoundMode(3);
            this.f15367g.setVisibility(8);
            this.f15365e.setThreeDotMode(2);
            this.f15365e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.delete_image);
            this.f15366f = imageView;
            imageView.setOnClickListener(new c(RecentlyVisitedForumListAdapter.this));
            this.f15368h = (TextView) view.findViewById(R.id.live_label_view);
            this.i = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.f15355a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        LinkedList<VisitedForumData> linkedList;
        if (forumViewHolder == null || (linkedList = this.f15356b) == null || linkedList.get(i) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.f15356b.get(i);
        forumViewHolder.itemView.setTag(visitedForumData);
        o(visitedForumData, forumViewHolder);
        n(visitedForumData, forumViewHolder);
        p(visitedForumData, forumViewHolder);
        forumViewHolder.f15364d.W(visitedForumData.u(), 10, false);
        forumViewHolder.f15364d.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.f15364d.setStrokeWith(3);
        forumViewHolder.f15364d.setShowOval(true);
        q(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.f15366f, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.f15362b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.f15363c, R.color.CAM_X0109);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f15355a.getPageActivity(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(this.f15355a.getPageActivity(), R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f15355a.getPageActivity(), R.dimen.tbds5)).into(forumViewHolder.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        LinkedList<VisitedForumData> linkedList = this.f15356b;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.f15355a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    public void i(LinkedList<VisitedForumData> linkedList) {
        this.f15356b = linkedList;
    }

    public void j(View.OnClickListener onClickListener) {
        this.f15360f = onClickListener;
    }

    public void k(boolean z) {
        this.f15357c = z;
        notifyDataSetChanged();
    }

    public void l(a aVar) {
        this.f15358d = aVar;
    }

    public void m(View.OnLongClickListener onLongClickListener) {
        this.f15359e = onLongClickListener;
    }

    public final void n(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int t = visitedForumData.t();
        TextView textView = forumViewHolder.f15363c;
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
        forumViewHolder.f15362b.setText(forumName);
    }

    public final void p(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f15365e.setVisibility(8);
        forumViewHolder.f15366f.setVisibility(8);
        forumViewHolder.f15368h.setVisibility(8);
        if (this.f15357c) {
            forumViewHolder.f15366f.setVisibility(0);
            forumViewHolder.f15366f.setTag(visitedForumData);
        } else if (!visitedForumData.B()) {
            if (visitedForumData.x() <= 0) {
                forumViewHolder.f15365e.setVisibility(8);
                return;
            }
            forumViewHolder.f15365e.setVisibility(0);
            forumViewHolder.f15365e.f(visitedForumData.x());
        } else {
            forumViewHolder.f15368h.setVisibility(0);
        }
    }

    public final void q(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        ThemeColorInfo z = visitedForumData.z();
        if (z == null) {
            forumViewHolder.f15367g.setVisibility(0);
            forumViewHolder.f15367g.setDefaultGradientColor();
            return;
        }
        LinearGradientView linearGradientView = forumViewHolder.f15367g;
        if (linearGradientView != null) {
            linearGradientView.setGradientColor(z.day, z.night, z.dark);
            forumViewHolder.f15367g.setVisibility(0);
        }
    }
}
