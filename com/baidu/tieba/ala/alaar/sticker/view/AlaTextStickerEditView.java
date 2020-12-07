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
    private a gmA;
    private HttpMessageListener gmB;
    private TextView gmx;
    private TextView gmy;
    private EditText gmz;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void GB(String str);

        void bQW();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gmz.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gmz.setText(TextHelper.subString(AlaTextStickerEditView.this.gmz.getText().toString(), 16));
                    AlaTextStickerEditView.this.gmz.setSelection(AlaTextStickerEditView.this.gmz.getText().length());
                    AlaTextStickerEditView.this.gmx.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gmz.getText().length() == 0) {
                    AlaTextStickerEditView.this.gmz.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gmx.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gmx.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gmx.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gmy.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gmz.getText()) + 1) / 2)));
            }
        };
        this.gmB = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bQn()) {
                    if (AlaTextStickerEditView.this.gmA != null) {
                        AlaTextStickerEditView.this.gmA.GB(AlaTextStickerEditView.this.gmz.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmz);
                        AlaTextStickerEditView.this.gmA.bQW();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gmz.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gmz.setText(TextHelper.subString(AlaTextStickerEditView.this.gmz.getText().toString(), 16));
                    AlaTextStickerEditView.this.gmz.setSelection(AlaTextStickerEditView.this.gmz.getText().length());
                    AlaTextStickerEditView.this.gmx.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gmz.getText().length() == 0) {
                    AlaTextStickerEditView.this.gmz.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gmx.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gmx.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gmx.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gmy.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gmz.getText()) + 1) / 2)));
            }
        };
        this.gmB = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bQn()) {
                    if (AlaTextStickerEditView.this.gmA != null) {
                        AlaTextStickerEditView.this.gmA.GB(AlaTextStickerEditView.this.gmz.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmz);
                        AlaTextStickerEditView.this.gmA.bQW();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.gmz.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.gmz.setText(TextHelper.subString(AlaTextStickerEditView.this.gmz.getText().toString(), 16));
                    AlaTextStickerEditView.this.gmz.setSelection(AlaTextStickerEditView.this.gmz.getText().length());
                    AlaTextStickerEditView.this.gmx.setAlpha(1.0f);
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.gmz.getText().length() == 0) {
                    AlaTextStickerEditView.this.gmz.setHint(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_striker_text));
                    AlaTextStickerEditView.this.gmx.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.gmx.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.gmx.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.gmy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.c.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.gmy.setText(AlaTextStickerEditView.this.getContext().getString(a.h.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.gmz.getText()) + 1) / 2)));
            }
        };
        this.gmB = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.h.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bQn()) {
                    if (AlaTextStickerEditView.this.gmA != null) {
                        AlaTextStickerEditView.this.gmA.GB(AlaTextStickerEditView.this.gmz.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmz);
                        AlaTextStickerEditView.this.gmA.bQW();
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
        this.gmx = (TextView) findViewById(a.f.ala_sticker_edit_complete);
        this.gmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bRf();
            }
        });
        this.gmy = (TextView) findViewById(a.f.ala_sticker_edit_num);
        this.gmy.setText(getContext().getString(a.h.ala_live_sticker_edit_num, 0));
        this.gmz = (EditText) findViewById(a.f.ala_sticker_edit_view);
        this.gmz.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bRf();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.gmz.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.gmB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRf() {
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            String obj = this.gmz.getText().toString();
            if (j.jb(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.g.ep(this.gmz.getText().toString(), this.aFN.mLiveInfo.getLiveTitle());
            } else if (this.gmA != null) {
                this.gmA.GB(getContext().getResources().getString(a.h.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.gmz);
                this.gmA.bQW();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gmB);
    }

    public void setLiveShowInfo(w wVar) {
        this.aFN = wVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.gmA = aVar;
    }

    public void GD(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.gmz.setText(str);
            this.gmz.setSelection(this.gmz.getText().length());
            this.gmx.setAlpha(1.0f);
        } else {
            this.gmz.setText("");
            this.gmz.setSelection(0);
            this.gmx.setAlpha(0.7f);
        }
        this.gmz.requestFocus();
        if (this.gmz != null) {
            this.gmz.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.gmz);
                }
            });
        }
    }
}
