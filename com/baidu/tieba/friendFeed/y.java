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
    TbPageContext<FriendFeedActivity> aIu;
    private FriendFeedActivity aIv;
    private p aIw;
    private ViewGroup aIx;
    private PbEditor aIy;
    private ai aIz;
    private Handler handler;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ViewGroup mRootView;

    public y(TbPageContext<FriendFeedActivity> tbPageContext) {
        super(tbPageContext);
        this.handler = null;
        this.aIz = null;
        this.aIu = tbPageContext;
        this.aIv = tbPageContext.getOrignalPage();
        this.aIv.setContentView(com.baidu.tieba.w.friend_feed_view);
        this.handler = new Handler();
        initHeader();
        IZ();
    }

    public PbEditor IY() {
        return this.aIy;
    }

    private void initHeader() {
        this.mRootView = (ViewGroup) this.aIv.findViewById(com.baidu.tieba.v.content);
        this.mNavigationBar = (NavigationBar) this.aIv.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aIv.getPageContext().getString(com.baidu.tieba.y.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void IZ() {
        this.mNoNetworkView = (NoNetworkView) this.aIv.findViewById(com.baidu.tieba.v.view_no_network);
        this.aIx = (ViewGroup) this.aIv.findViewById(com.baidu.tieba.v.content_with_data);
        this.mNoDataView = NoDataViewFactory.a(this.aIv.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.friendfeed__no_data), null);
        this.mBdListView = (BdListView) this.aIv.findViewById(com.baidu.tieba.v.friend_feed_list);
        this.aIw = new p(this.aIv, com.baidu.adp.lib.util.n.M(this.aIv.getPageContext().getPageActivity()), be.sY().ta());
        this.mBdListView.setAdapter((ListAdapter) this.aIw);
        this.aIy = (PbEditor) this.aIv.findViewById(com.baidu.tieba.v.friendfeed_editor);
        this.aIy.setHideBaobao(true);
        this.aIy.aQ(false);
    }

    public void onChangeSkinType(int i) {
        this.aIu.getLayoutMode().X(i == 1);
        this.aIu.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aIu, i);
        this.mNoNetworkView.onChangeSkinType(this.aIu, i);
        if (this.aIy != null) {
            this.aIy.b(this.aIu, i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aIu, i);
        }
    }

    public void Ja() {
        this.aIy.Z(this.aIy.getEditText());
        this.aIy.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.aIy.BZ();
        this.aIy.refresh();
        if (this.aIy.alv()) {
            this.aIy.acj();
        } else {
            this.aIy.getEditText().requestFocus();
            this.aIy.Y(this.aIy.getEditText());
        }
        K(i, i2);
    }

    protected void K(int i, int i2) {
        this.aIz = new ai(this.aIv.getPageContext().getPageActivity(), i, i2, this.aIy, this.mBdListView, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.aIz, 300L);
    }

    public void hideProgress() {
        this.mBdListView.mW();
    }

    public p Jb() {
        return this.aIw;
    }

    public void showNoDataTip(boolean z) {
        if (z) {
            this.aIx.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.aIx.setVisibility(0);
        this.mNoDataView.setVisibility(8);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public boolean Jc() {
        return this.aIy.Jc();
    }

    public void Jd() {
        if (this.aIw != null) {
            this.aIw.notifyDataSetChanged();
        }
    }

    public void bK(boolean z) {
        this.aIv.hideProgressBar();
        if (z) {
            this.aIy.getEditText().setText("");
            this.aIy.alO();
            this.aIy.clearData();
        }
    }

    public void fG(String str) {
        this.aIy.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aIy.cmz.a(writeImagesInfo, z);
    }

    public void Je() {
        this.aIv.showProgressBar();
    }

    public void v(ArrayList<String> arrayList) {
        this.aIy.v(arrayList);
    }

    public String Jf() {
        return this.aIy.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aIy.getAudioData();
    }

    public void Jg() {
        this.aIy.Jg();
    }

    public void Jh() {
        this.aIy.Jh();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aIy.a(this.aIu, new z(this, vVar));
        }
    }
}
