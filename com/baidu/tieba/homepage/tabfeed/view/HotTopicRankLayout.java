package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.o;
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.homepage.tabfeed.data.b;
/* loaded from: classes16.dex */
public class HotTopicRankLayout extends LinearLayout implements View.OnClickListener, o<b>, p {
    private View akr;
    private ImageView aks;
    private f<c> iLq;
    private HotTopicTabRankListLayout iST;
    private View iSU;
    private View mBottomLine;
    private int mSkinType;
    private TextView mTitle;

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.mSkinType = 3;
        this.iLq = new f<c>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, c cVar, int i, long j) {
                if (cVar != null) {
                    com.baidu.tieba.homepage.tabfeed.b.c("c13753", cVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, c cVar, int i, long j) {
                if (cVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.aks = (ImageView) findViewById(R.id.iv_into);
        this.akr = findViewById(R.id.layout_into);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.iSU = findViewById(R.id.title_layout);
        this.iSU.setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds22));
        ViewGroup.LayoutParams layoutParams = this.iSU.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.iSU.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        this.iST = new HotTopicTabRankListLayout(getContext());
        this.iST.setOnItemCoverListener(this.iLq);
        linearLayout.addView(this.iST);
        linearLayout.setPadding(0, 0, 0, l.getDimens(getContext(), R.dimen.tbds48));
        this.aks.setClickable(false);
        this.akr.setOnClickListener(this);
        this.aks.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(b bVar) {
        this.mTitle.setText(bVar.title != null ? bVar.title : "");
        this.iST.a(bVar);
        com.baidu.tbadk.a.b.a.a(this.mBottomLine, bVar);
        com.baidu.tieba.homepage.tabfeed.b.JM("c13753");
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_c);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aW(this.mBottomLine);
            SvgManager.bjq().a(this.aks, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        }
        this.mSkinType = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akr == view) {
        }
    }
}
