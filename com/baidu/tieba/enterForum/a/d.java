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
/* loaded from: classes2.dex */
public class d extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> cXC;
    private boolean cXD;
    private View.OnLongClickListener cXE;
    private View.OnClickListener cXF;
    private View.OnClickListener cev;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void k(LinkedList<VisitedForumData> linkedList) {
        this.cXC = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cXC == null) {
            return 0;
        }
        return this.cXC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cXC != null && this.cXC.get(i) != null) {
            VisitedForumData visitedForumData = this.cXC.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cXG.startLoad(visitedForumData.Ir(), 10, false);
            al.c(aVar.aSA, e.f.icon_ba_delete_n);
            al.h(aVar.aAN, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aAN.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.cXH.setVisibility(8);
            aVar.aSA.setVisibility(8);
            aVar.cXI.setVisibility(8);
            if (this.cXD) {
                aVar.aSA.setVisibility(0);
                aVar.aSA.setTag(visitedForumData);
            } else if (!visitedForumData.Is()) {
                if (visitedForumData.It() <= 0) {
                    aVar.cXH.setVisibility(8);
                    return;
                }
                aVar.cXH.setVisibility(0);
                aVar.cXH.refresh(visitedForumData.It());
            } else {
                aVar.cXI.setVisibility(0);
                al.i(aVar.cXI, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.cXI, e.d.cp_cont_i);
            }
        }
    }

    public void cP(boolean z) {
        this.cXD = z;
        notifyDataSetChanged();
    }

    public void l(View.OnClickListener onClickListener) {
        this.cev = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cXE = onLongClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.cXF = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aAN;
        public ImageView aSA;
        public TbImageView cXG;
        public MessageRedDotView cXH;
        public TextView cXI;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cev != null) {
                        d.this.cev.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.cXE != null) {
                        d.this.cXE.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.cXG = (TbImageView) view.findViewById(e.g.forum_image);
            this.cXG.setDefaultResource(e.f.icon_default_ba_120);
            this.cXG.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aAN = (TextView) view.findViewById(e.g.forum_name);
            this.cXH = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.cXH.setThreeDotMode(2);
            this.aSA = (ImageView) view.findViewById(e.g.delete_image);
            this.aSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cXF != null) {
                        d.this.cXF.onClick(view2);
                    }
                }
            });
            this.cXI = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
