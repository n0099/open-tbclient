package com.baidu.tieba.homepage.concern.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes22.dex */
public class RecommendBarLayout extends LinearLayout implements View.OnClickListener, q {
    private ImageView jgo;
    private CustomMessageListener jpV;
    private byte jqR;
    private FrameLayout jrQ;
    private TextView jrR;
    private ViewPager jrS;
    private RecommendBarPageAdapter jrT;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.jpV = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.jrT.l(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.jqR = b;
        initUI();
        cGF();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void cGF() {
        this.jpV.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jpV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jpV);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.jrQ = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.jrR = (TextView) findViewById(R.id.recommend_bar_title);
        this.jrS = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.jgo = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.jrS.setOffscreenPageLimit(2);
        this.jrT = new RecommendBarPageAdapter(this.pageContext, this.jqR);
        this.jrS.setAdapter(this.jrT);
        this.jrS.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                com.baidu.adp.widget.ListView.q AY = RecommendBarLayout.this.jrT.AY(i);
                if (AY instanceof e) {
                    e eVar = (e) AY;
                    aq aj = new aq("c14004").dR("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", RecommendBarLayout.this.jqR).aj("obj_param1", i);
                    if (!StringUtils.isNull(eVar.jrd)) {
                        aj = aj.dR("obj_name", eVar.jrd);
                    }
                    TiebaStatic.log(aj);
                    aq aj2 = new aq("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", eVar.cGx()).aj("obj_locate", RecommendBarLayout.this.jqR);
                    TiebaStatic.log(StringUtils.isNull(eVar.jrd) ? aj2 : aj2.dR("obj_name", eVar.jrd));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jrQ.setOnClickListener(this);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.jrR, R.color.cp_cont_b);
            SvgManager.boN().a(this.jgo, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jrT.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(d dVar) {
        if (dVar == null || y.isEmpty(dVar.cGv())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.jrS.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), dVar.cGw() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.jrS.setCurrentItem(0, true);
        this.jrT.a(dVar);
        TiebaStatic.log(new aq("c13907").dR("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jqR));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            com.baidu.adp.widget.ListView.q AY = this.jrT.AY(this.jrS.getCurrentItem());
            if (AY instanceof e) {
                e eVar = (e) AY;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, eVar.aHs)));
                aq aj = new aq("c13645").dR("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jqR);
                TiebaStatic.log(StringUtils.isNull(eVar.jrd) ? aj : aj.dR("obj_name", eVar.jrd));
            }
        }
    }
}
