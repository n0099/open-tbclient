package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> hba;
    private boolean hbb;
    private InterfaceC0608b hbc;
    private View.OnLongClickListener hbd;
    private View.OnClickListener hbe;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0608b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.hba = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hba == null) {
            return 0;
        }
        return this.hba.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.hba != null && this.hba.get(i) != null) {
            VisitedForumData visitedForumData = this.hba.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.hbh.startLoad(visitedForumData.beH(), 10, false);
            aVar.hbh.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.hbh.setStrokeWith(3);
            aVar.hbh.setShowOval(true);
            c(visitedForumData, aVar);
            an.setImageResource(aVar.ewT, R.drawable.icon_ba_delete_n);
            an.setViewTextColor(aVar.een, (int) R.color.cp_cont_b);
            an.setViewTextColor(aVar.hbg, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aXp().lW(R.color.cp_btn_a).lR(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).lS(R.color.cp_shadow_a_alpha16).lQ(4353).lT(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).lU(0).lV(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aR(aVar.baM);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (ar.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.een.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hbg.setText("关注 " + ar.numFormatOverWanNa(visitedForumData.beL()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.hbj.setVisibility(0);
                aVar.hbj.setDefaultGradientColor();
            } else if (aVar.hbj != null) {
                aVar.hbj.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.hbj.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hbi.setVisibility(8);
            aVar.ewT.setVisibility(8);
            aVar.hbk.setVisibility(8);
            if (this.hbb) {
                aVar.ewT.setVisibility(0);
                aVar.ewT.setTag(visitedForumData);
            } else if (!visitedForumData.beI()) {
                if (visitedForumData.beJ() <= 0) {
                    aVar.hbi.setVisibility(8);
                    return;
                }
                aVar.hbi.setVisibility(0);
                aVar.hbi.refresh(visitedForumData.beJ());
            } else {
                aVar.hbk.setVisibility(0);
            }
        }
    }

    public void jk(boolean z) {
        this.hbb = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0608b interfaceC0608b) {
        this.hbc = interfaceC0608b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.hbd = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.hbe = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout baM;
        public TextView een;
        public ImageView ewT;
        public View hbf;
        public TextView hbg;
        public BarImageView hbh;
        public MessageRedDotView hbi;
        public LinearGradientView hbj;
        public TextView hbk;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hbc != null) {
                        b.this.hbc.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.hbd != null) {
                        b.this.hbd.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.hbf = view.findViewById(R.id.top_container);
            this.hbh = (BarImageView) view.findViewById(R.id.forum_image);
            this.hbh.setPlaceHolderAutoChangeSkinType(2);
            this.hbh.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.een = (TextView) view.findViewById(R.id.forum_name);
            this.hbi = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.hbg = (TextView) view.findViewById(R.id.forum_follow);
            this.hbj = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.hbj.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.hbj.setRoundMode(3);
            this.hbj.setVisibility(8);
            this.hbi.setThreeDotMode(2);
            this.hbi.setEnterForumStyle(true);
            this.ewT = (ImageView) view.findViewById(R.id.delete_image);
            this.ewT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hbe != null) {
                        b.this.hbe.onClick(view2);
                    }
                }
            });
            this.hbk = (TextView) view.findViewById(R.id.live_label_view);
            this.baM = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
