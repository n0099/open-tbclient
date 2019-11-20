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
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.live.k.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.g.b;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes6.dex */
public class AlaLiveMultiBeautyView extends LinearLayout implements View.OnClickListener {
    private HListView epS;
    private com.baidu.tieba.ala.liveroom.g.c epT;
    private LinearLayout epU;
    private LinearLayout epV;
    private Button epW;
    private Button epX;
    private Button epY;
    private View epZ;
    private GridView eqa;
    private boolean eqb;
    private com.baidu.tieba.ala.liveroom.data.c eqc;
    private SeekBar eqd;
    private SeekBar eqe;
    private SeekBar eqf;
    private SeekBar eqg;
    private SeekBar eqh;
    private b.a eqi;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.eqb = true;
        this.eqc = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eqb = true;
        this.eqc = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqb = true;
        this.eqc = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    protected void initViews() {
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
        this.epS = (HListView) findViewById(a.g.filter_list_view);
        if (this.epS != null) {
            this.epT = new com.baidu.tieba.ala.liveroom.g.c(this.epS);
            this.epT.nv(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.epS.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.epS.setAdapter((ListAdapter) this.epT);
            this.epS.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eqa = (GridView) findViewById(a.g.filter_grid_view);
        if (this.eqa != null) {
            this.epT = new com.baidu.tieba.ala.liveroom.g.c(this.eqa);
            this.eqa.setAdapter((ListAdapter) this.epT);
        }
        this.epT.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void lh(int i) {
                AlaLiveMultiBeautyView.this.eqc.mFilterName = AlaLiveMultiBeautyView.this.epT.ees[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.onFilterSelected(AlaLiveMultiBeautyView.this.epT.ees[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.epY = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.epY.setOnClickListener(this);
        this.epW = (Button) findViewById(a.g.btn_choose_filter);
        this.epW.setOnClickListener(this);
        this.epX = (Button) findViewById(a.g.btn_choose_face_shape);
        this.epX.setOnClickListener(this);
        this.epU = (LinearLayout) findViewById(a.g.live_face_shape);
        this.epV = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.eqd = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.eqd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqc.eeT = i;
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.aW(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqe = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.eqe.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqc.eeU = i;
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.aZ(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqf = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.eqf.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqc.eeV = i;
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqg = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.eqg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqc.eeX = i;
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.aX(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqh = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.eqh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqc.eeW = i;
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.aY(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.epZ = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.aWv();
                if (AlaLiveMultiBeautyView.this.eqi != null) {
                    AlaLiveMultiBeautyView.this.eqi.aRw();
                    return true;
                }
                return true;
            }
        });
    }

    public void aWv() {
        if (this.eqc != null) {
            com.baidu.live.c.np().putString("ala_beauty_5.4_config_str", this.eqc.toJsonString());
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eqb && this.epW.getWidth() != 0) {
            f(this.epW, false);
            this.eqb = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epW) {
            f(this.epW, true);
            setEffectFilterBeautyChooseBtnTextColor(this.epW);
            if (this.epS != null) {
                setEffectFilterBeautyChooseBlock(this.epS);
            } else if (this.eqa != null) {
                setEffectFilterBeautyChooseBlock(this.eqa);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.epX) {
            f(this.epX, true);
            setEffectFilterBeautyChooseBtnTextColor(this.epX);
            setEffectFilterBeautyChooseBlock(this.epU);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.epY) {
            f(this.epY, true);
            setEffectFilterBeautyChooseBtnTextColor(this.epY);
            setEffectFilterBeautyChooseBlock(this.epV);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.epS != null) {
            this.epS.setVisibility(4);
        }
        if (this.eqa != null) {
            this.eqa.setVisibility(4);
        }
        this.epU.setVisibility(4);
        this.epV.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.epW.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.epX.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.epY.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    public void setOnEffectSelectedListener(b.a aVar) {
        this.eqi = aVar;
    }

    private void f(View view, boolean z) {
        this.epZ.clearAnimation();
        int width = (this.epZ.getWidth() / 2) + this.epZ.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epZ.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.epZ.getWidth() / 2);
        this.epZ.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.epZ.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.tieba.ala.liveroom.data.c cVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (cVar != null && alaLiveVideoConfig != null) {
            this.eqd.setProgress(cVar.eeT);
            this.eqe.setProgress(cVar.eeU);
            this.eqf.setProgress(cVar.eeV);
            this.eqg.setProgress(cVar.eeX);
            this.eqh.setProgress(cVar.eeW);
            this.epT.tG(cVar.mFilterName);
            this.epT.notifyDataSetChanged();
            this.eqc = cVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.epX.setVisibility(0);
            } else {
                this.epX.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
