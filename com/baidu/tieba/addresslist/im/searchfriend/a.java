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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private EditText bDY;
    private TextView bDZ;
    private ImageView bEa;
    private InterfaceC0191a bEb;
    private View.OnClickListener bEc = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bDZ) {
                String a = k.a(a.this.bDY.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.kg(a.trim());
                        a.this.bDZ.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(e.j.input_content);
                    }
                }
            } else if (view == a.this.bEa) {
                a.this.kf("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0191a {
        void ke(String str);
    }

    public void ds(boolean z) {
        this.bDZ.setClickable(z);
    }

    public void kf(String str) {
        this.bDY.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bDY = (EditText) view.findViewById(e.g.new_search_friend_input);
        this.bDZ = (TextView) view.findViewById(e.g.new_search_friend_search);
        this.bEa = (ImageView) view.findViewById(e.g.new_search_friend_del);
        this.bDZ.setOnClickListener(this.bEc);
        this.bEa.setOnClickListener(this.bEc);
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
                    a.this.bEa.setVisibility(8);
                } else {
                    a.this.bEa.setVisibility(0);
                }
            }
        };
        this.bDY.addTextChangedListener(this.mTextWatcher);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void WK() {
        this.bDY.removeTextChangedListener(this.mTextWatcher);
    }

    public void WL() {
        l.b(this.context, this.bDY);
    }

    public void a(InterfaceC0191a interfaceC0191a) {
        this.bEb = interfaceC0191a;
    }

    public void ey(int i) {
        al.c(this.bDZ, e.d.cp_cont_g, 1);
        this.bDY.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.bEa, e.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(String str) {
        if (this.bEb != null) {
            this.bEb.ke(str);
        }
    }
}
