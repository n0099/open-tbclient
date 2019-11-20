package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static DateFormat cYR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cXD;
    private WheelView cYS;
    private WheelView cYT;
    private WheelView cYU;
    private WheelView cYV;
    private WheelView cYW;
    private WheelView cYX;
    private int cYk;
    private int cYl;
    private int cYm;
    private float cYn;
    private WheelView.DividerType cYs;
    private int cZc;
    private com.baidu.tbadk.widget.timepicker.a.d.b cZd;
    private int gravity;
    private int textSize;
    private View view;
    private int cXH = 1900;
    private int cXI = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cYY = 1;
    private int cYZ = 12;
    private int cZa = 1;
    private int cZb = 31;
    private boolean cXK = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cXD = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fR(boolean z) {
        this.cXK = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cXK) {
            int[] A = com.baidu.tbadk.widget.timepicker.a.e.b.A(i, i2 + 1, i3);
            a(A[0], A[1] - 1, A[2], A[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cYS = (WheelView) this.view.findViewById(R.id.year);
        this.cYS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ay(this.cXH, this.cXI)));
        this.cYS.setLabel("");
        this.cYS.setCurrentItem(i - this.cXH);
        this.cYS.setGravity(this.gravity);
        this.cYT = (WheelView) this.view.findViewById(R.id.month);
        this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ld(i)));
        this.cYT.setLabel("");
        int la = com.baidu.tbadk.widget.timepicker.a.e.a.la(i);
        if (la != 0 && (i2 > la - 1 || z)) {
            this.cYT.setCurrentItem(i2 + 1);
        } else {
            this.cYT.setCurrentItem(i2);
        }
        this.cYT.setGravity(this.gravity);
        this.cYU = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.la(i) == 0) {
            this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.ax(i, i2))));
        } else {
            this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i))));
        }
        this.cYU.setLabel("");
        this.cYU.setCurrentItem(i3 - 1);
        this.cYU.setGravity(this.gravity);
        this.cYV = (WheelView) this.view.findViewById(R.id.hour);
        this.cYV.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cYV.setCurrentItem(i4);
        this.cYV.setGravity(this.gravity);
        this.cYW = (WheelView) this.view.findViewById(R.id.min);
        this.cYW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cYW.setCurrentItem(i5);
        this.cYW.setGravity(this.gravity);
        this.cYX = (WheelView) this.view.findViewById(R.id.second);
        this.cYX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cYX.setCurrentItem(i5);
        this.cYX.setGravity(this.gravity);
        this.cYS.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lh(int i7) {
                int ax;
                int i8 = c.this.cXH + i7;
                c.this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ld(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.la(i8) == 0 || c.this.cYT.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.la(i8) - 1) {
                    c.this.cYT.setCurrentItem(c.this.cYT.getCurrentItem());
                } else {
                    c.this.cYT.setCurrentItem(c.this.cYT.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.la(i8) == 0 || c.this.cYT.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.la(i8) - 1) {
                    c.this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.ax(i8, c.this.cYT.getCurrentItem() + 1))));
                    ax = com.baidu.tbadk.widget.timepicker.a.e.a.ax(i8, c.this.cYT.getCurrentItem() + 1);
                } else if (c.this.cYT.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.la(i8) + 1) {
                    c.this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i8))));
                    ax = com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i8);
                } else {
                    c.this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.ax(i8, c.this.cYT.getCurrentItem()))));
                    ax = com.baidu.tbadk.widget.timepicker.a.e.a.ax(i8, c.this.cYT.getCurrentItem());
                }
                if (c.this.cYU.getCurrentItem() > ax - 1) {
                    c.this.cYU.setCurrentItem(ax - 1);
                }
                if (c.this.cZd != null) {
                    c.this.cZd.aAf();
                }
            }
        });
        this.cYT.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lh(int i7) {
                int ax;
                int currentItem = c.this.cYS.getCurrentItem() + c.this.cXH;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem) - 1) {
                    c.this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.ax(currentItem, i7 + 1))));
                    ax = com.baidu.tbadk.widget.timepicker.a.e.a.ax(currentItem, i7 + 1);
                } else if (c.this.cYT.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem) + 1) {
                    c.this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(currentItem))));
                    ax = com.baidu.tbadk.widget.timepicker.a.e.a.kZ(currentItem);
                } else {
                    c.this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(com.baidu.tbadk.widget.timepicker.a.e.a.ax(currentItem, i7))));
                    ax = com.baidu.tbadk.widget.timepicker.a.e.a.ax(currentItem, i7);
                }
                if (c.this.cYU.getCurrentItem() > ax - 1) {
                    c.this.cYU.setCurrentItem(ax - 1);
                }
                if (c.this.cZd != null) {
                    c.this.cZd.aAf();
                }
            }
        });
        a(this.cYU);
        a(this.cYV);
        a(this.cYW);
        a(this.cYX);
        if (this.cXD.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cYS.setVisibility(this.cXD[0] ? 0 : 8);
        this.cYT.setVisibility(this.cXD[1] ? 0 : 8);
        this.cYU.setVisibility(this.cXD[2] ? 0 : 8);
        this.cYV.setVisibility(this.cXD[3] ? 0 : 8);
        this.cYW.setVisibility(this.cXD[4] ? 0 : 8);
        this.cYX.setVisibility(this.cXD[5] ? 0 : 8);
        aAr();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cZc = i;
        this.cYS = (WheelView) this.view.findViewById(R.id.year);
        this.cYS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cXH, this.cXI));
        this.cYS.setCurrentItem(i - this.cXH);
        this.cYS.setGravity(this.gravity);
        this.cYT = (WheelView) this.view.findViewById(R.id.month);
        if (this.cXH == this.cXI) {
            this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cYY, this.cYZ));
            this.cYT.setCurrentItem((i2 + 1) - this.cYY);
        } else if (i == this.cXH) {
            this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cYY, 12));
            this.cYT.setCurrentItem((i2 + 1) - this.cYY);
        } else if (i == this.cXI) {
            this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cYZ));
            this.cYT.setCurrentItem(i2);
        } else {
            this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cYT.setCurrentItem(i2);
        }
        this.cYT.setGravity(this.gravity);
        this.cYU = (WheelView) this.view.findViewById(R.id.day);
        if (this.cXH == this.cXI && this.cYY == this.cYZ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cZb > 31) {
                    this.cZb = 31;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, this.cZb));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cZb > 30) {
                    this.cZb = 30;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, this.cZb));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cZb > 29) {
                    this.cZb = 29;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, this.cZb));
            } else {
                if (this.cZb > 28) {
                    this.cZb = 28;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, this.cZb));
            }
            this.cYU.setCurrentItem(i3 - this.cZa);
        } else if (i == this.cXH && i2 + 1 == this.cYY) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, 29));
            } else {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZa, 28));
            }
            this.cYU.setCurrentItem(i3 - this.cZa);
        } else if (i == this.cXI && i2 + 1 == this.cYZ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cZb > 31) {
                    this.cZb = 31;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZb));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cZb > 30) {
                    this.cZb = 30;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZb));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cZb > 29) {
                    this.cZb = 29;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZb));
            } else {
                if (this.cZb > 28) {
                    this.cZb = 28;
                }
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZb));
            }
            this.cYU.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cYU.setCurrentItem(i3 - 1);
        }
        this.cYU.setGravity(this.gravity);
        this.cYV = (WheelView) this.view.findViewById(R.id.hour);
        this.cYV.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cYV.setCurrentItem(i4);
        this.cYV.setGravity(this.gravity);
        this.cYW = (WheelView) this.view.findViewById(R.id.min);
        this.cYW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cYW.setCurrentItem(i5);
        this.cYW.setGravity(this.gravity);
        this.cYX = (WheelView) this.view.findViewById(R.id.second);
        this.cYX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cYX.setCurrentItem(i6);
        this.cYX.setGravity(this.gravity);
        this.cYS.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lh(int i7) {
                int i8 = i7 + c.this.cXH;
                c.this.cZc = i8;
                int currentItem = c.this.cYT.getCurrentItem();
                if (c.this.cXH == c.this.cXI) {
                    c.this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cYY, c.this.cYZ));
                    if (currentItem > c.this.cYT.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cYT.getAdapter().getItemsCount() - 1;
                        c.this.cYT.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cYY + currentItem;
                    if (c.this.cYY == c.this.cYZ) {
                        c.this.a(i8, i9, c.this.cZa, c.this.cZb, asList, asList2);
                    } else if (i9 == c.this.cYY) {
                        c.this.a(i8, i9, c.this.cZa, 31, asList, asList2);
                    } else if (i9 == c.this.cYZ) {
                        c.this.a(i8, i9, 1, c.this.cZb, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cXH) {
                    c.this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cYY, 12));
                    if (currentItem > c.this.cYT.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cYT.getAdapter().getItemsCount() - 1;
                        c.this.cYT.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cYY + currentItem;
                    if (i10 == c.this.cYY) {
                        c.this.a(i8, i10, c.this.cZa, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cXI) {
                    c.this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cYZ));
                    if (currentItem > c.this.cYT.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cYT.getAdapter().getItemsCount() - 1;
                        c.this.cYT.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cYZ) {
                        c.this.a(i8, i11, 1, c.this.cZb, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cYT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cYT.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cZd != null) {
                    c.this.cZd.aAf();
                }
            }
        });
        this.cYT.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lh(int i7) {
                int i8 = i7 + 1;
                if (c.this.cXH == c.this.cXI) {
                    int i9 = (c.this.cYY + i8) - 1;
                    if (c.this.cYY == c.this.cYZ) {
                        c.this.a(c.this.cZc, i9, c.this.cZa, c.this.cZb, asList, asList2);
                    } else if (c.this.cYY == i9) {
                        c.this.a(c.this.cZc, i9, c.this.cZa, 31, asList, asList2);
                    } else if (c.this.cYZ == i9) {
                        c.this.a(c.this.cZc, i9, 1, c.this.cZb, asList, asList2);
                    } else {
                        c.this.a(c.this.cZc, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cZc == c.this.cXH) {
                    int i10 = (c.this.cYY + i8) - 1;
                    if (i10 == c.this.cYY) {
                        c.this.a(c.this.cZc, i10, c.this.cZa, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cZc, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cZc == c.this.cXI) {
                    if (i8 == c.this.cYZ) {
                        c.this.a(c.this.cZc, c.this.cYT.getCurrentItem() + 1, 1, c.this.cZb, asList, asList2);
                    } else {
                        c.this.a(c.this.cZc, c.this.cYT.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cZc, i8, 1, 31, asList, asList2);
                }
                if (c.this.cZd != null) {
                    c.this.cZd.aAf();
                }
            }
        });
        a(this.cYU);
        a(this.cYV);
        a(this.cYW);
        a(this.cYX);
        if (this.cXD.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cYS.setVisibility(this.cXD[0] ? 0 : 8);
        this.cYT.setVisibility(this.cXD[1] ? 0 : 8);
        this.cYU.setVisibility(this.cXD[2] ? 0 : 8);
        this.cYV.setVisibility(this.cXD[3] ? 0 : 8);
        this.cYW.setVisibility(this.cXD[4] ? 0 : 8);
        this.cYX.setVisibility(this.cXD[5] ? 0 : 8);
        aAr();
    }

    private void a(WheelView wheelView) {
        if (this.cZd != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lh(int i) {
                    c.this.cZd.aAf();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cYU.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cYU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cYU.getAdapter().getItemsCount() - 1) {
            this.cYU.setCurrentItem(this.cYU.getAdapter().getItemsCount() - 1);
        }
    }

    private void aAr() {
        this.cYU.setTextSize(this.textSize);
        this.cYT.setTextSize(this.textSize);
        this.cYS.setTextSize(this.textSize);
        this.cYV.setTextSize(this.textSize);
        this.cYW.setTextSize(this.textSize);
        this.cYX.setTextSize(this.textSize);
    }

    private void aAs() {
        this.cYU.setTextColorOut(this.cYk);
        this.cYT.setTextColorOut(this.cYk);
        this.cYS.setTextColorOut(this.cYk);
        this.cYV.setTextColorOut(this.cYk);
        this.cYW.setTextColorOut(this.cYk);
        this.cYX.setTextColorOut(this.cYk);
    }

    private void aAt() {
        this.cYU.setTextColorCenter(this.cYl);
        this.cYT.setTextColorCenter(this.cYl);
        this.cYS.setTextColorCenter(this.cYl);
        this.cYV.setTextColorCenter(this.cYl);
        this.cYW.setTextColorCenter(this.cYl);
        this.cYX.setTextColorCenter(this.cYl);
    }

    private void aAu() {
        this.cYU.setDividerColor(this.cYm);
        this.cYT.setDividerColor(this.cYm);
        this.cYS.setDividerColor(this.cYm);
        this.cYV.setDividerColor(this.cYm);
        this.cYW.setDividerColor(this.cYm);
        this.cYX.setDividerColor(this.cYm);
    }

    private void aAv() {
        this.cYU.setDividerType(this.cYs);
        this.cYT.setDividerType(this.cYs);
        this.cYS.setDividerType(this.cYs);
        this.cYV.setDividerType(this.cYs);
        this.cYW.setDividerType(this.cYs);
        this.cYX.setDividerType(this.cYs);
    }

    private void aAw() {
        this.cYU.setLineSpacingMultiplier(this.cYn);
        this.cYT.setLineSpacingMultiplier(this.cYn);
        this.cYS.setLineSpacingMultiplier(this.cYn);
        this.cYV.setLineSpacingMultiplier(this.cYn);
        this.cYW.setLineSpacingMultiplier(this.cYn);
        this.cYX.setLineSpacingMultiplier(this.cYn);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cXK) {
            if (str != null) {
                this.cYS.setLabel(str);
            } else {
                this.cYS.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cYT.setLabel(str2);
            } else {
                this.cYT.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cYU.setLabel(str3);
            } else {
                this.cYU.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cYV.setLabel(str4);
            } else {
                this.cYV.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cYW.setLabel(str5);
            } else {
                this.cYW.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cYX.setLabel(str6);
            } else {
                this.cYX.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cYU.setTextXOffset(i);
        this.cYT.setTextXOffset(i2);
        this.cYS.setTextXOffset(i3);
        this.cYV.setTextXOffset(i4);
        this.cYW.setTextXOffset(i5);
        this.cYX.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cYS.setCyclic(z);
        this.cYT.setCyclic(z);
        this.cYU.setCyclic(z);
        this.cYV.setCyclic(z);
        this.cYW.setCyclic(z);
        this.cYX.setCyclic(z);
    }

    public String getTime() {
        if (this.cXK) {
            return aAx();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cZc == this.cXH) {
            if (this.cYT.getCurrentItem() + this.cYY == this.cYY) {
                sb.append(this.cYS.getCurrentItem() + this.cXH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cYT.getCurrentItem() + this.cYY).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cYU.getCurrentItem() + this.cZa).append(HanziToPinyin.Token.SEPARATOR).append(this.cYV.getCurrentItem()).append(":").append(this.cYW.getCurrentItem()).append(":").append(this.cYX.getCurrentItem());
            } else {
                sb.append(this.cYS.getCurrentItem() + this.cXH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cYT.getCurrentItem() + this.cYY).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cYU.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.cYV.getCurrentItem()).append(":").append(this.cYW.getCurrentItem()).append(":").append(this.cYX.getCurrentItem());
            }
        } else {
            sb.append(this.cYS.getCurrentItem() + this.cXH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cYT.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cYU.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.cYV.getCurrentItem()).append(":").append(this.cYW.getCurrentItem()).append(":").append(this.cYX.getCurrentItem());
        }
        return sb.toString();
    }

    private String aAx() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cYS.getCurrentItem() + this.cXH;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem2) == 0) {
            currentItem = this.cYT.getCurrentItem() + 1;
            z = false;
        } else if ((this.cYT.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem2) <= 0) {
            currentItem = this.cYT.getCurrentItem() + 1;
            z = false;
        } else if ((this.cYT.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem2) == 1) {
            currentItem = this.cYT.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cYT.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cYU.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.cYV.getCurrentItem()).append(":").append(this.cYW.getCurrentItem()).append(":").append(this.cYX.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void lf(int i) {
        this.cXH = i;
    }

    public void lg(int i) {
        this.cXI = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.cXH) {
                this.cXI = i;
                this.cYZ = i2;
                this.cZb = i3;
            } else if (i == this.cXH) {
                if (i2 > this.cYY) {
                    this.cXI = i;
                    this.cYZ = i2;
                    this.cZb = i3;
                } else if (i2 == this.cYY && i3 > this.cZa) {
                    this.cXI = i;
                    this.cYZ = i2;
                    this.cZb = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.cXI) {
                this.cYY = i5;
                this.cZa = i6;
                this.cXH = i4;
            } else if (i4 == this.cXI) {
                if (i5 < this.cYZ) {
                    this.cYY = i5;
                    this.cZa = i6;
                    this.cXH = i4;
                } else if (i5 == this.cYZ && i6 < this.cZb) {
                    this.cYY = i5;
                    this.cZa = i6;
                    this.cXH = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.cXH = calendar.get(1);
            this.cXI = calendar2.get(1);
            this.cYY = calendar.get(2) + 1;
            this.cYZ = calendar2.get(2) + 1;
            this.cZa = calendar.get(5);
            this.cZb = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cYn = f;
        aAw();
    }

    public void setDividerColor(int i) {
        this.cYm = i;
        aAu();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cYs = dividerType;
        aAv();
    }

    public void setTextColorCenter(int i) {
        this.cYl = i;
        aAt();
    }

    public void setTextColorOut(int i) {
        this.cYk = i;
        aAs();
    }

    public void fS(boolean z) {
        this.cYU.fS(z);
        this.cYT.fS(z);
        this.cYS.fS(z);
        this.cYV.fS(z);
        this.cYW.fS(z);
        this.cYX.fS(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cZd = bVar;
    }
}
