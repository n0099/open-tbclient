package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes10.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private x aBr;
    private TextView gsp;
    private TextView gsq;
    private EditText gsr;
    private a gss;
    private HttpMessageListener gst;
    private TextWatcher mTextWatcher;

    /* loaded from: classes10.dex */
    public interface a {
        void Fn(String str);

        void bPE();
    }

    public AlaTextStickerEditView(Context context) {
        super(context);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gsr.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gsr.setText(TextHelper.subString(AlaTextStickerEditView.this.gsr.getText().toString(), 16));
                    AlaTextStickerEditView.this.gsr.setSelection(AlaTextStickerEditView.this.gsr.getText().length());
                    AlaTextStickerEditView.this.gsp.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gsr.getText().length() == 0) {
                    AlaTextStickerEditView.this.gsr.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gsp.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gsp.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gsp.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gsq.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gsr.getText()) + 1) / 2)));
            }
        };
        this.gst = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bOW()) {
                    if (AlaTextStickerEditView.this.gss != null) {
                        AlaTextStickerEditView.this.gss.Fn(AlaTextStickerEditView.this.gsr.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gsr);
                        AlaTextStickerEditView.this.gss.bPE();
                    }
                } else {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    public AlaTextStickerEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gsr.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gsr.setText(TextHelper.subString(AlaTextStickerEditView.this.gsr.getText().toString(), 16));
                    AlaTextStickerEditView.this.gsr.setSelection(AlaTextStickerEditView.this.gsr.getText().length());
                    AlaTextStickerEditView.this.gsp.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gsr.getText().length() == 0) {
                    AlaTextStickerEditView.this.gsr.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gsp.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gsp.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gsp.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gsq.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gsr.getText()) + 1) / 2)));
            }
        };
        this.gst = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bOW()) {
                    if (AlaTextStickerEditView.this.gss != null) {
                        AlaTextStickerEditView.this.gss.Fn(AlaTextStickerEditView.this.gsr.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gsr);
                        AlaTextStickerEditView.this.gss.bPE();
                    }
                } else {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    public AlaTextStickerEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gsr.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gsr.setText(TextHelper.subString(AlaTextStickerEditView.this.gsr.getText().toString(), 16));
                    AlaTextStickerEditView.this.gsr.setSelection(AlaTextStickerEditView.this.gsr.getText().length());
                    AlaTextStickerEditView.this.gsp.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gsr.getText().length() == 0) {
                    AlaTextStickerEditView.this.gsr.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gsp.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gsp.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gsp.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gsq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gsq.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gsr.getText()) + 1) / 2)));
            }
        };
        this.gst = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bOW()) {
                    if (AlaTextStickerEditView.this.gss != null) {
                        AlaTextStickerEditView.this.gss.Fn(AlaTextStickerEditView.this.gsr.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gsr);
                        AlaTextStickerEditView.this.gss.bPE();
                    }
                } else {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_sticker_edit_view, this);
        setBackgroundDrawable(getContext().getResources().getDrawable(a.e.ala_sticker_text_panel_bg));
        this.gsp = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.gsp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bPN();
            }
        });
        this.gsq = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.gsq.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.gsr = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.gsr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bPN();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.gsr.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.gst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPN() {
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            String obj = this.gsr.getText().toString();
            if (j.hF(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.en(this.gsr.getText().toString(), this.aBr.mLiveInfo.getLiveTitle());
            } else if (this.gss != null) {
                this.gss.Fn(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.gsr);
                this.gss.bPE();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gst);
    }

    public void setLiveShowInfo(x xVar) {
        this.aBr = xVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.gss = aVar;
    }

    public void Fp(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.gsr.setText(str);
            this.gsr.setSelection(this.gsr.getText().length());
            this.gsp.setAlpha(1.0f);
        } else {
            this.gsr.setText("");
            this.gsr.setSelection(0);
            this.gsp.setAlpha(0.7f);
        }
        this.gsr.requestFocus();
        if (this.gsr != null) {
            this.gsr.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gsr);
                }
            });
        }
    }
}
