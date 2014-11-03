package com.baidu.tieba.album;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b extends BaseFragment {
    private ViewPager Cu;
    private TextView JN;
    private int RO = -1;
    private View ahA;
    private h ahB;
    private ImageView ahC;
    private View ahD;
    private p aht;
    private com.baidu.tbadk.img.e ahw;
    private AlbumActivity ahz;
    private NavigationBar mNavigationBar;
    private View mRoot;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahz = (AlbumActivity) getActivity();
        this.aht = this.ahz.xJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.navigation_bar);
        this.ahA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ahz);
        this.JN = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_choose, (ViewGroup) null);
        this.ahC = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.Cu = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.v.viewPager);
        this.ahw = this.ahz.xK();
        this.Cu.setOnPageChangeListener(new d(this));
        this.ahD = this.mRoot.findViewById(com.baidu.tieba.v.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            xR();
        }
    }

    private void xP() {
        if (this.aht == null && this.ahz != null) {
            this.aht = this.ahz.xJ();
        }
        if (this.aht != null && this.aht.xX() != null) {
            int currentIndex = this.aht.getCurrentIndex();
            if (currentIndex >= 0) {
                this.RO = currentIndex;
                if (this.RO > this.aht.xX().size() - 1) {
                    this.RO = this.aht.xX().size() - 1;
                }
                this.aht.dP(-1);
                dL(this.RO + 1);
                this.ahB = null;
                this.ahB = new h(this.ahz, this.ahw);
                this.Cu.setAdapter(this.ahB);
                if (this.RO == 0 && this.aht.xX() != null) {
                    if (this.aht.isAdded(this.aht.xX().get(this.RO))) {
                        a(this.ahC, true);
                    } else {
                        a(this.ahC, false);
                    }
                }
            }
            this.ahB.setData(this.aht.xX());
            this.Cu.setCurrentItem(this.RO, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.ahB != null) {
            this.ahB.setData(null);
        }
    }

    public View xQ() {
        return this.ahA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ahz.getLayoutMode().L(i == 1);
        this.ahz.getLayoutMode().h(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null) {
            TbadkApplication.m251getInst().getSkinType();
            if (z) {
                aw.h(imageView, com.baidu.tieba.u.btn_add_finish_s);
            } else {
                aw.h(imageView, com.baidu.tieba.u.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dL(int i) {
        if (this.aht != null && this.aht.xX() != null) {
            String string = this.ahz.getString(com.baidu.tieba.y.album_big_image_title, new Object[]{Integer.valueOf(i), Integer.valueOf(this.aht.xX().size())});
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.JN.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo dM;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.ahB != null && (dM = this.ahB.dM(this.RO)) != null && dM.getFilePath() != null && dM.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.ahC, z);
        }
    }

    private void xR() {
        if (!isHidden()) {
            this.ahD.setVisibility(8);
            this.Cu.setVisibility(0);
            xP();
        }
    }
}
