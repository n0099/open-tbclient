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
    private int aQT;
    private boolean aQU;
    private int aQV;
    private boolean aQW;
    private boolean aQX;
    private GestureDetector aQY;
    private GestureDetector aQZ;
    private int aRa;
    private int aRb;
    private int aRc;
    private int[] aRd;
    private int aRe;
    private int aRf;
    private int aRg;
    private int aRh;
    private boolean aRi;
    private float aRj;
    private int aRk;
    private int aRl;
    private int aRm;
    private boolean aRn;
    private a aRo;
    private int aRp;
    private GestureDetector.OnGestureListener aRq;
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
        this.aQT = 0;
        this.aQU = true;
        this.aQW = false;
        this.aQX = false;
        this.aRa = -1;
        this.aRb = -1;
        this.aRc = -1;
        this.aRd = new int[2];
        this.aRi = false;
        this.aRj = 500.0f;
        this.aRq = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.aQW && b.this.aQX) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.aRj) {
                        if (b.this.aRp > (-width)) {
                            b.this.aRo.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.aRj) && b.this.aRp < width) {
                        b.this.aRo.stopDragWithVelocity(true, f);
                    }
                    b.this.aQX = false;
                }
                return false;
            }
        };
        this.aRo = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.aQY = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.aRo.isDragEnabled() || b.this.aRo.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.aRg = (int) motionEvent.getX();
                b.this.aRh = (int) motionEvent.getY();
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
        this.aQZ = new GestureDetector(listView.getContext(), this.aRq);
        this.aQZ.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.aRk = i;
        this.aRl = i4;
        this.aRm = i5;
        fI(i3);
        fH(i2);
    }

    public GestureDetector Ip() {
        return this.aQY;
    }

    public void fH(int i) {
        this.aQT = i;
    }

    public void cd(boolean z) {
        this.aQU = z;
    }

    public void fI(int i) {
        this.aQV = i;
    }

    public void ce(boolean z) {
        this.aQW = z;
    }

    public boolean o(int i, int i2, int i3) {
        int i4 = 0;
        if (this.aQU && !this.aQX) {
            i4 = 12;
        }
        if (this.aQW && this.aQX) {
            i4 = i4 | 1 | 2;
        }
        this.aRi = this.aRo.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.aRi;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.aRo.isDragEnabled() && !this.aRo.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.aQW && this.aRi && this.aQV == 1) {
                this.aQZ.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aRg = (int) motionEvent.getX();
                    this.aRh = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.aQW && this.aQX) {
                        if ((this.aRp >= 0 ? this.aRp : -this.aRp) > this.mListView.getWidth() / 2) {
                            this.aRo.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.aQX = false;
                    this.aRi = false;
                    break;
                case 3:
                    this.aQX = false;
                    this.aRi = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.aQW && this.aQX) {
            this.aRp = point.x;
        }
    }

    public int o(MotionEvent motionEvent) {
        return q(motionEvent);
    }

    public int p(MotionEvent motionEvent) {
        if (this.aQV == 1) {
            return r(motionEvent);
        }
        return -1;
    }

    public int q(MotionEvent motionEvent) {
        return c(motionEvent, this.aRk);
    }

    public int r(MotionEvent motionEvent) {
        return c(motionEvent, this.aRm);
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
                findViewById.getLocationOnScreen(this.aRd);
                if (rawX > this.aRd[0] && rawY > this.aRd[1] && rawX < this.aRd[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.aRd[1]) {
                        this.aRe = childAt.getLeft();
                        this.aRf = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.aQW && this.aQV == 0) {
            this.aRc = c(motionEvent, this.aRl);
        }
        this.aRa = o(motionEvent);
        if (this.aRa != -1 && this.aQT == 0) {
            o(this.aRa, ((int) motionEvent.getX()) - this.aRe, ((int) motionEvent.getY()) - this.aRf);
        }
        this.aQX = false;
        this.aRn = true;
        this.aRp = 0;
        this.aRb = p(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.aRe;
            int i2 = y2 - this.aRf;
            if (this.aRn && !this.aRi && (this.aRa != -1 || this.aRb != -1)) {
                if (this.aRa != -1) {
                    if (this.aQT == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.aQU) {
                        o(this.aRa, i, i2);
                    } else if (this.aQT != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.aQW) {
                        this.aQX = true;
                        o(this.aRb, i, i2);
                    }
                } else if (this.aRb != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.aQW) {
                        this.aQX = true;
                        o(this.aRb, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.aRn = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aRa != -1 && this.aQT == 2) {
            this.mListView.performHapticFeedback(0);
            o(this.aRa, this.aRg - this.aRe, this.aRh - this.aRf);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aQW && this.aQV == 0 && this.aRc != -1) {
            this.aRo.removeItem(this.aRc - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
