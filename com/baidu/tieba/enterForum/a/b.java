package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes16.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> hgF;
    private boolean hgG;
    private InterfaceC0617b hgH;
    private View.OnLongClickListener hgI;
    private View.OnClickListener hgJ;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0617b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.hgF = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hgF == null) {
            return 0;
        }
        return this.hgF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.hgF != null && this.hgF.get(i) != null) {
            VisitedForumData visitedForumData = this.hgF.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.hgM.startLoad(visitedForumData.biq(), 10, false);
            aVar.hgM.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.hgM.setStrokeWith(3);
            aVar.hgM.setShowOval(true);
            c(visitedForumData, aVar);
            ao.setImageResource(aVar.eDm, R.drawable.icon_ba_delete_n);
            ao.setViewTextColor(aVar.ekx, R.color.cp_cont_b);
            ao.setViewTextColor(aVar.hgL, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_btn_a).ml(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).mm(R.color.cp_shadow_a_alpha16).mk(4353).mn(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).mo(0).mp(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aX(aVar.baL);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (as.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ekx.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hgL.setText("关注 " + as.numFormatOverWanNa(visitedForumData.biu()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.hgO.setVisibility(0);
                aVar.hgO.setDefaultGradientColor();
            } else if (aVar.hgO != null) {
                aVar.hgO.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.hgO.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hgN.setVisibility(8);
            aVar.eDm.setVisibility(8);
            aVar.hgP.setVisibility(8);
            if (this.hgG) {
                aVar.eDm.setVisibility(0);
                aVar.eDm.setTag(visitedForumData);
            } else if (!visitedForumData.bir()) {
                if (visitedForumData.bis() <= 0) {
                    aVar.hgN.setVisibility(8);
                    return;
                }
                aVar.hgN.setVisibility(0);
                aVar.hgN.refresh(visitedForumData.bis());
            } else {
                aVar.hgP.setVisibility(0);
            }
        }
    }

    public void jO(boolean z) {
        this.hgG = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0617b interfaceC0617b) {
        this.hgH = interfaceC0617b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.hgI = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.hgJ = onClickListener;
    }

    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout baL;
        public ImageView eDm;
        public TextView ekx;
        public View hgK;
        public TextView hgL;
        public BarImageView hgM;
        public MessageRedDotView hgN;
        public LinearGradientView hgO;
        public TextView hgP;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hgH != null) {
                        b.this.hgH.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.hgI != null) {
                        b.this.hgI.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.hgK = view.findViewById(R.id.top_container);
            this.hgM = (BarImageView) view.findViewById(R.id.forum_image);
            this.hgM.setPlaceHolderAutoChangeSkinType(2);
            this.hgM.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.ekx = (TextView) view.findViewById(R.id.forum_name);
            this.hgN = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.hgL = (TextView) view.findViewById(R.id.forum_follow);
            this.hgO = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.hgO.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.hgO.setRoundMode(3);
            this.hgO.setVisibility(8);
            this.hgN.setThreeDotMode(2);
            this.hgN.setEnterForumStyle(true);
            this.eDm = (ImageView) view.findViewById(R.id.delete_image);
            this.eDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hgJ != null) {
                        b.this.hgJ.onClick(view2);
                    }
                }
            });
            this.hgP = (TextView) view.findViewById(R.id.live_label_view);
            this.baL = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
