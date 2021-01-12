package com.baidu.tieba.enterForum.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    private LinkedList<VisitedForumData> iBr;
    private boolean iBs;
    private a iBt;
    private View.OnLongClickListener iBu;
    private View.OnClickListener iBv;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iBr = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: y */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iBr == null) {
            return 0;
        }
        return this.iBr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        if (forumViewHolder != null && this.iBr != null && this.iBr.get(i) != null) {
            VisitedForumData visitedForumData = this.iBr.get(i);
            forumViewHolder.itemView.setTag(visitedForumData);
            a(visitedForumData, forumViewHolder);
            b(visitedForumData, forumViewHolder);
            d(visitedForumData, forumViewHolder);
            forumViewHolder.iBy.startLoad(visitedForumData.bAr(), 10, false);
            forumViewHolder.iBy.setStrokeColorResId(R.color.CAM_X0201);
            forumViewHolder.iBy.setStrokeWith(3);
            forumViewHolder.iBy.setShowOval(true);
            c(visitedForumData, forumViewHolder);
            ao.setImageResource(forumViewHolder.fCR, R.drawable.icon_ba_delete_n);
            ao.setViewTextColor(forumViewHolder.fiz, R.color.CAM_X0105);
            ao.setViewTextColor(forumViewHolder.iBx, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0901).oW(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).oX(R.color.CAM_X0804).oV(4353).oY(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).oZ(0).pa(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bz(forumViewHolder.bta);
        }
    }

    private void a(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            forumViewHolder.fiz.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iBx.setText("关注 " + at.numFormatOverWanNa(visitedForumData.bAv()));
        }
    }

    private void c(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                forumViewHolder.iBA.setVisibility(0);
                forumViewHolder.iBA.setDefaultGradientColor();
            } else if (forumViewHolder.iBA != null) {
                forumViewHolder.iBA.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                forumViewHolder.iBA.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iBz.setVisibility(8);
            forumViewHolder.fCR.setVisibility(8);
            forumViewHolder.iBB.setVisibility(8);
            if (this.iBs) {
                forumViewHolder.fCR.setVisibility(0);
                forumViewHolder.fCR.setTag(visitedForumData);
            } else if (!visitedForumData.bAs()) {
                if (visitedForumData.bAt() <= 0) {
                    forumViewHolder.iBz.setVisibility(8);
                    return;
                }
                forumViewHolder.iBz.setVisibility(0);
                forumViewHolder.iBz.refresh(visitedForumData.bAt());
            } else {
                forumViewHolder.iBB.setVisibility(0);
            }
        }
    }

    public void lY(boolean z) {
        this.iBs = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.iBt = aVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iBu = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.iBv = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout bta;
        public ImageView fCR;
        public TextView fiz;
        public LinearGradientView iBA;
        public TextView iBB;
        public View iBw;
        public TextView iBx;
        public BarImageView iBy;
        public MessageRedDotView iBz;

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iBt != null) {
                        RecentlyVisitedForumListAdapter.this.iBt.a(ForumViewHolder.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iBu != null) {
                        RecentlyVisitedForumListAdapter.this.iBu.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iBw = view.findViewById(R.id.top_container);
            this.iBy = (BarImageView) view.findViewById(R.id.forum_image);
            this.iBy.setPlaceHolderAutoChangeSkinType(1);
            this.fiz = (TextView) view.findViewById(R.id.forum_name);
            this.iBz = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iBx = (TextView) view.findViewById(R.id.forum_follow);
            this.iBA = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iBA.setCornerRadius(l.getDimens(RecentlyVisitedForumListAdapter.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iBA.setRoundMode(3);
            this.iBA.setVisibility(8);
            this.iBz.setThreeDotMode(2);
            this.iBz.setEnterForumStyle(true);
            this.fCR = (ImageView) view.findViewById(R.id.delete_image);
            this.fCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iBv != null) {
                        RecentlyVisitedForumListAdapter.this.iBv.onClick(view2);
                    }
                }
            });
            this.iBB = (TextView) view.findViewById(R.id.live_label_view);
            this.bta = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
