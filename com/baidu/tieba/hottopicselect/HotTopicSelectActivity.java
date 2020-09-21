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
/* loaded from: classes20.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent fpm;
    private TextView irD;
    private HotTopicSelectModel jmB;
    private View jmD;
    private BdListView jmE;
    private ExpandableListView jmF;
    private e jmG;
    private b jmH;
    private ViewGroup jmI;
    private EditText jmJ;
    private ImageView jmK;
    private TextView jmL;
    private NoDataView mNoDataView;
    private final List<d> jmC = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jmK) {
                HotTopicSelectActivity.this.cEt();
            } else if (view == HotTopicSelectActivity.this.irD) {
                HotTopicSelectActivity.this.Kt("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jmH.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Kt(topicName);
                HotTopicSelectActivity.this.aT(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jmM = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jmF != null) {
                HotTopicSelectActivity.this.jmF.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jmN = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jmG != null && (child = HotTopicSelectActivity.this.jmG.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Kt(topicName);
                c group = HotTopicSelectActivity.this.jmG.getGroup(i);
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
        this.jmB = new HotTopicSelectModel(getPageContext(), this);
        this.jmB.X(getIntent());
        this.jmB.cED();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jmB.cEz();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.dEG.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvP() {
        ListView listView;
        View childAt;
        if (this.jmE.getVisibility() == 0) {
            listView = this.jmE;
        } else {
            listView = this.jmF;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvQ() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qV(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bvR() {
        return this.fpm;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bvV() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jmD.setVisibility(8);
        showLoadingView(this.jmI, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jmI = (ViewGroup) findViewById(R.id.frame_main_view);
        this.irD = (TextView) findViewById(R.id.btn_confirm);
        this.jmL = (TextView) findViewById(R.id.topic_text);
        this.jmK = (ImageView) findViewById(R.id.clear_right_img);
        this.jmD = findViewById(R.id.home_search_list);
        this.jmE = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jmI.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jmH = new b(getPageContext());
        this.jmE.setAdapter((ListAdapter) this.jmH);
        this.jmF = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jmG = new e(getPageContext());
        this.jmF.setAdapter(this.jmG);
        this.jmE.setOnItemClickListener(this.mOnItemClickListener);
        this.jmF.setOnGroupClickListener(this.jmM);
        this.jmF.setOnChildClickListener(this.jmN);
        this.irD.setOnClickListener(this.mOnClickListener);
        this.jmK.setOnClickListener(this.mOnClickListener);
        nf(false);
        cEv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dF("obj_name", str);
        aqVar.ai("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cnV() {
        String cnV = this.jmB != null ? this.jmB.cnV() : "";
        return cnV != null ? cnV : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEt() {
        this.jmB.Ky("");
        this.jmJ.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
        this.jmF.setVisibility(0);
        this.jmE.setVisibility(8);
        this.jmH.clearList();
        if (this.jmG != null && !y.isEmpty(this.jmG.getList())) {
            this.jmD.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jmB.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Kt("");
        super.onBackPressed();
    }

    private void cEv() {
        this.jmJ = (EditText) findViewById(R.id.search_root);
        this.jmJ.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jmJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jmJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cnV())) {
                        HotTopicSelectActivity.this.Kt(HotTopicSelectActivity.this.cnV());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jmJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cEu();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jmD.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jmB.Kx(obj);
                }
                HotTopicSelectActivity.this.nf(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cEw();
            }
        });
        this.jmJ.requestFocus();
    }

    public void nf(boolean z) {
        this.jmK.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEw() {
        if (this.jmJ != null && this.jmL != null) {
            if (TextUtils.isEmpty(this.jmJ.getText())) {
                ap.setViewTextColor(this.jmL, R.color.cp_cont_d, 1);
            } else {
                ap.setViewTextColor(this.jmL, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt(String str) {
        if (this.jmJ != null && this.jmJ.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jmJ);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fpm = new Intent();
            this.fpm.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Ku(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Kv(String str) {
        hideLoadingView(this.jmI);
        this.jmD.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oW(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oW(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cEx())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jmG.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jmD.setVisibility(0);
        this.jmF.setVisibility(0);
        this.jmE.setVisibility(8);
        hideLoadingView(this.jmI);
        this.jmG.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jmG.notifyDataSetChanged();
        int count = this.jmF.getCount();
        for (int i = 0; i < count; i++) {
            this.jmF.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Kw(String str) {
        this.jmD.setVisibility(0);
        this.jmF.setVisibility(8);
        this.jmE.setVisibility(0);
        hideLoadingView(this.jmI);
        String cnV = cnV();
        d Ku = Ku(cnV);
        this.jmC.clear();
        this.jmC.add(Ku);
        this.jmH.j(cnV, this.jmC);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jmD.setVisibility(0);
        this.jmF.setVisibility(8);
        this.jmE.setVisibility(0);
        hideLoadingView(this.jmI);
        this.jmC.clear();
        String cnV = cnV();
        this.jmC.add(Ku(cnV));
        if (cVar == null || cVar.getList() == null) {
            this.jmH.j(cnV, this.jmC);
            return;
        }
        this.jmC.addAll(cVar.getList());
        this.jmH.j(cnV, this.jmC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bll();
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
        if (this.jmH != null) {
            this.jmH.notifyDataSetChanged();
        }
        if (this.jmG != null) {
            this.jmG.notifyDataSetChanged();
        }
        if (this.jmJ != null) {
            this.jmJ.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        ap.setViewTextColor(this.irD, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jmJ, R.color.cp_cont_b, 2);
        ap.setImageResource(this.jmK, R.drawable.del_search_btn);
        cEw();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jmB.onDestroy();
        this.mNoDataView.bll();
        hideLoadingView(this.jmI);
        super.onDestroy();
    }
}
