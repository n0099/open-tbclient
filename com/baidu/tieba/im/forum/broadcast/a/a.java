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
/* loaded from: classes25.dex */
public class a extends RecyclerView.Adapter<C0760a> {
    private List<b> jIW = new ArrayList();
    private f<b> jIX;
    private final Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public C0760a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0760a(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0760a c0760a, final int i) {
        final b bVar = this.jIW.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0760a.kdn.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                c0760a.kdn.setLayoutParams(layoutParams);
            }
            if (be.dC(bVar.cRd() * 1000)) {
                c0760a.kdn.setText(au.dn(bVar.cRd() * 1000));
            } else {
                c0760a.kdn.setText(au.m38do(bVar.cRd() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                c0760a.kdG.setVisibility(8);
                c0760a.kdv.setVisibility(0);
                c0760a.kdv.setText(bVar.getTitle());
            } else {
                c0760a.kdG.setVisibility(0);
                c0760a.kdv.setVisibility(8);
                c0760a.kdp.setText(bVar.getTitle());
                c0760a.kdB.setConrers(15);
                c0760a.kdB.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                c0760a.kdB.setDrawCorner(true);
                c0760a.kdB.setPlaceHolder(2);
                c0760a.kdB.startLoad(bVar.getPicUrl(), 10, false);
                c0760a.kdB.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                c0760a.kdq.setVisibility(8);
            } else {
                c0760a.kdq.setVisibility(0);
                c0760a.kdq.setText(bVar.getContent());
            }
            c0760a.kdo.setText(bVar.cRj().forum_name);
            c0760a.kdA.setShowOval(true);
            c0760a.kdA.setAutoChangeStyle(true);
            c0760a.kdA.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            c0760a.kdA.setStrokeColorResId(R.color.CAM_X0401);
            c0760a.kdA.setShowOuterBorder(false);
            c0760a.kdA.setShowInnerBorder(true);
            c0760a.kdA.setPlaceHolder(1);
            c0760a.kdA.startLoad(bVar.cRj().avatar, 10, false);
            c0760a.kdr.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, au.dz(bVar.cRe())));
            c0760a.kds.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, au.dz(bVar.cRf())));
            int parseFloat = (int) (Float.parseFloat(bVar.cRg()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cRg())) {
                c0760a.kdt.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                c0760a.kdt.setText("0%");
            }
            if (bVar.cRk() != null) {
                if (bVar.cRk().is_deleted.intValue() != 1) {
                    if (bVar.cRi() != 1) {
                        if (bVar.cRi() != 6) {
                            if (bVar.cRi() == 10) {
                                c0760a.kdz.setVisibility(0);
                                c0760a.kdC.setVisibility(0);
                                c0760a.kdy.setVisibility(8);
                            }
                        } else {
                            c0760a.kdz.setVisibility(8);
                            c0760a.kdC.setVisibility(8);
                            c0760a.kdy.setVisibility(0);
                            c0760a.kdF.setVisibility(0);
                            c0760a.kdu.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            c0760a.kdF.setText(this.mContext.getString(R.string.edit));
                            c0760a.kdF.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.qG(R.color.CAM_X0302);
                            c0760a.kdF.setConfig(bVar2);
                            c0760a.kdF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.jIX != null) {
                                        a.this.jIX.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        c0760a.kdz.setVisibility(8);
                        c0760a.kdC.setVisibility(8);
                        c0760a.kdy.setVisibility(0);
                        c0760a.kdF.setVisibility(8);
                        c0760a.kdu.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    c0760a.kdy.setVisibility(0);
                    c0760a.kdF.setVisibility(8);
                    c0760a.kdu.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cRi() == 1 || bVar.cRi() == 6) {
                        c0760a.kdz.setVisibility(8);
                        c0760a.kdC.setVisibility(8);
                    } else {
                        c0760a.kdz.setVisibility(0);
                        c0760a.kdC.setVisibility(0);
                    }
                }
            } else {
                c0760a.kdy.setVisibility(0);
                c0760a.kdF.setVisibility(8);
                c0760a.kdu.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cRi() == 1 || bVar.cRi() == 6) {
                    c0760a.kdz.setVisibility(8);
                    c0760a.kdC.setVisibility(8);
                } else {
                    c0760a.kdz.setVisibility(0);
                    c0760a.kdC.setVisibility(0);
                }
            }
            c0760a.kdx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jIX != null) {
                        a.this.jIX.a(view, bVar, i, i);
                    }
                }
            });
            a(c0760a, bVar, i);
        }
    }

    private void a(C0760a c0760a, b bVar, int i) {
        ap.setViewTextColor(c0760a.kdn, R.color.CAM_X0109);
        ap.setViewTextColor(c0760a.kdo, R.color.CAM_X0105);
        ap.setViewTextColor(c0760a.kdp, R.color.CAM_X0101);
        ap.setViewTextColor(c0760a.kdq, R.color.CAM_X0107);
        ap.setViewTextColor(c0760a.kdr, R.color.CAM_X0107);
        ap.setViewTextColor(c0760a.kds, R.color.CAM_X0107);
        ap.setViewTextColor(c0760a.kdt, R.color.CAM_X0107);
        ap.setBackgroundColor(c0760a.kdC, R.color.CAM_X0203);
        ap.setViewTextColor(c0760a.kdv, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.CAM_X0601, R.color.CAM_X0606).ag(l.getDimens(this.mContext, R.dimen.tbds21)).af(l.getDimens(this.mContext, R.dimen.tbds21)).bn(c0760a.kdD);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0760a.kdn.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                c0760a.kdn.setLayoutParams(layoutParams);
            }
            c0760a.kdx.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            c0760a.kdE.setVisibility(0);
            com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0205).pS(l.getDimens(this.mContext, R.dimen.tbds31)).pT(R.color.CAM_X0804).pR(4369).pU(l.getDimens(this.mContext, R.dimen.tbds10)).pV(0).pW(l.getDimens(this.mContext, R.dimen.tbds5)).bn(c0760a.kdE);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c0760a.kdx.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            c0760a.kdx.setLayoutParams(layoutParams2);
            c0760a.kdx.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            c0760a.kdE.setVisibility(8);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pM(l.getDimens(this.mContext, R.dimen.tbds31)).pG(R.color.CAM_X0205).bn(c0760a.kdx);
        }
        if (bVar.cRk() != null) {
            if (bVar.cRk().is_deleted.intValue() != 1) {
                if (bVar.cRi() != 1) {
                    if (bVar.cRi() != 6) {
                        return;
                    }
                    ap.setViewTextColor(c0760a.kdu, R.color.CAM_X0301);
                    return;
                }
                ap.setViewTextColor(c0760a.kdu, R.color.CAM_X0107);
                return;
            }
            ap.setViewTextColor(c0760a.kdu, R.color.CAM_X0109);
            return;
        }
        ap.setViewTextColor(c0760a.kdu, R.color.CAM_X0109);
    }

    /* renamed from: com.baidu.tieba.im.forum.broadcast.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0760a extends RecyclerView.ViewHolder {
        private BarImageView kdA;
        private TbImageView kdB;
        private View kdC;
        private View kdD;
        private View kdE;
        private TBSpecificationBtn kdF;
        private RelativeLayout kdG;
        private TextView kdn;
        private TextView kdo;
        private TextView kdp;
        private TextView kdq;
        private TextView kdr;
        private TextView kds;
        private TextView kdt;
        private TextView kdu;
        private TextView kdv;
        private LinearLayout kdw;
        private LinearLayout kdx;
        private LinearLayout kdy;
        private LinearLayout kdz;

        public C0760a(View view) {
            super(view);
            this.kdn = (TextView) view.findViewById(R.id.bcast_time);
            this.kdo = (TextView) view.findViewById(R.id.forum_name);
            this.kdp = (TextView) view.findViewById(R.id.bcast_title);
            this.kdq = (TextView) view.findViewById(R.id.bcast_content);
            this.kdr = (TextView) view.findViewById(R.id.publish_number);
            this.kds = (TextView) view.findViewById(R.id.pv_number);
            this.kdt = (TextView) view.findViewById(R.id.ctr_number);
            this.kdw = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kdx = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kdA = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kdB = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kdC = view.findViewById(R.id.forum_bg_line);
            this.kdy = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kdu = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kdF = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kdz = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kdG = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kdv = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kdE = view.findViewById(R.id.bg_item_mian_view);
            this.kdD = view.findViewById(R.id.gradient_cover);
        }
    }

    public void ei(List<b> list) {
        if (list != null) {
            this.jIW = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jIW != null) {
            return this.jIW.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.jIX = fVar;
    }
}
