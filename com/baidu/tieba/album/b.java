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
    private ViewPager Ct;
    private TextView JM;
    private int RK = -1;
    private p ahk;
    private com.baidu.tbadk.img.e ahn;
    private AlbumActivity ahq;
    private View ahr;
    private h ahs;
    private ImageView aht;
    private View ahu;
    private NavigationBar mNavigationBar;
    private View mRoot;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahq = (AlbumActivity) getActivity();
        this.ahk = this.ahq.xH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_view, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.navigation_bar);
        this.ahr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ahq);
        this.JM = this.mNavigationBar.setTitleText("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.album_big_image_choose, (ViewGroup) null);
        this.aht = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_choose);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.Ct = (ViewPager) this.mRoot.findViewById(com.baidu.tieba.v.viewPager);
        this.ahn = this.ahq.xI();
        this.Ct.setOnPageChangeListener(new d(this));
        this.ahu = this.mRoot.findViewById(com.baidu.tieba.v.album_no_data);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            xP();
        }
    }

    private void xN() {
        if (this.ahk == null && this.ahq != null) {
            this.ahk = this.ahq.xH();
        }
        if (this.ahk != null && this.ahk.xV() != null) {
            int currentIndex = this.ahk.getCurrentIndex();
            if (currentIndex >= 0) {
                this.RK = currentIndex;
                if (this.RK > this.ahk.xV().size() - 1) {
                    this.RK = this.ahk.xV().size() - 1;
                }
                this.ahk.dP(-1);
                dL(this.RK + 1);
                this.ahs = null;
                this.ahs = new h(this.ahq, this.ahn);
                this.Ct.setAdapter(this.ahs);
                if (this.RK == 0 && this.ahk.xV() != null) {
                    if (this.ahk.isAdded(this.ahk.xV().get(this.RK))) {
                        a(this.aht, true);
                    } else {
                        a(this.aht, false);
                    }
                }
            }
            this.ahs.setData(this.ahk.xV());
            this.Ct.setCurrentItem(this.RK, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.ahs != null) {
            this.ahs.setData(null);
        }
    }

    public View xO() {
        return this.ahr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ahq.getLayoutMode().L(i == 1);
        this.ahq.getLayoutMode().h(this.mRoot);
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
        if (this.ahk != null && this.ahk.xV() != null) {
            String string = this.ahq.getString(com.baidu.tieba.y.album_big_image_title, new Object[]{Integer.valueOf(i), Integer.valueOf(this.ahk.xV().size())});
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.JM.setText(string);
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo dM;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.ahs != null && (dM = this.ahs.dM(this.RK)) != null && dM.getFilePath() != null && dM.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aht, z);
        }
    }

    private void xP() {
        if (!isHidden()) {
            this.ahu.setVisibility(8);
            this.Ct.setVisibility(0);
            xN();
        }
    }
}
