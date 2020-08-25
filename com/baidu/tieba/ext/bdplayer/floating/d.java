package com.baidu.tieba.ext.bdplayer.floating;

import android.app.Notification;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.floating.FloatView;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.listener.SimpleFloatListener;
import com.baidu.searchbox.floating.utils.OverlayPermissionCheck;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ext.bdplayer.floating.LiveFloatOperateView;
import kotlin.Pair;
/* loaded from: classes7.dex */
public class d implements e {
    private boolean hEC;
    private b hED;
    private View mContentView;
    private Context mContext;
    protected UniversalPlayer mPlayer = null;
    protected Config hEx = new Config();
    private int cLS = 167;
    private int hEy = 94;
    private int hEz = 0;
    private a hEA = new a();
    protected String hEB = null;

    /* loaded from: classes7.dex */
    public interface b {
        boolean chw();
    }

    public static boolean Lo() {
        return OverlayPermissionCheck.INSTANCE.hasPermission(BDPlayerConfig.getAppContext());
    }

    public d(Context context) {
        this.hEx.setSize(new Pair<>(Integer.valueOf(this.cLS), Integer.valueOf(this.hEy)));
        this.hEx.setLocation(new Pair<>(15, 57));
        this.hEx.setShadow(this.hEz);
        this.mContext = context;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void onCreate() {
        if (!this.hEC) {
            d(MissionEvent.MESSAGE_CREATE);
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void onDestroy() {
        d(MissionEvent.MESSAGE_DESTROY);
        if (this.mPlayer == null || !this.mPlayer.isFloatingMode()) {
            d("not isFloatingMode");
        }
        if (this.mPlayer != null) {
            this.mPlayer.setPlayerMode(PlayerConstant.HALF_MODE);
        }
        if (this.hED == null || this.hED.chw()) {
        }
    }

    public void PR() {
        if (this.mPlayer != null) {
            this.mPlayer.setPlayerMode(PlayerConstant.HALF_MODE);
        }
        dismiss(true);
    }

    public void chz() {
        if (this.mPlayer != null) {
            this.hEC = true;
            this.hEB = this.mPlayer.getCurrentMode();
            this.mPlayer.setPlayerMode(PlayerConstant.FLOATING_MODE);
            if (this.mPlayer instanceof BDVideoPlayer) {
                this.mPlayer.sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FLOATING));
            }
            final LayerContainer layerContainer = this.mPlayer.getLayerContainer();
            int measuredWidth = layerContainer.getMeasuredWidth();
            int measuredHeight = layerContainer.getMeasuredHeight();
            float max = Math.max(this.hEx.getSize().getFirst().intValue(), this.hEx.getSize().getSecond().intValue()) / Math.max(measuredWidth, measuredHeight);
            int i = (int) (measuredWidth * max);
            int i2 = (int) (max * measuredHeight);
            if (i <= 0 || i2 <= 0) {
                i = this.cLS;
                i2 = this.hEy;
            }
            this.hEx.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ext.bdplayer.floating.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context = layerContainer.getContext();
                    FloatView.with(context).setConfig(d.this.hEx).bindContext(d.this).setFloatingView(new FrameLayout(context)).addFloatListener(d.this.hEA).show();
                }
            });
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDefaultSize(int i, int i2) {
        this.hEx.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setBlockOffset(int i, int i2, int i3, int i4) {
        this.hEx.setBlockOffset(new Rect(i, i2, i3, i4));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setAnimator(FloatViewAnimator floatViewAnimator) {
        this.hEx.setAnimator(floatViewAnimator);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void startForeground(Notification notification) {
        this.hEx.setNotification(notification);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDragEnable(boolean z) {
        this.hEx.setCanDrag(z);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setLocation(int i, int i2) {
        this.hEx.setLocation(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void addFloatListener(FloatViewListener floatViewListener) {
        this.hEx.getFloatViewListeners().add(floatViewListener);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public boolean hasFloatingView() {
        return FloatView.hasFloatView();
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void dismiss(boolean z) {
        this.hEC = false;
        if (hasFloatingView()) {
            Context context = null;
            if (this.hEx.getFloatingView() != null) {
                context = this.hEx.getFloatingView().getContext();
            }
            FloatView.dismissAppFloatView(context, z);
        }
        d("dismiss");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.searchbox.floating.config.Config */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.floating.IFloating
    public boolean nextScale() {
        Pair pair;
        Pair<ScaleMode, ScaleMode> scaleMode = this.hEx.getScaleMode();
        if (scaleMode.getFirst().ordinal() < scaleMode.getSecond().ordinal()) {
            pair = new Pair(scaleMode.getSecond(), scaleMode.getSecond().next());
        } else if (scaleMode.getFirst().ordinal() == scaleMode.getSecond().ordinal()) {
            pair = new Pair(scaleMode.getFirst(), scaleMode.getFirst().next());
        } else {
            pair = scaleMode.getFirst().ordinal() > scaleMode.getSecond().ordinal() ? new Pair(scaleMode.getSecond(), scaleMode.getSecond().pre()) : null;
        }
        this.hEx.setScaleMode(pair);
        if (hasFloatingView()) {
            FloatView.Companion.invalidate(FloatView.Companion.getAppContentView() != null ? FloatView.Companion.getAppContentView().getContext() : null);
        }
        return chA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chA() {
        if (this.hEx.getScaleMode().getSecond() == ScaleMode.S) {
            return true;
        }
        if (this.hEx.getScaleMode().getSecond() != ScaleMode.L && this.hEx.getScaleMode().getFirst() != ScaleMode.L) {
            if (this.hEx.getScaleMode().getFirst() == ScaleMode.S) {
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void reverse(boolean z) {
        this.hEx.setReverse(z);
    }

    @Override // com.baidu.searchbox.player.context.IPlayerContext
    public void setPlayer(UniversalPlayer universalPlayer) {
        this.mPlayer = universalPlayer;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
        this.hEx.setScaleMode(pair);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(b bVar) {
        this.hED = bVar;
    }

    /* loaded from: classes7.dex */
    public class a extends SimpleFloatListener {
        public a() {
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewCreate(boolean z, View view, ScaleMode scaleMode, Point point) {
            if (!d.this.hEC) {
                d.this.dismiss(true);
                return;
            }
            if (z && view != null && d.this.mPlayer != null) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (d.this.mPlayer != null) {
                    d.this.mPlayer.attachToContainer(viewGroup);
                    d.this.mPlayer.getStatDispatcher().onFloatingShow(a(scaleMode), point);
                }
                if (d.this.mContentView != null) {
                    if (d.this.mContentView.getParent() != null) {
                        ((ViewGroup) d.this.mContentView.getParent()).removeView(d.this.mContentView);
                    }
                    viewGroup.addView(d.this.mContentView);
                }
                LiveFloatOperateView liveFloatOperateView = new LiveFloatOperateView(d.this.mContext);
                liveFloatOperateView.setOnViewOperatorListener(new LiveFloatOperateView.a() { // from class: com.baidu.tieba.ext.bdplayer.floating.d.a.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.LiveFloatOperateView.a
                    public void onCloseClicked() {
                        d.this.dismiss(true);
                    }

                    @Override // com.baidu.tieba.ext.bdplayer.floating.LiveFloatOperateView.a
                    public void a(LiveFloatOperateView liveFloatOperateView2) {
                        liveFloatOperateView2.setScaleMode(!d.this.nextScale());
                    }
                });
                liveFloatOperateView.setScaleMode(!d.this.chA());
                if (liveFloatOperateView.getParent() != null) {
                    ((ViewGroup) liveFloatOperateView.getParent()).removeView(liveFloatOperateView);
                }
                viewGroup.addView(liveFloatOperateView);
            }
            if (!d.this.hEC) {
                d.this.d("onViewCreate");
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewDismiss(View view, ScaleMode scaleMode, Point point) {
            if (d.this.mPlayer != null) {
                d.this.mPlayer.getStatDispatcher().onFloatingDismiss(a(scaleMode), point);
            }
            if (!d.this.hEC) {
                d.this.d("onDismiss");
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onClick(View view, ScaleMode scaleMode, Point point) {
            if (d.this.mPlayer != null) {
                d.this.mPlayer.getStatDispatcher().onFloatingClick(a(scaleMode), point);
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onScale(boolean z, ScaleMode scaleMode, Point point) {
            if (d.this.mPlayer != null) {
                d.this.mPlayer.getStatDispatcher().onFloatingScale(z, a(scaleMode), point);
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewShow(View view) {
            if (d.this.mPlayer != null && d.this.mPlayer.isFloatingMode() && !d.this.eY(view.getContext())) {
                d.this.mPlayer.resume();
            }
            if (!d.this.hEC) {
                d.this.d("onViewShow");
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewHide(View view) {
            if (d.this.mPlayer != null && d.this.mPlayer.isFloatingMode()) {
                d.this.mPlayer.pause();
            }
            if (!d.this.hEC) {
                d.this.d("onViewHide");
            }
        }

        protected String a(ScaleMode scaleMode) {
            switch (scaleMode) {
                case S:
                    return "1";
                case M:
                    return "2";
                case L:
                    return "3";
                default:
                    return "1";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eY(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return audioManager != null && audioManager.isMusicActive();
    }

    public boolean chB() {
        return this.hEC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Log.d("FloatingPlayerContext", str);
    }
}
