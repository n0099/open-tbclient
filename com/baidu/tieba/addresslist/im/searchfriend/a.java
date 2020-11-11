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
    private EditText fUV;
    private TextView fUW;
    private ImageView fUX;
    private InterfaceC0613a fUY;
    private View.OnClickListener fUZ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fUW) {
                String charSequence2String = k.charSequence2String(a.this.fUV.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.FE(charSequence2String.trim());
                        a.this.fUW.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.fUX) {
                a.this.FD("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0613a {
        void FC(String str);
    }

    public void ll(boolean z) {
        this.fUW.setClickable(z);
    }

    public void FD(String str) {
        this.fUV.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.fUV = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.fUW = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.fUX = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.fUW.setOnClickListener(this.fUZ);
        this.fUX.setOnClickListener(this.fUZ);
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
                    a.this.fUX.setVisibility(8);
                } else {
                    a.this.fUX.setVisibility(0);
                }
            }
        };
        this.fUV.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bKg() {
        this.fUV.removeTextChangedListener(this.mTextWatcher);
    }

    public void bHj() {
        l.hideSoftKeyPad(this.context, this.fUV);
    }

    public void a(InterfaceC0613a interfaceC0613a) {
        this.fUY = interfaceC0613a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fUW, R.color.cp_cont_g, 1);
        this.fUV.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setImageResource(this.fUX, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FE(String str) {
        if (this.fUY != null) {
            this.fUY.FC(str);
        }
    }
}
