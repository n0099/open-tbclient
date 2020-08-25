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
/* loaded from: classes15.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private WheelView.DividerType fhU;
    private boolean[] fhk;
    private int fiD;
    private com.baidu.tbadk.widget.timepicker.a.d.b fiE;
    private WheelView fis;
    private WheelView fit;
    private WheelView fiu;
    private WheelView fiv;
    private WheelView fiw;
    private WheelView fiy;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fho = FeatureCodes.SKY_SEG;
    private int fhp = 2100;
    private int fiz = 1;
    private int fiA = 12;
    private int fiB = 1;
    private int fiC = 31;
    private boolean fhr = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fhk = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void kd(boolean z) {
        this.fhr = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fhr) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fis = (WheelView) this.view.findViewById(R.id.year);
        this.fis.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fho, this.fhp)));
        this.fis.setLabel("");
        this.fis.setCurrentItem(i - this.fho);
        this.fis.setGravity(this.gravity);
        this.fit = (WheelView) this.view.findViewById(R.id.month);
        this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rH(i)));
        this.fit.setLabel("");
        int rE = com.baidu.tbadk.widget.timepicker.a.e.a.rE(i);
        if (rE != 0 && (i2 > rE - 1 || z)) {
            this.fit.setCurrentItem(i2 + 1);
        } else {
            this.fit.setCurrentItem(i2);
        }
        this.fit.setGravity(this.gravity);
        this.fiu = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(i) == 0) {
            this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.rD(i))));
        }
        this.fiu.setLabel("");
        this.fiu.setCurrentItem(i3 - 1);
        this.fiu.setGravity(this.gravity);
        this.fiv = (WheelView) this.view.findViewById(R.id.hour);
        this.fiv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fiv.setCurrentItem(i4);
        this.fiv.setGravity(this.gravity);
        this.fiw = (WheelView) this.view.findViewById(R.id.min);
        this.fiw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiw.setCurrentItem(i5);
        this.fiw.setGravity(this.gravity);
        this.fiy = (WheelView) this.view.findViewById(R.id.second);
        this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiy.setCurrentItem(i5);
        this.fiy.setGravity(this.gravity);
        this.fis.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int i8 = c.this.fho + i7;
                c.this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rH(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) == 0 || c.this.fit.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) - 1) {
                    c.this.fit.setCurrentItem(c.this.fit.getCurrentItem());
                } else {
                    c.this.fit.setCurrentItem(c.this.fit.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) == 0 || c.this.fit.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) - 1) {
                    c.this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fit.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fit.getCurrentItem() + 1);
                } else if (c.this.fit.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) + 1) {
                    c.this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.rD(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.rD(i8);
                } else {
                    c.this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fit.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fit.getCurrentItem());
                }
                if (c.this.fiu.getCurrentItem() > bu - 1) {
                    c.this.fiu.setCurrentItem(bu - 1);
                }
                if (c.this.fiE != null) {
                    c.this.fiE.byA();
                }
            }
        });
        this.fit.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int currentItem = c.this.fis.getCurrentItem() + c.this.fho;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem) - 1) {
                    c.this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.fit.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem) + 1) {
                    c.this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.rD(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.rD(currentItem);
                } else {
                    c.this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.fiu.getCurrentItem() > bu - 1) {
                    c.this.fiu.setCurrentItem(bu - 1);
                }
                if (c.this.fiE != null) {
                    c.this.fiE.byA();
                }
            }
        });
        a(this.fiu);
        a(this.fiv);
        a(this.fiw);
        a(this.fiy);
        if (this.fhk.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fis.setVisibility(this.fhk[0] ? 0 : 8);
        this.fit.setVisibility(this.fhk[1] ? 0 : 8);
        this.fiu.setVisibility(this.fhk[2] ? 0 : 8);
        this.fiv.setVisibility(this.fhk[3] ? 0 : 8);
        this.fiw.setVisibility(this.fhk[4] ? 0 : 8);
        this.fiy.setVisibility(this.fhk[5] ? 0 : 8);
        byI();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fiD = i;
        this.fis = (WheelView) this.view.findViewById(R.id.year);
        this.fis.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fho, this.fhp));
        this.fis.setCurrentItem(i - this.fho);
        this.fis.setGravity(this.gravity);
        this.fit = (WheelView) this.view.findViewById(R.id.month);
        if (this.fho == this.fhp) {
            this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiz, this.fiA));
            this.fit.setCurrentItem((i2 + 1) - this.fiz);
        } else if (i == this.fho) {
            this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiz, 12));
            this.fit.setCurrentItem((i2 + 1) - this.fiz);
        } else if (i == this.fhp) {
            this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiA));
            this.fit.setCurrentItem(i2);
        } else {
            this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fit.setCurrentItem(i2);
        }
        this.fit.setGravity(this.gravity);
        this.fiu = (WheelView) this.view.findViewById(R.id.day);
        if (this.fho == this.fhp && this.fiz == this.fiA) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fiC > 31) {
                    this.fiC = 31;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, this.fiC));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fiC > 30) {
                    this.fiC = 30;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, this.fiC));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fiC > 29) {
                    this.fiC = 29;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, this.fiC));
            } else {
                if (this.fiC > 28) {
                    this.fiC = 28;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, this.fiC));
            }
            this.fiu.setCurrentItem(i3 - this.fiB);
        } else if (i == this.fho && i2 + 1 == this.fiz) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, 29));
            } else {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiB, 28));
            }
            this.fiu.setCurrentItem(i3 - this.fiB);
        } else if (i == this.fhp && i2 + 1 == this.fiA) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fiC > 31) {
                    this.fiC = 31;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiC));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fiC > 30) {
                    this.fiC = 30;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiC));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fiC > 29) {
                    this.fiC = 29;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiC));
            } else {
                if (this.fiC > 28) {
                    this.fiC = 28;
                }
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiC));
            }
            this.fiu.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fiu.setCurrentItem(i3 - 1);
        }
        this.fiu.setGravity(this.gravity);
        this.fiv = (WheelView) this.view.findViewById(R.id.hour);
        this.fiv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fiv.setCurrentItem(i4);
        this.fiv.setGravity(this.gravity);
        this.fiw = (WheelView) this.view.findViewById(R.id.min);
        this.fiw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiw.setCurrentItem(i5);
        this.fiw.setGravity(this.gravity);
        this.fiy = (WheelView) this.view.findViewById(R.id.second);
        this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiy.setCurrentItem(i6);
        this.fiy.setGravity(this.gravity);
        this.fis.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fho;
                c.this.fiD = i8;
                int currentItem = c.this.fit.getCurrentItem();
                if (c.this.fho == c.this.fhp) {
                    c.this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fiz, c.this.fiA));
                    if (currentItem > c.this.fit.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fit.getAdapter().getItemsCount() - 1;
                        c.this.fit.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fiz + currentItem;
                    if (c.this.fiz == c.this.fiA) {
                        c.this.a(i8, i9, c.this.fiB, c.this.fiC, asList, asList2);
                    } else if (i9 == c.this.fiz) {
                        c.this.a(i8, i9, c.this.fiB, 31, asList, asList2);
                    } else if (i9 == c.this.fiA) {
                        c.this.a(i8, i9, 1, c.this.fiC, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fho) {
                    c.this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fiz, 12));
                    if (currentItem > c.this.fit.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fit.getAdapter().getItemsCount() - 1;
                        c.this.fit.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fiz + currentItem;
                    if (i10 == c.this.fiz) {
                        c.this.a(i8, i10, c.this.fiB, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fhp) {
                    c.this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fiA));
                    if (currentItem > c.this.fit.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fit.getAdapter().getItemsCount() - 1;
                        c.this.fit.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fiA) {
                        c.this.a(i8, i11, 1, c.this.fiC, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fit.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fit.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fiE != null) {
                    c.this.fiE.byA();
                }
            }
        });
        this.fit.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fho == c.this.fhp) {
                    int i9 = (c.this.fiz + i8) - 1;
                    if (c.this.fiz == c.this.fiA) {
                        c.this.a(c.this.fiD, i9, c.this.fiB, c.this.fiC, asList, asList2);
                    } else if (c.this.fiz == i9) {
                        c.this.a(c.this.fiD, i9, c.this.fiB, 31, asList, asList2);
                    } else if (c.this.fiA == i9) {
                        c.this.a(c.this.fiD, i9, 1, c.this.fiC, asList, asList2);
                    } else {
                        c.this.a(c.this.fiD, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fiD == c.this.fho) {
                    int i10 = (c.this.fiz + i8) - 1;
                    if (i10 == c.this.fiz) {
                        c.this.a(c.this.fiD, i10, c.this.fiB, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fiD, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fiD == c.this.fhp) {
                    if (i8 == c.this.fiA) {
                        c.this.a(c.this.fiD, c.this.fit.getCurrentItem() + 1, 1, c.this.fiC, asList, asList2);
                    } else {
                        c.this.a(c.this.fiD, c.this.fit.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fiD, i8, 1, 31, asList, asList2);
                }
                if (c.this.fiE != null) {
                    c.this.fiE.byA();
                }
            }
        });
        a(this.fiu);
        a(this.fiv);
        a(this.fiw);
        a(this.fiy);
        if (this.fhk.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fis.setVisibility(this.fhk[0] ? 0 : 8);
        this.fit.setVisibility(this.fhk[1] ? 0 : 8);
        this.fiu.setVisibility(this.fhk[2] ? 0 : 8);
        this.fiv.setVisibility(this.fhk[3] ? 0 : 8);
        this.fiw.setVisibility(this.fhk[4] ? 0 : 8);
        this.fiy.setVisibility(this.fhk[5] ? 0 : 8);
        byI();
    }

    private void a(WheelView wheelView) {
        if (this.fiE != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fiE.byA();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fiu.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fiu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fiu.getAdapter().getItemsCount() - 1) {
            this.fiu.setCurrentItem(this.fiu.getAdapter().getItemsCount() - 1);
        }
    }

    private void byI() {
        this.fiu.setTextSize(this.textSize);
        this.fit.setTextSize(this.textSize);
        this.fis.setTextSize(this.textSize);
        this.fiv.setTextSize(this.textSize);
        this.fiw.setTextSize(this.textSize);
        this.fiy.setTextSize(this.textSize);
    }

    private void byJ() {
        this.fiu.setTextColorOut(this.textColorOut);
        this.fit.setTextColorOut(this.textColorOut);
        this.fis.setTextColorOut(this.textColorOut);
        this.fiv.setTextColorOut(this.textColorOut);
        this.fiw.setTextColorOut(this.textColorOut);
        this.fiy.setTextColorOut(this.textColorOut);
    }

    private void byK() {
        this.fiu.setTextColorCenter(this.textColorCenter);
        this.fit.setTextColorCenter(this.textColorCenter);
        this.fis.setTextColorCenter(this.textColorCenter);
        this.fiv.setTextColorCenter(this.textColorCenter);
        this.fiw.setTextColorCenter(this.textColorCenter);
        this.fiy.setTextColorCenter(this.textColorCenter);
    }

    private void byL() {
        this.fiu.setDividerColor(this.dividerColor);
        this.fit.setDividerColor(this.dividerColor);
        this.fis.setDividerColor(this.dividerColor);
        this.fiv.setDividerColor(this.dividerColor);
        this.fiw.setDividerColor(this.dividerColor);
        this.fiy.setDividerColor(this.dividerColor);
    }

    private void byM() {
        this.fiu.setDividerType(this.fhU);
        this.fit.setDividerType(this.fhU);
        this.fis.setDividerType(this.fhU);
        this.fiv.setDividerType(this.fhU);
        this.fiw.setDividerType(this.fhU);
        this.fiy.setDividerType(this.fhU);
    }

    private void byN() {
        this.fiu.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fit.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fis.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiv.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiw.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiy.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fhr) {
            if (str != null) {
                this.fis.setLabel(str);
            } else {
                this.fis.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fit.setLabel(str2);
            } else {
                this.fit.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fiu.setLabel(str3);
            } else {
                this.fiu.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fiv.setLabel(str4);
            } else {
                this.fiv.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fiw.setLabel(str5);
            } else {
                this.fiw.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fiy.setLabel(str6);
            } else {
                this.fiy.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fiu.setTextXOffset(i);
        this.fit.setTextXOffset(i2);
        this.fis.setTextXOffset(i3);
        this.fiv.setTextXOffset(i4);
        this.fiw.setTextXOffset(i5);
        this.fiy.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fis.setCyclic(z);
        this.fit.setCyclic(z);
        this.fiu.setCyclic(z);
        this.fiv.setCyclic(z);
        this.fiw.setCyclic(z);
        this.fiy.setCyclic(z);
    }

    public String getTime() {
        if (this.fhr) {
            return byO();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fiD == this.fho) {
            if (this.fit.getCurrentItem() + this.fiz == this.fiz) {
                sb.append(this.fis.getCurrentItem() + this.fho).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fit.getCurrentItem() + this.fiz).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiu.getCurrentItem() + this.fiB).append(" ").append(this.fiv.getCurrentItem()).append(":").append(this.fiw.getCurrentItem()).append(":").append(this.fiy.getCurrentItem());
            } else {
                sb.append(this.fis.getCurrentItem() + this.fho).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fit.getCurrentItem() + this.fiz).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiu.getCurrentItem() + 1).append(" ").append(this.fiv.getCurrentItem()).append(":").append(this.fiw.getCurrentItem()).append(":").append(this.fiy.getCurrentItem());
            }
        } else {
            sb.append(this.fis.getCurrentItem() + this.fho).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fit.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiu.getCurrentItem() + 1).append(" ").append(this.fiv.getCurrentItem()).append(":").append(this.fiw.getCurrentItem()).append(":").append(this.fiy.getCurrentItem());
        }
        return sb.toString();
    }

    private String byO() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fis.getCurrentItem() + this.fho;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem2) == 0) {
            currentItem = this.fit.getCurrentItem() + 1;
            z = false;
        } else if ((this.fit.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem2) <= 0) {
            currentItem = this.fit.getCurrentItem() + 1;
            z = false;
        } else if ((this.fit.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem2) == 1) {
            currentItem = this.fit.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fit.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fiu.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fiv.getCurrentItem()).append(":").append(this.fiw.getCurrentItem()).append(":").append(this.fiy.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void rJ(int i) {
        this.fho = i;
    }

    public void rK(int i) {
        this.fhp = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fho) {
                this.fhp = i;
                this.fiA = i2;
                this.fiC = i3;
            } else if (i == this.fho) {
                if (i2 > this.fiz) {
                    this.fhp = i;
                    this.fiA = i2;
                    this.fiC = i3;
                } else if (i2 == this.fiz && i3 > this.fiB) {
                    this.fhp = i;
                    this.fiA = i2;
                    this.fiC = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fhp) {
                this.fiz = i5;
                this.fiB = i6;
                this.fho = i4;
            } else if (i4 == this.fhp) {
                if (i5 < this.fiA) {
                    this.fiz = i5;
                    this.fiB = i6;
                    this.fho = i4;
                } else if (i5 == this.fiA && i6 < this.fiC) {
                    this.fiz = i5;
                    this.fiB = i6;
                    this.fho = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fho = calendar.get(1);
            this.fhp = calendar2.get(1);
            this.fiz = calendar.get(2) + 1;
            this.fiA = calendar2.get(2) + 1;
            this.fiB = calendar.get(5);
            this.fiC = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        byN();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        byL();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fhU = dividerType;
        byM();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        byK();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        byJ();
    }

    public void isCenterLabel(boolean z) {
        this.fiu.isCenterLabel(z);
        this.fit.isCenterLabel(z);
        this.fis.isCenterLabel(z);
        this.fiv.isCenterLabel(z);
        this.fiw.isCenterLabel(z);
        this.fiy.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fiE = bVar;
    }
}
