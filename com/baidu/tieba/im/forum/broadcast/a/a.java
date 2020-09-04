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
/* loaded from: classes20.dex */
public class a extends RecyclerView.Adapter<C0713a> {
    private List<b> iSj = new ArrayList();
    private f<b> iSk;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: D */
    public C0713a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0713a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0713a c0713a, final int i) {
        final b bVar = this.iSj.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0713a.jmI.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0713a.jmI.setLayoutParams(layoutParams);
            }
            if (bd.cV(bVar.cEA() * 1000)) {
                c0713a.jmI.setText(at.cG(bVar.cEA() * 1000));
            } else {
                c0713a.jmI.setText(at.cH(bVar.cEA() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0713a.jnb.setVisibility(8);
                c0713a.jmQ.setVisibility(0);
                c0713a.jmQ.setText(bVar.getTitle());
            } else {
                c0713a.jnb.setVisibility(0);
                c0713a.jmQ.setVisibility(8);
                c0713a.jmK.setText(bVar.getTitle());
                c0713a.jmW.setConrers(15);
                c0713a.jmW.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0713a.jmW.setDrawCorner(true);
                c0713a.jmW.setPlaceHolder(2);
                c0713a.jmW.startLoad(bVar.getPicUrl(), 10, false);
                c0713a.jmW.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0713a.jmL.setVisibility(8);
            } else {
                c0713a.jmL.setVisibility(0);
                c0713a.jmL.setText(bVar.getContent());
            }
            c0713a.jmJ.setText(bVar.cEG().forum_name);
            c0713a.jmV.setShowOval(true);
            c0713a.jmV.setAutoChangeStyle(true);
            c0713a.jmV.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0713a.jmV.setStrokeColorResId(R.color.cp_border_a);
            c0713a.jmV.setShowOuterBorder(false);
            c0713a.jmV.setShowInnerBorder(true);
            c0713a.jmV.setPlaceHolder(1);
            c0713a.jmV.startLoad(bVar.cEG().avatar, 10, false);
            c0713a.jmM.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.cS(bVar.cEB())));
            c0713a.jmN.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.cS(bVar.cEC())));
            int parseFloat = (int) (Float.parseFloat(bVar.cED()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cED())) {
                c0713a.jmO.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0713a.jmO.setText("0%");
            }
            if (bVar.cEH() != null) {
                if (bVar.cEH().is_deleted.intValue() != 1) {
                    if (bVar.cEF() != 1) {
                        if (bVar.cEF() != 6) {
                            if (bVar.cEF() == 10) {
                                c0713a.jmU.setVisibility(0);
                                c0713a.jmX.setVisibility(0);
                                c0713a.jmT.setVisibility(8);
                            }
                        } else {
                            c0713a.jmU.setVisibility(8);
                            c0713a.jmX.setVisibility(8);
                            c0713a.jmT.setVisibility(0);
                            c0713a.jna.setVisibility(0);
                            c0713a.jmP.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0713a.jna.setText(this.mContext.getString(R.string.edit));
                            c0713a.jna.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pb(R.color.cp_link_tip_a);
                            c0713a.jna.setConfig(bVar2);
                            c0713a.jna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.iSk != null) {
                                        a.this.iSk.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0713a.jmU.setVisibility(8);
                        c0713a.jmX.setVisibility(8);
                        c0713a.jmT.setVisibility(0);
                        c0713a.jna.setVisibility(8);
                        c0713a.jmP.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0713a.jmT.setVisibility(0);
                    c0713a.jna.setVisibility(8);
                    c0713a.jmP.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cEF() == 1 || bVar.cEF() == 6) {
                        c0713a.jmU.setVisibility(8);
                        c0713a.jmX.setVisibility(8);
                    } else {
                        c0713a.jmU.setVisibility(0);
                        c0713a.jmX.setVisibility(0);
                    }
                }
            } else {
                c0713a.jmT.setVisibility(0);
                c0713a.jna.setVisibility(8);
                c0713a.jmP.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cEF() == 1 || bVar.cEF() == 6) {
                    c0713a.jmU.setVisibility(8);
                    c0713a.jmX.setVisibility(8);
                } else {
                    c0713a.jmU.setVisibility(0);
                    c0713a.jmX.setVisibility(0);
                }
            }
            c0713a.jmS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iSk != null) {
                        a.this.iSk.a(view, bVar, i, i);
                    }
                }
            });
            a(c0713a, bVar, i);
        }
    }

    private void a(C0713a c0713a, b bVar, int i) {
        ap.setViewTextColor(c0713a.jmI, R.color.cp_cont_d);
        ap.setViewTextColor(c0713a.jmJ, R.color.cp_cont_b);
        ap.setViewTextColor(c0713a.jmK, R.color.cp_cont_a);
        ap.setViewTextColor(c0713a.jmL, R.color.cp_cont_j);
        ap.setViewTextColor(c0713a.jmM, R.color.cp_cont_j);
        ap.setViewTextColor(c0713a.jmN, R.color.cp_cont_j);
        ap.setViewTextColor(c0713a.jmO, R.color.cp_cont_j);
        ap.setBackgroundColor(c0713a.jmX, R.color.cp_bg_line_b);
        ap.setViewTextColor(c0713a.jmQ, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).Z(l.getDimens(this.mContext, R.dimen.tbds21)).Y(l.getDimens(this.mContext, R.dimen.tbds21)).aZ(c0713a.jmY);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0713a.jmI.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0713a.jmI.setLayoutParams(layoutParams);
            }
            c0713a.jmS.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0713a.jmZ.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_e).op(l.getDimens(this.mContext, R.dimen.tbds31)).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.mContext, R.dimen.tbds10)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(c0713a.jmZ);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0713a.jmS.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0713a.jmS.setLayoutParams(layoutParams2);
            c0713a.jmS.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0713a.jmZ.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).oj(l.getDimens(this.mContext, R.dimen.tbds31)).of(R.color.cp_bg_line_e).aZ(c0713a.jmS);
        }
        if (bVar.cEH() != null) {
            if (bVar.cEH().is_deleted.intValue() != 1) {
                if (bVar.cEF() != 1) {
                    if (bVar.cEF() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0713a.jmP, R.color.cp_cont_h);
                    return;
                }
                ap.setViewTextColor(c0713a.jmP, R.color.cp_cont_j);
                return;
            }
            ap.setViewTextColor(c0713a.jmP, R.color.cp_cont_d);
            return;
        }
        ap.setViewTextColor(c0713a.jmP, R.color.cp_cont_d);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0713a extends RecyclerView.ViewHolder {
        private TextView jmI;
        private TextView jmJ;
        private TextView jmK;
        private TextView jmL;
        private TextView jmM;
        private TextView jmN;
        private TextView jmO;
        private TextView jmP;
        private TextView jmQ;
        private LinearLayout jmR;
        private LinearLayout jmS;
        private LinearLayout jmT;
        private LinearLayout jmU;
        private BarImageView jmV;
        private TbImageView jmW;
        private View jmX;
        private View jmY;
        private View jmZ;
        private TBSpecificationBtn jna;
        private RelativeLayout jnb;

        public C0713a(View view) {
            super(view);
            this.jmI = (TextView) view.findViewById(R.id.bcast_time);
            this.jmJ = (TextView) view.findViewById(R.id.forum_name);
            this.jmK = (TextView) view.findViewById(R.id.bcast_title);
            this.jmL = (TextView) view.findViewById(R.id.bcast_content);
            this.jmM = (TextView) view.findViewById(R.id.publish_number);
            this.jmN = (TextView) view.findViewById(R.id.pv_number);
            this.jmO = (TextView) view.findViewById(R.id.ctr_number);
            this.jmR = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.jmS = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.jmV = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.jmW = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jmX = view.findViewById(R.id.forum_bg_line);
            this.jmT = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.jmP = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.jna = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.jmU = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.jnb = (RelativeLayout) view.findViewById(R.id.container_image);
            this.jmQ = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.jmZ = view.findViewById(R.id.bg_item_mian_view);
            this.jmY = view.findViewById(R.id.gradient_cover);
        }
    }

    public void dG(List<b> list) {
        if (list != null) {
            this.iSj = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iSj != null) {
            return this.iSj.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.iSk = fVar;
    }
}
