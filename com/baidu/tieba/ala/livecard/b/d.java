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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    public int dDb;
    private IndicatorView dZi;
    private boolean dZn;
    private int dZp;
    private View dividerLine;
    private ForbidParentSwipeBackRelativeLayout fGI;
    private boolean fGL;
    private FrsAlaStageLiveViewPager fHc;
    private FrsAlaStageLiveViewItemAdapter fHd;
    private LinearLayout fHe;
    private View fHf;
    private h fHg;
    private com.baidu.tieba.ala.livecard.vc.a fHh;
    private com.baidu.tieba.ala.livecard.vc.b fHi;
    private com.baidu.tieba.ala.livecard.vc.c fHj;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dZn = false;
        this.dZp = 5;
        this.fGL = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.fHi != null) {
                    int ms = d.this.fHi.ms(i + 1);
                    d.this.mCurrentIndex = ms;
                    if (d.this.dZi != null) {
                        d.this.dZi.setPosition(d.this.fHi.mt(ms));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.fHd.getCount()) >= 2) {
                    int currentItem = d.this.fHc.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.fHc.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.fHc.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.fHj = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bk bkVar) {
                d.this.e(view, bkVar);
                d.this.W(bkVar);
                d.this.a(d.this.mTbPageContext, bkVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bk bkVar) {
                d.this.e(view, bkVar);
            }
        };
        this.fGI = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fHf = getView().findViewById(R.id.divider_pager_and_indicator);
        this.fHc = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.fHe = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dZi = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.fHh = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.fGI);
        this.fHh.setUniqueId(getTag());
        this.fHc.setBackgroundResource(R.drawable.transparent_bg);
        this.fHc.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fHd = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.fHc.setAdapter(this.fHd);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fGL = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fGL = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fGI.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.fHg != null && !v.isEmpty(d.this.fHg.liB) && d.this.fHg.liB.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fGL);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fGL);
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
        if (hVar != null && hVar.liB != null) {
            this.fHg = hVar;
            setVisibility(0);
            if (this.fHi == null) {
                this.fHi = new com.baidu.tieba.ala.livecard.vc.b(hVar.liB, this.dZn, this.dZp);
                this.fHi.mv(2);
                this.fHi.mu(6);
                this.fHi.mw(1);
            }
            this.fHi.bE(hVar.liB);
            this.fHd.setForumName(this.mForumName);
            this.fHd.a(this.fHi.aXk(), this.fHj);
            this.fHc.setCurrentItem(this.fHi.aXj(), false);
            if (hVar.liB.size() >= 2) {
                this.fHe.setVisibility(0);
                if (this.dZi.getCount() != this.fHi.aXi()) {
                    this.dZi.setCount(this.fHi.aXi());
                    this.mCurrentIndex = this.fHi.aXj();
                }
                this.dZi.setPosition(this.fHi.mt(this.mCurrentIndex));
            } else {
                this.fHe.setVisibility(8);
            }
            if (hVar.liB.size() > 0) {
                this.fHh.e(hVar.liB.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bwk();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bwk() {
        int mt;
        if (this.fHg != null && v.isEmpty(this.fHg.liB) && (mt = this.fHi.mt(this.mCurrentIndex)) < this.fHg.liB.size() && mt >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.fHg.liB != null && this.fHg.liB.get(mt) != null) {
                this.fHg.liB.get(mt).dDb = this.dDb;
            }
            customMessage.setData(this.fHg.liB.get(mt));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.fHg.liB.get(mt) != null) {
                TiebaStatic.log(new an("c12804").dh("tid", this.fHg.liB.get(mt).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(bk bkVar) {
        if (bkVar.aQS() != null && bkVar.aQS().user_info != null && bkVar.aQS().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").dh("tid", bkVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bk bkVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bkVar);
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
    public void qw(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGI, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fHf, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.fHh.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bk bkVar) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            if (bkVar.aQS() != null && bkVar.aQS().user_info != null) {
                alaLiveInfoCoreData.userName = bkVar.aQS().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fHg != null && !v.isEmpty(this.fHg.liB)) {
                for (bk bkVar2 : this.fHg.liB) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }
}
