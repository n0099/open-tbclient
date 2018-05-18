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
    private View.OnClickListener bNl;
    private LinkedList<VisitedForumData> cId;
    private boolean cIe;
    private View.OnLongClickListener cIf;
    private View.OnClickListener cIg;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void m(LinkedList<VisitedForumData> linkedList) {
        this.cId = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cId == null) {
            return 0;
        }
        return this.cId.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cId != null && this.cId.get(i) != null) {
            VisitedForumData visitedForumData = this.cId.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cIh.startLoad(visitedForumData.Dk(), 10, false);
            ak.c(aVar.aFT, d.f.icon_ba_delete_n);
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
            aVar.cIi.setVisibility(8);
            aVar.aFT.setVisibility(8);
            aVar.cIj.setVisibility(8);
            if (this.cIe) {
                aVar.aFT.setVisibility(0);
                aVar.aFT.setTag(visitedForumData);
            } else if (!visitedForumData.Dl()) {
                if (visitedForumData.Dm() <= 0) {
                    aVar.cIi.setVisibility(8);
                    return;
                }
                aVar.cIi.setVisibility(0);
                aVar.cIi.refresh(visitedForumData.Dm());
            } else {
                aVar.cIj.setVisibility(0);
                ak.i(aVar.cIj, d.f.enter_forum_live_label_bg_shape);
                ak.h(aVar.cIj, d.C0126d.cp_cont_g);
            }
        }
    }

    public void co(boolean z) {
        this.cIe = z;
        notifyDataSetChanged();
    }

    public void k(View.OnClickListener onClickListener) {
        this.bNl = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cIf = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.cIg = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView aFT;
        public TextView apV;
        public TbImageView cIh;
        public MessageRedDotView cIi;
        public TextView cIj;

        public a(View view2) {
            super(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (d.this.bNl != null) {
                        d.this.bNl.onClick(view3);
                    }
                }
            });
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    if (d.this.cIf != null) {
                        d.this.cIf.onLongClick(view3);
                        return true;
                    }
                    return true;
                }
            });
            this.cIh = (TbImageView) view2.findViewById(d.g.forum_image);
            this.cIh.setDefaultResource(d.f.icon_default_ba_120);
            this.cIh.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.apV = (TextView) view2.findViewById(d.g.forum_name);
            this.cIi = (MessageRedDotView) view2.findViewById(d.g.red_dot_view);
            this.cIi.setThreeDotMode(2);
            this.aFT = (ImageView) view2.findViewById(d.g.delete_image);
            this.aFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (d.this.cIg != null) {
                        d.this.cIg.onClick(view3);
                    }
                }
            });
            this.cIj = (TextView) view2.findViewById(d.g.live_label_view);
        }
    }
}
