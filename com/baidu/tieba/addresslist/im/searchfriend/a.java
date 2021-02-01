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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private EditText gjL;
    private TextView gjM;
    private ImageView gjN;
    private InterfaceC0596a gjO;
    private View.OnClickListener gjP = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gjM) {
                String charSequence2String = k.charSequence2String(a.this.gjL.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Fd(charSequence2String.trim());
                        a.this.gjM.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.gjN) {
                a.this.Fc("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0596a {
        void Fb(String str);
    }

    public void me(boolean z) {
        this.gjM.setClickable(z);
    }

    public void Fc(String str) {
        this.gjL.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.gjL = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.gjM = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.gjN = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.gjM.setOnClickListener(this.gjP);
        this.gjN.setOnClickListener(this.gjP);
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
                    a.this.gjN.setVisibility(8);
                } else {
                    a.this.gjN.setVisibility(0);
                }
            }
        };
        this.gjL.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bMd() {
        this.gjL.removeTextChangedListener(this.mTextWatcher);
    }

    public void bIW() {
        l.hideSoftKeyPad(this.context, this.gjL);
    }

    public void a(InterfaceC0596a interfaceC0596a) {
        this.gjO = interfaceC0596a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.gjM, R.color.CAM_X0111, 1);
        this.gjL.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setImageResource(this.gjN, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd(String str) {
        if (this.gjO != null) {
            this.gjO.Fb(str);
        }
    }
}
