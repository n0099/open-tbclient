package com.baidu.tieba.im.forum.broadcast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    private List<b> knp = new ArrayList();
    private f<b> knq;
    private final Context mContext;

    public FroumBroadMajorHistoryAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: M */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, final int i) {
        final b bVar = this.knp.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kFi.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                froumBroadMajorHistoryItemViewHolder.kFi.setLayoutParams(layoutParams);
            }
            if (be.eh(bVar.cVV() * 1000)) {
                froumBroadMajorHistoryItemViewHolder.kFi.setText(au.dS(bVar.cVV() * 1000));
            } else {
                froumBroadMajorHistoryItemViewHolder.kFi.setText(au.dT(bVar.cVV() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                froumBroadMajorHistoryItemViewHolder.kFB.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kFq.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFq.setText(bVar.getTitle());
            } else {
                froumBroadMajorHistoryItemViewHolder.kFB.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFq.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kFk.setText(bVar.getTitle());
                froumBroadMajorHistoryItemViewHolder.kFw.setConrers(15);
                froumBroadMajorHistoryItemViewHolder.kFw.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                froumBroadMajorHistoryItemViewHolder.kFw.setDrawCorner(true);
                froumBroadMajorHistoryItemViewHolder.kFw.setPlaceHolder(2);
                froumBroadMajorHistoryItemViewHolder.kFw.startLoad(bVar.getPicUrl(), 10, false);
                froumBroadMajorHistoryItemViewHolder.kFw.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                froumBroadMajorHistoryItemViewHolder.kFl.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.kFl.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFl.setText(bVar.getContent());
            }
            froumBroadMajorHistoryItemViewHolder.kFj.setText(bVar.cWa().forum_name);
            froumBroadMajorHistoryItemViewHolder.kFv.setShowOval(true);
            froumBroadMajorHistoryItemViewHolder.kFv.setAutoChangeStyle(true);
            froumBroadMajorHistoryItemViewHolder.kFv.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            froumBroadMajorHistoryItemViewHolder.kFv.setStrokeColorResId(R.color.CAM_X0401);
            froumBroadMajorHistoryItemViewHolder.kFv.setShowOuterBorder(false);
            froumBroadMajorHistoryItemViewHolder.kFv.setShowInnerBorder(true);
            froumBroadMajorHistoryItemViewHolder.kFv.setPlaceHolder(1);
            froumBroadMajorHistoryItemViewHolder.kFv.startLoad(bVar.cWa().avatar, 10, false);
            froumBroadMajorHistoryItemViewHolder.kFm.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, au.ee(bVar.cVW())));
            froumBroadMajorHistoryItemViewHolder.kFn.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, au.ee(bVar.cVX())));
            int parseFloat = (int) (Float.parseFloat(bVar.cVY()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cVY())) {
                froumBroadMajorHistoryItemViewHolder.kFo.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                froumBroadMajorHistoryItemViewHolder.kFo.setText("0%");
            }
            if (bVar.cWb() != null) {
                if (bVar.cWb().is_deleted.intValue() != 1) {
                    if (bVar.cHa() != 1) {
                        if (bVar.cHa() != 6) {
                            if (bVar.cHa() == 10) {
                                froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kFt.setVisibility(8);
                            }
                        } else {
                            froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kFt.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kFA.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kFp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            froumBroadMajorHistoryItemViewHolder.kFA.setText(this.mContext.getString(R.string.edit));
                            froumBroadMajorHistoryItemViewHolder.kFA.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pR(R.color.CAM_X0302);
                            froumBroadMajorHistoryItemViewHolder.kFA.setConfig(bVar2);
                            froumBroadMajorHistoryItemViewHolder.kFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (FroumBroadMajorHistoryAdapter.this.knq != null) {
                                        FroumBroadMajorHistoryAdapter.this.knq.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFt.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kFA.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFp.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    froumBroadMajorHistoryItemViewHolder.kFt.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kFA.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kFp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cHa() == 1 || bVar.cHa() == 6) {
                        froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(8);
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(0);
                    }
                }
            } else {
                froumBroadMajorHistoryItemViewHolder.kFt.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFA.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kFp.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cHa() == 1 || bVar.cHa() == 6) {
                    froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(8);
                } else {
                    froumBroadMajorHistoryItemViewHolder.kFu.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kFx.setVisibility(0);
                }
            }
            froumBroadMajorHistoryItemViewHolder.kFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FroumBroadMajorHistoryAdapter.this.knq != null) {
                        FroumBroadMajorHistoryAdapter.this.knq.a(view, bVar, i, i);
                    }
                }
            });
            a(froumBroadMajorHistoryItemViewHolder, bVar, i);
        }
    }

    private void a(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, b bVar, int i) {
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFi, R.color.CAM_X0109);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFj, R.color.CAM_X0105);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFk, R.color.CAM_X0101);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFl, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFm, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFn, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFo, R.color.CAM_X0107);
        ap.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.kFx, R.color.CAM_X0203);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFq, R.color.CAM_X0105);
        a.btv().oO(0).m(R.color.CAM_X0601, R.color.CAM_X0606).aj(l.getDimens(this.mContext, R.dimen.tbds21)).ai(l.getDimens(this.mContext, R.dimen.tbds21)).bv(froumBroadMajorHistoryItemViewHolder.kFy);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kFi.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.kFi.setLayoutParams(layoutParams);
            }
            froumBroadMajorHistoryItemViewHolder.kFs.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.kFz.setVisibility(0);
            a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.mContext, R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.mContext, R.dimen.tbds10)).pe(0).pf(l.getDimens(this.mContext, R.dimen.tbds5)).bv(froumBroadMajorHistoryItemViewHolder.kFz);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kFs.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.kFs.setLayoutParams(layoutParams2);
            froumBroadMajorHistoryItemViewHolder.kFs.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.kFz.setVisibility(8);
            a.btv().oO(0).oV(l.getDimens(this.mContext, R.dimen.tbds31)).oP(R.color.CAM_X0205).bv(froumBroadMajorHistoryItemViewHolder.kFs);
        }
        if (bVar.cWb() != null) {
            if (bVar.cWb().is_deleted.intValue() != 1) {
                if (bVar.cHa() != 1) {
                    if (bVar.cHa() != 6) {
                        return;
                    }
                    ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFp, R.color.CAM_X0301);
                    return;
                }
                ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFp, R.color.CAM_X0107);
                return;
            }
            ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFp, R.color.CAM_X0109);
            return;
        }
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFp, R.color.CAM_X0109);
    }

    /* loaded from: classes8.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        private TBSpecificationBtn kFA;
        private RelativeLayout kFB;
        private TextView kFi;
        private TextView kFj;
        private TextView kFk;
        private TextView kFl;
        private TextView kFm;
        private TextView kFn;
        private TextView kFo;
        private TextView kFp;
        private TextView kFq;
        private LinearLayout kFr;
        private LinearLayout kFs;
        private LinearLayout kFt;
        private LinearLayout kFu;
        private BarImageView kFv;
        private TbImageView kFw;
        private View kFx;
        private View kFy;
        private View kFz;

        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            this.kFi = (TextView) view.findViewById(R.id.bcast_time);
            this.kFj = (TextView) view.findViewById(R.id.forum_name);
            this.kFk = (TextView) view.findViewById(R.id.bcast_title);
            this.kFl = (TextView) view.findViewById(R.id.bcast_content);
            this.kFm = (TextView) view.findViewById(R.id.publish_number);
            this.kFn = (TextView) view.findViewById(R.id.pv_number);
            this.kFo = (TextView) view.findViewById(R.id.ctr_number);
            this.kFr = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kFs = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kFv = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kFw = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kFx = view.findViewById(R.id.forum_bg_line);
            this.kFt = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kFp = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kFA = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kFu = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kFB = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kFq = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kFz = view.findViewById(R.id.bg_item_mian_view);
            this.kFy = view.findViewById(R.id.gradient_cover);
        }
    }

    public void ey(List<b> list) {
        if (list != null) {
            this.knp = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.knp != null) {
            return this.knp.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.knq = fVar;
    }
}
