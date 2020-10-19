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
    private boolean iaF;
    private b iaG;
    private View mContentView;
    private Context mContext;
    protected UniversalPlayer mPlayer = null;
    protected Config iaA = new Config();
    private int cZZ = 167;
    private int iaB = 94;
    private int iaC = 0;
    private a iaD = new a();
    protected String iaE = null;

    /* loaded from: classes4.dex */
    public interface b {
        boolean coi();
    }

    public static boolean MV() {
        return OverlayPermissionCheck.INSTANCE.hasPermission(BDPlayerConfig.getAppContext());
    }

    public d(Context context) {
        this.iaA.setSize(new Pair<>(Integer.valueOf(this.cZZ), Integer.valueOf(this.iaB)));
        this.iaA.setLocation(new Pair<>(15, 57));
        this.iaA.setShadow(this.iaC);
        this.mContext = context;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void onCreate() {
        if (!this.iaF) {
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
        if (this.iaG == null || this.iaG.coi()) {
        }
    }

    public void RW() {
        if (this.mPlayer != null) {
            this.mPlayer.setPlayerMode(PlayerConstant.HALF_MODE);
        }
        dismiss(true);
    }

    public void col() {
        if (this.mPlayer != null) {
            this.iaF = true;
            this.iaE = this.mPlayer.getCurrentMode();
            this.mPlayer.setPlayerMode(PlayerConstant.FLOATING_MODE);
            if (this.mPlayer instanceof BDVideoPlayer) {
                this.mPlayer.sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FLOATING));
            }
            final LayerContainer layerContainer = this.mPlayer.getLayerContainer();
            int measuredWidth = layerContainer.getMeasuredWidth();
            int measuredHeight = layerContainer.getMeasuredHeight();
            float max = Math.max(this.iaA.getSize().getFirst().intValue(), this.iaA.getSize().getSecond().intValue()) / Math.max(measuredWidth, measuredHeight);
            int i = (int) (measuredWidth * max);
            int i2 = (int) (max * measuredHeight);
            if (i <= 0 || i2 <= 0) {
                i = this.cZZ;
                i2 = this.iaB;
            }
            this.iaA.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            if (isDebug()) {
                Log.d("FloatingPlayerContext", "switchToFloating ...");
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ext.bdplayer.floating.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context = layerContainer.getContext();
                    FrameLayout frameLayout = new FrameLayout(context);
                    frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    FloatView.with(context).setConfig(d.this.iaA).bindContext(d.this).setFloatingView(frameLayout).addFloatListener(d.this.iaD).show();
                }
            });
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDefaultSize(int i, int i2) {
        this.iaA.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setBlockOffset(int i, int i2, int i3, int i4) {
        this.iaA.setBlockOffset(new Rect(i, i2, i3, i4));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setAnimator(FloatViewAnimator floatViewAnimator) {
        this.iaA.setAnimator(floatViewAnimator);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void startForeground(Notification notification) {
        this.iaA.setNotification(notification);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDragEnable(boolean z) {
        this.iaA.setCanDrag(z);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setLocation(int i, int i2) {
        this.iaA.setLocation(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void addFloatListener(FloatViewListener floatViewListener) {
        this.iaA.getFloatViewListeners().add(floatViewListener);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public boolean hasFloatingView() {
        return FloatView.hasFloatView();
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void dismiss(boolean z) {
        this.iaF = false;
        if (hasFloatingView()) {
            Context context = null;
            if (this.iaA.getFloatingView() != null) {
                context = this.iaA.getFloatingView().getContext();
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
        Pair<ScaleMode, ScaleMode> scaleMode = this.iaA.getScaleMode();
        if (scaleMode.getFirst().ordinal() < scaleMode.getSecond().ordinal()) {
            pair = new Pair(scaleMode.getSecond(), scaleMode.getSecond().next());
        } else if (scaleMode.getFirst().ordinal() == scaleMode.getSecond().ordinal()) {
            pair = new Pair(scaleMode.getFirst(), scaleMode.getFirst().next());
        } else {
            pair = scaleMode.getFirst().ordinal() > scaleMode.getSecond().ordinal() ? new Pair(scaleMode.getSecond(), scaleMode.getSecond().pre()) : null;
        }
        this.iaA.setScaleMode(pair);
        if (hasFloatingView()) {
            FloatView.Companion.invalidate(FloatView.Companion.getAppContentView() != null ? FloatView.Companion.getAppContentView().getContext() : null);
        }
        return com();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean com() {
        if (this.iaA.getScaleMode().getSecond() == ScaleMode.S) {
            return true;
        }
        if (this.iaA.getScaleMode().getSecond() != ScaleMode.L && this.iaA.getScaleMode().getFirst() != ScaleMode.L) {
            if (this.iaA.getScaleMode().getFirst() == ScaleMode.S) {
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void reverse(boolean z) {
        this.iaA.setReverse(z);
    }

    @Override // com.baidu.searchbox.player.context.IPlayerContext
    public void setPlayer(UniversalPlayer universalPlayer) {
        this.mPlayer = universalPlayer;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
        this.iaA.setScaleMode(pair);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void a(b bVar) {
        this.iaG = bVar;
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
            if (d.this.iaF) {
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
                    liveFloatOperateView.setScaleMode(!d.this.com());
                    if (liveFloatOperateView.getParent() != null) {
                        ((ViewGroup) liveFloatOperateView.getParent()).removeView(liveFloatOperateView);
                    }
                    viewGroup.addView(liveFloatOperateView);
                    viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                }
                if (!d.this.iaF) {
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
            if (!d.this.iaF) {
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
            if (d.this.mPlayer != null && d.this.mPlayer.isFloatingMode() && !d.this.fl(view.getContext())) {
                d.this.mPlayer.resume();
            }
            if (!d.this.iaF) {
                d.this.d("onViewShow");
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewHide(View view) {
            if (d.this.mPlayer != null && d.this.mPlayer.isFloatingMode()) {
                d.this.mPlayer.pause();
            }
            if (!d.this.iaF) {
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
    public boolean fl(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        return audioManager != null && audioManager.isMusicActive();
    }

    public boolean con() {
        return this.iaF;
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
