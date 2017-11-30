package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int aQQ;
    private boolean aQR;
    private int aQS;
    private boolean aQT;
    private boolean aQU;
    private GestureDetector aQV;
    private GestureDetector aQW;
    private int aQX;
    private int aQY;
    private int aQZ;
    private int[] aRa;
    private int aRb;
    private int aRc;
    private int aRd;
    private int aRe;
    private boolean aRf;
    private float aRg;
    private int aRh;
    private int aRi;
    private int aRj;
    private boolean aRk;
    private a aRl;
    private int aRm;
    private GestureDetector.OnGestureListener aRn;
    private GestureDetector mDetector;
    private ListView mListView;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.aQQ = 0;
        this.aQR = true;
        this.aQT = false;
        this.aQU = false;
        this.aQX = -1;
        this.aQY = -1;
        this.aQZ = -1;
        this.aRa = new int[2];
        this.aRf = false;
        this.aRg = 500.0f;
        this.aRn = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.aQT && b.this.aQU) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.aRg) {
                        if (b.this.aRm > (-width)) {
                            b.this.aRl.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.aRg) && b.this.aRm < width) {
                        b.this.aRl.stopDragWithVelocity(true, f);
                    }
                    b.this.aQU = false;
                }
                return false;
            }
        };
        this.aRl = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.aQV = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.aRl.isDragEnabled() || b.this.aRl.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.aRd = (int) motionEvent.getX();
                b.this.aRe = (int) motionEvent.getY();
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                b.this.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
        this.aQW = new GestureDetector(listView.getContext(), this.aRn);
        this.aQW.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.aRh = i;
        this.aRi = i4;
        this.aRj = i5;
        fI(i3);
        fH(i2);
    }

    public GestureDetector Io() {
        return this.aQV;
    }

    public void fH(int i) {
        this.aQQ = i;
    }

    public void cc(boolean z) {
        this.aQR = z;
    }

    public void fI(int i) {
        this.aQS = i;
    }

    public void cd(boolean z) {
        this.aQT = z;
    }

    public boolean o(int i, int i2, int i3) {
        int i4 = 0;
        if (this.aQR && !this.aQU) {
            i4 = 12;
        }
        if (this.aQT && this.aQU) {
            i4 = i4 | 1 | 2;
        }
        this.aRf = this.aRl.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.aRf;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.aRl.isDragEnabled() && !this.aRl.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.aQT && this.aRf && this.aQS == 1) {
                this.aQW.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aRd = (int) motionEvent.getX();
                    this.aRe = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.aQT && this.aQU) {
                        if ((this.aRm >= 0 ? this.aRm : -this.aRm) > this.mListView.getWidth() / 2) {
                            this.aRl.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.aQU = false;
                    this.aRf = false;
                    break;
                case 3:
                    this.aQU = false;
                    this.aRf = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.aQT && this.aQU) {
            this.aRm = point.x;
        }
    }

    public int o(MotionEvent motionEvent) {
        return q(motionEvent);
    }

    public int p(MotionEvent motionEvent) {
        if (this.aQS == 1) {
            return r(motionEvent);
        }
        return -1;
    }

    public int q(MotionEvent motionEvent) {
        return c(motionEvent, this.aRh);
    }

    public int r(MotionEvent motionEvent) {
        return c(motionEvent, this.aRj);
    }

    public int c(MotionEvent motionEvent, int i) {
        int pointToPosition = this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int count = this.mListView.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.mListView.getChildAt(pointToPosition - this.mListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.aRa);
                if (rawX > this.aRa[0] && rawY > this.aRa[1] && rawX < this.aRa[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.aRa[1]) {
                        this.aRb = childAt.getLeft();
                        this.aRc = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.aQT && this.aQS == 0) {
            this.aQZ = c(motionEvent, this.aRi);
        }
        this.aQX = o(motionEvent);
        if (this.aQX != -1 && this.aQQ == 0) {
            o(this.aQX, ((int) motionEvent.getX()) - this.aRb, ((int) motionEvent.getY()) - this.aRc);
        }
        this.aQU = false;
        this.aRk = true;
        this.aRm = 0;
        this.aQY = p(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.aRb;
            int i2 = y2 - this.aRc;
            if (this.aRk && !this.aRf && (this.aQX != -1 || this.aQY != -1)) {
                if (this.aQX != -1) {
                    if (this.aQQ == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.aQR) {
                        o(this.aQX, i, i2);
                    } else if (this.aQQ != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.aQT) {
                        this.aQU = true;
                        o(this.aQY, i, i2);
                    }
                } else if (this.aQY != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.aQT) {
                        this.aQU = true;
                        o(this.aQY, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.aRk = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aQX != -1 && this.aQQ == 2) {
            this.mListView.performHapticFeedback(0);
            o(this.aQX, this.aRd - this.aRb, this.aRe - this.aRc);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aQT && this.aQS == 0 && this.aQZ != -1) {
            this.aRl.removeItem(this.aQZ - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
