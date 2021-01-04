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
    private TextView bOC;
    private EditText bOD;
    private TextView bOE;
    private long bvY;
    private InterfaceC0712a gSB;
    private long gqJ;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0712a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0712a interfaceC0712a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.gSB = interfaceC0712a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bOC = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bOD = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bOE = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bOD.setCursorVisible(false);
        this.bOC.setEnabled(false);
        this.bOD.addTextChangedListener(this);
        this.bOC.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.bvY = j;
        this.gqJ = j2;
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
            this.bOE.setText(String.valueOf(length));
            if (length > 20) {
                this.bOE.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bOC.setEnabled(false);
            } else {
                this.bOE.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                if (length == 0) {
                    this.bOC.setEnabled(false);
                } else {
                    this.bOC.setEnabled(true);
                }
            }
        }
        if (this.gSB != null) {
            this.gSB.afterTextChanged(editable);
        }
    }

    public String Xs() {
        if (this.bOD.getText() != null) {
            return this.bOD.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bOD.setCursorVisible(true);
        } else {
            this.bOD.setCursorVisible(false);
        }
    }
}
