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
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, as, au {
    public String forumId;
    public String forumName;
    private VoiceManager ioV;
    private am ipo;
    public boolean isBrandForum;
    public int isGeneralTab;
    private com.baidu.tbadk.k.c ivj;
    protected b ixO;
    protected c ixP;
    public FrsViewData ixQ;
    public boolean ixR;
    public boolean ixS;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int ixT = 3;
    private boolean ixU = true;
    private int dvr = 0;
    private int ipU = 0;
    private int sortType = 0;
    private CustomMessageListener isy = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.yI(num.intValue());
            }
        }
    };
    private CustomMessageListener iqi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.ixO != null) {
                        FrsCommonTabFragment.this.ixO.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.ivj != null && FrsCommonTabFragment.this.ivj.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.ixO != null) {
                        FrsCommonTabFragment.this.ixO.kG(true);
                    }
                    FrsCommonTabFragment.this.boi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener ixV = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.ixO.JJ(str);
                }
            }
        }
    };
    private CustomMessageListener iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i ctG = FrsCommonTabFragment.this.ixO.ctG();
                    if (ctG != null && ctG.drn() != null && (ctG.drn().getTag() instanceof am)) {
                        FrsCommonTabFragment.this.ipo = (am) ctG.drn().getTag();
                    }
                    if (FrsCommonTabFragment.this.ipo != null && FrsCommonTabFragment.this.ipo.tW() != null) {
                        FrsCommonTabFragment.this.ipo.tW().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.ipU += i2;
            if (FrsCommonTabFragment.this.ipU >= FrsCommonTabFragment.this.dvr * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dDn().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.ixS = bundle.getBoolean("can_auto_play_video");
            this.ixR = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.ixQ = (FrsViewData) bundle.getSerializable("view_data");
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
                this.ixS = arguments.getBoolean("can_auto_play_video");
                this.ixR = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.ixQ = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.ioV = getVoiceManager();
        this.ioV.onCreate(getPageContext());
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        this.ixP = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.ixP.setTabType(this.tabType);
        registerListener(this.iqi);
        registerListener(this.ixV);
        registerListener(this.iqK);
        this.dvr = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.ixO = new b(this, this.mRootView, this.ixQ);
        this.ixO.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cvL();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cm(this.tabId, 2);
    }

    private void cm(int i, int i2) {
        aq aqVar = new aq("c13008");
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dK("fid", this.forumId);
        if (i == 89) {
            aqVar.aj("obj_type", 1);
        } else if (i == 502) {
            aqVar.aj("obj_type", 8);
        } else if (i == 504) {
            aqVar.aj("obj_type", 11);
        } else if (this.tabType == 3) {
            aqVar.aj("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            aqVar.aj("obj_type", 12);
        }
        aqVar.aj("obj_locate", i2);
        aqVar.bmR();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.ixO.px(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.isy);
            if (this.ivj == null) {
                this.ivj = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.ivj.setTitle(null);
            this.ivj.setSubText(str);
            this.ivj.setButtonText(null);
            this.ivj.attachView(view, z);
            this.ivj.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.ixO.px(true);
        if (this.ivj != null) {
            this.ivj.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.ixO != null) {
                this.ixO.kG(false);
                this.ixO.cvq();
                this.ixO.a(dVar);
            }
            if (this.ixP.cvX() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
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
        if (!this.ixP.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.ixO != null) {
            this.ixO.kG(false);
        }
    }

    public void an(bw bwVar) {
        if (bwVar != null) {
            this.ixP.an(bwVar);
            this.ixO.csk();
        }
    }

    public void cvJ() {
        cvK();
        int i = 0;
        Iterator<q> it = this.ixP.cvW().threadList.iterator();
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
            chc();
        }
    }

    private void cvK() {
        bw bwVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.crx().crB()) && this.ixO.cvV() != null && this.ixO.cvV().getData() != null) {
            ArrayList<q> arrayList = this.ixP.cvW().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.ixO.cvV().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.crx().crB());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bwVar = ((bv) next).eji;
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
                            } else if (!at.equals(com.baidu.tieba.frs.a.crx().crB().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.ixO.cvV().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void chc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.ioV != null) {
                this.ioV.stopPlay();
            }
            if (this.ixP != null) {
                this.ixP.yL(this.sortType);
            }
        }
    }

    private void cvL() {
        if (l.isNetOk()) {
            if (this.ioV != null) {
                this.ioV.stopPlay();
            }
            if (this.ixP != null) {
                this.ixP.yK(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cvL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        s.ciJ().nX(false);
        MessageManager.getInstance().unRegisterListener(this.isy);
        super.onDestroy();
        if (this.ixO != null) {
            this.ixO.onDestroy();
        }
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ixO != null) {
                this.ixO.resume();
            }
            if (this.ixU) {
                this.ixU = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("first_into_tab_profession", true) || cvM()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("first_into_tab_profession", false);
                        cvN();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Kf(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cvP();
        } else if (this.ixO != null) {
            this.ixO.pause();
        }
        cvg();
    }

    private boolean cvM() {
        return (this.ixQ == null || this.ixQ.getForum() == null || StringUtils.isNull(this.ixQ.getForum().getFirst_class()) || !this.ixQ.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cvN() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.oe(1);
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
        aVar.ba(professionDialogLayout);
        aVar.iz(false);
        aVar.iA(false);
        aVar.b(getPageContext()).bkJ();
    }

    private void cvg() {
        if (isPrimary()) {
            if (this.ivj != null && this.ivj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.isy);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    public void cvO() {
        if (this.ixO != null) {
            this.ixO.refreshView();
        }
    }

    private void cvP() {
        if (this.tabId == 502) {
            aq aqVar = new aq("c13376");
            aqVar.dK("fid", this.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ixO != null) {
            this.ixO.pause();
        }
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ixT != 3 || this.ixO != null) {
            this.ixT = i;
            super.onChangeSkinType(i);
            this.ixO.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.ixS);
        bundle.putBoolean("need_log", this.ixR);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.ioV != null) {
            this.ioV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
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
                        this.ixO.JJ(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void csk() {
        this.ixO.csk();
    }

    @Override // com.baidu.tieba.frs.as
    public void bKT() {
        csk();
        this.ixO.kG(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), cvQ(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cvQ() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.zN(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void yI(int i) {
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.rh(i);
        }
    }

    public c cvR() {
        return this.ixP;
    }

    public b cvS() {
        return this.ixO;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.au
    public void boi() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.ixP.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cvL();
                return;
            }
            this.ixO.kG(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void boj() {
    }
}
