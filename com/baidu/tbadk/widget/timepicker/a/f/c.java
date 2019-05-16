package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
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
    public static DateFormat cNW = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cMK;
    private WheelView cNX;
    private WheelView cNY;
    private WheelView cNZ;
    private int cNp;
    private int cNq;
    private int cNr;
    private float cNs;
    private WheelView.DividerType cNx;
    private WheelView cOa;
    private WheelView cOb;
    private WheelView cOc;
    private int cOh;
    private com.baidu.tbadk.widget.timepicker.a.d.b cOi;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = 1900;
    private int endYear = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cOd = 1;
    private int cOe = 12;
    private int cOf = 1;
    private int cOg = 31;
    private boolean cMP = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cMK = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fV(boolean z) {
        this.cMP = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cMP) {
            int[] z = com.baidu.tbadk.widget.timepicker.a.e.b.z(i, i2 + 1, i3);
            a(z[0], z[1] - 1, z[2], z[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cNX = (WheelView) this.view.findViewById(R.id.year);
        this.cNX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.av(this.startYear, this.endYear)));
        this.cNX.setLabel("");
        this.cNX.setCurrentItem(i - this.startYear);
        this.cNX.setGravity(this.gravity);
        this.cNY = (WheelView) this.view.findViewById(R.id.month);
        this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lO(i)));
        this.cNY.setLabel("");
        int lL = com.baidu.tbadk.widget.timepicker.a.e.a.lL(i);
        if (lL != 0 && (i2 > lL - 1 || z)) {
            this.cNY.setCurrentItem(i2 + 1);
        } else {
            this.cNY.setCurrentItem(i2);
        }
        this.cNY.setGravity(this.gravity);
        this.cNZ = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(i) == 0) {
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(i, i2))));
        } else {
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.lK(i))));
        }
        this.cNZ.setLabel("");
        this.cNZ.setCurrentItem(i3 - 1);
        this.cNZ.setGravity(this.gravity);
        this.cOa = (WheelView) this.view.findViewById(R.id.hour);
        this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cOa.setCurrentItem(i4);
        this.cOa.setGravity(this.gravity);
        this.cOb = (WheelView) this.view.findViewById(R.id.min);
        this.cOb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOb.setCurrentItem(i5);
        this.cOb.setGravity(this.gravity);
        this.cOc = (WheelView) this.view.findViewById(R.id.second);
        this.cOc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOc.setCurrentItem(i5);
        this.cOc.setGravity(this.gravity);
        this.cNX.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int au;
                int i8 = c.this.startYear + i7;
                c.this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lO(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) == 0 || c.this.cNY.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) - 1) {
                    c.this.cNY.setCurrentItem(c.this.cNY.getCurrentItem());
                } else {
                    c.this.cNY.setCurrentItem(c.this.cNY.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) == 0 || c.this.cNY.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) - 1) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNY.getCurrentItem() + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNY.getCurrentItem() + 1);
                } else if (c.this.cNY.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) + 1) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.lK(i8))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.lK(i8);
                } else {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNY.getCurrentItem()))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNY.getCurrentItem());
                }
                if (c.this.cNZ.getCurrentItem() > au - 1) {
                    c.this.cNZ.setCurrentItem(au - 1);
                }
                if (c.this.cOi != null) {
                    c.this.cOi.ayx();
                }
            }
        });
        this.cNY.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int au;
                int currentItem = c.this.cNX.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem) - 1) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1);
                } else if (c.this.cNY.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem) + 1) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.lK(currentItem))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.lK(currentItem);
                } else {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7);
                }
                if (c.this.cNZ.getCurrentItem() > au - 1) {
                    c.this.cNZ.setCurrentItem(au - 1);
                }
                if (c.this.cOi != null) {
                    c.this.cOi.ayx();
                }
            }
        });
        a(this.cNZ);
        a(this.cOa);
        a(this.cOb);
        a(this.cOc);
        if (this.cMK.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cNX.setVisibility(this.cMK[0] ? 0 : 8);
        this.cNY.setVisibility(this.cMK[1] ? 0 : 8);
        this.cNZ.setVisibility(this.cMK[2] ? 0 : 8);
        this.cOa.setVisibility(this.cMK[3] ? 0 : 8);
        this.cOb.setVisibility(this.cMK[4] ? 0 : 8);
        this.cOc.setVisibility(this.cMK[5] ? 0 : 8);
        ayH();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cOh = i;
        this.cNX = (WheelView) this.view.findViewById(R.id.year);
        this.cNX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.cNX.setCurrentItem(i - this.startYear);
        this.cNX.setGravity(this.gravity);
        this.cNY = (WheelView) this.view.findViewById(R.id.month);
        if (this.startYear == this.endYear) {
            this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOd, this.cOe));
            this.cNY.setCurrentItem((i2 + 1) - this.cOd);
        } else if (i == this.startYear) {
            this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOd, 12));
            this.cNY.setCurrentItem((i2 + 1) - this.cOd);
        } else if (i == this.endYear) {
            this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOe));
            this.cNY.setCurrentItem(i2);
        } else {
            this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cNY.setCurrentItem(i2);
        }
        this.cNY.setGravity(this.gravity);
        this.cNZ = (WheelView) this.view.findViewById(R.id.day);
        if (this.startYear == this.endYear && this.cOd == this.cOe) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cOg > 31) {
                    this.cOg = 31;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, this.cOg));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cOg > 30) {
                    this.cOg = 30;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, this.cOg));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cOg > 29) {
                    this.cOg = 29;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, this.cOg));
            } else {
                if (this.cOg > 28) {
                    this.cOg = 28;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, this.cOg));
            }
            this.cNZ.setCurrentItem(i3 - this.cOf);
        } else if (i == this.startYear && i2 + 1 == this.cOd) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, 29));
            } else {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOf, 28));
            }
            this.cNZ.setCurrentItem(i3 - this.cOf);
        } else if (i == this.endYear && i2 + 1 == this.cOe) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cOg > 31) {
                    this.cOg = 31;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOg));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cOg > 30) {
                    this.cOg = 30;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOg));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cOg > 29) {
                    this.cOg = 29;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOg));
            } else {
                if (this.cOg > 28) {
                    this.cOg = 28;
                }
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOg));
            }
            this.cNZ.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cNZ.setCurrentItem(i3 - 1);
        }
        this.cNZ.setGravity(this.gravity);
        this.cOa = (WheelView) this.view.findViewById(R.id.hour);
        this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cOa.setCurrentItem(i4);
        this.cOa.setGravity(this.gravity);
        this.cOb = (WheelView) this.view.findViewById(R.id.min);
        this.cOb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOb.setCurrentItem(i5);
        this.cOb.setGravity(this.gravity);
        this.cOc = (WheelView) this.view.findViewById(R.id.second);
        this.cOc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOc.setCurrentItem(i6);
        this.cOc.setGravity(this.gravity);
        this.cNX.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.cOh = i8;
                int currentItem = c.this.cNY.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cOd, c.this.cOe));
                    if (currentItem > c.this.cNY.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cNY.getAdapter().getItemsCount() - 1;
                        c.this.cNY.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cOd + currentItem;
                    if (c.this.cOd == c.this.cOe) {
                        c.this.a(i8, i9, c.this.cOf, c.this.cOg, asList, asList2);
                    } else if (i9 == c.this.cOd) {
                        c.this.a(i8, i9, c.this.cOf, 31, asList, asList2);
                    } else if (i9 == c.this.cOe) {
                        c.this.a(i8, i9, 1, c.this.cOg, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cOd, 12));
                    if (currentItem > c.this.cNY.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cNY.getAdapter().getItemsCount() - 1;
                        c.this.cNY.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cOd + currentItem;
                    if (i10 == c.this.cOd) {
                        c.this.a(i8, i10, c.this.cOf, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cOe));
                    if (currentItem > c.this.cNY.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cNY.getAdapter().getItemsCount() - 1;
                        c.this.cNY.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cOe) {
                        c.this.a(i8, i11, 1, c.this.cOg, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cNY.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cOi != null) {
                    c.this.cOi.ayx();
                }
            }
        });
        this.cNY.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.cOd + i8) - 1;
                    if (c.this.cOd == c.this.cOe) {
                        c.this.a(c.this.cOh, i9, c.this.cOf, c.this.cOg, asList, asList2);
                    } else if (c.this.cOd == i9) {
                        c.this.a(c.this.cOh, i9, c.this.cOf, 31, asList, asList2);
                    } else if (c.this.cOe == i9) {
                        c.this.a(c.this.cOh, i9, 1, c.this.cOg, asList, asList2);
                    } else {
                        c.this.a(c.this.cOh, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cOh == c.this.startYear) {
                    int i10 = (c.this.cOd + i8) - 1;
                    if (i10 == c.this.cOd) {
                        c.this.a(c.this.cOh, i10, c.this.cOf, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cOh, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cOh == c.this.endYear) {
                    if (i8 == c.this.cOe) {
                        c.this.a(c.this.cOh, c.this.cNY.getCurrentItem() + 1, 1, c.this.cOg, asList, asList2);
                    } else {
                        c.this.a(c.this.cOh, c.this.cNY.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cOh, i8, 1, 31, asList, asList2);
                }
                if (c.this.cOi != null) {
                    c.this.cOi.ayx();
                }
            }
        });
        a(this.cNZ);
        a(this.cOa);
        a(this.cOb);
        a(this.cOc);
        if (this.cMK.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cNX.setVisibility(this.cMK[0] ? 0 : 8);
        this.cNY.setVisibility(this.cMK[1] ? 0 : 8);
        this.cNZ.setVisibility(this.cMK[2] ? 0 : 8);
        this.cOa.setVisibility(this.cMK[3] ? 0 : 8);
        this.cOb.setVisibility(this.cMK[4] ? 0 : 8);
        this.cOc.setVisibility(this.cMK[5] ? 0 : 8);
        ayH();
    }

    private void a(WheelView wheelView) {
        if (this.cOi != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lR(int i) {
                    c.this.cOi.ayx();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cNZ.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cNZ.getAdapter().getItemsCount() - 1) {
            this.cNZ.setCurrentItem(this.cNZ.getAdapter().getItemsCount() - 1);
        }
    }

    private void ayH() {
        this.cNZ.setTextSize(this.textSize);
        this.cNY.setTextSize(this.textSize);
        this.cNX.setTextSize(this.textSize);
        this.cOa.setTextSize(this.textSize);
        this.cOb.setTextSize(this.textSize);
        this.cOc.setTextSize(this.textSize);
    }

    private void ayI() {
        this.cNZ.setTextColorOut(this.cNp);
        this.cNY.setTextColorOut(this.cNp);
        this.cNX.setTextColorOut(this.cNp);
        this.cOa.setTextColorOut(this.cNp);
        this.cOb.setTextColorOut(this.cNp);
        this.cOc.setTextColorOut(this.cNp);
    }

    private void ayJ() {
        this.cNZ.setTextColorCenter(this.cNq);
        this.cNY.setTextColorCenter(this.cNq);
        this.cNX.setTextColorCenter(this.cNq);
        this.cOa.setTextColorCenter(this.cNq);
        this.cOb.setTextColorCenter(this.cNq);
        this.cOc.setTextColorCenter(this.cNq);
    }

    private void ayK() {
        this.cNZ.setDividerColor(this.cNr);
        this.cNY.setDividerColor(this.cNr);
        this.cNX.setDividerColor(this.cNr);
        this.cOa.setDividerColor(this.cNr);
        this.cOb.setDividerColor(this.cNr);
        this.cOc.setDividerColor(this.cNr);
    }

    private void ayL() {
        this.cNZ.setDividerType(this.cNx);
        this.cNY.setDividerType(this.cNx);
        this.cNX.setDividerType(this.cNx);
        this.cOa.setDividerType(this.cNx);
        this.cOb.setDividerType(this.cNx);
        this.cOc.setDividerType(this.cNx);
    }

    private void ayM() {
        this.cNZ.setLineSpacingMultiplier(this.cNs);
        this.cNY.setLineSpacingMultiplier(this.cNs);
        this.cNX.setLineSpacingMultiplier(this.cNs);
        this.cOa.setLineSpacingMultiplier(this.cNs);
        this.cOb.setLineSpacingMultiplier(this.cNs);
        this.cOc.setLineSpacingMultiplier(this.cNs);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cMP) {
            if (str != null) {
                this.cNX.setLabel(str);
            } else {
                this.cNX.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cNY.setLabel(str2);
            } else {
                this.cNY.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cNZ.setLabel(str3);
            } else {
                this.cNZ.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cOa.setLabel(str4);
            } else {
                this.cOa.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cOb.setLabel(str5);
            } else {
                this.cOb.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cOc.setLabel(str6);
            } else {
                this.cOc.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cNZ.setTextXOffset(i);
        this.cNY.setTextXOffset(i2);
        this.cNX.setTextXOffset(i3);
        this.cOa.setTextXOffset(i4);
        this.cOb.setTextXOffset(i5);
        this.cOc.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cNX.setCyclic(z);
        this.cNY.setCyclic(z);
        this.cNZ.setCyclic(z);
        this.cOa.setCyclic(z);
        this.cOb.setCyclic(z);
        this.cOc.setCyclic(z);
    }

    public String getTime() {
        if (this.cMP) {
            return ayN();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cOh == this.startYear) {
            if (this.cNY.getCurrentItem() + this.cOd == this.cOd) {
                sb.append(this.cNX.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNY.getCurrentItem() + this.cOd).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNZ.getCurrentItem() + this.cOf).append(" ").append(this.cOa.getCurrentItem()).append(":").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem());
            } else {
                sb.append(this.cNX.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNY.getCurrentItem() + this.cOd).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNZ.getCurrentItem() + 1).append(" ").append(this.cOa.getCurrentItem()).append(":").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem());
            }
        } else {
            sb.append(this.cNX.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNY.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNZ.getCurrentItem() + 1).append(" ").append(this.cOa.getCurrentItem()).append(":").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem());
        }
        return sb.toString();
    }

    private String ayN() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cNX.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem2) == 0) {
            currentItem = this.cNY.getCurrentItem() + 1;
            z = false;
        } else if ((this.cNY.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem2) <= 0) {
            currentItem = this.cNY.getCurrentItem() + 1;
            z = false;
        } else if ((this.cNY.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem2) == 1) {
            currentItem = this.cNY.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cNY.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cNZ.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cOa.getCurrentItem()).append(":").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void lQ(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.cOe = i2;
                this.cOg = i3;
            } else if (i == this.startYear) {
                if (i2 > this.cOd) {
                    this.endYear = i;
                    this.cOe = i2;
                    this.cOg = i3;
                } else if (i2 == this.cOd && i3 > this.cOf) {
                    this.endYear = i;
                    this.cOe = i2;
                    this.cOg = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.cOd = i5;
                this.cOf = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.cOe) {
                    this.cOd = i5;
                    this.cOf = i6;
                    this.startYear = i4;
                } else if (i5 == this.cOe && i6 < this.cOg) {
                    this.cOd = i5;
                    this.cOf = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.cOd = calendar.get(2) + 1;
            this.cOe = calendar2.get(2) + 1;
            this.cOf = calendar.get(5);
            this.cOg = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cNs = f;
        ayM();
    }

    public void setDividerColor(int i) {
        this.cNr = i;
        ayK();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cNx = dividerType;
        ayL();
    }

    public void setTextColorCenter(int i) {
        this.cNq = i;
        ayJ();
    }

    public void setTextColorOut(int i) {
        this.cNp = i;
        ayI();
    }

    public void fW(boolean z) {
        this.cNZ.fW(z);
        this.cNY.fW(z);
        this.cNX.fW(z);
        this.cOa.fW(z);
        this.cOb.fW(z);
        this.cOc.fW(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cOi = bVar;
    }
}
