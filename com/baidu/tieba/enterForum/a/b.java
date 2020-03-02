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
    private LinkedList<VisitedForumData> fTB;
    private boolean fTC;
    private InterfaceC0494b fTD;
    private View.OnLongClickListener fTE;
    private View.OnClickListener fTF;
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
        this.fTB = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fTB == null) {
            return 0;
        }
        return this.fTB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fTB != null && this.fTB.get(i) != null) {
            VisitedForumData visitedForumData = this.fTB.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fTI.startLoad(visitedForumData.aOb(), 10, false);
            aVar.fTI.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fTI.setStrokeWith(3);
            aVar.fTI.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dzG, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.dic, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fTH, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.f.a.aGZ().kR(R.color.cp_btn_a).kM(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aQ(aVar.fAV);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.dic.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fTH.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aOf()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.fTK.setVisibility(0);
                aVar.fTK.setDefaultGradientColor();
            } else if (aVar.fTK != null) {
                aVar.fTK.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.fTK.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fTJ.setVisibility(8);
            aVar.dzG.setVisibility(8);
            aVar.fTL.setVisibility(8);
            if (this.fTC) {
                aVar.dzG.setVisibility(0);
                aVar.dzG.setTag(visitedForumData);
            } else if (!visitedForumData.aOc()) {
                if (visitedForumData.aOd() <= 0) {
                    aVar.fTJ.setVisibility(8);
                    return;
                }
                aVar.fTJ.setVisibility(0);
                aVar.fTJ.refresh(visitedForumData.aOd());
            } else {
                aVar.fTL.setVisibility(0);
            }
        }
    }

    public void hC(boolean z) {
        this.fTC = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0494b interfaceC0494b) {
        this.fTD = interfaceC0494b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fTE = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.fTF = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView dic;
        public ImageView dzG;
        public LinearLayout fAV;
        public View fTG;
        public TextView fTH;
        public BarImageView fTI;
        public MessageRedDotView fTJ;
        public LinearGradientView fTK;
        public TextView fTL;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTD != null) {
                        b.this.fTD.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fTE != null) {
                        b.this.fTE.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.fTG = view.findViewById(R.id.top_container);
            this.fTI = (BarImageView) view.findViewById(R.id.forum_image);
            this.fTI.setPlaceHolder(2);
            this.fTI.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.dic = (TextView) view.findViewById(R.id.forum_name);
            this.fTJ = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fTH = (TextView) view.findViewById(R.id.forum_follow);
            this.fTK = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fTK.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.fTK.setRoundMode(3);
            this.fTK.setVisibility(8);
            this.fTJ.setThreeDotMode(2);
            this.fTJ.setEnterForumStyle(true);
            this.dzG = (ImageView) view.findViewById(R.id.delete_image);
            this.dzG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTF != null) {
                        b.this.fTF.onClick(view2);
                    }
                }
            });
            this.fTL = (TextView) view.findViewById(R.id.live_label_view);
            this.fAV = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
