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
/* loaded from: classes21.dex */
public class RecommendBarLayout extends LinearLayout implements View.OnClickListener, q {
    private ImageView iFc;
    private CustomMessageListener iOF;
    private byte iPz;
    private ViewPager iQA;
    private RecommendBarPageAdapter iQB;
    private FrameLayout iQy;
    private TextView iQz;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.iOF = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.iQB.k(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.iPz = b;
        initUI();
        czU();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void czU() {
        this.iOF.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.iOF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.iOF);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.iQy = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.iQz = (TextView) findViewById(R.id.recommend_bar_title);
        this.iQA = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.iFc = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.iQA.setOffscreenPageLimit(2);
        this.iQB = new RecommendBarPageAdapter(this.pageContext, this.iPz);
        this.iQA.setAdapter(this.iQB);
        this.iQA.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                com.baidu.adp.widget.ListView.q zZ = RecommendBarLayout.this.iQB.zZ(i);
                if (zZ instanceof e) {
                    e eVar = (e) zZ;
                    aq ai = new aq("c14004").dF("uid", TbadkApplication.getCurrentAccount()).ai("obj_locate", RecommendBarLayout.this.iPz).ai("obj_param1", i);
                    if (!StringUtils.isNull(eVar.iPL)) {
                        ai = ai.dF("obj_name", eVar.iPL);
                    }
                    TiebaStatic.log(ai);
                    aq ai2 = new aq("c13643").dF("uid", TbadkApplication.getCurrentAccount()).dF("fid", eVar.czM()).ai("obj_locate", RecommendBarLayout.this.iPz);
                    TiebaStatic.log(StringUtils.isNull(eVar.iPL) ? ai2 : ai2.dF("obj_name", eVar.iPL));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iQy.setOnClickListener(this);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.iQz, R.color.cp_cont_b);
            SvgManager.bkl().a(this.iFc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iQB.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(d dVar) {
        if (dVar == null || y.isEmpty(dVar.czK())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.iQA.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), dVar.czL() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.iQA.setCurrentItem(0, true);
        this.iQB.a(dVar);
        TiebaStatic.log(new aq("c13907").dF("uid", TbadkApplication.getCurrentAccount()).ai("obj_locate", this.iPz));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            com.baidu.adp.widget.ListView.q zZ = this.iQB.zZ(this.iQA.getCurrentItem());
            if (zZ instanceof e) {
                e eVar = (e) zZ;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, eVar.aEb)));
                aq ai = new aq("c13645").dF("uid", TbadkApplication.getCurrentAccount()).ai("obj_locate", this.iPz);
                TiebaStatic.log(StringUtils.isNull(eVar.iPL) ? ai : ai.dF("obj_name", eVar.iPL));
            }
        }
    }
}
