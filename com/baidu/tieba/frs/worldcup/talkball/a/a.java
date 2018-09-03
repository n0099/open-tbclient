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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.worldcup.talkball.b.c;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<C0160a> {
    private View.OnClickListener mClickListener;
    private List<c> mData;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public C0160a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0160a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.competition_layout, viewGroup, false));
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
        c mh = mh(i);
        if (mh != null) {
            b(c0160a);
            c0160a.dLz.startLoad(mh.aBA().get(0).getIcon(), 10, false);
            c0160a.dLA.setText(mh.aBA().get(0).getName());
            c0160a.dLB.startLoad(mh.aBA().get(1).getIcon(), 10, false);
            c0160a.dLC.setText(mh.aBA().get(1).getName());
            c0160a.dLE.setText(mh.getType());
            c0160a.dLF.setText(bL(mh.getTime()));
            c0160a.dLG.setText(mh.aBB());
            a(c0160a);
        }
    }

    private void a(C0160a c0160a) {
        if (c0160a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0160a.dLz.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.black_alpha15));
                c0160a.dLB.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.black_alpha15));
            } else {
                c0160a.dLz.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.transparent));
                c0160a.dLB.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.transparent));
            }
            am.j(c0160a.itemView, f.d.cp_bg_line_d);
            am.c(c0160a.dLD, f.C0146f.icon_front_worldcup_vs_n);
            am.h(c0160a.dLA, f.d.cp_cont_f);
            am.h(c0160a.dLC, f.d.cp_cont_f);
            am.h(c0160a.dLF, f.d.cp_cont_d);
            am.h(c0160a.dLE, f.d.cp_cont_f);
            am.h(c0160a.dLG, f.C0146f.btn_concern_like_focus_color);
            am.i(c0160a.dLG, f.C0146f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0160a c0160a) {
        if (c0160a.itemView.getLayoutParams() != null && (c0160a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0160a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0160a.dLH) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(f.e.tbds44);
                    c0160a.itemView.setLayoutParams(layoutParams);
                    c0160a.dLH = true;
                }
            } else if (c0160a.dLH) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(f.e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(f.e.tbds20);
                c0160a.itemView.setLayoutParams(layoutParams);
                c0160a.dLH = false;
            }
        }
    }

    private String bL(long j) {
        String f;
        Date date = new Date(j);
        if (ap.U(j)) {
            f = k.b(date);
        } else {
            f = ap.f(date);
        }
        return this.mPageContext.getResources().getString(f.j.competition_deadline) + f;
    }

    private c mh(int i) {
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
    public class C0160a extends RecyclerView.ViewHolder {
        public TextView dLA;
        public TbImageView dLB;
        public TextView dLC;
        public ImageView dLD;
        public TextView dLE;
        public TextView dLF;
        public TextView dLG;
        public boolean dLH;
        public TbImageView dLz;

        public C0160a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.dLH = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.dLz = (TbImageView) this.itemView.findViewById(f.g.country_icon_left);
                am.i(this.dLz, f.C0146f.picture_stroke);
                this.dLA = (TextView) this.itemView.findViewById(f.g.country_name_left);
                this.dLB = (TbImageView) this.itemView.findViewById(f.g.country_icon_right);
                am.i(this.dLB, f.C0146f.picture_stroke);
                this.dLC = (TextView) this.itemView.findViewById(f.g.country_name_right);
                this.dLD = (ImageView) this.itemView.findViewById(f.g.vs_icon);
                this.dLE = (TextView) this.itemView.findViewById(f.g.vs_type);
                this.dLF = (TextView) this.itemView.findViewById(f.g.vs_time);
                this.dLG = (TextView) this.itemView.findViewById(f.g.competitiom_btn);
                this.dLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
