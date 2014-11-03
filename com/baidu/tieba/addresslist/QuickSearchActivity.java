package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity {
    private com.baidu.tieba.addresslist.c.b agR;
    private View agS;
    private EditText agT;
    private TextView agU;
    private View agV;
    private ListView agW;
    private o agX;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.quick_search_activity);
        this.agR = new com.baidu.tieba.addresslist.c.b(this);
        this.agR.setUniqueId(getUniqueId());
        sa();
    }

    private void sa() {
        this.agS = findViewById(v.quick_search_parent);
        xA();
        this.agW = (ListView) findViewById(v.quick_search_result);
        this.agW.setOnTouchListener(new i(this));
        this.agX = new o(this, null);
        this.agW.setAdapter((ListAdapter) this.agX);
        this.agW.setOnItemClickListener(this);
        this.agV = findViewById(v.quick_search_empty_result);
        this.agS.setOnTouchListener(new j(this));
    }

    private void xA() {
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.quick_search_navigation, (View.OnClickListener) null);
        this.agT = (EditText) addCustomView.findViewById(v.quick_search_input);
        this.agT.addTextChangedListener(new n(this, null));
        this.agT.setOnFocusChangeListener(new l(this));
        this.agU = (TextView) addCustomView.findViewById(v.quick_search_delete_button);
        com.baidu.adp.lib.util.m.a(this, this.agU, 10, 10, 10, 10);
        this.agU.setOnClickListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.m.b(this, this.agT);
        this.agR = null;
    }

    public void eh(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.b> ek = this.agR.ek(str);
        if (ek.size() > 0) {
            bi(true);
            this.agX.setContacts(ek);
            this.agX.notifyDataSetChanged();
            this.agW.setSelection(0);
            return;
        }
        bi(false);
    }

    private void bi(boolean z) {
        this.agW.setVisibility(z ? 0 : 8);
        this.agV.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.b item = this.agX.getItem(i);
        if (item != null && item.getUserId() > 0) {
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.m251getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.h(this.agS, s.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(i);
        this.agX.notifyDataSetChanged();
    }
}
