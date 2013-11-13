package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PhotoWallView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f1679a;
    private final int b;
    private final int c;
    private BDImageView2[] d;
    private Context e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private int j;
    private com.baidu.tieba.util.i k;
    private z l;
    private aa m;
    private boolean n;
    private List<PhotoUrlData> o;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1679a = 8;
        this.b = 20;
        this.c = 2;
        this.d = new BDImageView2[8];
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.n = false;
        a(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1679a = 8;
        this.b = 20;
        this.c = 2;
        this.d = new BDImageView2[8];
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.n = false;
        a(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.f1679a = 8;
        this.b = 20;
        this.c = 2;
        this.d = new BDImageView2[8];
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.n = false;
        a(context);
    }

    private void a(Context context) {
        this.e = context;
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.photo_wall_view, (ViewGroup) null));
        this.f = (LinearLayout) findViewById(R.id.first_line);
        this.g = (LinearLayout) findViewById(R.id.second_line);
        this.g.setVisibility(8);
        this.h = (LinearLayout) findViewById(R.id.lay_hint_text);
        this.i = (TextView) findViewById(R.id.hint_text);
        this.j = com.baidu.adp.lib.h.f.a(this.e);
        this.k = new com.baidu.tieba.util.i(this.e);
    }

    public void setData(List<PhotoUrlData> list) {
        BDImageView2 bDImageView2;
        boolean z;
        if (this.o != null && list != null) {
            if (this.o.size() != list.size() || list.size() == 0 || this.o.size() == 0) {
                z = false;
            } else {
                int size = this.o.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.o.get(i) == null || list.get(i) == null || !this.o.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (z) {
                com.baidu.adp.lib.h.d.d("equal");
                return;
            }
            if (this.o == null) {
                this.o = new ArrayList();
            }
            this.o.clear();
            for (PhotoUrlData photoUrlData : list) {
                this.o.add(photoUrlData);
            }
        }
        this.f.removeAllViews();
        this.g.removeAllViews();
        LinearLayout.LayoutParams params = getParams();
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                BDImageView2 bDImageView22 = this.d[i2];
                if (bDImageView22 == null) {
                    BDImageView2 bDImageView23 = new BDImageView2(this.e);
                    this.d[i2] = bDImageView23;
                    bDImageView2 = bDImageView23;
                } else {
                    bDImageView2 = bDImageView22;
                }
                bDImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(bDImageView2, photoUrlData2.getSmallurl());
                    bDImageView2.setOnClickListener(new ab(this, photoUrlData2, i2));
                    if (this.n) {
                        bDImageView2.setOnLongClickListener(new ac(this, photoUrlData2, i2));
                    }
                }
                if (i2 < 4) {
                    this.f.addView(bDImageView2, params);
                } else {
                    this.g.addView(bDImageView2, params);
                }
            }
        }
        int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.n) {
            this.h.setVisibility(0);
            if (size3 == 0) {
                this.i.setText(this.e.getString(R.string.group_info_photo_add));
            } else {
                this.i.setText(this.e.getString(R.string.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.n) {
            BDImageView2 bDImageView24 = this.d[size3];
            if (bDImageView24 == null) {
                bDImageView24 = new BDImageView2(this.e);
                this.d[size3] = bDImageView24;
            }
            bDImageView24.setBackgroundDrawable(null);
            bDImageView24.setImageBitmap(null);
            bDImageView24.setBackgroundResource(R.drawable.group_information_add);
            bDImageView24.setOnClickListener(new ad(this, size3));
            bDImageView24.setOnLongClickListener(null);
            if (size3 < 4) {
                this.f.addView(bDImageView24, params);
            } else {
                this.g.addView(bDImageView24, params);
            }
        }
        if (this.f.getChildCount() + this.g.getChildCount() > 4) {
            this.g.setVisibility(0);
        }
    }

    private void a(BDImageView2 bDImageView2, String str) {
        if (this.k == null) {
            this.k = new com.baidu.tieba.util.i(this.e);
        }
        bDImageView2.setBackgroundDrawable(null);
        bDImageView2.setImageBitmap(null);
        this.k.d(true);
        com.baidu.adp.widget.ImageView.e a2 = this.k.a(str, new ae(this, bDImageView2));
        if (a2 != null) {
            a2.a(bDImageView2);
        }
    }

    private LinearLayout.LayoutParams getParams() {
        int a2 = (this.j - com.baidu.adp.lib.h.f.a(this.e, 20.0f)) / 4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        int a3 = com.baidu.adp.lib.h.f.a(this.e, 2.0f);
        layoutParams.leftMargin = a3;
        layoutParams.rightMargin = a3;
        return layoutParams;
    }

    public void a() {
        for (int i = 0; i < 8; i++) {
            BDImageView2 bDImageView2 = this.d[i];
            if (bDImageView2 != null) {
                bDImageView2.setBackgroundDrawable(null);
                bDImageView2.setImageBitmap(null);
            }
        }
    }

    public void setPhotoClickListener(z zVar) {
        this.l = zVar;
    }

    public void setPhotoLongClickListener(aa aaVar) {
        this.m = aaVar;
    }

    public void setIsManager(boolean z) {
        this.n = z;
    }
}
