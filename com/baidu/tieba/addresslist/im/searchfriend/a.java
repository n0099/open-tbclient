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
    private EditText bzN;
    private TextView bzO;
    private ImageView bzP;
    private InterfaceC0157a bzQ;
    private View.OnClickListener bzR = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bzO) {
                String a = k.a(a.this.bzN.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.jL(a.trim());
                        a.this.bzO.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(e.j.input_content);
                    }
                }
            } else if (view == a.this.bzP) {
                a.this.jK("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0157a {
        void jJ(String str);
    }

    public void da(boolean z) {
        this.bzO.setClickable(z);
    }

    public void jK(String str) {
        this.bzN.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bzN = (EditText) view.findViewById(e.g.new_search_friend_input);
        this.bzO = (TextView) view.findViewById(e.g.new_search_friend_search);
        this.bzP = (ImageView) view.findViewById(e.g.new_search_friend_del);
        this.bzO.setOnClickListener(this.bzR);
        this.bzP.setOnClickListener(this.bzR);
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
                    a.this.bzP.setVisibility(8);
                } else {
                    a.this.bzP.setVisibility(0);
                }
            }
        };
        this.bzN.addTextChangedListener(this.mTextWatcher);
        dW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Vt() {
        this.bzN.removeTextChangedListener(this.mTextWatcher);
    }

    public void Vu() {
        l.a(this.context, this.bzN);
    }

    public void a(InterfaceC0157a interfaceC0157a) {
        this.bzQ = interfaceC0157a;
    }

    public void dW(int i) {
        al.c(this.bzO, e.d.cp_cont_g, 1);
        this.bzN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.bzP, e.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(String str) {
        if (this.bzQ != null) {
            this.bzQ.jJ(str);
        }
    }
}
