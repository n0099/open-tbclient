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
    private LinkedList<VisitedForumData> iFY;
    private boolean iFZ;
    private a iGa;
    private View.OnLongClickListener iGb;
    private View.OnClickListener iGc;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ForumViewHolder forumViewHolder);
    }

    public RecentlyVisitedForumListAdapter(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iFY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: y */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iFY == null) {
            return 0;
        }
        return this.iFY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        if (forumViewHolder != null && this.iFY != null && this.iFY.get(i) != null) {
            VisitedForumData visitedForumData = this.iFY.get(i);
            forumViewHolder.itemView.setTag(visitedForumData);
            a(visitedForumData, forumViewHolder);
            b(visitedForumData, forumViewHolder);
            d(visitedForumData, forumViewHolder);
            forumViewHolder.iGf.startLoad(visitedForumData.bEk(), 10, false);
            forumViewHolder.iGf.setStrokeColorResId(R.color.CAM_X0201);
            forumViewHolder.iGf.setStrokeWith(3);
            forumViewHolder.iGf.setShowOval(true);
            c(visitedForumData, forumViewHolder);
            ao.setImageResource(forumViewHolder.fHy, R.drawable.icon_ba_delete_n);
            ao.setViewTextColor(forumViewHolder.fni, R.color.CAM_X0105);
            ao.setViewTextColor(forumViewHolder.iGe, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0901).qD(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).qE(R.color.CAM_X0804).qC(4353).qF(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).qG(0).qH(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bz(forumViewHolder.bxO);
        }
    }

    private void a(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            forumViewHolder.fni.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iGe.setText("关注 " + at.numFormatOverWanNa(visitedForumData.bEo()));
        }
    }

    private void c(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                forumViewHolder.iGh.setVisibility(0);
                forumViewHolder.iGh.setDefaultGradientColor();
            } else if (forumViewHolder.iGh != null) {
                forumViewHolder.iGh.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                forumViewHolder.iGh.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, ForumViewHolder forumViewHolder) {
        if (visitedForumData != null && forumViewHolder != null) {
            forumViewHolder.iGg.setVisibility(8);
            forumViewHolder.fHy.setVisibility(8);
            forumViewHolder.iGi.setVisibility(8);
            if (this.iFZ) {
                forumViewHolder.fHy.setVisibility(0);
                forumViewHolder.fHy.setTag(visitedForumData);
            } else if (!visitedForumData.bEl()) {
                if (visitedForumData.bEm() <= 0) {
                    forumViewHolder.iGg.setVisibility(8);
                    return;
                }
                forumViewHolder.iGg.setVisibility(0);
                forumViewHolder.iGg.refresh(visitedForumData.bEm());
            } else {
                forumViewHolder.iGi.setVisibility(0);
            }
        }
    }

    public void mc(boolean z) {
        this.iFZ = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.iGa = aVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iGb = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.iGc = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout bxO;
        public ImageView fHy;
        public TextView fni;
        public View iGd;
        public TextView iGe;
        public BarImageView iGf;
        public MessageRedDotView iGg;
        public LinearGradientView iGh;
        public TextView iGi;

        public ForumViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iGa != null) {
                        RecentlyVisitedForumListAdapter.this.iGa.a(ForumViewHolder.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iGb != null) {
                        RecentlyVisitedForumListAdapter.this.iGb.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iGd = view.findViewById(R.id.top_container);
            this.iGf = (BarImageView) view.findViewById(R.id.forum_image);
            this.iGf.setPlaceHolderAutoChangeSkinType(1);
            this.fni = (TextView) view.findViewById(R.id.forum_name);
            this.iGg = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iGe = (TextView) view.findViewById(R.id.forum_follow);
            this.iGh = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iGh.setCornerRadius(l.getDimens(RecentlyVisitedForumListAdapter.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iGh.setRoundMode(3);
            this.iGh.setVisibility(8);
            this.iGg.setThreeDotMode(2);
            this.iGg.setEnterForumStyle(true);
            this.fHy = (ImageView) view.findViewById(R.id.delete_image);
            this.fHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.ForumViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (RecentlyVisitedForumListAdapter.this.iGc != null) {
                        RecentlyVisitedForumListAdapter.this.iGc.onClick(view2);
                    }
                }
            });
            this.iGi = (TextView) view.findViewById(R.id.live_label_view);
            this.bxO = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
