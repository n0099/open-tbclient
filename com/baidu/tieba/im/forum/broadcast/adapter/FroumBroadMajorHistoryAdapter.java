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
    private List<b> knD = new ArrayList();
    private f<b> knE;
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
        final b bVar = this.knD.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kFw.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                froumBroadMajorHistoryItemViewHolder.kFw.setLayoutParams(layoutParams);
            }
            if (be.eh(bVar.cWc() * 1000)) {
                froumBroadMajorHistoryItemViewHolder.kFw.setText(au.dS(bVar.cWc() * 1000));
            } else {
                froumBroadMajorHistoryItemViewHolder.kFw.setText(au.dT(bVar.cWc() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                froumBroadMajorHistoryItemViewHolder.kFP.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kFE.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFE.setText(bVar.getTitle());
            } else {
                froumBroadMajorHistoryItemViewHolder.kFP.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFE.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kFy.setText(bVar.getTitle());
                froumBroadMajorHistoryItemViewHolder.kFK.setConrers(15);
                froumBroadMajorHistoryItemViewHolder.kFK.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                froumBroadMajorHistoryItemViewHolder.kFK.setDrawCorner(true);
                froumBroadMajorHistoryItemViewHolder.kFK.setPlaceHolder(2);
                froumBroadMajorHistoryItemViewHolder.kFK.startLoad(bVar.getPicUrl(), 10, false);
                froumBroadMajorHistoryItemViewHolder.kFK.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                froumBroadMajorHistoryItemViewHolder.kFz.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.kFz.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFz.setText(bVar.getContent());
            }
            froumBroadMajorHistoryItemViewHolder.kFx.setText(bVar.cWh().forum_name);
            froumBroadMajorHistoryItemViewHolder.kFJ.setShowOval(true);
            froumBroadMajorHistoryItemViewHolder.kFJ.setAutoChangeStyle(true);
            froumBroadMajorHistoryItemViewHolder.kFJ.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            froumBroadMajorHistoryItemViewHolder.kFJ.setStrokeColorResId(R.color.CAM_X0401);
            froumBroadMajorHistoryItemViewHolder.kFJ.setShowOuterBorder(false);
            froumBroadMajorHistoryItemViewHolder.kFJ.setShowInnerBorder(true);
            froumBroadMajorHistoryItemViewHolder.kFJ.setPlaceHolder(1);
            froumBroadMajorHistoryItemViewHolder.kFJ.startLoad(bVar.cWh().avatar, 10, false);
            froumBroadMajorHistoryItemViewHolder.kFA.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, au.ee(bVar.cWd())));
            froumBroadMajorHistoryItemViewHolder.kFB.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, au.ee(bVar.cWe())));
            int parseFloat = (int) (Float.parseFloat(bVar.cWf()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cWf())) {
                froumBroadMajorHistoryItemViewHolder.kFC.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                froumBroadMajorHistoryItemViewHolder.kFC.setText("0%");
            }
            if (bVar.cWi() != null) {
                if (bVar.cWi().is_deleted.intValue() != 1) {
                    if (bVar.cHh() != 1) {
                        if (bVar.cHh() != 6) {
                            if (bVar.cHh() == 10) {
                                froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kFH.setVisibility(8);
                            }
                        } else {
                            froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kFH.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kFO.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kFD.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            froumBroadMajorHistoryItemViewHolder.kFO.setText(this.mContext.getString(R.string.edit));
                            froumBroadMajorHistoryItemViewHolder.kFO.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pR(R.color.CAM_X0302);
                            froumBroadMajorHistoryItemViewHolder.kFO.setConfig(bVar2);
                            froumBroadMajorHistoryItemViewHolder.kFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (FroumBroadMajorHistoryAdapter.this.knE != null) {
                                        FroumBroadMajorHistoryAdapter.this.knE.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFH.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kFO.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFD.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    froumBroadMajorHistoryItemViewHolder.kFH.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kFO.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kFD.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cHh() == 1 || bVar.cHh() == 6) {
                        froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(8);
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(0);
                    }
                }
            } else {
                froumBroadMajorHistoryItemViewHolder.kFH.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kFO.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kFD.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cHh() == 1 || bVar.cHh() == 6) {
                    froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(8);
                } else {
                    froumBroadMajorHistoryItemViewHolder.kFI.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kFL.setVisibility(0);
                }
            }
            froumBroadMajorHistoryItemViewHolder.kFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FroumBroadMajorHistoryAdapter.this.knE != null) {
                        FroumBroadMajorHistoryAdapter.this.knE.a(view, bVar, i, i);
                    }
                }
            });
            a(froumBroadMajorHistoryItemViewHolder, bVar, i);
        }
    }

    private void a(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, b bVar, int i) {
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFw, R.color.CAM_X0109);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFx, R.color.CAM_X0105);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFy, R.color.CAM_X0101);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFz, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFA, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFB, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFC, R.color.CAM_X0107);
        ap.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.kFL, R.color.CAM_X0203);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFE, R.color.CAM_X0105);
        a.btv().oO(0).m(R.color.CAM_X0601, R.color.CAM_X0606).aj(l.getDimens(this.mContext, R.dimen.tbds21)).ai(l.getDimens(this.mContext, R.dimen.tbds21)).bv(froumBroadMajorHistoryItemViewHolder.kFM);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kFw.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.kFw.setLayoutParams(layoutParams);
            }
            froumBroadMajorHistoryItemViewHolder.kFG.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.kFN.setVisibility(0);
            a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.mContext, R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.mContext, R.dimen.tbds10)).pe(0).pf(l.getDimens(this.mContext, R.dimen.tbds5)).bv(froumBroadMajorHistoryItemViewHolder.kFN);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kFG.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.kFG.setLayoutParams(layoutParams2);
            froumBroadMajorHistoryItemViewHolder.kFG.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.kFN.setVisibility(8);
            a.btv().oO(0).oV(l.getDimens(this.mContext, R.dimen.tbds31)).oP(R.color.CAM_X0205).bv(froumBroadMajorHistoryItemViewHolder.kFG);
        }
        if (bVar.cWi() != null) {
            if (bVar.cWi().is_deleted.intValue() != 1) {
                if (bVar.cHh() != 1) {
                    if (bVar.cHh() != 6) {
                        return;
                    }
                    ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFD, R.color.CAM_X0301);
                    return;
                }
                ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFD, R.color.CAM_X0107);
                return;
            }
            ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFD, R.color.CAM_X0109);
            return;
        }
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kFD, R.color.CAM_X0109);
    }

    /* loaded from: classes8.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        private TextView kFA;
        private TextView kFB;
        private TextView kFC;
        private TextView kFD;
        private TextView kFE;
        private LinearLayout kFF;
        private LinearLayout kFG;
        private LinearLayout kFH;
        private LinearLayout kFI;
        private BarImageView kFJ;
        private TbImageView kFK;
        private View kFL;
        private View kFM;
        private View kFN;
        private TBSpecificationBtn kFO;
        private RelativeLayout kFP;
        private TextView kFw;
        private TextView kFx;
        private TextView kFy;
        private TextView kFz;

        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            this.kFw = (TextView) view.findViewById(R.id.bcast_time);
            this.kFx = (TextView) view.findViewById(R.id.forum_name);
            this.kFy = (TextView) view.findViewById(R.id.bcast_title);
            this.kFz = (TextView) view.findViewById(R.id.bcast_content);
            this.kFA = (TextView) view.findViewById(R.id.publish_number);
            this.kFB = (TextView) view.findViewById(R.id.pv_number);
            this.kFC = (TextView) view.findViewById(R.id.ctr_number);
            this.kFF = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kFG = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kFJ = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kFK = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kFL = view.findViewById(R.id.forum_bg_line);
            this.kFH = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kFD = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kFO = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kFI = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kFP = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kFE = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kFN = view.findViewById(R.id.bg_item_mian_view);
            this.kFM = view.findViewById(R.id.gradient_cover);
        }
    }

    public void ey(List<b> list) {
        if (list != null) {
            this.knD = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.knD != null) {
            return this.knD.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.knE = fVar;
    }
}
