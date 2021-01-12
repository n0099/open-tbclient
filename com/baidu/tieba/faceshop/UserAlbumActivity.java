package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, PopupWindow.OnDismissListener, y.a, com.baidu.tieba.newfaceshop.facemake.f {
    private static int iQU = 10;
    private GridView dhj;
    private TextView iQV;
    private TextView iQW;
    private y iQX;
    private com.baidu.tieba.newfaceshop.facemake.g iQY;
    private com.baidu.tbadk.album.b iQZ;
    private int iRc;
    private com.baidu.tbadk.album.a iRd;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View rootView;
    private List<ImageFileInfo> mImageList = new ArrayList();
    private List<ImageFileInfo> iRa = new ArrayList();
    private LinkedHashMap<String, ImageFileInfo> iRb = new LinkedHashMap<>();
    private String eEE = com.baidu.tbadk.album.a.ALBUM_ID_ALL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.user_pick_album, (ViewGroup) null);
        setContentView(this.rootView);
        ao.setBackgroundResource(this.rootView, R.color.CAM_X0201);
        initView();
        initSetting();
        cyp();
    }

    private void initView() {
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.rootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds320)), NoDataViewFactory.d.Bk(getPageContext().getPageActivity().getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.dhj = (GridView) this.rootView.findViewById(R.id.grid_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
        this.iQV = this.mNavigationBar.mCenterText;
        this.iQV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_albumarrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                UserAlbumActivity.this.iQV.setCompoundDrawables(null, null, drawable, null);
                UserAlbumActivity.this.iQZ.a(new com.baidu.tbadk.album.c() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.1.1
                    @Override // com.baidu.tbadk.album.c
                    public void onPreLoad() {
                    }

                    @Override // com.baidu.tbadk.album.c
                    public void bq(List<com.baidu.tbadk.album.a> list) {
                        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
                            if (UserAlbumActivity.this.iRd != null) {
                                list.add(0, UserAlbumActivity.this.iRd);
                            }
                            if (!UserAlbumActivity.this.iQX.isShowing()) {
                                UserAlbumActivity.this.iQX.c(list, UserAlbumActivity.this.eEE);
                                UserAlbumActivity.this.iQX.O(UserAlbumActivity.this.mNavigationBar);
                            }
                        }
                    }
                });
            }
        });
        this.iQV.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        ao.setViewTextColor(this.iQV, R.color.CAM_X0302);
        Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.iQV.setCompoundDrawables(null, null, drawable, null);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAlbumActivity.this.finish();
            }
        }).setPadding(com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), 0, 0, 0);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iQW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAlbumActivity.this.iRb = UserAlbumActivity.this.iQY.dgu();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : UserAlbumActivity.this.iRb.entrySet()) {
                    arrayList.add(entry.getValue());
                }
                Intent intent = new Intent();
                intent.putExtra("selected_album_list", arrayList);
                UserAlbumActivity.this.setResult(-1, intent);
                UserAlbumActivity.this.finish();
            }
        });
        this.iQW.setPadding(0, 0, com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds34), 0);
        ao.setViewTextColor(this.iQW, R.color.CAM_X0302);
    }

    private void initSetting() {
        this.iQZ = new com.baidu.tbadk.album.b(getActivity());
        this.iQY = new com.baidu.tieba.newfaceshop.facemake.g(this, this.mImageList);
        this.iQY.Od(getPageContext().getString(R.string.can_select_only_ten));
        this.iQY.b(this);
        this.dhj.setAdapter((ListAdapter) this.iQY);
        this.dhj.setOnScrollListener(this);
        this.iQX = new y(getPageContext().getPageActivity());
        this.iQX.setOnDismissListener(this);
        this.iQX.a(this);
    }

    private void cyp() {
        this.iQZ.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.4
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                    UserAlbumActivity.this.dhj.setVisibility(0);
                    UserAlbumActivity.this.mNoDataView.setVisibility(8);
                    UserAlbumActivity.this.iRa.clear();
                    UserAlbumActivity.this.iRa.addAll(list2);
                    UserAlbumActivity.this.mImageList.addAll(list2);
                    UserAlbumActivity.this.iRd = new com.baidu.tbadk.album.a();
                    UserAlbumActivity.this.iRd.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
                    UserAlbumActivity.this.iRd.setCount(list2.size() + "");
                    UserAlbumActivity.this.iRd.setName(UserAlbumActivity.this.getPageContext().getString(R.string.album_all));
                    UserAlbumActivity.this.iRd.a(list2.get(0));
                    UserAlbumActivity.this.iQY.notifyDataSetChanged();
                    return;
                }
                UserAlbumActivity.this.dhj.setVisibility(8);
                UserAlbumActivity.this.mNoDataView.setVisibility(0);
            }
        });
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.iQY.di(true);
        } else if (this.iQY.isScroll()) {
            this.iQY.di(false);
            cyq();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private void cyq() {
        if (this.iQY != null && this.iQY.dgL() != null) {
            int childCount = this.dhj.getChildCount();
            int firstVisiblePosition = this.dhj.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dhj.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iQY.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iQY.dgL().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.5
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) UserAlbumActivity.this.dhj.findViewWithTag(str);
                                if (tbImageView2 != null && aVar != null) {
                                    tbImageView2.invalidate();
                                }
                            }
                        }, false, false);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.iQY != null) {
            this.iRb = this.iQY.dgu();
        }
        Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.iQV.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tieba.faceshop.y.a
    public void a(int i, com.baidu.tbadk.album.a aVar) {
        if (aVar != null) {
            this.eEE = aVar.getAlbumId();
            this.mNavigationBar.setCenterTextTitle(aVar.getName());
            this.iQZ.a(aVar.getAlbumId(), new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.6
                @Override // com.baidu.tbadk.album.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.album.d
                public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                    UserAlbumActivity.this.mImageList.clear();
                    if (!com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                        UserAlbumActivity.this.mImageList.addAll(list2);
                    }
                    UserAlbumActivity.this.iQY.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void cyr() {
        this.iRc++;
        cyu();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void cys() {
        if (this.iRc > 0) {
            this.iRc--;
        }
        cyu();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public boolean cyt() {
        return this.iRc < iQU;
    }

    private void cyu() {
        String string = getPageContext().getString(R.string.add);
        if (this.iRc > 0) {
            this.iQW.setText("(" + this.iRc + ") " + string);
        } else {
            this.iQW.setText(string);
        }
    }
}
