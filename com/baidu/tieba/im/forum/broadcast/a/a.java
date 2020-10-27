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
public class a extends RecyclerView.Adapter<C0744a> {
    private List<b> jCo = new ArrayList();
    private f<b> jCp;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public C0744a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0744a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0744a c0744a, final int i) {
        final b bVar = this.jCo.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0744a.jWG.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0744a.jWG.setLayoutParams(layoutParams);
            }
            if (bd.dg(bVar.cOW() * 1000)) {
                c0744a.jWG.setText(at.cR(bVar.cOW() * 1000));
            } else {
                c0744a.jWG.setText(at.cS(bVar.cOW() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0744a.jWZ.setVisibility(8);
                c0744a.jWO.setVisibility(0);
                c0744a.jWO.setText(bVar.getTitle());
            } else {
                c0744a.jWZ.setVisibility(0);
                c0744a.jWO.setVisibility(8);
                c0744a.jWI.setText(bVar.getTitle());
                c0744a.jWU.setConrers(15);
                c0744a.jWU.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0744a.jWU.setDrawCorner(true);
                c0744a.jWU.setPlaceHolder(2);
                c0744a.jWU.startLoad(bVar.getPicUrl(), 10, false);
                c0744a.jWU.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0744a.jWJ.setVisibility(8);
            } else {
                c0744a.jWJ.setVisibility(0);
                c0744a.jWJ.setText(bVar.getContent());
            }
            c0744a.jWH.setText(bVar.cPc().forum_name);
            c0744a.jWT.setShowOval(true);
            c0744a.jWT.setAutoChangeStyle(true);
            c0744a.jWT.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0744a.jWT.setStrokeColorResId(R.color.cp_border_a);
            c0744a.jWT.setShowOuterBorder(false);
            c0744a.jWT.setShowInnerBorder(true);
            c0744a.jWT.setPlaceHolder(1);
            c0744a.jWT.startLoad(bVar.cPc().avatar, 10, false);
            c0744a.jWK.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.dd(bVar.cOX())));
            c0744a.jWL.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.dd(bVar.cOY())));
            int parseFloat = (int) (Float.parseFloat(bVar.cOZ()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cOZ())) {
                c0744a.jWM.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0744a.jWM.setText("0%");
            }
            if (bVar.cPd() != null) {
                if (bVar.cPd().is_deleted.intValue() != 1) {
                    if (bVar.cPb() != 1) {
                        if (bVar.cPb() != 6) {
                            if (bVar.cPb() == 10) {
                                c0744a.jWS.setVisibility(0);
                                c0744a.jWV.setVisibility(0);
                                c0744a.jWR.setVisibility(8);
                            }
                        } else {
                            c0744a.jWS.setVisibility(8);
                            c0744a.jWV.setVisibility(8);
                            c0744a.jWR.setVisibility(0);
                            c0744a.jWY.setVisibility(0);
                            c0744a.jWN.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0744a.jWY.setText(this.mContext.getString(R.string.edit));
                            c0744a.jWY.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pY(R.color.cp_link_tip_a);
                            c0744a.jWY.setConfig(bVar2);
                            c0744a.jWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jCp != null) {
                                        a.this.jCp.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0744a.jWS.setVisibility(8);
                        c0744a.jWV.setVisibility(8);
                        c0744a.jWR.setVisibility(0);
                        c0744a.jWY.setVisibility(8);
                        c0744a.jWN.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0744a.jWR.setVisibility(0);
                    c0744a.jWY.setVisibility(8);
                    c0744a.jWN.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cPb() == 1 || bVar.cPb() == 6) {
                        c0744a.jWS.setVisibility(8);
                        c0744a.jWV.setVisibility(8);
                    } else {
                        c0744a.jWS.setVisibility(0);
                        c0744a.jWV.setVisibility(0);
                    }
                }
            } else {
                c0744a.jWR.setVisibility(0);
                c0744a.jWY.setVisibility(8);
                c0744a.jWN.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cPb() == 1 || bVar.cPb() == 6) {
                    c0744a.jWS.setVisibility(8);
                    c0744a.jWV.setVisibility(8);
                } else {
                    c0744a.jWS.setVisibility(0);
                    c0744a.jWV.setVisibility(0);
                }
            }
            c0744a.jWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jCp != null) {
                        a.this.jCp.a(view, bVar, i, i);
                    }
                }
            });
            a(c0744a, bVar, i);
        }
    }

    private void a(C0744a c0744a, b bVar, int i) {
        ap.setViewTextColor(c0744a.jWG, R.color.cp_cont_d);
        ap.setViewTextColor(c0744a.jWH, R.color.cp_cont_b);
        ap.setViewTextColor(c0744a.jWI, R.color.cp_cont_a);
        ap.setViewTextColor(c0744a.jWJ, R.color.cp_cont_j);
        ap.setViewTextColor(c0744a.jWK, R.color.cp_cont_j);
        ap.setViewTextColor(c0744a.jWL, R.color.cp_cont_j);
        ap.setViewTextColor(c0744a.jWM, R.color.cp_cont_j);
        ap.setBackgroundColor(c0744a.jWV, R.color.cp_bg_line_b);
        ap.setViewTextColor(c0744a.jWO, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).ad(l.getDimens(this.mContext, R.dimen.tbds21)).ac(l.getDimens(this.mContext, R.dimen.tbds21)).bg(c0744a.jWW);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0744a.jWG.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0744a.jWG.setLayoutParams(layoutParams);
            }
            c0744a.jWQ.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0744a.jWX.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_bg_line_e).pk(l.getDimens(this.mContext, R.dimen.tbds31)).pl(R.color.cp_shadow_a_alpha16).pj(4369).pm(l.getDimens(this.mContext, R.dimen.tbds10)).po(0).pp(l.getDimens(this.mContext, R.dimen.tbds5)).bg(c0744a.jWX);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0744a.jWQ.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0744a.jWQ.setLayoutParams(layoutParams2);
            c0744a.jWQ.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0744a.jWX.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pe(l.getDimens(this.mContext, R.dimen.tbds31)).pa(R.color.cp_bg_line_e).bg(c0744a.jWQ);
        }
        if (bVar.cPd() != null) {
            if (bVar.cPd().is_deleted.intValue() != 1) {
                if (bVar.cPb() != 1) {
                    if (bVar.cPb() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0744a.jWN, R.color.cp_cont_h);
                    return;
                }
                ap.setViewTextColor(c0744a.jWN, R.color.cp_cont_j);
                return;
            }
            ap.setViewTextColor(c0744a.jWN, R.color.cp_cont_d);
            return;
        }
        ap.setViewTextColor(c0744a.jWN, R.color.cp_cont_d);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0744a extends RecyclerView.ViewHolder {
        private TextView jWG;
        private TextView jWH;
        private TextView jWI;
        private TextView jWJ;
        private TextView jWK;
        private TextView jWL;
        private TextView jWM;
        private TextView jWN;
        private TextView jWO;
        private LinearLayout jWP;
        private LinearLayout jWQ;
        private LinearLayout jWR;
        private LinearLayout jWS;
        private BarImageView jWT;
        private TbImageView jWU;
        private View jWV;
        private View jWW;
        private View jWX;
        private TBSpecificationBtn jWY;
        private RelativeLayout jWZ;

        public C0744a(View view) {
            super(view);
            this.jWG = (TextView) view.findViewById(R.id.bcast_time);
            this.jWH = (TextView) view.findViewById(R.id.forum_name);
            this.jWI = (TextView) view.findViewById(R.id.bcast_title);
            this.jWJ = (TextView) view.findViewById(R.id.bcast_content);
            this.jWK = (TextView) view.findViewById(R.id.publish_number);
            this.jWL = (TextView) view.findViewById(R.id.pv_number);
            this.jWM = (TextView) view.findViewById(R.id.ctr_number);
            this.jWP = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.jWQ = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.jWT = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.jWU = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jWV = view.findViewById(R.id.forum_bg_line);
            this.jWR = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.jWN = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.jWY = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.jWS = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.jWZ = (RelativeLayout) view.findViewById(R.id.container_image);
            this.jWO = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.jWX = view.findViewById(R.id.bg_item_mian_view);
            this.jWW = view.findViewById(R.id.gradient_cover);
        }
    }

    public void ea(List<b> list) {
        if (list != null) {
            this.jCo = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jCo != null) {
            return this.jCo.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jCp = fVar;
    }
}
