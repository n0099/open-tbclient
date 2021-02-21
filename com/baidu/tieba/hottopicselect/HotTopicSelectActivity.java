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
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes8.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent geY;
    private TextView jAP;
    private HotTopicSelectModel kzl;
    private View kzn;
    private BdListView kzo;
    private ExpandableListView kzp;
    private e kzq;
    private b kzr;
    private ViewGroup kzs;
    private EditText kzt;
    private ImageView kzu;
    private TextView kzv;
    private NoDataView mNoDataView;
    private final List<d> kzm = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kzu) {
                HotTopicSelectActivity.this.cUa();
            } else if (view == HotTopicSelectActivity.this.jAP) {
                HotTopicSelectActivity.this.Mm("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.kzr.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Mm(topicName);
                HotTopicSelectActivity.this.bg(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener kzw = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kzp != null) {
                HotTopicSelectActivity.this.kzp.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener kzx = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kzq != null && (child = HotTopicSelectActivity.this.kzq.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Mm(topicName);
                c group = HotTopicSelectActivity.this.kzq.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.bg(topicName, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kzl = new HotTopicSelectModel(getPageContext(), this);
        this.kzl.W(getIntent());
        this.kzl.cUk();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kzl.cUg();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bYe.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEH() {
        ListView listView;
        View childAt;
        if (this.kzo.getVisibility() == 0) {
            listView = this.kzo;
        } else {
            listView = this.kzp;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return this.geY;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bEN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kzn.setVisibility(8);
        showLoadingView(this.kzs, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kzs = (ViewGroup) findViewById(R.id.frame_main_view);
        this.jAP = (TextView) findViewById(R.id.btn_confirm);
        this.kzv = (TextView) findViewById(R.id.topic_text);
        this.kzu = (ImageView) findViewById(R.id.clear_right_img);
        this.kzn = findViewById(R.id.home_search_list);
        this.kzo = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kzs.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kzr = new b(getPageContext());
        this.kzo.setAdapter((ListAdapter) this.kzr);
        this.kzp = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kzq = new e(getPageContext());
        this.kzp.setAdapter(this.kzq);
        this.kzo.setOnItemClickListener(this.mOnItemClickListener);
        this.kzp.setOnGroupClickListener(this.kzw);
        this.kzp.setOnChildClickListener(this.kzx);
        this.jAP.setOnClickListener(this.mOnClickListener);
        this.kzu.setOnClickListener(this.mOnClickListener);
        po(false);
        cUc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(String str, int i) {
        ar arVar = new ar("c11665");
        arVar.dR("obj_name", str);
        arVar.ap("obj_locate", i);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cBn() {
        String cBn = this.kzl != null ? this.kzl.cBn() : "";
        return cBn != null ? cBn : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUa() {
        this.kzl.Mr("");
        this.kzt.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUb() {
        this.kzp.setVisibility(0);
        this.kzo.setVisibility(8);
        this.kzr.clearList();
        if (this.kzq != null && !y.isEmpty(this.kzq.getList())) {
            this.kzn.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kzl.getCacheData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Mm("");
        super.onBackPressed();
    }

    private void cUc() {
        this.kzt = (EditText) findViewById(R.id.search_root);
        this.kzt.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kzt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kzt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cBn())) {
                        HotTopicSelectActivity.this.Mm(HotTopicSelectActivity.this.cBn());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kzt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cUb();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kzn.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kzl.Mq(obj);
                }
                HotTopicSelectActivity.this.po(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cUd();
            }
        });
        this.kzt.requestFocus();
    }

    public void po(boolean z) {
        this.kzu.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUd() {
        if (this.kzt != null && this.kzv != null) {
            if (TextUtils.isEmpty(this.kzt.getText())) {
                ap.setViewTextColor(this.kzv, R.color.CAM_X0109, 1);
            } else {
                ap.setViewTextColor(this.kzv, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mm(String str) {
        if (this.kzt != null && this.kzt.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kzt);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.geY = new Intent();
            this.geY.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Mn(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Mo(String str) {
        hideLoadingView(this.kzs);
        this.kzn.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cUe())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kzq.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kzn.setVisibility(0);
        this.kzp.setVisibility(0);
        this.kzo.setVisibility(8);
        hideLoadingView(this.kzs);
        this.kzq.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kzq.notifyDataSetChanged();
        int count = this.kzp.getCount();
        for (int i = 0; i < count; i++) {
            this.kzp.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Mp(String str) {
        this.kzn.setVisibility(0);
        this.kzp.setVisibility(8);
        this.kzo.setVisibility(0);
        hideLoadingView(this.kzs);
        String cBn = cBn();
        d Mn = Mn(cBn);
        this.kzm.clear();
        this.kzm.add(Mn);
        this.kzr.j(cBn, this.kzm);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kzn.setVisibility(0);
        this.kzp.setVisibility(8);
        this.kzo.setVisibility(0);
        hideLoadingView(this.kzs);
        this.kzm.clear();
        String cBn = cBn();
        this.kzm.add(Mn(cBn));
        if (cVar == null || cVar.getList() == null) {
            this.kzr.j(cBn, this.kzm);
            return;
        }
        this.kzm.addAll(cVar.getList());
        this.kzr.j(cBn, this.kzm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
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
        if (this.kzr != null) {
            this.kzr.notifyDataSetChanged();
        }
        if (this.kzq != null) {
            this.kzq.notifyDataSetChanged();
        }
        if (this.kzt != null) {
            this.kzt.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        ap.setViewTextColor(this.jAP, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kzt, R.color.CAM_X0105, 2);
        ap.setImageResource(this.kzu, R.drawable.del_search_btn);
        cUd();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kzl.onDestroy();
        this.mNoDataView.btX();
        hideLoadingView(this.kzs);
        super.onDestroy();
    }
}
