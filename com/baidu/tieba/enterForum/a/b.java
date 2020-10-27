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
    private LinkedList<VisitedForumData> icb;
    private boolean icc;
    private InterfaceC0698b icd;
    private View.OnLongClickListener ice;
    private View.OnClickListener icf;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0698b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.icb = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.icb == null) {
            return 0;
        }
        return this.icb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.icb != null && this.icb.get(i) != null) {
            VisitedForumData visitedForumData = this.icb.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.ici.startLoad(visitedForumData.bwA(), 10, false);
            aVar.ici.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.ici.setStrokeWith(3);
            aVar.ici.setShowOval(true);
            c(visitedForumData, aVar);
            ap.setImageResource(aVar.flm, R.drawable.icon_ba_delete_n);
            ap.setViewTextColor(aVar.eRg, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.ich, R.color.cp_cont_d);
            com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_btn_a).pk(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds10)).pl(R.color.cp_shadow_a_alpha16).pj(4353).pm(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).po(0).pp(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds5)).bg(aVar.bol);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.eRg.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.ich.setText("关注 " + at.numFormatOverWanNa(visitedForumData.bwE()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null) {
                aVar.ick.setVisibility(0);
                aVar.ick.setDefaultGradientColor();
            } else if (aVar.ick != null) {
                aVar.ick.setGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark);
                aVar.ick.setVisibility(0);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.icj.setVisibility(8);
            aVar.flm.setVisibility(8);
            aVar.icl.setVisibility(8);
            if (this.icc) {
                aVar.flm.setVisibility(0);
                aVar.flm.setTag(visitedForumData);
            } else if (!visitedForumData.bwB()) {
                if (visitedForumData.bwC() <= 0) {
                    aVar.icj.setVisibility(8);
                    return;
                }
                aVar.icj.setVisibility(0);
                aVar.icj.refresh(visitedForumData.bwC());
            } else {
                aVar.icl.setVisibility(0);
            }
        }
    }

    public void la(boolean z) {
        this.icc = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0698b interfaceC0698b) {
        this.icd = interfaceC0698b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.ice = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.icf = onClickListener;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public LinearLayout bol;
        public TextView eRg;
        public ImageView flm;
        public View icg;
        public TextView ich;
        public BarImageView ici;
        public MessageRedDotView icj;
        public LinearGradientView ick;
        public TextView icl;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.icd != null) {
                        b.this.icd.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.ice != null) {
                        b.this.ice.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.icg = view.findViewById(R.id.top_container);
            this.ici = (BarImageView) view.findViewById(R.id.forum_image);
            this.ici.setPlaceHolderAutoChangeSkinType(2);
            this.ici.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.eRg = (TextView) view.findViewById(R.id.forum_name);
            this.icj = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.ich = (TextView) view.findViewById(R.id.forum_follow);
            this.ick = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.ick.setCornerRadius(l.getDimens(b.this.mPageContext.getPageActivity(), R.dimen.tbds10));
            this.ick.setRoundMode(3);
            this.ick.setVisibility(8);
            this.icj.setThreeDotMode(2);
            this.icj.setEnterForumStyle(true);
            this.flm = (ImageView) view.findViewById(R.id.delete_image);
            this.flm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.icf != null) {
                        b.this.icf.onClick(view2);
                    }
                }
            });
            this.icl = (TextView) view.findViewById(R.id.live_label_view);
            this.bol = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
