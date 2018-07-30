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
        return new C0160a(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.competition_layout, viewGroup, false));
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
            c0160a.dLD.startLoad(mh.aBD().get(0).getIcon(), 10, false);
            c0160a.dLE.setText(mh.aBD().get(0).getName());
            c0160a.dLF.startLoad(mh.aBD().get(1).getIcon(), 10, false);
            c0160a.dLG.setText(mh.aBD().get(1).getName());
            c0160a.dLI.setText(mh.getType());
            c0160a.dLJ.setText(bL(mh.getTime()));
            c0160a.dLK.setText(mh.aBE());
            a(c0160a);
        }
    }

    private void a(C0160a c0160a) {
        if (c0160a != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                c0160a.dLD.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.black_alpha15));
                c0160a.dLF.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.black_alpha15));
            } else {
                c0160a.dLD.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.transparent));
                c0160a.dLF.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0140d.transparent));
            }
            am.j(c0160a.itemView, d.C0140d.cp_bg_line_d);
            am.c(c0160a.dLH, d.f.icon_front_worldcup_vs_n);
            am.h(c0160a.dLE, d.C0140d.cp_cont_f);
            am.h(c0160a.dLG, d.C0140d.cp_cont_f);
            am.h(c0160a.dLJ, d.C0140d.cp_cont_d);
            am.h(c0160a.dLI, d.C0140d.cp_cont_f);
            am.h(c0160a.dLK, d.f.btn_concern_like_focus_color);
            am.i(c0160a.dLK, d.f.btn_transparent_focus_border_bg);
        }
    }

    private void b(C0160a c0160a) {
        if (c0160a.itemView.getLayoutParams() != null && (c0160a.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c0160a.itemView.getLayoutParams();
            if (getItemCount() == 1) {
                if (!c0160a.dLL) {
                    layoutParams.width = -1;
                    layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds44);
                    c0160a.itemView.setLayoutParams(layoutParams);
                    c0160a.dLL = true;
                }
            } else if (c0160a.dLL) {
                layoutParams.width = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds762);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(d.e.tbds20);
                c0160a.itemView.setLayoutParams(layoutParams);
                c0160a.dLL = false;
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
        return this.mPageContext.getResources().getString(d.j.competition_deadline) + f;
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
        public TbImageView dLD;
        public TextView dLE;
        public TbImageView dLF;
        public TextView dLG;
        public ImageView dLH;
        public TextView dLI;
        public TextView dLJ;
        public TextView dLK;
        public boolean dLL;

        public C0160a(View view) {
            super(view);
            init();
        }

        private void init() {
            if (this.itemView != null) {
                this.dLL = false;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mClickListener != null) {
                            a.this.mClickListener.onClick(view);
                        }
                    }
                });
                this.dLD = (TbImageView) this.itemView.findViewById(d.g.country_icon_left);
                am.i(this.dLD, d.f.picture_stroke);
                this.dLE = (TextView) this.itemView.findViewById(d.g.country_name_left);
                this.dLF = (TbImageView) this.itemView.findViewById(d.g.country_icon_right);
                am.i(this.dLF, d.f.picture_stroke);
                this.dLG = (TextView) this.itemView.findViewById(d.g.country_name_right);
                this.dLH = (ImageView) this.itemView.findViewById(d.g.vs_icon);
                this.dLI = (TextView) this.itemView.findViewById(d.g.vs_type);
                this.dLJ = (TextView) this.itemView.findViewById(d.g.vs_time);
                this.dLK = (TextView) this.itemView.findViewById(d.g.competitiom_btn);
                this.dLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.a.a.a.2
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
