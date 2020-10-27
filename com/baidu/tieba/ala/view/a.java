package com.baidu.tieba.ala.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a implements TextWatcher, View.OnClickListener {
    private TextView bAg;
    private EditText bAh;
    private TextView bAi;
    private long bmB;
    private long fSB;
    private InterfaceC0692a gsw;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0692a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0692a interfaceC0692a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.gsw = interfaceC0692a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bAg = (TextView) this.mView.findViewById(a.g.id_feenback_edit_confirm_btn);
        this.bAh = (EditText) this.mView.findViewById(a.g.id_feedback_edit_text);
        this.bAi = (TextView) this.mView.findViewById(a.g.id_feedback_real_textnum);
        this.bAh.setCursorVisible(false);
        this.bAg.setEnabled(false);
        this.bAh.addTextChangedListener(this);
        this.bAg.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.bmB = j;
        this.fSB = j2;
        this.mUserId = j3;
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            int length = editable.toString().length();
            this.bAi.setText(String.valueOf(length));
            if (length > 20) {
                this.bAi.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_color_FF1E66));
                this.bAg.setEnabled(false);
            } else {
                this.bAi.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                if (length == 0) {
                    this.bAg.setEnabled(false);
                } else {
                    this.bAg.setEnabled(true);
                }
            }
        }
        if (this.gsw != null) {
            this.gsw.afterTextChanged(editable);
        }
    }

    public String RR() {
        if (this.bAh.getText() != null) {
            return this.bAh.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bAh.setCursorVisible(true);
        } else {
            this.bAh.setCursorVisible(false);
        }
    }
}
