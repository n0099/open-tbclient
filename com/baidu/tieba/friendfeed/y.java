package com.baidu.tieba.friendfeed;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.ch;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f {
    private com.baidu.tbadk.core.view.o ahX;
    private NoNetworkView aoS;
    private FriendFeedActivity azF;
    private q azG;
    private ViewGroup azH;
    private BdListView azI;
    private PbEditor azJ;
    private ch azK;
    private Handler handler;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public y(FriendFeedActivity friendFeedActivity) {
        super(friendFeedActivity);
        this.handler = null;
        this.azK = null;
        this.azF = friendFeedActivity;
        friendFeedActivity.setContentView(com.baidu.tieba.w.friend_feed_view);
        this.handler = new Handler();
        s(friendFeedActivity);
        t(friendFeedActivity);
    }

    public PbEditor EQ() {
        return this.azJ;
    }

    private void s(FriendFeedActivity friendFeedActivity) {
        this.mRootView = (ViewGroup) this.azF.findViewById(com.baidu.tieba.v.content);
        this.mNavigationBar = (NavigationBar) this.azF.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.azF.getString(com.baidu.tieba.y.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void t(FriendFeedActivity friendFeedActivity) {
        this.aoS = (NoNetworkView) this.azF.findViewById(com.baidu.tieba.v.view_no_network);
        this.azH = (ViewGroup) this.azF.findViewById(com.baidu.tieba.v.content_with_data);
        this.ahX = NoDataViewFactory.a(this.azF, this.mRootView, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.friendfeed__no_data), null);
        this.azI = (BdListView) friendFeedActivity.findViewById(com.baidu.tieba.v.friend_feed_list);
        this.azG = new q(this.azF, com.baidu.adp.lib.util.m.n(this.azF), ba.mD().mF());
        this.azI.setAdapter((ListAdapter) this.azG);
        this.azJ = (PbEditor) this.azF.findViewById(com.baidu.tieba.v.friendfeed_editor);
        this.azJ.setHideBaobao(true);
        this.azJ.au(false);
    }

    public void onChangeSkinType(int i) {
        this.azF.getLayoutMode().L(i == 1);
        this.azF.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
        if (this.azJ != null) {
            this.azJ.changeSkinType(i);
        }
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
    }

    public void ER() {
        this.azJ.w(this.azJ.getEditText());
        this.azJ.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.azJ.Bc();
        this.azJ.refresh();
        if (this.azJ.BD()) {
            this.azJ.Ch();
        } else {
            this.azJ.getEditText().requestFocus();
            this.azJ.v(this.azJ.getEditText());
        }
        I(i, i2);
    }

    protected void I(int i, int i2) {
        this.azK = new ch(this.azF, i, i2, this.azJ, this.azI, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.azK, 300L);
    }

    public void hideProgress() {
        this.azI.hN();
    }

    public q ES() {
        return this.azG;
    }

    public void bP(boolean z) {
        if (z) {
            this.azH.setVisibility(8);
            this.ahX.setVisibility(0);
            return;
        }
        this.azH.setVisibility(0);
        this.ahX.setVisibility(8);
    }

    public BdListView ET() {
        return this.azI;
    }

    public boolean Cj() {
        return this.azJ.Cj();
    }

    public void EU() {
        if (this.azG != null) {
            this.azG.notifyDataSetChanged();
        }
    }

    public void bQ(boolean z) {
        this.azF.hideProgressBar();
        if (z) {
            this.azJ.getEditText().setText("");
            this.azJ.Ca();
            this.azJ.clearData();
        }
    }

    public void fc(String str) {
        this.azJ.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azJ.arn.a(writeImagesInfo, z);
    }

    public void EV() {
        this.azF.showProgressBar();
    }

    public void p(ArrayList<String> arrayList) {
        this.azJ.p(arrayList);
    }

    public String EW() {
        return this.azJ.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.azJ.getAudioData();
    }

    public void BR() {
        this.azJ.BR();
    }

    public void BS() {
        this.azJ.BS();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.azJ.setOnActionListener(new z(this, wVar));
        }
    }
}
