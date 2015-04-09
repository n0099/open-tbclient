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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.c.b axB;
    private View axC;
    private EditText axD;
    private TextView axE;
    private TextView axF;
    private ListView axG;
    private n axH;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.quick_search_activity);
        this.axB = new com.baidu.tieba.addresslist.c.b(this);
        this.axB.setUniqueId(getUniqueId());
        EP();
    }

    private void EP() {
        this.axC = findViewById(v.quick_search_parent);
        ET();
        this.axG = (ListView) findViewById(v.quick_search_result);
        this.axG.setOnTouchListener(new h(this));
        this.axH = new n(this, null);
        this.axG.setAdapter((ListAdapter) this.axH);
        this.axG.setOnItemClickListener(this);
        this.axF = (TextView) findViewById(v.quick_search_empty_result);
        this.axC.setOnTouchListener(new i(this));
    }

    private void ET() {
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new j(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.quick_search_navigation, (View.OnClickListener) null);
        this.axD = (EditText) addCustomView.findViewById(v.quick_search_input);
        this.axD.addTextChangedListener(new m(this, null));
        this.axD.setOnFocusChangeListener(new k(this));
        this.axE = (TextView) addCustomView.findViewById(v.quick_search_delete_button);
        com.baidu.adp.lib.util.n.a(getPageContext().getPageActivity(), this.axE, 10, 10, 10, 10);
        this.axE.setOnClickListener(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), this.axD);
        this.axB = null;
    }

    public void eX(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> fm = this.axB.fm(str);
        if (fm.size() > 0) {
            bn(true);
            this.axH.setContacts(fm);
            this.axH.notifyDataSetChanged();
            this.axG.setSelection(0);
            return;
        }
        bn(false);
    }

    private void bn(boolean z) {
        this.axG.setVisibility(z ? 0 : 8);
        this.axF.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.a item = this.axH.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m411getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.i(this.axC, s.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.axH.notifyDataSetChanged();
        ba.b(this.axF, s.cp_cont_d, 1);
    }
}
