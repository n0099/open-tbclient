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
    private EditText gjZ;
    private TextView gka;
    private ImageView gkb;
    private InterfaceC0597a gkc;
    private View.OnClickListener gkd = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gka) {
                String charSequence2String = k.charSequence2String(a.this.gjZ.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Fe(charSequence2String.trim());
                        a.this.gka.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.gkb) {
                a.this.Fd("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0597a {
        void Fc(String str);
    }

    public void me(boolean z) {
        this.gka.setClickable(z);
    }

    public void Fd(String str) {
        this.gjZ.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.gjZ = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.gka = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.gkb = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.gka.setOnClickListener(this.gkd);
        this.gkb.setOnClickListener(this.gkd);
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
                    a.this.gkb.setVisibility(8);
                } else {
                    a.this.gkb.setVisibility(0);
                }
            }
        };
        this.gjZ.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bMk() {
        this.gjZ.removeTextChangedListener(this.mTextWatcher);
    }

    public void bIW() {
        l.hideSoftKeyPad(this.context, this.gjZ);
    }

    public void a(InterfaceC0597a interfaceC0597a) {
        this.gkc = interfaceC0597a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.gka, R.color.CAM_X0111, 1);
        this.gjZ.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setImageResource(this.gkb, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fe(String str) {
        if (this.gkc != null) {
            this.gkc.Fc(str);
        }
    }
}
