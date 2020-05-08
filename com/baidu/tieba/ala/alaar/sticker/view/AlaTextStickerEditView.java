package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.n;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes3.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private n aDK;
    private TextView eMa;
    private TextView eMb;
    private EditText eMc;
    private a eMd;
    private HttpMessageListener eMe;
    private TextWatcher mTextWatcher;

    /* loaded from: classes3.dex */
    public interface a {
        void zl(String str);
    }

    public AlaTextStickerEditView(Context context) {
        super(context);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (AlaTextStickerEditView.this.eMc.getText().length() > 8) {
                    AlaTextStickerEditView.this.eMc.setText(AlaTextStickerEditView.this.eMc.getText().toString().substring(0, 8));
                    AlaTextStickerEditView.this.eMc.setSelection(AlaTextStickerEditView.this.eMc.getText().length());
                    return;
                }
                if (AlaTextStickerEditView.this.eMc.getText().length() == 0) {
                    AlaTextStickerEditView.this.eMa.setEnabled(false);
                } else {
                    AlaTextStickerEditView.this.eMa.setEnabled(true);
                }
                if (AlaTextStickerEditView.this.eMc.getText().length() == 8) {
                    AlaTextStickerEditView.this.eMb.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_other_b));
                } else {
                    AlaTextStickerEditView.this.eMb.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                }
                AlaTextStickerEditView.this.eMb.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf(AlaTextStickerEditView.this.eMc.getText().length())));
            }
        };
        this.eMe = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof AntiContentHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (((AntiContentHttpResponseMessage) httpResponsedMessage).bkg()) {
                        if (AlaTextStickerEditView.this.eMd != null) {
                            AlaTextStickerEditView.this.eMd.zl(AlaTextStickerEditView.this.eMc.getText().toString());
                        }
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eMc);
                        return;
                    }
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    public AlaTextStickerEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (AlaTextStickerEditView.this.eMc.getText().length() > 8) {
                    AlaTextStickerEditView.this.eMc.setText(AlaTextStickerEditView.this.eMc.getText().toString().substring(0, 8));
                    AlaTextStickerEditView.this.eMc.setSelection(AlaTextStickerEditView.this.eMc.getText().length());
                    return;
                }
                if (AlaTextStickerEditView.this.eMc.getText().length() == 0) {
                    AlaTextStickerEditView.this.eMa.setEnabled(false);
                } else {
                    AlaTextStickerEditView.this.eMa.setEnabled(true);
                }
                if (AlaTextStickerEditView.this.eMc.getText().length() == 8) {
                    AlaTextStickerEditView.this.eMb.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_other_b));
                } else {
                    AlaTextStickerEditView.this.eMb.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                }
                AlaTextStickerEditView.this.eMb.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf(AlaTextStickerEditView.this.eMc.getText().length())));
            }
        };
        this.eMe = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof AntiContentHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (((AntiContentHttpResponseMessage) httpResponsedMessage).bkg()) {
                        if (AlaTextStickerEditView.this.eMd != null) {
                            AlaTextStickerEditView.this.eMd.zl(AlaTextStickerEditView.this.eMc.getText().toString());
                        }
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eMc);
                        return;
                    }
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    public AlaTextStickerEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (AlaTextStickerEditView.this.eMc.getText().length() > 8) {
                    AlaTextStickerEditView.this.eMc.setText(AlaTextStickerEditView.this.eMc.getText().toString().substring(0, 8));
                    AlaTextStickerEditView.this.eMc.setSelection(AlaTextStickerEditView.this.eMc.getText().length());
                    return;
                }
                if (AlaTextStickerEditView.this.eMc.getText().length() == 0) {
                    AlaTextStickerEditView.this.eMa.setEnabled(false);
                } else {
                    AlaTextStickerEditView.this.eMa.setEnabled(true);
                }
                if (AlaTextStickerEditView.this.eMc.getText().length() == 8) {
                    AlaTextStickerEditView.this.eMb.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_other_b));
                } else {
                    AlaTextStickerEditView.this.eMb.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                }
                AlaTextStickerEditView.this.eMb.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf(AlaTextStickerEditView.this.eMc.getText().length())));
            }
        };
        this.eMe = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof AntiContentHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (((AntiContentHttpResponseMessage) httpResponsedMessage).bkg()) {
                        if (AlaTextStickerEditView.this.eMd != null) {
                            AlaTextStickerEditView.this.eMd.zl(AlaTextStickerEditView.this.eMc.getText().toString());
                        }
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eMc);
                        return;
                    }
                    BdUtilHelper.showToast(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.getContext().getResources().getString(a.i.ala_live_sticker_edit_anti));
                }
            }
        };
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_sticker_edit_view, this);
        setBackgroundColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
        this.eMa = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.eMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaTextStickerEditView.this.aDK != null && AlaTextStickerEditView.this.aDK.mLiveInfo != null) {
                    com.baidu.tieba.ala.alaar.sticker.a.f.cZ(AlaTextStickerEditView.this.eMc.getText().toString(), AlaTextStickerEditView.this.aDK.mLiveInfo.getLiveTitle());
                }
            }
        });
        this.eMb = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.eMb.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.eMc = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.eMc.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eMe);
    }

    public void setLiveShowInfo(n nVar) {
        this.aDK = nVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.eMd = aVar;
    }

    public void show(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        if (!StringUtils.isNull(str)) {
            this.eMc.setText(str);
            this.eMc.setSelection(this.eMc.getText().length());
        }
        this.eMc.requestFocus();
        if (this.eMc != null) {
            this.eMc.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eMc);
                }
            });
        }
    }
}
