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
    private WheelView.DividerType fKU;
    private boolean[] fKk;
    private int fLA;
    private com.baidu.tbadk.widget.timepicker.a.d.b fLB;
    private WheelView fLq;
    private WheelView fLr;
    private WheelView fLs;
    private WheelView fLt;
    private WheelView fLu;
    private WheelView fLv;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fKo = FeatureCodes.SKY_SEG;
    private int fKp = 2100;
    private int fLw = 1;
    private int fLx = 12;
    private int fLy = 1;
    private int fLz = 31;
    private boolean fKr = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fKk = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void lb(boolean z) {
        this.fKr = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fKr) {
            int[] E = com.baidu.tbadk.widget.timepicker.a.e.b.E(i, i2 + 1, i3);
            a(E[0], E[1] - 1, E[2], E[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fLq = (WheelView) this.view.findViewById(R.id.year);
        this.fLq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fKo, this.fKp)));
        this.fLq.setLabel("");
        this.fLq.setCurrentItem(i - this.fKo);
        this.fLq.setGravity(this.gravity);
        this.fLr = (WheelView) this.view.findViewById(R.id.month);
        this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tp(i)));
        this.fLr.setLabel("");
        int tm = com.baidu.tbadk.widget.timepicker.a.e.a.tm(i);
        if (tm != 0 && (i2 > tm - 1 || z)) {
            this.fLr.setCurrentItem(i2 + 1);
        } else {
            this.fLr.setCurrentItem(i2);
        }
        this.fLr.setGravity(this.gravity);
        this.fLs = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.tm(i) == 0) {
            this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.tl(i))));
        }
        this.fLs.setLabel("");
        this.fLs.setCurrentItem(i3 - 1);
        this.fLs.setGravity(this.gravity);
        this.fLt = (WheelView) this.view.findViewById(R.id.hour);
        this.fLt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fLt.setCurrentItem(i4);
        this.fLt.setGravity(this.gravity);
        this.fLu = (WheelView) this.view.findViewById(R.id.min);
        this.fLu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLu.setCurrentItem(i5);
        this.fLu.setGravity(this.gravity);
        this.fLv = (WheelView) this.view.findViewById(R.id.second);
        this.fLv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLv.setCurrentItem(i5);
        this.fLv.setGravity(this.gravity);
        this.fLq.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int i8 = c.this.fKo + i7;
                c.this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tp(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.tm(i8) == 0 || c.this.fLr.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.tm(i8) - 1) {
                    c.this.fLr.setCurrentItem(c.this.fLr.getCurrentItem());
                } else {
                    c.this.fLr.setCurrentItem(c.this.fLr.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.tm(i8) == 0 || c.this.fLr.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.tm(i8) - 1) {
                    c.this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLr.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLr.getCurrentItem() + 1);
                } else if (c.this.fLr.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.tm(i8) + 1) {
                    c.this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.tl(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.tl(i8);
                } else {
                    c.this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLr.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLr.getCurrentItem());
                }
                if (c.this.fLs.getCurrentItem() > bu - 1) {
                    c.this.fLs.setCurrentItem(bu - 1);
                }
                if (c.this.fLB != null) {
                    c.this.fLB.bGf();
                }
            }
        });
        this.fLr.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int currentItem = c.this.fLq.getCurrentItem() + c.this.fKo;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.tm(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.tm(currentItem) - 1) {
                    c.this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.fLr.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.tm(currentItem) + 1) {
                    c.this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.tl(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.tl(currentItem);
                } else {
                    c.this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tq(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.fLs.getCurrentItem() > bu - 1) {
                    c.this.fLs.setCurrentItem(bu - 1);
                }
                if (c.this.fLB != null) {
                    c.this.fLB.bGf();
                }
            }
        });
        a(this.fLs);
        a(this.fLt);
        a(this.fLu);
        a(this.fLv);
        if (this.fKk.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fLq.setVisibility(this.fKk[0] ? 0 : 8);
        this.fLr.setVisibility(this.fKk[1] ? 0 : 8);
        this.fLs.setVisibility(this.fKk[2] ? 0 : 8);
        this.fLt.setVisibility(this.fKk[3] ? 0 : 8);
        this.fLu.setVisibility(this.fKk[4] ? 0 : 8);
        this.fLv.setVisibility(this.fKk[5] ? 0 : 8);
        bGn();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fLA = i;
        this.fLq = (WheelView) this.view.findViewById(R.id.year);
        this.fLq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fKo, this.fKp));
        this.fLq.setCurrentItem(i - this.fKo);
        this.fLq.setGravity(this.gravity);
        this.fLr = (WheelView) this.view.findViewById(R.id.month);
        if (this.fKo == this.fKp) {
            this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLw, this.fLx));
            this.fLr.setCurrentItem((i2 + 1) - this.fLw);
        } else if (i == this.fKo) {
            this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLw, 12));
            this.fLr.setCurrentItem((i2 + 1) - this.fLw);
        } else if (i == this.fKp) {
            this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLx));
            this.fLr.setCurrentItem(i2);
        } else {
            this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fLr.setCurrentItem(i2);
        }
        this.fLr.setGravity(this.gravity);
        this.fLs = (WheelView) this.view.findViewById(R.id.day);
        if (this.fKo == this.fKp && this.fLw == this.fLx) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fLz > 31) {
                    this.fLz = 31;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, this.fLz));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fLz > 30) {
                    this.fLz = 30;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, this.fLz));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fLz > 29) {
                    this.fLz = 29;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, this.fLz));
            } else {
                if (this.fLz > 28) {
                    this.fLz = 28;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, this.fLz));
            }
            this.fLs.setCurrentItem(i3 - this.fLy);
        } else if (i == this.fKo && i2 + 1 == this.fLw) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, 29));
            } else {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLy, 28));
            }
            this.fLs.setCurrentItem(i3 - this.fLy);
        } else if (i == this.fKp && i2 + 1 == this.fLx) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fLz > 31) {
                    this.fLz = 31;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLz));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fLz > 30) {
                    this.fLz = 30;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLz));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fLz > 29) {
                    this.fLz = 29;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLz));
            } else {
                if (this.fLz > 28) {
                    this.fLz = 28;
                }
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLz));
            }
            this.fLs.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fLs.setCurrentItem(i3 - 1);
        }
        this.fLs.setGravity(this.gravity);
        this.fLt = (WheelView) this.view.findViewById(R.id.hour);
        this.fLt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fLt.setCurrentItem(i4);
        this.fLt.setGravity(this.gravity);
        this.fLu = (WheelView) this.view.findViewById(R.id.min);
        this.fLu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLu.setCurrentItem(i5);
        this.fLu.setGravity(this.gravity);
        this.fLv = (WheelView) this.view.findViewById(R.id.second);
        this.fLv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLv.setCurrentItem(i6);
        this.fLv.setGravity(this.gravity);
        this.fLq.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fKo;
                c.this.fLA = i8;
                int currentItem = c.this.fLr.getCurrentItem();
                if (c.this.fKo == c.this.fKp) {
                    c.this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fLw, c.this.fLx));
                    if (currentItem > c.this.fLr.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fLr.getAdapter().getItemsCount() - 1;
                        c.this.fLr.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fLw + currentItem;
                    if (c.this.fLw == c.this.fLx) {
                        c.this.a(i8, i9, c.this.fLy, c.this.fLz, asList, asList2);
                    } else if (i9 == c.this.fLw) {
                        c.this.a(i8, i9, c.this.fLy, 31, asList, asList2);
                    } else if (i9 == c.this.fLx) {
                        c.this.a(i8, i9, 1, c.this.fLz, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fKo) {
                    c.this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fLw, 12));
                    if (currentItem > c.this.fLr.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fLr.getAdapter().getItemsCount() - 1;
                        c.this.fLr.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fLw + currentItem;
                    if (i10 == c.this.fLw) {
                        c.this.a(i8, i10, c.this.fLy, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fKp) {
                    c.this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fLx));
                    if (currentItem > c.this.fLr.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fLr.getAdapter().getItemsCount() - 1;
                        c.this.fLr.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fLx) {
                        c.this.a(i8, i11, 1, c.this.fLz, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fLr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fLr.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fLB != null) {
                    c.this.fLB.bGf();
                }
            }
        });
        this.fLr.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fKo == c.this.fKp) {
                    int i9 = (c.this.fLw + i8) - 1;
                    if (c.this.fLw == c.this.fLx) {
                        c.this.a(c.this.fLA, i9, c.this.fLy, c.this.fLz, asList, asList2);
                    } else if (c.this.fLw == i9) {
                        c.this.a(c.this.fLA, i9, c.this.fLy, 31, asList, asList2);
                    } else if (c.this.fLx == i9) {
                        c.this.a(c.this.fLA, i9, 1, c.this.fLz, asList, asList2);
                    } else {
                        c.this.a(c.this.fLA, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fLA == c.this.fKo) {
                    int i10 = (c.this.fLw + i8) - 1;
                    if (i10 == c.this.fLw) {
                        c.this.a(c.this.fLA, i10, c.this.fLy, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fLA, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fLA == c.this.fKp) {
                    if (i8 == c.this.fLx) {
                        c.this.a(c.this.fLA, c.this.fLr.getCurrentItem() + 1, 1, c.this.fLz, asList, asList2);
                    } else {
                        c.this.a(c.this.fLA, c.this.fLr.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fLA, i8, 1, 31, asList, asList2);
                }
                if (c.this.fLB != null) {
                    c.this.fLB.bGf();
                }
            }
        });
        a(this.fLs);
        a(this.fLt);
        a(this.fLu);
        a(this.fLv);
        if (this.fKk.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fLq.setVisibility(this.fKk[0] ? 0 : 8);
        this.fLr.setVisibility(this.fKk[1] ? 0 : 8);
        this.fLs.setVisibility(this.fKk[2] ? 0 : 8);
        this.fLt.setVisibility(this.fKk[3] ? 0 : 8);
        this.fLu.setVisibility(this.fKk[4] ? 0 : 8);
        this.fLv.setVisibility(this.fKk[5] ? 0 : 8);
        bGn();
    }

    private void a(WheelView wheelView) {
        if (this.fLB != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fLB.bGf();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fLs.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fLs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fLs.getAdapter().getItemsCount() - 1) {
            this.fLs.setCurrentItem(this.fLs.getAdapter().getItemsCount() - 1);
        }
    }

    private void bGn() {
        this.fLs.setTextSize(this.textSize);
        this.fLr.setTextSize(this.textSize);
        this.fLq.setTextSize(this.textSize);
        this.fLt.setTextSize(this.textSize);
        this.fLu.setTextSize(this.textSize);
        this.fLv.setTextSize(this.textSize);
    }

    private void bGo() {
        this.fLs.setTextColorOut(this.textColorOut);
        this.fLr.setTextColorOut(this.textColorOut);
        this.fLq.setTextColorOut(this.textColorOut);
        this.fLt.setTextColorOut(this.textColorOut);
        this.fLu.setTextColorOut(this.textColorOut);
        this.fLv.setTextColorOut(this.textColorOut);
    }

    private void bGp() {
        this.fLs.setTextColorCenter(this.textColorCenter);
        this.fLr.setTextColorCenter(this.textColorCenter);
        this.fLq.setTextColorCenter(this.textColorCenter);
        this.fLt.setTextColorCenter(this.textColorCenter);
        this.fLu.setTextColorCenter(this.textColorCenter);
        this.fLv.setTextColorCenter(this.textColorCenter);
    }

    private void bGq() {
        this.fLs.setDividerColor(this.dividerColor);
        this.fLr.setDividerColor(this.dividerColor);
        this.fLq.setDividerColor(this.dividerColor);
        this.fLt.setDividerColor(this.dividerColor);
        this.fLu.setDividerColor(this.dividerColor);
        this.fLv.setDividerColor(this.dividerColor);
    }

    private void bGr() {
        this.fLs.setDividerType(this.fKU);
        this.fLr.setDividerType(this.fKU);
        this.fLq.setDividerType(this.fKU);
        this.fLt.setDividerType(this.fKU);
        this.fLu.setDividerType(this.fKU);
        this.fLv.setDividerType(this.fKU);
    }

    private void bGs() {
        this.fLs.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLr.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLq.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLt.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLu.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLv.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void d(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fKr) {
            if (str != null) {
                this.fLq.setLabel(str);
            } else {
                this.fLq.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fLr.setLabel(str2);
            } else {
                this.fLr.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fLs.setLabel(str3);
            } else {
                this.fLs.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fLt.setLabel(str4);
            } else {
                this.fLt.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fLu.setLabel(str5);
            } else {
                this.fLu.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fLv.setLabel(str6);
            } else {
                this.fLv.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fLs.setTextXOffset(i);
        this.fLr.setTextXOffset(i2);
        this.fLq.setTextXOffset(i3);
        this.fLt.setTextXOffset(i4);
        this.fLu.setTextXOffset(i5);
        this.fLv.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fLq.setCyclic(z);
        this.fLr.setCyclic(z);
        this.fLs.setCyclic(z);
        this.fLt.setCyclic(z);
        this.fLu.setCyclic(z);
        this.fLv.setCyclic(z);
    }

    public String getTime() {
        if (this.fKr) {
            return bGt();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fLA == this.fKo) {
            if (this.fLr.getCurrentItem() + this.fLw == this.fLw) {
                sb.append(this.fLq.getCurrentItem() + this.fKo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLr.getCurrentItem() + this.fLw).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLs.getCurrentItem() + this.fLy).append(" ").append(this.fLt.getCurrentItem()).append(":").append(this.fLu.getCurrentItem()).append(":").append(this.fLv.getCurrentItem());
            } else {
                sb.append(this.fLq.getCurrentItem() + this.fKo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLr.getCurrentItem() + this.fLw).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLs.getCurrentItem() + 1).append(" ").append(this.fLt.getCurrentItem()).append(":").append(this.fLu.getCurrentItem()).append(":").append(this.fLv.getCurrentItem());
            }
        } else {
            sb.append(this.fLq.getCurrentItem() + this.fKo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLr.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLs.getCurrentItem() + 1).append(" ").append(this.fLt.getCurrentItem()).append(":").append(this.fLu.getCurrentItem()).append(":").append(this.fLv.getCurrentItem());
        }
        return sb.toString();
    }

    private String bGt() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fLq.getCurrentItem() + this.fKo;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.tm(currentItem2) == 0) {
            currentItem = this.fLr.getCurrentItem() + 1;
            z = false;
        } else if ((this.fLr.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.tm(currentItem2) <= 0) {
            currentItem = this.fLr.getCurrentItem() + 1;
            z = false;
        } else if ((this.fLr.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.tm(currentItem2) == 1) {
            currentItem = this.fLr.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fLr.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fLs.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fLt.getCurrentItem()).append(":").append(this.fLu.getCurrentItem()).append(":").append(this.fLv.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void tr(int i) {
        this.fKo = i;
    }

    public void ts(int i) {
        this.fKp = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fKo) {
                this.fKp = i;
                this.fLx = i2;
                this.fLz = i3;
            } else if (i == this.fKo) {
                if (i2 > this.fLw) {
                    this.fKp = i;
                    this.fLx = i2;
                    this.fLz = i3;
                } else if (i2 == this.fLw && i3 > this.fLy) {
                    this.fKp = i;
                    this.fLx = i2;
                    this.fLz = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fKp) {
                this.fLw = i5;
                this.fLy = i6;
                this.fKo = i4;
            } else if (i4 == this.fKp) {
                if (i5 < this.fLx) {
                    this.fLw = i5;
                    this.fLy = i6;
                    this.fKo = i4;
                } else if (i5 == this.fLx && i6 < this.fLz) {
                    this.fLw = i5;
                    this.fLy = i6;
                    this.fKo = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fKo = calendar.get(1);
            this.fKp = calendar2.get(1);
            this.fLw = calendar.get(2) + 1;
            this.fLx = calendar2.get(2) + 1;
            this.fLy = calendar.get(5);
            this.fLz = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bGs();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bGq();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fKU = dividerType;
        bGr();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bGp();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bGo();
    }

    public void isCenterLabel(boolean z) {
        this.fLs.isCenterLabel(z);
        this.fLr.isCenterLabel(z);
        this.fLq.isCenterLabel(z);
        this.fLt.isCenterLabel(z);
        this.fLu.isCenterLabel(z);
        this.fLv.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fLB = bVar;
    }
}
