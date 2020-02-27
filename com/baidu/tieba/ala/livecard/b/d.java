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
    public int cPE;
    private View dividerLine;
    private IndicatorView dks;
    private boolean dkx;
    private int dkz;
    private ForbidParentSwipeBackRelativeLayout eNF;
    private boolean eNI;
    private FrsAlaStageLiveViewPager eNZ;
    private FrsAlaStageLiveViewItemAdapter eOa;
    private LinearLayout eOb;
    private View eOc;
    private g eOd;
    private com.baidu.tieba.ala.livecard.vc.a eOe;
    private com.baidu.tieba.ala.livecard.vc.b eOf;
    private com.baidu.tieba.ala.livecard.vc.c eOg;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dkx = false;
        this.dkz = 5;
        this.eNI = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.eOf != null) {
                    int lB = d.this.eOf.lB(i + 1);
                    d.this.mCurrentIndex = lB;
                    if (d.this.dks != null) {
                        d.this.dks.setPosition(d.this.eOf.lC(lB));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.eOa.getCount()) >= 2) {
                    int currentItem = d.this.eNZ.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.eNZ.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.eNZ.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.eOg = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
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
        this.eNF = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.eOc = getView().findViewById(R.id.divider_pager_and_indicator);
        this.eNZ = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.eOb = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dks = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.eOe = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.eNF);
        this.eOe.setUniqueId(getTag());
        this.eNZ.setBackgroundResource(R.drawable.transparent_bg);
        this.eNZ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eOa = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.eNZ.setAdapter(this.eOa);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.eNI = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.eNI = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.eNF.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.eOd != null && !v.isEmpty(d.this.eOd.kel) && d.this.eOd.kel.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eNI);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eNI);
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
        if (gVar != null && gVar.kel != null) {
            this.eOd = gVar;
            setVisibility(0);
            if (this.eOf == null) {
                this.eOf = new com.baidu.tieba.ala.livecard.vc.b(gVar.kel, this.dkx, this.dkz);
                this.eOf.lE(2);
                this.eOf.lD(6);
                this.eOf.lF(1);
            }
            this.eOf.ac(gVar.kel);
            this.eOa.setForumName(this.mForumName);
            this.eOa.a(this.eOf.aID(), this.eOg);
            this.eNZ.setCurrentItem(this.eOf.aIC(), false);
            if (gVar.kel.size() >= 2) {
                this.eOb.setVisibility(0);
                if (this.dks.getCount() != this.eOf.aIB()) {
                    this.dks.setCount(this.eOf.aIB());
                    this.mCurrentIndex = this.eOf.aIC();
                }
                this.dks.setPosition(this.eOf.lC(this.mCurrentIndex));
            } else {
                this.eOb.setVisibility(8);
            }
            if (gVar.kel.size() > 0) {
                this.eOe.e(gVar.kel.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bgW();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bgW() {
        int lC;
        if (this.eOd != null && v.isEmpty(this.eOd.kel) && (lC = this.eOf.lC(this.mCurrentIndex)) < this.eOd.kel.size() && lC >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.eOd.kel != null && this.eOd.kel.get(lC) != null) {
                this.eOd.kel.get(lC).cPE = this.cPE;
            }
            customMessage.setData(this.eOd.kel.get(lC));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.eOd.kel.get(lC) != null) {
                TiebaStatic.log(new an("c12804").cy("tid", this.eOd.kel.get(lC).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(bj bjVar) {
        if (bjVar.aCF() != null && bjVar.aCF().user_info != null && bjVar.aCF().user_info.is_official == 2) {
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
            am.setBackgroundResource(this.eNF, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOc, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.eOe.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCm().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
            if (bjVar.aCF() != null && bjVar.aCF().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.aCF().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.eOd != null && !v.isEmpty(this.eOd.kel)) {
                for (bj bjVar2 : this.eOd.kel) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
        alaLiveInfoCoreData.userName = bjVar.aCm().getUserName();
        return alaLiveInfoCoreData;
    }
}
