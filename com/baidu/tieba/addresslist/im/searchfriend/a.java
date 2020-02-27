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
    private EditText ebX;
    private TextView ebY;
    private ImageView ebZ;
    private InterfaceC0411a eca;
    private View.OnClickListener ecb = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ebY) {
                String charSequence2String = k.charSequence2String(a.this.ebX.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.xt(charSequence2String.trim());
                        a.this.ebY.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.ebZ) {
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
        this.ebY.setClickable(z);
    }

    public void xs(String str) {
        this.ebX.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ebX = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.ebY = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.ebZ = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.ebY.setOnClickListener(this.ecb);
        this.ebZ.setOnClickListener(this.ecb);
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
                    a.this.ebZ.setVisibility(8);
                } else {
                    a.this.ebZ.setVisibility(0);
                }
            }
        };
        this.ebX.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aYT() {
        this.ebX.removeTextChangedListener(this.mTextWatcher);
    }

    public void aYU() {
        l.hideSoftKeyPad(this.context, this.ebX);
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.eca = interfaceC0411a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.ebY, R.color.cp_cont_g, 1);
        this.ebX.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.ebZ, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(String str) {
        if (this.eca != null) {
            this.eca.xr(str);
        }
    }
}
