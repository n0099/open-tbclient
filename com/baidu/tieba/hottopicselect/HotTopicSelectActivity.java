package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements d.a.m0.t0.a, HotTopicSelectModel.c {
    public TextView mCancelBtn;
    public ImageView mClearView;
    public HotTopicSelectModel mHotModel;
    public EditText mInputEdt;
    public View mListCustomView;
    public ExpandableListView mLvNoSearch;
    public ViewGroup mMainLayout;
    public NoDataView mNoDataView;
    public d.a.n0.e1.e mNoSearchAdapter;
    public Intent mResultIntent;
    public d.a.n0.e1.b mSuggestAdatper;
    public BdListView mSuggestView;
    public TextView mTopicText;
    public final List<d.a.n0.e1.d> mSearchList = new ArrayList();
    public final View.OnClickListener mOnClickListener = new a();
    public final AdapterView.OnItemClickListener mOnItemClickListener = new b();
    public final ExpandableListView.OnGroupClickListener mOnGroupClickListener = new c();
    public final ExpandableListView.OnChildClickListener mOnChildClickListener = new d();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.mClearView) {
                HotTopicSelectActivity.this.clearAllTextStatus();
            } else if (view == HotTopicSelectActivity.this.mCancelBtn) {
                HotTopicSelectActivity.this.createIntent("");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.n0.e1.d dVar = (d.a.n0.e1.d) ListUtils.getItem(HotTopicSelectActivity.this.mSuggestAdatper.d(), i2);
            if (dVar != null) {
                String b2 = dVar.b();
                HotTopicSelectActivity.this.createIntent(b2);
                HotTopicSelectActivity.this.addClickStats(b2, 3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ExpandableListView.OnGroupClickListener {
        public c() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j) {
            if (HotTopicSelectActivity.this.mLvNoSearch != null) {
                HotTopicSelectActivity.this.mLvNoSearch.expandGroup(i2);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ExpandableListView.OnChildClickListener {
        public d() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j) {
            d.a.n0.e1.d child;
            if (HotTopicSelectActivity.this.mNoSearchAdapter == null || (child = HotTopicSelectActivity.this.mNoSearchAdapter.getChild(i2, i3)) == null) {
                return false;
            }
            String b2 = child.b();
            HotTopicSelectActivity.this.createIntent(b2);
            d.a.n0.e1.c group = HotTopicSelectActivity.this.mNoSearchAdapter.getGroup(i2);
            if (group != null) {
                HotTopicSelectActivity.this.addClickStats(b2, group.c() == 0 ? 1 : 2);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            l.x(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                l.K(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                if (TextUtils.isEmpty(HotTopicSelectActivity.this.getSearchKey())) {
                    return true;
                }
                HotTopicSelectActivity hotTopicSelectActivity = HotTopicSelectActivity.this;
                hotTopicSelectActivity.createIntent(hotTopicSelectActivity.getSearchKey());
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (obj == null || obj.trim().length() <= 0) {
                HotTopicSelectActivity.this.afterDealText();
            } else {
                HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                HotTopicSelectActivity.this.mListCustomView.setVisibility(8);
                HotTopicSelectActivity.this.showLoadingView();
                HotTopicSelectActivity.this.mHotModel.G(obj);
            }
            HotTopicSelectActivity.this.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
            HotTopicSelectActivity.this.setTopicTextViewColor();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addClickStats(String str, int i2) {
        StatisticItem statisticItem = new StatisticItem("c11665");
        statisticItem.param("obj_name", str);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterDealText() {
        this.mLvNoSearch.setVisibility(0);
        this.mSuggestView.setVisibility(8);
        this.mSuggestAdatper.b();
        d.a.n0.e1.e eVar = this.mNoSearchAdapter;
        if (eVar != null && !ListUtils.isEmpty(eVar.f())) {
            this.mListCustomView.setVisibility(0);
            return;
        }
        showLoadingView();
        this.mHotModel.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllTextStatus() {
        this.mHotModel.H("");
        this.mInputEdt.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIntent(String str) {
        EditText editText = this.mInputEdt;
        if (editText != null && editText.hasFocus()) {
            l.x(getPageContext().getPageActivity(), this.mInputEdt);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.mResultIntent = new Intent();
            this.mResultIntent.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d.a.n0.e1.d createSearchData(String str) {
        d.a.n0.e1.d dVar = new d.a.n0.e1.d();
        dVar.d(str);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSearchKey() {
        HotTopicSelectModel hotTopicSelectModel = this.mHotModel;
        String y = hotTopicSelectModel != null ? hotTopicSelectModel.y() : "";
        return y != null ? y : "";
    }

    private void initInputEdit() {
        EditText editText = (EditText) findViewById(R.id.search_root);
        this.mInputEdt = editText;
        editText.setCompoundDrawablePadding(l.g(getPageContext().getPageActivity(), R.dimen.ds8));
        this.mInputEdt.setOnFocusChangeListener(new e());
        this.mInputEdt.setOnEditorActionListener(new f());
        this.mInputEdt.addTextChangedListener(new g());
        this.mInputEdt.requestFocus();
    }

    private void initUI() {
        this.mMainLayout = (ViewGroup) findViewById(R.id.frame_main_view);
        this.mCancelBtn = (TextView) findViewById(R.id.btn_confirm);
        this.mTopicText = (TextView) findViewById(R.id.topic_text);
        this.mClearView = (ImageView) findViewById(R.id.clear_right_img);
        this.mListCustomView = findViewById(R.id.home_search_list);
        this.mSuggestView = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mMainLayout.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        d.a.n0.e1.b bVar = new d.a.n0.e1.b(getPageContext());
        this.mSuggestAdatper = bVar;
        this.mSuggestView.setAdapter((ListAdapter) bVar);
        this.mLvNoSearch = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        d.a.n0.e1.e eVar = new d.a.n0.e1.e(getPageContext());
        this.mNoSearchAdapter = eVar;
        this.mLvNoSearch.setAdapter(eVar);
        this.mSuggestView.setOnItemClickListener(this.mOnItemClickListener);
        this.mLvNoSearch.setOnGroupClickListener(this.mOnGroupClickListener);
        this.mLvNoSearch.setOnChildClickListener(this.mOnChildClickListener);
        this.mCancelBtn.setOnClickListener(this.mOnClickListener);
        this.mClearView.setOnClickListener(this.mOnClickListener);
        setDelButtonVisible(false);
        initInputEdit();
    }

    private void parseAndDealData(d.a.n0.e1.c cVar, boolean z) {
        if (cVar == null || ListUtils.isEmpty(cVar.b())) {
            return;
        }
        if (TextUtils.isEmpty(cVar.a())) {
            cVar.e(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
        }
        this.mNoSearchAdapter.g(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopicTextViewColor() {
        EditText editText = this.mInputEdt;
        if (editText == null || this.mTopicText == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText())) {
            SkinManager.setViewTextColor(this.mTopicText, R.color.CAM_X0109, 1);
        } else {
            SkinManager.setViewTextColor(this.mTopicText, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.mListCustomView.setVisibility(8);
        showLoadingView(this.mMainLayout, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    @Override // d.a.m0.t0.a
    public Intent getResultIntent() {
        return this.mResultIntent;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.a.m0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.mCancel.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewTop() {
        ListView listView;
        View childAt;
        if (this.mSuggestView.getVisibility() == 0) {
            listView = this.mSuggestView;
        } else {
            listView = this.mLvNoSearch;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        createIntent("");
        super.onBackPressed();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mSkinType = i2;
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        d.a.n0.e1.b bVar = this.mSuggestAdatper;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        d.a.n0.e1.e eVar = this.mNoSearchAdapter;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
        EditText editText = this.mInputEdt;
        if (editText != null) {
            editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
        SkinManager.setViewTextColor(this.mCancelBtn, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.mInputEdt, R.color.CAM_X0105, 2);
        SkinManager.setImageResource(this.mClearView, R.drawable.del_search_btn);
        setTopicTextViewColor();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
        this.mHotModel = hotTopicSelectModel;
        hotTopicSelectModel.B(getIntent());
        this.mHotModel.E();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.mHotModel.F();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mHotModel.onDestroy();
        this.mNoDataView.e();
        hideLoadingView(this.mMainLayout);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchFailed(String str) {
        hideLoadingView(this.mMainLayout);
        this.mListCustomView.setVisibility(8);
        if (!j.z()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchSuccess(d.a.n0.e1.c cVar, d.a.n0.e1.c cVar2) {
        this.mListCustomView.setVisibility(0);
        this.mLvNoSearch.setVisibility(0);
        this.mSuggestView.setVisibility(8);
        hideLoadingView(this.mMainLayout);
        this.mNoSearchAdapter.c();
        parseAndDealData(cVar, true);
        parseAndDealData(cVar2, false);
        this.mNoSearchAdapter.notifyDataSetChanged();
        int count = this.mLvNoSearch.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            this.mLvNoSearch.expandGroup(i2);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchFailed(String str) {
        this.mListCustomView.setVisibility(0);
        this.mLvNoSearch.setVisibility(8);
        this.mSuggestView.setVisibility(0);
        hideLoadingView(this.mMainLayout);
        String searchKey = getSearchKey();
        d.a.n0.e1.d createSearchData = createSearchData(searchKey);
        this.mSearchList.clear();
        this.mSearchList.add(createSearchData);
        this.mSuggestAdatper.e(searchKey, this.mSearchList);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchSuccess(d.a.n0.e1.c cVar) {
        this.mListCustomView.setVisibility(0);
        this.mLvNoSearch.setVisibility(8);
        this.mSuggestView.setVisibility(0);
        hideLoadingView(this.mMainLayout);
        this.mSearchList.clear();
        String searchKey = getSearchKey();
        this.mSearchList.add(createSearchData(searchKey));
        if (cVar != null && cVar.b() != null) {
            this.mSearchList.addAll(cVar.b());
            this.mSuggestAdatper.e(searchKey, this.mSearchList);
            return;
        }
        this.mSuggestAdatper.e(searchKey, this.mSearchList);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    @Override // d.a.m0.t0.a
    public void onViewChangeSkinType(int i2) {
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
    }

    public void setDelButtonVisible(boolean z) {
        this.mClearView.setVisibility(z ? 0 : 8);
    }
}
