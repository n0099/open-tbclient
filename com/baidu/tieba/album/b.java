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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private p aoJ;
    private com.baidu.tbadk.img.e aoM;
    private AlbumActivity aoO;
    private View aoP;
    private h aoQ;
    private ImageView aoR;
    private View aoS;
    private int mCurrentIndex = -1;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView mTitle;
    private ViewPager mViewPager;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aoO = (AlbumActivity) getBaseFragmentActivity();
        this.aoJ = this.aoO.Bc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.x.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.w.navigation_bar);
        this.aoP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aoO);
        this.mTitle = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.album_big_image_choose, (ViewGroup) null);
        this.aoR = (ImageView) inflate.findViewById(com.baidu.tieba.w.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.mViewPager = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.w.viewPager);
        this.aoM = this.aoO.Bd();
        this.mViewPager.setOnPageChangeListener(new d(this));
        this.aoS = this.mRoot.findViewById(com.baidu.tieba.w.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Bk();
        }
    }

    private void Bi() {
        if (this.aoJ == null && this.aoO != null) {
            this.aoJ = this.aoO.Bc();
        }
        if (this.aoJ != null && this.aoJ.Bq() != null) {
            int currentIndex = this.aoJ.getCurrentIndex();
            if (currentIndex >= 0) {
                this.mCurrentIndex = currentIndex;
                if (this.mCurrentIndex > this.aoJ.Bq().size() - 1) {
                    this.mCurrentIndex = this.aoJ.Bq().size() - 1;
                }
                this.aoJ.setCurrentIndex(-1);
                ef(this.mCurrentIndex + 1);
                this.aoQ = null;
                this.aoQ = new h(this.aoO, this.aoM);
                this.mViewPager.setAdapter(this.aoQ);
                if (this.mCurrentIndex == 0 && this.aoJ.Bq() != null) {
                    if (this.aoJ.isAdded(this.aoJ.Bq().get(this.mCurrentIndex))) {
                        a(this.aoR, true);
                    } else {
                        a(this.aoR, false);
                    }
                }
            }
            this.aoQ.setData(this.aoJ.Bq());
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aoQ != null) {
            this.aoQ.setData(null);
        }
    }

    public View Bj() {
        return this.aoP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aoO.getLayoutMode().ab(i == 1);
        this.aoO.getLayoutMode().h(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.aoO.getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkCoreApplication.m255getInst().getSkinType();
            if (z) {
                ax.i(imageView, com.baidu.tieba.v.btn_add_finish_s);
            } else {
                ax.i(imageView, com.baidu.tieba.v.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ef(int i) {
        if (this.aoJ != null && this.aoJ.Bq() != null) {
            String string = this.aoO.getPageContext().getContext().getString(com.baidu.tieba.z.album_big_image_title, Integer.valueOf(i), Integer.valueOf(this.aoJ.Bq().size()));
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.mTitle.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo eg;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aoQ != null && (eg = this.aoQ.eg(this.mCurrentIndex)) != null && eg.getFilePath() != null && eg.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aoR, z);
        }
    }

    private void Bk() {
        if (!isHidden()) {
            this.aoS.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Bi();
        }
    }
}
