package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d extends RecyclerView.Adapter<a> {
    private View.OnClickListener bYH;
    private LinkedList<VisitedForumData> cRO;
    private boolean cRP;
    private View.OnLongClickListener cRQ;
    private View.OnClickListener cRR;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void k(LinkedList<VisitedForumData> linkedList) {
        this.cRO = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cRO != null && this.cRO.get(i) != null) {
            VisitedForumData visitedForumData = this.cRO.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cRS.startLoad(visitedForumData.Hb(), 10, false);
            am.c(aVar.aPl, d.f.icon_ba_delete_n);
            am.h(aVar.axT, d.C0140d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.axT.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.cRT.setVisibility(8);
            aVar.aPl.setVisibility(8);
            aVar.cRU.setVisibility(8);
            if (this.cRP) {
                aVar.aPl.setVisibility(0);
                aVar.aPl.setTag(visitedForumData);
            } else if (!visitedForumData.Hc()) {
                if (visitedForumData.Hd() <= 0) {
                    aVar.cRT.setVisibility(8);
                    return;
                }
                aVar.cRT.setVisibility(0);
                aVar.cRT.refresh(visitedForumData.Hd());
            } else {
                aVar.cRU.setVisibility(0);
                am.i(aVar.cRU, d.f.enter_forum_live_label_bg_shape);
                am.h(aVar.cRU, d.C0140d.cp_cont_i);
            }
        }
    }

    public void cx(boolean z) {
        this.cRP = z;
        notifyDataSetChanged();
    }

    public void l(View.OnClickListener onClickListener) {
        this.bYH = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cRQ = onLongClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.cRR = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView aPl;
        public TextView axT;
        public TbImageView cRS;
        public MessageRedDotView cRT;
        public TextView cRU;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.bYH != null) {
                        d.this.bYH.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.cRQ != null) {
                        d.this.cRQ.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.cRS = (TbImageView) view.findViewById(d.g.forum_image);
            this.cRS.setDefaultResource(d.f.icon_default_ba_120);
            this.cRS.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.axT = (TextView) view.findViewById(d.g.forum_name);
            this.cRT = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.cRT.setThreeDotMode(2);
            this.aPl = (ImageView) view.findViewById(d.g.delete_image);
            this.aPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cRR != null) {
                        d.this.cRR.onClick(view2);
                    }
                }
            });
            this.cRU = (TextView) view.findViewById(d.g.live_label_view);
        }
    }
}
