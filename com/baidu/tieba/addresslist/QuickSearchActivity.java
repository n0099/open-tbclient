package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.c.b aoh;
    private View aoi;
    private EditText aoj;
    private TextView aok;
    private View aol;
    private ListView aom;
    private p aon;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.quick_search_activity);
        this.aoh = new com.baidu.tieba.addresslist.c.b(this);
        this.aoh.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.aoi = findViewById(w.quick_search_parent);
        AT();
        this.aom = (ListView) findViewById(w.quick_search_result);
        this.aom.setOnTouchListener(new j(this));
        this.aon = new p(this, null);
        this.aom.setAdapter((ListAdapter) this.aon);
        this.aom.setOnItemClickListener(this);
        this.aol = findViewById(w.quick_search_empty_result);
        this.aoi.setOnTouchListener(new k(this));
    }

    private void AT() {
        this.mNavigationBar = (NavigationBar) findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.quick_search_navigation, (View.OnClickListener) null);
        this.aoj = (EditText) addCustomView.findViewById(w.quick_search_input);
        this.aoj.addTextChangedListener(new o(this, null));
        this.aoj.setOnFocusChangeListener(new m(this));
        this.aok = (TextView) addCustomView.findViewById(w.quick_search_delete_button);
        com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), this.aok, 10, 10, 10, 10);
        this.aok.setOnClickListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), this.aoj);
        this.aoh = null;
    }

    public void eN(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.b> eQ = this.aoh.eQ(str);
        if (eQ.size() > 0) {
            bh(true);
            this.aon.setContacts(eQ);
            this.aon.notifyDataSetChanged();
            this.aom.setSelection(0);
            return;
        }
        bh(false);
    }

    private void bh(boolean z) {
        this.aom.setVisibility(z ? 0 : 8);
        this.aol.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.b item = this.aon.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m255getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ax.i(this.aoi, t.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aon.notifyDataSetChanged();
    }
}
