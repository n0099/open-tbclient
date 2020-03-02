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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.x;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<g> implements x {
    public int cPF;
    private View dividerLine;
    private int dkA;
    private IndicatorView dkt;
    private boolean dky;
    private ForbidParentSwipeBackRelativeLayout eNG;
    private boolean eNJ;
    private FrsAlaStageLiveViewPager eOa;
    private FrsAlaStageLiveViewItemAdapter eOb;
    private LinearLayout eOc;
    private View eOd;
    private g eOe;
    private com.baidu.tieba.ala.livecard.vc.a eOf;
    private com.baidu.tieba.ala.livecard.vc.b eOg;
    private com.baidu.tieba.ala.livecard.vc.c eOh;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dky = false;
        this.dkA = 5;
        this.eNJ = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.eOg != null) {
                    int lB = d.this.eOg.lB(i + 1);
                    d.this.mCurrentIndex = lB;
                    if (d.this.dkt != null) {
                        d.this.dkt.setPosition(d.this.eOg.lC(lB));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.eOb.getCount()) >= 2) {
                    int currentItem = d.this.eOa.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.eOa.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.eOa.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.eOh = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void b(View view, bj bjVar) {
                d.this.d(view, bjVar);
                d.this.U(bjVar);
                d.this.a(d.this.mTbPageContext, bjVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bj bjVar) {
                d.this.d(view, bjVar);
            }
        };
        this.eNG = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.eOd = getView().findViewById(R.id.divider_pager_and_indicator);
        this.eOa = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.eOc = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dkt = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.eOf = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.eNG);
        this.eOf.setUniqueId(getTag());
        this.eOa.setBackgroundResource(R.drawable.transparent_bg);
        this.eOa.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eOb = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.eOa.setAdapter(this.eOb);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.eNJ = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.eNJ = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.eNG.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.eOe != null && !v.isEmpty(d.this.eOe.ken) && d.this.eOe.ken.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eNJ);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eNJ);
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
        if (gVar != null && gVar.ken != null) {
            this.eOe = gVar;
            setVisibility(0);
            if (this.eOg == null) {
                this.eOg = new com.baidu.tieba.ala.livecard.vc.b(gVar.ken, this.dky, this.dkA);
                this.eOg.lE(2);
                this.eOg.lD(6);
                this.eOg.lF(1);
            }
            this.eOg.ac(gVar.ken);
            this.eOb.setForumName(this.mForumName);
            this.eOb.a(this.eOg.aIF(), this.eOh);
            this.eOa.setCurrentItem(this.eOg.aIE(), false);
            if (gVar.ken.size() >= 2) {
                this.eOc.setVisibility(0);
                if (this.dkt.getCount() != this.eOg.aID()) {
                    this.dkt.setCount(this.eOg.aID());
                    this.mCurrentIndex = this.eOg.aIE();
                }
                this.dkt.setPosition(this.eOg.lC(this.mCurrentIndex));
            } else {
                this.eOc.setVisibility(8);
            }
            if (gVar.ken.size() > 0) {
                this.eOf.e(gVar.ken.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bgY();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bgY() {
        int lC;
        if (this.eOe != null && v.isEmpty(this.eOe.ken) && (lC = this.eOg.lC(this.mCurrentIndex)) < this.eOe.ken.size() && lC >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.eOe.ken != null && this.eOe.ken.get(lC) != null) {
                this.eOe.ken.get(lC).cPF = this.cPF;
            }
            customMessage.setData(this.eOe.ken.get(lC));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.eOe.ken.get(lC) != null) {
                TiebaStatic.log(new an("c12804").cy("tid", this.eOe.ken.get(lC).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(bj bjVar) {
        if (bjVar.aCH() != null && bjVar.aCH().user_info != null && bjVar.aCH().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").cy("tid", bjVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, bj bjVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bjVar);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNG, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOd, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.eOf.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            if (bjVar.aCH() != null && bjVar.aCH().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.aCH().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.eOe != null && !v.isEmpty(this.eOe.ken)) {
                for (bj bjVar2 : this.eOe.ken) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
        alaLiveInfoCoreData.userName = bjVar.aCo().getUserName();
        return alaLiveInfoCoreData;
    }
}
