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
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes11.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bqG;
    private boolean gwp;
    private m gwr;
    private HListView hQL;
    private com.baidu.tieba.ala.liveroom.g.c hQM;
    private LinearLayout hQN;
    private LinearLayout hQO;
    private Button hQP;
    private Button hQQ;
    private Button hQR;
    private Button hQS;
    private View hQT;
    private GridView hQU;
    private f hQV;
    private SeekBar hQW;
    private SeekBar hQX;
    private SeekBar hQY;
    private SeekBar hQZ;
    private SeekBar hRa;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gwp = true;
        this.hQV = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwp = true;
        this.hQV = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwp = true;
        this.hQV = new f();
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
        this.hQL = (HListView) findViewById(a.f.filter_list_view);
        if (this.hQL != null) {
            this.hQM = new com.baidu.tieba.ala.liveroom.g.c(this.hQL);
            this.hQM.tw(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hQL.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hQL.setAdapter((ListAdapter) this.hQM);
            this.hQL.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hQU = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hQU != null) {
            this.hQM = new com.baidu.tieba.ala.liveroom.g.c(this.hQU);
            this.hQU.setAdapter((ListAdapter) this.hQM);
        }
        this.hQM.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void sG(int i) {
                AlaLiveMultiBeautyView.this.hQV.mFilterName = AlaLiveMultiBeautyView.this.hQM.hBu[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.onFilterSelected(AlaLiveMultiBeautyView.this.hQM.hBu[i].gwT, AlaLiveMultiBeautyView.this.hQM.hBu[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hQR = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hQR.setOnClickListener(this);
        this.hQS.setOnClickListener(this);
        this.hQP = (Button) findViewById(a.f.btn_choose_filter);
        this.hQP.setOnClickListener(this);
        this.hQQ = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hQQ.setOnClickListener(this);
        this.hQN = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hQO = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hQW = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hQW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQV.aCG = i;
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQX = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hQX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQV.aCH = i;
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQY = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hQY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQV.aCI = i;
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQZ = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hQZ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQV.aCK = i;
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hRa = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hRa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQV.aCJ = i;
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQT = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.zD();
                if (AlaLiveMultiBeautyView.this.gwr != null) {
                    AlaLiveMultiBeautyView.this.gwr.onClosed();
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
    public void zC() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zD() {
        if (this.hQV != null) {
            com.baidu.live.d.xc().putString("ala_beauty_5.4_config_str", this.hQV.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(k kVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqG = bdPageContext;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(ab abVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gwp && this.hQP.getWidth() != 0) {
            i(this.hQP, false);
            this.gwp = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQP) {
            i(this.hQP, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQP);
            if (this.hQL != null) {
                setEffectFilterBeautyChooseBlock(this.hQL);
            } else if (this.hQU != null) {
                setEffectFilterBeautyChooseBlock(this.hQU);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hQQ) {
            i(this.hQQ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQQ);
            setEffectFilterBeautyChooseBlock(this.hQN);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hQR) {
            i(this.hQR, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQR);
            setEffectFilterBeautyChooseBlock(this.hQO);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hQS) {
            i(this.hQS, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQS);
            setEffectFilterBeautyChooseBlock(this.hQO);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hQL != null) {
            this.hQL.setVisibility(4);
        }
        if (this.hQU != null) {
            this.hQU.setVisibility(4);
        }
        this.hQN.setVisibility(4);
        this.hQO.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hQP.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hQQ.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hQR.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(m mVar) {
        this.gwr = mVar;
    }

    private void i(View view, boolean z) {
        this.hQT.clearAnimation();
        int width = (this.hQT.getWidth() / 2) + this.hQT.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hQT.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hQT.getWidth() / 2);
        this.hQT.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hQT.startAnimation(translateAnimation);
        }
    }

    public void setViewData(l lVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (lVar != null && alaLiveVideoConfig != null) {
            f fVar = (f) lVar;
            this.hQW.setProgress(fVar.aCG);
            this.hQX.setProgress(fVar.aCH);
            this.hQY.setProgress(fVar.aCI);
            this.hQZ.setProgress(fVar.aCK);
            this.hRa.setProgress(fVar.aCJ);
            this.hQM.HH(fVar.mFilterName);
            this.hQM.notifyDataSetChanged();
            this.hQV = fVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hQQ.setVisibility(0);
            } else {
                this.hQQ.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
