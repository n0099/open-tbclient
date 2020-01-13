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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes2.dex */
public abstract class a implements f {
    private static final int fip = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout KX;
    public boolean fiA;
    protected f.b fiC;
    protected AlaLiveRecorder fiq;
    protected EditText fir;
    private LinearLayout fis;
    private CheckBox fiu;
    private CheckBox fiv;
    private TextView fiw;
    protected Button fiy;
    protected e fiz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean fiB = false;
    private View.OnFocusChangeListener fiD = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.fir) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fir);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fir);
                }
            }
        }
    };

    protected abstract int bjW();

    protected abstract int bph();

    protected abstract boolean bpi();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fiz = new e(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boZ() {
        this.fir = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.fir.setOnFocusChangeListener(this.fiD);
        this.fis = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.fiz.an(this.fis);
        this.fiu = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.fiv = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.fiw = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.KX = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.fiy = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        re();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.fiq = alaLiveRecorder;
    }

    protected void bpa() {
        this.fiq.setVideoConfig(AlaLiveRecordConfigHelper.bjH().k(bph(), bjW(), bpi()));
    }

    protected boolean bpb() {
        return false;
    }

    protected boolean bpc() {
        return false;
    }

    public String bpd() {
        return com.baidu.live.c.oJ().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bpe() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.fir.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bpd())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bpc = bpc();
        boolean bpb = bpb();
        if (bpc || bpb) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.fiC != null) {
            this.fiA = true;
            bpa();
            this.fiC.bmR();
            if (!TextUtils.isEmpty(this.fir.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void re() {
        this.fiu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bpg();
                if (z) {
                    a.this.fiu.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.fiu.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.fiv != null) {
            this.fiv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bpg();
                    if (z) {
                        a.this.fiv.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.fiv.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.fiw != null) {
            this.fiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fiC.bmU();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpf() {
        if (this.fiB) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bpg() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.fir.getText().toString();
    }

    public boolean bjP() {
        return this.fiz.isShowLocation();
    }

    public void a(f.b bVar) {
        this.fiC = bVar;
    }

    public void jk(boolean z) {
        this.fiu.setVisibility(8);
        this.fiu.setChecked(false);
    }

    public boolean bjM() {
        return this.fiu.isChecked();
    }

    public boolean bjN() {
        return this.fiv.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fiB != z) {
            this.fiB = z;
        }
    }

    public void destroy() {
        if (this.fiz != null) {
            this.fiz.destroy();
        }
    }
}
