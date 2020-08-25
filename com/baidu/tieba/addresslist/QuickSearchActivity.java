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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel fpM;
    private View fpN;
    private EditText fpO;
    private TextView fpP;
    private TextView fpQ;
    private ListView fpR;
    private b fpS;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        this.fpM = new QuickSearchModel(this);
        this.fpM.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.fpN = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        bBw();
        this.fpR = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fpR.addHeaderView(textView);
        this.fpR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.fpO);
                    return false;
                }
                return false;
            }
        });
        this.fpS = new b();
        this.fpR.setAdapter((ListAdapter) this.fpS);
        this.fpR.setOnItemClickListener(this);
        this.fpQ = (TextView) findViewById(R.id.quick_search_empty_result);
        this.fpN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.fpO);
                    return false;
                }
                return false;
            }
        });
    }

    private void bBw() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.fpO.hasFocus()) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.fpO);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        this.fpO = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.fpO.addTextChangedListener(new a());
        this.fpO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fpO.requestFocus();
        this.fpP = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.addToParentArea(getPageContext().getPageActivity(), this.fpP, 10, 10, 10, 10);
        this.fpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.fpO.setText("");
                QuickSearchActivity.this.fpQ.setVisibility(8);
                QuickSearchActivity.this.fpR.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.fpO);
        this.fpM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> DQ = this.fpM.DQ(str);
        if (DQ.size() > 0) {
            kn(true);
            this.fpS.setContacts(DQ);
            this.fpS.notifyDataSetChanged();
            this.fpR.setSelection(0);
            return;
        }
        kn(false);
    }

    private void kn(boolean z) {
        this.fpR.setVisibility(z ? 0 : 8);
        this.fpQ.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.fpR.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.fpS.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.bps(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements TextWatcher {
        private a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() != 0) {
                QuickSearchActivity.this.DD(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.fpQ.setVisibility(8);
            QuickSearchActivity.this.fpR.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.fpP.setVisibility(8);
            } else {
                QuickSearchActivity.this.fpP.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> fpU;

        private b() {
            this.fpU = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.fpU = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fpU != null) {
                return this.fpU.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: sg */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.fpU == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.fpU.get(i);
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
                cVar2.fpV = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                cVar2.fpW = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.fpW.setText(item.getUserName());
            }
            cVar.fpV.startLoad(item.bps(), 12, false);
            return view;
        }
    }

    /* loaded from: classes15.dex */
    private class c {
        public HeadImageView fpV;
        public TextView fpW;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.fpN, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fpS.notifyDataSetChanged();
        ap.setViewTextColor(this.fpQ, R.color.cp_cont_d, 1);
    }
}
