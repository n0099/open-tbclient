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
/* loaded from: classes7.dex */
public class a implements TextWatcher, View.OnClickListener {
    private long bey;
    private InterfaceC0661a fSR;
    private long fuN;
    private TextView fut;
    private EditText gZV;
    private TextView gZW;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0661a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0661a interfaceC0661a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.fSR = interfaceC0661a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.fut = (TextView) this.mView.findViewById(a.g.id_feenback_edit_confirm_btn);
        this.gZV = (EditText) this.mView.findViewById(a.g.id_feedback_edit_text);
        this.gZW = (TextView) this.mView.findViewById(a.g.id_feedback_real_textnum);
        this.gZV.setCursorVisible(false);
        this.fut.setEnabled(false);
        this.gZV.addTextChangedListener(this);
        this.fut.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.bey = j;
        this.fuN = j2;
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
            this.gZW.setText(String.valueOf(length));
            if (length > 20) {
                this.gZW.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_color_FF1E66));
                this.fut.setEnabled(false);
            } else {
                this.gZW.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                if (length == 0) {
                    this.fut.setEnabled(false);
                } else {
                    this.fut.setEnabled(true);
                }
            }
        }
        if (this.fSR != null) {
            this.fSR.afterTextChanged(editable);
        }
    }

    public String cam() {
        if (this.gZV.getText() != null) {
            return this.gZV.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.gZV.setCursorVisible(true);
        } else {
            this.gZV.setCursorVisible(false);
        }
    }
}
