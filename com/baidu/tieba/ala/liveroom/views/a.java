package com.baidu.tieba.ala.liveroom.views;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.al;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public abstract class a implements e {
    private LinearLayout ahm;
    protected AlaLiveRecorder buC;
    protected EditText hue;
    private LinearLayout huf;
    private CheckBox hug;
    private CheckBox huh;
    private TextView hui;
    protected Button huj;
    protected d huk;
    public boolean hul;
    protected e.b hun;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hum = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hue) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hue);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hue);
                }
            }
        }
    };

    protected abstract int cbr();

    protected abstract com.baidu.tieba.ala.category.b.a chG();

    protected abstract int chJ();

    protected abstract boolean chK();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.huk = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void chz() {
        this.hue = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hue.setOnFocusChangeListener(this.focusChangeListener);
        this.huf = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.huk.aG(this.huf);
        this.hug = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.huh = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hui = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.ahm = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.huj = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        GB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.buC = alaLiveRecorder;
    }

    protected void chA() {
        this.buC.setVideoConfig(LiveRecorderConfigHelper.Pn().d(chJ(), cbr(), chK()));
    }

    protected boolean chB() {
        return false;
    }

    protected boolean chC() {
        return false;
    }

    public String chD() {
        return com.baidu.live.d.AZ().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean chE() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(chD())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean chC = chC();
            boolean chB = chB();
            if (chC || chB) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!al.EB()) {
                return chF();
            } else if (chG() == null || chG().bQQ() == null || chG().bQR() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hun != null) {
                this.hun.d(chG());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean chF() {
        if (this.hun != null) {
            this.hul = true;
            chA();
            this.hun.cfg();
            if (TextUtils.isEmpty(this.hue.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void ng(boolean z) {
        if (z) {
            chF();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void GB() {
        this.hug.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.chI();
                if (z) {
                    a.this.hug.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hug.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.huh != null) {
            this.huh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.chI();
                    if (z) {
                        a.this.huh.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.huh.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hui != null) {
            this.hui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hun.cfj();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void chH() {
        if (this.hum) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void chI() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hue.getText().toString();
    }

    public boolean cbk() {
        return this.huk.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hun = bVar;
    }

    public void nf(boolean z) {
        this.hug.setVisibility(8);
        this.hug.setChecked(false);
    }

    public boolean cbh() {
        return this.hug.isChecked();
    }

    public boolean cbi() {
        return this.huh.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hum != z) {
            this.hum = z;
        }
    }

    public void destroy() {
        if (this.huk != null) {
            this.huk.destroy();
        }
    }
}
