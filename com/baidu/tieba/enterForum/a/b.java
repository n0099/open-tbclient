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
    private LinkedList<VisitedForumData> eBn;
    private boolean eBo;
    private InterfaceC0280b eBp;
    private View.OnLongClickListener eBq;
    private View.OnClickListener eBr;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0280b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.eBn = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eBn == null) {
            return 0;
        }
        return this.eBn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eBn != null && this.eBn.get(i) != null) {
            VisitedForumData visitedForumData = this.eBn.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eBt.startLoad(visitedForumData.alz(), 10, false);
            aVar.eBt.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            aVar.eBt.setStrokeWith(3);
            aVar.eBt.setShowOval(true);
            c(visitedForumData, aVar);
            al.c(aVar.clE, d.f.icon_ba_delete_n);
            al.j(aVar.bSY, d.C0277d.cp_cont_b);
            al.j(aVar.eBs, d.C0277d.cp_cont_d);
            al.k(aVar.eeI, d.f.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.bSY.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBs.setText("关注 " + ap.ay(visitedForumData.alD()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eBx.setVisibility(8);
                aVar.eBv.setVisibility(0);
                aVar.eBv.setDefaultGradientColor();
                return;
            }
            aVar.eBx.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eBv != null) {
                aVar.eBv.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eBv.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eBx != null) {
                aVar.eBx.startLoad(themeElement.pattern_image, 10, false);
                aVar.eBx.setRadius(l.h(this.mPageContext.getPageActivity(), d.e.tbds25));
                aVar.eBx.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBu.setVisibility(8);
            aVar.clE.setVisibility(8);
            aVar.eBw.setVisibility(8);
            if (this.eBo) {
                aVar.clE.setVisibility(0);
                aVar.clE.setTag(visitedForumData);
            } else if (!visitedForumData.alA()) {
                if (visitedForumData.alB() <= 0) {
                    aVar.eBu.setVisibility(8);
                    return;
                }
                aVar.eBu.setVisibility(0);
                aVar.eBu.refresh(visitedForumData.alB());
            } else {
                aVar.eBw.setVisibility(0);
            }
        }
    }

    public void fJ(boolean z) {
        this.eBo = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0280b interfaceC0280b) {
        this.eBp = interfaceC0280b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eBq = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.eBr = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView bSY;
        public ImageView clE;
        public TextView eBs;
        public BarImageView eBt;
        public MessageRedDotView eBu;
        public LinearGradientView eBv;
        public TextView eBw;
        public TbImageView eBx;
        public LinearLayout eeI;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBp != null) {
                        b.this.eBp.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eBq != null) {
                        b.this.eBq.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eBt = (BarImageView) view.findViewById(d.g.forum_image);
            this.eBt.setDefaultResource(d.f.icon_default_ba_120);
            this.eBt.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.bSY = (TextView) view.findViewById(d.g.forum_name);
            this.eBu = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.eBs = (TextView) view.findViewById(d.g.forum_follow);
            this.eBv = (LinearGradientView) view.findViewById(d.g.forum_bg);
            this.eBx = (TbImageView) view.findViewById(d.g.head_top_bg_mask);
            this.eBv.setCornerRadius(22);
            this.eBv.setRoundMode(3);
            this.eBv.setVisibility(8);
            this.eBu.setThreeDotMode(2);
            this.clE = (ImageView) view.findViewById(d.g.delete_image);
            this.clE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBr != null) {
                        b.this.eBr.onClick(view2);
                    }
                }
            });
            this.eBw = (TextView) view.findViewById(d.g.live_label_view);
            this.eeI = (LinearLayout) view.findViewById(d.g.bottom_container);
        }
    }
}
