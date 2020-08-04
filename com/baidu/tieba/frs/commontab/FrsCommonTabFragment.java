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
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, aq, as {
    public String forumId;
    private ak hFR;
    private VoiceManager hFy;
    private com.baidu.tbadk.k.c hKX;
    protected b hNC;
    protected c hND;
    public FrsViewData hNE;
    public boolean hNF;
    public boolean hNG;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int hNH = 3;
    private boolean hNI = true;
    private int cXV = 0;
    private int hGx = 0;
    private int sortType = 0;
    private CustomMessageListener hJb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.vl(num.intValue());
            }
        }
    };
    private CustomMessageListener hGL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.hNC != null) {
                        FrsCommonTabFragment.this.hNC.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.hKX != null && FrsCommonTabFragment.this.hKX.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.hNC != null) {
                        FrsCommonTabFragment.this.hNC.jH(true);
                    }
                    FrsCommonTabFragment.this.bcg();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener hNJ = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.hNC.FW(str);
                }
            }
        }
    };
    private CustomMessageListener hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i ccy = FrsCommonTabFragment.this.hNC.ccy();
                    if (ccy != null && ccy.cYQ() != null && (ccy.cYQ().getTag() instanceof ak)) {
                        FrsCommonTabFragment.this.hFR = (ak) ccy.cYQ().getTag();
                    }
                    if (FrsCommonTabFragment.this.hFR != null && FrsCommonTabFragment.this.hFR.sg() != null) {
                        FrsCommonTabFragment.this.hFR.sg().b(new a.C0096a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.hGx += i2;
            if (FrsCommonTabFragment.this.hGx >= FrsCommonTabFragment.this.cXV * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dkh().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.hNG = bundle.getBoolean("can_auto_play_video");
            this.hNF = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.hNE = (FrsViewData) bundle.getSerializable("view_data");
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
                this.hNG = arguments.getBoolean("can_auto_play_video");
                this.hNF = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.hNE = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.hFy = getVoiceManager();
        this.hFy.onCreate(getPageContext());
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        this.hND = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.hND.setTabType(this.tabType);
        registerListener(this.hGL);
        registerListener(this.hNJ);
        registerListener(this.hHn);
        this.cXV = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.hNC = new b(this, this.mRootView, this.hNE);
        this.hNC.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cew();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cb(this.tabId, 2);
    }

    private void cb(int i, int i2) {
        ap apVar = new ap("c13008");
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.dn("fid", this.forumId);
        if (i == 89) {
            apVar.ah("obj_type", 1);
        } else if (i == 502) {
            apVar.ah("obj_type", 8);
        } else if (i == 504) {
            apVar.ah("obj_type", 11);
        } else if (this.isGeneralTab == 1) {
            apVar.ah("obj_type", 12);
        }
        apVar.ah("obj_locate", i2);
        apVar.baO();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.hNC.og(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.hJb);
            if (this.hKX == null) {
                this.hKX = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.hKX.setTitle(null);
            this.hKX.setSubText(str);
            this.hKX.setButtonText(null);
            this.hKX.attachView(view, z);
            this.hKX.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.hNC.og(true);
        if (this.hKX != null) {
            this.hKX.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.hNC != null) {
                this.hNC.jH(false);
                this.hNC.cea();
                this.hNC.a(dVar);
            }
            if (this.hND.ceI() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
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
        if (!this.hND.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.hNC != null) {
            this.hNC.jH(false);
        }
    }

    public void am(bv bvVar) {
        if (bvVar != null) {
            this.hND.am(bvVar);
            this.hNC.cbd();
        }
    }

    public void ceu() {
        cev();
        int i = 0;
        Iterator<q> it = this.hND.ceH().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bu ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bQi();
        }
    }

    private void cev() {
        bv bvVar;
        if (!x.isEmpty(com.baidu.tieba.frs.a.cap().cat()) && this.hNC.ceG() != null && this.hNC.ceG().getData() != null) {
            ArrayList<q> arrayList = this.hND.ceH().threadList;
            if (!x.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.hNC.ceG().getData();
                int count = x.getCount(com.baidu.tieba.frs.a.cap().cat());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bu) {
                        bvVar = ((bu) next).dLK;
                    } else if (!(next instanceof bv)) {
                        bvVar = null;
                    } else {
                        bvVar = (bv) next;
                    }
                    if (bvVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.as.equals(com.baidu.tieba.frs.a.cap().cat().get(i2).getId(), bvVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hNC.ceG().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void bQi() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.hFy != null) {
                this.hFy.stopPlay();
            }
            if (this.hND != null) {
                this.hND.vo(this.sortType);
            }
        }
    }

    private void cew() {
        if (l.isNetOk()) {
            if (this.hFy != null) {
                this.hFy.stopPlay();
            }
            if (this.hND != null) {
                this.hND.vn(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cew();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        s.bRL().mH(false);
        MessageManager.getInstance().unRegisterListener(this.hJb);
        super.onDestroy();
        if (this.hNC != null) {
            this.hNC.onDestroy();
        }
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.hNC != null) {
                this.hNC.resume();
            }
            if (this.hNI) {
                this.hNI = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("first_into_tab_profession", true) || cex()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("first_into_tab_profession", false);
                        cey();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Gr(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            ceA();
        } else if (this.hNC != null) {
            this.hNC.pause();
        }
        cdQ();
    }

    private boolean cex() {
        return (this.hNE == null || this.hNE.getForum() == null || StringUtils.isNull(this.hNE.getForum().getFirst_class()) || !this.hNE.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cey() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.lq(1);
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
        aVar.aV(professionDialogLayout);
        aVar.hJ(false);
        aVar.hK(false);
        aVar.b(getPageContext()).aYL();
    }

    private void cdQ() {
        if (isPrimary()) {
            if (this.hKX != null && this.hKX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hJb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    public void cez() {
        if (this.hNC != null) {
            this.hNC.refreshView();
        }
    }

    private void ceA() {
        if (this.tabId == 502) {
            ap apVar = new ap("c13376");
            apVar.dn("fid", this.forumId);
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(apVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hNC != null) {
            this.hNC.pause();
        }
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hNH != 3 || this.hNC != null) {
            this.hNH = i;
            super.onChangeSkinType(i);
            this.hNC.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.hNG);
        bundle.putBoolean("need_log", this.hNF);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
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
                        this.hNC.FW(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void cbd() {
        this.hNC.cbd();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxR() {
        cbd();
        this.hNC.jH(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), ceB(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String ceB() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hNE != null) {
            i = this.hNE.getSortType();
        }
        tbPageTag.sortType = g.wp(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void vl(int i) {
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.oh(i);
        }
    }

    public c ceC() {
        return this.hND;
    }

    public b ceD() {
        return this.hNC;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.as
    public void bcg() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.hND.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cew();
                return;
            }
            this.hNC.jH(false);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bch() {
    }
}
