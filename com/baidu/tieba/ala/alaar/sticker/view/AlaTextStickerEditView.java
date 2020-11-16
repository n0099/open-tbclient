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
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes4.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private w aDh;
    private TextView gep;
    private TextView geq;
    private EditText ger;
    private a ges;
    private HttpMessageListener get;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void FM(String str);

        void bNl();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.ger.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.ger.setText(TextHelper.subString(AlaTextStickerEditView.this.ger.getText().toString(), 16));
                    AlaTextStickerEditView.this.ger.setSelection(AlaTextStickerEditView.this.ger.getText().length());
                    AlaTextStickerEditView.this.gep.setAlpha(1.0f);
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.ger.getText().length() == 0) {
                    AlaTextStickerEditView.this.ger.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gep.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gep.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gep.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.geq.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.ger.getText()) + 1) / 2)));
            }
        };
        this.get = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bMC()) {
                    if (AlaTextStickerEditView.this.ges != null) {
                        AlaTextStickerEditView.this.ges.FM(AlaTextStickerEditView.this.ger.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.ger);
                        AlaTextStickerEditView.this.ges.bNl();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.ger.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.ger.setText(TextHelper.subString(AlaTextStickerEditView.this.ger.getText().toString(), 16));
                    AlaTextStickerEditView.this.ger.setSelection(AlaTextStickerEditView.this.ger.getText().length());
                    AlaTextStickerEditView.this.gep.setAlpha(1.0f);
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.ger.getText().length() == 0) {
                    AlaTextStickerEditView.this.ger.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gep.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gep.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gep.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.geq.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.ger.getText()) + 1) / 2)));
            }
        };
        this.get = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bMC()) {
                    if (AlaTextStickerEditView.this.ges != null) {
                        AlaTextStickerEditView.this.ges.FM(AlaTextStickerEditView.this.ger.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.ger);
                        AlaTextStickerEditView.this.ges.bNl();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.ger.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.ger.setText(TextHelper.subString(AlaTextStickerEditView.this.ger.getText().toString(), 16));
                    AlaTextStickerEditView.this.ger.setSelection(AlaTextStickerEditView.this.ger.getText().length());
                    AlaTextStickerEditView.this.gep.setAlpha(1.0f);
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.ger.getText().length() == 0) {
                    AlaTextStickerEditView.this.ger.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gep.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gep.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gep.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.geq.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.geq.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.ger.getText()) + 1) / 2)));
            }
        };
        this.get = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bMC()) {
                    if (AlaTextStickerEditView.this.ges != null) {
                        AlaTextStickerEditView.this.ges.FM(AlaTextStickerEditView.this.ger.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.ger);
                        AlaTextStickerEditView.this.ges.bNl();
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
        this.gep = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.gep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bNu();
            }
        });
        this.geq = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.geq.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.ger = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.ger.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bNu();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.ger.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.get);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNu() {
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            String obj = this.ger.getText().toString();
            if (j.ix(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.eh(this.ger.getText().toString(), this.aDh.mLiveInfo.getLiveTitle());
            } else if (this.ges != null) {
                this.ges.FM(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.ger);
                this.ges.bNl();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.get);
    }

    public void setLiveShowInfo(w wVar) {
        this.aDh = wVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.ges = aVar;
    }

    public void FO(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.ger.setText(str);
            this.ger.setSelection(this.ger.getText().length());
            this.gep.setAlpha(1.0f);
        } else {
            this.ger.setText("");
            this.ger.setSelection(0);
            this.gep.setAlpha(0.7f);
        }
        this.ger.requestFocus();
        if (this.ger != null) {
            this.ger.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.ger);
                }
            });
        }
    }
}
