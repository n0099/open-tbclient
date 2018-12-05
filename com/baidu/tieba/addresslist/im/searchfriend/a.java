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
    private EditText bDV;
    private TextView bDW;
    private ImageView bDX;
    private InterfaceC0191a bDY;
    private View.OnClickListener bDZ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bDW) {
                String a = k.a(a.this.bDV.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.kf(a.trim());
                        a.this.bDW.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(e.j.input_content);
                    }
                }
            } else if (view == a.this.bDX) {
                a.this.ke("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0191a {
        void kd(String str);
    }

    public void ds(boolean z) {
        this.bDW.setClickable(z);
    }

    public void ke(String str) {
        this.bDV.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bDV = (EditText) view.findViewById(e.g.new_search_friend_input);
        this.bDW = (TextView) view.findViewById(e.g.new_search_friend_search);
        this.bDX = (ImageView) view.findViewById(e.g.new_search_friend_del);
        this.bDW.setOnClickListener(this.bDZ);
        this.bDX.setOnClickListener(this.bDZ);
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
                    a.this.bDX.setVisibility(8);
                } else {
                    a.this.bDX.setVisibility(0);
                }
            }
        };
        this.bDV.addTextChangedListener(this.mTextWatcher);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void WI() {
        this.bDV.removeTextChangedListener(this.mTextWatcher);
    }

    public void WJ() {
        l.b(this.context, this.bDV);
    }

    public void a(InterfaceC0191a interfaceC0191a) {
        this.bDY = interfaceC0191a;
    }

    public void ey(int i) {
        al.c(this.bDW, e.d.cp_cont_g, 1);
        this.bDV.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.bDX, e.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(String str) {
        if (this.bDY != null) {
            this.bDY.kd(str);
        }
    }
}
