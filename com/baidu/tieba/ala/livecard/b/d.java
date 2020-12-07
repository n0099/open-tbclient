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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.b<h> implements z {
    private View dividerLine;
    public int eHa;
    private boolean fhA;
    private int fhC;
    private IndicatorView fhv;
    private FrsAlaStageLiveViewItemAdapter hcA;
    private LinearLayout hcB;
    private View hcC;
    private h hcD;
    private com.baidu.tieba.ala.livecard.vc.a hcE;
    private com.baidu.tieba.ala.livecard.vc.b hcF;
    private com.baidu.tieba.ala.livecard.vc.c hcG;
    private ForbidParentSwipeBackRelativeLayout hcf;
    private boolean hci;
    private FrsAlaStageLiveViewPager hcz;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.fhA = false;
        this.fhC = 5;
        this.hci = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.hcF != null) {
                    int ru = d.this.hcF.ru(i + 1);
                    d.this.mCurrentIndex = ru;
                    if (d.this.fhv != null) {
                        d.this.fhv.setPosition(d.this.hcF.rv(ru));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.hcA.getCount()) >= 2) {
                    int currentItem = d.this.hcz.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.hcz.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.hcz.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.hcG = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, by byVar) {
                d.this.e(view, byVar);
                d.this.X(byVar);
                d.this.a(d.this.mTbPageContext, byVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, by byVar) {
                d.this.e(view, byVar);
            }
        };
        this.hcf = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.hcC = getView().findViewById(R.id.divider_pager_and_indicator);
        this.hcz = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.hcB = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.fhv = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.hcE = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.hcf);
        this.hcE.setUniqueId(getTag());
        this.hcz.setBackgroundResource(R.drawable.transparent_bg);
        this.hcz.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hcA = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.hcz.setAdapter(this.hcA);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.hci = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.hci = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.hcf.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.hcD != null && !y.isEmpty(d.this.hcD.njA) && d.this.hcD.njA.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hci);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hci);
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
        if (hVar != null && hVar.njA != null) {
            this.hcD = hVar;
            setVisibility(0);
            if (this.hcF == null) {
                this.hcF = new com.baidu.tieba.ala.livecard.vc.b(hVar.njA, this.fhA, this.fhC);
                this.hcF.rx(2);
                this.hcF.rw(6);
                this.hcF.ry(1);
            }
            this.hcF.cv(hVar.njA);
            this.hcA.setForumName(this.mForumName);
            this.hcA.a(this.hcF.bwH(), this.hcG);
            this.hcz.setCurrentItem(this.hcF.bwG(), false);
            if (hVar.njA.size() >= 2) {
                this.hcB.setVisibility(0);
                if (this.fhv.getCount() != this.hcF.bwF()) {
                    this.fhv.setCount(this.hcF.bwF());
                    this.mCurrentIndex = this.hcF.bwG();
                }
                this.fhv.setPosition(this.hcF.rv(this.mCurrentIndex));
            } else {
                this.hcB.setVisibility(8);
            }
            if (hVar.njA.size() > 0) {
                this.hcE.l(hVar.njA.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bZa();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZa() {
        int rv;
        if (this.hcD != null && y.isEmpty(this.hcD.njA) && (rv = this.hcF.rv(this.mCurrentIndex)) < this.hcD.njA.size() && rv >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.hcD.njA != null && this.hcD.njA.get(rv) != null) {
                this.hcD.njA.get(rv).eHa = this.eHa;
            }
            customMessage.setData(this.hcD.njA.get(rv));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.hcD.njA.get(rv) != null) {
                TiebaStatic.log(new ar("c12804").dY("tid", this.hcD.njA.get(rv).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(by byVar) {
        if (byVar.bpj() != null && byVar.bpj().user_info != null && byVar.bpj().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12805").dY("tid", byVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, by byVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(byVar);
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
    public void wi(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hcf, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hcC, R.color.CAM_X0204);
            this.mSkinType = i;
        }
        this.hcE.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, by byVar) {
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            if (byVar.bpj() != null && byVar.bpj().user_info != null) {
                alaLiveInfoCoreData.userName = byVar.bpj().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.hcD != null && !y.isEmpty(this.hcD.njA)) {
                for (by byVar2 : this.hcD.njA) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(by byVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
        alaLiveInfoCoreData.userName = byVar.boP().getUserName();
        return alaLiveInfoCoreData;
    }
}
