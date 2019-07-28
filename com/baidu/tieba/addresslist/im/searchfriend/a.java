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
    private EditText cZC;
    private TextView cZD;
    private ImageView cZE;
    private InterfaceC0276a cZF;
    private View.OnClickListener cZG = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cZD) {
                String a = k.a(a.this.cZC.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.sH(a.trim());
                        a.this.cZD.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.cZE) {
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
        this.cZD.setClickable(z);
    }

    public void sG(String str) {
        this.cZC.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.cZC = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.cZD = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.cZE = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.cZD.setOnClickListener(this.cZG);
        this.cZE.setOnClickListener(this.cZG);
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
                    a.this.cZE.setVisibility(8);
                } else {
                    a.this.cZE.setVisibility(0);
                }
            }
        };
        this.cZC.addTextChangedListener(this.mTextWatcher);
        iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aDD() {
        this.cZC.removeTextChangedListener(this.mTextWatcher);
    }

    public void aDE() {
        l.b(this.context, this.cZC);
    }

    public void a(InterfaceC0276a interfaceC0276a) {
        this.cZF = interfaceC0276a;
    }

    public void iV(int i) {
        am.f(this.cZD, R.color.cp_cont_g, 1);
        this.cZC.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.c(this.cZE, (int) R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(String str) {
        if (this.cZF != null) {
            this.cZF.sF(str);
        }
    }
}
