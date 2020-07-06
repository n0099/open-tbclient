package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private WheelView.DividerType eQR;
    private boolean[] eQh;
    private WheelView eRn;
    private WheelView eRo;
    private WheelView eRp;
    private WheelView eRq;
    private WheelView eRr;
    private WheelView eRs;
    private int eRx;
    private com.baidu.tbadk.widget.timepicker.a.d.b eRy;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int eQl = FeatureCodes.SKY_SEG;
    private int eQm = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int eRt = 1;
    private int eRu = 12;
    private int eRv = 1;
    private int eRw = 31;
    private boolean eQo = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.eQh = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void ja(boolean z) {
        this.eQo = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.eQo) {
            int[] C = com.baidu.tbadk.widget.timepicker.a.e.b.C(i, i2 + 1, i3);
            a(C[0], C[1] - 1, C[2], C[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.eRn = (WheelView) this.view.findViewById(R.id.year);
        this.eRn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bj(this.eQl, this.eQm)));
        this.eRn.setLabel("");
        this.eRn.setCurrentItem(i - this.eQl);
        this.eRn.setGravity(this.gravity);
        this.eRo = (WheelView) this.view.findViewById(R.id.month);
        this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pe(i)));
        this.eRo.setLabel("");
        int pb = com.baidu.tbadk.widget.timepicker.a.e.a.pb(i);
        if (pb != 0 && (i2 > pb - 1 || z)) {
            this.eRo.setCurrentItem(i2 + 1);
        } else {
            this.eRo.setCurrentItem(i2);
        }
        this.eRo.setGravity(this.gravity);
        this.eRp = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.pb(i) == 0) {
            this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.bi(i, i2))));
        } else {
            this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.pa(i))));
        }
        this.eRp.setLabel("");
        this.eRp.setCurrentItem(i3 - 1);
        this.eRp.setGravity(this.gravity);
        this.eRq = (WheelView) this.view.findViewById(R.id.hour);
        this.eRq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eRq.setCurrentItem(i4);
        this.eRq.setGravity(this.gravity);
        this.eRr = (WheelView) this.view.findViewById(R.id.min);
        this.eRr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eRr.setCurrentItem(i5);
        this.eRr.setGravity(this.gravity);
        this.eRs = (WheelView) this.view.findViewById(R.id.second);
        this.eRs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eRs.setCurrentItem(i5);
        this.eRs.setGravity(this.gravity);
        this.eRn.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bi;
                int i8 = c.this.eQl + i7;
                c.this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pe(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.pb(i8) == 0 || c.this.eRo.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.pb(i8) - 1) {
                    c.this.eRo.setCurrentItem(c.this.eRo.getCurrentItem());
                } else {
                    c.this.eRo.setCurrentItem(c.this.eRo.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.pb(i8) == 0 || c.this.eRo.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.pb(i8) - 1) {
                    c.this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.bi(i8, c.this.eRo.getCurrentItem() + 1))));
                    bi = com.baidu.tbadk.widget.timepicker.a.e.a.bi(i8, c.this.eRo.getCurrentItem() + 1);
                } else if (c.this.eRo.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.pb(i8) + 1) {
                    c.this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.pa(i8))));
                    bi = com.baidu.tbadk.widget.timepicker.a.e.a.pa(i8);
                } else {
                    c.this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.bi(i8, c.this.eRo.getCurrentItem()))));
                    bi = com.baidu.tbadk.widget.timepicker.a.e.a.bi(i8, c.this.eRo.getCurrentItem());
                }
                if (c.this.eRp.getCurrentItem() > bi - 1) {
                    c.this.eRp.setCurrentItem(bi - 1);
                }
                if (c.this.eRy != null) {
                    c.this.eRy.blS();
                }
            }
        });
        this.eRo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bi;
                int currentItem = c.this.eRn.getCurrentItem() + c.this.eQl;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.pb(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.pb(currentItem) - 1) {
                    c.this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.bi(currentItem, i7 + 1))));
                    bi = com.baidu.tbadk.widget.timepicker.a.e.a.bi(currentItem, i7 + 1);
                } else if (c.this.eRo.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.pb(currentItem) + 1) {
                    c.this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.pa(currentItem))));
                    bi = com.baidu.tbadk.widget.timepicker.a.e.a.pa(currentItem);
                } else {
                    c.this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pf(com.baidu.tbadk.widget.timepicker.a.e.a.bi(currentItem, i7))));
                    bi = com.baidu.tbadk.widget.timepicker.a.e.a.bi(currentItem, i7);
                }
                if (c.this.eRp.getCurrentItem() > bi - 1) {
                    c.this.eRp.setCurrentItem(bi - 1);
                }
                if (c.this.eRy != null) {
                    c.this.eRy.blS();
                }
            }
        });
        a(this.eRp);
        a(this.eRq);
        a(this.eRr);
        a(this.eRs);
        if (this.eQh.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.eRn.setVisibility(this.eQh[0] ? 0 : 8);
        this.eRo.setVisibility(this.eQh[1] ? 0 : 8);
        this.eRp.setVisibility(this.eQh[2] ? 0 : 8);
        this.eRq.setVisibility(this.eQh[3] ? 0 : 8);
        this.eRr.setVisibility(this.eQh[4] ? 0 : 8);
        this.eRs.setVisibility(this.eQh[5] ? 0 : 8);
        bma();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.eRx = i;
        this.eRn = (WheelView) this.view.findViewById(R.id.year);
        this.eRn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eQl, this.eQm));
        this.eRn.setCurrentItem(i - this.eQl);
        this.eRn.setGravity(this.gravity);
        this.eRo = (WheelView) this.view.findViewById(R.id.month);
        if (this.eQl == this.eQm) {
            this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRt, this.eRu));
            this.eRo.setCurrentItem((i2 + 1) - this.eRt);
        } else if (i == this.eQl) {
            this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRt, 12));
            this.eRo.setCurrentItem((i2 + 1) - this.eRt);
        } else if (i == this.eQm) {
            this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eRu));
            this.eRo.setCurrentItem(i2);
        } else {
            this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.eRo.setCurrentItem(i2);
        }
        this.eRo.setGravity(this.gravity);
        this.eRp = (WheelView) this.view.findViewById(R.id.day);
        if (this.eQl == this.eQm && this.eRt == this.eRu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eRw > 31) {
                    this.eRw = 31;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, this.eRw));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eRw > 30) {
                    this.eRw = 30;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, this.eRw));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eRw > 29) {
                    this.eRw = 29;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, this.eRw));
            } else {
                if (this.eRw > 28) {
                    this.eRw = 28;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, this.eRw));
            }
            this.eRp.setCurrentItem(i3 - this.eRv);
        } else if (i == this.eQl && i2 + 1 == this.eRt) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, 29));
            } else {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eRv, 28));
            }
            this.eRp.setCurrentItem(i3 - this.eRv);
        } else if (i == this.eQm && i2 + 1 == this.eRu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eRw > 31) {
                    this.eRw = 31;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eRw));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eRw > 30) {
                    this.eRw = 30;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eRw));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eRw > 29) {
                    this.eRw = 29;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eRw));
            } else {
                if (this.eRw > 28) {
                    this.eRw = 28;
                }
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eRw));
            }
            this.eRp.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.eRp.setCurrentItem(i3 - 1);
        }
        this.eRp.setGravity(this.gravity);
        this.eRq = (WheelView) this.view.findViewById(R.id.hour);
        this.eRq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eRq.setCurrentItem(i4);
        this.eRq.setGravity(this.gravity);
        this.eRr = (WheelView) this.view.findViewById(R.id.min);
        this.eRr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eRr.setCurrentItem(i5);
        this.eRr.setGravity(this.gravity);
        this.eRs = (WheelView) this.view.findViewById(R.id.second);
        this.eRs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eRs.setCurrentItem(i6);
        this.eRs.setGravity(this.gravity);
        this.eRn.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.eQl;
                c.this.eRx = i8;
                int currentItem = c.this.eRo.getCurrentItem();
                if (c.this.eQl == c.this.eQm) {
                    c.this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eRt, c.this.eRu));
                    if (currentItem > c.this.eRo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eRo.getAdapter().getItemsCount() - 1;
                        c.this.eRo.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.eRt + currentItem;
                    if (c.this.eRt == c.this.eRu) {
                        c.this.a(i8, i9, c.this.eRv, c.this.eRw, asList, asList2);
                    } else if (i9 == c.this.eRt) {
                        c.this.a(i8, i9, c.this.eRv, 31, asList, asList2);
                    } else if (i9 == c.this.eRu) {
                        c.this.a(i8, i9, 1, c.this.eRw, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eQl) {
                    c.this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eRt, 12));
                    if (currentItem > c.this.eRo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eRo.getAdapter().getItemsCount() - 1;
                        c.this.eRo.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.eRt + currentItem;
                    if (i10 == c.this.eRt) {
                        c.this.a(i8, i10, c.this.eRv, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eQm) {
                    c.this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.eRu));
                    if (currentItem > c.this.eRo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eRo.getAdapter().getItemsCount() - 1;
                        c.this.eRo.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.eRu) {
                        c.this.a(i8, i11, 1, c.this.eRw, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.eRo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.eRo.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.eRy != null) {
                    c.this.eRy.blS();
                }
            }
        });
        this.eRo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.eQl == c.this.eQm) {
                    int i9 = (c.this.eRt + i8) - 1;
                    if (c.this.eRt == c.this.eRu) {
                        c.this.a(c.this.eRx, i9, c.this.eRv, c.this.eRw, asList, asList2);
                    } else if (c.this.eRt == i9) {
                        c.this.a(c.this.eRx, i9, c.this.eRv, 31, asList, asList2);
                    } else if (c.this.eRu == i9) {
                        c.this.a(c.this.eRx, i9, 1, c.this.eRw, asList, asList2);
                    } else {
                        c.this.a(c.this.eRx, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.eRx == c.this.eQl) {
                    int i10 = (c.this.eRt + i8) - 1;
                    if (i10 == c.this.eRt) {
                        c.this.a(c.this.eRx, i10, c.this.eRv, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.eRx, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.eRx == c.this.eQm) {
                    if (i8 == c.this.eRu) {
                        c.this.a(c.this.eRx, c.this.eRo.getCurrentItem() + 1, 1, c.this.eRw, asList, asList2);
                    } else {
                        c.this.a(c.this.eRx, c.this.eRo.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.eRx, i8, 1, 31, asList, asList2);
                }
                if (c.this.eRy != null) {
                    c.this.eRy.blS();
                }
            }
        });
        a(this.eRp);
        a(this.eRq);
        a(this.eRr);
        a(this.eRs);
        if (this.eQh.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.eRn.setVisibility(this.eQh[0] ? 0 : 8);
        this.eRo.setVisibility(this.eQh[1] ? 0 : 8);
        this.eRp.setVisibility(this.eQh[2] ? 0 : 8);
        this.eRq.setVisibility(this.eQh[3] ? 0 : 8);
        this.eRr.setVisibility(this.eQh[4] ? 0 : 8);
        this.eRs.setVisibility(this.eQh[5] ? 0 : 8);
        bma();
    }

    private void a(WheelView wheelView) {
        if (this.eRy != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.eRy.blS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.eRp.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.eRp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.eRp.getAdapter().getItemsCount() - 1) {
            this.eRp.setCurrentItem(this.eRp.getAdapter().getItemsCount() - 1);
        }
    }

    private void bma() {
        this.eRp.setTextSize(this.textSize);
        this.eRo.setTextSize(this.textSize);
        this.eRn.setTextSize(this.textSize);
        this.eRq.setTextSize(this.textSize);
        this.eRr.setTextSize(this.textSize);
        this.eRs.setTextSize(this.textSize);
    }

    private void bmb() {
        this.eRp.setTextColorOut(this.textColorOut);
        this.eRo.setTextColorOut(this.textColorOut);
        this.eRn.setTextColorOut(this.textColorOut);
        this.eRq.setTextColorOut(this.textColorOut);
        this.eRr.setTextColorOut(this.textColorOut);
        this.eRs.setTextColorOut(this.textColorOut);
    }

    private void bmc() {
        this.eRp.setTextColorCenter(this.textColorCenter);
        this.eRo.setTextColorCenter(this.textColorCenter);
        this.eRn.setTextColorCenter(this.textColorCenter);
        this.eRq.setTextColorCenter(this.textColorCenter);
        this.eRr.setTextColorCenter(this.textColorCenter);
        this.eRs.setTextColorCenter(this.textColorCenter);
    }

    private void bmd() {
        this.eRp.setDividerColor(this.dividerColor);
        this.eRo.setDividerColor(this.dividerColor);
        this.eRn.setDividerColor(this.dividerColor);
        this.eRq.setDividerColor(this.dividerColor);
        this.eRr.setDividerColor(this.dividerColor);
        this.eRs.setDividerColor(this.dividerColor);
    }

    private void bme() {
        this.eRp.setDividerType(this.eQR);
        this.eRo.setDividerType(this.eQR);
        this.eRn.setDividerType(this.eQR);
        this.eRq.setDividerType(this.eQR);
        this.eRr.setDividerType(this.eQR);
        this.eRs.setDividerType(this.eQR);
    }

    private void bmf() {
        this.eRp.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eRo.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eRn.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eRq.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eRr.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eRs.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.eQo) {
            if (str != null) {
                this.eRn.setLabel(str);
            } else {
                this.eRn.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.eRo.setLabel(str2);
            } else {
                this.eRo.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.eRp.setLabel(str3);
            } else {
                this.eRp.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.eRq.setLabel(str4);
            } else {
                this.eRq.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.eRr.setLabel(str5);
            } else {
                this.eRr.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.eRs.setLabel(str6);
            } else {
                this.eRs.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eRp.setTextXOffset(i);
        this.eRo.setTextXOffset(i2);
        this.eRn.setTextXOffset(i3);
        this.eRq.setTextXOffset(i4);
        this.eRr.setTextXOffset(i5);
        this.eRs.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.eRn.setCyclic(z);
        this.eRo.setCyclic(z);
        this.eRp.setCyclic(z);
        this.eRq.setCyclic(z);
        this.eRr.setCyclic(z);
        this.eRs.setCyclic(z);
    }

    public String getTime() {
        if (this.eQo) {
            return bmg();
        }
        StringBuilder sb = new StringBuilder();
        if (this.eRx == this.eQl) {
            if (this.eRo.getCurrentItem() + this.eRt == this.eRt) {
                sb.append(this.eRn.getCurrentItem() + this.eQl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eRo.getCurrentItem() + this.eRt).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eRp.getCurrentItem() + this.eRv).append(" ").append(this.eRq.getCurrentItem()).append(":").append(this.eRr.getCurrentItem()).append(":").append(this.eRs.getCurrentItem());
            } else {
                sb.append(this.eRn.getCurrentItem() + this.eQl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eRo.getCurrentItem() + this.eRt).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eRp.getCurrentItem() + 1).append(" ").append(this.eRq.getCurrentItem()).append(":").append(this.eRr.getCurrentItem()).append(":").append(this.eRs.getCurrentItem());
            }
        } else {
            sb.append(this.eRn.getCurrentItem() + this.eQl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eRo.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eRp.getCurrentItem() + 1).append(" ").append(this.eRq.getCurrentItem()).append(":").append(this.eRr.getCurrentItem()).append(":").append(this.eRs.getCurrentItem());
        }
        return sb.toString();
    }

    private String bmg() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.eRn.getCurrentItem() + this.eQl;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.pb(currentItem2) == 0) {
            currentItem = this.eRo.getCurrentItem() + 1;
            z = false;
        } else if ((this.eRo.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.pb(currentItem2) <= 0) {
            currentItem = this.eRo.getCurrentItem() + 1;
            z = false;
        } else if ((this.eRo.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.pb(currentItem2) == 1) {
            currentItem = this.eRo.getCurrentItem();
            z = true;
        } else {
            currentItem = this.eRo.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.eRp.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.eRq.getCurrentItem()).append(":").append(this.eRr.getCurrentItem()).append(":").append(this.eRs.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void pg(int i) {
        this.eQl = i;
    }

    public void ph(int i) {
        this.eQm = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.eQl) {
                this.eQm = i;
                this.eRu = i2;
                this.eRw = i3;
            } else if (i == this.eQl) {
                if (i2 > this.eRt) {
                    this.eQm = i;
                    this.eRu = i2;
                    this.eRw = i3;
                } else if (i2 == this.eRt && i3 > this.eRv) {
                    this.eQm = i;
                    this.eRu = i2;
                    this.eRw = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.eQm) {
                this.eRt = i5;
                this.eRv = i6;
                this.eQl = i4;
            } else if (i4 == this.eQm) {
                if (i5 < this.eRu) {
                    this.eRt = i5;
                    this.eRv = i6;
                    this.eQl = i4;
                } else if (i5 == this.eRu && i6 < this.eRw) {
                    this.eRt = i5;
                    this.eRv = i6;
                    this.eQl = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.eQl = calendar.get(1);
            this.eQm = calendar2.get(1);
            this.eRt = calendar.get(2) + 1;
            this.eRu = calendar2.get(2) + 1;
            this.eRv = calendar.get(5);
            this.eRw = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bmf();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bmd();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.eQR = dividerType;
        bme();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bmc();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bmb();
    }

    public void isCenterLabel(boolean z) {
        this.eRp.isCenterLabel(z);
        this.eRo.isCenterLabel(z);
        this.eRn.isCenterLabel(z);
        this.eRq.isCenterLabel(z);
        this.eRr.isCenterLabel(z);
        this.eRs.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.eRy = bVar;
    }
}
