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
    private LinkedList<VisitedForumData> eVM;
    private boolean eVN;
    private InterfaceC0301b eVO;
    private View.OnLongClickListener eVP;
    private View.OnClickListener eVQ;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0301b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void l(LinkedList<VisitedForumData> linkedList) {
        this.eVM = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eVM == null) {
            return 0;
        }
        return this.eVM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eVM != null && this.eVM.get(i) != null) {
            VisitedForumData visitedForumData = this.eVM.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eVT.startLoad(visitedForumData.arH(), 10, false);
            aVar.eVT.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.eVT.setStrokeWith(3);
            aVar.eVT.setShowOval(true);
            c(visitedForumData, aVar);
            am.c(aVar.cvm, (int) R.drawable.icon_ba_delete_n);
            am.j(aVar.ccd, R.color.cp_cont_b);
            am.j(aVar.eVS, R.color.cp_cont_d);
            am.k(aVar.eVR, R.drawable.recent_visit_bg_top);
            am.k(aVar.euc, R.drawable.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ccd.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eVS.setText("关注 " + aq.aN(visitedForumData.arL()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eVX.setVisibility(8);
                aVar.eVV.setVisibility(0);
                aVar.eVV.setDefaultGradientColor();
                return;
            }
            aVar.eVX.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eVV != null) {
                aVar.eVV.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eVV.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eVX != null) {
                aVar.eVX.startLoad(themeElement.pattern_image, 10, false);
                aVar.eVX.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.eVX.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eVU.setVisibility(8);
            aVar.cvm.setVisibility(8);
            aVar.eVW.setVisibility(8);
            if (this.eVN) {
                aVar.cvm.setVisibility(0);
                aVar.cvm.setTag(visitedForumData);
            } else if (!visitedForumData.arI()) {
                if (visitedForumData.arJ() <= 0) {
                    aVar.eVU.setVisibility(8);
                    return;
                }
                aVar.eVU.setVisibility(0);
                aVar.eVU.refresh(visitedForumData.arJ());
            } else {
                aVar.eVW.setVisibility(0);
            }
        }
    }

    public void gk(boolean z) {
        this.eVN = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0301b interfaceC0301b) {
        this.eVO = interfaceC0301b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eVP = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.eVQ = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView ccd;
        public ImageView cvm;
        public View eVR;
        public TextView eVS;
        public BarImageView eVT;
        public MessageRedDotView eVU;
        public LinearGradientView eVV;
        public TextView eVW;
        public TbImageView eVX;
        public LinearLayout euc;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eVO != null) {
                        b.this.eVO.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eVP != null) {
                        b.this.eVP.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eVR = view.findViewById(R.id.top_container);
            this.eVT = (BarImageView) view.findViewById(R.id.forum_image);
            this.eVT.setDefaultResource(R.drawable.icon_default_ba_120);
            this.eVT.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.ccd = (TextView) view.findViewById(R.id.forum_name);
            this.eVU = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.eVS = (TextView) view.findViewById(R.id.forum_follow);
            this.eVV = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.eVX = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.eVV.setCornerRadius(22);
            this.eVV.setRoundMode(3);
            this.eVV.setVisibility(8);
            this.eVU.setThreeDotMode(2);
            this.cvm = (ImageView) view.findViewById(R.id.delete_image);
            this.cvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eVQ != null) {
                        b.this.eVQ.onClick(view2);
                    }
                }
            });
            this.eVW = (TextView) view.findViewById(R.id.live_label_view);
            this.euc = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
