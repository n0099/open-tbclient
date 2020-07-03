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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.homepage.tabfeed.data.b;
/* loaded from: classes9.dex */
public class HotTopicRankLayout extends LinearLayout implements View.OnClickListener, n<b>, o {
    private View ajf;
    private ImageView ajg;
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.b> iqN;
    private HotTopicTabRankListLayout ixJ;
    private View ixK;
    private View mBottomLine;
    private int mSkinType;
    private TextView mTitle;

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.mSkinType = 3;
        this.iqN = new f<com.baidu.tieba.homepage.hotTopic.tab.b.b>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout.1
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
        this.ajg = (ImageView) findViewById(R.id.iv_into);
        this.ajf = findViewById(R.id.layout_into);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.ixK = findViewById(R.id.title_layout);
        this.ixK.setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds22));
        ViewGroup.LayoutParams layoutParams = this.ixK.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.ixK.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        this.ixJ = new HotTopicTabRankListLayout(getContext());
        this.ixJ.setOnItemCoverListener(this.iqN);
        linearLayout.addView(this.ixJ);
        int dimens = l.getDimens(getContext(), R.dimen.tbds22);
        linearLayout.setPadding(dimens, 0, dimens, l.getDimens(getContext(), R.dimen.tbds48));
        this.ajg.setClickable(false);
        this.ajf.setOnClickListener(this);
        this.ajg.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(b bVar) {
        this.mTitle.setText(bVar.title != null ? bVar.title : "");
        this.ixJ.a(bVar);
        com.baidu.tieba.homepage.tabfeed.b.Gh("c13753");
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            an.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            an.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            SvgManager.aWQ().a(this.ajg, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        }
        this.mSkinType = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ajf == view) {
        }
    }
}
