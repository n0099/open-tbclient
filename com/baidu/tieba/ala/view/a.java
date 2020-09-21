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
    private long bhr;
    private InterfaceC0658a fWb;
    private TextView fxE;
    private long fxY;
    private EditText hdV;
    private TextView hdW;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0658a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0658a interfaceC0658a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.fWb = interfaceC0658a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.fxE = (TextView) this.mView.findViewById(a.g.id_feenback_edit_confirm_btn);
        this.hdV = (EditText) this.mView.findViewById(a.g.id_feedback_edit_text);
        this.hdW = (TextView) this.mView.findViewById(a.g.id_feedback_real_textnum);
        this.hdV.setCursorVisible(false);
        this.fxE.setEnabled(false);
        this.hdV.addTextChangedListener(this);
        this.fxE.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.bhr = j;
        this.fxY = j2;
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
            this.hdW.setText(String.valueOf(length));
            if (length > 20) {
                this.hdW.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_color_FF1E66));
                this.fxE.setEnabled(false);
            } else {
                this.hdW.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                if (length == 0) {
                    this.fxE.setEnabled(false);
                } else {
                    this.fxE.setEnabled(true);
                }
            }
        }
        if (this.fWb != null) {
            this.fWb.afterTextChanged(editable);
        }
    }

    public String ccw() {
        if (this.hdV.getText() != null) {
            return this.hdV.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.hdV.setCursorVisible(true);
        } else {
            this.hdV.setCursorVisible(false);
        }
    }
}
