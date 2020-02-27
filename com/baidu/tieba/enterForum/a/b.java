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
public class b extends RecyclerView.Adapter<a> {
    private boolean fTA;
    private InterfaceC0494b fTB;
    private View.OnLongClickListener fTC;
    private View.OnClickListener fTD;
    private LinkedList<VisitedForumData> fTz;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0494b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.fTz = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fTz == null) {
            return 0;
        }
        return this.fTz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fTz != null && this.fTz.get(i) != null) {
            VisitedForumData visitedForumData = this.fTz.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fTG.startLoad(visitedForumData.aNZ(), 10, false);
            aVar.fTG.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fTG.setStrokeWith(3);
            aVar.fTG.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dzF, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.dib, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fTF, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.f.a.aGX().kR(R.color.cp_btn_a).kM(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aQ(aVar.fAT);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.dib.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fTF.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aOd()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.fTI.setVisibility(0);
                aVar.fTI.setDefaultGradientColor();
            } else if (aVar.fTI != null) {
                aVar.fTI.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.fTI.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fTH.setVisibility(8);
            aVar.dzF.setVisibility(8);
            aVar.fTJ.setVisibility(8);
            if (this.fTA) {
                aVar.dzF.setVisibility(0);
                aVar.dzF.setTag(visitedForumData);
            } else if (!visitedForumData.aOa()) {
                if (visitedForumData.aOb() <= 0) {
                    aVar.fTH.setVisibility(8);
                    return;
                }
                aVar.fTH.setVisibility(0);
                aVar.fTH.refresh(visitedForumData.aOb());
            } else {
                aVar.fTJ.setVisibility(0);
            }
        }
    }

    public void hC(boolean z) {
        this.fTA = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0494b interfaceC0494b) {
        this.fTB = interfaceC0494b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fTC = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.fTD = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView dib;
        public ImageView dzF;
        public LinearLayout fAT;
        public View fTE;
        public TextView fTF;
        public BarImageView fTG;
        public MessageRedDotView fTH;
        public LinearGradientView fTI;
        public TextView fTJ;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTB != null) {
                        b.this.fTB.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fTC != null) {
                        b.this.fTC.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.fTE = view.findViewById(R.id.top_container);
            this.fTG = (BarImageView) view.findViewById(R.id.forum_image);
            this.fTG.setPlaceHolder(2);
            this.fTG.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.dib = (TextView) view.findViewById(R.id.forum_name);
            this.fTH = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fTF = (TextView) view.findViewById(R.id.forum_follow);
            this.fTI = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fTI.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.fTI.setRoundMode(3);
            this.fTI.setVisibility(8);
            this.fTH.setThreeDotMode(2);
            this.fTH.setEnterForumStyle(true);
            this.dzF = (ImageView) view.findViewById(R.id.delete_image);
            this.dzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTD != null) {
                        b.this.fTD.onClick(view2);
                    }
                }
            });
            this.fTJ = (TextView) view.findViewById(R.id.live_label_view);
            this.fAT = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
