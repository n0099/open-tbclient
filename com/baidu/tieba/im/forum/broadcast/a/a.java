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
public class a extends RecyclerView.Adapter<C0758a> {
    private List<b> jIl = new ArrayList();
    private f<b> jIm;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public C0758a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0758a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0758a c0758a, final int i) {
        final b bVar = this.jIl.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0758a.kcD.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0758a.kcD.setLayoutParams(layoutParams);
            }
            if (bd.dC(bVar.cRx() * 1000)) {
                c0758a.kcD.setText(at.dn(bVar.cRx() * 1000));
            } else {
                c0758a.kcD.setText(at.m39do(bVar.cRx() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0758a.kcW.setVisibility(8);
                c0758a.kcL.setVisibility(0);
                c0758a.kcL.setText(bVar.getTitle());
            } else {
                c0758a.kcW.setVisibility(0);
                c0758a.kcL.setVisibility(8);
                c0758a.kcF.setText(bVar.getTitle());
                c0758a.kcR.setConrers(15);
                c0758a.kcR.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0758a.kcR.setDrawCorner(true);
                c0758a.kcR.setPlaceHolder(2);
                c0758a.kcR.startLoad(bVar.getPicUrl(), 10, false);
                c0758a.kcR.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0758a.kcG.setVisibility(8);
            } else {
                c0758a.kcG.setVisibility(0);
                c0758a.kcG.setText(bVar.getContent());
            }
            c0758a.kcE.setText(bVar.cRD().forum_name);
            c0758a.kcQ.setShowOval(true);
            c0758a.kcQ.setAutoChangeStyle(true);
            c0758a.kcQ.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0758a.kcQ.setStrokeColorResId(R.color.cp_border_a);
            c0758a.kcQ.setShowOuterBorder(false);
            c0758a.kcQ.setShowInnerBorder(true);
            c0758a.kcQ.setPlaceHolder(1);
            c0758a.kcQ.startLoad(bVar.cRD().avatar, 10, false);
            c0758a.kcH.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.dz(bVar.cRy())));
            c0758a.kcI.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.dz(bVar.cRz())));
            int parseFloat = (int) (Float.parseFloat(bVar.cRA()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cRA())) {
                c0758a.kcJ.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0758a.kcJ.setText("0%");
            }
            if (bVar.cRE() != null) {
                if (bVar.cRE().is_deleted.intValue() != 1) {
                    if (bVar.cRC() != 1) {
                        if (bVar.cRC() != 6) {
                            if (bVar.cRC() == 10) {
                                c0758a.kcP.setVisibility(0);
                                c0758a.kcS.setVisibility(0);
                                c0758a.kcO.setVisibility(8);
                            }
                        } else {
                            c0758a.kcP.setVisibility(8);
                            c0758a.kcS.setVisibility(8);
                            c0758a.kcO.setVisibility(0);
                            c0758a.kcV.setVisibility(0);
                            c0758a.kcK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0758a.kcV.setText(this.mContext.getString(R.string.edit));
                            c0758a.kcV.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.qi(R.color.cp_link_tip_a);
                            c0758a.kcV.setConfig(bVar2);
                            c0758a.kcV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jIm != null) {
                                        a.this.jIm.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0758a.kcP.setVisibility(8);
                        c0758a.kcS.setVisibility(8);
                        c0758a.kcO.setVisibility(0);
                        c0758a.kcV.setVisibility(8);
                        c0758a.kcK.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0758a.kcO.setVisibility(0);
                    c0758a.kcV.setVisibility(8);
                    c0758a.kcK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cRC() == 1 || bVar.cRC() == 6) {
                        c0758a.kcP.setVisibility(8);
                        c0758a.kcS.setVisibility(8);
                    } else {
                        c0758a.kcP.setVisibility(0);
                        c0758a.kcS.setVisibility(0);
                    }
                }
            } else {
                c0758a.kcO.setVisibility(0);
                c0758a.kcV.setVisibility(8);
                c0758a.kcK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cRC() == 1 || bVar.cRC() == 6) {
                    c0758a.kcP.setVisibility(8);
                    c0758a.kcS.setVisibility(8);
                } else {
                    c0758a.kcP.setVisibility(0);
                    c0758a.kcS.setVisibility(0);
                }
            }
            c0758a.kcN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jIm != null) {
                        a.this.jIm.a(view, bVar, i, i);
                    }
                }
            });
            a(c0758a, bVar, i);
        }
    }

    private void a(C0758a c0758a, b bVar, int i) {
        ap.setViewTextColor(c0758a.kcD, R.color.cp_cont_d);
        ap.setViewTextColor(c0758a.kcE, R.color.cp_cont_b);
        ap.setViewTextColor(c0758a.kcF, R.color.cp_cont_a);
        ap.setViewTextColor(c0758a.kcG, R.color.cp_cont_j);
        ap.setViewTextColor(c0758a.kcH, R.color.cp_cont_j);
        ap.setViewTextColor(c0758a.kcI, R.color.cp_cont_j);
        ap.setViewTextColor(c0758a.kcJ, R.color.cp_cont_j);
        ap.setBackgroundColor(c0758a.kcS, R.color.cp_bg_line_b);
        ap.setViewTextColor(c0758a.kcL, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).af(l.getDimens(this.mContext, R.dimen.tbds21)).ae(l.getDimens(this.mContext, R.dimen.tbds21)).bk(c0758a.kcT);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0758a.kcD.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0758a.kcD.setLayoutParams(layoutParams);
            }
            c0758a.kcN.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0758a.kcU.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_bg_line_e).pv(l.getDimens(this.mContext, R.dimen.tbds31)).pw(R.color.cp_shadow_a_alpha16).pu(4369).px(l.getDimens(this.mContext, R.dimen.tbds10)).py(0).pz(l.getDimens(this.mContext, R.dimen.tbds5)).bk(c0758a.kcU);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0758a.kcN.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0758a.kcN.setLayoutParams(layoutParams2);
            c0758a.kcN.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0758a.kcU.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pp(l.getDimens(this.mContext, R.dimen.tbds31)).pk(R.color.cp_bg_line_e).bk(c0758a.kcN);
        }
        if (bVar.cRE() != null) {
            if (bVar.cRE().is_deleted.intValue() != 1) {
                if (bVar.cRC() != 1) {
                    if (bVar.cRC() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0758a.kcK, R.color.cp_cont_h);
                    return;
                }
                ap.setViewTextColor(c0758a.kcK, R.color.cp_cont_j);
                return;
            }
            ap.setViewTextColor(c0758a.kcK, R.color.cp_cont_d);
            return;
        }
        ap.setViewTextColor(c0758a.kcK, R.color.cp_cont_d);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0758a extends RecyclerView.ViewHolder {
        private TextView kcD;
        private TextView kcE;
        private TextView kcF;
        private TextView kcG;
        private TextView kcH;
        private TextView kcI;
        private TextView kcJ;
        private TextView kcK;
        private TextView kcL;
        private LinearLayout kcM;
        private LinearLayout kcN;
        private LinearLayout kcO;
        private LinearLayout kcP;
        private BarImageView kcQ;
        private TbImageView kcR;
        private View kcS;
        private View kcT;
        private View kcU;
        private TBSpecificationBtn kcV;
        private RelativeLayout kcW;

        public C0758a(View view) {
            super(view);
            this.kcD = (TextView) view.findViewById(R.id.bcast_time);
            this.kcE = (TextView) view.findViewById(R.id.forum_name);
            this.kcF = (TextView) view.findViewById(R.id.bcast_title);
            this.kcG = (TextView) view.findViewById(R.id.bcast_content);
            this.kcH = (TextView) view.findViewById(R.id.publish_number);
            this.kcI = (TextView) view.findViewById(R.id.pv_number);
            this.kcJ = (TextView) view.findViewById(R.id.ctr_number);
            this.kcM = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kcN = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kcQ = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kcR = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kcS = view.findViewById(R.id.forum_bg_line);
            this.kcO = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kcK = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kcV = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kcP = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kcW = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kcL = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kcU = view.findViewById(R.id.bg_item_mian_view);
            this.kcT = view.findViewById(R.id.gradient_cover);
        }
    }

    public void ei(List<b> list) {
        if (list != null) {
            this.jIl = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jIl != null) {
            return this.jIl.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jIm = fVar;
    }
}
