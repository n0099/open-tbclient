package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g<IMBlackListActivity> {
    private NoNetworkView axR;
    private e bbA;
    private IMBlackListActivity bbw;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bbw = iMBlackListActivity;
        initialize();
    }

    public void OF() {
        this.mProgress.setVisibility(0);
    }

    public void OG() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bbA.b(aVar);
        if (this.bbA.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bbA.notifyDataSetChanged();
    }

    public void Jv() {
        if (this.bbA.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bbA.notifyDataSetChanged();
    }

    public void F(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bbA.s(arrayList);
        this.bbA.notifyDataSetChanged();
    }

    private void initialize() {
        this.bbw.setContentView(com.baidu.tieba.x.im_black_list);
        this.mRoot = this.bbw.findViewById(com.baidu.tieba.w.root_view);
        this.axR = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.w.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(z.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bbw.getPageContext().getContext(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.bbA = new e(this.bbw);
        this.mListView.setAdapter((ListAdapter) this.bbA);
        qL();
    }

    private void qL() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bbw.getLayoutMode().ab(skinType == 1);
        this.bbw.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bbw.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bbw.getPageContext(), skinType);
        this.axR.onChangeSkinType(this.bbw.getPageContext(), skinType);
    }
}
