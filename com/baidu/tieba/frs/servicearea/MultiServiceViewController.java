package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MultiServiceViewController implements b {
    private FrsViewData jGv;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private List<ab> mDataList = new ArrayList();
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<ServiceViewHolder>() { // from class: com.baidu.tieba.frs.servicearea.MultiServiceViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: E */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.jGv);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i) {
            serviceViewHolder.a((ab) MultiServiceViewController.this.mDataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MultiServiceViewController.this.mDataList.size();
        }
    };

    public MultiServiceViewController(Context context) {
        this.mContext = context;
        this.mRecyclerView = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !y.isEmpty(aaVar.dataList)) {
            this.mDataList = aaVar.dataList;
            this.jGv = frsViewData;
            this.mAdapter.notifyDataSetChanged();
            this.mRecyclerView.setPadding(l.getDimens(this.mRecyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
            this.mRecyclerView.setClipToPadding(false);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRecyclerView;
    }

    /* loaded from: classes2.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout fSq;
        private List<String> jGA;
        private FrsViewData jGv;
        private FrameLayout jGx;
        private TbClipImageView jGy;
        private ab jGz;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.jGA = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.MultiServiceViewController.ServiceViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.equals(view2.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.jGz.imageUrl) || ServiceViewHolder.this.jGv == null || ServiceViewHolder.this.jGv.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.jGv.getForum().getId())) {
                        if (ServiceViewHolder.this.jGz != null && ServiceViewHolder.this.jGz.nvA != null) {
                            TiebaStatic.log(new ar("c13274").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", ServiceViewHolder.this.jGz.forumId).dR("obj_source", "frs_card").dR("obj_id", ServiceViewHolder.this.jGz.nvA.id).dR("obj_name", ServiceViewHolder.this.jGz.nvA.name).ap("obj_param1", ServiceViewHolder.this.jGz.nvA.eEp.intValue()));
                        }
                        d.a(view2.getContext(), ServiceViewHolder.this.jGz);
                        d.c(ServiceViewHolder.this.jGz);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(ServiceViewHolder.this.jGv.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                    ar arVar = new ar("c13666");
                    arVar.dR("fid", ServiceViewHolder.this.jGv.getForum().getId());
                    TiebaStatic.log(arVar);
                }
            };
            Context context = view.getContext();
            this.jGv = frsViewData;
            this.fSq = (LinearLayout) view;
            this.fSq.setGravity(16);
            this.fSq.setOrientation(0);
            this.jGx = new FrameLayout(context);
            this.jGy = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds57);
            this.jGy.setDrawerType(1);
            this.jGy.setIsRound(true);
            this.jGy.setBorderWidth(R.dimen.L_X01);
            this.jGy.setBorderColor(R.color.CAM_X0401);
            this.jGy.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jGy.setPlaceHolder(1);
            this.jGx.addView(this.jGy, new FrameLayout.LayoutParams(dimens, dimens));
            this.fSq.addView(this.jGx, new LinearLayout.LayoutParams(-2, l.getDimens(this.jGy.getContext(), R.dimen.tbds62)));
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.getDimens(context, R.dimen.M_W_X008);
            this.fSq.addView(this.mTextView, layoutParams);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(ab abVar) {
            if (abVar != null) {
                this.jGz = abVar;
                if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jGy.setImageResource(R.drawable.icon_mask_service_celebrity24);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jGy.getLayoutParams();
                    layoutParams.width = l.getDimens(this.jGy.getContext(), R.dimen.tbds62);
                    layoutParams.height = l.getDimens(this.jGy.getContext(), R.dimen.tbds62);
                } else {
                    this.jGy.startLoad(abVar.imageUrl, 10, false);
                }
                this.mTextView.setText(au.cutChineseAndEnglishWithSuffix(abVar.name, 10, ""));
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
                if (!this.jGA.contains(abVar.name)) {
                    d.b(abVar);
                    this.jGA.add(abVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
