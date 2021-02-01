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
    private int dAm;
    private int dAn;
    private int dAo;
    private float dAp;
    private WheelView.DividerType fZP;
    private boolean[] fZh;
    private WheelView gal;
    private WheelView gam;
    private WheelView gan;
    private WheelView gao;
    private WheelView gaq;
    private WheelView gar;
    private int gaw;
    private com.baidu.tbadk.widget.timepicker.a.d.b gax;
    private int gravity;
    private int textSize;
    private View view;
    private int fZl = FeatureCodes.SKY_SEG;
    private int fZm = 2100;
    private int gas = 1;
    private int gat = 12;
    private int gau = 1;
    private int gav = 31;
    private boolean fZo = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fZh = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void lR(boolean z) {
        this.fZo = z;
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fZo) {
            int[] I = com.baidu.tbadk.widget.timepicker.a.e.b.I(i, i2 + 1, i3);
            a(I[0], I[1] - 1, I[2], I[3] == 1, i4, i5, i6);
            return;
        }
        j(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.gal = (WheelView) this.view.findViewById(R.id.year);
        this.gal.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bs(this.fZl, this.fZm)));
        this.gal.setLabel("");
        this.gal.setCurrentItem(i - this.fZl);
        this.gal.setGravity(this.gravity);
        this.gam = (WheelView) this.view.findViewById(R.id.month);
        this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sC(i)));
        this.gam.setLabel("");
        int sz = com.baidu.tbadk.widget.timepicker.a.e.a.sz(i);
        if (sz != 0 && (i2 > sz - 1 || z)) {
            this.gam.setCurrentItem(i2 + 1);
        } else {
            this.gam.setCurrentItem(i2);
        }
        this.gam.setGravity(this.gravity);
        this.gan = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sz(i) == 0) {
            this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.br(i, i2))));
        } else {
            this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.sy(i))));
        }
        this.gan.setLabel("");
        this.gan.setCurrentItem(i3 - 1);
        this.gan.setGravity(this.gravity);
        this.gao = (WheelView) this.view.findViewById(R.id.hour);
        this.gao.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.gao.setCurrentItem(i4);
        this.gao.setGravity(this.gravity);
        this.gaq = (WheelView) this.view.findViewById(R.id.min);
        this.gaq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gaq.setCurrentItem(i5);
        this.gaq.setGravity(this.gravity);
        this.gar = (WheelView) this.view.findViewById(R.id.second);
        this.gar.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gar.setCurrentItem(i5);
        this.gar.setGravity(this.gravity);
        this.gal.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sG(int i7) {
                int br;
                int i8 = c.this.fZl + i7;
                c.this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sC(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sz(i8) == 0 || c.this.gam.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sz(i8) - 1) {
                    c.this.gam.setCurrentItem(c.this.gam.getCurrentItem());
                } else {
                    c.this.gam.setCurrentItem(c.this.gam.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sz(i8) == 0 || c.this.gam.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sz(i8) - 1) {
                    c.this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gam.getCurrentItem() + 1))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gam.getCurrentItem() + 1);
                } else if (c.this.gam.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sz(i8) + 1) {
                    c.this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.sy(i8))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.sy(i8);
                } else {
                    c.this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gam.getCurrentItem()))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gam.getCurrentItem());
                }
                if (c.this.gan.getCurrentItem() > br - 1) {
                    c.this.gan.setCurrentItem(br - 1);
                }
                if (c.this.gax != null) {
                    c.this.gax.bIz();
                }
            }
        });
        this.gam.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sG(int i7) {
                int br;
                int currentItem = c.this.gal.getCurrentItem() + c.this.fZl;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sz(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.sz(currentItem) - 1) {
                    c.this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7 + 1))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7 + 1);
                } else if (c.this.gam.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sz(currentItem) + 1) {
                    c.this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.sy(currentItem))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.sy(currentItem);
                } else {
                    c.this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sD(com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7);
                }
                if (c.this.gan.getCurrentItem() > br - 1) {
                    c.this.gan.setCurrentItem(br - 1);
                }
                if (c.this.gax != null) {
                    c.this.gax.bIz();
                }
            }
        });
        a(this.gan);
        a(this.gao);
        a(this.gaq);
        a(this.gar);
        if (this.fZh.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.gal.setVisibility(this.fZh[0] ? 0 : 8);
        this.gam.setVisibility(this.fZh[1] ? 0 : 8);
        this.gan.setVisibility(this.fZh[2] ? 0 : 8);
        this.gao.setVisibility(this.fZh[3] ? 0 : 8);
        this.gaq.setVisibility(this.fZh[4] ? 0 : 8);
        this.gar.setVisibility(this.fZh[5] ? 0 : 8);
        bIH();
    }

    private void j(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.gaw = i;
        this.gal = (WheelView) this.view.findViewById(R.id.year);
        this.gal.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fZl, this.fZm));
        this.gal.setCurrentItem(i - this.fZl);
        this.gal.setGravity(this.gravity);
        this.gam = (WheelView) this.view.findViewById(R.id.month);
        if (this.fZl == this.fZm) {
            this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gas, this.gat));
            this.gam.setCurrentItem((i2 + 1) - this.gas);
        } else if (i == this.fZl) {
            this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gas, 12));
            this.gam.setCurrentItem((i2 + 1) - this.gas);
        } else if (i == this.fZm) {
            this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gat));
            this.gam.setCurrentItem(i2);
        } else {
            this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.gam.setCurrentItem(i2);
        }
        this.gam.setGravity(this.gravity);
        this.gan = (WheelView) this.view.findViewById(R.id.day);
        if (this.fZl == this.fZm && this.gas == this.gat) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.gav > 31) {
                    this.gav = 31;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, this.gav));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.gav > 30) {
                    this.gav = 30;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, this.gav));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.gav > 29) {
                    this.gav = 29;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, this.gav));
            } else {
                if (this.gav > 28) {
                    this.gav = 28;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, this.gav));
            }
            this.gan.setCurrentItem(i3 - this.gau);
        } else if (i == this.fZl && i2 + 1 == this.gas) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, 29));
            } else {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gau, 28));
            }
            this.gan.setCurrentItem(i3 - this.gau);
        } else if (i == this.fZm && i2 + 1 == this.gat) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.gav > 31) {
                    this.gav = 31;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gav));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.gav > 30) {
                    this.gav = 30;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gav));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.gav > 29) {
                    this.gav = 29;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gav));
            } else {
                if (this.gav > 28) {
                    this.gav = 28;
                }
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gav));
            }
            this.gan.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.gan.setCurrentItem(i3 - 1);
        }
        this.gan.setGravity(this.gravity);
        this.gao = (WheelView) this.view.findViewById(R.id.hour);
        this.gao.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.gao.setCurrentItem(i4);
        this.gao.setGravity(this.gravity);
        this.gaq = (WheelView) this.view.findViewById(R.id.min);
        this.gaq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gaq.setCurrentItem(i5);
        this.gaq.setGravity(this.gravity);
        this.gar = (WheelView) this.view.findViewById(R.id.second);
        this.gar.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gar.setCurrentItem(i6);
        this.gar.setGravity(this.gravity);
        this.gal.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sG(int i7) {
                int i8 = i7 + c.this.fZl;
                c.this.gaw = i8;
                int currentItem = c.this.gam.getCurrentItem();
                if (c.this.fZl == c.this.fZm) {
                    c.this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.gas, c.this.gat));
                    if (currentItem > c.this.gam.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gam.getAdapter().getItemsCount() - 1;
                        c.this.gam.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.gas + currentItem;
                    if (c.this.gas == c.this.gat) {
                        c.this.a(i8, i9, c.this.gau, c.this.gav, asList, asList2);
                    } else if (i9 == c.this.gas) {
                        c.this.a(i8, i9, c.this.gau, 31, asList, asList2);
                    } else if (i9 == c.this.gat) {
                        c.this.a(i8, i9, 1, c.this.gav, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fZl) {
                    c.this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.gas, 12));
                    if (currentItem > c.this.gam.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gam.getAdapter().getItemsCount() - 1;
                        c.this.gam.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.gas + currentItem;
                    if (i10 == c.this.gas) {
                        c.this.a(i8, i10, c.this.gau, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fZm) {
                    c.this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.gat));
                    if (currentItem > c.this.gam.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gam.getAdapter().getItemsCount() - 1;
                        c.this.gam.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.gat) {
                        c.this.a(i8, i11, 1, c.this.gav, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.gam.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.gam.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.gax != null) {
                    c.this.gax.bIz();
                }
            }
        });
        this.gam.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sG(int i7) {
                int i8 = i7 + 1;
                if (c.this.fZl == c.this.fZm) {
                    int i9 = (c.this.gas + i8) - 1;
                    if (c.this.gas == c.this.gat) {
                        c.this.a(c.this.gaw, i9, c.this.gau, c.this.gav, asList, asList2);
                    } else if (c.this.gas == i9) {
                        c.this.a(c.this.gaw, i9, c.this.gau, 31, asList, asList2);
                    } else if (c.this.gat == i9) {
                        c.this.a(c.this.gaw, i9, 1, c.this.gav, asList, asList2);
                    } else {
                        c.this.a(c.this.gaw, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.gaw == c.this.fZl) {
                    int i10 = (c.this.gas + i8) - 1;
                    if (i10 == c.this.gas) {
                        c.this.a(c.this.gaw, i10, c.this.gau, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.gaw, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.gaw == c.this.fZm) {
                    if (i8 == c.this.gat) {
                        c.this.a(c.this.gaw, c.this.gam.getCurrentItem() + 1, 1, c.this.gav, asList, asList2);
                    } else {
                        c.this.a(c.this.gaw, c.this.gam.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.gaw, i8, 1, 31, asList, asList2);
                }
                if (c.this.gax != null) {
                    c.this.gax.bIz();
                }
            }
        });
        a(this.gan);
        a(this.gao);
        a(this.gaq);
        a(this.gar);
        if (this.fZh.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.gal.setVisibility(this.fZh[0] ? 0 : 8);
        this.gam.setVisibility(this.fZh[1] ? 0 : 8);
        this.gan.setVisibility(this.fZh[2] ? 0 : 8);
        this.gao.setVisibility(this.fZh[3] ? 0 : 8);
        this.gaq.setVisibility(this.fZh[4] ? 0 : 8);
        this.gar.setVisibility(this.fZh[5] ? 0 : 8);
        bIH();
    }

    private void a(WheelView wheelView) {
        if (this.gax != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void sG(int i) {
                    c.this.gax.bIz();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.gan.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.gan.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.gan.getAdapter().getItemsCount() - 1) {
            this.gan.setCurrentItem(this.gan.getAdapter().getItemsCount() - 1);
        }
    }

    private void bIH() {
        this.gan.setTextSize(this.textSize);
        this.gam.setTextSize(this.textSize);
        this.gal.setTextSize(this.textSize);
        this.gao.setTextSize(this.textSize);
        this.gaq.setTextSize(this.textSize);
        this.gar.setTextSize(this.textSize);
    }

    private void bII() {
        this.gan.setTextColorOut(this.dAm);
        this.gam.setTextColorOut(this.dAm);
        this.gal.setTextColorOut(this.dAm);
        this.gao.setTextColorOut(this.dAm);
        this.gaq.setTextColorOut(this.dAm);
        this.gar.setTextColorOut(this.dAm);
    }

    private void bIJ() {
        this.gan.setTextColorCenter(this.dAn);
        this.gam.setTextColorCenter(this.dAn);
        this.gal.setTextColorCenter(this.dAn);
        this.gao.setTextColorCenter(this.dAn);
        this.gaq.setTextColorCenter(this.dAn);
        this.gar.setTextColorCenter(this.dAn);
    }

    private void bIK() {
        this.gan.setDividerColor(this.dAo);
        this.gam.setDividerColor(this.dAo);
        this.gal.setDividerColor(this.dAo);
        this.gao.setDividerColor(this.dAo);
        this.gaq.setDividerColor(this.dAo);
        this.gar.setDividerColor(this.dAo);
    }

    private void bIL() {
        this.gan.setDividerType(this.fZP);
        this.gam.setDividerType(this.fZP);
        this.gal.setDividerType(this.fZP);
        this.gao.setDividerType(this.fZP);
        this.gaq.setDividerType(this.fZP);
        this.gar.setDividerType(this.fZP);
    }

    private void bIM() {
        this.gan.setLineSpacingMultiplier(this.dAp);
        this.gam.setLineSpacingMultiplier(this.dAp);
        this.gal.setLineSpacingMultiplier(this.dAp);
        this.gao.setLineSpacingMultiplier(this.dAp);
        this.gaq.setLineSpacingMultiplier(this.dAp);
        this.gar.setLineSpacingMultiplier(this.dAp);
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fZo) {
            if (str != null) {
                this.gal.setLabel(str);
            } else {
                this.gal.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.gam.setLabel(str2);
            } else {
                this.gam.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.gan.setLabel(str3);
            } else {
                this.gan.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.gao.setLabel(str4);
            } else {
                this.gao.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.gaq.setLabel(str5);
            } else {
                this.gaq.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.gar.setLabel(str6);
            } else {
                this.gar.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gan.setTextXOffset(i);
        this.gam.setTextXOffset(i2);
        this.gal.setTextXOffset(i3);
        this.gao.setTextXOffset(i4);
        this.gaq.setTextXOffset(i5);
        this.gar.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.gal.setCyclic(z);
        this.gam.setCyclic(z);
        this.gan.setCyclic(z);
        this.gao.setCyclic(z);
        this.gaq.setCyclic(z);
        this.gar.setCyclic(z);
    }

    public String getTime() {
        if (this.fZo) {
            return bIN();
        }
        StringBuilder sb = new StringBuilder();
        if (this.gaw == this.fZl) {
            if (this.gam.getCurrentItem() + this.gas == this.gas) {
                sb.append(this.gal.getCurrentItem() + this.fZl).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gam.getCurrentItem() + this.gas).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gan.getCurrentItem() + this.gau).append(" ").append(this.gao.getCurrentItem()).append(":").append(this.gaq.getCurrentItem()).append(":").append(this.gar.getCurrentItem());
            } else {
                sb.append(this.gal.getCurrentItem() + this.fZl).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gam.getCurrentItem() + this.gas).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gan.getCurrentItem() + 1).append(" ").append(this.gao.getCurrentItem()).append(":").append(this.gaq.getCurrentItem()).append(":").append(this.gar.getCurrentItem());
            }
        } else {
            sb.append(this.gal.getCurrentItem() + this.fZl).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gam.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gan.getCurrentItem() + 1).append(" ").append(this.gao.getCurrentItem()).append(":").append(this.gaq.getCurrentItem()).append(":").append(this.gar.getCurrentItem());
        }
        return sb.toString();
    }

    private String bIN() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.gal.getCurrentItem() + this.fZl;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sz(currentItem2) == 0) {
            currentItem = this.gam.getCurrentItem() + 1;
            z = false;
        } else if ((this.gam.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sz(currentItem2) <= 0) {
            currentItem = this.gam.getCurrentItem() + 1;
            z = false;
        } else if ((this.gam.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sz(currentItem2) == 1) {
            currentItem = this.gam.getCurrentItem();
            z = true;
        } else {
            currentItem = this.gam.getCurrentItem();
            z = false;
        }
        int[] d = com.baidu.tbadk.widget.timepicker.a.e.b.d(currentItem2, currentItem, this.gan.getCurrentItem() + 1, z);
        sb.append(d[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[2]).append(" ").append(this.gao.getCurrentItem()).append(":").append(this.gaq.getCurrentItem()).append(":").append(this.gar.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sE(int i) {
        this.fZl = i;
    }

    public void sF(int i) {
        this.fZm = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fZl) {
                this.fZm = i;
                this.gat = i2;
                this.gav = i3;
            } else if (i == this.fZl) {
                if (i2 > this.gas) {
                    this.fZm = i;
                    this.gat = i2;
                    this.gav = i3;
                } else if (i2 == this.gas && i3 > this.gau) {
                    this.fZm = i;
                    this.gat = i2;
                    this.gav = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fZm) {
                this.gas = i5;
                this.gau = i6;
                this.fZl = i4;
            } else if (i4 == this.fZm) {
                if (i5 < this.gat) {
                    this.gas = i5;
                    this.gau = i6;
                    this.fZl = i4;
                } else if (i5 == this.gat && i6 < this.gav) {
                    this.gas = i5;
                    this.gau = i6;
                    this.fZl = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fZl = calendar.get(1);
            this.fZm = calendar2.get(1);
            this.gas = calendar.get(2) + 1;
            this.gat = calendar2.get(2) + 1;
            this.gau = calendar.get(5);
            this.gav = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.dAp = f;
        bIM();
    }

    public void setDividerColor(int i) {
        this.dAo = i;
        bIK();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fZP = dividerType;
        bIL();
    }

    public void setTextColorCenter(int i) {
        this.dAn = i;
        bIJ();
    }

    public void setTextColorOut(int i) {
        this.dAm = i;
        bII();
    }

    public void lS(boolean z) {
        this.gan.lS(z);
        this.gam.lS(z);
        this.gal.lS(z);
        this.gao.lS(z);
        this.gaq.lS(z);
        this.gar.lS(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.gax = bVar;
    }
}
