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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a {
    private EditText bpV;
    private TextView bpW;
    private ImageView bpX;
    private InterfaceC0133a bpY;
    private View.OnClickListener bpZ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bpW) {
                String a = k.a(a.this.bpV.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iW(a.trim());
                        a.this.bpW.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(f.j.input_content);
                    }
                }
            } else if (view == a.this.bpX) {
                a.this.iV("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0133a {
        void iU(String str);
    }

    public void cA(boolean z) {
        this.bpW.setClickable(z);
    }

    public void iV(String str) {
        this.bpV.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bpV = (EditText) view.findViewById(f.g.new_search_friend_input);
        this.bpW = (TextView) view.findViewById(f.g.new_search_friend_search);
        this.bpX = (ImageView) view.findViewById(f.g.new_search_friend_del);
        this.bpW.setOnClickListener(this.bpZ);
        this.bpX.setOnClickListener(this.bpZ);
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
                    a.this.bpX.setVisibility(8);
                } else {
                    a.this.bpX.setVisibility(0);
                }
            }
        };
        this.bpV.addTextChangedListener(this.mTextWatcher);
        dB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void RJ() {
        this.bpV.removeTextChangedListener(this.mTextWatcher);
    }

    public void RK() {
        l.a(this.context, this.bpV);
    }

    public void a(InterfaceC0133a interfaceC0133a) {
        this.bpY = interfaceC0133a;
    }

    public void dB(int i) {
        am.c(this.bpW, f.d.cp_cont_g, 1);
        this.bpV.setHintTextColor(am.getColor(f.d.cp_cont_e));
        am.c(this.bpX, f.C0146f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW(String str) {
        if (this.bpY != null) {
            this.bpY.iU(str);
        }
    }
}
