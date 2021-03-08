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
    private LinkedList<VisitedForumData> iIY;
    private boolean iIZ;
    private a iJa;
    private View.OnLongClickListener iJb;
    private View.OnClickListener iJc;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iIY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iIY == null) {
            return 0;
        }
        return this.iIY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        if (forumViewHolder != null && this.iIY != null && this.iIY.get(i) != null) {
            VisitedForumData visitedForumData = this.iIY.get(i);
            forumViewHolder.itemView.setTag(visitedForumData);
            a(visitedForumData, forumViewHolder);
            b(visitedForumData, forumViewHolder);
            d(visitedForumData, forumViewHolder);
            forumViewHolder.iJf.startLoad(visitedForumData.bAM(), 10, false);
            forumViewHolder.iJf.setStrokeColorResId(R.color.CAM_X0201);
            forumViewHolder.iJf.setStrokeWith(3);
            forumViewHolder.iJf.setShowOval(true);
            c(visitedForumData, forumViewHolder);
            ap.setImageResource(forumViewHolder.fGC, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(forumViewHolder.fmq, R.color.CAM_X0105);
            ap.setViewTextColor(forumViewHolder.iJe, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0901).pc(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).pd(R.color.CAM_X0804).pb(4353).pe(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).pf(0).pg(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bv(forumViewHolder.bye);
        }
    }

    private void a(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            String forumName = visitedForumData.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            forumViewHolder.fmq.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iJe.setText("关注 " + au.numFormatOverWanNa(visitedForumData.bAQ()));
        }
    }

    private void c(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                forumViewHolder.iJh.setVisibility(0);
                forumViewHolder.iJh.setDefaultGradientColor();
            } else if (forumViewHolder.iJh != null) {
                forumViewHolder.iJh.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                forumViewHolder.iJh.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iJg.setVisibility(8);
            forumViewHolder.fGC.setVisibility(8);
            forumViewHolder.iJi.setVisibility(8);
            if (this.iIZ) {
                forumViewHolder.fGC.setVisibility(0);
                forumViewHolder.fGC.setTag(visitedForumData);
            } else if (!visitedForumData.bAN()) {
                if (visitedForumData.bAO() <= 0) {
                    forumViewHolder.iJg.setVisibility(8);
                    return;
                }
                forumViewHolder.iJg.setVisibility(0);
                forumViewHolder.iJg.refresh(visitedForumData.bAO());
            } else {
                forumViewHolder.iJi.setVisibility(0);
            }
        }
    }

    public void mc(boolean z) {
        this.iIZ = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.iJa = aVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iJb = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.iJc = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout bye;
        public ImageView fGC;
        public TextView fmq;
        public View iJd;
        public TextView iJe;
        public BarImageView iJf;
        public MessageRedDotView iJg;
        public LinearGradientView iJh;
        public TextView iJi;

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iJa != null) {
                        RecentlyVisitedForumListAdapter.this.iJa.a(ForumViewHolder.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iJb != null) {
                        RecentlyVisitedForumListAdapter.this.iJb.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iJd = view.findViewById(R.id.top_container);
            this.iJf = (BarImageView) view.findViewById(R.id.forum_image);
            this.iJf.setPlaceHolderAutoChangeSkinType(1);
            this.fmq = (TextView) view.findViewById(R.id.forum_name);
            this.iJg = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iJe = (TextView) view.findViewById(R.id.forum_follow);
            this.iJh = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iJh.setCornerRadius(l.getDimens(RecentlyVisitedForumListAdapter.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iJh.setRoundMode(3);
            this.iJh.setVisibility(8);
            this.iJg.setThreeDotMode(2);
            this.iJg.setEnterForumStyle(true);
            this.fGC = (ImageView) view.findViewById(R.id.delete_image);
            this.fGC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iJc != null) {
                        RecentlyVisitedForumListAdapter.this.iJc.onClick(view2);
                    }
                }
            });
            this.iJi = (TextView) view.findViewById(R.id.live_label_view);
            this.bye = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
