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
    private EditText gcM;
    private TextView gcN;
    private ImageView gcO;
    private InterfaceC0625a gcP;
    private View.OnClickListener gcQ = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gcN) {
                String charSequence2String = k.charSequence2String(a.this.gcM.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.FT(charSequence2String.trim());
                        a.this.gcN.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.gcO) {
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
        this.gcN.setClickable(z);
    }

    public void FS(String str) {
        this.gcM.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.gcM = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.gcN = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.gcO = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.gcN.setOnClickListener(this.gcQ);
        this.gcO.setOnClickListener(this.gcQ);
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
                    a.this.gcO.setVisibility(8);
                } else {
                    a.this.gcO.setVisibility(0);
                }
            }
        };
        this.gcM.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bNh() {
        this.gcM.removeTextChangedListener(this.mTextWatcher);
    }

    public void bKc() {
        l.hideSoftKeyPad(this.context, this.gcM);
    }

    public void a(InterfaceC0625a interfaceC0625a) {
        this.gcP = interfaceC0625a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.gcN, R.color.CAM_X0111, 1);
        this.gcM.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setImageResource(this.gcO, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT(String str) {
        if (this.gcP != null) {
            this.gcP.FR(str);
        }
    }
}
