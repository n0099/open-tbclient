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
    private int jCS;
    private a jCT;

    public void setOnItemCoverListener(f<c> fVar) {
        this.jCT.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.jCS = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.jCT = new a();
        setAdapter(this.jCT);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cKh() != null) {
            this.jCT.dK(dVar.cKh());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            this.jCT.notifyDataSetChanged();
            this.jCS = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> aiR;
        private List<c> jCQ;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.aiR = fVar;
        }

        void dK(@NonNull List<c> list) {
            this.jCQ = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: C */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.aiR);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.jCQ;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.aiR != null) {
                    this.aiR.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.jCQ == null) {
                return 0;
            }
            return this.jCQ.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> aiR;
        private TextView ajq;
        private TextView ajr;
        private TextView etx;
        private int jCS;
        private View jCU;
        private View jCV;
        private TextView jCW;
        private ImageView jCX;

        b(View view) {
            super(view);
            this.jCS = 3;
            this.jCU = view.findViewById(R.id.itemLayout);
            this.ajq = (TextView) view.findViewById(R.id.indexView);
            this.etx = (TextView) view.findViewById(R.id.titleView);
            this.ajr = (TextView) view.findViewById(R.id.tagView);
            this.jCV = view.findViewById(R.id.moreLayout);
            this.jCW = (TextView) view.findViewById(R.id.moreText);
            this.jCX = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.jCP) {
                    this.jCU.setVisibility(8);
                    this.jCV.setVisibility(0);
                    this.jCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.aiR != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.aiR.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.jCU.setVisibility(0);
                this.jCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.aiR != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.aiR.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.jCV.setVisibility(8);
                if (cVar.index > 0) {
                    this.ajq.setText(String.valueOf(cVar.index));
                    this.ajq.setVisibility(0);
                } else {
                    this.ajq.setVisibility(8);
                }
                this.etx.setText(cVar.eBa);
                String t = TagTextHelper.t(this.ajr.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.etx.getLayoutParams();
                if (TextUtils.isEmpty(t)) {
                    this.ajr.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.ajr.getContext(), R.dimen.tbds22);
                    this.etx.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.ajr.getContext(), R.dimen.tbds74);
                    this.etx.setLayoutParams(marginLayoutParams);
                    this.ajr.setVisibility(0);
                    this.ajr.setText(t);
                }
                ap.setViewTextColor(this.ajq, TagTextHelper.pA(cVar.index));
                com.baidu.tbadk.core.elementsMaven.c.bj(this.ajr).pb(R.string.J_X04).setBackGroundColor(TagTextHelper.pz(cVar.tag));
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.aiR = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.jCS != i) {
                int i2 = com.baidu.tbadk.a.d.bhw() ? R.color.CAM_X0206 : R.color.CAM_X0204;
                com.baidu.tbadk.core.util.e.a.h(this.jCU, R.color.CAM_X0205, i2);
                com.baidu.tbadk.core.util.e.a.h(this.jCV, R.color.CAM_X0205, i2);
                ap.setViewTextColor(this.etx, R.color.CAM_X0105);
                ap.setViewTextColor(this.ajr, R.color.CAM_X0101);
                if (this.jCV.getVisibility() == 0) {
                    ap.setViewTextColor(this.jCW, R.color.CAM_X0304);
                    int color = ap.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.jCX.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.jCX.setImageDrawable(drawable);
                }
                this.jCS = i;
            }
        }
    }
}
