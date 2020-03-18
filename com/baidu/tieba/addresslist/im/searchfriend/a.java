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
    private EditText ecB;
    private TextView ecC;
    private ImageView ecD;
    private InterfaceC0411a ecE;
    private View.OnClickListener ecF = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ecC) {
                String charSequence2String = k.charSequence2String(a.this.ecB.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.xu(charSequence2String.trim());
                        a.this.ecC.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.ecD) {
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

    public void hF(boolean z) {
        this.ecC.setClickable(z);
    }

    public void xt(String str) {
        this.ecB.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ecB = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.ecC = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.ecD = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.ecC.setOnClickListener(this.ecF);
        this.ecD.setOnClickListener(this.ecF);
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
                    a.this.ecD.setVisibility(8);
                } else {
                    a.this.ecD.setVisibility(0);
                }
            }
        };
        this.ecB.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aZa() {
        this.ecB.removeTextChangedListener(this.mTextWatcher);
    }

    public void aZb() {
        l.hideSoftKeyPad(this.context, this.ecB);
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.ecE = interfaceC0411a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.ecC, R.color.cp_cont_g, 1);
        this.ecB.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.ecD, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(String str) {
        if (this.ecE != null) {
            this.ecE.xs(str);
        }
    }
}
