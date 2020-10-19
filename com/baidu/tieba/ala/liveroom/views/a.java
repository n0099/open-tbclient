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
import com.baidu.live.data.ah;
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
    private LinearLayout ahl;
    protected AlaLiveRecorder bya;
    protected EditText hcq;
    private LinearLayout hcr;
    private CheckBox hcs;
    private CheckBox hct;
    private TextView hcu;
    protected Button hcv;
    protected d hcw;
    public boolean hcx;
    protected e.b hcz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hcy = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hcq) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hcq);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hcq);
                }
            }
        }
    };

    protected abstract int bVQ();

    protected abstract com.baidu.tieba.ala.category.b.a cbZ();

    protected abstract int ccc();

    protected abstract boolean ccd();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hcw = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbS() {
        this.hcq = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.hcq.setOnFocusChangeListener(this.focusChangeListener);
        this.hcr = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.hcw.aF(this.hcr);
        this.hcs = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.hct = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.hcu = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.ahl = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.hcv = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        FL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bya = alaLiveRecorder;
    }

    protected void cbT() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.Op().d(ccc(), bVQ(), ccd()));
    }

    protected boolean cbU() {
        return false;
    }

    protected boolean cbV() {
        return false;
    }

    public String cbW() {
        return com.baidu.live.c.AZ().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cbX() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(cbW())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        } else {
            boolean cbV = cbV();
            boolean cbU = cbU();
            if (cbV || cbU) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.i.ala_create_to_retry);
                return false;
            } else if (!ah.DW()) {
                return cbY();
            } else if (cbZ() == null || cbZ().bLO() == null || cbZ().bLP() == null) {
                this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hcz != null) {
                this.hcz.d(cbZ());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean cbY() {
        if (this.hcz != null) {
            this.hcx = true;
            cbT();
            this.hcz.bZB();
            if (TextUtils.isEmpty(this.hcq.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void mH(boolean z) {
        if (z) {
            cbY();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void FL() {
        this.hcs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.ccb();
                if (z) {
                    a.this.hcs.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hcs.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hct != null) {
            this.hct.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.ccb();
                    if (z) {
                        a.this.hct.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hct.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hcu != null) {
            this.hcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hcz.bZE();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cca() {
        if (this.hcy) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void ccb() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hcq.getText().toString();
    }

    public boolean bVJ() {
        return this.hcw.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hcz = bVar;
    }

    public void mG(boolean z) {
        this.hcs.setVisibility(8);
        this.hcs.setChecked(false);
    }

    public boolean bVG() {
        return this.hcs.isChecked();
    }

    public boolean bVH() {
        return this.hct.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hcy != z) {
            this.hcy = z;
        }
    }

    public void destroy() {
        if (this.hcw != null) {
            this.hcw.destroy();
        }
    }
}
