package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector.OnGestureListener bnA;
    private int bne;
    private boolean bnf;
    private int bng;
    private boolean bnh;
    private boolean bni;
    private GestureDetector bnj;
    private GestureDetector bnk;
    private int bnl;
    private int bnm;
    private int bnn;
    private int bno;
    private int bnp;
    private int bnq;
    private int bnr;
    private boolean bns;
    private float bnt;
    private int bnu;
    private int bnv;
    private int bnw;
    private boolean bnx;
    private a bny;
    private int bnz;
    private GestureDetector mDetector;
    private ListView mListView;
    private int[] mTempLoc;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.bne = 0;
        this.bnf = true;
        this.bnh = false;
        this.bni = false;
        this.bnl = -1;
        this.bnm = -1;
        this.bnn = -1;
        this.mTempLoc = new int[2];
        this.bns = false;
        this.bnt = 500.0f;
        this.bnA = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bnh && b.this.bni) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bnt) {
                        if (b.this.bnz > (-width)) {
                            b.this.bny.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bnt) && b.this.bnz < width) {
                        b.this.bny.stopDragWithVelocity(true, f);
                    }
                    b.this.bni = false;
                }
                return false;
            }
        };
        this.bny = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bnj = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bny.isDragEnabled() || b.this.bny.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bnq = (int) motionEvent.getX();
                b.this.bnr = (int) motionEvent.getY();
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
        this.bnk = new GestureDetector(listView.getContext(), this.bnA);
        this.bnk.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bnu = i;
        this.bnv = i4;
        this.bnw = i5;
        gB(i3);
        gA(i2);
    }

    public GestureDetector Ry() {
        return this.bnj;
    }

    public void gA(int i) {
        this.bne = i;
    }

    public void cY(boolean z) {
        this.bnf = z;
    }

    public void gB(int i) {
        this.bng = i;
    }

    public void cZ(boolean z) {
        this.bnh = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bnf && !this.bni) {
            i4 = 12;
        }
        if (this.bnh && this.bni) {
            i4 = i4 | 1 | 2;
        }
        this.bns = this.bny.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bns;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bny.isDragEnabled() && !this.bny.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bnh && this.bns && this.bng == 1) {
                this.bnk.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bnq = (int) motionEvent.getX();
                    this.bnr = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bnh && this.bni) {
                        if ((this.bnz >= 0 ? this.bnz : -this.bnz) > this.mListView.getWidth() / 2) {
                            this.bny.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bni = false;
                    this.bns = false;
                    break;
                case 3:
                    this.bni = false;
                    this.bns = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bnh && this.bni) {
            this.bnz = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bng == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bnu);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.bnw);
    }

    public int b(MotionEvent motionEvent, int i) {
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
                findViewById.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[0] && rawY > this.mTempLoc[1] && rawX < this.mTempLoc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.mTempLoc[1]) {
                        this.bno = childAt.getLeft();
                        this.bnp = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bnh && this.bng == 0) {
            this.bnn = b(motionEvent, this.bnv);
        }
        this.bnl = v(motionEvent);
        if (this.bnl != -1 && this.bne == 0) {
            p(this.bnl, ((int) motionEvent.getX()) - this.bno, ((int) motionEvent.getY()) - this.bnp);
        }
        this.bni = false;
        this.bnx = true;
        this.bnz = 0;
        this.bnm = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bno;
            int i2 = y2 - this.bnp;
            if (this.bnx && !this.bns && (this.bnl != -1 || this.bnm != -1)) {
                if (this.bnl != -1) {
                    if (this.bne == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bnf) {
                        p(this.bnl, i, i2);
                    } else if (this.bne != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bnh) {
                        this.bni = true;
                        p(this.bnm, i, i2);
                    }
                } else if (this.bnm != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bnh) {
                        this.bni = true;
                        p(this.bnm, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bnx = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bnl != -1 && this.bne == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.bnl, this.bnq - this.bno, this.bnr - this.bnp);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bnh && this.bng == 0 && this.bnn != -1) {
            this.bny.removeItem(this.bnn - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
