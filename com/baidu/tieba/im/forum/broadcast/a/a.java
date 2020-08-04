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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a extends RecyclerView.Adapter<C0661a> {
    private List<b> iDf = new ArrayList();
    private f<b> iDg;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: D */
    public C0661a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0661a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0661a c0661a, final int i) {
        final b bVar = this.iDf.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0661a.iXD.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0661a.iXD.setLayoutParams(layoutParams);
            }
            if (bc.cK(bVar.ctI() * 1000)) {
                c0661a.iXD.setText(as.cv(bVar.ctI() * 1000));
            } else {
                c0661a.iXD.setText(as.cw(bVar.ctI() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0661a.iXW.setVisibility(8);
                c0661a.iXL.setVisibility(0);
                c0661a.iXL.setText(bVar.getTitle());
            } else {
                c0661a.iXW.setVisibility(0);
                c0661a.iXL.setVisibility(8);
                c0661a.iXF.setText(bVar.getTitle());
                c0661a.iXR.setConrers(15);
                c0661a.iXR.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0661a.iXR.setDrawCorner(true);
                c0661a.iXR.setPlaceHolder(2);
                c0661a.iXR.startLoad(bVar.getPicUrl(), 10, false);
                c0661a.iXR.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0661a.iXG.setVisibility(8);
            } else {
                c0661a.iXG.setVisibility(0);
                c0661a.iXG.setText(bVar.getContent());
            }
            c0661a.iXE.setText(bVar.ctO().forum_name);
            c0661a.iXQ.setShowOval(true);
            c0661a.iXQ.setAutoChangeStyle(true);
            c0661a.iXQ.setAccuracyWith(10.0f);
            c0661a.iXQ.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0661a.iXQ.setStrokeColorResId(R.color.cp_border_a);
            c0661a.iXQ.setShowOuterBorder(false);
            c0661a.iXQ.setShowInnerBorder(true);
            c0661a.iXQ.setPlaceHolder(1);
            c0661a.iXQ.startLoad(bVar.ctO().avatar, 10, false);
            c0661a.iXH.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, as.cH(bVar.ctJ())));
            c0661a.iXI.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, as.cH(bVar.ctK())));
            int parseFloat = (int) (Float.parseFloat(bVar.ctL()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.ctL())) {
                c0661a.iXJ.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0661a.iXJ.setText("0%");
            }
            if (bVar.ctP() != null) {
                if (bVar.ctP().is_deleted.intValue() != 1) {
                    if (bVar.ctN() != 1) {
                        if (bVar.ctN() != 6) {
                            if (bVar.ctN() == 10) {
                                c0661a.iXP.setVisibility(0);
                                c0661a.iXS.setVisibility(0);
                                c0661a.iXO.setVisibility(8);
                            }
                        } else {
                            c0661a.iXP.setVisibility(8);
                            c0661a.iXS.setVisibility(8);
                            c0661a.iXO.setVisibility(0);
                            c0661a.iXV.setVisibility(0);
                            c0661a.iXK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0661a.iXV.setText(this.mContext.getString(R.string.edit));
                            c0661a.iXV.setTextSize(R.dimen.tbds34);
                            c cVar = new c();
                            cVar.mV(R.color.cp_link_tip_a);
                            c0661a.iXV.setConfig(cVar);
                            c0661a.iXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.iDg != null) {
                                        a.this.iDg.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0661a.iXP.setVisibility(8);
                        c0661a.iXS.setVisibility(8);
                        c0661a.iXO.setVisibility(0);
                        c0661a.iXV.setVisibility(8);
                        c0661a.iXK.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0661a.iXO.setVisibility(0);
                    c0661a.iXV.setVisibility(8);
                    c0661a.iXK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.ctN() == 1 || bVar.ctN() == 6) {
                        c0661a.iXP.setVisibility(8);
                        c0661a.iXS.setVisibility(8);
                    } else {
                        c0661a.iXP.setVisibility(0);
                        c0661a.iXS.setVisibility(0);
                    }
                }
            } else {
                c0661a.iXO.setVisibility(0);
                c0661a.iXV.setVisibility(8);
                c0661a.iXK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.ctN() == 1 || bVar.ctN() == 6) {
                    c0661a.iXP.setVisibility(8);
                    c0661a.iXS.setVisibility(8);
                } else {
                    c0661a.iXP.setVisibility(0);
                    c0661a.iXS.setVisibility(0);
                }
            }
            c0661a.iXN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iDg != null) {
                        a.this.iDg.a(view, bVar, i, i);
                    }
                }
            });
            a(c0661a, bVar, i);
        }
    }

    private void a(C0661a c0661a, b bVar, int i) {
        ao.setViewTextColor(c0661a.iXD, R.color.cp_cont_d);
        ao.setViewTextColor(c0661a.iXE, R.color.cp_cont_b);
        ao.setViewTextColor(c0661a.iXF, R.color.cp_cont_a);
        ao.setViewTextColor(c0661a.iXG, R.color.cp_cont_j);
        ao.setViewTextColor(c0661a.iXH, R.color.cp_cont_j);
        ao.setViewTextColor(c0661a.iXI, R.color.cp_cont_j);
        ao.setViewTextColor(c0661a.iXJ, R.color.cp_cont_j);
        ao.setBackgroundColor(c0661a.iXS, R.color.cp_bg_line_b);
        ao.setViewTextColor(c0661a.iXL, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).U(l.getDimens(this.mContext, R.dimen.tbds21)).T(l.getDimens(this.mContext, R.dimen.tbds21)).aX(c0661a.iXT);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0661a.iXD.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0661a.iXD.setLayoutParams(layoutParams);
            }
            c0661a.iXN.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0661a.iXU.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_e).ml(l.getDimens(this.mContext, R.dimen.tbds31)).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.mContext, R.dimen.tbds10)).mo(0).mp(l.getDimens(this.mContext, R.dimen.tbds5)).aX(c0661a.iXU);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0661a.iXN.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0661a.iXN.setLayoutParams(layoutParams2);
            c0661a.iXN.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0661a.iXU.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).mf(l.getDimens(this.mContext, R.dimen.tbds31)).mb(R.color.cp_bg_line_e).aX(c0661a.iXN);
        }
        if (bVar.ctP() != null) {
            if (bVar.ctP().is_deleted.intValue() != 1) {
                if (bVar.ctN() != 1) {
                    if (bVar.ctN() != 6) {
                        return;
                    }
                    ao.setViewTextColor(c0661a.iXK, R.color.cp_cont_h);
                    return;
                }
                ao.setViewTextColor(c0661a.iXK, R.color.cp_cont_j);
                return;
            }
            ao.setViewTextColor(c0661a.iXK, R.color.cp_cont_d);
            return;
        }
        ao.setViewTextColor(c0661a.iXK, R.color.cp_cont_d);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0661a extends RecyclerView.ViewHolder {
        private TextView iXD;
        private TextView iXE;
        private TextView iXF;
        private TextView iXG;
        private TextView iXH;
        private TextView iXI;
        private TextView iXJ;
        private TextView iXK;
        private TextView iXL;
        private LinearLayout iXM;
        private LinearLayout iXN;
        private LinearLayout iXO;
        private LinearLayout iXP;
        private BarImageView iXQ;
        private TbImageView iXR;
        private View iXS;
        private View iXT;
        private View iXU;
        private TBSpecificationBtn iXV;
        private RelativeLayout iXW;

        public C0661a(View view) {
            super(view);
            this.iXD = (TextView) view.findViewById(R.id.bcast_time);
            this.iXE = (TextView) view.findViewById(R.id.forum_name);
            this.iXF = (TextView) view.findViewById(R.id.bcast_title);
            this.iXG = (TextView) view.findViewById(R.id.bcast_content);
            this.iXH = (TextView) view.findViewById(R.id.publish_number);
            this.iXI = (TextView) view.findViewById(R.id.pv_number);
            this.iXJ = (TextView) view.findViewById(R.id.ctr_number);
            this.iXM = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.iXN = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.iXQ = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.iXR = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.iXS = view.findViewById(R.id.forum_bg_line);
            this.iXO = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.iXK = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.iXV = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.iXP = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.iXW = (RelativeLayout) view.findViewById(R.id.container_image);
            this.iXL = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.iXU = view.findViewById(R.id.bg_item_mian_view);
            this.iXT = view.findViewById(R.id.gradient_cover);
        }
    }

    public void dz(List<b> list) {
        if (list != null) {
            this.iDf = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iDf != null) {
            return this.iDf.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.iDg = fVar;
    }
}
