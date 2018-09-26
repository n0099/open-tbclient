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
    private EditText bvL;
    private TextView bvM;
    private ImageView bvN;
    private InterfaceC0133a bvO;
    private View.OnClickListener bvP = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bvM) {
                String a = k.a(a.this.bvL.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.jy(a.trim());
                        a.this.bvM.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(e.j.input_content);
                    }
                }
            } else if (view == a.this.bvN) {
                a.this.jx("");
            }
        }
    };
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0133a {
        void jw(String str);
    }

    public void cR(boolean z) {
        this.bvM.setClickable(z);
    }

    public void jx(String str) {
        this.bvL.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bvL = (EditText) view.findViewById(e.g.new_search_friend_input);
        this.bvM = (TextView) view.findViewById(e.g.new_search_friend_search);
        this.bvN = (ImageView) view.findViewById(e.g.new_search_friend_del);
        this.bvM.setOnClickListener(this.bvP);
        this.bvN.setOnClickListener(this.bvP);
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
                    a.this.bvN.setVisibility(8);
                } else {
                    a.this.bvN.setVisibility(0);
                }
            }
        };
        this.bvL.addTextChangedListener(this.mTextWatcher);
        dM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Tx() {
        this.bvL.removeTextChangedListener(this.mTextWatcher);
    }

    public void Ty() {
        l.a(this.context, this.bvL);
    }

    public void a(InterfaceC0133a interfaceC0133a) {
        this.bvO = interfaceC0133a;
    }

    public void dM(int i) {
        al.c(this.bvM, e.d.cp_cont_g, 1);
        this.bvL.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.bvN, e.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(String str) {
        if (this.bvO != null) {
            this.bvO.jw(str);
        }
    }
}
