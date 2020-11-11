package com.baidu.tieba.ext.bdplayer.floating;

import android.app.Notification;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.liveroom.e.h;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class d implements e {
    private boolean ite;
    private b itf;
    private View mContentView;
    private Context mContext;
    protected UniversalPlayer mPlayer = null;
    protected Config isZ = new Config();
    private int doy = 167;
    private int ita = 94;
    private int itb = 0;
    private a itc = new a();
    protected String itd = null;

    /* loaded from: classes4.dex */
    public interface b {
        boolean ctQ();
    }

    public static boolean NP() {
        return OverlayPermissionCheck.INSTANCE.hasPermission(BDPlayerConfig.getAppContext());
    }

    public d(Context context) {
        this.isZ.setSize(new Pair<>(Integer.valueOf(this.doy), Integer.valueOf(this.ita)));
        this.isZ.setLocation(new Pair<>(15, 57));
        this.isZ.setShadow(this.itb);
        this.mContext = context;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void onCreate() {
        if (!this.ite) {
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
        if (this.itf == null || this.itf.ctQ()) {
        }
    }

    public void VC() {
        if (this.mPlayer != null) {
            this.mPlayer.setPlayerMode(PlayerConstant.HALF_MODE);
        }
        dismiss(true);
    }

    public void ctT() {
        if (this.mPlayer != null) {
            this.ite = true;
            this.itd = this.mPlayer.getCurrentMode();
            this.mPlayer.setPlayerMode(PlayerConstant.FLOATING_MODE);
            if (this.mPlayer instanceof BDVideoPlayer) {
                this.mPlayer.sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FLOATING));
            }
            final LayerContainer layerContainer = this.mPlayer.getLayerContainer();
            int measuredWidth = layerContainer.getMeasuredWidth();
            int measuredHeight = layerContainer.getMeasuredHeight();
            float max = Math.max(this.isZ.getSize().getFirst().intValue(), this.isZ.getSize().getSecond().intValue()) / Math.max(measuredWidth, measuredHeight);
            int i = (int) (measuredWidth * max);
            int i2 = (int) (max * measuredHeight);
            if (i <= 0 || i2 <= 0) {
                i = this.doy;
                i2 = this.ita;
            }
            this.isZ.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            if (isDebug()) {
                Log.d("FloatingPlayerContext", "switchToFloating ...");
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ext.bdplayer.floating.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context = layerContainer.getContext();
                    FrameLayout frameLayout = new FrameLayout(context);
                    frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    FloatView.with(context).setConfig(d.this.isZ).bindContext(d.this).setFloatingView(frameLayout).addFloatListener(d.this.itc).show();
                }
            });
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDefaultSize(int i, int i2) {
        this.isZ.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setBlockOffset(int i, int i2, int i3, int i4) {
        this.isZ.setBlockOffset(new Rect(i, i2, i3, i4));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setAnimator(FloatViewAnimator floatViewAnimator) {
        this.isZ.setAnimator(floatViewAnimator);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void startForeground(Notification notification) {
        this.isZ.setNotification(notification);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDragEnable(boolean z) {
        this.isZ.setCanDrag(z);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setLocation(int i, int i2) {
        this.isZ.setLocation(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void addFloatListener(FloatViewListener floatViewListener) {
        this.isZ.getFloatViewListeners().add(floatViewListener);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public boolean hasFloatingView() {
        return FloatView.hasFloatView();
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void dismiss(boolean z) {
        this.ite = false;
        if (hasFloatingView()) {
            Context context = null;
            if (this.isZ.getFloatingView() != null) {
                context = this.isZ.getFloatingView().getContext();
            }
            FloatView.dismissAppFloatView(context, z);
        }
        if (isDebug()) {
            d("dismiss");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.searchbox.floating.config.Config */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.floating.IFloating
    public boolean nextScale() {
        Pair pair;
        Pair<ScaleMode, ScaleMode> scaleMode = this.isZ.getScaleMode();
        if (scaleMode.getFirst().ordinal() < scaleMode.getSecond().ordinal()) {
            pair = new Pair(scaleMode.getSecond(), scaleMode.getSecond().next());
        } else if (scaleMode.getFirst().ordinal() == scaleMode.getSecond().ordinal()) {
            pair = new Pair(scaleMode.getFirst(), scaleMode.getFirst().next());
        } else {
            pair = scaleMode.getFirst().ordinal() > scaleMode.getSecond().ordinal() ? new Pair(scaleMode.getSecond(), scaleMode.getSecond().pre()) : null;
        }
        this.isZ.setScaleMode(pair);
        if (hasFloatingView()) {
            FloatView.Companion.invalidate(FloatView.Companion.getAppContentView() != null ? FloatView.Companion.getAppContentView().getContext() : null);
        }
        return ctU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctU() {
        if (this.isZ.getScaleMode().getSecond() == ScaleMode.S) {
            return true;
        }
        if (this.isZ.getScaleMode().getSecond() != ScaleMode.L && this.isZ.getScaleMode().getFirst() != ScaleMode.L) {
            if (this.isZ.getScaleMode().getFirst() == ScaleMode.S) {
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void reverse(boolean z) {
        this.isZ.setReverse(z);
    }

    @Override // com.baidu.searchbox.player.context.IPlayerContext
    public void setPlayer(UniversalPlayer universalPlayer) {
        this.mPlayer = universalPlayer;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
        this.isZ.setScaleMode(pair);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(b bVar) {
        this.itf = bVar;
    }

    /* loaded from: classes4.dex */
    public class a extends SimpleFloatListener {
        public a() {
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewCreate(boolean z, View view, ScaleMode scaleMode, Point point) {
            if (d.this.isDebug()) {
                Log.d("FloatingPlayerContext", "onViewCreate1");
            }
            if (d.this.ite) {
                if (d.this.isDebug()) {
                    Log.d("FloatingPlayerContext", "onViewCreate1= " + z + ", view=" + view + " mPlayer=" + (d.this.mPlayer == null ? "null" : Boolean.valueOf(d.this.mPlayer.isPlaying())));
                }
                if (z && view != null && d.this.mPlayer != null) {
                    if (d.this.isDebug()) {
                        Log.d("FloatingPlayerContext", "onViewCreate2.....");
                    }
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
                    liveFloatOperateView.setScaleMode(!d.this.ctU());
                    if (liveFloatOperateView.getParent() != null) {
                        ((ViewGroup) liveFloatOperateView.getParent()).removeView(liveFloatOperateView);
                    }
                    viewGroup.addView(liveFloatOperateView);
                    viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                }
                if (!d.this.ite) {
                    d.this.d("onViewCreate");
                    return;
                }
                return;
            }
            d.this.dismiss(true);
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewDismiss(View view, ScaleMode scaleMode, Point point) {
            if (d.this.mPlayer != null) {
                d.this.mPlayer.getStatDispatcher().onFloatingDismiss(a(scaleMode), point);
            }
            if (!d.this.ite) {
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
            if (d.this.mPlayer != null && d.this.mPlayer.isFloatingMode() && !d.this.fm(view.getContext())) {
                d.this.mPlayer.resume();
            }
            if (!d.this.ite) {
                d.this.d("onViewShow");
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewHide(View view) {
            if (d.this.mPlayer != null && d.this.mPlayer.isFloatingMode()) {
                d.this.mPlayer.pause();
            }
            if (!d.this.ite) {
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
    public boolean fm(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        return audioManager != null && audioManager.isMusicActive();
    }

    public boolean ctV() {
        return this.ite;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (isDebug()) {
            Log.d("FloatingPlayerContext", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
