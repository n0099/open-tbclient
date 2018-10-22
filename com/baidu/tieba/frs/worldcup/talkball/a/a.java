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
public class a extends RecyclerView.Adapter<C0196a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public C0196a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0196a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.competition_layout, viewGroup, false));
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
    public void onBindViewHolder(C0196a c0196a, int i) {
        c nj = nj(i);
        if (nj != null) {
            b(c0196a);
            c0196a.eaL.startLoad(nj.aHf().get(0).getIcon(), 10, false);
            c0196a.eaM.setText(nj.aHf().get(0).getName());
            c0196a.eaN.startLoad(nj.aHf().get(1).getIcon(), 10, false);
            c0196a.eaO.setText(nj.aHf().get(1).getName());
            c0196a.eaQ.setText(nj.getType());
            c0196a.eaR.setText(bW(nj.getTime()));
            c0196a.eaS.setText(nj.aHg());
            a(c0196a);
        }
    }

    private void a(C0196a c0196a) {
        if (c0196a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0196a.eaL.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
                c0196a.eaN.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
            } else {
                c0196a.eaL.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
                c0196a.eaN.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
            }
            al.j(c0196a.itemView, e.d.cp_bg_line_d);
            al.c(c0196a.eaP, e.f.icon_front_worldcup_vs_n);
            al.h(c0196a.eaM, e.d.cp_cont_f);
            al.h(c0196a.eaO, e.d.cp_cont_f);
            al.h(c0196a.eaR, e.d.cp_cont_d);
            al.h(c0196a.eaQ, e.d.cp_cont_f);
            al.h(c0196a.eaS, e.f.btn_concern_like_focus_color);
            al.i(c0196a.eaS, e.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0196a c0196a) {
        if (c0196a.itemView.getLayoutParams() != null && (c0196a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0196a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0196a.eaT) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0175e.tbds44);
                    c0196a.itemView.setLayoutParams(layoutParams);
                    c0196a.eaT = true;
                }
            } else if (c0196a.eaT) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(e.C0175e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0175e.tbds20);
                c0196a.itemView.setLayoutParams(layoutParams);
                c0196a.eaT = false;
            }
        }
    }

    private String bW(long j) {
        String f;
        Date date = new Date(j);
        if (ao.aa(j)) {
            f = k.b(date);
        } else {
            f = ao.f(date);
        }
        return this.mPageContext.getResources().getString(e.j.competition_deadline) + f;
    }

    private c nj(int i) {
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
    public class C0196a extends RecyclerView.ViewHolder {
        public TbImageView eaL;
        public TextView eaM;
        public TbImageView eaN;
        public TextView eaO;
        public ImageView eaP;
        public TextView eaQ;
        public TextView eaR;
        public TextView eaS;
        public boolean eaT;

        public C0196a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.eaT = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.eaL = (TbImageView) this.itemView.findViewById(e.g.country_icon_left);
                al.i(this.eaL, e.f.picture_stroke);
                this.eaM = (TextView) this.itemView.findViewById(e.g.country_name_left);
                this.eaN = (TbImageView) this.itemView.findViewById(e.g.country_icon_right);
                al.i(this.eaN, e.f.picture_stroke);
                this.eaO = (TextView) this.itemView.findViewById(e.g.country_name_right);
                this.eaP = (ImageView) this.itemView.findViewById(e.g.vs_icon);
                this.eaQ = (TextView) this.itemView.findViewById(e.g.vs_type);
                this.eaR = (TextView) this.itemView.findViewById(e.g.vs_time);
                this.eaS = (TextView) this.itemView.findViewById(e.g.competitiom_btn);
                this.eaS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
