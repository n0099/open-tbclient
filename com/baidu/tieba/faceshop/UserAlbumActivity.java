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
/* loaded from: classes9.dex */
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, PopupWindow.OnDismissListener, y.a, com.baidu.tieba.newfaceshop.facemake.f {
    private static int iVB = 10;
    private GridView dlY;
    private TextView iVC;
    private TextView iVD;
    private y iVE;
    private com.baidu.tieba.newfaceshop.facemake.g iVF;
    private com.baidu.tbadk.album.b iVG;
    private int iVJ;
    private com.baidu.tbadk.album.a iVK;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View rootView;
    private List<ImageFileInfo> mImageList = new ArrayList();
    private List<ImageFileInfo> iVH = new ArrayList();
    private LinkedHashMap<String, ImageFileInfo> iVI = new LinkedHashMap<>();
    private String eJp = com.baidu.tbadk.album.a.ALBUM_ID_ALL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.user_pick_album, (ViewGroup) null);
        setContentView(this.rootView);
        ao.setBackgroundResource(this.rootView, R.color.CAM_X0201);
        initView();
        initSetting();
        cCh();
    }

    private void initView() {
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.rootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds320)), NoDataViewFactory.d.Cv(getPageContext().getPageActivity().getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.dlY = (GridView) this.rootView.findViewById(R.id.grid_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
        this.iVC = this.mNavigationBar.mCenterText;
        this.iVC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_albumarrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                UserAlbumActivity.this.iVC.setCompoundDrawables(null, null, drawable, null);
                UserAlbumActivity.this.iVG.a(new com.baidu.tbadk.album.c() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.1.1
                    @Override // com.baidu.tbadk.album.c
                    public void onPreLoad() {
                    }

                    @Override // com.baidu.tbadk.album.c
                    public void bq(List<com.baidu.tbadk.album.a> list) {
                        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
                            if (UserAlbumActivity.this.iVK != null) {
                                list.add(0, UserAlbumActivity.this.iVK);
                            }
                            if (!UserAlbumActivity.this.iVE.isShowing()) {
                                UserAlbumActivity.this.iVE.c(list, UserAlbumActivity.this.eJp);
                                UserAlbumActivity.this.iVE.O(UserAlbumActivity.this.mNavigationBar);
                            }
                        }
                    }
                });
            }
        });
        this.iVC.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        ao.setViewTextColor(this.iVC, R.color.CAM_X0302);
        Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.iVC.setCompoundDrawables(null, null, drawable, null);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAlbumActivity.this.finish();
            }
        }).setPadding(com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), 0, 0, 0);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iVD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAlbumActivity.this.iVI = UserAlbumActivity.this.iVF.dkm();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : UserAlbumActivity.this.iVI.entrySet()) {
                    arrayList.add(entry.getValue());
                }
                Intent intent = new Intent();
                intent.putExtra("selected_album_list", arrayList);
                UserAlbumActivity.this.setResult(-1, intent);
                UserAlbumActivity.this.finish();
            }
        });
        this.iVD.setPadding(0, 0, com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds34), 0);
        ao.setViewTextColor(this.iVD, R.color.CAM_X0302);
    }

    private void initSetting() {
        this.iVG = new com.baidu.tbadk.album.b(getActivity());
        this.iVF = new com.baidu.tieba.newfaceshop.facemake.g(this, this.mImageList);
        this.iVF.Pl(getPageContext().getString(R.string.can_select_only_ten));
        this.iVF.b(this);
        this.dlY.setAdapter((ListAdapter) this.iVF);
        this.dlY.setOnScrollListener(this);
        this.iVE = new y(getPageContext().getPageActivity());
        this.iVE.setOnDismissListener(this);
        this.iVE.a(this);
    }

    private void cCh() {
        this.iVG.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.4
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                    UserAlbumActivity.this.dlY.setVisibility(0);
                    UserAlbumActivity.this.mNoDataView.setVisibility(8);
                    UserAlbumActivity.this.iVH.clear();
                    UserAlbumActivity.this.iVH.addAll(list2);
                    UserAlbumActivity.this.mImageList.addAll(list2);
                    UserAlbumActivity.this.iVK = new com.baidu.tbadk.album.a();
                    UserAlbumActivity.this.iVK.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
                    UserAlbumActivity.this.iVK.setCount(list2.size() + "");
                    UserAlbumActivity.this.iVK.setName(UserAlbumActivity.this.getPageContext().getString(R.string.album_all));
                    UserAlbumActivity.this.iVK.a(list2.get(0));
                    UserAlbumActivity.this.iVF.notifyDataSetChanged();
                    return;
                }
                UserAlbumActivity.this.dlY.setVisibility(8);
                UserAlbumActivity.this.mNoDataView.setVisibility(0);
            }
        });
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.iVF.dm(true);
        } else if (this.iVF.isScroll()) {
            this.iVF.dm(false);
            cCi();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private void cCi() {
        if (this.iVF != null && this.iVF.dkD() != null) {
            int childCount = this.dlY.getChildCount();
            int firstVisiblePosition = this.dlY.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dlY.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iVF.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iVF.dkD().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.5
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) UserAlbumActivity.this.dlY.findViewWithTag(str);
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
        if (this.iVF != null) {
            this.iVI = this.iVF.dkm();
        }
        Drawable drawable = ao.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.iVC.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tieba.faceshop.y.a
    public void a(int i, com.baidu.tbadk.album.a aVar) {
        if (aVar != null) {
            this.eJp = aVar.getAlbumId();
            this.mNavigationBar.setCenterTextTitle(aVar.getName());
            this.iVG.a(aVar.getAlbumId(), new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.6
                @Override // com.baidu.tbadk.album.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.album.d
                public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                    UserAlbumActivity.this.mImageList.clear();
                    if (!com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                        UserAlbumActivity.this.mImageList.addAll(list2);
                    }
                    UserAlbumActivity.this.iVF.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void cCj() {
        this.iVJ++;
        cCm();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void cCk() {
        if (this.iVJ > 0) {
            this.iVJ--;
        }
        cCm();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public boolean cCl() {
        return this.iVJ < iVB;
    }

    private void cCm() {
        String string = getPageContext().getString(R.string.add);
        if (this.iVJ > 0) {
            this.iVD.setText("(" + this.iVJ + ") " + string);
        } else {
            this.iVD.setText(string);
        }
    }
}
