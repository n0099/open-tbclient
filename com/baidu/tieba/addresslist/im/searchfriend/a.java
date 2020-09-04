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
/* loaded from: classes15.dex */
public class a {
    private Context context;
    private EditText fro;
    private TextView frp;
    private ImageView frq;
    private InterfaceC0574a frr;
    private View.OnClickListener frt = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.frp) {
                String charSequence2String = k.charSequence2String(a.this.fro.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.DP(charSequence2String.trim());
                        a.this.frp.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.frq) {
                a.this.DO("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0574a {
        void DN(String str);
    }

    public void kq(boolean z) {
        this.frp.setClickable(z);
    }

    public void DO(String str) {
        this.fro.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fro = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.frp = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.frq = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.frp.setOnClickListener(this.frt);
        this.frq.setOnClickListener(this.frt);
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
                    a.this.frq.setVisibility(8);
                } else {
                    a.this.frq.setVisibility(0);
                }
            }
        };
        this.fro.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bBQ() {
        this.fro.removeTextChangedListener(this.mTextWatcher);
    }

    public void byY() {
        l.hideSoftKeyPad(this.context, this.fro);
    }

    public void a(InterfaceC0574a interfaceC0574a) {
        this.frr = interfaceC0574a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.frp, R.color.cp_cont_g, 1);
        this.fro.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setImageResource(this.frq, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DP(String str) {
        if (this.frr != null) {
            this.frr.DN(str);
        }
    }
}
