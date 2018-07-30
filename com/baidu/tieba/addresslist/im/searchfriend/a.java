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
    private EditText bpT;
    private TextView bpU;
    private ImageView bpV;
    private InterfaceC0133a bpW;
    private View.OnClickListener bpX = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bpU) {
                String a = k.a(a.this.bpT.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iV(a.trim());
                        a.this.bpU.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.j.input_content);
                    }
                }
            } else if (view == a.this.bpV) {
                a.this.iU("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0133a {
        void iT(String str);
    }

    public void cz(boolean z) {
        this.bpU.setClickable(z);
    }

    public void iU(String str) {
        this.bpT.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bpT = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.bpU = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.bpV = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.bpU.setOnClickListener(this.bpX);
        this.bpV.setOnClickListener(this.bpX);
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
                    a.this.bpV.setVisibility(8);
                } else {
                    a.this.bpV.setVisibility(0);
                }
            }
        };
        this.bpT.addTextChangedListener(this.mTextWatcher);
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void RE() {
        this.bpT.removeTextChangedListener(this.mTextWatcher);
    }

    public void RF() {
        l.a(this.context, this.bpT);
    }

    public void a(InterfaceC0133a interfaceC0133a) {
        this.bpW = interfaceC0133a;
    }

    public void dC(int i) {
        am.c(this.bpU, d.C0140d.cp_cont_g, 1);
        this.bpT.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        am.c(this.bpV, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(String str) {
        if (this.bpW != null) {
            this.bpW.iT(str);
        }
    }
}
