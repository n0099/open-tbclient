package com.baidu.tieba.friendfeed;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.af;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.g<FriendFeedActivity> {
    TbPageContext<FriendFeedActivity> aBA;
    private FriendFeedActivity aBB;
    private q aBC;
    private ViewGroup aBD;
    private PbEditor aBE;
    private af aBF;
    private Handler handler;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ViewGroup mRootView;

    public y(TbPageContext<FriendFeedActivity> tbPageContext) {
        super(tbPageContext);
        this.handler = null;
        this.aBF = null;
        this.aBA = tbPageContext;
        this.aBB = tbPageContext.getOrignalPage();
        this.aBB.setContentView(com.baidu.tieba.x.friend_feed_view);
        this.handler = new Handler();
        initHeader();
        Fi();
    }

    public PbEditor Fh() {
        return this.aBE;
    }

    private void initHeader() {
        this.mRootView = (ViewGroup) this.aBB.findViewById(com.baidu.tieba.w.content);
        this.mNavigationBar = (NavigationBar) this.aBB.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aBB.getPageContext().getString(com.baidu.tieba.z.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void Fi() {
        this.mNoNetworkView = (NoNetworkView) this.aBB.findViewById(com.baidu.tieba.w.view_no_network);
        this.aBD = (ViewGroup) this.aBB.findViewById(com.baidu.tieba.w.content_with_data);
        this.mNoDataView = NoDataViewFactory.a(this.aBB.getPageContext().getPageActivity(), this.mRootView, aa.a(NoDataViewFactory.ImgType.NODATA), ab.ci(com.baidu.tieba.z.friendfeed__no_data), null);
        this.mBdListView = (BdListView) this.aBB.findViewById(com.baidu.tieba.w.friend_feed_list);
        this.aBC = new q(this.aBB, com.baidu.adp.lib.util.l.M(this.aBB.getPageContext().getPageActivity()), bb.px().pz());
        this.mBdListView.setAdapter((ListAdapter) this.aBC);
        this.aBE = (PbEditor) this.aBB.findViewById(com.baidu.tieba.w.friendfeed_editor);
        this.aBE.setHideBaobao(true);
        this.aBE.aI(false);
    }

    public void onChangeSkinType(int i) {
        this.aBA.getLayoutMode().ab(i == 1);
        this.aBA.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aBA, i);
        this.mNoNetworkView.onChangeSkinType(this.aBA, i);
        if (this.aBE != null) {
            this.aBE.b(this.aBA, i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aBA, i);
        }
    }

    public void Fj() {
        this.aBE.U(this.aBE.getEditText());
        this.aBE.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.aBE.yB();
        this.aBE.refresh();
        if (this.aBE.afj()) {
            this.aBE.Zz();
        } else {
            this.aBE.getEditText().requestFocus();
            this.aBE.T(this.aBE.getEditText());
        }
        J(i, i2);
    }

    protected void J(int i, int i2) {
        this.aBF = new af(this.aBB.getPageContext().getPageActivity(), i, i2, this.aBE, this.mBdListView, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.aBF, 300L);
    }

    public void hideProgress() {
        this.mBdListView.jJ();
    }

    public q Fk() {
        return this.aBC;
    }

    public void showNoDataTip(boolean z) {
        if (z) {
            this.aBD.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.aBD.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public boolean Fl() {
        return this.aBE.Fl();
    }

    public void Fm() {
        if (this.aBC != null) {
            this.aBC.notifyDataSetChanged();
        }
    }

    public void bD(boolean z) {
        this.aBB.hideProgressBar();
        if (z) {
            this.aBE.getEditText().setText("");
            this.aBE.afC();
            this.aBE.clearData();
        }
    }

    public void fx(String str) {
        this.aBE.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aBE.bUs.a(writeImagesInfo, z);
    }

    public void Fn() {
        this.aBB.showProgressBar();
    }

    public void z(ArrayList<String> arrayList) {
        this.aBE.z(arrayList);
    }

    public String Fo() {
        return this.aBE.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aBE.getAudioData();
    }

    public void Fp() {
        this.aBE.Fp();
    }

    public void Fq() {
        this.aBE.Fq();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aBE.a(this.aBA, new z(this, wVar));
        }
    }
}
