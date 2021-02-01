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
    private Intent geT;
    private TextView jAB;
    private HotTopicSelectModel kyX;
    private View kyZ;
    private BdListView kza;
    private ExpandableListView kzb;
    private e kzc;
    private b kzd;
    private ViewGroup kze;
    private EditText kzf;
    private ImageView kzg;
    private TextView kzh;
    private NoDataView mNoDataView;
    private final List<d> kyY = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kzg) {
                HotTopicSelectActivity.this.cTT();
            } else if (view == HotTopicSelectActivity.this.jAB) {
                HotTopicSelectActivity.this.Ml("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.kzd.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Ml(topicName);
                HotTopicSelectActivity.this.bg(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener kzi = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kzb != null) {
                HotTopicSelectActivity.this.kzb.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener kzj = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kzc != null && (child = HotTopicSelectActivity.this.kzc.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Ml(topicName);
                c group = HotTopicSelectActivity.this.kzc.getGroup(i);
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
        this.kyX = new HotTopicSelectModel(getPageContext(), this);
        this.kyX.W(getIntent());
        this.kyX.cUd();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kyX.cTZ();
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
        if (this.kza.getVisibility() == 0) {
            listView = this.kza;
        } else {
            listView = this.kzb;
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
        return this.geT;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bEN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kyZ.setVisibility(8);
        showLoadingView(this.kze, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kze = (ViewGroup) findViewById(R.id.frame_main_view);
        this.jAB = (TextView) findViewById(R.id.btn_confirm);
        this.kzh = (TextView) findViewById(R.id.topic_text);
        this.kzg = (ImageView) findViewById(R.id.clear_right_img);
        this.kyZ = findViewById(R.id.home_search_list);
        this.kza = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kze.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kzd = new b(getPageContext());
        this.kza.setAdapter((ListAdapter) this.kzd);
        this.kzb = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kzc = new e(getPageContext());
        this.kzb.setAdapter(this.kzc);
        this.kza.setOnItemClickListener(this.mOnItemClickListener);
        this.kzb.setOnGroupClickListener(this.kzi);
        this.kzb.setOnChildClickListener(this.kzj);
        this.jAB.setOnClickListener(this.mOnClickListener);
        this.kzg.setOnClickListener(this.mOnClickListener);
        po(false);
        cTV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(String str, int i) {
        ar arVar = new ar("c11665");
        arVar.dR("obj_name", str);
        arVar.ap("obj_locate", i);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cBg() {
        String cBg = this.kyX != null ? this.kyX.cBg() : "";
        return cBg != null ? cBg : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTT() {
        this.kyX.Mq("");
        this.kzf.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTU() {
        this.kzb.setVisibility(0);
        this.kza.setVisibility(8);
        this.kzd.clearList();
        if (this.kzc != null && !y.isEmpty(this.kzc.getList())) {
            this.kyZ.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kyX.getCacheData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Ml("");
        super.onBackPressed();
    }

    private void cTV() {
        this.kzf = (EditText) findViewById(R.id.search_root);
        this.kzf.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kzf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kzf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cBg())) {
                        HotTopicSelectActivity.this.Ml(HotTopicSelectActivity.this.cBg());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kzf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cTU();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kyZ.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kyX.Mp(obj);
                }
                HotTopicSelectActivity.this.po(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cTW();
            }
        });
        this.kzf.requestFocus();
    }

    public void po(boolean z) {
        this.kzg.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTW() {
        if (this.kzf != null && this.kzh != null) {
            if (TextUtils.isEmpty(this.kzf.getText())) {
                ap.setViewTextColor(this.kzh, R.color.CAM_X0109, 1);
            } else {
                ap.setViewTextColor(this.kzh, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ml(String str) {
        if (this.kzf != null && this.kzf.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kzf);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.geT = new Intent();
            this.geT.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Mm(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Mn(String str) {
        hideLoadingView(this.kze);
        this.kyZ.setVisibility(8);
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
            if (TextUtils.isEmpty(cVar.cTX())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kzc.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kyZ.setVisibility(0);
        this.kzb.setVisibility(0);
        this.kza.setVisibility(8);
        hideLoadingView(this.kze);
        this.kzc.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kzc.notifyDataSetChanged();
        int count = this.kzb.getCount();
        for (int i = 0; i < count; i++) {
            this.kzb.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Mo(String str) {
        this.kyZ.setVisibility(0);
        this.kzb.setVisibility(8);
        this.kza.setVisibility(0);
        hideLoadingView(this.kze);
        String cBg = cBg();
        d Mm = Mm(cBg);
        this.kyY.clear();
        this.kyY.add(Mm);
        this.kzd.j(cBg, this.kyY);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kyZ.setVisibility(0);
        this.kzb.setVisibility(8);
        this.kza.setVisibility(0);
        hideLoadingView(this.kze);
        this.kyY.clear();
        String cBg = cBg();
        this.kyY.add(Mm(cBg));
        if (cVar == null || cVar.getList() == null) {
            this.kzd.j(cBg, this.kyY);
            return;
        }
        this.kyY.addAll(cVar.getList());
        this.kzd.j(cBg, this.kyY);
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
        if (this.kzd != null) {
            this.kzd.notifyDataSetChanged();
        }
        if (this.kzc != null) {
            this.kzc.notifyDataSetChanged();
        }
        if (this.kzf != null) {
            this.kzf.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        ap.setViewTextColor(this.jAB, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kzf, R.color.CAM_X0105, 2);
        ap.setImageResource(this.kzg, R.drawable.del_search_btn);
        cTW();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kyX.onDestroy();
        this.mNoDataView.btX();
        hideLoadingView(this.kze);
        super.onDestroy();
    }
}
