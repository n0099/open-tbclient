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
    private n apE;
    private AlbumActivity apJ;
    private View apK;
    private e aqX;
    private RelativeLayout aqY;
    private View aqZ;
    private View ara;
    private com.baidu.tieba.view.a arb;
    private GridView arc;
    private aa ard;
    private boolean are;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private TextView mTitleText;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apJ = (AlbumActivity) getBaseFragmentActivity();
        this.apE = this.apJ.Bv();
        o.BN().a(this);
        this.aqX = new e(this.apJ.getPageContext().getPageActivity());
        this.arb = new com.baidu.tieba.view.a(this.apJ);
        this.apE.eU("-1");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.x.album_image_list_view, (ViewGroup) null);
        this.aqY = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.w.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.apK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.apJ);
        this.ara = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.album_iamge_title_layout, (View.OnClickListener) null);
        this.mTitleText = (TextView) this.ara.findViewById(com.baidu.tieba.w.navigationTitle_frs);
        this.arc = (GridView) this.mView.findViewById(com.baidu.tieba.w.gv_image_list);
        this.aqZ = this.mView.findViewById(com.baidu.tieba.w.gv_foot);
        this.ard = new aa(this.apJ, this.apE);
        this.arc.setAdapter((ListAdapter) this.ard);
        this.arc.setOnScrollListener(this);
        ai aiVar = new ai(this);
        aj ajVar = new aj(this);
        ak akVar = new ak(this);
        al alVar = new al(this);
        am amVar = new am(this);
        this.ara.setOnClickListener(alVar);
        this.arb.a(amVar);
        this.ard.a(aiVar);
        this.ard.a(ajVar);
        this.ard.a(akVar);
        this.mNoDataView = NoDataViewFactory.a(this.apJ.getPageContext().getPageActivity(), this.aqY, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.album_list_no_data, com.baidu.tieba.z.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.are = false;
        if (isShow()) {
            BD();
        }
    }

    private void BB() {
        if (this.apE == null && this.apJ != null) {
            this.apE = this.apJ.Bv();
        }
        if (this.apE != null && this.apE.BL() == null) {
            setData(BS(), true);
            eW("-1");
        }
    }

    private List<ImageFileInfo> BS() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(new ImageFileInfo());
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setAlbumnId("-2");
        arrayList.add(0, imageFileInfo);
        return arrayList;
    }

    private void eW(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aqX.a(str, new an(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        this.aqX.a(new ao(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list, boolean z) {
        if (this.ard != null) {
            this.apE.D(list);
            this.ard.setData(list, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.apJ.getLayoutMode().ab(i == 1);
        this.apJ.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(this.apJ.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View BC() {
        return this.apK;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aqX != null) {
            this.aqX.BF();
        }
        o.BN().b(this);
    }

    public void l(int i, boolean z) {
        if (this.arc != null) {
            int firstVisiblePosition = this.arc.getFirstVisiblePosition();
            int lastVisiblePosition = this.arc.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.arc.getChildAt(i - firstVisiblePosition);
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
        if (imageFileInfo != null && this.ard != null) {
            l(this.ard.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.are = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.album.s
    public void bm(boolean z) {
        BD();
    }

    private void BD() {
        if (!isHidden() && !this.are) {
            BB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (I(((i + i2) - 1) + 1, 3) == I(i3, 3)) {
            if (!this.aqZ.isShown()) {
                this.aqZ.setVisibility(0);
            }
        } else if (this.aqZ.isShown()) {
            this.aqZ.setVisibility(8);
        }
    }

    private int I(int i, int i2) {
        return i % i2 == 0 ? i / i2 : (i / i2) + 1;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.ard.bo(true);
        } else if (this.ard.isScroll()) {
            this.ard.bo(false);
            BU();
        }
    }

    private void BU() {
        int childCount = this.arc.getChildCount();
        int firstVisiblePosition = this.arc.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.arc.getChildAt(i);
            if (childAt != null) {
                HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.w.pic);
                ImageFileInfo item = this.ard.getItem(firstVisiblePosition + i);
                if (item != null && headImageView != null) {
                    headImageView.setTag(item.toCachedKey(false));
                    this.apJ.Bw().a(item, new ap(this), false, false);
                }
            }
        }
    }
}
