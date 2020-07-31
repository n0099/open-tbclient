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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a {
    private Context context;
    private EditText ffQ;
    private TextView ffR;
    private ImageView ffS;
    private InterfaceC0528a ffT;
    private View.OnClickListener ffU = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ffR) {
                String charSequence2String = k.charSequence2String(a.this.ffQ.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Bu(charSequence2String.trim());
                        a.this.ffR.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.ffS) {
                a.this.Bt("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0528a {
        void Bs(String str);
    }

    public void jQ(boolean z) {
        this.ffR.setClickable(z);
    }

    public void Bt(String str) {
        this.ffQ.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ffQ = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.ffR = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.ffS = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.ffR.setOnClickListener(this.ffU);
        this.ffS.setOnClickListener(this.ffU);
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
                    a.this.ffS.setVisibility(8);
                } else {
                    a.this.ffS.setVisibility(0);
                }
            }
        };
        this.ffQ.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bsS() {
        this.ffQ.removeTextChangedListener(this.mTextWatcher);
    }

    public void bsT() {
        l.hideSoftKeyPad(this.context, this.ffQ);
    }

    public void a(InterfaceC0528a interfaceC0528a) {
        this.ffT = interfaceC0528a;
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.ffR, R.color.cp_cont_g, 1);
        this.ffQ.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        ao.setImageResource(this.ffS, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(String str) {
        if (this.ffT != null) {
            this.ffT.Bs(str);
        }
    }
}
