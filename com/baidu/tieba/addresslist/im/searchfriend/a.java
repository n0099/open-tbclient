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
    private EditText cPQ;
    private TextView cPR;
    private ImageView cPS;
    private InterfaceC0259a cPT;
    private View.OnClickListener cPU = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cPR) {
                String a = k.a(a.this.cPQ.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.rf(a.trim());
                        a.this.cPR.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.j.input_content);
                    }
                }
            } else if (view == a.this.cPS) {
                a.this.re("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0259a {
        void rd(String str);
    }

    public void fL(boolean z) {
        this.cPR.setClickable(z);
    }

    public void re(String str) {
        this.cPQ.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.cPQ = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.cPR = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.cPS = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.cPR.setOnClickListener(this.cPU);
        this.cPS.setOnClickListener(this.cPU);
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
                    a.this.cPS.setVisibility(8);
                } else {
                    a.this.cPS.setVisibility(0);
                }
            }
        };
        this.cPQ.addTextChangedListener(this.mTextWatcher);
        ic(TbadkCoreApplication.getInst().getSkinType());
    }

    public void axh() {
        this.cPQ.removeTextChangedListener(this.mTextWatcher);
    }

    public void axi() {
        l.b(this.context, this.cPQ);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.cPT = interfaceC0259a;
    }

    public void ic(int i) {
        al.d(this.cPR, d.C0277d.cp_cont_g, 1);
        this.cPQ.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.c(this.cPS, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rf(String str) {
        if (this.cPT != null) {
            this.cPT.rd(str);
        }
    }
}
