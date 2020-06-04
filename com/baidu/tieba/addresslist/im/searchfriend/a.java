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
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private EditText eRd;
    private TextView eRe;
    private ImageView eRf;
    private InterfaceC0510a eRg;
    private View.OnClickListener eRh = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eRe) {
                String charSequence2String = k.charSequence2String(a.this.eRd.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Aq(charSequence2String.trim());
                        a.this.eRe.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.eRf) {
                a.this.Ap("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0510a {
        void Ao(String str);
    }

    public void ja(boolean z) {
        this.eRe.setClickable(z);
    }

    public void Ap(String str) {
        this.eRd.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.eRd = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.eRe = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.eRf = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.eRe.setOnClickListener(this.eRh);
        this.eRf.setOnClickListener(this.eRh);
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
                    a.this.eRf.setVisibility(8);
                } else {
                    a.this.eRf.setVisibility(0);
                }
            }
        };
        this.eRd.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bnp() {
        this.eRd.removeTextChangedListener(this.mTextWatcher);
    }

    public void bnq() {
        l.hideSoftKeyPad(this.context, this.eRd);
    }

    public void a(InterfaceC0510a interfaceC0510a) {
        this.eRg = interfaceC0510a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.eRe, R.color.cp_cont_g, 1);
        this.eRd.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.eRf, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(String str) {
        if (this.eRg != null) {
            this.eRg.Ao(str);
        }
    }
}
