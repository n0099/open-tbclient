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
    private e gvA;
    private GestureDetector gvB;
    private boolean gvC;
    private boolean gvD;
    private TbImageView gvE;
    private final int gvF;
    private int gvG;
    private int gvH;
    private boolean gvI;
    private float gvJ;
    private float gvK;
    private CharSequence gvL;
    int gvM;
    int gvN;
    int gvO;
    private GestureDetector.OnGestureListener gvP;
    private int gvt;
    private int gvu;
    private int gvv;
    private int gvw;
    private int gvx;
    private int gvy;
    private int gvz;
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
        this.gvC = false;
        this.gvD = true;
        this.gvF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gvG = this.gvF;
        this.gvH = this.gvF;
        this.gvI = false;
        this.type = 2;
        this.gvP = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gvI = true;
                if (DragTextView.this.gvA != null && DragTextView.this.gvC) {
                    DragTextView.this.gvA.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvI = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
                if (DragTextView.this.gvA != null) {
                    DragTextView.this.gvA.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvI = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gvC = false;
        this.gvD = true;
        this.gvF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gvG = this.gvF;
        this.gvH = this.gvF;
        this.gvI = false;
        this.type = 2;
        this.gvP = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gvI = true;
                if (DragTextView.this.gvA != null && DragTextView.this.gvC) {
                    DragTextView.this.gvA.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvI = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
                if (DragTextView.this.gvA != null) {
                    DragTextView.this.gvA.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvI = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gvC = false;
        this.gvD = true;
        this.gvF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gvG = this.gvF;
        this.gvH = this.gvF;
        this.gvI = false;
        this.type = 2;
        this.gvP = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gvI = true;
                if (DragTextView.this.gvA != null && DragTextView.this.gvC) {
                    DragTextView.this.gvA.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvI = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gvI = false;
                if (DragTextView.this.gvA != null) {
                    DragTextView.this.gvA.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gvI = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gvt = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.gvB = new GestureDetector(context, this.gvP);
        this.gvM = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.gvN = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.gvO = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.gvC = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.gvD = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.gvy = this.gvN;
        } else {
            this.gvy = this.gvM;
        }
        this.gvz = this.gvO;
        this.gvu = i;
        this.gvw = i3;
        this.gvv = i2;
        this.gvx = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.gvG = i;
        this.gvH = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gvD) {
            return super.onTouchEvent(motionEvent);
        }
        this.gvB.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.gvI = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cEl = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.dwp = getX();
                    this.bMr = getY();
                    if (this.gvA != null && this.gvA.bQr()) {
                        this.gvJ = getTranslationX();
                        this.gvK = getTranslationY();
                        this.gvL = getText();
                    }
                    if (this.gvA != null) {
                        this.gvA.bQq();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.gvA != null && !this.gvI) {
                    this.gvA.g(this, (int) this.dwp, (int) this.bMr, getWidth() + ((int) this.dwp), getHeight() + ((int) this.bMr));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.gvA == null || this.gvA.bQr())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i = this.gvv;
                        int i2 = this.gvu - this.gvy;
                        int i3 = this.gvw + this.gvy;
                        int i4 = this.gvw - this.gvG;
                        int i5 = (this.gvx - this.gvH) + this.gvz;
                        int i6 = this.gvz + this.gvx;
                        int i7 = i4 - this.gvy;
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
                        if (this.gvA != null) {
                            this.gvA.C((int) this.dwp, (int) this.bMr, ((int) this.dwp) + getWidth(), ((int) this.bMr) + getHeight());
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
        if (this.gvE == null) {
            this.gvE = new TbImageView(getContext());
        }
        this.gvE.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.gvt || abs2 > this.gvt) {
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
        this.gvA = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bQz() {
        setTranslationX(this.gvJ);
        setTranslationY(this.gvK);
        if (this.type == 2) {
            setText(this.gvL);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
