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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends BaseFragment implements u {
    private p aoJ;
    private AlbumActivity aoO;
    private View aoP;
    private aa apO;
    private GridView apY;
    private ab apZ;
    private RelativeLayout apl;
    private e apn;
    private String aqa;
    private boolean aqb = true;
    private z aqc;
    private boolean aqd;
    private boolean aqe;
    private TextView mCancel;
    private List<ImageFileInfo> mList;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private TextView mTitle;
    private View mView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aoO = (AlbumActivity) getBaseFragmentActivity();
        this.aoJ = this.aoO.Bc();
        q.Br().a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(com.baidu.tieba.x.album_image_list_view, (ViewGroup) null);
        this.apl = (RelativeLayout) this.mView.findViewById(com.baidu.tieba.w.album_image_list_root);
        this.mNavigationBar = (NavigationBar) this.mView.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aoP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aoO);
        this.mTitle = this.mNavigationBar.setTitleText("");
        this.mCancel = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.aoO.getPageContext().getString(com.baidu.tieba.z.cancel), this.aoO);
        this.apY = (GridView) this.mView.findViewById(com.baidu.tieba.w.gv_image_list);
        this.apZ = new ab(this.aoO, this.aoJ);
        this.apY.setAdapter((ListAdapter) this.apZ);
        this.apY.setOnScrollListener(this.apZ);
        this.apO = new ai(this);
        this.aqc = new aj(this);
        this.apZ.a(this.apO);
        this.apZ.a(this.aqc);
        this.mNoDataView = NoDataViewFactory.a(this.aoO.getPageContext().getContext(), this.apl, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.t(com.baidu.tieba.z.album_list_no_data, com.baidu.tieba.z.album_list_no_data_1), null);
        return this.mView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aqe = false;
        if (isShow()) {
            Bk();
        }
    }

    private void Bi() {
        if (this.aoJ == null && this.aoO != null) {
            this.aoJ = this.aoO.Bc();
        }
        if (this.aoJ != null) {
            String Bp = this.aoJ.Bp();
            if (TextUtils.isEmpty(Bp)) {
                Bp = this.aoJ.getLastAlbumId();
                if (TextUtils.isEmpty(Bp)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.aqa) && this.aqa.equals(Bp) && this.aqb) {
                if (this.apZ != null) {
                    this.apZ.notifyDataSetChanged();
                    return;
                }
                return;
            }
            setData(null);
            eU(Bp);
            this.aqa = Bp;
        }
    }

    private void eU(String str) {
        if (this.apn == null) {
            this.apn = new e(this.aoO.getPageContext().getContext());
        }
        this.apn.a(str, new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<ImageFileInfo> list) {
        if (this.apZ != null) {
            this.aoJ.D(list);
            this.apZ.setData(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aoO.getLayoutMode().ab(i == 1);
        this.aoO.getLayoutMode().h(this.mView);
        this.mNavigationBar.onChangeSkinType(this.aoO.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    public View Bj() {
        return this.aoP;
    }

    public TextView Bx() {
        return this.mCancel;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.apn != null) {
            this.apn.Bm();
        }
        q.Br().b(this);
    }

    public void l(int i, boolean z) {
        if (this.apY != null) {
            int firstVisiblePosition = this.apY.getFirstVisiblePosition();
            int lastVisiblePosition = this.apY.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.apY.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.w.select_icon);
                    TbadkCoreApplication.m255getInst().getSkinType();
                    if (z) {
                        ax.i(imageView, com.baidu.tieba.v.btn_choose_photo_s);
                    } else {
                        ax.i(imageView, com.baidu.tieba.v.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.apZ != null) {
            l(this.apZ.g(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aqe = true;
    }

    @Override // com.baidu.tieba.album.u
    public void bk(boolean z) {
        this.aqd = z;
        this.aqb = false;
        Bk();
    }

    private void Bk() {
        if (!isHidden() && !this.aqe) {
            if (this.aqd) {
                this.apY.setVisibility(8);
                this.mNoDataView.setVisibility(0);
                return;
            }
            this.apY.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            Bi();
        }
    }
}
