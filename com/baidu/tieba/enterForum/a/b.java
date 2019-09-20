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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> eXs;
    private boolean eXt;
    private InterfaceC0310b eXu;
    private View.OnLongClickListener eXv;
    private View.OnClickListener eXw;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0310b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.eXs = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eXs == null) {
            return 0;
        }
        return this.eXs.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eXs != null && this.eXs.get(i) != null) {
            VisitedForumData visitedForumData = this.eXs.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eXz.startLoad(visitedForumData.arT(), 10, false);
            aVar.eXz.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.eXz.setStrokeWith(3);
            aVar.eXz.setShowOval(true);
            c(visitedForumData, aVar);
            am.c(aVar.cwi, (int) R.drawable.icon_ba_delete_n);
            am.j(aVar.ccX, R.color.cp_cont_b);
            am.j(aVar.eXy, R.color.cp_cont_d);
            am.k(aVar.eXx, R.drawable.recent_visit_bg_top);
            am.k(aVar.evM, R.drawable.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ccX.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eXy.setText("关注 " + aq.aN(visitedForumData.arX()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eXD.setVisibility(8);
                aVar.eXB.setVisibility(0);
                aVar.eXB.setDefaultGradientColor();
                return;
            }
            aVar.eXD.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eXB != null) {
                aVar.eXB.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eXB.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eXD != null) {
                aVar.eXD.startLoad(themeElement.pattern_image, 10, false);
                aVar.eXD.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.eXD.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eXA.setVisibility(8);
            aVar.cwi.setVisibility(8);
            aVar.eXC.setVisibility(8);
            if (this.eXt) {
                aVar.cwi.setVisibility(0);
                aVar.cwi.setTag(visitedForumData);
            } else if (!visitedForumData.arU()) {
                if (visitedForumData.arV() <= 0) {
                    aVar.eXA.setVisibility(8);
                    return;
                }
                aVar.eXA.setVisibility(0);
                aVar.eXA.refresh(visitedForumData.arV());
            } else {
                aVar.eXC.setVisibility(0);
            }
        }
    }

    public void gn(boolean z) {
        this.eXt = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0310b interfaceC0310b) {
        this.eXu = interfaceC0310b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eXv = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.eXw = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView ccX;
        public ImageView cwi;
        public MessageRedDotView eXA;
        public LinearGradientView eXB;
        public TextView eXC;
        public TbImageView eXD;
        public View eXx;
        public TextView eXy;
        public BarImageView eXz;
        public LinearLayout evM;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eXu != null) {
                        b.this.eXu.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eXv != null) {
                        b.this.eXv.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eXx = view.findViewById(R.id.top_container);
            this.eXz = (BarImageView) view.findViewById(R.id.forum_image);
            this.eXz.setDefaultResource(R.drawable.icon_default_ba_120);
            this.eXz.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.ccX = (TextView) view.findViewById(R.id.forum_name);
            this.eXA = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.eXy = (TextView) view.findViewById(R.id.forum_follow);
            this.eXB = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.eXD = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.eXB.setCornerRadius(22);
            this.eXB.setRoundMode(3);
            this.eXB.setVisibility(8);
            this.eXA.setThreeDotMode(2);
            this.cwi = (ImageView) view.findViewById(R.id.delete_image);
            this.cwi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eXw != null) {
                        b.this.eXw.onClick(view2);
                    }
                }
            });
            this.eXC = (TextView) view.findViewById(R.id.live_label_view);
            this.evM = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
