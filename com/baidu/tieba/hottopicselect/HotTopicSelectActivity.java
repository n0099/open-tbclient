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
    private Intent fBA;
    private TextView iGw;
    private View jBA;
    private BdListView jBB;
    private ExpandableListView jBC;
    private e jBD;
    private b jBE;
    private ViewGroup jBF;
    private EditText jBG;
    private ImageView jBH;
    private TextView jBI;
    private HotTopicSelectModel jBy;
    private NoDataView mNoDataView;
    private final List<d> jBz = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jBH) {
                HotTopicSelectActivity.this.cIc();
            } else if (view == HotTopicSelectActivity.this.iGw) {
                HotTopicSelectActivity.this.Li("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jBE.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Li(topicName);
                HotTopicSelectActivity.this.aU(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jBJ = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jBC != null) {
                HotTopicSelectActivity.this.jBC.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jBK = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jBD != null && (child = HotTopicSelectActivity.this.jBD.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Li(topicName);
                c group = HotTopicSelectActivity.this.jBD.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aU(topicName, group.getType() == 0 ? 1 : 2);
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
        this.jBy = new HotTopicSelectModel(getPageContext(), this);
        this.jBy.V(getIntent());
        this.jBy.cIm();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jBy.cIi();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.dQH.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byz() {
        ListView listView;
        View childAt;
        if (this.jBB.getVisibility() == 0) {
            listView = this.jBB;
        } else {
            listView = this.jBC;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byA() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rt(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent byB() {
        return this.fBA;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void byF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jBA.setVisibility(8);
        showLoadingView(this.jBF, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jBF = (ViewGroup) findViewById(R.id.frame_main_view);
        this.iGw = (TextView) findViewById(R.id.btn_confirm);
        this.jBI = (TextView) findViewById(R.id.topic_text);
        this.jBH = (ImageView) findViewById(R.id.clear_right_img);
        this.jBA = findViewById(R.id.home_search_list);
        this.jBB = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jBF.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jBE = new b(getPageContext());
        this.jBB.setAdapter((ListAdapter) this.jBE);
        this.jBC = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jBD = new e(getPageContext());
        this.jBC.setAdapter(this.jBD);
        this.jBB.setOnItemClickListener(this.mOnItemClickListener);
        this.jBC.setOnGroupClickListener(this.jBJ);
        this.jBC.setOnChildClickListener(this.jBK);
        this.iGw.setOnClickListener(this.mOnClickListener);
        this.jBH.setOnClickListener(this.mOnClickListener);
        nK(false);
        cIe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dK("obj_name", str);
        aqVar.aj("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String crt() {
        String crt = this.jBy != null ? this.jBy.crt() : "";
        return crt != null ? crt : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIc() {
        this.jBy.Ln("");
        this.jBG.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cId() {
        this.jBC.setVisibility(0);
        this.jBB.setVisibility(8);
        this.jBE.clearList();
        if (this.jBD != null && !y.isEmpty(this.jBD.getList())) {
            this.jBA.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jBy.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Li("");
        super.onBackPressed();
    }

    private void cIe() {
        this.jBG = (EditText) findViewById(R.id.search_root);
        this.jBG.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jBG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jBG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.crt())) {
                        HotTopicSelectActivity.this.Li(HotTopicSelectActivity.this.crt());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jBG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cId();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jBA.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jBy.Lm(obj);
                }
                HotTopicSelectActivity.this.nK(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cIf();
            }
        });
        this.jBG.requestFocus();
    }

    public void nK(boolean z) {
        this.jBH.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIf() {
        if (this.jBG != null && this.jBI != null) {
            if (TextUtils.isEmpty(this.jBG.getText())) {
                ap.setViewTextColor(this.jBI, R.color.cp_cont_d, 1);
            } else {
                ap.setViewTextColor(this.jBI, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li(String str) {
        if (this.jBG != null && this.jBG.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jBG);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fBA = new Intent();
            this.fBA.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Lj(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Lk(String str) {
        hideLoadingView(this.jBF);
        this.jBA.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pv(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pv(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cIg())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jBD.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jBA.setVisibility(0);
        this.jBC.setVisibility(0);
        this.jBB.setVisibility(8);
        hideLoadingView(this.jBF);
        this.jBD.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jBD.notifyDataSetChanged();
        int count = this.jBC.getCount();
        for (int i = 0; i < count; i++) {
            this.jBC.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Ll(String str) {
        this.jBA.setVisibility(0);
        this.jBC.setVisibility(8);
        this.jBB.setVisibility(0);
        hideLoadingView(this.jBF);
        String crt = crt();
        d Lj = Lj(crt);
        this.jBz.clear();
        this.jBz.add(Lj);
        this.jBE.j(crt, this.jBz);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jBA.setVisibility(0);
        this.jBC.setVisibility(8);
        this.jBB.setVisibility(0);
        hideLoadingView(this.jBF);
        this.jBz.clear();
        String crt = crt();
        this.jBz.add(Lj(crt));
        if (cVar == null || cVar.getList() == null) {
            this.jBE.j(crt, this.jBz);
            return;
        }
        this.jBz.addAll(cVar.getList());
        this.jBE.j(crt, this.jBz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bnV();
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
        if (this.jBE != null) {
            this.jBE.notifyDataSetChanged();
        }
        if (this.jBD != null) {
            this.jBD.notifyDataSetChanged();
        }
        if (this.jBG != null) {
            this.jBG.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        ap.setViewTextColor(this.iGw, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jBG, R.color.cp_cont_b, 2);
        ap.setImageResource(this.jBH, R.drawable.del_search_btn);
        cIf();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jBy.onDestroy();
        this.mNoDataView.bnV();
        hideLoadingView(this.jBF);
        super.onDestroy();
    }
}
