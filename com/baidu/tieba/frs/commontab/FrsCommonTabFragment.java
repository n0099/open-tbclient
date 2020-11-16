package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, as, au {
    public String forumId;
    public String forumName;
    private VoiceManager iIc;
    private am iIv;
    private com.baidu.tbadk.k.c iOp;
    protected b iQU;
    protected c iQV;
    public FrsViewData iQW;
    public boolean iQX;
    public boolean iQY;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int iQZ = 3;
    private boolean iRa = true;
    private int dHY = 0;
    private int iJb = 0;
    private int sortType = 0;
    private CustomMessageListener iLE = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.zM(num.intValue());
            }
        }
    };
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.iQU != null) {
                        FrsCommonTabFragment.this.iQU.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.iOp != null && FrsCommonTabFragment.this.iOp.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.iQU != null) {
                        FrsCommonTabFragment.this.iQU.ld(true);
                    }
                    FrsCommonTabFragment.this.brR();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener iRb = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.iQU.Ka(str);
                }
            }
        }
    };
    private CustomMessageListener iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cyR = FrsCommonTabFragment.this.iQU.cyR();
                    if (cyR != null && cyR.dww() != null && (cyR.dww().getTag() instanceof am)) {
                        FrsCommonTabFragment.this.iIv = (am) cyR.dww().getTag();
                    }
                    if (FrsCommonTabFragment.this.iIv != null && FrsCommonTabFragment.this.iIv.tW() != null) {
                        FrsCommonTabFragment.this.iIv.tW().b(new a.C0096a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.iJb += i2;
            if (FrsCommonTabFragment.this.iJb >= FrsCommonTabFragment.this.dHY * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.t.c.dIO().b(FrsCommonTabFragment.this.getUniqueId(), true);
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt("tab_id");
            this.tabType = bundle.getInt("tab_type");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("name");
            this.iQY = bundle.getBoolean("can_auto_play_video");
            this.iQX = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.iQW = (FrsViewData) bundle.getSerializable("view_data");
            if (this.isGeneralTab != 1) {
                this.sortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.tabType = arguments.getInt("tab_type");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.forumName = arguments.getString("name");
                this.iQY = arguments.getBoolean("can_auto_play_video");
                this.iQX = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.iQW = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.iIc = getVoiceManager();
        this.iIc.onCreate(getPageContext());
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        this.iQV = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.iQV.setTabType(this.tabType);
        registerListener(this.iJp);
        registerListener(this.iRb);
        registerListener(this.iJR);
        this.dHY = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.iQU = new b(this, this.mRootView, this.iQW);
        this.iQU.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cAW();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cq(this.tabId, 2);
    }

    private void cq(int i, int i2) {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.forumId);
        if (i == 89) {
            arVar.ak("obj_type", 1);
        } else if (i == 502) {
            arVar.ak("obj_type", 8);
        } else if (i == 504) {
            arVar.ak("obj_type", 11);
        } else if (this.tabType == 3) {
            arVar.ak("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            arVar.ak("obj_type", 12);
        }
        arVar.ak("obj_locate", i2);
        arVar.bqy();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.iQU.qb(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.iLE);
            if (this.iOp == null) {
                this.iOp = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.iOp.setTitle(null);
            this.iOp.setSubText(str);
            this.iOp.setButtonText(null);
            this.iOp.attachView(view, z);
            this.iOp.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.iQU.qb(true);
        if (this.iOp != null) {
            this.iOp.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.iQU != null) {
                this.iQU.ld(false);
                this.iQU.cAB();
                this.iQU.a(dVar);
            }
            if (this.iQV.cBi() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.iQV.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.iQU != null) {
            this.iQU.ld(false);
        }
    }

    public void ap(bx bxVar) {
        if (bxVar != null) {
            this.iQV.ap(bxVar);
            this.iQU.cxv();
        }
    }

    public void cAU() {
        cAV();
        int i = 0;
        Iterator<q> it = this.iQV.cBh().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bw ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            cmn();
        }
    }

    private void cAV() {
        bx bxVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.cwH().cwL()) && this.iQU.cBg() != null && this.iQU.cBg().getData() != null) {
            ArrayList<q> arrayList = this.iQV.cBh().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.iQU.cBg().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.cwH().cwL());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bw) {
                        bxVar = ((bw) next).evQ;
                    } else if (!(next instanceof bx)) {
                        bxVar = null;
                    } else {
                        bxVar = (bx) next;
                    }
                    if (bxVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cwH().cwL().get(i2).getId(), bxVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iQU.cBg().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cmn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.iIc != null) {
                this.iIc.stopPlay();
            }
            if (this.iQV != null) {
                this.iQV.zP(this.sortType);
            }
        }
    }

    private void cAW() {
        if (l.isNetOk()) {
            if (this.iIc != null) {
                this.iIc.stopPlay();
            }
            if (this.iQV != null) {
                this.iQV.zO(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cAW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        t.cnT().oB(false);
        MessageManager.getInstance().unRegisterListener(this.iLE);
        super.onDestroy();
        if (this.iQU != null) {
            this.iQU.onDestroy();
        }
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.iQU != null) {
                this.iQU.resume();
            }
            if (this.iRa) {
                this.iRa = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("first_into_tab_profession", true) || cAX()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("first_into_tab_profession", false);
                        cAY();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Kw(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cBa();
        } else if (this.iQU != null) {
            this.iQU.pause();
        }
        cAr();
    }

    private boolean cAX() {
        return (this.iQW == null || this.iQW.getForum() == null || StringUtils.isNull(this.iQW.getForum().getFirst_class()) || !this.iQW.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cAY() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ov(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        professionDialogLayout.setCloseViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bg(professionDialogLayout);
        aVar.iW(false);
        aVar.iX(false);
        aVar.b(getPageContext()).bog();
    }

    private void cAr() {
        if (isPrimary()) {
            if (this.iOp != null && this.iOp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iLE);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    public void cAZ() {
        if (this.iQU != null) {
            this.iQU.refreshView();
        }
    }

    private void cBa() {
        if (this.tabId == 502) {
            ar arVar = new ar("c13376");
            arVar.dR("fid", this.forumId);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iQU != null) {
            this.iQU.pause();
        }
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iQZ != 3 || this.iQU != null) {
            this.iQZ = i;
            super.onChangeSkinType(i);
            this.iQU.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.iQY);
        bundle.putBoolean("need_log", this.iQX);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.iIc != null) {
            this.iIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    String stringExtra = intent.getStringExtra("tid");
                    int intExtra = intent.getIntExtra("type", -1);
                    if (!StringUtils.isNull(stringExtra) && intExtra == 0) {
                        this.iQU.Ka(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void cxv() {
        this.iQU.cxv();
    }

    @Override // com.baidu.tieba.frs.as
    public void bPo() {
        cxv();
        this.iQU.ld(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), cBb(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cBb() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.AR(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void zM(int i) {
        if (this.iOp != null && this.iOp.isViewAttached()) {
            this.iOp.sa(i);
        }
    }

    public c cBc() {
        return this.iQV;
    }

    public b cBd() {
        return this.iQU;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.au
    public void brR() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.iQV.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cAW();
                return;
            }
            this.iQU.ld(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void brS() {
    }
}
