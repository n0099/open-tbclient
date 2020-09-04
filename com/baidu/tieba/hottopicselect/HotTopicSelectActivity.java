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
/* loaded from: classes15.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private TextView ikB;
    private HotTopicSelectModel jdU;
    private View jdW;
    private BdListView jdX;
    private ExpandableListView jdY;
    private e jdZ;
    private b jea;
    private ViewGroup jeb;
    private EditText jec;
    private ImageView jed;
    private TextView jee;
    private Intent jef;
    private NoDataView mNoDataView;
    private final List<d> jdV = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jed) {
                HotTopicSelectActivity.this.cAM();
            } else if (view == HotTopicSelectActivity.this.ikB) {
                HotTopicSelectActivity.this.JR("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jea.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.JR(topicName);
                HotTopicSelectActivity.this.aT(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jeg = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jdY != null) {
                HotTopicSelectActivity.this.jdY.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jeh = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jdZ != null && (child = HotTopicSelectActivity.this.jdZ.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.JR(topicName);
                c group = HotTopicSelectActivity.this.jdZ.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aT(topicName, group.getType() == 0 ? 1 : 2);
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
        this.jdU = new HotTopicSelectModel(getPageContext(), this);
        this.jdU.Y(getIntent());
        this.jdU.cAW();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jdU.cAS();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.dCF.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buL() {
        ListView listView;
        View childAt;
        if (this.jdX.getVisibility() == 0) {
            listView = this.jdX;
        } else {
            listView = this.jdY;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buN() {
        return this.jef;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void buR() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jdW.setVisibility(8);
        showLoadingView(this.jeb, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jeb = (ViewGroup) findViewById(R.id.frame_main_view);
        this.ikB = (TextView) findViewById(R.id.btn_confirm);
        this.jee = (TextView) findViewById(R.id.topic_text);
        this.jed = (ImageView) findViewById(R.id.clear_right_img);
        this.jdW = findViewById(R.id.home_search_list);
        this.jdX = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jeb.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jea = new b(getPageContext());
        this.jdX.setAdapter((ListAdapter) this.jea);
        this.jdY = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jdZ = new e(getPageContext());
        this.jdY.setAdapter(this.jdZ);
        this.jdX.setOnItemClickListener(this.mOnItemClickListener);
        this.jdY.setOnGroupClickListener(this.jeg);
        this.jdY.setOnChildClickListener(this.jeh);
        this.ikB.setOnClickListener(this.mOnClickListener);
        this.jed.setOnClickListener(this.mOnClickListener);
        mZ(false);
        cAO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dD("obj_name", str);
        aqVar.ai("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ckI() {
        String ckI = this.jdU != null ? this.jdU.ckI() : "";
        return ckI != null ? ckI : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAM() {
        this.jdU.JW("");
        this.jec.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAN() {
        this.jdY.setVisibility(0);
        this.jdX.setVisibility(8);
        this.jea.clearList();
        if (this.jdZ != null && !y.isEmpty(this.jdZ.getList())) {
            this.jdW.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jdU.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        JR("");
        super.onBackPressed();
    }

    private void cAO() {
        this.jec = (EditText) findViewById(R.id.search_root);
        this.jec.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jec.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jec.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.ckI())) {
                        HotTopicSelectActivity.this.JR(HotTopicSelectActivity.this.ckI());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jec.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cAN();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jdW.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jdU.JV(obj);
                }
                HotTopicSelectActivity.this.mZ(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cAP();
            }
        });
        this.jec.requestFocus();
    }

    public void mZ(boolean z) {
        this.jed.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAP() {
        if (this.jec != null && this.jee != null) {
            if (TextUtils.isEmpty(this.jec.getText())) {
                ap.setViewTextColor(this.jee, R.color.cp_cont_d, 1);
            } else {
                ap.setViewTextColor(this.jee, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR(String str) {
        if (this.jec != null && this.jec.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jec);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.jef = new Intent();
            this.jef.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d JS(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void JT(String str) {
        hideLoadingView(this.jeb);
        this.jdW.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cAQ())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jdZ.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jdW.setVisibility(0);
        this.jdY.setVisibility(0);
        this.jdX.setVisibility(8);
        hideLoadingView(this.jeb);
        this.jdZ.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jdZ.notifyDataSetChanged();
        int count = this.jdY.getCount();
        for (int i = 0; i < count; i++) {
            this.jdY.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void JU(String str) {
        this.jdW.setVisibility(0);
        this.jdY.setVisibility(8);
        this.jdX.setVisibility(0);
        hideLoadingView(this.jeb);
        String ckI = ckI();
        d JS = JS(ckI);
        this.jdV.clear();
        this.jdV.add(JS);
        this.jea.j(ckI, this.jdV);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jdW.setVisibility(0);
        this.jdY.setVisibility(8);
        this.jdX.setVisibility(0);
        hideLoadingView(this.jeb);
        this.jdV.clear();
        String ckI = ckI();
        this.jdV.add(JS(ckI));
        if (cVar == null || cVar.getList() == null) {
            this.jea.j(ckI, this.jdV);
            return;
        }
        this.jdV.addAll(cVar.getList());
        this.jea.j(ckI, this.jdV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bkq();
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
        if (this.jea != null) {
            this.jea.notifyDataSetChanged();
        }
        if (this.jdZ != null) {
            this.jdZ.notifyDataSetChanged();
        }
        if (this.jec != null) {
            this.jec.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        ap.setViewTextColor(this.ikB, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jec, R.color.cp_cont_b, 2);
        ap.setImageResource(this.jed, R.drawable.del_search_btn);
        cAP();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jdU.onDestroy();
        this.mNoDataView.bkq();
        hideLoadingView(this.jeb);
        super.onDestroy();
    }
}
