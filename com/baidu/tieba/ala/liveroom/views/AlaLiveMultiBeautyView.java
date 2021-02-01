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
    private boolean gwb;
    private m gwd;
    private LinearLayout hQA;
    private Button hQB;
    private Button hQC;
    private Button hQD;
    private Button hQE;
    private View hQF;
    private GridView hQG;
    private f hQH;
    private SeekBar hQI;
    private SeekBar hQJ;
    private SeekBar hQK;
    private SeekBar hQL;
    private SeekBar hQM;
    private HListView hQx;
    private com.baidu.tieba.ala.liveroom.g.c hQy;
    private LinearLayout hQz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gwb = true;
        this.hQH = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwb = true;
        this.hQH = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwb = true;
        this.hQH = new f();
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
        this.hQx = (HListView) findViewById(a.f.filter_list_view);
        if (this.hQx != null) {
            this.hQy = new com.baidu.tieba.ala.liveroom.g.c(this.hQx);
            this.hQy.tw(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hQx.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hQx.setAdapter((ListAdapter) this.hQy);
            this.hQx.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hQG = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hQG != null) {
            this.hQy = new com.baidu.tieba.ala.liveroom.g.c(this.hQG);
            this.hQG.setAdapter((ListAdapter) this.hQy);
        }
        this.hQy.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void sG(int i) {
                AlaLiveMultiBeautyView.this.hQH.mFilterName = AlaLiveMultiBeautyView.this.hQy.hBg[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.onFilterSelected(AlaLiveMultiBeautyView.this.hQy.hBg[i].gwF, AlaLiveMultiBeautyView.this.hQy.hBg[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hQD = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hQD.setOnClickListener(this);
        this.hQE.setOnClickListener(this);
        this.hQB = (Button) findViewById(a.f.btn_choose_filter);
        this.hQB.setOnClickListener(this);
        this.hQC = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hQC.setOnClickListener(this);
        this.hQz = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hQA = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hQI = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hQI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQH.aCG = i;
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQJ = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hQJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQH.aCH = i;
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQK = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hQK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQH.aCI = i;
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQL = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hQL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQH.aCK = i;
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQM = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hQM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hQH.aCJ = i;
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hQF = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.zD();
                if (AlaLiveMultiBeautyView.this.gwd != null) {
                    AlaLiveMultiBeautyView.this.gwd.onClosed();
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
        if (this.hQH != null) {
            com.baidu.live.d.xc().putString("ala_beauty_5.4_config_str", this.hQH.toJsonString());
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
        if (this.gwb && this.hQB.getWidth() != 0) {
            i(this.hQB, false);
            this.gwb = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQB) {
            i(this.hQB, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQB);
            if (this.hQx != null) {
                setEffectFilterBeautyChooseBlock(this.hQx);
            } else if (this.hQG != null) {
                setEffectFilterBeautyChooseBlock(this.hQG);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hQC) {
            i(this.hQC, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQC);
            setEffectFilterBeautyChooseBlock(this.hQz);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hQD) {
            i(this.hQD, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQD);
            setEffectFilterBeautyChooseBlock(this.hQA);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hQE) {
            i(this.hQE, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hQE);
            setEffectFilterBeautyChooseBlock(this.hQA);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hQx != null) {
            this.hQx.setVisibility(4);
        }
        if (this.hQG != null) {
            this.hQG.setVisibility(4);
        }
        this.hQz.setVisibility(4);
        this.hQA.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hQB.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hQC.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hQD.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(m mVar) {
        this.gwd = mVar;
    }

    private void i(View view, boolean z) {
        this.hQF.clearAnimation();
        int width = (this.hQF.getWidth() / 2) + this.hQF.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hQF.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hQF.getWidth() / 2);
        this.hQF.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hQF.startAnimation(translateAnimation);
        }
    }

    public void setViewData(l lVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (lVar != null && alaLiveVideoConfig != null) {
            f fVar = (f) lVar;
            this.hQI.setProgress(fVar.aCG);
            this.hQJ.setProgress(fVar.aCH);
            this.hQK.setProgress(fVar.aCI);
            this.hQL.setProgress(fVar.aCK);
            this.hQM.setProgress(fVar.aCJ);
            this.hQy.HG(fVar.mFilterName);
            this.hQy.notifyDataSetChanged();
            this.hQH = fVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hQC.setVisibility(0);
            } else {
                this.hQC.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
