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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener bMV = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.bVI) {
                String a = k.a(a.this.bVH.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.iu(a.trim());
                        a.this.bVI.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(d.j.input_content);
                    }
                }
            } else if (view == a.this.bVJ) {
                a.this.it("");
            }
        }
    };
    private EditText bVH;
    private TextView bVI;
    private ImageView bVJ;
    private InterfaceC0130a bVK;
    private Context context;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0130a {
        void is(String str);
    }

    public void cZ(boolean z) {
        this.bVI.setClickable(z);
    }

    public void it(String str) {
        this.bVH.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bVH = (EditText) view.findViewById(d.g.new_search_friend_input);
        this.bVI = (TextView) view.findViewById(d.g.new_search_friend_search);
        this.bVJ = (ImageView) view.findViewById(d.g.new_search_friend_del);
        this.bVI.setOnClickListener(this.bMV);
        this.bVJ.setOnClickListener(this.bMV);
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
                    a.this.bVJ.setVisibility(8);
                } else {
                    a.this.bVJ.setVisibility(0);
                }
            }
        };
        this.bVH.addTextChangedListener(this.mTextWatcher);
        gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Vc() {
        this.bVH.removeTextChangedListener(this.mTextWatcher);
    }

    public void Vd() {
        l.a(this.context, this.bVH);
    }

    public void a(InterfaceC0130a interfaceC0130a) {
        this.bVK = interfaceC0130a;
    }

    public void gx(int i) {
        aj.e(this.bVI, d.C0140d.cp_cont_g, 1);
        this.bVH.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        aj.c(this.bVJ, d.f.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(String str) {
        if (this.bVK != null) {
            this.bVK.is(str);
        }
    }
}
