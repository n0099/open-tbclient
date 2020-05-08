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
    private WheelView.DividerType erU;
    private boolean[] erj;
    private int esA;
    private com.baidu.tbadk.widget.timepicker.a.d.b esB;
    private WheelView esq;
    private WheelView esr;
    private WheelView ess;
    private WheelView est;
    private WheelView esu;
    private WheelView esv;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int ern = FeatureCodes.SKY_SEG;
    private int ero = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int esw = 1;
    private int esx = 12;
    private int esy = 1;
    private int esz = 31;
    private boolean erq = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.erj = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void ir(boolean z) {
        this.erq = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.erq) {
            int[] D = com.baidu.tbadk.widget.timepicker.a.e.b.D(i, i2 + 1, i3);
            a(D[0], D[1] - 1, D[2], D[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.esq = (WheelView) this.view.findViewById(R.id.year);
        this.esq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bb(this.ern, this.ero)));
        this.esq.setLabel("");
        this.esq.setCurrentItem(i - this.ern);
        this.esq.setGravity(this.gravity);
        this.esr = (WheelView) this.view.findViewById(R.id.month);
        this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nZ(i)));
        this.esr.setLabel("");
        int nW = com.baidu.tbadk.widget.timepicker.a.e.a.nW(i);
        if (nW != 0 && (i2 > nW - 1 || z)) {
            this.esr.setCurrentItem(i2 + 1);
        } else {
            this.esr.setCurrentItem(i2);
        }
        this.esr.setGravity(this.gravity);
        this.ess = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(i) == 0) {
            this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(i, i2))));
        } else {
            this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.nV(i))));
        }
        this.ess.setLabel("");
        this.ess.setCurrentItem(i3 - 1);
        this.ess.setGravity(this.gravity);
        this.est = (WheelView) this.view.findViewById(R.id.hour);
        this.est.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.est.setCurrentItem(i4);
        this.est.setGravity(this.gravity);
        this.esu = (WheelView) this.view.findViewById(R.id.min);
        this.esu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esu.setCurrentItem(i5);
        this.esu.setGravity(this.gravity);
        this.esv = (WheelView) this.view.findViewById(R.id.second);
        this.esv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esv.setCurrentItem(i5);
        this.esv.setGravity(this.gravity);
        this.esq.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int ba;
                int i8 = c.this.ern + i7;
                c.this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nZ(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) == 0 || c.this.esr.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) - 1) {
                    c.this.esr.setCurrentItem(c.this.esr.getCurrentItem());
                } else {
                    c.this.esr.setCurrentItem(c.this.esr.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) == 0 || c.this.esr.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) - 1) {
                    c.this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esr.getCurrentItem() + 1))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esr.getCurrentItem() + 1);
                } else if (c.this.esr.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) + 1) {
                    c.this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.nV(i8))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.nV(i8);
                } else {
                    c.this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esr.getCurrentItem()))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esr.getCurrentItem());
                }
                if (c.this.ess.getCurrentItem() > ba - 1) {
                    c.this.ess.setCurrentItem(ba - 1);
                }
                if (c.this.esB != null) {
                    c.this.esB.bdf();
                }
            }
        });
        this.esr.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int ba;
                int currentItem = c.this.esq.getCurrentItem() + c.this.ern;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem) - 1) {
                    c.this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7 + 1))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7 + 1);
                } else if (c.this.esr.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem) + 1) {
                    c.this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.nV(currentItem))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.nV(currentItem);
                } else {
                    c.this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7);
                }
                if (c.this.ess.getCurrentItem() > ba - 1) {
                    c.this.ess.setCurrentItem(ba - 1);
                }
                if (c.this.esB != null) {
                    c.this.esB.bdf();
                }
            }
        });
        a(this.ess);
        a(this.est);
        a(this.esu);
        a(this.esv);
        if (this.erj.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.esq.setVisibility(this.erj[0] ? 0 : 8);
        this.esr.setVisibility(this.erj[1] ? 0 : 8);
        this.ess.setVisibility(this.erj[2] ? 0 : 8);
        this.est.setVisibility(this.erj[3] ? 0 : 8);
        this.esu.setVisibility(this.erj[4] ? 0 : 8);
        this.esv.setVisibility(this.erj[5] ? 0 : 8);
        bdn();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.esA = i;
        this.esq = (WheelView) this.view.findViewById(R.id.year);
        this.esq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.ern, this.ero));
        this.esq.setCurrentItem(i - this.ern);
        this.esq.setGravity(this.gravity);
        this.esr = (WheelView) this.view.findViewById(R.id.month);
        if (this.ern == this.ero) {
            this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esw, this.esx));
            this.esr.setCurrentItem((i2 + 1) - this.esw);
        } else if (i == this.ern) {
            this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esw, 12));
            this.esr.setCurrentItem((i2 + 1) - this.esw);
        } else if (i == this.ero) {
            this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esx));
            this.esr.setCurrentItem(i2);
        } else {
            this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.esr.setCurrentItem(i2);
        }
        this.esr.setGravity(this.gravity);
        this.ess = (WheelView) this.view.findViewById(R.id.day);
        if (this.ern == this.ero && this.esw == this.esx) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.esz > 31) {
                    this.esz = 31;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, this.esz));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.esz > 30) {
                    this.esz = 30;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, this.esz));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.esz > 29) {
                    this.esz = 29;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, this.esz));
            } else {
                if (this.esz > 28) {
                    this.esz = 28;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, this.esz));
            }
            this.ess.setCurrentItem(i3 - this.esy);
        } else if (i == this.ern && i2 + 1 == this.esw) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, 29));
            } else {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esy, 28));
            }
            this.ess.setCurrentItem(i3 - this.esy);
        } else if (i == this.ero && i2 + 1 == this.esx) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.esz > 31) {
                    this.esz = 31;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esz));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.esz > 30) {
                    this.esz = 30;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esz));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.esz > 29) {
                    this.esz = 29;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esz));
            } else {
                if (this.esz > 28) {
                    this.esz = 28;
                }
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esz));
            }
            this.ess.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.ess.setCurrentItem(i3 - 1);
        }
        this.ess.setGravity(this.gravity);
        this.est = (WheelView) this.view.findViewById(R.id.hour);
        this.est.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.est.setCurrentItem(i4);
        this.est.setGravity(this.gravity);
        this.esu = (WheelView) this.view.findViewById(R.id.min);
        this.esu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esu.setCurrentItem(i5);
        this.esu.setGravity(this.gravity);
        this.esv = (WheelView) this.view.findViewById(R.id.second);
        this.esv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esv.setCurrentItem(i6);
        this.esv.setGravity(this.gravity);
        this.esq.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.ern;
                c.this.esA = i8;
                int currentItem = c.this.esr.getCurrentItem();
                if (c.this.ern == c.this.ero) {
                    c.this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.esw, c.this.esx));
                    if (currentItem > c.this.esr.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.esr.getAdapter().getItemsCount() - 1;
                        c.this.esr.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.esw + currentItem;
                    if (c.this.esw == c.this.esx) {
                        c.this.a(i8, i9, c.this.esy, c.this.esz, asList, asList2);
                    } else if (i9 == c.this.esw) {
                        c.this.a(i8, i9, c.this.esy, 31, asList, asList2);
                    } else if (i9 == c.this.esx) {
                        c.this.a(i8, i9, 1, c.this.esz, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.ern) {
                    c.this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.esw, 12));
                    if (currentItem > c.this.esr.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.esr.getAdapter().getItemsCount() - 1;
                        c.this.esr.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.esw + currentItem;
                    if (i10 == c.this.esw) {
                        c.this.a(i8, i10, c.this.esy, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.ero) {
                    c.this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.esx));
                    if (currentItem > c.this.esr.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.esr.getAdapter().getItemsCount() - 1;
                        c.this.esr.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.esx) {
                        c.this.a(i8, i11, 1, c.this.esz, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.esr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.esr.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.esB != null) {
                    c.this.esB.bdf();
                }
            }
        });
        this.esr.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.ern == c.this.ero) {
                    int i9 = (c.this.esw + i8) - 1;
                    if (c.this.esw == c.this.esx) {
                        c.this.a(c.this.esA, i9, c.this.esy, c.this.esz, asList, asList2);
                    } else if (c.this.esw == i9) {
                        c.this.a(c.this.esA, i9, c.this.esy, 31, asList, asList2);
                    } else if (c.this.esx == i9) {
                        c.this.a(c.this.esA, i9, 1, c.this.esz, asList, asList2);
                    } else {
                        c.this.a(c.this.esA, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.esA == c.this.ern) {
                    int i10 = (c.this.esw + i8) - 1;
                    if (i10 == c.this.esw) {
                        c.this.a(c.this.esA, i10, c.this.esy, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.esA, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.esA == c.this.ero) {
                    if (i8 == c.this.esx) {
                        c.this.a(c.this.esA, c.this.esr.getCurrentItem() + 1, 1, c.this.esz, asList, asList2);
                    } else {
                        c.this.a(c.this.esA, c.this.esr.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.esA, i8, 1, 31, asList, asList2);
                }
                if (c.this.esB != null) {
                    c.this.esB.bdf();
                }
            }
        });
        a(this.ess);
        a(this.est);
        a(this.esu);
        a(this.esv);
        if (this.erj.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.esq.setVisibility(this.erj[0] ? 0 : 8);
        this.esr.setVisibility(this.erj[1] ? 0 : 8);
        this.ess.setVisibility(this.erj[2] ? 0 : 8);
        this.est.setVisibility(this.erj[3] ? 0 : 8);
        this.esu.setVisibility(this.erj[4] ? 0 : 8);
        this.esv.setVisibility(this.erj[5] ? 0 : 8);
        bdn();
    }

    private void a(WheelView wheelView) {
        if (this.esB != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.esB.bdf();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.ess.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.ess.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.ess.getAdapter().getItemsCount() - 1) {
            this.ess.setCurrentItem(this.ess.getAdapter().getItemsCount() - 1);
        }
    }

    private void bdn() {
        this.ess.setTextSize(this.textSize);
        this.esr.setTextSize(this.textSize);
        this.esq.setTextSize(this.textSize);
        this.est.setTextSize(this.textSize);
        this.esu.setTextSize(this.textSize);
        this.esv.setTextSize(this.textSize);
    }

    private void bdo() {
        this.ess.setTextColorOut(this.textColorOut);
        this.esr.setTextColorOut(this.textColorOut);
        this.esq.setTextColorOut(this.textColorOut);
        this.est.setTextColorOut(this.textColorOut);
        this.esu.setTextColorOut(this.textColorOut);
        this.esv.setTextColorOut(this.textColorOut);
    }

    private void bdp() {
        this.ess.setTextColorCenter(this.textColorCenter);
        this.esr.setTextColorCenter(this.textColorCenter);
        this.esq.setTextColorCenter(this.textColorCenter);
        this.est.setTextColorCenter(this.textColorCenter);
        this.esu.setTextColorCenter(this.textColorCenter);
        this.esv.setTextColorCenter(this.textColorCenter);
    }

    private void bdq() {
        this.ess.setDividerColor(this.dividerColor);
        this.esr.setDividerColor(this.dividerColor);
        this.esq.setDividerColor(this.dividerColor);
        this.est.setDividerColor(this.dividerColor);
        this.esu.setDividerColor(this.dividerColor);
        this.esv.setDividerColor(this.dividerColor);
    }

    private void bdr() {
        this.ess.setDividerType(this.erU);
        this.esr.setDividerType(this.erU);
        this.esq.setDividerType(this.erU);
        this.est.setDividerType(this.erU);
        this.esu.setDividerType(this.erU);
        this.esv.setDividerType(this.erU);
    }

    private void bds() {
        this.ess.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esr.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esq.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.est.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esu.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esv.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.erq) {
            if (str != null) {
                this.esq.setLabel(str);
            } else {
                this.esq.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.esr.setLabel(str2);
            } else {
                this.esr.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.ess.setLabel(str3);
            } else {
                this.ess.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.est.setLabel(str4);
            } else {
                this.est.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.esu.setLabel(str5);
            } else {
                this.esu.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.esv.setLabel(str6);
            } else {
                this.esv.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ess.setTextXOffset(i);
        this.esr.setTextXOffset(i2);
        this.esq.setTextXOffset(i3);
        this.est.setTextXOffset(i4);
        this.esu.setTextXOffset(i5);
        this.esv.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.esq.setCyclic(z);
        this.esr.setCyclic(z);
        this.ess.setCyclic(z);
        this.est.setCyclic(z);
        this.esu.setCyclic(z);
        this.esv.setCyclic(z);
    }

    public String getTime() {
        if (this.erq) {
            return bdt();
        }
        StringBuilder sb = new StringBuilder();
        if (this.esA == this.ern) {
            if (this.esr.getCurrentItem() + this.esw == this.esw) {
                sb.append(this.esq.getCurrentItem() + this.ern).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esr.getCurrentItem() + this.esw).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.ess.getCurrentItem() + this.esy).append(" ").append(this.est.getCurrentItem()).append(":").append(this.esu.getCurrentItem()).append(":").append(this.esv.getCurrentItem());
            } else {
                sb.append(this.esq.getCurrentItem() + this.ern).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esr.getCurrentItem() + this.esw).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.ess.getCurrentItem() + 1).append(" ").append(this.est.getCurrentItem()).append(":").append(this.esu.getCurrentItem()).append(":").append(this.esv.getCurrentItem());
            }
        } else {
            sb.append(this.esq.getCurrentItem() + this.ern).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esr.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.ess.getCurrentItem() + 1).append(" ").append(this.est.getCurrentItem()).append(":").append(this.esu.getCurrentItem()).append(":").append(this.esv.getCurrentItem());
        }
        return sb.toString();
    }

    private String bdt() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.esq.getCurrentItem() + this.ern;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem2) == 0) {
            currentItem = this.esr.getCurrentItem() + 1;
            z = false;
        } else if ((this.esr.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem2) <= 0) {
            currentItem = this.esr.getCurrentItem() + 1;
            z = false;
        } else if ((this.esr.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem2) == 1) {
            currentItem = this.esr.getCurrentItem();
            z = true;
        } else {
            currentItem = this.esr.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.ess.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.est.getCurrentItem()).append(":").append(this.esu.getCurrentItem()).append(":").append(this.esv.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void ob(int i) {
        this.ern = i;
    }

    public void oc(int i) {
        this.ero = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.ern) {
                this.ero = i;
                this.esx = i2;
                this.esz = i3;
            } else if (i == this.ern) {
                if (i2 > this.esw) {
                    this.ero = i;
                    this.esx = i2;
                    this.esz = i3;
                } else if (i2 == this.esw && i3 > this.esy) {
                    this.ero = i;
                    this.esx = i2;
                    this.esz = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.ero) {
                this.esw = i5;
                this.esy = i6;
                this.ern = i4;
            } else if (i4 == this.ero) {
                if (i5 < this.esx) {
                    this.esw = i5;
                    this.esy = i6;
                    this.ern = i4;
                } else if (i5 == this.esx && i6 < this.esz) {
                    this.esw = i5;
                    this.esy = i6;
                    this.ern = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.ern = calendar.get(1);
            this.ero = calendar2.get(1);
            this.esw = calendar.get(2) + 1;
            this.esx = calendar2.get(2) + 1;
            this.esy = calendar.get(5);
            this.esz = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bds();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bdq();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.erU = dividerType;
        bdr();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bdp();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bdo();
    }

    public void isCenterLabel(boolean z) {
        this.ess.isCenterLabel(z);
        this.esr.isCenterLabel(z);
        this.esq.isCenterLabel(z);
        this.est.isCenterLabel(z);
        this.esu.isCenterLabel(z);
        this.esv.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.esB = bVar;
    }
}
