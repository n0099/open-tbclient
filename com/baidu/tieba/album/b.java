package com.baidu.tieba.album;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private n apH;
    private com.baidu.tbadk.img.e apK;
    private AlbumActivity apM;
    private View apN;
    private h apO;
    private ImageView apP;
    private View apQ;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apM = (AlbumActivity) getBaseFragmentActivity();
        this.apH = this.apM.BB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.x.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.navigation_bar);
        this.apN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.apM);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.album_big_image_choose, (ViewGroup) null);
        this.apP = (ImageView) inflate.findViewById(com.baidu.tieba.w.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.w.viewPager);
        this.apK = this.apM.BC();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.apQ = this.mRoot.findViewById(com.baidu.tieba.w.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            BJ();
        }
    }

    private void BH() {
        if (this.apH == null && this.apM != null) {
            this.apH = this.apM.BB();
        }
        if (this.apH != null && this.apH.BP() != null) {
            int currentIndex = this.apH.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.apH.BP().size() - 1) {
                    this.mCurrentIndex = this.apH.BP().size() - 1;
                }
                this.apH.setCurrentIndex(-1);
                el(this.mCurrentIndex + 1);
                this.apO = null;
                this.apO = new h(this.apM, this.apK);
                this.mViewPager.setAdapter(this.apO);
                if (this.mCurrentIndex == 0 && this.apH.BP() != null) {
                    if (this.apH.isAdded(this.apH.BP().get(this.mCurrentIndex))) {
                        a(this.apP, true);
                    } else {
                        a(this.apP, false);
                    }
                }
            }
            this.apO.setData(this.apH.BP());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.apO != null) {
            this.apO.setData(null);
        }
    }

    public View BI() {
        return this.apN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.apM.getLayoutMode().ab(i == 1);
        this.apM.getLayoutMode().h(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.apM.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                bc.i(imageView, com.baidu.tieba.v.btn_add_finish_s);
            } else {
                bc.i(imageView, com.baidu.tieba.v.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(int i) {
        if (this.apH != null && this.apH.BP() != null) {
            String string = this.apM.getPageContext().getContext().getString(com.baidu.tieba.z.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.apH.BP().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo em;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.apO != null && (em = this.apO.em(this.mCurrentIndex)) != null && em.getFilePath() != null && em.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.apP, z);
        }
    }

    private void BJ() {
        if (!isHidden()) {
            this.apQ.setVisibility(8);
            this.mViewPager.setVisibility(0);
            BH();
        }
    }
}
