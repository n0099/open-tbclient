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
    private LinkedList<VisitedForumData> gzs;
    private boolean gzt;
    private b gzu;
    private View.OnLongClickListener gzv;
    private View.OnClickListener gzw;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.gzs = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.gzs == null) {
            return 0;
        }
        return this.gzs.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.gzs != null && this.gzs.get(i) != null) {
            VisitedForumData visitedForumData = this.gzs.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.gzz.startLoad(visitedForumData.aWv(), 10, false);
            aVar.gzz.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.gzz.setStrokeWith(3);
            aVar.gzz.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dZT, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.dIC, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.gzy, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aPq().lb(R.color.cp_btn_a).kW(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kV(4353).kY(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).kZ(0).la(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aR(aVar.ggx);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.dIC.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gzy.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aWz()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.gzB.setVisibility(0);
                aVar.gzB.setDefaultGradientColor();
            } else if (aVar.gzB != null) {
                aVar.gzB.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.gzB.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gzA.setVisibility(8);
            aVar.dZT.setVisibility(8);
            aVar.gzC.setVisibility(8);
            if (this.gzt) {
                aVar.dZT.setVisibility(0);
                aVar.dZT.setTag(visitedForumData);
            } else if (!visitedForumData.aWw()) {
                if (visitedForumData.aWx() <= 0) {
                    aVar.gzA.setVisibility(8);
                    return;
                }
                aVar.gzA.setVisibility(0);
                aVar.gzA.refresh(visitedForumData.aWx());
            } else {
                aVar.gzC.setVisibility(0);
            }
        }
    }

    public void iB(boolean z) {
        this.gzt = z;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.gzu = bVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.gzv = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.gzw = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView dIC;
        public ImageView dZT;
        public LinearLayout ggx;
        public MessageRedDotView gzA;
        public LinearGradientView gzB;
        public TextView gzC;
        public View gzx;
        public TextView gzy;
        public BarImageView gzz;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gzu != null) {
                        c.this.gzu.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (c.this.gzv != null) {
                        c.this.gzv.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.gzx = view.findViewById(R.id.top_container);
            this.gzz = (BarImageView) view.findViewById(R.id.forum_image);
            this.gzz.setPlaceHolder(2);
            this.gzz.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.dIC = (TextView) view.findViewById(R.id.forum_name);
            this.gzA = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.gzy = (TextView) view.findViewById(R.id.forum_follow);
            this.gzB = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.gzB.setCornerRadius(l.getDimens(c.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.gzB.setRoundMode(3);
            this.gzB.setVisibility(8);
            this.gzA.setThreeDotMode(2);
            this.gzA.setEnterForumStyle(true);
            this.dZT = (ImageView) view.findViewById(R.id.delete_image);
            this.dZT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gzw != null) {
                        c.this.gzw.onClick(view2);
                    }
                }
            });
            this.gzC = (TextView) view.findViewById(R.id.live_label_view);
            this.ggx = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
