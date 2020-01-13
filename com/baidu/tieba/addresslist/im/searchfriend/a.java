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
/* loaded from: classes6.dex */
public class a {
    private Context context;
    private EditText dXT;
    private TextView dXU;
    private ImageView dXV;
    private InterfaceC0400a dXW;
    private View.OnClickListener dXX = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dXU) {
                String charSequence2String = k.charSequence2String(a.this.dXT.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.wZ(charSequence2String.trim());
                        a.this.dXU.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.dXV) {
                a.this.wY("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0400a {
        void wX(String str);
    }

    public void hx(boolean z) {
        this.dXU.setClickable(z);
    }

    public void wY(String str) {
        this.dXT.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.dXT = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.dXU = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.dXV = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.dXU.setOnClickListener(this.dXX);
        this.dXV.setOnClickListener(this.dXX);
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
                    a.this.dXV.setVisibility(8);
                } else {
                    a.this.dXV.setVisibility(0);
                }
            }
        };
        this.dXT.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aWE() {
        this.dXT.removeTextChangedListener(this.mTextWatcher);
    }

    public void aWF() {
        l.hideSoftKeyPad(this.context, this.dXT);
    }

    public void a(InterfaceC0400a interfaceC0400a) {
        this.dXW = interfaceC0400a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dXU, R.color.cp_cont_g, 1);
        this.dXT.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.dXV, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(String str) {
        if (this.dXW != null) {
            this.dXW.wX(str);
        }
    }
}
