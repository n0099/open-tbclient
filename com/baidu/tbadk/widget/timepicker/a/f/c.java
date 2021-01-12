package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dyh;
    private int dyi;
    private int dyj;
    private float dyk;
    private boolean[] fWR;
    private WheelView fXV;
    private WheelView fXW;
    private WheelView fXX;
    private WheelView fXY;
    private WheelView fXZ;
    private WheelView.DividerType fXz;
    private WheelView fYa;
    private int fYf;
    private com.baidu.tbadk.widget.timepicker.a.d.b fYg;
    private int gravity;
    private int textSize;
    private View view;
    private int fWV = FeatureCodes.SKY_SEG;
    private int fWW = 2100;
    private int fYb = 1;
    private int fYc = 12;
    private int fYd = 1;
    private int fYe = 31;
    private boolean fWY = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fWR = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void lN(boolean z) {
        this.fWY = z;
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fWY) {
            int[] I = com.baidu.tbadk.widget.timepicker.a.e.b.I(i, i2 + 1, i3);
            a(I[0], I[1] - 1, I[2], I[3] == 1, i4, i5, i6);
            return;
        }
        j(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fXV = (WheelView) this.view.findViewById(R.id.year);
        this.fXV.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fWV, this.fWW)));
        this.fXV.setLabel("");
        this.fXV.setCurrentItem(i - this.fWV);
        this.fXV.setGravity(this.gravity);
        this.fXW = (WheelView) this.view.findViewById(R.id.month);
        this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(i)));
        this.fXW.setLabel("");
        int su = com.baidu.tbadk.widget.timepicker.a.e.a.su(i);
        if (su != 0 && (i2 > su - 1 || z)) {
            this.fXW.setCurrentItem(i2 + 1);
        } else {
            this.fXW.setCurrentItem(i2);
        }
        this.fXW.setGravity(this.gravity);
        this.fXX = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.su(i) == 0) {
            this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.st(i))));
        }
        this.fXX.setLabel("");
        this.fXX.setCurrentItem(i3 - 1);
        this.fXX.setGravity(this.gravity);
        this.fXY = (WheelView) this.view.findViewById(R.id.hour);
        this.fXY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fXY.setCurrentItem(i4);
        this.fXY.setGravity(this.gravity);
        this.fXZ = (WheelView) this.view.findViewById(R.id.min);
        this.fXZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fXZ.setCurrentItem(i5);
        this.fXZ.setGravity(this.gravity);
        this.fYa = (WheelView) this.view.findViewById(R.id.second);
        this.fYa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fYa.setCurrentItem(i5);
        this.fYa.setGravity(this.gravity);
        this.fXV.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sB(int i7) {
                int bu;
                int i8 = c.this.fWV + i7;
                c.this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.su(i8) == 0 || c.this.fXW.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.su(i8) - 1) {
                    c.this.fXW.setCurrentItem(c.this.fXW.getCurrentItem());
                } else {
                    c.this.fXW.setCurrentItem(c.this.fXW.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.su(i8) == 0 || c.this.fXW.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.su(i8) - 1) {
                    c.this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fXW.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fXW.getCurrentItem() + 1);
                } else if (c.this.fXW.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.su(i8) + 1) {
                    c.this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.st(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.st(i8);
                } else {
                    c.this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fXW.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fXW.getCurrentItem());
                }
                if (c.this.fXX.getCurrentItem() > bu - 1) {
                    c.this.fXX.setCurrentItem(bu - 1);
                }
                if (c.this.fYg != null) {
                    c.this.fYg.bIg();
                }
            }
        });
        this.fXW.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sB(int i7) {
                int bu;
                int currentItem = c.this.fXV.getCurrentItem() + c.this.fWV;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.su(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.su(currentItem) - 1) {
                    c.this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.fXW.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.su(currentItem) + 1) {
                    c.this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem);
                } else {
                    c.this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sy(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.fXX.getCurrentItem() > bu - 1) {
                    c.this.fXX.setCurrentItem(bu - 1);
                }
                if (c.this.fYg != null) {
                    c.this.fYg.bIg();
                }
            }
        });
        a(this.fXX);
        a(this.fXY);
        a(this.fXZ);
        a(this.fYa);
        if (this.fWR.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fXV.setVisibility(this.fWR[0] ? 0 : 8);
        this.fXW.setVisibility(this.fWR[1] ? 0 : 8);
        this.fXX.setVisibility(this.fWR[2] ? 0 : 8);
        this.fXY.setVisibility(this.fWR[3] ? 0 : 8);
        this.fXZ.setVisibility(this.fWR[4] ? 0 : 8);
        this.fYa.setVisibility(this.fWR[5] ? 0 : 8);
        bIo();
    }

    private void j(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.fYf = i;
        this.fXV = (WheelView) this.view.findViewById(R.id.year);
        this.fXV.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fWV, this.fWW));
        this.fXV.setCurrentItem(i - this.fWV);
        this.fXV.setGravity(this.gravity);
        this.fXW = (WheelView) this.view.findViewById(R.id.month);
        if (this.fWV == this.fWW) {
            this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYb, this.fYc));
            this.fXW.setCurrentItem((i2 + 1) - this.fYb);
        } else if (i == this.fWV) {
            this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYb, 12));
            this.fXW.setCurrentItem((i2 + 1) - this.fYb);
        } else if (i == this.fWW) {
            this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fYc));
            this.fXW.setCurrentItem(i2);
        } else {
            this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fXW.setCurrentItem(i2);
        }
        this.fXW.setGravity(this.gravity);
        this.fXX = (WheelView) this.view.findViewById(R.id.day);
        if (this.fWV == this.fWW && this.fYb == this.fYc) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fYe > 31) {
                    this.fYe = 31;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, this.fYe));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fYe > 30) {
                    this.fYe = 30;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, this.fYe));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fYe > 29) {
                    this.fYe = 29;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, this.fYe));
            } else {
                if (this.fYe > 28) {
                    this.fYe = 28;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, this.fYe));
            }
            this.fXX.setCurrentItem(i3 - this.fYd);
        } else if (i == this.fWV && i2 + 1 == this.fYb) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, 29));
            } else {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fYd, 28));
            }
            this.fXX.setCurrentItem(i3 - this.fYd);
        } else if (i == this.fWW && i2 + 1 == this.fYc) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fYe > 31) {
                    this.fYe = 31;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fYe));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fYe > 30) {
                    this.fYe = 30;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fYe));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fYe > 29) {
                    this.fYe = 29;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fYe));
            } else {
                if (this.fYe > 28) {
                    this.fYe = 28;
                }
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fYe));
            }
            this.fXX.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fXX.setCurrentItem(i3 - 1);
        }
        this.fXX.setGravity(this.gravity);
        this.fXY = (WheelView) this.view.findViewById(R.id.hour);
        this.fXY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fXY.setCurrentItem(i4);
        this.fXY.setGravity(this.gravity);
        this.fXZ = (WheelView) this.view.findViewById(R.id.min);
        this.fXZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fXZ.setCurrentItem(i5);
        this.fXZ.setGravity(this.gravity);
        this.fYa = (WheelView) this.view.findViewById(R.id.second);
        this.fYa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fYa.setCurrentItem(i6);
        this.fYa.setGravity(this.gravity);
        this.fXV.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sB(int i7) {
                int i8 = i7 + c.this.fWV;
                c.this.fYf = i8;
                int currentItem = c.this.fXW.getCurrentItem();
                if (c.this.fWV == c.this.fWW) {
                    c.this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fYb, c.this.fYc));
                    if (currentItem > c.this.fXW.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fXW.getAdapter().getItemsCount() - 1;
                        c.this.fXW.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fYb + currentItem;
                    if (c.this.fYb == c.this.fYc) {
                        c.this.a(i8, i9, c.this.fYd, c.this.fYe, asList, asList2);
                    } else if (i9 == c.this.fYb) {
                        c.this.a(i8, i9, c.this.fYd, 31, asList, asList2);
                    } else if (i9 == c.this.fYc) {
                        c.this.a(i8, i9, 1, c.this.fYe, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fWV) {
                    c.this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fYb, 12));
                    if (currentItem > c.this.fXW.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fXW.getAdapter().getItemsCount() - 1;
                        c.this.fXW.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fYb + currentItem;
                    if (i10 == c.this.fYb) {
                        c.this.a(i8, i10, c.this.fYd, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fWW) {
                    c.this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fYc));
                    if (currentItem > c.this.fXW.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fXW.getAdapter().getItemsCount() - 1;
                        c.this.fXW.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fYc) {
                        c.this.a(i8, i11, 1, c.this.fYe, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fXW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fXW.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fYg != null) {
                    c.this.fYg.bIg();
                }
            }
        });
        this.fXW.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sB(int i7) {
                int i8 = i7 + 1;
                if (c.this.fWV == c.this.fWW) {
                    int i9 = (c.this.fYb + i8) - 1;
                    if (c.this.fYb == c.this.fYc) {
                        c.this.a(c.this.fYf, i9, c.this.fYd, c.this.fYe, asList, asList2);
                    } else if (c.this.fYb == i9) {
                        c.this.a(c.this.fYf, i9, c.this.fYd, 31, asList, asList2);
                    } else if (c.this.fYc == i9) {
                        c.this.a(c.this.fYf, i9, 1, c.this.fYe, asList, asList2);
                    } else {
                        c.this.a(c.this.fYf, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fYf == c.this.fWV) {
                    int i10 = (c.this.fYb + i8) - 1;
                    if (i10 == c.this.fYb) {
                        c.this.a(c.this.fYf, i10, c.this.fYd, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fYf, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fYf == c.this.fWW) {
                    if (i8 == c.this.fYc) {
                        c.this.a(c.this.fYf, c.this.fXW.getCurrentItem() + 1, 1, c.this.fYe, asList, asList2);
                    } else {
                        c.this.a(c.this.fYf, c.this.fXW.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fYf, i8, 1, 31, asList, asList2);
                }
                if (c.this.fYg != null) {
                    c.this.fYg.bIg();
                }
            }
        });
        a(this.fXX);
        a(this.fXY);
        a(this.fXZ);
        a(this.fYa);
        if (this.fWR.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fXV.setVisibility(this.fWR[0] ? 0 : 8);
        this.fXW.setVisibility(this.fWR[1] ? 0 : 8);
        this.fXX.setVisibility(this.fWR[2] ? 0 : 8);
        this.fXY.setVisibility(this.fWR[3] ? 0 : 8);
        this.fXZ.setVisibility(this.fWR[4] ? 0 : 8);
        this.fYa.setVisibility(this.fWR[5] ? 0 : 8);
        bIo();
    }

    private void a(WheelView wheelView) {
        if (this.fYg != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void sB(int i) {
                    c.this.fYg.bIg();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fXX.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fXX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fXX.getAdapter().getItemsCount() - 1) {
            this.fXX.setCurrentItem(this.fXX.getAdapter().getItemsCount() - 1);
        }
    }

    private void bIo() {
        this.fXX.setTextSize(this.textSize);
        this.fXW.setTextSize(this.textSize);
        this.fXV.setTextSize(this.textSize);
        this.fXY.setTextSize(this.textSize);
        this.fXZ.setTextSize(this.textSize);
        this.fYa.setTextSize(this.textSize);
    }

    private void bIp() {
        this.fXX.setTextColorOut(this.dyh);
        this.fXW.setTextColorOut(this.dyh);
        this.fXV.setTextColorOut(this.dyh);
        this.fXY.setTextColorOut(this.dyh);
        this.fXZ.setTextColorOut(this.dyh);
        this.fYa.setTextColorOut(this.dyh);
    }

    private void bIq() {
        this.fXX.setTextColorCenter(this.dyi);
        this.fXW.setTextColorCenter(this.dyi);
        this.fXV.setTextColorCenter(this.dyi);
        this.fXY.setTextColorCenter(this.dyi);
        this.fXZ.setTextColorCenter(this.dyi);
        this.fYa.setTextColorCenter(this.dyi);
    }

    private void bIr() {
        this.fXX.setDividerColor(this.dyj);
        this.fXW.setDividerColor(this.dyj);
        this.fXV.setDividerColor(this.dyj);
        this.fXY.setDividerColor(this.dyj);
        this.fXZ.setDividerColor(this.dyj);
        this.fYa.setDividerColor(this.dyj);
    }

    private void bIs() {
        this.fXX.setDividerType(this.fXz);
        this.fXW.setDividerType(this.fXz);
        this.fXV.setDividerType(this.fXz);
        this.fXY.setDividerType(this.fXz);
        this.fXZ.setDividerType(this.fXz);
        this.fYa.setDividerType(this.fXz);
    }

    private void bIt() {
        this.fXX.setLineSpacingMultiplier(this.dyk);
        this.fXW.setLineSpacingMultiplier(this.dyk);
        this.fXV.setLineSpacingMultiplier(this.dyk);
        this.fXY.setLineSpacingMultiplier(this.dyk);
        this.fXZ.setLineSpacingMultiplier(this.dyk);
        this.fYa.setLineSpacingMultiplier(this.dyk);
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fWY) {
            if (str != null) {
                this.fXV.setLabel(str);
            } else {
                this.fXV.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fXW.setLabel(str2);
            } else {
                this.fXW.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fXX.setLabel(str3);
            } else {
                this.fXX.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fXY.setLabel(str4);
            } else {
                this.fXY.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fXZ.setLabel(str5);
            } else {
                this.fXZ.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fYa.setLabel(str6);
            } else {
                this.fYa.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fXX.setTextXOffset(i);
        this.fXW.setTextXOffset(i2);
        this.fXV.setTextXOffset(i3);
        this.fXY.setTextXOffset(i4);
        this.fXZ.setTextXOffset(i5);
        this.fYa.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fXV.setCyclic(z);
        this.fXW.setCyclic(z);
        this.fXX.setCyclic(z);
        this.fXY.setCyclic(z);
        this.fXZ.setCyclic(z);
        this.fYa.setCyclic(z);
    }

    public String getTime() {
        if (this.fWY) {
            return bIu();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fYf == this.fWV) {
            if (this.fXW.getCurrentItem() + this.fYb == this.fYb) {
                sb.append(this.fXV.getCurrentItem() + this.fWV).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fXW.getCurrentItem() + this.fYb).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fXX.getCurrentItem() + this.fYd).append(" ").append(this.fXY.getCurrentItem()).append(":").append(this.fXZ.getCurrentItem()).append(":").append(this.fYa.getCurrentItem());
            } else {
                sb.append(this.fXV.getCurrentItem() + this.fWV).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fXW.getCurrentItem() + this.fYb).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fXX.getCurrentItem() + 1).append(" ").append(this.fXY.getCurrentItem()).append(":").append(this.fXZ.getCurrentItem()).append(":").append(this.fYa.getCurrentItem());
            }
        } else {
            sb.append(this.fXV.getCurrentItem() + this.fWV).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fXW.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fXX.getCurrentItem() + 1).append(" ").append(this.fXY.getCurrentItem()).append(":").append(this.fXZ.getCurrentItem()).append(":").append(this.fYa.getCurrentItem());
        }
        return sb.toString();
    }

    private String bIu() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fXV.getCurrentItem() + this.fWV;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.su(currentItem2) == 0) {
            currentItem = this.fXW.getCurrentItem() + 1;
            z = false;
        } else if ((this.fXW.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.su(currentItem2) <= 0) {
            currentItem = this.fXW.getCurrentItem() + 1;
            z = false;
        } else if ((this.fXW.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.su(currentItem2) == 1) {
            currentItem = this.fXW.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fXW.getCurrentItem();
            z = false;
        }
        int[] d = com.baidu.tbadk.widget.timepicker.a.e.b.d(currentItem2, currentItem, this.fXX.getCurrentItem() + 1, z);
        sb.append(d[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[2]).append(" ").append(this.fXY.getCurrentItem()).append(":").append(this.fXZ.getCurrentItem()).append(":").append(this.fYa.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sz(int i) {
        this.fWV = i;
    }

    public void sA(int i) {
        this.fWW = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fWV) {
                this.fWW = i;
                this.fYc = i2;
                this.fYe = i3;
            } else if (i == this.fWV) {
                if (i2 > this.fYb) {
                    this.fWW = i;
                    this.fYc = i2;
                    this.fYe = i3;
                } else if (i2 == this.fYb && i3 > this.fYd) {
                    this.fWW = i;
                    this.fYc = i2;
                    this.fYe = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fWW) {
                this.fYb = i5;
                this.fYd = i6;
                this.fWV = i4;
            } else if (i4 == this.fWW) {
                if (i5 < this.fYc) {
                    this.fYb = i5;
                    this.fYd = i6;
                    this.fWV = i4;
                } else if (i5 == this.fYc && i6 < this.fYe) {
                    this.fYb = i5;
                    this.fYd = i6;
                    this.fWV = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fWV = calendar.get(1);
            this.fWW = calendar2.get(1);
            this.fYb = calendar.get(2) + 1;
            this.fYc = calendar2.get(2) + 1;
            this.fYd = calendar.get(5);
            this.fYe = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.dyk = f;
        bIt();
    }

    public void setDividerColor(int i) {
        this.dyj = i;
        bIr();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fXz = dividerType;
        bIs();
    }

    public void setTextColorCenter(int i) {
        this.dyi = i;
        bIq();
    }

    public void setTextColorOut(int i) {
        this.dyh = i;
        bIp();
    }

    public void lO(boolean z) {
        this.fXX.lO(z);
        this.fXW.lO(z);
        this.fXV.lO(z);
        this.fXY.lO(z);
        this.fXZ.lO(z);
        this.fYa.lO(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fYg = bVar;
    }
}
