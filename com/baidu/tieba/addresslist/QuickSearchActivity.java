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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel bot;
    private View bou;
    private EditText bov;
    private TextView bow;
    private TextView box;
    private ListView boy;
    private b boz;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.quick_search_activity);
        this.bot = new QuickSearchModel(this);
        this.bot.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bou = findViewById(d.g.quick_search_parent);
        adjustResizeForSoftInput();
        Ro();
        this.boy = (ListView) findViewById(d.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.boy.addHeaderView(textView);
        this.boy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bov);
                    return false;
                }
                return false;
            }
        });
        this.boz = new b();
        this.boy.setAdapter((ListAdapter) this.boz);
        this.boy.setOnItemClickListener(this);
        this.box = (TextView) findViewById(d.g.quick_search_empty_result);
        this.bou.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bov);
                    return false;
                }
                return false;
            }
        });
    }

    private void Ro() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.bov.hasFocus()) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bov);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.quick_search_navigation, (View.OnClickListener) null);
        this.bov = (EditText) addCustomView.findViewById(d.g.quick_search_input);
        this.bov.addTextChangedListener(new a());
        this.bov.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bov.requestFocus();
        this.bow = (TextView) addCustomView.findViewById(d.g.quick_search_delete_button);
        l.a(getPageContext().getPageActivity(), this.bow, 10, 10, 10, 10);
        this.bow.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.bov.setText("");
                QuickSearchActivity.this.box.setVisibility(8);
                QuickSearchActivity.this.boy.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.a(getPageContext().getPageActivity(), this.bov);
        this.bot = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iK(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> iX = this.bot.iX(str);
        if (iX.size() > 0) {
            cy(true);
            this.boz.setContacts(iX);
            this.boz.notifyDataSetChanged();
            this.boy.setSelection(0);
            return;
        }
        cy(false);
    }

    private void cy(boolean z) {
        this.boy.setVisibility(z ? 0 : 8);
        this.box.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.boy.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.boz.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.Fu(), 0, 4)));
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
                QuickSearchActivity.this.iK(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.box.setVisibility(8);
            QuickSearchActivity.this.boy.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.bow.setVisibility(8);
            } else {
                QuickSearchActivity.this.bow.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> boB;

        private b() {
            this.boB = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.boB = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.boB != null) {
                return this.boB.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: gC */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.boB == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.boB.get(i);
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
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(d.h.quick_search_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.boC = (HeadImageView) view.findViewById(d.g.quick_search_item_icon);
                cVar2.boD = (TextView) view.findViewById(d.g.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            am.i(view, d.f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.boD.setText(item.getUserName());
            }
            cVar.boC.startLoad(item.Fu(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView boC;
        public TextView boD;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.bou, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.boz.notifyDataSetChanged();
        am.c(this.box, d.C0140d.cp_cont_d, 1);
    }
}
