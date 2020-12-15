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
import com.baidu.tieba.tbadkCore.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c implements b {
    private FrsViewData jtc;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private List<ab> mDataList = new ArrayList();
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.frs.servicearea.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: z */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(new LinearLayout(viewGroup.getContext()), c.this.jtc);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.a((ab) c.this.mDataList.get(i));
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
    public void setData(aa aaVar, FrsViewData frsViewData) {
        if (aaVar != null && !y.isEmpty(aaVar.dataList)) {
            this.mDataList = aaVar.dataList;
            this.jtc = frsViewData;
            this.mAdapter.notifyDataSetChanged();
            this.mRecyclerView.setPadding(l.getDimens(this.mRecyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
            this.mRecyclerView.setClipToPadding(false);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRecyclerView;
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        private LinearLayout fLe;
        private FrsViewData jtc;
        private FrameLayout jte;
        private TbClipImageView jtf;
        private ab jtg;
        private List<String> jth;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public a(View view, FrsViewData frsViewData) {
            super(view);
            this.jth = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!TextUtils.equals(view2.getResources().getString(R.string.hot_user_rank), a.this.jtg.imageUrl) || a.this.jtc == null || a.this.jtc.getForum() == null || TextUtils.isEmpty(a.this.jtc.getForum().getId())) {
                        if (a.this.jtg != null && a.this.jtg.nkQ != null) {
                            TiebaStatic.log(new ar("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fid", a.this.jtg.forumId).dY("obj_source", "frs_card").dY("obj_id", a.this.jtg.nkQ.id).dY("obj_name", a.this.jtg.nkQ.name).al("obj_param1", a.this.jtg.nkQ.exF.intValue()));
                        }
                        e.a(view2.getContext(), a.this.jtg);
                        e.c(a.this.jtg);
                        return;
                    }
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(a.this.jtc.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                    ar arVar = new ar("c13666");
                    arVar.dY("fid", a.this.jtc.getForum().getId());
                    TiebaStatic.log(arVar);
                }
            };
            Context context = view.getContext();
            this.jtc = frsViewData;
            this.fLe = (LinearLayout) view;
            this.fLe.setGravity(16);
            this.fLe.setOrientation(0);
            this.jte = new FrameLayout(context);
            this.jtf = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds57);
            this.jtf.setDrawerType(1);
            this.jtf.setIsRound(true);
            this.jtf.setBorderWidth(R.dimen.L_X01);
            this.jtf.setBorderColor(R.color.CAM_X0401);
            this.jtf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jtf.setPlaceHolder(1);
            this.jte.addView(this.jtf, new FrameLayout.LayoutParams(dimens, dimens));
            this.fLe.addView(this.jte, new LinearLayout.LayoutParams(-2, l.getDimens(this.jtf.getContext(), R.dimen.tbds62)));
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.getDimens(context, R.dimen.M_W_X008);
            this.fLe.addView(this.mTextView, layoutParams);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(ab abVar) {
            if (abVar != null) {
                this.jtg = abVar;
                if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), abVar.imageUrl)) {
                    this.jtf.setImageResource(R.drawable.icon_mask_service_celebrity24);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jtf.getLayoutParams();
                    layoutParams.width = l.getDimens(this.jtf.getContext(), R.dimen.tbds62);
                    layoutParams.height = l.getDimens(this.jtf.getContext(), R.dimen.tbds62);
                } else {
                    this.jtf.startLoad(abVar.imageUrl, 10, false);
                }
                this.mTextView.setText(au.cutChineseAndEnglishWithSuffix(abVar.name, 10, ""));
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
                if (!this.jth.contains(abVar.name)) {
                    e.b(abVar);
                    this.jth.add(abVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
