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
/* loaded from: classes7.dex */
public class a {
    private Context context;
    private EditText glC;
    private TextView glD;
    private ImageView glE;
    private InterfaceC0603a glF;
    private View.OnClickListener glG = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.glD) {
                String charSequence2String = k.charSequence2String(a.this.glC.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Fl(charSequence2String.trim());
                        a.this.glD.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.glE) {
                a.this.Fk("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0603a {
        void Fj(String str);
    }

    public void me(boolean z) {
        this.glD.setClickable(z);
    }

    public void Fk(String str) {
        this.glC.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.glC = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.glD = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.glE = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.glD.setOnClickListener(this.glG);
        this.glE.setOnClickListener(this.glG);
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
                    a.this.glE.setVisibility(8);
                } else {
                    a.this.glE.setVisibility(0);
                }
            }
        };
        this.glC.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bMo() {
        this.glC.removeTextChangedListener(this.mTextWatcher);
    }

    public void bJa() {
        l.hideSoftKeyPad(this.context, this.glC);
    }

    public void a(InterfaceC0603a interfaceC0603a) {
        this.glF = interfaceC0603a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.glD, R.color.CAM_X0111, 1);
        this.glC.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setImageResource(this.glE, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fl(String str) {
        if (this.glF != null) {
            this.glF.Fj(str);
        }
    }
}
