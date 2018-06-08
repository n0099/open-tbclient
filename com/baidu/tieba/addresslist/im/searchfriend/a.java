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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private EditText bnM;
    private TextView bnN;
    private ImageView bnO;
    private InterfaceC0134a bnP;
    private View.OnClickListener bnQ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bnN) {
                String a = k.a(a.this.bnM.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iT(a.trim());
                        a.this.bnN.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.k.input_content);
                    }
                }
            } else if (view == a.this.bnO) {
                a.this.iS("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0134a {
        void iR(String str);
    }

    public void cv(boolean z) {
        this.bnN.setClickable(z);
    }

    public void iS(String str) {
        this.bnM.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bnM = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.bnN = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.bnO = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.bnN.setOnClickListener(this.bnQ);
        this.bnO.setOnClickListener(this.bnQ);
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
                    a.this.bnO.setVisibility(8);
                } else {
                    a.this.bnO.setVisibility(0);
                }
            }
        };
        this.bnM.addTextChangedListener(this.mTextWatcher);
        dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Ra() {
        this.bnM.removeTextChangedListener(this.mTextWatcher);
    }

    public void Rb() {
        l.b(this.context, this.bnM);
    }

    public void a(InterfaceC0134a interfaceC0134a) {
        this.bnP = interfaceC0134a;
    }

    public void dy(int i) {
        al.c(this.bnN, d.C0141d.cp_cont_g, 1);
        this.bnM.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        al.c(this.bnO, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(String str) {
        if (this.bnP != null) {
            this.bnP.iR(str);
        }
    }
}
