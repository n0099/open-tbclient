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
    private int jZf;
    private a jZg;

    public void setOnItemCoverListener(f<c> fVar) {
        this.jZg.setOnItemCoverListener(fVar);
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.jZf = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        initView();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        this.jZg = new a();
        setAdapter(this.jZg);
    }

    public void a(d dVar) {
        if (dVar != null && dVar.cOM() != null) {
            this.jZg.ec(dVar.cOM());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            this.jZg.notifyDataSetChanged();
            this.jZf = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private f<c> ajB;
        private List<c> jZd;

        a() {
        }

        public void setOnItemCoverListener(f<c> fVar) {
            this.ajB = fVar;
        }

        void ec(@NonNull List<c> list) {
            this.jZd = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: G */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.setOnItemCoverListener(this.ajB);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.jZd;
            if (list != null && list.size() > i) {
                c cVar = list.get(i);
                bVar.a(cVar);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.ajB != null) {
                    this.ajB.b(bVar.itemView, cVar, i, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.jZd == null) {
                return 0;
            }
            return this.jZd.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        private f<c> ajB;
        private TextView aka;
        private TextView akb;
        private TextView eFr;
        private int jZf;
        private View jZh;
        private View jZi;
        private TextView jZj;
        private ImageView jZk;

        b(View view) {
            super(view);
            this.jZf = 3;
            this.jZh = view.findViewById(R.id.itemLayout);
            this.aka = (TextView) view.findViewById(R.id.indexView);
            this.eFr = (TextView) view.findViewById(R.id.titleView);
            this.akb = (TextView) view.findViewById(R.id.tagView);
            this.jZi = view.findViewById(R.id.moreLayout);
            this.jZj = (TextView) view.findViewById(R.id.moreText);
            this.jZk = (ImageView) view.findViewById(R.id.moreIcon);
        }

        void a(final c cVar) {
            if (cVar != null) {
                if (cVar.jZc) {
                    this.jZh.setVisibility(8);
                    this.jZi.setVisibility(0);
                    this.jZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                            if (b.this.ajB != null) {
                                int adapterPosition = b.this.getAdapterPosition();
                                b.this.ajB.a(view, cVar, adapterPosition, adapterPosition);
                            }
                        }
                    });
                    return;
                }
                this.jZh.setVisibility(0);
                this.jZh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new HotTopicActivityConfig(view.getContext()).createNormalConfig("" + cVar.topicId, null, "3").start();
                        if (b.this.ajB != null) {
                            int adapterPosition = b.this.getAdapterPosition();
                            b.this.ajB.a(view, cVar, adapterPosition, adapterPosition);
                        }
                    }
                });
                this.jZi.setVisibility(8);
                if (cVar.index > 0) {
                    this.aka.setText(String.valueOf(cVar.index));
                    this.aka.setVisibility(0);
                } else {
                    this.aka.setVisibility(8);
                }
                this.eFr.setText(cVar.eNh);
                String D = TagTextHelper.D(this.akb.getContext(), cVar.tag);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eFr.getLayoutParams();
                if (TextUtils.isEmpty(D)) {
                    this.akb.setVisibility(8);
                    marginLayoutParams.rightMargin = l.getDimens(this.akb.getContext(), R.dimen.tbds22);
                    this.eFr.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.getDimens(this.akb.getContext(), R.dimen.tbds74);
                    this.eFr.setLayoutParams(marginLayoutParams);
                    this.akb.setVisibility(0);
                    this.akb.setText(D);
                }
                ao.setViewTextColor(this.aka, TagTextHelper.oE(cVar.index));
                com.baidu.tbadk.core.elementsMaven.c.bv(this.akb).od(R.string.J_X04).setBackGroundColor(TagTextHelper.oD(cVar.tag));
            }
        }

        void setOnItemCoverListener(f<c> fVar) {
            this.ajB = fVar;
        }

        void onChangeSkinType(int i) {
            if (this.jZf != i) {
                int i2 = R.color.CAM_X0204;
                com.baidu.tbadk.core.util.f.a.m(this.jZh, R.color.CAM_X0205, i2);
                com.baidu.tbadk.core.util.f.a.m(this.jZi, R.color.CAM_X0205, i2);
                ao.setViewTextColor(this.eFr, R.color.CAM_X0105);
                ao.setViewTextColor(this.akb, R.color.CAM_X0101);
                if (this.jZi.getVisibility() == 0) {
                    ao.setViewTextColor(this.jZj, R.color.CAM_X0304);
                    int color = ao.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.jZk.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.jZk.setImageDrawable(drawable);
                }
                this.jZf = i;
            }
        }
    }
}
