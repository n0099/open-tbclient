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
/* loaded from: classes10.dex */
public class a implements TextWatcher, View.OnClickListener {
    private TextView bJQ;
    private EditText bJR;
    private TextView bJS;
    private long brk;
    private InterfaceC0695a gNV;
    private long gmc;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0695a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0695a interfaceC0695a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.gNV = interfaceC0695a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bJQ = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bJR = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bJS = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bJR.setCursorVisible(false);
        this.bJQ.setEnabled(false);
        this.bJR.addTextChangedListener(this);
        this.bJQ.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.brk = j;
        this.gmc = j2;
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
            this.bJS.setText(String.valueOf(length));
            if (length > 20) {
                this.bJS.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bJQ.setEnabled(false);
            } else {
                this.bJS.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                if (length == 0) {
                    this.bJQ.setEnabled(false);
                } else {
                    this.bJQ.setEnabled(true);
                }
            }
        }
        if (this.gNV != null) {
            this.gNV.afterTextChanged(editable);
        }
    }

    public String TA() {
        if (this.bJR.getText() != null) {
            return this.bJR.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bJR.setCursorVisible(true);
        } else {
            this.bJR.setCursorVisible(false);
        }
    }
}
