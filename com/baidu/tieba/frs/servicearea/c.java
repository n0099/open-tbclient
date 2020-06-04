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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements b {
    private RecyclerView mRecyclerView;
    private List<z> mDataList = new ArrayList();
    private boolean hII = false;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.frs.servicearea.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: u */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            int i2 = 0;
            if (c.this.hII) {
                i2 = l.getEquipmentWidth(viewGroup.getContext()) / getItemCount();
            }
            return new a(new LinearLayout(viewGroup.getContext()), i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.a((z) c.this.mDataList.get(i));
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
    public void setData(y yVar) {
        if (yVar != null && !v.isEmpty(yVar.dataList)) {
            this.mDataList = yVar.dataList;
            this.mAdapter.notifyDataSetChanged();
            this.hII = yVar.lkX == 4 || yVar.lkX == 5;
            if (!this.hII) {
                this.mRecyclerView.setPadding(l.getDimens(this.mRecyclerView.getContext(), R.dimen.tbds3), 0, 0, 0);
                this.mRecyclerView.setClipToPadding(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRecyclerView;
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private LinearLayout ezZ;
        private FrameLayout hIK;
        private TbClipImageView hIL;
        private View hIM;
        private z hIN;
        private List<String> hIO;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public a(View view, int i) {
            super(view);
            this.hIO = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.a(view2.getContext(), a.this.hIN, a.this.hIM);
                    e.c(a.this.hIN);
                }
            };
            Context context = view.getContext();
            this.ezZ = (LinearLayout) view;
            this.ezZ.setGravity(1);
            this.ezZ.setOrientation(1);
            this.hIK = new FrameLayout(context);
            this.hIL = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds94);
            int dimens2 = i > 0 ? (i - dimens) / 2 : l.getDimens(context, R.dimen.tbds53);
            this.hIL.setDrawerType(1);
            this.hIL.setIsRound(true);
            this.hIL.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hIL.setPlaceHolder(1);
            this.hIK.addView(this.hIL, new FrameLayout.LayoutParams(dimens, dimens));
            this.hIM = new View(context);
            int dimens3 = l.getDimens(context, R.dimen.tbds20);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens3, dimens3);
            layoutParams.gravity = 5;
            this.hIK.addView(this.hIM, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = dimens2;
            layoutParams2.rightMargin = dimens2;
            this.ezZ.addView(this.hIK, layoutParams2);
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.tbfontsize31));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds16);
            this.ezZ.addView(this.mTextView, layoutParams3);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(z zVar) {
            if (zVar != null) {
                this.hIN = zVar;
                this.hIL.startLoad(zVar.imageUrl, 10, false);
                this.mTextView.setText(aq.cutChineseAndEnglishWithSuffix(zVar.name, 8, ""));
                am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
                am.setBackgroundColor(this.itemView, R.color.cp_bg_line_d);
                this.hIM.setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
                this.hIM.setVisibility(zVar.gQs ? 0 : 8);
                if (!this.hIO.contains(zVar.name)) {
                    e.b(zVar);
                    this.hIO.add(zVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
