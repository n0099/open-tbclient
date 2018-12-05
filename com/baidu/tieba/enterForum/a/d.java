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
    private View.OnClickListener crg;
    private LinkedList<VisitedForumData> dnG;
    private boolean dnH;
    private View.OnLongClickListener dnI;
    private View.OnClickListener dnJ;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.dnG = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(e.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dnG == null) {
            return 0;
        }
        return this.dnG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.dnG != null && this.dnG.get(i) != null) {
            VisitedForumData visitedForumData = this.dnG.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.dnK.startLoad(visitedForumData.LG(), 10, false);
            al.c(aVar.bbm, e.f.icon_ba_delete_n);
            al.h(aVar.aJK, e.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ao.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.aJK.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.dnL.setVisibility(8);
            aVar.bbm.setVisibility(8);
            aVar.dnM.setVisibility(8);
            if (this.dnH) {
                aVar.bbm.setVisibility(0);
                aVar.bbm.setTag(visitedForumData);
            } else if (!visitedForumData.LH()) {
                if (visitedForumData.LI() <= 0) {
                    aVar.dnL.setVisibility(8);
                    return;
                }
                aVar.dnL.setVisibility(0);
                aVar.dnL.refresh(visitedForumData.LI());
            } else {
                aVar.dnM.setVisibility(0);
                al.i(aVar.dnM, e.f.enter_forum_live_label_bg_shape);
                al.h(aVar.dnM, e.d.cp_cont_i);
            }
        }
    }

    public void dq(boolean z) {
        this.dnH = z;
        notifyDataSetChanged();
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.crg = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.dnI = onLongClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.dnJ = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView aJK;
        public ImageView bbm;
        public TbImageView dnK;
        public MessageRedDotView dnL;
        public TextView dnM;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.crg != null) {
                        d.this.crg.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.dnI != null) {
                        d.this.dnI.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.dnK = (TbImageView) view.findViewById(e.g.forum_image);
            this.dnK.setDefaultResource(e.f.icon_default_ba_120);
            this.dnK.setDefaultErrorResource(e.f.icon_default_ba_120);
            this.aJK = (TextView) view.findViewById(e.g.forum_name);
            this.dnL = (MessageRedDotView) view.findViewById(e.g.red_dot_view);
            this.dnL.setThreeDotMode(2);
            this.bbm = (ImageView) view.findViewById(e.g.delete_image);
            this.bbm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.dnJ != null) {
                        d.this.dnJ.onClick(view2);
                    }
                }
            });
            this.dnM = (TextView) view.findViewById(e.g.live_label_view);
        }
    }
}
