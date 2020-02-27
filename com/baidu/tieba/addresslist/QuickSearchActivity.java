package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel eaA;
    private View eaB;
    private EditText eaC;
    private TextView eaD;
    private TextView eaE;
    private ListView eaF;
    private b eaG;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        this.eaA = new QuickSearchModel(this);
        this.eaA.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.eaB = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        aYA();
        this.eaF = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eaF.addHeaderView(textView);
        this.eaF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.eaC);
                    return false;
                }
                return false;
            }
        });
        this.eaG = new b();
        this.eaF.setAdapter((ListAdapter) this.eaG);
        this.eaF.setOnItemClickListener(this);
        this.eaE = (TextView) findViewById(R.id.quick_search_empty_result);
        this.eaB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.eaC);
                    return false;
                }
                return false;
            }
        });
    }

    private void aYA() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.eaC.hasFocus()) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.eaC);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        this.eaC = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.eaC.addTextChangedListener(new a());
        this.eaC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.eaC.requestFocus();
        this.eaD = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.addToParentArea(getPageContext().getPageActivity(), this.eaD, 10, 10, 10, 10);
        this.eaD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.eaC.setText("");
                QuickSearchActivity.this.eaE.setVisibility(8);
                QuickSearchActivity.this.eaF.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.eaC);
        this.eaA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> xv = this.eaA.xv(str);
        if (xv.size() > 0) {
            hD(true);
            this.eaG.setContacts(xv);
            this.eaG.notifyDataSetChanged();
            this.eaF.setSelection(0);
            return;
        }
        hD(false);
    }

    private void hD(boolean z) {
        this.eaF.setVisibility(z ? 0 : 8);
        this.eaE.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.eaF.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.eaG.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.aMl(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements TextWatcher {
        private a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() != 0) {
                QuickSearchActivity.this.xi(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.eaE.setVisibility(8);
            QuickSearchActivity.this.eaF.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.eaD.setVisibility(8);
            } else {
                QuickSearchActivity.this.eaD.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> eaI;

        private b() {
            this.eaI = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.eaI = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eaI != null) {
                return this.eaI.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: ok */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.eaI == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.eaI.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            com.baidu.tbadk.core.c layoutMode = QuickSearchActivity.this.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            }
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(R.layout.quick_search_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.eaJ = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                cVar2.eaK = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.eaK.setText(item.getUserName());
            }
            cVar.eaJ.startLoad(item.aMl(), 12, false);
            return view;
        }
    }

    /* loaded from: classes8.dex */
    private class c {
        public HeadImageView eaJ;
        public TextView eaK;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.eaB, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eaG.notifyDataSetChanged();
        am.setViewTextColor(this.eaE, R.color.cp_cont_d, 1);
    }
}
