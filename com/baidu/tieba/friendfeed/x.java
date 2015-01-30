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
    TbPageContext<FriendFeedActivity> aCB;
    private FriendFeedActivity aCC;
    private p aCD;
    private ViewGroup aCE;
    private PbEditor aCF;
    private af aCG;
    private Handler handler;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ViewGroup mRootView;

    public x(TbPageContext<FriendFeedActivity> tbPageContext) {
        super(tbPageContext);
        this.handler = null;
        this.aCG = null;
        this.aCB = tbPageContext;
        this.aCC = tbPageContext.getOrignalPage();
        this.aCC.setContentView(com.baidu.tieba.x.friend_feed_view);
        this.handler = new Handler();
        initHeader();
        FG();
    }

    public PbEditor FF() {
        return this.aCF;
    }

    private void initHeader() {
        this.mRootView = (ViewGroup) this.aCC.findViewById(com.baidu.tieba.w.content);
        this.mNavigationBar = (NavigationBar) this.aCC.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aCC.getPageContext().getString(z.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void FG() {
        this.mNoNetworkView = (NoNetworkView) this.aCC.findViewById(com.baidu.tieba.w.view_no_network);
        this.aCE = (ViewGroup) this.aCC.findViewById(com.baidu.tieba.w.content_with_data);
        this.mNoDataView = NoDataViewFactory.a(this.aCC.getPageContext().getPageActivity(), this.mRootView, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.friendfeed__no_data), null);
        this.mBdListView = (BdListView) this.aCC.findViewById(com.baidu.tieba.w.friend_feed_list);
        this.aCD = new p(this.aCC, com.baidu.adp.lib.util.l.M(this.aCC.getPageContext().getPageActivity()), bg.pI().pK());
        this.mBdListView.setAdapter((ListAdapter) this.aCD);
        this.aCF = (PbEditor) this.aCC.findViewById(com.baidu.tieba.w.friendfeed_editor);
        this.aCF.setHideBaobao(true);
        this.aCF.aK(false);
    }

    public void onChangeSkinType(int i) {
        this.aCB.getLayoutMode().ab(i == 1);
        this.aCB.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aCB, i);
        this.mNoNetworkView.onChangeSkinType(this.aCB, i);
        if (this.aCF != null) {
            this.aCF.b(this.aCB, i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aCB, i);
        }
    }

    public void FH() {
        this.aCF.W(this.aCF.getEditText());
        this.aCF.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.aCF.yR();
        this.aCF.refresh();
        if (this.aCF.afN()) {
            this.aCF.aae();
        } else {
            this.aCF.getEditText().requestFocus();
            this.aCF.V(this.aCF.getEditText());
        }
        K(i, i2);
    }

    protected void K(int i, int i2) {
        this.aCG = new af(this.aCC.getPageContext().getPageActivity(), i, i2, this.aCF, this.mBdListView, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.aCG, 300L);
    }

    public void hideProgress() {
        this.mBdListView.jI();
    }

    public p FI() {
        return this.aCD;
    }

    public void showNoDataTip(boolean z) {
        if (z) {
            this.aCE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.aCE.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public boolean FJ() {
        return this.aCF.FJ();
    }

    public void FK() {
        if (this.aCD != null) {
            this.aCD.notifyDataSetChanged();
        }
    }

    public void bG(boolean z) {
        this.aCC.hideProgressBar();
        if (z) {
            this.aCF.getEditText().setText("");
            this.aCF.agg();
            this.aCF.clearData();
        }
    }

    public void fC(String str) {
        this.aCF.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCF.bWk.a(writeImagesInfo, z);
    }

    public void FL() {
        this.aCC.showProgressBar();
    }

    public void A(ArrayList<String> arrayList) {
        this.aCF.A(arrayList);
    }

    public String FM() {
        return this.aCF.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aCF.getAudioData();
    }

    public void FN() {
        this.aCF.FN();
    }

    public void FO() {
        this.aCF.FO();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aCF.a(this.aCB, new y(this, wVar));
        }
    }
}
