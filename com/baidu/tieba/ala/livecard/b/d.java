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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    private View dividerLine;
    private boolean eAD;
    private int eAF;
    private IndicatorView eAy;
    public int ebp;
    private ForbidParentSwipeBackRelativeLayout gmF;
    private boolean gmI;
    private FrsAlaStageLiveViewPager gmZ;
    private FrsAlaStageLiveViewItemAdapter gna;
    private LinearLayout gnb;
    private View gnc;
    private h gnd;
    private com.baidu.tieba.ala.livecard.vc.a gne;
    private com.baidu.tieba.ala.livecard.vc.b gnf;
    private com.baidu.tieba.ala.livecard.vc.c gng;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.eAD = false;
        this.eAF = 5;
        this.gmI = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gnf != null) {
                    int pC = d.this.gnf.pC(i + 1);
                    d.this.mCurrentIndex = pC;
                    if (d.this.eAy != null) {
                        d.this.eAy.setPosition(d.this.gnf.pD(pC));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gna.getCount()) >= 2) {
                    int currentItem = d.this.gmZ.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gmZ.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gmZ.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gng = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bw bwVar) {
                d.this.e(view, bwVar);
                d.this.V(bwVar);
                d.this.a(d.this.mTbPageContext, bwVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bw bwVar) {
                d.this.e(view, bwVar);
            }
        };
        this.gmF = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gnc = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gmZ = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gnb = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eAy = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gne = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gmF);
        this.gne.setUniqueId(getTag());
        this.gmZ.setBackgroundResource(R.drawable.transparent_bg);
        this.gmZ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gna = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gmZ.setAdapter(this.gna);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gmI = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gmI = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gmF.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gnd != null && !com.baidu.tbadk.core.util.y.isEmpty(d.this.gnd.mmu) && d.this.gnd.mmu.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gmI);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gmI);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_stage_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.mmu != null) {
            this.gnd = hVar;
            setVisibility(0);
            if (this.gnf == null) {
                this.gnf = new com.baidu.tieba.ala.livecard.vc.b(hVar.mmu, this.eAD, this.eAF);
                this.gnf.pF(2);
                this.gnf.pE(6);
                this.gnf.pG(1);
            }
            this.gnf.bX(hVar.mmu);
            this.gna.setForumName(this.mForumName);
            this.gna.a(this.gnf.bmO(), this.gng);
            this.gmZ.setCurrentItem(this.gnf.bmN(), false);
            if (hVar.mmu.size() >= 2) {
                this.gnb.setVisibility(0);
                if (this.eAy.getCount() != this.gnf.bmM()) {
                    this.eAy.setCount(this.gnf.bmM());
                    this.mCurrentIndex = this.gnf.bmN();
                }
                this.eAy.setPosition(this.gnf.pD(this.mCurrentIndex));
            } else {
                this.gnb.setVisibility(8);
            }
            if (hVar.mmu.size() > 0) {
                this.gne.l(hVar.mmu.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bNb();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bNb() {
        int pD;
        if (this.gnd != null && com.baidu.tbadk.core.util.y.isEmpty(this.gnd.mmu) && (pD = this.gnf.pD(this.mCurrentIndex)) < this.gnd.mmu.size() && pD >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gnd.mmu != null && this.gnd.mmu.get(pD) != null) {
                this.gnd.mmu.get(pD).ebp = this.ebp;
            }
            customMessage.setData(this.gnd.mmu.get(pD));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gnd.mmu.get(pD) != null) {
                TiebaStatic.log(new aq("c12804").dF("tid", this.gnd.mmu.get(pD).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bw bwVar) {
        if (bwVar.bfS() != null && bwVar.bfS().user_info != null && bwVar.bfS().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dF("tid", bwVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bw bwVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bwVar);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmF, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gnc, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.gne.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bfy().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
            if (bwVar.bfS() != null && bwVar.bfS().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.bfS().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gnd != null && !com.baidu.tbadk.core.util.y.isEmpty(this.gnd.mmu)) {
                for (bw bwVar2 : this.gnd.mmu) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
        alaLiveInfoCoreData.userName = bwVar.bfy().getUserName();
        return alaLiveInfoCoreData;
    }
}
