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
/* loaded from: classes21.dex */
public class a {
    private Context context;
    private EditText fPf;
    private TextView fPg;
    private ImageView fPh;
    private InterfaceC0601a fPi;
    private View.OnClickListener fPj = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fPg) {
                String charSequence2String = k.charSequence2String(a.this.fPf.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Fq(charSequence2String.trim());
                        a.this.fPg.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.fPh) {
                a.this.Fp("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0601a {
        void Fo(String str);
    }

    public void lc(boolean z) {
        this.fPg.setClickable(z);
    }

    public void Fp(String str) {
        this.fPf.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fPf = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.fPg = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.fPh = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.fPg.setOnClickListener(this.fPj);
        this.fPh.setOnClickListener(this.fPj);
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
                    a.this.fPh.setVisibility(8);
                } else {
                    a.this.fPh.setVisibility(0);
                }
            }
        };
        this.fPf.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bHH() {
        this.fPf.removeTextChangedListener(this.mTextWatcher);
    }

    public void bEK() {
        l.hideSoftKeyPad(this.context, this.fPf);
    }

    public void a(InterfaceC0601a interfaceC0601a) {
        this.fPi = interfaceC0601a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fPg, R.color.cp_cont_g, 1);
        this.fPf.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setImageResource(this.fPh, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq(String str) {
        if (this.fPi != null) {
            this.fPi.Fo(str);
        }
    }
}
