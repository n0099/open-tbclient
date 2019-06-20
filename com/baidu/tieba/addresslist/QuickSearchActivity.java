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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private EditText axl;
    private QuickSearchModel cWI;
    private View cWJ;
    private TextView cWK;
    private TextView cWL;
    private ListView cWM;
    private b cWN;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        this.cWI = new QuickSearchModel(this);
        this.cWI.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.cWJ = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        aBX();
        this.cWM = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.cWM.addHeaderView(textView);
        this.cWM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.axl);
                    return false;
                }
                return false;
            }
        });
        this.cWN = new b();
        this.cWM.setAdapter((ListAdapter) this.cWN);
        this.cWM.setOnItemClickListener(this);
        this.cWL = (TextView) findViewById(R.id.quick_search_empty_result);
        this.cWJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.axl);
                    return false;
                }
                return false;
            }
        });
    }

    private void aBX() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.axl.hasFocus()) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.axl);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        this.axl = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.axl.addTextChangedListener(new a());
        this.axl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.axl.requestFocus();
        this.cWK = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.b(getPageContext().getPageActivity(), this.cWK, 10, 10, 10, 10);
        this.cWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.axl.setText("");
                QuickSearchActivity.this.cWL.setVisibility(8);
                QuickSearchActivity.this.cWM.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.b(getPageContext().getPageActivity(), this.axl);
        this.cWI = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sd(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> sq = this.cWI.sq(str);
        if (sq.size() > 0) {
            gh(true);
            this.cWN.setContacts(sq);
            this.cWN.notifyDataSetChanged();
            this.cWM.setSelection(0);
            return;
        }
        gh(false);
    }

    private void gh(boolean z) {
        this.cWM.setVisibility(z ? 0 : 8);
        this.cWL.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.cWM.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.cWN.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.aoM(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        private a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() != 0) {
                QuickSearchActivity.this.sd(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.cWL.setVisibility(8);
            QuickSearchActivity.this.cWM.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.cWK.setVisibility(8);
            } else {
                QuickSearchActivity.this.cWK.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> cWP;

        private b() {
            this.cWP = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.cWP = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cWP != null) {
                return this.cWP.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: mp */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.cWP == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.cWP.get(i);
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
                cVar2.cWQ = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                cVar2.cWR = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            al.k(view, R.drawable.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.cWR.setText(item.getUserName());
            }
            cVar.cWQ.startLoad(item.aoM(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView cWQ;
        public TextView cWR;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.cWJ, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cWN.notifyDataSetChanged();
        al.f(this.cWL, R.color.cp_cont_d, 1);
    }
}
