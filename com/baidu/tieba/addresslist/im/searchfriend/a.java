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
    private EditText eCo;
    private TextView eCp;
    private ImageView eCq;
    private InterfaceC0442a eCr;
    private View.OnClickListener eCs = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eCp) {
                String charSequence2String = k.charSequence2String(a.this.eCo.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.yH(charSequence2String.trim());
                        a.this.eCp.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.eCq) {
                a.this.yG("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0442a {
        void yF(String str);
    }

    public void iD(boolean z) {
        this.eCp.setClickable(z);
    }

    public void yG(String str) {
        this.eCo.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.eCo = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.eCp = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.eCq = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.eCp.setOnClickListener(this.eCs);
        this.eCq.setOnClickListener(this.eCs);
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
                    a.this.eCq.setVisibility(8);
                } else {
                    a.this.eCq.setVisibility(0);
                }
            }
        };
        this.eCo.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bhe() {
        this.eCo.removeTextChangedListener(this.mTextWatcher);
    }

    public void bhf() {
        l.hideSoftKeyPad(this.context, this.eCo);
    }

    public void a(InterfaceC0442a interfaceC0442a) {
        this.eCr = interfaceC0442a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.eCp, R.color.cp_cont_g, 1);
        this.eCo.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.eCq, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(String str) {
        if (this.eCr != null) {
            this.eCr.yF(str);
        }
    }
}
