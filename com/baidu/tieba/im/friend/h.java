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
    private NoNetworkView axO;
    private IMBlackListActivity bbv;
    private e bbz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        this.bbv = iMBlackListActivity;
        initialize();
    }

    public void OA() {
        this.mProgress.setVisibility(0);
    }

    public void OB() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.bbz.b(aVar);
        if (this.bbz.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bbz.notifyDataSetChanged();
    }

    public void Jq() {
        if (this.bbz.getCount() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bbz.notifyDataSetChanged();
    }

    public void F(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        this.bbz.s(arrayList);
        this.bbz.notifyDataSetChanged();
    }

    private void initialize() {
        this.bbv.setContentView(com.baidu.tieba.x.im_black_list);
        this.mRoot = this.bbv.findViewById(com.baidu.tieba.w.root_view);
        this.axO = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.w.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(z.chat_black_list_title);
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.w.black_list);
        this.mNoDataView = NoDataViewFactory.a(this.bbv.getPageContext().getContext(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.black_list_no_data_text), null);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.w.progress);
        this.bbz = new e(this.bbv);
        this.mListView.setAdapter((ListAdapter) this.bbz);
        qF();
    }

    private void qF() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.bbv.getLayoutMode().ab(skinType == 1);
        this.bbv.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bbv.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bbv.getPageContext(), skinType);
        this.axO.onChangeSkinType(this.bbv.getPageContext(), skinType);
    }
}
