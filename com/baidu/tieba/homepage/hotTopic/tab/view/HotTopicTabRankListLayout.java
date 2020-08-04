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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import java.util.List;
/* loaded from: classes16.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int iwV;
    private a ixf;

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.b> fVar) {
        this.ixf.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.iwV = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.ixf = new a();
        setAdapter(this.ixf);
    }

    public void a(c cVar) {
        if (cVar != null && cVar.cmR() != null) {
            this.ixf.db(cVar.cmR());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwV != i) {
            this.ixf.notifyDataSetChanged();
            this.iwV = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<com.baidu.tieba.homepage.hotTopic.tab.b.b> agN;
        private List<com.baidu.tieba.homepage.hotTopic.tab.b.b> ixe;

        a() {
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.b> fVar) {
            this.agN = fVar;
        }

        void db(@NonNull List<com.baidu.tieba.homepage.hotTopic.tab.b.b> list) {
            this.ixe = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: y */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.agN);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<com.baidu.tieba.homepage.hotTopic.tab.b.b> list = this.ixe;
            if (list != null && list.size() > i) {
                com.baidu.tieba.homepage.hotTopic.tab.b.b bVar2 = list.get(i);
                bVar.a(bVar2);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.agN != null) {
                    this.agN.b(bVar.itemView, bVar2, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.ixe == null) {
                return 0;
            }
            return this.ixe.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<com.baidu.tieba.homepage.hotTopic.tab.b.b> agN;
        private TextView dJr;
        private int iwV;
        private View ixg;
        private TextView ixh;
        private TextView ixi;
        private View ixj;
        private TextView ixk;
        private ImageView ixl;

        b(View view) {
            super(view);
            this.iwV = 3;
            this.ixg = view.findViewById(R.id.itemLayout);
            this.ixh = (TextView) view.findViewById(R.id.indexView);
            this.dJr = (TextView) view.findViewById(R.id.titleView);
            this.ixi = (TextView) view.findViewById(R.id.tagView);
            this.ixj = view.findViewById(R.id.moreLayout);
            this.ixk = (TextView) view.findViewById(R.id.moreText);
            this.ixl = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final com.baidu.tieba.homepage.hotTopic.tab.b.b bVar) {
            if (bVar != null) {
                if (bVar.ixd) {
                    this.ixg.setVisibility(8);
                    this.ixj.setVisibility(0);
                    this.ixj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", SchemeCollecter.CLASSIFY_ALL).start();
                            if (b.this.agN != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.agN.a(view, bVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.ixg.setVisibility(0);
                this.ixg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + bVar.topicId, null, "3").start();
                        if (b.this.agN != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.agN.a(view, bVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.ixj.setVisibility(8);
                if (bVar.index > 0) {
                    this.ixh.setText(String.valueOf(bVar.index));
                    this.ixh.setVisibility(0);
                } else {
                    this.ixh.setVisibility(8);
                }
                this.dJr.setText(bVar.dQI);
                String s = TagTextHelper.s(this.ixi.getContext(), bVar.tag);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
                if (TextUtils.isEmpty(s)) {
                    this.ixi.setVisibility(8);
                    layoutParams.rightMargin = l.getDimens(this.ixi.getContext(), R.dimen.tbds22);
                    this.dJr.setLayoutParams(layoutParams);
                } else {
                    layoutParams.rightMargin = l.getDimens(this.ixi.getContext(), R.dimen.tbds74);
                    this.dJr.setLayoutParams(layoutParams);
                    this.ixi.setVisibility(0);
                    this.ixi.setText(s);
                }
                ao.setViewTextColor(this.ixh, TagTextHelper.lU(bVar.index));
                int color = ao.getColor(TagTextHelper.lT(bVar.tag));
                Drawable background = this.ixi.getBackground();
                DrawableCompat.setTint(background, color);
                this.ixi.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.b> fVar) {
            this.agN = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.iwV != i) {
                com.baidu.tbadk.core.util.e.a.h(this.ixg, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.h(this.ixj, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
                ao.setViewTextColor(this.ixi, R.color.cp_cont_a);
                if (this.ixj.getVisibility() == 0) {
                    ao.setViewTextColor(this.ixk, R.color.cp_link_tip_a);
                    int color = ao.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.ixl.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.ixl.setImageDrawable(drawable);
                }
                this.iwV = i;
            }
        }
    }
}
