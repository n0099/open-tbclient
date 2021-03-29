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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.l0.s;
import d.b.i0.x1.g.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, d.b.i0.x1.g.f, PopupWindow.OnDismissListener, s.d {
    public static int MAX_SELECT_NUM = 10;
    public g mAdapter;
    public TextView mAddAlbumTv;
    public d.b.h0.e.a mAddData;
    public int mChoosedNum;
    public GridView mGridView;
    public d.b.h0.e.b mLoadModel;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public TextView mSelectAlbumTv;
    public s mUserCollectAlbumListPopupWindow;
    public View rootView;
    public List<ImageFileInfo> mImageList = new ArrayList();
    public List<ImageFileInfo> mAllImageList = new ArrayList();
    public LinkedHashMap<String, ImageFileInfo> mChooseList = new LinkedHashMap<>();
    public String mAlbumId = d.b.h0.e.a.f50120f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.tieba.faceshop.UserAlbumActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0186a implements d.b.h0.e.c {
            public C0186a() {
            }

            @Override // d.b.h0.e.c
            public void a(List<d.b.h0.e.a> list) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                if (UserAlbumActivity.this.mAddData != null) {
                    list.add(0, UserAlbumActivity.this.mAddData);
                }
                if (UserAlbumActivity.this.mUserCollectAlbumListPopupWindow.isShowing()) {
                    return;
                }
                UserAlbumActivity.this.mUserCollectAlbumListPopupWindow.i(list, UserAlbumActivity.this.mAlbumId);
                UserAlbumActivity.this.mUserCollectAlbumListPopupWindow.l(UserAlbumActivity.this.mNavigationBar);
            }

            @Override // d.b.h0.e.c
            public void onPreLoad() {
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_up);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            UserAlbumActivity.this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
            UserAlbumActivity.this.mLoadModel.g(new C0186a());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserAlbumActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserAlbumActivity userAlbumActivity = UserAlbumActivity.this;
            userAlbumActivity.mChooseList = userAlbumActivity.mAdapter.f();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : UserAlbumActivity.this.mChooseList.entrySet()) {
                arrayList.add(entry.getValue());
            }
            Intent intent = new Intent();
            intent.putExtra("selected_album_list", arrayList);
            UserAlbumActivity.this.setResult(-1, intent);
            UserAlbumActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.h0.e.d {
        public d() {
        }

        @Override // d.b.h0.e.d
        public void a(List<d.b.h0.e.a> list, List<ImageFileInfo> list2, String str) {
            if (!ListUtils.isEmpty(list2)) {
                UserAlbumActivity.this.mGridView.setVisibility(0);
                UserAlbumActivity.this.mNoDataView.setVisibility(8);
                UserAlbumActivity.this.mAllImageList.clear();
                UserAlbumActivity.this.mAllImageList.addAll(list2);
                UserAlbumActivity.this.mImageList.addAll(list2);
                UserAlbumActivity.this.mAddData = new d.b.h0.e.a();
                UserAlbumActivity.this.mAddData.h(d.b.h0.e.a.f50120f);
                d.b.h0.e.a aVar = UserAlbumActivity.this.mAddData;
                aVar.i(list2.size() + "");
                UserAlbumActivity.this.mAddData.l(UserAlbumActivity.this.getPageContext().getString(R.string.album_all));
                UserAlbumActivity.this.mAddData.k(list2.get(0));
                UserAlbumActivity.this.mAdapter.notifyDataSetChanged();
                return;
            }
            UserAlbumActivity.this.mGridView.setVisibility(8);
            UserAlbumActivity.this.mNoDataView.setVisibility(0);
        }

        @Override // d.b.h0.e.d
        public void onPreLoad() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.h0.a0.b {
        public e() {
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) UserAlbumActivity.this.mGridView.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.h0.e.d {
        public f() {
        }

        @Override // d.b.h0.e.d
        public void a(List<d.b.h0.e.a> list, List<ImageFileInfo> list2, String str) {
            UserAlbumActivity.this.mImageList.clear();
            if (!ListUtils.isEmpty(list2)) {
                UserAlbumActivity.this.mImageList.addAll(list2);
            }
            UserAlbumActivity.this.mAdapter.notifyDataSetChanged();
        }

        @Override // d.b.h0.e.d
        public void onPreLoad() {
        }
    }

    private void initSetting() {
        this.mLoadModel = new d.b.h0.e.b(getActivity());
        g gVar = new g(this, this.mImageList);
        this.mAdapter = gVar;
        gVar.k(getPageContext().getString(R.string.can_select_only_ten));
        this.mAdapter.j(this);
        this.mGridView.setAdapter((ListAdapter) this.mAdapter);
        this.mGridView.setOnScrollListener(this);
        s sVar = new s(getPageContext().getPageActivity());
        this.mUserCollectAlbumListPopupWindow = sVar;
        sVar.setOnDismissListener(this);
        this.mUserCollectAlbumListPopupWindow.j(this);
    }

    private void initView() {
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getPageContext().getPageActivity(), R.dimen.ds320)), NoDataViewFactory.e.c(getPageContext().getPageActivity().getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.mGridView = (GridView) this.rootView.findViewById(R.id.grid_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
        TextView textView = this.mNavigationBar.mCenterText;
        this.mSelectAlbumTv = textView;
        textView.setOnClickListener(new a());
        this.mSelectAlbumTv.setCompoundDrawablePadding(l.g(getPageContext().getPageActivity(), R.dimen.ds8));
        SkinManager.setViewTextColor(this.mSelectAlbumTv, R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b()).setPadding(l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0, 0, 0);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add), new c());
        this.mAddAlbumTv = addTextButton;
        addTextButton.setPadding(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds34), 0);
        SkinManager.setViewTextColor(this.mAddAlbumTv, R.color.CAM_X0302);
    }

    private void loadAlbumData() {
        this.mLoadModel.i(d.b.h0.e.a.f50120f, new d());
    }

    private void refreshImages() {
        g gVar = this.mAdapter;
        if (gVar == null || gVar.g() == null) {
            return;
        }
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                ImageFileInfo item = this.mAdapter.getItem(firstVisiblePosition + i);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.mAdapter.g().e(item, new e(), false, false);
                }
            }
        }
    }

    private void updateChoosedNum() {
        String string = getPageContext().getString(R.string.add);
        if (this.mChoosedNum > 0) {
            TextView textView = this.mAddAlbumTv;
            textView.setText("(" + this.mChoosedNum + ") " + string);
            return;
        }
        this.mAddAlbumTv.setText(string);
    }

    @Override // d.b.i0.x1.g.f
    public boolean canChooseMore() {
        return this.mChoosedNum < MAX_SELECT_NUM;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().k(i == 1);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @Override // d.b.i0.x1.g.f
    public void onChoose() {
        this.mChoosedNum++;
        updateChoosedNum();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.user_pick_album, (ViewGroup) null);
        this.rootView = inflate;
        setContentView(inflate);
        SkinManager.setBackgroundResource(this.rootView, R.color.CAM_X0201);
        initView();
        initSetting();
        loadAlbumData();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        g gVar = this.mAdapter;
        if (gVar != null) {
            this.mChooseList = gVar.f();
        }
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // d.b.i0.l0.s.d
    public void onItemClick(int i, d.b.h0.e.a aVar) {
        if (aVar != null) {
            this.mAlbumId = aVar.b();
            this.mNavigationBar.setCenterTextTitle(aVar.g());
            this.mLoadModel.i(aVar.b(), new f());
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.mAdapter.l(true);
        } else if (this.mAdapter.i()) {
            this.mAdapter.l(false);
            refreshImages();
        }
    }

    @Override // d.b.i0.x1.g.f
    public void onUnChoose() {
        int i = this.mChoosedNum;
        if (i > 0) {
            this.mChoosedNum = i - 1;
        }
        updateChoosedNum();
    }
}
