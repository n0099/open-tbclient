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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private EditText cYe;
    private TextView cYf;
    private ImageView cYg;
    private InterfaceC0274a cYh;
    private View.OnClickListener cYi = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cYf) {
                String a = k.a(a.this.cYe.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.sp(a.trim());
                        a.this.cYf.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.cYg) {
                a.this.so("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0274a {
        void sn(String str);
    }

    public void gi(boolean z) {
        this.cYf.setClickable(z);
    }

    public void so(String str) {
        this.cYe.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.cYe = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.cYf = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.cYg = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.cYf.setOnClickListener(this.cYi);
        this.cYg.setOnClickListener(this.cYi);
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
                    a.this.cYg.setVisibility(8);
                } else {
                    a.this.cYg.setVisibility(0);
                }
            }
        };
        this.cYe.addTextChangedListener(this.mTextWatcher);
        iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aCk() {
        this.cYe.removeTextChangedListener(this.mTextWatcher);
    }

    public void aCl() {
        l.b(this.context, this.cYe);
    }

    public void a(InterfaceC0274a interfaceC0274a) {
        this.cYh = interfaceC0274a;
    }

    public void iP(int i) {
        al.f(this.cYf, R.color.cp_cont_g, 1);
        this.cYe.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.c(this.cYg, (int) R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp(String str) {
        if (this.cYh != null) {
            this.cYh.sn(str);
        }
    }
}
