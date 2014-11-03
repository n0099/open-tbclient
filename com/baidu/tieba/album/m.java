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
    private View ahA;
    private RelativeLayout ahW;
    private com.baidu.tbadk.core.view.o ahX;
    private j ahY;
    private e ahZ;
    private p aht;
    private AlbumActivity ahz;
    private NavigationBar mNavigationBar;
    private View mView;
    private BdListView vl;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahz = (AlbumActivity) getActivity();
        this.aht = this.ahz.xJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.w.album_list_view, (ViewGroup) null);
        this.ahW = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.v.parent);
        this.vl = (BdListView) this.mView.findViewById(com.baidu.tieba.v.album_list);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.ahA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ahz);
        this.mNavigationBar.setTitleText(this.ahz.getString(com.baidu.tieba.y.album));
        this.ahX = NoDataViewFactory.a(this.ahz, this.ahW, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.album_list_no_data, com.baidu.tieba.y.album_list_no_data_1), null);
        this.ahY = new j(this.ahz);
        this.vl.setAdapter((ListAdapter) this.ahY);
        this.vl.setOnScrollListener(this.ahY);
        this.vl.setOnItemClickListener(this);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        xR();
    }

    public void setData(List<a> list) {
        if (this.ahY != null) {
            this.ahY.setData(list);
        }
    }

    private void xU() {
        if (this.ahZ == null) {
            this.ahZ = new e(this.ahz);
        }
        this.ahZ.a(new n(this));
    }

    public View getBtnBack() {
        return this.ahA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item;
        super.onItemClick(adapterView, view, i, j);
        if (this.ahY != null && (item = this.ahY.getItem(i)) != null && this.aht != null && this.ahz != null) {
            this.aht.eo(item.getAlbumId());
            this.aht.setLastAlbumId(item.getAlbumId());
            this.ahz.dK(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ahz.getLayoutMode().L(i == 1);
        this.ahz.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ahZ != null) {
            this.ahZ.xS();
        }
    }

    private void xR() {
        this.vl.setVisibility(0);
        this.ahX.setVisibility(8);
        xU();
    }
}
