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
    private ThreadCardViewHolder jgM;
    private VoiceManager jgu;
    private com.baidu.tbadk.l.c jmK;
    protected b jpr;
    protected c jps;
    public FrsViewData jpt;
    public boolean jpu;
    public boolean jpv;
    private boolean jpy;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int jpw = 3;
    private boolean jpx = true;
    private int dVi = 0;
    private int jhs = 0;
    private int sortType = 0;
    private CustomMessageListener jjZ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.zh(num.intValue());
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.jpr != null) {
                        FrsCommonTabFragment.this.jpr.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.jmK != null && FrsCommonTabFragment.this.jmK.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.jpr != null) {
                        FrsCommonTabFragment.this.jpr.lU(true);
                    }
                    FrsCommonTabFragment.this.bum();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener jpz = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.jpr.Kr(str);
                }
            }
        }
    };
    private CustomMessageListener jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cDF = FrsCommonTabFragment.this.jpr.cDF();
                    if (cDF != null && cDF.dAc() != null && (cDF.dAc().getTag() instanceof ThreadCardViewHolder)) {
                        FrsCommonTabFragment.this.jgM = (ThreadCardViewHolder) cDF.dAc().getTag();
                    }
                    if (FrsCommonTabFragment.this.jgM != null && FrsCommonTabFragment.this.jgM.tj() != null) {
                        FrsCommonTabFragment.this.jgM.tj().b(new a.C0089a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsCommonTabFragment.this.jps != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FrsCommonTabFragment.this.jps.Ks(str);
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.jhs += i2;
            if (FrsCommonTabFragment.this.jhs >= FrsCommonTabFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dMz().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.jpv = bundle.getBoolean("can_auto_play_video");
            this.jpu = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.jpt = (FrsViewData) bundle.getSerializable("view_data");
            this.jpy = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
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
                this.jpv = arguments.getBoolean("can_auto_play_video");
                this.jpu = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.jpt = (FrsViewData) arguments.getSerializable("view_data");
                this.jpy = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
        }
        this.jgu = getVoiceManager();
        this.jgu.onCreate(getPageContext());
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        this.jps = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.jps.setTabType(this.tabType);
        this.jps.setFunAdController(com.baidu.tieba.funad.a.rM(this.jpy));
        registerListener(this.jhH);
        registerListener(this.jpz);
        registerListener(this.jil);
        registerListener(this.jpA);
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.jpr = new b(this, this.mRootView, this.jpt);
        this.jpr.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cFL();
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
            arVar.ap("obj_type", 1);
        } else if (i == 502) {
            arVar.ap("obj_type", 8);
        } else if (i == 504) {
            arVar.ap("obj_type", 11);
        } else if (this.tabType == 3) {
            arVar.ap("obj_type", 13);
        } else if (this.isGeneralTab == 1) {
            arVar.ap("obj_type", 12);
        }
        arVar.ap("obj_locate", i2);
        arVar.bsO();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.jpr.rc(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.jjZ);
            if (this.jmK == null) {
                this.jmK = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.jmK.setTitle(null);
            this.jmK.setSubText(str);
            this.jmK.setButtonText(null);
            this.jmK.attachView(view, z);
            this.jmK.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.jpr.rc(true);
        if (this.jmK != null) {
            this.jmK.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.jpr != null) {
                this.jpr.lU(false);
                this.jpr.cFp();
                this.jpr.a(dVar);
            }
            if (this.jps.cFY() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
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
        if (!this.jps.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.jpr != null) {
            this.jpr.lU(false);
        }
    }

    public void aq(cb cbVar) {
        if (cbVar != null) {
            this.jps.aq(cbVar);
        }
    }

    public void cFJ() {
        cFK();
        int i = 0;
        Iterator<n> it = this.jps.cFX().threadList.iterator();
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
            cqU();
        }
    }

    private void cFK() {
        cb cbVar;
        if (!y.isEmpty(com.baidu.tieba.frs.a.cBr().cBv()) && this.jpr.cFV() != null && this.jpr.cFV().getData() != null) {
            ArrayList<n> arrayList = this.jps.cFX().threadList;
            if (!y.isEmpty(arrayList)) {
                Iterator<n> it = arrayList.iterator();
                List<n> data = this.jpr.cFV().getData();
                int count = y.getCount(com.baidu.tieba.frs.a.cBr().cBv());
                int i = 0;
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof ca) {
                        cbVar = ((ca) next).eJQ;
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
                            } else if (!au.equals(com.baidu.tieba.frs.a.cBr().cBv().get(i2).getId(), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jpr.cFV().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void cqU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.jgu != null) {
                this.jgu.stopPlay();
            }
            if (this.jps != null) {
                this.jps.zk(this.sortType);
            }
        }
    }

    private void cFL() {
        if (l.isNetOk()) {
            if (this.jgu != null) {
                this.jgu.stopPlay();
            }
            if (this.jps != null) {
                this.jps.zj(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cFL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        t.csB().pB(false);
        MessageManager.getInstance().unRegisterListener(this.jjZ);
        MessageManager.getInstance().unRegisterListener(this.jpA);
        super.onDestroy();
        if (this.jpr != null) {
            this.jpr.onDestroy();
        }
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jpr != null) {
                this.jpr.resume();
            }
            if (this.jpx) {
                this.jpx = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("first_into_tab_profession", true) || cFM()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("first_into_tab_profession", false);
                        cFN();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Le(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cFP();
        } else if (this.jpr != null) {
            this.jpr.pause();
        }
        cFf();
    }

    private boolean cFM() {
        return (this.jpt == null || this.jpt.getForum() == null || StringUtils.isNull(this.jpt.getForum().getFirst_class()) || !this.jpt.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cFN() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.nA(1);
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
        aVar.b(getPageContext()).bqx();
    }

    private void cFf() {
        if (isPrimary()) {
            if (this.jmK != null && this.jmK.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjZ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    public void cFO() {
        if (this.jpr != null) {
            this.jpr.refreshView();
        }
    }

    private void cFP() {
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
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jpr != null) {
            this.jpr.pause();
        }
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jpw != 3 || this.jpr != null) {
            this.jpw = i;
            super.onChangeSkinType(i);
            this.jpr.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.jpv);
        bundle.putBoolean("need_log", this.jpu);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.jpy);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
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
                        this.jpr.Kr(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCg() {
        this.jpr.cCg();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSx() {
        cCg();
        this.jpr.lU(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), cFQ(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cFQ() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Av(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void zh(int i) {
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.rm(i);
        }
    }

    public c cFR() {
        return this.jps;
    }

    public b cFS() {
        return this.jpr;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.jps.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cFL();
                return;
            }
            this.jpr.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
    }

    @Override // com.baidu.tieba.recapp.q
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, advertAppInfo.page, str, this.jps.getPn());
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDa() {
    }

    @Override // com.baidu.tieba.recapp.q
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.q
    public int getPageNum() {
        return this.jps.getPn();
    }
}
