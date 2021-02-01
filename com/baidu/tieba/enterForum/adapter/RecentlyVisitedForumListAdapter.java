package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    private LinkedList<VisitedForumData> iHb;
    private boolean iHc;
    private a iHd;
    private View.OnLongClickListener iHe;
    private View.OnClickListener iHf;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iHb = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iHb == null) {
            return 0;
        }
        return this.iHb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        if (forumViewHolder != null && this.iHb != null && this.iHb.get(i) != null) {
            VisitedForumData visitedForumData = this.iHb.get(i);
            forumViewHolder.itemView.setTag(visitedForumData);
            a(visitedForumData, forumViewHolder);
            b(visitedForumData, forumViewHolder);
            d(visitedForumData, forumViewHolder);
            forumViewHolder.iHi.startLoad(visitedForumData.bAJ(), 10, false);
            forumViewHolder.iHi.setStrokeColorResId(R.color.CAM_X0201);
            forumViewHolder.iHi.setStrokeWith(3);
            forumViewHolder.iHi.setShowOval(true);
            c(visitedForumData, forumViewHolder);
            ap.setImageResource(forumViewHolder.fFd, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(forumViewHolder.fkQ, R.color.CAM_X0105);
            ap.setViewTextColor(forumViewHolder.iHh, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pb(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).pc(R.color.CAM_X0804).pa(4353).pd(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).pe(0).pf(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bv(forumViewHolder.bwE);
        }
    }

    private void a(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            String forumName = visitedForumData.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            forumViewHolder.fkQ.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iHh.setText("关注 " + au.numFormatOverWanNa(visitedForumData.bAN()));
        }
    }

    private void c(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                forumViewHolder.iHk.setVisibility(0);
                forumViewHolder.iHk.setDefaultGradientColor();
            } else if (forumViewHolder.iHk != null) {
                forumViewHolder.iHk.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                forumViewHolder.iHk.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iHj.setVisibility(8);
            forumViewHolder.fFd.setVisibility(8);
            forumViewHolder.iHl.setVisibility(8);
            if (this.iHc) {
                forumViewHolder.fFd.setVisibility(0);
                forumViewHolder.fFd.setTag(visitedForumData);
            } else if (!visitedForumData.bAK()) {
                if (visitedForumData.bAL() <= 0) {
                    forumViewHolder.iHj.setVisibility(8);
                    return;
                }
                forumViewHolder.iHj.setVisibility(0);
                forumViewHolder.iHj.refresh(visitedForumData.bAL());
            } else {
                forumViewHolder.iHl.setVisibility(0);
            }
        }
    }

    public void mc(boolean z) {
        this.iHc = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.iHd = aVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iHe = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.iHf = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout bwE;
        public ImageView fFd;
        public TextView fkQ;
        public View iHg;
        public TextView iHh;
        public BarImageView iHi;
        public MessageRedDotView iHj;
        public LinearGradientView iHk;
        public TextView iHl;

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iHd != null) {
                        RecentlyVisitedForumListAdapter.this.iHd.a(ForumViewHolder.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iHe != null) {
                        RecentlyVisitedForumListAdapter.this.iHe.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iHg = view.findViewById(R.id.top_container);
            this.iHi = (BarImageView) view.findViewById(R.id.forum_image);
            this.iHi.setPlaceHolderAutoChangeSkinType(1);
            this.fkQ = (TextView) view.findViewById(R.id.forum_name);
            this.iHj = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iHh = (TextView) view.findViewById(R.id.forum_follow);
            this.iHk = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iHk.setCornerRadius(l.getDimens(RecentlyVisitedForumListAdapter.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iHk.setRoundMode(3);
            this.iHk.setVisibility(8);
            this.iHj.setThreeDotMode(2);
            this.iHj.setEnterForumStyle(true);
            this.fFd = (ImageView) view.findViewById(R.id.delete_image);
            this.fFd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iHf != null) {
                        RecentlyVisitedForumListAdapter.this.iHf.onClick(view2);
                    }
                }
            });
            this.iHl = (TextView) view.findViewById(R.id.live_label_view);
            this.bwE = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
