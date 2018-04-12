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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private EditText bfE;
    private TextView bfF;
    private ImageView bfG;
    private InterfaceC0118a bfH;
    private View.OnClickListener bfI = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == a.this.bfF) {
                String a = k.a(a.this.bfE.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iq(a.trim());
                        a.this.bfF.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.k.input_content);
                    }
                }
            } else if (view2 == a.this.bfG) {
                a.this.ip("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0118a {
        void io(String str);
    }

    public void cq(boolean z) {
        this.bfF.setClickable(z);
    }

    public void ip(String str) {
        this.bfE.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view2) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bfE = (EditText) view2.findViewById(d.g.new_search_friend_input);
        this.bfF = (TextView) view2.findViewById(d.g.new_search_friend_search);
        this.bfG = (ImageView) view2.findViewById(d.g.new_search_friend_del);
        this.bfF.setOnClickListener(this.bfI);
        this.bfG.setOnClickListener(this.bfI);
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
                    a.this.bfG.setVisibility(8);
                } else {
                    a.this.bfG.setVisibility(0);
                }
            }
        };
        this.bfE.addTextChangedListener(this.mTextWatcher);
        dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ND() {
        this.bfE.removeTextChangedListener(this.mTextWatcher);
    }

    public void NE() {
        l.b(this.context, this.bfE);
    }

    public void a(InterfaceC0118a interfaceC0118a) {
        this.bfH = interfaceC0118a;
    }

    public void dw(int i) {
        ak.c(this.bfF, d.C0126d.cp_cont_g, 1);
        this.bfE.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.c(this.bfG, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq(String str) {
        if (this.bfH != null) {
            this.bfH.io(str);
        }
    }
}
