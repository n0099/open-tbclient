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
public class a extends RecyclerView.Adapter<C0162a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public C0162a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0162a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.competition_layout, viewGroup, false));
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
        c mL = mL(i);
        if (mL != null) {
            b(c0162a);
            c0162a.dSR.startLoad(mL.aDN().get(0).getIcon(), 10, false);
            c0162a.dSS.setText(mL.aDN().get(0).getName());
            c0162a.dST.startLoad(mL.aDN().get(1).getIcon(), 10, false);
            c0162a.dSU.setText(mL.aDN().get(1).getName());
            c0162a.dSW.setText(mL.getType());
            c0162a.dSX.setText(bP(mL.getTime()));
            c0162a.dSY.setText(mL.aDO());
            a(c0162a);
        }
    }

    private void a(C0162a c0162a) {
        if (c0162a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0162a.dSR.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
                c0162a.dST.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha15));
            } else {
                c0162a.dSR.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
                c0162a.dST.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.transparent));
            }
            al.j(c0162a.itemView, e.d.cp_bg_line_d);
            al.c(c0162a.dSV, e.f.icon_front_worldcup_vs_n);
            al.h(c0162a.dSS, e.d.cp_cont_f);
            al.h(c0162a.dSU, e.d.cp_cont_f);
            al.h(c0162a.dSX, e.d.cp_cont_d);
            al.h(c0162a.dSW, e.d.cp_cont_f);
            al.h(c0162a.dSY, e.f.btn_concern_like_focus_color);
            al.i(c0162a.dSY, e.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0162a c0162a) {
        if (c0162a.itemView.getLayoutParams() != null && (c0162a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0162a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0162a.dSZ) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0141e.tbds44);
                    c0162a.itemView.setLayoutParams(layoutParams);
                    c0162a.dSZ = true;
                }
            } else if (c0162a.dSZ) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(e.C0141e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(e.C0141e.tbds20);
                c0162a.itemView.setLayoutParams(layoutParams);
                c0162a.dSZ = false;
            }
        }
    }

    private String bP(long j) {
        String f;
        Date date = new Date(j);
        if (ao.Y(j)) {
            f = k.b(date);
        } else {
            f = ao.f(date);
        }
        return this.mPageContext.getResources().getString(e.j.competition_deadline) + f;
    }

    private c mL(int i) {
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
    public class C0162a extends RecyclerView.ViewHolder {
        public TbImageView dSR;
        public TextView dSS;
        public TbImageView dST;
        public TextView dSU;
        public ImageView dSV;
        public TextView dSW;
        public TextView dSX;
        public TextView dSY;
        public boolean dSZ;

        public C0162a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.dSZ = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.dSR = (TbImageView) this.itemView.findViewById(e.g.country_icon_left);
                al.i(this.dSR, e.f.picture_stroke);
                this.dSS = (TextView) this.itemView.findViewById(e.g.country_name_left);
                this.dST = (TbImageView) this.itemView.findViewById(e.g.country_icon_right);
                al.i(this.dST, e.f.picture_stroke);
                this.dSU = (TextView) this.itemView.findViewById(e.g.country_name_right);
                this.dSV = (ImageView) this.itemView.findViewById(e.g.vs_icon);
                this.dSW = (TextView) this.itemView.findViewById(e.g.vs_type);
                this.dSX = (TextView) this.itemView.findViewById(e.g.vs_time);
                this.dSY = (TextView) this.itemView.findViewById(e.g.competitiom_btn);
                this.dSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
