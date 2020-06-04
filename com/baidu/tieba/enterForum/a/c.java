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
public class c extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> gOn;
    private boolean gOo;
    private b gOp;
    private View.OnLongClickListener gOq;
    private View.OnClickListener gOr;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.gOn = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.gOn == null) {
            return 0;
        }
        return this.gOn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.gOn != null && this.gOn.get(i) != null) {
            VisitedForumData visitedForumData = this.gOn.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.gOu.startLoad(visitedForumData.bcF(), 10, false);
            aVar.gOu.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.gOu.setStrokeWith(3);
            aVar.gOu.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.eoe, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.dWR, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.gOt, (int) R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.aVv().lF(R.color.cp_btn_a).lA(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).lB(R.color.cp_shadow_a_alpha16).lz(4353).lC(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).lD(0).lE(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aR(aVar.aYe);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.dWR.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gOt.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.bcJ()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.gOw.setVisibility(0);
                aVar.gOw.setDefaultGradientColor();
            } else if (aVar.gOw != null) {
                aVar.gOw.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.gOw.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.gOv.setVisibility(8);
            aVar.eoe.setVisibility(8);
            aVar.gOx.setVisibility(8);
            if (this.gOo) {
                aVar.eoe.setVisibility(0);
                aVar.eoe.setTag(visitedForumData);
            } else if (!visitedForumData.bcG()) {
                if (visitedForumData.bcH() <= 0) {
                    aVar.gOv.setVisibility(8);
                    return;
                }
                aVar.gOv.setVisibility(0);
                aVar.gOv.refresh(visitedForumData.bcH());
            } else {
                aVar.gOx.setVisibility(0);
            }
        }
    }

    public void iY(boolean z) {
        this.gOo = z;
        notifyDataSetChanged();
    }

    public void a(b bVar) {
        this.gOp = bVar;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.gOq = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.gOr = onClickListener;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout aYe;
        public TextView dWR;
        public ImageView eoe;
        public View gOs;
        public TextView gOt;
        public BarImageView gOu;
        public MessageRedDotView gOv;
        public LinearGradientView gOw;
        public TextView gOx;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gOp != null) {
                        c.this.gOp.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (c.this.gOq != null) {
                        c.this.gOq.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.gOs = view.findViewById(R.id.top_container);
            this.gOu = (BarImageView) view.findViewById(R.id.forum_image);
            this.gOu.setPlaceHolderAutoChangeSkinType(2);
            this.gOu.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.dWR = (TextView) view.findViewById(R.id.forum_name);
            this.gOv = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.gOt = (TextView) view.findViewById(R.id.forum_follow);
            this.gOw = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.gOw.setCornerRadius(l.getDimens(c.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.gOw.setRoundMode(3);
            this.gOw.setVisibility(8);
            this.gOv.setThreeDotMode(2);
            this.gOv.setEnterForumStyle(true);
            this.eoe = (ImageView) view.findViewById(R.id.delete_image);
            this.eoe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.c.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gOr != null) {
                        c.this.gOr.onClick(view2);
                    }
                }
            });
            this.gOx = (TextView) view.findViewById(R.id.live_label_view);
            this.aYe = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
