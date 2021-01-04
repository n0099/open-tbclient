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
/* loaded from: classes11.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private x aGe;
    private TextView gwW;
    private TextView gwX;
    private EditText gwY;
    private a gwZ;
    private HttpMessageListener gxa;
    private TextWatcher mTextWatcher;

    /* loaded from: classes11.dex */
    public interface a {
        void Gz(String str);

        void bTv();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gwY.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gwY.setText(TextHelper.subString(AlaTextStickerEditView.this.gwY.getText().toString(), 16));
                    AlaTextStickerEditView.this.gwY.setSelection(AlaTextStickerEditView.this.gwY.getText().length());
                    AlaTextStickerEditView.this.gwW.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gwY.getText().length() == 0) {
                    AlaTextStickerEditView.this.gwY.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gwW.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gwW.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gwW.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gwX.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gwY.getText()) + 1) / 2)));
            }
        };
        this.gxa = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bSN()) {
                    if (AlaTextStickerEditView.this.gwZ != null) {
                        AlaTextStickerEditView.this.gwZ.Gz(AlaTextStickerEditView.this.gwY.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gwY);
                        AlaTextStickerEditView.this.gwZ.bTv();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gwY.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gwY.setText(TextHelper.subString(AlaTextStickerEditView.this.gwY.getText().toString(), 16));
                    AlaTextStickerEditView.this.gwY.setSelection(AlaTextStickerEditView.this.gwY.getText().length());
                    AlaTextStickerEditView.this.gwW.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gwY.getText().length() == 0) {
                    AlaTextStickerEditView.this.gwY.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gwW.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gwW.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gwW.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gwX.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gwY.getText()) + 1) / 2)));
            }
        };
        this.gxa = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bSN()) {
                    if (AlaTextStickerEditView.this.gwZ != null) {
                        AlaTextStickerEditView.this.gwZ.Gz(AlaTextStickerEditView.this.gwY.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gwY);
                        AlaTextStickerEditView.this.gwZ.bTv();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gwY.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gwY.setText(TextHelper.subString(AlaTextStickerEditView.this.gwY.getText().toString(), 16));
                    AlaTextStickerEditView.this.gwY.setSelection(AlaTextStickerEditView.this.gwY.getText().length());
                    AlaTextStickerEditView.this.gwW.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gwY.getText().length() == 0) {
                    AlaTextStickerEditView.this.gwY.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gwW.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gwW.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gwW.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gwX.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gwX.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gwY.getText()) + 1) / 2)));
            }
        };
        this.gxa = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bSN()) {
                    if (AlaTextStickerEditView.this.gwZ != null) {
                        AlaTextStickerEditView.this.gwZ.Gz(AlaTextStickerEditView.this.gwY.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gwY);
                        AlaTextStickerEditView.this.gwZ.bTv();
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
        this.gwW = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.gwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bTE();
            }
        });
        this.gwX = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.gwX.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.gwY = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.gwY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bTE();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.gwY.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.gxa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTE() {
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            String obj = this.gwY.getText().toString();
            if (j.iQ(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.eo(this.gwY.getText().toString(), this.aGe.mLiveInfo.getLiveTitle());
            } else if (this.gwZ != null) {
                this.gwZ.Gz(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.gwY);
                this.gwZ.bTv();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gxa);
    }

    public void setLiveShowInfo(x xVar) {
        this.aGe = xVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.gwZ = aVar;
    }

    public void GB(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.gwY.setText(str);
            this.gwY.setSelection(this.gwY.getText().length());
            this.gwW.setAlpha(1.0f);
        } else {
            this.gwY.setText("");
            this.gwY.setSelection(0);
            this.gwW.setAlpha(0.7f);
        }
        this.gwY.requestFocus();
        if (this.gwY != null) {
            this.gwY.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gwY);
                }
            });
        }
    }
}
