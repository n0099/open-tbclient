package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import java.util.List;
/* loaded from: classes22.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int jBV;
    private a jBW;

    public void setOnItemCoverListener(f<c> fVar) {
        this.jBW.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.jBV = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.jBW = new a();
        setAdapter(this.jBW);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cKC() != null) {
            this.jBW.dK(dVar.cKC());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            this.jBW.notifyDataSetChanged();
            this.jBV = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> aiM;
        private List<c> jBT;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.aiM = fVar;
        }

        void dK(@NonNull List<c> list) {
            this.jBT = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: C */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.aiM);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.jBT;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.aiM != null) {
                    this.aiM.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.jBT == null) {
                return 0;
            }
            return this.jBT.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> aiM;
        private TextView ajl;
        private TextView ajm;
        private TextView evg;
        private int jBV;
        private View jBX;
        private View jBY;
        private TextView jBZ;
        private ImageView jCa;

        b(View view) {
            super(view);
            this.jBV = 3;
            this.jBX = view.findViewById(R.id.itemLayout);
            this.ajl = (TextView) view.findViewById(R.id.indexView);
            this.evg = (TextView) view.findViewById(R.id.titleView);
            this.ajm = (TextView) view.findViewById(R.id.tagView);
            this.jBY = view.findViewById(R.id.moreLayout);
            this.jBZ = (TextView) view.findViewById(R.id.moreText);
            this.jCa = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.jBS) {
                    this.jBX.setVisibility(8);
                    this.jBY.setVisibility(0);
                    this.jBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.aiM != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.aiM.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.jBX.setVisibility(0);
                this.jBX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.aiM != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.aiM.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.jBY.setVisibility(8);
                if (cVar.index > 0) {
                    this.ajl.setText(String.valueOf(cVar.index));
                    this.ajl.setVisibility(0);
                } else {
                    this.ajl.setVisibility(8);
                }
                this.evg.setText(cVar.eCJ);
                String t = TagTextHelper.t(this.ajm.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.evg.getLayoutParams();
                if (TextUtils.isEmpty(t)) {
                    this.ajm.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.ajm.getContext(), R.dimen.tbds22);
                    this.evg.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.ajm.getContext(), R.dimen.tbds74);
                    this.evg.setLayoutParams(marginLayoutParams);
                    this.ajm.setVisibility(0);
                    this.ajm.setText(t);
                }
                ap.setViewTextColor(this.ajl, TagTextHelper.pe(cVar.index));
                int color = ap.getColor(TagTextHelper.pd(cVar.tag));
                Drawable background = this.ajm.getBackground();
                DrawableCompat.setTint(background, color);
                this.ajm.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.aiM = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.jBV != i) {
                com.baidu.tbadk.core.util.e.a.g(this.jBX, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.g(this.jBY, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                ap.setViewTextColor(this.evg, R.color.cp_cont_b);
                ap.setViewTextColor(this.ajm, R.color.cp_cont_a);
                if (this.jBY.getVisibility() == 0) {
                    ap.setViewTextColor(this.jBZ, R.color.cp_link_tip_a);
                    int color = ap.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.jCa.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.jCa.setImageDrawable(drawable);
                }
                this.jBV = i;
            }
        }
    }
}
