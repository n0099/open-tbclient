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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private EditText bpm;
    private TextView bpn;
    private ImageView bpo;
    private InterfaceC0135a bpp;
    private View.OnClickListener bpq = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bpn) {
                String a = k.a(a.this.bpm.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iY(a.trim());
                        a.this.bpn.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.k.input_content);
                    }
                }
            } else if (view == a.this.bpo) {
                a.this.iX("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0135a {
        void iW(String str);
    }

    public void cz(boolean z) {
        this.bpn.setClickable(z);
    }

    public void iX(String str) {
        this.bpm.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bpm = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.bpn = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.bpo = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.bpn.setOnClickListener(this.bpq);
        this.bpo.setOnClickListener(this.bpq);
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
                    a.this.bpo.setVisibility(8);
                } else {
                    a.this.bpo.setVisibility(0);
                }
            }
        };
        this.bpm.addTextChangedListener(this.mTextWatcher);
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Rx() {
        this.bpm.removeTextChangedListener(this.mTextWatcher);
    }

    public void Ry() {
        l.b(this.context, this.bpm);
    }

    public void a(InterfaceC0135a interfaceC0135a) {
        this.bpp = interfaceC0135a;
    }

    public void dz(int i) {
        am.c(this.bpn, d.C0142d.cp_cont_g, 1);
        this.bpm.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        am.c(this.bpo, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY(String str) {
        if (this.bpp != null) {
            this.bpp.iW(str);
        }
    }
}
