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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c implements b {
    private RecyclerView mRecyclerView;
    private List<z> mDataList = new ArrayList();
    private boolean ibV = false;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.frs.servicearea.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: v */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            int i2 = 0;
            if (c.this.ibV) {
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
        if (yVar != null && !x.isEmpty(yVar.dataList)) {
            this.mDataList = yVar.dataList;
            this.mAdapter.notifyDataSetChanged();
            this.ibV = yVar.lMi == 4 || yVar.lMi == 5;
            if (!this.ibV) {
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
        private LinearLayout ePK;
        private FrameLayout ibX;
        private TbClipImageView ibY;
        private View ibZ;
        private z ica;
        private List<String> icb;
        private View.OnClickListener mOnClickListener;
        private TextView mTextView;

        public a(View view, int i) {
            super(view);
            this.icb = new ArrayList();
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ica != null && a.this.ica.lMj != null) {
                        TiebaStatic.log(new ap("c13274").t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("fid", a.this.ica.forumId).dn("obj_source", "frs_card").dn("obj_id", a.this.ica.lMj.id).dn("obj_name", a.this.ica.lMj.name).ah("obj_param1", a.this.ica.lMj.dGy.intValue()));
                    }
                    e.a(view2.getContext(), a.this.ica, a.this.ibZ);
                    e.c(a.this.ica);
                }
            };
            Context context = view.getContext();
            this.ePK = (LinearLayout) view;
            this.ePK.setGravity(1);
            this.ePK.setOrientation(1);
            this.ibX = new FrameLayout(context);
            this.ibY = new TbClipImageView(context);
            int dimens = l.getDimens(context, R.dimen.tbds94);
            int dimens2 = i > 0 ? (i - dimens) / 2 : l.getDimens(context, R.dimen.tbds53);
            this.ibY.setDrawerType(1);
            this.ibY.setIsRound(true);
            this.ibY.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ibY.setPlaceHolder(1);
            this.ibX.addView(this.ibY, new FrameLayout.LayoutParams(dimens, dimens));
            this.ibZ = new View(context);
            int dimens3 = l.getDimens(context, R.dimen.tbds20);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens3, dimens3);
            layoutParams.gravity = 5;
            this.ibX.addView(this.ibZ, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = dimens2;
            layoutParams2.rightMargin = dimens2;
            this.ePK.addView(this.ibX, layoutParams2);
            this.mTextView = new TextView(context);
            this.mTextView.setTextSize(0, l.getDimens(context, R.dimen.tbfontsize31));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds16);
            this.ePK.addView(this.mTextView, layoutParams3);
            view.setOnClickListener(this.mOnClickListener);
        }

        public void a(z zVar) {
            if (zVar != null) {
                this.ica = zVar;
                this.ibY.startLoad(zVar.imageUrl, 10, false);
                this.mTextView.setText(as.cutChineseAndEnglishWithSuffix(zVar.name, 8, ""));
                ao.setViewTextColor(this.mTextView, R.color.cp_cont_b);
                ao.setBackgroundColor(this.itemView, R.color.cp_bg_line_d);
                this.ibZ.setBackground(ao.getDrawable(R.drawable.frs_service_red_dot));
                this.ibZ.setVisibility(zVar.hiL ? 0 : 8);
                if (!this.icb.contains(zVar.name)) {
                    e.b(zVar);
                    this.icb.add(zVar.name);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        this.mAdapter.notifyDataSetChanged();
    }
}
