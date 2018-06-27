package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private float baA;
    private int baB;
    private int baC;
    private int baD;
    private boolean baE;
    private a baF;
    private int baG;
    private GestureDetector.OnGestureListener baH;
    private int bak;
    private boolean bal;
    private int bam;
    private boolean ban;
    private boolean bao;
    private GestureDetector bap;
    private GestureDetector baq;
    private int bas;
    private int bat;
    private int bau;
    private int bav;
    private int baw;
    private int bax;
    private int bay;
    private boolean baz;
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
        this.bak = 0;
        this.bal = true;
        this.ban = false;
        this.bao = false;
        this.bas = -1;
        this.bat = -1;
        this.bau = -1;
        this.mTempLoc = new int[2];
        this.baz = false;
        this.baA = 500.0f;
        this.baH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.ban && b.this.bao) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.baA) {
                        if (b.this.baG > (-width)) {
                            b.this.baF.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.baA) && b.this.baG < width) {
                        b.this.baF.stopDragWithVelocity(true, f);
                    }
                    b.this.bao = false;
                }
                return false;
            }
        };
        this.baF = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bap = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.baF.isDragEnabled() || b.this.baF.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bax = (int) motionEvent.getX();
                b.this.bay = (int) motionEvent.getY();
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
        this.baq = new GestureDetector(listView.getContext(), this.baH);
        this.baq.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.baB = i;
        this.baC = i4;
        this.baD = i5;
        fD(i3);
        fC(i2);
    }

    public GestureDetector Mw() {
        return this.bap;
    }

    public void fC(int i) {
        this.bak = i;
    }

    public void cj(boolean z) {
        this.bal = z;
    }

    public void fD(int i) {
        this.bam = i;
    }

    public void ck(boolean z) {
        this.ban = z;
    }

    public boolean n(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bal && !this.bao) {
            i4 = 12;
        }
        if (this.ban && this.bao) {
            i4 = i4 | 1 | 2;
        }
        this.baz = this.baF.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.baz;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.baF.isDragEnabled() && !this.baF.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.ban && this.baz && this.bam == 1) {
                this.baq.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bax = (int) motionEvent.getX();
                    this.bay = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.ban && this.bao) {
                        if ((this.baG >= 0 ? this.baG : -this.baG) > this.mListView.getWidth() / 2) {
                            this.baF.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bao = false;
                    this.baz = false;
                    break;
                case 3:
                    this.bao = false;
                    this.baz = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.ban && this.bao) {
            this.baG = point.x;
        }
    }

    public int u(MotionEvent motionEvent) {
        return w(motionEvent);
    }

    public int v(MotionEvent motionEvent) {
        if (this.bam == 1) {
            return x(motionEvent);
        }
        return -1;
    }

    public int w(MotionEvent motionEvent) {
        return b(motionEvent, this.baB);
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.baD);
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
                        this.bav = childAt.getLeft();
                        this.baw = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.ban && this.bam == 0) {
            this.bau = b(motionEvent, this.baC);
        }
        this.bas = u(motionEvent);
        if (this.bas != -1 && this.bak == 0) {
            n(this.bas, ((int) motionEvent.getX()) - this.bav, ((int) motionEvent.getY()) - this.baw);
        }
        this.bao = false;
        this.baE = true;
        this.baG = 0;
        this.bat = v(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bav;
            int i2 = y2 - this.baw;
            if (this.baE && !this.baz && (this.bas != -1 || this.bat != -1)) {
                if (this.bas != -1) {
                    if (this.bak == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bal) {
                        n(this.bas, i, i2);
                    } else if (this.bak != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.ban) {
                        this.bao = true;
                        n(this.bat, i, i2);
                    }
                } else if (this.bat != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.ban) {
                        this.bao = true;
                        n(this.bat, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.baE = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bas != -1 && this.bak == 2) {
            this.mListView.performHapticFeedback(0);
            n(this.bas, this.bax - this.bav, this.bay - this.baw);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.ban && this.bam == 0 && this.bau != -1) {
            this.baF.removeItem(this.bau - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
