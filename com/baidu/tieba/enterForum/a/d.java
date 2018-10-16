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
    private View.OnClickListener cmW;
    private LinkedList<VisitedForumData> dfT;
    private boolean dfU;
    private View.OnLongClickListener dfV;
    private View.OnClickListener dfW;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void k(LinkedList<VisitedForumData> linkedList) {
        this.dfT = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dfT == null) {
            return 0;
        }
        return this.dfT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.dfT != null && this.dfT.get(i) != null) {
            VisitedForumData visitedForumData = this.dfT.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.dfX.startLoad(visitedForumData.Kq(), 10, false);
            al.c(aVar.aXa, e.f.icon_ba_delete_n);
            al.h(aVar.aFu, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aFu.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.dfY.setVisibility(8);
            aVar.aXa.setVisibility(8);
            aVar.dfZ.setVisibility(8);
            if (this.dfU) {
                aVar.aXa.setVisibility(0);
                aVar.aXa.setTag(visitedForumData);
            } else if (!visitedForumData.Kr()) {
                if (visitedForumData.Ks() <= 0) {
                    aVar.dfY.setVisibility(8);
                    return;
                }
                aVar.dfY.setVisibility(0);
                aVar.dfY.refresh(visitedForumData.Ks());
            } else {
                aVar.dfZ.setVisibility(0);
                al.i(aVar.dfZ, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.dfZ, e.d.cp_cont_i);
            }
        }
    }

    public void cY(boolean z) {
        this.dfU = z;
        notifyDataSetChanged();
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.cmW = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.dfV = onLongClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.dfW = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aFu;
        public ImageView aXa;
        public TbImageView dfX;
        public MessageRedDotView dfY;
        public TextView dfZ;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cmW != null) {
                        d.this.cmW.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.dfV != null) {
                        d.this.dfV.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.dfX = (TbImageView) view.findViewById(e.g.forum_image);
            this.dfX.setDefaultResource(e.f.icon_default_ba_120);
            this.dfX.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aFu = (TextView) view.findViewById(e.g.forum_name);
            this.dfY = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.dfY.setThreeDotMode(2);
            this.aXa = (ImageView) view.findViewById(e.g.delete_image);
            this.aXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dfW != null) {
                        d.this.dfW.onClick(view2);
                    }
                }
            });
            this.dfZ = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
