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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, aq, as {
    public String forumId;
    private ak hAb;
    private com.baidu.tbadk.k.c hEZ;
    protected b hHB;
    protected c hHC;
    public FrsViewData hHD;
    public boolean hHE;
    public boolean hHF;
    private VoiceManager hzJ;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int hHG = 3;
    private boolean hHH = true;
    private int cTi = 0;
    private int hAH = 0;
    private int sortType = 0;
    private CustomMessageListener hDd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.uT(num.intValue());
            }
        }
    };
    private CustomMessageListener hAR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.hHB != null) {
                        FrsCommonTabFragment.this.hHB.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.hEZ != null && FrsCommonTabFragment.this.hEZ.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.hHB != null) {
                        FrsCommonTabFragment.this.hHB.jc(true);
                    }
                    FrsCommonTabFragment.this.aYg();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener hHI = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.hHB.Fk(str);
                }
            }
        }
    };
    private CustomMessageListener hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bZa = FrsCommonTabFragment.this.hHB.bZa();
                    if (bZa != null && bZa.cVl() != null && (bZa.cVl().getTag() instanceof ak)) {
                        FrsCommonTabFragment.this.hAb = (ak) bZa.cVl().getTag();
                    }
                    if (FrsCommonTabFragment.this.hAb != null && FrsCommonTabFragment.this.hAb.se() != null) {
                        FrsCommonTabFragment.this.hAb.se().b(new a.C0098a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.hAH += i2;
            if (FrsCommonTabFragment.this.hAH >= FrsCommonTabFragment.this.cTi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dgX().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.hHF = bundle.getBoolean("can_auto_play_video");
            this.hHE = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.hHD = (FrsViewData) bundle.getSerializable("view_data");
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
                this.hHF = arguments.getBoolean("can_auto_play_video");
                this.hHE = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.hHD = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.hzJ = getVoiceManager();
        this.hzJ.onCreate(getPageContext());
        com.baidu.tieba.s.c.dgX().z(getUniqueId());
        this.hHC = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.hHC.setTabType(this.tabType);
        registerListener(this.hAR);
        registerListener(this.hHI);
        registerListener(this.hBs);
        this.cTi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.hHB = new b(this, this.mRootView, this.hHD);
        this.hHB.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            caX();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bY(this.tabId, 2);
    }

    private void bY(int i, int i2) {
        ao aoVar = new ao("c13008");
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        aoVar.dk("fid", this.forumId);
        if (i == 89) {
            aoVar.ag("obj_type", 1);
        } else if (i == 502) {
            aoVar.ag("obj_type", 8);
        } else if (i == 504) {
            aoVar.ag("obj_type", 11);
        } else if (this.isGeneralTab == 1) {
            aoVar.ag("obj_type", 12);
        }
        aoVar.ag("obj_locate", i2);
        aoVar.aWN();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.hHB.nB(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.hDd);
            if (this.hEZ == null) {
                this.hEZ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.hEZ.setTitle(null);
            this.hEZ.setSubText(str);
            this.hEZ.setButtonText(null);
            this.hEZ.attachView(view, z);
            this.hEZ.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.hHB.nB(true);
        if (this.hEZ != null) {
            this.hEZ.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.hHB != null) {
                this.hHB.jc(false);
                this.hHB.caB();
                this.hHB.a(dVar);
            }
            if (this.hHC.cbj() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dgX().b(getUniqueId(), false);
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
        if (!this.hHC.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.hHB != null) {
            this.hHB.jc(false);
        }
    }

    public void ap(bu buVar) {
        if (buVar != null) {
            this.hHC.ap(buVar);
            this.hHB.bXG();
        }
    }

    public void caV() {
        caW();
        int i = 0;
        Iterator<q> it = this.hHC.cbi().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bt ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bMW();
        }
    }

    private void caW() {
        bu buVar;
        if (!w.isEmpty(com.baidu.tieba.frs.a.bWV().bWZ()) && this.hHB.cbh() != null && this.hHB.cbh().getData() != null) {
            ArrayList<q> arrayList = this.hHC.cbi().threadList;
            if (!w.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                List<q> data = this.hHB.cbh().getData();
                int count = w.getCount(com.baidu.tieba.frs.a.bWV().bWZ());
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bt) {
                        buVar = ((bt) next).dLi;
                    } else if (!(next instanceof bu)) {
                        buVar = null;
                    } else {
                        buVar = (bu) next;
                    }
                    if (buVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!ar.equals(com.baidu.tieba.frs.a.bWV().bWZ().get(i2).getId(), buVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hHB.cbh().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void bMW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.hzJ != null) {
                this.hzJ.stopPlay();
            }
            if (this.hHC != null) {
                this.hHC.uW(this.sortType);
            }
        }
    }

    private void caX() {
        if (l.isNetOk()) {
            if (this.hzJ != null) {
                this.hzJ.stopPlay();
            }
            if (this.hHC != null) {
                this.hHC.uV(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            caX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dgX().A(getUniqueId());
        s.bOA().mc(false);
        MessageManager.getInstance().unRegisterListener(this.hDd);
        super.onDestroy();
        if (this.hHB != null) {
            this.hHB.onDestroy();
        }
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.hHB != null) {
                this.hHB.resume();
            }
            if (this.hHH) {
                this.hHH = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("first_into_tab_profession", true) || caY()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("first_into_tab_profession", false);
                        caZ();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).FF(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cbb();
        } else if (this.hHB != null) {
            this.hHB.pause();
        }
        car();
    }

    private boolean caY() {
        return (this.hHD == null || this.hHD.getForum() == null || StringUtils.isNull(this.hHD.getForum().getFirst_class()) || !this.hHD.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void caZ() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kW(1);
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
        aVar.aP(professionDialogLayout);
        aVar.hf(false);
        aVar.hg(false);
        aVar.b(getPageContext()).aUN();
    }

    private void car() {
        if (isPrimary()) {
            if (this.hEZ != null && this.hEZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hDd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    public void cba() {
        if (this.hHB != null) {
            this.hHB.refreshView();
        }
    }

    private void cbb() {
        if (this.tabId == 502) {
            ao aoVar = new ao("c13376");
            aoVar.dk("fid", this.forumId);
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aoVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hHB != null) {
            this.hHB.pause();
        }
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hHG != 3 || this.hHB != null) {
            this.hHG = i;
            super.onChangeSkinType(i);
            this.hHB.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.hHF);
        bundle.putBoolean("need_log", this.hHE);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.hzJ != null) {
            this.hzJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dgX().b(getUniqueId(), false);
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
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
                        this.hHB.Fk(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bXG() {
        this.hHB.bXG();
    }

    @Override // com.baidu.tieba.frs.aq
    public void buH() {
        bXG();
        this.hHB.jc(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), cbc(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cbc() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hHD != null) {
            i = this.hHD.getSortType();
        }
        tbPageTag.sortType = g.vX(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void uT(int i) {
        if (this.hEZ != null && this.hEZ.isViewAttached()) {
            this.hEZ.nP(i);
        }
    }

    public c cbd() {
        return this.hHC;
    }

    public b cbe() {
        return this.hHB;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.as
    public void aYg() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.hHC.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                caX();
                return;
            }
            this.hHB.jc(false);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void aYh() {
    }
}
