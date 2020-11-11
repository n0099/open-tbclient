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
    private LinkedList<VisitedForumData> iic;
    private boolean iid;
    private InterfaceC0712b iie;
    private View.OnLongClickListener iif;
    private View.OnClickListener iig;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0712b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.iic = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iic == null) {
            return 0;
        }
        return this.iic.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.iic != null && this.iic.get(i) != null) {
            VisitedForumData visitedForumData = this.iic.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.iij.startLoad(visitedForumData.byZ(), 10, false);
            aVar.iij.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.iij.setStrokeWith(3);
            aVar.iij.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.frf, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.eWV, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.iii, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_btn_a).pv(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).pw(R.color.cp_shadow_a_alpha16).pu(4353).px(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).py(0).pz(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bk(aVar.bpE);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.eWV.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.iii.setText("关注 " + at.numFormatOverWanNa(visitedForumData.bzd()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.iil.setVisibility(0);
                aVar.iil.setDefaultGradientColor();
            } else if (aVar.iil != null) {
                aVar.iil.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.iil.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.iik.setVisibility(8);
            aVar.frf.setVisibility(8);
            aVar.iim.setVisibility(8);
            if (this.iid) {
                aVar.frf.setVisibility(0);
                aVar.frf.setTag(visitedForumData);
            } else if (!visitedForumData.bza()) {
                if (visitedForumData.bzb() <= 0) {
                    aVar.iik.setVisibility(8);
                    return;
                }
                aVar.iik.setVisibility(0);
                aVar.iik.refresh(visitedForumData.bzb());
            } else {
                aVar.iim.setVisibility(0);
            }
        }
    }

    public void lj(boolean z) {
        this.iid = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0712b interfaceC0712b) {
        this.iie = interfaceC0712b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.iif = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.iig = onClickListener;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bpE;
        public TextView eWV;
        public ImageView frf;
        public View iih;
        public TextView iii;
        public BarImageView iij;
        public MessageRedDotView iik;
        public LinearGradientView iil;
        public TextView iim;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iie != null) {
                        b.this.iie.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.iif != null) {
                        b.this.iif.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.iih = view.findViewById(R.id.top_container);
            this.iij = (BarImageView) view.findViewById(R.id.forum_image);
            this.iij.setPlaceHolderAutoChangeSkinType(2);
            this.iij.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.eWV = (TextView) view.findViewById(R.id.forum_name);
            this.iik = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.iii = (TextView) view.findViewById(R.id.forum_follow);
            this.iil = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.iil.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.iil.setRoundMode(3);
            this.iil.setVisibility(8);
            this.iik.setThreeDotMode(2);
            this.iik.setEnterForumStyle(true);
            this.frf = (ImageView) view.findViewById(R.id.delete_image);
            this.frf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iig != null) {
                        b.this.iig.onClick(view2);
                    }
                }
            });
            this.iim = (TextView) view.findViewById(R.id.live_label_view);
            this.bpE = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
