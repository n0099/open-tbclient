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
    private View.OnClickListener csv;
    private LinkedList<VisitedForumData> drj;
    private boolean drk;
    private View.OnLongClickListener drl;
    private View.OnClickListener drm;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.drj = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.drj == null) {
            return 0;
        }
        return this.drj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.drj != null && this.drj.get(i) != null) {
            VisitedForumData visitedForumData = this.drj.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.drn.startLoad(visitedForumData.LY(), 10, false);
            al.c(aVar.bbZ, e.f.icon_ba_delete_n);
            al.h(aVar.aKo, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aKo.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.dro.setVisibility(8);
            aVar.bbZ.setVisibility(8);
            aVar.drp.setVisibility(8);
            if (this.drk) {
                aVar.bbZ.setVisibility(0);
                aVar.bbZ.setTag(visitedForumData);
            } else if (!visitedForumData.LZ()) {
                if (visitedForumData.Ma() <= 0) {
                    aVar.dro.setVisibility(8);
                    return;
                }
                aVar.dro.setVisibility(0);
                aVar.dro.refresh(visitedForumData.Ma());
            } else {
                aVar.drp.setVisibility(0);
                al.i(aVar.drp, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.drp, e.d.cp_cont_i);
            }
        }
    }

    public void dt(boolean z) {
        this.drk = z;
        notifyDataSetChanged();
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.csv = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.drl = onLongClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.drm = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aKo;
        public ImageView bbZ;
        public TbImageView drn;
        public MessageRedDotView dro;
        public TextView drp;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.csv != null) {
                        d.this.csv.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.drl != null) {
                        d.this.drl.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.drn = (TbImageView) view.findViewById(e.g.forum_image);
            this.drn.setDefaultResource(e.f.icon_default_ba_120);
            this.drn.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aKo = (TextView) view.findViewById(e.g.forum_name);
            this.dro = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.dro.setThreeDotMode(2);
            this.bbZ = (ImageView) view.findViewById(e.g.delete_image);
            this.bbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.drm != null) {
                        d.this.drm.onClick(view2);
                    }
                }
            });
            this.drp = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
