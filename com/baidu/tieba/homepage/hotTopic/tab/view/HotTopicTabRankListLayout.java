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
/* loaded from: classes21.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int iUD;
    private a iUE;

    public void setOnItemCoverListener(f<c> fVar) {
        this.iUE.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.iUD = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.iUE = new a();
        setAdapter(this.iUE);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cBn() != null) {
            this.iUE.dq(dVar.cBn());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            this.iUE.notifyDataSetChanged();
            this.iUD = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> ait;
        private List<c> iUB;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.ait = fVar;
        }

        void dq(@NonNull List<c> list) {
            this.iUB = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: A */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.ait);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.iUB;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.ait != null) {
                    this.ait.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.iUB == null) {
                return 0;
            }
            return this.iUB.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class b extends RecyclerView.ViewHolder {
        private TextView aiS;
        private TextView aiT;
        private f<c> ait;
        private TextView dUN;
        private int iUD;
        private View iUF;
        private View iUG;
        private TextView iUH;
        private ImageView iUI;

        b(View view) {
            super(view);
            this.iUD = 3;
            this.iUF = view.findViewById(R.id.itemLayout);
            this.aiS = (TextView) view.findViewById(R.id.indexView);
            this.dUN = (TextView) view.findViewById(R.id.titleView);
            this.aiT = (TextView) view.findViewById(R.id.tagView);
            this.iUG = view.findViewById(R.id.moreLayout);
            this.iUH = (TextView) view.findViewById(R.id.moreText);
            this.iUI = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.iUA) {
                    this.iUF.setVisibility(8);
                    this.iUG.setVisibility(0);
                    this.iUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.ait != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.ait.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.iUF.setVisibility(0);
                this.iUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.ait != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.ait.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.iUG.setVisibility(8);
                if (cVar.index > 0) {
                    this.aiS.setText(String.valueOf(cVar.index));
                    this.aiS.setVisibility(0);
                } else {
                    this.aiS.setVisibility(8);
                }
                this.dUN.setText(cVar.ecp);
                String t = TagTextHelper.t(this.aiT.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dUN.getLayoutParams();
                if (TextUtils.isEmpty(t)) {
                    this.aiT.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.aiT.getContext(), R.dimen.tbds22);
                    this.dUN.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.aiT.getContext(), R.dimen.tbds74);
                    this.dUN.setLayoutParams(marginLayoutParams);
                    this.aiT.setVisibility(0);
                    this.aiT.setText(t);
                }
                ap.setViewTextColor(this.aiS, TagTextHelper.om(cVar.index));
                int color = ap.getColor(TagTextHelper.ol(cVar.tag));
                Drawable background = this.aiT.getBackground();
                DrawableCompat.setTint(background, color);
                this.aiT.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.ait = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.iUD != i) {
                com.baidu.tbadk.core.util.e.a.g(this.iUF, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.g(this.iUG, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
                ap.setViewTextColor(this.aiT, R.color.cp_cont_a);
                if (this.iUG.getVisibility() == 0) {
                    ap.setViewTextColor(this.iUH, R.color.cp_link_tip_a);
                    int color = ap.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.iUI.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.iUI.setImageDrawable(drawable);
                }
                this.iUD = i;
            }
        }
    }
}
