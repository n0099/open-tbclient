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
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> eQE;
    private boolean eQF;
    private InterfaceC0298b eQG;
    private View.OnLongClickListener eQH;
    private View.OnClickListener eQI;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0298b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.eQE = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eQE == null) {
            return 0;
        }
        return this.eQE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eQE != null && this.eQE.get(i) != null) {
            VisitedForumData visitedForumData = this.eQE.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eQK.startLoad(visitedForumData.aqz(), 10, false);
            aVar.eQK.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.eQK.setStrokeWith(3);
            aVar.eQK.setShowOval(true);
            c(visitedForumData, aVar);
            al.c(aVar.ctP, (int) R.drawable.icon_ba_delete_n);
            al.j(aVar.caT, R.color.cp_cont_b);
            al.j(aVar.eQJ, R.color.cp_cont_d);
            al.k(aVar.eoW, R.drawable.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ap.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.caT.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eQJ.setText("关注 " + ap.aM(visitedForumData.aqD()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eQO.setVisibility(8);
                aVar.eQM.setVisibility(0);
                aVar.eQM.setDefaultGradientColor();
                return;
            }
            aVar.eQO.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eQM != null) {
                aVar.eQM.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eQM.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eQO != null) {
                aVar.eQO.startLoad(themeElement.pattern_image, 10, false);
                aVar.eQO.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.eQO.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eQL.setVisibility(8);
            aVar.ctP.setVisibility(8);
            aVar.eQN.setVisibility(8);
            if (this.eQF) {
                aVar.ctP.setVisibility(0);
                aVar.ctP.setTag(visitedForumData);
            } else if (!visitedForumData.aqA()) {
                if (visitedForumData.aqB() <= 0) {
                    aVar.eQL.setVisibility(8);
                    return;
                }
                aVar.eQL.setVisibility(0);
                aVar.eQL.refresh(visitedForumData.aqB());
            } else {
                aVar.eQN.setVisibility(0);
            }
        }
    }

    public void gg(boolean z) {
        this.eQF = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0298b interfaceC0298b) {
        this.eQG = interfaceC0298b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eQH = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.eQI = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView caT;
        public ImageView ctP;
        public TextView eQJ;
        public BarImageView eQK;
        public MessageRedDotView eQL;
        public LinearGradientView eQM;
        public TextView eQN;
        public TbImageView eQO;
        public LinearLayout eoW;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eQG != null) {
                        b.this.eQG.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eQH != null) {
                        b.this.eQH.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eQK = (BarImageView) view.findViewById(R.id.forum_image);
            this.eQK.setDefaultResource(R.drawable.icon_default_ba_120);
            this.eQK.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.caT = (TextView) view.findViewById(R.id.forum_name);
            this.eQL = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.eQJ = (TextView) view.findViewById(R.id.forum_follow);
            this.eQM = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.eQO = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.eQM.setCornerRadius(22);
            this.eQM.setRoundMode(3);
            this.eQM.setVisibility(8);
            this.eQL.setThreeDotMode(2);
            this.ctP = (ImageView) view.findViewById(R.id.delete_image);
            this.ctP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eQI != null) {
                        b.this.eQI.onClick(view2);
                    }
                }
            });
            this.eQN = (TextView) view.findViewById(R.id.live_label_view);
            this.eoW = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
