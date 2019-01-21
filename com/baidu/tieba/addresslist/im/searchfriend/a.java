package com.baidu.tieba.addresslist.im.searchfriend;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private EditText bEM;
    private TextView bEN;
    private ImageView bEO;
    private InterfaceC0191a bEP;
    private View.OnClickListener bEQ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bEN) {
                String a = k.a(a.this.bEM.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.kw(a.trim());
                        a.this.bEN.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(e.j.input_content);
                    }
                }
            } else if (view == a.this.bEO) {
                a.this.kv("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0191a {
        void ku(String str);
    }

    public void dv(boolean z) {
        this.bEN.setClickable(z);
    }

    public void kv(String str) {
        this.bEM.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bEM = (EditText) view.findViewById(e.g.new_search_friend_input);
        this.bEN = (TextView) view.findViewById(e.g.new_search_friend_search);
        this.bEO = (ImageView) view.findViewById(e.g.new_search_friend_del);
        this.bEN.setOnClickListener(this.bEQ);
        this.bEO.setOnClickListener(this.bEQ);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    a.this.bEO.setVisibility(8);
                } else {
                    a.this.bEO.setVisibility(0);
                }
            }
        };
        this.bEM.addTextChangedListener(this.mTextWatcher);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Xh() {
        this.bEM.removeTextChangedListener(this.mTextWatcher);
    }

    public void Xi() {
        l.b(this.context, this.bEM);
    }

    public void a(InterfaceC0191a interfaceC0191a) {
        this.bEP = interfaceC0191a;
    }

    public void ey(int i) {
        al.c(this.bEN, e.d.cp_cont_g, 1);
        this.bEM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.bEO, e.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(String str) {
        if (this.bEP != null) {
            this.bEP.ku(str);
        }
    }
}
