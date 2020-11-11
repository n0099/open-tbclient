package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.homepage.tabfeed.data.b;
/* loaded from: classes22.dex */
public class HotTopicRankLayout extends LinearLayout implements View.OnClickListener, p<b>, q {
    private View alj;
    private ImageView alk;
    private f<c> jBo;
    private HotTopicTabRankListLayout jIV;
    private View jIW;
    private View mBottomLine;
    private int mSkinType;
    private TextView mTitle;

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.mSkinType = 3;
        this.jBo = new f<c>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout.1
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
        this.alk = (ImageView) findViewById(R.id.iv_into);
        this.alj = findViewById(R.id.layout_into);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.jIW = findViewById(R.id.title_layout);
        this.jIW.setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds22));
        ViewGroup.LayoutParams layoutParams = this.jIW.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.jIW.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        this.jIV = new HotTopicTabRankListLayout(getContext());
        this.jIV.setOnItemCoverListener(this.jBo);
        linearLayout.addView(this.jIV);
        linearLayout.setPadding(0, 0, 0, l.getDimens(getContext(), R.dimen.tbds48));
        this.alk.setClickable(false);
        this.alj.setOnClickListener(this);
        this.alk.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(b bVar) {
        this.mTitle.setText(bVar.title != null ? bVar.title : "");
        this.jIV.a(bVar);
        com.baidu.tbadk.a.b.a.a(this.mBottomLine, bVar);
        com.baidu.tieba.homepage.tabfeed.b.LS("c13753");
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_c);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.be(this.mBottomLine);
            SvgManager.brn().a(this.alk, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        }
        this.mSkinType = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alj == view) {
        }
    }
}
