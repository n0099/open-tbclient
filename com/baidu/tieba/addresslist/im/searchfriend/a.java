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
    private EditText cPT;
    private TextView cPU;
    private ImageView cPV;
    private InterfaceC0259a cPW;
    private View.OnClickListener cPX = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cPU) {
                String a = k.a(a.this.cPT.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.rg(a.trim());
                        a.this.cPU.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.j.input_content);
                    }
                }
            } else if (view == a.this.cPV) {
                a.this.rf("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0259a {
        void re(String str);
    }

    public void fL(boolean z) {
        this.cPU.setClickable(z);
    }

    public void rf(String str) {
        this.cPT.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.cPT = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.cPU = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.cPV = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.cPU.setOnClickListener(this.cPX);
        this.cPV.setOnClickListener(this.cPX);
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
                    a.this.cPV.setVisibility(8);
                } else {
                    a.this.cPV.setVisibility(0);
                }
            }
        };
        this.cPT.addTextChangedListener(this.mTextWatcher);
        ib(TbadkCoreApplication.getInst().getSkinType());
    }

    public void axe() {
        this.cPT.removeTextChangedListener(this.mTextWatcher);
    }

    public void axf() {
        l.b(this.context, this.cPT);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.cPW = interfaceC0259a;
    }

    public void ib(int i) {
        al.d(this.cPU, d.C0277d.cp_cont_g, 1);
        this.cPT.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.c(this.cPV, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(String str) {
        if (this.cPW != null) {
            this.cPW.re(str);
        }
    }
}
