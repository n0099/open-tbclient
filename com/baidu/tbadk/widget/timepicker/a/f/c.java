package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.searchbox.ugc.model.PublishType;
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
    private boolean[] fRV;
    private WheelView.DividerType fSF;
    private WheelView fTb;
    private WheelView fTc;
    private WheelView fTd;
    private WheelView fTe;
    private WheelView fTf;
    private WheelView fTg;
    private int fTl;
    private com.baidu.tbadk.widget.timepicker.a.d.b fTm;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fRZ = FeatureCodes.SKY_SEG;
    private int fSa = 2100;
    private int fTh = 1;
    private int fTi = 12;
    private int fTj = 1;
    private int fTk = 31;
    private boolean fSc = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fRV = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void lv(boolean z) {
        this.fSc = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fSc) {
            int[] D = com.baidu.tbadk.widget.timepicker.a.e.b.D(i, i2 + 1, i3);
            a(D[0], D[1] - 1, D[2], D[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fTb = (WheelView) this.view.findViewById(R.id.year);
        this.fTb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bx(this.fRZ, this.fSa)));
        this.fTb.setLabel("");
        this.fTb.setCurrentItem(i - this.fRZ);
        this.fTb.setGravity(this.gravity);
        this.fTc = (WheelView) this.view.findViewById(R.id.month);
        this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tS(i)));
        this.fTc.setLabel("");
        int tP = com.baidu.tbadk.widget.timepicker.a.e.a.tP(i);
        if (tP != 0 && (i2 > tP - 1 || z)) {
            this.fTc.setCurrentItem(i2 + 1);
        } else {
            this.fTc.setCurrentItem(i2);
        }
        this.fTc.setGravity(this.gravity);
        this.fTd = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.tP(i) == 0) {
            this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.bw(i, i2))));
        } else {
            this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.tO(i))));
        }
        this.fTd.setLabel("");
        this.fTd.setCurrentItem(i3 - 1);
        this.fTd.setGravity(this.gravity);
        this.fTe = (WheelView) this.view.findViewById(R.id.hour);
        this.fTe.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fTe.setCurrentItem(i4);
        this.fTe.setGravity(this.gravity);
        this.fTf = (WheelView) this.view.findViewById(R.id.min);
        this.fTf.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fTf.setCurrentItem(i5);
        this.fTf.setGravity(this.gravity);
        this.fTg = (WheelView) this.view.findViewById(R.id.second);
        this.fTg.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fTg.setCurrentItem(i5);
        this.fTg.setGravity(this.gravity);
        this.fTb.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bw;
                int i8 = c.this.fRZ + i7;
                c.this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tS(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.tP(i8) == 0 || c.this.fTc.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.tP(i8) - 1) {
                    c.this.fTc.setCurrentItem(c.this.fTc.getCurrentItem());
                } else {
                    c.this.fTc.setCurrentItem(c.this.fTc.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.tP(i8) == 0 || c.this.fTc.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.tP(i8) - 1) {
                    c.this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.bw(i8, c.this.fTc.getCurrentItem() + 1))));
                    bw = com.baidu.tbadk.widget.timepicker.a.e.a.bw(i8, c.this.fTc.getCurrentItem() + 1);
                } else if (c.this.fTc.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.tP(i8) + 1) {
                    c.this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.tO(i8))));
                    bw = com.baidu.tbadk.widget.timepicker.a.e.a.tO(i8);
                } else {
                    c.this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.bw(i8, c.this.fTc.getCurrentItem()))));
                    bw = com.baidu.tbadk.widget.timepicker.a.e.a.bw(i8, c.this.fTc.getCurrentItem());
                }
                if (c.this.fTd.getCurrentItem() > bw - 1) {
                    c.this.fTd.setCurrentItem(bw - 1);
                }
                if (c.this.fTm != null) {
                    c.this.fTm.bJF();
                }
            }
        });
        this.fTc.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bw;
                int currentItem = c.this.fTb.getCurrentItem() + c.this.fRZ;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.tP(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.tP(currentItem) - 1) {
                    c.this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.bw(currentItem, i7 + 1))));
                    bw = com.baidu.tbadk.widget.timepicker.a.e.a.bw(currentItem, i7 + 1);
                } else if (c.this.fTc.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.tP(currentItem) + 1) {
                    c.this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.tO(currentItem))));
                    bw = com.baidu.tbadk.widget.timepicker.a.e.a.tO(currentItem);
                } else {
                    c.this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.tT(com.baidu.tbadk.widget.timepicker.a.e.a.bw(currentItem, i7))));
                    bw = com.baidu.tbadk.widget.timepicker.a.e.a.bw(currentItem, i7);
                }
                if (c.this.fTd.getCurrentItem() > bw - 1) {
                    c.this.fTd.setCurrentItem(bw - 1);
                }
                if (c.this.fTm != null) {
                    c.this.fTm.bJF();
                }
            }
        });
        a(this.fTd);
        a(this.fTe);
        a(this.fTf);
        a(this.fTg);
        if (this.fRV.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fTb.setVisibility(this.fRV[0] ? 0 : 8);
        this.fTc.setVisibility(this.fRV[1] ? 0 : 8);
        this.fTd.setVisibility(this.fRV[2] ? 0 : 8);
        this.fTe.setVisibility(this.fRV[3] ? 0 : 8);
        this.fTf.setVisibility(this.fRV[4] ? 0 : 8);
        this.fTg.setVisibility(this.fRV[5] ? 0 : 8);
        bJN();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"4", "6", PublishType.TYPE_VIDEO_SHARE, "11"};
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList(strArr);
        this.fTl = i;
        this.fTb = (WheelView) this.view.findViewById(R.id.year);
        this.fTb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fRZ, this.fSa));
        this.fTb.setCurrentItem(i - this.fRZ);
        this.fTb.setGravity(this.gravity);
        this.fTc = (WheelView) this.view.findViewById(R.id.month);
        if (this.fRZ == this.fSa) {
            this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTh, this.fTi));
            this.fTc.setCurrentItem((i2 + 1) - this.fTh);
        } else if (i == this.fRZ) {
            this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTh, 12));
            this.fTc.setCurrentItem((i2 + 1) - this.fTh);
        } else if (i == this.fSa) {
            this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fTi));
            this.fTc.setCurrentItem(i2);
        } else {
            this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fTc.setCurrentItem(i2);
        }
        this.fTc.setGravity(this.gravity);
        this.fTd = (WheelView) this.view.findViewById(R.id.day);
        if (this.fRZ == this.fSa && this.fTh == this.fTi) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fTk > 31) {
                    this.fTk = 31;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, this.fTk));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fTk > 30) {
                    this.fTk = 30;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, this.fTk));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fTk > 29) {
                    this.fTk = 29;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, this.fTk));
            } else {
                if (this.fTk > 28) {
                    this.fTk = 28;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, this.fTk));
            }
            this.fTd.setCurrentItem(i3 - this.fTj);
        } else if (i == this.fRZ && i2 + 1 == this.fTh) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, 29));
            } else {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fTj, 28));
            }
            this.fTd.setCurrentItem(i3 - this.fTj);
        } else if (i == this.fSa && i2 + 1 == this.fTi) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fTk > 31) {
                    this.fTk = 31;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fTk));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fTk > 30) {
                    this.fTk = 30;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fTk));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fTk > 29) {
                    this.fTk = 29;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fTk));
            } else {
                if (this.fTk > 28) {
                    this.fTk = 28;
                }
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fTk));
            }
            this.fTd.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fTd.setCurrentItem(i3 - 1);
        }
        this.fTd.setGravity(this.gravity);
        this.fTe = (WheelView) this.view.findViewById(R.id.hour);
        this.fTe.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fTe.setCurrentItem(i4);
        this.fTe.setGravity(this.gravity);
        this.fTf = (WheelView) this.view.findViewById(R.id.min);
        this.fTf.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fTf.setCurrentItem(i5);
        this.fTf.setGravity(this.gravity);
        this.fTg = (WheelView) this.view.findViewById(R.id.second);
        this.fTg.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fTg.setCurrentItem(i6);
        this.fTg.setGravity(this.gravity);
        this.fTb.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fRZ;
                c.this.fTl = i8;
                int currentItem = c.this.fTc.getCurrentItem();
                if (c.this.fRZ == c.this.fSa) {
                    c.this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fTh, c.this.fTi));
                    if (currentItem > c.this.fTc.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fTc.getAdapter().getItemsCount() - 1;
                        c.this.fTc.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fTh + currentItem;
                    if (c.this.fTh == c.this.fTi) {
                        c.this.a(i8, i9, c.this.fTj, c.this.fTk, asList, asList2);
                    } else if (i9 == c.this.fTh) {
                        c.this.a(i8, i9, c.this.fTj, 31, asList, asList2);
                    } else if (i9 == c.this.fTi) {
                        c.this.a(i8, i9, 1, c.this.fTk, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fRZ) {
                    c.this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fTh, 12));
                    if (currentItem > c.this.fTc.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fTc.getAdapter().getItemsCount() - 1;
                        c.this.fTc.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fTh + currentItem;
                    if (i10 == c.this.fTh) {
                        c.this.a(i8, i10, c.this.fTj, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fSa) {
                    c.this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fTi));
                    if (currentItem > c.this.fTc.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fTc.getAdapter().getItemsCount() - 1;
                        c.this.fTc.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fTi) {
                        c.this.a(i8, i11, 1, c.this.fTk, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fTc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fTc.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fTm != null) {
                    c.this.fTm.bJF();
                }
            }
        });
        this.fTc.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fRZ == c.this.fSa) {
                    int i9 = (c.this.fTh + i8) - 1;
                    if (c.this.fTh == c.this.fTi) {
                        c.this.a(c.this.fTl, i9, c.this.fTj, c.this.fTk, asList, asList2);
                    } else if (c.this.fTh == i9) {
                        c.this.a(c.this.fTl, i9, c.this.fTj, 31, asList, asList2);
                    } else if (c.this.fTi == i9) {
                        c.this.a(c.this.fTl, i9, 1, c.this.fTk, asList, asList2);
                    } else {
                        c.this.a(c.this.fTl, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fTl == c.this.fRZ) {
                    int i10 = (c.this.fTh + i8) - 1;
                    if (i10 == c.this.fTh) {
                        c.this.a(c.this.fTl, i10, c.this.fTj, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fTl, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fTl == c.this.fSa) {
                    if (i8 == c.this.fTi) {
                        c.this.a(c.this.fTl, c.this.fTc.getCurrentItem() + 1, 1, c.this.fTk, asList, asList2);
                    } else {
                        c.this.a(c.this.fTl, c.this.fTc.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fTl, i8, 1, 31, asList, asList2);
                }
                if (c.this.fTm != null) {
                    c.this.fTm.bJF();
                }
            }
        });
        a(this.fTd);
        a(this.fTe);
        a(this.fTf);
        a(this.fTg);
        if (this.fRV.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fTb.setVisibility(this.fRV[0] ? 0 : 8);
        this.fTc.setVisibility(this.fRV[1] ? 0 : 8);
        this.fTd.setVisibility(this.fRV[2] ? 0 : 8);
        this.fTe.setVisibility(this.fRV[3] ? 0 : 8);
        this.fTf.setVisibility(this.fRV[4] ? 0 : 8);
        this.fTg.setVisibility(this.fRV[5] ? 0 : 8);
        bJN();
    }

    private void a(WheelView wheelView) {
        if (this.fTm != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fTm.bJF();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fTd.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fTd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fTd.getAdapter().getItemsCount() - 1) {
            this.fTd.setCurrentItem(this.fTd.getAdapter().getItemsCount() - 1);
        }
    }

    private void bJN() {
        this.fTd.setTextSize(this.textSize);
        this.fTc.setTextSize(this.textSize);
        this.fTb.setTextSize(this.textSize);
        this.fTe.setTextSize(this.textSize);
        this.fTf.setTextSize(this.textSize);
        this.fTg.setTextSize(this.textSize);
    }

    private void bJO() {
        this.fTd.setTextColorOut(this.textColorOut);
        this.fTc.setTextColorOut(this.textColorOut);
        this.fTb.setTextColorOut(this.textColorOut);
        this.fTe.setTextColorOut(this.textColorOut);
        this.fTf.setTextColorOut(this.textColorOut);
        this.fTg.setTextColorOut(this.textColorOut);
    }

    private void bJP() {
        this.fTd.setTextColorCenter(this.textColorCenter);
        this.fTc.setTextColorCenter(this.textColorCenter);
        this.fTb.setTextColorCenter(this.textColorCenter);
        this.fTe.setTextColorCenter(this.textColorCenter);
        this.fTf.setTextColorCenter(this.textColorCenter);
        this.fTg.setTextColorCenter(this.textColorCenter);
    }

    private void bJQ() {
        this.fTd.setDividerColor(this.dividerColor);
        this.fTc.setDividerColor(this.dividerColor);
        this.fTb.setDividerColor(this.dividerColor);
        this.fTe.setDividerColor(this.dividerColor);
        this.fTf.setDividerColor(this.dividerColor);
        this.fTg.setDividerColor(this.dividerColor);
    }

    private void bJR() {
        this.fTd.setDividerType(this.fSF);
        this.fTc.setDividerType(this.fSF);
        this.fTb.setDividerType(this.fSF);
        this.fTe.setDividerType(this.fSF);
        this.fTf.setDividerType(this.fSF);
        this.fTg.setDividerType(this.fSF);
    }

    private void bJS() {
        this.fTd.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fTc.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fTb.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fTe.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fTf.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fTg.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void d(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fSc) {
            if (str != null) {
                this.fTb.setLabel(str);
            } else {
                this.fTb.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fTc.setLabel(str2);
            } else {
                this.fTc.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fTd.setLabel(str3);
            } else {
                this.fTd.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fTe.setLabel(str4);
            } else {
                this.fTe.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fTf.setLabel(str5);
            } else {
                this.fTf.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fTg.setLabel(str6);
            } else {
                this.fTg.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fTd.setTextXOffset(i);
        this.fTc.setTextXOffset(i2);
        this.fTb.setTextXOffset(i3);
        this.fTe.setTextXOffset(i4);
        this.fTf.setTextXOffset(i5);
        this.fTg.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fTb.setCyclic(z);
        this.fTc.setCyclic(z);
        this.fTd.setCyclic(z);
        this.fTe.setCyclic(z);
        this.fTf.setCyclic(z);
        this.fTg.setCyclic(z);
    }

    public String getTime() {
        if (this.fSc) {
            return bJT();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fTl == this.fRZ) {
            if (this.fTc.getCurrentItem() + this.fTh == this.fTh) {
                sb.append(this.fTb.getCurrentItem() + this.fRZ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fTc.getCurrentItem() + this.fTh).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fTd.getCurrentItem() + this.fTj).append(" ").append(this.fTe.getCurrentItem()).append(":").append(this.fTf.getCurrentItem()).append(":").append(this.fTg.getCurrentItem());
            } else {
                sb.append(this.fTb.getCurrentItem() + this.fRZ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fTc.getCurrentItem() + this.fTh).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fTd.getCurrentItem() + 1).append(" ").append(this.fTe.getCurrentItem()).append(":").append(this.fTf.getCurrentItem()).append(":").append(this.fTg.getCurrentItem());
            }
        } else {
            sb.append(this.fTb.getCurrentItem() + this.fRZ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fTc.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fTd.getCurrentItem() + 1).append(" ").append(this.fTe.getCurrentItem()).append(":").append(this.fTf.getCurrentItem()).append(":").append(this.fTg.getCurrentItem());
        }
        return sb.toString();
    }

    private String bJT() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fTb.getCurrentItem() + this.fRZ;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.tP(currentItem2) == 0) {
            currentItem = this.fTc.getCurrentItem() + 1;
            z = false;
        } else if ((this.fTc.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.tP(currentItem2) <= 0) {
            currentItem = this.fTc.getCurrentItem() + 1;
            z = false;
        } else if ((this.fTc.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.tP(currentItem2) == 1) {
            currentItem = this.fTc.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fTc.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fTd.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fTe.getCurrentItem()).append(":").append(this.fTf.getCurrentItem()).append(":").append(this.fTg.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void tU(int i) {
        this.fRZ = i;
    }

    public void tV(int i) {
        this.fSa = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fRZ) {
                this.fSa = i;
                this.fTi = i2;
                this.fTk = i3;
            } else if (i == this.fRZ) {
                if (i2 > this.fTh) {
                    this.fSa = i;
                    this.fTi = i2;
                    this.fTk = i3;
                } else if (i2 == this.fTh && i3 > this.fTj) {
                    this.fSa = i;
                    this.fTi = i2;
                    this.fTk = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fSa) {
                this.fTh = i5;
                this.fTj = i6;
                this.fRZ = i4;
            } else if (i4 == this.fSa) {
                if (i5 < this.fTi) {
                    this.fTh = i5;
                    this.fTj = i6;
                    this.fRZ = i4;
                } else if (i5 == this.fTi && i6 < this.fTk) {
                    this.fTh = i5;
                    this.fTj = i6;
                    this.fRZ = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fRZ = calendar.get(1);
            this.fSa = calendar2.get(1);
            this.fTh = calendar.get(2) + 1;
            this.fTi = calendar2.get(2) + 1;
            this.fTj = calendar.get(5);
            this.fTk = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bJS();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bJQ();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fSF = dividerType;
        bJR();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bJP();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bJO();
    }

    public void isCenterLabel(boolean z) {
        this.fTd.isCenterLabel(z);
        this.fTc.isCenterLabel(z);
        this.fTb.isCenterLabel(z);
        this.fTe.isCenterLabel(z);
        this.fTf.isCenterLabel(z);
        this.fTg.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fTm = bVar;
    }
}
