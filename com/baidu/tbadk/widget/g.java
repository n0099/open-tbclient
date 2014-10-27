package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import com.baidu.tbadk.BaseActivity;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes.dex */
public class g {
    protected Bitmap aaE;
    protected Vector<h> aaF;
    private int aaH;
    protected int bgColor;
    protected boolean hY;
    protected int hZ;
    protected int height;
    protected int iI;
    protected short[] iJ;
    protected byte[] iK;
    protected byte[] iL;
    protected byte[] iM;
    protected int iO;
    protected int[] ib;
    protected int[] ic;
    protected int[] ie;
    protected int ig;
    protected int ih;
    protected int ii;
    protected boolean ij;
    protected boolean ik;
    protected int il;
    protected int im;
    protected InputStream in;
    protected int iq;
    protected int ir;
    protected int is;
    protected int iu;
    protected int iw;
    protected int ix;
    protected int iy;
    protected Bitmap iz;
    protected int status;
    protected int width;
    protected int ia = 1;
    protected byte[] iD = new byte[256];
    protected int iE = 0;
    protected int iF = 0;
    protected int iG = 0;
    protected boolean iH = false;
    protected int delay = 0;
    protected int aaG = 0;
    private volatile boolean interrupted = false;

    public g(int i) {
        this.aaH = GravityCompat.RELATIVE_LAYOUT_DIRECTION;
        this.aaH = i;
    }

    public boolean isInterrupted() {
        return this.interrupted;
    }

    public int ds(int i) {
        this.delay = -1;
        if (i >= 0 && i < this.iO && this.aaF != null && i < this.aaF.size()) {
            this.delay = this.aaF.elementAt(i).delay;
        }
        return this.delay;
    }

    public int bj() {
        return this.iO;
    }

