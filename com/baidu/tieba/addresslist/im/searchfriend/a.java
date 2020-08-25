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
/* loaded from: classes15.dex */
public class a {
    private Context context;
    private EditText frk;
    private TextView frl;
    private ImageView frm;
    private InterfaceC0574a frn;
    private View.OnClickListener fro = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.frl) {
                String charSequence2String = k.charSequence2String(a.this.frk.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.DO(charSequence2String.trim());
                        a.this.frl.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.frm) {
                a.this.DN("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0574a {
        void DM(String str);
    }

    public void ko(boolean z) {
        this.frl.setClickable(z);
    }

    public void DN(String str) {
        this.frk.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.frk = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.frl = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.frm = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.frl.setOnClickListener(this.fro);
        this.frm.setOnClickListener(this.fro);
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
                    a.this.frm.setVisibility(8);
                } else {
                    a.this.frm.setVisibility(0);
                }
            }
        };
        this.frk.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bBP() {
        this.frk.removeTextChangedListener(this.mTextWatcher);
    }

    public void byX() {
        l.hideSoftKeyPad(this.context, this.frk);
    }

    public void a(InterfaceC0574a interfaceC0574a) {
        this.frn = interfaceC0574a;
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.frl, R.color.cp_cont_g, 1);
        this.frk.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setImageResource(this.frm, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(String str) {
        if (this.frn != null) {
            this.frn.DM(str);
        }
    }
}
