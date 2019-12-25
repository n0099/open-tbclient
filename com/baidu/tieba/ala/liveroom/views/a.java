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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes2.dex */
public abstract class a implements f {
    private static final int ffg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout KS;
    protected AlaLiveRecorder ffh;
    protected EditText ffi;
    private LinearLayout ffj;
    private CheckBox ffk;
    private CheckBox ffl;
    private TextView ffm;
    protected Button ffn;
    protected e ffo;
    public boolean ffp;
    protected f.b ffr;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean ffq = false;
    private View.OnFocusChangeListener ffs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.ffi) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.ffi);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.ffi);
                }
            }
        }
    };

    protected abstract int bjk();

    protected abstract int bog();

    protected abstract boolean boh();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ffo = new e(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bnY() {
        this.ffi = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.ffi.setOnFocusChangeListener(this.ffs);
        this.ffj = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.ffo.aj(this.ffj);
        this.ffk = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.ffl = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.ffm = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.KS = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.ffn = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        qS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.ffh = alaLiveRecorder;
    }

    protected void bnZ() {
        this.ffh.setVideoConfig(AlaLiveRecordConfigHelper.biV().k(bog(), bjk(), boh()));
    }

    protected boolean boa() {
        return false;
    }

    protected boolean bob() {
        return false;
    }

    public String boc() {
        return com.baidu.live.c.oI().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bod() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.ffi.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(boc())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bob = bob();
        boolean boa = boa();
        if (bob || boa) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.ffr != null) {
            this.ffp = true;
            bnZ();
            this.ffr.blT();
            if (!TextUtils.isEmpty(this.ffi.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void qS() {
        this.ffk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bof();
                if (z) {
                    a.this.ffk.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.ffk.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.ffl != null) {
            this.ffl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bof();
                    if (z) {
                        a.this.ffl.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.ffl.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.ffm != null) {
            this.ffm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ffr.blW();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boe() {
        if (this.ffq) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bof() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.ffi.getText().toString();
    }

    public boolean bjd() {
        return this.ffo.isShowLocation();
    }

    public void a(f.b bVar) {
        this.ffr = bVar;
    }

    public void jb(boolean z) {
        this.ffk.setVisibility(8);
        this.ffk.setChecked(false);
    }

    public boolean bja() {
        return this.ffk.isChecked();
    }

    public boolean bjb() {
        return this.ffl.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ffq != z) {
            this.ffq = z;
        }
    }

    public void destroy() {
        if (this.ffo != null) {
            this.ffo.destroy();
        }
    }
}
