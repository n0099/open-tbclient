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
/* loaded from: classes21.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> iiQ;
    private boolean iiR;
    private InterfaceC0715b iiS;
    private View.OnLongClickListener iiT;
    private View.OnClickListener iiU;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0715b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iiQ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iiQ == null) {
            return 0;
        }
        return this.iiQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.iiQ != null && this.iiQ.get(i) != null) {
            VisitedForumData visitedForumData = this.iiQ.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.iiX.startLoad(visitedForumData.byp(), 10, false);
            aVar.iiX.setStrokeColorResId(R.color.CAM_X0201);
            aVar.iiX.setStrokeWith(3);
            aVar.iiX.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.fqm, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.eWc, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.iiW, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0901).pS(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).pT(R.color.CAM_X0804).pR(4353).pU(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).pV(0).pW(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bn(aVar.bnT);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.eWc.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.iiW.setText("关注 " + au.numFormatOverWanNa(visitedForumData.byt()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.iiZ.setVisibility(0);
                aVar.iiZ.setDefaultGradientColor();
            } else if (aVar.iiZ != null) {
                aVar.iiZ.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.iiZ.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.iiY.setVisibility(8);
            aVar.fqm.setVisibility(8);
            aVar.ija.setVisibility(8);
            if (this.iiR) {
                aVar.fqm.setVisibility(0);
                aVar.fqm.setTag(visitedForumData);
            } else if (!visitedForumData.byq()) {
                if (visitedForumData.byr() <= 0) {
                    aVar.iiY.setVisibility(8);
                    return;
                }
                aVar.iiY.setVisibility(0);
                aVar.iiY.refresh(visitedForumData.byr());
            } else {
                aVar.ija.setVisibility(0);
            }
        }
    }

    public void lk(boolean z) {
        this.iiR = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0715b interfaceC0715b) {
        this.iiS = interfaceC0715b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iiT = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.iiU = onClickListener;
    }

    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bnT;
        public TextView eWc;
        public ImageView fqm;
        public View iiV;
        public TextView iiW;
        public BarImageView iiX;
        public MessageRedDotView iiY;
        public LinearGradientView iiZ;
        public TextView ija;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iiS != null) {
                        b.this.iiS.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.iiT != null) {
                        b.this.iiT.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iiV = view.findViewById(R.id.top_container);
            this.iiX = (BarImageView) view.findViewById(R.id.forum_image);
            this.iiX.setPlaceHolderAutoChangeSkinType(1);
            this.iiX.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.eWc = (TextView) view.findViewById(R.id.forum_name);
            this.iiY = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iiW = (TextView) view.findViewById(R.id.forum_follow);
            this.iiZ = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iiZ.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iiZ.setRoundMode(3);
            this.iiZ.setVisibility(8);
            this.iiY.setThreeDotMode(2);
            this.iiY.setEnterForumStyle(true);
            this.fqm = (ImageView) view.findViewById(R.id.delete_image);
            this.fqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iiU != null) {
                        b.this.iiU.onClick(view2);
                    }
                }
            });
            this.ija = (TextView) view.findViewById(R.id.live_label_view);
            this.bnT = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
