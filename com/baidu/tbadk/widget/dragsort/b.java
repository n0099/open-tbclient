package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector.OnGestureListener bHA;
    private int bHd;
    private boolean bHe;
    private int bHf;
    private boolean bHg;
    private boolean bHh;
    private GestureDetector bHi;
    private GestureDetector bHj;
    private int bHk;
    private int bHl;
    private int bHm;
    private int[] bHn;
    private int bHo;
    private int bHp;
    private int bHq;
    private int bHr;
    private boolean bHs;
    private float bHt;
    private int bHu;
    private int bHv;
    private int bHw;
    private boolean bHx;
    private a bHy;
    private int bHz;
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
        this.bHd = 0;
        this.bHe = true;
        this.bHg = false;
        this.bHh = false;
        this.bHk = -1;
        this.bHl = -1;
        this.bHm = -1;
        this.bHn = new int[2];
        this.bHs = false;
        this.bHt = 500.0f;
        this.bHA = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bHg && b.this.bHh) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bHt) {
                        if (b.this.bHz > (-width)) {
                            b.this.bHy.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bHt) && b.this.bHz < width) {
                        b.this.bHy.stopDragWithVelocity(true, f);
                    }
                    b.this.bHh = false;
                }
                return false;
            }
        };
        this.bHy = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bHi = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bHy.isDragEnabled() || b.this.bHy.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bHq = (int) motionEvent.getX();
                b.this.bHr = (int) motionEvent.getY();
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
        this.bHj = new GestureDetector(listView.getContext(), this.bHA);
        this.bHj.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bHu = i;
        this.bHv = i4;
        this.bHw = i5;
        iA(i3);
        iz(i2);
    }

    public GestureDetector Qj() {
        return this.bHi;
    }

    public void iz(int i) {
        this.bHd = i;
    }

    public void cJ(boolean z) {
        this.bHe = z;
    }

    public void iA(int i) {
        this.bHf = i;
    }

    public void cK(boolean z) {
        this.bHg = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bHe && !this.bHh) {
            i4 = 12;
        }
        if (this.bHg && this.bHh) {
            i4 = i4 | 1 | 2;
        }
        this.bHs = this.bHy.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bHs;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bHy.isDragEnabled() && !this.bHy.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bHg && this.bHs && this.bHf == 1) {
                this.bHj.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bHq = (int) motionEvent.getX();
                    this.bHr = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bHg && this.bHh) {
                        if ((this.bHz >= 0 ? this.bHz : -this.bHz) > this.mListView.getWidth() / 2) {
                            this.bHy.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bHh = false;
                    this.bHs = false;
                    break;
                case 3:
                    this.bHh = false;
                    this.bHs = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bHg && this.bHh) {
            this.bHz = point.x;
        }
    }

    public int B(MotionEvent motionEvent) {
        return D(motionEvent);
    }

    public int C(MotionEvent motionEvent) {
        if (this.bHf == 1) {
            return E(motionEvent);
        }
        return -1;
    }

    public int D(MotionEvent motionEvent) {
        return c(motionEvent, this.bHu);
    }

    public int E(MotionEvent motionEvent) {
        return c(motionEvent, this.bHw);
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
                findViewById.getLocationOnScreen(this.bHn);
                if (rawX > this.bHn[0] && rawY > this.bHn[1] && rawX < this.bHn[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.bHn[1]) {
                        this.bHo = childAt.getLeft();
                        this.bHp = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bHg && this.bHf == 0) {
            this.bHm = c(motionEvent, this.bHv);
        }
        this.bHk = B(motionEvent);
        if (this.bHk != -1 && this.bHd == 0) {
            y(this.bHk, ((int) motionEvent.getX()) - this.bHo, ((int) motionEvent.getY()) - this.bHp);
        }
        this.bHh = false;
        this.bHx = true;
        this.bHz = 0;
        this.bHl = C(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bHo;
            int i2 = y2 - this.bHp;
            if (this.bHx && !this.bHs && (this.bHk != -1 || this.bHl != -1)) {
                if (this.bHk != -1) {
                    if (this.bHd == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bHe) {
                        y(this.bHk, i, i2);
                    } else if (this.bHd != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bHg) {
                        this.bHh = true;
                        y(this.bHl, i, i2);
                    }
                } else if (this.bHl != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bHg) {
                        this.bHh = true;
                        y(this.bHl, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bHx = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bHk != -1 && this.bHd == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.bHk, this.bHq - this.bHo, this.bHr - this.bHp);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bHg && this.bHf == 0 && this.bHm != -1) {
            this.bHy.removeItem(this.bHm - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
