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
public class a extends RecyclerView.Adapter<C0233a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public C0233a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0233a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.competition_layout, viewGroup, false));
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
    public void onBindViewHolder(C0233a c0233a, int i) {
        c nR = nR(i);
        if (nR != null) {
            b(c0233a);
            c0233a.eiI.startLoad(nR.aIp().get(0).getIcon(), 10, false);
            c0233a.eiJ.setText(nR.aIp().get(0).getName());
            c0233a.eiK.startLoad(nR.aIp().get(1).getIcon(), 10, false);
            c0233a.eiL.setText(nR.aIp().get(1).getName());
            c0233a.eiN.setText(nR.getType());
            c0233a.eiO.setText(bY(nR.getTime()));
            c0233a.eiP.setText(nR.aIq());
            a(c0233a);
        }
    }

    private void a(C0233a c0233a) {
        if (c0233a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0233a.eiI.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
                c0233a.eiK.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
            } else {
                c0233a.eiI.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
                c0233a.eiK.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
            }
            al.j(c0233a.itemView, e.d.cp_bg_line_d);
            al.c(c0233a.eiM, e.f.icon_front_worldcup_vs_n);
            al.h(c0233a.eiJ, e.d.cp_cont_f);
            al.h(c0233a.eiL, e.d.cp_cont_f);
            al.h(c0233a.eiO, e.d.cp_cont_d);
            al.h(c0233a.eiN, e.d.cp_cont_f);
            al.h(c0233a.eiP, e.f.btn_concern_like_focus_color);
            al.i(c0233a.eiP, e.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0233a c0233a) {
        if (c0233a.itemView.getLayoutParams() != null && (c0233a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0233a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0233a.eiQ) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0210e.tbds44);
                    c0233a.itemView.setLayoutParams(layoutParams);
                    c0233a.eiQ = true;
                }
            } else if (c0233a.eiQ) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(e.C0210e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0210e.tbds20);
                c0233a.itemView.setLayoutParams(layoutParams);
                c0233a.eiQ = false;
            }
        }
    }

    private String bY(long j) {
        String f;
        Date date = new Date(j);
        if (ao.aj(j)) {
            f = k.b(date);
        } else {
            f = ao.f(date);
        }
        return this.mPageContext.getResources().getString(e.j.competition_deadline) + f;
    }

    private c nR(int i) {
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
    public class C0233a extends RecyclerView.ViewHolder {
        public TbImageView eiI;
        public TextView eiJ;
        public TbImageView eiK;
        public TextView eiL;
        public ImageView eiM;
        public TextView eiN;
        public TextView eiO;
        public TextView eiP;
        public boolean eiQ;

        public C0233a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.eiQ = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.eiI = (TbImageView) this.itemView.findViewById(e.g.country_icon_left);
                al.i(this.eiI, e.f.picture_stroke);
                this.eiJ = (TextView) this.itemView.findViewById(e.g.country_name_left);
                this.eiK = (TbImageView) this.itemView.findViewById(e.g.country_icon_right);
                al.i(this.eiK, e.f.picture_stroke);
                this.eiL = (TextView) this.itemView.findViewById(e.g.country_name_right);
                this.eiM = (ImageView) this.itemView.findViewById(e.g.vs_icon);
                this.eiN = (TextView) this.itemView.findViewById(e.g.vs_type);
                this.eiO = (TextView) this.itemView.findViewById(e.g.vs_time);
                this.eiP = (TextView) this.itemView.findViewById(e.g.competitiom_btn);
                this.eiP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
