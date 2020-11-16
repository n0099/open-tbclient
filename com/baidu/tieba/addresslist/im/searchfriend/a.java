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
/* loaded from: classes20.dex */
public class a {
    private Context context;
    private EditText fUC;
    private TextView fUD;
    private ImageView fUE;
    private InterfaceC0613a fUF;
    private View.OnClickListener fUG = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fUD) {
                String charSequence2String = k.charSequence2String(a.this.fUC.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.Ff(charSequence2String.trim());
                        a.this.fUD.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.fUE) {
                a.this.Fe("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0613a {
        void Fd(String str);
    }

    public void lm(boolean z) {
        this.fUD.setClickable(z);
    }

    public void Fe(String str) {
        this.fUC.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fUC = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.fUD = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.fUE = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.fUD.setOnClickListener(this.fUG);
        this.fUE.setOnClickListener(this.fUG);
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
                    a.this.fUE.setVisibility(8);
                } else {
                    a.this.fUE.setVisibility(0);
                }
            }
        };
        this.fUC.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bJz() {
        this.fUC.removeTextChangedListener(this.mTextWatcher);
    }

    public void bGC() {
        l.hideSoftKeyPad(this.context, this.fUC);
    }

    public void a(InterfaceC0613a interfaceC0613a) {
        this.fUF = interfaceC0613a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fUD, R.color.CAM_X0111, 1);
        this.fUC.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setImageResource(this.fUE, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ff(String str) {
        if (this.fUF != null) {
            this.fUF.Fd(str);
        }
    }
}
