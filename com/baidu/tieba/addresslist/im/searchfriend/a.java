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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private Context context;
    private EditText dkb;
    private TextView dkc;
    private ImageView dkd;
    private InterfaceC0312a dke;
    private View.OnClickListener dkf = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dkc) {
                String charSequence2String = k.charSequence2String(a.this.dkb.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.rP(charSequence2String.trim());
                        a.this.dkc.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.dkd) {
                a.this.rO("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0312a {
        void rN(String str);
    }

    public void ge(boolean z) {
        this.dkc.setClickable(z);
    }

    public void rO(String str) {
        this.dkb.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.dkb = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.dkc = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.dkd = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.dkc.setOnClickListener(this.dkf);
        this.dkd.setOnClickListener(this.dkf);
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
                    a.this.dkd.setVisibility(8);
                } else {
                    a.this.dkd.setVisibility(0);
                }
            }
        };
        this.dkb.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aEr() {
        this.dkb.removeTextChangedListener(this.mTextWatcher);
    }

    public void aEs() {
        l.hideSoftKeyPad(this.context, this.dkb);
    }

    public void a(InterfaceC0312a interfaceC0312a) {
        this.dke = interfaceC0312a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dkc, R.color.cp_cont_g, 1);
        this.dkb.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.dkd, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(String str) {
        if (this.dke != null) {
            this.dke.rN(str);
        }
    }
}
