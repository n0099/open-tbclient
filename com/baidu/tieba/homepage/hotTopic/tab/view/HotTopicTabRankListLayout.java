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
    private int iLX;
    private a iLY;

    public void setOnItemCoverListener(f<c> fVar) {
        this.iLY.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.iLX = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.iLY = new a();
        setAdapter(this.iLY);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cxF() != null) {
            this.iLY.di(dVar.cxF());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            this.iLY.notifyDataSetChanged();
            this.iLX = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> ahY;
        private List<c> iLV;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.ahY = fVar;
        }

        void di(@NonNull List<c> list) {
            this.iLV = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: y */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.ahY);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.iLV;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.ahY != null) {
                    this.ahY.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.iLV == null) {
                return 0;
            }
            return this.iLV.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> ahY;
        private TextView aiy;
        private TextView aiz;
        private TextView dSD;
        private int iLX;
        private View iLZ;
        private View iMa;
        private TextView iMb;
        private ImageView iMc;

        b(View view) {
            super(view);
            this.iLX = 3;
            this.iLZ = view.findViewById(R.id.itemLayout);
            this.aiy = (TextView) view.findViewById(R.id.indexView);
            this.dSD = (TextView) view.findViewById(R.id.titleView);
            this.aiz = (TextView) view.findViewById(R.id.tagView);
            this.iMa = view.findViewById(R.id.moreLayout);
            this.iMb = (TextView) view.findViewById(R.id.moreText);
            this.iMc = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.iLU) {
                    this.iLZ.setVisibility(8);
                    this.iMa.setVisibility(0);
                    this.iMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.ahY != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.ahY.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.iLZ.setVisibility(0);
                this.iLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.ahY != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.ahY.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.iMa.setVisibility(8);
                if (cVar.index > 0) {
                    this.aiy.setText(String.valueOf(cVar.index));
                    this.aiy.setVisibility(0);
                } else {
                    this.aiy.setVisibility(8);
                }
                this.dSD.setText(cVar.eaf);
                String t = TagTextHelper.t(this.aiz.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dSD.getLayoutParams();
                if (TextUtils.isEmpty(t)) {
                    this.aiz.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.aiz.getContext(), R.dimen.tbds22);
                    this.dSD.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.aiz.getContext(), R.dimen.tbds74);
                    this.dSD.setLayoutParams(marginLayoutParams);
                    this.aiz.setVisibility(0);
                    this.aiz.setText(t);
                }
                ap.setViewTextColor(this.aiy, TagTextHelper.oa(cVar.index));
                int color = ap.getColor(TagTextHelper.nZ(cVar.tag));
                Drawable background = this.aiz.getBackground();
                DrawableCompat.setTint(background, color);
                this.aiz.setBackgroundDrawable(background);
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.ahY = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.iLX != i) {
                com.baidu.tbadk.core.util.e.a.g(this.iLZ, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                com.baidu.tbadk.core.util.e.a.g(this.iMa, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
                ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
                ap.setViewTextColor(this.aiz, R.color.cp_cont_a);
                if (this.iMa.getVisibility() == 0) {
                    ap.setViewTextColor(this.iMb, R.color.cp_link_tip_a);
                    int color = ap.getColor(R.color.cp_link_tip_a);
                    Drawable drawable = this.iMc.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.iMc.setImageDrawable(drawable);
                }
                this.iLX = i;
            }
        }
    }
}
