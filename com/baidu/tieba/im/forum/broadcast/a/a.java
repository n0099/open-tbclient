package com.baidu.tieba.im.forum.broadcast.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class a extends RecyclerView.Adapter<C0728a> {
    private List<b> jpO = new ArrayList();
    private f<b> jpP;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public C0728a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0728a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0728a c0728a, final int i) {
        final b bVar = this.jpO.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0728a.jKi.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0728a.jKi.setLayoutParams(layoutParams);
            }
            if (bd.de(bVar.cLP() * 1000)) {
                c0728a.jKi.setText(at.cP(bVar.cLP() * 1000));
            } else {
                c0728a.jKi.setText(at.cQ(bVar.cLP() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0728a.jKB.setVisibility(8);
                c0728a.jKq.setVisibility(0);
                c0728a.jKq.setText(bVar.getTitle());
            } else {
                c0728a.jKB.setVisibility(0);
                c0728a.jKq.setVisibility(8);
                c0728a.jKk.setText(bVar.getTitle());
                c0728a.jKw.setConrers(15);
                c0728a.jKw.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0728a.jKw.setDrawCorner(true);
                c0728a.jKw.setPlaceHolder(2);
                c0728a.jKw.startLoad(bVar.getPicUrl(), 10, false);
                c0728a.jKw.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0728a.jKl.setVisibility(8);
            } else {
                c0728a.jKl.setVisibility(0);
                c0728a.jKl.setText(bVar.getContent());
            }
            c0728a.jKj.setText(bVar.cLV().forum_name);
            c0728a.jKv.setShowOval(true);
            c0728a.jKv.setAutoChangeStyle(true);
            c0728a.jKv.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0728a.jKv.setStrokeColorResId(R.color.cp_border_a);
            c0728a.jKv.setShowOuterBorder(false);
            c0728a.jKv.setShowInnerBorder(true);
            c0728a.jKv.setPlaceHolder(1);
            c0728a.jKv.startLoad(bVar.cLV().avatar, 10, false);
            c0728a.jKm.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.db(bVar.cLQ())));
            c0728a.jKn.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.db(bVar.cLR())));
            int parseFloat = (int) (Float.parseFloat(bVar.cLS()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cLS())) {
                c0728a.jKo.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0728a.jKo.setText("0%");
            }
            if (bVar.cLW() != null) {
                if (bVar.cLW().is_deleted.intValue() != 1) {
                    if (bVar.cLU() != 1) {
                        if (bVar.cLU() != 6) {
                            if (bVar.cLU() == 10) {
                                c0728a.jKu.setVisibility(0);
                                c0728a.jKx.setVisibility(0);
                                c0728a.jKt.setVisibility(8);
                            }
                        } else {
                            c0728a.jKu.setVisibility(8);
                            c0728a.jKx.setVisibility(8);
                            c0728a.jKt.setVisibility(0);
                            c0728a.jKA.setVisibility(0);
                            c0728a.jKp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0728a.jKA.setText(this.mContext.getString(R.string.edit));
                            c0728a.jKA.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pN(R.color.cp_link_tip_a);
                            c0728a.jKA.setConfig(bVar2);
                            c0728a.jKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jpP != null) {
                                        a.this.jpP.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0728a.jKu.setVisibility(8);
                        c0728a.jKx.setVisibility(8);
                        c0728a.jKt.setVisibility(0);
                        c0728a.jKA.setVisibility(8);
                        c0728a.jKp.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0728a.jKt.setVisibility(0);
                    c0728a.jKA.setVisibility(8);
                    c0728a.jKp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cLU() == 1 || bVar.cLU() == 6) {
                        c0728a.jKu.setVisibility(8);
                        c0728a.jKx.setVisibility(8);
                    } else {
                        c0728a.jKu.setVisibility(0);
                        c0728a.jKx.setVisibility(0);
                    }
                }
            } else {
                c0728a.jKt.setVisibility(0);
                c0728a.jKA.setVisibility(8);
                c0728a.jKp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cLU() == 1 || bVar.cLU() == 6) {
                    c0728a.jKu.setVisibility(8);
                    c0728a.jKx.setVisibility(8);
                } else {
                    c0728a.jKu.setVisibility(0);
                    c0728a.jKx.setVisibility(0);
                }
            }
            c0728a.jKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jpP != null) {
                        a.this.jpP.a(view, bVar, i, i);
                    }
                }
            });
            a(c0728a, bVar, i);
        }
    }

    private void a(C0728a c0728a, b bVar, int i) {
        ap.setViewTextColor(c0728a.jKi, R.color.cp_cont_d);
        ap.setViewTextColor(c0728a.jKj, R.color.cp_cont_b);
        ap.setViewTextColor(c0728a.jKk, R.color.cp_cont_a);
        ap.setViewTextColor(c0728a.jKl, R.color.cp_cont_j);
        ap.setViewTextColor(c0728a.jKm, R.color.cp_cont_j);
        ap.setViewTextColor(c0728a.jKn, R.color.cp_cont_j);
        ap.setViewTextColor(c0728a.jKo, R.color.cp_cont_j);
        ap.setBackgroundColor(c0728a.jKx, R.color.cp_bg_line_b);
        ap.setViewTextColor(c0728a.jKq, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).ab(l.getDimens(this.mContext, R.dimen.tbds21)).aa(l.getDimens(this.mContext, R.dimen.tbds21)).bf(c0728a.jKy);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0728a.jKi.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0728a.jKi.setLayoutParams(layoutParams);
            }
            c0728a.jKs.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0728a.jKz.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_bg_line_e).oZ(l.getDimens(this.mContext, R.dimen.tbds31)).pa(R.color.cp_shadow_a_alpha16).oY(4369).pb(l.getDimens(this.mContext, R.dimen.tbds10)).pc(0).pd(l.getDimens(this.mContext, R.dimen.tbds5)).bf(c0728a.jKz);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0728a.jKs.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0728a.jKs.setLayoutParams(layoutParams2);
            c0728a.jKs.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0728a.jKz.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oT(l.getDimens(this.mContext, R.dimen.tbds31)).oP(R.color.cp_bg_line_e).bf(c0728a.jKs);
        }
        if (bVar.cLW() != null) {
            if (bVar.cLW().is_deleted.intValue() != 1) {
                if (bVar.cLU() != 1) {
                    if (bVar.cLU() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0728a.jKp, R.color.cp_cont_h);
                    return;
                }
                ap.setViewTextColor(c0728a.jKp, R.color.cp_cont_j);
                return;
            }
            ap.setViewTextColor(c0728a.jKp, R.color.cp_cont_d);
            return;
        }
        ap.setViewTextColor(c0728a.jKp, R.color.cp_cont_d);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0728a extends RecyclerView.ViewHolder {
        private TBSpecificationBtn jKA;
        private RelativeLayout jKB;
        private TextView jKi;
        private TextView jKj;
        private TextView jKk;
        private TextView jKl;
        private TextView jKm;
        private TextView jKn;
        private TextView jKo;
        private TextView jKp;
        private TextView jKq;
        private LinearLayout jKr;
        private LinearLayout jKs;
        private LinearLayout jKt;
        private LinearLayout jKu;
        private BarImageView jKv;
        private TbImageView jKw;
        private View jKx;
        private View jKy;
        private View jKz;

        public C0728a(View view) {
            super(view);
            this.jKi = (TextView) view.findViewById(R.id.bcast_time);
            this.jKj = (TextView) view.findViewById(R.id.forum_name);
            this.jKk = (TextView) view.findViewById(R.id.bcast_title);
            this.jKl = (TextView) view.findViewById(R.id.bcast_content);
            this.jKm = (TextView) view.findViewById(R.id.publish_number);
            this.jKn = (TextView) view.findViewById(R.id.pv_number);
            this.jKo = (TextView) view.findViewById(R.id.ctr_number);
            this.jKr = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.jKs = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.jKv = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.jKw = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jKx = view.findViewById(R.id.forum_bg_line);
            this.jKt = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.jKp = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.jKA = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.jKu = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.jKB = (RelativeLayout) view.findViewById(R.id.container_image);
            this.jKq = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.jKz = view.findViewById(R.id.bg_item_mian_view);
            this.jKy = view.findViewById(R.id.gradient_cover);
        }
    }

    public void dR(List<b> list) {
        if (list != null) {
            this.jpO = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jpO != null) {
            return this.jpO.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jpP = fVar;
    }
}
