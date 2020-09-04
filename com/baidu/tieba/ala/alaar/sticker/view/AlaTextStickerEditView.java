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
    private r aAj;
    private TextView fAc;
    private TextView fAd;
    private EditText fAe;
    private a fAf;
    private HttpMessageListener fAg;
    private TextWatcher mTextWatcher;

    /* loaded from: classes7.dex */
    public interface a {
        void Eq(String str);

        void bER();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fAe.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fAe.setText(TextHelper.subString(AlaTextStickerEditView.this.fAe.getText().toString(), 16));
                    AlaTextStickerEditView.this.fAe.setSelection(AlaTextStickerEditView.this.fAe.getText().length());
                    AlaTextStickerEditView.this.fAc.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fAe.getText().length() == 0) {
                    AlaTextStickerEditView.this.fAe.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fAc.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fAc.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fAc.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fAd.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fAe.getText()) + 1) / 2)));
            }
        };
        this.fAg = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bEj()) {
                    if (AlaTextStickerEditView.this.fAf != null) {
                        AlaTextStickerEditView.this.fAf.Eq(AlaTextStickerEditView.this.fAe.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAe);
                        AlaTextStickerEditView.this.fAf.bER();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fAe.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fAe.setText(TextHelper.subString(AlaTextStickerEditView.this.fAe.getText().toString(), 16));
                    AlaTextStickerEditView.this.fAe.setSelection(AlaTextStickerEditView.this.fAe.getText().length());
                    AlaTextStickerEditView.this.fAc.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fAe.getText().length() == 0) {
                    AlaTextStickerEditView.this.fAe.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fAc.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fAc.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fAc.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fAd.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fAe.getText()) + 1) / 2)));
            }
        };
        this.fAg = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bEj()) {
                    if (AlaTextStickerEditView.this.fAf != null) {
                        AlaTextStickerEditView.this.fAf.Eq(AlaTextStickerEditView.this.fAe.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAe);
                        AlaTextStickerEditView.this.fAf.bER();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fAe.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fAe.setText(TextHelper.subString(AlaTextStickerEditView.this.fAe.getText().toString(), 16));
                    AlaTextStickerEditView.this.fAe.setSelection(AlaTextStickerEditView.this.fAe.getText().length());
                    AlaTextStickerEditView.this.fAc.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fAe.getText().length() == 0) {
                    AlaTextStickerEditView.this.fAe.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fAc.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fAc.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fAc.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fAd.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fAd.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fAe.getText()) + 1) / 2)));
            }
        };
        this.fAg = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bEj()) {
                    if (AlaTextStickerEditView.this.fAf != null) {
                        AlaTextStickerEditView.this.fAf.Eq(AlaTextStickerEditView.this.fAe.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAe);
                        AlaTextStickerEditView.this.fAf.bER();
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
        this.fAc = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.fAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bFa();
            }
        });
        this.fAd = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.fAd.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.fAe = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.fAe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bFa();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.fAe.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.fAg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFa() {
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            String obj = this.fAe.getText().toString();
            if (com.baidu.live.utils.i.hm(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.f.dS(this.fAe.getText().toString(), this.aAj.mLiveInfo.getLiveTitle());
            } else if (this.fAf != null) {
                this.fAf.Eq(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.fAe);
                this.fAf.bER();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fAg);
    }

    public void setLiveShowInfo(r rVar) {
        this.aAj = rVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.fAf = aVar;
    }

    public void show(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.fAe.setText(str);
            this.fAe.setSelection(this.fAe.getText().length());
            this.fAc.setAlpha(1.0f);
        } else {
            this.fAe.setText("");
            this.fAe.setSelection(0);
            this.fAc.setAlpha(0.7f);
        }
        this.fAe.requestFocus();
        if (this.fAe != null) {
            this.fAe.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fAe);
                }
            });
        }
    }
}
