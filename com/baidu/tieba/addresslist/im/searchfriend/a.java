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
    private EditText dkS;
    private TextView dkT;
    private ImageView dkU;
    private InterfaceC0317a dkV;
    private View.OnClickListener dkW = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dkT) {
                String charSequence2String = k.charSequence2String(a.this.dkS.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.rP(charSequence2String.trim());
                        a.this.dkT.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.dkU) {
                a.this.rO("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0317a {
        void rN(String str);
    }

    public void ge(boolean z) {
        this.dkT.setClickable(z);
    }

    public void rO(String str) {
        this.dkS.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.dkS = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.dkT = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.dkU = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.dkT.setOnClickListener(this.dkW);
        this.dkU.setOnClickListener(this.dkW);
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
                    a.this.dkU.setVisibility(8);
                } else {
                    a.this.dkU.setVisibility(0);
                }
            }
        };
        this.dkS.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aEt() {
        this.dkS.removeTextChangedListener(this.mTextWatcher);
    }

    public void aEu() {
        l.hideSoftKeyPad(this.context, this.dkS);
    }

    public void a(InterfaceC0317a interfaceC0317a) {
        this.dkV = interfaceC0317a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dkT, R.color.cp_cont_g, 1);
        this.dkS.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.dkU, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(String str) {
        if (this.dkV != null) {
            this.dkV.rN(str);
        }
    }
}
