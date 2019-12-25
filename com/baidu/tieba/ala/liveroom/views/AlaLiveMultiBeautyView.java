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
import com.baidu.live.q.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.g.b;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes2.dex */
public class AlaLiveMultiBeautyView extends LinearLayout implements View.OnClickListener {
    private SeekBar fgA;
    private SeekBar fgB;
    private b.a fgC;
    private HListView fgm;
    private com.baidu.tieba.ala.liveroom.g.c fgn;
    private LinearLayout fgo;
    private LinearLayout fgp;
    private Button fgq;
    private Button fgr;
    private Button fgs;
    private View fgt;
    private GridView fgu;
    private boolean fgv;
    private com.baidu.tieba.ala.liveroom.data.c fgw;
    private SeekBar fgx;
    private SeekBar fgy;
    private SeekBar fgz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fgv = true;
        this.fgw = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgv = true;
        this.fgw = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = true;
        this.fgw = new com.baidu.tieba.ala.liveroom.data.c();
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
        this.fgm = (HListView) findViewById(a.g.filter_list_view);
        if (this.fgm != null) {
            this.fgn = new com.baidu.tieba.ala.liveroom.g.c(this.fgm);
            this.fgn.pM(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fgm.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fgm.setAdapter((ListAdapter) this.fgn);
            this.fgm.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fgu = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fgu != null) {
            this.fgn = new com.baidu.tieba.ala.liveroom.g.c(this.fgu);
            this.fgu.setAdapter((ListAdapter) this.fgn);
        }
        this.fgn.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fgw.mFilterName = AlaLiveMultiBeautyView.this.fgn.eUn[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.onFilterSelected(AlaLiveMultiBeautyView.this.fgn.eUn[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fgs = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fgs.setOnClickListener(this);
        this.fgq = (Button) findViewById(a.g.btn_choose_filter);
        this.fgq.setOnClickListener(this);
        this.fgr = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fgr.setOnClickListener(this);
        this.fgo = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fgp = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fgx = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fgx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fgw.eUN = i;
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.bm(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fgy = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fgy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fgw.eUO = i;
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.bp(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fgz = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fgz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fgw.eUP = i;
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fgA = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fgA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fgw.eUR = i;
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.bn(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fgB = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fgB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fgw.eUQ = i;
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.bo(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fgt = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.boj();
                if (AlaLiveMultiBeautyView.this.fgC != null) {
                    AlaLiveMultiBeautyView.this.fgC.biX();
                    return true;
                }
                return true;
            }
        });
    }

    public void boj() {
        if (this.fgw != null) {
            com.baidu.live.c.oI().putString("ala_beauty_5.4_config_str", this.fgw.toJsonString());
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fgv && this.fgq.getWidth() != 0) {
            f(this.fgq, false);
            this.fgv = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fgq) {
            f(this.fgq, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fgq);
            if (this.fgm != null) {
                setEffectFilterBeautyChooseBlock(this.fgm);
            } else if (this.fgu != null) {
                setEffectFilterBeautyChooseBlock(this.fgu);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fgr) {
            f(this.fgr, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fgr);
            setEffectFilterBeautyChooseBlock(this.fgo);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fgs) {
            f(this.fgs, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fgs);
            setEffectFilterBeautyChooseBlock(this.fgp);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fgm != null) {
            this.fgm.setVisibility(4);
        }
        if (this.fgu != null) {
            this.fgu.setVisibility(4);
        }
        this.fgo.setVisibility(4);
        this.fgp.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fgq.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fgr.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fgs.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    public void setOnEffectSelectedListener(b.a aVar) {
        this.fgC = aVar;
    }

    private void f(View view, boolean z) {
        this.fgt.clearAnimation();
        int width = (this.fgt.getWidth() / 2) + this.fgt.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fgt.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fgt.getWidth() / 2);
        this.fgt.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fgt.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.tieba.ala.liveroom.data.c cVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (cVar != null && alaLiveVideoConfig != null) {
            this.fgx.setProgress(cVar.eUN);
            this.fgy.setProgress(cVar.eUO);
            this.fgz.setProgress(cVar.eUP);
            this.fgA.setProgress(cVar.eUR);
            this.fgB.setProgress(cVar.eUQ);
            this.fgn.yv(cVar.mFilterName);
            this.fgn.notifyDataSetChanged();
            this.fgw = cVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fgr.setVisibility(0);
            } else {
                this.fgr.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
