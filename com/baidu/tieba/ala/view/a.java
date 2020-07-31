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
    private long aZc;
    private InterfaceC0611a fHw;
    private TextView fiT;
    private long fjn;
    private EditText gNa;
    private TextView gNb;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0611a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0611a interfaceC0611a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.fHw = interfaceC0611a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.fiT = (TextView) this.mView.findViewById(a.g.id_feenback_edit_confirm_btn);
        this.gNa = (EditText) this.mView.findViewById(a.g.id_feedback_edit_text);
        this.gNb = (TextView) this.mView.findViewById(a.g.id_feedback_real_textnum);
        this.gNa.setCursorVisible(false);
        this.fiT.setEnabled(false);
        this.gNa.addTextChangedListener(this);
        this.fiT.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.aZc = j;
        this.fjn = j2;
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
            this.gNb.setText(String.valueOf(length));
            if (length > 20) {
                this.gNb.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_color_FF1E66));
                this.fiT.setEnabled(false);
            } else {
                this.gNb.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                if (length == 0) {
                    this.fiT.setEnabled(false);
                } else {
                    this.fiT.setEnabled(true);
                }
            }
        }
        if (this.fHw != null) {
            this.fHw.afterTextChanged(editable);
        }
    }

    public String bQa() {
        if (this.gNa.getText() != null) {
            return this.gNa.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.gNa.setCursorVisible(true);
        } else {
            this.gNa.setCursorVisible(false);
        }
    }
}
