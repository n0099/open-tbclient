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
/* loaded from: classes8.dex */
public class a {
    private Context context;
    private EditText gmf;
    private TextView gmg;
    private ImageView gmh;
    private InterfaceC0616a gmi;
    private View.OnClickListener gmj = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gmg) {
                String charSequence2String = k.charSequence2String(a.this.gmf.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.FQ(charSequence2String.trim());
                        a.this.gmg.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.gmh) {
                a.this.FP("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0616a {
        void FO(String str);
    }

    public void me(boolean z) {
        this.gmg.setClickable(z);
    }

    public void FP(String str) {
        this.gmf.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.gmf = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.gmg = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.gmh = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.gmg.setOnClickListener(this.gmj);
        this.gmh.setOnClickListener(this.gmj);
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
                    a.this.gmh.setVisibility(8);
                } else {
                    a.this.gmh.setVisibility(0);
                }
            }
        };
        this.gmf.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bPB() {
        this.gmf.removeTextChangedListener(this.mTextWatcher);
    }

    public void bMv() {
        l.hideSoftKeyPad(this.context, this.gmf);
    }

    public void a(InterfaceC0616a interfaceC0616a) {
        this.gmi = interfaceC0616a;
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.gmg, R.color.CAM_X0111, 1);
        this.gmf.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setImageResource(this.gmh, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(String str) {
        if (this.gmi != null) {
            this.gmi.FO(str);
        }
    }
}
