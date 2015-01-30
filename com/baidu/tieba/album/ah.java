package com.baidu.tieba.album;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends BaseFragment implements AbsListView.OnScrollListener, s {
    private n apH;
    private AlbumActivity apM;
    private View apN;
    private e ara;
    private RelativeLayout arb;
    private View arc;
    private View ard;
    private com.baidu.tieba.view.a are;
    private GridView arf;
    private aa arg;
    private boolean arh;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private TextView mTitleText;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apM = (AlbumActivity) getBaseFragmentActivity();
        this.apH = this.apM.BB();
        o.BT().a(this);
        this.ara = new e(this.apM.getPageContext().getPageActivity());
        this.are = new com.baidu.tieba.view.a(this.apM);
        this.apH.eX("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.x.album_image_list_view, (ViewGroup) null);
        this.arb = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.w.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.apN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.apM);
        this.ard = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.album_iamge_title_layout, (View.OnClickListener) null);
        this.mTitleText = (TextView) this.ard.findViewById(com.baidu.tieba.w.navigationTitle_frs);
        this.arf = (GridView) this.mView.findViewById(com.baidu.tieba.w.gv_image_list);
        this.arc = this.mView.findViewById(com.baidu.tieba.w.gv_foot);
        this.arg = new aa(this.apM, this.apH);
        this.arf.setAdapter((ListAdapter) this.arg);
        this.arf.setOnScrollListener(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        am amVar = new am(this);
        this.ard.setOnClickListener(alVar);
        this.are.a(amVar);
        this.arg.a(aiVar);
        this.arg.a(ajVar);
        this.arg.a(akVar);
        this.mNoDataView = NoDataViewFactory.a(this.apM.getPageContext().getPageActivity(), this.arb, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.album_list_no_data, com.baidu.tieba.z.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.arh = false;
        if (isShow()) {
            BJ();
        }
    }

    private void BH() {
        if (this.apH == null && this.apM != null) {
            this.apH = this.apM.BB();
        }
        if (this.apH != null && this.apH.BR() == null) {
            setData(BY(), true);
            eZ("-1");
        }
    }

    private List<ImageFileInfo> BY() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void eZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ara.a(str, new an(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ() {
        this.ara.a(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.arg != null) {
            this.apH.D(list);
            this.arg.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.apM.getLayoutMode().ab(i == 1);
        this.apM.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(this.apM.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View BI() {
        return this.apN;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ara != null) {
            this.ara.BL();
        }
        o.BT().b(this);
    }

    public void l(int i, boolean z) {
        if (this.arf != null) {
            int firstVisiblePosition = this.arf.getFirstVisiblePosition();
            int lastVisiblePosition = this.arf.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.arf.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.w.select_icon);
                    if (z) {
                        bc.i(imageView, com.baidu.tieba.v.btn_choose_photo_s);
                    } else {
                        bc.i(imageView, com.baidu.tieba.v.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.arg != null) {
            l(this.arg.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.arh = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.album.s
    public void bm(boolean z) {
        BJ();
    }

    private void BJ() {
        if (!isHidden() && !this.arh) {
            BH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if ((((i + i2) - 1) / 3) + 1 == (i3 / 3) + 1) {
            if (!this.arc.isShown()) {
                this.arc.setVisibility(0);
            }
        } else if (this.arc.isShown()) {
            this.arc.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.arg.bo(true);
        } else if (this.arg.isScroll()) {
            this.arg.bo(false);
            Ca();
        }
    }

    private void Ca() {
        int childCount = this.arf.getChildCount();
        int firstVisiblePosition = this.arf.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.arf.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.w.pic);
                ImageFileInfo item = this.arg.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.apM.BC().a(item, new ap(this), false, false);
                }
            }
        }
    }
}
