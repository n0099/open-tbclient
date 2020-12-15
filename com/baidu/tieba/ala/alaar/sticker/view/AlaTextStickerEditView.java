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
    private w aFN;
    private TextView gmA;
    private EditText gmB;
    private a gmC;
    private HttpMessageListener gmD;
    private TextView gmz;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void GB(String str);

        void bQX();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gmB.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gmB.setText(TextHelper.subString(AlaTextStickerEditView.this.gmB.getText().toString(), 16));
                    AlaTextStickerEditView.this.gmB.setSelection(AlaTextStickerEditView.this.gmB.getText().length());
                    AlaTextStickerEditView.this.gmz.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gmB.getText().length() == 0) {
                    AlaTextStickerEditView.this.gmB.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gmz.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gmz.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gmz.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gmA.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gmB.getText()) + 1) / 2)));
            }
        };
        this.gmD = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bQo()) {
                    if (AlaTextStickerEditView.this.gmC != null) {
                        AlaTextStickerEditView.this.gmC.GB(AlaTextStickerEditView.this.gmB.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmB);
                        AlaTextStickerEditView.this.gmC.bQX();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gmB.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gmB.setText(TextHelper.subString(AlaTextStickerEditView.this.gmB.getText().toString(), 16));
                    AlaTextStickerEditView.this.gmB.setSelection(AlaTextStickerEditView.this.gmB.getText().length());
                    AlaTextStickerEditView.this.gmz.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gmB.getText().length() == 0) {
                    AlaTextStickerEditView.this.gmB.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gmz.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gmz.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gmz.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gmA.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gmB.getText()) + 1) / 2)));
            }
        };
        this.gmD = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bQo()) {
                    if (AlaTextStickerEditView.this.gmC != null) {
                        AlaTextStickerEditView.this.gmC.GB(AlaTextStickerEditView.this.gmB.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmB);
                        AlaTextStickerEditView.this.gmC.bQX();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gmB.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gmB.setText(TextHelper.subString(AlaTextStickerEditView.this.gmB.getText().toString(), 16));
                    AlaTextStickerEditView.this.gmB.setSelection(AlaTextStickerEditView.this.gmB.getText().length());
                    AlaTextStickerEditView.this.gmz.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gmB.getText().length() == 0) {
                    AlaTextStickerEditView.this.gmB.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gmz.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gmz.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gmz.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gmA.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gmA.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gmB.getText()) + 1) / 2)));
            }
        };
        this.gmD = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bQo()) {
                    if (AlaTextStickerEditView.this.gmC != null) {
                        AlaTextStickerEditView.this.gmC.GB(AlaTextStickerEditView.this.gmB.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmB);
                        AlaTextStickerEditView.this.gmC.bQX();
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
        this.gmz = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.gmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bRg();
            }
        });
        this.gmA = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.gmA.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.gmB = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.gmB.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bRg();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.gmB.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.gmD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRg() {
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            String obj = this.gmB.getText().toString();
            if (j.jb(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.ep(this.gmB.getText().toString(), this.aFN.mLiveInfo.getLiveTitle());
            } else if (this.gmC != null) {
                this.gmC.GB(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.gmB);
                this.gmC.bQX();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gmD);
    }

    public void setLiveShowInfo(w wVar) {
        this.aFN = wVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.gmC = aVar;
    }

    public void GD(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.gmB.setText(str);
            this.gmB.setSelection(this.gmB.getText().length());
            this.gmz.setAlpha(1.0f);
        } else {
            this.gmB.setText("");
            this.gmB.setSelection(0);
            this.gmz.setAlpha(0.7f);
        }
        this.gmB.requestFocus();
        if (this.gmB != null) {
            this.gmB.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmB);
                }
            });
        }
    }
}
