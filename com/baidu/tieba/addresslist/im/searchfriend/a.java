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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private EditText fbo;
    private TextView fbp;
    private ImageView fbq;
    private InterfaceC0518a fbr;
    private View.OnClickListener fbs = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fbp) {
                String charSequence2String = k.charSequence2String(a.this.fbo.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.AJ(charSequence2String.trim());
                        a.this.fbp.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.fbq) {
                a.this.AI("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0518a {
        void AH(String str);
    }

    public void jm(boolean z) {
        this.fbp.setClickable(z);
    }

    public void AI(String str) {
        this.fbo.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fbo = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.fbp = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.fbq = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.fbp.setOnClickListener(this.fbs);
        this.fbq.setOnClickListener(this.fbs);
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
                    a.this.fbq.setVisibility(8);
                } else {
                    a.this.fbq.setVisibility(0);
                }
            }
        };
        this.fbo.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bpP() {
        this.fbo.removeTextChangedListener(this.mTextWatcher);
    }

    public void bpQ() {
        l.hideSoftKeyPad(this.context, this.fbo);
    }

    public void a(InterfaceC0518a interfaceC0518a) {
        this.fbr = interfaceC0518a;
    }

    public void changeSkin(int i) {
        an.setViewTextColor(this.fbp, R.color.cp_cont_g, 1);
        this.fbo.setHintTextColor(an.getColor(R.color.cp_cont_e));
        an.setImageResource(this.fbq, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(String str) {
        if (this.fbr != null) {
            this.fbr.AH(str);
        }
    }
}
