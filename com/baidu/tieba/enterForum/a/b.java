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
    private LinkedList<VisitedForumData> eAY;
    private boolean eAZ;
    private InterfaceC0280b eBa;
    private View.OnLongClickListener eBb;
    private View.OnClickListener eBc;
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
        this.eAY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(d.h.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eAY == null) {
            return 0;
        }
        return this.eAY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eAY != null && this.eAY.get(i) != null) {
            VisitedForumData visitedForumData = this.eAY.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eBe.startLoad(visitedForumData.alw(), 10, false);
            aVar.eBe.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            aVar.eBe.setStrokeWith(3);
            aVar.eBe.setShowOval(true);
            c(visitedForumData, aVar);
            al.c(aVar.clG, d.f.icon_ba_delete_n);
            al.j(aVar.bTa, d.C0277d.cp_cont_b);
            al.j(aVar.eBd, d.C0277d.cp_cont_d);
            al.k(aVar.eet, d.f.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.bTa.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBd.setText("关注 " + ap.ay(visitedForumData.alA()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eBi.setVisibility(8);
                aVar.eBg.setVisibility(0);
                aVar.eBg.setDefaultGradientColor();
                return;
            }
            aVar.eBi.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eBg != null) {
                aVar.eBg.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eBg.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eBi != null) {
                aVar.eBi.startLoad(themeElement.pattern_image, 10, false);
                aVar.eBi.setRadius(l.h(this.mPageContext.getPageActivity(), d.e.tbds25));
                aVar.eBi.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eBf.setVisibility(8);
            aVar.clG.setVisibility(8);
            aVar.eBh.setVisibility(8);
            if (this.eAZ) {
                aVar.clG.setVisibility(0);
                aVar.clG.setTag(visitedForumData);
            } else if (!visitedForumData.alx()) {
                if (visitedForumData.aly() <= 0) {
                    aVar.eBf.setVisibility(8);
                    return;
                }
                aVar.eBf.setVisibility(0);
                aVar.eBf.refresh(visitedForumData.aly());
            } else {
                aVar.eBh.setVisibility(0);
            }
        }
    }

    public void fJ(boolean z) {
        this.eAZ = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0280b interfaceC0280b) {
        this.eBa = interfaceC0280b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eBb = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.eBc = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView bTa;
        public ImageView clG;
        public TextView eBd;
        public BarImageView eBe;
        public MessageRedDotView eBf;
        public LinearGradientView eBg;
        public TextView eBh;
        public TbImageView eBi;
        public LinearLayout eet;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBa != null) {
                        b.this.eBa.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eBb != null) {
                        b.this.eBb.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eBe = (BarImageView) view.findViewById(d.g.forum_image);
            this.eBe.setDefaultResource(d.f.icon_default_ba_120);
            this.eBe.setDefaultErrorResource(d.f.icon_default_ba_120);
            this.bTa = (TextView) view.findViewById(d.g.forum_name);
            this.eBf = (MessageRedDotView) view.findViewById(d.g.red_dot_view);
            this.eBd = (TextView) view.findViewById(d.g.forum_follow);
            this.eBg = (LinearGradientView) view.findViewById(d.g.forum_bg);
            this.eBi = (TbImageView) view.findViewById(d.g.head_top_bg_mask);
            this.eBg.setCornerRadius(22);
            this.eBg.setRoundMode(3);
            this.eBg.setVisibility(8);
            this.eBf.setThreeDotMode(2);
            this.clG = (ImageView) view.findViewById(d.g.delete_image);
            this.clG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eBc != null) {
                        b.this.eBc.onClick(view2);
                    }
                }
            });
            this.eBh = (TextView) view.findViewById(d.g.live_label_view);
            this.eet = (LinearLayout) view.findViewById(d.g.bottom_container);
        }
    }
}
