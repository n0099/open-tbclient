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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent fJV;
    private TextView iSS;
    private HotTopicSelectModel jNX;
    private View jNZ;
    private BdListView jOa;
    private ExpandableListView jOb;
    private e jOc;
    private b jOd;
    private ViewGroup jOe;
    private EditText jOf;
    private ImageView jOg;
    private TextView jOh;
    private NoDataView mNoDataView;
    private final List<d> jNY = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jOg) {
                HotTopicSelectActivity.this.cLj();
            } else if (view == HotTopicSelectActivity.this.iSS) {
                HotTopicSelectActivity.this.LG("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jOd.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.LG(topicName);
                HotTopicSelectActivity.this.aV(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jOi = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jOb != null) {
                HotTopicSelectActivity.this.jOb.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jOj = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jOc != null && (child = HotTopicSelectActivity.this.jOc.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.LG(topicName);
                c group = HotTopicSelectActivity.this.jOc.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aV(topicName, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jNX = new HotTopicSelectModel(getPageContext(), this);
        this.jNX.V(getIntent());
        this.jNX.cLt();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jNX.cLp();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bKf.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAs() {
        ListView listView;
        View childAt;
        if (this.jOa.getVisibility() == 0) {
            listView = this.jOa;
        } else {
            listView = this.jOb;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAt() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rE(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bAu() {
        return this.fJV;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bAy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jNZ.setVisibility(8);
        showLoadingView(this.jOe, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jOe = (ViewGroup) findViewById(R.id.frame_main_view);
        this.iSS = (TextView) findViewById(R.id.btn_confirm);
        this.jOh = (TextView) findViewById(R.id.topic_text);
        this.jOg = (ImageView) findViewById(R.id.clear_right_img);
        this.jNZ = findViewById(R.id.home_search_list);
        this.jOa = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jOe.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jOd = new b(getPageContext());
        this.jOa.setAdapter((ListAdapter) this.jOd);
        this.jOb = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jOc = new e(getPageContext());
        this.jOb.setAdapter(this.jOc);
        this.jOa.setOnItemClickListener(this.mOnItemClickListener);
        this.jOb.setOnGroupClickListener(this.jOi);
        this.jOb.setOnChildClickListener(this.jOj);
        this.iSS.setOnClickListener(this.mOnClickListener);
        this.jOg.setOnClickListener(this.mOnClickListener);
        oc(false);
        cLl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dR("obj_name", str);
        aqVar.aj("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cuA() {
        String cuA = this.jNX != null ? this.jNX.cuA() : "";
        return cuA != null ? cuA : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLj() {
        this.jNX.LL("");
        this.jOf.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLk() {
        this.jOb.setVisibility(0);
        this.jOa.setVisibility(8);
        this.jOd.clearList();
        if (this.jOc != null && !y.isEmpty(this.jOc.getList())) {
            this.jNZ.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jNX.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        LG("");
        super.onBackPressed();
    }

    private void cLl() {
        this.jOf = (EditText) findViewById(R.id.search_root);
        this.jOf.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jOf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jOf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cuA())) {
                        HotTopicSelectActivity.this.LG(HotTopicSelectActivity.this.cuA());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jOf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (obj == null || obj.trim().length() <= 0) {
                    HotTopicSelectActivity.this.cLk();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jNZ.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jNX.LK(obj);
                }
                HotTopicSelectActivity.this.oc(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cLm();
            }
        });
        this.jOf.requestFocus();
    }

    public void oc(boolean z) {
        this.jOg.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLm() {
        if (this.jOf != null && this.jOh != null) {
            if (TextUtils.isEmpty(this.jOf.getText())) {
                ap.setViewTextColor(this.jOh, R.color.cp_cont_d, 1);
            } else {
                ap.setViewTextColor(this.jOh, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LG(String str) {
        if (this.jOf != null && this.jOf.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jOf);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fJV = new Intent();
            this.fJV.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d LH(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void LI(String str) {
        hideLoadingView(this.jOe);
        this.jNZ.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cLn())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jOc.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jNZ.setVisibility(0);
        this.jOb.setVisibility(0);
        this.jOa.setVisibility(8);
        hideLoadingView(this.jOe);
        this.jOc.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jOc.notifyDataSetChanged();
        int count = this.jOb.getCount();
        for (int i = 0; i < count; i++) {
            this.jOb.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void LJ(String str) {
        this.jNZ.setVisibility(0);
        this.jOb.setVisibility(8);
        this.jOa.setVisibility(0);
        hideLoadingView(this.jOe);
        String cuA = cuA();
        d LH = LH(cuA);
        this.jNY.clear();
        this.jNY.add(LH);
        this.jOd.j(cuA, this.jNY);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jNZ.setVisibility(0);
        this.jOb.setVisibility(8);
        this.jOa.setVisibility(0);
        hideLoadingView(this.jOe);
        this.jNY.clear();
        String cuA = cuA();
        this.jNY.add(LH(cuA));
        if (cVar == null || cVar.getList() == null) {
            this.jOd.j(cuA, this.jNY);
            return;
        }
        this.jNY.addAll(cVar.getList());
        this.jOd.j(cuA, this.jNY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bpO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jOd != null) {
            this.jOd.notifyDataSetChanged();
        }
        if (this.jOc != null) {
            this.jOc.notifyDataSetChanged();
        }
        if (this.jOf != null) {
            this.jOf.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        ap.setViewTextColor(this.iSS, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jOf, R.color.cp_cont_b, 2);
        ap.setImageResource(this.jOg, R.drawable.del_search_btn);
        cLm();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jNX.onDestroy();
        this.mNoDataView.bpO();
        hideLoadingView(this.jOe);
        super.onDestroy();
    }
}
