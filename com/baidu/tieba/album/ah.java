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
    private TextView JM;
    private List<ImageFileInfo> Wx;
    private RelativeLayout ahN;
    private com.baidu.tbadk.core.view.o ahO;
    private e ahQ;
    private p ahk;
    private AlbumActivity ahq;
    private View ahr;
    private TextView aiC;
    private GridView aiD;
    private ab aiE;
    private String aiF;
    private boolean aiG = true;
    private z aiH;
    private boolean aiI;
    private boolean aiJ;
    private aa ais;
    private NavigationBar mNavigationBar;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahq = (AlbumActivity) getActivity();
        this.ahk = this.ahq.xH();
        q.xW().a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.w.album_image_list_view, (ViewGroup) null);
        this.ahN = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.v.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.ahr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ahq);
        this.JM = this.mNavigationBar.setTitleText("");
        this.aiC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ahq.getString(com.baidu.tieba.y.cancel), this.ahq);
        this.aiD = (GridView) this.mView.findViewById(com.baidu.tieba.v.gv_image_list);
        this.aiE = new ab(this.ahq, this.ahk);
        this.aiD.setAdapter((ListAdapter) this.aiE);
        this.aiD.setOnScrollListener(this.aiE);
        this.ais = new ai(this);
        this.aiH = new aj(this);
        this.aiE.a(this.ais);
        this.aiE.a(this.aiH);
        this.ahO = NoDataViewFactory.a(this.ahq, this.ahN, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.album_list_no_data, com.baidu.tieba.y.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aiJ = false;
        if (isShow()) {
            xP();
        }
    }

    private void xN() {
        if (this.ahk == null && this.ahq != null) {
            this.ahk = this.ahq.xH();
        }
        if (this.ahk != null) {
            String xU = this.ahk.xU();
            if (TextUtils.isEmpty(xU)) {
                xU = this.ahk.getLastAlbumId();
                if (TextUtils.isEmpty(xU)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.aiF) && this.aiF.equals(xU) && this.aiG) {
                if (this.aiE != null) {
                    this.aiE.notifyDataSetChanged();
                    return;
                }
                return;
            }
            setData(null);
            ep(xU);
            this.aiF = xU;
        }
    }

    private void ep(String str) {
        if (this.ahQ == null) {
            this.ahQ = new e(this.ahq);
        }
        this.ahQ.a(str, new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (this.aiE != null) {
            this.ahk.y(list);
            this.aiE.setData(list);
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

    public View xO() {
        return this.ahr;
    }

    public TextView ye() {
        return this.aiC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ahQ != null) {
            this.ahQ.xR();
        }
        q.xW().b(this);
    }

    public void l(int i, boolean z) {
        if (this.aiD != null) {
            int firstVisiblePosition = this.aiD.getFirstVisiblePosition();
            int lastVisiblePosition = this.aiD.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aiD.getChildAt(i - firstVisiblePosition);
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
        if (imageFileInfo != null && this.aiE != null) {
            l(this.aiE.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aiJ = true;
    }

    @Override // com.baidu.tieba.album.u
    public void bl(boolean z) {
        this.aiI = z;
        this.aiG = false;
        xP();
    }

    private void xP() {
        if (!isHidden() && !this.aiJ) {
            if (this.aiI) {
                this.aiD.setVisibility(8);
                this.ahO.setVisibility(0);
                return;
            }
            this.aiD.setVisibility(0);
            this.ahO.setVisibility(8);
            xN();
        }
    }
}
