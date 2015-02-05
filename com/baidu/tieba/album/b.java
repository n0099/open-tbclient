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
    private n apE;
    private com.baidu.tbadk.img.e apH;
    private AlbumActivity apJ;
    private View apK;
    private h apL;
    private ImageView apM;
    private View apN;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apJ = (AlbumActivity) getBaseFragmentActivity();
        this.apE = this.apJ.Bv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.x.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.navigation_bar);
        this.apK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.apJ);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.album_big_image_choose, (ViewGroup) null);
        this.apM = (ImageView) inflate.findViewById(com.baidu.tieba.w.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.w.viewPager);
        this.apH = this.apJ.Bw();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.apN = this.mRoot.findViewById(com.baidu.tieba.w.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            BD();
        }
    }

    private void BB() {
        if (this.apE == null && this.apJ != null) {
            this.apE = this.apJ.Bv();
        }
        if (this.apE != null && this.apE.BJ() != null) {
            int currentIndex = this.apE.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.apE.BJ().size() - 1) {
                    this.mCurrentIndex = this.apE.BJ().size() - 1;
                }
                this.apE.setCurrentIndex(-1);
                el(this.mCurrentIndex + 1);
                this.apL = null;
                this.apL = new h(this.apJ, this.apH);
                this.mViewPager.setAdapter(this.apL);
                if (this.mCurrentIndex == 0 && this.apE.BJ() != null) {
                    if (this.apE.isAdded(this.apE.BJ().get(this.mCurrentIndex))) {
                        a(this.apM, true);
                    } else {
                        a(this.apM, false);
                    }
                }
            }
            this.apL.setData(this.apE.BJ());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.apL != null) {
            this.apL.setData(null);
        }
    }

    public View BC() {
        return this.apK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.apJ.getLayoutMode().ab(i == 1);
        this.apJ.getLayoutMode().h(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.apJ.getPageContext(), i);
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
        if (this.apE != null && this.apE.BJ() != null) {
            String string = this.apJ.getPageContext().getContext().getString(com.baidu.tieba.z.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.apE.BJ().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo em;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.apL != null && (em = this.apL.em(this.mCurrentIndex)) != null && em.getFilePath() != null && em.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.apM, z);
        }
    }

    private void BD() {
        if (!isHidden()) {
            this.apN.setVisibility(8);
            this.mViewPager.setVisibility(0);
            BB();
        }
    }
}
