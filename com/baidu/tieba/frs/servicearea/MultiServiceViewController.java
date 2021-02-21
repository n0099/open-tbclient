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
    private FrsViewData jGJ;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private List<ab> mDataList = new ArrayList();
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<ServiceViewHolder>() { // from class: com.baidu.tieba.frs.servicearea.MultiServiceViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: E */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.jGJ);
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
            this.jGJ = frsViewData;
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
        private FrsViewData jGJ;
        private FrameLayout jGL;
        private TbClipImageView jGM;
        private ab jGN;
        private List<String> jGO;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.jGO = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.MultiServiceViewController.ServiceViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.equals(view2.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.jGN.imageUrl) || ServiceViewHolder.this.jGJ == null || ServiceViewHolder.this.jGJ.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.jGJ.getForum().getId())) {
                        if (ServiceViewHolder.this.jGN != null && ServiceViewHolder.this.jGN.nwa != null) {
                            TiebaStatic.log(new ar("c13274").v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", ServiceViewHolder.this.jGN.forumId).dR("obj_source", "frs_card").dR("obj_id", ServiceViewHolder.this.jGN.nwa.id).dR("obj_name", ServiceViewHolder.this.jGN.nwa.name).ap("obj_param1", ServiceViewHolder.this.jGN.nwa.eEp.intValue()));
                        }
                        d.a(view2.getContext(), ServiceViewHolder.this.jGN);
                        d.c(ServiceViewHolder.this.jGN);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(ServiceViewHolder.this.jGJ.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                    ar arVar = new ar("c13666");
                    arVar.dR("fid", ServiceViewHolder.this.jGJ.getForum().getId());
                    TiebaStatic.log(arVar);
                }
            };
            Context context = view.getContext();
            this.jGJ = frsViewData;
            this.fSq = (LinearLayout) view;
            this.fSq.setGravity(16);
            this.fSq.setOrientation(0);
            this.jGL = new FrameLayout(context);
            this.jGM = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds57);
            this.jGM.setDrawerType(1);
            this.jGM.setIsRound(true);
            this.jGM.setBorderWidth(R.dimen.L_X01);
            this.jGM.setBorderColor(R.color.CAM_X0401);
            this.jGM.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jGM.setPlaceHolder(1);
            this.jGL.addView(this.jGM, new FrameLayout.LayoutParams(dimens, dimens));
            this.fSq.addView(this.jGL, new LinearLayout.LayoutParams(-2, l.getDimens(this.jGM.getContext(), R.dimen.tbds62)));
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
                this.jGN = abVar;
                if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jGM.setImageResource(R.drawable.icon_mask_service_celebrity24);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jGM.getLayoutParams();
                    layoutParams.width = l.getDimens(this.jGM.getContext(), R.dimen.tbds62);
                    layoutParams.height = l.getDimens(this.jGM.getContext(), R.dimen.tbds62);
                } else {
                    this.jGM.startLoad(abVar.imageUrl, 10, false);
                }
                this.mTextView.setText(au.cutChineseAndEnglishWithSuffix(abVar.name, 10, ""));
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
                if (!this.jGO.contains(abVar.name)) {
                    d.b(abVar);
                    this.jGO.add(abVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
