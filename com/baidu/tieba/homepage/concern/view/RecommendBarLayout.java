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
    private ImageView jAz;
    private CustomMessageListener jKg;
    private byte jLh;
    private FrameLayout jMg;
    private TextView jMh;
    private ViewPager jMi;
    private RecommendBarPageAdapter jMj;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.jKg = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.jMj.l(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.jLh = b;
        initUI();
        cOa();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void cOa() {
        this.jKg.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.jKg);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.jKg);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.jMg = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.jMh = (TextView) findViewById(R.id.recommend_bar_title);
        this.jMi = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.jAz = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.jMi.setOffscreenPageLimit(2);
        this.jMj = new RecommendBarPageAdapter(this.pageContext, this.jLh);
        this.jMi.setAdapter(this.jMj);
        this.jMi.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                com.baidu.adp.widget.ListView.q Cy = RecommendBarLayout.this.jMj.Cy(i);
                if (Cy instanceof d) {
                    d dVar = (d) Cy;
                    ar al = new ar("c14004").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", RecommendBarLayout.this.jLh).al("obj_param1", i);
                    if (!StringUtils.isNull(dVar.jLt)) {
                        al = al.dY("obj_name", dVar.jLt);
                    }
                    TiebaStatic.log(al);
                    ar al2 = new ar("c13643").dY("uid", TbadkApplication.getCurrentAccount()).dY("fid", dVar.cNS()).al("obj_locate", RecommendBarLayout.this.jLh);
                    TiebaStatic.log(StringUtils.isNull(dVar.jLt) ? al2 : al2.dY("obj_name", dVar.jLt));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jMg.setOnClickListener(this);
        if (com.baidu.tbadk.a.d.bkA()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jMh.getLayoutParams();
            marginLayoutParams.leftMargin = l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007);
            this.jMh.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            c.bm(this.jMh).pu(R.string.F_X02).ps(R.color.CAM_X0105);
            SvgManager.btW().a(this.jAz, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jMj.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar == null || y.isEmpty(cVar.cNQ())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.jMi.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), cVar.cNR() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.jMi.setCurrentItem(0, true);
        this.jMj.a(cVar);
        TiebaStatic.log(new ar("c13907").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLh));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            com.baidu.adp.widget.ListView.q Cy = this.jMj.Cy(this.jMi.getCurrentItem());
            if (Cy instanceof d) {
                d dVar = (d) Cy;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, dVar.aJj)));
                ar al = new ar("c13645").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLh);
                TiebaStatic.log(StringUtils.isNull(dVar.jLt) ? al : al.dY("obj_name", dVar.jLt));
            }
        }
    }
}
