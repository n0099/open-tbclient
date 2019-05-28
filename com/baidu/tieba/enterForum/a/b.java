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
    private LinkedList<VisitedForumData> eQF;
    private boolean eQG;
    private InterfaceC0298b eQH;
    private View.OnLongClickListener eQI;
    private View.OnClickListener eQJ;
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
        this.eQF = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eQF == null) {
            return 0;
        }
        return this.eQF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eQF != null && this.eQF.get(i) != null) {
            VisitedForumData visitedForumData = this.eQF.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eQL.startLoad(visitedForumData.aqz(), 10, false);
            aVar.eQL.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.eQL.setStrokeWith(3);
            aVar.eQL.setShowOval(true);
            c(visitedForumData, aVar);
            al.c(aVar.ctP, (int) R.drawable.icon_ba_delete_n);
            al.j(aVar.caT, R.color.cp_cont_b);
            al.j(aVar.eQK, R.color.cp_cont_d);
            al.k(aVar.eoX, R.drawable.recent_visit_bg);
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
            aVar.eQK.setText("关注 " + ap.aM(visitedForumData.aqD()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eQP.setVisibility(8);
                aVar.eQN.setVisibility(0);
                aVar.eQN.setDefaultGradientColor();
                return;
            }
            aVar.eQP.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eQN != null) {
                aVar.eQN.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eQN.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eQP != null) {
                aVar.eQP.startLoad(themeElement.pattern_image, 10, false);
                aVar.eQP.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.eQP.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eQM.setVisibility(8);
            aVar.ctP.setVisibility(8);
            aVar.eQO.setVisibility(8);
            if (this.eQG) {
                aVar.ctP.setVisibility(0);
                aVar.ctP.setTag(visitedForumData);
            } else if (!visitedForumData.aqA()) {
                if (visitedForumData.aqB() <= 0) {
                    aVar.eQM.setVisibility(8);
                    return;
                }
                aVar.eQM.setVisibility(0);
                aVar.eQM.refresh(visitedForumData.aqB());
            } else {
                aVar.eQO.setVisibility(0);
            }
        }
    }

    public void gg(boolean z) {
        this.eQG = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0298b interfaceC0298b) {
        this.eQH = interfaceC0298b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eQI = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.eQJ = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView caT;
        public ImageView ctP;
        public TextView eQK;
        public BarImageView eQL;
        public MessageRedDotView eQM;
        public LinearGradientView eQN;
        public TextView eQO;
        public TbImageView eQP;
        public LinearLayout eoX;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eQH != null) {
                        b.this.eQH.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eQI != null) {
                        b.this.eQI.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eQL = (BarImageView) view.findViewById(R.id.forum_image);
            this.eQL.setDefaultResource(R.drawable.icon_default_ba_120);
            this.eQL.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.caT = (TextView) view.findViewById(R.id.forum_name);
            this.eQM = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.eQK = (TextView) view.findViewById(R.id.forum_follow);
            this.eQN = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.eQP = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.eQN.setCornerRadius(22);
            this.eQN.setRoundMode(3);
            this.eQN.setVisibility(8);
            this.eQM.setThreeDotMode(2);
            this.ctP = (ImageView) view.findViewById(R.id.delete_image);
            this.ctP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eQJ != null) {
                        b.this.eQJ.onClick(view2);
                    }
                }
            });
            this.eQO = (TextView) view.findViewById(R.id.live_label_view);
            this.eoX = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
