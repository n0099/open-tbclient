package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> eBr;
    private boolean eBs;
    private InterfaceC0239b eBt;
    private View.OnLongClickListener eBu;
    private View.OnClickListener eBv;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0239b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.eBr = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eBr == null) {
            return 0;
        }
        return this.eBr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eBr != null && this.eBr.get(i) != null) {
            VisitedForumData visitedForumData = this.eBr.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eBx.startLoad(visitedForumData.alA(), 10, false);
            aVar.eBx.setStrokeColorResId(d.C0236d.cp_bg_line_d);
            aVar.eBx.setStrokeWith(3);
            aVar.eBx.setShowOval(true);
            c(visitedForumData, aVar);
            al.c(aVar.clE, d.f.icon_ba_delete_n);
            al.j(aVar.bSX, d.C0236d.cp_cont_b);
            al.j(aVar.eBw, d.C0236d.cp_cont_d);
            al.k(aVar.eeM, d.f.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.bSX.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBw.setText("关注 " + ap.ay(visitedForumData.alE()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eBB.setVisibility(8);
                aVar.eBz.setVisibility(0);
                aVar.eBz.setDefaultGradientColor();
                return;
            }
            aVar.eBB.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eBz != null) {
                aVar.eBz.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eBz.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eBB != null) {
                aVar.eBB.startLoad(themeElement.pattern_image, 10, false);
                aVar.eBB.setRadius(l.h(this.mPageContext.getPageActivity(), d.e.tbds25));
                aVar.eBB.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBy.setVisibility(8);
            aVar.clE.setVisibility(8);
            aVar.eBA.setVisibility(8);
            if (this.eBs) {
                aVar.clE.setVisibility(0);
                aVar.clE.setTag(visitedForumData);
            } else if (!visitedForumData.alB()) {
                if (visitedForumData.alC() <= 0) {
                    aVar.eBy.setVisibility(8);
                    return;
                }
                aVar.eBy.setVisibility(0);
                aVar.eBy.refresh(visitedForumData.alC());
            } else {
                aVar.eBA.setVisibility(0);
            }
        }
    }

    public void fJ(boolean z) {
        this.eBs = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0239b interfaceC0239b) {
        this.eBt = interfaceC0239b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eBu = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.eBv = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView bSX;
        public ImageView clE;
        public TextView eBA;
        public TbImageView eBB;
        public TextView eBw;
        public BarImageView eBx;
        public MessageRedDotView eBy;
        public LinearGradientView eBz;
        public LinearLayout eeM;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBt != null) {
                        b.this.eBt.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eBu != null) {
                        b.this.eBu.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eBx = (BarImageView) view.findViewById(d.g.forum_image);
            this.eBx.setDefaultResource(d.f.icon_default_ba_120);
            this.eBx.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.bSX = (TextView) view.findViewById(d.g.forum_name);
            this.eBy = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.eBw = (TextView) view.findViewById(d.g.forum_follow);
            this.eBz = (LinearGradientView) view.findViewById(d.g.forum_bg);
            this.eBB = (TbImageView) view.findViewById(d.g.head_top_bg_mask);
            this.eBz.setCornerRadius(22);
            this.eBz.setRoundMode(3);
            this.eBz.setVisibility(8);
            this.eBy.setThreeDotMode(2);
            this.clE = (ImageView) view.findViewById(d.g.delete_image);
            this.clE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBv != null) {
                        b.this.eBv.onClick(view2);
                    }
                }
            });
            this.eBA = (TextView) view.findViewById(d.g.live_label_view);
            this.eeM = (LinearLayout) view.findViewById(d.g.bottom_container);
        }
    }
}
