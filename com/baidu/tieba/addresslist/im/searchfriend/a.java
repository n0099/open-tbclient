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
/* loaded from: classes5.dex */
public class a {
    private Context context;
    private EditText dXK;
    private TextView dXL;
    private ImageView dXM;
    private InterfaceC0398a dXN;
    private View.OnClickListener dXO = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dXL) {
                String charSequence2String = k.charSequence2String(a.this.dXK.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.wV(charSequence2String.trim());
                        a.this.dXL.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.dXM) {
                a.this.wU("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0398a {
        void wT(String str);
    }

    public void hs(boolean z) {
        this.dXL.setClickable(z);
    }

    public void wU(String str) {
        this.dXK.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.dXK = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.dXL = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.dXM = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.dXL.setOnClickListener(this.dXO);
        this.dXM.setOnClickListener(this.dXO);
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
                    a.this.dXM.setVisibility(8);
                } else {
                    a.this.dXM.setVisibility(0);
                }
            }
        };
        this.dXK.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aWk() {
        this.dXK.removeTextChangedListener(this.mTextWatcher);
    }

    public void aWl() {
        l.hideSoftKeyPad(this.context, this.dXK);
    }

    public void a(InterfaceC0398a interfaceC0398a) {
        this.dXN = interfaceC0398a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dXL, R.color.cp_cont_g, 1);
        this.dXK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.dXM, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(String str) {
        if (this.dXN != null) {
            this.dXN.wT(str);
        }
    }
}
