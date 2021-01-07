package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.f;
import com.baidu.live.ar.k;
import com.baidu.live.ar.l;
import com.baidu.live.ar.m;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes11.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext brR;
    private boolean gxY;
    private m gya;
    private HListView hQJ;
    private com.baidu.tieba.ala.liveroom.h.c hQK;
    private LinearLayout hQL;
    private LinearLayout hQM;
    private Button hQN;
    private Button hQO;
    private Button hQP;
    private Button hQQ;
    private View hQR;
    private GridView hQS;
    private f hQT;
    private SeekBar hQU;
    private SeekBar hQV;
    private SeekBar hQW;
    private SeekBar hQX;
    private SeekBar hQY;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gxY = true;
        this.hQT = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxY = true;
        this.hQT = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxY = true;
        this.hQT = new f();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.g.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.g.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.g.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.g.ala_live_beauty_new_ver_layout, this);
        }
        this.hQJ = (HListView) findViewById(a.f.filter_list_view);
        if (this.hQJ != null) {
            this.hQK = new com.baidu.tieba.ala.liveroom.h.c(this.hQJ);
            this.hQK.uW(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hQJ.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hQJ.setAdapter((ListAdapter) this.hQK);
            this.hQJ.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hQS = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hQS != null) {
            this.hQK = new com.baidu.tieba.ala.liveroom.h.c(this.hQS);
            this.hQS.setAdapter((ListAdapter) this.hQK);
        }
        this.hQK.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void uh(int i) {
                AlaLiveMultiBeautyView.this.hQT.mFilterName = AlaLiveMultiBeautyView.this.hQK.hBC[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.onFilterSelected(AlaLiveMultiBeautyView.this.hQK.hBC[i].gyC, AlaLiveMultiBeautyView.this.hQK.hBC[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hQP = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hQP.setOnClickListener(this);
        this.hQQ.setOnClickListener(this);
        this.hQN = (Button) findViewById(a.f.btn_choose_filter);
        this.hQN.setOnClickListener(this);
        this.hQO = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hQO.setOnClickListener(this);
        this.hQL = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hQM = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hQU = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hQU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQT.aFO = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQV = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hQV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQT.aFP = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQW = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hQW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQT.aFQ = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQX = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hQX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQT.aFS = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQY = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hQY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQT.aFR = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQR = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.CR();
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.onClosed();
                    return true;
                }
                return true;
            }
        });
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void CQ() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void CR() {
        if (this.hQT != null) {
            com.baidu.live.d.Ba().putString("ala_beauty_5.4_config_str", this.hQT.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(k kVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.brR = bdPageContext;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(x xVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gxY && this.hQN.getWidth() != 0) {
            i(this.hQN, false);
            this.gxY = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQN) {
            i(this.hQN, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQN);
            if (this.hQJ != null) {
                setEffectFilterBeautyChooseBlock(this.hQJ);
            } else if (this.hQS != null) {
                setEffectFilterBeautyChooseBlock(this.hQS);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hQO) {
            i(this.hQO, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQO);
            setEffectFilterBeautyChooseBlock(this.hQL);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hQP) {
            i(this.hQP, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQP);
            setEffectFilterBeautyChooseBlock(this.hQM);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hQQ) {
            i(this.hQQ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQQ);
            setEffectFilterBeautyChooseBlock(this.hQM);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hQJ != null) {
            this.hQJ.setVisibility(4);
        }
        if (this.hQS != null) {
            this.hQS.setVisibility(4);
        }
        this.hQL.setVisibility(4);
        this.hQM.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hQN.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hQO.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hQP.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(m mVar) {
        this.gya = mVar;
    }

    private void i(View view, boolean z) {
        this.hQR.clearAnimation();
        int width = (this.hQR.getWidth() / 2) + this.hQR.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hQR.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hQR.getWidth() / 2);
        this.hQR.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hQR.startAnimation(translateAnimation);
        }
    }

    public void setViewData(l lVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (lVar != null && alaLiveVideoConfig != null) {
            f fVar = (f) lVar;
            this.hQU.setProgress(fVar.aFO);
            this.hQV.setProgress(fVar.aFP);
            this.hQW.setProgress(fVar.aFQ);
            this.hQX.setProgress(fVar.aFS);
            this.hQY.setProgress(fVar.aFR);
            this.hQK.In(fVar.mFilterName);
            this.hQK.notifyDataSetChanged();
            this.hQT = fVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hQO.setVisibility(0);
            } else {
                this.hQO.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
