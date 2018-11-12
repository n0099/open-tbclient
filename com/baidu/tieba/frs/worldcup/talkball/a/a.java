package com.baidu.tieba.frs.worldcup.talkball.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.worldcup.talkball.b.c;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<C0222a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public C0222a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0222a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.competition_layout, viewGroup, false));
    }

    public void setData(List<c> list) {
        this.mData = list;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0222a c0222a, int i) {
        c nB = nB(i);
        if (nB != null) {
            b(c0222a);
            c0222a.ecf.startLoad(nB.aGD().get(0).getIcon(), 10, false);
            c0222a.ecg.setText(nB.aGD().get(0).getName());
            c0222a.ech.startLoad(nB.aGD().get(1).getIcon(), 10, false);
            c0222a.eci.setText(nB.aGD().get(1).getName());
            c0222a.eck.setText(nB.getType());
            c0222a.ecl.setText(bR(nB.getTime()));
            c0222a.ecm.setText(nB.aGE());
            a(c0222a);
        }
    }

    private void a(C0222a c0222a) {
        if (c0222a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0222a.ecf.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
                c0222a.ech.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
            } else {
                c0222a.ecf.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
                c0222a.ech.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
            }
            al.j(c0222a.itemView, e.d.cp_bg_line_d);
            al.c(c0222a.ecj, e.f.icon_front_worldcup_vs_n);
            al.h(c0222a.ecg, e.d.cp_cont_f);
            al.h(c0222a.eci, e.d.cp_cont_f);
            al.h(c0222a.ecl, e.d.cp_cont_d);
            al.h(c0222a.eck, e.d.cp_cont_f);
            al.h(c0222a.ecm, e.f.btn_concern_like_focus_color);
            al.i(c0222a.ecm, e.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0222a c0222a) {
        if (c0222a.itemView.getLayoutParams() != null && (c0222a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0222a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0222a.ecn) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0200e.tbds44);
                    c0222a.itemView.setLayoutParams(layoutParams);
                    c0222a.ecn = true;
                }
            } else if (c0222a.ecn) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(e.C0200e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0200e.tbds20);
                c0222a.itemView.setLayoutParams(layoutParams);
                c0222a.ecn = false;
            }
        }
    }

    private String bR(long j) {
        String f;
        Date date = new Date(j);
        if (ao.ac(j)) {
            f = k.b(date);
        } else {
            f = ao.f(date);
        }
        return this.mPageContext.getResources().getString(e.j.competition_deadline) + f;
    }

    private c nB(int i) {
        if (this.mData == null || i < 0 || i >= getItemCount()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* renamed from: com.baidu.tieba.frs.worldcup.talkball.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0222a extends RecyclerView.ViewHolder {
        public TbImageView ecf;
        public TextView ecg;
        public TbImageView ech;
        public TextView eci;
        public ImageView ecj;
        public TextView eck;
        public TextView ecl;
        public TextView ecm;
        public boolean ecn;

        public C0222a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.ecn = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.ecf = (TbImageView) this.itemView.findViewById(e.g.country_icon_left);
                al.i(this.ecf, e.f.picture_stroke);
                this.ecg = (TextView) this.itemView.findViewById(e.g.country_name_left);
                this.ech = (TbImageView) this.itemView.findViewById(e.g.country_icon_right);
                al.i(this.ech, e.f.picture_stroke);
                this.eci = (TextView) this.itemView.findViewById(e.g.country_name_right);
                this.ecj = (ImageView) this.itemView.findViewById(e.g.vs_icon);
                this.eck = (TextView) this.itemView.findViewById(e.g.vs_type);
                this.ecl = (TextView) this.itemView.findViewById(e.g.vs_time);
                this.ecm = (TextView) this.itemView.findViewById(e.g.competitiom_btn);
                this.ecm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
            }
        }
    }
}
