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
/* loaded from: classes22.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> hPE;
    private boolean hPF;
    private InterfaceC0682b hPG;
    private View.OnLongClickListener hPH;
    private View.OnClickListener hPI;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0682b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.hPE = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hPE == null) {
            return 0;
        }
        return this.hPE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.hPE != null && this.hPE.get(i) != null) {
            VisitedForumData visitedForumData = this.hPE.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.hPL.startLoad(visitedForumData.buH(), 10, false);
            aVar.hPL.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.hPL.setStrokeWith(3);
            aVar.hPL.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.fcO, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.eIK, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.hPK, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_btn_a).oZ(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).pa(R.color.cp_shadow_a_alpha16).oY(4353).pb(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).pc(0).pd(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bf(aVar.bmN);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.eIK.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hPK.setText("关注 " + at.numFormatOverWanNa(visitedForumData.buL()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.hPN.setVisibility(0);
                aVar.hPN.setDefaultGradientColor();
            } else if (aVar.hPN != null) {
                aVar.hPN.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.hPN.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.hPM.setVisibility(8);
            aVar.fcO.setVisibility(8);
            aVar.hPO.setVisibility(8);
            if (this.hPF) {
                aVar.fcO.setVisibility(0);
                aVar.fcO.setTag(visitedForumData);
            } else if (!visitedForumData.buI()) {
                if (visitedForumData.buJ() <= 0) {
                    aVar.hPM.setVisibility(8);
                    return;
                }
                aVar.hPM.setVisibility(0);
                aVar.hPM.refresh(visitedForumData.buJ());
            } else {
                aVar.hPO.setVisibility(0);
            }
        }
    }

    public void kN(boolean z) {
        this.hPF = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0682b interfaceC0682b) {
        this.hPG = interfaceC0682b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.hPH = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.hPI = onClickListener;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bmN;
        public TextView eIK;
        public ImageView fcO;
        public View hPJ;
        public TextView hPK;
        public BarImageView hPL;
        public MessageRedDotView hPM;
        public LinearGradientView hPN;
        public TextView hPO;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hPG != null) {
                        b.this.hPG.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.hPH != null) {
                        b.this.hPH.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.hPJ = view.findViewById(R.id.top_container);
            this.hPL = (BarImageView) view.findViewById(R.id.forum_image);
            this.hPL.setPlaceHolderAutoChangeSkinType(2);
            this.hPL.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.eIK = (TextView) view.findViewById(R.id.forum_name);
            this.hPM = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.hPK = (TextView) view.findViewById(R.id.forum_follow);
            this.hPN = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.hPN.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.hPN.setRoundMode(3);
            this.hPN.setVisibility(8);
            this.hPM.setThreeDotMode(2);
            this.hPM.setEnterForumStyle(true);
            this.fcO = (ImageView) view.findViewById(R.id.delete_image);
            this.fcO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hPI != null) {
                        b.this.hPI.onClick(view2);
                    }
                }
            });
            this.hPO = (TextView) view.findViewById(R.id.live_label_view);
            this.bmN = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
