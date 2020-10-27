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
    private w aEc;
    private TextView fYQ;
    private TextView fYR;
    private EditText fYS;
    private a fYT;
    private HttpMessageListener fYU;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void FX(String str);

        void bLt();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fYS.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fYS.setText(TextHelper.subString(AlaTextStickerEditView.this.fYS.getText().toString(), 16));
                    AlaTextStickerEditView.this.fYS.setSelection(AlaTextStickerEditView.this.fYS.getText().length());
                    AlaTextStickerEditView.this.fYQ.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fYS.getText().length() == 0) {
                    AlaTextStickerEditView.this.fYS.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fYQ.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fYQ.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fYQ.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fYR.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fYS.getText()) + 1) / 2)));
            }
        };
        this.fYU = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bKK()) {
                    if (AlaTextStickerEditView.this.fYT != null) {
                        AlaTextStickerEditView.this.fYT.FX(AlaTextStickerEditView.this.fYS.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fYS);
                        AlaTextStickerEditView.this.fYT.bLt();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fYS.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fYS.setText(TextHelper.subString(AlaTextStickerEditView.this.fYS.getText().toString(), 16));
                    AlaTextStickerEditView.this.fYS.setSelection(AlaTextStickerEditView.this.fYS.getText().length());
                    AlaTextStickerEditView.this.fYQ.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fYS.getText().length() == 0) {
                    AlaTextStickerEditView.this.fYS.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fYQ.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fYQ.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fYQ.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fYR.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fYS.getText()) + 1) / 2)));
            }
        };
        this.fYU = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bKK()) {
                    if (AlaTextStickerEditView.this.fYT != null) {
                        AlaTextStickerEditView.this.fYT.FX(AlaTextStickerEditView.this.fYS.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fYS);
                        AlaTextStickerEditView.this.fYT.bLt();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fYS.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fYS.setText(TextHelper.subString(AlaTextStickerEditView.this.fYS.getText().toString(), 16));
                    AlaTextStickerEditView.this.fYS.setSelection(AlaTextStickerEditView.this.fYS.getText().length());
                    AlaTextStickerEditView.this.fYQ.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fYS.getText().length() == 0) {
                    AlaTextStickerEditView.this.fYS.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fYQ.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fYQ.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fYQ.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fYR.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fYR.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fYS.getText()) + 1) / 2)));
            }
        };
        this.fYU = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bKK()) {
                    if (AlaTextStickerEditView.this.fYT != null) {
                        AlaTextStickerEditView.this.fYT.FX(AlaTextStickerEditView.this.fYS.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fYS);
                        AlaTextStickerEditView.this.fYT.bLt();
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
        this.fYQ = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.fYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bLC();
            }
        });
        this.fYR = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.fYR.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.fYS = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.fYS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bLC();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.fYS.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.fYU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLC() {
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            String obj = this.fYS.getText().toString();
            if (j.ik(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.eh(this.fYS.getText().toString(), this.aEc.mLiveInfo.getLiveTitle());
            } else if (this.fYT != null) {
                this.fYT.FX(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.fYS);
                this.fYT.bLt();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fYU);
    }

    public void setLiveShowInfo(w wVar) {
        this.aEc = wVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.fYT = aVar;
    }

    public void FZ(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.fYS.setText(str);
            this.fYS.setSelection(this.fYS.getText().length());
            this.fYQ.setAlpha(1.0f);
        } else {
            this.fYS.setText("");
            this.fYS.setSelection(0);
            this.fYQ.setAlpha(0.7f);
        }
        this.fYS.requestFocus();
        if (this.fYS != null) {
            this.fYS.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fYS);
                }
            });
        }
    }
}
