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
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public class RecommendBarLayout extends LinearLayout implements View.OnClickListener, q {
    private ImageView jmX;
    private CustomMessageListener jwE;
    private byte jxF;
    private FrameLayout jyE;
    private TextView jyF;
    private ViewPager jyG;
    private RecommendBarPageAdapter jyH;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.jwE = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.jyH.l(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.jxF = b;
        initUI();
        cIL();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void cIL() {
        this.jwE.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jwE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jwE);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.jyE = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.jyF = (TextView) findViewById(R.id.recommend_bar_title);
        this.jyG = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.jmX = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.jyG.setOffscreenPageLimit(2);
        this.jyH = new RecommendBarPageAdapter(this.pageContext, this.jxF);
        this.jyG.setAdapter(this.jyH);
        this.jyG.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                com.baidu.adp.widget.ListView.q BJ = RecommendBarLayout.this.jyH.BJ(i);
                if (BJ instanceof d) {
                    d dVar = (d) BJ;
                    ar ak = new ar("c14004").dR("uid", TbadkApplication.getCurrentAccount()).ak("obj_locate", RecommendBarLayout.this.jxF).ak("obj_param1", i);
                    if (!StringUtils.isNull(dVar.jxR)) {
                        ak = ak.dR("obj_name", dVar.jxR);
                    }
                    TiebaStatic.log(ak);
                    ar ak2 = new ar("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", dVar.cID()).ak("obj_locate", RecommendBarLayout.this.jxF);
                    TiebaStatic.log(StringUtils.isNull(dVar.jxR) ? ak2 : ak2.dR("obj_name", dVar.jxR));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jyE.setOnClickListener(this);
        if (com.baidu.tbadk.a.d.bhw()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jyF.getLayoutParams();
            marginLayoutParams.leftMargin = l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007);
            this.jyF.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            c.bj(this.jyF).oV(R.string.F_X02).oT(R.color.CAM_X0105);
            SvgManager.bqB().a(this.jmX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jyH.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar == null || y.isEmpty(cVar.cIB())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.jyG.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), cVar.cIC() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.jyG.setCurrentItem(0, true);
        this.jyH.a(cVar);
        TiebaStatic.log(new ar("c13907").dR("uid", TbadkApplication.getCurrentAccount()).ak("obj_locate", this.jxF));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            com.baidu.adp.widget.ListView.q BJ = this.jyH.BJ(this.jyG.getCurrentItem());
            if (BJ instanceof d) {
                d dVar = (d) BJ;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, dVar.aGz)));
                ar ak = new ar("c13645").dR("uid", TbadkApplication.getCurrentAccount()).ak("obj_locate", this.jxF);
                TiebaStatic.log(StringUtils.isNull(dVar.jxR) ? ak : ak.dR("obj_name", dVar.jxR));
            }
        }
    }
}
