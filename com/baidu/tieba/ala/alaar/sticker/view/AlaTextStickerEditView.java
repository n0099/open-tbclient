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
    private u aDU;
    private a fPA;
    private HttpMessageListener fPB;
    private TextView fPx;
    private TextView fPy;
    private EditText fPz;
    private TextWatcher mTextWatcher;

    /* loaded from: classes4.dex */
    public interface a {
        void Fy(String str);

        void bIT();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fPz.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fPz.setText(TextHelper.subString(AlaTextStickerEditView.this.fPz.getText().toString(), 16));
                    AlaTextStickerEditView.this.fPz.setSelection(AlaTextStickerEditView.this.fPz.getText().length());
                    AlaTextStickerEditView.this.fPx.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fPz.getText().length() == 0) {
                    AlaTextStickerEditView.this.fPz.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fPx.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fPx.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fPx.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fPy.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fPz.getText()) + 1) / 2)));
            }
        };
        this.fPB = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bIl()) {
                    if (AlaTextStickerEditView.this.fPA != null) {
                        AlaTextStickerEditView.this.fPA.Fy(AlaTextStickerEditView.this.fPz.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fPz);
                        AlaTextStickerEditView.this.fPA.bIT();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fPz.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fPz.setText(TextHelper.subString(AlaTextStickerEditView.this.fPz.getText().toString(), 16));
                    AlaTextStickerEditView.this.fPz.setSelection(AlaTextStickerEditView.this.fPz.getText().length());
                    AlaTextStickerEditView.this.fPx.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fPz.getText().length() == 0) {
                    AlaTextStickerEditView.this.fPz.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fPx.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fPx.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fPx.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fPy.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fPz.getText()) + 1) / 2)));
            }
        };
        this.fPB = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bIl()) {
                    if (AlaTextStickerEditView.this.fPA != null) {
                        AlaTextStickerEditView.this.fPA.Fy(AlaTextStickerEditView.this.fPz.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fPz);
                        AlaTextStickerEditView.this.fPA.bIT();
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
                int textLength = TextHelper.getTextLength(AlaTextStickerEditView.this.fPz.getText());
                if (textLength > 16) {
                    AlaTextStickerEditView.this.fPz.setText(TextHelper.subString(AlaTextStickerEditView.this.fPz.getText().toString(), 16));
                    AlaTextStickerEditView.this.fPz.setSelection(AlaTextStickerEditView.this.fPz.getText().length());
                    AlaTextStickerEditView.this.fPx.setAlpha(1.0f);
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_text_length_limit));
                    return;
                }
                if (AlaTextStickerEditView.this.fPz.getText().length() == 0) {
                    AlaTextStickerEditView.this.fPz.setHint(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_striker_text));
                    AlaTextStickerEditView.this.fPx.setAlpha(0.7f);
                } else {
                    AlaTextStickerEditView.this.fPx.setAlpha(1.0f);
                }
                AlaTextStickerEditView.this.fPx.setEnabled(true);
                if (textLength == 16) {
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_color_ff1e66));
                } else {
                    AlaTextStickerEditView.this.fPy.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_white_alpha100));
                }
                AlaTextStickerEditView.this.fPy.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf((TextHelper.getTextLength(AlaTextStickerEditView.this.fPz.getText()) + 1) / 2)));
            }
        };
        this.fPB = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof AntiContentHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.sdk_net_fail_tip));
                } else if (((AntiContentHttpResponseMessage) httpResponsedMessage).bIl()) {
                    if (AlaTextStickerEditView.this.fPA != null) {
                        AlaTextStickerEditView.this.fPA.Fy(AlaTextStickerEditView.this.fPz.getText().toString());
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fPz);
                        AlaTextStickerEditView.this.fPA.bIT();
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
        this.fPx = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.fPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTextStickerEditView.this.bJc();
            }
        });
        this.fPy = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.fPy.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.fPz = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.fPz.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                    case 6:
                        AlaTextStickerEditView.this.bJc();
                        return true;
                    case 5:
                    default:
                        return true;
                }
            }
        });
        this.fPz.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.fPB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJc() {
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            String obj = this.fPz.getText().toString();
            if (j.hT(obj)) {
                BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_live_sticker_text_emoji_limit));
            } else if (!TextUtils.isEmpty(obj)) {
                com.baidu.tieba.ala.alaar.sticker.a.f.ea(this.fPz.getText().toString(), this.aDU.mLiveInfo.getLiveTitle());
            } else if (this.fPA != null) {
                this.fPA.Fy(getContext().getResources().getString(a.i.ala_live_striker_text));
                BdUtilHelper.hideSoftKeyPad(getContext(), this.fPz);
                this.fPA.bIT();
            }
        }
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fPB);
    }

    public void setLiveShowInfo(u uVar) {
        this.aDU = uVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.fPA = aVar;
    }

    public void Fz(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        if (str != null) {
            this.fPz.setText(str);
            this.fPz.setSelection(this.fPz.getText().length());
            this.fPx.setAlpha(1.0f);
        } else {
            this.fPz.setText("");
            this.fPz.setSelection(0);
            this.fPx.setAlpha(0.7f);
        }
        this.fPz.requestFocus();
        if (this.fPz != null) {
            this.fPz.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.fPz);
                }
            });
        }
    }
}
