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
    private LinkedList<VisitedForumData> iHp;
    private boolean iHq;
    private a iHr;
    private View.OnLongClickListener iHs;
    private View.OnClickListener iHt;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iHp = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iHp == null) {
            return 0;
        }
        return this.iHp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        if (forumViewHolder != null && this.iHp != null && this.iHp.get(i) != null) {
            VisitedForumData visitedForumData = this.iHp.get(i);
            forumViewHolder.itemView.setTag(visitedForumData);
            a(visitedForumData, forumViewHolder);
            b(visitedForumData, forumViewHolder);
            d(visitedForumData, forumViewHolder);
            forumViewHolder.iHw.startLoad(visitedForumData.bAJ(), 10, false);
            forumViewHolder.iHw.setStrokeColorResId(R.color.CAM_X0201);
            forumViewHolder.iHw.setStrokeWith(3);
            forumViewHolder.iHw.setShowOval(true);
            c(visitedForumData, forumViewHolder);
            ap.setImageResource(forumViewHolder.fFd, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(forumViewHolder.fkQ, R.color.CAM_X0105);
            ap.setViewTextColor(forumViewHolder.iHv, R.color.CAM_X0109);
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
            forumViewHolder.iHv.setText("关注 " + au.numFormatOverWanNa(visitedForumData.bAN()));
        }
    }

    private void c(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                forumViewHolder.iHy.setVisibility(0);
                forumViewHolder.iHy.setDefaultGradientColor();
            } else if (forumViewHolder.iHy != null) {
                forumViewHolder.iHy.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                forumViewHolder.iHy.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iHx.setVisibility(8);
            forumViewHolder.fFd.setVisibility(8);
            forumViewHolder.iHz.setVisibility(8);
            if (this.iHq) {
                forumViewHolder.fFd.setVisibility(0);
                forumViewHolder.fFd.setTag(visitedForumData);
            } else if (!visitedForumData.bAK()) {
                if (visitedForumData.bAL() <= 0) {
                    forumViewHolder.iHx.setVisibility(8);
                    return;
                }
                forumViewHolder.iHx.setVisibility(0);
                forumViewHolder.iHx.refresh(visitedForumData.bAL());
            } else {
                forumViewHolder.iHz.setVisibility(0);
            }
        }
    }

    public void mc(boolean z) {
        this.iHq = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.iHr = aVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iHs = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.iHt = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout bwE;
        public ImageView fFd;
        public TextView fkQ;
        public View iHu;
        public TextView iHv;
        public BarImageView iHw;
        public MessageRedDotView iHx;
        public LinearGradientView iHy;
        public TextView iHz;

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iHr != null) {
                        RecentlyVisitedForumListAdapter.this.iHr.a(ForumViewHolder.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iHs != null) {
                        RecentlyVisitedForumListAdapter.this.iHs.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iHu = view.findViewById(R.id.top_container);
            this.iHw = (BarImageView) view.findViewById(R.id.forum_image);
            this.iHw.setPlaceHolderAutoChangeSkinType(1);
            this.fkQ = (TextView) view.findViewById(R.id.forum_name);
            this.iHx = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iHv = (TextView) view.findViewById(R.id.forum_follow);
            this.iHy = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iHy.setCornerRadius(l.getDimens(RecentlyVisitedForumListAdapter.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iHy.setRoundMode(3);
            this.iHy.setVisibility(8);
            this.iHx.setThreeDotMode(2);
            this.iHx.setEnterForumStyle(true);
            this.fFd = (ImageView) view.findViewById(R.id.delete_image);
            this.fFd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iHt != null) {
                        RecentlyVisitedForumListAdapter.this.iHt.onClick(view2);
                    }
                }
            });
            this.iHz = (TextView) view.findViewById(R.id.live_label_view);
            this.bwE = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
