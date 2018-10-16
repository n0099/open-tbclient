package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bib;
    private boolean bic;
    private int bie;
    private boolean bif;
    private boolean bih;
    private GestureDetector bii;
    private GestureDetector bij;
    private int bik;
    private int bil;
    private int bim;
    private int bin;
    private int bio;
    private int bip;
    private int biq;
    private boolean bir;
    private float bis;
    private int bit;
    private int biu;
    private int biv;
    private boolean biw;
    private a bix;
    private int biy;
    private GestureDetector.OnGestureListener biz;
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
        this.bib = 0;
        this.bic = true;
        this.bif = false;
        this.bih = false;
        this.bik = -1;
        this.bil = -1;
        this.bim = -1;
        this.mTempLoc = new int[2];
        this.bir = false;
        this.bis = 500.0f;
        this.biz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bif && b.this.bih) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bis) {
                        if (b.this.biy > (-width)) {
                            b.this.bix.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bis) && b.this.biy < width) {
                        b.this.bix.stopDragWithVelocity(true, f);
                    }
                    b.this.bih = false;
                }
                return false;
            }
        };
        this.bix = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bii = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bix.isDragEnabled() || b.this.bix.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bip = (int) motionEvent.getX();
                b.this.biq = (int) motionEvent.getY();
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
        this.bij = new GestureDetector(listView.getContext(), this.biz);
        this.bij.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bit = i;
        this.biu = i4;
        this.biv = i5;
        fY(i3);
        fX(i2);
    }

    public GestureDetector PL() {
        return this.bii;
    }

    public void fX(int i) {
        this.bib = i;
    }

    public void cD(boolean z) {
        this.bic = z;
    }

    public void fY(int i) {
        this.bie = i;
    }

    public void cE(boolean z) {
        this.bif = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bic && !this.bih) {
            i4 = 12;
        }
        if (this.bif && this.bih) {
            i4 = i4 | 1 | 2;
        }
        this.bir = this.bix.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bir;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bix.isDragEnabled() && !this.bix.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bif && this.bir && this.bie == 1) {
                this.bij.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bip = (int) motionEvent.getX();
                    this.biq = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bif && this.bih) {
                        if ((this.biy >= 0 ? this.biy : -this.biy) > this.mListView.getWidth() / 2) {
                            this.bix.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bih = false;
                    this.bir = false;
                    break;
                case 3:
                    this.bih = false;
                    this.bir = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bif && this.bih) {
            this.biy = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bie == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bit);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.biv);
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
                        this.bin = childAt.getLeft();
                        this.bio = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bif && this.bie == 0) {
            this.bim = b(motionEvent, this.biu);
        }
        this.bik = v(motionEvent);
        if (this.bik != -1 && this.bib == 0) {
            p(this.bik, ((int) motionEvent.getX()) - this.bin, ((int) motionEvent.getY()) - this.bio);
        }
        this.bih = false;
        this.biw = true;
        this.biy = 0;
        this.bil = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bin;
            int i2 = y2 - this.bio;
            if (this.biw && !this.bir && (this.bik != -1 || this.bil != -1)) {
                if (this.bik != -1) {
                    if (this.bib == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bic) {
                        p(this.bik, i, i2);
                    } else if (this.bib != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bif) {
                        this.bih = true;
                        p(this.bil, i, i2);
                    }
                } else if (this.bil != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bif) {
                        this.bih = true;
                        p(this.bil, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.biw = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bik != -1 && this.bib == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.bik, this.bip - this.bin, this.biq - this.bio);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bif && this.bie == 0 && this.bim != -1) {
            this.bix.removeItem(this.bim - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
