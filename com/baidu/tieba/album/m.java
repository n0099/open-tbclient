package com.baidu.tieba.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class m extends BaseFragment implements AdapterView.OnItemClickListener {
    private p aoJ;
    private AlbumActivity aoO;
    private View aoP;
    private RelativeLayout apl;
    private j apm;
    private e apn;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aoO = (AlbumActivity) getBaseFragmentActivity();
        this.aoJ = this.aoO.Bc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.x.album_list_view, (ViewGroup) null);
        this.apl = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.w.parent);
        this.mListView = (BdListView) this.mView.findViewById(com.baidu.tieba.w.album_list);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aoP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aoO);
        this.mNavigationBar.setTitleText(this.aoO.getPageContext().getString(com.baidu.tieba.z.album));
        this.mNoDataView = NoDataViewFactory.a(this.aoO.getPageContext().getContext(), this.apl, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.album_list_no_data, com.baidu.tieba.z.album_list_no_data_1), null);
        this.apm = new j(this.aoO);
        this.mListView.setAdapter((ListAdapter) this.apm);
        this.mListView.setOnScrollListener(this.apm);
        this.mListView.setOnItemClickListener(this);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Bk();
    }

    public void setData(List<a> list) {
        if (this.apm != null) {
            this.apm.setData(list);
        }
    }

    private void Bn() {
        if (this.apn == null) {
            this.apn = new e(this.aoO.getPageContext().getContext());
        }
        this.apn.a(new n(this));
    }

    public View getBtnBack() {
        return this.aoP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item;
        super.onItemClick(adapterView, view, i, j);
        if (this.apm != null && (item = this.apm.getItem(i)) != null && this.aoJ != null && this.aoO != null) {
            this.aoJ.eT(item.getAlbumId());
            this.aoJ.setLastAlbumId(item.getAlbumId());
            this.aoO.ee(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aoO.getLayoutMode().ab(i == 1);
        this.aoO.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(this.aoO.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.apn != null) {
            this.apn.Bl();
        }
    }

    private void Bk() {
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        Bn();
    }
}
