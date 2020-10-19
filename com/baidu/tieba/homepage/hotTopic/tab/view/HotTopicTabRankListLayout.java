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
    private int jjB;
    private a jjC;

    public void setOnItemCoverListener(f<c> fVar) {
        this.jjC.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.jjB = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.jjC = new a();
        setAdapter(this.jjC);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cEU() != null) {
            this.jjC.dt(dVar.cEU());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            this.jjC.notifyDataSetChanged();
            this.jjB = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> aiL;
        private List<c> jjz;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.aiL = fVar;
        }

        void dt(@NonNull List<c> list) {
            this.jjz = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: C */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.aiL);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.jjz;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.aiL != null) {
                    this.aiL.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.jjz == null) {
                return 0;
            }
            return this.jjz.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> aiL;
        private TextView ajk;
        private TextView ajl;
        private TextView egP;
        private int jjB;
        private View jjD;
        private View jjE;
        private TextView jjF;
        private ImageView jjG;

        b(View view) {
            super(view);
            this.jjB = 3;
            this.jjD = view.findViewById(R.id.itemLayout);
            this.ajk = (TextView) view.findViewById(R.id.indexView);
            this.egP = (TextView) view.findViewById(R.id.titleView);
            this.ajl = (TextView) view.findViewById(R.id.tagView);
            this.jjE = view.findViewById(R.id.moreLayout);
            this.jjF = (TextView) view.findViewById(R.id.moreText);
            this.jjG = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.jjy) {
                    this.jjD.setVisibility(8);
                    this.jjE.setVisibility(0);
                    this.jjE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.aiL != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.aiL.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.jjD.setVisibility(0);
                this.jjD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.aiL != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.aiL.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.jjE.setVisibility(8);
                if (cVar.index > 0) {
                    this.ajk.setText(String.valueOf(cVar.index));
                    this.ajk.setVisibility(0);
                } else {
                    this.ajk.setVisibility(8);
                }
                this.egP.setText(cVar.eou);
                String t = TagTextHelper.t(this.ajl.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.egP.getLayoutParams();
                if (TextUtils.isEmpty(t)) {
                    this.ajl.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.ajl.getContext(), R.dimen.tbds22);
                    this.egP.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.ajl.getContext(), R.dimen.tbds74);
                    this.egP.setLayoutParams(marginLayoutParams);
                    this.ajl.setVisibility(0);
                    this.ajl.setText(t);
                }
                ap.setViewTextColor(this.ajk, TagTextHelper.oJ(cVar.index));
                int color = ap.getColor(TagTextHelper.oI(cVar.tag));
                Drawable background = this.ajl.getBackground();
                DrawableCompat.setTint(background, color);
                this.ajl.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.aiL = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.jjB != i) {
                com.baidu.tbadk.core.util.e.a.g(this.jjD, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.g(this.jjE, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                ap.setViewTextColor(this.egP, R.color.cp_cont_b);
                ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
                if (this.jjE.getVisibility() == 0) {
                    ap.setViewTextColor(this.jjF, R.color.cp_link_tip_a);
                    int color = ap.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.jjG.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.jjG.setImageDrawable(drawable);
                }
                this.jjB = i;
            }
        }
    }
}
