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
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d extends RecyclerView.Adapter<a> {
    private View.OnClickListener bVm;
    private LinkedList<VisitedForumData> cRk;
    private boolean cRl;
    private View.OnLongClickListener cRm;
    private View.OnClickListener cRn;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        this.cRk = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cRk == null) {
            return 0;
        }
        return this.cRk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cRk != null && this.cRk.get(i) != null) {
            VisitedForumData visitedForumData = this.cRk.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cRo.startLoad(visitedForumData.GN(), 10, false);
            al.c(aVar.aOp, d.f.icon_ba_delete_n);
            al.h(aVar.ayc, d.C0141d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ayc.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.cRp.setVisibility(8);
            aVar.aOp.setVisibility(8);
            aVar.cRq.setVisibility(8);
            if (this.cRl) {
                aVar.aOp.setVisibility(0);
                aVar.aOp.setTag(visitedForumData);
            } else if (!visitedForumData.GO()) {
                if (visitedForumData.GP() <= 0) {
                    aVar.cRp.setVisibility(8);
                    return;
                }
                aVar.cRp.setVisibility(0);
                aVar.cRp.refresh(visitedForumData.GP());
            } else {
                aVar.cRq.setVisibility(0);
                al.i(aVar.cRq, d.f.enter_forum_live_label_bg_shape);
                al.h(aVar.cRq, d.C0141d.cp_cont_i);
            }
        }
    }

    public void ct(boolean z) {
        this.cRl = z;
        notifyDataSetChanged();
    }

    public void k(View.OnClickListener onClickListener) {
        this.bVm = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cRm = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.cRn = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView aOp;
        public TextView ayc;
        public TbImageView cRo;
        public MessageRedDotView cRp;
        public TextView cRq;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.bVm != null) {
                        d.this.bVm.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.cRm != null) {
                        d.this.cRm.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.cRo = (TbImageView) view.findViewById(d.g.forum_image);
            this.cRo.setDefaultResource(d.f.icon_default_ba_120);
            this.cRo.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.ayc = (TextView) view.findViewById(d.g.forum_name);
            this.cRp = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.cRp.setThreeDotMode(2);
            this.aOp = (ImageView) view.findViewById(d.g.delete_image);
            this.aOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cRn != null) {
                        d.this.cRn.onClick(view2);
                    }
                }
            });
            this.cRq = (TextView) view.findViewById(d.g.live_label_view);
        }
    }
}
