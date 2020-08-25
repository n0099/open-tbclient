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
    private InterfaceC0667b htA;
    private View.OnLongClickListener htB;
    private View.OnClickListener htC;
    private LinkedList<VisitedForumData> hty;
    private boolean htz;
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
        this.hty = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hty == null) {
            return 0;
        }
        return this.hty.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.hty != null && this.hty.get(i) != null) {
            VisitedForumData visitedForumData = this.hty.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.htF.startLoad(visitedForumData.brc(), 10, false);
            aVar.htF.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.htF.setStrokeWith(3);
            aVar.htF.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.eNL, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.eus, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.htE, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).oo(4353).or(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).os(0).ot(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).aZ(aVar.bgg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.eus.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.htE.setText("关注 " + at.numFormatOverWanNa(visitedForumData.brg()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.htH.setVisibility(0);
                aVar.htH.setDefaultGradientColor();
            } else if (aVar.htH != null) {
                aVar.htH.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.htH.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.htG.setVisibility(8);
            aVar.eNL.setVisibility(8);
            aVar.htI.setVisibility(8);
            if (this.htz) {
                aVar.eNL.setVisibility(0);
                aVar.eNL.setTag(visitedForumData);
            } else if (!visitedForumData.brd()) {
                if (visitedForumData.bre() <= 0) {
                    aVar.htG.setVisibility(8);
                    return;
                }
                aVar.htG.setVisibility(0);
                aVar.htG.refresh(visitedForumData.bre());
            } else {
                aVar.htI.setVisibility(0);
            }
        }
    }

    public void km(boolean z) {
        this.htz = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0667b interfaceC0667b) {
        this.htA = interfaceC0667b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.htB = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.htC = onClickListener;
    }

    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bgg;
        public ImageView eNL;
        public TextView eus;
        public View htD;
        public TextView htE;
        public BarImageView htF;
        public MessageRedDotView htG;
        public LinearGradientView htH;
        public TextView htI;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.htA != null) {
                        b.this.htA.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.htB != null) {
                        b.this.htB.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.htD = view.findViewById(R.id.top_container);
            this.htF = (BarImageView) view.findViewById(R.id.forum_image);
            this.htF.setPlaceHolderAutoChangeSkinType(2);
            this.htF.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.eus = (TextView) view.findViewById(R.id.forum_name);
            this.htG = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.htE = (TextView) view.findViewById(R.id.forum_follow);
            this.htH = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.htH.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.htH.setRoundMode(3);
            this.htH.setVisibility(8);
            this.htG.setThreeDotMode(2);
            this.htG.setEnterForumStyle(true);
            this.eNL = (ImageView) view.findViewById(R.id.delete_image);
            this.eNL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.htC != null) {
                        b.this.htC.onClick(view2);
                    }
                }
            });
            this.htI = (TextView) view.findViewById(R.id.live_label_view);
            this.bgg = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
