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
    private EditText dbv;
    private TextView dbw;
    private ImageView dbx;
    private InterfaceC0285a dby;
    private View.OnClickListener dbz = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dbw) {
                String a = k.a(a.this.dbv.getText(), null);
                if (!StringUtils.isNULL(a)) {
                    if (a.trim().length() != 0) {
                        a.this.tg(a.trim());
                        a.this.dbw.setClickable(false);
                    } else if (a.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.dbx) {
                a.this.tf("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0285a {
        void te(String str);
    }

    public void gp(boolean z) {
        this.dbw.setClickable(z);
    }

    public void tf(String str) {
        this.dbv.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.dbv = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.dbw = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.dbx = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.dbw.setOnClickListener(this.dbz);
        this.dbx.setOnClickListener(this.dbz);
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
                    a.this.dbx.setVisibility(8);
                } else {
                    a.this.dbx.setVisibility(0);
                }
            }
        };
        this.dbv.addTextChangedListener(this.mTextWatcher);
        iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aEj() {
        this.dbv.removeTextChangedListener(this.mTextWatcher);
    }

    public void aEk() {
        l.b(this.context, this.dbv);
    }

    public void a(InterfaceC0285a interfaceC0285a) {
        this.dby = interfaceC0285a;
    }

    public void iY(int i) {
        am.f(this.dbw, R.color.cp_cont_g, 1);
        this.dbv.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.c(this.dbx, (int) R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(String str) {
        if (this.dby != null) {
            this.dby.te(str);
        }
    }
}
