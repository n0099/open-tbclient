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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MultiServiceViewController implements b {
    private FrsViewData jFx;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private List<ab> mDataList = new ArrayList();
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<ServiceViewHolder>() { // from class: com.baidu.tieba.frs.servicearea.MultiServiceViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: D */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.jFx);
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
        if (aaVar != null && !x.isEmpty(aaVar.dataList)) {
            this.mDataList = aaVar.dataList;
            this.jFx = frsViewData;
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
        private LinearLayout fUK;
        private TbClipImageView jFA;
        private ab jFB;
        private List<String> jFC;
        private FrsViewData jFx;
        private FrameLayout jFz;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.jFC = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.MultiServiceViewController.ServiceViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.equals(view2.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.jFB.imageUrl) || ServiceViewHolder.this.jFx == null || ServiceViewHolder.this.jFx.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.jFx.getForum().getId())) {
                        if (ServiceViewHolder.this.jFB != null && ServiceViewHolder.this.jFB.nqy != null) {
                            TiebaStatic.log(new aq("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("fid", ServiceViewHolder.this.jFB.forumId).dX("obj_source", "frs_card").dX("obj_id", ServiceViewHolder.this.jFB.nqy.id).dX("obj_name", ServiceViewHolder.this.jFB.nqy.name).an("obj_param1", ServiceViewHolder.this.jFB.nqy.eGU.intValue()));
                        }
                        d.a(view2.getContext(), ServiceViewHolder.this.jFB);
                        d.c(ServiceViewHolder.this.jFB);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(ServiceViewHolder.this.jFx.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                    aq aqVar = new aq("c13666");
                    aqVar.dX("fid", ServiceViewHolder.this.jFx.getForum().getId());
                    TiebaStatic.log(aqVar);
                }
            };
            Context context = view.getContext();
            this.jFx = frsViewData;
            this.fUK = (LinearLayout) view;
            this.fUK.setGravity(16);
            this.fUK.setOrientation(0);
            this.jFz = new FrameLayout(context);
            this.jFA = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds57);
            this.jFA.setDrawerType(1);
            this.jFA.setIsRound(true);
            this.jFA.setBorderWidth(R.dimen.L_X01);
            this.jFA.setBorderColor(R.color.CAM_X0401);
            this.jFA.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jFA.setPlaceHolder(1);
            this.jFz.addView(this.jFA, new FrameLayout.LayoutParams(dimens, dimens));
            this.fUK.addView(this.jFz, new LinearLayout.LayoutParams(-2, l.getDimens(this.jFA.getContext(), R.dimen.tbds62)));
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.getDimens(context, R.dimen.M_W_X008);
            this.fUK.addView(this.mTextView, layoutParams);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(ab abVar) {
            if (abVar != null) {
                this.jFB = abVar;
                if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jFA.setImageResource(R.drawable.icon_mask_service_celebrity24);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jFA.getLayoutParams();
                    layoutParams.width = l.getDimens(this.jFA.getContext(), R.dimen.tbds62);
                    layoutParams.height = l.getDimens(this.jFA.getContext(), R.dimen.tbds62);
                } else {
                    this.jFA.startLoad(abVar.imageUrl, 10, false);
                }
                this.mTextView.setText(at.cutChineseAndEnglishWithSuffix(abVar.name, 10, ""));
                ao.setViewTextColor(this.mTextView, R.color.CAM_X0105);
                if (!this.jFC.contains(abVar.name)) {
                    d.b(abVar);
                    this.jFC.add(abVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
