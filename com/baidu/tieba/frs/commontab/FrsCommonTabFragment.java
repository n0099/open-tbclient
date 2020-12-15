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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, ar, at {
    public String forumId;
    public String forumName;
    private VoiceManager iSW;
    private am iTo;
    private com.baidu.tbadk.l.c iZi;
    public boolean isBrandForum;
    public int isGeneralTab;
    protected b jbO;
    protected c jbP;
    public FrsViewData jbQ;
    public boolean jbR;
    public boolean jbS;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int jbT = 3;
    private boolean jbU = true;
    private int dOW = 0;
    private int iTU = 0;
    private int sortType = 0;
    private CustomMessageListener iWz = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.Ar(num.intValue());
            }
        }
    };
    private CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.jbO != null) {
                        FrsCommonTabFragment.this.jbO.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.iZi != null && FrsCommonTabFragment.this.iZi.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.jbO != null) {
                        FrsCommonTabFragment.this.jbO.lx(true);
                    }
                    FrsCommonTabFragment.this.bvq();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener jbV = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.jbO.KR(str);
                }
            }
        }
    };
    private CustomMessageListener iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cDj = FrsCommonTabFragment.this.jbO.cDj();
                    if (cDj != null && cDj.dBP() != null && (cDj.dBP().getTag() instanceof am)) {
                        FrsCommonTabFragment.this.iTo = (am) cDj.dBP().getTag();
                    }
                    if (FrsCommonTabFragment.this.iTo != null && FrsCommonTabFragment.this.iTo.tZ() != null) {
                        FrsCommonTabFragment.this.iTo.tZ().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.iTU += i2;
            if (FrsCommonTabFragment.this.iTU >= FrsCommonTabFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.t.c.dOf().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.jbS = bundle.getBoolean("can_auto_play_video");
            this.jbR = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.jbQ = (FrsViewData) bundle.getSerializable("view_data");
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
                this.jbS = arguments.getBoolean("can_auto_play_video");
                this.jbR = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.jbQ = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.iSW = getVoiceManager();
        this.iSW.onCreate(getPageContext());
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        this.jbP = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.jbP.setTabType(this.tabType);
        registerListener(this.iUj);
        registerListener(this.jbV);
        registerListener(this.iUL);
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.jbO = new b(this, this.mRootView, this.jbQ);
        this.jbO.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cFn();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cu(this.tabId, 2);
    }

    private void cu(int i, int i2) {
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13008");
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("fid", this.forumId);
        if (i == 89) {
            arVar.al("obj_type", 1);
        } else if (i == 502) {
            arVar.al("obj_type", 8);
        } else if (i == 504) {
            arVar.al("obj_type", 11);
        } else if (this.tabType == 3) {
            arVar.al("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            arVar.al("obj_type", 12);
        }
        arVar.al("obj_locate", i2);
        arVar.btT();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.jbO.qy(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.iWz);
            if (this.iZi == null) {
                this.iZi = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.iZi.setTitle(null);
            this.iZi.setSubText(str);
            this.iZi.setButtonText(null);
            this.iZi.attachView(view, z);
            this.iZi.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.jbO.qy(true);
        if (this.iZi != null) {
            this.iZi.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.jbO != null) {
                this.jbO.lx(false);
                this.jbO.cES();
                this.jbO.a(dVar);
            }
            if (this.jbP.cFz() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
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
        if (!this.jbP.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.jbO != null) {
            this.jbO.lx(false);
        }
    }

    public void ap(by byVar) {
        if (byVar != null) {
            this.jbP.ap(byVar);
            this.jbO.cBM();
        }
    }

    public void cFl() {
        cFm();
        int i = 0;
        Iterator<q> it = this.jbP.cFy().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bx ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            cqB();
        }
    }

    private void cFm() {
        by byVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.cAX().cBb()) && this.jbO.cFx() != null && this.jbO.cFx().getData() != null) {
            ArrayList<q> arrayList = this.jbP.cFy().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.jbO.cFx().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.cAX().cBb());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bx) {
                        byVar = ((bx) next).eCR;
                    } else if (!(next instanceof by)) {
                        byVar = null;
                    } else {
                        byVar = (by) next;
                    }
                    if (byVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!au.equals(com.baidu.tieba.frs.a.cAX().cBb().get(i2).getId(), byVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jbO.cFx().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cqB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.iSW != null) {
                this.iSW.stopPlay();
            }
            if (this.jbP != null) {
                this.jbP.Au(this.sortType);
            }
        }
    }

    private void cFn() {
        if (l.isNetOk()) {
            if (this.iSW != null) {
                this.iSW.stopPlay();
            }
            if (this.jbP != null) {
                this.jbP.At(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        t.csh().oX(false);
        MessageManager.getInstance().unRegisterListener(this.iWz);
        super.onDestroy();
        if (this.jbO != null) {
            this.jbO.onDestroy();
        }
        if (this.iSW != null) {
            this.iSW.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jbO != null) {
                this.jbO.resume();
            }
            if (this.jbU) {
                this.jbU = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("first_into_tab_profession", true) || cFo()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("first_into_tab_profession", false);
                        cFp();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).LD(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cFr();
        } else if (this.jbO != null) {
            this.jbO.pause();
        }
        cEI();
    }

    private boolean cFo() {
        return (this.jbQ == null || this.jbQ.getForum() == null || StringUtils.isNull(this.jbQ.getForum().getFirst_class()) || !this.jbQ.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cFp() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.oT(1);
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
        aVar.bi(professionDialogLayout);
        aVar.jl(false);
        aVar.jm(false);
        aVar.b(getPageContext()).brv();
    }

    private void cEI() {
        if (isPrimary()) {
            if (this.iZi != null && this.iZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWz);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    public void cFq() {
        if (this.jbO != null) {
            this.jbO.refreshView();
        }
    }

    private void cFr() {
        if (this.tabId == 502) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13376");
            arVar.dY("fid", this.forumId);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iSW != null) {
            this.iSW.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jbO != null) {
            this.jbO.pause();
        }
        if (this.iSW != null) {
            this.iSW.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jbT != 3 || this.jbO != null) {
            this.jbT = i;
            super.onChangeSkinType(i);
            this.jbO.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.jbS);
        bundle.putBoolean("need_log", this.jbR);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.iSW != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iSW != null) {
            this.iSW.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
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
                        this.jbO.KR(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBM() {
        this.jbO.cBM();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTa() {
        cBM();
        this.jbO.lx(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), cFs(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cFs() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.f.j.BF(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void Ar(int i) {
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.sB(i);
        }
    }

    public c cFt() {
        return this.jbP;
    }

    public b cFu() {
        return this.jbO;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.jbP.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cFn();
                return;
            }
            this.jbO.lx(false);
        }
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
    }
}
