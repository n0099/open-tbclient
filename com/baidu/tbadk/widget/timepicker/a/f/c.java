package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private boolean[] fER;
    private WheelView.DividerType fFB;
    private WheelView fFX;
    private WheelView fFY;
    private WheelView fFZ;
    private WheelView fGa;
    private WheelView fGb;
    private WheelView fGc;
    private int fGh;
    private com.baidu.tbadk.widget.timepicker.a.d.b fGi;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fEV = FeatureCodes.SKY_SEG;
    private int fEW = 2100;
    private int fGd = 1;
    private int fGe = 12;
    private int fGf = 1;
    private int fGg = 31;
    private boolean fEY = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fER = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void kR(boolean z) {
        this.fEY = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fEY) {
            int[] C = com.baidu.tbadk.widget.timepicker.a.e.b.C(i, i2 + 1, i3);
            a(C[0], C[1] - 1, C[2], C[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fFX = (WheelView) this.view.findViewById(R.id.year);
        this.fFX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fEV, this.fEW)));
        this.fFX.setLabel("");
        this.fFX.setCurrentItem(i - this.fEV);
        this.fFX.setGravity(this.gravity);
        this.fFY = (WheelView) this.view.findViewById(R.id.month);
        this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sH(i)));
        this.fFY.setLabel("");
        int sE = com.baidu.tbadk.widget.timepicker.a.e.a.sE(i);
        if (sE != 0 && (i2 > sE - 1 || z)) {
            this.fFY.setCurrentItem(i2 + 1);
        } else {
            this.fFY.setCurrentItem(i2);
        }
        this.fFY.setGravity(this.gravity);
        this.fFZ = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sE(i) == 0) {
            this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.sD(i))));
        }
        this.fFZ.setLabel("");
        this.fFZ.setCurrentItem(i3 - 1);
        this.fFZ.setGravity(this.gravity);
        this.fGa = (WheelView) this.view.findViewById(R.id.hour);
        this.fGa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fGa.setCurrentItem(i4);
        this.fGa.setGravity(this.gravity);
        this.fGb = (WheelView) this.view.findViewById(R.id.min);
        this.fGb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fGb.setCurrentItem(i5);
        this.fGb.setGravity(this.gravity);
        this.fGc = (WheelView) this.view.findViewById(R.id.second);
        this.fGc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fGc.setCurrentItem(i5);
        this.fGc.setGravity(this.gravity);
        this.fFX.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int i8 = c.this.fEV + i7;
                c.this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sH(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sE(i8) == 0 || c.this.fFY.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sE(i8) - 1) {
                    c.this.fFY.setCurrentItem(c.this.fFY.getCurrentItem());
                } else {
                    c.this.fFY.setCurrentItem(c.this.fFY.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sE(i8) == 0 || c.this.fFY.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sE(i8) - 1) {
                    c.this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fFY.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fFY.getCurrentItem() + 1);
                } else if (c.this.fFY.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sE(i8) + 1) {
                    c.this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.sD(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.sD(i8);
                } else {
                    c.this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fFY.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fFY.getCurrentItem());
                }
                if (c.this.fFZ.getCurrentItem() > bu - 1) {
                    c.this.fFZ.setCurrentItem(bu - 1);
                }
                if (c.this.fGi != null) {
                    c.this.fGi.bEn();
                }
            }
        });
        this.fFY.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int currentItem = c.this.fFX.getCurrentItem() + c.this.fEV;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sE(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.sE(currentItem) - 1) {
                    c.this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.fFY.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sE(currentItem) + 1) {
                    c.this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.sD(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.sD(currentItem);
                } else {
                    c.this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.fFZ.getCurrentItem() > bu - 1) {
                    c.this.fFZ.setCurrentItem(bu - 1);
                }
                if (c.this.fGi != null) {
                    c.this.fGi.bEn();
                }
            }
        });
        a(this.fFZ);
        a(this.fGa);
        a(this.fGb);
        a(this.fGc);
        if (this.fER.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fFX.setVisibility(this.fER[0] ? 0 : 8);
        this.fFY.setVisibility(this.fER[1] ? 0 : 8);
        this.fFZ.setVisibility(this.fER[2] ? 0 : 8);
        this.fGa.setVisibility(this.fER[3] ? 0 : 8);
        this.fGb.setVisibility(this.fER[4] ? 0 : 8);
        this.fGc.setVisibility(this.fER[5] ? 0 : 8);
        bEv();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fGh = i;
        this.fFX = (WheelView) this.view.findViewById(R.id.year);
        this.fFX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fEV, this.fEW));
        this.fFX.setCurrentItem(i - this.fEV);
        this.fFX.setGravity(this.gravity);
        this.fFY = (WheelView) this.view.findViewById(R.id.month);
        if (this.fEV == this.fEW) {
            this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGd, this.fGe));
            this.fFY.setCurrentItem((i2 + 1) - this.fGd);
        } else if (i == this.fEV) {
            this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGd, 12));
            this.fFY.setCurrentItem((i2 + 1) - this.fGd);
        } else if (i == this.fEW) {
            this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fGe));
            this.fFY.setCurrentItem(i2);
        } else {
            this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fFY.setCurrentItem(i2);
        }
        this.fFY.setGravity(this.gravity);
        this.fFZ = (WheelView) this.view.findViewById(R.id.day);
        if (this.fEV == this.fEW && this.fGd == this.fGe) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fGg > 31) {
                    this.fGg = 31;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, this.fGg));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fGg > 30) {
                    this.fGg = 30;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, this.fGg));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fGg > 29) {
                    this.fGg = 29;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, this.fGg));
            } else {
                if (this.fGg > 28) {
                    this.fGg = 28;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, this.fGg));
            }
            this.fFZ.setCurrentItem(i3 - this.fGf);
        } else if (i == this.fEV && i2 + 1 == this.fGd) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, 29));
            } else {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fGf, 28));
            }
            this.fFZ.setCurrentItem(i3 - this.fGf);
        } else if (i == this.fEW && i2 + 1 == this.fGe) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fGg > 31) {
                    this.fGg = 31;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fGg));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fGg > 30) {
                    this.fGg = 30;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fGg));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fGg > 29) {
                    this.fGg = 29;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fGg));
            } else {
                if (this.fGg > 28) {
                    this.fGg = 28;
                }
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fGg));
            }
            this.fFZ.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fFZ.setCurrentItem(i3 - 1);
        }
        this.fFZ.setGravity(this.gravity);
        this.fGa = (WheelView) this.view.findViewById(R.id.hour);
        this.fGa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fGa.setCurrentItem(i4);
        this.fGa.setGravity(this.gravity);
        this.fGb = (WheelView) this.view.findViewById(R.id.min);
        this.fGb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fGb.setCurrentItem(i5);
        this.fGb.setGravity(this.gravity);
        this.fGc = (WheelView) this.view.findViewById(R.id.second);
        this.fGc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fGc.setCurrentItem(i6);
        this.fGc.setGravity(this.gravity);
        this.fFX.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fEV;
                c.this.fGh = i8;
                int currentItem = c.this.fFY.getCurrentItem();
                if (c.this.fEV == c.this.fEW) {
                    c.this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fGd, c.this.fGe));
                    if (currentItem > c.this.fFY.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fFY.getAdapter().getItemsCount() - 1;
                        c.this.fFY.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fGd + currentItem;
                    if (c.this.fGd == c.this.fGe) {
                        c.this.a(i8, i9, c.this.fGf, c.this.fGg, asList, asList2);
                    } else if (i9 == c.this.fGd) {
                        c.this.a(i8, i9, c.this.fGf, 31, asList, asList2);
                    } else if (i9 == c.this.fGe) {
                        c.this.a(i8, i9, 1, c.this.fGg, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fEV) {
                    c.this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fGd, 12));
                    if (currentItem > c.this.fFY.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fFY.getAdapter().getItemsCount() - 1;
                        c.this.fFY.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fGd + currentItem;
                    if (i10 == c.this.fGd) {
                        c.this.a(i8, i10, c.this.fGf, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fEW) {
                    c.this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fGe));
                    if (currentItem > c.this.fFY.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fFY.getAdapter().getItemsCount() - 1;
                        c.this.fFY.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fGe) {
                        c.this.a(i8, i11, 1, c.this.fGg, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fFY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fFY.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fGi != null) {
                    c.this.fGi.bEn();
                }
            }
        });
        this.fFY.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fEV == c.this.fEW) {
                    int i9 = (c.this.fGd + i8) - 1;
                    if (c.this.fGd == c.this.fGe) {
                        c.this.a(c.this.fGh, i9, c.this.fGf, c.this.fGg, asList, asList2);
                    } else if (c.this.fGd == i9) {
                        c.this.a(c.this.fGh, i9, c.this.fGf, 31, asList, asList2);
                    } else if (c.this.fGe == i9) {
                        c.this.a(c.this.fGh, i9, 1, c.this.fGg, asList, asList2);
                    } else {
                        c.this.a(c.this.fGh, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fGh == c.this.fEV) {
                    int i10 = (c.this.fGd + i8) - 1;
                    if (i10 == c.this.fGd) {
                        c.this.a(c.this.fGh, i10, c.this.fGf, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fGh, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fGh == c.this.fEW) {
                    if (i8 == c.this.fGe) {
                        c.this.a(c.this.fGh, c.this.fFY.getCurrentItem() + 1, 1, c.this.fGg, asList, asList2);
                    } else {
                        c.this.a(c.this.fGh, c.this.fFY.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fGh, i8, 1, 31, asList, asList2);
                }
                if (c.this.fGi != null) {
                    c.this.fGi.bEn();
                }
            }
        });
        a(this.fFZ);
        a(this.fGa);
        a(this.fGb);
        a(this.fGc);
        if (this.fER.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fFX.setVisibility(this.fER[0] ? 0 : 8);
        this.fFY.setVisibility(this.fER[1] ? 0 : 8);
        this.fFZ.setVisibility(this.fER[2] ? 0 : 8);
        this.fGa.setVisibility(this.fER[3] ? 0 : 8);
        this.fGb.setVisibility(this.fER[4] ? 0 : 8);
        this.fGc.setVisibility(this.fER[5] ? 0 : 8);
        bEv();
    }

    private void a(WheelView wheelView) {
        if (this.fGi != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fGi.bEn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fFZ.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fFZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fFZ.getAdapter().getItemsCount() - 1) {
            this.fFZ.setCurrentItem(this.fFZ.getAdapter().getItemsCount() - 1);
        }
    }

    private void bEv() {
        this.fFZ.setTextSize(this.textSize);
        this.fFY.setTextSize(this.textSize);
        this.fFX.setTextSize(this.textSize);
        this.fGa.setTextSize(this.textSize);
        this.fGb.setTextSize(this.textSize);
        this.fGc.setTextSize(this.textSize);
    }

    private void bEw() {
        this.fFZ.setTextColorOut(this.textColorOut);
        this.fFY.setTextColorOut(this.textColorOut);
        this.fFX.setTextColorOut(this.textColorOut);
        this.fGa.setTextColorOut(this.textColorOut);
        this.fGb.setTextColorOut(this.textColorOut);
        this.fGc.setTextColorOut(this.textColorOut);
    }

    private void bEx() {
        this.fFZ.setTextColorCenter(this.textColorCenter);
        this.fFY.setTextColorCenter(this.textColorCenter);
        this.fFX.setTextColorCenter(this.textColorCenter);
        this.fGa.setTextColorCenter(this.textColorCenter);
        this.fGb.setTextColorCenter(this.textColorCenter);
        this.fGc.setTextColorCenter(this.textColorCenter);
    }

    private void bEy() {
        this.fFZ.setDividerColor(this.dividerColor);
        this.fFY.setDividerColor(this.dividerColor);
        this.fFX.setDividerColor(this.dividerColor);
        this.fGa.setDividerColor(this.dividerColor);
        this.fGb.setDividerColor(this.dividerColor);
        this.fGc.setDividerColor(this.dividerColor);
    }

    private void bEz() {
        this.fFZ.setDividerType(this.fFB);
        this.fFY.setDividerType(this.fFB);
        this.fFX.setDividerType(this.fFB);
        this.fGa.setDividerType(this.fFB);
        this.fGb.setDividerType(this.fFB);
        this.fGc.setDividerType(this.fFB);
    }

    private void bEA() {
        this.fFZ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fFY.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fFX.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fGa.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fGb.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fGc.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void d(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fEY) {
            if (str != null) {
                this.fFX.setLabel(str);
            } else {
                this.fFX.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fFY.setLabel(str2);
            } else {
                this.fFY.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fFZ.setLabel(str3);
            } else {
                this.fFZ.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fGa.setLabel(str4);
            } else {
                this.fGa.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fGb.setLabel(str5);
            } else {
                this.fGb.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fGc.setLabel(str6);
            } else {
                this.fGc.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fFZ.setTextXOffset(i);
        this.fFY.setTextXOffset(i2);
        this.fFX.setTextXOffset(i3);
        this.fGa.setTextXOffset(i4);
        this.fGb.setTextXOffset(i5);
        this.fGc.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fFX.setCyclic(z);
        this.fFY.setCyclic(z);
        this.fFZ.setCyclic(z);
        this.fGa.setCyclic(z);
        this.fGb.setCyclic(z);
        this.fGc.setCyclic(z);
    }

    public String getTime() {
        if (this.fEY) {
            return bEB();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fGh == this.fEV) {
            if (this.fFY.getCurrentItem() + this.fGd == this.fGd) {
                sb.append(this.fFX.getCurrentItem() + this.fEV).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fFY.getCurrentItem() + this.fGd).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fFZ.getCurrentItem() + this.fGf).append(" ").append(this.fGa.getCurrentItem()).append(":").append(this.fGb.getCurrentItem()).append(":").append(this.fGc.getCurrentItem());
            } else {
                sb.append(this.fFX.getCurrentItem() + this.fEV).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fFY.getCurrentItem() + this.fGd).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fFZ.getCurrentItem() + 1).append(" ").append(this.fGa.getCurrentItem()).append(":").append(this.fGb.getCurrentItem()).append(":").append(this.fGc.getCurrentItem());
            }
        } else {
            sb.append(this.fFX.getCurrentItem() + this.fEV).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fFY.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fFZ.getCurrentItem() + 1).append(" ").append(this.fGa.getCurrentItem()).append(":").append(this.fGb.getCurrentItem()).append(":").append(this.fGc.getCurrentItem());
        }
        return sb.toString();
    }

    private String bEB() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fFX.getCurrentItem() + this.fEV;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sE(currentItem2) == 0) {
            currentItem = this.fFY.getCurrentItem() + 1;
            z = false;
        } else if ((this.fFY.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sE(currentItem2) <= 0) {
            currentItem = this.fFY.getCurrentItem() + 1;
            z = false;
        } else if ((this.fFY.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sE(currentItem2) == 1) {
            currentItem = this.fFY.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fFY.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fFZ.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fGa.getCurrentItem()).append(":").append(this.fGb.getCurrentItem()).append(":").append(this.fGc.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sJ(int i) {
        this.fEV = i;
    }

    public void sK(int i) {
        this.fEW = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fEV) {
                this.fEW = i;
                this.fGe = i2;
                this.fGg = i3;
            } else if (i == this.fEV) {
                if (i2 > this.fGd) {
                    this.fEW = i;
                    this.fGe = i2;
                    this.fGg = i3;
                } else if (i2 == this.fGd && i3 > this.fGf) {
                    this.fEW = i;
                    this.fGe = i2;
                    this.fGg = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fEW) {
                this.fGd = i5;
                this.fGf = i6;
                this.fEV = i4;
            } else if (i4 == this.fEW) {
                if (i5 < this.fGe) {
                    this.fGd = i5;
                    this.fGf = i6;
                    this.fEV = i4;
                } else if (i5 == this.fGe && i6 < this.fGg) {
                    this.fGd = i5;
                    this.fGf = i6;
                    this.fEV = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fEV = calendar.get(1);
            this.fEW = calendar2.get(1);
            this.fGd = calendar.get(2) + 1;
            this.fGe = calendar2.get(2) + 1;
            this.fGf = calendar.get(5);
            this.fGg = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bEA();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bEy();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fFB = dividerType;
        bEz();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bEx();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bEw();
    }

    public void isCenterLabel(boolean z) {
        this.fFZ.isCenterLabel(z);
        this.fFY.isCenterLabel(z);
        this.fFX.isCenterLabel(z);
        this.fGa.isCenterLabel(z);
        this.fGb.isCenterLabel(z);
        this.fGc.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fGi = bVar;
    }
}
