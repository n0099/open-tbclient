package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import java.util.List;
/* loaded from: classes2.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int kdK;
    private a kdL;

    public void setOnItemCoverListener(f<c> fVar) {
        this.kdL.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.kdK = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.kdL = new a();
        setAdapter(this.kdL);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cSE() != null) {
            this.kdL.ec(dVar.cSE());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            this.kdL.notifyDataSetChanged();
            this.kdK = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> aks;
        private List<c> kdI;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.aks = fVar;
        }

        void ec(@NonNull List<c> list) {
            this.kdI = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: G */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.aks);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.kdI;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.aks != null) {
                    this.aks.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.kdI == null) {
                return 0;
            }
            return this.kdI.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        private TextView akR;
        private TextView akS;
        private f<c> aks;
        private TextView eKc;
        private int kdK;
        private View kdM;
        private View kdN;
        private TextView kdO;
        private ImageView kdP;

        b(View view) {
            super(view);
            this.kdK = 3;
            this.kdM = view.findViewById(R.id.itemLayout);
            this.akR = (TextView) view.findViewById(R.id.indexView);
            this.eKc = (TextView) view.findViewById(R.id.titleView);
            this.akS = (TextView) view.findViewById(R.id.tagView);
            this.kdN = view.findViewById(R.id.moreLayout);
            this.kdO = (TextView) view.findViewById(R.id.moreText);
            this.kdP = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.kdH) {
                    this.kdM.setVisibility(8);
                    this.kdN.setVisibility(0);
                    this.kdN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.aks != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.aks.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.kdM.setVisibility(0);
                this.kdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.aks != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.aks.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.kdN.setVisibility(8);
                if (cVar.index > 0) {
                    this.akR.setText(String.valueOf(cVar.index));
                    this.akR.setVisibility(0);
                } else {
                    this.akR.setVisibility(8);
                }
                this.eKc.setText(cVar.eRS);
                String D = TagTextHelper.D(this.akS.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eKc.getLayoutParams();
                if (TextUtils.isEmpty(D)) {
                    this.akS.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.akS.getContext(), R.dimen.tbds22);
                    this.eKc.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.akS.getContext(), R.dimen.tbds74);
                    this.eKc.setLayoutParams(marginLayoutParams);
                    this.akS.setVisibility(0);
                    this.akS.setText(D);
                }
                ao.setViewTextColor(this.akR, TagTextHelper.ql(cVar.index));
                com.baidu.tbadk.core.elementsMaven.c.bv(this.akS).pK(R.string.J_X04).setBackGroundColor(TagTextHelper.qk(cVar.tag));
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.aks = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.kdK != i) {
                int i2 = R.color.CAM_X0204;
                com.baidu.tbadk.core.util.f.a.m(this.kdM, R.color.CAM_X0205, i2);
                com.baidu.tbadk.core.util.f.a.m(this.kdN, R.color.CAM_X0205, i2);
                ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
                ao.setViewTextColor(this.akS, R.color.CAM_X0101);
                if (this.kdN.getVisibility() == 0) {
                    ao.setViewTextColor(this.kdO, R.color.CAM_X0304);
                    int color = ao.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.kdP.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.kdP.setImageDrawable(drawable);
                }
                this.kdK = i;
            }
        }
    }
}
