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
import com.baidu.live.data.q;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
/* loaded from: classes3.dex */
public class AlaTextStickerEditView extends RelativeLayout {
    private q aJj;
    private TextView eYI;
    private TextView eYJ;
    private EditText eYK;
    private a eYL;
    private HttpMessageListener eYM;
    private TextWatcher mTextWatcher;

    /* loaded from: classes3.dex */
    public interface a {
        void AR(String str);
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
                if (AlaTextStickerEditView.this.eYK.getText().length() > 8) {
                    AlaTextStickerEditView.this.eYK.setText(AlaTextStickerEditView.this.eYK.getText().toString().substring(0, 8));
                    AlaTextStickerEditView.this.eYK.setSelection(AlaTextStickerEditView.this.eYK.getText().length());
                    return;
                }
                if (AlaTextStickerEditView.this.eYK.getText().length() == 0) {
                    AlaTextStickerEditView.this.eYI.setEnabled(false);
                } else {
                    AlaTextStickerEditView.this.eYI.setEnabled(true);
                }
                if (AlaTextStickerEditView.this.eYK.getText().length() == 8) {
                    AlaTextStickerEditView.this.eYJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_other_b));
                } else {
                    AlaTextStickerEditView.this.eYJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                }
                AlaTextStickerEditView.this.eYJ.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf(AlaTextStickerEditView.this.eYK.getText().length())));
            }
        };
        this.eYM = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof AntiContentHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (((AntiContentHttpResponseMessage) httpResponsedMessage).bpC()) {
                        if (AlaTextStickerEditView.this.eYL != null) {
                            AlaTextStickerEditView.this.eYL.AR(AlaTextStickerEditView.this.eYK.getText().toString());
                        }
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eYK);
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
                if (AlaTextStickerEditView.this.eYK.getText().length() > 8) {
                    AlaTextStickerEditView.this.eYK.setText(AlaTextStickerEditView.this.eYK.getText().toString().substring(0, 8));
                    AlaTextStickerEditView.this.eYK.setSelection(AlaTextStickerEditView.this.eYK.getText().length());
                    return;
                }
                if (AlaTextStickerEditView.this.eYK.getText().length() == 0) {
                    AlaTextStickerEditView.this.eYI.setEnabled(false);
                } else {
                    AlaTextStickerEditView.this.eYI.setEnabled(true);
                }
                if (AlaTextStickerEditView.this.eYK.getText().length() == 8) {
                    AlaTextStickerEditView.this.eYJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_other_b));
                } else {
                    AlaTextStickerEditView.this.eYJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                }
                AlaTextStickerEditView.this.eYJ.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf(AlaTextStickerEditView.this.eYK.getText().length())));
            }
        };
        this.eYM = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof AntiContentHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (((AntiContentHttpResponseMessage) httpResponsedMessage).bpC()) {
                        if (AlaTextStickerEditView.this.eYL != null) {
                            AlaTextStickerEditView.this.eYL.AR(AlaTextStickerEditView.this.eYK.getText().toString());
                        }
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eYK);
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
                if (AlaTextStickerEditView.this.eYK.getText().length() > 8) {
                    AlaTextStickerEditView.this.eYK.setText(AlaTextStickerEditView.this.eYK.getText().toString().substring(0, 8));
                    AlaTextStickerEditView.this.eYK.setSelection(AlaTextStickerEditView.this.eYK.getText().length());
                    return;
                }
                if (AlaTextStickerEditView.this.eYK.getText().length() == 0) {
                    AlaTextStickerEditView.this.eYI.setEnabled(false);
                } else {
                    AlaTextStickerEditView.this.eYI.setEnabled(true);
                }
                if (AlaTextStickerEditView.this.eYK.getText().length() == 8) {
                    AlaTextStickerEditView.this.eYJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_other_b));
                } else {
                    AlaTextStickerEditView.this.eYJ.setTextColor(AlaTextStickerEditView.this.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                }
                AlaTextStickerEditView.this.eYJ.setText(AlaTextStickerEditView.this.getContext().getString(a.i.ala_live_sticker_edit_num, Integer.valueOf(AlaTextStickerEditView.this.eYK.getText().length())));
            }
        };
        this.eYM = new HttpMessageListener(1021158) { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof AntiContentHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (((AntiContentHttpResponseMessage) httpResponsedMessage).bpC()) {
                        if (AlaTextStickerEditView.this.eYL != null) {
                            AlaTextStickerEditView.this.eYL.AR(AlaTextStickerEditView.this.eYK.getText().toString());
                        }
                        BdUtilHelper.hideSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eYK);
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
        this.eYI = (TextView) findViewById(a.g.ala_sticker_edit_complete);
        this.eYI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaTextStickerEditView.this.aJj != null && AlaTextStickerEditView.this.aJj.mLiveInfo != null) {
                    com.baidu.tieba.ala.alaar.sticker.a.f.dx(AlaTextStickerEditView.this.eYK.getText().toString(), AlaTextStickerEditView.this.aJj.mLiveInfo.getLiveTitle());
                }
            }
        });
        this.eYJ = (TextView) findViewById(a.g.ala_sticker_edit_num);
        this.eYJ.setText(getContext().getString(a.i.ala_live_sticker_edit_num, 0));
        this.eYK = (EditText) findViewById(a.g.ala_sticker_edit_view);
        this.eYK.addTextChangedListener(this.mTextWatcher);
        MessageManager.getInstance().registerListener(this.eYM);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eYM);
    }

    public void setLiveShowInfo(q qVar) {
        this.aJj = qVar;
    }

    public void setTextEditCompleteListener(a aVar) {
        this.eYL = aVar;
    }

    public void show(String str) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        if (!StringUtils.isNull(str)) {
            this.eYK.setText(str);
            this.eYK.setSelection(this.eYK.getText().length());
        }
        this.eYK.requestFocus();
        if (this.eYK != null) {
            this.eYK.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.2
                @Override // java.lang.Runnable
                public void run() {
                    BdUtilHelper.showSoftKeyPad(AlaTextStickerEditView.this.getContext(), AlaTextStickerEditView.this.eYK);
                }
            });
        }
    }
}
