package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f {
    private IMBlackListActivity aVI;
    private e aVM;
    private TextView aVN;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgress;
    private View mRoot;
    private BdListView vl;

    public h(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity);
        this.aVI = iMBlackListActivity;
        ny();
    }

    public void Cz() {
        this.mProgress.setVisibility(0);
    }

    public void MZ() {
        this.mProgress.setVisibility(8);
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        this.aVM.b(aVar);
        if (this.aVM.getCount() <= 0) {
            this.vl.setVisibility(8);
            this.aVN.setVisibility(0);
            return;
        }
        this.vl.setVisibility(0);
        this.aVN.setVisibility(8);
        this.aVM.notifyDataSetChanged();
    }

    public void v(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.vl.setVisibility(8);
            this.aVN.setVisibility(0);
            return;
        }
        this.vl.setVisibility(0);
        this.aVN.setVisibility(8);
        this.aVM.setData(arrayList);
        this.aVM.notifyDataSetChanged();
    }

    private void ny() {
        this.aVI.setContentView(com.baidu.tieba.w.im_black_list);
        this.mRoot = this.aVI.findViewById(com.baidu.tieba.v.root_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(y.chat_black_list_title);
        this.vl = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.black_list);
        this.aVN = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.no_data_container);
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.aVM = new e(this.aVI);
        this.vl.setAdapter((ListAdapter) this.aVM);
        nz();
    }

    private void nz() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.aVI.getLayoutMode().L(skinType == 1);
        this.aVI.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(skinType);
    }
}
