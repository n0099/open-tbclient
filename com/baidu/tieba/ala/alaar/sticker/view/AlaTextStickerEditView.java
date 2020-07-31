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
/* loaded from: classes4.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private q avf;
    private TextView foB;
    private TextView foC;
    private EditText foD;
    private a foE;
    private HttpMessageListener foF;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void BV(String str);

        void bvV();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.foD.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.foD.setText(TextHelper.subString(AlaTextStickerEditView.this.foD.getText().toString(), 16));
                    AlaTextStickerEditView.this.foD.setSelection(AlaTextStickerEditView.this.foD.getText().length());
                    AlaTextStickerEditView.this.foB.setAlpha(1.0f);
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.foD.getText().length() == 0) {
                    AlaTextStickerEditView.this.foD.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.foB.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.foB.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.foB.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.foC.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.foD.getText()) + 1) / 2)));
            }
        };
        this.foF = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bvn()) {
                    if (AlaTextStickerEditView.this.foE != null) {
                        AlaTextStickerEditView.this.foE.BV(AlaTextStickerEditView.this.foD.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.foD);
                        AlaTextStickerEditView.this.foE.bvV();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.foD.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.foD.setText(TextHelper.subString(AlaTextStickerEditView.this.foD.getText().toString(), 16));
                    AlaTextStickerEditView.this.foD.setSelection(AlaTextStickerEditView.this.foD.getText().length());
                    AlaTextStickerEditView.this.foB.setAlpha(1.0f);
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.foD.getText().length() == 0) {
                    AlaTextStickerEditView.this.foD.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.foB.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.foB.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.foB.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.foC.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.foD.getText()) + 1) / 2)));
            }
        };
        this.foF = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bvn()) {
                    if (AlaTextStickerEditView.this.foE != null) {
                        AlaTextStickerEditView.this.foE.BV(AlaTextStickerEditView.this.foD.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.foD);
                        AlaTextStickerEditView.this.foE.bvV();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.foD.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.foD.setText(TextHelper.subString(AlaTextStickerEditView.this.foD.getText().toString(), 16));
                    AlaTextStickerEditView.this.foD.setSelection(AlaTextStickerEditView.this.foD.getText().length());
                    AlaTextStickerEditView.this.foB.setAlpha(1.0f);
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.foD.getText().length() == 0) {
                    AlaTextStickerEditView.this.foD.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.foB.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.foB.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.foB.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.foC.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.foC.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.foD.getText()) + 1) / 2)));
            }
        };
        this.foF = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bvn()) {
                    if (AlaTextStickerEditView.this.foE != null) {
                        AlaTextStickerEditView.this.foE.BV(AlaTextStickerEditView.this.foD.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.foD);
                        AlaTextStickerEditView.this.foE.bvV();
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
        this.foB = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.foB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bwb();
            }
        });
        this.foC = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.foC.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.foD = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.foD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bwb();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.foD.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.foF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwb() {
        if (this.avf != null && this.avf.mLiveInfo != null) {
            String obj = this.foD.getText().toString();
            if (com.baidu.live.utils.i.fR(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.f.dB(this.foD.getText().toString(), this.avf.mLiveInfo.getLiveTitle());
            } else if (this.foE != null) {
                this.foE.BV(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.foD);
                this.foE.bvV();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.foF);
    }

    public void setLiveShowInfo(q qVar) {
        this.avf = qVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.foE = aVar;
    }

    public void show(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.foD.setText(str);
            this.foD.setSelection(this.foD.getText().length());
            this.foB.setAlpha(1.0f);
        } else {
            this.foD.setText("");
            this.foD.setSelection(0);
            this.foB.setAlpha(0.7f);
        }
        this.foD.requestFocus();
        if (this.foD != null) {
            this.foD.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.foD);
                }
            });
        }
    }
}
