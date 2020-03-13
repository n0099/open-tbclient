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
    private LinkedList<VisitedForumData> fTO;
    private boolean fTP;
    private InterfaceC0494b fTQ;
    private View.OnLongClickListener fTR;
    private View.OnClickListener fTS;
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
        this.fTO = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fTO == null) {
            return 0;
        }
        return this.fTO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fTO != null && this.fTO.get(i) != null) {
            VisitedForumData visitedForumData = this.fTO.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fTV.startLoad(visitedForumData.aOc(), 10, false);
            aVar.fTV.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fTV.setStrokeWith(3);
            aVar.fTV.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.dzT, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.diq, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fTU, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aHa().kR(R.color.cp_btn_a).kM(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aQ(aVar.fBi);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.diq.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fTU.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.aOg()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.fTX.setVisibility(0);
                aVar.fTX.setDefaultGradientColor();
            } else if (aVar.fTX != null) {
                aVar.fTX.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.fTX.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fTW.setVisibility(8);
            aVar.dzT.setVisibility(8);
            aVar.fTY.setVisibility(8);
            if (this.fTP) {
                aVar.dzT.setVisibility(0);
                aVar.dzT.setTag(visitedForumData);
            } else if (!visitedForumData.aOd()) {
                if (visitedForumData.aOe() <= 0) {
                    aVar.fTW.setVisibility(8);
                    return;
                }
                aVar.fTW.setVisibility(0);
                aVar.fTW.refresh(visitedForumData.aOe());
            } else {
                aVar.fTY.setVisibility(0);
            }
        }
    }

    public void hC(boolean z) {
        this.fTP = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0494b interfaceC0494b) {
        this.fTQ = interfaceC0494b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fTR = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.fTS = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView diq;
        public ImageView dzT;
        public LinearLayout fBi;
        public View fTT;
        public TextView fTU;
        public BarImageView fTV;
        public MessageRedDotView fTW;
        public LinearGradientView fTX;
        public TextView fTY;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTQ != null) {
                        b.this.fTQ.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fTR != null) {
                        b.this.fTR.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.fTT = view.findViewById(R.id.top_container);
            this.fTV = (BarImageView) view.findViewById(R.id.forum_image);
            this.fTV.setPlaceHolder(2);
            this.fTV.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.diq = (TextView) view.findViewById(R.id.forum_name);
            this.fTW = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fTU = (TextView) view.findViewById(R.id.forum_follow);
            this.fTX = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fTX.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.fTX.setRoundMode(3);
            this.fTX.setVisibility(8);
            this.fTW.setThreeDotMode(2);
            this.fTW.setEnterForumStyle(true);
            this.dzT = (ImageView) view.findViewById(R.id.delete_image);
            this.dzT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTS != null) {
                        b.this.fTS.onClick(view2);
                    }
                }
            });
            this.fTY = (TextView) view.findViewById(R.id.live_label_view);
            this.fBi = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
