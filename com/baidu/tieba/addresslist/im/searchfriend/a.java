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
    private EditText cZJ;
    private TextView cZK;
    private ImageView cZL;
    private InterfaceC0276a cZM;
    private View.OnClickListener cZN = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cZK) {
                String a = k.a(a.this.cZJ.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.sH(a.trim());
                        a.this.cZK.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.cZL) {
                a.this.sG("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0276a {
        void sF(String str);
    }

    public void gm(boolean z) {
        this.cZK.setClickable(z);
    }

    public void sG(String str) {
        this.cZJ.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.cZJ = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.cZK = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.cZL = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.cZK.setOnClickListener(this.cZN);
        this.cZL.setOnClickListener(this.cZN);
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
                    a.this.cZL.setVisibility(8);
                } else {
                    a.this.cZL.setVisibility(0);
                }
            }
        };
        this.cZJ.addTextChangedListener(this.mTextWatcher);
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aDF() {
        this.cZJ.removeTextChangedListener(this.mTextWatcher);
    }

    public void aDG() {
        l.b(this.context, this.cZJ);
    }

    public void a(InterfaceC0276a interfaceC0276a) {
        this.cZM = interfaceC0276a;
    }

    public void iV(int i) {
        am.f(this.cZK, R.color.cp_cont_g, 1);
        this.cZJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.c(this.cZL, (int) R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(String str) {
        if (this.cZM != null) {
            this.cZM.sF(str);
        }
    }
}
