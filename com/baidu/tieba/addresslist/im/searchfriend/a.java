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
/* loaded from: classes7.dex */
public class a {
    private Context context;
    private InterfaceC0599a ghA;
    private View.OnClickListener ghB = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ghy) {
                String charSequence2String = k.charSequence2String(a.this.ghx.getText(), null);
                if (!StringUtils.isNULL(charSequence2String)) {
                    if (charSequence2String.trim().length() != 0) {
                        a.this.EF(charSequence2String.trim());
                        a.this.ghy.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        a.this.mPageContext.showToast(R.string.input_content);
                    }
                }
            } else if (view == a.this.ghz) {
                a.this.EE("");
            }
        }
    };
    private EditText ghx;
    private TextView ghy;
    private ImageView ghz;
    private TbPageContext<?> mPageContext;
    private TextWatcher mTextWatcher;

    /* renamed from: com.baidu.tieba.addresslist.im.searchfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0599a {
        void ED(String str);
    }

    public void ma(boolean z) {
        this.ghy.setClickable(z);
    }

    public void EE(String str) {
        this.ghx.setText(str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ghx = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.ghy = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.ghz = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.ghy.setOnClickListener(this.ghB);
        this.ghz.setOnClickListener(this.ghB);
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
                    a.this.ghz.setVisibility(8);
                } else {
                    a.this.ghz.setVisibility(0);
                }
            }
        };
        this.ghx.addTextChangedListener(this.mTextWatcher);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bLJ() {
        this.ghx.removeTextChangedListener(this.mTextWatcher);
    }

    public void bID() {
        l.hideSoftKeyPad(this.context, this.ghx);
    }

    public void a(InterfaceC0599a interfaceC0599a) {
        this.ghA = interfaceC0599a;
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.ghy, R.color.CAM_X0111, 1);
        this.ghx.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setImageResource(this.ghz, R.drawable.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EF(String str) {
        if (this.ghA != null) {
            this.ghA.ED(str);
        }
    }
}
