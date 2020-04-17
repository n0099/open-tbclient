package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class c extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> gzm;
    private boolean gzn;
    private b gzo;
    private View.OnLongClickListener gzp;
    private View.OnClickListener gzq;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.gzm = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.gzm == null) {
            return 0;
        }
        return this.gzm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.gzm != null && this.gzm.get(i) != null) {
            VisitedForumData visitedForumData = this.gzm.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.gzt.startLoad(visitedForumData.aWx(), 10, false);
            aVar.gzt.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.gzt.setStrokeWith(3);
            aVar.gzt.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dZO, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.dIy, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.gzs, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aPt().lb(R.color.cp_btn_a).kW(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kV(4353).kY(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).kZ(0).la(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aR(aVar.ggr);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.dIy.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gzs.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aWB()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.gzv.setVisibility(0);
                aVar.gzv.setDefaultGradientColor();
            } else if (aVar.gzv != null) {
                aVar.gzv.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.gzv.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gzu.setVisibility(8);
            aVar.dZO.setVisibility(8);
            aVar.gzw.setVisibility(8);
            if (this.gzn) {
                aVar.dZO.setVisibility(0);
                aVar.dZO.setTag(visitedForumData);
            } else if (!visitedForumData.aWy()) {
                if (visitedForumData.aWz() <= 0) {
                    aVar.gzu.setVisibility(8);
                    return;
                }
                aVar.gzu.setVisibility(0);
                aVar.gzu.refresh(visitedForumData.aWz());
            } else {
                aVar.gzw.setVisibility(0);
            }
        }
    }

    public void iB(boolean z) {
        this.gzn = z;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.gzo = bVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.gzp = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.gzq = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView dIy;
        public ImageView dZO;
        public LinearLayout ggr;
        public View gzr;
        public TextView gzs;
        public BarImageView gzt;
        public MessageRedDotView gzu;
        public LinearGradientView gzv;
        public TextView gzw;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gzo != null) {
                        c.this.gzo.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (c.this.gzp != null) {
                        c.this.gzp.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.gzr = view.findViewById(R.id.top_container);
            this.gzt = (BarImageView) view.findViewById(R.id.forum_image);
            this.gzt.setPlaceHolder(2);
            this.gzt.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.dIy = (TextView) view.findViewById(R.id.forum_name);
            this.gzu = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.gzs = (TextView) view.findViewById(R.id.forum_follow);
            this.gzv = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.gzv.setCornerRadius(l.getDimens(c.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.gzv.setRoundMode(3);
            this.gzv.setVisibility(8);
            this.gzu.setThreeDotMode(2);
            this.gzu.setEnterForumStyle(true);
            this.dZO = (ImageView) view.findViewById(R.id.delete_image);
            this.dZO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gzq != null) {
                        c.this.gzq.onClick(view2);
                    }
                }
            });
            this.gzw = (TextView) view.findViewById(R.id.live_label_view);
            this.ggr = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
