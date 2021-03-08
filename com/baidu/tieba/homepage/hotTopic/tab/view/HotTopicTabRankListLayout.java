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
    private int kiZ;
    private a kja;

    public void setOnItemCoverListener(f<c> fVar) {
        this.kja.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.kiZ = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.kja = new a();
        setAdapter(this.kja);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cQX() != null) {
            this.kja.dZ(dVar.cQX());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            this.kja.notifyDataSetChanged();
            this.kiZ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> akI;
        private List<c> kiX;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.akI = fVar;
        }

        void dZ(@NonNull List<c> list) {
            this.kiX = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: H */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.akI);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.kiX;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.akI != null) {
                    this.akI.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.kiX == null) {
                return 0;
            }
            return this.kiX.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> akI;
        private TextView alh;
        private TextView ali;
        private TextView eIY;
        private int kiZ;
        private View kjb;
        private View kjc;
        private TextView kjd;
        private ImageView kje;

        b(View view) {
            super(view);
            this.kiZ = 3;
            this.kjb = view.findViewById(R.id.itemLayout);
            this.alh = (TextView) view.findViewById(R.id.indexView);
            this.eIY = (TextView) view.findViewById(R.id.titleView);
            this.ali = (TextView) view.findViewById(R.id.tagView);
            this.kjc = view.findViewById(R.id.moreLayout);
            this.kjd = (TextView) view.findViewById(R.id.moreText);
            this.kje = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.kiW) {
                    this.kjb.setVisibility(8);
                    this.kjc.setVisibility(0);
                    this.kjc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.akI != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.akI.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.kjb.setVisibility(0);
                this.kjb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.akI != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.akI.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.kjc.setVisibility(8);
                if (cVar.index > 0) {
                    this.alh.setText(String.valueOf(cVar.index));
                    this.alh.setVisibility(0);
                } else {
                    this.alh.setVisibility(8);
                }
                this.eIY.setText(cVar.eQU);
                String D = TagTextHelper.D(this.ali.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eIY.getLayoutParams();
                if (TextUtils.isEmpty(D)) {
                    this.ali.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.ali.getContext(), R.dimen.tbds22);
                    this.eIY.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.ali.getContext(), R.dimen.tbds74);
                    this.eIY.setLayoutParams(marginLayoutParams);
                    this.ali.setVisibility(0);
                    this.ali.setText(D);
                }
                ap.setViewTextColor(this.alh, TagTextHelper.oK(cVar.index));
                com.baidu.tbadk.core.elementsMaven.c.br(this.ali).oh(R.string.J_X04).setBackGroundColor(TagTextHelper.oJ(cVar.tag));
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.akI = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.kiZ != i) {
                int i2 = R.color.CAM_X0204;
                com.baidu.tbadk.core.util.f.a.m(this.kjb, R.color.CAM_X0205, i2);
                com.baidu.tbadk.core.util.f.a.m(this.kjc, R.color.CAM_X0205, i2);
                ap.setViewTextColor(this.eIY, R.color.CAM_X0105);
                ap.setViewTextColor(this.ali, R.color.CAM_X0101);
                if (this.kjc.getVisibility() == 0) {
                    ap.setViewTextColor(this.kjd, R.color.CAM_X0304);
                    int color = ap.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.kje.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.kje.setImageDrawable(drawable);
                }
                this.kiZ = i;
            }
        }
    }
}
