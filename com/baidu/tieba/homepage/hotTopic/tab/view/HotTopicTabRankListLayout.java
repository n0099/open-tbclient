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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import java.util.List;
/* loaded from: classes9.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int iqP;
    private a iqZ;

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.b> fVar) {
        this.iqZ.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.iqP = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.iqZ = new a();
        setAdapter(this.iqZ);
    }

    public void a(c cVar) {
        if (cVar != null && cVar.cjp() != null) {
            this.iqZ.cW(cVar.cjp());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            this.iqZ.notifyDataSetChanged();
            this.iqP = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<com.baidu.tieba.homepage.hotTopic.tab.b.b> agW;
        private List<com.baidu.tieba.homepage.hotTopic.tab.b.b> iqY;

        a() {
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.b> fVar) {
            this.agW = fVar;
        }

        void cW(@NonNull List<com.baidu.tieba.homepage.hotTopic.tab.b.b> list) {
            this.iqY = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: y */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.agW);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<com.baidu.tieba.homepage.hotTopic.tab.b.b> list = this.iqY;
            if (list != null && list.size() > i) {
                com.baidu.tieba.homepage.hotTopic.tab.b.b bVar2 = list.get(i);
                bVar.a(bVar2);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.agW != null) {
                    this.agW.b(bVar.itemView, bVar2, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.iqY == null) {
                return 0;
            }
            return this.iqY.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<com.baidu.tieba.homepage.hotTopic.tab.b.b> agW;
        private TextView dDu;
        private int iqP;
        private View ira;
        private TextView irb;
        private TextView irc;
        private View ird;
        private TextView ire;
        private ImageView irf;

        b(View view) {
            super(view);
            this.iqP = 3;
            this.ira = view.findViewById(R.id.itemLayout);
            this.irb = (TextView) view.findViewById(R.id.indexView);
            this.dDu = (TextView) view.findViewById(R.id.titleView);
            this.irc = (TextView) view.findViewById(R.id.tagView);
            this.ird = view.findViewById(R.id.moreLayout);
            this.ire = (TextView) view.findViewById(R.id.moreText);
            this.irf = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final com.baidu.tieba.homepage.hotTopic.tab.b.b bVar) {
            if (bVar != null) {
                if (bVar.iqX) {
                    this.ira.setVisibility(8);
                    this.ird.setVisibility(0);
                    this.ird.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", SchemeCollecter.CLASSIFY_ALL).start();
                            if (b.this.agW != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.agW.a(view, bVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.ira.setVisibility(0);
                this.ira.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + bVar.topicId, null, "3").start();
                        if (b.this.agW != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.agW.a(view, bVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.ird.setVisibility(8);
                if (bVar.index > 0) {
                    this.irb.setText(String.valueOf(bVar.index));
                    this.irb.setVisibility(0);
                } else {
                    this.irb.setVisibility(8);
                }
                this.dDu.setText(bVar.dKw);
                String s = TagTextHelper.s(this.irc.getContext(), bVar.tag);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDu.getLayoutParams();
                if (TextUtils.isEmpty(s)) {
                    this.irc.setVisibility(8);
                    layoutParams.rightMargin = l.getDimens(this.irc.getContext(), R.dimen.tbds22);
                    this.dDu.setLayoutParams(layoutParams);
                } else {
                    layoutParams.rightMargin = l.getDimens(this.irc.getContext(), R.dimen.tbds74);
                    this.dDu.setLayoutParams(layoutParams);
                    this.irc.setVisibility(0);
                    this.irc.setText(s);
                }
                an.setViewTextColor(this.irb, TagTextHelper.lA(bVar.index));
                int color = an.getColor(TagTextHelper.lz(bVar.tag));
                Drawable background = this.irc.getBackground();
                DrawableCompat.setTint(background, color);
                this.irc.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.b> fVar) {
            this.agW = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.iqP != i) {
                com.baidu.tbadk.core.util.e.a.f(this.ira, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.f(this.ird, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
                an.setViewTextColor(this.irc, (int) R.color.cp_cont_a);
                if (this.ird.getVisibility() == 0) {
                    an.setViewTextColor(this.ire, (int) R.color.cp_link_tip_a);
                    int color = an.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.irf.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.irf.setImageDrawable(drawable);
                }
                this.iqP = i;
            }
        }
    }
}
