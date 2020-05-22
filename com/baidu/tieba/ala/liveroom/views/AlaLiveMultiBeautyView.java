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
import com.baidu.live.ar.g;
import com.baidu.live.ar.h;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aUs;
    private Button eZA;
    private View eZB;
    private boolean eZC;
    private h eZE;
    private LinearLayout eZx;
    private Button eZy;
    private Button eZz;
    private SeekBar ggA;
    private HListView ggr;
    private com.baidu.tieba.ala.liveroom.g.c ggs;
    private LinearLayout ggt;
    private GridView ggu;
    private com.baidu.tieba.ala.liveroom.data.d ggv;
    private SeekBar ggw;
    private SeekBar ggx;
    private SeekBar ggy;
    private SeekBar ggz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.eZC = true;
        this.ggv = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZC = true;
        this.ggv = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZC = true;
        this.ggv = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.ggr = (HListView) findViewById(a.g.filter_list_view);
        if (this.ggr != null) {
            this.ggs = new com.baidu.tieba.ala.liveroom.g.c(this.ggr);
            this.ggs.pw(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.ggr.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.ggr.setAdapter((ListAdapter) this.ggs);
            this.ggr.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.ggu = (GridView) findViewById(a.g.filter_grid_view);
        if (this.ggu != null) {
            this.ggs = new com.baidu.tieba.ala.liveroom.g.c(this.ggu);
            this.ggu.setAdapter((ListAdapter) this.ggs);
        }
        this.ggs.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.ggv.mFilterName = AlaLiveMultiBeautyView.this.ggs.fSO[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.onFilterSelected(AlaLiveMultiBeautyView.this.ggs.fSO[i].mShowName, AlaLiveMultiBeautyView.this.ggs.fSO[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.eZA = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eZA.setOnClickListener(this);
        this.eZy = (Button) findViewById(a.g.btn_choose_filter);
        this.eZy.setOnClickListener(this);
        this.eZz = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eZz.setOnClickListener(this);
        this.ggt = (LinearLayout) findViewById(a.g.live_face_shape);
        this.eZx = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.ggw = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.ggw.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggv.fTm = i;
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.n(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggx = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.ggx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggv.fTn = i;
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggy = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.ggy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggv.fTo = i;
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggz = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.ggz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggv.fTq = i;
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggA = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.ggA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggv.fTp = i;
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eZB = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.vc();
                if (AlaLiveMultiBeautyView.this.eZE != null) {
                    AlaLiveMultiBeautyView.this.eZE.vd();
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
    public void vb() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vc() {
        if (this.ggv != null) {
            com.baidu.live.c.uN().putString("ala_beauty_5.4_config_str", this.ggv.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aUs = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eZC && this.eZy.getWidth() != 0) {
            h(this.eZy, false);
            this.eZC = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eZy) {
            h(this.eZy, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZy);
            if (this.ggr != null) {
                setEffectFilterBeautyChooseBlock(this.ggr);
            } else if (this.ggu != null) {
                setEffectFilterBeautyChooseBlock(this.ggu);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.eZz) {
            h(this.eZz, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZz);
            setEffectFilterBeautyChooseBlock(this.ggt);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eZA) {
            h(this.eZA, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZA);
            setEffectFilterBeautyChooseBlock(this.eZx);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.ggr != null) {
            this.ggr.setVisibility(4);
        }
        if (this.ggu != null) {
            this.ggu.setVisibility(4);
        }
        this.ggt.setVisibility(4);
        this.eZx.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eZy.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZz.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZA.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eZE = hVar;
    }

    private void h(View view, boolean z) {
        this.eZB.clearAnimation();
        int width = (this.eZB.getWidth() / 2) + this.eZB.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eZB.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eZB.getWidth() / 2);
        this.eZB.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eZB.startAnimation(translateAnimation);
        }
    }

    public void setViewData(g gVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (gVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) gVar;
            this.ggw.setProgress(dVar.fTm);
            this.ggx.setProgress(dVar.fTn);
            this.ggy.setProgress(dVar.fTo);
            this.ggz.setProgress(dVar.fTq);
            this.ggA.setProgress(dVar.fTp);
            this.ggs.AT(dVar.mFilterName);
            this.ggs.notifyDataSetChanged();
            this.ggv = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.eZz.setVisibility(0);
            } else {
                this.eZz.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
