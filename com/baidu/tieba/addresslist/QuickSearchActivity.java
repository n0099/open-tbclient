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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel fet;
    private View feu;
    private EditText fev;
    private TextView few;
    private TextView fex;
    private ListView fey;
    private b fez;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        this.fet = new QuickSearchModel(this);
        this.fet.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.feu = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        bsz();
        this.fey = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.fey.addHeaderView(textView);
        this.fey.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.fev);
                    return false;
                }
                return false;
            }
        });
        this.fez = new b();
        this.fey.setAdapter((ListAdapter) this.fez);
        this.fey.setOnItemClickListener(this);
        this.fex = (TextView) findViewById(R.id.quick_search_empty_result);
        this.feu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.fev);
                    return false;
                }
                return false;
            }
        });
    }

    private void bsz() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.fev.hasFocus()) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.fev);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        this.fev = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.fev.addTextChangedListener(new a());
        this.fev.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fev.requestFocus();
        this.few = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.addToParentArea(getPageContext().getPageActivity(), this.few, 10, 10, 10, 10);
        this.few.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.fev.setText("");
                QuickSearchActivity.this.fex.setVisibility(8);
                QuickSearchActivity.this.fey.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.fev);
        this.fet = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> Bw = this.fet.Bw(str);
        if (Bw.size() > 0) {
            jP(true);
            this.fez.setContacts(Bw);
            this.fez.notifyDataSetChanged();
            this.fey.setSelection(0);
            return;
        }
        jP(false);
    }

    private void jP(boolean z) {
        this.fey.setVisibility(z ? 0 : 8);
        this.fex.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.fey.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.fez.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.bgH(), 0, 4)));
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
                QuickSearchActivity.this.Bj(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.fex.setVisibility(8);
            QuickSearchActivity.this.fey.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.few.setVisibility(8);
            } else {
                QuickSearchActivity.this.few.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> feB;

        private b() {
            this.feB = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.feB = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.feB != null) {
                return this.feB.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: pU */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.feB == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.feB.get(i);
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
                cVar2.feC = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                cVar2.feD = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.feD.setText(item.getUserName());
            }
            cVar.feC.startLoad(item.bgH(), 12, false);
            return view;
        }
    }

    /* loaded from: classes15.dex */
    private class c {
        public HeadImageView feC;
        public TextView feD;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.feu, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fez.notifyDataSetChanged();
        ao.setViewTextColor(this.fex, R.color.cp_cont_d, 1);
    }
}
