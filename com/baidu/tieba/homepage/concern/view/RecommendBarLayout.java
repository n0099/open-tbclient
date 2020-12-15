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
/* loaded from: classes22.dex */
public class RecommendBarLayout extends LinearLayout implements View.OnClickListener, q {
    private ImageView jAB;
    private CustomMessageListener jKi;
    private byte jLj;
    private FrameLayout jMi;
    private TextView jMj;
    private ViewPager jMk;
    private RecommendBarPageAdapter jMl;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.jKi = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.jMl.l(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.jLj = b;
        initUI();
        cOb();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void cOb() {
        this.jKi.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jKi);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jKi);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.jMi = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.jMj = (TextView) findViewById(R.id.recommend_bar_title);
        this.jMk = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.jAB = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.jMk.setOffscreenPageLimit(2);
        this.jMl = new RecommendBarPageAdapter(this.pageContext, this.jLj);
        this.jMk.setAdapter(this.jMl);
        this.jMk.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                com.baidu.adp.widget.ListView.q Cy = RecommendBarLayout.this.jMl.Cy(i);
                if (Cy instanceof d) {
                    d dVar = (d) Cy;
                    ar al = new ar("c14004").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", RecommendBarLayout.this.jLj).al("obj_param1", i);
                    if (!StringUtils.isNull(dVar.jLv)) {
                        al = al.dY("obj_name", dVar.jLv);
                    }
                    TiebaStatic.log(al);
                    ar al2 = new ar("c13643").dY("uid", TbadkApplication.getCurrentAccount()).dY("fid", dVar.cNT()).al("obj_locate", RecommendBarLayout.this.jLj);
                    TiebaStatic.log(StringUtils.isNull(dVar.jLv) ? al2 : al2.dY("obj_name", dVar.jLv));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jMi.setOnClickListener(this);
        if (com.baidu.tbadk.a.d.bkA()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jMj.getLayoutParams();
            marginLayoutParams.leftMargin = l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007);
            this.jMj.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            c.bm(this.jMj).pu(R.string.F_X02).ps(R.color.CAM_X0105);
            SvgManager.btW().a(this.jAB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jMl.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar == null || y.isEmpty(cVar.cNR())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.jMk.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), cVar.cNS() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.jMk.setCurrentItem(0, true);
        this.jMl.a(cVar);
        TiebaStatic.log(new ar("c13907").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLj));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            com.baidu.adp.widget.ListView.q Cy = this.jMl.Cy(this.jMk.getCurrentItem());
            if (Cy instanceof d) {
                d dVar = (d) Cy;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, dVar.aJj)));
                ar al = new ar("c13645").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLj);
                TiebaStatic.log(StringUtils.isNull(dVar.jLv) ? al : al.dY("obj_name", dVar.jLv));
            }
        }
    }
}
