package com.baidu.tieba.ala.live.guess.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class TimeCountTextView extends TextView {
    private static final String TAG = TimeCountTextView.class.getSimpleName();
    private CountDownTimer bNS;
    private boolean gXP;
    @SuppressLint({"HandlerLeak"})
    Handler handler;

    /* loaded from: classes4.dex */
    public interface a {
        void onFinish();
    }

    public TimeCountTextView(Context context) {
        this(context, null);
    }

    public TimeCountTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeCountTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gXP = false;
        this.handler = new Handler() { // from class: com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 0) {
                    TimeCountTextView.this.setText("2");
                    TimeCountTextView.this.y(false, 3);
                } else if (message.what == 1) {
                    TimeCountTextView.this.setText("1");
                    TimeCountTextView.this.y(false, 2);
                } else if (message.what == 2) {
                    TimeCountTextView.this.setText("0");
                    TimeCountTextView.this.y(false, 1);
                }
                if (message.what == 3) {
                    TimeCountTextView.this.x(false, 3);
                } else if (message.what == 4) {
                    TimeCountTextView.this.x(false, 2);
                } else if (message.what == 5) {
                    TimeCountTextView.this.x(false, 1);
                }
            }
        };
    }

    public void a(long j, final long j2, final a aVar) {
        setTextColor(Color.parseColor("#7968E5"));
        this.gXP = false;
        if (this.bNS == null) {
            this.bNS = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    if (j3 < j2) {
                        if (!TimeCountTextView.this.gXP) {
                            TimeCountTextView.this.gXP = true;
                            TimeCountTextView.this.setTextColor(Color.parseColor("#FF0050"));
                            TimeCountTextView.this.setText(String.valueOf((100 + j3) / 1000));
                            TimeCountTextView.this.handler.sendEmptyMessage(3);
                            return;
                        }
                        return;
                    }
                    TimeCountTextView.this.setText(String.valueOf((100 + j3) / 1000));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (aVar != null) {
                        aVar.onFinish();
                    }
                }
            };
        }
        this.bNS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final boolean z, final int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 0.0f);
        ofFloat.setDuration(300L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    if (i == 3) {
                        TimeCountTextView.this.handler.sendEmptyMessageDelayed(0, 100L);
                    } else if (i == 2) {
                        TimeCountTextView.this.handler.sendEmptyMessageDelayed(1, 100L);
                    } else if (i == 1) {
                        TimeCountTextView.this.handler.sendEmptyMessageDelayed(2, 100L);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final boolean z, final int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    if (i == 3) {
                        TimeCountTextView.this.handler.sendEmptyMessageDelayed(4, 300L);
                    }
                    if (i == 2) {
                        TimeCountTextView.this.handler.sendEmptyMessageDelayed(5, 300L);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void cancel() {
        if (this.bNS != null) {
            this.bNS.cancel();
        }
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }
}
