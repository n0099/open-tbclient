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
    private TextView hWo;
    private HotTopicSelectModel iOR;
    private View iOT;
    private BdListView iOU;
    private ExpandableListView iOV;
    private e iOW;
    private b iOX;
    private ViewGroup iOY;
    private EditText iOZ;
    private ImageView iPa;
    private TextView iPb;
    private Intent iPc;
    private NoDataView mNoDataView;
    private final List<d> iOS = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.iPa) {
                HotTopicSelectActivity.this.cpT();
            } else if (view == HotTopicSelectActivity.this.hWo) {
                HotTopicSelectActivity.this.GY("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) x.getItem(HotTopicSelectActivity.this.iOX.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.GY(topicName);
                HotTopicSelectActivity.this.aQ(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener iPd = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.iOV != null) {
                HotTopicSelectActivity.this.iOV.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener iPe = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.iOW != null && (child = HotTopicSelectActivity.this.iOW.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.GY(topicName);
                c group = HotTopicSelectActivity.this.iOW.getGroup(i);
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
        this.iOR = new HotTopicSelectModel(getPageContext(), this);
        this.iOR.W(getIntent());
        this.iOR.cqd();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.iOR.cpZ();
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
        if (this.iOU.getVisibility() == 0) {
            listView = this.iOU;
        } else {
            listView = this.iOV;
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
        return this.iPc;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bmd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iOT.setVisibility(8);
        showLoadingView(this.iOY, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.iOY = (ViewGroup) findViewById(R.id.frame_main_view);
        this.hWo = (TextView) findViewById(R.id.btn_confirm);
        this.iPb = (TextView) findViewById(R.id.topic_text);
        this.iPa = (ImageView) findViewById(R.id.clear_right_img);
        this.iOT = findViewById(R.id.home_search_list);
        this.iOU = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.iOY.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.iOX = new b(getPageContext());
        this.iOU.setAdapter((ListAdapter) this.iOX);
        this.iOV = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.iOW = new e(getPageContext());
        this.iOV.setAdapter(this.iOW);
        this.iOU.setOnItemClickListener(this.mOnItemClickListener);
        this.iOV.setOnGroupClickListener(this.iPd);
        this.iOV.setOnChildClickListener(this.iPe);
        this.hWo.setOnClickListener(this.mOnClickListener);
        this.iPa.setOnClickListener(this.mOnClickListener);
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
        String cal = this.iOR != null ? this.iOR.cal() : "";
        return cal != null ? cal : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpT() {
        this.iOR.Hd("");
        this.iOZ.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpU() {
        this.iOV.setVisibility(0);
        this.iOU.setVisibility(8);
        this.iOX.clearList();
        if (this.iOW != null && !x.isEmpty(this.iOW.getList())) {
            this.iOT.setVisibility(0);
            return;
        }
        showLoadingView();
        this.iOR.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        GY("");
        super.onBackPressed();
    }

    private void cpV() {
        this.iOZ = (EditText) findViewById(R.id.search_root);
        this.iOZ.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.iOZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.iOZ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
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
        this.iOZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.iOT.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.iOR.Hc(obj);
                }
                HotTopicSelectActivity.this.mu(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cpW();
            }
        });
        this.iOZ.requestFocus();
    }

    public void mu(boolean z) {
        this.iPa.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpW() {
        if (this.iOZ != null && this.iPb != null) {
            if (TextUtils.isEmpty(this.iOZ.getText())) {
                ao.setViewTextColor(this.iPb, R.color.cp_cont_d, 1);
            } else {
                ao.setViewTextColor(this.iPb, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY(String str) {
        if (this.iOZ != null && this.iOZ.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iOZ);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.iPc = new Intent();
            this.iPc.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
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
        hideLoadingView(this.iOY);
        this.iOT.setVisibility(8);
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
            this.iOW.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.iOT.setVisibility(0);
        this.iOV.setVisibility(0);
        this.iOU.setVisibility(8);
        hideLoadingView(this.iOY);
        this.iOW.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.iOW.notifyDataSetChanged();
        int count = this.iOV.getCount();
        for (int i = 0; i < count; i++) {
            this.iOV.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Hb(String str) {
        this.iOT.setVisibility(0);
        this.iOV.setVisibility(8);
        this.iOU.setVisibility(0);
        hideLoadingView(this.iOY);
        String cal = cal();
        d GZ = GZ(cal);
        this.iOS.clear();
        this.iOS.add(GZ);
        this.iOX.k(cal, this.iOS);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.iOT.setVisibility(0);
        this.iOV.setVisibility(8);
        this.iOU.setVisibility(0);
        hideLoadingView(this.iOY);
        this.iOS.clear();
        String cal = cal();
        this.iOS.add(GZ(cal));
        if (cVar == null || cVar.getList() == null) {
            this.iOX.k(cal, this.iOS);
            return;
        }
        this.iOS.addAll(cVar.getList());
        this.iOX.k(cal, this.iOS);
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
        if (this.iOX != null) {
            this.iOX.notifyDataSetChanged();
        }
        if (this.iOW != null) {
            this.iOW.notifyDataSetChanged();
        }
        if (this.iOZ != null) {
            this.iOZ.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        }
        ao.setViewTextColor(this.hWo, R.color.cp_link_tip_a, 1);
        ao.setViewTextColor(this.iOZ, R.color.cp_cont_b, 2);
        ao.setImageResource(this.iPa, R.drawable.del_search_btn);
        cpW();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.iOR.onDestroy();
        this.mNoDataView.bbU();
        hideLoadingView(this.iOY);
        super.onDestroy();
    }
}
