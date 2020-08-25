package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c implements b {
    private RecyclerView mRecyclerView;
    private List<aa> mDataList = new ArrayList();
    private boolean iqc = false;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.frs.servicearea.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: v */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            int i2 = 0;
            if (c.this.iqc) {
                i2 = l.getEquipmentWidth(viewGroup.getContext()) / getItemCount();
            }
            return new a(new LinearLayout(viewGroup.getContext()), i2);
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
        this.mRecyclerView = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        if (zVar != null && !y.isEmpty(zVar.dataList)) {
            this.mDataList = zVar.dataList;
            this.mAdapter.notifyDataSetChanged();
            this.iqc = zVar.mdS == 4 || zVar.mdS == 5;
            if (!this.iqc) {
                this.mRecyclerView.setPadding(l.getDimens(this.mRecyclerView.getContext(), R.dimen.tbds3), 0, 0, 0);
                this.mRecyclerView.setClipToPadding(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRecyclerView;
    }

    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.ViewHolder {
        private LinearLayout faq;
        private FrameLayout iqe;
        private TbClipImageView iqf;
        private View iqg;
        private aa iqh;
        private List<String> iqi;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public a(View view, int i) {
            super(view);
            this.iqi = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iqh != null && a.this.iqh.mdT != null) {
                        TiebaStatic.log(new aq("c13274").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", a.this.iqh.forumId).dD("obj_source", "frs_card").dD("obj_id", a.this.iqh.mdT.id).dD("obj_name", a.this.iqh.mdT.name).ai("obj_param1", a.this.iqh.mdT.dPG.intValue()));
                    }
                    e.a(view2.getContext(), a.this.iqh, a.this.iqg);
                    e.c(a.this.iqh);
                }
            };
            Context context = view.getContext();
            this.faq = (LinearLayout) view;
            this.faq.setGravity(1);
            this.faq.setOrientation(1);
            this.iqe = new FrameLayout(context);
            this.iqf = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds94);
            int dimens2 = i > 0 ? (i - dimens) / 2 : l.getDimens(context, R.dimen.tbds53);
            this.iqf.setDrawerType(1);
            this.iqf.setIsRound(true);
            this.iqf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iqf.setPlaceHolder(1);
            this.iqe.addView(this.iqf, new FrameLayout.LayoutParams(dimens, dimens));
            this.iqg = new View(context);
            int dimens3 = l.getDimens(context, R.dimen.tbds20);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens3, dimens3);
            layoutParams.gravity = 5;
            this.iqe.addView(this.iqg, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = dimens2;
            layoutParams2.rightMargin = dimens2;
            this.faq.addView(this.iqe, layoutParams2);
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.tbfontsize31));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds16);
            this.faq.addView(this.mTextView, layoutParams3);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(aa aaVar) {
            if (aaVar != null) {
                this.iqh = aaVar;
                this.iqf.startLoad(aaVar.imageUrl, 10, false);
                this.mTextView.setText(at.cutChineseAndEnglishWithSuffix(aaVar.name, 8, ""));
                ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
                ap.setBackgroundColor(this.itemView, R.color.cp_bg_line_d);
                this.iqg.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
                this.iqg.setVisibility(aaVar.hvJ ? 0 : 8);
                if (!this.iqi.contains(aaVar.name)) {
                    e.b(aaVar);
                    this.iqi.add(aaVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
