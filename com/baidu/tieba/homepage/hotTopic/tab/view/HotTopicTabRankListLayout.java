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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import java.util.List;
/* loaded from: classes2.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    private int kgI;
    private a kgJ;

    public void setOnItemCoverListener(f<c> fVar) {
        this.kgJ.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.kgI = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgI = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgI = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.kgJ = new a();
        setAdapter(this.kgJ);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cQJ() != null) {
            this.kgJ.dZ(dVar.cQJ());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgI != i) {
            this.kgJ.notifyDataSetChanged();
            this.kgI = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> ajq;
        private List<c> kgG;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.ajq = fVar;
        }

        void dZ(@NonNull List<c> list) {
            this.kgG = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: H */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.ajq);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.kgG;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.ajq != null) {
                    this.ajq.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.kgG == null) {
                return 0;
            }
            return this.kgG.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        private TextView ajP;
        private TextView ajQ;
        private f<c> ajq;
        private TextView eHx;
        private int kgI;
        private View kgK;
        private View kgL;
        private TextView kgM;
        private ImageView kgN;

        b(View view) {
            super(view);
            this.kgI = 3;
            this.kgK = view.findViewById(R.id.itemLayout);
            this.ajP = (TextView) view.findViewById(R.id.indexView);
            this.eHx = (TextView) view.findViewById(R.id.titleView);
            this.ajQ = (TextView) view.findViewById(R.id.tagView);
            this.kgL = view.findViewById(R.id.moreLayout);
            this.kgM = (TextView) view.findViewById(R.id.moreText);
            this.kgN = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.kgF) {
                    this.kgK.setVisibility(8);
                    this.kgL.setVisibility(0);
                    this.kgL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.ajq != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.ajq.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.kgK.setVisibility(0);
                this.kgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.ajq != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.ajq.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.kgL.setVisibility(8);
                if (cVar.index > 0) {
                    this.ajP.setText(String.valueOf(cVar.index));
                    this.ajP.setVisibility(0);
                } else {
                    this.ajP.setVisibility(8);
                }
                this.eHx.setText(cVar.ePt);
                String D = TagTextHelper.D(this.ajQ.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eHx.getLayoutParams();
                if (TextUtils.isEmpty(D)) {
                    this.ajQ.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.ajQ.getContext(), R.dimen.tbds22);
                    this.eHx.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.ajQ.getContext(), R.dimen.tbds74);
                    this.eHx.setLayoutParams(marginLayoutParams);
                    this.ajQ.setVisibility(0);
                    this.ajQ.setText(D);
                }
                ap.setViewTextColor(this.ajP, TagTextHelper.oJ(cVar.index));
                com.baidu.tbadk.core.elementsMaven.c.br(this.ajQ).og(R.string.J_X04).setBackGroundColor(TagTextHelper.oI(cVar.tag));
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.ajq = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.kgI != i) {
                int i2 = R.color.CAM_X0204;
                com.baidu.tbadk.core.util.f.a.m(this.kgK, R.color.CAM_X0205, i2);
                com.baidu.tbadk.core.util.f.a.m(this.kgL, R.color.CAM_X0205, i2);
                ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
                ap.setViewTextColor(this.ajQ, R.color.CAM_X0101);
                if (this.kgL.getVisibility() == 0) {
                    ap.setViewTextColor(this.kgM, R.color.CAM_X0304);
                    int color = ap.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.kgN.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.kgN.setImageDrawable(drawable);
                }
                this.kgI = i;
            }
        }
    }
}
