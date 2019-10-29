package com.baidu.tieba.enterForum.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.LinkedList;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<a> {
    private LinkedList<VisitedForumData> fae;
    private boolean faf;
    private InterfaceC0399b fag;
    private View.OnLongClickListener fah;
    private View.OnClickListener fai;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0399b {
        void a(a aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void h(LinkedList<VisitedForumData> linkedList) {
        this.fae = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.fae == null) {
            return 0;
        }
        return this.fae.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null && this.fae != null && this.fae.get(i) != null) {
            VisitedForumData visitedForumData = this.fae.get(i);
            aVar.itemView.setTag(visitedForumData);
            a(visitedForumData, aVar);
            b(visitedForumData, aVar);
            d(visitedForumData, aVar);
            aVar.fal.startLoad(visitedForumData.atH(), 10, false);
            aVar.fal.setStrokeColorResId(R.color.cp_bg_line_d);
            aVar.fal.setStrokeWith(3);
            aVar.fal.setShowOval(true);
            c(visitedForumData, aVar);
            am.setImageResource(aVar.cIr, R.drawable.icon_ba_delete_n);
            am.setViewTextColor(aVar.crl, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fak, (int) R.color.cp_cont_d);
            am.setBackgroundResource(aVar.faj, R.drawable.recent_visit_bg_top);
            am.setBackgroundResource(aVar.eEw, R.drawable.recent_visit_bg);
        }
    }

    private void a(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            String forumName = visitedForumData.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            aVar.crl.setText(forumName);
        }
    }

    private void b(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fak.setText("关注 " + aq.numFormatOverWanNa(visitedForumData.atL()));
        }
    }

    private void c(VisitedForumData visitedForumData, a aVar) {
        ThemeElement themeElement;
        if (visitedForumData != null && aVar != null) {
            ThemeColorInfo themeColorInfo = visitedForumData.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                aVar.fap.setVisibility(8);
                aVar.fan.setVisibility(0);
                aVar.fan.setDefaultGradientColor();
                return;
            }
            aVar.fap.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            if (aVar.fan != null) {
                aVar.fan.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                aVar.fan.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (aVar.fap != null) {
                aVar.fap.startLoad(themeElement.pattern_image, 10, false);
                aVar.fap.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds25));
                aVar.fap.setConrers(3);
            }
        }
    }

    private void d(VisitedForumData visitedForumData, a aVar) {
        if (visitedForumData != null && aVar != null) {
            aVar.fam.setVisibility(8);
            aVar.cIr.setVisibility(8);
            aVar.fao.setVisibility(8);
            if (this.faf) {
                aVar.cIr.setVisibility(0);
                aVar.cIr.setTag(visitedForumData);
            } else if (!visitedForumData.atI()) {
                if (visitedForumData.atJ() <= 0) {
                    aVar.fam.setVisibility(8);
                    return;
                }
                aVar.fam.setVisibility(0);
                aVar.fam.refresh(visitedForumData.atJ());
            } else {
                aVar.fao.setVisibility(0);
            }
        }
    }

    public void gc(boolean z) {
        this.faf = z;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0399b interfaceC0399b) {
        this.fag = interfaceC0399b;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.fah = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.fai = onClickListener;
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView cIr;
        public TextView crl;
        public LinearLayout eEw;
        public View faj;
        public TextView fak;
        public BarImageView fal;
        public MessageRedDotView fam;
        public LinearGradientView fan;
        public TextView fao;
        public TbImageView fap;

        public a(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fag != null) {
                        b.this.fag.a(a.this);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (b.this.fah != null) {
                        b.this.fah.onLongClick(view2);
                        return true;
                    }
                    return true;
                }
            });
            this.faj = view.findViewById(R.id.top_container);
            this.fal = (BarImageView) view.findViewById(R.id.forum_image);
            this.fal.setDefaultResource(R.drawable.icon_default_ba_120);
            this.fal.setDefaultErrorResource(R.drawable.icon_default_ba_120);
            this.crl = (TextView) view.findViewById(R.id.forum_name);
            this.fam = (MessageRedDotView) view.findViewById(R.id.red_dot_view);
            this.fak = (TextView) view.findViewById(R.id.forum_follow);
            this.fan = (LinearGradientView) view.findViewById(R.id.forum_bg);
            this.fap = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fan.setCornerRadius(22);
            this.fan.setRoundMode(3);
            this.fan.setVisibility(8);
            this.fam.setThreeDotMode(2);
            this.cIr = (ImageView) view.findViewById(R.id.delete_image);
            this.cIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fai != null) {
                        b.this.fai.onClick(view2);
                    }
                }
            });
            this.fao = (TextView) view.findViewById(R.id.live_label_view);
            this.eEw = (LinearLayout) view.findViewById(R.id.bottom_container);
        }
    }
}
