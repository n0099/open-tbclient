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
import com.baidu.card.al;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, as, au {
    public String forumId;
    public String forumName;
    private VoiceManager hSO;
    private al hTh;
    private com.baidu.tbadk.k.c hZc;
    protected b ibH;
    protected c ibI;
    public FrsViewData ibJ;
    public boolean ibK;
    public boolean ibL;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int ibM = 3;
    private boolean ibN = true;
    private int dhe = 0;
    private int hTN = 0;
    private int sortType = 0;
    private CustomMessageListener hWr = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.xD(num.intValue());
            }
        }
    };
    private CustomMessageListener hUb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.ibH != null) {
                        FrsCommonTabFragment.this.ibH.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.hZc != null && FrsCommonTabFragment.this.hZc.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.ibH != null) {
                        FrsCommonTabFragment.this.ibH.kf(true);
                    }
                    FrsCommonTabFragment.this.bkD();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener ibO = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.ibH.Iy(str);
                }
            }
        }
    };
    private CustomMessageListener hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cmV = FrsCommonTabFragment.this.ibH.cmV();
                    if (cmV != null && cmV.djT() != null && (cmV.djT().getTag() instanceof al)) {
                        FrsCommonTabFragment.this.hTh = (al) cmV.djT().getTag();
                    }
                    if (FrsCommonTabFragment.this.hTh != null && FrsCommonTabFragment.this.hTh.tR() != null) {
                        FrsCommonTabFragment.this.hTh.tR().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.hTN += i2;
            if (FrsCommonTabFragment.this.hTN >= FrsCommonTabFragment.this.dhe * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dvE().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.ibL = bundle.getBoolean("can_auto_play_video");
            this.ibK = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.ibJ = (FrsViewData) bundle.getSerializable("view_data");
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
                this.ibL = arguments.getBoolean("can_auto_play_video");
                this.ibK = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.ibJ = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.hSO = getVoiceManager();
        this.hSO.onCreate(getPageContext());
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        this.ibI = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.ibI.setTabType(this.tabType);
        registerListener(this.hUb);
        registerListener(this.ibO);
        registerListener(this.hUD);
        this.dhe = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.ibH = new b(this, this.mRootView, this.ibJ);
        this.ibH.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cpa();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cj(this.tabId, 2);
    }

    private void cj(int i, int i2) {
        aq aqVar = new aq("c13008");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("fid", this.forumId);
        if (i == 89) {
            aqVar.ai("obj_type", 1);
        } else if (i == 502) {
            aqVar.ai("obj_type", 8);
        } else if (i == 504) {
            aqVar.ai("obj_type", 11);
        } else if (this.tabType == 3) {
            aqVar.ai("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            aqVar.ai("obj_type", 12);
        }
        aqVar.ai("obj_locate", i2);
        aqVar.bjn();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.ibH.oK(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.hWr);
            if (this.hZc == null) {
                this.hZc = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.hZc.setTitle(null);
            this.hZc.setSubText(str);
            this.hZc.setButtonText(null);
            this.hZc.attachView(view, z);
            this.hZc.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.ibH.oK(true);
        if (this.hZc != null) {
            this.hZc.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.ibH != null) {
                this.ibH.kf(false);
                this.ibH.coE();
                this.ibH.a(dVar);
            }
            if (this.ibI.cpm() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
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
        if (!this.ibI.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.ibH != null) {
            this.ibH.kf(false);
        }
    }

    public void am(bw bwVar) {
        if (bwVar != null) {
            this.ibI.am(bwVar);
            this.ibH.clz();
        }
    }

    public void coY() {
        coZ();
        int i = 0;
        Iterator<q> it = this.ibI.cpl().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bv ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            cat();
        }
    }

    private void coZ() {
        bw bwVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.ckL().ckP()) && this.ibH.cpk() != null && this.ibH.cpk().getData() != null) {
            ArrayList<q> arrayList = this.ibI.cpl().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.ibH.cpk().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.ckL().ckP());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bwVar = ((bv) next).dUS;
                    } else if (!(next instanceof bw)) {
                        bwVar = null;
                    } else {
                        bwVar = (bw) next;
                    }
                    if (bwVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!at.equals(com.baidu.tieba.frs.a.ckL().ckP().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.ibH.cpk().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cat() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.hSO != null) {
                this.hSO.stopPlay();
            }
            if (this.ibI != null) {
                this.ibI.xG(this.sortType);
            }
        }
    }

    private void cpa() {
        if (l.isNetOk()) {
            if (this.hSO != null) {
                this.hSO.stopPlay();
            }
            if (this.ibI != null) {
                this.ibI.xF(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cpa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        s.cbX().nk(false);
        MessageManager.getInstance().unRegisterListener(this.hWr);
        super.onDestroy();
        if (this.ibH != null) {
            this.ibH.onDestroy();
        }
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ibH != null) {
                this.ibH.resume();
            }
            if (this.ibN) {
                this.ibN = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("first_into_tab_profession", true) || cpb()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("first_into_tab_profession", false);
                        cpc();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).IT(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cpe();
        } else if (this.ibH != null) {
            this.ibH.pause();
        }
        cou();
    }

    private boolean cpb() {
        return (this.ibJ == null || this.ibJ.getForum() == null || StringUtils.isNull(this.ibJ.getForum().getFirst_class()) || !this.ibJ.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cpc() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.nw(1);
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
        aVar.aX(professionDialogLayout);
        aVar.m39if(false);
        aVar.ig(false);
        aVar.b(getPageContext()).bhg();
    }

    private void cou() {
        if (isPrimary()) {
            if (this.hZc != null && this.hZc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWr);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    public void cpd() {
        if (this.ibH != null) {
            this.ibH.refreshView();
        }
    }

    private void cpe() {
        if (this.tabId == 502) {
            aq aqVar = new aq("c13376");
            aqVar.dD("fid", this.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ibH != null) {
            this.ibH.pause();
        }
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ibM != 3 || this.ibH != null) {
            this.ibM = i;
            super.onChangeSkinType(i);
            this.ibH.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.ibL);
        bundle.putBoolean("need_log", this.ibK);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.hSO != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
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
                        this.ibH.Iy(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void clz() {
        this.ibH.clz();
    }

    @Override // com.baidu.tieba.frs.as
    public void bGQ() {
        clz();
        this.ibH.kf(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), cpf(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cpf() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.ibJ != null) {
            i = this.ibJ.getSortType();
        }
        tbPageTag.sortType = g.yI(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void xD(int i) {
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.qs(i);
        }
    }

    public c cpg() {
        return this.ibI;
    }

    public b cph() {
        return this.ibH;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.ibI.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cpa();
                return;
            }
            this.ibH.kf(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
    }
}
