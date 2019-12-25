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
/* loaded from: classes6.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> fNV;
    private boolean fNW;
    private InterfaceC0482b fNX;
    private View.OnLongClickListener fNY;
    private View.OnClickListener fNZ;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0482b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.fNV = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fNV == null) {
            return 0;
        }
        return this.fNV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fNV != null && this.fNV.get(i) != null) {
            VisitedForumData visitedForumData = this.fNV.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fOc.startLoad(visitedForumData.aLk(), 10, false);
            aVar.fOc.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fOc.setStrokeWith(3);
            aVar.fOc.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dvr, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.ddN, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fOb, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.f.a.aEs().kA(R.color.cp_btn_a).kv(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).ku(4353).kx(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ky(0).kz(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aM(aVar.fvk);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ddN.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fOb.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aLo()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.fOe.setVisibility(0);
                aVar.fOe.setDefaultGradientColor();
            } else if (aVar.fOe != null) {
                aVar.fOe.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.fOe.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fOd.setVisibility(8);
            aVar.dvr.setVisibility(8);
            aVar.fOf.setVisibility(8);
            if (this.fNW) {
                aVar.dvr.setVisibility(0);
                aVar.dvr.setTag(visitedForumData);
            } else if (!visitedForumData.aLl()) {
                if (visitedForumData.aLm() <= 0) {
                    aVar.fOd.setVisibility(8);
                    return;
                }
                aVar.fOd.setVisibility(0);
                aVar.fOd.refresh(visitedForumData.aLm());
            } else {
                aVar.fOf.setVisibility(0);
            }
        }
    }

    public void hq(boolean z) {
        this.fNW = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0482b interfaceC0482b) {
        this.fNX = interfaceC0482b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fNY = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.fNZ = onClickListener;
    }

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView ddN;
        public ImageView dvr;
        public View fOa;
        public TextView fOb;
        public BarImageView fOc;
        public MessageRedDotView fOd;
        public LinearGradientView fOe;
        public TextView fOf;
        public LinearLayout fvk;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fNX != null) {
                        b.this.fNX.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fNY != null) {
                        b.this.fNY.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.fOa = view.findViewById(R.id.top_container);
            this.fOc = (BarImageView) view.findViewById(R.id.forum_image);
            this.fOc.setPlaceHolder(2);
            this.fOc.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.ddN = (TextView) view.findViewById(R.id.forum_name);
            this.fOd = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fOb = (TextView) view.findViewById(R.id.forum_follow);
            this.fOe = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fOe.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.fOe.setRoundMode(3);
            this.fOe.setVisibility(8);
            this.fOd.setThreeDotMode(2);
            this.fOd.setEnterForumStyle(true);
            this.dvr = (ImageView) view.findViewById(R.id.delete_image);
            this.dvr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fNZ != null) {
                        b.this.fNZ.onClick(view2);
                    }
                }
            });
            this.fOf = (TextView) view.findViewById(R.id.live_label_view);
            this.fvk = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
