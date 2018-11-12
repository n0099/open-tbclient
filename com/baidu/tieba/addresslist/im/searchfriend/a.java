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
    private ImageView bAA;
    private InterfaceC0181a bAB;
    private View.OnClickListener bAC = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bAz) {
                String a = k.a(a.this.bAy.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.jN(a.trim());
                        a.this.bAz.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(e.j.input_content);
                    }
                }
            } else if (view == a.this.bAA) {
                a.this.jM("");
            }
        }
    };
    private EditText bAy;
    private TextView bAz;
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0181a {
        void jL(String str);
    }

    public void dr(boolean z) {
        this.bAz.setClickable(z);
    }

    public void jM(String str) {
        this.bAy.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bAy = (EditText) view.findViewById(e.g.new_search_friend_input);
        this.bAz = (TextView) view.findViewById(e.g.new_search_friend_search);
        this.bAA = (ImageView) view.findViewById(e.g.new_search_friend_del);
        this.bAz.setOnClickListener(this.bAC);
        this.bAA.setOnClickListener(this.bAC);
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
                    a.this.bAA.setVisibility(8);
                } else {
                    a.this.bAA.setVisibility(0);
                }
            }
        };
        this.bAy.addTextChangedListener(this.mTextWatcher);
        ek(TbadkCoreApplication.getInst().getSkinType());
    }

    public void VC() {
        this.bAy.removeTextChangedListener(this.mTextWatcher);
    }

    public void VD() {
        l.b(this.context, this.bAy);
    }

    public void a(InterfaceC0181a interfaceC0181a) {
        this.bAB = interfaceC0181a;
    }

    public void ek(int i) {
        al.c(this.bAz, e.d.cp_cont_g, 1);
        this.bAy.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.bAA, e.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN(String str) {
        if (this.bAB != null) {
            this.bAB.jL(str);
        }
    }
}
