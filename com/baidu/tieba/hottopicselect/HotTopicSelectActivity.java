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
    private Intent fPL;
    private TextView iYP;
    private HotTopicSelectModel jTU;
    private View jTW;
    private BdListView jTX;
    private ExpandableListView jTY;
    private e jTZ;
    private b jUa;
    private ViewGroup jUb;
    private EditText jUc;
    private ImageView jUd;
    private TextView jUe;
    private NoDataView mNoDataView;
    private final List<d> jTV = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jUd) {
                HotTopicSelectActivity.this.cNK();
            } else if (view == HotTopicSelectActivity.this.iYP) {
                HotTopicSelectActivity.this.LX("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jUa.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.LX(topicName);
                HotTopicSelectActivity.this.aX(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jUf = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jTY != null) {
                HotTopicSelectActivity.this.jTY.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jUg = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jTZ != null && (child = HotTopicSelectActivity.this.jTZ.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.LX(topicName);
                c group = HotTopicSelectActivity.this.jTZ.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aX(topicName, group.getType() == 0 ? 1 : 2);
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
        this.jTU = new HotTopicSelectModel(getPageContext(), this);
        this.jTU.V(getIntent());
        this.jTU.cNU();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jTU.cNQ();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bPL.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCR() {
        ListView listView;
        View childAt;
        if (this.jTX.getVisibility() == 0) {
            listView = this.jTX;
        } else {
            listView = this.jTY;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCS() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rO(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCT() {
        return this.fPL;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bCX() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jTW.setVisibility(8);
        showLoadingView(this.jUb, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jUb = (ViewGroup) findViewById(R.id.frame_main_view);
        this.iYP = (TextView) findViewById(R.id.btn_confirm);
        this.jUe = (TextView) findViewById(R.id.topic_text);
        this.jUd = (ImageView) findViewById(R.id.clear_right_img);
        this.jTW = findViewById(R.id.home_search_list);
        this.jTX = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jUb.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jUa = new b(getPageContext());
        this.jTX.setAdapter((ListAdapter) this.jUa);
        this.jTY = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jTZ = new e(getPageContext());
        this.jTY.setAdapter(this.jTZ);
        this.jTX.setOnItemClickListener(this.mOnItemClickListener);
        this.jTY.setOnGroupClickListener(this.jUf);
        this.jTY.setOnChildClickListener(this.jUg);
        this.iYP.setOnClickListener(this.mOnClickListener);
        this.jUd.setOnClickListener(this.mOnClickListener);
        ol(false);
        cNM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dR("obj_name", str);
        aqVar.al("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxb() {
        String cxb = this.jTU != null ? this.jTU.cxb() : "";
        return cxb != null ? cxb : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNK() {
        this.jTU.Mc("");
        this.jUc.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNL() {
        this.jTY.setVisibility(0);
        this.jTX.setVisibility(8);
        this.jUa.clearList();
        if (this.jTZ != null && !y.isEmpty(this.jTZ.getList())) {
            this.jTW.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jTU.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        LX("");
        super.onBackPressed();
    }

    private void cNM() {
        this.jUc = (EditText) findViewById(R.id.search_root);
        this.jUc.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jUc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jUc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cxb())) {
                        HotTopicSelectActivity.this.LX(HotTopicSelectActivity.this.cxb());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jUc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cNL();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jTW.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jTU.Mb(obj);
                }
                HotTopicSelectActivity.this.ol(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cNN();
            }
        });
        this.jUc.requestFocus();
    }

    public void ol(boolean z) {
        this.jUd.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNN() {
        if (this.jUc != null && this.jUe != null) {
            if (TextUtils.isEmpty(this.jUc.getText())) {
                ap.setViewTextColor(this.jUe, R.color.cp_cont_d, 1);
            } else {
                ap.setViewTextColor(this.jUe, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LX(String str) {
        if (this.jUc != null && this.jUc.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jUc);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fPL = new Intent();
            this.fPL.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d LY(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void LZ(String str) {
        hideLoadingView(this.jUb);
        this.jTW.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cNO())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jTZ.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jTW.setVisibility(0);
        this.jTY.setVisibility(0);
        this.jTX.setVisibility(8);
        hideLoadingView(this.jUb);
        this.jTZ.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jTZ.notifyDataSetChanged();
        int count = this.jTY.getCount();
        for (int i = 0; i < count; i++) {
            this.jTY.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Ma(String str) {
        this.jTW.setVisibility(0);
        this.jTY.setVisibility(8);
        this.jTX.setVisibility(0);
        hideLoadingView(this.jUb);
        String cxb = cxb();
        d LY = LY(cxb);
        this.jTV.clear();
        this.jTV.add(LY);
        this.jUa.j(cxb, this.jTV);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jTW.setVisibility(0);
        this.jTY.setVisibility(8);
        this.jTX.setVisibility(0);
        hideLoadingView(this.jUb);
        this.jTV.clear();
        String cxb = cxb();
        this.jTV.add(LY(cxb));
        if (cVar == null || cVar.getList() == null) {
            this.jUa.j(cxb, this.jTV);
            return;
        }
        this.jTV.addAll(cVar.getList());
        this.jUa.j(cxb, this.jTV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bso();
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
        if (this.jUa != null) {
            this.jUa.notifyDataSetChanged();
        }
        if (this.jTZ != null) {
            this.jTZ.notifyDataSetChanged();
        }
        if (this.jUc != null) {
            this.jUc.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        ap.setViewTextColor(this.iYP, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jUc, R.color.cp_cont_b, 2);
        ap.setImageResource(this.jUd, R.drawable.del_search_btn);
        cNN();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jTU.onDestroy();
        this.mNoDataView.bso();
        hideLoadingView(this.jUb);
        super.onDestroy();
    }
}
