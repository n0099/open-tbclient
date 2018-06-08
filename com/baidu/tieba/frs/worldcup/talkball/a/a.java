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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.c;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<C0160a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public C0160a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0160a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.competition_layout, viewGroup, false));
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
    public void onBindViewHolder(C0160a c0160a, int i) {
        c lO = lO(i);
        if (lO != null) {
            b(c0160a);
            c0160a.dFv.startLoad(lO.aAn().get(0).getIcon(), 10, false);
            c0160a.dFw.setText(lO.aAn().get(0).getName());
            c0160a.dFx.startLoad(lO.aAn().get(1).getIcon(), 10, false);
            c0160a.dFy.setText(lO.aAn().get(1).getName());
            c0160a.dFA.setText(lO.getType());
            c0160a.dFB.setText(bK(lO.getTime()));
            c0160a.dFC.setText(lO.aAo());
            a(c0160a);
        }
    }

    private void a(C0160a c0160a) {
        if (c0160a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0160a.dFv.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.black_alpha15));
                c0160a.dFx.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.black_alpha15));
            } else {
                c0160a.dFv.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
                c0160a.dFx.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
            }
            al.j(c0160a.itemView, d.C0141d.cp_bg_line_d);
            al.c(c0160a.dFz, d.f.icon_front_worldcup_vs_n);
            al.h(c0160a.dFw, d.C0141d.cp_cont_f);
            al.h(c0160a.dFy, d.C0141d.cp_cont_f);
            al.h(c0160a.dFB, d.C0141d.cp_cont_d);
            al.h(c0160a.dFA, d.C0141d.cp_cont_f);
            al.h(c0160a.dFC, d.f.btn_concern_like_focus_color);
            al.i(c0160a.dFC, d.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0160a c0160a) {
        if (c0160a.itemView.getLayoutParams() != null && (c0160a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0160a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0160a.dFD) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds44);
                    c0160a.itemView.setLayoutParams(layoutParams);
                    c0160a.dFD = true;
                }
            } else if (c0160a.dFD) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds20);
                c0160a.itemView.setLayoutParams(layoutParams);
                c0160a.dFD = false;
            }
        }
    }

    private String bK(long j) {
        String g;
        Date date = new Date(j);
        if (ao.R(j)) {
            g = k.c(date);
        } else {
            g = ao.g(date);
        }
        return this.mPageContext.getResources().getString(d.k.competition_deadline) + g;
    }

    private c lO(int i) {
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
    public class C0160a extends RecyclerView.ViewHolder {
        public TextView dFA;
        public TextView dFB;
        public TextView dFC;
        public boolean dFD;
        public TbImageView dFv;
        public TextView dFw;
        public TbImageView dFx;
        public TextView dFy;
        public ImageView dFz;

        public C0160a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.dFD = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.dFv = (TbImageView) this.itemView.findViewById(d.g.country_icon_left);
                al.i(this.dFv, d.f.picture_stroke);
                this.dFw = (TextView) this.itemView.findViewById(d.g.country_name_left);
                this.dFx = (TbImageView) this.itemView.findViewById(d.g.country_icon_right);
                al.i(this.dFx, d.f.picture_stroke);
                this.dFy = (TextView) this.itemView.findViewById(d.g.country_name_right);
                this.dFz = (ImageView) this.itemView.findViewById(d.g.vs_icon);
                this.dFA = (TextView) this.itemView.findViewById(d.g.vs_type);
                this.dFB = (TextView) this.itemView.findViewById(d.g.vs_time);
                this.dFC = (TextView) this.itemView.findViewById(d.g.competitiom_btn);
                this.dFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
