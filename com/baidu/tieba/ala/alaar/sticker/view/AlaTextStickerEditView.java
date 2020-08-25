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
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes7.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private r aAh;
    private EditText fAa;
    private a fAb;
    private HttpMessageListener fAc;
    private TextView fzY;
    private TextView fzZ;
    private TextWatcher mTextWatcher;

    /* loaded from: classes7.dex */
    public interface a {
        void Ep(String str);

        void bEQ();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fAa.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fAa.setText(TextHelper.subString(AlaTextStickerEditView.this.fAa.getText().toString(), 16));
                    AlaTextStickerEditView.this.fAa.setSelection(AlaTextStickerEditView.this.fAa.getText().length());
                    AlaTextStickerEditView.this.fzY.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fAa.getText().length() == 0) {
                    AlaTextStickerEditView.this.fAa.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fzY.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fzY.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fzY.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fzZ.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fAa.getText()) + 1) / 2)));
            }
        };
        this.fAc = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bEi()) {
                    if (AlaTextStickerEditView.this.fAb != null) {
                        AlaTextStickerEditView.this.fAb.Ep(AlaTextStickerEditView.this.fAa.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAa);
                        AlaTextStickerEditView.this.fAb.bEQ();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fAa.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fAa.setText(TextHelper.subString(AlaTextStickerEditView.this.fAa.getText().toString(), 16));
                    AlaTextStickerEditView.this.fAa.setSelection(AlaTextStickerEditView.this.fAa.getText().length());
                    AlaTextStickerEditView.this.fzY.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fAa.getText().length() == 0) {
                    AlaTextStickerEditView.this.fAa.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fzY.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fzY.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fzY.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fzZ.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fAa.getText()) + 1) / 2)));
            }
        };
        this.fAc = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bEi()) {
                    if (AlaTextStickerEditView.this.fAb != null) {
                        AlaTextStickerEditView.this.fAb.Ep(AlaTextStickerEditView.this.fAa.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAa);
                        AlaTextStickerEditView.this.fAb.bEQ();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fAa.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fAa.setText(TextHelper.subString(AlaTextStickerEditView.this.fAa.getText().toString(), 16));
                    AlaTextStickerEditView.this.fAa.setSelection(AlaTextStickerEditView.this.fAa.getText().length());
                    AlaTextStickerEditView.this.fzY.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fAa.getText().length() == 0) {
                    AlaTextStickerEditView.this.fAa.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fzY.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fzY.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fzY.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fzZ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fzZ.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fAa.getText()) + 1) / 2)));
            }
        };
        this.fAc = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bEi()) {
                    if (AlaTextStickerEditView.this.fAb != null) {
                        AlaTextStickerEditView.this.fAb.Ep(AlaTextStickerEditView.this.fAa.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAa);
                        AlaTextStickerEditView.this.fAb.bEQ();
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
        this.fzY = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.fzY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bEZ();
            }
        });
        this.fzZ = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.fzZ.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.fAa = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.fAa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bEZ();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.fAa.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.fAc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEZ() {
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            String obj = this.fAa.getText().toString();
            if (com.baidu.live.utils.i.hl(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.f.dR(this.fAa.getText().toString(), this.aAh.mLiveInfo.getLiveTitle());
            } else if (this.fAb != null) {
                this.fAb.Ep(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.fAa);
                this.fAb.bEQ();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fAc);
    }

    public void setLiveShowInfo(r rVar) {
        this.aAh = rVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.fAb = aVar;
    }

    public void show(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.fAa.setText(str);
            this.fAa.setSelection(this.fAa.getText().length());
            this.fzY.setAlpha(1.0f);
        } else {
            this.fAa.setText("");
            this.fAa.setSelection(0);
            this.fzY.setAlpha(0.7f);
        }
        this.fAa.requestFocus();
        if (this.fAa != null) {
            this.fAa.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAa);
                }
            });
        }
    }
}
