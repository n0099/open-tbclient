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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
/* loaded from: classes22.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> itJ;
    private boolean itK;
    private InterfaceC0729b itL;
    private View.OnLongClickListener itM;
    private View.OnClickListener itN;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0729b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.itJ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.itJ == null) {
            return 0;
        }
        return this.itJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.itJ != null && this.itJ.get(i) != null) {
            VisitedForumData visitedForumData = this.itJ.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.itQ.startLoad(visitedForumData.bBP(), 10, false);
            aVar.itQ.setStrokeColorResId(R.color.CAM_X0201);
            aVar.itQ.setStrokeWith(3);
            aVar.itQ.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.fxR, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.fdz, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.itP, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qs(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).qt(R.color.CAM_X0804).qr(4353).qu(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).qv(0).qw(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bq(aVar.btb);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.fdz.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.itP.setText("关注 " + au.numFormatOverWanNa(visitedForumData.bBT()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.itS.setVisibility(0);
                aVar.itS.setDefaultGradientColor();
            } else if (aVar.itS != null) {
                aVar.itS.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.itS.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.itR.setVisibility(8);
            aVar.fxR.setVisibility(8);
            aVar.itT.setVisibility(8);
            if (this.itK) {
                aVar.fxR.setVisibility(0);
                aVar.fxR.setTag(visitedForumData);
            } else if (!visitedForumData.bBQ()) {
                if (visitedForumData.bBR() <= 0) {
                    aVar.itR.setVisibility(8);
                    return;
                }
                aVar.itR.setVisibility(0);
                aVar.itR.refresh(visitedForumData.bBR());
            } else {
                aVar.itT.setVisibility(0);
            }
        }
    }

    public void lF(boolean z) {
        this.itK = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0729b interfaceC0729b) {
        this.itL = interfaceC0729b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.itM = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.itN = onClickListener;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout btb;
        public TextView fdz;
        public ImageView fxR;
        public View itO;
        public TextView itP;
        public BarImageView itQ;
        public MessageRedDotView itR;
        public LinearGradientView itS;
        public TextView itT;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.itL != null) {
                        b.this.itL.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.itM != null) {
                        b.this.itM.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.itO = view.findViewById(R.id.top_container);
            this.itQ = (BarImageView) view.findViewById(R.id.forum_image);
            this.itQ.setPlaceHolderAutoChangeSkinType(1);
            this.itQ.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.fdz = (TextView) view.findViewById(R.id.forum_name);
            this.itR = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.itP = (TextView) view.findViewById(R.id.forum_follow);
            this.itS = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.itS.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.itS.setRoundMode(3);
            this.itS.setVisibility(8);
            this.itR.setThreeDotMode(2);
            this.itR.setEnterForumStyle(true);
            this.fxR = (ImageView) view.findViewById(R.id.delete_image);
            this.fxR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.itN != null) {
                        b.this.itN.onClick(view2);
                    }
                }
            });
            this.itT = (TextView) view.findViewById(R.id.live_label_view);
            this.btb = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
