package com.baidu.tieba.album;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends BaseFragment implements u {
    private TextView JN;
    private List<ImageFileInfo> WB;
    private View ahA;
    private RelativeLayout ahW;
    private com.baidu.tbadk.core.view.o ahX;
    private e ahZ;
    private p aht;
    private AlbumActivity ahz;
    private aa aiB;
    private TextView aiL;
    private GridView aiM;
    private ab aiN;
    private String aiO;
    private boolean aiP = true;
    private z aiQ;
    private boolean aiR;
    private boolean aiS;
    private NavigationBar mNavigationBar;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahz = (AlbumActivity) getActivity();
        this.aht = this.ahz.xJ();
        q.xY().a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.w.album_image_list_view, (ViewGroup) null);
        this.ahW = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.v.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.ahA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ahz);
        this.JN = this.mNavigationBar.setTitleText("");
        this.aiL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ahz.getString(com.baidu.tieba.y.cancel), this.ahz);
        this.aiM = (GridView) this.mView.findViewById(com.baidu.tieba.v.gv_image_list);
        this.aiN = new ab(this.ahz, this.aht);
        this.aiM.setAdapter((ListAdapter) this.aiN);
        this.aiM.setOnScrollListener(this.aiN);
        this.aiB = new ai(this);
        this.aiQ = new aj(this);
        this.aiN.a(this.aiB);
        this.aiN.a(this.aiQ);
        this.ahX = NoDataViewFactory.a(this.ahz, this.ahW, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.album_list_no_data, com.baidu.tieba.y.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aiS = false;
        if (isShow()) {
            xR();
        }
    }

    private void xP() {
        if (this.aht == null && this.ahz != null) {
            this.aht = this.ahz.xJ();
        }
        if (this.aht != null) {
            String xW = this.aht.xW();
            if (TextUtils.isEmpty(xW)) {
                xW = this.aht.getLastAlbumId();
                if (TextUtils.isEmpty(xW)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.aiO) && this.aiO.equals(xW) && this.aiP) {
                if (this.aiN != null) {
                    this.aiN.notifyDataSetChanged();
                    return;
                }
                return;
            }
            setData(null);
            ep(xW);
            this.aiO = xW;
        }
    }

    private void ep(String str) {
        if (this.ahZ == null) {
            this.ahZ = new e(this.ahz);
        }
        this.ahZ.a(str, new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (this.aiN != null) {
            this.aht.y(list);
            this.aiN.setData(list);
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

    public View xQ() {
        return this.ahA;
    }

    public TextView yg() {
        return this.aiL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ahZ != null) {
            this.ahZ.xT();
        }
        q.xY().b(this);
    }

    public void l(int i, boolean z) {
        if (this.aiM != null) {
            int firstVisiblePosition = this.aiM.getFirstVisiblePosition();
            int lastVisiblePosition = this.aiM.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aiM.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.v.select_icon);
                    TbadkApplication.m251getInst().getSkinType();
                    if (z) {
                        aw.h(imageView, com.baidu.tieba.u.btn_choose_photo_s);
                    } else {
                        aw.h(imageView, com.baidu.tieba.u.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aiN != null) {
            l(this.aiN.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aiS = true;
    }

    @Override // com.baidu.tieba.album.u
    public void bl(boolean z) {
        this.aiR = z;
        this.aiP = false;
        xR();
    }

    private void xR() {
        if (!isHidden() && !this.aiS) {
            if (this.aiR) {
                this.aiM.setVisibility(8);
                this.ahX.setVisibility(0);
                return;
            }
            this.aiM.setVisibility(0);
            this.ahX.setVisibility(8);
            xP();
        }
    }
}
