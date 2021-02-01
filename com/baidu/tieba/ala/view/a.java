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
/* loaded from: classes11.dex */
public class a implements TextWatcher, View.OnClickListener {
    private TextView bNA;
    private EditText bNB;
    private TextView bNC;
    private long buN;
    private InterfaceC0695a gQB;
    private long goL;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0695a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0695a interfaceC0695a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.gQB = interfaceC0695a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bNA = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bNB = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bNC = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bNB.setCursorVisible(false);
        this.bNA.setEnabled(false);
        this.bNB.addTextChangedListener(this);
        this.bNA.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.buN = j;
        this.goL = j2;
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
            this.bNC.setText(String.valueOf(length));
            if (length > 20) {
                this.bNC.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bNA.setEnabled(false);
            } else {
                this.bNC.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                if (length == 0) {
                    this.bNA.setEnabled(false);
                } else {
                    this.bNA.setEnabled(true);
                }
            }
        }
        if (this.gQB != null) {
            this.gQB.afterTextChanged(editable);
        }
    }

    public String Vh() {
        if (this.bNB.getText() != null) {
            return this.bNB.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bNB.setCursorVisible(true);
        } else {
            this.bNB.setCursorVisible(false);
        }
    }
}
