package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tieba.tbadkCore.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class c implements b {
    private FrsViewData jfx;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private List<aa> mDataList = new ArrayList();
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.frs.servicearea.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: z */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(new LinearLayout(viewGroup.getContext()), c.this.jfx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.a((aa) c.this.mDataList.get(i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return c.this.mDataList.size();
        }
    };

    public c(Context context) {
        this.mContext = context;
        this.mRecyclerView = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar, FrsViewData frsViewData) {
        if (zVar != null && !y.isEmpty(zVar.dataList)) {
            this.mDataList = zVar.dataList;
            this.jfx = frsViewData;
            this.mAdapter.notifyDataSetChanged();
            this.mRecyclerView.setPadding(l.getDimens(this.mRecyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
            this.mRecyclerView.setClipToPadding(false);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRecyclerView;
    }

    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.ViewHolder {
        private LinearLayout fDs;
        private TbClipImageView jfA;
        private aa jfB;
        private List<String> jfC;
        private FrsViewData jfx;
        private FrameLayout jfz;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public a(View view, FrsViewData frsViewData) {
            super(view);
            this.jfC = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.equals(view2.getResources().getString(R.string.hot_user_rank), a.this.jfB.imageUrl) || a.this.jfx == null || a.this.jfx.getForum() == null || TextUtils.isEmpty(a.this.jfx.getForum().getId())) {
                        if (a.this.jfB != null && a.this.jfB.mWQ != null) {
                            TiebaStatic.log(new ar("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", a.this.jfB.forumId).dR("obj_source", "frs_card").dR("obj_id", a.this.jfB.mWQ.id).dR("obj_name", a.this.jfB.mWQ.name).ak("obj_param1", a.this.jfB.mWQ.eqD.intValue()));
                        }
                        e.a(view2.getContext(), a.this.jfB);
                        e.c(a.this.jfB);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(a.this.jfx.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                    ar arVar = new ar("c13666");
                    arVar.dR("fid", a.this.jfx.getForum().getId());
                    TiebaStatic.log(arVar);
                }
            };
            Context context = view.getContext();
            this.jfx = frsViewData;
            this.fDs = (LinearLayout) view;
            this.fDs.setGravity(16);
            this.fDs.setOrientation(0);
            this.jfz = new FrameLayout(context);
            this.jfA = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds57);
            this.jfA.setDrawerType(1);
            this.jfA.setIsRound(true);
            this.jfA.setBorderWidth(R.dimen.L_X01);
            this.jfA.setBorderColor(R.color.CAM_X0401);
            this.jfA.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jfA.setPlaceHolder(1);
            this.jfz.addView(this.jfA, new FrameLayout.LayoutParams(dimens, dimens));
            this.fDs.addView(this.jfz, new LinearLayout.LayoutParams(-2, l.getDimens(this.jfA.getContext(), R.dimen.tbds62)));
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.getDimens(context, R.dimen.M_W_X008);
            this.fDs.addView(this.mTextView, layoutParams);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(aa aaVar) {
            if (aaVar != null) {
                this.jfB = aaVar;
                if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), aaVar.imageUrl)) {
                    this.jfA.setImageResource(R.drawable.icon_mask_service_celebrity24);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jfA.getLayoutParams();
                    layoutParams.width = l.getDimens(this.jfA.getContext(), R.dimen.tbds62);
                    layoutParams.height = l.getDimens(this.jfA.getContext(), R.dimen.tbds62);
                } else {
                    this.jfA.startLoad(aaVar.imageUrl, 10, false);
                }
                this.mTextView.setText(au.cutChineseAndEnglishWithSuffix(aaVar.name, 10, ""));
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
                if (!this.jfC.contains(aaVar.name)) {
                    e.b(aaVar);
                    this.jfC.add(aaVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
