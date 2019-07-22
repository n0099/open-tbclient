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
    private LinkedList<VisitedForumData> eVF;
    private boolean eVG;
    private InterfaceC0295b eVH;
    private View.OnLongClickListener eVI;
    private View.OnClickListener eVJ;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0295b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.eVF = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eVF == null) {
            return 0;
        }
        return this.eVF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eVF != null && this.eVF.get(i) != null) {
            VisitedForumData visitedForumData = this.eVF.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eVL.startLoad(visitedForumData.arF(), 10, false);
            aVar.eVL.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.eVL.setStrokeWith(3);
            aVar.eVL.setShowOval(true);
            c(visitedForumData, aVar);
            am.c(aVar.cvf, (int) R.drawable.icon_ba_delete_n);
            am.j(aVar.cbW, R.color.cp_cont_b);
            am.j(aVar.eVK, R.color.cp_cont_d);
            am.k(aVar.etV, R.drawable.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.cbW.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eVK.setText("关注 " + aq.aN(visitedForumData.arJ()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eVP.setVisibility(8);
                aVar.eVN.setVisibility(0);
                aVar.eVN.setDefaultGradientColor();
                return;
            }
            aVar.eVP.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eVN != null) {
                aVar.eVN.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eVN.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eVP != null) {
                aVar.eVP.startLoad(themeElement.pattern_image, 10, false);
                aVar.eVP.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.eVP.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eVM.setVisibility(8);
            aVar.cvf.setVisibility(8);
            aVar.eVO.setVisibility(8);
            if (this.eVG) {
                aVar.cvf.setVisibility(0);
                aVar.cvf.setTag(visitedForumData);
            } else if (!visitedForumData.arG()) {
                if (visitedForumData.arH() <= 0) {
                    aVar.eVM.setVisibility(8);
                    return;
                }
                aVar.eVM.setVisibility(0);
                aVar.eVM.refresh(visitedForumData.arH());
            } else {
                aVar.eVO.setVisibility(0);
            }
        }
    }

    public void gk(boolean z) {
        this.eVG = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0295b interfaceC0295b) {
        this.eVH = interfaceC0295b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eVI = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.eVJ = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView cbW;
        public ImageView cvf;
        public TextView eVK;
        public BarImageView eVL;
        public MessageRedDotView eVM;
        public LinearGradientView eVN;
        public TextView eVO;
        public TbImageView eVP;
        public LinearLayout etV;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eVH != null) {
                        b.this.eVH.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eVI != null) {
                        b.this.eVI.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eVL = (BarImageView) view.findViewById(R.id.forum_image);
            this.eVL.setDefaultResource(R.drawable.icon_default_ba_120);
            this.eVL.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.cbW = (TextView) view.findViewById(R.id.forum_name);
            this.eVM = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.eVK = (TextView) view.findViewById(R.id.forum_follow);
            this.eVN = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.eVP = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.eVN.setCornerRadius(22);
            this.eVN.setRoundMode(3);
            this.eVN.setVisibility(8);
            this.eVM.setThreeDotMode(2);
            this.cvf = (ImageView) view.findViewById(R.id.delete_image);
            this.cvf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eVJ != null) {
                        b.this.eVJ.onClick(view2);
                    }
                }
            });
            this.eVO = (TextView) view.findViewById(R.id.live_label_view);
            this.etV = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
