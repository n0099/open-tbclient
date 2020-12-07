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
    private TextView bJO;
    private EditText bJP;
    private TextView bJQ;
    private long brr;
    private InterfaceC0720a gGN;
    private long ggj;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private long mUserId;
    private View mView;

    /* renamed from: com.baidu.tieba.ala.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0720a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0720a interfaceC0720a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.gGN = interfaceC0720a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bJO = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bJP = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bJQ = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bJP.setCursorVisible(false);
        this.bJO.setEnabled(false);
        this.bJP.addTextChangedListener(this);
        this.bJO.setOnClickListener(this);
    }

    public void b(long j, long j2, long j3, boolean z) {
        this.brr = j;
        this.ggj = j2;
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
            this.bJQ.setText(String.valueOf(length));
            if (length > 20) {
                this.bJQ.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bJO.setEnabled(false);
            } else {
                this.bJQ.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                if (length == 0) {
                    this.bJO.setEnabled(false);
                } else {
                    this.bJO.setEnabled(true);
                }
            }
        }
        if (this.gGN != null) {
            this.gGN.afterTextChanged(editable);
        }
    }

    public String Wq() {
        if (this.bJP.getText() != null) {
            return this.bJP.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bJP.setCursorVisible(true);
        } else {
            this.bJP.setCursorVisible(false);
        }
    }
}
