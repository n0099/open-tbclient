package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes11.dex */
public class DragTextView extends TextView {
    private float bMr;
    private float cEl;
    private float dwp;
    int gvA;
    private GestureDetector.OnGestureListener gvB;
    private int gvf;
    private int gvg;
    private int gvh;
    private int gvi;
    private int gvj;
    private int gvk;
    private int gvl;
    private e gvm;
    private GestureDetector gvn;
    private boolean gvo;
    private boolean gvp;
    private TbImageView gvq;
    private final int gvr;
    private int gvs;
    private int gvt;
    private boolean gvu;
    private float gvv;
    private float gvw;
    private CharSequence gvx;
    int gvy;
    int gvz;
    private int mActivePointerId;
    private float mDownX;
    private boolean mIsSilding;
    private float mLastMotionX;
    private float mLastMotionY;
    private int type;

    public DragTextView(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gvo = false;
        this.gvp = true;
        this.gvr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gvs = this.gvr;
        this.gvt = this.gvr;
        this.gvu = false;
        this.type = 2;
        this.gvB = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gvu = true;
                if (DragTextView.this.gvm != null && DragTextView.this.gvo) {
                    DragTextView.this.gvm.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvu = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
                if (DragTextView.this.gvm != null) {
                    DragTextView.this.gvm.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvu = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gvo = false;
        this.gvp = true;
        this.gvr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gvs = this.gvr;
        this.gvt = this.gvr;
        this.gvu = false;
        this.type = 2;
        this.gvB = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gvu = true;
                if (DragTextView.this.gvm != null && DragTextView.this.gvo) {
                    DragTextView.this.gvm.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvu = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
                if (DragTextView.this.gvm != null) {
                    DragTextView.this.gvm.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvu = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gvo = false;
        this.gvp = true;
        this.gvr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gvs = this.gvr;
        this.gvt = this.gvr;
        this.gvu = false;
        this.type = 2;
        this.gvB = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gvu = true;
                if (DragTextView.this.gvm != null && DragTextView.this.gvo) {
                    DragTextView.this.gvm.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvu = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gvu = false;
                if (DragTextView.this.gvm != null) {
                    DragTextView.this.gvm.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvu = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gvf = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.gvn = new GestureDetector(context, this.gvB);
        this.gvy = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.gvz = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.gvA = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.gvo = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.gvp = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.gvk = this.gvz;
        } else {
            this.gvk = this.gvy;
        }
        this.gvl = this.gvA;
        this.gvg = i;
        this.gvi = i3;
        this.gvh = i2;
        this.gvj = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.gvs = i;
        this.gvt = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gvp) {
            return super.onTouchEvent(motionEvent);
        }
        this.gvn.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.gvu = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cEl = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.dwp = getX();
                    this.bMr = getY();
                    if (this.gvm != null && this.gvm.bQk()) {
                        this.gvv = getTranslationX();
                        this.gvw = getTranslationY();
                        this.gvx = getText();
                    }
                    if (this.gvm != null) {
                        this.gvm.bQj();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.gvm != null && !this.gvu) {
                    this.gvm.g(this, (int) this.dwp, (int) this.bMr, getWidth() + ((int) this.dwp), getHeight() + ((int) this.bMr));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.gvm == null || this.gvm.bQk())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i = this.gvh;
                        int i2 = this.gvg - this.gvk;
                        int i3 = this.gvi + this.gvk;
                        int i4 = this.gvi - this.gvs;
                        int i5 = (this.gvj - this.gvt) + this.gvl;
                        int i6 = this.gvl + this.gvj;
                        int i7 = i4 - this.gvk;
                        if (y < i) {
                            height = getHeight() + i;
                        } else {
                            i = y;
                        }
                        if (x < i2) {
                            width = getWidth() + i2;
                        } else {
                            i2 = x;
                        }
                        if (width > i3) {
                            i2 = i3 - getWidth();
                        } else {
                            i3 = width;
                        }
                        if (height > i6) {
                            i = i6 - getHeight();
                        } else {
                            i6 = height;
                        }
                        if (i3 < i4 && i6 > i5) {
                            i = i5 - getHeight();
                            i6 = i5;
                        }
                        if (i2 >= i7 || i6 <= i5) {
                            i7 = i2;
                        } else {
                            int width2 = getWidth() + i7;
                        }
                        this.dwp = i7;
                        this.bMr = i;
                        setTranslationX(i7);
                        setTranslationY(i);
                        setAlpha(0.7f);
                        if (this.gvm != null) {
                            this.gvm.C((int) this.dwp, (int) this.bMr, ((int) this.dwp) + getWidth(), ((int) this.bMr) + getHeight());
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    public void setBackground(PicStickerItem picStickerItem) {
        if (this.gvq == null) {
            this.gvq = new TbImageView(getContext());
        }
        this.gvq.startLoad(picStickerItem.url, 10, false);
    }

    private void endDrag() {
        this.mIsSilding = false;
        this.mActivePointerId = -1;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!isInvalidEvent(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (abs > this.gvf || abs2 > this.gvf) {
                this.mIsSilding = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private int getDiffX(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private int M(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cEl);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.gvm = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bQs() {
        setTranslationX(this.gvv);
        setTranslationY(this.gvw);
        if (this.type == 2) {
            setText(this.gvx);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
