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
    private View.OnClickListener csw;
    private LinkedList<VisitedForumData> drk;
    private boolean drl;
    private View.OnLongClickListener drm;
    private View.OnClickListener drn;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.drk = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.drk == null) {
            return 0;
        }
        return this.drk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.drk != null && this.drk.get(i) != null) {
            VisitedForumData visitedForumData = this.drk.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.dro.startLoad(visitedForumData.LY(), 10, false);
            al.c(aVar.bca, e.f.icon_ba_delete_n);
            al.h(aVar.aKp, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aKp.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.drp.setVisibility(8);
            aVar.bca.setVisibility(8);
            aVar.drq.setVisibility(8);
            if (this.drl) {
                aVar.bca.setVisibility(0);
                aVar.bca.setTag(visitedForumData);
            } else if (!visitedForumData.LZ()) {
                if (visitedForumData.Ma() <= 0) {
                    aVar.drp.setVisibility(8);
                    return;
                }
                aVar.drp.setVisibility(0);
                aVar.drp.refresh(visitedForumData.Ma());
            } else {
                aVar.drq.setVisibility(0);
                al.i(aVar.drq, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.drq, e.d.cp_cont_i);
            }
        }
    }

    public void dt(boolean z) {
        this.drl = z;
        notifyDataSetChanged();
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.csw = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.drm = onLongClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.drn = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aKp;
        public ImageView bca;
        public TbImageView dro;
        public MessageRedDotView drp;
        public TextView drq;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.csw != null) {
                        d.this.csw.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.drm != null) {
                        d.this.drm.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.dro = (TbImageView) view.findViewById(e.g.forum_image);
            this.dro.setDefaultResource(e.f.icon_default_ba_120);
            this.dro.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aKp = (TextView) view.findViewById(e.g.forum_name);
            this.drp = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.drp.setThreeDotMode(2);
            this.bca = (ImageView) view.findViewById(e.g.delete_image);
            this.bca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.drn != null) {
                        d.this.drn.onClick(view2);
                    }
                }
            });
            this.drq = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
