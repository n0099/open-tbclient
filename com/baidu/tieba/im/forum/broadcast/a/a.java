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
    private List<b> jWB = new ArrayList();
    private f<b> jWC;
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
        final b bVar = this.jWB.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0776a.kqS.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0776a.kqS.setLayoutParams(layoutParams);
            }
            if (be.eb(bVar.cWs() * 1000)) {
                c0776a.kqS.setText(au.dM(bVar.cWs() * 1000));
            } else {
                c0776a.kqS.setText(au.dN(bVar.cWs() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0776a.krl.setVisibility(8);
                c0776a.kra.setVisibility(0);
                c0776a.kra.setText(bVar.getTitle());
            } else {
                c0776a.krl.setVisibility(0);
                c0776a.kra.setVisibility(8);
                c0776a.kqU.setText(bVar.getTitle());
                c0776a.krg.setConrers(15);
                c0776a.krg.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0776a.krg.setDrawCorner(true);
                c0776a.krg.setPlaceHolder(2);
                c0776a.krg.startLoad(bVar.getPicUrl(), 10, false);
                c0776a.krg.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0776a.kqV.setVisibility(8);
            } else {
                c0776a.kqV.setVisibility(0);
                c0776a.kqV.setText(bVar.getContent());
            }
            c0776a.kqT.setText(bVar.cWx().forum_name);
            c0776a.krf.setShowOval(true);
            c0776a.krf.setAutoChangeStyle(true);
            c0776a.krf.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0776a.krf.setStrokeColorResId(R.color.CAM_X0401);
            c0776a.krf.setShowOuterBorder(false);
            c0776a.krf.setShowInnerBorder(true);
            c0776a.krf.setPlaceHolder(1);
            c0776a.krf.startLoad(bVar.cWx().avatar, 10, false);
            c0776a.kqW.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, au.dY(bVar.cWt())));
            c0776a.kqX.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, au.dY(bVar.cWu())));
            int parseFloat = (int) (Float.parseFloat(bVar.cWv()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cWv())) {
                c0776a.kqY.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0776a.kqY.setText("0%");
            }
            if (bVar.cWy() != null) {
                if (bVar.cWy().is_deleted.intValue() != 1) {
                    if (bVar.cGF() != 1) {
                        if (bVar.cGF() != 6) {
                            if (bVar.cGF() == 10) {
                                c0776a.kre.setVisibility(0);
                                c0776a.krh.setVisibility(0);
                                c0776a.krd.setVisibility(8);
                            }
                        } else {
                            c0776a.kre.setVisibility(8);
                            c0776a.krh.setVisibility(8);
                            c0776a.krd.setVisibility(0);
                            c0776a.krk.setVisibility(0);
                            c0776a.kqZ.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0776a.krk.setText(this.mContext.getString(R.string.edit));
                            c0776a.krk.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.rh(R.color.CAM_X0302);
                            c0776a.krk.setConfig(bVar2);
                            c0776a.krk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jWC != null) {
                                        a.this.jWC.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0776a.kre.setVisibility(8);
                        c0776a.krh.setVisibility(8);
                        c0776a.krd.setVisibility(0);
                        c0776a.krk.setVisibility(8);
                        c0776a.kqZ.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0776a.krd.setVisibility(0);
                    c0776a.krk.setVisibility(8);
                    c0776a.kqZ.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cGF() == 1 || bVar.cGF() == 6) {
                        c0776a.kre.setVisibility(8);
                        c0776a.krh.setVisibility(8);
                    } else {
                        c0776a.kre.setVisibility(0);
                        c0776a.krh.setVisibility(0);
                    }
                }
            } else {
                c0776a.krd.setVisibility(0);
                c0776a.krk.setVisibility(8);
                c0776a.kqZ.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cGF() == 1 || bVar.cGF() == 6) {
                    c0776a.kre.setVisibility(8);
                    c0776a.krh.setVisibility(8);
                } else {
                    c0776a.kre.setVisibility(0);
                    c0776a.krh.setVisibility(0);
                }
            }
            c0776a.krc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jWC != null) {
                        a.this.jWC.a(view, bVar, i, i);
                    }
                }
            });
            a(c0776a, bVar, i);
        }
    }

    private void a(C0776a c0776a, b bVar, int i) {
        ap.setViewTextColor(c0776a.kqS, R.color.CAM_X0109);
        ap.setViewTextColor(c0776a.kqT, R.color.CAM_X0105);
        ap.setViewTextColor(c0776a.kqU, R.color.CAM_X0101);
        ap.setViewTextColor(c0776a.kqV, R.color.CAM_X0107);
        ap.setViewTextColor(c0776a.kqW, R.color.CAM_X0107);
        ap.setViewTextColor(c0776a.kqX, R.color.CAM_X0107);
        ap.setViewTextColor(c0776a.kqY, R.color.CAM_X0107);
        ap.setBackgroundColor(c0776a.krh, R.color.CAM_X0203);
        ap.setViewTextColor(c0776a.kra, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0601, R.color.CAM_X0606).ag(l.getDimens(this.mContext, R.dimen.tbds21)).af(l.getDimens(this.mContext, R.dimen.tbds21)).bq(c0776a.kri);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0776a.kqS.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0776a.kqS.setLayoutParams(layoutParams);
            }
            c0776a.krc.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0776a.krj.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.mContext, R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.mContext, R.dimen.tbds10)).qv(0).qw(l.getDimens(this.mContext, R.dimen.tbds5)).bq(c0776a.krj);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0776a.krc.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0776a.krc.setLayoutParams(layoutParams2);
            c0776a.krc.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0776a.krj.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds31)).qg(R.color.CAM_X0205).bq(c0776a.krc);
        }
        if (bVar.cWy() != null) {
            if (bVar.cWy().is_deleted.intValue() != 1) {
                if (bVar.cGF() != 1) {
                    if (bVar.cGF() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0776a.kqZ, R.color.CAM_X0301);
                    return;
                }
                ap.setViewTextColor(c0776a.kqZ, R.color.CAM_X0107);
                return;
            }
            ap.setViewTextColor(c0776a.kqZ, R.color.CAM_X0109);
            return;
        }
        ap.setViewTextColor(c0776a.kqZ, R.color.CAM_X0109);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0776a extends RecyclerView.ViewHolder {
        private TextView kqS;
        private TextView kqT;
        private TextView kqU;
        private TextView kqV;
        private TextView kqW;
        private TextView kqX;
        private TextView kqY;
        private TextView kqZ;
        private TextView kra;
        private LinearLayout krb;
        private LinearLayout krc;
        private LinearLayout krd;
        private LinearLayout kre;
        private BarImageView krf;
        private TbImageView krg;
        private View krh;
        private View kri;
        private View krj;
        private TBSpecificationBtn krk;
        private RelativeLayout krl;

        public C0776a(View view) {
            super(view);
            this.kqS = (TextView) view.findViewById(R.id.bcast_time);
            this.kqT = (TextView) view.findViewById(R.id.forum_name);
            this.kqU = (TextView) view.findViewById(R.id.bcast_title);
            this.kqV = (TextView) view.findViewById(R.id.bcast_content);
            this.kqW = (TextView) view.findViewById(R.id.publish_number);
            this.kqX = (TextView) view.findViewById(R.id.pv_number);
            this.kqY = (TextView) view.findViewById(R.id.ctr_number);
            this.krb = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.krc = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.krf = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.krg = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.krh = view.findViewById(R.id.forum_bg_line);
            this.krd = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kqZ = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.krk = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kre = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.krl = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kra = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.krj = view.findViewById(R.id.bg_item_mian_view);
            this.kri = view.findViewById(R.id.gradient_cover);
        }
    }

    public void et(List<b> list) {
        if (list != null) {
            this.jWB = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jWB != null) {
            return this.jWB.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jWC = fVar;
    }
}
