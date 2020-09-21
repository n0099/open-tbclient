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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class a {
    private Context context;
    private EditText fuB;
    private TextView fuC;
    private ImageView fuD;
    private InterfaceC0570a fuE;
    private View.OnClickListener fuF = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fuC) {
                String charSequence2String = k.charSequence2String(a.this.fuB.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Em(charSequence2String.trim());
                        a.this.fuC.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.fuD) {
                a.this.El("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0570a {
        void Ek(String str);
    }

    public void kr(boolean z) {
        this.fuC.setClickable(z);
    }

    public void El(String str) {
        this.fuB.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fuB = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.fuC = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.fuD = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.fuC.setOnClickListener(this.fuF);
        this.fuD.setOnClickListener(this.fuF);
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
                    a.this.fuD.setVisibility(8);
                } else {
                    a.this.fuD.setVisibility(0);
                }
            }
        };
        this.fuB.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bDc() {
        this.fuB.removeTextChangedListener(this.mTextWatcher);
    }

    public void bAh() {
        l.hideSoftKeyPad(this.context, this.fuB);
    }

    public void a(InterfaceC0570a interfaceC0570a) {
        this.fuE = interfaceC0570a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fuC, R.color.cp_cont_g, 1);
        this.fuB.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setImageResource(this.fuD, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Em(String str) {
        if (this.fuE != null) {
            this.fuE.Ek(str);
        }
    }
}
