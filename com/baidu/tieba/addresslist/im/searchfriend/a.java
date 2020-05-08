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
    private EditText eCt;
    private TextView eCu;
    private ImageView eCv;
    private InterfaceC0463a eCw;
    private View.OnClickListener eCx = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eCu) {
                String charSequence2String = k.charSequence2String(a.this.eCt.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.yK(charSequence2String.trim());
                        a.this.eCu.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.eCv) {
                a.this.yJ("");
            }
        }
    };
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0463a {
        void yI(String str);
    }

    public void iD(boolean z) {
        this.eCu.setClickable(z);
    }

    public void yJ(String str) {
        this.eCt.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.eCt = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.eCu = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.eCv = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.eCu.setOnClickListener(this.eCx);
        this.eCv.setOnClickListener(this.eCx);
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
                    a.this.eCv.setVisibility(8);
                } else {
                    a.this.eCv.setVisibility(0);
                }
            }
        };
        this.eCt.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bhc() {
        this.eCt.removeTextChangedListener(this.mTextWatcher);
    }

    public void bhd() {
        l.hideSoftKeyPad(this.context, this.eCt);
    }

    public void a(InterfaceC0463a interfaceC0463a) {
        this.eCw = interfaceC0463a;
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.eCu, R.color.cp_cont_g, 1);
        this.eCt.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setImageResource(this.eCv, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK(String str) {
        if (this.eCw != null) {
            this.eCw.yI(str);
        }
    }
}
