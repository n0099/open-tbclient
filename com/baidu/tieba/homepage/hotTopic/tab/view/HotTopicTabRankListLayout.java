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
    private int jQw;
    private a jQx;

    public void setOnItemCoverListener(f<c> fVar) {
        this.jQx.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.jQw = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.jQx = new a();
        setAdapter(this.jQx);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cPx() != null) {
            this.jQx.dV(dVar.cPx());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            this.jQx.notifyDataSetChanged();
            this.jQw = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> ajQ;
        private List<c> jQu;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.ajQ = fVar;
        }

        void dV(@NonNull List<c> list) {
            this.jQu = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: C */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.ajQ);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.jQu;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.ajQ != null) {
                    this.ajQ.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.jQu == null) {
                return 0;
            }
            return this.jQu.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> ajQ;
        private TextView akp;
        private TextView akq;
        private TextView eAz;
        private TextView jQA;
        private ImageView jQB;
        private int jQw;
        private View jQy;
        private View jQz;

        b(View view) {
            super(view);
            this.jQw = 3;
            this.jQy = view.findViewById(R.id.itemLayout);
            this.akp = (TextView) view.findViewById(R.id.indexView);
            this.eAz = (TextView) view.findViewById(R.id.titleView);
            this.akq = (TextView) view.findViewById(R.id.tagView);
            this.jQz = view.findViewById(R.id.moreLayout);
            this.jQA = (TextView) view.findViewById(R.id.moreText);
            this.jQB = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.jQt) {
                    this.jQy.setVisibility(8);
                    this.jQz.setVisibility(0);
                    this.jQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.ajQ != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.ajQ.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.jQy.setVisibility(0);
                this.jQy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.ajQ != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.ajQ.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.jQz.setVisibility(8);
                if (cVar.index > 0) {
                    this.akp.setText(String.valueOf(cVar.index));
                    this.akp.setVisibility(0);
                } else {
                    this.akp.setVisibility(8);
                }
                this.eAz.setText(cVar.eIa);
                String C = TagTextHelper.C(this.akq.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eAz.getLayoutParams();
                if (TextUtils.isEmpty(C)) {
                    this.akq.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.akq.getContext(), R.dimen.tbds22);
                    this.eAz.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.akq.getContext(), R.dimen.tbds74);
                    this.eAz.setLayoutParams(marginLayoutParams);
                    this.akq.setVisibility(0);
                    this.akq.setText(C);
                }
                ap.setViewTextColor(this.akp, TagTextHelper.qa(cVar.index));
                com.baidu.tbadk.core.elementsMaven.c.bm(this.akq).pA(R.string.J_X04).setBackGroundColor(TagTextHelper.pZ(cVar.tag));
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.ajQ = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.jQw != i) {
                int i2 = com.baidu.tbadk.a.d.bkA() ? R.color.CAM_X0206 : R.color.CAM_X0204;
                com.baidu.tbadk.core.util.e.a.g(this.jQy, R.color.CAM_X0205, i2);
                com.baidu.tbadk.core.util.e.a.g(this.jQz, R.color.CAM_X0205, i2);
                ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
                ap.setViewTextColor(this.akq, R.color.CAM_X0101);
                if (this.jQz.getVisibility() == 0) {
                    ap.setViewTextColor(this.jQA, R.color.CAM_X0304);
                    int color = ap.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.jQB.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.jQB.setImageDrawable(drawable);
                }
                this.jQw = i;
            }
        }
    }
}
