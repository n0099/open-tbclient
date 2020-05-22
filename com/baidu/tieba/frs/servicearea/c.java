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
    private boolean hHV = false;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.frs.servicearea.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: u */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            int i2 = 0;
            if (c.this.hHV) {
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
            this.hHV = yVar.ljO == 4 || yVar.ljO == 5;
            if (!this.hHV) {
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
        private LinearLayout ezO;
        private FrameLayout hHX;
        private TbClipImageView hHY;
        private View hHZ;
        private z hIa;
        private List<String> hIb;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public a(View view, int i) {
            super(view);
            this.hIb = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.a(view2.getContext(), a.this.hIa, a.this.hHZ);
                    e.c(a.this.hIa);
                }
            };
            Context context = view.getContext();
            this.ezO = (LinearLayout) view;
            this.ezO.setGravity(1);
            this.ezO.setOrientation(1);
            this.hHX = new FrameLayout(context);
            this.hHY = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds94);
            int dimens2 = i > 0 ? (i - dimens) / 2 : l.getDimens(context, R.dimen.tbds53);
            this.hHY.setDrawerType(1);
            this.hHY.setIsRound(true);
            this.hHY.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hHY.setPlaceHolder(1);
            this.hHX.addView(this.hHY, new FrameLayout.LayoutParams(dimens, dimens));
            this.hHZ = new View(context);
            int dimens3 = l.getDimens(context, R.dimen.tbds20);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens3, dimens3);
            layoutParams.gravity = 5;
            this.hHX.addView(this.hHZ, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = dimens2;
            layoutParams2.rightMargin = dimens2;
            this.ezO.addView(this.hHX, layoutParams2);
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.tbfontsize31));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds16);
            this.ezO.addView(this.mTextView, layoutParams3);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(z zVar) {
            if (zVar != null) {
                this.hIa = zVar;
                this.hHY.startLoad(zVar.imageUrl, 10, false);
                this.mTextView.setText(aq.cutChineseAndEnglishWithSuffix(zVar.name, 8, ""));
                am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
                am.setBackgroundColor(this.itemView, R.color.cp_bg_line_d);
                this.hHZ.setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
                this.hHZ.setVisibility(zVar.gQh ? 0 : 8);
                if (!this.hIb.contains(zVar.name)) {
                    e.b(zVar);
                    this.hIb.add(zVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
