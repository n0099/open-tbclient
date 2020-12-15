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
/* loaded from: classes21.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent fXF;
    private TextView jnd;
    private HotTopicSelectModel kil;
    private View kin;
    private BdListView kio;
    private ExpandableListView kip;
    private e kiq;
    private b kir;
    private ViewGroup kis;
    private EditText kit;
    private ImageView kiu;
    private TextView kiv;
    private NoDataView mNoDataView;
    private final List<d> kim = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kiu) {
                HotTopicSelectActivity.this.cSF();
            } else if (view == HotTopicSelectActivity.this.jnd) {
                HotTopicSelectActivity.this.MF("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.kir.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.MF(topicName);
                HotTopicSelectActivity.this.aX(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener kiw = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kip != null) {
                HotTopicSelectActivity.this.kip.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener kix = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kiq != null && (child = HotTopicSelectActivity.this.kiq.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.MF(topicName);
                c group = HotTopicSelectActivity.this.kiq.getGroup(i);
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
        this.kil = new HotTopicSelectModel(getPageContext(), this);
        this.kil.V(getIntent());
        this.kil.cSP();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kil.cSL();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bTh.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        ListView listView;
        View childAt;
        if (this.kio.getVisibility() == 0) {
            listView = this.kio;
        } else {
            listView = this.kip;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXF;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bFR() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kin.setVisibility(8);
        showLoadingView(this.kis, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kis = (ViewGroup) findViewById(R.id.frame_main_view);
        this.jnd = (TextView) findViewById(R.id.btn_confirm);
        this.kiv = (TextView) findViewById(R.id.topic_text);
        this.kiu = (ImageView) findViewById(R.id.clear_right_img);
        this.kin = findViewById(R.id.home_search_list);
        this.kio = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kis.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kir = new b(getPageContext());
        this.kio.setAdapter((ListAdapter) this.kir);
        this.kip = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kiq = new e(getPageContext());
        this.kip.setAdapter(this.kiq);
        this.kio.setOnItemClickListener(this.mOnItemClickListener);
        this.kip.setOnGroupClickListener(this.kiw);
        this.kip.setOnChildClickListener(this.kix);
        this.jnd.setOnClickListener(this.mOnClickListener);
        this.kiu.setOnClickListener(this.mOnClickListener);
        oJ(false);
        cSH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, int i) {
        ar arVar = new ar("c11665");
        arVar.dY("obj_name", str);
        arVar.al("obj_locate", i);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cAT() {
        String cAT = this.kil != null ? this.kil.cAT() : "";
        return cAT != null ? cAT : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSF() {
        this.kil.MK("");
        this.kit.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSG() {
        this.kip.setVisibility(0);
        this.kio.setVisibility(8);
        this.kir.clearList();
        if (this.kiq != null && !y.isEmpty(this.kiq.getList())) {
            this.kin.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kil.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        MF("");
        super.onBackPressed();
    }

    private void cSH() {
        this.kit = (EditText) findViewById(R.id.search_root);
        this.kit.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cAT())) {
                        HotTopicSelectActivity.this.MF(HotTopicSelectActivity.this.cAT());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kit.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cSG();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kin.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kil.MJ(obj);
                }
                HotTopicSelectActivity.this.oJ(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cSI();
            }
        });
        this.kit.requestFocus();
    }

    public void oJ(boolean z) {
        this.kiu.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSI() {
        if (this.kit != null && this.kiv != null) {
            if (TextUtils.isEmpty(this.kit.getText())) {
                ap.setViewTextColor(this.kiv, R.color.CAM_X0109, 1);
            } else {
                ap.setViewTextColor(this.kiv, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MF(String str) {
        if (this.kit != null && this.kit.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kit);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fXF = new Intent();
            this.fXF.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d MG(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void MH(String str) {
        hideLoadingView(this.kis);
        this.kin.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cSJ())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kiq.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kin.setVisibility(0);
        this.kip.setVisibility(0);
        this.kio.setVisibility(8);
        hideLoadingView(this.kis);
        this.kiq.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kiq.notifyDataSetChanged();
        int count = this.kip.getCount();
        for (int i = 0; i < count; i++) {
            this.kip.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void MI(String str) {
        this.kin.setVisibility(0);
        this.kip.setVisibility(8);
        this.kio.setVisibility(0);
        hideLoadingView(this.kis);
        String cAT = cAT();
        d MG = MG(cAT);
        this.kim.clear();
        this.kim.add(MG);
        this.kir.j(cAT, this.kim);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kin.setVisibility(0);
        this.kip.setVisibility(8);
        this.kio.setVisibility(0);
        hideLoadingView(this.kis);
        this.kim.clear();
        String cAT = cAT();
        this.kim.add(MG(cAT));
        if (cVar == null || cVar.getList() == null) {
            this.kir.j(cAT, this.kim);
            return;
        }
        this.kim.addAll(cVar.getList());
        this.kir.j(cAT, this.kim);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bvb();
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
        if (this.kir != null) {
            this.kir.notifyDataSetChanged();
        }
        if (this.kiq != null) {
            this.kiq.notifyDataSetChanged();
        }
        if (this.kit != null) {
            this.kit.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        ap.setViewTextColor(this.jnd, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kit, R.color.CAM_X0105, 2);
        ap.setImageResource(this.kiu, R.drawable.del_search_btn);
        cSI();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kil.onDestroy();
        this.mNoDataView.bvb();
        hideLoadingView(this.kis);
        super.onDestroy();
    }
}
