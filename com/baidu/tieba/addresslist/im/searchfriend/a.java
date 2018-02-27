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
    private View.OnClickListener bMI = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bVw) {
                String a = k.a(a.this.bVv.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iu(a.trim());
                        a.this.bVw.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.j.input_content);
                    }
                }
            } else if (view == a.this.bVx) {
                a.this.it("");
            }
        }
    };
    private EditText bVv;
    private TextView bVw;
    private ImageView bVx;
    private InterfaceC0131a bVy;
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0131a {
        void is(String str);
    }

    public void cZ(boolean z) {
        this.bVw.setClickable(z);
    }

    public void it(String str) {
        this.bVv.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bVv = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.bVw = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.bVx = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.bVw.setOnClickListener(this.bMI);
        this.bVx.setOnClickListener(this.bMI);
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
                    a.this.bVx.setVisibility(8);
                } else {
                    a.this.bVx.setVisibility(0);
                }
            }
        };
        this.bVv.addTextChangedListener(this.mTextWatcher);
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Vb() {
        this.bVv.removeTextChangedListener(this.mTextWatcher);
    }

    public void Vc() {
        l.a(this.context, this.bVv);
    }

    public void a(InterfaceC0131a interfaceC0131a) {
        this.bVy = interfaceC0131a;
    }

    public void gx(int i) {
        aj.e(this.bVw, d.C0141d.cp_cont_g, 1);
        this.bVv.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.c(this.bVx, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(String str) {
        if (this.bVy != null) {
            this.bVy.is(str);
        }
    }
}
