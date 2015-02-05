package com.baidu.tieba.friendfeed;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.g<FriendFeedActivity> {
    private p aCA;
    private ViewGroup aCB;
    private PbEditor aCC;
    private af aCD;
    TbPageContext<FriendFeedActivity> aCy;
    private FriendFeedActivity aCz;
    private Handler handler;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ViewGroup mRootView;

    public x(TbPageContext<FriendFeedActivity> tbPageContext) {
        super(tbPageContext);
        this.handler = null;
        this.aCD = null;
        this.aCy = tbPageContext;
        this.aCz = tbPageContext.getOrignalPage();
        this.aCz.setContentView(com.baidu.tieba.x.friend_feed_view);
        this.handler = new Handler();
        initHeader();
        FA();
    }

    public PbEditor Fz() {
        return this.aCC;
    }

    private void initHeader() {
        this.mRootView = (ViewGroup) this.aCz.findViewById(com.baidu.tieba.w.content);
        this.mNavigationBar = (NavigationBar) this.aCz.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aCz.getPageContext().getString(z.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void FA() {
        this.mNoNetworkView = (NoNetworkView) this.aCz.findViewById(com.baidu.tieba.w.view_no_network);
        this.aCB = (ViewGroup) this.aCz.findViewById(com.baidu.tieba.w.content_with_data);
        this.mNoDataView = NoDataViewFactory.a(this.aCz.getPageContext().getPageActivity(), this.mRootView, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.friendfeed__no_data), null);
        this.mBdListView = (BdListView) this.aCz.findViewById(com.baidu.tieba.w.friend_feed_list);
        this.aCA = new p(this.aCz, com.baidu.adp.lib.util.l.M(this.aCz.getPageContext().getPageActivity()), bg.pB().pD());
        this.mBdListView.setAdapter((ListAdapter) this.aCA);
        this.aCC = (PbEditor) this.aCz.findViewById(com.baidu.tieba.w.friendfeed_editor);
        this.aCC.setHideBaobao(true);
        this.aCC.aK(false);
    }

    public void onChangeSkinType(int i) {
        this.aCy.getLayoutMode().ab(i == 1);
        this.aCy.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aCy, i);
        this.mNoNetworkView.onChangeSkinType(this.aCy, i);
        if (this.aCC != null) {
            this.aCC.b(this.aCy, i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aCy, i);
        }
    }

    public void FB() {
        this.aCC.W(this.aCC.getEditText());
        this.aCC.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.aCC.yL();
        this.aCC.refresh();
        if (this.aCC.afI()) {
            this.aCC.ZZ();
        } else {
            this.aCC.getEditText().requestFocus();
            this.aCC.V(this.aCC.getEditText());
        }
        L(i, i2);
    }

    protected void L(int i, int i2) {
        this.aCD = new af(this.aCz.getPageContext().getPageActivity(), i, i2, this.aCC, this.mBdListView, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.aCD, 300L);
    }

    public void hideProgress() {
        this.mBdListView.jB();
    }

    public p FC() {
        return this.aCA;
    }

    public void showNoDataTip(boolean z) {
        if (z) {
            this.aCB.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.aCB.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public boolean FD() {
        return this.aCC.FD();
    }

    public void FE() {
        if (this.aCA != null) {
            this.aCA.notifyDataSetChanged();
        }
    }

    public void bG(boolean z) {
        this.aCz.hideProgressBar();
        if (z) {
            this.aCC.getEditText().setText("");
            this.aCC.agb();
            this.aCC.clearData();
        }
    }

    public void fz(String str) {
        this.aCC.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCC.bWj.a(writeImagesInfo, z);
    }

    public void FF() {
        this.aCz.showProgressBar();
    }

    public void A(ArrayList<String> arrayList) {
        this.aCC.A(arrayList);
    }

    public String FG() {
        return this.aCC.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aCC.getAudioData();
    }

    public void FH() {
        this.aCC.FH();
    }

    public void FI() {
        this.aCC.FI();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aCC.a(this.aCy, new y(this, wVar));
        }
    }
}
