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
/* loaded from: classes20.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private WheelView.DividerType fkS;
    private boolean[] fki;
    private WheelView flo;
    private WheelView flp;
    private WheelView flq;
    private WheelView flr;
    private WheelView fls;
    private WheelView flt;
    private int fly;
    private com.baidu.tbadk.widget.timepicker.a.d.b flz;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fkm = FeatureCodes.SKY_SEG;
    private int fkn = 2100;
    private int flu = 1;
    private int flv = 12;
    private int flw = 1;
    private int flx = 31;
    private boolean fkp = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fki = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void kg(boolean z) {
        this.fkp = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fkp) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.flo = (WheelView) this.view.findViewById(R.id.year);
        this.flo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fkm, this.fkn)));
        this.flo.setLabel("");
        this.flo.setCurrentItem(i - this.fkm);
        this.flo.setGravity(this.gravity);
        this.flp = (WheelView) this.view.findViewById(R.id.month);
        this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rY(i)));
        this.flp.setLabel("");
        int rV = com.baidu.tbadk.widget.timepicker.a.e.a.rV(i);
        if (rV != 0 && (i2 > rV - 1 || z)) {
            this.flp.setCurrentItem(i2 + 1);
        } else {
            this.flp.setCurrentItem(i2);
        }
        this.flp.setGravity(this.gravity);
        this.flq = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.rV(i) == 0) {
            this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.rU(i))));
        }
        this.flq.setLabel("");
        this.flq.setCurrentItem(i3 - 1);
        this.flq.setGravity(this.gravity);
        this.flr = (WheelView) this.view.findViewById(R.id.hour);
        this.flr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.flr.setCurrentItem(i4);
        this.flr.setGravity(this.gravity);
        this.fls = (WheelView) this.view.findViewById(R.id.min);
        this.fls.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fls.setCurrentItem(i5);
        this.fls.setGravity(this.gravity);
        this.flt = (WheelView) this.view.findViewById(R.id.second);
        this.flt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.flt.setCurrentItem(i5);
        this.flt.setGravity(this.gravity);
        this.flo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int i8 = c.this.fkm + i7;
                c.this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rY(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rV(i8) == 0 || c.this.flp.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.rV(i8) - 1) {
                    c.this.flp.setCurrentItem(c.this.flp.getCurrentItem());
                } else {
                    c.this.flp.setCurrentItem(c.this.flp.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rV(i8) == 0 || c.this.flp.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.rV(i8) - 1) {
                    c.this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.flp.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.flp.getCurrentItem() + 1);
                } else if (c.this.flp.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.rV(i8) + 1) {
                    c.this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.rU(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.rU(i8);
                } else {
                    c.this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.flp.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.flp.getCurrentItem());
                }
                if (c.this.flq.getCurrentItem() > bu - 1) {
                    c.this.flq.setCurrentItem(bu - 1);
                }
                if (c.this.flz != null) {
                    c.this.flz.bzK();
                }
            }
        });
        this.flp.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int currentItem = c.this.flo.getCurrentItem() + c.this.fkm;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.rV(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.rV(currentItem) - 1) {
                    c.this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.flp.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.rV(currentItem) + 1) {
                    c.this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.rU(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.rU(currentItem);
                } else {
                    c.this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.rZ(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.flq.getCurrentItem() > bu - 1) {
                    c.this.flq.setCurrentItem(bu - 1);
                }
                if (c.this.flz != null) {
                    c.this.flz.bzK();
                }
            }
        });
        a(this.flq);
        a(this.flr);
        a(this.fls);
        a(this.flt);
        if (this.fki.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.flo.setVisibility(this.fki[0] ? 0 : 8);
        this.flp.setVisibility(this.fki[1] ? 0 : 8);
        this.flq.setVisibility(this.fki[2] ? 0 : 8);
        this.flr.setVisibility(this.fki[3] ? 0 : 8);
        this.fls.setVisibility(this.fki[4] ? 0 : 8);
        this.flt.setVisibility(this.fki[5] ? 0 : 8);
        bzS();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fly = i;
        this.flo = (WheelView) this.view.findViewById(R.id.year);
        this.flo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fkm, this.fkn));
        this.flo.setCurrentItem(i - this.fkm);
        this.flo.setGravity(this.gravity);
        this.flp = (WheelView) this.view.findViewById(R.id.month);
        if (this.fkm == this.fkn) {
            this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flu, this.flv));
            this.flp.setCurrentItem((i2 + 1) - this.flu);
        } else if (i == this.fkm) {
            this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flu, 12));
            this.flp.setCurrentItem((i2 + 1) - this.flu);
        } else if (i == this.fkn) {
            this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.flv));
            this.flp.setCurrentItem(i2);
        } else {
            this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.flp.setCurrentItem(i2);
        }
        this.flp.setGravity(this.gravity);
        this.flq = (WheelView) this.view.findViewById(R.id.day);
        if (this.fkm == this.fkn && this.flu == this.flv) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.flx > 31) {
                    this.flx = 31;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, this.flx));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.flx > 30) {
                    this.flx = 30;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, this.flx));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.flx > 29) {
                    this.flx = 29;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, this.flx));
            } else {
                if (this.flx > 28) {
                    this.flx = 28;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, this.flx));
            }
            this.flq.setCurrentItem(i3 - this.flw);
        } else if (i == this.fkm && i2 + 1 == this.flu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, 29));
            } else {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.flw, 28));
            }
            this.flq.setCurrentItem(i3 - this.flw);
        } else if (i == this.fkn && i2 + 1 == this.flv) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.flx > 31) {
                    this.flx = 31;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.flx));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.flx > 30) {
                    this.flx = 30;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.flx));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.flx > 29) {
                    this.flx = 29;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.flx));
            } else {
                if (this.flx > 28) {
                    this.flx = 28;
                }
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.flx));
            }
            this.flq.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.flq.setCurrentItem(i3 - 1);
        }
        this.flq.setGravity(this.gravity);
        this.flr = (WheelView) this.view.findViewById(R.id.hour);
        this.flr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.flr.setCurrentItem(i4);
        this.flr.setGravity(this.gravity);
        this.fls = (WheelView) this.view.findViewById(R.id.min);
        this.fls.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fls.setCurrentItem(i5);
        this.fls.setGravity(this.gravity);
        this.flt = (WheelView) this.view.findViewById(R.id.second);
        this.flt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.flt.setCurrentItem(i6);
        this.flt.setGravity(this.gravity);
        this.flo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fkm;
                c.this.fly = i8;
                int currentItem = c.this.flp.getCurrentItem();
                if (c.this.fkm == c.this.fkn) {
                    c.this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.flu, c.this.flv));
                    if (currentItem > c.this.flp.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.flp.getAdapter().getItemsCount() - 1;
                        c.this.flp.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.flu + currentItem;
                    if (c.this.flu == c.this.flv) {
                        c.this.a(i8, i9, c.this.flw, c.this.flx, asList, asList2);
                    } else if (i9 == c.this.flu) {
                        c.this.a(i8, i9, c.this.flw, 31, asList, asList2);
                    } else if (i9 == c.this.flv) {
                        c.this.a(i8, i9, 1, c.this.flx, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fkm) {
                    c.this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.flu, 12));
                    if (currentItem > c.this.flp.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.flp.getAdapter().getItemsCount() - 1;
                        c.this.flp.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.flu + currentItem;
                    if (i10 == c.this.flu) {
                        c.this.a(i8, i10, c.this.flw, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fkn) {
                    c.this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.flv));
                    if (currentItem > c.this.flp.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.flp.getAdapter().getItemsCount() - 1;
                        c.this.flp.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.flv) {
                        c.this.a(i8, i11, 1, c.this.flx, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.flp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.flp.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.flz != null) {
                    c.this.flz.bzK();
                }
            }
        });
        this.flp.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fkm == c.this.fkn) {
                    int i9 = (c.this.flu + i8) - 1;
                    if (c.this.flu == c.this.flv) {
                        c.this.a(c.this.fly, i9, c.this.flw, c.this.flx, asList, asList2);
                    } else if (c.this.flu == i9) {
                        c.this.a(c.this.fly, i9, c.this.flw, 31, asList, asList2);
                    } else if (c.this.flv == i9) {
                        c.this.a(c.this.fly, i9, 1, c.this.flx, asList, asList2);
                    } else {
                        c.this.a(c.this.fly, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fly == c.this.fkm) {
                    int i10 = (c.this.flu + i8) - 1;
                    if (i10 == c.this.flu) {
                        c.this.a(c.this.fly, i10, c.this.flw, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fly, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fly == c.this.fkn) {
                    if (i8 == c.this.flv) {
                        c.this.a(c.this.fly, c.this.flp.getCurrentItem() + 1, 1, c.this.flx, asList, asList2);
                    } else {
                        c.this.a(c.this.fly, c.this.flp.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fly, i8, 1, 31, asList, asList2);
                }
                if (c.this.flz != null) {
                    c.this.flz.bzK();
                }
            }
        });
        a(this.flq);
        a(this.flr);
        a(this.fls);
        a(this.flt);
        if (this.fki.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.flo.setVisibility(this.fki[0] ? 0 : 8);
        this.flp.setVisibility(this.fki[1] ? 0 : 8);
        this.flq.setVisibility(this.fki[2] ? 0 : 8);
        this.flr.setVisibility(this.fki[3] ? 0 : 8);
        this.fls.setVisibility(this.fki[4] ? 0 : 8);
        this.flt.setVisibility(this.fki[5] ? 0 : 8);
        bzS();
    }

    private void a(WheelView wheelView) {
        if (this.flz != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.flz.bzK();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.flq.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.flq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.flq.getAdapter().getItemsCount() - 1) {
            this.flq.setCurrentItem(this.flq.getAdapter().getItemsCount() - 1);
        }
    }

    private void bzS() {
        this.flq.setTextSize(this.textSize);
        this.flp.setTextSize(this.textSize);
        this.flo.setTextSize(this.textSize);
        this.flr.setTextSize(this.textSize);
        this.fls.setTextSize(this.textSize);
        this.flt.setTextSize(this.textSize);
    }

    private void bzT() {
        this.flq.setTextColorOut(this.textColorOut);
        this.flp.setTextColorOut(this.textColorOut);
        this.flo.setTextColorOut(this.textColorOut);
        this.flr.setTextColorOut(this.textColorOut);
        this.fls.setTextColorOut(this.textColorOut);
        this.flt.setTextColorOut(this.textColorOut);
    }

    private void bzU() {
        this.flq.setTextColorCenter(this.textColorCenter);
        this.flp.setTextColorCenter(this.textColorCenter);
        this.flo.setTextColorCenter(this.textColorCenter);
        this.flr.setTextColorCenter(this.textColorCenter);
        this.fls.setTextColorCenter(this.textColorCenter);
        this.flt.setTextColorCenter(this.textColorCenter);
    }

    private void bzV() {
        this.flq.setDividerColor(this.dividerColor);
        this.flp.setDividerColor(this.dividerColor);
        this.flo.setDividerColor(this.dividerColor);
        this.flr.setDividerColor(this.dividerColor);
        this.fls.setDividerColor(this.dividerColor);
        this.flt.setDividerColor(this.dividerColor);
    }

    private void bzW() {
        this.flq.setDividerType(this.fkS);
        this.flp.setDividerType(this.fkS);
        this.flo.setDividerType(this.fkS);
        this.flr.setDividerType(this.fkS);
        this.fls.setDividerType(this.fkS);
        this.flt.setDividerType(this.fkS);
    }

    private void bzX() {
        this.flq.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.flp.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.flo.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.flr.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fls.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.flt.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fkp) {
            if (str != null) {
                this.flo.setLabel(str);
            } else {
                this.flo.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.flp.setLabel(str2);
            } else {
                this.flp.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.flq.setLabel(str3);
            } else {
                this.flq.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.flr.setLabel(str4);
            } else {
                this.flr.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fls.setLabel(str5);
            } else {
                this.fls.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.flt.setLabel(str6);
            } else {
                this.flt.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.flq.setTextXOffset(i);
        this.flp.setTextXOffset(i2);
        this.flo.setTextXOffset(i3);
        this.flr.setTextXOffset(i4);
        this.fls.setTextXOffset(i5);
        this.flt.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.flo.setCyclic(z);
        this.flp.setCyclic(z);
        this.flq.setCyclic(z);
        this.flr.setCyclic(z);
        this.fls.setCyclic(z);
        this.flt.setCyclic(z);
    }

    public String getTime() {
        if (this.fkp) {
            return bzY();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fly == this.fkm) {
            if (this.flp.getCurrentItem() + this.flu == this.flu) {
                sb.append(this.flo.getCurrentItem() + this.fkm).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.flp.getCurrentItem() + this.flu).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.flq.getCurrentItem() + this.flw).append(" ").append(this.flr.getCurrentItem()).append(":").append(this.fls.getCurrentItem()).append(":").append(this.flt.getCurrentItem());
            } else {
                sb.append(this.flo.getCurrentItem() + this.fkm).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.flp.getCurrentItem() + this.flu).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.flq.getCurrentItem() + 1).append(" ").append(this.flr.getCurrentItem()).append(":").append(this.fls.getCurrentItem()).append(":").append(this.flt.getCurrentItem());
            }
        } else {
            sb.append(this.flo.getCurrentItem() + this.fkm).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.flp.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.flq.getCurrentItem() + 1).append(" ").append(this.flr.getCurrentItem()).append(":").append(this.fls.getCurrentItem()).append(":").append(this.flt.getCurrentItem());
        }
        return sb.toString();
    }

    private String bzY() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.flo.getCurrentItem() + this.fkm;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.rV(currentItem2) == 0) {
            currentItem = this.flp.getCurrentItem() + 1;
            z = false;
        } else if ((this.flp.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.rV(currentItem2) <= 0) {
            currentItem = this.flp.getCurrentItem() + 1;
            z = false;
        } else if ((this.flp.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.rV(currentItem2) == 1) {
            currentItem = this.flp.getCurrentItem();
            z = true;
        } else {
            currentItem = this.flp.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.flq.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.flr.getCurrentItem()).append(":").append(this.fls.getCurrentItem()).append(":").append(this.flt.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sa(int i) {
        this.fkm = i;
    }

    public void sb(int i) {
        this.fkn = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fkm) {
                this.fkn = i;
                this.flv = i2;
                this.flx = i3;
            } else if (i == this.fkm) {
                if (i2 > this.flu) {
                    this.fkn = i;
                    this.flv = i2;
                    this.flx = i3;
                } else if (i2 == this.flu && i3 > this.flw) {
                    this.fkn = i;
                    this.flv = i2;
                    this.flx = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fkn) {
                this.flu = i5;
                this.flw = i6;
                this.fkm = i4;
            } else if (i4 == this.fkn) {
                if (i5 < this.flv) {
                    this.flu = i5;
                    this.flw = i6;
                    this.fkm = i4;
                } else if (i5 == this.flv && i6 < this.flx) {
                    this.flu = i5;
                    this.flw = i6;
                    this.fkm = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fkm = calendar.get(1);
            this.fkn = calendar2.get(1);
            this.flu = calendar.get(2) + 1;
            this.flv = calendar2.get(2) + 1;
            this.flw = calendar.get(5);
            this.flx = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bzX();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bzV();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fkS = dividerType;
        bzW();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bzU();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bzT();
    }

    public void isCenterLabel(boolean z) {
        this.flq.isCenterLabel(z);
        this.flp.isCenterLabel(z);
        this.flo.isCenterLabel(z);
        this.flr.isCenterLabel(z);
        this.fls.isCenterLabel(z);
        this.flt.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.flz = bVar;
    }
}
