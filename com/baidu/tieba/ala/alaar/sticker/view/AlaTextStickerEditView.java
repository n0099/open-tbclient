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
    private TextView gvn;
    private TextView gvo;
    private EditText gvp;
    private a gvq;
    private HttpMessageListener gvr;
    private TextWatcher mTextWatcher;

    /* loaded from: classes11.dex */
    public interface a {
        void FM(String str);

        void bQp();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gvp.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gvp.setText(TextHelper.subString(AlaTextStickerEditView.this.gvp.getText().toString(), 16));
                    AlaTextStickerEditView.this.gvp.setSelection(AlaTextStickerEditView.this.gvp.getText().length());
                    AlaTextStickerEditView.this.gvn.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gvp.getText().length() == 0) {
                    AlaTextStickerEditView.this.gvp.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gvn.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gvn.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gvn.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gvo.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gvp.getText()) + 1) / 2)));
            }
        };
        this.gvr = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bPH()) {
                    if (AlaTextStickerEditView.this.gvq != null) {
                        AlaTextStickerEditView.this.gvq.FM(AlaTextStickerEditView.this.gvp.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvp);
                        AlaTextStickerEditView.this.gvq.bQp();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gvp.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gvp.setText(TextHelper.subString(AlaTextStickerEditView.this.gvp.getText().toString(), 16));
                    AlaTextStickerEditView.this.gvp.setSelection(AlaTextStickerEditView.this.gvp.getText().length());
                    AlaTextStickerEditView.this.gvn.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gvp.getText().length() == 0) {
                    AlaTextStickerEditView.this.gvp.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gvn.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gvn.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gvn.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gvo.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gvp.getText()) + 1) / 2)));
            }
        };
        this.gvr = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bPH()) {
                    if (AlaTextStickerEditView.this.gvq != null) {
                        AlaTextStickerEditView.this.gvq.FM(AlaTextStickerEditView.this.gvp.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvp);
                        AlaTextStickerEditView.this.gvq.bQp();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gvp.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gvp.setText(TextHelper.subString(AlaTextStickerEditView.this.gvp.getText().toString(), 16));
                    AlaTextStickerEditView.this.gvp.setSelection(AlaTextStickerEditView.this.gvp.getText().length());
                    AlaTextStickerEditView.this.gvn.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gvp.getText().length() == 0) {
                    AlaTextStickerEditView.this.gvp.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gvn.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gvn.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gvn.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gvo.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gvo.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gvp.getText()) + 1) / 2)));
            }
        };
        this.gvr = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bPH()) {
                    if (AlaTextStickerEditView.this.gvq != null) {
                        AlaTextStickerEditView.this.gvq.FM(AlaTextStickerEditView.this.gvp.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvp);
                        AlaTextStickerEditView.this.gvq.bQp();
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
        this.gvn = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.gvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bQy();
            }
        });
        this.gvo = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.gvo.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.gvp = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.gvp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bQy();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.gvp.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.gvr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQy() {
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            String obj = this.gvp.getText().toString();
            if (j.ia(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.em(this.gvp.getText().toString(), this.aDd.mLiveInfo.getLiveTitle());
            } else if (this.gvq != null) {
                this.gvq.FM(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.gvp);
                this.gvq.bQp();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gvr);
    }

    public void setLiveShowInfo(ab abVar) {
        this.aDd = abVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.gvq = aVar;
    }

    public void FO(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.gvp.setText(str);
            this.gvp.setSelection(this.gvp.getText().length());
            this.gvn.setAlpha(1.0f);
        } else {
            this.gvp.setText("");
            this.gvp.setSelection(0);
            this.gvn.setAlpha(0.7f);
        }
        this.gvp.requestFocus();
        if (this.gvp != null) {
            this.gvp.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gvp);
                }
            });
        }
    }
}
