package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes21.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> hAJ;
    private boolean hAK;
    private InterfaceC0664b hAL;
    private View.OnLongClickListener hAM;
    private View.OnClickListener hAN;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0664b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.hAJ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hAJ == null) {
            return 0;
        }
        return this.hAJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.hAJ != null && this.hAJ.get(i) != null) {
            VisitedForumData visitedForumData = this.hAJ.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.hAQ.startLoad(visitedForumData.brX(), 10, false);
            aVar.hAQ.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.hAQ.setStrokeWith(3);
            aVar.hAQ.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.eQG, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.ewA, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.hAP, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_btn_a).oB(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).oC(R.color.cp_shadow_a_alpha16).oA(4353).oD(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).oE(0).oF(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bb(aVar.bja);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.ewA.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hAP.setText("关注 " + at.numFormatOverWanNa(visitedForumData.bsb()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.hAS.setVisibility(0);
                aVar.hAS.setDefaultGradientColor();
            } else if (aVar.hAS != null) {
                aVar.hAS.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.hAS.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hAR.setVisibility(8);
            aVar.eQG.setVisibility(8);
            aVar.hAT.setVisibility(8);
            if (this.hAK) {
                aVar.eQG.setVisibility(0);
                aVar.eQG.setTag(visitedForumData);
            } else if (!visitedForumData.brY()) {
                if (visitedForumData.brZ() <= 0) {
                    aVar.hAR.setVisibility(8);
                    return;
                }
                aVar.hAR.setVisibility(0);
                aVar.hAR.refresh(visitedForumData.brZ());
            } else {
                aVar.hAT.setVisibility(0);
            }
        }
    }

    public void kp(boolean z) {
        this.hAK = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0664b interfaceC0664b) {
        this.hAL = interfaceC0664b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.hAM = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.hAN = onClickListener;
    }

    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bja;
        public ImageView eQG;
        public TextView ewA;
        public View hAO;
        public TextView hAP;
        public BarImageView hAQ;
        public MessageRedDotView hAR;
        public LinearGradientView hAS;
        public TextView hAT;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hAL != null) {
                        b.this.hAL.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.hAM != null) {
                        b.this.hAM.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.hAO = view.findViewById(R.id.top_container);
            this.hAQ = (BarImageView) view.findViewById(R.id.forum_image);
            this.hAQ.setPlaceHolderAutoChangeSkinType(2);
            this.hAQ.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.ewA = (TextView) view.findViewById(R.id.forum_name);
            this.hAR = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.hAP = (TextView) view.findViewById(R.id.forum_follow);
            this.hAS = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.hAS.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.hAS.setRoundMode(3);
            this.hAS.setVisibility(8);
            this.hAR.setThreeDotMode(2);
            this.hAR.setEnterForumStyle(true);
            this.eQG = (ImageView) view.findViewById(R.id.delete_image);
            this.eQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hAN != null) {
                        b.this.hAN.onClick(view2);
                    }
                }
            });
            this.hAT = (TextView) view.findViewById(R.id.live_label_view);
            this.bja = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
