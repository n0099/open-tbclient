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
/* loaded from: classes6.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private TextView dWA;
    private ListView dWB;
    private b dWC;
    private QuickSearchModel dWw;
    private View dWx;
    private EditText dWy;
    private TextView dWz;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        this.dWw = new QuickSearchModel(this);
        this.dWw.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.dWx = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        aWl();
        this.dWB = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.dWB.addHeaderView(textView);
        this.dWB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.dWy);
                    return false;
                }
                return false;
            }
        });
        this.dWC = new b();
        this.dWB.setAdapter((ListAdapter) this.dWC);
        this.dWB.setOnItemClickListener(this);
        this.dWA = (TextView) findViewById(R.id.quick_search_empty_result);
        this.dWx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.dWy);
                    return false;
                }
                return false;
            }
        });
    }

    private void aWl() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.dWy.hasFocus()) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.dWy);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        this.dWy = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.dWy.addTextChangedListener(new a());
        this.dWy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.dWy.requestFocus();
        this.dWz = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.addToParentArea(getPageContext().getPageActivity(), this.dWz, 10, 10, 10, 10);
        this.dWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.dWy.setText("");
                QuickSearchActivity.this.dWA.setVisibility(8);
                QuickSearchActivity.this.dWB.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.dWy);
        this.dWw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wO(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> xb = this.dWw.xb(str);
        if (xb.size() > 0) {
            hw(true);
            this.dWC.setContacts(xb);
            this.dWC.notifyDataSetChanged();
            this.dWB.setSelection(0);
            return;
        }
        hw(false);
    }

    private void hw(boolean z) {
        this.dWB.setVisibility(z ? 0 : 8);
        this.dWA.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.dWB.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.dWC.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.aJR(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements TextWatcher {
        private a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() != 0) {
                QuickSearchActivity.this.wO(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.dWA.setVisibility(8);
            QuickSearchActivity.this.dWB.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.dWz.setVisibility(8);
            } else {
                QuickSearchActivity.this.dWz.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> dWE;

        private b() {
            this.dWE = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.dWE = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dWE != null) {
                return this.dWE.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nT */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.dWE == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.dWE.get(i);
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
                cVar2.dWF = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                cVar2.dWG = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.dWG.setText(item.getUserName());
            }
            cVar.dWF.startLoad(item.aJR(), 12, false);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private class c {
        public HeadImageView dWF;
        public TextView dWG;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.dWx, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dWC.notifyDataSetChanged();
        am.setViewTextColor(this.dWA, R.color.cp_cont_d, 1);
    }
}
