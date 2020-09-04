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
/* loaded from: classes16.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> htE;
    private boolean htF;
    private InterfaceC0667b htG;
    private View.OnLongClickListener htH;
    private View.OnClickListener htI;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0667b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.htE = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.htE == null) {
            return 0;
        }
        return this.htE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.htE != null && this.htE.get(i) != null) {
            VisitedForumData visitedForumData = this.htE.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.htL.startLoad(visitedForumData.brd(), 10, false);
            aVar.htL.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.htL.setStrokeWith(3);
            aVar.htL.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.eNP, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.euw, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.htK, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).oo(4353).or(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).os(0).ot(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aZ(aVar.bgi);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.euw.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.htK.setText("关注 " + at.numFormatOverWanNa(visitedForumData.brh()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.htN.setVisibility(0);
                aVar.htN.setDefaultGradientColor();
            } else if (aVar.htN != null) {
                aVar.htN.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.htN.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.htM.setVisibility(8);
            aVar.eNP.setVisibility(8);
            aVar.htO.setVisibility(8);
            if (this.htF) {
                aVar.eNP.setVisibility(0);
                aVar.eNP.setTag(visitedForumData);
            } else if (!visitedForumData.bre()) {
                if (visitedForumData.brf() <= 0) {
                    aVar.htM.setVisibility(8);
                    return;
                }
                aVar.htM.setVisibility(0);
                aVar.htM.refresh(visitedForumData.brf());
            } else {
                aVar.htO.setVisibility(0);
            }
        }
    }

    public void ko(boolean z) {
        this.htF = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0667b interfaceC0667b) {
        this.htG = interfaceC0667b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.htH = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.htI = onClickListener;
    }

    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bgi;
        public ImageView eNP;
        public TextView euw;
        public View htJ;
        public TextView htK;
        public BarImageView htL;
        public MessageRedDotView htM;
        public LinearGradientView htN;
        public TextView htO;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.htG != null) {
                        b.this.htG.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.htH != null) {
                        b.this.htH.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.htJ = view.findViewById(R.id.top_container);
            this.htL = (BarImageView) view.findViewById(R.id.forum_image);
            this.htL.setPlaceHolderAutoChangeSkinType(2);
            this.htL.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.euw = (TextView) view.findViewById(R.id.forum_name);
            this.htM = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.htK = (TextView) view.findViewById(R.id.forum_follow);
            this.htN = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.htN.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.htN.setRoundMode(3);
            this.htN.setVisibility(8);
            this.htM.setThreeDotMode(2);
            this.htM.setEnterForumStyle(true);
            this.eNP = (ImageView) view.findViewById(R.id.delete_image);
            this.eNP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.htI != null) {
                        b.this.htI.onClick(view2);
                    }
                }
            });
            this.htO = (TextView) view.findViewById(R.id.live_label_view);
            this.bgi = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
