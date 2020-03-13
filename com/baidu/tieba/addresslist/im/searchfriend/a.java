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
    private EditText ecl;
    private TextView ecm;
    private ImageView ecn;
    private InterfaceC0411a eco;
    private View.OnClickListener ecp = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ecm) {
                String charSequence2String = k.charSequence2String(a.this.ecl.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.xu(charSequence2String.trim());
                        a.this.ecm.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.ecn) {
                a.this.xt("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0411a {
        void xs(String str);
    }

    public void hE(boolean z) {
        this.ecm.setClickable(z);
    }

    public void xt(String str) {
        this.ecl.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ecl = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.ecm = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.ecn = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.ecm.setOnClickListener(this.ecp);
        this.ecn.setOnClickListener(this.ecp);
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
                    a.this.ecn.setVisibility(8);
                } else {
                    a.this.ecn.setVisibility(0);
                }
            }
        };
        this.ecl.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aYW() {
        this.ecl.removeTextChangedListener(this.mTextWatcher);
    }

    public void aYX() {
        l.hideSoftKeyPad(this.context, this.ecl);
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.eco = interfaceC0411a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.ecm, R.color.cp_cont_g, 1);
        this.ecl.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.ecn, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(String str) {
        if (this.eco != null) {
            this.eco.xs(str);
        }
    }
}
