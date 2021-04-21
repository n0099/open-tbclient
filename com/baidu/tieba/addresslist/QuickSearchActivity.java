package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    public TextView mCancelButton;
    public TextView mEmptyResultView;
    public EditText mInputEditText;
    public g mListAdapter;
    public NavigationBar mNavigationBar;
    public View mParentView;
    public QuickSearchModel mSearchModel;
    public ListView mSearchResultList;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                l.w(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                l.w(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (QuickSearchActivity.this.mInputEditText.hasFocus()) {
                l.w(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
            }
            QuickSearchActivity.this.closeActivity();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            l.w(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QuickSearchActivity.this.mInputEditText.setText("");
            QuickSearchActivity.this.mEmptyResultView.setVisibility(8);
            QuickSearchActivity.this.mSearchResultList.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.mCancelButton.setVisibility(8);
            } else {
                QuickSearchActivity.this.mCancelButton.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() != 0) {
                QuickSearchActivity.this.refreshResultList(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.mEmptyResultView.setVisibility(8);
            QuickSearchActivity.this.mSearchResultList.setVisibility(8);
        }

        public /* synthetic */ f(QuickSearchActivity quickSearchActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f14254a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14255b;

        public h() {
        }

        public /* synthetic */ h(QuickSearchActivity quickSearchActivity, a aVar) {
            this();
        }
    }

    private void initNavigatorBar() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        EditText editText = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.mInputEditText = editText;
        editText.addTextChangedListener(new f(this, null));
        this.mInputEditText.setOnFocusChangeListener(new d());
        this.mInputEditText.requestFocus();
        this.mCancelButton = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.c(getPageContext().getPageActivity(), this.mCancelButton, 10, 10, 10, 10);
        this.mCancelButton.setOnClickListener(new e());
    }

    private void initViews() {
        this.mParentView = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        initNavigatorBar();
        this.mSearchResultList = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.mSearchResultList.addHeaderView(textView);
        this.mSearchResultList.setOnTouchListener(new a());
        g gVar = new g(this, null);
        this.mListAdapter = gVar;
        this.mSearchResultList.setAdapter((ListAdapter) gVar);
        this.mSearchResultList.setOnItemClickListener(this);
        this.mEmptyResultView = (TextView) findViewById(R.id.quick_search_empty_result);
        this.mParentView.setOnTouchListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshResultList(String str) {
        List<d.b.i0.s.f.a> s = this.mSearchModel.s(str);
        if (s.size() > 0) {
            showSearchResultList(true);
            this.mListAdapter.b(s);
            this.mListAdapter.notifyDataSetChanged();
            this.mSearchResultList.setSelection(0);
            return;
        }
        showSearchResultList(false);
    }

    private void showSearchResultList(boolean z) {
        this.mSearchResultList.setVisibility(z ? 0 : 8);
        this.mEmptyResultView.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundResource(this.mParentView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mListAdapter.notifyDataSetChanged();
        SkinManager.setViewTextColor(this.mEmptyResultView, R.color.CAM_X0109, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        QuickSearchModel quickSearchModel = new QuickSearchModel(this);
        this.mSearchModel = quickSearchModel;
        quickSearchModel.setUniqueId(getUniqueId());
        initViews();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.w(getPageContext().getPageActivity(), this.mInputEditText);
        this.mSearchModel = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.mSearchResultList.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        d.b.i0.s.f.a item = this.mListAdapter.getItem(i);
        if (item == null || item.e() <= 0) {
            return;
        }
        if (item.i() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.e(), item.f(), item.h(), 0, 4)));
            return;
        }
        sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.e()), item.f())));
    }

    /* loaded from: classes4.dex */
    public class g extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<d.b.i0.s.f.a> f14252e;

        public g() {
            this.f14252e = new ArrayList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d.b.i0.s.f.a getItem(int i) {
            if (this.f14252e == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.f14252e.get(i);
        }

        public void b(List<d.b.i0.s.f.a> list) {
            this.f14252e = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<d.b.i0.s.f.a> list = this.f14252e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            h hVar;
            d.b.i0.r.c layoutMode = QuickSearchActivity.this.getLayoutMode();
            TbadkCoreApplication.getInst().getSkinType();
            d.b.i0.s.f.a item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(R.layout.quick_search_item, (ViewGroup) null);
                hVar = new h(QuickSearchActivity.this, null);
                hVar.f14254a = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                hVar.f14255b = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(hVar);
            } else {
                hVar = (h) view.getTag();
            }
            layoutMode.j(view);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            if (item.f() != null) {
                hVar.f14255b.setText(item.f());
            }
            hVar.f14254a.W(item.h(), 12, false);
            return view;
        }

        public /* synthetic */ g(QuickSearchActivity quickSearchActivity, a aVar) {
            this();
        }
    }
}
