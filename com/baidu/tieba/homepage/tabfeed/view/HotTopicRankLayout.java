package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.n;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.homepage.tabfeed.data.b;
/* loaded from: classes16.dex */
public class HotTopicRankLayout extends LinearLayout implements View.OnClickListener, n<b>, o {
    private View aja;
    private ImageView ajb;
    private HotTopicTabRankListLayout iDP;
    private View iDQ;
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.b> iwT;
    private View mBottomLine;
    private int mSkinType;
    private TextView mTitle;

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.mSkinType = 3;
        this.iwT = new f<com.baidu.tieba.homepage.hotTopic.tab.b.b>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, com.baidu.tieba.homepage.hotTopic.tab.b.b bVar, int i, long j) {
                if (bVar != null) {
                    com.baidu.tieba.homepage.tabfeed.b.b("c13753", bVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, com.baidu.tieba.homepage.hotTopic.tab.b.b bVar, int i, long j) {
                if (bVar == null) {
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
        this.ajb = (ImageView) findViewById(R.id.iv_into);
        this.aja = findViewById(R.id.layout_into);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.iDQ = findViewById(R.id.title_layout);
        this.iDQ.setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds22));
        ViewGroup.LayoutParams layoutParams = this.iDQ.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.iDQ.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        this.iDP = new HotTopicTabRankListLayout(getContext());
        this.iDP.setOnItemCoverListener(this.iwT);
        linearLayout.addView(this.iDP);
        int dimens = l.getDimens(getContext(), R.dimen.tbds22);
        linearLayout.setPadding(dimens, 0, dimens, l.getDimens(getContext(), R.dimen.tbds48));
        this.ajb.setClickable(false);
        this.aja.setOnClickListener(this);
        this.ajb.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(b bVar) {
        this.mTitle.setText(bVar.title != null ? bVar.title : "");
        this.iDP.a(bVar);
        com.baidu.tbadk.a.b.a.a(this.mBottomLine, bVar);
        com.baidu.tieba.homepage.tabfeed.b.GT("c13753");
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_c);
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aU(this.mBottomLine);
            SvgManager.baR().a(this.ajb, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        }
        this.mSkinType = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aja == view) {
        }
    }
}
