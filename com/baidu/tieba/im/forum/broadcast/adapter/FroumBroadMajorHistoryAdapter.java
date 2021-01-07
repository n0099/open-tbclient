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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bd;
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
    private List<b> kjN = new ArrayList();
    private f<b> kjO;
    private final Context mContext;

    public FroumBroadMajorHistoryAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: L */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, final int i) {
        final b bVar = this.kjN.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kBH.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                froumBroadMajorHistoryItemViewHolder.kBH.setLayoutParams(layoutParams);
            }
            if (bd.eb(bVar.cXP() * 1000)) {
                froumBroadMajorHistoryItemViewHolder.kBH.setText(at.dM(bVar.cXP() * 1000));
            } else {
                froumBroadMajorHistoryItemViewHolder.kBH.setText(at.dN(bVar.cXP() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                froumBroadMajorHistoryItemViewHolder.kCa.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kBP.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kBP.setText(bVar.getTitle());
            } else {
                froumBroadMajorHistoryItemViewHolder.kCa.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kBP.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kBJ.setText(bVar.getTitle());
                froumBroadMajorHistoryItemViewHolder.kBV.setConrers(15);
                froumBroadMajorHistoryItemViewHolder.kBV.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                froumBroadMajorHistoryItemViewHolder.kBV.setDrawCorner(true);
                froumBroadMajorHistoryItemViewHolder.kBV.setPlaceHolder(2);
                froumBroadMajorHistoryItemViewHolder.kBV.startLoad(bVar.getPicUrl(), 10, false);
                froumBroadMajorHistoryItemViewHolder.kBV.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                froumBroadMajorHistoryItemViewHolder.kBK.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.kBK.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kBK.setText(bVar.getContent());
            }
            froumBroadMajorHistoryItemViewHolder.kBI.setText(bVar.cXU().forum_name);
            froumBroadMajorHistoryItemViewHolder.kBU.setShowOval(true);
            froumBroadMajorHistoryItemViewHolder.kBU.setAutoChangeStyle(true);
            froumBroadMajorHistoryItemViewHolder.kBU.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            froumBroadMajorHistoryItemViewHolder.kBU.setStrokeColorResId(R.color.CAM_X0401);
            froumBroadMajorHistoryItemViewHolder.kBU.setShowOuterBorder(false);
            froumBroadMajorHistoryItemViewHolder.kBU.setShowInnerBorder(true);
            froumBroadMajorHistoryItemViewHolder.kBU.setPlaceHolder(1);
            froumBroadMajorHistoryItemViewHolder.kBU.startLoad(bVar.cXU().avatar, 10, false);
            froumBroadMajorHistoryItemViewHolder.kBL.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.dY(bVar.cXQ())));
            froumBroadMajorHistoryItemViewHolder.kBM.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.dY(bVar.cXR())));
            int parseFloat = (int) (Float.parseFloat(bVar.cXS()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cXS())) {
                froumBroadMajorHistoryItemViewHolder.kBN.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                froumBroadMajorHistoryItemViewHolder.kBN.setText("0%");
            }
            if (bVar.cXV() != null) {
                if (bVar.cXV().is_deleted.intValue() != 1) {
                    if (bVar.cJF() != 1) {
                        if (bVar.cJF() != 6) {
                            if (bVar.cJF() == 10) {
                                froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kBS.setVisibility(8);
                            }
                        } else {
                            froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kBS.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kBZ.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kBO.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            froumBroadMajorHistoryItemViewHolder.kBZ.setText(this.mContext.getString(R.string.edit));
                            froumBroadMajorHistoryItemViewHolder.kBZ.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.rs(R.color.CAM_X0302);
                            froumBroadMajorHistoryItemViewHolder.kBZ.setConfig(bVar2);
                            froumBroadMajorHistoryItemViewHolder.kBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (FroumBroadMajorHistoryAdapter.this.kjO != null) {
                                        FroumBroadMajorHistoryAdapter.this.kjO.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kBS.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kBZ.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kBO.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    froumBroadMajorHistoryItemViewHolder.kBS.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kBZ.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kBO.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cJF() == 1 || bVar.cJF() == 6) {
                        froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(8);
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(0);
                    }
                }
            } else {
                froumBroadMajorHistoryItemViewHolder.kBS.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kBZ.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kBO.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cJF() == 1 || bVar.cJF() == 6) {
                    froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(8);
                } else {
                    froumBroadMajorHistoryItemViewHolder.kBT.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kBW.setVisibility(0);
                }
            }
            froumBroadMajorHistoryItemViewHolder.kBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FroumBroadMajorHistoryAdapter.this.kjO != null) {
                        FroumBroadMajorHistoryAdapter.this.kjO.a(view, bVar, i, i);
                    }
                }
            });
            a(froumBroadMajorHistoryItemViewHolder, bVar, i);
        }
    }

    private void a(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, b bVar, int i) {
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBH, R.color.CAM_X0109);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBI, R.color.CAM_X0105);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBJ, R.color.CAM_X0101);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBK, R.color.CAM_X0107);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBL, R.color.CAM_X0107);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBM, R.color.CAM_X0107);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBN, R.color.CAM_X0107);
        ao.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.kBW, R.color.CAM_X0203);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBP, R.color.CAM_X0105);
        a.bwV().qq(0).m(R.color.CAM_X0601, R.color.CAM_X0606).ai(l.getDimens(this.mContext, R.dimen.tbds21)).ah(l.getDimens(this.mContext, R.dimen.tbds21)).bz(froumBroadMajorHistoryItemViewHolder.kBX);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kBH.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.kBH.setLayoutParams(layoutParams);
            }
            froumBroadMajorHistoryItemViewHolder.kBR.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.kBY.setVisibility(0);
            a.bwU().qI(R.color.CAM_X0205).qD(l.getDimens(this.mContext, R.dimen.tbds31)).qE(R.color.CAM_X0804).qC(4369).qF(l.getDimens(this.mContext, R.dimen.tbds10)).qG(0).qH(l.getDimens(this.mContext, R.dimen.tbds5)).bz(froumBroadMajorHistoryItemViewHolder.kBY);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kBR.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.kBR.setLayoutParams(layoutParams2);
            froumBroadMajorHistoryItemViewHolder.kBR.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.kBY.setVisibility(8);
            a.bwV().qq(0).qx(l.getDimens(this.mContext, R.dimen.tbds31)).qr(R.color.CAM_X0205).bz(froumBroadMajorHistoryItemViewHolder.kBR);
        }
        if (bVar.cXV() != null) {
            if (bVar.cXV().is_deleted.intValue() != 1) {
                if (bVar.cJF() != 1) {
                    if (bVar.cJF() != 6) {
                        return;
                    }
                    ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBO, R.color.CAM_X0301);
                    return;
                }
                ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBO, R.color.CAM_X0107);
                return;
            }
            ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBO, R.color.CAM_X0109);
            return;
        }
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kBO, R.color.CAM_X0109);
    }

    /* loaded from: classes8.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        private TextView kBH;
        private TextView kBI;
        private TextView kBJ;
        private TextView kBK;
        private TextView kBL;
        private TextView kBM;
        private TextView kBN;
        private TextView kBO;
        private TextView kBP;
        private LinearLayout kBQ;
        private LinearLayout kBR;
        private LinearLayout kBS;
        private LinearLayout kBT;
        private BarImageView kBU;
        private TbImageView kBV;
        private View kBW;
        private View kBX;
        private View kBY;
        private TBSpecificationBtn kBZ;
        private RelativeLayout kCa;

        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            this.kBH = (TextView) view.findViewById(R.id.bcast_time);
            this.kBI = (TextView) view.findViewById(R.id.forum_name);
            this.kBJ = (TextView) view.findViewById(R.id.bcast_title);
            this.kBK = (TextView) view.findViewById(R.id.bcast_content);
            this.kBL = (TextView) view.findViewById(R.id.publish_number);
            this.kBM = (TextView) view.findViewById(R.id.pv_number);
            this.kBN = (TextView) view.findViewById(R.id.ctr_number);
            this.kBQ = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kBR = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kBU = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kBV = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kBW = view.findViewById(R.id.forum_bg_line);
            this.kBS = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kBO = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kBZ = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kBT = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kCa = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kBP = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kBY = view.findViewById(R.id.bg_item_mian_view);
            this.kBX = view.findViewById(R.id.gradient_cover);
        }
    }

    public void eA(List<b> list) {
        if (list != null) {
            this.kjN = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.kjN != null) {
            return this.kjN.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.kjO = fVar;
    }
}
