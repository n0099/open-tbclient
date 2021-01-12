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
/* loaded from: classes7.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    private List<b> kfh = new ArrayList();
    private f<b> kfi;
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
        final b bVar = this.kfh.get(i);
        if (bVar != null) {
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kxc.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds62);
                froumBroadMajorHistoryItemViewHolder.kxc.setLayoutParams(layoutParams);
            }
            if (bd.eb(bVar.cTX() * 1000)) {
                froumBroadMajorHistoryItemViewHolder.kxc.setText(at.dM(bVar.cTX() * 1000));
            } else {
                froumBroadMajorHistoryItemViewHolder.kxc.setText(at.dN(bVar.cTX() * 1000));
            }
            if (StringUtils.isNull(bVar.getPicUrl())) {
                froumBroadMajorHistoryItemViewHolder.kxv.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kxk.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kxk.setText(bVar.getTitle());
            } else {
                froumBroadMajorHistoryItemViewHolder.kxv.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kxk.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kxe.setText(bVar.getTitle());
                froumBroadMajorHistoryItemViewHolder.kxq.setConrers(15);
                froumBroadMajorHistoryItemViewHolder.kxq.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
                froumBroadMajorHistoryItemViewHolder.kxq.setDrawCorner(true);
                froumBroadMajorHistoryItemViewHolder.kxq.setPlaceHolder(2);
                froumBroadMajorHistoryItemViewHolder.kxq.startLoad(bVar.getPicUrl(), 10, false);
                froumBroadMajorHistoryItemViewHolder.kxq.setGifIconSupport(false);
            }
            if (StringUtils.isNull(bVar.getContent())) {
                froumBroadMajorHistoryItemViewHolder.kxf.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.kxf.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kxf.setText(bVar.getContent());
            }
            froumBroadMajorHistoryItemViewHolder.kxd.setText(bVar.cUc().forum_name);
            froumBroadMajorHistoryItemViewHolder.kxp.setShowOval(true);
            froumBroadMajorHistoryItemViewHolder.kxp.setAutoChangeStyle(true);
            froumBroadMajorHistoryItemViewHolder.kxp.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
            froumBroadMajorHistoryItemViewHolder.kxp.setStrokeColorResId(R.color.CAM_X0401);
            froumBroadMajorHistoryItemViewHolder.kxp.setShowOuterBorder(false);
            froumBroadMajorHistoryItemViewHolder.kxp.setShowInnerBorder(true);
            froumBroadMajorHistoryItemViewHolder.kxp.setPlaceHolder(1);
            froumBroadMajorHistoryItemViewHolder.kxp.startLoad(bVar.cUc().avatar, 10, false);
            froumBroadMajorHistoryItemViewHolder.kxg.setText(this.mContext.getString(R.string.forum_broadcast_major_history_reacht_number, at.dY(bVar.cTY())));
            froumBroadMajorHistoryItemViewHolder.kxh.setText(this.mContext.getString(R.string.forum_broadcast_major_history_read_number, at.dY(bVar.cTZ())));
            int parseFloat = (int) (Float.parseFloat(bVar.cUa()) * 100.0f);
            if (parseFloat < 0) {
                parseFloat = 0;
            } else if (parseFloat > 100) {
                parseFloat = 100;
            }
            if (!StringUtils.isNull(bVar.cUa())) {
                froumBroadMajorHistoryItemViewHolder.kxi.setText(this.mContext.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
            } else {
                froumBroadMajorHistoryItemViewHolder.kxi.setText("0%");
            }
            if (bVar.cUd() != null) {
                if (bVar.cUd().is_deleted.intValue() != 1) {
                    if (bVar.cFN() != 1) {
                        if (bVar.cFN() != 6) {
                            if (bVar.cFN() == 10) {
                                froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(0);
                                froumBroadMajorHistoryItemViewHolder.kxn.setVisibility(8);
                            }
                        } else {
                            froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(8);
                            froumBroadMajorHistoryItemViewHolder.kxn.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kxu.setVisibility(0);
                            froumBroadMajorHistoryItemViewHolder.kxj.setText(this.mContext.getString(R.string.forum_broadcast_major_history_check_failed));
                            froumBroadMajorHistoryItemViewHolder.kxu.setText(this.mContext.getString(R.string.edit));
                            froumBroadMajorHistoryItemViewHolder.kxu.setTextSize(R.dimen.tbds34);
                            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                            bVar2.pM(R.color.CAM_X0302);
                            froumBroadMajorHistoryItemViewHolder.kxu.setConfig(bVar2);
                            froumBroadMajorHistoryItemViewHolder.kxu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (FroumBroadMajorHistoryAdapter.this.kfi != null) {
                                        FroumBroadMajorHistoryAdapter.this.kfi.a(view, bVar, i, i);
                                    }
                                }
                            });
                        }
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kxn.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kxu.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kxj.setText(this.mContext.getString(R.string.video_review_state));
                    }
                } else {
                    froumBroadMajorHistoryItemViewHolder.kxn.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kxu.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kxj.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                    if (bVar.cFN() == 1 || bVar.cFN() == 6) {
                        froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(8);
                        froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(8);
                    } else {
                        froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(0);
                        froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(0);
                    }
                }
            } else {
                froumBroadMajorHistoryItemViewHolder.kxn.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.kxu.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.kxj.setText(this.mContext.getString(R.string.forum_broadcast_major_history_pb_deleted));
                if (bVar.cFN() == 1 || bVar.cFN() == 6) {
                    froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(8);
                } else {
                    froumBroadMajorHistoryItemViewHolder.kxo.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.kxr.setVisibility(0);
                }
            }
            froumBroadMajorHistoryItemViewHolder.kxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FroumBroadMajorHistoryAdapter.this.kfi != null) {
                        FroumBroadMajorHistoryAdapter.this.kfi.a(view, bVar, i, i);
                    }
                }
            });
            a(froumBroadMajorHistoryItemViewHolder, bVar, i);
        }
    }

    private void a(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, b bVar, int i) {
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxc, R.color.CAM_X0109);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxd, R.color.CAM_X0105);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxe, R.color.CAM_X0101);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxf, R.color.CAM_X0107);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxg, R.color.CAM_X0107);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxh, R.color.CAM_X0107);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxi, R.color.CAM_X0107);
        ao.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.kxr, R.color.CAM_X0203);
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxk, R.color.CAM_X0105);
        a.btb().oJ(0).m(R.color.CAM_X0601, R.color.CAM_X0606).ai(l.getDimens(this.mContext, R.dimen.tbds21)).ah(l.getDimens(this.mContext, R.dimen.tbds21)).bz(froumBroadMajorHistoryItemViewHolder.kxs);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kxc.getLayoutParams();
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.kxc.setLayoutParams(layoutParams);
            }
            froumBroadMajorHistoryItemViewHolder.kxm.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.kxt.setVisibility(0);
            a.bta().pb(R.color.CAM_X0205).oW(l.getDimens(this.mContext, R.dimen.tbds31)).oX(R.color.CAM_X0804).oV(4369).oY(l.getDimens(this.mContext, R.dimen.tbds10)).oZ(0).pa(l.getDimens(this.mContext, R.dimen.tbds5)).bz(froumBroadMajorHistoryItemViewHolder.kxt);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.kxm.getLayoutParams();
            layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.kxm.setLayoutParams(layoutParams2);
            froumBroadMajorHistoryItemViewHolder.kxm.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.kxt.setVisibility(8);
            a.btb().oJ(0).oQ(l.getDimens(this.mContext, R.dimen.tbds31)).oK(R.color.CAM_X0205).bz(froumBroadMajorHistoryItemViewHolder.kxm);
        }
        if (bVar.cUd() != null) {
            if (bVar.cUd().is_deleted.intValue() != 1) {
                if (bVar.cFN() != 1) {
                    if (bVar.cFN() != 6) {
                        return;
                    }
                    ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxj, R.color.CAM_X0301);
                    return;
                }
                ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxj, R.color.CAM_X0107);
                return;
            }
            ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxj, R.color.CAM_X0109);
            return;
        }
        ao.setViewTextColor(froumBroadMajorHistoryItemViewHolder.kxj, R.color.CAM_X0109);
    }

    /* loaded from: classes7.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        private TextView kxc;
        private TextView kxd;
        private TextView kxe;
        private TextView kxf;
        private TextView kxg;
        private TextView kxh;
        private TextView kxi;
        private TextView kxj;
        private TextView kxk;
        private LinearLayout kxl;
        private LinearLayout kxm;
        private LinearLayout kxn;
        private LinearLayout kxo;
        private BarImageView kxp;
        private TbImageView kxq;
        private View kxr;
        private View kxs;
        private View kxt;
        private TBSpecificationBtn kxu;
        private RelativeLayout kxv;

        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            this.kxc = (TextView) view.findViewById(R.id.bcast_time);
            this.kxd = (TextView) view.findViewById(R.id.forum_name);
            this.kxe = (TextView) view.findViewById(R.id.bcast_title);
            this.kxf = (TextView) view.findViewById(R.id.bcast_content);
            this.kxg = (TextView) view.findViewById(R.id.publish_number);
            this.kxh = (TextView) view.findViewById(R.id.pv_number);
            this.kxi = (TextView) view.findViewById(R.id.ctr_number);
            this.kxl = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.kxm = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.kxp = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.kxq = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kxr = view.findViewById(R.id.forum_bg_line);
            this.kxn = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.kxj = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.kxu = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.kxo = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.kxv = (RelativeLayout) view.findViewById(R.id.container_image);
            this.kxk = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.kxt = view.findViewById(R.id.bg_item_mian_view);
            this.kxs = view.findViewById(R.id.gradient_cover);
        }
    }

    public void eA(List<b> list) {
        if (list != null) {
            this.kfh = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.kfh != null) {
            return this.kfh.size();
        }
        return 0;
    }

    public void a(f<b> fVar) {
        this.kfi = fVar;
    }
}
