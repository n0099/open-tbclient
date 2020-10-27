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
import com.baidu.live.data.ak;
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
    protected AlaLiveRecorder bAW;
    protected EditText hog;
    private LinearLayout hoh;
    private CheckBox hoi;
    private CheckBox hoj;
    private TextView hok;
    protected Button hol;
    protected d hom;
    public boolean hon;
    protected e.b hop;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hoo = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hog) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hog);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hog);
                }
            }
        }
    };

    protected abstract int bYP();

    protected abstract com.baidu.tieba.ala.category.b.a cfd();

    protected abstract int cfg();

    protected abstract boolean cfh();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hom = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceW() {
        this.hog = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.hog.setOnFocusChangeListener(this.focusChangeListener);
        this.hoh = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.hom.aE(this.hoh);
        this.hoi = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.hoj = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.hok = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.ahm = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.hol = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        Ga();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bAW = alaLiveRecorder;
    }

    protected void ceX() {
        this.bAW.setVideoConfig(LiveRecorderConfigHelper.ON().d(cfg(), bYP(), cfh()));
    }

    protected boolean ceY() {
        return false;
    }

    protected boolean ceZ() {
        return false;
    }

    public String cfa() {
        return com.baidu.live.d.AZ().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cfb() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(cfa())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        } else {
            boolean ceZ = ceZ();
            boolean ceY = ceY();
            if (ceZ || ceY) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.i.ala_create_to_retry);
                return false;
            } else if (!ak.Ef()) {
                return cfc();
            } else if (cfd() == null || cfd().bOq() == null || cfd().bOr() == null) {
                this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hop != null) {
                this.hop.d(cfd());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean cfc() {
        if (this.hop != null) {
            this.hon = true;
            ceX();
            this.hop.ccF();
            if (TextUtils.isEmpty(this.hog.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void mX(boolean z) {
        if (z) {
            cfc();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void Ga() {
        this.hoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cff();
                if (z) {
                    a.this.hoi.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hoi.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hoj != null) {
            this.hoj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.cff();
                    if (z) {
                        a.this.hoj.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hoj.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hok != null) {
            this.hok.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hop.ccI();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cfe() {
        if (this.hoo) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void cff() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hog.getText().toString();
    }

    public boolean bYI() {
        return this.hom.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hop = bVar;
    }

    public void mW(boolean z) {
        this.hoi.setVisibility(8);
        this.hoi.setChecked(false);
    }

    public boolean bYF() {
        return this.hoi.isChecked();
    }

    public boolean bYG() {
        return this.hoj.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hoo != z) {
            this.hoo = z;
        }
    }

    public void destroy() {
        if (this.hom != null) {
            this.hom.destroy();
        }
    }
}
