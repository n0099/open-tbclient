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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener bML = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bVz) {
                String a = k.a(a.this.bVy.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iu(a.trim());
                        a.this.bVz.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.j.input_content);
                    }
                }
            } else if (view == a.this.bVA) {
                a.this.it("");
            }
        }
    };
    private ImageView bVA;
    private InterfaceC0131a bVB;
    private EditText bVy;
    private TextView bVz;
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0131a {
        void is(String str);
    }

    public void cZ(boolean z) {
        this.bVz.setClickable(z);
    }

    public void it(String str) {
        this.bVy.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bVy = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.bVz = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.bVA = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.bVz.setOnClickListener(this.bML);
        this.bVA.setOnClickListener(this.bML);
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
                    a.this.bVA.setVisibility(8);
                } else {
                    a.this.bVA.setVisibility(0);
                }
            }
        };
        this.bVy.addTextChangedListener(this.mTextWatcher);
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Vc() {
        this.bVy.removeTextChangedListener(this.mTextWatcher);
    }

    public void Vd() {
        l.a(this.context, this.bVy);
    }

    public void a(InterfaceC0131a interfaceC0131a) {
        this.bVB = interfaceC0131a;
    }

    public void gx(int i) {
        aj.e(this.bVz, d.C0141d.cp_cont_g, 1);
        this.bVy.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.c(this.bVA, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(String str) {
        if (this.bVB != null) {
            this.bVB.is(str);
        }
    }
}
