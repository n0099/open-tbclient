package com.baidu.tieba.friendfeed;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.az;
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
    private com.baidu.tbadk.core.view.o ahO;
    private NoNetworkView aoJ;
    private PbEditor azA;
    private ch azB;
    private FriendFeedActivity azw;
    private q azx;
    private ViewGroup azy;
    private BdListView azz;
    private Handler handler;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public y(FriendFeedActivity friendFeedActivity) {
        super(friendFeedActivity);
        this.handler = null;
        this.azB = null;
        this.azw = friendFeedActivity;
        friendFeedActivity.setContentView(com.baidu.tieba.w.friend_feed_view);
        this.handler = new Handler();
        s(friendFeedActivity);
        t(friendFeedActivity);
    }

    public PbEditor EO() {
        return this.azA;
    }

    private void s(FriendFeedActivity friendFeedActivity) {
        this.mRootView = (ViewGroup) this.azw.findViewById(com.baidu.tieba.v.content);
        this.mNavigationBar = (NavigationBar) this.azw.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.azw.getString(com.baidu.tieba.y.friendfeed_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void t(FriendFeedActivity friendFeedActivity) {
        this.aoJ = (NoNetworkView) this.azw.findViewById(com.baidu.tieba.v.view_no_network);
        this.azy = (ViewGroup) this.azw.findViewById(com.baidu.tieba.v.content_with_data);
        this.ahO = NoDataViewFactory.a(this.azw, this.mRootView, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.friendfeed__no_data), null);
        this.azz = (BdListView) friendFeedActivity.findViewById(com.baidu.tieba.v.friend_feed_list);
        this.azx = new q(this.azw, com.baidu.adp.lib.util.m.n(this.azw), az.mD().mF());
        this.azz.setAdapter((ListAdapter) this.azx);
        this.azA = (PbEditor) this.azw.findViewById(com.baidu.tieba.v.friendfeed_editor);
        this.azA.setHideBaobao(true);
        this.azA.au(false);
    }

    public void onChangeSkinType(int i) {
        this.azw.getLayoutMode().L(i == 1);
        this.azw.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        this.aoJ.onChangeSkinType(i);
        if (this.azA != null) {
            this.azA.changeSkinType(i);
        }
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
    }

    public void EP() {
        this.azA.w(this.azA.getEditText());
        this.azA.hide();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.azA.Ba();
        this.azA.refresh();
        if (this.azA.BB()) {
            this.azA.Cf();
        } else {
            this.azA.getEditText().requestFocus();
            this.azA.v(this.azA.getEditText());
        }
        I(i, i2);
    }

    protected void I(int i, int i2) {
        this.azB = new ch(this.azw, i, i2, this.azA, this.azz, this.mNavigationBar.getHeight());
        this.handler.postDelayed(this.azB, 300L);
    }

    public void hideProgress() {
        this.azz.hN();
    }

    public q EQ() {
        return this.azx;
    }

    public void bP(boolean z) {
        if (z) {
            this.azy.setVisibility(8);
            this.ahO.setVisibility(0);
            return;
        }
        this.azy.setVisibility(0);
        this.ahO.setVisibility(8);
    }

    public BdListView ER() {
        return this.azz;
    }

    public boolean Ch() {
        return this.azA.Ch();
    }

    public void ES() {
        if (this.azx != null) {
            this.azx.notifyDataSetChanged();
        }
    }

    public void bQ(boolean z) {
        this.azw.hideProgressBar();
        if (z) {
            this.azA.getEditText().setText("");
            this.azA.BY();
            this.azA.clearData();
        }
    }

    public void fc(String str) {
        this.azA.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azA.are.a(writeImagesInfo, z);
    }

    public void ET() {
        this.azw.showProgressBar();
    }

    public void o(ArrayList<String> arrayList) {
        this.azA.o(arrayList);
    }

    public String EU() {
        return this.azA.getContent();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.azA.getAudioData();
    }

    public void BP() {
        this.azA.BP();
    }

    public void BQ() {
        this.azA.BQ();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.azA.setOnActionListener(new z(this, wVar));
        }
    }
}
