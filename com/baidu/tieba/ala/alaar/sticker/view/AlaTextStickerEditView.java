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
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes11.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private ab aDd;
    private TextView guZ;
    private TextView gva;
    private EditText gvb;
    private a gvc;
    private HttpMessageListener gvd;
    private TextWatcher mTextWatcher;

    /* loaded from: classes11.dex */
    public interface a {
        void FL(String str);

        void bQi();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gvb.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gvb.setText(TextHelper.subString(AlaTextStickerEditView.this.gvb.getText().toString(), 16));
                    AlaTextStickerEditView.this.gvb.setSelection(AlaTextStickerEditView.this.gvb.getText().length());
                    AlaTextStickerEditView.this.guZ.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gvb.getText().length() == 0) {
                    AlaTextStickerEditView.this.gvb.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.guZ.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.guZ.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.guZ.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gva.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gvb.getText()) + 1) / 2)));
            }
        };
        this.gvd = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bPA()) {
                    if (AlaTextStickerEditView.this.gvc != null) {
                        AlaTextStickerEditView.this.gvc.FL(AlaTextStickerEditView.this.gvb.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvb);
                        AlaTextStickerEditView.this.gvc.bQi();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gvb.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gvb.setText(TextHelper.subString(AlaTextStickerEditView.this.gvb.getText().toString(), 16));
                    AlaTextStickerEditView.this.gvb.setSelection(AlaTextStickerEditView.this.gvb.getText().length());
                    AlaTextStickerEditView.this.guZ.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gvb.getText().length() == 0) {
                    AlaTextStickerEditView.this.gvb.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.guZ.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.guZ.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.guZ.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gva.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gvb.getText()) + 1) / 2)));
            }
        };
        this.gvd = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bPA()) {
                    if (AlaTextStickerEditView.this.gvc != null) {
                        AlaTextStickerEditView.this.gvc.FL(AlaTextStickerEditView.this.gvb.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvb);
                        AlaTextStickerEditView.this.gvc.bQi();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gvb.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gvb.setText(TextHelper.subString(AlaTextStickerEditView.this.gvb.getText().toString(), 16));
                    AlaTextStickerEditView.this.gvb.setSelection(AlaTextStickerEditView.this.gvb.getText().length());
                    AlaTextStickerEditView.this.guZ.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gvb.getText().length() == 0) {
                    AlaTextStickerEditView.this.gvb.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.guZ.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.guZ.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.guZ.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gva.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gva.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gvb.getText()) + 1) / 2)));
            }
        };
        this.gvd = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bPA()) {
                    if (AlaTextStickerEditView.this.gvc != null) {
                        AlaTextStickerEditView.this.gvc.FL(AlaTextStickerEditView.this.gvb.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvb);
                        AlaTextStickerEditView.this.gvc.bQi();
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
        this.guZ = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.guZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bQr();
            }
        });
        this.gva = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.gva.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.gvb = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.gvb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bQr();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.gvb.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.gvd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQr() {
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            String obj = this.gvb.getText().toString();
            if (j.ia(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.em(this.gvb.getText().toString(), this.aDd.mLiveInfo.getLiveTitle());
            } else if (this.gvc != null) {
                this.gvc.FL(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.gvb);
                this.gvc.bQi();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gvd);
    }

    public void setLiveShowInfo(ab abVar) {
        this.aDd = abVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.gvc = aVar;
    }

    public void FN(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.gvb.setText(str);
            this.gvb.setSelection(this.gvb.getText().length());
            this.guZ.setAlpha(1.0f);
        } else {
            this.gvb.setText("");
            this.gvb.setSelection(0);
            this.guZ.setAlpha(0.7f);
        }
        this.gvb.requestFocus();
        if (this.gvb != null) {
            this.gvb.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvb);
                }
            });
        }
    }
}
