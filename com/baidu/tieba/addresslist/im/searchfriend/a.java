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
    private EditText ebY;
    private TextView ebZ;
    private ImageView eca;
    private InterfaceC0411a ecb;
    private View.OnClickListener ecc = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ebZ) {
                String charSequence2String = k.charSequence2String(a.this.ebY.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.xt(charSequence2String.trim());
                        a.this.ebZ.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.eca) {
                a.this.xs("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0411a {
        void xr(String str);
    }

    public void hE(boolean z) {
        this.ebZ.setClickable(z);
    }

    public void xs(String str) {
        this.ebY.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ebY = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.ebZ = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.eca = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.ebZ.setOnClickListener(this.ecc);
        this.eca.setOnClickListener(this.ecc);
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
                    a.this.eca.setVisibility(8);
                } else {
                    a.this.eca.setVisibility(0);
                }
            }
        };
        this.ebY.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aYV() {
        this.ebY.removeTextChangedListener(this.mTextWatcher);
    }

    public void aYW() {
        l.hideSoftKeyPad(this.context, this.ebY);
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.ecb = interfaceC0411a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.ebZ, R.color.cp_cont_g, 1);
        this.ebY.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.eca, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(String str) {
        if (this.ecb != null) {
            this.ecb.xr(str);
        }
    }
}
