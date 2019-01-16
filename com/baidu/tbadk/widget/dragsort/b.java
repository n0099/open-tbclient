package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bnd;
    private boolean bne;
    private int bnf;
    private boolean bng;
    private boolean bnh;
    private GestureDetector bni;
    private GestureDetector bnj;
    private int bnk;
    private int bnl;
    private int bnm;
    private int bnn;
    private int bno;
    private int bnp;
    private int bnq;
    private boolean bnr;
    private float bns;
    private int bnt;
    private int bnu;
    private int bnv;
    private boolean bnw;
    private a bnx;
    private int bny;
    private GestureDetector.OnGestureListener bnz;
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
        this.bnd = 0;
        this.bne = true;
        this.bng = false;
        this.bnh = false;
        this.bnk = -1;
        this.bnl = -1;
        this.bnm = -1;
        this.mTempLoc = new int[2];
        this.bnr = false;
        this.bns = 500.0f;
        this.bnz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bng && b.this.bnh) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bns) {
                        if (b.this.bny > (-width)) {
                            b.this.bnx.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bns) && b.this.bny < width) {
                        b.this.bnx.stopDragWithVelocity(true, f);
                    }
                    b.this.bnh = false;
                }
                return false;
            }
        };
        this.bnx = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bni = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bnx.isDragEnabled() || b.this.bnx.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bnp = (int) motionEvent.getX();
                b.this.bnq = (int) motionEvent.getY();
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
        this.bnj = new GestureDetector(listView.getContext(), this.bnz);
        this.bnj.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bnt = i;
        this.bnu = i4;
        this.bnv = i5;
        gB(i3);
        gA(i2);
    }

    public GestureDetector Ry() {
        return this.bni;
    }

    public void gA(int i) {
        this.bnd = i;
    }

    public void cY(boolean z) {
        this.bne = z;
    }

    public void gB(int i) {
        this.bnf = i;
    }

    public void cZ(boolean z) {
        this.bng = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bne && !this.bnh) {
            i4 = 12;
        }
        if (this.bng && this.bnh) {
            i4 = i4 | 1 | 2;
        }
        this.bnr = this.bnx.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bnr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bnx.isDragEnabled() && !this.bnx.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bng && this.bnr && this.bnf == 1) {
                this.bnj.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bnp = (int) motionEvent.getX();
                    this.bnq = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bng && this.bnh) {
                        if ((this.bny >= 0 ? this.bny : -this.bny) > this.mListView.getWidth() / 2) {
                            this.bnx.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bnh = false;
                    this.bnr = false;
                    break;
                case 3:
                    this.bnh = false;
                    this.bnr = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bng && this.bnh) {
            this.bny = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bnf == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bnt);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.bnv);
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
                        this.bnn = childAt.getLeft();
                        this.bno = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bng && this.bnf == 0) {
            this.bnm = b(motionEvent, this.bnu);
        }
        this.bnk = v(motionEvent);
        if (this.bnk != -1 && this.bnd == 0) {
            p(this.bnk, ((int) motionEvent.getX()) - this.bnn, ((int) motionEvent.getY()) - this.bno);
        }
        this.bnh = false;
        this.bnw = true;
        this.bny = 0;
        this.bnl = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bnn;
            int i2 = y2 - this.bno;
            if (this.bnw && !this.bnr && (this.bnk != -1 || this.bnl != -1)) {
                if (this.bnk != -1) {
                    if (this.bnd == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bne) {
                        p(this.bnk, i, i2);
                    } else if (this.bnd != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bng) {
                        this.bnh = true;
                        p(this.bnl, i, i2);
                    }
                } else if (this.bnl != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bng) {
                        this.bnh = true;
                        p(this.bnl, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bnw = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bnk != -1 && this.bnd == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.bnk, this.bnp - this.bnn, this.bnq - this.bno);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bng && this.bnf == 0 && this.bnm != -1) {
            this.bnx.removeItem(this.bnm - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
