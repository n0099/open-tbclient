package com.baidu.tieba.friendFeed;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.ai;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.g<FriendFeedActivity> {
    TbPageContext<FriendFeedActivity> aIC;
    private FriendFeedActivity aID;
    private p aIE;
    private ViewGroup aIF;
    private PbEditor aIG;
    private ai aIH;
    private Handler handler;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ViewGroup mRootView;

    public y(TbPageContext<FriendFeedActivity> tbPageContext) {
        super(tbPageContext);
        this.handler = null;
        this.aIH = null;
        this.aIC = tbPageContext;
        this.aID = tbPageContext.getOrignalPage();
        this.aID.setContentView(com.baidu.tieba.w.friend_feed_view);
        this.handler = new Handler();
        initHeader();
        Jf();
    }

    public PbEditor Je() {
        return this.aIG;
    }

    private void initHeader() {
        this.mRootView = (ViewGroup) this.aID.findViewById(com.baidu.tieba.v.content);
        this.mNavigationBar = (NavigationBar) this.aID.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aID.getPageContext().getString(com.baidu.tieba.y.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void Jf() {
        this.mNoNetworkView = (NoNetworkView) this.aID.findViewById(com.baidu.tieba.v.view_no_network);
        this.aIF = (ViewGroup) this.aID.findViewById(com.baidu.tieba.v.content_with_data);
        this.mNoDataView = NoDataViewFactory.a(this.aID.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.friendfeed__no_data), null);
        this.mBdListView = (BdListView) this.aID.findViewById(com.baidu.tieba.v.friend_feed_list);
        this.aIE = new p(this.aID, com.baidu.adp.lib.util.n.M(this.aID.getPageContext().getPageActivity()), be.sY().ta());
        this.mBdListView.setAdapter((ListAdapter) this.aIE);
        this.aIG = (PbEditor) this.aID.findViewById(com.baidu.tieba.v.friendfeed_editor);
        this.aIG.setHideBaobao(true);
        this.aIG.aQ(false);
    }

    public void onChangeSkinType(int i) {
        this.aIC.getLayoutMode().X(i == 1);
        this.aIC.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aIC, i);
        this.mNoNetworkView.onChangeSkinType(this.aIC, i);
        if (this.aIG != null) {
            this.aIG.b(this.aIC, i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aIC, i);
        }
    }

    public void Jg() {
        this.aIG.Z(this.aIG.getEditText());
        this.aIG.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.aIG.Cf();
        this.aIG.refresh();
        if (this.aIG.alK()) {
            this.aIG.acy();
        } else {
            this.aIG.getEditText().requestFocus();
            this.aIG.Y(this.aIG.getEditText());
        }
        K(i, i2);
    }

    protected void K(int i, int i2) {
        this.aIH = new ai(this.aID.getPageContext().getPageActivity(), i, i2, this.aIG, this.mBdListView, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.aIH, 300L);
    }

    public void hideProgress() {
        this.mBdListView.mW();
    }

    public p Jh() {
        return this.aIE;
    }

    public void showNoDataTip(boolean z) {
        if (z) {
            this.aIF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.aIF.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public boolean Ji() {
        return this.aIG.Ji();
    }

    public void Jj() {
        if (this.aIE != null) {
            this.aIE.notifyDataSetChanged();
        }
    }

    public void bK(boolean z) {
        this.aID.hideProgressBar();
        if (z) {
            this.aIG.getEditText().setText("");
            this.aIG.amd();
            this.aIG.clearData();
        }
    }

    public void fJ(String str) {
        this.aIG.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aIG.cmP.a(writeImagesInfo, z);
    }

    public void Jk() {
        this.aID.showProgressBar();
    }

    public void v(ArrayList<String> arrayList) {
        this.aIG.v(arrayList);
    }

    public String Jl() {
        return this.aIG.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aIG.getAudioData();
    }

    public void Jm() {
        this.aIG.Jm();
    }

    public void Jn() {
        this.aIG.Jn();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aIG.a(this.aIC, new z(this, vVar));
        }
    }
}
