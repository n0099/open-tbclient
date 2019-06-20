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
    private EditText cYg;
    private TextView cYh;
    private ImageView cYi;
    private InterfaceC0274a cYj;
    private View.OnClickListener cYk = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cYh) {
                String a = k.a(a.this.cYg.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.so(a.trim());
                        a.this.cYh.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.cYi) {
                a.this.sn("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0274a {
        void sm(String str);
    }

    public void gi(boolean z) {
        this.cYh.setClickable(z);
    }

    public void sn(String str) {
        this.cYg.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.cYg = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.cYh = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.cYi = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.cYh.setOnClickListener(this.cYk);
        this.cYi.setOnClickListener(this.cYk);
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
                    a.this.cYi.setVisibility(8);
                } else {
                    a.this.cYi.setVisibility(0);
                }
            }
        };
        this.cYg.addTextChangedListener(this.mTextWatcher);
        iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aCn() {
        this.cYg.removeTextChangedListener(this.mTextWatcher);
    }

    public void aCo() {
        l.b(this.context, this.cYg);
    }

    public void a(InterfaceC0274a interfaceC0274a) {
        this.cYj = interfaceC0274a;
    }

    public void iP(int i) {
        al.f(this.cYh, R.color.cp_cont_g, 1);
        this.cYg.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.c(this.cYi, (int) R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void so(String str) {
        if (this.cYj != null) {
            this.cYj.sm(str);
        }
    }
}
