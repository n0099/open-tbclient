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
    private LinkedList<VisitedForumData> eAZ;
    private boolean eBa;
    private InterfaceC0280b eBb;
    private View.OnLongClickListener eBc;
    private View.OnClickListener eBd;
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
        this.eAZ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eAZ == null) {
            return 0;
        }
        return this.eAZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eAZ != null && this.eAZ.get(i) != null) {
            VisitedForumData visitedForumData = this.eAZ.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eBf.startLoad(visitedForumData.alw(), 10, false);
            aVar.eBf.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            aVar.eBf.setStrokeWith(3);
            aVar.eBf.setShowOval(true);
            c(visitedForumData, aVar);
            al.c(aVar.clH, d.f.icon_ba_delete_n);
            al.j(aVar.bTb, d.C0277d.cp_cont_b);
            al.j(aVar.eBe, d.C0277d.cp_cont_d);
            al.k(aVar.eeu, d.f.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.bTb.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBe.setText("关注 " + ap.ay(visitedForumData.alA()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eBj.setVisibility(8);
                aVar.eBh.setVisibility(0);
                aVar.eBh.setDefaultGradientColor();
                return;
            }
            aVar.eBj.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eBh != null) {
                aVar.eBh.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eBh.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eBj != null) {
                aVar.eBj.startLoad(themeElement.pattern_image, 10, false);
                aVar.eBj.setRadius(l.h(this.mPageContext.getPageActivity(), d.e.tbds25));
                aVar.eBj.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBg.setVisibility(8);
            aVar.clH.setVisibility(8);
            aVar.eBi.setVisibility(8);
            if (this.eBa) {
                aVar.clH.setVisibility(0);
                aVar.clH.setTag(visitedForumData);
            } else if (!visitedForumData.alx()) {
                if (visitedForumData.aly() <= 0) {
                    aVar.eBg.setVisibility(8);
                    return;
                }
                aVar.eBg.setVisibility(0);
                aVar.eBg.refresh(visitedForumData.aly());
            } else {
                aVar.eBi.setVisibility(0);
            }
        }
    }

    public void fJ(boolean z) {
        this.eBa = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0280b interfaceC0280b) {
        this.eBb = interfaceC0280b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eBc = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.eBd = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView bTb;
        public ImageView clH;
        public TextView eBe;
        public BarImageView eBf;
        public MessageRedDotView eBg;
        public LinearGradientView eBh;
        public TextView eBi;
        public TbImageView eBj;
        public LinearLayout eeu;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBb != null) {
                        b.this.eBb.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eBc != null) {
                        b.this.eBc.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eBf = (BarImageView) view.findViewById(d.g.forum_image);
            this.eBf.setDefaultResource(d.f.icon_default_ba_120);
            this.eBf.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.bTb = (TextView) view.findViewById(d.g.forum_name);
            this.eBg = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.eBe = (TextView) view.findViewById(d.g.forum_follow);
            this.eBh = (LinearGradientView) view.findViewById(d.g.forum_bg);
            this.eBj = (TbImageView) view.findViewById(d.g.head_top_bg_mask);
            this.eBh.setCornerRadius(22);
            this.eBh.setRoundMode(3);
            this.eBh.setVisibility(8);
            this.eBg.setThreeDotMode(2);
            this.clH = (ImageView) view.findViewById(d.g.delete_image);
            this.clH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBd != null) {
                        b.this.eBd.onClick(view2);
                    }
                }
            });
            this.eBi = (TextView) view.findViewById(d.g.live_label_view);
            this.eeu = (LinearLayout) view.findViewById(d.g.bottom_container);
        }
    }
}
