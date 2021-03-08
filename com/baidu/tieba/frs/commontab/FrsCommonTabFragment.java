package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, ao, aq, q {
    public String forumId;
    public String forumName;
    public boolean isBrandForum;
    public int isGeneralTab;
    private VoiceManager jie;
    private ThreadCardViewHolder jiw;
    private com.baidu.tbadk.l.c jot;
    protected b jra;
    protected c jrb;
    public FrsViewData jrc;
    public boolean jrd;
    public boolean jre;
    private boolean jrh;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int jrf = 3;
    private boolean jrg = true;
    private int dWJ = 0;
    private int jjc = 0;
    private int sortType = 0;
    private CustomMessageListener jlI = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.zi(num.intValue());
            }
        }
    };
    private CustomMessageListener jjr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.jra != null) {
                        FrsCommonTabFragment.this.jra.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.jot != null && FrsCommonTabFragment.this.jot.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.jra != null) {
                        FrsCommonTabFragment.this.jra.lU(true);
                    }
                    FrsCommonTabFragment.this.bup();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener jri = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.jra.KA(str);
                }
            }
        }
    };
    private CustomMessageListener jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cDL = FrsCommonTabFragment.this.jra.cDL();
                    if (cDL != null && cDL.dAk() != null && (cDL.dAk().getTag() instanceof ThreadCardViewHolder)) {
                        FrsCommonTabFragment.this.jiw = (ThreadCardViewHolder) cDL.dAk().getTag();
                    }
                    if (FrsCommonTabFragment.this.jiw != null && FrsCommonTabFragment.this.jiw.tj() != null) {
                        FrsCommonTabFragment.this.jiw.tj().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsCommonTabFragment.this.jrb != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FrsCommonTabFragment.this.jrb.KB(str);
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.jjc += i2;
            if (FrsCommonTabFragment.this.jjc >= FrsCommonTabFragment.this.dWJ * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dMH().b(FrsCommonTabFragment.this.getUniqueId(), true);
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt("tab_id");
            this.tabType = bundle.getInt("tab_type");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("name");
            this.jre = bundle.getBoolean("can_auto_play_video");
            this.jrd = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.jrc = (FrsViewData) bundle.getSerializable("view_data");
            this.jrh = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
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
                this.jre = arguments.getBoolean("can_auto_play_video");
                this.jrd = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.jrc = (FrsViewData) arguments.getSerializable("view_data");
                this.jrh = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
        }
        this.jie = getVoiceManager();
        this.jie.onCreate(getPageContext());
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        this.jrb = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.jrb.setTabType(this.tabType);
        this.jrb.setFunAdController(com.baidu.tieba.funad.a.rM(this.jrh));
        registerListener(this.jjr);
        registerListener(this.jri);
        registerListener(this.jjU);
        registerListener(this.jrj);
        this.dWJ = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.jra = new b(this, this.mRootView, this.jrc);
        this.jra.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cFR();
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
            arVar.aq("obj_type", 1);
        } else if (i == 502) {
            arVar.aq("obj_type", 8);
        } else if (i == 504) {
            arVar.aq("obj_type", 11);
        } else if (this.tabType == 3) {
            arVar.aq("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            arVar.aq("obj_type", 12);
        }
        arVar.aq("obj_locate", i2);
        arVar.bsR();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.jra.rc(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.jlI);
            if (this.jot == null) {
                this.jot = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.jot.setTitle(null);
            this.jot.setSubText(str);
            this.jot.setButtonText(null);
            this.jot.attachView(view, z);
            this.jot.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.jra.rc(true);
        if (this.jot != null) {
            this.jot.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.jra != null) {
                this.jra.lU(false);
                this.jra.cFv();
                this.jra.a(dVar);
            }
            if (this.jrb.cGe() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
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
        if (!this.jrb.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.jra != null) {
            this.jra.lU(false);
        }
    }

    public void aq(cb cbVar) {
        if (cbVar != null) {
            this.jrb.aq(cbVar);
        }
    }

    public void cFP() {
        cFQ();
        int i = 0;
        Iterator<n> it = this.jrb.cGd().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof ca ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            cra();
        }
    }

    private void cFQ() {
        cb cbVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.cBx().cBB()) && this.jra.cGb() != null && this.jra.cGb().getData() != null) {
            ArrayList<n> arrayList = this.jrb.cGd().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<n> it = arrayList.iterator();
                List<n> data = this.jra.cGb().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.cBx().cBB());
                int i = 0;
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof ca) {
                        cbVar = ((ca) next).eLr;
                    } else if (!(next instanceof cb)) {
                        cbVar = null;
                    } else {
                        cbVar = (cb) next;
                    }
                    if (cbVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!au.equals(com.baidu.tieba.frs.a.cBx().cBB().get(i2).getId(), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jra.cGb().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cra() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.jie != null) {
                this.jie.stopPlay();
            }
            if (this.jrb != null) {
                this.jrb.zl(this.sortType);
            }
        }
    }

    private void cFR() {
        if (l.isNetOk()) {
            if (this.jie != null) {
                this.jie.stopPlay();
            }
            if (this.jrb != null) {
                this.jrb.zk(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cFR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        t.csH().pB(false);
        MessageManager.getInstance().unRegisterListener(this.jlI);
        MessageManager.getInstance().unRegisterListener(this.jrj);
        super.onDestroy();
        if (this.jra != null) {
            this.jra.onDestroy();
        }
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jra != null) {
                this.jra.resume();
            }
            if (this.jrg) {
                this.jrg = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("first_into_tab_profession", true) || cFS()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("first_into_tab_profession", false);
                        cFT();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Ln(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cFV();
        } else if (this.jra != null) {
            this.jra.pause();
        }
        cFl();
    }

    private boolean cFS() {
        return (this.jrc == null || this.jrc.getForum() == null || StringUtils.isNull(this.jrc.getForum().getFirst_class()) || !this.jrc.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cFT() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.nB(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        professionDialogLayout.setCloseViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bn(professionDialogLayout);
        aVar.jF(false);
        aVar.jG(false);
        aVar.b(getPageContext()).bqz();
    }

    private void cFl() {
        if (isPrimary()) {
            if (this.jot != null && this.jot.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jlI);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    public void cFU() {
        if (this.jra != null) {
            this.jra.refreshView();
        }
    }

    private void cFV() {
        if (this.tabId == 502) {
            ar arVar = new ar("c13376");
            arVar.dR("fid", this.forumId);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jra != null) {
            this.jra.pause();
        }
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jrf != 3 || this.jra != null) {
            this.jrf = i;
            super.onChangeSkinType(i);
            this.jra.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.jre);
        bundle.putBoolean("need_log", this.jrd);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.jrh);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.jie != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    String stringExtra = intent.getStringExtra("tid");
                    int intExtra = intent.getIntExtra("type", -1);
                    if (!StringUtils.isNull(stringExtra) && intExtra == 0) {
                        this.jra.KA(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCm() {
        this.jra.cCm();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSD() {
        cCm();
        this.jra.lU(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), cFW(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cFW() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Aw(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void zi(int i) {
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.rn(i);
        }
    }

    public c cFX() {
        return this.jrb;
    }

    public b cFY() {
        return this.jra;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bup() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.jrb.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cFR();
                return;
            }
            this.jra.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void buq() {
    }

    @Override // com.baidu.tieba.recapp.q
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAX().a(advertAppInfo, this.forumId, 0L, advertAppInfo.page, str, this.jrb.getPn());
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDg() {
    }

    @Override // com.baidu.tieba.recapp.q
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.q
    public int getPageNum() {
        return this.jrb.getPn();
    }
}
