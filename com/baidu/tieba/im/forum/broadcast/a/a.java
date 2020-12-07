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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class a extends RecyclerView.Adapter<C0776a> {
    private f<b> jWA;
    private List<b> jWz = new ArrayList();
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public C0776a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0776a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0776a c0776a, final int i) {
        final b bVar = this.jWz.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0776a.kqQ.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0776a.kqQ.setLayoutParams(layoutParams);
            }
            if (be.eb(bVar.cWr() * 1000)) {
                c0776a.kqQ.setText(au.dM(bVar.cWr() * 1000));
            } else {
                c0776a.kqQ.setText(au.dN(bVar.cWr() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0776a.krj.setVisibility(8);
                c0776a.kqY.setVisibility(0);
                c0776a.kqY.setText(bVar.getTitle());
            } else {
                c0776a.krj.setVisibility(0);
                c0776a.kqY.setVisibility(8);
                c0776a.kqS.setText(bVar.getTitle());
                c0776a.kre.setConrers(15);
                c0776a.kre.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0776a.kre.setDrawCorner(true);
                c0776a.kre.setPlaceHolder(2);
                c0776a.kre.startLoad(bVar.getPicUrl(), 10, false);
                c0776a.kre.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0776a.kqT.setVisibility(8);
            } else {
                c0776a.kqT.setVisibility(0);
                c0776a.kqT.setText(bVar.getContent());
            }
            c0776a.kqR.setText(bVar.cWw().forum_name);
            c0776a.krd.setShowOval(true);
            c0776a.krd.setAutoChangeStyle(true);
            c0776a.krd.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0776a.krd.setStrokeColorResId(R.color.CAM_X0401);
            c0776a.krd.setShowOuterBorder(false);
            c0776a.krd.setShowInnerBorder(true);
            c0776a.krd.setPlaceHolder(1);
            c0776a.krd.startLoad(bVar.cWw().avatar, 10, false);
            c0776a.kqU.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, au.dY(bVar.cWs())));
            c0776a.kqV.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, au.dY(bVar.cWt())));
            int parseFloat = (int) (Float.parseFloat(bVar.cWu()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cWu())) {
                c0776a.kqW.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0776a.kqW.setText("0%");
            }
            if (bVar.cWx() != null) {
                if (bVar.cWx().is_deleted.intValue() != 1) {
                    if (bVar.cGE() != 1) {
                        if (bVar.cGE() != 6) {
                            if (bVar.cGE() == 10) {
                                c0776a.krc.setVisibility(0);
                                c0776a.krf.setVisibility(0);
                                c0776a.krb.setVisibility(8);
                            }
                        } else {
                            c0776a.krc.setVisibility(8);
                            c0776a.krf.setVisibility(8);
                            c0776a.krb.setVisibility(0);
                            c0776a.kri.setVisibility(0);
                            c0776a.kqX.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0776a.kri.setText(this.mContext.getString(R.string.edit));
                            c0776a.kri.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.rh(R.color.CAM_X0302);
                            c0776a.kri.setConfig(bVar2);
                            c0776a.kri.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jWA != null) {
                                        a.this.jWA.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0776a.krc.setVisibility(8);
                        c0776a.krf.setVisibility(8);
                        c0776a.krb.setVisibility(0);
                        c0776a.kri.setVisibility(8);
                        c0776a.kqX.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0776a.krb.setVisibility(0);
                    c0776a.kri.setVisibility(8);
                    c0776a.kqX.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cGE() == 1 || bVar.cGE() == 6) {
                        c0776a.krc.setVisibility(8);
                        c0776a.krf.setVisibility(8);
                    } else {
                        c0776a.krc.setVisibility(0);
                        c0776a.krf.setVisibility(0);
                    }
                }
            } else {
                c0776a.krb.setVisibility(0);
                c0776a.kri.setVisibility(8);
                c0776a.kqX.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cGE() == 1 || bVar.cGE() == 6) {
                    c0776a.krc.setVisibility(8);
                    c0776a.krf.setVisibility(8);
                } else {
                    c0776a.krc.setVisibility(0);
                    c0776a.krf.setVisibility(0);
                }
            }
            c0776a.kra.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jWA != null) {
                        a.this.jWA.a(view, bVar, i, i);
                    }
                }
            });
            a(c0776a, bVar, i);
        }
    }

    private void a(C0776a c0776a, b bVar, int i) {
        ap.setViewTextColor(c0776a.kqQ, R.color.CAM_X0109);
        ap.setViewTextColor(c0776a.kqR, R.color.CAM_X0105);
        ap.setViewTextColor(c0776a.kqS, R.color.CAM_X0101);
        ap.setViewTextColor(c0776a.kqT, R.color.CAM_X0107);
        ap.setViewTextColor(c0776a.kqU, R.color.CAM_X0107);
        ap.setViewTextColor(c0776a.kqV, R.color.CAM_X0107);
        ap.setViewTextColor(c0776a.kqW, R.color.CAM_X0107);
        ap.setBackgroundColor(c0776a.krf, R.color.CAM_X0203);
        ap.setViewTextColor(c0776a.kqY, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0601, R.color.CAM_X0606).ag(l.getDimens(this.mContext, R.dimen.tbds21)).af(l.getDimens(this.mContext, R.dimen.tbds21)).bq(c0776a.krg);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0776a.kqQ.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0776a.kqQ.setLayoutParams(layoutParams);
            }
            c0776a.kra.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0776a.krh.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.mContext, R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.mContext, R.dimen.tbds10)).qv(0).qw(l.getDimens(this.mContext, R.dimen.tbds5)).bq(c0776a.krh);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0776a.kra.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0776a.kra.setLayoutParams(layoutParams2);
            c0776a.kra.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0776a.krh.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds31)).qg(R.color.CAM_X0205).bq(c0776a.kra);
        }
        if (bVar.cWx() != null) {
            if (bVar.cWx().is_deleted.intValue() != 1) {
                if (bVar.cGE() != 1) {
                    if (bVar.cGE() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0776a.kqX, R.color.CAM_X0301);
                    return;
                }
                ap.setViewTextColor(c0776a.kqX, R.color.CAM_X0107);
                return;
            }
            ap.setViewTextColor(c0776a.kqX, R.color.CAM_X0109);
            return;
        }
        ap.setViewTextColor(c0776a.kqX, R.color.CAM_X0109);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0776a extends RecyclerView.ViewHolder {
        private TextView kqQ;
        private TextView kqR;
        private TextView kqS;
        private TextView kqT;
        private TextView kqU;
        private TextView kqV;
        private TextView kqW;
        private TextView kqX;
        private TextView kqY;
        private LinearLayout kqZ;
        private LinearLayout kra;
        private LinearLayout krb;
        private LinearLayout krc;
        private BarImageView krd;
        private TbImageView kre;
        private View krf;
        private View krg;
        private View krh;
        private TBSpecificationBtn kri;
        private RelativeLayout krj;

        public C0776a(View view) {
            super(view);
            this.kqQ = (TextView) view.findViewById(R.id.bcast_time);
            this.kqR = (TextView) view.findViewById(R.id.forum_name);
            this.kqS = (TextView) view.findViewById(R.id.bcast_title);
            this.kqT = (TextView) view.findViewById(R.id.bcast_content);
            this.kqU = (TextView) view.findViewById(R.id.publish_number);
            this.kqV = (TextView) view.findViewById(R.id.pv_number);
            this.kqW = (TextView) view.findViewById(R.id.ctr_number);
            this.kqZ = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kra = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.krd = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kre = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.krf = view.findViewById(R.id.forum_bg_line);
            this.krb = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kqX = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kri = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.krc = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.krj = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kqY = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.krh = view.findViewById(R.id.bg_item_mian_view);
            this.krg = view.findViewById(R.id.gradient_cover);
        }
    }

    public void et(List<b> list) {
        if (list != null) {
            this.jWz = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jWz != null) {
            return this.jWz.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jWA = fVar;
    }
}
