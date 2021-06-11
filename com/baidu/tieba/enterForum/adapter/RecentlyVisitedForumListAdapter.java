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
    public TbPageContext<?> f14421a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<VisitedForumData> f14422b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14423c;

    /* renamed from: d  reason: collision with root package name */
    public a f14424d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f14425e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14426f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14427a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14428b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14429c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f14430d;

        /* renamed from: e  reason: collision with root package name */
        public MessageRedDotView f14431e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f14432f;

        /* renamed from: g  reason: collision with root package name */
        public LinearGradientView f14433g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14434h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f14435i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f14424d != null) {
                    RecentlyVisitedForumListAdapter.this.f14424d.a(ForumViewHolder.this);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnLongClickListener {
            public b(RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (RecentlyVisitedForumListAdapter.this.f14425e != null) {
                    RecentlyVisitedForumListAdapter.this.f14425e.onLongClick(view);
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
                if (RecentlyVisitedForumListAdapter.this.f14426f != null) {
                    RecentlyVisitedForumListAdapter.this.f14426f.onClick(view);
                }
            }
        }

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new a(RecentlyVisitedForumListAdapter.this));
            view.setOnLongClickListener(new b(RecentlyVisitedForumListAdapter.this));
            this.f14427a = view.findViewById(R.id.top_container);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_image);
            this.f14430d = barImageView;
            barImageView.setPlaceHolderAutoChangeSkinType(1);
            this.f14428b = (TextView) view.findViewById(R.id.forum_name);
            this.f14431e = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.f14429c = (TextView) view.findViewById(R.id.forum_follow);
            LinearGradientView linearGradientView = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.f14433g = linearGradientView;
            linearGradientView.setCornerRadius(l.g(RecentlyVisitedForumListAdapter.this.f14421a.getPageActivity(), R.dimen.tbds10));
            this.f14433g.setRoundMode(3);
            this.f14433g.setVisibility(8);
            this.f14431e.setThreeDotMode(2);
            this.f14431e.setEnterForumStyle(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.delete_image);
            this.f14432f = imageView;
            imageView.setOnClickListener(new c(RecentlyVisitedForumListAdapter.this));
            this.f14434h = (TextView) view.findViewById(R.id.live_label_view);
            this.f14435i = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.f14421a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        LinkedList<VisitedForumData> linkedList;
        if (forumViewHolder == null || (linkedList = this.f14422b) == null || linkedList.get(i2) == null) {
            return;
        }
        VisitedForumData visitedForumData = this.f14422b.get(i2);
        forumViewHolder.itemView.setTag(visitedForumData);
        o(visitedForumData, forumViewHolder);
        n(visitedForumData, forumViewHolder);
        p(visitedForumData, forumViewHolder);
        forumViewHolder.f14430d.U(visitedForumData.y(), 10, false);
        forumViewHolder.f14430d.setStrokeColorResId(R.color.CAM_X0201);
        forumViewHolder.f14430d.setStrokeWith(3);
        forumViewHolder.f14430d.setShowOval(true);
        q(visitedForumData, forumViewHolder);
        SkinManager.setImageResource(forumViewHolder.f14432f, R.drawable.icon_ba_delete_n);
        SkinManager.setViewTextColor(forumViewHolder.f14428b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(forumViewHolder.f14429c, R.color.CAM_X0109);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f14421a.getPageActivity(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(this.f14421a.getPageActivity(), R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f14421a.getPageActivity(), R.dimen.tbds5)).into(forumViewHolder.f14435i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        LinkedList<VisitedForumData> linkedList = this.f14422b;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ForumViewHolder(this.f14421a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    public void i(LinkedList<VisitedForumData> linkedList) {
        this.f14422b = linkedList;
    }

    public void j(View.OnClickListener onClickListener) {
        this.f14426f = onClickListener;
    }

    public void k(boolean z) {
        this.f14423c = z;
        notifyDataSetChanged();
    }

    public void l(a aVar) {
        this.f14424d = aVar;
    }

    public void m(View.OnLongClickListener onLongClickListener) {
        this.f14425e = onLongClickListener;
    }

    public final void n(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        int x = visitedForumData.x();
        TextView textView = forumViewHolder.f14429c;
        textView.setText("关注 " + StringHelper.numFormatOverWanNa(x));
    }

    public final void o(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        String forumName = visitedForumData.getForumName();
        if (k.isEmpty(forumName)) {
            forumName = "";
        }
        forumViewHolder.f14428b.setText(forumName);
    }

    public final void p(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f14431e.setVisibility(8);
        forumViewHolder.f14432f.setVisibility(8);
        forumViewHolder.f14434h.setVisibility(8);
        if (this.f14423c) {
            forumViewHolder.f14432f.setVisibility(0);
            forumViewHolder.f14432f.setTag(visitedForumData);
        } else if (!visitedForumData.F()) {
            if (visitedForumData.B() <= 0) {
                forumViewHolder.f14431e.setVisibility(8);
                return;
            }
            forumViewHolder.f14431e.setVisibility(0);
            forumViewHolder.f14431e.f(visitedForumData.B());
        } else {
            forumViewHolder.f14434h.setVisibility(0);
        }
    }

    public final void q(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData == null || forumViewHolder == null) {
            return;
        }
        ThemeColorInfo D = visitedForumData.D();
        if (D == null) {
            forumViewHolder.f14433g.setVisibility(0);
            forumViewHolder.f14433g.setDefaultGradientColor();
            return;
        }
        LinearGradientView linearGradientView = forumViewHolder.f14433g;
        if (linearGradientView != null) {
            linearGradientView.setGradientColor(D.day, D.night, D.dark);
            forumViewHolder.f14433g.setVisibility(0);
        }
    }
}