    protected void df() {
        int i;
        int[] iArr = new int[this.width * this.height];
        if (this.iG > 0) {
            if (this.iG == 3) {
                int i2 = this.iO - 2;
                if (i2 > 0) {
                    this.aaE = dt(i2 - 1);
                } else {
                    this.aaE = null;
                }
            }
            if (this.aaE != null) {
                this.aaE.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.iG == 2) {
                    int i3 = !this.iH ? this.ih : 0;
                    for (int i4 = 0; i4 < this.iy; i4++) {
                        int i5 = ((this.iw + i4) * this.width) + this.iu;
                        int i6 = this.ix + i5;
                        while (i5 < i6) {
                            iArr[i5] = i3;
                            i5++;
                        }
                    }
                }
            }
        }
        int i7 = 8;
        int i8 = 1;
        int i9 = 0;
        for (int i10 = 0; i10 < this.is; i10++) {
            if (this.ik) {
                if (i9 >= this.is) {
                    i8++;
                    switch (i8) {
                        case 2:
                            i9 = 4;
                            break;
                        case 3:
                            i9 = 2;
                            i7 = 4;
                            break;
                        case 4:
                            i9 = 1;
                            i7 = 2;
                            break;
                    }
                }
                int i11 = i9;
                i9 += i7;
                i = i11;
            } else {
                i = i10;
            }
            int i12 = i + this.iq;
            if (i12 < this.height) {
                int i13 = this.width * i12;
                int i14 = i13 + this.im;
                int i15 = this.ir + i14;
                if (this.width + i13 < i15) {
                    i15 = this.width + i13;
                }
                int i16 = this.ir * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.ie[this.iM[i16] & BaseActivity.KEYBOARD_STATE_INIT];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.iz = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    public Bitmap dt(int i) {
        int i2;
        if (this.iO > 0 && (i2 = i % this.iO) < this.aaF.size()) {
            return this.aaF.elementAt(i2).iz;
        }
        return null;
    }

    public int d(InputStream inputStream) {
        if (this.interrupted) {
            return 4;
        }
        init();
        if (inputStream != null) {
            this.in = inputStream;
            dp();
            if (!dk()) {
                dm();
                if (this.aaG >= this.aaH) {
                    return 3;
                }
                if (this.iO < 0) {
                    this.status = 1;
                }
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        if (this.interrupted) {
            return 4;
        }
        return this.status;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    protected void vt() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        short s;
        int i10 = this.ir * this.is;
        if (this.iM == null || this.iM.length < i10) {
            this.iM = new byte[i10];
        }
        if (this.iJ == null) {
            this.iJ = new short[4096];
        }
        if (this.iK == null) {
            this.iK = new byte[4096];
        }
        if (this.iL == null) {
            this.iL = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i11 = 1 << read;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = read + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.iJ[i16] = 0;
            this.iK[i16] = (byte) i16;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 0;
        while (i21 < i10) {
            if (i18 != 0) {
                i = i15;
                i2 = i19;
                i3 = i23;
                i4 = i14;
                i5 = i18;
                i6 = i20;
                i7 = i24;
                i8 = i13;
            } else if (i23 < i14) {
                if (i22 == 0) {
                    i22 = dl();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.iD[i25] & BaseActivity.KEYBOARD_STATE_INIT) << i23;
                i23 += 8;
                i25++;
                i22--;
            } else {
                int i26 = i20 & i15;
                i20 >>= i14;
                i23 -= i14;
                if (i26 > i13 || i26 == i12) {
                    break;
                } else if (i26 == i11) {
                    i14 = read + 1;
                    i15 = (1 << i14) - 1;
                    i13 = i11 + 2;
                    i24 = -1;
                } else if (i24 == -1) {
                    this.iL[i18] = this.iK[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.iL[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.iL[i9] = this.iK[s];
                        s = this.iJ[s];
                        i9++;
                    }
                    int i27 = this.iK[s] & BaseActivity.KEYBOARD_STATE_INIT;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.iL[i9] = (byte) i27;
                    this.iJ[i13] = (short) i24;
                    this.iK[i13] = (byte) i27;
                    i8 = i13 + 1;
                    if ((i8 & i15) == 0 && i8 < 4096) {
                        i14++;
                        i15 += i8;
                    }
                    i6 = i20;
                    i7 = i26;
                    i = i15;
                    i2 = i27;
                    i3 = i23;
                    i4 = i14;
                    i5 = i28;
                }
            }
            int i29 = i5 - 1;
            this.iM[i17] = this.iL[i29];
            i21++;
            i17++;
            i14 = i4;
            i23 = i3;
            i19 = i2;
            i15 = i;
            int i30 = i7;
            i20 = i6;
            i18 = i29;
            i13 = i8;
            i24 = i30;
        }
        for (int i31 = i17; i31 < i10; i31++) {
            this.iM[i31] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dk() {
        return this.status != 0;
    }

    protected void init() {
        this.status = 0;
        this.iO = 0;
        this.aaF = new Vector<>();
        this.ib = null;
        this.ic = null;
    }

    protected int read() {
        try {
            return this.in.read();
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    protected int dl() {
        this.iE = read();
        int i = 0;
        if (this.iE > 0) {
            while (i < this.iE) {
                try {
                    int read = this.in.read(this.iD, i, this.iE - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.iE) {
                this.status = 1;
            }
        }
        return i;
    }

    protected int[] y(int i) {
        int i2;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.in.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.status = 1;
        } else {
            iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                i4 = i7 + 1;
                iArr[i5] = ((bArr[i4] & BaseActivity.KEYBOARD_STATE_INIT) << 16) | (-16777216) | ((bArr[i6] & BaseActivity.KEYBOARD_STATE_INIT) << 8) | (bArr[i7] & BaseActivity.KEYBOARD_STATE_INIT);
            }
        }
        return iArr;
    }

    protected void dm() {
        boolean z = false;
        while (!z && !dk() && !this.interrupted) {
            int read = read();
            if (this.aaG < this.aaH) {
                switch (read) {
                    case 33:
                        switch (read()) {
                            case 1:
                                dv();
                                continue;
                            case 249:
                                dn();
                                continue;
                            case 254:
                                dv();
                                continue;
                            case MotionEventCompat.ACTION_MASK /* 255 */:
                                dl();
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i = 0; i < 11; i++) {
                                    stringBuffer.append((char) this.iD[i]);
                                }
                                if (stringBuffer.toString().equals("NETSCAPE2.0")) {
                                    ds();
                                    break;
                                } else {
                                    dv();
                                    continue;
                                }
                            default:
                                dv();
                                continue;
                        }
                    case 44:
                        vu();
                        break;
                    case 59:
                        z = true;
                        break;
                    default:
                        this.status = 1;
                        break;
                }
            } else {
                return;
            }
        }
    }

    protected void dn() {
        read();
        int read = read();
        this.iF = (read & 28) >> 2;
        if (this.iF == 0) {
            this.iF = 1;
        }
        this.iH = (read & 1) != 0;
        this.delay = dt() * 10;
        this.delay = this.delay < 15 ? 100 : this.delay;
        this.iI = read();
        read();
    }

    protected void dp() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) read());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.status = 1;
            return;
        }
        dr();
        if (this.hY && !dk()) {
            this.ib = y(this.hZ);
            this.bgColor = this.ib[this.ig];
        }
    }

    protected void vu() {
        int i = 0;
        this.im = dt();
        this.iq = dt();
        this.ir = dt();
        this.is = dt();
        int read = read();
        this.ij = (read & 128) != 0;
        this.il = (int) Math.pow(2.0d, (read & 7) + 1);
        this.ik = (read & 64) != 0;
        if (this.ij) {
            this.ic = y(this.il);
            this.ie = this.ic;
        } else {
            this.ie = this.ib;
            if (this.ig == this.iI) {
                this.bgColor = 0;
            }
        }
        if (this.iH) {
            int i2 = this.ie[this.iI];
            this.ie[this.iI] = 0;
            i = i2;
        }
        if (this.ie == null) {
            this.status = 1;
        }
        if (!dk()) {
            vt();
            dv();
            if (!dk()) {
                this.iO++;
                this.iz = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                df();
                this.aaF.addElement(new h(this.iz, this.delay));
                this.aaG += this.width * this.height * 2;
                if (this.iH) {
                    this.ie[this.iI] = i;
                }
                du();
            }
        }
    }

    protected void dr() {
        this.width = dt();
        this.height = dt();
        int read = read();
        this.hY = (read & 128) != 0;
        this.hZ = 2 << (read & 7);
        this.ig = read();
        this.ii = read();
    }

    protected void ds() {
        do {
            dl();
            if (this.iD[0] == 1) {
                this.ia = (this.iD[1] & BaseActivity.KEYBOARD_STATE_INIT) | ((this.iD[2] & BaseActivity.KEYBOARD_STATE_INIT) << 8);
            }
            if (this.iE <= 0) {
                return;
            }
        } while (!dk());
    }

    protected int dt() {
        return read() | (read() << 8);
    }

    protected void du() {
        this.iG = this.iF;
        this.iu = this.im;
        this.iw = this.iq;
        this.ix = this.ir;
        this.iy = this.is;
        this.aaE = this.iz;
        this.ih = this.bgColor;
        this.iF = 0;
        this.iH = false;
        this.delay = 0;
        this.ic = null;
    }

    protected void dv() {
        do {
            dl();
            if (this.iE <= 0) {
                return;
            }
        } while (!dk());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vf() {
        this.interrupted = true;
        if (this.aaF != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aaF.size()) {
                    this.aaF.get(i2).iz = null;
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
