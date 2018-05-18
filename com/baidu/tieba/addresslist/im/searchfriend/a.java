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
    private EditText bfF;
    private TextView bfG;
    private ImageView bfH;
    private InterfaceC0118a bfI;
    private View.OnClickListener bfJ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == a.this.bfG) {
                String a = k.a(a.this.bfF.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.ir(a.trim());
                        a.this.bfG.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.k.input_content);
                    }
                }
            } else if (view2 == a.this.bfH) {
                a.this.iq("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0118a {
        void ip(String str);
    }

    public void cq(boolean z) {
        this.bfG.setClickable(z);
    }

    public void iq(String str) {
        this.bfF.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view2) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bfF = (EditText) view2.findViewById(d.g.new_search_friend_input);
        this.bfG = (TextView) view2.findViewById(d.g.new_search_friend_search);
        this.bfH = (ImageView) view2.findViewById(d.g.new_search_friend_del);
        this.bfG.setOnClickListener(this.bfJ);
        this.bfH.setOnClickListener(this.bfJ);
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
                    a.this.bfH.setVisibility(8);
                } else {
                    a.this.bfH.setVisibility(0);
                }
            }
        };
        this.bfF.addTextChangedListener(this.mTextWatcher);
        dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void NB() {
        this.bfF.removeTextChangedListener(this.mTextWatcher);
    }

    public void NC() {
        l.b(this.context, this.bfF);
    }

    public void a(InterfaceC0118a interfaceC0118a) {
        this.bfI = interfaceC0118a;
    }

    public void dw(int i) {
        ak.c(this.bfG, d.C0126d.cp_cont_g, 1);
        this.bfF.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.c(this.bfH, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(String str) {
        if (this.bfI != null) {
            this.bfI.ip(str);
        }
    }
}
