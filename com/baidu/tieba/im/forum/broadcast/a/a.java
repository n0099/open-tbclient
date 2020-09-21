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
/* loaded from: classes25.dex */
public class a extends RecyclerView.Adapter<C0710a> {
    private List<b> jaP = new ArrayList();
    private f<b> jaQ;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: F */
    public C0710a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0710a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0710a c0710a, final int i) {
        final b bVar = this.jaP.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0710a.jvl.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0710a.jvl.setLayoutParams(layoutParams);
            }
            if (bd.cW(bVar.cIg() * 1000)) {
                c0710a.jvl.setText(at.cH(bVar.cIg() * 1000));
            } else {
                c0710a.jvl.setText(at.cI(bVar.cIg() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0710a.jvE.setVisibility(8);
                c0710a.jvt.setVisibility(0);
                c0710a.jvt.setText(bVar.getTitle());
            } else {
                c0710a.jvE.setVisibility(0);
                c0710a.jvt.setVisibility(8);
                c0710a.jvn.setText(bVar.getTitle());
                c0710a.jvz.setConrers(15);
                c0710a.jvz.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0710a.jvz.setDrawCorner(true);
                c0710a.jvz.setPlaceHolder(2);
                c0710a.jvz.startLoad(bVar.getPicUrl(), 10, false);
                c0710a.jvz.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0710a.jvo.setVisibility(8);
            } else {
                c0710a.jvo.setVisibility(0);
                c0710a.jvo.setText(bVar.getContent());
            }
            c0710a.jvm.setText(bVar.cIm().forum_name);
            c0710a.jvy.setShowOval(true);
            c0710a.jvy.setAutoChangeStyle(true);
            c0710a.jvy.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0710a.jvy.setStrokeColorResId(R.color.cp_border_a);
            c0710a.jvy.setShowOuterBorder(false);
            c0710a.jvy.setShowInnerBorder(true);
            c0710a.jvy.setPlaceHolder(1);
            c0710a.jvy.startLoad(bVar.cIm().avatar, 10, false);
            c0710a.jvp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.cT(bVar.cIh())));
            c0710a.jvq.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.cT(bVar.cIi())));
            int parseFloat = (int) (Float.parseFloat(bVar.cIj()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cIj())) {
                c0710a.jvr.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0710a.jvr.setText("0%");
            }
            if (bVar.cIn() != null) {
                if (bVar.cIn().is_deleted.intValue() != 1) {
                    if (bVar.cIl() != 1) {
                        if (bVar.cIl() != 6) {
                            if (bVar.cIl() == 10) {
                                c0710a.jvx.setVisibility(0);
                                c0710a.jvA.setVisibility(0);
                                c0710a.jvw.setVisibility(8);
                            }
                        } else {
                            c0710a.jvx.setVisibility(8);
                            c0710a.jvA.setVisibility(8);
                            c0710a.jvw.setVisibility(0);
                            c0710a.jvD.setVisibility(0);
                            c0710a.jvs.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0710a.jvD.setText(this.mContext.getString(R.string.edit));
                            c0710a.jvD.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pp(R.color.cp_link_tip_a);
                            c0710a.jvD.setConfig(bVar2);
                            c0710a.jvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jaQ != null) {
                                        a.this.jaQ.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0710a.jvx.setVisibility(8);
                        c0710a.jvA.setVisibility(8);
                        c0710a.jvw.setVisibility(0);
                        c0710a.jvD.setVisibility(8);
                        c0710a.jvs.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0710a.jvw.setVisibility(0);
                    c0710a.jvD.setVisibility(8);
                    c0710a.jvs.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cIl() == 1 || bVar.cIl() == 6) {
                        c0710a.jvx.setVisibility(8);
                        c0710a.jvA.setVisibility(8);
                    } else {
                        c0710a.jvx.setVisibility(0);
                        c0710a.jvA.setVisibility(0);
                    }
                }
            } else {
                c0710a.jvw.setVisibility(0);
                c0710a.jvD.setVisibility(8);
                c0710a.jvs.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cIl() == 1 || bVar.cIl() == 6) {
                    c0710a.jvx.setVisibility(8);
                    c0710a.jvA.setVisibility(8);
                } else {
                    c0710a.jvx.setVisibility(0);
                    c0710a.jvA.setVisibility(0);
                }
            }
            c0710a.jvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jaQ != null) {
                        a.this.jaQ.a(view, bVar, i, i);
                    }
                }
            });
            a(c0710a, bVar, i);
        }
    }

    private void a(C0710a c0710a, b bVar, int i) {
        ap.setViewTextColor(c0710a.jvl, R.color.cp_cont_d);
        ap.setViewTextColor(c0710a.jvm, R.color.cp_cont_b);
        ap.setViewTextColor(c0710a.jvn, R.color.cp_cont_a);
        ap.setViewTextColor(c0710a.jvo, R.color.cp_cont_j);
        ap.setViewTextColor(c0710a.jvp, R.color.cp_cont_j);
        ap.setViewTextColor(c0710a.jvq, R.color.cp_cont_j);
        ap.setViewTextColor(c0710a.jvr, R.color.cp_cont_j);
        ap.setBackgroundColor(c0710a.jvA, R.color.cp_bg_line_b);
        ap.setViewTextColor(c0710a.jvt, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).Z(l.getDimens(this.mContext, R.dimen.tbds21)).Y(l.getDimens(this.mContext, R.dimen.tbds21)).bb(c0710a.jvB);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0710a.jvl.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0710a.jvl.setLayoutParams(layoutParams);
            }
            c0710a.jvv.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0710a.jvC.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_bg_line_e).oB(l.getDimens(this.mContext, R.dimen.tbds31)).oC(R.color.cp_shadow_a_alpha16).oA(4369).oD(l.getDimens(this.mContext, R.dimen.tbds10)).oE(0).oF(l.getDimens(this.mContext, R.dimen.tbds5)).bb(c0710a.jvC);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0710a.jvv.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0710a.jvv.setLayoutParams(layoutParams2);
            c0710a.jvv.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0710a.jvC.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).ov(l.getDimens(this.mContext, R.dimen.tbds31)).or(R.color.cp_bg_line_e).bb(c0710a.jvv);
        }
        if (bVar.cIn() != null) {
            if (bVar.cIn().is_deleted.intValue() != 1) {
                if (bVar.cIl() != 1) {
                    if (bVar.cIl() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0710a.jvs, R.color.cp_cont_h);
                    return;
                }
                ap.setViewTextColor(c0710a.jvs, R.color.cp_cont_j);
                return;
            }
            ap.setViewTextColor(c0710a.jvs, R.color.cp_cont_d);
            return;
        }
        ap.setViewTextColor(c0710a.jvs, R.color.cp_cont_d);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0710a extends RecyclerView.ViewHolder {
        private View jvA;
        private View jvB;
        private View jvC;
        private TBSpecificationBtn jvD;
        private RelativeLayout jvE;
        private TextView jvl;
        private TextView jvm;
        private TextView jvn;
        private TextView jvo;
        private TextView jvp;
        private TextView jvq;
        private TextView jvr;
        private TextView jvs;
        private TextView jvt;
        private LinearLayout jvu;
        private LinearLayout jvv;
        private LinearLayout jvw;
        private LinearLayout jvx;
        private BarImageView jvy;
        private TbImageView jvz;

        public C0710a(View view) {
            super(view);
            this.jvl = (TextView) view.findViewById(R.id.bcast_time);
            this.jvm = (TextView) view.findViewById(R.id.forum_name);
            this.jvn = (TextView) view.findViewById(R.id.bcast_title);
            this.jvo = (TextView) view.findViewById(R.id.bcast_content);
            this.jvp = (TextView) view.findViewById(R.id.publish_number);
            this.jvq = (TextView) view.findViewById(R.id.pv_number);
            this.jvr = (TextView) view.findViewById(R.id.ctr_number);
            this.jvu = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.jvv = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.jvy = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.jvz = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jvA = view.findViewById(R.id.forum_bg_line);
            this.jvw = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.jvs = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.jvD = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.jvx = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.jvE = (RelativeLayout) view.findViewById(R.id.container_image);
            this.jvt = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.jvC = view.findViewById(R.id.bg_item_mian_view);
            this.jvB = view.findViewById(R.id.gradient_cover);
        }
    }

    public void dO(List<b> list) {
        if (list != null) {
            this.jaP = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jaP != null) {
            return this.jaP.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jaQ = fVar;
    }
}
