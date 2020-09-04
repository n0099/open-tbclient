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
    private WheelView.DividerType fhY;
    private boolean[] fho;
    private WheelView fiA;
    private WheelView fiB;
    private WheelView fiC;
    private int fiH;
    private com.baidu.tbadk.widget.timepicker.a.d.b fiI;
    private WheelView fiw;
    private WheelView fiy;
    private WheelView fiz;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fhs = FeatureCodes.SKY_SEG;
    private int fht = 2100;
    private int fiD = 1;
    private int fiE = 12;
    private int fiF = 1;
    private int fiG = 31;
    private boolean fhv = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fho = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void kf(boolean z) {
        this.fhv = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fhv) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fiw = (WheelView) this.view.findViewById(R.id.year);
        this.fiw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fhs, this.fht)));
        this.fiw.setLabel("");
        this.fiw.setCurrentItem(i - this.fhs);
        this.fiw.setGravity(this.gravity);
        this.fiy = (WheelView) this.view.findViewById(R.id.month);
        this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rH(i)));
        this.fiy.setLabel("");
        int rE = com.baidu.tbadk.widget.timepicker.a.e.a.rE(i);
        if (rE != 0 && (i2 > rE - 1 || z)) {
            this.fiy.setCurrentItem(i2 + 1);
        } else {
            this.fiy.setCurrentItem(i2);
        }
        this.fiy.setGravity(this.gravity);
        this.fiz = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(i) == 0) {
            this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.rD(i))));
        }
        this.fiz.setLabel("");
        this.fiz.setCurrentItem(i3 - 1);
        this.fiz.setGravity(this.gravity);
        this.fiA = (WheelView) this.view.findViewById(R.id.hour);
        this.fiA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fiA.setCurrentItem(i4);
        this.fiA.setGravity(this.gravity);
        this.fiB = (WheelView) this.view.findViewById(R.id.min);
        this.fiB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiB.setCurrentItem(i5);
        this.fiB.setGravity(this.gravity);
        this.fiC = (WheelView) this.view.findViewById(R.id.second);
        this.fiC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiC.setCurrentItem(i5);
        this.fiC.setGravity(this.gravity);
        this.fiw.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int i8 = c.this.fhs + i7;
                c.this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rH(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) == 0 || c.this.fiy.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) - 1) {
                    c.this.fiy.setCurrentItem(c.this.fiy.getCurrentItem());
                } else {
                    c.this.fiy.setCurrentItem(c.this.fiy.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) == 0 || c.this.fiy.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) - 1) {
                    c.this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fiy.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fiy.getCurrentItem() + 1);
                } else if (c.this.fiy.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.rE(i8) + 1) {
                    c.this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.rD(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.rD(i8);
                } else {
                    c.this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fiy.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fiy.getCurrentItem());
                }
                if (c.this.fiz.getCurrentItem() > bu - 1) {
                    c.this.fiz.setCurrentItem(bu - 1);
                }
                if (c.this.fiI != null) {
                    c.this.fiI.byB();
                }
            }
        });
        this.fiy.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int currentItem = c.this.fiw.getCurrentItem() + c.this.fhs;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem) - 1) {
                    c.this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.fiy.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem) + 1) {
                    c.this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.rD(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.rD(currentItem);
                } else {
                    c.this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rI(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.fiz.getCurrentItem() > bu - 1) {
                    c.this.fiz.setCurrentItem(bu - 1);
                }
                if (c.this.fiI != null) {
                    c.this.fiI.byB();
                }
            }
        });
        a(this.fiz);
        a(this.fiA);
        a(this.fiB);
        a(this.fiC);
        if (this.fho.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fiw.setVisibility(this.fho[0] ? 0 : 8);
        this.fiy.setVisibility(this.fho[1] ? 0 : 8);
        this.fiz.setVisibility(this.fho[2] ? 0 : 8);
        this.fiA.setVisibility(this.fho[3] ? 0 : 8);
        this.fiB.setVisibility(this.fho[4] ? 0 : 8);
        this.fiC.setVisibility(this.fho[5] ? 0 : 8);
        byJ();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fiH = i;
        this.fiw = (WheelView) this.view.findViewById(R.id.year);
        this.fiw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fhs, this.fht));
        this.fiw.setCurrentItem(i - this.fhs);
        this.fiw.setGravity(this.gravity);
        this.fiy = (WheelView) this.view.findViewById(R.id.month);
        if (this.fhs == this.fht) {
            this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiD, this.fiE));
            this.fiy.setCurrentItem((i2 + 1) - this.fiD);
        } else if (i == this.fhs) {
            this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiD, 12));
            this.fiy.setCurrentItem((i2 + 1) - this.fiD);
        } else if (i == this.fht) {
            this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiE));
            this.fiy.setCurrentItem(i2);
        } else {
            this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fiy.setCurrentItem(i2);
        }
        this.fiy.setGravity(this.gravity);
        this.fiz = (WheelView) this.view.findViewById(R.id.day);
        if (this.fhs == this.fht && this.fiD == this.fiE) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fiG > 31) {
                    this.fiG = 31;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, this.fiG));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fiG > 30) {
                    this.fiG = 30;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, this.fiG));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fiG > 29) {
                    this.fiG = 29;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, this.fiG));
            } else {
                if (this.fiG > 28) {
                    this.fiG = 28;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, this.fiG));
            }
            this.fiz.setCurrentItem(i3 - this.fiF);
        } else if (i == this.fhs && i2 + 1 == this.fiD) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, 29));
            } else {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fiF, 28));
            }
            this.fiz.setCurrentItem(i3 - this.fiF);
        } else if (i == this.fht && i2 + 1 == this.fiE) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fiG > 31) {
                    this.fiG = 31;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiG));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fiG > 30) {
                    this.fiG = 30;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiG));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fiG > 29) {
                    this.fiG = 29;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiG));
            } else {
                if (this.fiG > 28) {
                    this.fiG = 28;
                }
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fiG));
            }
            this.fiz.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fiz.setCurrentItem(i3 - 1);
        }
        this.fiz.setGravity(this.gravity);
        this.fiA = (WheelView) this.view.findViewById(R.id.hour);
        this.fiA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fiA.setCurrentItem(i4);
        this.fiA.setGravity(this.gravity);
        this.fiB = (WheelView) this.view.findViewById(R.id.min);
        this.fiB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiB.setCurrentItem(i5);
        this.fiB.setGravity(this.gravity);
        this.fiC = (WheelView) this.view.findViewById(R.id.second);
        this.fiC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fiC.setCurrentItem(i6);
        this.fiC.setGravity(this.gravity);
        this.fiw.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fhs;
                c.this.fiH = i8;
                int currentItem = c.this.fiy.getCurrentItem();
                if (c.this.fhs == c.this.fht) {
                    c.this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fiD, c.this.fiE));
                    if (currentItem > c.this.fiy.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fiy.getAdapter().getItemsCount() - 1;
                        c.this.fiy.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fiD + currentItem;
                    if (c.this.fiD == c.this.fiE) {
                        c.this.a(i8, i9, c.this.fiF, c.this.fiG, asList, asList2);
                    } else if (i9 == c.this.fiD) {
                        c.this.a(i8, i9, c.this.fiF, 31, asList, asList2);
                    } else if (i9 == c.this.fiE) {
                        c.this.a(i8, i9, 1, c.this.fiG, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fhs) {
                    c.this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fiD, 12));
                    if (currentItem > c.this.fiy.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fiy.getAdapter().getItemsCount() - 1;
                        c.this.fiy.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fiD + currentItem;
                    if (i10 == c.this.fiD) {
                        c.this.a(i8, i10, c.this.fiF, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fht) {
                    c.this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fiE));
                    if (currentItem > c.this.fiy.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fiy.getAdapter().getItemsCount() - 1;
                        c.this.fiy.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fiE) {
                        c.this.a(i8, i11, 1, c.this.fiG, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fiy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fiy.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fiI != null) {
                    c.this.fiI.byB();
                }
            }
        });
        this.fiy.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fhs == c.this.fht) {
                    int i9 = (c.this.fiD + i8) - 1;
                    if (c.this.fiD == c.this.fiE) {
                        c.this.a(c.this.fiH, i9, c.this.fiF, c.this.fiG, asList, asList2);
                    } else if (c.this.fiD == i9) {
                        c.this.a(c.this.fiH, i9, c.this.fiF, 31, asList, asList2);
                    } else if (c.this.fiE == i9) {
                        c.this.a(c.this.fiH, i9, 1, c.this.fiG, asList, asList2);
                    } else {
                        c.this.a(c.this.fiH, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fiH == c.this.fhs) {
                    int i10 = (c.this.fiD + i8) - 1;
                    if (i10 == c.this.fiD) {
                        c.this.a(c.this.fiH, i10, c.this.fiF, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fiH, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fiH == c.this.fht) {
                    if (i8 == c.this.fiE) {
                        c.this.a(c.this.fiH, c.this.fiy.getCurrentItem() + 1, 1, c.this.fiG, asList, asList2);
                    } else {
                        c.this.a(c.this.fiH, c.this.fiy.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fiH, i8, 1, 31, asList, asList2);
                }
                if (c.this.fiI != null) {
                    c.this.fiI.byB();
                }
            }
        });
        a(this.fiz);
        a(this.fiA);
        a(this.fiB);
        a(this.fiC);
        if (this.fho.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fiw.setVisibility(this.fho[0] ? 0 : 8);
        this.fiy.setVisibility(this.fho[1] ? 0 : 8);
        this.fiz.setVisibility(this.fho[2] ? 0 : 8);
        this.fiA.setVisibility(this.fho[3] ? 0 : 8);
        this.fiB.setVisibility(this.fho[4] ? 0 : 8);
        this.fiC.setVisibility(this.fho[5] ? 0 : 8);
        byJ();
    }

    private void a(WheelView wheelView) {
        if (this.fiI != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fiI.byB();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fiz.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fiz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fiz.getAdapter().getItemsCount() - 1) {
            this.fiz.setCurrentItem(this.fiz.getAdapter().getItemsCount() - 1);
        }
    }

    private void byJ() {
        this.fiz.setTextSize(this.textSize);
        this.fiy.setTextSize(this.textSize);
        this.fiw.setTextSize(this.textSize);
        this.fiA.setTextSize(this.textSize);
        this.fiB.setTextSize(this.textSize);
        this.fiC.setTextSize(this.textSize);
    }

    private void byK() {
        this.fiz.setTextColorOut(this.textColorOut);
        this.fiy.setTextColorOut(this.textColorOut);
        this.fiw.setTextColorOut(this.textColorOut);
        this.fiA.setTextColorOut(this.textColorOut);
        this.fiB.setTextColorOut(this.textColorOut);
        this.fiC.setTextColorOut(this.textColorOut);
    }

    private void byL() {
        this.fiz.setTextColorCenter(this.textColorCenter);
        this.fiy.setTextColorCenter(this.textColorCenter);
        this.fiw.setTextColorCenter(this.textColorCenter);
        this.fiA.setTextColorCenter(this.textColorCenter);
        this.fiB.setTextColorCenter(this.textColorCenter);
        this.fiC.setTextColorCenter(this.textColorCenter);
    }

    private void byM() {
        this.fiz.setDividerColor(this.dividerColor);
        this.fiy.setDividerColor(this.dividerColor);
        this.fiw.setDividerColor(this.dividerColor);
        this.fiA.setDividerColor(this.dividerColor);
        this.fiB.setDividerColor(this.dividerColor);
        this.fiC.setDividerColor(this.dividerColor);
    }

    private void byN() {
        this.fiz.setDividerType(this.fhY);
        this.fiy.setDividerType(this.fhY);
        this.fiw.setDividerType(this.fhY);
        this.fiA.setDividerType(this.fhY);
        this.fiB.setDividerType(this.fhY);
        this.fiC.setDividerType(this.fhY);
    }

    private void byO() {
        this.fiz.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiy.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiw.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiA.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiB.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fiC.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fhv) {
            if (str != null) {
                this.fiw.setLabel(str);
            } else {
                this.fiw.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fiy.setLabel(str2);
            } else {
                this.fiy.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fiz.setLabel(str3);
            } else {
                this.fiz.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fiA.setLabel(str4);
            } else {
                this.fiA.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fiB.setLabel(str5);
            } else {
                this.fiB.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fiC.setLabel(str6);
            } else {
                this.fiC.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fiz.setTextXOffset(i);
        this.fiy.setTextXOffset(i2);
        this.fiw.setTextXOffset(i3);
        this.fiA.setTextXOffset(i4);
        this.fiB.setTextXOffset(i5);
        this.fiC.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fiw.setCyclic(z);
        this.fiy.setCyclic(z);
        this.fiz.setCyclic(z);
        this.fiA.setCyclic(z);
        this.fiB.setCyclic(z);
        this.fiC.setCyclic(z);
    }

    public String getTime() {
        if (this.fhv) {
            return byP();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fiH == this.fhs) {
            if (this.fiy.getCurrentItem() + this.fiD == this.fiD) {
                sb.append(this.fiw.getCurrentItem() + this.fhs).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiy.getCurrentItem() + this.fiD).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiz.getCurrentItem() + this.fiF).append(" ").append(this.fiA.getCurrentItem()).append(":").append(this.fiB.getCurrentItem()).append(":").append(this.fiC.getCurrentItem());
            } else {
                sb.append(this.fiw.getCurrentItem() + this.fhs).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiy.getCurrentItem() + this.fiD).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiz.getCurrentItem() + 1).append(" ").append(this.fiA.getCurrentItem()).append(":").append(this.fiB.getCurrentItem()).append(":").append(this.fiC.getCurrentItem());
            }
        } else {
            sb.append(this.fiw.getCurrentItem() + this.fhs).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiy.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fiz.getCurrentItem() + 1).append(" ").append(this.fiA.getCurrentItem()).append(":").append(this.fiB.getCurrentItem()).append(":").append(this.fiC.getCurrentItem());
        }
        return sb.toString();
    }

    private String byP() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fiw.getCurrentItem() + this.fhs;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem2) == 0) {
            currentItem = this.fiy.getCurrentItem() + 1;
            z = false;
        } else if ((this.fiy.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem2) <= 0) {
            currentItem = this.fiy.getCurrentItem() + 1;
            z = false;
        } else if ((this.fiy.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.rE(currentItem2) == 1) {
            currentItem = this.fiy.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fiy.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fiz.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fiA.getCurrentItem()).append(":").append(this.fiB.getCurrentItem()).append(":").append(this.fiC.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void rJ(int i) {
        this.fhs = i;
    }

    public void rK(int i) {
        this.fht = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fhs) {
                this.fht = i;
                this.fiE = i2;
                this.fiG = i3;
            } else if (i == this.fhs) {
                if (i2 > this.fiD) {
                    this.fht = i;
                    this.fiE = i2;
                    this.fiG = i3;
                } else if (i2 == this.fiD && i3 > this.fiF) {
                    this.fht = i;
                    this.fiE = i2;
                    this.fiG = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fht) {
                this.fiD = i5;
                this.fiF = i6;
                this.fhs = i4;
            } else if (i4 == this.fht) {
                if (i5 < this.fiE) {
                    this.fiD = i5;
                    this.fiF = i6;
                    this.fhs = i4;
                } else if (i5 == this.fiE && i6 < this.fiG) {
                    this.fiD = i5;
                    this.fiF = i6;
                    this.fhs = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fhs = calendar.get(1);
            this.fht = calendar2.get(1);
            this.fiD = calendar.get(2) + 1;
            this.fiE = calendar2.get(2) + 1;
            this.fiF = calendar.get(5);
            this.fiG = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        byO();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        byM();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fhY = dividerType;
        byN();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        byL();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        byK();
    }

    public void isCenterLabel(boolean z) {
        this.fiz.isCenterLabel(z);
        this.fiy.isCenterLabel(z);
        this.fiw.isCenterLabel(z);
        this.fiA.isCenterLabel(z);
        this.fiB.isCenterLabel(z);
        this.fiC.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fiI = bVar;
    }
}
