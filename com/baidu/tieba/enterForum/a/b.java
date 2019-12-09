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
    private LinkedList<VisitedForumData> eZn;
    private boolean eZo;
    private InterfaceC0394b eZp;
    private View.OnLongClickListener eZq;
    private View.OnClickListener eZr;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0394b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.eZn = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eZn == null) {
            return 0;
        }
        return this.eZn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.eZn != null && this.eZn.get(i) != null) {
            VisitedForumData visitedForumData = this.eZn.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.eZu.startLoad(visitedForumData.atF(), 10, false);
            aVar.eZu.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.eZu.setStrokeWith(3);
            aVar.eZu.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.cHA, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.cqt, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.eZt, (int) R.color.cp_cont_d);
            am.setBackgroundResource(aVar.eZs, R.drawable.recent_visit_bg_top);
            am.setBackgroundResource(aVar.eDF, R.drawable.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.cqt.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eZt.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.atJ()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.eZy.setVisibility(8);
                aVar.eZw.setVisibility(0);
                aVar.eZw.setDefaultGradientColor();
                return;
            }
            aVar.eZy.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.eZw != null) {
                aVar.eZw.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.eZw.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.eZy != null) {
                aVar.eZy.startLoad(themeElement.pattern_image, 10, false);
                aVar.eZy.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.eZy.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.eZv.setVisibility(8);
            aVar.cHA.setVisibility(8);
            aVar.eZx.setVisibility(8);
            if (this.eZo) {
                aVar.cHA.setVisibility(0);
                aVar.cHA.setTag(visitedForumData);
            } else if (!visitedForumData.atG()) {
                if (visitedForumData.atH() <= 0) {
                    aVar.eZv.setVisibility(8);
                    return;
                }
                aVar.eZv.setVisibility(0);
                aVar.eZv.refresh(visitedForumData.atH());
            } else {
                aVar.eZx.setVisibility(0);
            }
        }
    }

    public void gc(boolean z) {
        this.eZo = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0394b interfaceC0394b) {
        this.eZp = interfaceC0394b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.eZq = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.eZr = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView cHA;
        public TextView cqt;
        public LinearLayout eDF;
        public View eZs;
        public TextView eZt;
        public BarImageView eZu;
        public MessageRedDotView eZv;
        public LinearGradientView eZw;
        public TextView eZx;
        public TbImageView eZy;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eZp != null) {
                        b.this.eZp.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.eZq != null) {
                        b.this.eZq.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.eZs = view.findViewById(R.id.top_container);
            this.eZu = (BarImageView) view.findViewById(R.id.forum_image);
            this.eZu.setDefaultResource(R.drawable.icon_default_ba_120);
            this.eZu.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.cqt = (TextView) view.findViewById(R.id.forum_name);
            this.eZv = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.eZt = (TextView) view.findViewById(R.id.forum_follow);
            this.eZw = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.eZy = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.eZw.setCornerRadius(22);
            this.eZw.setRoundMode(3);
            this.eZw.setVisibility(8);
            this.eZv.setThreeDotMode(2);
            this.cHA = (ImageView) view.findViewById(R.id.delete_image);
            this.cHA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eZr != null) {
                        b.this.eZr.onClick(view2);
                    }
                }
            });
            this.eZx = (TextView) view.findViewById(R.id.live_label_view);
            this.eDF = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
