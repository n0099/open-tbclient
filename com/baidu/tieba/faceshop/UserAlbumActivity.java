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
import com.baidu.tbadk.core.util.ap;
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
    private static int iYy = 10;
    private GridView dkY;
    private TextView iYA;
    private y iYB;
    private com.baidu.tieba.newfaceshop.facemake.g iYC;
    private com.baidu.tbadk.album.b iYD;
    private int iYG;
    private com.baidu.tbadk.album.a iYH;
    private TextView iYz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View rootView;
    private List<ImageFileInfo> mImageList = new ArrayList();
    private List<ImageFileInfo> iYE = new ArrayList();
    private LinkedHashMap<String, ImageFileInfo> iYF = new LinkedHashMap<>();
    private String eIm = com.baidu.tbadk.album.a.ALBUM_ID_ALL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.user_pick_album, (ViewGroup) null);
        setContentView(this.rootView);
        ap.setBackgroundResource(this.rootView, R.color.CAM_X0201);
        initView();
        initSetting();
        czN();
    }

    private void initView() {
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.rootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds320)), NoDataViewFactory.d.BI(getPageContext().getPageActivity().getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.dkY = (GridView) this.rootView.findViewById(R.id.grid_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
        this.iYz = this.mNavigationBar.mCenterText;
        this.iYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Drawable drawable = ap.getDrawable(R.drawable.icon_emotion_albumarrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                UserAlbumActivity.this.iYz.setCompoundDrawables(null, null, drawable, null);
                UserAlbumActivity.this.iYD.a(new com.baidu.tbadk.album.c() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.1.1
                    @Override // com.baidu.tbadk.album.c
                    public void onPreLoad() {
                    }

                    @Override // com.baidu.tbadk.album.c
                    public void bl(List<com.baidu.tbadk.album.a> list) {
                        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
                            if (UserAlbumActivity.this.iYH != null) {
                                list.add(0, UserAlbumActivity.this.iYH);
                            }
                            if (!UserAlbumActivity.this.iYB.isShowing()) {
                                UserAlbumActivity.this.iYB.setData(list, UserAlbumActivity.this.eIm);
                                UserAlbumActivity.this.iYB.O(UserAlbumActivity.this.mNavigationBar);
                            }
                        }
                    }
                });
            }
        });
        this.iYz.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        ap.setViewTextColor(this.iYz, R.color.CAM_X0302);
        Drawable drawable = ap.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.iYz.setCompoundDrawables(null, null, drawable, null);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAlbumActivity.this.finish();
            }
        }).setPadding(com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), 0, 0, 0);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iYA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAlbumActivity.this.iYF = UserAlbumActivity.this.iYC.diL();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : UserAlbumActivity.this.iYF.entrySet()) {
                    arrayList.add(entry.getValue());
                }
                Intent intent = new Intent();
                intent.putExtra("selected_album_list", arrayList);
                UserAlbumActivity.this.setResult(-1, intent);
                UserAlbumActivity.this.finish();
            }
        });
        this.iYA.setPadding(0, 0, com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds34), 0);
        ap.setViewTextColor(this.iYA, R.color.CAM_X0302);
    }

    private void initSetting() {
        this.iYD = new com.baidu.tbadk.album.b(getActivity());
        this.iYC = new com.baidu.tieba.newfaceshop.facemake.g(this, this.mImageList);
        this.iYC.Pa(getPageContext().getString(R.string.can_select_only_ten));
        this.iYC.b(this);
        this.dkY.setAdapter((ListAdapter) this.iYC);
        this.dkY.setOnScrollListener(this);
        this.iYB = new y(getPageContext().getPageActivity());
        this.iYB.setOnDismissListener(this);
        this.iYB.a(this);
    }

    private void czN() {
        this.iYD.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.4
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!com.baidu.tbadk.core.util.y.isEmpty(list2)) {
                    UserAlbumActivity.this.dkY.setVisibility(0);
                    UserAlbumActivity.this.mNoDataView.setVisibility(8);
                    UserAlbumActivity.this.iYE.clear();
                    UserAlbumActivity.this.iYE.addAll(list2);
                    UserAlbumActivity.this.mImageList.addAll(list2);
                    UserAlbumActivity.this.iYH = new com.baidu.tbadk.album.a();
                    UserAlbumActivity.this.iYH.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
                    UserAlbumActivity.this.iYH.setCount(list2.size() + "");
                    UserAlbumActivity.this.iYH.setName(UserAlbumActivity.this.getPageContext().getString(R.string.album_all));
                    UserAlbumActivity.this.iYH.a(list2.get(0));
                    UserAlbumActivity.this.iYC.notifyDataSetChanged();
                    return;
                }
                UserAlbumActivity.this.dkY.setVisibility(8);
                UserAlbumActivity.this.mNoDataView.setVisibility(0);
            }
        });
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.iYC.dq(true);
        } else if (this.iYC.isScroll()) {
            this.iYC.dq(false);
            czO();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private void czO() {
        if (this.iYC != null && this.iYC.djc() != null) {
            int childCount = this.dkY.getChildCount();
            int firstVisiblePosition = this.dkY.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dkY.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iYC.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iYC.djc().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.5
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) UserAlbumActivity.this.dkY.findViewWithTag(str);
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
        if (this.iYC != null) {
            this.iYF = this.iYC.diL();
        }
        Drawable drawable = ap.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.iYz.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // com.baidu.tieba.faceshop.y.a
    public void a(int i, com.baidu.tbadk.album.a aVar) {
        if (aVar != null) {
            this.eIm = aVar.getAlbumId();
            this.mNavigationBar.setCenterTextTitle(aVar.getName());
            this.iYD.a(aVar.getAlbumId(), new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.faceshop.UserAlbumActivity.6
                @Override // com.baidu.tbadk.album.d
                public void onPreLoad() {
                }

                @Override // com.baidu.tbadk.album.d
                public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                    UserAlbumActivity.this.mImageList.clear();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(list2)) {
                        UserAlbumActivity.this.mImageList.addAll(list2);
                    }
                    UserAlbumActivity.this.iYC.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void czP() {
        this.iYG++;
        czS();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public void czQ() {
        if (this.iYG > 0) {
            this.iYG--;
        }
        czS();
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.f
    public boolean czR() {
        return this.iYG < iYy;
    }

    private void czS() {
        String string = getPageContext().getString(R.string.add);
        if (this.iYG > 0) {
            this.iYA.setText("(" + this.iYG + ") " + string);
        } else {
            this.iYA.setText(string);
        }
    }
}
