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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
    private TextView hQn;
    private HotTopicSelectModel iIK;
    private View iIM;
    private BdListView iIN;
    private ExpandableListView iIO;
    private e iIP;
    private b iIQ;
    private ViewGroup iIR;
    private EditText iIS;
    private ImageView iIT;
    private TextView iIU;
    private Intent iIV;
    private NoDataView mNoDataView;
    private final List<d> iIL = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.iIT) {
                HotTopicSelectActivity.this.cms();
            } else if (view == HotTopicSelectActivity.this.hQn) {
                HotTopicSelectActivity.this.Gm("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) w.getItem(HotTopicSelectActivity.this.iIQ.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Gm(topicName);
                HotTopicSelectActivity.this.aR(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener iIW = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.iIO != null) {
                HotTopicSelectActivity.this.iIO.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener iIX = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.iIP != null && (child = HotTopicSelectActivity.this.iIP.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Gm(topicName);
                c group = HotTopicSelectActivity.this.iIP.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aR(topicName, group.getType() == 0 ? 1 : 2);
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
        this.iIK = new HotTopicSelectModel(getPageContext(), this);
        this.iIK.V(getIntent());
        this.iIK.cmC();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.iIK.cmy();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.dmF.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bim() {
        ListView listView;
        View childAt;
        if (this.iIN.getVisibility() == 0) {
            listView = this.iIN;
        } else {
            listView = this.iIO;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bin() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ob(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bio() {
        return this.iIV;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bis() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iIM.setVisibility(8);
        showLoadingView(this.iIR, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.iIR = (ViewGroup) findViewById(R.id.frame_main_view);
        this.hQn = (TextView) findViewById(R.id.btn_confirm);
        this.iIU = (TextView) findViewById(R.id.topic_text);
        this.iIT = (ImageView) findViewById(R.id.clear_right_img);
        this.iIM = findViewById(R.id.home_search_list);
        this.iIN = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.iIR.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.iIQ = new b(getPageContext());
        this.iIN.setAdapter((ListAdapter) this.iIQ);
        this.iIO = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.iIP = new e(getPageContext());
        this.iIO.setAdapter(this.iIP);
        this.iIN.setOnItemClickListener(this.mOnItemClickListener);
        this.iIO.setOnGroupClickListener(this.iIW);
        this.iIO.setOnChildClickListener(this.iIX);
        this.hQn.setOnClickListener(this.mOnClickListener);
        this.iIT.setOnClickListener(this.mOnClickListener);
        lP(false);
        cmu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(String str, int i) {
        ao aoVar = new ao("c11665");
        aoVar.dk("obj_name", str);
        aoVar.ag("obj_locate", i);
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bWR() {
        String bWR = this.iIK != null ? this.iIK.bWR() : "";
        return bWR != null ? bWR : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        this.iIK.Gr("");
        this.iIS.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmt() {
        this.iIO.setVisibility(0);
        this.iIN.setVisibility(8);
        this.iIQ.clearList();
        if (this.iIP != null && !w.isEmpty(this.iIP.getList())) {
            this.iIM.setVisibility(0);
            return;
        }
        showLoadingView();
        this.iIK.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Gm("");
        super.onBackPressed();
    }

    private void cmu() {
        this.iIS = (EditText) findViewById(R.id.search_root);
        this.iIS.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.iIS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.iIS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.bWR())) {
                        HotTopicSelectActivity.this.Gm(HotTopicSelectActivity.this.bWR());
                    }
                    return true;
                }
                return false;
            }
        });
        this.iIS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cmt();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.iIM.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.iIK.Gq(obj);
                }
                HotTopicSelectActivity.this.lP(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cmv();
            }
        });
        this.iIS.requestFocus();
    }

    public void lP(boolean z) {
        this.iIT.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmv() {
        if (this.iIS != null && this.iIU != null) {
            if (TextUtils.isEmpty(this.iIS.getText())) {
                an.setViewTextColor(this.iIU, R.color.cp_cont_d, 1);
            } else {
                an.setViewTextColor(this.iIU, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gm(String str) {
        if (this.iIS != null && this.iIS.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iIS);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.iIV = new Intent();
            this.iIV.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Gn(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Go(String str) {
        hideLoadingView(this.iIR);
        this.iIM.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mm(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mm(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !w.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cmw())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.iIP.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.iIM.setVisibility(0);
        this.iIO.setVisibility(0);
        this.iIN.setVisibility(8);
        hideLoadingView(this.iIR);
        this.iIP.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.iIP.notifyDataSetChanged();
        int count = this.iIO.getCount();
        for (int i = 0; i < count; i++) {
            this.iIO.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Gp(String str) {
        this.iIM.setVisibility(0);
        this.iIO.setVisibility(8);
        this.iIN.setVisibility(0);
        hideLoadingView(this.iIR);
        String bWR = bWR();
        d Gn = Gn(bWR);
        this.iIL.clear();
        this.iIL.add(Gn);
        this.iIQ.j(bWR, this.iIL);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.iIM.setVisibility(0);
        this.iIO.setVisibility(8);
        this.iIN.setVisibility(0);
        hideLoadingView(this.iIR);
        this.iIL.clear();
        String bWR = bWR();
        this.iIL.add(Gn(bWR));
        if (cVar == null || cVar.getList() == null) {
            this.iIQ.j(bWR, this.iIL);
            return;
        }
        this.iIL.addAll(cVar.getList());
        this.iIQ.j(bWR, this.iIL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.aXU();
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
        if (this.iIQ != null) {
            this.iIQ.notifyDataSetChanged();
        }
        if (this.iIP != null) {
            this.iIP.notifyDataSetChanged();
        }
        if (this.iIS != null) {
            this.iIS.setHintTextColor(an.getColor(R.color.cp_cont_d));
        }
        an.setViewTextColor(this.hQn, R.color.cp_link_tip_a, 1);
        an.setViewTextColor(this.iIS, R.color.cp_cont_b, 2);
        an.setImageResource(this.iIT, R.drawable.del_search_btn);
        cmv();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.iIK.onDestroy();
        this.mNoDataView.aXU();
        hideLoadingView(this.iIR);
        super.onDestroy();
    }
}
