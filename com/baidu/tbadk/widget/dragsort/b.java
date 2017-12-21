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
    private int aQW;
    private boolean aQX;
    private int aQY;
    private boolean aQZ;
    private boolean aRa;
    private GestureDetector aRb;
    private GestureDetector aRc;
    private int aRd;
    private int aRe;
    private int aRf;
    private int[] aRg;
    private int aRh;
    private int aRi;
    private int aRj;
    private int aRk;
    private boolean aRl;
    private float aRm;
    private int aRn;
    private int aRo;
    private int aRp;
    private boolean aRq;
    private a aRr;
    private int aRs;
    private GestureDetector.OnGestureListener aRt;
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
        this.aQW = 0;
        this.aQX = true;
        this.aQZ = false;
        this.aRa = false;
        this.aRd = -1;
        this.aRe = -1;
        this.aRf = -1;
        this.aRg = new int[2];
        this.aRl = false;
        this.aRm = 500.0f;
        this.aRt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.aQZ && b.this.aRa) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.aRm) {
                        if (b.this.aRs > (-width)) {
                            b.this.aRr.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.aRm) && b.this.aRs < width) {
                        b.this.aRr.stopDragWithVelocity(true, f);
                    }
                    b.this.aRa = false;
                }
                return false;
            }
        };
        this.aRr = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.aRb = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.aRr.isDragEnabled() || b.this.aRr.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.aRj = (int) motionEvent.getX();
                b.this.aRk = (int) motionEvent.getY();
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
        this.aRc = new GestureDetector(listView.getContext(), this.aRt);
        this.aRc.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.aRn = i;
        this.aRo = i4;
        this.aRp = i5;
        fI(i3);
        fH(i2);
    }

    public GestureDetector Ip() {
        return this.aRb;
    }

    public void fH(int i) {
        this.aQW = i;
    }

    public void cd(boolean z) {
        this.aQX = z;
    }

    public void fI(int i) {
        this.aQY = i;
    }

    public void ce(boolean z) {
        this.aQZ = z;
    }

    public boolean o(int i, int i2, int i3) {
        int i4 = 0;
        if (this.aQX && !this.aRa) {
            i4 = 12;
        }
        if (this.aQZ && this.aRa) {
            i4 = i4 | 1 | 2;
        }
        this.aRl = this.aRr.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.aRl;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.aRr.isDragEnabled() && !this.aRr.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.aQZ && this.aRl && this.aQY == 1) {
                this.aRc.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aRj = (int) motionEvent.getX();
                    this.aRk = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.aQZ && this.aRa) {
                        if ((this.aRs >= 0 ? this.aRs : -this.aRs) > this.mListView.getWidth() / 2) {
                            this.aRr.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.aRa = false;
                    this.aRl = false;
                    break;
                case 3:
                    this.aRa = false;
                    this.aRl = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.aQZ && this.aRa) {
            this.aRs = point.x;
        }
    }

    public int o(MotionEvent motionEvent) {
        return q(motionEvent);
    }

    public int p(MotionEvent motionEvent) {
        if (this.aQY == 1) {
            return r(motionEvent);
        }
        return -1;
    }

    public int q(MotionEvent motionEvent) {
        return c(motionEvent, this.aRn);
    }

    public int r(MotionEvent motionEvent) {
        return c(motionEvent, this.aRp);
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
                findViewById.getLocationOnScreen(this.aRg);
                if (rawX > this.aRg[0] && rawY > this.aRg[1] && rawX < this.aRg[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.aRg[1]) {
                        this.aRh = childAt.getLeft();
                        this.aRi = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.aQZ && this.aQY == 0) {
            this.aRf = c(motionEvent, this.aRo);
        }
        this.aRd = o(motionEvent);
        if (this.aRd != -1 && this.aQW == 0) {
            o(this.aRd, ((int) motionEvent.getX()) - this.aRh, ((int) motionEvent.getY()) - this.aRi);
        }
        this.aRa = false;
        this.aRq = true;
        this.aRs = 0;
        this.aRe = p(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.aRh;
            int i2 = y2 - this.aRi;
            if (this.aRq && !this.aRl && (this.aRd != -1 || this.aRe != -1)) {
                if (this.aRd != -1) {
                    if (this.aQW == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.aQX) {
                        o(this.aRd, i, i2);
                    } else if (this.aQW != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.aQZ) {
                        this.aRa = true;
                        o(this.aRe, i, i2);
                    }
                } else if (this.aRe != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.aQZ) {
                        this.aRa = true;
                        o(this.aRe, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.aRq = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aRd != -1 && this.aQW == 2) {
            this.mListView.performHapticFeedback(0);
            o(this.aRd, this.aRj - this.aRh, this.aRk - this.aRi);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aQZ && this.aQY == 0 && this.aRf != -1) {
            this.aRr.removeItem(this.aRf - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
