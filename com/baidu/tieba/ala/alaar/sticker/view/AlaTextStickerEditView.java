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
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes4.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private u aAP;
    private TextView fDo;
    private TextView fDp;
    private EditText fDq;
    private a fDr;
    private HttpMessageListener fDs;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void EN(String str);

        void bGh();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fDq.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fDq.setText(TextHelper.subString(AlaTextStickerEditView.this.fDq.getText().toString(), 16));
                    AlaTextStickerEditView.this.fDq.setSelection(AlaTextStickerEditView.this.fDq.getText().length());
                    AlaTextStickerEditView.this.fDo.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fDq.getText().length() == 0) {
                    AlaTextStickerEditView.this.fDq.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fDo.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fDo.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fDo.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fDp.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fDq.getText()) + 1) / 2)));
            }
        };
        this.fDs = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bFz()) {
                    if (AlaTextStickerEditView.this.fDr != null) {
                        AlaTextStickerEditView.this.fDr.EN(AlaTextStickerEditView.this.fDq.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fDq);
                        AlaTextStickerEditView.this.fDr.bGh();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fDq.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fDq.setText(TextHelper.subString(AlaTextStickerEditView.this.fDq.getText().toString(), 16));
                    AlaTextStickerEditView.this.fDq.setSelection(AlaTextStickerEditView.this.fDq.getText().length());
                    AlaTextStickerEditView.this.fDo.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fDq.getText().length() == 0) {
                    AlaTextStickerEditView.this.fDq.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fDo.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fDo.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fDo.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fDp.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fDq.getText()) + 1) / 2)));
            }
        };
        this.fDs = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bFz()) {
                    if (AlaTextStickerEditView.this.fDr != null) {
                        AlaTextStickerEditView.this.fDr.EN(AlaTextStickerEditView.this.fDq.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fDq);
                        AlaTextStickerEditView.this.fDr.bGh();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fDq.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fDq.setText(TextHelper.subString(AlaTextStickerEditView.this.fDq.getText().toString(), 16));
                    AlaTextStickerEditView.this.fDq.setSelection(AlaTextStickerEditView.this.fDq.getText().length());
                    AlaTextStickerEditView.this.fDo.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fDq.getText().length() == 0) {
                    AlaTextStickerEditView.this.fDq.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fDo.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fDo.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fDo.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fDp.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fDp.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fDq.getText()) + 1) / 2)));
            }
        };
        this.fDs = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bFz()) {
                    if (AlaTextStickerEditView.this.fDr != null) {
                        AlaTextStickerEditView.this.fDr.EN(AlaTextStickerEditView.this.fDq.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fDq);
                        AlaTextStickerEditView.this.fDr.bGh();
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
        this.fDo = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.fDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bGq();
            }
        });
        this.fDp = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.fDp.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.fDq = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.fDq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bGq();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.fDq.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.fDs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGq() {
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            String obj = this.fDq.getText().toString();
            if (j.hC(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.f.dU(this.fDq.getText().toString(), this.aAP.mLiveInfo.getLiveTitle());
            } else if (this.fDr != null) {
                this.fDr.EN(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.fDq);
                this.fDr.bGh();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fDs);
    }

    public void setLiveShowInfo(u uVar) {
        this.aAP = uVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.fDr = aVar;
    }

    public void EO(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.fDq.setText(str);
            this.fDq.setSelection(this.fDq.getText().length());
            this.fDo.setAlpha(1.0f);
        } else {
            this.fDq.setText("");
            this.fDq.setSelection(0);
            this.fDo.setAlpha(0.7f);
        }
        this.fDq.requestFocus();
        if (this.fDq != null) {
            this.fDq.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fDq);
                }
            });
        }
    }
}
