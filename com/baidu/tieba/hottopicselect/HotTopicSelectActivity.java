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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private TextView hWm;
    private HotTopicSelectModel iOP;
    private View iOR;
    private BdListView iOS;
    private ExpandableListView iOT;
    private e iOU;
    private b iOV;
    private ViewGroup iOW;
    private EditText iOX;
    private ImageView iOY;
    private TextView iOZ;
    private Intent iPa;
    private NoDataView mNoDataView;
    private final List<d> iOQ = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.iOY) {
                HotTopicSelectActivity.this.cpT();
            } else if (view == HotTopicSelectActivity.this.hWm) {
                HotTopicSelectActivity.this.GY("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) x.getItem(HotTopicSelectActivity.this.iOV.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.GY(topicName);
                HotTopicSelectActivity.this.aQ(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener iPb = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.iOT != null) {
                HotTopicSelectActivity.this.iOT.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener iPc = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.iOU != null && (child = HotTopicSelectActivity.this.iOU.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.GY(topicName);
                c group = HotTopicSelectActivity.this.iOU.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aQ(topicName, group.getType() == 0 ? 1 : 2);
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
        this.iOP = new HotTopicSelectModel(getPageContext(), this);
        this.iOP.W(getIntent());
        this.iOP.cqd();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.iOP.cpZ();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.dsB.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blX() {
        ListView listView;
        View childAt;
        if (this.iOS.getVisibility() == 0) {
            listView = this.iOS;
        } else {
            listView = this.iOT;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blY() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ot(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent blZ() {
        return this.iPa;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bmd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iOR.setVisibility(8);
        showLoadingView(this.iOW, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.iOW = (ViewGroup) findViewById(R.id.frame_main_view);
        this.hWm = (TextView) findViewById(R.id.btn_confirm);
        this.iOZ = (TextView) findViewById(R.id.topic_text);
        this.iOY = (ImageView) findViewById(R.id.clear_right_img);
        this.iOR = findViewById(R.id.home_search_list);
        this.iOS = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.iOW.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.iOV = new b(getPageContext());
        this.iOS.setAdapter((ListAdapter) this.iOV);
        this.iOT = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.iOU = new e(getPageContext());
        this.iOT.setAdapter(this.iOU);
        this.iOS.setOnItemClickListener(this.mOnItemClickListener);
        this.iOT.setOnGroupClickListener(this.iPb);
        this.iOT.setOnChildClickListener(this.iPc);
        this.hWm.setOnClickListener(this.mOnClickListener);
        this.iOY.setOnClickListener(this.mOnClickListener);
        mu(false);
        cpV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str, int i) {
        ap apVar = new ap("c11665");
        apVar.dn("obj_name", str);
        apVar.ah("obj_locate", i);
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cal() {
        String cal = this.iOP != null ? this.iOP.cal() : "";
        return cal != null ? cal : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpT() {
        this.iOP.Hd("");
        this.iOX.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpU() {
        this.iOT.setVisibility(0);
        this.iOS.setVisibility(8);
        this.iOV.clearList();
        if (this.iOU != null && !x.isEmpty(this.iOU.getList())) {
            this.iOR.setVisibility(0);
            return;
        }
        showLoadingView();
        this.iOP.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        GY("");
        super.onBackPressed();
    }

    private void cpV() {
        this.iOX = (EditText) findViewById(R.id.search_root);
        this.iOX.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.iOX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.iOX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cal())) {
                        HotTopicSelectActivity.this.GY(HotTopicSelectActivity.this.cal());
                    }
                    return true;
                }
                return false;
            }
        });
        this.iOX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cpU();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.iOR.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.iOP.Hc(obj);
                }
                HotTopicSelectActivity.this.mu(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cpW();
            }
        });
        this.iOX.requestFocus();
    }

    public void mu(boolean z) {
        this.iOY.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpW() {
        if (this.iOX != null && this.iOZ != null) {
            if (TextUtils.isEmpty(this.iOX.getText())) {
                ao.setViewTextColor(this.iOZ, R.color.cp_cont_d, 1);
            } else {
                ao.setViewTextColor(this.iOZ, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY(String str) {
        if (this.iOX != null && this.iOX.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iOX);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.iPa = new Intent();
            this.iPa.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d GZ(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Ha(String str) {
        hideLoadingView(this.iOW);
        this.iOR.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !x.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cpX())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.iOU.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.iOR.setVisibility(0);
        this.iOT.setVisibility(0);
        this.iOS.setVisibility(8);
        hideLoadingView(this.iOW);
        this.iOU.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.iOU.notifyDataSetChanged();
        int count = this.iOT.getCount();
        for (int i = 0; i < count; i++) {
            this.iOT.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Hb(String str) {
        this.iOR.setVisibility(0);
        this.iOT.setVisibility(8);
        this.iOS.setVisibility(0);
        hideLoadingView(this.iOW);
        String cal = cal();
        d GZ = GZ(cal);
        this.iOQ.clear();
        this.iOQ.add(GZ);
        this.iOV.k(cal, this.iOQ);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.iOR.setVisibility(0);
        this.iOT.setVisibility(8);
        this.iOS.setVisibility(0);
        hideLoadingView(this.iOW);
        this.iOQ.clear();
        String cal = cal();
        this.iOQ.add(GZ(cal));
        if (cVar == null || cVar.getList() == null) {
            this.iOV.k(cal, this.iOQ);
            return;
        }
        this.iOQ.addAll(cVar.getList());
        this.iOV.k(cal, this.iOQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bbU();
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
        if (this.iOV != null) {
            this.iOV.notifyDataSetChanged();
        }
        if (this.iOU != null) {
            this.iOU.notifyDataSetChanged();
        }
        if (this.iOX != null) {
            this.iOX.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        }
        ao.setViewTextColor(this.hWm, R.color.cp_link_tip_a, 1);
        ao.setViewTextColor(this.iOX, R.color.cp_cont_b, 2);
        ao.setImageResource(this.iOY, R.drawable.del_search_btn);
        cpW();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.iOP.onDestroy();
        this.mNoDataView.bbU();
        hideLoadingView(this.iOW);
        super.onDestroy();
    }
}
