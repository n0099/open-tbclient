package com.baidu.tieba.ala.livecard.b;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<g> implements z {
    private int apR;
    public int cez;
    private IndicatorView ctd;
    private boolean cti;
    private int ctk;
    private ForbidParentSwipeBackRelativeLayout dTM;
    private boolean dTP;
    private FrsAlaStageLiveViewPager dUh;
    private FrsAlaStageLiveViewItemAdapter dUi;
    private LinearLayout dUj;
    private View dUk;
    private g dUl;
    private com.baidu.tieba.ala.livecard.vc.a dUm;
    private com.baidu.tieba.ala.livecard.vc.b dUn;
    private com.baidu.tieba.ala.livecard.vc.c dUo;
    private View dividerLine;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.apR = 1;
        this.cti = false;
        this.ctk = 5;
        this.dTP = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.apR = i;
                if (d.this.dUn != null) {
                    int iY = d.this.dUn.iY(i + 1);
                    d.this.apR = iY;
                    if (d.this.ctd != null) {
                        d.this.ctd.setPosition(d.this.dUn.iZ(iY));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.dUi.getCount()) >= 2) {
                    int currentItem = d.this.dUh.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.dUh.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.dUh.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.dUo = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void b(View view, bh bhVar) {
                d.this.d(view, bhVar);
                d.this.O(bhVar);
                d.this.a(d.this.mTbPageContext, bhVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bh bhVar) {
                d.this.d(view, bhVar);
            }
        };
        this.dTM = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.dUk = getView().findViewById(R.id.divider_pager_and_indicator);
        this.dUh = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.dUj = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.ctd = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.dUm = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.dTM);
        this.dUm.setUniqueId(getTag());
        this.dUh.setBackgroundResource(R.drawable.transparent_bg);
        this.dUh.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dUi = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.dUh.setAdapter(this.dUi);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.dTP = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.dTP = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.dTM.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.dUl != null && !v.isEmpty(d.this.dUl.jgi) && d.this.dUl.jgi.size() > 1) {
                    if (d.this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
                        ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(false);
                    } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(false);
                    }
                }
            }

            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void enableSwipeBack() {
                if (d.this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.dTP);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.dTP);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_stage_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
        if (gVar != null && gVar.jgi != null) {
            this.dUl = gVar;
            setVisibility(0);
            if (this.dUn == null) {
                this.dUn = new com.baidu.tieba.ala.livecard.vc.b(gVar.jgi, this.cti, this.ctk);
                this.dUn.jb(2);
                this.dUn.ja(6);
                this.dUn.jc(1);
            }
            this.dUn.aY(gVar.jgi);
            this.dUi.setForumName(this.mForumName);
            this.dUi.a(this.dUn.aou(), this.dUo);
            this.dUh.setCurrentItem(this.dUn.aot(), false);
            if (gVar.jgi.size() >= 2) {
                this.dUj.setVisibility(0);
                if (this.ctd.getCount() != this.dUn.aos()) {
                    this.ctd.setCount(this.dUn.aos());
                    this.apR = this.dUn.aot();
                }
                this.ctd.setPosition(this.dUn.iZ(this.apR));
            } else {
                this.dUj.setVisibility(8);
            }
            if (gVar.jgi.size() > 0) {
                this.dUm.c(gVar.jgi.get(0), "ala_frs_stage_live_feed_back_type");
            }
            aMO();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aMO() {
        int iZ;
        if (this.dUl != null && v.isEmpty(this.dUl.jgi) && (iZ = this.dUn.iZ(this.apR)) < this.dUl.jgi.size() && iZ >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.dUl.jgi != null && this.dUl.jgi.get(iZ) != null) {
                this.dUl.jgi.get(iZ).cez = this.cez;
            }
            customMessage.setData(this.dUl.jgi.get(iZ));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.dUl.jgi.get(iZ) != null) {
                TiebaStatic.log(new an("c12804").bS("tid", this.dUl.jgi.get(iZ).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(bh bhVar) {
        if (bhVar.aiZ() != null && bhVar.aiZ().user_info != null && bhVar.aiZ().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").bS("tid", bhVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, bh bhVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bhVar);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTM, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dUk, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.dUm.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            if (bhVar.aiZ() != null && bhVar.aiZ().user_info != null) {
                alaLiveInfoCoreData.userName = bhVar.aiZ().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.dUl != null && !v.isEmpty(this.dUl.jgi)) {
                for (bh bhVar2 : this.dUl.jgi) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
        alaLiveInfoCoreData.userName = bhVar.aiG().getUserName();
        return alaLiveInfoCoreData;
    }
}
