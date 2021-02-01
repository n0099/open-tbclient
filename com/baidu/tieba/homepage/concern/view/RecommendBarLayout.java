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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.adapter.RecommendBarPageAdapter;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class RecommendBarLayout extends LinearLayout implements View.OnClickListener, q {
    private ImageView jPr;
    private CustomMessageListener kaq;
    private byte kbt;
    private FrameLayout kcs;
    private TextView kct;
    private ViewPager kcu;
    private RecommendBarPageAdapter kcv;
    private final Context mContext;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private BdUniqueId pageId;

    public RecommendBarLayout(TbPageContext<?> tbPageContext, Context context, BdUniqueId bdUniqueId, byte b2) {
        super(context, null, 0);
        this.mSkinType = 3;
        this.kaq = new CustomMessageListener(0) { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RecommendBarLayout.this.kcv.n(longValue, customResponsedMessage.getCmd() == 2001335);
                    }
                }
            }
        };
        this.pageId = bdUniqueId;
        this.mContext = context;
        this.pageContext = tbPageContext;
        this.kbt = b2;
        initUI();
        cPm();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.pageId = bdUniqueId;
    }

    private void cPm() {
        this.kaq.setTag(this.pageId);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIKE_FORUM, this.kaq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UNLIKE_FORUM, this.kaq);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_bar_card, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.kcs = (FrameLayout) findViewById(R.id.recommend_bar_top);
        this.kct = (TextView) findViewById(R.id.recommend_bar_title);
        this.kcu = (ViewPager) findViewById(R.id.recommend_bar_view_pager);
        this.jPr = (ImageView) findViewById(R.id.recommend_bar_right_arrow);
        this.kcu.setOffscreenPageLimit(2);
        this.kcv = new RecommendBarPageAdapter(this.pageContext, this.kbt);
        this.kcu.setAdapter(this.kcv);
        this.kcu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.concern.view.RecommendBarLayout.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                n Bv = RecommendBarLayout.this.kcv.Bv(i);
                if (Bv instanceof d) {
                    d dVar = (d) Bv;
                    ar ap = new ar("c14004").dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", RecommendBarLayout.this.kbt).ap("obj_param1", i);
                    if (!StringUtils.isNull(dVar.kbF)) {
                        ap = ap.dR("obj_name", dVar.kbF);
                    }
                    TiebaStatic.log(ap);
                    ar ap2 = new ar("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", dVar.cPe()).ap("obj_locate", RecommendBarLayout.this.kbt);
                    TiebaStatic.log(StringUtils.isNull(dVar.kbF) ? ap2 : ap2.dR("obj_name", dVar.kbF));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kcs.setOnClickListener(this);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            c.br(this.kct).oa(R.string.F_X02).nY(R.color.CAM_X0105);
            SvgManager.bsR().a(this.jPr, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.kcv.onSkinTypeChanged(i);
        }
        this.mSkinType = i;
    }

    public void setData(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar == null || y.isEmpty(cVar.cPc())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((LinearLayout.LayoutParams) this.kcu.getLayoutParams()).height = l.getDimens(this.pageContext.getPageActivity(), cVar.cPd() ? R.dimen.tbds660 : R.dimen.tbds728);
        this.kcu.setCurrentItem(0, true);
        this.kcv.a(cVar);
        TiebaStatic.log(new ar("c13907").dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbt));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.recommend_bar_top) {
            n Bv = this.kcv.Bv(this.kcu.getCurrentItem());
            if (Bv instanceof d) {
                d dVar = (d) Bv;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(this.mContext, dVar.aHq)));
                ar ap = new ar("c13645").dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbt);
                TiebaStatic.log(StringUtils.isNull(dVar.kbF) ? ap : ap.dR("obj_name", dVar.kbF));
            }
        }
    }
}
