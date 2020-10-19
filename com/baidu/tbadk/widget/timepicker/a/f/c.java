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
    private boolean[] fww;
    private WheelView fxC;
    private WheelView fxD;
    private WheelView fxE;
    private WheelView fxF;
    private WheelView fxG;
    private WheelView fxH;
    private int fxM;
    private com.baidu.tbadk.widget.timepicker.a.d.b fxN;
    private WheelView.DividerType fxg;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fwA = FeatureCodes.SKY_SEG;
    private int fwB = 2100;
    private int fxI = 1;
    private int fxJ = 12;
    private int fxK = 1;
    private int fxL = 31;
    private boolean fwD = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fww = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void kE(boolean z) {
        this.fwD = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fwD) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fxC = (WheelView) this.view.findViewById(R.id.year);
        this.fxC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bu(this.fwA, this.fwB)));
        this.fxC.setLabel("");
        this.fxC.setCurrentItem(i - this.fwA);
        this.fxC.setGravity(this.gravity);
        this.fxD = (WheelView) this.view.findViewById(R.id.month);
        this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sw(i)));
        this.fxD.setLabel("");
        int st = com.baidu.tbadk.widget.timepicker.a.e.a.st(i);
        if (st != 0 && (i2 > st - 1 || z)) {
            this.fxD.setCurrentItem(i2 + 1);
        } else {
            this.fxD.setCurrentItem(i2);
        }
        this.fxD.setGravity(this.gravity);
        this.fxE = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.st(i) == 0) {
            this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.bt(i, i2))));
        } else {
            this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.ss(i))));
        }
        this.fxE.setLabel("");
        this.fxE.setCurrentItem(i3 - 1);
        this.fxE.setGravity(this.gravity);
        this.fxF = (WheelView) this.view.findViewById(R.id.hour);
        this.fxF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fxF.setCurrentItem(i4);
        this.fxF.setGravity(this.gravity);
        this.fxG = (WheelView) this.view.findViewById(R.id.min);
        this.fxG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fxG.setCurrentItem(i5);
        this.fxG.setGravity(this.gravity);
        this.fxH = (WheelView) this.view.findViewById(R.id.second);
        this.fxH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fxH.setCurrentItem(i5);
        this.fxH.setGravity(this.gravity);
        this.fxC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bt;
                int i8 = c.this.fwA + i7;
                c.this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sw(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.st(i8) == 0 || c.this.fxD.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.st(i8) - 1) {
                    c.this.fxD.setCurrentItem(c.this.fxD.getCurrentItem());
                } else {
                    c.this.fxD.setCurrentItem(c.this.fxD.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.st(i8) == 0 || c.this.fxD.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.st(i8) - 1) {
                    c.this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.bt(i8, c.this.fxD.getCurrentItem() + 1))));
                    bt = com.baidu.tbadk.widget.timepicker.a.e.a.bt(i8, c.this.fxD.getCurrentItem() + 1);
                } else if (c.this.fxD.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.st(i8) + 1) {
                    c.this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.ss(i8))));
                    bt = com.baidu.tbadk.widget.timepicker.a.e.a.ss(i8);
                } else {
                    c.this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.bt(i8, c.this.fxD.getCurrentItem()))));
                    bt = com.baidu.tbadk.widget.timepicker.a.e.a.bt(i8, c.this.fxD.getCurrentItem());
                }
                if (c.this.fxE.getCurrentItem() > bt - 1) {
                    c.this.fxE.setCurrentItem(bt - 1);
                }
                if (c.this.fxN != null) {
                    c.this.fxN.bCu();
                }
            }
        });
        this.fxD.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bt;
                int currentItem = c.this.fxC.getCurrentItem() + c.this.fwA;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem) - 1) {
                    c.this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.bt(currentItem, i7 + 1))));
                    bt = com.baidu.tbadk.widget.timepicker.a.e.a.bt(currentItem, i7 + 1);
                } else if (c.this.fxD.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem) + 1) {
                    c.this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.ss(currentItem))));
                    bt = com.baidu.tbadk.widget.timepicker.a.e.a.ss(currentItem);
                } else {
                    c.this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sx(com.baidu.tbadk.widget.timepicker.a.e.a.bt(currentItem, i7))));
                    bt = com.baidu.tbadk.widget.timepicker.a.e.a.bt(currentItem, i7);
                }
                if (c.this.fxE.getCurrentItem() > bt - 1) {
                    c.this.fxE.setCurrentItem(bt - 1);
                }
                if (c.this.fxN != null) {
                    c.this.fxN.bCu();
                }
            }
        });
        a(this.fxE);
        a(this.fxF);
        a(this.fxG);
        a(this.fxH);
        if (this.fww.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fxC.setVisibility(this.fww[0] ? 0 : 8);
        this.fxD.setVisibility(this.fww[1] ? 0 : 8);
        this.fxE.setVisibility(this.fww[2] ? 0 : 8);
        this.fxF.setVisibility(this.fww[3] ? 0 : 8);
        this.fxG.setVisibility(this.fww[4] ? 0 : 8);
        this.fxH.setVisibility(this.fww[5] ? 0 : 8);
        bCC();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fxM = i;
        this.fxC = (WheelView) this.view.findViewById(R.id.year);
        this.fxC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fwA, this.fwB));
        this.fxC.setCurrentItem(i - this.fwA);
        this.fxC.setGravity(this.gravity);
        this.fxD = (WheelView) this.view.findViewById(R.id.month);
        if (this.fwA == this.fwB) {
            this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxI, this.fxJ));
            this.fxD.setCurrentItem((i2 + 1) - this.fxI);
        } else if (i == this.fwA) {
            this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxI, 12));
            this.fxD.setCurrentItem((i2 + 1) - this.fxI);
        } else if (i == this.fwB) {
            this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fxJ));
            this.fxD.setCurrentItem(i2);
        } else {
            this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fxD.setCurrentItem(i2);
        }
        this.fxD.setGravity(this.gravity);
        this.fxE = (WheelView) this.view.findViewById(R.id.day);
        if (this.fwA == this.fwB && this.fxI == this.fxJ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fxL > 31) {
                    this.fxL = 31;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, this.fxL));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fxL > 30) {
                    this.fxL = 30;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, this.fxL));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fxL > 29) {
                    this.fxL = 29;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, this.fxL));
            } else {
                if (this.fxL > 28) {
                    this.fxL = 28;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, this.fxL));
            }
            this.fxE.setCurrentItem(i3 - this.fxK);
        } else if (i == this.fwA && i2 + 1 == this.fxI) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, 29));
            } else {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fxK, 28));
            }
            this.fxE.setCurrentItem(i3 - this.fxK);
        } else if (i == this.fwB && i2 + 1 == this.fxJ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fxL > 31) {
                    this.fxL = 31;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fxL));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fxL > 30) {
                    this.fxL = 30;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fxL));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fxL > 29) {
                    this.fxL = 29;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fxL));
            } else {
                if (this.fxL > 28) {
                    this.fxL = 28;
                }
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fxL));
            }
            this.fxE.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fxE.setCurrentItem(i3 - 1);
        }
        this.fxE.setGravity(this.gravity);
        this.fxF = (WheelView) this.view.findViewById(R.id.hour);
        this.fxF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fxF.setCurrentItem(i4);
        this.fxF.setGravity(this.gravity);
        this.fxG = (WheelView) this.view.findViewById(R.id.min);
        this.fxG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fxG.setCurrentItem(i5);
        this.fxG.setGravity(this.gravity);
        this.fxH = (WheelView) this.view.findViewById(R.id.second);
        this.fxH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fxH.setCurrentItem(i6);
        this.fxH.setGravity(this.gravity);
        this.fxC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fwA;
                c.this.fxM = i8;
                int currentItem = c.this.fxD.getCurrentItem();
                if (c.this.fwA == c.this.fwB) {
                    c.this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fxI, c.this.fxJ));
                    if (currentItem > c.this.fxD.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fxD.getAdapter().getItemsCount() - 1;
                        c.this.fxD.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fxI + currentItem;
                    if (c.this.fxI == c.this.fxJ) {
                        c.this.a(i8, i9, c.this.fxK, c.this.fxL, asList, asList2);
                    } else if (i9 == c.this.fxI) {
                        c.this.a(i8, i9, c.this.fxK, 31, asList, asList2);
                    } else if (i9 == c.this.fxJ) {
                        c.this.a(i8, i9, 1, c.this.fxL, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fwA) {
                    c.this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fxI, 12));
                    if (currentItem > c.this.fxD.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fxD.getAdapter().getItemsCount() - 1;
                        c.this.fxD.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fxI + currentItem;
                    if (i10 == c.this.fxI) {
                        c.this.a(i8, i10, c.this.fxK, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fwB) {
                    c.this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fxJ));
                    if (currentItem > c.this.fxD.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fxD.getAdapter().getItemsCount() - 1;
                        c.this.fxD.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fxJ) {
                        c.this.a(i8, i11, 1, c.this.fxL, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fxD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fxD.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fxN != null) {
                    c.this.fxN.bCu();
                }
            }
        });
        this.fxD.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fwA == c.this.fwB) {
                    int i9 = (c.this.fxI + i8) - 1;
                    if (c.this.fxI == c.this.fxJ) {
                        c.this.a(c.this.fxM, i9, c.this.fxK, c.this.fxL, asList, asList2);
                    } else if (c.this.fxI == i9) {
                        c.this.a(c.this.fxM, i9, c.this.fxK, 31, asList, asList2);
                    } else if (c.this.fxJ == i9) {
                        c.this.a(c.this.fxM, i9, 1, c.this.fxL, asList, asList2);
                    } else {
                        c.this.a(c.this.fxM, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fxM == c.this.fwA) {
                    int i10 = (c.this.fxI + i8) - 1;
                    if (i10 == c.this.fxI) {
                        c.this.a(c.this.fxM, i10, c.this.fxK, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fxM, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fxM == c.this.fwB) {
                    if (i8 == c.this.fxJ) {
                        c.this.a(c.this.fxM, c.this.fxD.getCurrentItem() + 1, 1, c.this.fxL, asList, asList2);
                    } else {
                        c.this.a(c.this.fxM, c.this.fxD.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fxM, i8, 1, 31, asList, asList2);
                }
                if (c.this.fxN != null) {
                    c.this.fxN.bCu();
                }
            }
        });
        a(this.fxE);
        a(this.fxF);
        a(this.fxG);
        a(this.fxH);
        if (this.fww.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fxC.setVisibility(this.fww[0] ? 0 : 8);
        this.fxD.setVisibility(this.fww[1] ? 0 : 8);
        this.fxE.setVisibility(this.fww[2] ? 0 : 8);
        this.fxF.setVisibility(this.fww[3] ? 0 : 8);
        this.fxG.setVisibility(this.fww[4] ? 0 : 8);
        this.fxH.setVisibility(this.fww[5] ? 0 : 8);
        bCC();
    }

    private void a(WheelView wheelView) {
        if (this.fxN != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fxN.bCu();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fxE.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fxE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fxE.getAdapter().getItemsCount() - 1) {
            this.fxE.setCurrentItem(this.fxE.getAdapter().getItemsCount() - 1);
        }
    }

    private void bCC() {
        this.fxE.setTextSize(this.textSize);
        this.fxD.setTextSize(this.textSize);
        this.fxC.setTextSize(this.textSize);
        this.fxF.setTextSize(this.textSize);
        this.fxG.setTextSize(this.textSize);
        this.fxH.setTextSize(this.textSize);
    }

    private void bCD() {
        this.fxE.setTextColorOut(this.textColorOut);
        this.fxD.setTextColorOut(this.textColorOut);
        this.fxC.setTextColorOut(this.textColorOut);
        this.fxF.setTextColorOut(this.textColorOut);
        this.fxG.setTextColorOut(this.textColorOut);
        this.fxH.setTextColorOut(this.textColorOut);
    }

    private void bCE() {
        this.fxE.setTextColorCenter(this.textColorCenter);
        this.fxD.setTextColorCenter(this.textColorCenter);
        this.fxC.setTextColorCenter(this.textColorCenter);
        this.fxF.setTextColorCenter(this.textColorCenter);
        this.fxG.setTextColorCenter(this.textColorCenter);
        this.fxH.setTextColorCenter(this.textColorCenter);
    }

    private void bCF() {
        this.fxE.setDividerColor(this.dividerColor);
        this.fxD.setDividerColor(this.dividerColor);
        this.fxC.setDividerColor(this.dividerColor);
        this.fxF.setDividerColor(this.dividerColor);
        this.fxG.setDividerColor(this.dividerColor);
        this.fxH.setDividerColor(this.dividerColor);
    }

    private void bCG() {
        this.fxE.setDividerType(this.fxg);
        this.fxD.setDividerType(this.fxg);
        this.fxC.setDividerType(this.fxg);
        this.fxF.setDividerType(this.fxg);
        this.fxG.setDividerType(this.fxg);
        this.fxH.setDividerType(this.fxg);
    }

    private void bCH() {
        this.fxE.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fxD.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fxC.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fxF.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fxG.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fxH.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fwD) {
            if (str != null) {
                this.fxC.setLabel(str);
            } else {
                this.fxC.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fxD.setLabel(str2);
            } else {
                this.fxD.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fxE.setLabel(str3);
            } else {
                this.fxE.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fxF.setLabel(str4);
            } else {
                this.fxF.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fxG.setLabel(str5);
            } else {
                this.fxG.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fxH.setLabel(str6);
            } else {
                this.fxH.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fxE.setTextXOffset(i);
        this.fxD.setTextXOffset(i2);
        this.fxC.setTextXOffset(i3);
        this.fxF.setTextXOffset(i4);
        this.fxG.setTextXOffset(i5);
        this.fxH.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fxC.setCyclic(z);
        this.fxD.setCyclic(z);
        this.fxE.setCyclic(z);
        this.fxF.setCyclic(z);
        this.fxG.setCyclic(z);
        this.fxH.setCyclic(z);
    }

    public String getTime() {
        if (this.fwD) {
            return bCI();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fxM == this.fwA) {
            if (this.fxD.getCurrentItem() + this.fxI == this.fxI) {
                sb.append(this.fxC.getCurrentItem() + this.fwA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fxD.getCurrentItem() + this.fxI).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fxE.getCurrentItem() + this.fxK).append(" ").append(this.fxF.getCurrentItem()).append(":").append(this.fxG.getCurrentItem()).append(":").append(this.fxH.getCurrentItem());
            } else {
                sb.append(this.fxC.getCurrentItem() + this.fwA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fxD.getCurrentItem() + this.fxI).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fxE.getCurrentItem() + 1).append(" ").append(this.fxF.getCurrentItem()).append(":").append(this.fxG.getCurrentItem()).append(":").append(this.fxH.getCurrentItem());
            }
        } else {
            sb.append(this.fxC.getCurrentItem() + this.fwA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fxD.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fxE.getCurrentItem() + 1).append(" ").append(this.fxF.getCurrentItem()).append(":").append(this.fxG.getCurrentItem()).append(":").append(this.fxH.getCurrentItem());
        }
        return sb.toString();
    }

    private String bCI() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fxC.getCurrentItem() + this.fwA;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem2) == 0) {
            currentItem = this.fxD.getCurrentItem() + 1;
            z = false;
        } else if ((this.fxD.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem2) <= 0) {
            currentItem = this.fxD.getCurrentItem() + 1;
            z = false;
        } else if ((this.fxD.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.st(currentItem2) == 1) {
            currentItem = this.fxD.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fxD.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fxE.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fxF.getCurrentItem()).append(":").append(this.fxG.getCurrentItem()).append(":").append(this.fxH.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sy(int i) {
        this.fwA = i;
    }

    public void sz(int i) {
        this.fwB = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fwA) {
                this.fwB = i;
                this.fxJ = i2;
                this.fxL = i3;
            } else if (i == this.fwA) {
                if (i2 > this.fxI) {
                    this.fwB = i;
                    this.fxJ = i2;
                    this.fxL = i3;
                } else if (i2 == this.fxI && i3 > this.fxK) {
                    this.fwB = i;
                    this.fxJ = i2;
                    this.fxL = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fwB) {
                this.fxI = i5;
                this.fxK = i6;
                this.fwA = i4;
            } else if (i4 == this.fwB) {
                if (i5 < this.fxJ) {
                    this.fxI = i5;
                    this.fxK = i6;
                    this.fwA = i4;
                } else if (i5 == this.fxJ && i6 < this.fxL) {
                    this.fxI = i5;
                    this.fxK = i6;
                    this.fwA = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fwA = calendar.get(1);
            this.fwB = calendar2.get(1);
            this.fxI = calendar.get(2) + 1;
            this.fxJ = calendar2.get(2) + 1;
            this.fxK = calendar.get(5);
            this.fxL = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bCH();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bCF();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fxg = dividerType;
        bCG();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bCE();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bCD();
    }

    public void isCenterLabel(boolean z) {
        this.fxE.isCenterLabel(z);
        this.fxD.isCenterLabel(z);
        this.fxC.isCenterLabel(z);
        this.fxF.isCenterLabel(z);
        this.fxG.isCenterLabel(z);
        this.fxH.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fxN = bVar;
    }
}
