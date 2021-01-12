package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class RecommendBarLayout extends LinearLayout implements View.OnClickListener, q {
    private ImageView jIu;
    private CustomMessageListener jSP;
    private byte jTS;
    private FrameLayout jUR;
    private TextView jUS;
    private ViewPager jUT;
    private RecommendBarPageAdapter jUU;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b2) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.jSP = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.jUU.n(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.jTS = b2;
        initUI();
        cNq();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void cNq() {
        this.jSP.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jSP);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jSP);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.jUR = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.jUS = (TextView) findViewById(R.id.recommend_bar_title);
        this.jUT = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.jIu = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.jUT.setOffscreenPageLimit(2);
        this.jUU = new RecommendBarPageAdapter(this.pageContext, this.jTS);
        this.jUT.setAdapter(this.jUU);
        this.jUT.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                n Bg = RecommendBarLayout.this.jUU.Bg(i);
                if (Bg instanceof d) {
                    d dVar = (d) Bg;
                    aq an = new aq("c14004").dW("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", RecommendBarLayout.this.jTS).an("obj_param1", i);
                    if (!StringUtils.isNull(dVar.jUe)) {
                        an = an.dW("obj_name", dVar.jUe);
                    }
                    TiebaStatic.log(an);
                    aq an2 = new aq("c13643").dW("uid", TbadkApplication.getCurrentAccount()).dW("fid", dVar.cNi()).an("obj_locate", RecommendBarLayout.this.jTS);
                    TiebaStatic.log(StringUtils.isNull(dVar.jUe) ? an2 : an2.dW("obj_name", dVar.jUe));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jUR.setOnClickListener(this);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            c.bv(this.jUS).nX(R.string.F_X02).nV(R.color.CAM_X0105);
            SvgManager.bsx().a(this.jIu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jUU.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar == null || x.isEmpty(cVar.cNg())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.jUT.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), cVar.cNh() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.jUT.setCurrentItem(0, true);
        this.jUU.a(cVar);
        TiebaStatic.log(new aq("c13907").dW("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jTS));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            n Bg = this.jUU.Bg(this.jUT.getCurrentItem());
            if (Bg instanceof d) {
                d dVar = (d) Bg;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, dVar.aEU)));
                aq an = new aq("c13645").dW("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jTS);
                TiebaStatic.log(StringUtils.isNull(dVar.jUe) ? an : an.dW("obj_name", dVar.jUe));
            }
        }
    }
}
