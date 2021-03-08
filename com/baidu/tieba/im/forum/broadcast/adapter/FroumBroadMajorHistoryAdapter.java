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
/* loaded from: classes7.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    private List<b> kpF = new ArrayList();
    private f<b> kpG;
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
        final b bVar = this.kpF.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kHy.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                froumBroadMajorHistoryItemViewHolder.kHy.setLayoutParams(layoutParams);
            }
            if (be.eh(bVar.cWj() * 1000)) {
                froumBroadMajorHistoryItemViewHolder.kHy.setText(au.dS(bVar.cWj() * 1000));
            } else {
                froumBroadMajorHistoryItemViewHolder.kHy.setText(au.dT(bVar.cWj() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                froumBroadMajorHistoryItemViewHolder.kHR.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kHG.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kHG.setText(bVar.getTitle());
            } else {
                froumBroadMajorHistoryItemViewHolder.kHR.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kHG.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kHA.setText(bVar.getTitle());
                froumBroadMajorHistoryItemViewHolder.kHM.setConrers(15);
                froumBroadMajorHistoryItemViewHolder.kHM.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                froumBroadMajorHistoryItemViewHolder.kHM.setDrawCorner(true);
                froumBroadMajorHistoryItemViewHolder.kHM.setPlaceHolder(2);
                froumBroadMajorHistoryItemViewHolder.kHM.startLoad(bVar.getPicUrl(), 10, false);
                froumBroadMajorHistoryItemViewHolder.kHM.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                froumBroadMajorHistoryItemViewHolder.kHB.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.kHB.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kHB.setText(bVar.getContent());
            }
            froumBroadMajorHistoryItemViewHolder.kHz.setText(bVar.cWo().forum_name);
            froumBroadMajorHistoryItemViewHolder.kHL.setShowOval(true);
            froumBroadMajorHistoryItemViewHolder.kHL.setAutoChangeStyle(true);
            froumBroadMajorHistoryItemViewHolder.kHL.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            froumBroadMajorHistoryItemViewHolder.kHL.setStrokeColorResId(R.color.CAM_X0401);
            froumBroadMajorHistoryItemViewHolder.kHL.setShowOuterBorder(false);
            froumBroadMajorHistoryItemViewHolder.kHL.setShowInnerBorder(true);
            froumBroadMajorHistoryItemViewHolder.kHL.setPlaceHolder(1);
            froumBroadMajorHistoryItemViewHolder.kHL.startLoad(bVar.cWo().avatar, 10, false);
            froumBroadMajorHistoryItemViewHolder.kHC.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, au.ee(bVar.cWk())));
            froumBroadMajorHistoryItemViewHolder.kHD.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, au.ee(bVar.cWl())));
            int parseFloat = (int) (Float.parseFloat(bVar.cWm()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cWm())) {
                froumBroadMajorHistoryItemViewHolder.kHE.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                froumBroadMajorHistoryItemViewHolder.kHE.setText("0%");
            }
            if (bVar.cWp() != null) {
                if (bVar.cWp().is_deleted.intValue() != 1) {
                    if (bVar.cHn() != 1) {
                        if (bVar.cHn() != 6) {
                            if (bVar.cHn() == 10) {
                                froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kHJ.setVisibility(8);
                            }
                        } else {
                            froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kHJ.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kHQ.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kHF.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            froumBroadMajorHistoryItemViewHolder.kHQ.setText(this.mContext.getString(R.string.edit));
                            froumBroadMajorHistoryItemViewHolder.kHQ.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pS(R.color.CAM_X0302);
                            froumBroadMajorHistoryItemViewHolder.kHQ.setConfig(bVar2);
                            froumBroadMajorHistoryItemViewHolder.kHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (FroumBroadMajorHistoryAdapter.this.kpG != null) {
                                        FroumBroadMajorHistoryAdapter.this.kpG.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kHJ.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kHQ.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kHF.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    froumBroadMajorHistoryItemViewHolder.kHJ.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kHQ.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kHF.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cHn() == 1 || bVar.cHn() == 6) {
                        froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(8);
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(0);
                    }
                }
            } else {
                froumBroadMajorHistoryItemViewHolder.kHJ.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kHQ.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kHF.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cHn() == 1 || bVar.cHn() == 6) {
                    froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(8);
                } else {
                    froumBroadMajorHistoryItemViewHolder.kHK.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kHN.setVisibility(0);
                }
            }
            froumBroadMajorHistoryItemViewHolder.kHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FroumBroadMajorHistoryAdapter.this.kpG != null) {
                        FroumBroadMajorHistoryAdapter.this.kpG.a(view, bVar, i, i);
                    }
                }
            });
            a(froumBroadMajorHistoryItemViewHolder, bVar, i);
        }
    }

    private void a(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, b bVar, int i) {
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHy, R.color.CAM_X0109);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHz, R.color.CAM_X0105);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHA, R.color.CAM_X0101);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHB, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHC, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHD, R.color.CAM_X0107);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHE, R.color.CAM_X0107);
        ap.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.kHN, R.color.CAM_X0203);
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHG, R.color.CAM_X0105);
        a.bty().oP(0).m(R.color.CAM_X0601, R.color.CAM_X0606).an(l.getDimens(this.mContext, R.dimen.tbds21)).am(l.getDimens(this.mContext, R.dimen.tbds21)).bv(froumBroadMajorHistoryItemViewHolder.kHO);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kHy.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.kHy.setLayoutParams(layoutParams);
            }
            froumBroadMajorHistoryItemViewHolder.kHI.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.kHP.setVisibility(0);
            a.btx().ph(R.color.CAM_X0205).pc(l.getDimens(this.mContext, R.dimen.tbds31)).pd(R.color.CAM_X0804).pb(4369).pe(l.getDimens(this.mContext, R.dimen.tbds10)).pf(0).pg(l.getDimens(this.mContext, R.dimen.tbds5)).bv(froumBroadMajorHistoryItemViewHolder.kHP);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kHI.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.kHI.setLayoutParams(layoutParams2);
            froumBroadMajorHistoryItemViewHolder.kHI.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.kHP.setVisibility(8);
            a.bty().oP(0).oW(l.getDimens(this.mContext, R.dimen.tbds31)).oQ(R.color.CAM_X0205).bv(froumBroadMajorHistoryItemViewHolder.kHI);
        }
        if (bVar.cWp() != null) {
            if (bVar.cWp().is_deleted.intValue() != 1) {
                if (bVar.cHn() != 1) {
                    if (bVar.cHn() != 6) {
                        return;
                    }
                    ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHF, R.color.CAM_X0301);
                    return;
                }
                ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHF, R.color.CAM_X0107);
                return;
            }
            ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHF, R.color.CAM_X0109);
            return;
        }
        ap.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kHF, R.color.CAM_X0109);
    }

    /* loaded from: classes7.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        private TextView kHA;
        private TextView kHB;
        private TextView kHC;
        private TextView kHD;
        private TextView kHE;
        private TextView kHF;
        private TextView kHG;
        private LinearLayout kHH;
        private LinearLayout kHI;
        private LinearLayout kHJ;
        private LinearLayout kHK;
        private BarImageView kHL;
        private TbImageView kHM;
        private View kHN;
        private View kHO;
        private View kHP;
        private TBSpecificationBtn kHQ;
        private RelativeLayout kHR;
        private TextView kHy;
        private TextView kHz;

        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            this.kHy = (TextView) view.findViewById(R.id.bcast_time);
            this.kHz = (TextView) view.findViewById(R.id.forum_name);
            this.kHA = (TextView) view.findViewById(R.id.bcast_title);
            this.kHB = (TextView) view.findViewById(R.id.bcast_content);
            this.kHC = (TextView) view.findViewById(R.id.publish_number);
            this.kHD = (TextView) view.findViewById(R.id.pv_number);
            this.kHE = (TextView) view.findViewById(R.id.ctr_number);
            this.kHH = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kHI = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kHL = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kHM = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kHN = view.findViewById(R.id.forum_bg_line);
            this.kHJ = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kHF = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kHQ = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kHK = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kHR = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kHG = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kHP = view.findViewById(R.id.bg_item_mian_view);
            this.kHO = view.findViewById(R.id.gradient_cover);
        }
    }

    public void ey(List<b> list) {
        if (list != null) {
            this.kpF = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.kpF != null) {
            return this.kpF.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.kpG = fVar;
    }
}
