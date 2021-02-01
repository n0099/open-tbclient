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
/* loaded from: classes2.dex */
public class HotTopicRankLayout extends LinearLayout implements View.OnClickListener, p<b>, q {
    private View alP;
    private ImageView alQ;
    private f<c> kgb;
    private HotTopicTabRankListLayout knZ;
    private View koa;
    private View mBottomLine;
    private int mSkinType;
    private TextView mTitle;
    private View mTopLine;

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.mSkinType = 3;
        this.kgb = new f<c>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout.1
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
        this.alQ = (ImageView) findViewById(R.id.iv_into);
        this.alP = findViewById(R.id.layout_into);
        this.mTopLine = findViewById(R.id.divider_line_top);
        this.mBottomLine = findViewById(R.id.divider_line_bottom);
        this.koa = findViewById(R.id.title_layout);
        this.koa.setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds22));
        ViewGroup.LayoutParams layoutParams = this.koa.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.koa.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        this.knZ = new HotTopicTabRankListLayout(getContext());
        this.knZ.setOnItemCoverListener(this.kgb);
        linearLayout.addView(this.knZ);
        linearLayout.setPadding(0, 0, 0, l.getDimens(getContext(), R.dimen.tbds48));
        this.alQ.setClickable(false);
        this.alP.setOnClickListener(this);
        this.alQ.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(b bVar) {
        this.mTitle.setText(bVar.title != null ? bVar.title : "");
        this.knZ.a(bVar);
        this.mTopLine.setVisibility(0);
        this.mBottomLine.setVisibility(8);
        com.baidu.tbadk.a.b.b.bl(this.mTopLine);
        com.baidu.tieba.homepage.tabfeed.b.Mg("c13753");
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0108);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            SvgManager.bsR().a(this.alQ, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        this.mSkinType = i;
        com.baidu.tbadk.a.b.b.bm(this.mTopLine);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alP == view) {
        }
    }
}
