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
/* loaded from: classes8.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel giE;
    private View giF;
    private EditText giG;
    private TextView giH;
    private TextView giI;
    private ListView giJ;
    private b giK;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quick_search_activity);
        this.giE = new QuickSearchModel(this);
        this.giE.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.giF = findViewById(R.id.quick_search_parent);
        adjustResizeForSoftInput();
        bLR();
        this.giJ = (ListView) findViewById(R.id.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.giJ.addHeaderView(textView);
        this.giJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.giG);
                    return false;
                }
                return false;
            }
        });
        this.giK = new b();
        this.giJ.setAdapter((ListAdapter) this.giK);
        this.giJ.setOnItemClickListener(this);
        this.giI = (TextView) findViewById(R.id.quick_search_empty_result);
        this.giF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.giG);
                    return false;
                }
                return false;
            }
        });
    }

    private void bLR() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.giG.hasFocus()) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.giG);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
        this.giG = (EditText) addCustomView.findViewById(R.id.quick_search_input);
        this.giG.addTextChangedListener(new a());
        this.giG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.giG.requestFocus();
        this.giH = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
        l.addToParentArea(getPageContext().getPageActivity(), this.giH, 10, 10, 10, 10);
        this.giH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.giG.setText("");
                QuickSearchActivity.this.giI.setVisibility(8);
                QuickSearchActivity.this.giJ.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.giG);
        this.giE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ET(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> Fg = this.giE.Fg(str);
        if (Fg.size() > 0) {
            md(true);
            this.giK.setContacts(Fg);
            this.giK.notifyDataSetChanged();
            this.giJ.setSelection(0);
            return;
        }
        md(false);
    }

    private void md(boolean z) {
        this.giJ.setVisibility(z ? 0 : 8);
        this.giI.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.giJ.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.giK.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
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
                QuickSearchActivity.this.ET(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.giI.setVisibility(8);
            QuickSearchActivity.this.giJ.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.giH.setVisibility(8);
            } else {
                QuickSearchActivity.this.giH.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> giM;

        private b() {
            this.giM = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.giM = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.giM != null) {
                return this.giM.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: td */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.giM == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.giM.get(i);
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
                cVar2.giN = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                cVar2.giO = (TextView) view.findViewById(R.id.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.giO.setText(item.getUserName());
            }
            cVar.giN.startLoad(item.getUserPortrait(), 12, false);
            return view;
        }
    }

    /* loaded from: classes8.dex */
    private class c {
        public HeadImageView giN;
        public TextView giO;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.giF, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giK.notifyDataSetChanged();
        ap.setViewTextColor(this.giI, R.color.CAM_X0109, 1);
    }
}
