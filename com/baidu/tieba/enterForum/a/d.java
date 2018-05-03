package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d extends RecyclerView.Adapter<a> {
    private View.OnClickListener bMv;
    private LinkedList<VisitedForumData> cGU;
    private boolean cGV;
    private View.OnLongClickListener cGW;
    private View.OnClickListener cGX;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        this.cGU = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cGU == null) {
            return 0;
        }
        return this.cGU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cGU != null && this.cGU.get(i) != null) {
            VisitedForumData visitedForumData = this.cGU.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cGY.startLoad(visitedForumData.Dm(), 10, false);
            ak.c(aVar.aFS, d.f.icon_ba_delete_n);
            ak.h(aVar.apV, d.C0126d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (an.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.apV.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.cGZ.setVisibility(8);
            aVar.aFS.setVisibility(8);
            aVar.cHa.setVisibility(8);
            if (this.cGV) {
                aVar.aFS.setVisibility(0);
                aVar.aFS.setTag(visitedForumData);
            } else if (!visitedForumData.Dn()) {
                if (visitedForumData.Do() <= 0) {
                    aVar.cGZ.setVisibility(8);
                    return;
                }
                aVar.cGZ.setVisibility(0);
                aVar.cGZ.refresh(visitedForumData.Do());
            } else {
                aVar.cHa.setVisibility(0);
                ak.i(aVar.cHa, d.f.enter_forum_live_label_bg_shape);
                ak.h(aVar.cHa, d.C0126d.cp_cont_g);
            }
        }
    }

    public void co(boolean z) {
        this.cGV = z;
        notifyDataSetChanged();
    }

    public void k(View.OnClickListener onClickListener) {
        this.bMv = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cGW = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.cGX = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView aFS;
        public TextView apV;
        public TbImageView cGY;
        public MessageRedDotView cGZ;
        public TextView cHa;

        public a(View view2) {
            super(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (d.this.bMv != null) {
                        d.this.bMv.onClick(view3);
                    }
                }
            });
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    if (d.this.cGW != null) {
                        d.this.cGW.onLongClick(view3);
                        return true;
                    }
                    return true;
                }
            });
            this.cGY = (TbImageView) view2.findViewById(d.g.forum_image);
            this.cGY.setDefaultResource(d.f.icon_default_ba_120);
            this.cGY.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.apV = (TextView) view2.findViewById(d.g.forum_name);
            this.cGZ = (MessageRedDotView) view2.findViewById(d.g.red_dot_view);
            this.cGZ.setThreeDotMode(2);
            this.aFS = (ImageView) view2.findViewById(d.g.delete_image);
            this.aFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (d.this.cGX != null) {
                        d.this.cGX.onClick(view3);
                    }
                }
            });
            this.cHa = (TextView) view2.findViewById(d.g.live_label_view);
        }
    }
}
