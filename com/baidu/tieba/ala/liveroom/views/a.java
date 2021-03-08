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
import com.baidu.live.data.as;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes10.dex */
public abstract class a implements e {
    private LinearLayout ajp;
    protected AlaLiveRecorder bDg;
    protected EditText hRb;
    private LinearLayout hRc;
    private CheckBox hRd;
    private CheckBox hRe;
    private TextView hRf;
    protected Button hRg;
    protected d hRh;
    public boolean hRi;
    protected e.b hRk;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hRj = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hRb) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hRb);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hRb);
                }
            }
        }
    };

    protected abstract int bRl();

    protected abstract com.baidu.tieba.ala.category.b.a clf();

    protected abstract int cli();

    protected abstract boolean clj();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hRh = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckY() {
        this.hRb = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hRb.setOnFocusChangeListener(this.focusChangeListener);
        this.hRc = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hRh.aO(this.hRc);
        this.hRd = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hRe = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hRf = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.ajp = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hRg = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        EG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bDg = alaLiveRecorder;
    }

    protected void ckZ() {
        this.bDg.setVideoConfig(com.baidu.live.z.a.b.PI().d(cli(), bRl(), clj()));
    }

    protected boolean cla() {
        return false;
    }

    protected boolean clb() {
        return false;
    }

    public String clc() {
        return com.baidu.live.d.xf().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cld() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(clc())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean clb = clb();
            boolean cla = cla();
            if (clb || cla) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!as.Co()) {
                return cle();
            } else if (clf() == null || clf().bTy() == null || clf().bTz() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hRk != null) {
                this.hRk.d(clf());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean cle() {
        if (this.hRk != null) {
            this.hRi = true;
            ckZ();
            this.hRk.cix();
            if (TextUtils.isEmpty(this.hRb.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void oj(boolean z) {
        if (z) {
            cle();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void EG() {
        this.hRd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.clh();
                if (z) {
                    a.this.hRd.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hRd.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hRe != null) {
            this.hRe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.clh();
                    if (z) {
                        a.this.hRe.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hRe.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hRf != null) {
            this.hRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hRk.ciA();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clg() {
        if (this.hRj) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void clh() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hRb.getText().toString();
    }

    public boolean ceG() {
        return this.hRh.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hRk = bVar;
    }

    public void oi(boolean z) {
        this.hRd.setVisibility(8);
        this.hRd.setChecked(false);
    }

    public boolean ceD() {
        return this.hRd.isChecked();
    }

    public boolean ceE() {
        return this.hRe.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hRj != z) {
            this.hRj = z;
        }
    }

    public void destroy() {
        if (this.hRh != null) {
            this.hRh.destroy();
        }
    }
}
