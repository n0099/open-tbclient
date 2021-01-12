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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.i;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, ao, aq, p {
    public String forumId;
    public String forumName;
    public boolean isBrandForum;
    public int isGeneralTab;
    private VoiceManager jaA;
    private ThreadCardViewHolder jaS;
    private com.baidu.tbadk.l.c jgO;
    public boolean jjA;
    private boolean jjD;
    protected b jjw;
    protected c jjx;
    public FrsViewData jjy;
    public boolean jjz;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int jjB = 3;
    private boolean jjC = true;
    private int dTc = 0;
    private int jby = 0;
    private int sortType = 0;
    private CustomMessageListener jee = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.yX(num.intValue());
            }
        }
    };
    private CustomMessageListener jbN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.jjw != null) {
                        FrsCommonTabFragment.this.jjw.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.jgO != null && FrsCommonTabFragment.this.jgO.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.jjw != null) {
                        FrsCommonTabFragment.this.jjw.lQ(true);
                    }
                    FrsCommonTabFragment.this.btS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener jjE = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.jjw.JF(str);
                }
            }
        }
    };
    private CustomMessageListener jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cCm = FrsCommonTabFragment.this.jjw.cCm();
                    if (cCm != null && cCm.dxN() != null && (cCm.dxN().getTag() instanceof ThreadCardViewHolder)) {
                        FrsCommonTabFragment.this.jaS = (ThreadCardViewHolder) cCm.dxN().getTag();
                    }
                    if (FrsCommonTabFragment.this.jaS != null && FrsCommonTabFragment.this.jaS.tm() != null) {
                        FrsCommonTabFragment.this.jaS.tm().b(new a.C0089a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsCommonTabFragment.this.jjx != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FrsCommonTabFragment.this.jjx.JG(str);
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.jby += i2;
            if (FrsCommonTabFragment.this.jby >= FrsCommonTabFragment.this.dTc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dKg().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.jjA = bundle.getBoolean("can_auto_play_video");
            this.jjz = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.jjy = (FrsViewData) bundle.getSerializable("view_data");
            this.jjD = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
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
                this.jjA = arguments.getBoolean("can_auto_play_video");
                this.jjz = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.jjy = (FrsViewData) arguments.getSerializable("view_data");
                this.jjD = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
        }
        this.jaA = getVoiceManager();
        this.jaA.onCreate(getPageContext());
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        this.jjx = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.jjx.setTabType(this.tabType);
        this.jjx.setFunAdController(com.baidu.tieba.funad.a.rC(this.jjD));
        registerListener(this.jbN);
        registerListener(this.jjE);
        registerListener(this.jcq);
        registerListener(this.jjF);
        this.dTc = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.jjw = new b(this, this.mRootView, this.jjy);
        this.jjw.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cEr();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        cs(this.tabId, 2);
    }

    private void cs(int i, int i2) {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dW("fid", this.forumId);
        if (i == 89) {
            aqVar.an("obj_type", 1);
        } else if (i == 502) {
            aqVar.an("obj_type", 8);
        } else if (i == 504) {
            aqVar.an("obj_type", 11);
        } else if (this.tabType == 3) {
            aqVar.an("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            aqVar.an("obj_type", 12);
        }
        aqVar.an("obj_locate", i2);
        aqVar.bsu();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.jjw.qS(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.jee);
            if (this.jgO == null) {
                this.jgO = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.jgO.setTitle(null);
            this.jgO.setSubText(str);
            this.jgO.setButtonText(null);
            this.jgO.attachView(view, z);
            this.jgO.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.jjw.qS(true);
        if (this.jgO != null) {
            this.jgO.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.jjw != null) {
                this.jjw.lQ(false);
                this.jjw.cDW();
                this.jjw.a(dVar);
            }
            if (this.jjx.cEE() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
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
        if (!this.jjx.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.jjw != null) {
            this.jjw.lQ(false);
        }
    }

    public void ap(bz bzVar) {
        if (bzVar != null) {
            this.jjx.ap(bzVar);
        }
    }

    public void cEp() {
        cEq();
        int i = 0;
        Iterator<n> it = this.jjx.cED().threadList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof by ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            cpD();
        }
    }

    private void cEq() {
        bz bzVar;
        if (!x.isEmpty(com.baidu.tieba.frs.a.czZ().cAd()) && this.jjw.cEB() != null && this.jjw.cEB().getData() != null) {
            ArrayList<n> arrayList = this.jjx.cED().threadList;
            if (!x.isEmpty(arrayList)) {
                Iterator<n> it = arrayList.iterator();
                List<n> data = this.jjw.cEB().getData();
                int count = x.getCount(com.baidu.tieba.frs.a.czZ().cAd());
                int i = 0;
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof by) {
                        bzVar = ((by) next).eHK;
                    } else if (!(next instanceof bz)) {
                        bzVar = null;
                    } else {
                        bzVar = (bz) next;
                    }
                    if (bzVar != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!at.equals(com.baidu.tieba.frs.a.czZ().cAd().get(i2).getId(), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jjw.cEB().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cpD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.jaA != null) {
                this.jaA.stopPlay();
            }
            if (this.jjx != null) {
                this.jjx.za(this.sortType);
            }
        }
    }

    private void cEr() {
        if (l.isNetOk()) {
            if (this.jaA != null) {
                this.jaA.stopPlay();
            }
            if (this.jjx != null) {
                this.jjx.yZ(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cEr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        s.crj().pr(false);
        MessageManager.getInstance().unRegisterListener(this.jee);
        MessageManager.getInstance().unRegisterListener(this.jjF);
        super.onDestroy();
        if (this.jjw != null) {
            this.jjw.onDestroy();
        }
        if (this.jaA != null) {
            this.jaA.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jjw != null) {
                this.jjw.resume();
            }
            if (this.jjC) {
                this.jjC = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("first_into_tab_profession", true) || cEs()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("first_into_tab_profession", false);
                        cEt();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Ks(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cEv();
        } else if (this.jjw != null) {
            this.jjw.pause();
        }
        cDM();
    }

    private boolean cEs() {
        return (this.jjy == null || this.jjy.getForum() == null || StringUtils.isNull(this.jjy.getForum().getFirst_class()) || !this.jjy.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cEt() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.nx(1);
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
        aVar.br(professionDialogLayout);
        aVar.jD(false);
        aVar.jE(false);
        aVar.b(getPageContext()).bqe();
    }

    private void cDM() {
        if (isPrimary()) {
            if (this.jgO != null && this.jgO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jee);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    public void cEu() {
        if (this.jjw != null) {
            this.jjw.refreshView();
        }
    }

    private void cEv() {
        if (this.tabId == 502) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13376");
            aqVar.dW("fid", this.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jaA != null) {
            this.jaA.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jjw != null) {
            this.jjw.pause();
        }
        if (this.jaA != null) {
            this.jaA.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jjB != 3 || this.jjw != null) {
            this.jjB = i;
            super.onChangeSkinType(i);
            this.jjw.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.jjA);
        bundle.putBoolean("need_log", this.jjz);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.jjD);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.jaA != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jaA != null) {
            this.jaA.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
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
                        this.jjw.JF(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cAO() {
        this.jjw.cAO();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bRN() {
        cAO();
        this.jjw.lQ(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), cEw(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cEw() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Al(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void yX(int i) {
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.rh(i);
        }
    }

    public c cEx() {
        return this.jjx;
    }

    public b cEy() {
        return this.jjw;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.aq
    public void btS() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.jjx.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cEr();
                return;
            }
            this.jjw.lQ(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void btT() {
    }

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAC().a(advertAppInfo, this.forumId, 0L, advertAppInfo.page, str, this.jjx.getPn());
    }

    @Override // com.baidu.tieba.recapp.p
    public void cBH() {
    }

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        return this.jjx.getPn();
    }
}
