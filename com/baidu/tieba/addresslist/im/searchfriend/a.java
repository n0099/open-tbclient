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
    private EditText gcO;
    private TextView gcP;
    private ImageView gcQ;
    private InterfaceC0625a gcR;
    private View.OnClickListener gcS = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gcP) {
                String charSequence2String = k.charSequence2String(a.this.gcO.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.FT(charSequence2String.trim());
                        a.this.gcP.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.gcQ) {
                a.this.FS("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0625a {
        void FR(String str);
    }

    public void lH(boolean z) {
        this.gcP.setClickable(z);
    }

    public void FS(String str) {
        this.gcO.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.gcO = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.gcP = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.gcQ = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.gcP.setOnClickListener(this.gcS);
        this.gcQ.setOnClickListener(this.gcS);
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
                    a.this.gcQ.setVisibility(8);
                } else {
                    a.this.gcQ.setVisibility(0);
                }
            }
        };
        this.gcO.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bNi() {
        this.gcO.removeTextChangedListener(this.mTextWatcher);
    }

    public void bKc() {
        l.hideSoftKeyPad(this.context, this.gcO);
    }

    public void a(InterfaceC0625a interfaceC0625a) {
        this.gcR = interfaceC0625a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.gcP, R.color.CAM_X0111, 1);
        this.gcO.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setImageResource(this.gcQ, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT(String str) {
        if (this.gcR != null) {
            this.gcR.FR(str);
        }
    }
}
