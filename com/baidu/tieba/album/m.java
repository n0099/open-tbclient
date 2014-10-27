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
    private RelativeLayout ahN;
    private com.baidu.tbadk.core.view.o ahO;
    private j ahP;
    private e ahQ;
    private p ahk;
    private AlbumActivity ahq;
    private View ahr;
    private NavigationBar mNavigationBar;
    private View mView;
    private BdListView vl;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahq = (AlbumActivity) getActivity();
        this.ahk = this.ahq.xH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.w.album_list_view, (ViewGroup) null);
        this.ahN = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.v.parent);
        this.vl = (BdListView) this.mView.findViewById(com.baidu.tieba.v.album_list);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.ahr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ahq);
        this.mNavigationBar.setTitleText(this.ahq.getString(com.baidu.tieba.y.album));
        this.ahO = NoDataViewFactory.a(this.ahq, this.ahN, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.album_list_no_data, com.baidu.tieba.y.album_list_no_data_1), null);
        this.ahP = new j(this.ahq);
        this.vl.setAdapter((ListAdapter) this.ahP);
        this.vl.setOnScrollListener(this.ahP);
        this.vl.setOnItemClickListener(this);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        xP();
    }

    public void setData(List<a> list) {
        if (this.ahP != null) {
            this.ahP.setData(list);
        }
    }

    private void xS() {
        if (this.ahQ == null) {
            this.ahQ = new e(this.ahq);
        }
        this.ahQ.a(new n(this));
    }

    public View getBtnBack() {
        return this.ahr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item;
        super.onItemClick(adapterView, view, i, j);
        if (this.ahP != null && (item = this.ahP.getItem(i)) != null && this.ahk != null && this.ahq != null) {
            this.ahk.eo(item.getAlbumId());
            this.ahk.setLastAlbumId(item.getAlbumId());
            this.ahq.dK(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ahq.getLayoutMode().L(i == 1);
        this.ahq.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ahQ != null) {
            this.ahQ.xQ();
        }
    }

    private void xP() {
        this.vl.setVisibility(0);
        this.ahO.setVisibility(8);
        xS();
    }
}
