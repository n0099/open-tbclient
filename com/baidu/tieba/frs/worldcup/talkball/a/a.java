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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.c;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<C0162a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p */
    public C0162a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0162a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.competition_layout, viewGroup, false));
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
    public void onBindViewHolder(C0162a c0162a, int i) {
        c lV = lV(i);
        if (lV != null) {
            b(c0162a);
            c0162a.dIO.startLoad(lV.aAU().get(0).getIcon(), 10, false);
            c0162a.dIP.setText(lV.aAU().get(0).getName());
            c0162a.dIQ.startLoad(lV.aAU().get(1).getIcon(), 10, false);
            c0162a.dIR.setText(lV.aAU().get(1).getName());
            c0162a.dIT.setText(lV.getType());
            c0162a.dIU.setText(bG(lV.getTime()));
            c0162a.dIV.setText(lV.aAV());
            a(c0162a);
        }
    }

    private void a(C0162a c0162a) {
        if (c0162a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0162a.dIO.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.black_alpha15));
                c0162a.dIQ.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.black_alpha15));
            } else {
                c0162a.dIO.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.transparent));
                c0162a.dIQ.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.transparent));
            }
            am.j(c0162a.itemView, d.C0142d.cp_bg_line_d);
            am.c(c0162a.dIS, d.f.icon_front_worldcup_vs_n);
            am.h(c0162a.dIP, d.C0142d.cp_cont_f);
            am.h(c0162a.dIR, d.C0142d.cp_cont_f);
            am.h(c0162a.dIU, d.C0142d.cp_cont_d);
            am.h(c0162a.dIT, d.C0142d.cp_cont_f);
            am.h(c0162a.dIV, d.f.btn_concern_like_focus_color);
            am.i(c0162a.dIV, d.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0162a c0162a) {
        if (c0162a.itemView.getLayoutParams() != null && (c0162a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0162a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0162a.dIW) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds44);
                    c0162a.itemView.setLayoutParams(layoutParams);
                    c0162a.dIW = true;
                }
            } else if (c0162a.dIW) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds20);
                c0162a.itemView.setLayoutParams(layoutParams);
                c0162a.dIW = false;
            }
        }
    }

    private String bG(long j) {
        String g;
        Date date = new Date(j);
        if (ap.S(j)) {
            g = k.c(date);
        } else {
            g = ap.g(date);
        }
        return this.mPageContext.getResources().getString(d.k.competition_deadline) + g;
    }

    private c lV(int i) {
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
    /* loaded from: classes2.dex */
    public class C0162a extends RecyclerView.ViewHolder {
        public TbImageView dIO;
        public TextView dIP;
        public TbImageView dIQ;
        public TextView dIR;
        public ImageView dIS;
        public TextView dIT;
        public TextView dIU;
        public TextView dIV;
        public boolean dIW;

        public C0162a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.dIW = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.dIO = (TbImageView) this.itemView.findViewById(d.g.country_icon_left);
                am.i(this.dIO, d.f.picture_stroke);
                this.dIP = (TextView) this.itemView.findViewById(d.g.country_name_left);
                this.dIQ = (TbImageView) this.itemView.findViewById(d.g.country_icon_right);
                am.i(this.dIQ, d.f.picture_stroke);
                this.dIR = (TextView) this.itemView.findViewById(d.g.country_name_right);
                this.dIS = (ImageView) this.itemView.findViewById(d.g.vs_icon);
                this.dIT = (TextView) this.itemView.findViewById(d.g.vs_type);
                this.dIU = (TextView) this.itemView.findViewById(d.g.vs_time);
                this.dIV = (TextView) this.itemView.findViewById(d.g.competitiom_btn);
                this.dIV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
