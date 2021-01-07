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
    private VoiceManager jfh;
    private ThreadCardViewHolder jfz;
    private com.baidu.tbadk.l.c jlv;
    protected b jod;
    protected c joe;
    public FrsViewData jof;
    public boolean jog;
    public boolean joh;
    private boolean jok;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    public int tabType;
    private int joi = 3;
    private boolean joj = true;
    private int dXO = 0;
    private int jgf = 0;
    private int sortType = 0;
    private CustomMessageListener jiM = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.AD(num.intValue());
            }
        }
    };
    private CustomMessageListener jgu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.jod != null) {
                        FrsCommonTabFragment.this.jod.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.jlv != null && FrsCommonTabFragment.this.jlv.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.jod != null) {
                        FrsCommonTabFragment.this.jod.lU(true);
                    }
                    FrsCommonTabFragment.this.bxM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener jol = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.jod.KP(str);
                }
            }
        }
    };
    private CustomMessageListener jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    i cGe = FrsCommonTabFragment.this.jod.cGe();
                    if (cGe != null && cGe.dBF() != null && (cGe.dBF().getTag() instanceof ThreadCardViewHolder)) {
                        FrsCommonTabFragment.this.jfz = (ThreadCardViewHolder) cGe.dBF().getTag();
                    }
                    if (FrsCommonTabFragment.this.jfz != null && FrsCommonTabFragment.this.jfz.ty() != null) {
                        FrsCommonTabFragment.this.jfz.ty().b(new a.C0090a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsCommonTabFragment.this.joe != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FrsCommonTabFragment.this.joe.KQ(str);
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.jgf += i2;
            if (FrsCommonTabFragment.this.jgf >= FrsCommonTabFragment.this.dXO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dNY().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.joh = bundle.getBoolean("can_auto_play_video");
            this.jog = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.jof = (FrsViewData) bundle.getSerializable("view_data");
            this.jok = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
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
                this.joh = arguments.getBoolean("can_auto_play_video");
                this.jog = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.jof = (FrsViewData) arguments.getSerializable("view_data");
                this.jok = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
        }
        this.jfh = getVoiceManager();
        this.jfh.onCreate(getPageContext());
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
        this.joe = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        this.joe.setTabType(this.tabType);
        this.joe.setFunAdController(com.baidu.tieba.funad.a.rG(this.jok));
        registerListener(this.jgu);
        registerListener(this.jol);
        registerListener(this.jgX);
        registerListener(this.jom);
        this.dXO = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.jod = new b(this, this.mRootView, this.jof);
        this.jod.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cIj();
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
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("fid", this.forumId);
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
        aqVar.bwo();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.jod.qW(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.jiM);
            if (this.jlv == null) {
                this.jlv = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.jlv.setTitle(null);
            this.jlv.setSubText(str);
            this.jlv.setButtonText(null);
            this.jlv.attachView(view, z);
            this.jlv.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.jod.qW(true);
        if (this.jlv != null) {
            this.jlv.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.jod != null) {
                this.jod.lU(false);
                this.jod.cHO();
                this.jod.a(dVar);
            }
            if (this.joe.cIw() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
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
        if (!this.joe.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.jod != null) {
            this.jod.lU(false);
        }
    }

    public void ap(bz bzVar) {
        if (bzVar != null) {
            this.joe.ap(bzVar);
        }
    }

    public void cIh() {
        cIi();
        int i = 0;
        Iterator<n> it = this.joe.cIv().threadList.iterator();
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
            ctv();
        }
    }

    private void cIi() {
        bz bzVar;
        if (!x.isEmpty(com.baidu.tieba.frs.a.cDR().cDV()) && this.jod.cIt() != null && this.jod.cIt().getData() != null) {
            ArrayList<n> arrayList = this.joe.cIv().threadList;
            if (!x.isEmpty(arrayList)) {
                Iterator<n> it = arrayList.iterator();
                List<n> data = this.jod.cIt().getData();
                int count = x.getCount(com.baidu.tieba.frs.a.cDR().cDV());
                int i = 0;
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof by) {
                        bzVar = ((by) next).eMv;
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
                            } else if (!at.equals(com.baidu.tieba.frs.a.cDR().cDV().get(i2).getId(), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jod.cIt().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void ctv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (l.isNetOk()) {
            if (this.jfh != null) {
                this.jfh.stopPlay();
            }
            if (this.joe != null) {
                this.joe.AG(this.sortType);
            }
        }
    }

    private void cIj() {
        if (l.isNetOk()) {
            if (this.jfh != null) {
                this.jfh.stopPlay();
            }
            if (this.joe != null) {
                this.joe.AF(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            cIj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        s.cvb().pv(false);
        MessageManager.getInstance().unRegisterListener(this.jiM);
        MessageManager.getInstance().unRegisterListener(this.jom);
        super.onDestroy();
        if (this.jod != null) {
            this.jod.onDestroy();
        }
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.jod != null) {
                this.jod.resume();
            }
            if (this.joj) {
                this.joj = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("first_into_tab_profession", true) || cIk()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("first_into_tab_profession", false);
                        cIl();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).LC(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                } else if (!this.isLazyLoaded) {
                    onLazyLoad();
                }
            }
            cIn();
        } else if (this.jod != null) {
            this.jod.pause();
        }
        cHE();
    }

    private boolean cIk() {
        return (this.jof == null || this.jof.getForum() == null || StringUtils.isNull(this.jof.getForum().getFirst_class()) || !this.jof.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void cIl() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.pd(1);
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
        aVar.jH(false);
        aVar.jI(false);
        aVar.b(getPageContext()).btY();
    }

    private void cHE() {
        if (isPrimary()) {
            if (this.jlv != null && this.jlv.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jiM);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    public void cIm() {
        if (this.jod != null) {
            this.jod.refreshView();
        }
    }

    private void cIn() {
        if (this.tabId == 502) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13376");
            aqVar.dX("fid", this.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jod != null) {
            this.jod.pause();
        }
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.joi != 3 || this.jod != null) {
            this.joi = i;
            super.onChangeSkinType(i);
            this.jod.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("name", this.forumName);
        bundle.putBoolean("can_auto_play_video", this.joh);
        bundle.putBoolean("need_log", this.jog);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.jok);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
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
                        this.jod.KP(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cEG() {
        this.jod.cEG();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bVF() {
        cEG();
        this.jod.lU(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), cIo(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String cIo() {
        if (this.tabId != 89 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.BR(getSortType());
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = this.tabId;
        tbPageTag.tabType = this.tabType;
        tbPageTag.isGeneralTab = this.isGeneralTab;
        return tbPageTag;
    }

    public void AD(int i) {
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.sN(i);
        }
    }

    public c cIp() {
        return this.joe;
    }

    public b cIq() {
        return this.jod;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxM() {
        if (getContext() != null) {
            if (j.isNetWorkAvailable()) {
                hideNetRefreshView(this.mRootView);
                if (this.joe.hasData()) {
                    hideLoadingView(this.mRootView);
                } else {
                    showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                cIj();
                return;
            }
            this.jod.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxN() {
    }

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bEw().a(advertAppInfo, this.forumId, 0L, advertAppInfo.page, str, this.joe.getPn());
    }

    @Override // com.baidu.tieba.recapp.p
    public void cFz() {
    }

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        return this.joe.getPn();
    }
}
