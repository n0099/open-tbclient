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
    private View.OnClickListener bXw;
    private LinkedList<VisitedForumData> cPf;
    private boolean cPg;
    private View.OnLongClickListener cPh;
    private View.OnClickListener cPi;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void k(LinkedList<VisitedForumData> linkedList) {
        this.cPf = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.i.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cPf == null) {
            return 0;
        }
        return this.cPf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.cPf != null && this.cPf.get(i) != null) {
            VisitedForumData visitedForumData = this.cPf.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            aVar.cPj.startLoad(visitedForumData.Hf(), 10, false);
            am.c(aVar.aPl, d.f.icon_ba_delete_n);
            am.h(aVar.ayV, d.C0142d.cp_cont_b);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ayV.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.cPk.setVisibility(8);
            aVar.aPl.setVisibility(8);
            aVar.cPl.setVisibility(8);
            if (this.cPg) {
                aVar.aPl.setVisibility(0);
                aVar.aPl.setTag(visitedForumData);
            } else if (!visitedForumData.Hg()) {
                if (visitedForumData.Hh() <= 0) {
                    aVar.cPk.setVisibility(8);
                    return;
                }
                aVar.cPk.setVisibility(0);
                aVar.cPk.refresh(visitedForumData.Hh());
            } else {
                aVar.cPl.setVisibility(0);
                am.i(aVar.cPl, d.f.enter_forum_live_label_bg_shape);
                am.h(aVar.cPl, d.C0142d.cp_cont_i);
            }
        }
    }

    public void cx(boolean z) {
        this.cPg = z;
        notifyDataSetChanged();
    }

    public void l(View.OnClickListener onClickListener) {
        this.bXw = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cPh = onLongClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.cPi = onClickListener;
    }

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView aPl;
        public TextView ayV;
        public TbImageView cPj;
        public MessageRedDotView cPk;
        public TextView cPl;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.bXw != null) {
                        d.this.bXw.onClick(view2);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.cPh != null) {
                        d.this.cPh.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.cPj = (TbImageView) view.findViewById(d.g.forum_image);
            this.cPj.setDefaultResource(d.f.icon_default_ba_120);
            this.cPj.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.ayV = (TextView) view.findViewById(d.g.forum_name);
            this.cPk = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.cPk.setThreeDotMode(2);
            this.aPl = (ImageView) view.findViewById(d.g.delete_image);
            this.aPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.d.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cPi != null) {
                        d.this.cPi.onClick(view2);
                    }
                }
            });
            this.cPl = (TextView) view.findViewById(d.g.live_label_view);
        }
    }
}
