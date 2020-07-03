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
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes3.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private q aLQ;
    private TextView fju;
    private TextView fjv;
    private EditText fjw;
    private a fjx;
    private HttpMessageListener fjy;
    private TextWatcher mTextWatcher;

    /* loaded from: classes3.dex */
    public interface a {
        void Bk(String str);

        void bsL();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fjw.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fjw.setText(TextHelper.subString(AlaTextStickerEditView.this.fjw.getText().toString(), 16));
                    AlaTextStickerEditView.this.fjw.setSelection(AlaTextStickerEditView.this.fjw.getText().length());
                    AlaTextStickerEditView.this.fju.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fjw.getText().length() == 0) {
                    AlaTextStickerEditView.this.fjw.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fju.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fju.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fju.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fjv.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fjw.getText()) + 1) / 2)));
            }
        };
        this.fjy = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bsd()) {
                    if (AlaTextStickerEditView.this.fjx != null) {
                        AlaTextStickerEditView.this.fjx.Bk(AlaTextStickerEditView.this.fjw.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fjw);
                        AlaTextStickerEditView.this.fjx.bsL();
                    }
                } else {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_edit_anti));
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fjw.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fjw.setText(TextHelper.subString(AlaTextStickerEditView.this.fjw.getText().toString(), 16));
                    AlaTextStickerEditView.this.fjw.setSelection(AlaTextStickerEditView.this.fjw.getText().length());
                    AlaTextStickerEditView.this.fju.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fjw.getText().length() == 0) {
                    AlaTextStickerEditView.this.fjw.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fju.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fju.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fju.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fjv.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fjw.getText()) + 1) / 2)));
            }
        };
        this.fjy = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bsd()) {
                    if (AlaTextStickerEditView.this.fjx != null) {
                        AlaTextStickerEditView.this.fjx.Bk(AlaTextStickerEditView.this.fjw.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fjw);
                        AlaTextStickerEditView.this.fjx.bsL();
                    }
                } else {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_edit_anti));
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fjw.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fjw.setText(TextHelper.subString(AlaTextStickerEditView.this.fjw.getText().toString(), 16));
                    AlaTextStickerEditView.this.fjw.setSelection(AlaTextStickerEditView.this.fjw.getText().length());
                    AlaTextStickerEditView.this.fju.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fjw.getText().length() == 0) {
                    AlaTextStickerEditView.this.fjw.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fju.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fju.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fju.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fjv.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fjv.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fjw.getText()) + 1) / 2)));
            }
        };
        this.fjy = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bsd()) {
                    if (AlaTextStickerEditView.this.fjx != null) {
                        AlaTextStickerEditView.this.fjx.Bk(AlaTextStickerEditView.this.fjw.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fjw);
                        AlaTextStickerEditView.this.fjx.bsL();
                    }
                } else {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_sticker_edit_view, this);
        setBackgroundDrawable(getContext().getResources().getDrawable(a.f.ala_sticker_text_panel_bg));
        this.fju = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.fju.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bsR();
            }
        });
        this.fjv = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.fjv.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.fjw = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.fjw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bsR();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.fjw.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.fjy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsR() {
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            String obj = this.fjw.getText().toString();
            if (com.baidu.live.utils.i.fT(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.f.dB(this.fjw.getText().toString(), this.aLQ.mLiveInfo.getLiveTitle());
            } else if (this.fjx != null) {
                this.fjx.Bk(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.fjw);
                this.fjx.bsL();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fjy);
    }

    public void setLiveShowInfo(q qVar) {
        this.aLQ = qVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.fjx = aVar;
    }

    public void show(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.fjw.setText(str);
            this.fjw.setSelection(this.fjw.getText().length());
            this.fju.setAlpha(1.0f);
        } else {
            this.fjw.setText("");
            this.fjw.setSelection(0);
            this.fju.setAlpha(0.7f);
        }
        this.fjw.requestFocus();
        if (this.fjw != null) {
            this.fjw.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fjw);
                }
            });
        }
    }
}
