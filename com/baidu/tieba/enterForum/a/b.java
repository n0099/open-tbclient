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
    private View.OnLongClickListener fUA;
    private View.OnClickListener fUB;
    private LinkedList<VisitedForumData> fUx;
    private boolean fUy;
    private InterfaceC0494b fUz;
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
        this.fUx = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fUx == null) {
            return 0;
        }
        return this.fUx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fUx != null && this.fUx.get(i) != null) {
            VisitedForumData visitedForumData = this.fUx.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fUE.startLoad(visitedForumData.aOg(), 10, false);
            aVar.fUE.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fUE.setStrokeWith(3);
            aVar.fUE.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dAg, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.diF, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fUD, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aHe().kR(R.color.cp_btn_a).kM(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aQ(aVar.fBQ);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.diF.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fUD.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aOk()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.fUG.setVisibility(0);
                aVar.fUG.setDefaultGradientColor();
            } else if (aVar.fUG != null) {
                aVar.fUG.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.fUG.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fUF.setVisibility(8);
            aVar.dAg.setVisibility(8);
            aVar.fUH.setVisibility(8);
            if (this.fUy) {
                aVar.dAg.setVisibility(0);
                aVar.dAg.setTag(visitedForumData);
            } else if (!visitedForumData.aOh()) {
                if (visitedForumData.aOi() <= 0) {
                    aVar.fUF.setVisibility(8);
                    return;
                }
                aVar.fUF.setVisibility(0);
                aVar.fUF.refresh(visitedForumData.aOi());
            } else {
                aVar.fUH.setVisibility(0);
            }
        }
    }

    public void hD(boolean z) {
        this.fUy = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0494b interfaceC0494b) {
        this.fUz = interfaceC0494b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fUA = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.fUB = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView dAg;
        public TextView diF;
        public LinearLayout fBQ;
        public View fUC;
        public TextView fUD;
        public BarImageView fUE;
        public MessageRedDotView fUF;
        public LinearGradientView fUG;
        public TextView fUH;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fUz != null) {
                        b.this.fUz.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fUA != null) {
                        b.this.fUA.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.fUC = view.findViewById(R.id.top_container);
            this.fUE = (BarImageView) view.findViewById(R.id.forum_image);
            this.fUE.setPlaceHolder(2);
            this.fUE.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.diF = (TextView) view.findViewById(R.id.forum_name);
            this.fUF = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fUD = (TextView) view.findViewById(R.id.forum_follow);
            this.fUG = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fUG.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.fUG.setRoundMode(3);
            this.fUG.setVisibility(8);
            this.fUF.setThreeDotMode(2);
            this.fUF.setEnterForumStyle(true);
            this.dAg = (ImageView) view.findViewById(R.id.delete_image);
            this.dAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fUB != null) {
                        b.this.fUB.onClick(view2);
                    }
                }
            });
            this.fUH = (TextView) view.findViewById(R.id.live_label_view);
            this.fBQ = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
