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
    private w aES;
    private TextView geI;
    private TextView geJ;
    private EditText geK;
    private a geL;
    private HttpMessageListener geM;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void Gl(String str);

        void bNS();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.geK.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.geK.setText(TextHelper.subString(AlaTextStickerEditView.this.geK.getText().toString(), 16));
                    AlaTextStickerEditView.this.geK.setSelection(AlaTextStickerEditView.this.geK.getText().length());
                    AlaTextStickerEditView.this.geI.setAlpha(1.0f);
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.geK.getText().length() == 0) {
                    AlaTextStickerEditView.this.geK.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.geI.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.geI.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.geI.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.geJ.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.geK.getText()) + 1) / 2)));
            }
        };
        this.geM = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bNj()) {
                    if (AlaTextStickerEditView.this.geL != null) {
                        AlaTextStickerEditView.this.geL.Gl(AlaTextStickerEditView.this.geK.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.geK);
                        AlaTextStickerEditView.this.geL.bNS();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.geK.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.geK.setText(TextHelper.subString(AlaTextStickerEditView.this.geK.getText().toString(), 16));
                    AlaTextStickerEditView.this.geK.setSelection(AlaTextStickerEditView.this.geK.getText().length());
                    AlaTextStickerEditView.this.geI.setAlpha(1.0f);
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.geK.getText().length() == 0) {
                    AlaTextStickerEditView.this.geK.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.geI.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.geI.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.geI.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.geJ.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.geK.getText()) + 1) / 2)));
            }
        };
        this.geM = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bNj()) {
                    if (AlaTextStickerEditView.this.geL != null) {
                        AlaTextStickerEditView.this.geL.Gl(AlaTextStickerEditView.this.geK.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.geK);
                        AlaTextStickerEditView.this.geL.bNS();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.geK.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.geK.setText(TextHelper.subString(AlaTextStickerEditView.this.geK.getText().toString(), 16));
                    AlaTextStickerEditView.this.geK.setSelection(AlaTextStickerEditView.this.geK.getText().length());
                    AlaTextStickerEditView.this.geI.setAlpha(1.0f);
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.geK.getText().length() == 0) {
                    AlaTextStickerEditView.this.geK.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.geI.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.geI.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.geI.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.geJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.geJ.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.geK.getText()) + 1) / 2)));
            }
        };
        this.geM = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bNj()) {
                    if (AlaTextStickerEditView.this.geL != null) {
                        AlaTextStickerEditView.this.geL.Gl(AlaTextStickerEditView.this.geK.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.geK);
                        AlaTextStickerEditView.this.geL.bNS();
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
        this.geI = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.geI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bOb();
            }
        });
        this.geJ = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.geJ.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.geK = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.geK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bOb();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.geK.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.geM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOb() {
        if (this.aES != null && this.aES.mLiveInfo != null) {
            String obj = this.geK.getText().toString();
            if (j.iD(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.eh(this.geK.getText().toString(), this.aES.mLiveInfo.getLiveTitle());
            } else if (this.geL != null) {
                this.geL.Gl(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.geK);
                this.geL.bNS();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.geM);
    }

    public void setLiveShowInfo(w wVar) {
        this.aES = wVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.geL = aVar;
    }

    public void Gn(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.geK.setText(str);
            this.geK.setSelection(this.geK.getText().length());
            this.geI.setAlpha(1.0f);
        } else {
            this.geK.setText("");
            this.geK.setSelection(0);
            this.geI.setAlpha(0.7f);
        }
        this.geK.requestFocus();
        if (this.geK != null) {
            this.geK.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.geK);
                }
            });
        }
    }
}
