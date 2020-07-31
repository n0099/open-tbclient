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
import com.baidu.live.ar.h;
import com.baidu.live.ar.i;
import com.baidu.live.ar.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aXY;
    private LinearLayout fpR;
    private Button fpV;
    private Button fpW;
    private Button fpX;
    private View fpY;
    private boolean fpZ;
    private j fqb;
    private HListView gyV;
    private com.baidu.tieba.ala.liveroom.h.c gyW;
    private LinearLayout gyX;
    private GridView gyY;
    private com.baidu.tieba.ala.liveroom.data.d gyZ;
    private SeekBar gza;
    private SeekBar gzb;
    private SeekBar gzc;
    private SeekBar gzd;
    private SeekBar gze;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fpZ = true;
        this.gyZ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpZ = true;
        this.gyZ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpZ = true;
        this.gyZ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
        }
        this.gyV = (HListView) findViewById(a.g.filter_list_view);
        if (this.gyV != null) {
            this.gyW = new com.baidu.tieba.ala.liveroom.h.c(this.gyV);
            this.gyW.ql(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gyV.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gyV.setAdapter((ListAdapter) this.gyW);
            this.gyV.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.gyY = (GridView) findViewById(a.g.filter_grid_view);
        if (this.gyY != null) {
            this.gyW = new com.baidu.tieba.ala.liveroom.h.c(this.gyY);
            this.gyY.setAdapter((ListAdapter) this.gyW);
        }
        this.gyW.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.gyZ.mFilterName = AlaLiveMultiBeautyView.this.gyW.gkN[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.onFilterSelected(AlaLiveMultiBeautyView.this.gyW.gkN[i].mShowName, AlaLiveMultiBeautyView.this.gyW.gkN[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fpX = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fpX.setOnClickListener(this);
        this.fpV = (Button) findViewById(a.g.btn_choose_filter);
        this.fpV.setOnClickListener(this);
        this.fpW = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fpW.setOnClickListener(this);
        this.gyX = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fpR = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.gza = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.gza.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gyZ.gll = i;
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gzb = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.gzb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gyZ.glm = i;
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gzc = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.gzc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gyZ.gln = i;
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gzd = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.gzd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gyZ.glp = i;
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gze = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.gze.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gyZ.glo = i;
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.r(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fpY = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.vx();
                if (AlaLiveMultiBeautyView.this.fqb != null) {
                    AlaLiveMultiBeautyView.this.fqb.vy();
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
    public void vw() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vx() {
        if (this.gyZ != null) {
            com.baidu.live.c.vf().putString("ala_beauty_5.4_config_str", this.gyZ.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aXY = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fpZ && this.fpV.getWidth() != 0) {
            h(this.fpV, false);
            this.fpZ = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fpV) {
            h(this.fpV, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fpV);
            if (this.gyV != null) {
                setEffectFilterBeautyChooseBlock(this.gyV);
            } else if (this.gyY != null) {
                setEffectFilterBeautyChooseBlock(this.gyY);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fpW) {
            h(this.fpW, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fpW);
            setEffectFilterBeautyChooseBlock(this.gyX);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fpX) {
            h(this.fpX, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fpX);
            setEffectFilterBeautyChooseBlock(this.fpR);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.gyV != null) {
            this.gyV.setVisibility(4);
        }
        if (this.gyY != null) {
            this.gyY.setVisibility(4);
        }
        this.gyX.setVisibility(4);
        this.fpR.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fpV.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fpW.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fpX.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fqb = jVar;
    }

    private void h(View view, boolean z) {
        this.fpY.clearAnimation();
        int width = (this.fpY.getWidth() / 2) + this.fpY.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpY.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fpY.getWidth() / 2);
        this.fpY.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fpY.startAnimation(translateAnimation);
        }
    }

    public void setViewData(i iVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (iVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) iVar;
            this.gza.setProgress(dVar.gll);
            this.gzb.setProgress(dVar.glm);
            this.gzc.setProgress(dVar.gln);
            this.gzd.setProgress(dVar.glp);
            this.gze.setProgress(dVar.glo);
            this.gyW.BX(dVar.mFilterName);
            this.gyW.notifyDataSetChanged();
            this.gyZ = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fpW.setVisibility(0);
            } else {
                this.fpW.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
