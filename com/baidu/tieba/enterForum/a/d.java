package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class d extends RecyclerView.Adapter<a> {
    private View.OnClickListener crK;
    private View.OnClickListener dqA;
    private LinkedList<VisitedForumData> dqx;
    private boolean dqy;
    private View.OnLongClickListener dqz;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.dqx = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dqx == null) {
            return 0;
        }
        return this.dqx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.dqx != null && this.dqx.get(i) != null) {
            VisitedForumData visitedForumData = this.dqx.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.dqB.startLoad(visitedForumData.LH(), 10, false);
            al.c(aVar.bbp, e.f.icon_ba_delete_n);
            al.h(aVar.aJM, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aJM.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.dqC.setVisibility(8);
            aVar.bbp.setVisibility(8);
            aVar.dqD.setVisibility(8);
            if (this.dqy) {
                aVar.bbp.setVisibility(0);
                aVar.bbp.setTag(visitedForumData);
            } else if (!visitedForumData.LI()) {
                if (visitedForumData.LJ() <= 0) {
                    aVar.dqC.setVisibility(8);
                    return;
                }
                aVar.dqC.setVisibility(0);
                aVar.dqC.refresh(visitedForumData.LJ());
            } else {
                aVar.dqD.setVisibility(0);
                al.i(aVar.dqD, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.dqD, e.d.cp_cont_i);
            }
        }
    }

    public void dq(boolean z) {
        this.dqy = z;
        notifyDataSetChanged();
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.crK = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.dqz = onLongClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.dqA = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aJM;
        public ImageView bbp;
        public TbImageView dqB;
        public MessageRedDotView dqC;
        public TextView dqD;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.crK != null) {
                        d.this.crK.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.dqz != null) {
                        d.this.dqz.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.dqB = (TbImageView) view.findViewById(e.g.forum_image);
            this.dqB.setDefaultResource(e.f.icon_default_ba_120);
            this.dqB.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aJM = (TextView) view.findViewById(e.g.forum_name);
            this.dqC = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.dqC.setThreeDotMode(2);
            this.bbp = (ImageView) view.findViewById(e.g.delete_image);
            this.bbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dqA != null) {
                        d.this.dqA.onClick(view2);
                    }
                }
            });
            this.dqD = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
