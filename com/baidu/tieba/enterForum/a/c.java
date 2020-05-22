package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class c extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> gOc;
    private boolean gOd;
    private b gOe;
    private View.OnLongClickListener gOf;
    private View.OnClickListener gOg;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.gOc = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.gOc == null) {
            return 0;
        }
        return this.gOc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.gOc != null && this.gOc.get(i) != null) {
            VisitedForumData visitedForumData = this.gOc.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.gOj.startLoad(visitedForumData.bcE(), 10, false);
            aVar.gOj.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.gOj.setStrokeWith(3);
            aVar.gOj.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.eoe, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.dWR, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.gOi, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aVu().lD(R.color.cp_btn_a).ly(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).lz(R.color.cp_shadow_a_alpha16).lx(4353).lA(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).lB(0).lC(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aR(aVar.aYe);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.dWR.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gOi.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.bcI()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.gOl.setVisibility(0);
                aVar.gOl.setDefaultGradientColor();
            } else if (aVar.gOl != null) {
                aVar.gOl.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.gOl.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gOk.setVisibility(8);
            aVar.eoe.setVisibility(8);
            aVar.gOm.setVisibility(8);
            if (this.gOd) {
                aVar.eoe.setVisibility(0);
                aVar.eoe.setTag(visitedForumData);
            } else if (!visitedForumData.bcF()) {
                if (visitedForumData.bcG() <= 0) {
                    aVar.gOk.setVisibility(8);
                    return;
                }
                aVar.gOk.setVisibility(0);
                aVar.gOk.refresh(visitedForumData.bcG());
            } else {
                aVar.gOm.setVisibility(0);
            }
        }
    }

    public void iY(boolean z) {
        this.gOd = z;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.gOe = bVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.gOf = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.gOg = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout aYe;
        public TextView dWR;
        public ImageView eoe;
        public View gOh;
        public TextView gOi;
        public BarImageView gOj;
        public MessageRedDotView gOk;
        public LinearGradientView gOl;
        public TextView gOm;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gOe != null) {
                        c.this.gOe.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (c.this.gOf != null) {
                        c.this.gOf.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.gOh = view.findViewById(R.id.top_container);
            this.gOj = (BarImageView) view.findViewById(R.id.forum_image);
            this.gOj.setPlaceHolderAutoChangeSkinType(2);
            this.gOj.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.dWR = (TextView) view.findViewById(R.id.forum_name);
            this.gOk = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.gOi = (TextView) view.findViewById(R.id.forum_follow);
            this.gOl = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.gOl.setCornerRadius(l.getDimens(c.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.gOl.setRoundMode(3);
            this.gOl.setVisibility(8);
            this.gOk.setThreeDotMode(2);
            this.gOk.setEnterForumStyle(true);
            this.eoe = (ImageView) view.findViewById(R.id.delete_image);
            this.eoe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gOg != null) {
                        c.this.gOg.onClick(view2);
                    }
                }
            });
            this.gOm = (TextView) view.findViewById(R.id.live_label_view);
            this.aYe = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
