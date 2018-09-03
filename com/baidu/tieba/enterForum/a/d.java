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
import com.baidu.tieba.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d extends RecyclerView.Adapter<a> {
    private View.OnClickListener bYF;
    private LinkedList<VisitedForumData> cRL;
    private boolean cRM;
    private View.OnLongClickListener cRN;
    private View.OnClickListener cRO;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void k(LinkedList<VisitedForumData> linkedList) {
        this.cRL = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(f.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cRL == null) {
            return 0;
        }
        return this.cRL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cRL != null && this.cRL.get(i) != null) {
            VisitedForumData visitedForumData = this.cRL.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cRP.startLoad(visitedForumData.Hb(), 10, false);
            am.c(aVar.aPi, f.C0146f.icon_ba_delete_n);
            am.h(aVar.axQ, f.d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.axQ.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.cRQ.setVisibility(8);
            aVar.aPi.setVisibility(8);
            aVar.cRR.setVisibility(8);
            if (this.cRM) {
                aVar.aPi.setVisibility(0);
                aVar.aPi.setTag(visitedForumData);
            } else if (!visitedForumData.Hc()) {
                if (visitedForumData.Hd() <= 0) {
                    aVar.cRQ.setVisibility(8);
                    return;
                }
                aVar.cRQ.setVisibility(0);
                aVar.cRQ.refresh(visitedForumData.Hd());
            } else {
                aVar.cRR.setVisibility(0);
                am.i(aVar.cRR, f.C0146f.enter_forum_live_label_bg_shape);
                am.h(aVar.cRR, f.d.cp_cont_i);
            }
        }
    }

    public void cy(boolean z) {
        this.cRM = z;
        notifyDataSetChanged();
    }

    public void l(View.OnClickListener onClickListener) {
        this.bYF = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cRN = onLongClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.cRO = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView aPi;
        public TextView axQ;
        public TbImageView cRP;
        public MessageRedDotView cRQ;
        public TextView cRR;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.bYF != null) {
                        d.this.bYF.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.cRN != null) {
                        d.this.cRN.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.cRP = (TbImageView) view.findViewById(f.g.forum_image);
            this.cRP.setDefaultResource(f.C0146f.icon_default_ba_120);
            this.cRP.setDefaultErrorResource(f.C0146f.icon_default_ba_120);
            this.axQ = (TextView) view.findViewById(f.g.forum_name);
            this.cRQ = (MessageRedDotView) view.findViewById(f.g.red_dot_view);
            this.cRQ.setThreeDotMode(2);
            this.aPi = (ImageView) view.findViewById(f.g.delete_image);
            this.aPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cRO != null) {
                        d.this.cRO.onClick(view2);
                    }
                }
            });
            this.cRR = (TextView) view.findViewById(f.g.live_label_view);
        }
    }
}
