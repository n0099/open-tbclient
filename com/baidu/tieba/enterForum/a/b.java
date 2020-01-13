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
/* loaded from: classes7.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> fRe;
    private boolean fRf;
    private InterfaceC0486b fRg;
    private View.OnLongClickListener fRh;
    private View.OnClickListener fRi;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0486b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.fRe = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fRe == null) {
            return 0;
        }
        return this.fRe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fRe != null && this.fRe.get(i) != null) {
            VisitedForumData visitedForumData = this.fRe.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fRl.startLoad(visitedForumData.aLD(), 10, false);
            aVar.fRl.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fRl.setStrokeWith(3);
            aVar.fRl.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dvz, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.ddX, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fRk, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.f.a.aEL().kA(R.color.cp_btn_a).kv(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).ku(4353).kx(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ky(0).kz(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aQ(aVar.fyv);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ddX.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fRk.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aLH()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.fRn.setVisibility(0);
                aVar.fRn.setDefaultGradientColor();
            } else if (aVar.fRn != null) {
                aVar.fRn.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.fRn.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fRm.setVisibility(8);
            aVar.dvz.setVisibility(8);
            aVar.fRo.setVisibility(8);
            if (this.fRf) {
                aVar.dvz.setVisibility(0);
                aVar.dvz.setTag(visitedForumData);
            } else if (!visitedForumData.aLE()) {
                if (visitedForumData.aLF() <= 0) {
                    aVar.fRm.setVisibility(8);
                    return;
                }
                aVar.fRm.setVisibility(0);
                aVar.fRm.refresh(visitedForumData.aLF());
            } else {
                aVar.fRo.setVisibility(0);
            }
        }
    }

    public void hv(boolean z) {
        this.fRf = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0486b interfaceC0486b) {
        this.fRg = interfaceC0486b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fRh = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.fRi = onClickListener;
    }

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView ddX;
        public ImageView dvz;
        public View fRj;
        public TextView fRk;
        public BarImageView fRl;
        public MessageRedDotView fRm;
        public LinearGradientView fRn;
        public TextView fRo;
        public LinearLayout fyv;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fRg != null) {
                        b.this.fRg.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fRh != null) {
                        b.this.fRh.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.fRj = view.findViewById(R.id.top_container);
            this.fRl = (BarImageView) view.findViewById(R.id.forum_image);
            this.fRl.setPlaceHolder(2);
            this.fRl.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.ddX = (TextView) view.findViewById(R.id.forum_name);
            this.fRm = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fRk = (TextView) view.findViewById(R.id.forum_follow);
            this.fRn = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fRn.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.fRn.setRoundMode(3);
            this.fRn.setVisibility(8);
            this.fRm.setThreeDotMode(2);
            this.fRm.setEnterForumStyle(true);
            this.dvz = (ImageView) view.findViewById(R.id.delete_image);
            this.dvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fRi != null) {
                        b.this.fRi.onClick(view2);
                    }
                }
            });
            this.fRo = (TextView) view.findViewById(R.id.live_label_view);
            this.fyv = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
