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
import com.baidu.tieba.card.t;
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
    private am iHH;
    private VoiceManager iHo;
    private com.baidu.tbadk.k.c iNC;
    protected b iQh;
    protected c iQi;
    public FrsViewData iQj;
    public boolean iQk;
    public boolean iQl;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int iQm = 3;
    private boolean iQn = true;
    private int dJG = 0;
    private int iIn = 0;
    private int sortType = 0;
    private CustomMessageListener iKR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.zo(num.intValue());
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.iQh != null) {
                        FrsCommonTabFragment.this.iQh.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.iNC != null && FrsCommonTabFragment.this.iNC.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.iQh != null) {
                        FrsCommonTabFragment.this.iQh.lc(true);
                    }
                    FrsCommonTabFragment.this.bsB();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener iQo = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.iQh.Kz(str);
                }
            }
        }
    };
    private CustomMessageListener iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i czo = FrsCommonTabFragment.this.iQh.czo();
                    if (czo != null && czo.dwW() != null && (czo.dwW().getTag() instanceof am)) {
                        FrsCommonTabFragment.this.iHH = (am) czo.dwW().getTag();
                    }
                    if (FrsCommonTabFragment.this.iHH != null && FrsCommonTabFragment.this.iHH.tW() != null) {
                        FrsCommonTabFragment.this.iHH.tW().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.iIn += i2;
            if (FrsCommonTabFragment.this.iIn >= FrsCommonTabFragment.this.dJG * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dIX().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.iQl = bundle.getBoolean("can_auto_play_video");
            this.iQk = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.iQj = (FrsViewData) bundle.getSerializable("view_data");
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
                this.iQl = arguments.getBoolean("can_auto_play_video");
                this.iQk = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.iQj = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.iHo = getVoiceManager();
        this.iHo.onCreate(getPageContext());
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        this.iQi = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.iQi.setTabType(this.tabType);
        registerListener(this.iIB);
        registerListener(this.iQo);
        registerListener(this.iJd);
        this.dJG = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.iQh = new b(this, this.mRootView, this.iQj);
        this.iQh.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cBt();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cq(this.tabId, 2);
    }

    private void cq(int i, int i2) {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.forumId);
        if (i == 89) {
            aqVar.al("obj_type", 1);
        } else if (i == 502) {
            aqVar.al("obj_type", 8);
        } else if (i == 504) {
            aqVar.al("obj_type", 11);
        } else if (this.tabType == 3) {
            aqVar.al("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            aqVar.al("obj_type", 12);
        }
        aqVar.al("obj_locate", i2);
        aqVar.brk();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.iQh.pY(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.iKR);
            if (this.iNC == null) {
                this.iNC = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.iNC.setTitle(null);
            this.iNC.setSubText(str);
            this.iNC.setButtonText(null);
            this.iNC.attachView(view, z);
            this.iNC.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.iQh.pY(true);
        if (this.iNC != null) {
            this.iNC.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.iQh != null) {
                this.iQh.lc(false);
                this.iQh.cAY();
                this.iQh.a(dVar);
            }
            if (this.iQi.cBF() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
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
        if (!this.iQi.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.iQh != null) {
            this.iQh.lc(false);
        }
    }

    public void an(bw bwVar) {
        if (bwVar != null) {
            this.iQi.an(bwVar);
            this.iQh.cxS();
        }
    }

    public void cBr() {
        cBs();
        int i = 0;
        Iterator<q> it = this.iQi.cBE().threadList.iterator();
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
            cmL();
        }
    }

    private void cBs() {
        bw bwVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.cxf().cxj()) && this.iQh.cBD() != null && this.iQh.cBD().getData() != null) {
            ArrayList<q> arrayList = this.iQi.cBE().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.iQh.cBD().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.cxf().cxj());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bwVar = ((bv) next).exA;
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
                            } else if (!at.equals(com.baidu.tieba.frs.a.cxf().cxj().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iQh.cBD().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cmL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.iHo != null) {
                this.iHo.stopPlay();
            }
            if (this.iQi != null) {
                this.iQi.zr(this.sortType);
            }
        }
    }

    private void cBt() {
        if (l.isNetOk()) {
            if (this.iHo != null) {
                this.iHo.stopPlay();
            }
            if (this.iQi != null) {
                this.iQi.zq(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cBt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        t.cor().oy(false);
        MessageManager.getInstance().unRegisterListener(this.iKR);
        super.onDestroy();
        if (this.iQh != null) {
            this.iQh.onDestroy();
        }
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.iQh != null) {
                this.iQh.resume();
            }
            if (this.iQn) {
                this.iQn = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("first_into_tab_profession", true) || cBu()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("first_into_tab_profession", false);
                        cBv();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).KV(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cBx();
        } else if (this.iQh != null) {
            this.iQh.pause();
        }
        cAO();
    }

    private boolean cBu() {
        return (this.iQj == null || this.iQj.getForum() == null || StringUtils.isNull(this.iQj.getForum().getFirst_class()) || !this.iQj.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cBv() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.oz(1);
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
        aVar.bf(professionDialogLayout);
        aVar.iV(false);
        aVar.iW(false);
        aVar.b(getPageContext()).bpc();
    }

    private void cAO() {
        if (isPrimary()) {
            if (this.iNC != null && this.iNC.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iKR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    public void cBw() {
        if (this.iQh != null) {
            this.iQh.refreshView();
        }
    }

    private void cBx() {
        if (this.tabId == 502) {
            aq aqVar = new aq("c13376");
            aqVar.dR("fid", this.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.iQh != null) {
            this.iQh.pause();
        }
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iQm != 3 || this.iQh != null) {
            this.iQm = i;
            super.onChangeSkinType(i);
            this.iQh.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.iQl);
        bundle.putBoolean("need_log", this.iQk);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
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
                        this.iQh.Kz(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void cxS() {
        this.iQh.cxS();
    }

    @Override // com.baidu.tieba.frs.as
    public void bPV() {
        cxS();
        this.iQh.lc(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), cBy(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cBy() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.At(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void zo(int i) {
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.rC(i);
        }
    }

    public c cBz() {
        return this.iQi;
    }

    public b cBA() {
        return this.iQh;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.iQi.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cBt();
                return;
            }
            this.iQh.lc(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
    }
}
