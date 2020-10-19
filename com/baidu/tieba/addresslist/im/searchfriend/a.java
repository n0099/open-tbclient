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
/* loaded from: classes21.dex */
public class a {
    private Context context;
    private EditText fGK;
    private TextView fGL;
    private ImageView fGM;
    private InterfaceC0587a fGN;
    private View.OnClickListener fGO = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fGL) {
                String charSequence2String = k.charSequence2String(a.this.fGK.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.EX(charSequence2String.trim());
                        a.this.fGL.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.fGM) {
                a.this.EW("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0587a {
        void EV(String str);
    }

    public void kP(boolean z) {
        this.fGL.setClickable(z);
    }

    public void EW(String str) {
        this.fGK.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fGK = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.fGL = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.fGM = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.fGL.setOnClickListener(this.fGO);
        this.fGM.setOnClickListener(this.fGO);
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
                    a.this.fGM.setVisibility(8);
                } else {
                    a.this.fGM.setVisibility(0);
                }
            }
        };
        this.fGK.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bFO() {
        this.fGK.removeTextChangedListener(this.mTextWatcher);
    }

    public void bCR() {
        l.hideSoftKeyPad(this.context, this.fGK);
    }

    public void a(InterfaceC0587a interfaceC0587a) {
        this.fGN = interfaceC0587a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fGL, R.color.cp_cont_g, 1);
        this.fGK.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setImageResource(this.fGM, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EX(String str) {
        if (this.fGN != null) {
            this.fGN.EV(str);
        }
    }
}
