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
/* loaded from: classes16.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int iLR;
    private a iLS;

    public void setOnItemCoverListener(f<c> fVar) {
        this.iLS.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.iLR = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.iLS = new a();
        setAdapter(this.iLS);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cxE() != null) {
            this.iLS.di(dVar.cxE());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            this.iLS.notifyDataSetChanged();
            this.iLR = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> ahW;
        private List<c> iLP;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.ahW = fVar;
        }

        void di(@NonNull List<c> list) {
            this.iLP = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: y */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.ahW);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.iLP;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.ahW != null) {
                    this.ahW.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.iLP == null) {
                return 0;
            }
            return this.iLP.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> ahW;
        private TextView aiw;
        private TextView aix;
        private TextView dSz;
        private int iLR;
        private View iLT;
        private View iLU;
        private TextView iLV;
        private ImageView iLW;

        b(View view) {
            super(view);
            this.iLR = 3;
            this.iLT = view.findViewById(R.id.itemLayout);
            this.aiw = (TextView) view.findViewById(R.id.indexView);
            this.dSz = (TextView) view.findViewById(R.id.titleView);
            this.aix = (TextView) view.findViewById(R.id.tagView);
            this.iLU = view.findViewById(R.id.moreLayout);
            this.iLV = (TextView) view.findViewById(R.id.moreText);
            this.iLW = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.iLO) {
                    this.iLT.setVisibility(8);
                    this.iLU.setVisibility(0);
                    this.iLU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.ahW != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.ahW.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.iLT.setVisibility(0);
                this.iLT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.ahW != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.ahW.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.iLU.setVisibility(8);
                if (cVar.index > 0) {
                    this.aiw.setText(String.valueOf(cVar.index));
                    this.aiw.setVisibility(0);
                } else {
                    this.aiw.setVisibility(8);
                }
                this.dSz.setText(cVar.eab);
                String t = TagTextHelper.t(this.aix.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dSz.getLayoutParams();
                if (TextUtils.isEmpty(t)) {
                    this.aix.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.aix.getContext(), R.dimen.tbds22);
                    this.dSz.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.aix.getContext(), R.dimen.tbds74);
                    this.dSz.setLayoutParams(marginLayoutParams);
                    this.aix.setVisibility(0);
                    this.aix.setText(t);
                }
                ap.setViewTextColor(this.aiw, TagTextHelper.oa(cVar.index));
                int color = ap.getColor(TagTextHelper.nZ(cVar.tag));
                Drawable background = this.aix.getBackground();
                DrawableCompat.setTint(background, color);
                this.aix.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.ahW = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.iLR != i) {
                com.baidu.tbadk.core.util.e.a.g(this.iLT, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.g(this.iLU, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
                ap.setViewTextColor(this.aix, R.color.cp_cont_a);
                if (this.iLU.getVisibility() == 0) {
                    ap.setViewTextColor(this.iLV, R.color.cp_link_tip_a);
                    int color = ap.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.iLW.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.iLW.setImageDrawable(drawable);
                }
                this.iLR = i;
            }
        }
    }
}
