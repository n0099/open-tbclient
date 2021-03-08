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
    private TextView bPa;
    private EditText bPb;
    private TextView bPc;
    private long bwn;
    private InterfaceC0702a gSy;
    private long gqI;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0702a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0702a interfaceC0702a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.gSy = interfaceC0702a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bPa = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bPb = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bPc = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bPb.setCursorVisible(false);
        this.bPa.setEnabled(false);
        this.bPb.addTextChangedListener(this);
        this.bPa.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.bwn = j;
        this.gqI = j2;
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
            this.bPc.setText(String.valueOf(length));
            if (length > 20) {
                this.bPc.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bPa.setEnabled(false);
            } else {
                this.bPc.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                if (length == 0) {
                    this.bPa.setEnabled(false);
                } else {
                    this.bPa.setEnabled(true);
                }
            }
        }
        if (this.gSy != null) {
            this.gSy.afterTextChanged(editable);
        }
    }

    public String Vk() {
        if (this.bPb.getText() != null) {
            return this.bPb.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bPb.setCursorVisible(true);
        } else {
            this.bPb.setCursorVisible(false);
        }
    }
}
