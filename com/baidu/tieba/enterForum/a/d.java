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
    private View.OnClickListener cnl;
    private LinkedList<VisitedForumData> dgY;
    private boolean dgZ;
    private View.OnLongClickListener dha;
    private View.OnClickListener dhb;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void k(LinkedList<VisitedForumData> linkedList) {
        this.dgY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dgY == null) {
            return 0;
        }
        return this.dgY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.dgY != null && this.dgY.get(i) != null) {
            VisitedForumData visitedForumData = this.dgY.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.dhc.startLoad(visitedForumData.KC(), 10, false);
            al.c(aVar.aXO, e.f.icon_ba_delete_n);
            al.h(aVar.aGk, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aGk.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.dhd.setVisibility(8);
            aVar.aXO.setVisibility(8);
            aVar.dhe.setVisibility(8);
            if (this.dgZ) {
                aVar.aXO.setVisibility(0);
                aVar.aXO.setTag(visitedForumData);
            } else if (!visitedForumData.KD()) {
                if (visitedForumData.KE() <= 0) {
                    aVar.dhd.setVisibility(8);
                    return;
                }
                aVar.dhd.setVisibility(0);
                aVar.dhd.refresh(visitedForumData.KE());
            } else {
                aVar.dhe.setVisibility(0);
                al.i(aVar.dhe, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.dhe, e.d.cp_cont_i);
            }
        }
    }

    public void dp(boolean z) {
        this.dgZ = z;
        notifyDataSetChanged();
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.cnl = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.dha = onLongClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.dhb = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aGk;
        public ImageView aXO;
        public TbImageView dhc;
        public MessageRedDotView dhd;
        public TextView dhe;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cnl != null) {
                        d.this.cnl.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.dha != null) {
                        d.this.dha.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.dhc = (TbImageView) view.findViewById(e.g.forum_image);
            this.dhc.setDefaultResource(e.f.icon_default_ba_120);
            this.dhc.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aGk = (TextView) view.findViewById(e.g.forum_name);
            this.dhd = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.dhd.setThreeDotMode(2);
            this.aXO = (ImageView) view.findViewById(e.g.delete_image);
            this.aXO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dhb != null) {
                        d.this.dhb.onClick(view2);
                    }
                }
            });
            this.dhe = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
